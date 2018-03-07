package com.facebook.messaging.customthreads;

/* compiled from: media_picker_next_open_timestamp */
public class CustomThreadTheme {
    public final int f10234a;
    public final int f10235b;
    public final int f10236c;
    private final int f10237d;
    private final int f10238e;

    public static CustomThreadThemeBuilder newBuilder() {
        return new CustomThreadThemeBuilder();
    }

    public CustomThreadTheme(CustomThreadThemeBuilder customThreadThemeBuilder) {
        this.f10234a = customThreadThemeBuilder.f10239a;
        this.f10235b = customThreadThemeBuilder.f10240b;
        this.f10236c = customThreadThemeBuilder.f10241c;
        this.f10237d = customThreadThemeBuilder.f10242d;
        this.f10238e = customThreadThemeBuilder.f10243e;
    }

    public final int m10851d() {
        if (this.f10238e != 0) {
            return this.f10238e;
        }
        return this.f10237d;
    }
}
