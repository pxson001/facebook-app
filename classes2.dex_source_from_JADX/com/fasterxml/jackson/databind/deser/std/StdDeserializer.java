package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Converter;
import java.io.Serializable;
import java.util.Date;

/* compiled from: push_notification */
public abstract class StdDeserializer<T> extends JsonDeserializer<T> implements Serializable {
    private static final long serialVersionUID = 1;
    public final Class<?> _valueClass;

    protected StdDeserializer(Class<?> cls) {
        this._valueClass = cls;
    }

    protected StdDeserializer(JavaType javaType) {
        Class cls;
        if (javaType == null) {
            cls = null;
        } else {
            cls = javaType._class;
        }
        this._valueClass = cls;
    }

    public final Class<?> m13350g() {
        return this._valueClass;
    }

    protected static boolean m13345a(JsonDeserializer<?> jsonDeserializer) {
        return (jsonDeserializer == null || jsonDeserializer.getClass().getAnnotation(JacksonStdImpl.class) == null) ? false : true;
    }

    protected static boolean m13346a(KeyDeserializer keyDeserializer) {
        return (keyDeserializer == null || keyDeserializer.getClass().getAnnotation(JacksonStdImpl.class) == null) ? false : true;
    }

    public Object mo1799a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.d(jsonParser, deserializationContext);
    }

    protected final boolean m13351k(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.VALUE_TRUE) {
            return true;
        }
        if (g == JsonToken.VALUE_FALSE) {
            return false;
        }
        if (g == JsonToken.VALUE_NULL) {
            return false;
        }
        if (g == JsonToken.VALUE_NUMBER_INT) {
            if (jsonParser.mo1784u() != NumberType.INT) {
                return m13344a(jsonParser);
            }
            if (jsonParser.mo1785x() == 0) {
                return false;
            }
            return true;
        } else if (g == JsonToken.VALUE_STRING) {
            String trim = jsonParser.mo1769o().trim();
            if ("true".equals(trim)) {
                return true;
            }
            if ("false".equals(trim) || trim.length() == 0) {
                return Boolean.FALSE.booleanValue();
            }
            throw deserializationContext.m7387a(trim, this._valueClass, "only \"true\" or \"false\" recognized");
        } else {
            throw deserializationContext.m7383a(this._valueClass, g);
        }
    }

    protected final Boolean m13352l(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (g == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        if (g == JsonToken.VALUE_NUMBER_INT) {
            if (jsonParser.mo1784u() == NumberType.INT) {
                return jsonParser.mo1785x() == 0 ? Boolean.FALSE : Boolean.TRUE;
            } else {
                return Boolean.valueOf(m13344a(jsonParser));
            }
        } else if (g == JsonToken.VALUE_NULL) {
            return (Boolean) mo1798a();
        } else {
            if (g == JsonToken.VALUE_STRING) {
                String trim = jsonParser.mo1769o().trim();
                if ("true".equals(trim)) {
                    return Boolean.TRUE;
                }
                if ("false".equals(trim)) {
                    return Boolean.FALSE;
                }
                if (trim.length() == 0) {
                    return (Boolean) m13369b();
                }
                throw deserializationContext.m7387a(trim, this._valueClass, "only \"true\" or \"false\" recognized");
            }
            throw deserializationContext.m7383a(this._valueClass, g);
        }
    }

    private static boolean m13344a(JsonParser jsonParser) {
        if (jsonParser.mo1784u() == NumberType.LONG) {
            return (jsonParser.mo1786y() == 0 ? Boolean.FALSE : Boolean.TRUE).booleanValue();
        }
        String o = jsonParser.mo1769o();
        if ("0.0".equals(o) || "0".equals(o)) {
            return Boolean.FALSE.booleanValue();
        }
        return Boolean.TRUE.booleanValue();
    }

    protected final Byte m13353m(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.VALUE_NUMBER_INT || g == JsonToken.VALUE_NUMBER_FLOAT) {
            return Byte.valueOf(jsonParser.m13288v());
        }
        if (g == JsonToken.VALUE_STRING) {
            String trim = jsonParser.mo1769o().trim();
            try {
                if (trim.length() == 0) {
                    return (Byte) m13369b();
                }
                int a = NumberInput.m13438a(trim);
                if (a >= -128 && a <= 255) {
                    return Byte.valueOf((byte) a);
                }
                throw deserializationContext.m7387a(trim, this._valueClass, "overflow, value can not be represented as 8-bit value");
            } catch (IllegalArgumentException e) {
                throw deserializationContext.m7387a(trim, this._valueClass, "not a valid Byte value");
            }
        } else if (g == JsonToken.VALUE_NULL) {
            return (Byte) mo1798a();
        } else {
            throw deserializationContext.m7383a(this._valueClass, g);
        }
    }

    protected final Short m13354n(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.VALUE_NUMBER_INT || g == JsonToken.VALUE_NUMBER_FLOAT) {
            return Short.valueOf(jsonParser.m13289w());
        }
        if (g == JsonToken.VALUE_STRING) {
            String trim = jsonParser.mo1769o().trim();
            try {
                if (trim.length() == 0) {
                    return (Short) m13369b();
                }
                int a = NumberInput.m13438a(trim);
                if (a >= -32768 && a <= 32767) {
                    return Short.valueOf((short) a);
                }
                throw deserializationContext.m7387a(trim, this._valueClass, "overflow, value can not be represented as 16-bit value");
            } catch (IllegalArgumentException e) {
                throw deserializationContext.m7387a(trim, this._valueClass, "not a valid Short value");
            }
        } else if (g == JsonToken.VALUE_NULL) {
            return (Short) mo1798a();
        } else {
            throw deserializationContext.m7383a(this._valueClass, g);
        }
    }

    protected final short m13355o(JsonParser jsonParser, DeserializationContext deserializationContext) {
        int p = m13356p(jsonParser, deserializationContext);
        if (p >= -32768 && p <= 32767) {
            return (short) p;
        }
        throw deserializationContext.m7387a(String.valueOf(p), this._valueClass, "overflow, value can not be represented as 16-bit value");
    }

    protected final int m13356p(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.VALUE_NUMBER_INT || g == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.mo1785x();
        }
        if (g == JsonToken.VALUE_STRING) {
            String trim = jsonParser.mo1769o().trim();
            try {
                int length = trim.length();
                if (length > 9) {
                    long parseLong = Long.parseLong(trim);
                    if (parseLong >= -2147483648L && parseLong <= 2147483647L) {
                        return (int) parseLong;
                    }
                    throw deserializationContext.m7387a(trim, this._valueClass, "Overflow: numeric value (" + trim + ") out of range of int (-2147483648" + " - 2147483647" + ")");
                } else if (length != 0) {
                    return NumberInput.m13438a(trim);
                } else {
                    return 0;
                }
            } catch (IllegalArgumentException e) {
                throw deserializationContext.m7387a(trim, this._valueClass, "not a valid int value");
            }
        } else if (g == JsonToken.VALUE_NULL) {
            return 0;
        } else {
            throw deserializationContext.m7383a(this._valueClass, g);
        }
    }

    protected final Integer m13357q(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.VALUE_NUMBER_INT || g == JsonToken.VALUE_NUMBER_FLOAT) {
            return Integer.valueOf(jsonParser.mo1785x());
        }
        if (g == JsonToken.VALUE_STRING) {
            String trim = jsonParser.mo1769o().trim();
            try {
                int length = trim.length();
                if (length > 9) {
                    long parseLong = Long.parseLong(trim);
                    if (parseLong >= -2147483648L && parseLong <= 2147483647L) {
                        return Integer.valueOf((int) parseLong);
                    }
                    throw deserializationContext.m7387a(trim, this._valueClass, "Overflow: numeric value (" + trim + ") out of range of Integer (-2147483648" + " - 2147483647" + ")");
                } else if (length == 0) {
                    return (Integer) m13369b();
                } else {
                    return Integer.valueOf(NumberInput.m13438a(trim));
                }
            } catch (IllegalArgumentException e) {
                throw deserializationContext.m7387a(trim, this._valueClass, "not a valid Integer value");
            }
        } else if (g == JsonToken.VALUE_NULL) {
            return (Integer) mo1798a();
        } else {
            throw deserializationContext.m7383a(this._valueClass, g);
        }
    }

    protected final Long m13358r(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.VALUE_NUMBER_INT || g == JsonToken.VALUE_NUMBER_FLOAT) {
            return Long.valueOf(jsonParser.mo1786y());
        }
        if (g == JsonToken.VALUE_STRING) {
            String trim = jsonParser.mo1769o().trim();
            if (trim.length() == 0) {
                return (Long) m13369b();
            }
            try {
                return Long.valueOf(NumberInput.m13444b(trim));
            } catch (IllegalArgumentException e) {
                throw deserializationContext.m7387a(trim, this._valueClass, "not a valid Long value");
            }
        } else if (g == JsonToken.VALUE_NULL) {
            return (Long) mo1798a();
        } else {
            throw deserializationContext.m7383a(this._valueClass, g);
        }
    }

    protected final long m13359s(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.VALUE_NUMBER_INT || g == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.mo1786y();
        }
        if (g == JsonToken.VALUE_STRING) {
            String trim = jsonParser.mo1769o().trim();
            if (trim.length() == 0) {
                return 0;
            }
            try {
                return NumberInput.m13444b(trim);
            } catch (IllegalArgumentException e) {
                throw deserializationContext.m7387a(trim, this._valueClass, "not a valid long value");
            }
        } else if (g == JsonToken.VALUE_NULL) {
            return 0;
        } else {
            throw deserializationContext.m7383a(this._valueClass, g);
        }
    }

    protected final Float m13360t(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.VALUE_NUMBER_INT || g == JsonToken.VALUE_NUMBER_FLOAT) {
            return Float.valueOf(jsonParser.mo1773A());
        }
        if (g == JsonToken.VALUE_STRING) {
            String trim = jsonParser.mo1769o().trim();
            if (trim.length() == 0) {
                return (Float) m13369b();
            }
            switch (trim.charAt(0)) {
                case '-':
                    if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                        return Float.valueOf(Float.NEGATIVE_INFINITY);
                    }
                case 'I':
                    if ("Infinity".equals(trim) || "INF".equals(trim)) {
                        return Float.valueOf(Float.POSITIVE_INFINITY);
                    }
                case 'N':
                    if ("NaN".equals(trim)) {
                        return Float.valueOf(Float.NaN);
                    }
                    break;
            }
            try {
                return Float.valueOf(Float.parseFloat(trim));
            } catch (IllegalArgumentException e) {
                throw deserializationContext.m7387a(trim, this._valueClass, "not a valid Float value");
            }
        } else if (g == JsonToken.VALUE_NULL) {
            return (Float) mo1798a();
        } else {
            throw deserializationContext.m7383a(this._valueClass, g);
        }
    }

    protected final float m13361u(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.VALUE_NUMBER_INT || g == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.mo1773A();
        }
        if (g == JsonToken.VALUE_STRING) {
            String trim = jsonParser.mo1769o().trim();
            if (trim.length() == 0) {
                return 0.0f;
            }
            switch (trim.charAt(0)) {
                case '-':
                    if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                        return Float.NEGATIVE_INFINITY;
                    }
                case 'I':
                    if ("Infinity".equals(trim) || "INF".equals(trim)) {
                        return Float.POSITIVE_INFINITY;
                    }
                case 'N':
                    if ("NaN".equals(trim)) {
                        return Float.NaN;
                    }
                    break;
            }
            try {
                return Float.parseFloat(trim);
            } catch (IllegalArgumentException e) {
                throw deserializationContext.m7387a(trim, this._valueClass, "not a valid float value");
            }
        } else if (g == JsonToken.VALUE_NULL) {
            return 0.0f;
        } else {
            throw deserializationContext.m7383a(this._valueClass, g);
        }
    }

    protected final Double m13362v(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.VALUE_NUMBER_INT || g == JsonToken.VALUE_NUMBER_FLOAT) {
            return Double.valueOf(jsonParser.mo1774B());
        }
        if (g == JsonToken.VALUE_STRING) {
            String trim = jsonParser.mo1769o().trim();
            if (trim.length() == 0) {
                return (Double) m13369b();
            }
            switch (trim.charAt(0)) {
                case '-':
                    if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                        return Double.valueOf(Double.NEGATIVE_INFINITY);
                    }
                case 'I':
                    if ("Infinity".equals(trim) || "INF".equals(trim)) {
                        return Double.valueOf(Double.POSITIVE_INFINITY);
                    }
                case 'N':
                    if ("NaN".equals(trim)) {
                        return Double.valueOf(Double.NaN);
                    }
                    break;
            }
            try {
                return Double.valueOf(m13341a(trim));
            } catch (IllegalArgumentException e) {
                throw deserializationContext.m7387a(trim, this._valueClass, "not a valid Double value");
            }
        } else if (g == JsonToken.VALUE_NULL) {
            return (Double) mo1798a();
        } else {
            throw deserializationContext.m7383a(this._valueClass, g);
        }
    }

    protected final double m13363w(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.VALUE_NUMBER_INT || g == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.mo1774B();
        }
        if (g == JsonToken.VALUE_STRING) {
            String trim = jsonParser.mo1769o().trim();
            if (trim.length() == 0) {
                return 0.0d;
            }
            switch (trim.charAt(0)) {
                case '-':
                    if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                        return Double.NEGATIVE_INFINITY;
                    }
                case 'I':
                    if ("Infinity".equals(trim) || "INF".equals(trim)) {
                        return Double.POSITIVE_INFINITY;
                    }
                case 'N':
                    if ("NaN".equals(trim)) {
                        return Double.NaN;
                    }
                    break;
            }
            try {
                return m13341a(trim);
            } catch (IllegalArgumentException e) {
                throw deserializationContext.m7387a(trim, this._valueClass, "not a valid double value");
            }
        } else if (g == JsonToken.VALUE_NULL) {
            return 0.0d;
        } else {
            throw deserializationContext.m7383a(this._valueClass, g);
        }
    }

    protected Date a_(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.VALUE_NUMBER_INT) {
            return new Date(jsonParser.mo1786y());
        }
        if (g == JsonToken.VALUE_NULL) {
            return (Date) mo1798a();
        }
        if (g == JsonToken.VALUE_STRING) {
            try {
                String trim = jsonParser.mo1769o().trim();
                if (trim.length() == 0) {
                    return (Date) m13369b();
                }
                return deserializationContext.m7400b(trim);
            } catch (IllegalArgumentException e) {
                throw deserializationContext.m7387a(null, this._valueClass, "not a valid representation (error: " + e.getMessage() + ")");
            }
        }
        throw deserializationContext.m7383a(this._valueClass, g);
    }

    private static double m13341a(String str) {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    protected static String m13347x(JsonParser jsonParser, DeserializationContext deserializationContext) {
        String I = jsonParser.mo1753I();
        if (I != null) {
            return I;
        }
        throw deserializationContext.m7383a(String.class, jsonParser.mo1794g());
    }

    protected static JsonDeserializer<Object> m13343a(DeserializationContext deserializationContext, JavaType javaType, BeanProperty beanProperty) {
        return deserializationContext.m7381a(javaType, beanProperty);
    }

    protected static JsonDeserializer<?> m13342a(DeserializationContext deserializationContext, BeanProperty beanProperty, JsonDeserializer<?> jsonDeserializer) {
        AnnotationIntrospector f = deserializationContext.m7407f();
        if (f == null || beanProperty == null) {
            return jsonDeserializer;
        }
        Object i = f.mo1009i(beanProperty.b());
        if (i == null) {
            return jsonDeserializer;
        }
        Converter a = deserializationContext.m7335a(beanProperty.b(), i);
        JavaType b = a.b();
        if (jsonDeserializer == null) {
            jsonDeserializer = deserializationContext.m7381a(b, beanProperty);
        }
        return new StdDelegatingDeserializer(a, b, jsonDeserializer);
    }

    protected void m13349a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) {
        if (obj == null) {
            obj = this._valueClass;
        }
        if (!deserializationContext.m7394a(jsonParser, this, obj, str)) {
            deserializationContext.m7393a(obj, str, (JsonDeserializer) this);
            jsonParser.mo1793f();
        }
    }
}
