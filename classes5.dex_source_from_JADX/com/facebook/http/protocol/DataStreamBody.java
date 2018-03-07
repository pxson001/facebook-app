package com.facebook.http.protocol;

import com.google.common.io.Files;
import java.io.File;
import java.io.OutputStream;

/* compiled from: dialtone_wifi_interstitial */
public class DataStreamBody extends ContentBody {
    private final File f5068b;

    public DataStreamBody(File file, String str, String str2) {
        super(str, file.length(), str2);
        this.f5068b = file;
    }

    public void mo621b(OutputStream outputStream) {
        Files.a(this.f5068b).a(outputStream);
    }
}
