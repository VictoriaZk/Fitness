package com.epam.fitness.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Designed to provide price for membership
 */
public class MembershipPrices {

    private final static Logger LOGGER = LogManager.getLogger(MembershipPrices.class);
    private final static String DAYS = "days";
    private final static String PRICE = "price";
    private final static String PRICES_FILE_PATH = "prices.json";
    private static Map<Integer,BigDecimal> periodPriceMap;

    private static MembershipPrices instance;
    private MembershipPrices() throws ParseException {
        DataReader dataReader = new DataReader();
        String jsonPrices = dataReader.read(PRICES_FILE_PATH);
        periodPriceMap = getPeriodPriceMap(jsonPrices);
    }
    private static ReentrantLock lock = new ReentrantLock();


    /**
     * Get instance membership prices.
     *
     * @return the membership prices
     */
    public static MembershipPrices getInstance(){

        if(instance == null){
            try {
                lock.lock();
                if(instance == null){
                    instance = new MembershipPrices();
                }
            }
            catch (ParseException e) {
                LOGGER.error("Can not get Instance", e);
                throw new RuntimeException("Can not get price for membership", e);
            } finally {
                lock.unlock();
            }
        }

        return instance;
    }

    private Map<Integer,BigDecimal> getPeriodPriceMap(String jsonString) throws ParseException {
        Map<Integer,BigDecimal> periodCostMap = new HashMap<>();
        try {
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(jsonString);
            for (Object aJsonArray : jsonArray) {
                JSONObject newJsonObject = (JSONObject) aJsonArray;
                String strToParse = String.valueOf(newJsonObject);
                JSONObject newTariff = (JSONObject) parser.parse(strToParse);
                Integer days = Math.toIntExact((Long) newTariff.get(DAYS));
                BigDecimal price = BigDecimal.valueOf((Double)newTariff.get(PRICE));
                periodCostMap.put(days, price);
            }
        }catch (ParseException exception){
            LOGGER.error("Exception was meet during parsing JSON file with initial data",exception);
            throw exception;
        }
        return periodCostMap;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        String jsonPrices = dataReader.read(PRICES_FILE_PATH);
        System.out.println(jsonPrices);
    }

    /**
     * Get all costs map.
     *
     * @return the map
     */
    public Map<Integer,BigDecimal> getAllCosts(){
        return periodPriceMap;
    }

}
