package com.facebook.backstage.consumption.camera;

import javax.annotation.Nullable;

/* compiled from: root_type */
public class CameraOptions {
    public final float f4711a;
    public final Boolean f4712b;
    public final String f4713c;
    public final String f4714d;
    public final boolean f4715e;
    public final boolean f4716f;

    private CameraOptions(float f, @Nullable Boolean bool, @Nullable String str, @Nullable String str2, boolean z, boolean z2) {
        this.f4711a = f;
        this.f4712b = bool;
        this.f4713c = str;
        this.f4714d = str2;
        this.f4715e = z;
        this.f4716f = z2;
    }

    public static CameraOptions m4603a(@Nullable String str, @Nullable String str2) {
        return new CameraOptions(1.0f, Boolean.valueOf(true), str, str2, true, true);
    }

    public static CameraOptions m4602a() {
        return new CameraOptions(1.0f, null, null, null, true, true);
    }

    public static CameraOptions m4605b(@Nullable String str, @Nullable String str2) {
        return new CameraOptions(1.0f, Boolean.valueOf(true), str, str2, false, true);
    }

    public static CameraOptions m4604b() {
        return new CameraOptions(-1.0f, null, null, null, false, false);
    }
}
