package com.facebook.goodwill.dailydialogue.adapter;

/* compiled from: fetch_composer_in_tnv2_search_results */
class DailyDialogueInjectedFeedAdapter$5 implements Runnable {
    final /* synthetic */ DailyDialogueInjectedFeedAdapter f13434a;

    DailyDialogueInjectedFeedAdapter$5(DailyDialogueInjectedFeedAdapter dailyDialogueInjectedFeedAdapter) {
        this.f13434a = dailyDialogueInjectedFeedAdapter;
    }

    public void run() {
        if (this.f13434a.q) {
            this.f13434a.p = true;
            this.f13434a.i.a(new DailyDialogueInjectedFeedAdapter$ViewedMutationCallback(), this.f13434a.u);
        }
    }
}
