package com.fasterxml.jackson.datatype.guava;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.Module.SetupContext;
import com.fasterxml.jackson.datatype.guava.ser.GuavaBeanSerializerModifier;

/* compiled from: sr_RS */
public class GuavaModule extends Module {
    private final String f4187a = "GuavaModule";

    public final String mo1138a() {
        return "GuavaModule";
    }

    public Version version() {
        return ModuleVersion.a.b;
    }

    public final void mo1139a(SetupContext setupContext) {
        setupContext.mo1140a(new GuavaDeserializers());
        setupContext.mo1142a(new GuavaSerializers());
        setupContext.mo1143a(new MultimapTypeModifier());
        setupContext.mo1141a(new GuavaBeanSerializerModifier());
    }
}
