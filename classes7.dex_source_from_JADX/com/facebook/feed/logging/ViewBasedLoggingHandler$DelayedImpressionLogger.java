package com.facebook.feed.logging;

import com.facebook.graphql.model.BaseImpression;
import com.facebook.graphql.model.Sponsorable;

/* compiled from: android.intent.action.CONFIGURATION_CHANGED */
class ViewBasedLoggingHandler$DelayedImpressionLogger implements Runnable {
    final /* synthetic */ ViewBasedLoggingHandler f19365a;
    private Sponsorable f19366b;
    private BaseImpression f19367c;

    public ViewBasedLoggingHandler$DelayedImpressionLogger(ViewBasedLoggingHandler viewBasedLoggingHandler, Sponsorable sponsorable, BaseImpression baseImpression) {
        this.f19365a = viewBasedLoggingHandler;
        this.f19366b = sponsorable;
        this.f19367c = baseImpression;
    }

    public void run() {
        ViewBasedLoggingHandler.a(this.f19365a, this.f19366b, this.f19367c);
        this.f19365a.q.remove(this.f19366b.g());
    }
}
