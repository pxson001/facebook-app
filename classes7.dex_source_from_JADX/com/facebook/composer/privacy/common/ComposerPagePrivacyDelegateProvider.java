package com.facebook.composer.privacy.common;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: tapped_share_page */
public class ComposerPagePrivacyDelegateProvider extends AbstractAssistedProvider<ComposerPagePrivacyDelegate> {
    public final ComposerPagePrivacyDelegate m1942a(PrivacyUpdatedHandler privacyUpdatedHandler, String str) {
        return new ComposerPagePrivacyDelegate(privacyUpdatedHandler, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), TasksManager.b(this), ResourcesMethodAutoProvider.a(this), str);
    }
}
