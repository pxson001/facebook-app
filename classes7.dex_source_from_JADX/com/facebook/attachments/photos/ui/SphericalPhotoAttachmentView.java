package com.facebook.attachments.photos.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.TextureView.SurfaceTextureListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.UiThreadExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.touch.SphericalDragDetector.DragListener;
import com.facebook.common.touch.SphericalTouchDetector;
import com.facebook.common.touch.SphericalZoomDetector.ZoomListener;
import com.facebook.common.util.TriState;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.fbui.draggable.Direction;
import com.facebook.fbui.draggable.HorizontalScrollAwareView;
import com.facebook.feed.autoplay.KeepRegisteredVideoPlayerView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.sphericalphoto.SphericalPhotoFragment;
import com.facebook.spherical.HasGlToUIBridge;
import com.facebook.spherical.SphericalMediaTextureView;
import com.facebook.spherical.model.SphericalPhotoParams;
import com.facebook.spherical.model.SphericalRendererBounds.Builder;
import com.facebook.spherical.photo.HasSphericalPhoto;
import com.facebook.spherical.photo.PartialPanoUtil.PanoBounds;
import com.facebook.spherical.photo.PhotoHeadingPlugin;
import com.facebook.spherical.photo.PhotoVRCastParams;
import com.facebook.spherical.photo.PhotoVRCastPlugin;
import com.facebook.spherical.photo.PhotoVRCastPlugin.2;
import com.facebook.spherical.photo.SphericalPhotoIndicatorPlugin;
import com.facebook.spherical.photo.SphericalPhotoTextureView;
import com.facebook.spherical.photo.abtest.ExperimentsForPhotos360AbTestModule;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;
import com.facebook.spherical.ui.SphericalNuxAnimationController;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;
import com.google.common.base.Objects;
import javax.inject.Inject;

/* compiled from: use_cropping */
public class SphericalPhotoAttachmentView extends CustomFrameLayout implements HorizontalScrollAwareView, KeepRegisteredVideoPlayerView, HasGlToUIBridge, HasSphericalPhoto, RecyclerViewKeepAttached {
    public static final Handler f936k = new Handler(Looper.getMainLooper());
    @Inject
    public ImagePipeline f937a;
    @Inject
    public DefaultAndroidThreadUtil f938b;
    @Inject
    public Photos360QEHelper f939c;
    public ImageRequest f940d;
    public CallerContext f941e;
    public SphericalPhotoFragment f942f;
    public PhotoVRCastPlugin f943g;
    public PhotoHeadingPlugin f944h;
    public SphericalPhotoTextureView f945i;
    public SphericalPhotoIndicatorPlugin f946j;
    public GenericDraweeView f947l;
    private DataSource<CloseableReference<CloseableImage>> f948m;
    public boolean f949n;
    public int f950o;
    public boolean f951p;
    public boolean f952q;
    public boolean f953r;
    public boolean f954s;
    public boolean f955t;
    public Photo360TouchListener f956u;
    public SphericalTouchDetector f957v;
    public GestureDetector f958w;
    public ImageRequest f959x;
    public final Runnable f960y;
    public final SurfaceTextureListener f961z;

    /* compiled from: use_cropping */
    class C00821 implements Runnable {
        final /* synthetic */ SphericalPhotoAttachmentView f927a;

        C00821(SphericalPhotoAttachmentView sphericalPhotoAttachmentView) {
            this.f927a = sphericalPhotoAttachmentView;
        }

        public void run() {
            SphericalPhotoAttachmentView.m918r(this.f927a);
        }
    }

    /* compiled from: use_cropping */
    class C00832 implements SurfaceTextureListener {
        final /* synthetic */ SphericalPhotoAttachmentView f928a;

        C00832(SphericalPhotoAttachmentView sphericalPhotoAttachmentView) {
            this.f928a = sphericalPhotoAttachmentView;
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f928a.f946j.i();
            this.f928a.f946j.g = false;
            SphericalPhotoAttachmentView.m916o(this.f928a);
            this.f928a.f945i.k = this.f928a;
            this.f928a.m919a(this.f928a.f940d, this.f928a.f941e);
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return true;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* compiled from: use_cropping */
    class C00843 implements Runnable {
        final /* synthetic */ SphericalPhotoAttachmentView f929a;

        C00843(SphericalPhotoAttachmentView sphericalPhotoAttachmentView) {
            this.f929a = sphericalPhotoAttachmentView;
        }

        public void run() {
            this.f929a.m915n();
        }
    }

    /* compiled from: use_cropping */
    public class C00865 extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
        final /* synthetic */ SphericalPhotoAttachmentView f932a;

        public C00865(SphericalPhotoAttachmentView sphericalPhotoAttachmentView) {
            this.f932a = sphericalPhotoAttachmentView;
        }

        protected final void m904e(DataSource<CloseableReference<CloseableImage>> dataSource) {
            boolean b = dataSource.b();
            CloseableReference closeableReference = (CloseableReference) dataSource.d();
            if (closeableReference != null) {
                if (b) {
                    try {
                        this.f932a.f945i.a(closeableReference);
                    } catch (Throwable th) {
                        closeableReference.close();
                    }
                }
                closeableReference.close();
            }
        }

        protected final void m905f(DataSource<CloseableReference<CloseableImage>> dataSource) {
        }
    }

    /* compiled from: use_cropping */
    public class Photo360TouchListener implements DragListener, ZoomListener {
        final /* synthetic */ SphericalPhotoAttachmentView f933a;
        private boolean f934b = false;

        public Photo360TouchListener(SphericalPhotoAttachmentView sphericalPhotoAttachmentView) {
            this.f933a = sphericalPhotoAttachmentView;
        }

        public final void m906a() {
        }

        public final void m909b() {
            this.f933a.f946j.k();
            this.f933a.f946j.i = false;
            this.f933a.f945i.d();
        }

        public final void m907a(float f, float f2) {
            if (Math.abs(f) > 0.0f && !this.f934b) {
                this.f933a.getParent().requestDisallowInterceptTouchEvent(true);
                this.f934b = true;
            }
            this.f933a.f945i.b(f, 0.0f);
        }

        public final void m910b(float f, float f2) {
            this.f933a.f945i.c(f, 0.0f);
            this.f934b = false;
        }

        public final boolean m911c() {
            return false;
        }

        public final boolean m908a(float f) {
            return false;
        }

        public final void m912d() {
        }
    }

    /* compiled from: use_cropping */
    public class SingleTapConfirm extends SimpleOnGestureListener {
        final /* synthetic */ SphericalPhotoAttachmentView f935a;

        public SingleTapConfirm(SphericalPhotoAttachmentView sphericalPhotoAttachmentView) {
            this.f935a = sphericalPhotoAttachmentView;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f935a.performClick();
            return true;
        }
    }

    public static void m913a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SphericalPhotoAttachmentView sphericalPhotoAttachmentView = (SphericalPhotoAttachmentView) obj;
        ImagePipeline a = ImagePipelineMethodAutoProvider.a(fbInjector);
        DefaultAndroidThreadUtil b = DefaultAndroidThreadUtil.b(fbInjector);
        Photos360QEHelper a2 = Photos360QEHelper.a(fbInjector);
        sphericalPhotoAttachmentView.f937a = a;
        sphericalPhotoAttachmentView.f938b = b;
        sphericalPhotoAttachmentView.f939c = a2;
    }

    public SphericalPhotoAttachmentView(Context context) {
        this(context, null);
    }

    public SphericalPhotoAttachmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SphericalPhotoAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f949n = false;
        this.f950o = 0;
        this.f951p = true;
        this.f952q = false;
        this.f953r = false;
        this.f954s = false;
        this.f955t = true;
        this.f960y = new C00821(this);
        this.f961z = new C00832(this);
        Class cls = SphericalPhotoAttachmentView.class;
        m913a((Object) this, getContext());
        setContentView(2130907189);
        this.f945i = (SphericalPhotoTextureView) findViewById(2131567568);
        this.f947l = (GenericDraweeView) findViewById(2131567569);
        GenericDraweeView genericDraweeView = this.f947l;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        genericDraweeHierarchyBuilder.f = new ColorDrawable(getResources().getColor(2131362786));
        genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder;
        genericDraweeHierarchyBuilder.h = getResources().getDrawable(2130840253);
        genericDraweeView.setHierarchy(genericDraweeHierarchyBuilder.e(ScaleType.h).u());
        this.f945i.setSurfaceTextureListener(this.f961z);
        this.f956u = new Photo360TouchListener(this);
        this.f957v = new SphericalTouchDetector(getContext(), this.f956u, this.f956u, false);
        this.f958w = new GestureDetector(getContext(), new SingleTapConfirm(this));
        this.f946j = new SphericalPhotoIndicatorPlugin(context);
        this.f946j.m = this.f945i;
        addView(this.f946j);
        this.f943g = new PhotoVRCastPlugin(getContext());
        addView(this.f943g);
        if (this.f939c.a.a(ExperimentsForPhotos360AbTestModule.g, false)) {
            this.f944h = new PhotoHeadingPlugin(getContext());
            this.f944h.f = this.f945i;
            addView(this.f944h);
        }
        if (this.f944h != null) {
            this.f946j.n = this.f944h.g;
            this.f944h.b = this.f946j;
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f951p) {
            super.onMeasure(i, i);
        } else {
            super.onMeasure(i, i2);
        }
    }

    public final void m926c() {
        this.f938b.b(new C00843(this));
    }

    private void m915n() {
        this.f946j.g = true;
        setPreviewPhotoVisibility(8);
        if (this.f944h != null) {
            PhotoHeadingPlugin photoHeadingPlugin = this.f944h;
            photoHeadingPlugin.g.c();
            photoHeadingPlugin.g.a(photoHeadingPlugin.c, true, false, 0, photoHeadingPlugin.e);
        }
        SphericalNuxAnimationController sphericalNuxAnimationController = this.f946j.d;
        if (sphericalNuxAnimationController.d != null) {
            sphericalNuxAnimationController.d.cancel();
        }
        this.f953r = true;
        if (this.f946j.h || this.f952q) {
            this.f946j.l();
        }
        if (!(this.f946j.h || this.f952q) || this.f954s) {
            m931k();
        }
        if (this.f952q) {
            this.f937a.c(this.f959x, this.f941e).a(new C00865(this), UiThreadExecutorService.b());
        }
    }

    public final boolean gK_() {
        return true;
    }

    public final void m919a(ImageRequest imageRequest, CallerContext callerContext) {
        final int i = this.f950o + 1;
        this.f950o = i;
        this.f948m = this.f937a.c(imageRequest, callerContext);
        this.f948m.a(new BaseDataSubscriber<CloseableReference<CloseableImage>>(this) {
            final /* synthetic */ SphericalPhotoAttachmentView f931b;

            protected final void m902e(DataSource<CloseableReference<CloseableImage>> dataSource) {
                boolean b = dataSource.b();
                CloseableReference closeableReference = (CloseableReference) dataSource.d();
                if (closeableReference != null) {
                    if (b) {
                        try {
                            if (i == this.f931b.f950o) {
                                this.f931b.f945i.a(closeableReference, this.f931b);
                            }
                        } catch (Throwable th) {
                            closeableReference.close();
                        }
                    }
                    closeableReference.close();
                }
            }

            protected final void m903f(DataSource<CloseableReference<CloseableImage>> dataSource) {
            }
        }, UiThreadExecutorService.b());
    }

    public final boolean m925b(ImageRequest imageRequest, CallerContext callerContext) {
        if (this.f949n) {
            HandlerDetour.a(f936k, this.f960y);
            this.f949n = false;
        }
        if (Objects.equal(this.f940d, imageRequest) && this.f945i.getSurfaceTexture() != null && this.f946j.h) {
            return false;
        }
        this.f946j.i();
        m917p();
        this.f940d = imageRequest;
        this.f941e = callerContext;
        if (!this.f955t) {
            addView(this.f945i, 0);
            this.f955t = true;
        }
        m916o(this);
        return true;
    }

    public void setIsViewSignificantlyVisible(boolean z) {
        this.f946j.h = z;
    }

    public final void m928g() {
        this.f946j.m();
    }

    public final void m929h() {
        if (this.f948m != null) {
            this.f948m.g();
            this.f948m = null;
        }
    }

    public static void m916o(SphericalPhotoAttachmentView sphericalPhotoAttachmentView) {
        sphericalPhotoAttachmentView.setPreviewPhotoVisibility(0);
        sphericalPhotoAttachmentView.f946j.g();
        sphericalPhotoAttachmentView.f946j.c();
    }

    private void m917p() {
        this.f941e = null;
        m918r(this);
        setPreviewPhotoVisibility(0);
        setOnClickListener(null);
        this.f946j.g = false;
        this.f953r = false;
        PhotoVRCastPlugin photoVRCastPlugin = this.f943g;
        photoVRCastPlugin.e.setOnClickListener(null);
        photoVRCastPlugin.e.removeCallbacks(photoVRCastPlugin.h);
        photoVRCastPlugin.e.setVisibility(8);
        if (this.f944h != null) {
            this.f944h.g.b();
        }
    }

    private void setPreviewPhotoVisibility(int i) {
        this.f947l.setVisibility(i);
    }

    public void setPreviewPhotoDraweeController(DraweeController draweeController) {
        this.f947l.setController(draweeController);
    }

    public static void m918r(SphericalPhotoAttachmentView sphericalPhotoAttachmentView) {
        if (sphericalPhotoAttachmentView.f955t) {
            sphericalPhotoAttachmentView.removeView(sphericalPhotoAttachmentView.f945i);
            sphericalPhotoAttachmentView.f955t = false;
        }
    }

    public void setVrCastParamsAndMaybeStartVR(PhotoVRCastParams photoVRCastParams) {
        this.f943g.f = photoVRCastParams;
        PhotoVRCastPlugin photoVRCastPlugin = this.f943g;
        if (photoVRCastPlugin.g == TriState.UNSET) {
            Object obj;
            TriState triState;
            PackageManager packageManager = photoVRCastPlugin.getContext().getPackageManager();
            Intent intent = new Intent();
            intent.setAction("com.oculus.oculus360photos.action.CAST");
            if (packageManager.resolveActivity(intent, 65536) != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                triState = TriState.YES;
            } else {
                triState = TriState.NO;
            }
            photoVRCastPlugin.g = triState;
        }
        if (photoVRCastPlugin.g.asBoolean(false) && photoVRCastPlugin.b.a.a(ExperimentsForPhotos360AbTestModule.h, false)) {
            photoVRCastPlugin.c.b();
            photoVRCastPlugin.e.setVisibility(0);
            photoVRCastPlugin.e.postDelayed(photoVRCastPlugin.h, 5000);
            photoVRCastPlugin.e.setOnClickListener(new 2(photoVRCastPlugin));
            return;
        }
        photoVRCastPlugin.e.setVisibility(8);
    }

    public void setSphericalPhotoParams(SphericalPhotoParams sphericalPhotoParams) {
        this.f945i.i = sphericalPhotoParams;
        if (this.f944h != null) {
            this.f944h.c = sphericalPhotoParams;
        }
    }

    public final void m930j() {
        if (!this.f954s) {
            this.f945i.a();
        }
    }

    public final void m931k() {
        this.f945i.c();
    }

    public final void m932l() {
        this.f946j.u = false;
    }

    public final boolean m923a() {
        return this.f945i != null;
    }

    public SphericalMediaTextureView get360TextureView() {
        return this.f945i;
    }

    public boolean getShouldShowPhoneAnimationInFullScreen() {
        return this.f946j.i;
    }

    public final boolean m927d() {
        return true;
    }

    public final void m922a(EventTriggerType eventTriggerType, int i) {
    }

    public final void m921a(EventTriggerType eventTriggerType) {
    }

    public int getSeekPosition() {
        return 0;
    }

    public final boolean m924a(Direction direction, int i, int i2) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -106350296);
        if (this.f958w.onTouchEvent(motionEvent) || !this.f939c.a.a(ExperimentsForPhotos360AbTestModule.e, false)) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            LogUtils.a(379301497, a);
            return onTouchEvent;
        }
        onTouchEvent = this.f957v.a(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -935021146, a);
        return onTouchEvent;
    }

    public final void m920a(PanoBounds panoBounds, SphericalPhotoParams sphericalPhotoParams) {
        float f = (float) sphericalPhotoParams.h;
        Builder builder = new Builder();
        Builder b = builder.b();
        b.d = panoBounds.d - (f / 2.0f);
        b.c = (-panoBounds.c) + (f / 2.0f);
        if (panoBounds.a + panoBounds.b < 350.0f) {
            builder.e = true;
            b = builder;
            b.b = panoBounds.b - (f / 2.0f);
            b.a = (f / 2.0f) + (-panoBounds.a);
        }
        this.f945i.c = builder.c();
        this.f945i.j = panoBounds;
    }
}
