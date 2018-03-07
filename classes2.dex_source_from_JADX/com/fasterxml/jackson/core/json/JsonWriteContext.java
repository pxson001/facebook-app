package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonStreamContext;

/* compiled from: request_captcha */
public class JsonWriteContext extends JsonStreamContext {
    public final JsonWriteContext f7351c;
    protected String f7352d;
    protected JsonWriteContext f7353e = null;

    private JsonWriteContext(int i, JsonWriteContext jsonWriteContext) {
        this.a = i;
        this.f7351c = jsonWriteContext;
        this.b = -1;
    }

    public static JsonWriteContext m11949i() {
        return new JsonWriteContext(0, null);
    }

    private JsonWriteContext m11947a(int i) {
        this.a = i;
        this.b = -1;
        this.f7352d = null;
        return this;
    }

    public final JsonWriteContext m11953j() {
        JsonWriteContext jsonWriteContext = this.f7353e;
        if (jsonWriteContext != null) {
            return jsonWriteContext.m11947a(1);
        }
        jsonWriteContext = new JsonWriteContext(1, this);
        this.f7353e = jsonWriteContext;
        return jsonWriteContext;
    }

    public final JsonWriteContext m11954k() {
        JsonWriteContext jsonWriteContext = this.f7353e;
        if (jsonWriteContext != null) {
            return jsonWriteContext.m11947a(2);
        }
        jsonWriteContext = new JsonWriteContext(2, this);
        this.f7353e = jsonWriteContext;
        return jsonWriteContext;
    }

    public final /* synthetic */ JsonStreamContext mo1659a() {
        return this.f7351c;
    }

    public final JsonWriteContext m11955l() {
        return this.f7351c;
    }

    public final String mo1660h() {
        return this.f7352d;
    }

    public final int m11950a(String str) {
        if (this.f7354a != 2 || this.f7352d != null) {
            return 4;
        }
        this.f7352d = str;
        return this.f7355b < 0 ? 0 : 1;
    }

    public final int m11956m() {
        if (this.f7354a == 2) {
            if (this.f7352d == null) {
                return 5;
            }
            this.f7352d = null;
            this.b = this.f7355b + 1;
            return 2;
        } else if (this.f7354a == 1) {
            int i = this.f7355b;
            this.b = this.f7355b + 1;
            return i < 0 ? 0 : 1;
        } else {
            this.b = this.f7355b + 1;
            return this.f7355b == 0 ? 0 : 3;
        }
    }

    private void m11948a(StringBuilder stringBuilder) {
        if (this.f7354a == 2) {
            stringBuilder.append('{');
            if (this.f7352d != null) {
                stringBuilder.append('\"');
                stringBuilder.append(this.f7352d);
                stringBuilder.append('\"');
            } else {
                stringBuilder.append('?');
            }
            stringBuilder.append('}');
        } else if (this.f7354a == 1) {
            stringBuilder.append('[');
            stringBuilder.append(m11963g());
            stringBuilder.append(']');
        } else {
            stringBuilder.append("/");
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        m11948a(stringBuilder);
        return stringBuilder.toString();
    }
}
