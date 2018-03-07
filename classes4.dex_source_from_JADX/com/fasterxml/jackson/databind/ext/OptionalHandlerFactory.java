package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.ser.Serializers;
import java.io.Serializable;

/* compiled from: ver */
public class OptionalHandlerFactory implements Serializable {
    public static final OptionalHandlerFactory f307a = new OptionalHandlerFactory();
    private static final long serialVersionUID = 1;

    protected OptionalHandlerFactory() {
    }

    public final JsonSerializer<?> m536a(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) {
        Class cls = javaType._class;
        if (!cls.getName().startsWith("javax.xml.") && !m533c(cls, "javax.xml.")) {
            return m531a(cls, "org.w3c.dom.Node") ? (JsonSerializer) m530a("com.fasterxml.jackson.databind.ext.DOMSerializer") : null;
        } else {
            Object a = m530a("com.fasterxml.jackson.databind.ext.CoreXMLSerializers");
            if (a == null) {
                return null;
            }
            return ((Serializers) a).a(serializationConfig, javaType, beanDescription);
        }
    }

    public final JsonDeserializer<?> m535a(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        Class cls = javaType._class;
        if (cls.getName().startsWith("javax.xml.") || m533c(cls, "javax.xml.")) {
            Object a = m530a("com.fasterxml.jackson.databind.ext.CoreXMLDeserializers");
            if (a == null) {
                return null;
            }
            return ((Deserializers) a).a(javaType, deserializationConfig, beanDescription);
        } else if (m531a(cls, "org.w3c.dom.Node")) {
            return (JsonDeserializer) m530a("com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer");
        } else {
            return m531a(cls, "org.w3c.dom.Node") ? (JsonDeserializer) m530a("com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer") : null;
        }
    }

    private static Object m530a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (LinkageError e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    private boolean m531a(Class<?> cls, String str) {
        while (cls != null) {
            if (cls.getName().equals(str) || m532b(cls, str)) {
                return true;
            }
            cls = cls.getSuperclass();
        }
        return false;
    }

    private boolean m532b(Class<?> cls, String str) {
        Class[] interfaces = cls.getInterfaces();
        for (Class name : interfaces) {
            if (name.getName().equals(str)) {
                return true;
            }
        }
        for (Class name2 : interfaces) {
            if (m532b(name2, str)) {
                return true;
            }
        }
        return false;
    }

    private boolean m533c(Class<?> cls, String str) {
        for (Class superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (superclass.getName().startsWith(str)) {
                return true;
            }
        }
        while (cls != null) {
            if (m534d(cls, str)) {
                return true;
            }
            cls = cls.getSuperclass();
        }
        return false;
    }

    private boolean m534d(Class<?> cls, String str) {
        Class[] interfaces = cls.getInterfaces();
        for (Class name : interfaces) {
            if (name.getName().startsWith(str)) {
                return true;
            }
        }
        for (Class name2 : interfaces) {
            if (m534d(name2, str)) {
                return true;
            }
        }
        return false;
    }
}
