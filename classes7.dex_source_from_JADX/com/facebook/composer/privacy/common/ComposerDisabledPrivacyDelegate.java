package com.facebook.composer.privacy.common;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.composer.privacy.common.ComposerPrivacyData.Builder;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: tapped_view_timeline_button */
public class ComposerDisabledPrivacyDelegate extends ComposerPrivacyDelegate {
    @Inject
    public ComposerDisabledPrivacyDelegate(@Assisted PrivacyUpdatedHandler privacyUpdatedHandler, AbstractFbErrorReporter abstractFbErrorReporter, TasksManager tasksManager) {
        super(privacyUpdatedHandler, abstractFbErrorReporter, tasksManager);
    }

    public final void mo91a() {
        super.mo91a();
        Builder builder = new Builder();
        builder.f1994a = false;
        m1904a(builder.m1945a());
    }

    public final String mo92b() {
        return "disabled";
    }
}
