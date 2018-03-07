package com.facebook.ipc.composer.intent;

import com.google.common.base.Preconditions;

/* compiled from: linkForShare */
public class EmptyPluginConfig implements ComposerPluginConfig {
    private final String f11581a;

    private EmptyPluginConfig(String str) {
        this.f11581a = str;
    }

    public static EmptyPluginConfig m18272a(String str) {
        return new EmptyPluginConfig((String) Preconditions.checkNotNull(str));
    }

    public final String mo1081b() {
        return this.f11581a;
    }

    public final void mo1080a() {
    }
}
