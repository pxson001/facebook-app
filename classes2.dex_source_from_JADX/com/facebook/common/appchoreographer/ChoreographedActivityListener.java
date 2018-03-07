package com.facebook.common.appchoreographer;

import android.app.Activity;
import javax.inject.Inject;

/* compiled from: quick_promotion_image_size_param */
public class ChoreographedActivityListener {
    private boolean f8349a;
    private final ActivityChoreographerImpl f8350b;

    @Inject
    public ChoreographedActivityListener(ActivityChoreographerImpl activityChoreographerImpl) {
        this.f8350b = activityChoreographerImpl;
    }

    public final void m12862a(Activity activity) {
        m12861c(activity);
    }

    public final void m12863b(Activity activity) {
        m12861c(activity);
    }

    private void m12861c(Activity activity) {
        if (!this.f8349a) {
            this.f8350b.m12868b(activity.getClass());
            this.f8349a = true;
        }
    }
}
