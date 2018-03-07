package com.facebook.photos.tagging.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.base.tagging.TagPoint;
import com.facebook.photos.base.tagging.TaggablePhoto;
import com.facebook.photos.creativeediting.utilities.PhotoOverlayObjectMapper;
import com.facebook.photos.creativeediting.utilities.RotateRectfHelper;
import com.facebook.photos.galleryutil.GlobalOnLayoutHelper;
import com.facebook.photos.galleryutil.VisibilityAnimator;
import com.facebook.photos.photogallery.PhotoView;
import com.facebook.photos.taggablegallery.TaggablePhotoGalleryFragment;
import com.facebook.photos.taggablegallery.TaggablePhotoGalleryFragment.10;
import com.facebook.photos.tagging.shared.FaceBoxesView;
import com.facebook.photos.tagging.shared.FaceBoxesView.FaceBoxClickListener;
import com.facebook.photos.tagging.shared.VignetteOverlay;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.photos.tagging.ui.TagsView.C09613;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.widget.images.UrlImage.ProgressBarMode;
import com.facebook.widget.images.zoomableimageview.SimpleZoomableImageViewListener;
import com.facebook.widget.images.zoomableimageview.ZoomableImageView;
import com.facebook.widget.images.zoomableimageview.ZoomableImageView.ImageModeListener;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: interstitial_context */
public class TaggablePhotoView extends PhotoView<TaggablePhoto> {
    public static final String f10958a = TaggablePhotoView.class.getSimpleName();
    public TagsView f10959b;
    public FaceBoxesView f10960c;
    public VignetteOverlay f10961d;
    private VisibilityAnimator f10962e;
    public VisibilityAnimator f10963f;
    public 10 f10964g;
    public boolean f10965h;
    public boolean f10966i;
    public boolean f10967j;
    private PerformanceLogger f10968k;
    private MarkerConfig f10969l;
    private ViewHelperViewAnimatorFactory f10970m;
    public boolean f10971n;
    public FaceBoxConverter f10972o;
    public boolean f10973p;
    public boolean f10974q;
    public RectF f10975r = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    public PhotoOverlayObjectMapper f10976s;
    private TagStore f10977t;
    private FaceBoxStore f10978u;

    /* compiled from: interstitial_context */
    class C09491 implements FaceBoxClickListener {
        final /* synthetic */ TaggablePhotoView f10954a;

        C09491(TaggablePhotoView taggablePhotoView) {
            this.f10954a = taggablePhotoView;
        }

        public final void m12957a(RectF rectF) {
            if (this.f10954a.f10964g != null) {
                FaceBox a = this.f10954a.f10972o.m12941a(rectF);
                if (a == null) {
                    BLog.b(TaggablePhotoView.f10958a, "Retrieved Box is not a valid FaceBox");
                    return;
                }
                10 10 = this.f10954a.f10964g;
                TaggablePhotoView aA = TaggablePhotoGalleryFragment.aA(10.a);
                10.a.aU.m12998a(TaggablePhotoGalleryFragment.az(10.a), aA.m12971a(a), true, aA.f10972o);
            }
        }
    }

    /* compiled from: interstitial_context */
    public class C09502 {
        public final /* synthetic */ TaggablePhotoView f10955a;

        C09502(TaggablePhotoView taggablePhotoView) {
            this.f10955a = taggablePhotoView;
        }

        public final void m12958b(Tag tag) {
            if (this.f10955a.f10964g != null) {
                Tag tag2 = (Tag) this.f10955a.f10976s.a(tag);
                Preconditions.checkState(tag2 != null);
                this.f10955a.f10964g.a(tag2);
            }
        }
    }

    /* compiled from: interstitial_context */
    class C09513 extends SimpleZoomableImageViewListener {
        final /* synthetic */ TaggablePhotoView f10956a;

        C09513(TaggablePhotoView taggablePhotoView) {
            this.f10956a = taggablePhotoView;
        }

        public final void m12959a(Matrix matrix) {
            if (this.f10956a.f10966i || this.f10956a.m12979i()) {
                this.f10956a.f10959b.m13009a(this.f10956a.f10965h);
            }
            if (this.f10956a.f10966i || this.f10956a.f10960c.isShown()) {
                TaggablePhotoView.m12970v(this.f10956a);
            }
            if (this.f10956a.f10966i || this.f10956a.f10963f.a()) {
                this.f10956a.f10961d.setTransformMatrix(matrix);
            }
            10 10;
            if (this.f10956a.getZoomableImageView().getScale() > 1.0f) {
                if (!this.f10956a.f10965h) {
                    if (this.f10956a.f10964g != null) {
                        10 = this.f10956a.f10964g;
                    }
                    this.f10956a.f10965h = true;
                }
            } else if (this.f10956a.f10965h) {
                if (this.f10956a.f10964g != null) {
                    this.f10956a.f10959b.m13009a(false);
                    10 = this.f10956a.f10964g;
                }
                this.f10956a.f10965h = false;
            }
        }

        public final void m12960a(PointF pointF, PointF pointF2) {
            if ((!this.f10956a.f10960c.isShown() || !this.f10956a.f10960c.isEnabled() || !this.f10956a.f10960c.a(pointF)) && this.f10956a.f10964g != null) {
                10 10 = this.f10956a.f10964g;
                if (10.a.aA && 10.a.ay) {
                    if (10.a.aK == null) {
                        TaggablePhotoGalleryFragment.at(10.a);
                    }
                    if (pointF2 != null && TaggablePhotoGalleryFragment.aA(10.a).f10861e) {
                        10.a.aU.m12998a(TaggablePhotoGalleryFragment.az(10.a), new TagPoint(pointF2, 10.a.aK), false, TaggablePhotoGalleryFragment.aA(10.a).f10972o);
                    }
                } else if (!10.a.aw) {
                    if (10.a.ax) {
                        TaggablePhotoGalleryFragment.aB(10.a);
                    } else {
                        TaggablePhotoGalleryFragment.aC(10.a);
                    }
                }
            }
        }

        public final void m12961b(PointF pointF, PointF pointF2) {
            if (this.f10956a.f10964g != null) {
                10 10 = this.f10956a.f10964g;
                if (pointF2 != null && TaggablePhotoGalleryFragment.aA(10.a).f10861e && 10.a.aA && 10.a.ay) {
                    10.a.aU.m12998a(TaggablePhotoGalleryFragment.az(10.a), new TagPoint(pointF2, 10.a.aK), false, TaggablePhotoGalleryFragment.aA(10.a).f10972o);
                }
            }
        }

        public final void m12962c() {
            this.f10956a.setTagsAndFaceboxesEnabled(false);
        }

        public final void m12963d() {
            this.f10956a.setTagsAndFaceboxesEnabled(true);
        }
    }

    /* compiled from: interstitial_context */
    public class C09524 implements ImageModeListener {
        final /* synthetic */ TaggablePhotoView f10957a;

        public C09524(TaggablePhotoView taggablePhotoView) {
            this.f10957a = taggablePhotoView;
        }

        public final void m12964a() {
            this.f10957a.m12986q();
            this.f10957a.f10959b.bringToFront();
            if (this.f10957a.f10973p) {
                this.f10957a.m12984n();
            }
            if (this.f10957a.f10974q) {
                this.f10957a.m12975a(false);
            }
        }
    }

    public static void m12966a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((TaggablePhotoView) obj).m12965a((PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), ViewHelperViewAnimatorFactory.a(injectorLike), FaceBoxConverter.m12936a(injectorLike), PhotoOverlayObjectMapper.a(injectorLike), TagStore.a(injectorLike), FaceBoxStore.a(injectorLike));
    }

    public TaggablePhotoView(Context context) {
        super(context);
        m12968s();
    }

    private void m12968s() {
        Class cls = TaggablePhotoView.class;
        m12966a((Object) this, getContext());
        this.f10859c.setProgressBarMode(ProgressBarMode.PROGRESS_BAR_INDETERMINATE_WITH_PLACEHOLDER);
        this.f10971n = false;
        this.f10960c = new FaceBoxesView(getContext());
        this.f10960c.i = new C09491(this);
        addView(this.f10960c, new LayoutParams(-1, -1));
        this.f10959b = new TagsView(getContext(), getZoomableImageView());
        this.f10959b.f11018g = new C09502(this);
        addView(this.f10959b, new LayoutParams(-1, -1));
        this.f10961d = new VignetteOverlay(getContext());
        addView(this.f10961d, new LayoutParams(-1, -1));
        getZoomableImageView().Q = new C09524(this);
        getZoomableImageView().a(new C09513(this));
        this.f10962e = new VisibilityAnimator(this.f10959b, 150, false, this.f10970m);
        this.f10963f = new VisibilityAnimator(this.f10961d, 300, false, this.f10970m);
        m12967c(false);
        m12985o();
        m12976b(false);
    }

    public final void m12975a(boolean z) {
        if (this.f10859c == null || !this.f10859c.d()) {
            this.f10974q = true;
            return;
        }
        this.f10974q = false;
        m12969u();
        this.f10962e.a(z);
    }

    @Inject
    private void m12965a(@Nullable PerformanceLogger performanceLogger, ViewHelperViewAnimatorFactory viewHelperViewAnimatorFactory, FaceBoxConverter faceBoxConverter, PhotoOverlayObjectMapper photoOverlayObjectMapper, TagStore tagStore, FaceBoxStore faceBoxStore) {
        this.f10968k = performanceLogger;
        this.f10970m = viewHelperViewAnimatorFactory;
        this.f10972o = faceBoxConverter;
        this.f10976s = photoOverlayObjectMapper;
        this.f10977t = tagStore;
        this.f10978u = faceBoxStore;
    }

    public final void m12974a(@Nullable TaggablePhoto taggablePhoto) {
        super.mo612a(taggablePhoto);
        List list = null;
        List a = Lists.a();
        if (taggablePhoto != null) {
            int i;
            RectF rectF = this.f10975r;
            if (taggablePhoto instanceof LocalPhoto) {
                i = ((LocalPhoto) taggablePhoto).e;
                rectF = RotateRectfHelper.a(this.f10975r, RotateRectfHelper.a(i));
            } else {
                i = 0;
            }
            this.f10972o.m12945a(this.f10975r, this.f10978u.a(taggablePhoto), i);
            this.f10976s.a(this.f10975r, i);
            list = FaceBoxConverter.m12937a(this.f10978u.a(taggablePhoto), rectF, i);
            a = this.f10976s.a(this.f10977t.a(taggablePhoto));
            if (this.f10968k != null) {
                this.f10969l = new MarkerConfig(1310735, "FaceBoxesTimeToDisplay");
                this.f10969l.e = String.valueOf(taggablePhoto.a);
                this.f10969l.a(0.2d);
            }
        }
        this.f10959b.m13008a(a, this.f10967j);
        this.f10959b.setFaceBoxRects(list);
        m12967c(false);
        m12976b(false);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -126193523);
        super.onDetachedFromWindow();
        if (!(this.f10968k == null || this.f10969l == null)) {
            this.f10968k.f(this.f10969l);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1488723245, a);
    }

    public void setTagsAndFaceboxesEnabled(boolean z) {
        this.f10959b.setEnabled(z);
        this.f10960c.setEnabled(z);
    }

    public final void m12977g() {
        if (this.f10968k != null && this.f10969l != null) {
            this.f10968k.a(this.f10969l, false);
            if (this.f10978u.c((TaggablePhoto) this.f10858b) && this.f10968k.e(this.f10969l)) {
                this.f10968k.a(this.f10969l, 1.0d);
            }
        }
    }

    private void m12969u() {
        TagsView tagsView = this.f10959b;
        GlobalOnLayoutHelper.c(tagsView, new C09613(tagsView, this.f10965h));
    }

    public final void m12978h() {
        if (this.f10977t.a((TaggablePhoto) this.f10858b) != null) {
            for (Tag tag : new ArrayList(this.f10977t.a((TaggablePhoto) this.f10858b))) {
                Object obj;
                if (this.f10976s.c.contains(tag.a.e().x, tag.a.e().y)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    this.f10964g.a(tag);
                }
            }
        }
        this.f10959b.m13008a(this.f10976s.a(this.f10977t.a((TaggablePhoto) this.f10858b)), this.f10967j);
        if (m12979i()) {
            m12969u();
        }
    }

    public final boolean m12979i() {
        return this.f10962e.a();
    }

    public final void mo613j() {
        m12975a(true);
    }

    public final void m12981k() {
        m12982l();
        m12967c(true);
    }

    private void m12967c(boolean z) {
        this.f10962e.b(z);
    }

    public final void m12982l() {
        this.f10959b.m13006a();
    }

    public Rect getSelectedRemovableTagDisplayRect() {
        Rect rect;
        TagsView tagsView = this.f10959b;
        if (tagsView.f11017f != null) {
            Window window = ((Activity) tagsView.getContext()).getWindow();
            TagView tagView = tagsView.f11017f;
            Rect rect2 = new Rect();
            int[] iArr = new int[2];
            tagView.getLocationInWindow(iArr);
            rect2.set(iArr[0], iArr[1], iArr[0] + tagView.getWidth(), iArr[1] + tagView.getHeight());
            if (1 == 0) {
                Rect rect3 = new Rect();
                window.getDecorView().getWindowVisibleDisplayFrame(rect3);
                rect2.offset(0, -rect3.top);
            }
            rect = rect2;
        } else {
            rect = null;
        }
        return rect;
    }

    public final void m12983m() {
        int i;
        if (this.f10960c.isShown()) {
            m12984n();
        }
        if (this.f10858b instanceof LocalPhoto) {
            i = ((LocalPhoto) this.f10858b).e;
        } else {
            i = 0;
        }
        this.f10959b.setFaceBoxRects(FaceBoxConverter.m12937a(this.f10978u.a((TaggablePhoto) this.f10858b), this.f10975r, i));
        if (m12979i()) {
            m12969u();
        }
        if (this.f10968k != null && this.f10969l != null) {
            this.f10968k.b(this.f10969l);
        }
    }

    public final void m12984n() {
        if (this.f10859c == null || !this.f10859c.d()) {
            this.f10973p = true;
            return;
        }
        this.f10973p = false;
        this.f10960c.setVisibility(0);
        this.f10960c.setFaceBoxes(this.f10972o.m12944a(this.f10978u.a((TaggablePhoto) this.f10858b)));
        m12970v(this);
        if (this.f10971n) {
            this.f10960c.a();
        }
    }

    public static void m12970v(TaggablePhotoView taggablePhotoView) {
        ZoomableImageView zoomableImageView = taggablePhotoView.getZoomableImageView();
        if (zoomableImageView != null && zoomableImageView.getDrawable() != null && zoomableImageView.getImageMatrix() != null) {
            RectF rectF = new RectF();
            rectF.left = (float) zoomableImageView.getLeft();
            rectF.top = (float) zoomableImageView.getTop();
            rectF.bottom = (float) (zoomableImageView.getTop() + zoomableImageView.getPhotoHeight());
            rectF.right = (float) (zoomableImageView.getLeft() + zoomableImageView.getPhotoWidth());
            zoomableImageView.getPhotoDisplayMatrix().mapRect(rectF);
            RectF rectF2 = new RectF(0.0f, 0.0f, (float) zoomableImageView.getPhotoWidth(), (float) zoomableImageView.getPhotoHeight());
            FaceBoxesView faceBoxesView = taggablePhotoView.f10960c;
            int width = (int) rectF2.width();
            int height = (int) rectF2.height();
            Preconditions.checkNotNull(rectF);
            Preconditions.checkNotNull(rectF2);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(rectF2, rectF, ScaleToFit.FILL);
            faceBoxesView.a(width, height, matrix);
        }
    }

    public final void m12985o() {
        this.f10960c.setVisibility(8);
    }

    public final void m12972a(PointF pointF, float f) {
        this.f10961d.setPosition(pointF);
        this.f10961d.setRadius(f);
        this.f10963f.c();
    }

    public final void m12976b(boolean z) {
        this.f10963f.b(z);
    }

    protected void m12986q() {
    }

    @Nullable
    public final FaceBox m12971a(FaceBox faceBox) {
        return this.f10972o.m12942a(faceBox);
    }
}
