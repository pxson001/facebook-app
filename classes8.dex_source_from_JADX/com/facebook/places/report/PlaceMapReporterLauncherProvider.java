package com.facebook.places.report;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.places.suggestions.PlaceSuggestionsIntentBuilder;

/* compiled from: sections */
public class PlaceMapReporterLauncherProvider extends AbstractAssistedProvider<PlaceMapReporterLauncher> {
    public final PlaceMapReporterLauncher m3551a(Long l, String str, String str2) {
        return new PlaceMapReporterLauncher(l, str, str2, (Context) getInstance(Context.class), (ZeroDialogController) FbZeroDialogController.b(this), AnalyticsLoggerMethodAutoProvider.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), PlaceSuggestionsIntentBuilder.m3589a(this));
    }
}
