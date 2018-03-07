package com.facebook.graphql.cursor;

import android.os.Bundle;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;

/* compiled from: mPromptDisplayReason */
class LocalModelCursorLoaderManager$LoadRunnable implements Runnable {
    final /* synthetic */ LocalModelCursorLoaderManager f10965a;
    private final Bundle f10966b;

    public LocalModelCursorLoaderManager$LoadRunnable(LocalModelCursorLoaderManager localModelCursorLoaderManager, Bundle bundle) {
        this.f10965a = localModelCursorLoaderManager;
        this.f10966b = bundle;
    }

    public void run() {
        this.f10965a.e.b();
        if (this.f10965a.h.compareAndSet(true, false)) {
            ModelCursor modelCursor = (ModelCursor) this.f10965a.d.a();
            if (!(modelCursor == null || this.f10966b == null)) {
                modelCursor.getExtras().putAll(this.f10966b);
            }
            ExecutorDetour.a(this.f10965a.g, new LocalModelCursorLoaderManager$NotifyRunnable(this.f10965a, modelCursor), -239983159);
        }
    }
}
