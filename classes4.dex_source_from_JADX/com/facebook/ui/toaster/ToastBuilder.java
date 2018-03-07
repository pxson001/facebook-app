package com.facebook.ui.toaster;

/* compiled from: tracking_notification_type */
public class ToastBuilder {
    public CharSequence f766a;
    public int f767b;
    public int f768c;
    public Object[] f769d;
    public String f770e;
    public String f771f;
    public String f772g;
    public boolean f773h = false;

    public ToastBuilder(CharSequence charSequence) {
        this.f766a = charSequence;
    }

    public ToastBuilder(int i) {
        this.f768c = i;
    }

    public ToastBuilder(int i, Object... objArr) {
        this.f768c = i;
        this.f769d = objArr;
    }

    public final ToastBuilder m1119a(int i) {
        this.f767b = i;
        return this;
    }

    public final ToastBuilder m1120a(String str) {
        this.f772g = str;
        return this;
    }

    public final ToastBuilder m1118a() {
        this.f773h = true;
        return this;
    }
}
