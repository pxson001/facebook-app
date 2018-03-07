package com.facebook.video.server;

import com.facebook.common.iolite.ProgressOutputStream.Listener;
import com.facebook.video.server.VideoServer.VideoServerWorker;
import com.facebook.video.server.VideoServer.VideoServerWorker.RequestLiveInfoImpl;
import com.google.android.exoplayer.upstream.TransferListener;

/* compiled from: comment_edit */
class VideoServer$VideoServerWorker$3 implements Listener {
    final /* synthetic */ Listener f19556a;
    final /* synthetic */ RequestLiveInfoImpl f19557b;
    final /* synthetic */ TransferListener f19558c;
    final /* synthetic */ VideoServerWorker f19559d;

    VideoServer$VideoServerWorker$3(VideoServerWorker videoServerWorker, Listener listener, RequestLiveInfoImpl requestLiveInfoImpl, TransferListener transferListener) {
        this.f19559d = videoServerWorker;
        this.f19556a = listener;
        this.f19557b = requestLiveInfoImpl;
        this.f19558c = transferListener;
    }

    public final void m28274a(long j, long j2) {
        this.f19556a.a(j, j2);
        this.f19557b.b(j);
        if (this.f19558c != null) {
            this.f19558c.a((int) j);
        }
    }
}
