package com.facebook.ipc.composer.plugin;

import javax.annotation.Nullable;

/* compiled from: unknown view =  */
public class ComposerPlugin$InstanceState {
    public static final ComposerPlugin$InstanceState f1137a = new ComposerPlugin$InstanceState(null);
    @Nullable
    public String f1138b;

    public static ComposerPlugin$InstanceState m1366a(@Nullable String str) {
        return str == null ? f1137a : new ComposerPlugin$InstanceState(str);
    }

    private ComposerPlugin$InstanceState(@Nullable String str) {
        this.f1138b = str;
    }

    @Nullable
    public final String m1367a() {
        return this.f1138b;
    }
}
