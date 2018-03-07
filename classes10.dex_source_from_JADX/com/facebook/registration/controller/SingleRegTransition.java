package com.facebook.registration.controller;

import android.content.Intent;
import com.facebook.base.fragment.FragmentActionBuilder;
import com.facebook.registration.fragment.RegistrationFragment;

/* compiled from: lat_lon */
public class SingleRegTransition implements RegTransition {
    private Class<? extends RegistrationFragment> f8750a;
    public boolean f8751b = false;
    public boolean f8752c = false;
    public int f8753d = 2130968721;
    private int f8754e = 2130968722;
    private int f8755f = 2130968721;
    private int f8756g = 2130968722;

    public SingleRegTransition(Class<? extends RegistrationFragment> cls) {
        this.f8750a = cls;
    }

    public final SingleRegTransition m8756b() {
        this.f8751b = true;
        return this;
    }

    public final SingleRegTransition m8757c() {
        this.f8752c = true;
        return this;
    }

    public final Intent mo380a() {
        FragmentActionBuilder fragmentActionBuilder = new FragmentActionBuilder(this.f8750a);
        if (this.f8751b) {
            fragmentActionBuilder.a();
        }
        if (this.f8752c) {
            fragmentActionBuilder.b();
        }
        fragmentActionBuilder.a(this.f8753d, this.f8754e, this.f8755f, this.f8756g);
        return fragmentActionBuilder.a;
    }
}
