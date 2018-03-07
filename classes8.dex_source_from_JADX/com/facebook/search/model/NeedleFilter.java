package com.facebook.search.model;

import com.facebook.search.results.protocol.filters.FilterValue;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import javax.annotation.Nullable;

/* compiled from: TOUCH_SETTINGS */
public class NeedleFilter {
    public final String f22171a;
    public final String f22172b;
    public final String f22173c;
    public final FilterValue f22174d;

    /* compiled from: TOUCH_SETTINGS */
    public class Builder {
        public String f22167a;
        public String f22168b;
        public String f22169c;
        public FilterValue f22170d;

        public final NeedleFilter m25678a() {
            return new NeedleFilter(this);
        }
    }

    public NeedleFilter(Builder builder) {
        this.f22171a = (String) Preconditions.checkNotNull(builder.f22167a);
        this.f22172b = (String) Preconditions.checkNotNull(builder.f22168b);
        this.f22173c = builder.f22169c;
        this.f22174d = builder.f22170d;
    }

    public final String m25679b() {
        return this.f22172b;
    }

    @Nullable
    public final String m25680c() {
        return this.f22173c;
    }

    @Nullable
    public final FilterValue m25681d() {
        return this.f22174d;
    }

    public String toString() {
        JsonFactory jsonFactory = new JsonFactory();
        Writer stringWriter = new StringWriter();
        try {
            JsonGenerator a = jsonFactory.a(stringWriter);
            a.f();
            a.a("id", this.f22171a);
            a.a("name", this.f22172b);
            a.a("text", this.f22173c);
            a.a("filter_value");
            a.c(":");
            a.c(this.f22174d != null ? this.f22174d.toString() : "null");
            a.g();
            a.close();
            return stringWriter.getBuffer().toString();
        } catch (IOException e) {
            return super.toString();
        }
    }
}
