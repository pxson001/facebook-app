package com.facebook.http.protocol;

import com.facebook.http.entity.mime.ContentSerializationListener;

/* compiled from: dialtone_mode_selection_interstitial_become_invisible */
class SingleMethodRunnerImpl$1 implements ContentSerializationListener {
    final /* synthetic */ ApiMethodProgressListener f5086a;
    final /* synthetic */ SingleMethodRunnerImpl f5087b;

    SingleMethodRunnerImpl$1(SingleMethodRunnerImpl singleMethodRunnerImpl, ApiMethodProgressListener apiMethodProgressListener) {
        this.f5087b = singleMethodRunnerImpl;
        this.f5086a = apiMethodProgressListener;
    }

    public final void mo620a(long j) {
        this.f5086a.m9982a(j, j);
    }
}
