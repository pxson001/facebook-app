package com.facebook.fbui.facepile;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* compiled from: noProfileImageUrls */
public class Face {
    public Uri f9956a;
    public Drawable f9957b;
    public Drawable f9958c;
    public int f9959d;
    public int f9960e;
    public int f9961f;

    public Face() {
        this.f9961f = 255;
    }

    public Face(Uri uri) {
        this(uri, null, 1, 1, 255);
    }

    public Face(Uri uri, Drawable drawable) {
        this(uri, drawable, 1, 1, 255);
    }

    public Face(Uri uri, int i, int i2) {
        this(uri, null, i, i2, 255);
    }

    public Face(Uri uri, Drawable drawable, int i, int i2, int i3) {
        this.f9961f = 255;
        this.f9956a = uri;
        this.f9958c = drawable;
        this.f9960e = i;
        this.f9959d = i2;
        this.f9961f = i3;
    }

    public Face(Drawable drawable) {
        this(drawable, null, 1, 1, 255);
    }

    public Face(Drawable drawable, int i, int i2) {
        this(drawable, null, i, i2, 255);
    }

    private Face(Drawable drawable, Drawable drawable2, int i, int i2, int i3) {
        this.f9961f = 255;
        this.f9957b = drawable.mutate();
        this.f9958c = drawable2;
        this.f9960e = i;
        this.f9959d = i2;
        this.f9961f = i3;
    }
}
