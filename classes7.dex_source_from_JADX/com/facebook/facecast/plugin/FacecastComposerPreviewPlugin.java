package com.facebook.facecast.plugin;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.WindowManager;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.TransactionImpl;
import com.facebook.composer.facecast.feedattachment.FacecastComposerAttachmentController;
import com.facebook.composer.facecast.feedattachment.FacecastComposerAttachmentController.2;
import com.facebook.facecast.CameraHandlerDelegate;
import com.facebook.facecast.FacecastCamera;
import com.facebook.facecast.FacecastCameraProvider;
import com.facebook.facecast.plugin.FacecastPreviewPlugin.Listener;
import com.facebook.facecast.plugin.FacecastRotateCameraPlugin.Corner;
import com.facebook.facecast.plugin.FacecastRotateCameraPlugin.RotateCameraClickListener;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.Builder;
import com.facebook.video.videostreaming.DisplayListenerDelegate;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: broadcast_client_status */
public class FacecastComposerPreviewPlugin extends FacecastAggregatedBasePlugin implements Listener {
    @Inject
    public FacecastCameraProvider f18221c;
    @Inject
    @ForUiThread
    public Handler f18222d;
    public final CameraHandlerDelegate f18223e;
    private final RotateCameraClickListener f18224f;
    public final DisplayListenerDelegate f18225g;
    public final FacecastPreviewPlugin f18226h;
    public final FacecastRotateCameraPlugin f18227i;
    public final FacecastPreviewLabelPlugin f18228j;
    public FacecastCamera f18229k;
    public FacecastComposerAttachmentController f18230l;
    public int f18231m;

    /* compiled from: broadcast_client_status */
    class C15341 implements CameraHandlerDelegate {
        final /* synthetic */ FacecastComposerPreviewPlugin f18218a;

        C15341(FacecastComposerPreviewPlugin facecastComposerPreviewPlugin) {
            this.f18218a = facecastComposerPreviewPlugin;
        }

        public final void q_(int i) {
            this.f18218a.f18226h.m22107a(i, Long.MAX_VALUE);
        }

        public final void mo1390m() {
            if (this.f18218a.f18226h != null) {
                this.f18218a.f18226h.m22113h();
            }
        }

        public final void mo1391n() {
            this.f18218a.f18226h.m22109a(this.f18218a.f18229k);
        }

        public final void mo1392o() {
            this.f18218a.f18226h.m22112b(this.f18218a.f18229k);
            FacecastComposerAttachmentController facecastComposerAttachmentController = this.f18218a.f18230l;
            int i = this.f18218a.f18229k.f17975e;
            TransactionImpl a = facecastComposerAttachmentController.e.a(FacecastComposerAttachmentController.a);
            Builder builder = new Builder(((ComposerDataProviderImpl) ((ProvidesTargetData) Preconditions.checkNotNull(facecastComposerAttachmentController.d.get()))).e());
            builder.a = i;
            ((TransactionImpl) a.a(builder.a())).a();
            this.f18218a.f18227i.m22133g();
        }

        public final void mo1387a(Exception exception) {
            FacecastComposerAttachmentController facecastComposerAttachmentController = this.f18218a.f18230l;
            if (facecastComposerAttachmentController.p.a(FacecastComposerAttachmentController.c)) {
                facecastComposerAttachmentController.m = new AlertDialog.Builder(facecastComposerAttachmentController.g).a(true).b(2131242374).a(2131230726, null).a(new 2(facecastComposerAttachmentController)).a();
                facecastComposerAttachmentController.m.show();
            }
        }
    }

    /* compiled from: broadcast_client_status */
    class C15352 implements RotateCameraClickListener {
        final /* synthetic */ FacecastComposerPreviewPlugin f18219a;

        C15352(FacecastComposerPreviewPlugin facecastComposerPreviewPlugin) {
            this.f18219a = facecastComposerPreviewPlugin;
        }

        public final void mo1393p() {
            this.f18219a.f18229k.m21847a(3, null);
        }
    }

    /* compiled from: broadcast_client_status */
    class C15363 implements DisplayListenerDelegate {
        final /* synthetic */ FacecastComposerPreviewPlugin f18220a;

        C15363(FacecastComposerPreviewPlugin facecastComposerPreviewPlugin) {
            this.f18220a = facecastComposerPreviewPlugin;
        }

        public final void m21981a() {
        }

        public final void m21982a(SurfaceTexture surfaceTexture) {
            this.f18220a.f18229k.m21847a(0, (Object) surfaceTexture);
        }

        public final void m21983b() {
        }

        public final int m21984c() {
            return FacecastComposerPreviewPlugin.getCurrentRotation(this.f18220a);
        }
    }

    public static void m21986a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FacecastComposerPreviewPlugin facecastComposerPreviewPlugin = (FacecastComposerPreviewPlugin) obj;
        FacecastCameraProvider facecastCameraProvider = (FacecastCameraProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FacecastCameraProvider.class);
        Handler b = Handler_ForUiThreadMethodAutoProvider.b(fbInjector);
        facecastComposerPreviewPlugin.f18221c = facecastCameraProvider;
        facecastComposerPreviewPlugin.f18222d = b;
    }

    public static int getCurrentRotation(FacecastComposerPreviewPlugin facecastComposerPreviewPlugin) {
        return ((WindowManager) facecastComposerPreviewPlugin.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public FacecastComposerPreviewPlugin(Context context) {
        this(context, null);
    }

    private FacecastComposerPreviewPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastComposerPreviewPlugin(Context context, AttributeSet attributeSet, int i) {
        int i2;
        super(context, attributeSet, i);
        this.f18223e = new C15341(this);
        this.f18224f = new C15352(this);
        this.f18225g = new C15363(this);
        Class cls = FacecastComposerPreviewPlugin.class;
        m21986a(this, getContext());
        this.f18226h = new FacecastPreviewPlugin(context);
        this.f18226h.f18466p = this;
        this.f18227i = new FacecastRotateCameraPlugin(context);
        this.f18227i.setCorner(Corner.TOP_LEFT);
        this.f18227i.setOnClickListener(this.f18224f);
        this.f18228j = new FacecastPreviewLabelPlugin(context);
        if (Camera.getNumberOfCameras() > 1) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.f18231m = i2;
        m21957a(this.f18226h, this.f18227i, this.f18228j);
    }

    protected final void hE_() {
        super.hE_();
        this.f18229k = this.f18221c.m21853a(this.f18231m);
        this.f18229k.m21849a(this.f18223e);
        this.f18229k.m21848a(this.f18222d.getLooper());
    }

    public final void mo1412g() {
        if (this.f18230l != null) {
            this.f18230l.b();
        }
    }

    public final boolean m21988j() {
        return this.f18229k.m21852g();
    }

    public final void m21989l() {
        this.f18227i.setVisibility(8);
        this.f18228j.setVisibility(8);
    }
}
