package com.facebook.composer.location;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.analytics.ComposerLocationProductsPresenterLogger;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.location.ComposerLocationProductsPresenter.Listener;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCheckinSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.places.checkin.protocol.CheckinLocationCache;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tagging.conversion.FriendSuggestionsRunner;

/* compiled from: fundraiser_campaign_fragment_default_amount_not_in_list */
public class ComposerLocationProductsPresenterProvider extends AbstractAssistedProvider<ComposerLocationProductsPresenter> {
    public final <DataProvider extends ProvidesAttachments & ProvidesIsCheckinSupported & ProvidesSessionId & ProvidesConfiguration & ProvidesLocationInfo> ComposerLocationProductsPresenter<DataProvider> m8104a(DataProvider dataProvider, Listener listener) {
        return new ComposerLocationProductsPresenter((ProvidesAttachments) dataProvider, listener, CheckinLocationCache.a(this), FbLocationStatusUtil.a(this), FriendSuggestionsRunner.b(this), new ComposerLocationProductsPresenterLogger(AnalyticsLoggerMethodAutoProvider.a(this), (Clock) SystemClockMethodAutoProvider.a(this)), IdBasedLazy.a(this, 9529), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), IdBasedLazy.a(this, 5194));
    }
}
