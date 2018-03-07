package com.facebook.common.appchoreographer;

/* compiled from: west */
class ActivityChoreographerImpl$1 implements Runnable {
    final /* synthetic */ Class f106a;
    final /* synthetic */ ActivityChoreographerImpl f107b;

    ActivityChoreographerImpl$1(ActivityChoreographerImpl activityChoreographerImpl, Class cls) {
        this.f107b = activityChoreographerImpl;
        this.f106a = cls;
    }

    public void run() {
        this.f107b.g = null;
        this.f107b.b(this.f106a);
    }
}
