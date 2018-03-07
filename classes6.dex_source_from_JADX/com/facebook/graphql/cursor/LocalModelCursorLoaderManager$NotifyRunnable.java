package com.facebook.graphql.cursor;

/* compiled from: mPromptDisplayReason */
final class LocalModelCursorLoaderManager$NotifyRunnable implements Runnable {
    final /* synthetic */ LocalModelCursorLoaderManager f10967a;
    private final ModelCursor f10968b;

    public LocalModelCursorLoaderManager$NotifyRunnable(LocalModelCursorLoaderManager localModelCursorLoaderManager, ModelCursor modelCursor) {
        this.f10967a = localModelCursorLoaderManager;
        this.f10968b = modelCursor;
    }

    public final void run() {
        this.f10967a.e.a();
        this.f10967a.c.a(this.f10968b);
    }
}
