package com.facebook.common.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.common.base.Throwables;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.util.Set;

/* compiled from: profile/%s/activitylog_search */
public class FbJsonDeserializer extends JsonDeserializer<Object> {
    private Class<?> f8943a = null;
    private Constructor<?> f8944b = null;
    private boolean f8945c = false;

    protected final void m13809a(Class<?> cls) {
        try {
            this.f8943a = cls;
            this.f8944b = cls.getDeclaredConstructor(new Class[0]);
            this.f8945c = Postprocessable.class.isAssignableFrom(cls);
        } catch (Throwable e) {
            throw new RuntimeException(cls.getName() + " missing default constructor", e);
        }
    }

    public FbJsonField mo1880a(String str) {
        return null;
    }

    public final boolean mo1881d() {
        return true;
    }

    public Object mo1797a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        try {
            this.f8944b.setAccessible(true);
            Object newInstance = this.f8944b.newInstance(new Object[0]);
            while (FbJsonChecker.m13811a(jsonParser) != JsonToken.END_OBJECT) {
                if (jsonParser.mo1794g() == JsonToken.FIELD_NAME) {
                    String i = jsonParser.mo1778i();
                    jsonParser.mo1766c();
                    FbJsonField a = mo1880a(i);
                    if (a != null) {
                        a.deserialize(newInstance, jsonParser, deserializationContext);
                    } else {
                        jsonParser.mo1793f();
                    }
                }
            }
            if (this.f8945c) {
                ((Postprocessable) newInstance).mo78a();
            }
            return newInstance;
        } catch (Throwable e) {
            Throwables.propagateIfPossible(e, IOException.class);
            throw new JsonParseException("Failed to deserialize to instance " + this.f8944b.getDeclaringClass().getName() + "\n" + m13806a(jsonParser), jsonParser.mo1781l(), e);
        }
    }

    public static Set<String> getJsonFields() {
        return null;
    }

    public static String m13806a(JsonParser jsonParser) {
        Object b = jsonParser.mo1765b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("current token: ");
        stringBuilder.append(jsonParser.mo1769o());
        stringBuilder.append("\n");
        char[] toCharArray;
        int read;
        if (b instanceof InputStream) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            jsonParser.mo3207a(byteArrayOutputStream);
            byteArrayOutputStream.flush();
            toCharArray = byteArrayOutputStream.toString().toCharArray();
            stringBuilder.append(toCharArray, 0, Math.min(toCharArray.length, 100 - stringBuilder.length()));
            byteArrayOutputStream.close();
            InputStream inputStream = (InputStream) b;
            while (true) {
                read = inputStream.read();
                if (read == -1 || stringBuilder.length() >= 100) {
                    break;
                }
                stringBuilder.append((char) read);
            }
        } else if (b instanceof Reader) {
            Writer stringWriter = new StringWriter();
            jsonParser.mo1760a(stringWriter);
            stringWriter.flush();
            toCharArray = stringWriter.toString().toCharArray();
            stringBuilder.append(toCharArray, 0, Math.min(toCharArray.length, 100 - stringBuilder.length()));
            stringWriter.close();
            Reader reader = (Reader) b;
            while (true) {
                read = reader.read();
                if (read == -1 || stringBuilder.length() >= 100) {
                    reader.close();
                } else {
                    stringBuilder.append((char) read);
                }
            }
            reader.close();
        }
        if (stringBuilder.length() == 100) {
            stringBuilder.append("...");
        }
        return stringBuilder.toString();
    }
}
