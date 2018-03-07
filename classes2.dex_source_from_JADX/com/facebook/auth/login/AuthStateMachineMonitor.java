package com.facebook.auth.login;

import android.content.Intent;
import com.facebook.auth.event.AuthEventBus;
import com.facebook.auth.event.AuthLoggedInEvent;
import com.facebook.auth.event.AuthLoggedOutEvent;
import com.facebook.common.android.FbLocalBroadcastManager;

/* compiled from: shareable_id */
public class AuthStateMachineMonitor {
    public final FbLocalBroadcastManager f4972a;
    protected final AuthEventBus f4973b;

    public AuthStateMachineMonitor(FbLocalBroadcastManager fbLocalBroadcastManager, AuthEventBus authEventBus) {
        this.f4972a = fbLocalBroadcastManager;
        this.f4973b = authEventBus;
    }

    public final void m8890a() {
        this.f4972a.m2969a(new Intent("com.facebook.orca.login.AuthStateMachineMonitor.AUTH_COMPLETE"));
        this.f4973b.mo651a(new AuthLoggedInEvent());
    }

    public final void m8891b() {
        this.f4972a.m2969a(new Intent("com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE"));
    }

    public final void m8892c() {
        this.f4972a.m2969a(new Intent("com.facebook.orca.login.AuthStateMachineMonitor.LOGOUT_COMPLETE"));
        this.f4973b.mo651a(new AuthLoggedOutEvent());
    }
}
