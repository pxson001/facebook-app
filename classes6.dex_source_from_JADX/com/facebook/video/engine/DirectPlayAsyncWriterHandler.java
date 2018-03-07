package com.facebook.video.engine;

import com.facebook.debug.log.BLog;
import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.video.abtest.DirectPlayConfig;
import com.facebook.video.server.AsyncWriter$CancelledException;
import com.facebook.video.server.AsyncWriter$Handler;
import com.facebook.video.server.VideoResourceMetadata;
import com.facebook.video.server.cache.PlayerReadableCache;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* compiled from: configured_questions */
public abstract class DirectPlayAsyncWriterHandler implements AsyncWriter$Handler {
    public static final String f18742a = DirectPlayAsyncWriterHandler.class.getName();
    private final PlayerReadableCache f18743b;
    private final DirectPlayConfig f18744c;
    private final String f18745d;
    private final VideoResourceMetadata f18746e;
    public File f18747f;
    private RandomAccessFile f18748g;

    /* compiled from: configured_questions */
    abstract class PlayerReadableFileOutputStream extends OutputStream {
        private final RandomAccessFile f18737a;
        private final int f18738b;
        private int f18739c = 0;
        private boolean f18740d = false;

        protected abstract void mo1416a();

        public PlayerReadableFileOutputStream(RandomAccessFile randomAccessFile, int i) {
            this.f18737a = randomAccessFile;
            this.f18738b = i;
        }

        public void write(int i) {
            throw new UnsupportedOperationException();
        }

        public void write(byte[] bArr, int i, int i2) {
            this.f18737a.write(bArr, i, i2);
            this.f18739c += i2;
            if (this.f18739c > this.f18738b && !this.f18740d) {
                this.f18740d = true;
                mo1416a();
            }
        }

        public final int m27481b() {
            return this.f18739c;
        }

        public final boolean m27482c() {
            return this.f18740d;
        }
    }

    protected abstract void mo1421a(String str);

    protected abstract boolean mo1422a();

    protected abstract void mo1423b();

    public DirectPlayAsyncWriterHandler(PlayerReadableCache playerReadableCache, DirectPlayConfig directPlayConfig, String str, VideoResourceMetadata videoResourceMetadata) {
        this.f18743b = playerReadableCache;
        this.f18744c = directPlayConfig;
        this.f18745d = str;
        this.f18746e = videoResourceMetadata;
    }

    public final void mo1419a(IOException iOException) {
        try {
            mo1423b();
        } catch (Throwable e) {
            BLog.a(f18742a, "Exception throw", e);
        } catch (Throwable e2) {
            BLog.a(f18742a, "Exception throw", e2);
        }
    }

    public final OutputStream mo1418a(FileMetadata fileMetadata) {
        try {
            this.f18747f = this.f18743b.m28285a(this.f18745d);
            this.f18747f.getAbsolutePath();
            this.f18748g = new RandomAccessFile(this.f18747f, "rw");
            if (this.f18748g.length() != fileMetadata.a) {
                this.f18748g.setLength(fileMetadata.a);
            }
            this.f18748g.seek(0);
            Long.valueOf(fileMetadata.a);
            int a = this.f18746e.a((long) this.f18744c.c, 0, this.f18744c.f);
            if (this.f18744c.k && ((long) a) > fileMetadata.a) {
                a = (int) fileMetadata.a;
            }
            Integer.valueOf(a);
            return new PlayerReadableFileOutputStream(this, this.f18748g, a) {
                final /* synthetic */ DirectPlayAsyncWriterHandler f18741a;

                public void write(byte[] bArr, int i, int i2) {
                    if (this.f18741a.mo1422a()) {
                        String str = DirectPlayAsyncWriterHandler.f18742a;
                        throw new AsyncWriter$CancelledException("DirectPlay stopped", null);
                    } else {
                        super.write(bArr, i, i2);
                    }
                }

                public final void mo1416a() {
                    this.f18741a.mo1421a(this.f18741a.f18747f.getAbsolutePath());
                }
            };
        } catch (Throwable e) {
            BLog.a(f18742a, e, "Error creating direct play file", new Object[0]);
            return null;
        }
    }

    public final void mo1420a(OutputStream outputStream, IOException iOException) {
        if (iOException instanceof AsyncWriter$CancelledException) {
            iOException = null;
        }
        if (iOException != null) {
            BLog.a(f18742a, "Exception is thrown", iOException);
        }
        try {
            PlayerReadableFileOutputStream playerReadableFileOutputStream = (PlayerReadableFileOutputStream) outputStream;
            Integer.valueOf(playerReadableFileOutputStream.m27481b());
            if (!playerReadableFileOutputStream.m27482c()) {
                try {
                    mo1423b();
                } catch (Throwable e) {
                    BLog.a(f18742a, "Exception throw", e);
                } catch (Throwable e2) {
                    BLog.a(f18742a, "Exception throw", e2);
                }
            }
        } finally {
            try {
                this.f18748g.close();
            } catch (Throwable e3) {
                BLog.a(f18742a, "Exception is thrown", e3);
            }
        }
    }
}
