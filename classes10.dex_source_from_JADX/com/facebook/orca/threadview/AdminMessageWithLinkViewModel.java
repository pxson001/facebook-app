package com.facebook.orca.threadview;

import android.graphics.drawable.Drawable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mu */
public final class AdminMessageWithLinkViewModel {
    public final boolean f6849a;
    public final Drawable f6850b;
    public final int f6851c;
    public final String f6852d;
    public final String f6853e;

    /* compiled from: mu */
    public class Builder {
        public boolean f6844a;
        public Drawable f6845b;
        public int f6846c;
        public String f6847d;
        public String f6848e;

        public final AdminMessageWithLinkViewModel m6500a() {
            return new AdminMessageWithLinkViewModel(this);
        }
    }

    public AdminMessageWithLinkViewModel(Builder builder) {
        this.f6849a = builder.f6844a;
        this.f6850b = builder.f6845b;
        this.f6851c = builder.f6846c;
        this.f6852d = builder.f6847d;
        this.f6853e = builder.f6848e;
    }
}
