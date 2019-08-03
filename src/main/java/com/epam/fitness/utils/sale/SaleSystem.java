package com.epam.fitness.utils.sale;

import com.epam.fitness.utils.DataReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Designed to define sale depending on visits
 */
public class SaleSystem {

    private final static Logger LOGGER = LogManager.getLogger(SaleSystem.class);
    private final static String MIN_VISITS = "min visits";
    private final static String MAX_VISITS = "max visits";
    private final static String SALE = "sale";
    private final static String PRICES_FILE_PATH = "sales.json";
    private static Map<List<Integer>,Float> visitSaleMap;

    private static SaleSystem instance;
    private SaleSystem() throws ParseException {
        DataReader dataReader = new DataReader();
        String jsonPrices = dataReader.read(PRICES_FILE_PATH);
        visitSaleMap = getPeriodPriceMap(jsonPrices);
    }
    private static ReentrantLock lock = new ReentrantLock();


    /**
     * Get instance sale system.
     *
     * @return the sale system
     */
    public static SaleSystem getInstance(){

        if(instance == null){
            try {
                lock.lock();
                if(instance == null){
                    instance = new SaleSystem();
                }
            }
            catch (ParseException e) {
                LOGGER.error("Can not get Instance", e);
                throw new RuntimeException("Can not get sales for membership", e);
            } finally {
                lock.unlock();
            }
        }

        return instance;
    }

    private Map<List<Integer>,Float> getPeriodPriceMap(String jsonString) throws ParseException {
        Map<List<Integer>,Float> periodCostMap = new HashMap<>();
        try {
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(jsonString);
            for (Object aJsonArray : jsonArray) {
                JSONObject newJsonObject = (JSONObject) aJsonArray;
                String strToParse = String.valueOf(newJsonObject);
                JSONObject newTariff = (JSONObject) parser.parse(strToParse);
                Integer minVisits = Math.toIntExact((Long) newTariff.get(MIN_VISITS));
                Integer maxVisits = Math.toIntExact((Long) newTariff.get(MAX_VISITS));
                List<Integer> visitsRange = Arrays.asList(minVisits,maxVisits);
                Float sale = Float.valueOf(String.valueOf(newTariff.get(SALE)));
                periodCostMap.put(visitsRange, sale);
            }
        }catch (ParseException exception){
            LOGGER.error("Exception was meet during parsing JSON file with initial data",exception);
            throw exception;
        }
        return periodCostMap;
    }

    /**
     * Get sale by visit number float.
     *
     * @param visitsNumber the visits number
     * @return the float
     */
    public Float getSaleByVisitNumber(Integer visitsNumber){
        for(List<Integer> visitsRange : visitSaleMap.keySet()){
            if(visitsNumber>=visitsRange.get(0) && visitsNumber <= visitsRange.get(1)){
                return visitSaleMap.get(visitsRange);
            }
        }
        return 0f;

    }

}
