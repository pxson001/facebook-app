package com.facebook.backstage.data;

import android.graphics.Bitmap;
import java.util.Date;

/* compiled from: responsiveness_context */
public class LocalShot {
    public Date f5125a = new Date();
    public MediaType f5126b;
    public Bitmap f5127c;
    public String f5128d;
    public String f5129e;
    public int f5130f;
    public boolean f5131g;
    public String f5132h;
    private int f5133i;
    private float f5134j;

    /* compiled from: responsiveness_context */
    public enum MediaType {
        PHOTO,
        VIDEO
    }

    public LocalShot(MediaType mediaType, Bitmap bitmap, String str, int i, int i2, boolean z, float f) {
        this.f5126b = mediaType;
        this.f5127c = bitmap;
        this.f5128d = str;
        this.f5130f = i;
        this.f5131g = z;
        this.f5132h = "";
        this.f5133i = i2;
        this.f5134j = f;
    }

    public final void m4905a(Bitmap bitmap) {
        this.f5127c = bitmap;
    }

    public final int m4904a() {
        return this.f5133i;
    }

    public final void m4906a(String str) {
        this.f5129e = str;
    }

    public final Bitmap m4907d() {
        return this.f5127c;
    }

    public final String m4908e() {
        return this.f5128d;
    }

    public final int m4909g() {
        return this.f5130f;
    }

    public final boolean m4910h() {
        return this.f5131g;
    }

    public final boolean m4911i() {
        return this.f5126b == MediaType.PHOTO;
    }

    public final float m4912k() {
        return this.f5134j;
    }
}
