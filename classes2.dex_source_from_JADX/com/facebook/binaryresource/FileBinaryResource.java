package com.facebook.binaryresource;

import com.facebook.common.internal.Files;
import com.facebook.common.internal.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* compiled from: last_ssl_dialg_ms */
public class FileBinaryResource implements BinaryResource {
    public final File f17878a;

    private FileBinaryResource(File file) {
        this.f17878a = (File) Preconditions.a(file);
    }

    public final InputStream mo2976a() {
        return new FileInputStream(this.f17878a);
    }

    public final long mo2978c() {
        return this.f17878a.length();
    }

    public final byte[] mo2977b() {
        return Files.a(this.f17878a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FileBinaryResource)) {
            return false;
        }
        return this.f17878a.equals(((FileBinaryResource) obj).f17878a);
    }

    public int hashCode() {
        return this.f17878a.hashCode();
    }

    public static FileBinaryResource m25094a(File file) {
        return file != null ? new FileBinaryResource(file) : null;
    }
}
