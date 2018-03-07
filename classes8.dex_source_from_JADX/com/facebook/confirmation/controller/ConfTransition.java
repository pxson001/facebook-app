package com.facebook.confirmation.controller;

import android.content.Intent;
import com.facebook.base.fragment.FragmentActionBuilder;
import com.facebook.confirmation.fragment.ConfInputFragment;

/* compiled from: invalid_chars */
public class ConfTransition {
    private Class<? extends ConfInputFragment> f10718a;
    public boolean f10719b = false;
    public boolean f10720c = false;

    public ConfTransition(Class<? extends ConfInputFragment> cls) {
        this.f10718a = cls;
    }

    public final ConfTransition m12642a() {
        this.f10719b = true;
        return this;
    }

    public final ConfTransition m12643b() {
        this.f10720c = true;
        return this;
    }

    public final Intent m12644c() {
        FragmentActionBuilder fragmentActionBuilder = new FragmentActionBuilder(this.f10718a);
        if (this.f10719b) {
            fragmentActionBuilder.a();
        }
        if (this.f10720c) {
            fragmentActionBuilder.b();
        }
        return fragmentActionBuilder.a;
    }
}
