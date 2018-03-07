package com.facebook.widget.tokenizedtypeahead.model;

/* compiled from: feedback_background_sync */
public abstract class Token<LISTENER extends OnTokenClickedListener> {
    public final boolean f15075a;
    public LISTENER f15076b;
    public boolean f15077c;
    public boolean f15078d;
    public boolean f15079e;

    /* compiled from: feedback_background_sync */
    public interface OnTokenClickedListener<TOKEN extends Token> {
        void mo1200a(TOKEN token);
    }

    public abstract String mo1185b();

    public Token() {
        this(false);
    }

    public Token(boolean z) {
        this.f15075a = z;
    }

    public boolean m22639q() {
        return false;
    }

    public boolean mo1195a() {
        return !this.f15079e;
    }

    public final boolean m22640r() {
        return this.f15077c;
    }

    public final boolean m22641s() {
        return this.f15075a;
    }

    public void mo1522a(boolean z) {
        if (this.f15076b != null) {
            this.f15076b.mo1200a(this);
        }
    }
}
