package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.type.TypeModifier;

/* compiled from: zero_invalid_mcc_mnc */
public abstract class Module implements Versioned {

    /* compiled from: zero_invalid_mcc_mnc */
    public interface SetupContext {
        void mo1140a(Deserializers deserializers);

        void mo1141a(BeanSerializerModifier beanSerializerModifier);

        void mo1142a(Serializers serializers);

        void mo1143a(TypeModifier typeModifier);
    }

    public abstract String mo1138a();

    public abstract void mo1139a(SetupContext setupContext);

    public abstract Version version();
}
