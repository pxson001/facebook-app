package com.facebook.maps.delegate;

import com.facebook.android.maps.model.Circle;

/* compiled from: vnd.android.cursor.item/vnd.com.whatsapp.profile */
public class CircleDelegate {
    public final Circle f355a;
    public final com.google.android.gms.maps.model.Circle f356b;

    public CircleDelegate(Circle circle) {
        this.f355a = circle;
        this.f356b = null;
    }

    public CircleDelegate(com.google.android.gms.maps.model.Circle circle) {
        this.f356b = circle;
        this.f355a = null;
    }

    public final void m300a(boolean z) {
        if (this.f355a != null) {
            this.f355a.a(z);
        } else {
            this.f356b.m9654a(z);
        }
    }
}
