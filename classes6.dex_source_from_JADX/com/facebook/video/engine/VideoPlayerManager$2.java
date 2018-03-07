package com.facebook.video.engine;

import android.net.Uri;
import android.os.RemoteException;
import com.facebook.debug.log.BLog;
import com.facebook.exoplayer.ipc.VideoPlayRequest;

/* compiled from: composer_text_start */
public class VideoPlayerManager$2 implements Runnable {
    final /* synthetic */ String f18828a;
    final /* synthetic */ VideoDataSource f18829b;
    final /* synthetic */ VideoPlayerManager f18830c;

    public VideoPlayerManager$2(VideoPlayerManager videoPlayerManager, String str, VideoDataSource videoDataSource) {
        this.f18830c = videoPlayerManager;
        this.f18828a = str;
        this.f18829b = videoDataSource;
    }

    private void m27533a() {
        Throwable e;
        VideoPlayRequest videoPlayRequest = null;
        VideoPlayRequest a;
        try {
            Uri uri = this.f18829b.b;
            a = ((VideoPlayRequestBuilder) this.f18830c.S.get()).a(this.f18828a, "", this.f18829b.b, this.f18829b.d, this.f18829b.f);
            try {
                this.f18830c.M.a(this.f18830c.M.a(a), this.f18829b.b);
                if (a != null) {
                    a.close();
                }
            } catch (RemoteException e2) {
                e = e2;
                try {
                    BLog.b("VideoPlayerManager", e, "Failed to prepare exo service", new Object[0]);
                    if (a != null) {
                        a.close();
                    }
                } catch (Throwable th) {
                    e = th;
                    videoPlayRequest = a;
                    if (videoPlayRequest != null) {
                        videoPlayRequest.close();
                    }
                    throw e;
                }
            }
        } catch (RemoteException e3) {
            e = e3;
            a = null;
            BLog.b("VideoPlayerManager", e, "Failed to prepare exo service", new Object[0]);
            if (a != null) {
                a.close();
            }
        } catch (Throwable th2) {
            e = th2;
            if (videoPlayRequest != null) {
                videoPlayRequest.close();
            }
            throw e;
        }
    }

    public void run() {
        try {
            m27533a();
        } catch (Throwable e) {
            BLog.b("VideoPlayerManager", e, "Unexpected exception in exo service prepare", new Object[0]);
        }
    }
}
