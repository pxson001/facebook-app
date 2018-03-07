package com.facebook.http.protocol;

import com.google.common.io.Files;
import java.io.File;
import java.io.OutputStream;

/* compiled from: dialtone_upgrade_dialog */
public class DataStreamBodyWithOffset extends ContentBody {
    private final File f5069b;
    private final long f5070c;
    private final long f5071d;

    public DataStreamBodyWithOffset(File file, String str, String str2, long j, long j2) {
        super(str, j2, str2);
        this.f5069b = file;
        this.f5070c = j;
        this.f5071d = j2;
    }

    public final void mo621b(OutputStream outputStream) {
        Files.a(this.f5069b).a(this.f5070c, this.f5071d).a(outputStream);
    }
}
