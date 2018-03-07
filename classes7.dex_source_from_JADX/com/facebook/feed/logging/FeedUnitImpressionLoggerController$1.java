package com.facebook.feed.logging;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.google.common.collect.ImmutableList;

/* compiled from: android.intent.action.PACKAGE_REPLACED */
class FeedUnitImpressionLoggerController$1 implements Runnable {
    final /* synthetic */ ImmutableList f19341a;
    final /* synthetic */ FeedUnitImpressionLoggerController f19342b;

    FeedUnitImpressionLoggerController$1(FeedUnitImpressionLoggerController feedUnitImpressionLoggerController, ImmutableList immutableList) {
        this.f19342b = feedUnitImpressionLoggerController;
        this.f19341a = immutableList;
    }

    public void run() {
        this.f19342b.d.c(new HoneyClientEvent("viewport_waterfall").b("par", FeedUnitImpressionLoggerController.a(this.f19342b, this.f19341a)));
    }
}
