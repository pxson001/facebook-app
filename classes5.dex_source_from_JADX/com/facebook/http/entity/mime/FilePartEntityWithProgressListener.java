package com.facebook.http.entity.mime;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

/* compiled from: discover_suggestion */
public class FilePartEntityWithProgressListener implements HttpEntity {
    private final File f5005a;
    private final int f5006b;
    private final int f5007c;
    public ContentSerializationListener f5008d;

    public FilePartEntityWithProgressListener(File file, int i, int i2) {
        this.f5005a = file;
        this.f5006b = i;
        this.f5007c = i2;
    }

    public void writeTo(OutputStream outputStream) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f5005a, "r");
        try {
            randomAccessFile.seek((long) this.f5006b);
            byte[] bArr = new byte[4096];
            int i = this.f5007c;
            while (true) {
                int read = randomAccessFile.read(bArr, 0, Math.min(i, 4096));
                if (read == -1 || i <= 0) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                i -= read;
                if (this.f5008d != null) {
                    this.f5008d.mo620a((long) (this.f5007c - i));
                }
            }
            outputStream.flush();
            randomAccessFile.close();
        } catch (Throwable e) {
            throw new IOException("Cannot find source file", e);
        } catch (Throwable th) {
            randomAccessFile.close();
        }
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isChunked() {
        return false;
    }

    public long getContentLength() {
        return (long) this.f5007c;
    }

    public Header getContentType() {
        return new BasicHeader("Content-Type", "application/octet-stream");
    }

    public Header getContentEncoding() {
        return null;
    }

    public InputStream getContent() {
        throw new UnsupportedOperationException("Unsupported");
    }

    public boolean isStreaming() {
        return true;
    }

    public void consumeContent() {
    }
}
