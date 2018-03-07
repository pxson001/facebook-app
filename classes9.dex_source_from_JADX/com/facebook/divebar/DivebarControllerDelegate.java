package com.facebook.divebar;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.activitylistener.ListenableActivity;
import com.facebook.common.android.FbLocalBroadcastManager;
import com.facebook.ui.drawers.DrawerContentFragment;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: pending_tid */
public class DivebarControllerDelegate {
    private final FbLocalBroadcastManager f6711a;
    private final DivebarFragmentInitializer f6712b;
    public final DivebarFragmentInitializer f6713c;
    public final DivebarFragmentInitializer f6714d;
    public final DivebarFragmentInitializer f6715e;

    @Inject
    public DivebarControllerDelegate(FbLocalBroadcastManager fbLocalBroadcastManager, DivebarFragmentInitializer divebarFragmentInitializer, DivebarFragmentInitializer divebarFragmentInitializer2, DivebarFragmentInitializer divebarFragmentInitializer3, DivebarFragmentInitializer divebarFragmentInitializer4) {
        this.f6711a = fbLocalBroadcastManager;
        this.f6712b = divebarFragmentInitializer;
        this.f6713c = divebarFragmentInitializer2;
        this.f6714d = divebarFragmentInitializer3;
        this.f6715e = divebarFragmentInitializer4;
    }

    public final DrawerContentFragment m7004a(Context context) {
        Preconditions.checkNotNull(context);
        return m7002c().mo189a();
    }

    public final void m7006a(DivebarController$DivebarState divebarController$DivebarState) {
        Intent intent = new Intent();
        intent.setAction("com.facebook.orca.common.ui.titlebar.DIVEBAR_STATE_CHANGED");
        intent.putExtra("state", divebarController$DivebarState);
        this.f6711a.a(intent);
    }

    public final void m7007a(boolean z) {
        m7002c().mo191a(z);
    }

    public final void m7005a(ListenableActivity listenableActivity, DrawerBasedDivebarControllerImpl drawerBasedDivebarControllerImpl) {
        m7002c().mo190a(listenableActivity, drawerBasedDivebarControllerImpl);
    }

    protected final int m7003a(Context context, int i) {
        Preconditions.checkNotNull(context);
        if (m7002c().mo193c()) {
            return i;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private DivebarFragmentInitializer m7002c() {
        if (this.f6715e.mo192b()) {
            return this.f6715e;
        }
        if (this.f6714d.mo192b()) {
            return this.f6714d;
        }
        if (this.f6713c.mo192b()) {
            return this.f6713c;
        }
        return this.f6712b;
    }

    public final boolean m7008b() {
        return m7002c().mo194d();
    }
}
