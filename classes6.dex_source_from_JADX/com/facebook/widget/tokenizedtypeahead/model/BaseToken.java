package com.facebook.widget.tokenizedtypeahead.model;

import android.graphics.Bitmap;

/* compiled from: feedbackParams */
public abstract class BaseToken<T> extends Token {
    public final Type f15080a;

    /* compiled from: feedbackParams */
    public enum Type {
        PRIVACY,
        USER,
        FRIENDLIST,
        LOADING,
        SIMPLE,
        SUGGESTION,
        TAG_EXPANSION,
        FULL_CUSTOM,
        FRIENDS_EXCEPT,
        SPECIFIC_FRIENDS,
        INVITE,
        FOLDER,
        GROUP_TAG
    }

    public abstract T mo1186d();

    public abstract int mo1187e();

    public abstract int mo1188f();

    public abstract int mo1189g();

    public abstract int mo1190h();

    public abstract String mo1191i();

    public BaseToken(Type type) {
        this.f15080a = type;
    }

    public Bitmap m22648j() {
        return null;
    }

    public boolean mo1524k() {
        return true;
    }

    public String mo1192l() {
        return null;
    }

    public boolean m22651m() {
        return false;
    }

    public int m22652n() {
        return -1;
    }
}
