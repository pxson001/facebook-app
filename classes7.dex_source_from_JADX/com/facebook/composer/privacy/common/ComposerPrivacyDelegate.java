package com.facebook.composer.privacy.common;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;

/* compiled from: target_recipients */
public abstract class ComposerPrivacyDelegate {
    private final WeakReference<PrivacyUpdatedHandler> f1954a;
    public final AbstractFbErrorReporter f1955b;
    public final TasksManager<String> f1956c;

    /* compiled from: target_recipients */
    public interface PrivacyUpdatedHandler {
        void mo487a(ComposerPrivacyData composerPrivacyData, boolean z);
    }

    public abstract String mo92b();

    protected ComposerPrivacyDelegate(PrivacyUpdatedHandler privacyUpdatedHandler, FbErrorReporter fbErrorReporter, TasksManager<String> tasksManager) {
        this.f1954a = new WeakReference(Preconditions.checkNotNull(privacyUpdatedHandler));
        this.f1955b = (AbstractFbErrorReporter) Preconditions.checkNotNull(fbErrorReporter);
        this.f1956c = (TasksManager) Preconditions.checkNotNull(tasksManager);
    }

    public final void m1904a(ComposerPrivacyData composerPrivacyData) {
        PrivacyUpdatedHandler privacyUpdatedHandler = (PrivacyUpdatedHandler) this.f1954a.get();
        if (privacyUpdatedHandler == null) {
            this.f1955b.a("privacy_updated_handler collected", "The privacyUpdatedHandler is null");
        } else {
            privacyUpdatedHandler.mo487a(composerPrivacyData, false);
        }
    }

    public void mo91a() {
    }

    public void m1906e() {
        this.f1956c.c();
    }
}
