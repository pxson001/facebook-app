package com.facebook.http.protocol;

import com.facebook.http.entity.mime.ContentSerializationListener;

/* compiled from: dialtone_mode_selection_interstitial_become_invisible */
class SingleMethodRunnerImpl$2 implements ContentSerializationListener {
    final /* synthetic */ ApiMethodProgressListener f5088a;
    final /* synthetic */ int f5089b;
    final /* synthetic */ long f5090c;
    final /* synthetic */ SingleMethodRunnerImpl f5091d;

    SingleMethodRunnerImpl$2(SingleMethodRunnerImpl singleMethodRunnerImpl, ApiMethodProgressListener apiMethodProgressListener, int i, long j) {
        this.f5091d = singleMethodRunnerImpl;
        this.f5088a = apiMethodProgressListener;
        this.f5089b = i;
        this.f5090c = j;
    }

    public final void mo620a(long j) {
        this.f5088a.m9982a(((long) this.f5089b) + j, this.f5090c);
    }
}
