package com.facebook.composer.facecast.feedattachment;

import android.os.Handler;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.videostreaming.LiveStreamer;
import com.facebook.video.videostreaming.LiveStreamer.LiveStreamerPrefetchingListener;
import com.facebook.video.videostreaming.NetworkSpeedTest;
import com.facebook.video.videostreaming.NetworkSpeedTest.Status;
import com.facebook.video.videostreaming.protocol.VideoBroadcastInitResponse;
import javax.inject.Inject;

/* compiled from: groups_hub_tab */
public class FacecastComposerStateController {
    private final LiveStreamerPrefetchingListener f6422a = new C08091(this);
    private final C08102 f6423b = new C08102(this);
    public LiveStreamer f6424c;
    public FacecastComposerState f6425d;
    public boolean f6426e;
    public boolean f6427f;
    public boolean f6428g;
    public boolean f6429h;
    public FacecastComposerAttachmentController f6430i;
    public FacecastPrefetchingListener f6431j;
    public Handler f6432k;
    public Runnable f6433l;
    private String f6434m;

    /* compiled from: groups_hub_tab */
    public interface FacecastPrefetchingListener {
        void m7809a(VideoBroadcastInitResponse videoBroadcastInitResponse);

        void m7810o();
    }

    /* compiled from: groups_hub_tab */
    class C08091 implements LiveStreamerPrefetchingListener {
        final /* synthetic */ FacecastComposerStateController f6419a;

        C08091(FacecastComposerStateController facecastComposerStateController) {
            this.f6419a = facecastComposerStateController;
        }

        public final void m7853a(VideoBroadcastInitResponse videoBroadcastInitResponse) {
            this.f6419a.f6428g = true;
            this.f6419a.f6431j.m7809a(videoBroadcastInitResponse);
            FacecastComposerStateController.m7855f(this.f6419a);
            FacecastComposerStateController facecastComposerStateController = this.f6419a;
            facecastComposerStateController.f6433l = new C08113(facecastComposerStateController);
            HandlerDetour.b(facecastComposerStateController.f6432k, facecastComposerStateController.f6433l, videoBroadcastInitResponse.speedTestTimeoutSeconds * 1000, -1069202590);
        }

        public final void m7851a(ApiErrorResult apiErrorResult) {
            this.f6419a.f6429h = true;
            FacecastComposerStateController.m7855f(this.f6419a);
        }

        public final void hx_() {
            this.f6419a.f6426e = true;
            FacecastComposerStateController.m7855f(this.f6419a);
        }

        public final void m7852a(NetworkSpeedTest networkSpeedTest) {
            if (networkSpeedTest.state == Status.Succeeded && networkSpeedTest.speedTestPassesThreshold) {
                HandlerDetour.a(this.f6419a.f6432k, this.f6419a.f6433l);
                this.f6419a.f6426e = true;
                FacecastComposerStateController.m7855f(this.f6419a);
            }
        }
    }

    /* compiled from: groups_hub_tab */
    public class C08102 {
        public final /* synthetic */ FacecastComposerStateController f6420a;

        C08102(FacecastComposerStateController facecastComposerStateController) {
            this.f6420a = facecastComposerStateController;
        }
    }

    /* compiled from: groups_hub_tab */
    public class C08113 implements Runnable {
        final /* synthetic */ FacecastComposerStateController f6421a;

        public C08113(FacecastComposerStateController facecastComposerStateController) {
            this.f6421a = facecastComposerStateController;
        }

        public void run() {
            this.f6421a.f6424c.g();
            this.f6421a.f6427f = true;
            FacecastComposerStateController.m7855f(this.f6421a);
        }
    }

    /* compiled from: groups_hub_tab */
    public enum FacecastComposerState {
        CAMERA_PERMISSION_DENIED,
        LOADING,
        NO_CONNECTION,
        WEAK_CONNECTION,
        READY
    }

    @Inject
    public FacecastComposerStateController(LiveStreamer liveStreamer, Handler handler, @Assisted ComposerTargetData composerTargetData, @Assisted FacecastComposerState facecastComposerState) {
        this.f6424c = liveStreamer;
        String valueOf = (composerTargetData == null || composerTargetData.targetType == TargetType.UNDIRECTED) ? null : String.valueOf(composerTargetData.targetId);
        this.f6434m = valueOf;
        this.f6425d = facecastComposerState;
        this.f6432k = handler;
    }

    public final boolean m7856b() {
        return this.f6431j != null;
    }

    public final void m7857c() {
        this.f6428g = false;
        this.f6429h = false;
        this.f6426e = false;
        this.f6427f = false;
        this.f6425d = FacecastComposerState.LOADING;
        this.f6424c.a(this.f6434m);
        this.f6424c.a();
        this.f6424c.m = this.f6422a;
        this.f6424c.n = this.f6423b;
        this.f6424c.h();
    }

    public final void m7858d() {
        this.f6428g = false;
        this.f6429h = false;
        this.f6426e = false;
        this.f6427f = false;
        m7855f(this);
        this.f6424c.m = null;
        this.f6424c.l = null;
        this.f6424c.n = null;
        this.f6424c.i();
        this.f6432k.removeCallbacksAndMessages(null);
    }

    private void m7854a(FacecastComposerState facecastComposerState) {
        if (facecastComposerState != this.f6425d) {
            this.f6425d = facecastComposerState;
            FacecastComposerAttachmentController facecastComposerAttachmentController = this.f6430i;
            FacecastComposerState facecastComposerState2 = this.f6425d;
            FacecastComposerAttachmentController.m7823a(facecastComposerAttachmentController, facecastComposerState2 == FacecastComposerState.READY);
            if (facecastComposerState2 == FacecastComposerState.WEAK_CONNECTION || facecastComposerState2 == FacecastComposerState.NO_CONNECTION) {
                facecastComposerAttachmentController.f6397o.f6424c.i();
            }
            facecastComposerAttachmentController.f6391i.setState(facecastComposerState2);
        }
    }

    public static void m7855f(FacecastComposerStateController facecastComposerStateController) {
        if (facecastComposerStateController.f6429h) {
            facecastComposerStateController.m7854a(FacecastComposerState.NO_CONNECTION);
        } else if (facecastComposerStateController.f6428g && facecastComposerStateController.f6427f) {
            facecastComposerStateController.m7854a(FacecastComposerState.WEAK_CONNECTION);
        } else if (facecastComposerStateController.f6428g && facecastComposerStateController.f6426e) {
            facecastComposerStateController.m7854a(FacecastComposerState.READY);
        } else {
            facecastComposerStateController.m7854a(FacecastComposerState.LOADING);
        }
    }
}
