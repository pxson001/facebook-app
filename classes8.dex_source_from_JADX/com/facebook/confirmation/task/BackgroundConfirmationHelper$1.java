package com.facebook.confirmation.task;

import com.facebook.confirmation.util.SmsConfirmationReaderExperimental;

/* compiled from: instant_article_activity_json */
public class BackgroundConfirmationHelper$1 implements Runnable {
    final /* synthetic */ BackgroundConfirmationHelper f10795a;

    public BackgroundConfirmationHelper$1(BackgroundConfirmationHelper backgroundConfirmationHelper) {
        this.f10795a = backgroundConfirmationHelper;
    }

    public void run() {
        this.f10795a.a(((SmsConfirmationReaderExperimental) this.f10795a.g.get()).a());
    }
}
