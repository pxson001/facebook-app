package com.facebook.composer.privacy.common;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: tapped_unlike_page */
public class ComposerGroupPrivacyDelegateProvider extends AbstractAssistedProvider<ComposerGroupPrivacyDelegate> {
    public final ComposerGroupPrivacyDelegate m1934a(PrivacyUpdatedHandler privacyUpdatedHandler, Long l, String str) {
        return new ComposerGroupPrivacyDelegate(privacyUpdatedHandler, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), TasksManager.b(this), GraphQLQueryExecutor.a(this), ResourcesMethodAutoProvider.a(this), l, str);
    }
}
