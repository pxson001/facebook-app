package com.facebook.base.fragment;

import android.content.Intent;

/* compiled from: subtitle_text */
public class FragmentActionBuilder {
    public final Intent f2443a;

    public FragmentActionBuilder(Class<? extends NavigableFragment> cls) {
        this.f2443a = new Intent("com.facebook.fragment.FRAGMENT_ACTION").setClassName(cls.getPackage().getName(), cls.getName());
    }

    public final FragmentActionBuilder m3541a() {
        this.f2443a.putExtra("com.facebook.fragment.PUSH_BACK_STACK", true);
        return this;
    }

    public final FragmentActionBuilder m3543b() {
        this.f2443a.putExtra("com.facebook.fragment.CLEAR_BACK_STACK", true);
        return this;
    }

    public final FragmentActionBuilder m3542a(int i, int i2, int i3, int i4) {
        this.f2443a.putExtra("com.facebook.fragment.ENTER_ANIM", i);
        this.f2443a.putExtra("com.facebook.fragment.EXIT_ANIM", i2);
        this.f2443a.putExtra("com.facebook.fragment.POP_ENTER_ANIM", i3);
        this.f2443a.putExtra("com.facebook.fragment.POP_EXIT_ANIM", i4);
        return this;
    }
}
