package com.facebook.analytics2.logger;

import com.facebook.analytics2.logger.BatchLockState.BatchLock;
import com.facebook.crudolib.params.ParamsCollectionPool;
import java.io.ByteArrayOutputStream;
import javax.annotation.Nonnull;

/* compiled from: third_party_app_via_intent */
public class EventBatchMemoryStore extends EventBatchStore<ByteArrayOutputStream> {

    /* compiled from: third_party_app_via_intent */
    public class Batch extends com.facebook.analytics2.logger.EventBatchStore.Batch {
        public final ByteArrayOutputStream f1981a;
        final /* synthetic */ EventBatchMemoryStore f1982b;

        public Batch(EventBatchMemoryStore eventBatchMemoryStore, ByteArrayOutputStream byteArrayOutputStream, BatchLock batchLock) {
            this.f1982b = eventBatchMemoryStore;
            super(eventBatchMemoryStore, byteArrayOutputStream, batchLock);
            this.f1981a = byteArrayOutputStream;
        }
    }

    public EventBatchMemoryStore(int i, int i2, BatchFixedMetadataHelper batchFixedMetadataHelper, ParamsCollectionPool paramsCollectionPool) {
        super(i, i2, batchFixedMetadataHelper, paramsCollectionPool);
    }

    public final Object m2662a() {
        if (this.b == null) {
            return null;
        }
        return ((Batch) this.b).f1981a;
    }

    @Nonnull
    protected final com.facebook.analytics2.logger.EventBatchStore.Batch m2661a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BatchLock a = InProcessBatchLockState.a().a(byteArrayOutputStream);
        if (a.d(this)) {
            return new Batch(this, byteArrayOutputStream, a);
        }
        throw new IllegalStateException("Couldn't lock newly created batch");
    }
}
