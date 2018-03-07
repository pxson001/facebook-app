package com.facebook.analytics2.logger;

import com.facebook.crudolib.params.ParamsCollection;
import java.io.Writer;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: t_push */
public class BatchWriterStructure {
    private final Writer f3508a;
    public boolean f3509b;
    private boolean f3510c;
    public boolean f3511d;

    public BatchWriterStructure(Writer writer) {
        this.f3508a = writer;
    }

    private void m5721a() {
        m5723c();
        if (this.f3511d) {
            this.f3508a.write(44);
            return;
        }
        this.f3511d = true;
        this.f3508a.write(123);
    }

    public final void m5725a(BatchFixedMetadataHelper batchFixedMetadataHelper) {
        m5723c();
        m5721a();
        batchFixedMetadataHelper.m5407a(this.f3508a);
    }

    public final void m5726a(BatchSessionMetadataHelper batchSessionMetadataHelper) {
        m5723c();
        m5721a();
        batchSessionMetadataHelper.m5652a(this.f3508a);
    }

    private void m5722b() {
        m5723c();
        m5721a();
        this.f3508a.write("\"data\":[");
    }

    public final void m5727a(ParamsCollection paramsCollection) {
        m5723c();
        if (this.f3509b) {
            this.f3508a.write(44);
        } else {
            m5722b();
            this.f3509b = true;
        }
        paramsCollection.m5439a(this.f3508a);
    }

    public final void m5724a(BatchDynamicMetadataHelper batchDynamicMetadataHelper, boolean z) {
        m5723c();
        this.f3510c = true;
        this.f3508a.write(93);
        if (!z) {
            this.f3508a.write(44);
            batchDynamicMetadataHelper.a(this.f3508a);
        }
        this.f3508a.write(125);
    }

    private void m5723c() {
        if (this.f3510c) {
            throw new IllegalStateException("Cannot perform action because we have ended the batch");
        }
    }
}
