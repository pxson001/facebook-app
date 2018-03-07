package com.facebook.saved.viewport;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.saved.controller.SavedDataAndListStateController;
import com.facebook.saved.helper.SavedSectionHelper;

/* compiled from: instant_shopping_perf_event */
public class SavedItemsVpvLoggerProvider extends AbstractAssistedProvider<SavedItemsVpvLogger> {
    public final SavedItemsVpvLogger m9493a(SavedDataAndListStateController savedDataAndListStateController) {
        return new SavedItemsVpvLogger(savedDataAndListStateController, SaveAnalyticsLogger.a(this), SavedSectionHelper.m9180a((InjectorLike) this), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
