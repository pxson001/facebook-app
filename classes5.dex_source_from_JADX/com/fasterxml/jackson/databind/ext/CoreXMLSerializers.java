package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.Serializers.Base;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

/* compiled from: chat_heads */
public class CoreXMLSerializers extends Base {

    /* compiled from: chat_heads */
    public class XMLGregorianCalendarSerializer extends StdSerializer<XMLGregorianCalendar> {
        public static final XMLGregorianCalendarSerializer f6108a = new XMLGregorianCalendarSerializer();

        public final void m11364a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            CalendarSerializer.a.a(((XMLGregorianCalendar) obj).toGregorianCalendar(), jsonGenerator, serializerProvider);
        }

        public XMLGregorianCalendarSerializer() {
            super(XMLGregorianCalendar.class);
        }
    }

    public final JsonSerializer<?> m11365a(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) {
        Class cls = javaType._class;
        if (Duration.class.isAssignableFrom(cls) || QName.class.isAssignableFrom(cls)) {
            return ToStringSerializer.a;
        }
        if (XMLGregorianCalendar.class.isAssignableFrom(cls)) {
            return XMLGregorianCalendarSerializer.f6108a;
        }
        return null;
    }
}
