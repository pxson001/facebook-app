package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.Closeable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: client_time */
public class MappingIterator<T> implements Closeable, Iterator<T> {
    protected static final MappingIterator<?> f5972a = new MappingIterator(null, null, null, null, false, null);
    protected final JavaType f5973b;
    protected final DeserializationContext f5974c;
    protected final JsonDeserializer<T> f5975d;
    protected JsonParser f5976e;
    protected final boolean f5977f;
    protected boolean f5978g;
    protected final T f5979h;

    protected MappingIterator(JavaType javaType, JsonParser jsonParser, DeserializationContext deserializationContext, JsonDeserializer<?> jsonDeserializer, boolean z, Object obj) {
        this.f5973b = javaType;
        this.f5976e = jsonParser;
        this.f5974c = deserializationContext;
        this.f5975d = jsonDeserializer;
        this.f5977f = z;
        if (obj == null) {
            this.f5979h = null;
        } else {
            this.f5979h = obj;
        }
        if (z && jsonParser != null && jsonParser.g() == JsonToken.START_ARRAY) {
            jsonParser.n();
        }
    }

    public boolean hasNext() {
        try {
            return m10790a();
        } catch (JsonMappingException e) {
            throw new RuntimeJsonMappingException(e.getMessage(), e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    public T next() {
        try {
            return m10791b();
        } catch (JsonMappingException e) {
            throw new RuntimeJsonMappingException(e.getMessage(), e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void close() {
        if (this.f5976e != null) {
            this.f5976e.close();
        }
    }

    private boolean m10790a() {
        if (this.f5976e == null) {
            return false;
        }
        if (!this.f5978g) {
            JsonToken g = this.f5976e.g();
            this.f5978g = true;
            if (g == null) {
                g = this.f5976e.c();
                if (g == null || g == JsonToken.END_ARRAY) {
                    JsonParser jsonParser = this.f5976e;
                    this.f5976e = null;
                    if (!this.f5977f) {
                        return false;
                    }
                    jsonParser.close();
                    return false;
                }
            }
        }
        return true;
    }

    private T m10791b() {
        if (!this.f5978g && !m10790a()) {
            throw new NoSuchElementException();
        } else if (this.f5976e == null) {
            throw new NoSuchElementException();
        } else {
            T a;
            this.f5978g = false;
            if (this.f5979h == null) {
                a = this.f5975d.a(this.f5976e, this.f5974c);
            } else {
                this.f5975d.a(this.f5976e, this.f5974c, this.f5979h);
                a = this.f5979h;
            }
            this.f5976e.n();
            return a;
        }
    }
}
