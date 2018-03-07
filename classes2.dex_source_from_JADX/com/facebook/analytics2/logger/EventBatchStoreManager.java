package com.facebook.analytics2.logger;

import com.facebook.crudolib.params.ParamsCollection;
import javax.annotation.Nullable;

/* compiled from: ta_IN */
public class EventBatchStoreManager {
    private final EventBatchStore f3385a;
    private final UploadBatchNotifier f3386b;

    public EventBatchStoreManager(EventBatchStore eventBatchStore, UploadBatchNotifier uploadBatchNotifier) {
        this.f3385a = eventBatchStore;
        this.f3386b = uploadBatchNotifier;
    }

    public final void m5600a(BatchSession batchSession) {
        this.f3385a.m5612a(batchSession);
    }

    public final void m5603b(BatchSession batchSession) {
        this.f3385a.m5612a(batchSession);
    }

    public final void m5601a(ParamsCollection paramsCollection) {
        Object obj;
        this.f3385a.m5613a(paramsCollection);
        this.f3386b.mo751a(this.f3385a.mo749a());
        this.f3386b.mo750a();
        EventBatchStore eventBatchStore = this.f3385a;
        if (eventBatchStore.f3390b == null || eventBatchStore.f3390b.f3500f < eventBatchStore.f3392d) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.f3386b.mo753b();
        }
        eventBatchStore = this.f3385a;
        if (eventBatchStore.f3390b == null || eventBatchStore.f3390b.f3500f < eventBatchStore.f3393e) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.f3385a.m5614d();
        }
    }

    public final void m5602a(@Nullable String str) {
        this.f3386b.mo752a(str);
    }
}
