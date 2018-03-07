package com.google.common.io;

import java.io.Reader;

/* compiled from: bug_report_corrupted_directory_deleted */
public abstract class CharSource {
    public abstract Reader mo1017a();

    protected CharSource() {
    }

    public final String m13811b() {
        Closer a = Closer.a();
        try {
            String a2 = CharStreams.a((Reader) a.a(mo1017a()));
            a.close();
            return a2;
        } catch (Throwable th) {
            a.close();
        }
    }
}
