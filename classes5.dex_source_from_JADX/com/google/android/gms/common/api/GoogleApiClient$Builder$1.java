package com.google.android.gms.common.api;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.internal.zzmr;

class GoogleApiClient$Builder$1 implements Runnable {
    final /* synthetic */ GoogleApiClient f6455a;
    final /* synthetic */ Builder f6456b;

    GoogleApiClient$Builder$1(Builder builder, GoogleApiClient googleApiClient) {
        this.f6456b = builder;
        this.f6455a = googleApiClient;
    }

    public void run() {
        if (!this.f6456b.k.isFinishing() && !this.f6456b.k.kO_().g()) {
            Builder builder = this.f6456b;
            FragmentActivity fragmentActivity = this.f6456b.k;
            zzmr a = zzmr.m12864a(fragmentActivity);
            FragmentManager kO_ = fragmentActivity.kO_();
            if (a == null) {
                a = new zzmr();
                kO_.a().a(a, "GmsSupportLifecycleFrag").c();
                kO_.b();
            }
            Builder.a(builder, a, this.f6455a);
        }
    }
}
