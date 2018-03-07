package com.facebook.feed.fragment;

/* compiled from: group_tag_suggestion_clicked */
public class NewsFeedFragmentDataController$2 implements Runnable {
    final /* synthetic */ NewsFeedFragmentDataController f11872a;

    public NewsFeedFragmentDataController$2(NewsFeedFragmentDataController newsFeedFragmentDataController) {
        this.f11872a = newsFeedFragmentDataController;
    }

    public void run() {
        if (this.f11872a.e != null) {
            int a = this.f11872a.c.a(this.f11872a.e);
            int min = Math.min(this.f11872a.c.t() - 1, a + 1);
            for (int i = a; i <= min && !NewsFeedFragmentDataController.b(this.f11872a, a); i++) {
            }
        }
        NewsFeedFragmentDataController.a(this.f11872a, false);
    }
}
