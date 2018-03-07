package com.facebook.debug.http;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;

/* compiled from: pinOrPassword */
final class FileReporter$FileAppender {
    private final File f6576a;

    public FileReporter$FileAppender(File file) {
        this.f6576a = (File) Preconditions.checkNotNull(file);
    }

    public final void m6904a(String str) {
        try {
            Files.b(str + '\n', this.f6576a, Charsets.UTF_8);
        } catch (IOException e) {
            getClass();
        }
    }
}
