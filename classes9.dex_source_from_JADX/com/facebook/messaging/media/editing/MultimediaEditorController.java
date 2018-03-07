package com.facebook.messaging.media.editing;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.view.View;
import android.widget.ImageView;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.Assisted;
import com.facebook.messaging.media.editing.MultimediaEditorView.C13041;
import com.facebook.messaging.media.editing.MultimediaEditorView.C13052;
import com.facebook.messaging.montage.composer.MontageComposerController;
import com.facebook.messaging.montage.composer.MontageComposerController.ComposerEditorListener;
import com.facebook.messaging.photos.editing.PhotoEditingConfig;
import com.facebook.messaging.photos.editing.PhotoEditingController;
import com.facebook.messaging.photos.editing.PhotoEditingController.Listener;
import com.facebook.messaging.photos.editing.PhotoEditingControllerProvider;
import com.facebook.messaging.quickcam.VideoParams;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.InlineVideoView;
import com.facebook.widget.ViewStubHolder;
import com.google.common.base.Preconditions;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mDeleted */
public class MultimediaEditorController {
    public static final ContentType f11564a = ContentType.PHOTO;
    private static final int[] f11565b = new int[]{-1, -10053172, -14627083, -12271929, -15479021, -9979800, -15616, -33239, -2840436, -377780, -1669755, -41823, -2713925, -9025793, -5859897};
    public final MultimediaEditorView f11566c;
    public final ImagePipeline f11567d;
    private final PhotoEditingControllerProvider f11568e;
    public final ExecutorService f11569f;
    public PhotoEditingController f11570g;
    @Nullable
    private Random f11571h;
    @Nullable
    public ComposerEditorListener f11572i;
    public ContentType f11573j = f11564a;
    @Nullable
    public VideoParams f11574k;
    @Nullable
    public Uri f11575l;
    public boolean f11576m = true;

    /* compiled from: mDeleted */
    public class C13001 implements Listener {
        final /* synthetic */ MultimediaEditorController f11560a;

        public C13001(MultimediaEditorController multimediaEditorController) {
            this.f11560a = multimediaEditorController;
        }

        public final void mo442a() {
            boolean z;
            MultimediaEditorController multimediaEditorController = this.f11560a;
            if (this.f11560a.f11570g.f16093n || this.f11560a.f11570g.f16092m) {
                z = false;
            } else {
                z = true;
            }
            multimediaEditorController.m12220a(z);
        }

        public final void mo443b() {
            this.f11560a.f11566c.requestFocus();
        }
    }

    /* compiled from: mDeleted */
    public class C13012 {
        public final /* synthetic */ MultimediaEditorController f11561a;

        C13012(MultimediaEditorController multimediaEditorController) {
            this.f11561a = multimediaEditorController;
        }
    }

    /* compiled from: mDeleted */
    public class C13023 extends BaseBitmapDataSubscriber {
        final /* synthetic */ MultimediaEditorController f11562a;

        public C13023(MultimediaEditorController multimediaEditorController) {
            this.f11562a = multimediaEditorController;
        }

        protected final void m12209a(@Nullable Bitmap bitmap) {
            if (bitmap != null) {
                this.f11562a.m12218a(bitmap);
            }
        }

        protected final void m12210f(DataSource<CloseableReference<CloseableImage>> dataSource) {
        }
    }

    /* compiled from: mDeleted */
    public enum ContentType {
        PHOTO,
        VIDEO,
        FREEFORM
    }

    @Inject
    public MultimediaEditorController(@Assisted MultimediaEditorView multimediaEditorView, @Assisted PhotoEditingConfig photoEditingConfig, ImagePipeline imagePipeline, PhotoEditingControllerProvider photoEditingControllerProvider, ExecutorService executorService) {
        this.f11566c = multimediaEditorView;
        this.f11569f = executorService;
        this.f11567d = imagePipeline;
        this.f11568e = photoEditingControllerProvider;
        this.f11570g = this.f11568e.m16266a(photoEditingConfig, multimediaEditorView, multimediaEditorView.getLayers(), multimediaEditorView.getPhotoEditingControls(), multimediaEditorView.getTextStyles(), multimediaEditorView.getDeleteLayerButton());
        this.f11570g.f16091l = new C13001(this);
        m12213j();
        m12216n();
    }

    private void m12213j() {
        MultimediaEditorView multimediaEditorView = this.f11566c;
        multimediaEditorView.f11584c = new C13012(this);
        multimediaEditorView.getDoneButton().setOnClickListener(new C13041(multimediaEditorView));
        View cancelButton = multimediaEditorView.getCancelButton();
        if (cancelButton != null) {
            cancelButton.setOnClickListener(new C13052(multimediaEditorView));
        }
    }

    public final void m12217a() {
        if (this.f11572i != null) {
            ComposerEditorListener composerEditorListener;
            switch (this.f11573j) {
                case PHOTO:
                    ViewStubHolder imagePreviewStubHolder = this.f11566c.getImagePreviewStubHolder();
                    Preconditions.checkArgument(imagePreviewStubHolder.c());
                    ComposerEditorListener composerEditorListener2 = this.f11572i;
                    MontageComposerController.m12933a(composerEditorListener2.f12464a, composerEditorListener2.f12464a.f12471f.m13013a(this.f11570g.m16252a(imagePreviewStubHolder.a())), true);
                    return;
                case VIDEO:
                    composerEditorListener = this.f11572i;
                    MontageComposerController.m12933a(composerEditorListener.f12464a, composerEditorListener.f12464a.f12471f.m13014a(this.f11575l), false);
                    this.f11566c.m12232f();
                    return;
                case FREEFORM:
                    composerEditorListener = this.f11572i;
                    MontageComposerController.m12933a(composerEditorListener.f12464a, composerEditorListener.f12464a.f12471f.m13013a(this.f11570g.m16264s()), true);
                    this.f11566c.m12232f();
                    return;
                default:
                    throw new IllegalStateException("Unsupported content type: " + this.f11573j);
            }
        }
    }

    public final void m12218a(Bitmap bitmap) {
        m12212a(ContentType.PHOTO);
        ViewStubHolder imagePreviewStubHolder = this.f11566c.getImagePreviewStubHolder();
        ((ImageView) imagePreviewStubHolder.a()).setImageBitmap(bitmap);
        imagePreviewStubHolder.f();
    }

    public final void m12219a(Uri uri, @Nullable VideoParams videoParams) {
        boolean z;
        m12212a(ContentType.VIDEO);
        this.f11575l = uri;
        this.f11574k = videoParams;
        VideoDataSourceBuilder videoDataSourceBuilder = new VideoDataSourceBuilder();
        videoDataSourceBuilder.a = this.f11575l;
        videoDataSourceBuilder = videoDataSourceBuilder;
        videoDataSourceBuilder.f = StreamSourceType.FROM_LOCAL_STORAGE;
        VideoPlayerParamsBuilder a = new VideoPlayerParamsBuilder().a(videoDataSourceBuilder.i());
        a.g = true;
        VideoPlayerParams m = a.m();
        MultimediaEditorView multimediaEditorView = this.f11566c;
        if (videoParams == null) {
            z = false;
        } else {
            z = Source.QUICKCAM_FRONT.equals(videoParams.f16600d);
        }
        ViewStubHolder videoPreviewStubHolder = multimediaEditorView.getVideoPreviewStubHolder();
        InlineVideoView inlineVideoView = (InlineVideoView) videoPreviewStubHolder.a();
        inlineVideoView.setScaleX(z ? -1.0f : 1.0f);
        inlineVideoView.setVideoData(m);
        inlineVideoView.b(EventTriggerType.BY_AUTOPLAY);
        videoPreviewStubHolder.f();
    }

    public final void m12221b() {
        if (!ContentType.FREEFORM.equals(this.f11573j)) {
            m12212a(ContentType.FREEFORM);
            m12214k();
        }
    }

    public final void m12220a(boolean z) {
        if (z) {
            this.f11566c.m12231e();
        } else {
            this.f11566c.m12230b();
        }
    }

    private void m12214k() {
        m12211a(-1);
    }

    public final void m12223f() {
        if (this.f11571h == null) {
            this.f11571h = new Random();
        }
        m12211a(f11565b[this.f11571h.nextInt(f11565b.length)]);
    }

    private void m12211a(@ColorInt int i) {
        this.f11566c.setBackgroundColor(i);
        this.f11570g.f16102w = i;
    }

    public final void m12222c(boolean z) {
        this.f11566c.setEnabled(z);
    }

    public final boolean m12224h() {
        if (this.f11570g.m16255c()) {
            this.f11570g.m16253a();
            return true;
        } else if (this.f11570g.m16263o()) {
            this.f11570g.m16262n();
            return true;
        } else if (!this.f11576m) {
            return false;
        } else {
            if (this.f11570g.m16254b()) {
                this.f11566c.m12233g();
                return true;
            }
            m12215l(this);
            return true;
        }
    }

    public static void m12215l(MultimediaEditorController multimediaEditorController) {
        if (multimediaEditorController.f11570g.m16254b()) {
            multimediaEditorController.f11566c.m12233g();
        } else {
            multimediaEditorController.m12216n();
        }
    }

    private void m12212a(ContentType contentType) {
        if (this.f11573j != contentType) {
            m12216n();
            this.f11573j = contentType;
        }
    }

    private void m12216n() {
        this.f11570g.m16265t();
        this.f11570g.m16256d();
        this.f11570g.m16257h();
        this.f11573j = f11564a;
        this.f11575l = null;
        this.f11574k = null;
        MultimediaEditorView multimediaEditorView = this.f11566c;
        ViewStubHolder imagePreviewStubHolder = multimediaEditorView.getImagePreviewStubHolder();
        if (imagePreviewStubHolder.c()) {
            imagePreviewStubHolder.e();
            ((ImageView) imagePreviewStubHolder.a()).setImageBitmap(null);
        }
        multimediaEditorView.getVideoPreviewStubHolder().e();
    }
}
