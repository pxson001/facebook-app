package com.facebook.contextual;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

/* compiled from: stale_active_time_ms */
public class ContextValue {
    private static final Map<String, Type> f1916a = ImmutableMap.of("BOOL", Type.BOOLEAN, "INT", Type.INTEGER, "FLOAT", Type.FLOAT, "STRING", Type.STRING);
    private Type f1917b;
    private boolean f1918c;
    private long f1919d;
    private double f1920e;
    private String f1921f;

    /* compiled from: stale_active_time_ms */
    public enum Type {
        BOOLEAN,
        INTEGER,
        FLOAT,
        STRING
    }

    public static Type m1976a(String str) {
        return (Type) f1916a.get(str);
    }

    public ContextValue(Type type, String str) {
        if (type == null || str == null) {
            throw new ContextualConfigError("Bad context value");
        }
        switch (1.a[type.ordinal()]) {
            case 1:
                if (str.equals("true") || str.equals("false")) {
                    this.f1918c = Boolean.parseBoolean(str);
                    break;
                }
                throw new ContextualConfigError("Invalid boolean string");
            case 2:
                try {
                    this.f1919d = Long.parseLong(str);
                    break;
                } catch (NumberFormatException e) {
                    throw new ContextualConfigError("Invalid integer string");
                }
            case 3:
                try {
                    this.f1920e = Double.parseDouble(str);
                    break;
                } catch (NumberFormatException e2) {
                    throw new ContextualConfigError("Invalid float string");
                }
            case 4:
                this.f1921f = str;
                break;
            default:
                throw new ContextualConfigError("Unsupported context type");
        }
        this.f1917b = type;
    }

    public ContextValue(boolean z) {
        this.f1917b = Type.BOOLEAN;
        this.f1918c = z;
    }

    public ContextValue(long j) {
        this.f1917b = Type.INTEGER;
        this.f1919d = j;
    }

    public ContextValue(double d) {
        this.f1917b = Type.FLOAT;
        this.f1920e = d;
    }

    public ContextValue(String str) {
        this.f1917b = Type.STRING;
        this.f1921f = str;
    }

    public final long m1977a() {
        if (this.f1917b == Type.INTEGER) {
            return this.f1919d;
        }
        if (this.f1917b == Type.FLOAT) {
            return (long) this.f1920e;
        }
        throw new ContextualConfigError("Invalid value type");
    }

    public final double m1978b() {
        if (this.f1917b == Type.INTEGER) {
            return (double) this.f1919d;
        }
        if (this.f1917b == Type.FLOAT) {
            return this.f1920e;
        }
        throw new ContextualConfigError("Invalid value type");
    }

    public final String m1979c() {
        if (this.f1921f != null) {
            return this.f1921f;
        }
        switch (1.a[this.f1917b.ordinal()]) {
            case 1:
                this.f1921f = String.valueOf(this.f1918c);
                break;
            case 2:
                this.f1921f = String.valueOf(this.f1919d);
                break;
            case 3:
                this.f1921f = String.valueOf(this.f1920e);
                break;
            default:
                this.f1921f = "ILLEGAL_CONTEXT_VALUE_TYPE";
                break;
        }
        return this.f1921f;
    }
}
