package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: request_friendly_name */
public abstract class GeneratorBase extends JsonGenerator {
    protected ObjectCodec f7335b;
    protected int f7336c;
    protected boolean f7337d;
    public JsonWriteContext f7338e = JsonWriteContext.m11949i();
    protected boolean f7339f;

    protected abstract void mo1653h(String str);

    protected abstract void mo1654j();

    protected GeneratorBase(int i, ObjectCodec objectCodec) {
        this.f7336c = i;
        this.f7335b = objectCodec;
        this.f7337d = m11923a(Feature.WRITE_NUMBERS_AS_STRINGS);
    }

    public Version version() {
        return VersionUtil.a(getClass());
    }

    public final boolean m11923a(Feature feature) {
        return (this.f7336c & feature.getMask()) != 0;
    }

    public final JsonGenerator mo1106a(ObjectCodec objectCodec) {
        this.f7335b = objectCodec;
        return this;
    }

    public final ObjectCodec mo1107a() {
        return this.f7335b;
    }

    public final JsonWriteContext m11929i() {
        return this.f7338e;
    }

    public void mo1122b(SerializableString serializableString) {
        mo1115a(serializableString.mo1050a());
    }

    public void mo1126c(SerializableString serializableString) {
        mo1123b(serializableString.mo1050a());
    }

    public void mo1131d(String str) {
        mo1653h("write raw value");
        mo1127c(str);
    }

    public final void mo1114a(Object obj) {
        if (obj == null) {
            mo1137h();
        } else if (this.f7335b != null) {
            this.f7335b.mo909a((JsonGenerator) this, obj);
        } else {
            m11916b(obj);
        }
    }

    public final void mo1113a(TreeNode treeNode) {
        if (treeNode == null) {
            mo1137h();
        } else if (this.f7335b == null) {
            throw new IllegalStateException("No ObjectCodec defined");
        } else {
            this.f7335b.mo909a((JsonGenerator) this, (Object) treeNode);
        }
    }

    public void close() {
        this.f7339f = true;
    }

    public JsonGenerator mo1125c() {
        return this.f4184a != null ? this : m7672a(new DefaultPrettyPrinter());
    }

    protected static void m11917i(String str) {
        throw new JsonGenerationException(str);
    }

    private void m11916b(Object obj) {
        if (obj == null) {
            mo1137h();
        } else if (obj instanceof String) {
            mo1123b((String) obj);
        } else {
            if (obj instanceof Number) {
                Number number = (Number) obj;
                if (number instanceof Integer) {
                    mo1121b(number.intValue());
                    return;
                } else if (number instanceof Long) {
                    mo1111a(number.longValue());
                    return;
                } else if (number instanceof Double) {
                    mo1109a(number.doubleValue());
                    return;
                } else if (number instanceof Float) {
                    mo1110a(number.floatValue());
                    return;
                } else if (number instanceof Short) {
                    mo1118a(number.shortValue());
                    return;
                } else if (number instanceof Byte) {
                    mo1118a((short) number.byteValue());
                    return;
                } else if (number instanceof BigInteger) {
                    mo1117a((BigInteger) number);
                    return;
                } else if (number instanceof BigDecimal) {
                    mo1116a((BigDecimal) number);
                    return;
                } else if (number instanceof AtomicInteger) {
                    mo1121b(((AtomicInteger) number).get());
                    return;
                } else if (number instanceof AtomicLong) {
                    mo1111a(((AtomicLong) number).get());
                    return;
                }
            } else if (obj instanceof byte[]) {
                m7696a((byte[]) obj);
                return;
            } else if (obj instanceof Boolean) {
                mo1119a(((Boolean) obj).booleanValue());
                return;
            } else if (obj instanceof AtomicBoolean) {
                mo1119a(((AtomicBoolean) obj).get());
                return;
            }
            throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + obj.getClass().getName() + ")");
        }
    }

    protected static void m11918k() {
        VersionUtil.b();
    }
}
