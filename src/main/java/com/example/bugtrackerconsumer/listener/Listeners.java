package com.example.bugtrackerconsumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class Listeners {

    public final static String FANOUT_QUEUE_1_NAME = "spring-amqp-simple.fanout.queue1";
    public final static String FANOUT_QUEUE_2_NAME = "spring-amqp-simple.fanout.queue2";
    public final static String FANOUT_EXCHANGE_NAME = "spring-amqp-simple.fanout.exchange";

    public final static String TOPIC_QUEUE_1_NAME = "spring-amqp-simple.topic.queue1";
    public final static String TOPIC_QUEUE_2_NAME = "spring-amqp-simple.topic.queue2";
    public final static String TOPIC_EXCHANGE_NAME = "spring-amqp-simple.topic.exchange";
    public static final String BINDING_PATTERN_IMPORTANT = "*.important.*";
    public static final String BINDING_PATTERN_ERROR = "#.error";

    @RabbitListener(queues = {FANOUT_QUEUE_1_NAME}, autoStartup = "true")
    public void receiveMessageFromFanout1(String message) {
        System.out.println("Received fanout 1 message: " + message);
    }

    @RabbitListener(queues = {FANOUT_QUEUE_2_NAME}, autoStartup = "true")
    public void receiveMessageFromFanout2(String message) {
        System.out.println("Received fanout 2 message: " + message);
    }

    @RabbitListener(queues = {TOPIC_QUEUE_1_NAME}, autoStartup = "true")
    public void receiveMessageFromTopic1(String message) {
        System.out.println("Received topic 1 (" + BINDING_PATTERN_IMPORTANT + ") message: " + message);
    }

    @RabbitListener(queues = {TOPIC_QUEUE_2_NAME}, autoStartup = "true")
    public void receiveMessageFromTopic2(String message) {
        System.out.println("Received topic 2 (" + BINDING_PATTERN_ERROR + ") message: " + message);
    }
}
