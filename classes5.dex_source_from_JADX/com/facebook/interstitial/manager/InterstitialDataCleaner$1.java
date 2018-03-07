package com.facebook.interstitial.manager;

/* compiled from: TOPIC_EVENT_PLANNING */
class InterstitialDataCleaner$1 implements Runnable {
    final /* synthetic */ InterstitialDataCleaner f13866a;

    InterstitialDataCleaner$1(InterstitialDataCleaner interstitialDataCleaner) {
        this.f13866a = interstitialDataCleaner;
    }

    public void run() {
        this.f13866a.c.clearUserData();
    }
}
