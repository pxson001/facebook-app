package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.Writer;

/* compiled from: video_resize_longest_dimension */
public final class SegmentedStringWriter extends Writer {
    protected final TextBuffer f242a;

    public SegmentedStringWriter(BufferRecycler bufferRecycler) {
        this.f242a = new TextBuffer(bufferRecycler);
    }

    public final Writer append(char c) {
        write((int) c);
        return this;
    }

    public final Writer append(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        this.f242a.a(charSequence2, 0, charSequence2.length());
        return this;
    }

    public final Writer append(CharSequence charSequence, int i, int i2) {
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        this.f242a.a(charSequence2, 0, charSequence2.length());
        return this;
    }

    public final void close() {
    }

    public final void flush() {
    }

    public final void write(char[] cArr) {
        this.f242a.c(cArr, 0, cArr.length);
    }

    public final void write(char[] cArr, int i, int i2) {
        this.f242a.c(cArr, i, i2);
    }

    public final void write(int i) {
        this.f242a.a((char) i);
    }

    public final void write(String str) {
        this.f242a.a(str, 0, str.length());
    }

    public final void write(String str, int i, int i2) {
        this.f242a.a(str, i, i2);
    }

    public final String m275a() {
        String g = this.f242a.g();
        this.f242a.a();
        return g;
    }
}
