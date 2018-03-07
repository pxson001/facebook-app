package com.fasterxml.jackson.core.json;

import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.io.CharTypes;

/* compiled from: pushed_message */
public final class JsonReadContext extends JsonStreamContext {
    public final JsonReadContext f8629c;
    protected int f8630d;
    protected int f8631e;
    public String f8632f;
    protected JsonReadContext f8633g = null;

    private JsonReadContext(JsonReadContext jsonReadContext, int i, int i2, int i3) {
        this.a = i;
        this.f8629c = jsonReadContext;
        this.f8630d = i2;
        this.f8631e = i3;
        this.b = -1;
    }

    private void m13322a(int i, int i2, int i3) {
        this.a = i;
        this.b = -1;
        this.f8630d = i2;
        this.f8631e = i3;
        this.f8632f = null;
    }

    public static JsonReadContext m13321a(int i, int i2) {
        return new JsonReadContext(null, 0, i, i2);
    }

    public static JsonReadContext m13323i() {
        return new JsonReadContext(null, 0, 1, 0);
    }

    public final JsonReadContext m13327b(int i, int i2) {
        JsonReadContext jsonReadContext = this.f8633g;
        if (jsonReadContext == null) {
            jsonReadContext = new JsonReadContext(this, 1, i, i2);
            this.f8633g = jsonReadContext;
            return jsonReadContext;
        }
        jsonReadContext.m13322a(1, i, i2);
        return jsonReadContext;
    }

    public final JsonReadContext m13328c(int i, int i2) {
        JsonReadContext jsonReadContext = this.f8633g;
        if (jsonReadContext == null) {
            jsonReadContext = new JsonReadContext(this, 2, i, i2);
            this.f8633g = jsonReadContext;
            return jsonReadContext;
        }
        jsonReadContext.m13322a(2, i, i2);
        return jsonReadContext;
    }

    public final String mo1660h() {
        return this.f8632f;
    }

    public final /* synthetic */ JsonStreamContext mo1659a() {
        return this.f8629c;
    }

    public final JsonReadContext m13330j() {
        return this.f8629c;
    }

    public final JsonLocation m13324a(Object obj) {
        return new JsonLocation(obj, -1, this.f8630d, this.f8631e);
    }

    public final boolean m13331k() {
        int i = this.f7355b + 1;
        this.b = i;
        return this.f7354a != 0 && i > 0;
    }

    public final void m13326a(String str) {
        this.f8632f = str;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        switch (this.f7354a) {
            case 0:
                stringBuilder.append("/");
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                stringBuilder.append('[');
                stringBuilder.append(m11963g());
                stringBuilder.append(']');
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                stringBuilder.append('{');
                if (this.f8632f != null) {
                    stringBuilder.append('\"');
                    CharTypes.m11932a(stringBuilder, this.f8632f);
                    stringBuilder.append('\"');
                } else {
                    stringBuilder.append('?');
                }
                stringBuilder.append('}');
                break;
        }
        return stringBuilder.toString();
    }
}
