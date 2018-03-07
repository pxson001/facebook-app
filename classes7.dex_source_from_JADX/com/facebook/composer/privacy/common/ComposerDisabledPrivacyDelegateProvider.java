package com.facebook.composer.privacy.common;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: tapped_videohub_playlist_header */
public class ComposerDisabledPrivacyDelegateProvider extends AbstractAssistedProvider<ComposerDisabledPrivacyDelegate> {
    public final ComposerDisabledPrivacyDelegate m1917a(PrivacyUpdatedHandler privacyUpdatedHandler) {
        return new ComposerDisabledPrivacyDelegate(privacyUpdatedHandler, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), TasksManager.b(this));
    }
}
