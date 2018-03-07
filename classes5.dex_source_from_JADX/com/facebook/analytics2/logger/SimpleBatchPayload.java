package com.facebook.analytics2.logger;

import com.facebook.analytics2.logger.BatchLockState.BatchLock;
import java.io.Writer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: third_metaline */
public abstract class SimpleBatchPayload implements BatchPayloadInternal {
    static final ThreadLocal<byte[]> f1986c = new C01321();
    static final ThreadLocal<char[]> f1987d = new C01332();
    final BatchDynamicMetadataHelper f1988a;
    final Object f1989b;
    @Nullable
    volatile BatchLock f1990e;

    /* compiled from: third_metaline */
    final class C01321 extends ThreadLocal<byte[]> {
        C01321() {
        }

        protected final Object initialValue() {
            return new byte[2048];
        }
    }

    /* compiled from: third_metaline */
    final class C01332 extends ThreadLocal<char[]> {
        C01332() {
        }

        protected final Object initialValue() {
            return new char[1024];
        }
    }

    protected abstract void mo494b(Writer writer);

    abstract BatchLock mo496g();

    abstract int mo497h();

    abstract void mo498i();

    abstract void mo499j();

    SimpleBatchPayload(BatchDynamicMetadataHelper batchDynamicMetadataHelper, Object obj) {
        this.f1988a = batchDynamicMetadataHelper;
        this.f1989b = obj;
    }

    public final void m2683k() {
        this.f1990e = mo496g();
        this.f1990e.c(this);
    }

    public final void mo489a(Writer writer) {
        m2673a(writer, false);
    }

    final void m2673a(Writer writer, boolean z) {
        if (!mo492d()) {
            m2683k();
        }
        mo494b(writer);
        BatchWriterStructure batchWriterStructure = new BatchWriterStructure(writer);
        batchWriterStructure.d = true;
        batchWriterStructure.b = true;
        batchWriterStructure.a(this.f1988a, z);
        writer.flush();
    }

    private void mo495f() {
        if (this.f1990e == null) {
            throw new IllegalStateException("mBatchLock is null, and it should be locked");
        }
        this.f1990e.e(this);
    }

    public final int mo488a() {
        return mo497h() + 256;
    }

    public final void mo493e() {
        mo495f();
        mo498i();
        this.f1990e.a(this);
    }

    public final void mo491c() {
        mo495f();
        this.f1990e.f(this);
        mo499j();
        this.f1990e.a();
        this.f1990e = null;
    }

    public final boolean mo492d() {
        BatchLock batchLock = this.f1990e;
        return batchLock != null && batchLock.b(this);
    }

    public final boolean mo490b() {
        return false;
    }

    public String toString() {
        return getClass().getSimpleName() + "{lockKey=" + this.f1989b + ";hasLock=" + mo492d() + "}";
    }
}
