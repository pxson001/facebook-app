package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.std.JdkDeserializers.LocaleDeserializer;
import java.io.IOException;
import java.util.Locale;

@JacksonStdImpl
/* compiled from: checkbox_body */
final class StdKeyDeserializer$LocaleKD extends StdKeyDeserializer {
    private static final long serialVersionUID = 1;
    protected LocaleDeserializer _localeDeserializer = new LocaleDeserializer();

    StdKeyDeserializer$LocaleKD() {
        super(Locale.class);
    }

    protected final Object m11299b(String str, DeserializationContext deserializationContext) {
        try {
            return LocaleDeserializer.m11199a(str);
        } catch (IOException e) {
            throw deserializationContext.a(this._keyClass, str, "unable to parse key as locale");
        }
    }
}
