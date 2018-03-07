package com.facebook.http.protocol;

import com.facebook.http.entity.mime.apache.content.AbstractContentBody;
import com.google.common.io.CountingOutputStream;
import java.io.OutputStream;

/* compiled from: dialtone_wifi_interstitial_impression */
public abstract class ContentBody extends AbstractContentBody {
    private final long f5063b;
    private final String f5064c;

    protected abstract void mo621b(OutputStream outputStream);

    public ContentBody(String str, long j, String str2) {
        super(str);
        this.f5063b = j;
        this.f5064c = str2;
    }

    public final void mo616a(OutputStream outputStream) {
        CountingOutputStream countingOutputStream = new CountingOutputStream(new LimitOutputStream(outputStream, this.f5063b));
        mo621b(countingOutputStream);
        long j = countingOutputStream.a;
        if (j < this.f5063b) {
            throw new InsufficientDataException(j, this.f5063b);
        }
    }

    public final String mo618c() {
        return "binary";
    }

    public final String mo617b() {
        return null;
    }

    public final long mo619d() {
        return this.f5063b;
    }

    public final String mo615a() {
        return this.f5064c;
    }
}
