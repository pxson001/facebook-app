package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat$Value;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: choices */
public class DateDeserializers {
    private static final HashSet<String> f6067a = new HashSet();

    /* compiled from: choices */
    public abstract class DateBasedDeserializer<T> extends StdScalarDeserializer<T> implements ContextualDeserializer {
        protected final DateFormat _customFormat;
        protected final String _formatString;

        protected abstract DateBasedDeserializer<T> mo669a(DateFormat dateFormat, String str);

        protected DateBasedDeserializer(Class<?> cls) {
            super(cls);
            this._customFormat = null;
            this._formatString = null;
        }

        protected DateBasedDeserializer(DateBasedDeserializer<T> dateBasedDeserializer, DateFormat dateFormat, String str) {
            super(dateBasedDeserializer._valueClass);
            this._customFormat = dateFormat;
            this._formatString = str;
        }

        public JsonDeserializer<?> m11143a(DeserializationContext deserializationContext, BeanProperty beanProperty) {
            if (beanProperty == null) {
                return this;
            }
            JsonFormat$Value e = deserializationContext.f().e(beanProperty.b());
            if (e == null) {
                return this;
            }
            TimeZone timeZone = e.f5940d;
            String str = e.f5937a;
            if (str.length() > 0) {
                TimeZone k;
                Locale locale = e.f5939c;
                if (locale == null) {
                    locale = deserializationContext.j();
                }
                DateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
                if (timeZone == null) {
                    k = deserializationContext.k();
                } else {
                    k = timeZone;
                }
                simpleDateFormat.setTimeZone(k);
                return mo669a(simpleDateFormat, str);
            } else if (timeZone == null) {
                return this;
            } else {
                DateFormat o = deserializationContext._config.o();
                if (o.getClass() == StdDateFormat.class) {
                    o = StdDateFormat.a(timeZone);
                } else {
                    o = (DateFormat) o.clone();
                    o.setTimeZone(timeZone);
                }
                return mo669a(o, str);
            }
        }

        protected final Date a_(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (this._customFormat == null || jsonParser.g() != JsonToken.VALUE_STRING) {
                return super.a_(jsonParser, deserializationContext);
            }
            String trim = jsonParser.o().trim();
            if (trim.length() == 0) {
                return (Date) b();
            }
            Date parse;
            synchronized (this._customFormat) {
                try {
                    parse = this._customFormat.parse(trim);
                } catch (ParseException e) {
                    throw new IllegalArgumentException("Failed to parse Date value '" + trim + "' (format: \"" + this._formatString + "\"): " + e.getMessage());
                }
            }
            return parse;
        }
    }

    @JacksonStdImpl
    /* compiled from: choices */
    public class CalendarDeserializer extends DateBasedDeserializer<Calendar> {
        public static final CalendarDeserializer f6061a = new CalendarDeserializer();
        public static final CalendarDeserializer f6062b = new CalendarDeserializer(GregorianCalendar.class);
        protected final Class<? extends Calendar> _calendarClass;

        public /* synthetic */ Object m11146a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11147b(jsonParser, deserializationContext);
        }

        public CalendarDeserializer() {
            super(Calendar.class);
            this._calendarClass = null;
        }

        private CalendarDeserializer(Class<? extends Calendar> cls) {
            super(cls);
            this._calendarClass = cls;
        }

        private CalendarDeserializer(CalendarDeserializer calendarDeserializer, DateFormat dateFormat, String str) {
            super(calendarDeserializer, dateFormat, str);
            this._calendarClass = calendarDeserializer._calendarClass;
        }

        protected final DateBasedDeserializer mo669a(DateFormat dateFormat, String str) {
            return new CalendarDeserializer(this, dateFormat, str);
        }

        public Calendar m11147b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            Date a_ = a_(jsonParser, deserializationContext);
            if (a_ == null) {
                return null;
            }
            if (this._calendarClass == null) {
                return deserializationContext.a(a_);
            }
            try {
                Calendar calendar = (Calendar) this._calendarClass.newInstance();
                calendar.setTimeInMillis(a_.getTime());
                TimeZone k = deserializationContext.k();
                if (k == null) {
                    return calendar;
                }
                calendar.setTimeZone(k);
                return calendar;
            } catch (Throwable e) {
                throw deserializationContext.a(this._calendarClass, e);
            }
        }
    }

    /* compiled from: choices */
    public class DateDeserializer extends DateBasedDeserializer<Date> {
        public static final DateDeserializer f6063a = new DateDeserializer();

        public /* synthetic */ Object m11149a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11150b(jsonParser, deserializationContext);
        }

        public DateDeserializer() {
            super(Date.class);
        }

        private DateDeserializer(DateDeserializer dateDeserializer, DateFormat dateFormat, String str) {
            super(dateDeserializer, dateFormat, str);
        }

        protected final DateBasedDeserializer mo669a(DateFormat dateFormat, String str) {
            return new DateDeserializer(this, dateFormat, str);
        }

        public Date m11150b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return a_(jsonParser, deserializationContext);
        }
    }

    /* compiled from: choices */
    public class SqlDateDeserializer extends DateBasedDeserializer<java.sql.Date> {
        public static final SqlDateDeserializer f6064a = new SqlDateDeserializer();

        public /* synthetic */ Object m11152a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11153b(jsonParser, deserializationContext);
        }

        public SqlDateDeserializer() {
            super(java.sql.Date.class);
        }

        private SqlDateDeserializer(SqlDateDeserializer sqlDateDeserializer, DateFormat dateFormat, String str) {
            super(sqlDateDeserializer, dateFormat, str);
        }

        protected final DateBasedDeserializer mo669a(DateFormat dateFormat, String str) {
            return new SqlDateDeserializer(this, dateFormat, str);
        }

        public java.sql.Date m11153b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            Date a_ = a_(jsonParser, deserializationContext);
            return a_ == null ? null : new java.sql.Date(a_.getTime());
        }
    }

    /* compiled from: choices */
    public class TimeZoneDeserializer extends FromStringDeserializer<TimeZone> {
        public static final TimeZoneDeserializer f6065a = new TimeZoneDeserializer();

        public TimeZoneDeserializer() {
            super(TimeZone.class);
        }

        protected final Object m11154a(String str, DeserializationContext deserializationContext) {
            return TimeZone.getTimeZone(str);
        }
    }

    /* compiled from: choices */
    public class TimestampDeserializer extends DateBasedDeserializer<Timestamp> {
        public static final TimestampDeserializer f6066a = new TimestampDeserializer();

        public /* synthetic */ Object m11156a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11157b(jsonParser, deserializationContext);
        }

        public TimestampDeserializer() {
            super(Timestamp.class);
        }

        private TimestampDeserializer(TimestampDeserializer timestampDeserializer, DateFormat dateFormat, String str) {
            super(timestampDeserializer, dateFormat, str);
        }

        protected final DateBasedDeserializer mo669a(DateFormat dateFormat, String str) {
            return new TimestampDeserializer(this, dateFormat, str);
        }

        public Timestamp m11157b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return new Timestamp(a_(jsonParser, deserializationContext).getTime());
        }
    }

    static {
        int i = 0;
        Class[] clsArr = new Class[]{Calendar.class, GregorianCalendar.class, java.sql.Date.class, Date.class, Timestamp.class, TimeZone.class};
        while (i < 6) {
            f6067a.add(clsArr[i].getName());
            i++;
        }
    }

    public static JsonDeserializer<?> m11158a(Class<?> cls, String str) {
        if (!f6067a.contains(str)) {
            return null;
        }
        if (cls == Calendar.class) {
            return CalendarDeserializer.f6061a;
        }
        if (cls == Date.class) {
            return DateDeserializer.f6063a;
        }
        if (cls == java.sql.Date.class) {
            return SqlDateDeserializer.f6064a;
        }
        if (cls == Timestamp.class) {
            return TimestampDeserializer.f6066a;
        }
        if (cls == TimeZone.class) {
            return TimeZoneDeserializer.f6065a;
        }
        if (cls == GregorianCalendar.class) {
            return CalendarDeserializer.f6062b;
        }
        throw new IllegalArgumentException("Internal error: can't find deserializer for " + str);
    }
}
