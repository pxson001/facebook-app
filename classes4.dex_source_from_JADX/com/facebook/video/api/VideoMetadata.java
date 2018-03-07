package com.facebook.video.api;

/* compiled from: pa_href */
public class VideoMetadata {
    public final int f5580a;
    public final int f5581b;
    public final int f5582c;
    public final String f5583d;
    public final String f5584e;
    public final String f5585f;
    public String f5586g;

    public VideoMetadata(int i, int i2, int i3, String str, String str2, String str3, String str4) {
        this.f5580a = i;
        this.f5581b = i2;
        this.f5582c = i3;
        this.f5583d = str;
        this.f5584e = str2;
        this.f5585f = str3;
        this.f5586g = str4;
    }

    public VideoMetadata(int i, int i2, int i3, String str, String str2) {
        this.f5580a = i;
        this.f5581b = i2;
        this.f5582c = i3;
        this.f5583d = str;
        this.f5584e = str2;
        this.f5585f = "";
        this.f5586g = "";
    }

    public final String m5999a() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.f5583d != null) {
            stringBuilder.append(this.f5583d);
        }
        if (this.f5584e != null) {
            stringBuilder.append('/').append(this.f5584e);
        }
        return stringBuilder.toString();
    }

    public final void m6000a(String str) {
        this.f5586g = str;
    }
}
