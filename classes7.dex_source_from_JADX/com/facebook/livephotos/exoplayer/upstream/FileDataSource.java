package com.facebook.livephotos.exoplayer.upstream;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: other_user_name */
public final class FileDataSource implements UriDataSource {
    private final TransferListener f7669a;
    private RandomAccessFile f7670b;
    private String f7671c;
    private long f7672d;
    private boolean f7673e;

    /* compiled from: other_user_name */
    public class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public FileDataSource() {
        this(null);
    }

    public FileDataSource(TransferListener transferListener) {
        this.f7669a = transferListener;
    }

    public final long mo441a(DataSpec dataSpec) {
        try {
            this.f7671c = dataSpec.f7634a.toString();
            this.f7670b = new RandomAccessFile(dataSpec.f7634a.getPath(), "r");
            this.f7670b.seek(dataSpec.f7637d);
            this.f7672d = dataSpec.f7638e == -1 ? this.f7670b.length() - dataSpec.f7637d : dataSpec.f7638e;
            if (this.f7672d < 0) {
                throw new EOFException();
            }
            this.f7673e = true;
            return this.f7672d;
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        }
    }

    public final int mo440a(byte[] bArr, int i, int i2) {
        if (this.f7672d == 0) {
            return -1;
        }
        try {
            int read = this.f7670b.read(bArr, i, (int) Math.min(this.f7672d, (long) i2));
            if (read <= 0) {
                return read;
            }
            this.f7672d -= (long) read;
            return read;
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        }
    }

    public final void mo442a() {
        this.f7671c = null;
        if (this.f7670b != null) {
            try {
                this.f7670b.close();
                this.f7670b = null;
                if (this.f7673e) {
                    this.f7673e = false;
                    if (this.f7669a == null) {
                    }
                }
            } catch (IOException e) {
                throw new FileDataSourceException(e);
            } catch (Throwable th) {
                this.f7670b = null;
                if (this.f7673e) {
                    this.f7673e = false;
                }
            }
        }
    }
}
