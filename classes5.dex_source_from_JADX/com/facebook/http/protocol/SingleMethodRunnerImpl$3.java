package com.facebook.http.protocol;

import com.facebook.http.entity.mime.ContentSerializationListener;

/* compiled from: dialtone_mode_selection_interstitial_become_invisible */
class SingleMethodRunnerImpl$3 implements ContentSerializationListener {
    final /* synthetic */ ApiMethodProgressListener f5092a;
    final /* synthetic */ long f5093b;
    final /* synthetic */ SingleMethodRunnerImpl f5094c;

    SingleMethodRunnerImpl$3(SingleMethodRunnerImpl singleMethodRunnerImpl, ApiMethodProgressListener apiMethodProgressListener, long j) {
        this.f5094c = singleMethodRunnerImpl;
        this.f5092a = apiMethodProgressListener;
        this.f5093b = j;
    }

    public final void mo620a(long j) {
        this.f5092a.m9982a(j, this.f5093b);
    }
}
