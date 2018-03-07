package com.facebook.composer.privacy.common;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateBase.AnalyticsCallback;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateBase.DataProvider;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.ui.futures.TasksManager;

/* compiled from: tapped_review_in_action_bar */
public class ComposerSelectablePrivacyDelegateProvider extends AbstractAssistedProvider<ComposerSelectablePrivacyDelegate> {
    public final ComposerSelectablePrivacyDelegate m1964a(PrivacyUpdatedHandler privacyUpdatedHandler, AnalyticsCallback analyticsCallback, GraphQLPrivacyOption graphQLPrivacyOption, DataProvider dataProvider) {
        return new ComposerSelectablePrivacyDelegate(privacyUpdatedHandler, analyticsCallback, graphQLPrivacyOption, dataProvider, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), TasksManager.b(this), PrivacyOperationsClient.a(this), IdBasedLazy.a(this, 3115));
    }
}
