package com.facebook.composer.privacy.common;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.ui.futures.TasksManager;

/* compiled from: tapped_report_button */
public class ComposerTimelinePrivacyDelegateProvider extends AbstractAssistedProvider<ComposerTimelinePrivacyDelegate> {
    public final ComposerTimelinePrivacyDelegate m1971a(PrivacyUpdatedHandler privacyUpdatedHandler, Long l, String str, ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields) {
        return new ComposerTimelinePrivacyDelegate(privacyUpdatedHandler, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), TasksManager.b(this), l, str, composerTargetDataPrivacyScopeFields, GraphQLQueryExecutor.a(this), ResourcesMethodAutoProvider.a(this));
    }
}
