package com.facebook.bugreporter;

import com.facebook.bugreporter.RageShakeDetector.ActivityListener;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: suggestedLanguages */
public class ActivityListenerMethodAutoProvider extends AbstractProvider<ActivityListener> {
    public static ActivityListener m6440b(InjectorLike injectorLike) {
        return BugReporterModule.m6462a(RageShakeDetector.m6441a(injectorLike));
    }

    public Object get() {
        return BugReporterModule.m6462a(RageShakeDetector.m6441a(this));
    }
}
