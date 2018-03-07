package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/* compiled from: getOtherPss */
public interface ContextualDeserializer {
    JsonDeserializer<?> mo833a(DeserializationContext deserializationContext, BeanProperty beanProperty);
}
