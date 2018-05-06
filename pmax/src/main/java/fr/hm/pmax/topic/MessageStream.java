package fr.hm.pmax.topic;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageStream {

    String OUTPUT = "zipkin-output";

    @Output(OUTPUT)
    MessageChannel outputMessage();
}
