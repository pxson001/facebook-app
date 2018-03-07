package com.facebook.messaging.customthreads;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: media_picker_last_open_timestamp */
public class CustomThreadThemeBuilder {
    public int f10239a;
    public int f10240b;
    public int f10241c;
    public int f10242d;
    public int f10243e;

    CustomThreadThemeBuilder() {
    }

    public final CustomThreadThemeBuilder m10852b(int i) {
        this.f10240b = i;
        return this;
    }

    public final CustomThreadThemeBuilder m10853d(int i) {
        this.f10242d = i;
        return this;
    }

    public final CustomThreadTheme m10854f() {
        return new CustomThreadTheme(this);
    }
}
