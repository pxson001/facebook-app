package com.facebook.attachments.angora.actionbutton;

import com.facebook.api.feed.service.GraphPostService;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.google.common.collect.ImmutableList;

/* compiled from: userLongitude */
public class SavedOfflineSnackbarActionControllerProvider extends AbstractAssistedProvider<SavedOfflineSnackbarActionController> {
    public final SavedOfflineSnackbarActionController m882a(String str, String str2, String str3, ImmutableList<String> immutableList, String str4) {
        return new SavedOfflineSnackbarActionController(str, str2, str3, immutableList, str4, SaveAnalyticsLogger.a(this), GraphPostService.b(this));
    }
}
