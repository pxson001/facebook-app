package org.whispersystems.libsignal.util.guava;

import java.io.Serializable;

/* compiled from: acorn_weather_content_settings_suggestions */
public abstract class Optional<T> implements Serializable {
    public abstract boolean mo939a();

    public abstract T mo940b();

    public static <T> Optional<T> m22419c() {
        return Absent.f21482a;
    }

    public static <T> Optional<T> m22417a(T t) {
        return new Present(Preconditions.m22424a(t));
    }

    public static <T> Optional<T> m22418b(T t) {
        return t == null ? Absent.f21482a : new Present(t);
    }

    Optional() {
    }
}
