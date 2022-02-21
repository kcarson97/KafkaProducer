package com.KafkaPractice.kafkapractice.DataGenerator;

public class Message extends DataGenerator {

    /*
    The topic the message should be posted to
     */
    private String topic;

    /*
    The rate at which the data should be published
     */
    private int rate;
    /*
    The duration for which data should be published
     */
    private int duration;

    public Message(String topic, int rate,int time){
        this.topic=topic;
        this.rate=rate;
        this.duration=time;
    }

    public String getTopic() {
        return topic;
    }

    public int getRate() {
        return rate;
    }

    public int getDuration() {
        return duration;
    }

    /*
    Generates a fake quote/trade and returns it in string format
     */
    public String generateData(){

        if(topic.equalsIgnoreCase("quote")){
            return quoteFaker();
        }else{
            return tradeFaker();
        }
    }
}
