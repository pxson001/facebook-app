package com.facebook.composer.privacy.common;

import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateBase.AnalyticsCallback;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateBase.DataProvider;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.model.PrivacyOptionsResult;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.model.SelectablePrivacyData.Builder;
import com.facebook.privacy.service.PrivacyAnalyticsLogger;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: tapped_public_photos */
public final class ComposerWidestAudiencePrivacyDelegate extends ComposerSelectablePrivacyDelegateBase {
    @Inject
    public ComposerWidestAudiencePrivacyDelegate(@Assisted PrivacyUpdatedHandler privacyUpdatedHandler, FbErrorReporter fbErrorReporter, TasksManager tasksManager, PrivacyOperationsClient privacyOperationsClient, Lazy<PrivacyAnalyticsLogger> lazy, @Assisted AnalyticsCallback analyticsCallback, @Assisted GraphQLPrivacyOption graphQLPrivacyOption, @Assisted DataProvider dataProvider) {
        super(privacyUpdatedHandler, analyticsCallback, graphQLPrivacyOption, dataProvider, fbErrorReporter, tasksManager, privacyOperationsClient, lazy);
    }

    protected final SelectablePrivacyData mo93a(ComposerPrivacyData composerPrivacyData, PrivacyOptionsResult privacyOptionsResult) {
        Builder builder = new Builder(composerPrivacyData.f2001b);
        builder.a = privacyOptionsResult;
        builder = builder;
        builder.b = builder.a.a();
        return builder.b();
    }
}
