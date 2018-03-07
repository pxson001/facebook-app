package com.facebook.debug.dumpsys;

import com.facebook.common.iolite.PrefixedWriter;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: _loadJSURL */
public class DumpsysContext {
    private final String f11772a;
    private final FileDescriptor f11773b;
    private final PrintWriter f11774c;
    private final ImmutableList<String> f11775d;
    public final PrintWriter f11776e;
    public final DumpsysDumper f11777f;

    public DumpsysContext(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr, DumpsysDumper dumpsysDumper) {
        this.f11772a = str;
        this.f11773b = fileDescriptor;
        this.f11774c = (PrintWriter) Preconditions.checkNotNull(printWriter);
        this.f11775d = ImmutableList.copyOf((Object[]) Preconditions.checkNotNull(strArr));
        this.f11776e = new PrintWriter(new PrefixedWriter(printWriter, str));
        this.f11777f = dumpsysDumper;
    }
}
