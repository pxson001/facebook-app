package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.VersionUtil;

/* compiled from: request_header */
public abstract class JsonGeneratorImpl extends GeneratorBase {
    protected static final int[] f7329g = CharTypes.f7345f;
    protected final IOContext f7330h;
    protected int[] f7331i = f7329g;
    protected int f7332j;
    protected CharacterEscapes f7333k;
    protected SerializableString f7334l = DefaultPrettyPrinter.f4043a;

    public JsonGeneratorImpl(IOContext iOContext, int i, ObjectCodec objectCodec) {
        super(i, objectCodec);
        this.f7330h = iOContext;
        if (m11923a(Feature.ESCAPE_NON_ASCII)) {
            mo1655a(127);
        }
    }

    public final JsonGenerator mo1655a(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f7332j = i;
        return this;
    }

    public final JsonGenerator mo1657a(CharacterEscapes characterEscapes) {
        this.f7333k = characterEscapes;
        if (characterEscapes == null) {
            this.f7331i = f7329g;
        } else {
            this.f7331i = characterEscapes.a();
        }
        return this;
    }

    public final JsonGenerator mo1656a(SerializableString serializableString) {
        this.f7334l = serializableString;
        return this;
    }

    public Version version() {
        return VersionUtil.a(getClass());
    }

    public final void mo1658a(String str, String str2) {
        mo1115a(str);
        mo1123b(str2);
    }
}
