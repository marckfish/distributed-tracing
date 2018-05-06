package fr.hm.pmax.model.service;

import fr.hm.pmax.model.entity.Pmax;
import fr.hm.pmax.model.repository.PmaxRepository;
import fr.hm.pmax.topic.MessageStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmaxService {

    private final static Logger LOGGER = LoggerFactory.getLogger(PmaxService.class);

    private PmaxRepository pmaxRepository;

    private MessageStream messageStream;

    public PmaxService(PmaxRepository pmaxRepository, MessageStream messageStream){
        this.pmaxRepository = pmaxRepository;
        this.messageStream = messageStream;
    }

    @NewSpan
    public List<Pmax> findAll(@SpanTag("database h2") String param){
        MessageChannel messageChannel = messageStream.outputMessage();
        messageChannel.send(MessageBuilder.withPayload("h2").build());
        LOGGER.info("Réception de la requête");
        return pmaxRepository.findAll();
    }
}
