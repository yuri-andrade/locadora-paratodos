package com.desafio.locadora.utils;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessagesUtils {
    private final MessageSource messageSource;

    public MessagesUtils(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String key, Object... parameters) {
        return messageSource.getMessage(key, parameters, Locale.getDefault());
    }

}
