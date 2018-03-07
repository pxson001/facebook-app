package com.facebook.common.ui.util;

import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: short_category_names */
public class ViewOrientationLockHelperProvider extends AbstractAssistedProvider<ViewOrientationLockHelper> {
    public final ViewOrientationLockHelper m3883a(View view) {
        return new ViewOrientationLockHelper(view, BetterRotationManager.m3862b(this), AnalyticsLoggerMethodAutoProvider.a(this));
    }
}
