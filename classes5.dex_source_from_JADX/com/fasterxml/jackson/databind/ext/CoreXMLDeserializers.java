package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

/* compiled from: chat_with_group */
public class CoreXMLDeserializers extends Base {
    static final DatatypeFactory f6107a;

    /* compiled from: chat_with_group */
    public class DurationDeserializer extends FromStringDeserializer<Duration> {
        public static final DurationDeserializer f6104a = new DurationDeserializer();
        private static final long serialVersionUID = 1;

        public DurationDeserializer() {
            super(Duration.class);
        }

        protected final Object m11359a(String str, DeserializationContext deserializationContext) {
            return CoreXMLDeserializers.f6107a.newDuration(str);
        }
    }

    /* compiled from: chat_with_group */
    public class GregorianCalendarDeserializer extends StdScalarDeserializer<XMLGregorianCalendar> {
        public static final GregorianCalendarDeserializer f6105a = new GregorianCalendarDeserializer();
        private static final long serialVersionUID = 1;

        public /* synthetic */ Object m11360a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11361b(jsonParser, deserializationContext);
        }

        public GregorianCalendarDeserializer() {
            super(XMLGregorianCalendar.class);
        }

        public XMLGregorianCalendar m11361b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            Date a_ = a_(jsonParser, deserializationContext);
            if (a_ == null) {
                return null;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(a_);
            TimeZone k = deserializationContext.k();
            if (k != null) {
                gregorianCalendar.setTimeZone(k);
            }
            return CoreXMLDeserializers.f6107a.newXMLGregorianCalendar(gregorianCalendar);
        }
    }

    /* compiled from: chat_with_group */
    public class QNameDeserializer extends FromStringDeserializer<QName> {
        public static final QNameDeserializer f6106a = new QNameDeserializer();
        private static final long serialVersionUID = 1;

        public QNameDeserializer() {
            super(QName.class);
        }

        protected final Object m11362a(String str, DeserializationContext deserializationContext) {
            return QName.valueOf(str);
        }
    }

    static {
        try {
            f6107a = DatatypeFactory.newInstance();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final JsonDeserializer<?> m11363a(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        Class cls = javaType._class;
        if (cls == QName.class) {
            return QNameDeserializer.f6106a;
        }
        if (cls == XMLGregorianCalendar.class) {
            return GregorianCalendarDeserializer.f6105a;
        }
        if (cls == Duration.class) {
            return DurationDeserializer.f6104a;
        }
        return null;
    }
}
