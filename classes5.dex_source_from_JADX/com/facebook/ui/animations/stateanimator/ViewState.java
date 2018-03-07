package com.facebook.ui.animations.stateanimator;

import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.view.View;

/* compiled from: community_page_app_link */
public class ViewState {
    float f5420a;
    float f5421b;
    float f5422c;
    float f5423d;
    float f5424e;
    float f5425f;

    /* compiled from: community_page_app_link */
    public class Builder {
        int[] f5411a;
        public float f5412b;
        public float f5413c;
        public float f5414d;
        float f5415e;
        float f5416f;
        float f5417g;
        Resources f5418h;
        public com.facebook.ui.animations.stateanimator.AnimatedView.Builder f5419i;

        Builder(com.facebook.ui.animations.stateanimator.AnimatedView.Builder builder, View view, int[] iArr) {
            this.f5418h = view.getResources();
            this.f5412b = ViewCompat.f(view);
            this.f5413c = ViewCompat.p(view);
            this.f5414d = ViewCompat.q(view);
            this.f5415e = ViewCompat.v(view);
            this.f5416f = ViewCompat.a.t(view);
            this.f5417g = ViewCompat.a.r(view);
            this.f5411a = iArr;
            this.f5419i = builder;
        }

        public final com.facebook.ui.animations.stateanimator.AnimatedView.Builder m10308a(View view) {
            m10310b();
            return this.f5419i.m10296a(view);
        }

        public final Builder m10309a(int... iArr) {
            m10310b();
            return this.f5419i.m10298a(iArr);
        }

        public final void m10310b() {
            this.f5419i.m10299a(this.f5411a, new ViewState(this));
        }
    }

    public ViewState(Builder builder) {
        this.f5420a = builder.f5412b;
        this.f5421b = builder.f5413c;
        this.f5422c = builder.f5414d;
        this.f5423d = builder.f5415e;
        this.f5424e = builder.f5416f;
        this.f5425f = builder.f5417g;
    }
}
