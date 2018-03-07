package com.facebook.http.entity.mime.apache.content;

import java.io.OutputStream;

/* compiled from: disconnected */
public abstract class AbstractContentBody {
    public final String f5018a;
    private final String f5019b;
    private final String f5020c;

    public abstract String mo615a();

    public abstract void mo616a(OutputStream outputStream);

    public abstract String mo617b();

    public abstract String mo618c();

    public abstract long mo619d();

    public AbstractContentBody(String str) {
        if (str == null) {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        this.f5018a = str;
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            this.f5019b = str.substring(0, indexOf);
            this.f5020c = str.substring(indexOf + 1);
            return;
        }
        this.f5019b = str;
        this.f5020c = null;
    }
}
