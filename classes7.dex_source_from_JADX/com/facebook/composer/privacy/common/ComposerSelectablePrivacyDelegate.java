package com.facebook.composer.privacy.common;

import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateBase.AnalyticsCallback;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateBase.DataProvider;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.model.PrivacyOptionsResult;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.model.SelectablePrivacyData.Builder;
import com.facebook.privacy.service.PrivacyAnalyticsLogger;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tapped_reviews_context_item */
public final class ComposerSelectablePrivacyDelegate extends ComposerSelectablePrivacyDelegateBase {
    @Inject
    public ComposerSelectablePrivacyDelegate(@Assisted PrivacyUpdatedHandler privacyUpdatedHandler, @Assisted AnalyticsCallback analyticsCallback, @Nullable @Assisted GraphQLPrivacyOption graphQLPrivacyOption, @Assisted DataProvider dataProvider, FbErrorReporter fbErrorReporter, TasksManager tasksManager, PrivacyOperationsClient privacyOperationsClient, Lazy<PrivacyAnalyticsLogger> lazy) {
        super(privacyUpdatedHandler, analyticsCallback, graphQLPrivacyOption, dataProvider, fbErrorReporter, tasksManager, privacyOperationsClient, lazy);
    }

    protected final SelectablePrivacyData mo93a(ComposerPrivacyData composerPrivacyData, PrivacyOptionsResult privacyOptionsResult) {
        Builder builder = new Builder(composerPrivacyData.f2001b);
        builder.a = privacyOptionsResult;
        builder = builder.a(privacyOptionsResult.selectedPrivacyOption);
        builder.c = PrivacyOptionHelper.d(privacyOptionsResult.selectedPrivacyOption);
        builder = builder;
        builder.d = true;
        return builder.b();
    }
}
