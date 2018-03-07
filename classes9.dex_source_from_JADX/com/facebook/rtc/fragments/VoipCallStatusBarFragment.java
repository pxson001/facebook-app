package com.facebook.rtc.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rtc.fbwebrtc.VoipStatusHandler;

/* compiled from: application/vnd.wv.csp+xml */
public class VoipCallStatusBarFragment extends FbFragment {
    public Lazy<VoipStatusHandler> f19708a;
    private BaseFbBroadcastManager f19709b;
    private SelfRegistrableReceiverImpl f19710c;
    private ViewStub f19711d;
    private TextView f19712e;
    public boolean f19713f = false;

    /* compiled from: application/vnd.wv.csp+xml */
    class C23191 implements ActionReceiver {
        final /* synthetic */ VoipCallStatusBarFragment f19706a;

        C23191(VoipCallStatusBarFragment voipCallStatusBarFragment) {
            this.f19706a = voipCallStatusBarFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 957858260);
            this.f19706a.f19713f = true;
            VoipCallStatusBarFragment.m19515e(this.f19706a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1110332075, a);
        }
    }

    /* compiled from: application/vnd.wv.csp+xml */
    class C23202 implements OnClickListener {
        final /* synthetic */ VoipCallStatusBarFragment f19707a;

        C23202(VoipCallStatusBarFragment voipCallStatusBarFragment) {
            this.f19707a = voipCallStatusBarFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1755649446);
            ((VoipStatusHandler) this.f19707a.f19708a.get()).m19366c();
            Logger.a(2, EntryType.UI_INPUT_END, 1086551001, a);
        }
    }

    public final void m19517c(Bundle bundle) {
        super.c(bundle);
        FbInjector an = an();
        this.f19708a = IdBasedLazy.a(an, 10371);
        this.f19709b = (BaseFbBroadcastManager) LocalFbBroadcastManager.a(an);
        this.f19710c = this.f19709b.a().a("com.facebook.rtc.fbwebrtc.CALL_STATUS_AND_DURATION_UPDATE", new C23191(this)).a();
    }

    public final View m19516a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1069288161);
        this.f19711d = (ViewStub) layoutInflater.inflate(2130907743, viewGroup, false);
        this.f19712e = null;
        View view = this.f19711d;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1460356657, a);
        return view;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 177099669);
        super.mi_();
        this.f19710c.b();
        if (this.f19713f) {
            m19515e(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 959784418, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1117924943);
        super.mj_();
        this.f19710c.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1198959672, a);
    }

    private void m19514b() {
        if (this.f19712e == null) {
            this.f19711d.inflate();
            this.f19712e = (TextView) e(2131568448);
            this.f19712e.setOnClickListener(new C23202(this));
        }
    }

    public static void m19515e(VoipCallStatusBarFragment voipCallStatusBarFragment) {
        voipCallStatusBarFragment.m19514b();
        if (((VoipStatusHandler) voipCallStatusBarFragment.f19708a.get()).m19364a()) {
            voipCallStatusBarFragment.f19712e.setVisibility(0);
            voipCallStatusBarFragment.f19712e.setText(((VoipStatusHandler) voipCallStatusBarFragment.f19708a.get()).m19365b());
            return;
        }
        voipCallStatusBarFragment.f19712e.setVisibility(8);
    }
}
