package com.facebook.analytics2.logger;

import android.support.v7.widget.LinearLayoutCompat;
import java.io.Writer;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: text_direction */
public class MultiBatchWriterStructure {
    private final Writer f2031a;
    public int f2032b = 1;

    public MultiBatchWriterStructure(Writer writer) {
        this.f2031a = writer;
    }

    public final void m2736a() {
        m2735a(1);
        this.f2032b = 2;
        this.f2031a.write(123);
        this.f2031a.write("\"batches\":[");
    }

    public final void m2738a(SimpleBatchPayload simpleBatchPayload) {
        switch (this.f2032b) {
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                this.f2032b = 3;
                break;
            case 3:
                this.f2031a.write(44);
                break;
            default:
                throw new IllegalStateException("state=" + this.f2032b);
        }
        simpleBatchPayload.m2673a(this.f2031a, true);
    }

    public final void m2737a(BatchDynamicMetadataHelper batchDynamicMetadataHelper) {
        if (this.f2032b == 2 || this.f2032b == 3) {
            this.f2032b = 4;
            this.f2031a.write("],");
            batchDynamicMetadataHelper.m2640b(this.f2031a);
            this.f2031a.write(125);
            return;
        }
        throw new IllegalStateException("state=" + this.f2032b);
    }

    private void m2735a(int i) {
        if (this.f2032b != i) {
            throw new IllegalStateException("Expected state " + i + "; got " + this.f2032b);
        }
    }
}
