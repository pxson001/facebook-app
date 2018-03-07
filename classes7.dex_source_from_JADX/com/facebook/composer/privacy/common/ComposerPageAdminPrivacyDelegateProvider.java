package com.facebook.composer.privacy.common;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: tapped_suggest_edit */
public class ComposerPageAdminPrivacyDelegateProvider extends AbstractAssistedProvider<ComposerPageAdminPrivacyDelegate> {
    public final ComposerPageAdminPrivacyDelegate m1939a(PrivacyUpdatedHandler privacyUpdatedHandler, String str, String str2) {
        return new ComposerPageAdminPrivacyDelegate(privacyUpdatedHandler, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), TasksManager.b(this), str, str2, ResourcesMethodAutoProvider.a(this));
    }
}
