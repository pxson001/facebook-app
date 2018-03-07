package com.facebook.analytics2.logger;

import com.facebook.analytics2.logger.BatchLockState.BatchLock;
import com.facebook.crudolib.params.ParamsCollectionPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: t_vs */
class EventBatchFileStore extends EventBatchStore<File> {
    private final File f3387d;
    private final BatchLockState f3388e;

    /* compiled from: t_vs */
    class Batch extends com.facebook.analytics2.logger.EventBatchStore.Batch {
        public final File f3495a;
        final /* synthetic */ EventBatchFileStore f3496b;

        public Batch(EventBatchFileStore eventBatchFileStore, File file, BatchLock batchLock) {
            this.f3496b = eventBatchFileStore;
            super(eventBatchFileStore, new FileOutputStream(file), batchLock);
            this.f3495a = file;
        }
    }

    public EventBatchFileStore(int i, int i2, BatchFixedMetadataHelper batchFixedMetadataHelper, ParamsCollectionPool paramsCollectionPool, File file, BatchLockState batchLockState) {
        super(i, i2, batchFixedMetadataHelper, paramsCollectionPool);
        this.f3387d = file;
        this.f3388e = batchLockState;
    }

    protected final com.facebook.analytics2.logger.EventBatchStore.Batch mo748a(String str) {
        Object b = BatchDirectoryStructure.m5621b(BatchDirectoryStructure.m5618a(this.f3387d, str));
        BatchLock a = this.f3388e.m5596a(b);
        try {
            if (a.m5706d(this)) {
                com.facebook.analytics2.logger.EventBatchStore.Batch a2;
                try {
                    a2 = m5604a(b, a);
                } catch (FileNotFoundException e) {
                    a2 = m5604a(b, a);
                }
                if (a2 == null) {
                    a.m5710f(this);
                    a.m5699a();
                }
                return a2;
            }
            throw new IllegalStateException("Couldn't lock newly created file");
        } catch (Throwable th) {
            if (null == null) {
                a.m5710f(this);
                a.m5699a();
            }
        }
    }

    private Batch m5604a(File file, BatchLock batchLock) {
        if (file.getParentFile().isDirectory() || file.getParentFile().mkdirs()) {
            return new Batch(this, file, batchLock);
        }
        throw new IOException("Unable to create parent directories for: " + file);
    }

    protected final Object mo749a() {
        if (this.f3390b == null) {
            return null;
        }
        return ((Batch) this.f3390b).f3495a;
    }
}
