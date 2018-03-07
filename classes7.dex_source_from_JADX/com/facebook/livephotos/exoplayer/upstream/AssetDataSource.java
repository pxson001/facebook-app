package com.facebook.livephotos.exoplayer.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: paddingRight */
public final class AssetDataSource implements UriDataSource {
    private final AssetManager f7622a;
    private final TransferListener f7623b;
    private String f7624c;
    private InputStream f7625d;
    private long f7626e;
    private boolean f7627f;

    /* compiled from: paddingRight */
    public final class AssetDataSourceException extends IOException {
        public AssetDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public AssetDataSource(Context context, TransferListener transferListener) {
        this.f7622a = context.getAssets();
        this.f7623b = transferListener;
    }

    public final long mo441a(DataSpec dataSpec) {
        try {
            this.f7624c = dataSpec.f7634a.toString();
            String path = dataSpec.f7634a.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            this.f7624c = dataSpec.f7634a.toString();
            this.f7625d = this.f7622a.open(path, 1);
            if (this.f7625d.skip(dataSpec.f7637d) < dataSpec.f7637d) {
                throw new EOFException();
            }
            if (dataSpec.f7638e != -1) {
                this.f7626e = dataSpec.f7638e;
            } else {
                this.f7626e = (long) this.f7625d.available();
                if (this.f7626e == 2147483647L) {
                    this.f7626e = -1;
                }
            }
            this.f7627f = true;
            return this.f7626e;
        } catch (IOException e) {
            throw new AssetDataSourceException(e);
        }
    }

    public final int mo440a(byte[] bArr, int i, int i2) {
        if (this.f7626e == 0) {
            return -1;
        }
        try {
            if (this.f7626e != -1) {
                i2 = (int) Math.min(this.f7626e, (long) i2);
            }
            int read = this.f7625d.read(bArr, i, i2);
            if (read <= 0 || this.f7626e == -1) {
                return read;
            }
            this.f7626e -= (long) read;
            return read;
        } catch (IOException e) {
            throw new AssetDataSourceException(e);
        }
    }

    public final void mo442a() {
        this.f7624c = null;
        if (this.f7625d != null) {
            try {
                this.f7625d.close();
                this.f7625d = null;
                if (this.f7627f) {
                    this.f7627f = false;
                    if (this.f7623b == null) {
                    }
                }
            } catch (IOException e) {
                throw new AssetDataSourceException(e);
            } catch (Throwable th) {
                this.f7625d = null;
                if (this.f7627f) {
                    this.f7627f = false;
                }
            }
        }
    }
}
