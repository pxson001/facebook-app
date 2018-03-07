package com.facebook.composer.event;

/* compiled from: place_phone_number */
public class ComposerEventOriginator {
    public final String f7818a;

    private ComposerEventOriginator(Class cls) {
        this.f7818a = cls.getSimpleName();
    }

    public static ComposerEventOriginator m11262a(Class cls) {
        return new ComposerEventOriginator(cls);
    }
}
