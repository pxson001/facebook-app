package com.facebook.video.server;

import com.facebook.common.iolite.ProgressOutputStream;
import com.facebook.common.iolite.ProgressOutputStream.Listener;
import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.video.server.VideoServer.VideoServerWorker;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: comment_edit */
class VideoServer$VideoServerWorker$4 implements AsyncWriter {
    final /* synthetic */ AsyncWriter f19563a;
    final /* synthetic */ Listener f19564b;
    final /* synthetic */ VideoServerWorker f19565c;

    VideoServer$VideoServerWorker$4(VideoServerWorker videoServerWorker, AsyncWriter asyncWriter, Listener listener) {
        this.f19565c = videoServerWorker;
        this.f19563a = asyncWriter;
        this.f19564b = listener;
    }

    public final void m28278a(long j, long j2, final AsyncWriter$Handler asyncWriter$Handler) {
        this.f19563a.a(j, j2, new AsyncWriter$Handler(this) {
            final /* synthetic */ VideoServer$VideoServerWorker$4 f19561b;
            private OutputStream f19562c;

            public final void mo1419a(IOException iOException) {
                asyncWriter$Handler.mo1419a(iOException);
            }

            public final OutputStream mo1418a(FileMetadata fileMetadata) {
                this.f19562c = asyncWriter$Handler.mo1418a(fileMetadata);
                if (this.f19562c == null) {
                    return null;
                }
                return new ProgressOutputStream(this.f19562c, this.f19561b.f19564b);
            }

            public final void mo1420a(OutputStream outputStream, IOException iOException) {
                asyncWriter$Handler.mo1420a(this.f19562c, iOException);
            }
        });
    }
}
