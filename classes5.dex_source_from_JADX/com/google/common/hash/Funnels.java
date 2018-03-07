package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.OutputStream;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@Beta
/* compiled from: bug_report_did_select_product */
public final class Funnels {

    /* compiled from: bug_report_did_select_product */
    public class SinkAsStream extends OutputStream {
        final PrimitiveSink f7636a;

        public SinkAsStream(PrimitiveSink primitiveSink) {
            this.f7636a = (PrimitiveSink) Preconditions.checkNotNull(primitiveSink);
        }

        public void write(int i) {
            this.f7636a.b((byte) i);
        }

        public void write(byte[] bArr) {
            this.f7636a.c(bArr);
        }

        public void write(byte[] bArr, int i, int i2) {
            this.f7636a.b(bArr, i, i2);
        }

        public String toString() {
            return "Funnels.asOutputStream(" + this.f7636a + ")";
        }
    }

    private Funnels() {
    }
}
