package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/* compiled from: bug_report_created */
public final class ByteSink$AsCharSink extends CharSink {
    final /* synthetic */ ByteSink f7642a;
    private final Charset f7643b;

    public ByteSink$AsCharSink(ByteSink byteSink, Charset charset) {
        this.f7642a = byteSink;
        this.f7643b = (Charset) Preconditions.checkNotNull(charset);
    }

    public final Writer mo1016a() {
        return new OutputStreamWriter(this.f7642a.a(), this.f7643b);
    }

    public final String toString() {
        return this.f7642a.toString() + ".asCharSink(" + this.f7643b + ")";
    }
}
