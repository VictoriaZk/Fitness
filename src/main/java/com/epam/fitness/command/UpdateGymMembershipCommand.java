package com.epam.fitness.command;

import com.epam.fitness.command.session.SessionAttributes;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Client;
import com.epam.fitness.model.OrderInformation;
import com.epam.fitness.service.ClientService;
import com.epam.fitness.service.OrderInformationService;
import com.epam.fitness.utils.DateProducer;
import com.epam.fitness.utils.MembershipPrices;
import com.epam.fitness.utils.RequestParameterValidator;
import com.epam.fitness.utils.sale.SaleSystem;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

/**
 * Designed to buy or update current gym membership
 */
public class UpdateGymMembershipCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(UpdateGymMembershipCommand.class.getName());
    private static final String PROFILE_PAGE = "/controller?command=profile";
    private static final String COST = "cost";
    private static final String PERIOD = "period";
    private static final String CARD_NUMBER = "cardNumber";
    private static final String PAYMENT_ERROR = "payment_error";
    private static final String PERIOD_NOT_EXIST_ERROR = "period_not_exist_error";
    private static final String INVALID_COST_ERROR = "invalid_cost_error";
    private static final String ORDER_PAGE = "/controller?command=get_order_page";
    private static final String PERIOD_PATTERN="\\D+";
    private final RequestParameterValidator parameterValidator = new RequestParameterValidator();
    private final static SaleSystem SALE_SYSTEM = SaleSystem.getInstance();


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String cardNumber = request.getParameter(CARD_NUMBER);
        if(cardNumber==null || !parameterValidator.isCardNumberValid(cardNumber)){
            LOGGER.info("incorrect card number:" + cardNumber + " was input");
            return forwardToLoginWithError(request,PAYMENT_ERROR);
        }
        String periodExtension = request.getParameter(PERIOD);
        if(periodExtension==null || !isPeriodExist(periodExtension)){
            LOGGER.info("incorrect period:" + periodExtension + " was input");
            return forwardToLoginWithError(request,PERIOD_NOT_EXIST_ERROR);
        }
        String costString = request.getParameter(COST);
        if(costString==null || !parameterValidator.isCostValid(costString)){
            LOGGER.info("incorrect cost:" + costString + " was input");
            return forwardToLoginWithError(request,INVALID_COST_ERROR);
        }
        BigDecimal cost = new BigDecimal(costString);
        HttpSession session = request.getSession();
        Long clientID = (Long) session.getAttribute(SessionAttributes.ID);
        java.sql.Date newEndMembershipDate = defineNewEndMembershipEndDate(request,clientID);
        OrderInformation newOrderInformation = new OrderInformation(null,cost,new Timestamp(new Date().getTime()), newEndMembershipDate, clientID,cardNumber);
        OrderInformationService orderInformationService = new OrderInformationService();
        orderInformationService.save(newOrderInformation);
        increaseClientVisitNumber(clientID);
        LOGGER.info("Gym membership has been updated");
        return new CommandResult(PROFILE_PAGE,true);
    }

    private java.sql.Date defineNewEndMembershipEndDate(HttpServletRequest request, Long clientID) throws ServiceException {
        String periodExtension = request.getParameter(PERIOD);
        periodExtension = periodExtension.replaceAll(PERIOD_PATTERN,"");
        Integer periodExtensionInteger = Integer.valueOf(periodExtension);
        OrderInformationService orderInformationService = new OrderInformationService();
        Optional<OrderInformation> orderInformation = orderInformationService.findByClientId(clientID);
        Date membershipEndDate = new Date();
        if (orderInformation.isPresent()) {
            membershipEndDate = orderInformation.get().getMembershipEndDate();
        }
        Date newMembershipEndDate = DateProducer.getNecessaryDate(membershipEndDate,periodExtensionInteger);
        return new java.sql.Date(newMembershipEndDate.getTime());
    }


    private void increaseClientVisitNumber(long clientId) throws ServiceException {
        ClientService clientService = new ClientService();
        Optional<Client> clientOptional = clientService.findById(clientId);
        if(clientOptional.isPresent()){
            Client client = clientOptional.get();
            int currentVisitNumber = client.getMembershipPurchasedNumber();
            client.setMembershipPurchasedNumber(++currentVisitNumber);
            Float newPersonalDiscount = SALE_SYSTEM.getSaleByVisitNumber(currentVisitNumber);
            client.setPersonalSale(newPersonalDiscount);
            clientService.save(client);
        }

    }

    private CommandResult forwardToLoginWithError(HttpServletRequest request,String error) {
        request.setAttribute(error, true);
        return new CommandResult(ORDER_PAGE,false);
    }

    private boolean isPeriodExist(String  period){
        period = period.replaceAll(PERIOD_PATTERN,"");
        Integer periodInteger = Integer.valueOf(period);
        MembershipPrices membershipPrices = MembershipPrices.getInstance();
        return membershipPrices.getAllCosts().containsKey(periodInteger);
    }

}
