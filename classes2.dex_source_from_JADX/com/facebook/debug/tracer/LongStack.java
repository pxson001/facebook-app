package com.facebook.debug.tracer;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: zero_rating2/clearable/default_optin/secondary_button_step_key */
public class LongStack {
    public long[] f424a;
    private int f425b = -1;

    public LongStack(int i) {
        this.f424a = new long[i];
    }

    public final int m890a() {
        return this.f425b + 1;
    }

    public final long m892b() {
        long[] jArr = this.f424a;
        int i = this.f425b;
        this.f425b = i - 1;
        return jArr[i];
    }

    public final void m891a(long j) {
        if (this.f424a.length == this.f425b + 1) {
            Object obj = new long[(this.f424a.length * 2)];
            System.arraycopy(this.f424a, 0, obj, 0, this.f424a.length);
            this.f424a = obj;
        }
        long[] jArr = this.f424a;
        int i = this.f425b + 1;
        this.f425b = i;
        jArr[i] = j;
    }

    public final void m893c() {
        this.f425b = -1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<LongStack vector:[");
        for (int i = 0; i < this.f424a.length; i++) {
            if (i != 0) {
                stringBuilder.append(" ");
            }
            if (i == this.f425b) {
                stringBuilder.append(">>");
            }
            stringBuilder.append(this.f424a[i]);
            if (i == this.f425b) {
                stringBuilder.append("<<");
            }
        }
        stringBuilder.append("]>");
        return stringBuilder.toString();
    }
}
