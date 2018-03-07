package com.facebook.http.protocol;

import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.OutputStream;

/* compiled from: dialtone_mode_selection_interstitial_free_fb_button_click */
public class LimitOutputStream extends FilterOutputStream {
    private long f5083a;
    private final long f5084b;

    public LimitOutputStream(OutputStream outputStream, long j) {
        super(outputStream);
        Preconditions.checkArgument(j >= 0, "Limit must be non-negative");
        this.f5084b = j;
    }

    public void write(byte[] bArr, int i, int i2) {
        int min = (int) Math.min((long) i2, this.f5084b - this.f5083a);
        if (min > 0) {
            this.out.write(bArr, i, min);
            this.f5083a += (long) min;
        }
        if (min < i2) {
            throw new LimitExceededException(this.f5084b, i2 - min);
        }
    }

    public void write(int i) {
        if (this.f5083a >= this.f5084b) {
            throw new LimitExceededException(this.f5084b, 1);
        }
        this.out.write(i);
    }
}
