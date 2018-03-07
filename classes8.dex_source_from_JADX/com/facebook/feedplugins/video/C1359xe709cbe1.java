package com.facebook.feedplugins.video;

import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition.RichVideoAutoplayTransitionManager;
import com.facebook.graphql.model.FeedUnit;

/* compiled from: for_sale */
class C1359xe709cbe1 implements Runnable {
    final /* synthetic */ RichVideoAutoplayTransitionManager f13086a;

    C1359xe709cbe1(RichVideoAutoplayTransitionManager richVideoAutoplayTransitionManager) {
        this.f13086a = richVideoAutoplayTransitionManager;
    }

    public void run() {
        this.f13086a.b.a((FeedUnit) this.f13086a.c.c.a, this.f13086a.a, Boolean.valueOf(true));
    }
}
