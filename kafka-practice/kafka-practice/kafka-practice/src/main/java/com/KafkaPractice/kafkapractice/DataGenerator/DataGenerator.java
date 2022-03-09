package com.KafkaPractice.kafkapractice.DataGenerator;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.*;

@Configuration
public class DataGenerator {

    //class capable of generating fake data
    private Faker faker = new Faker();

    /*
    Generates a fake quote
     */
    public Map<String,Object> quoteFaker(){

        Map<String,Object> quoteData = new HashMap<>();

        quoteData.put("time",new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime()));
        quoteData.put("sym",faker.stock().nyseSymbol().trim());
        quoteData.put("bid",faker.number().randomDouble(2,0,100));
        quoteData.put("ask",faker.number().randomDouble(2, (int) ((double) quoteData.get("bid")),100));
        quoteData.put("bsize", faker.number().numberBetween(0,200));
        quoteData.put("asize", faker.number().numberBetween(0,200));
        quoteData.put("mode",randomValue());
        quoteData.put("ex", randomValue(new String [] {"N","O"}));
        quoteData.put("src",faker.company().name().toUpperCase().trim());

       return quoteData;
    }

    /*
    Generates a fake trade
     */
    public Map<String,Object> tradeFaker(){

        Map<String,Object> tradeData = new HashMap<>();

        tradeData.put("time",new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime()));
        tradeData.put("sym",faker.stock().nyseSymbol().trim());
        tradeData.put("price",faker.number().randomDouble(2,0,100));
        tradeData.put("size", faker.number().numberBetween(0,200));
        tradeData.put("stop", faker.number().numberBetween(0,1));
        tradeData.put("cond",randomValue());
        tradeData.put("ex", randomValue(new String [] {"N","O"}));
        tradeData.put("side", randomValue(new String [] {"sell","buy"}));

        return tradeData;
    }

    /*
    Generates random number
     */

    public String randomValue(Object[] arr){
        Random random = new Random();
        return arr[random.nextInt(arr.length)].toString();
    }

    /*
    Generates random character
     */

    public char randomValue(){
        Random random = new Random();
        return Character.toUpperCase((char) (random.nextInt(26) + 'a')) ;
    }



}
