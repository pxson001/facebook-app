package com.facebook.common.activitycleaner;

/* compiled from: isCu */
class ActivityCleaner$2 implements Runnable {
    final /* synthetic */ int f10677a;
    final /* synthetic */ ActivityCleaner f10678b;

    ActivityCleaner$2(ActivityCleaner activityCleaner, int i) {
        this.f10678b = activityCleaner;
        this.f10677a = i;
    }

    public void run() {
        ActivityCleaner.a(this.f10678b, this.f10677a, null);
    }
}
