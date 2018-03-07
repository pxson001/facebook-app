package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.Writer;

/* compiled from: bug_report_did_attach_screenshot */
public abstract class CharSink {
    public abstract Writer mo1016a();

    protected CharSink() {
    }

    public final void m13808a(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Closer a = Closer.a();
        try {
            Writer writer = (Writer) a.a(mo1016a());
            writer.append(charSequence);
            writer.flush();
            a.close();
        } catch (Throwable th) {
            a.close();
        }
    }
}
