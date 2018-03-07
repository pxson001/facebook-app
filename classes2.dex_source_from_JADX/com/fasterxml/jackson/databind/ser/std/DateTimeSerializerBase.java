package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: staleness */
public abstract class DateTimeSerializerBase<T> extends StdScalarSerializer<T> implements ContextualSerializer {
    protected final boolean f4173b;
    protected final DateFormat f4174c;

    public abstract DateTimeSerializerBase<T> mo1103a(boolean z, DateFormat dateFormat);

    protected abstract long mo1104b(T t);

    protected DateTimeSerializerBase(Class<T> cls, boolean z, DateFormat dateFormat) {
        super(cls);
        this.f4173b = z;
        this.f4174c = dateFormat;
    }

    public final JsonSerializer<?> mo1105a(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        if (beanProperty == null) {
            return this;
        }
        Value e = serializerProvider.m7322e().mo994e(beanProperty.b());
        if (e == null) {
            return this;
        }
        if (e.b.isNumeric()) {
            return mo1103a(true, null);
        }
        TimeZone timeZone = e.d;
        String str = e.a;
        if (str.length() > 0) {
            TimeZone i;
            Locale locale = e.c;
            if (locale == null) {
                locale = serializerProvider.m7325h();
            }
            DateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
            if (timeZone == null) {
                i = serializerProvider.m7326i();
            } else {
                i = timeZone;
            }
            simpleDateFormat.setTimeZone(i);
            return mo1103a(false, simpleDateFormat);
        } else if (timeZone == null) {
            return this;
        } else {
            DateFormat o = serializerProvider._config.m7270o();
            if (o.getClass() == StdDateFormat.class) {
                o = StdDateFormat.m7127b(timeZone);
            } else {
                o = (DateFormat) o.clone();
                o.setTimeZone(timeZone);
            }
            return mo1103a(false, o);
        }
    }

    public final boolean mo1102a(T t) {
        return t == null || mo1104b(t) == 0;
    }
}
