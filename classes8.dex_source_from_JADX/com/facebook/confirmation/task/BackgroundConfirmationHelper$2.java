package com.facebook.confirmation.task;

import com.facebook.backgroundtasks.BackgroundTaskManager;

/* compiled from: instant_article_activity_json */
class BackgroundConfirmationHelper$2 implements Runnable {
    final /* synthetic */ BackgroundConfirmationHelper f10796a;

    BackgroundConfirmationHelper$2(BackgroundConfirmationHelper backgroundConfirmationHelper) {
        this.f10796a = backgroundConfirmationHelper;
    }

    public void run() {
        ((BackgroundTaskManager) this.f10796a.f.get()).a();
    }
}
