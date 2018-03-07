package org.whispersystems.libsignal.util.guava;

/* compiled from: acorn_weather_content_settings */
public final class Absent extends Optional<Object> {
    public static final Absent f21482a = new Absent();

    Absent() {
    }

    public final boolean mo939a() {
        return false;
    }

    public final Object mo940b() {
        throw new IllegalStateException("value is absent");
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 1502476572;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    private Object readResolve() {
        return f21482a;
    }
}
