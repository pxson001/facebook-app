package com.facebook.video.server;

import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.video.server.VideoServer.VideoServerWorker;
import com.google.android.exoplayer.upstream.TransferListener;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nullable;

/* compiled from: comment_edit */
class VideoServer$VideoServerWorker$InstrumentedAsyncWriter implements AsyncWriter {
    final /* synthetic */ VideoServerWorker f19570a;
    private final AsyncWriter f19571b;
    public final String f19572c;
    @Nullable
    public final TransferListener f19573d;

    public VideoServer$VideoServerWorker$InstrumentedAsyncWriter(VideoServerWorker videoServerWorker, AsyncWriter asyncWriter, String str, TransferListener transferListener) {
        this.f19570a = videoServerWorker;
        this.f19571b = asyncWriter;
        this.f19572c = str;
        this.f19573d = transferListener;
    }

    public final void m28282a(long j, long j2, AsyncWriter$Handler asyncWriter$Handler) {
        if (this.f19573d != null) {
            this.f19573d.b();
        }
        VideoServerWorker.a(this.f19570a, j, j2, this.f19572c);
        final AsyncWriter$Handler asyncWriter$Handler2 = asyncWriter$Handler;
        final long j3 = j;
        final long j4 = j2;
        this.f19571b.a(j, j2, new AsyncWriter$Handler(this) {
            final /* synthetic */ VideoServer$VideoServerWorker$InstrumentedAsyncWriter f19569d;

            public final void mo1419a(IOException iOException) {
                if (this.f19569d.f19573d != null) {
                    this.f19569d.f19573d.c();
                }
                asyncWriter$Handler2.mo1419a(iOException);
            }

            public final OutputStream mo1418a(FileMetadata fileMetadata) {
                OutputStream a = asyncWriter$Handler2.mo1418a(fileMetadata);
                VideoServerWorker.b(this.f19569d.f19570a, j3, j4, this.f19569d.f19572c);
                return a;
            }

            public final void mo1420a(OutputStream outputStream, IOException iOException) {
                asyncWriter$Handler2.mo1420a(outputStream, iOException);
                if (this.f19569d.f19573d != null) {
                    this.f19569d.f19573d.c();
                }
                VideoServerWorker.a(this.f19569d.f19570a, this.f19569d.f19572c);
            }
        });
    }
}
