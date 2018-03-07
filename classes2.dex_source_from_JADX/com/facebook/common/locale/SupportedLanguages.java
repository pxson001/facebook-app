package com.facebook.common.locale;

import com.google.common.collect.ImmutableSet;

/* compiled from: valid_file */
public abstract class SupportedLanguages {

    /* compiled from: valid_file */
    public enum Type {
        ASSET,
        DOWNLOAD
    }

    public abstract ImmutableSet<String> mo364a();

    public abstract ImmutableSet<String> mo365a(Type type);
}
