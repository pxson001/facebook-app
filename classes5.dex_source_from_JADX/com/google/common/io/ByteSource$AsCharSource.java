package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* compiled from: bug_report_begin_flow */
public final class ByteSource$AsCharSource extends CharSource {
    final /* synthetic */ ByteSource f7644a;
    private final Charset f7645b;

    public ByteSource$AsCharSource(ByteSource byteSource, Charset charset) {
        this.f7644a = byteSource;
        this.f7645b = (Charset) Preconditions.checkNotNull(charset);
    }

    public final Reader mo1017a() {
        return new InputStreamReader(this.f7644a.a(), this.f7645b);
    }

    public final String toString() {
        return this.f7644a.toString() + ".asCharSource(" + this.f7645b + ")";
    }
}
