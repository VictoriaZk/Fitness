package com.epam.fitness.command.exercise;

import com.epam.fitness.command.Command;
import com.epam.fitness.command.CommandResult;
import com.epam.fitness.command.session.SessionAttributes;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Client;
import com.epam.fitness.model.Program;
import com.epam.fitness.model.UserRole;
import com.epam.fitness.model.dto.ExerciseDto;
import com.epam.fitness.service.ClientService;
import com.epam.fitness.service.ExerciseDtoService;
import com.epam.fitness.service.ProgramService;
import com.epam.fitness.utils.CurrentMembershipValidChecker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import static com.epam.fitness.command.exercise.constant.TextConstants.*;
import static com.epam.fitness.command.nutrition.constant.TextConstans.COACH_CLIENT_ID;

/**
 * Designed to represent client's exercises
 */
public class ShowClientExercisesCommand implements Command {

    private CurrentMembershipValidChecker membershipValidChecker = new CurrentMembershipValidChecker();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        String role = String.valueOf(session.getAttribute(SessionAttributes.ROLE));
        Long clientId;
        if(role.equals(UserRole.COACH)){
            clientId = getClientIdForAppropriateCoach(session,request);
        }
        else{
            clientId = (Long) session.getAttribute(SessionAttributes.ID);
            if(!membershipValidChecker.isCurrentMembershipValid(clientId)){
                request.setAttribute(IS_MEMBERSHIP_VALID, false);
                return new CommandResult(EXERCISE_PAGE,false);
            }else {
                request.setAttribute(IS_MEMBERSHIP_VALID, true);
            }
        }

        ClientService clientService = new ClientService();
        Optional<Client> client = clientService.findById(clientId);
        if(client.isPresent()) {
            Long programId = client.get().getProgramId();
            ProgramService programService = new ProgramService();
            Optional<Program> program = programService.findProgramById(programId);
            request.setAttribute(PROGRAM, program.get());
            ExerciseDtoService exerciseDtoService = new ExerciseDtoService();
            List<ExerciseDto> exercises = exerciseDtoService.findExercisesByProgramId(programId);
            request.setAttribute(EXERCISES,exercises);
        }
        return new CommandResult(EXERCISE_PAGE,false);
    }

    private Long getClientIdForAppropriateCoach(HttpSession session,HttpServletRequest request){
        String clientIdString = request.getParameter(COACH_CLIENT_ID);
        Long clientId;
        if(clientIdString==null){
            clientId= (Long) session.getAttribute(COACH_CLIENT_ID);
        }else{
            clientId= Long.valueOf(request.getParameter(COACH_CLIENT_ID));
            session.setAttribute(COACH_CLIENT_ID,clientId);
        }
        return clientId;
    }

}