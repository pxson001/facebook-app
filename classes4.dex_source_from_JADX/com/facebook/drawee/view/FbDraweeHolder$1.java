package com.facebook.drawee.view;

import com.facebook.drawee.components.DraweeEventTracker.Event;

/* compiled from: qe_group_contacts */
public class FbDraweeHolder$1 implements Runnable {
    final /* synthetic */ FbDraweeHolder f3952a;

    public FbDraweeHolder$1(FbDraweeHolder fbDraweeHolder) {
        this.f3952a = fbDraweeHolder;
    }

    public void run() {
        this.f3952a.g.a(Event.ON_RUN_CLEAR_CONTROLLER);
        this.f3952a.a(null);
        this.f3952a.d = false;
    }
}
