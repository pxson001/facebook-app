package com.facebook.livephotos.exoplayer.upstream;

import android.content.ContentResolver;
import android.content.Context;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: paddingBottom */
public final class ContentDataSource implements UriDataSource {
    private final ContentResolver f7628a;
    private final TransferListener f7629b;
    private InputStream f7630c;
    private String f7631d;
    private long f7632e;
    private boolean f7633f;

    /* compiled from: paddingBottom */
    public class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(Context context, TransferListener transferListener) {
        this.f7628a = context.getContentResolver();
        this.f7629b = transferListener;
    }

    public final long mo441a(DataSpec dataSpec) {
        try {
            this.f7631d = dataSpec.f7634a.toString();
            this.f7630c = new FileInputStream(this.f7628a.openAssetFileDescriptor(dataSpec.f7634a, "r").getFileDescriptor());
            if (this.f7630c.skip(dataSpec.f7637d) < dataSpec.f7637d) {
                throw new EOFException();
            }
            if (dataSpec.f7638e != -1) {
                this.f7632e = dataSpec.f7638e;
            } else {
                this.f7632e = (long) this.f7630c.available();
                if (this.f7632e == 0) {
                    this.f7632e = -1;
                }
            }
            this.f7633f = true;
            return this.f7632e;
        } catch (IOException e) {
            throw new ContentDataSourceException(e);
        }
    }

    public final int mo440a(byte[] bArr, int i, int i2) {
        if (this.f7632e == 0) {
            return -1;
        }
        try {
            if (this.f7632e != -1) {
                i2 = (int) Math.min(this.f7632e, (long) i2);
            }
            int read = this.f7630c.read(bArr, i, i2);
            if (read <= 0 || this.f7632e == -1) {
                return read;
            }
            this.f7632e -= (long) read;
            return read;
        } catch (IOException e) {
            throw new ContentDataSourceException(e);
        }
    }

    public final void mo442a() {
        this.f7631d = null;
        if (this.f7630c != null) {
            try {
                this.f7630c.close();
                this.f7630c = null;
                if (this.f7633f) {
                    this.f7633f = false;
                    if (this.f7629b == null) {
                    }
                }
            } catch (IOException e) {
                throw new ContentDataSourceException(e);
            } catch (Throwable th) {
                this.f7630c = null;
                if (this.f7633f) {
                    this.f7633f = false;
                }
            }
        }
    }
}
