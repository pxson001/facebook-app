package com.facebook.analytics2.logger;

import com.facebook.analytics2.logger.BatchLockState.BatchLock;
import java.io.ByteArrayOutputStream;
import java.io.Writer;

/* compiled from: text_with_entities */
public class MemoryBatchPayload extends SimpleBatchPayload {
    private final ByteArrayOutputStream f2030f;

    public MemoryBatchPayload(ByteArrayOutputStream byteArrayOutputStream, BatchDynamicMetadataHelper batchDynamicMetadataHelper) {
        super(batchDynamicMetadataHelper, byteArrayOutputStream);
        this.f2030f = byteArrayOutputStream;
    }

    protected final BatchLock mo496g() {
        return InProcessBatchLockState.a().a(this.f2030f);
    }

    protected final void mo494b(Writer writer) {
        writer.write(this.f2030f.toString());
    }

    final int mo497h() {
        return this.f2030f.size();
    }

    protected final void mo498i() {
    }

    protected final void mo499j() {
        this.f2030f.reset();
    }
}
