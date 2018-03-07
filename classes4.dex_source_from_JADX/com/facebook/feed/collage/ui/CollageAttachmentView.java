package com.facebook.feed.collage.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.util.AttributeSet;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.attachments.photos.ui.PostPostBadge;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.GenericDraweeHierarchyBuilderMethodAutoProvider;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.collage.CollageItem;
import com.facebook.feed.collage.CollageLayoutCalculator;
import com.facebook.feed.rows.util.VideoPlayIconDrawingHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: oat_mmap */
public class CollageAttachmentView<T extends CollageItem> extends FrameLayout {
    private static final String f6318g = CollageAttachmentView.class.getSimpleName();
    @Inject
    Resources f6319a;
    @Inject
    GenericDraweeHierarchyBuilder f6320b;
    @Inject
    AbstractFbErrorReporter f6321c;
    @Inject
    DialtoneController f6322d;
    @Inject
    VideoPlayIconDrawingHelper f6323e;
    @Inject
    QeAccessor f6324f;
    private Drawable f6325h;
    private Rect f6326i;
    public MultiDraweeHolder<GenericDraweeHierarchy> f6327j;
    public PostPostBadge f6328k;
    public int f6329l;
    private final TextLayoutBuilder f6330m = new TextLayoutBuilder();
    private final Paint f6331n = new Paint();
    private boolean f6332o;
    @Nullable
    public CollageLayoutCalculator<T> f6333p;
    private CollageAttachmentAccessibilityHelper f6334q;
    public String[] f6335r;
    private GestureDetectorCompat f6336s;
    private CollageGestureListener f6337t;
    @Nullable
    public OnImageClickListener<T> f6338u;
    private boolean f6339v = false;

    /* compiled from: oat_mmap */
    public interface OnImageClickListener<C extends CollageItem> {
        void mo565a(CollageAttachmentView<C> collageAttachmentView, C c, int i);
    }

    /* compiled from: oat_mmap */
    class CollageGestureListener extends SimpleOnGestureListener {
        final /* synthetic */ CollageAttachmentView f6344a;

        public CollageGestureListener(CollageAttachmentView collageAttachmentView) {
            this.f6344a = collageAttachmentView;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (this.f6344a.f6338u == null) {
                return false;
            }
            for (int i = 0; i < this.f6344a.f6333p.m6775a().size(); i++) {
                if (((ImageStateHolder) this.f6344a.f6327j.m6817b(i)).f6345a.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.f6344a.f6338u.mo565a(this.f6344a, (CollageItem) this.f6344a.f6333p.m6775a().get(i), i);
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: oat_mmap */
    class ImageStateHolder extends DraweeHolder<GenericDraweeHierarchy> {
        public final Rect f6345a = new Rect();
        public boolean f6346b = true;

        public ImageStateHolder(GenericDraweeHierarchy genericDraweeHierarchy) {
            super(genericDraweeHierarchy);
        }

        public final void m6821j() {
            this.f6346b = true;
            a(null);
        }
    }

    private static <T extends View> void m6785a(Class<T> cls, T t) {
        m6786a((Object) t, t.getContext());
    }

    private static void m6786a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CollageAttachmentView) obj).m6781a(ResourcesMethodAutoProvider.a(fbInjector), GenericDraweeHierarchyBuilderMethodAutoProvider.m6808b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), (DialtoneController) DialtoneControllerImpl.a(fbInjector), VideoPlayIconDrawingHelper.m6809a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    public CollageAttachmentView(Context context) {
        super(context);
        m6790d();
    }

    public CollageAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m6790d();
    }

    private void m6790d() {
        m6785a(CollageAttachmentView.class, (View) this);
        this.f6325h = this.f6319a.getDrawable(2130838102);
        this.f6327j = new MultiDraweeHolder();
        this.f6337t = new CollageGestureListener(this);
        this.f6336s = new GestureDetectorCompat(getContext(), this.f6337t);
        this.f6326i = new Rect();
        this.f6325h.getPadding(this.f6326i);
        this.f6320b.e(ScaleType.h);
        m6794g(5);
        this.f6328k = null;
        this.f6332o = false;
        this.f6334q = null;
        this.f6335r = null;
        setWillNotDraw(false);
        m6791e();
    }

    public void setOnImageClickListener(@Nullable OnImageClickListener<T> onImageClickListener) {
        this.f6338u = onImageClickListener;
    }

    public final void m6797a(int i) {
        if (this.f6338u != null && this.f6333p.m6775a() != null && i >= 0 && i < getVisibleAttachmentsCount()) {
            this.f6338u.mo565a(this, (CollageItem) this.f6333p.m6775a().get(i), i);
        }
    }

    public final void m6800a(CollageLayoutCalculator<T> collageLayoutCalculator, DraweeController[] draweeControllerArr) {
        boolean z = true;
        int i = 0;
        Preconditions.checkState(this.f6333p == null, "removeControllers() must be called before setting ");
        if (draweeControllerArr.length != collageLayoutCalculator.m6775a().size()) {
            z = false;
        }
        Preconditions.checkState(z);
        this.f6333p = collageLayoutCalculator;
        int length = draweeControllerArr.length;
        m6794g(length);
        this.f6339v = false;
        while (i < length) {
            m6783a((ImageStateHolder) this.f6327j.m6817b(i), draweeControllerArr[i], this.f6333p.f6302g[i]);
            i++;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        length = getPaddingLeft() + getPaddingRight();
        if (!(getWidth() == 0 || getHeight() == 0)) {
            m6795h(getWidth() - length);
        }
        if (getHeight() != paddingTop + this.f6333p.m6773a(getWidth() - length)) {
            requestLayout();
        }
        invalidate();
    }

    public final void m6799a(CollageLayoutCalculator<T> collageLayoutCalculator, DraweeController draweeController) {
        Preconditions.checkState(this.f6333p == null, "removeControllers() must be called before setting controllers");
        this.f6333p = collageLayoutCalculator;
        for (int i = 0; i < this.f6327j.m6820d(); i++) {
            ((ImageStateHolder) this.f6327j.m6817b(i)).f6346b = false;
        }
        ImageStateHolder imageStateHolder = (ImageStateHolder) this.f6327j.m6817b(0);
        imageStateHolder.m6821j();
        imageStateHolder.a(draweeController);
        imageStateHolder.f6346b = true;
        this.f6339v = true;
    }

    public void setInvisiblePhotoCount(int i) {
        this.f6329l = i;
    }

    public final void m6796a() {
        for (int i = 0; i < this.f6327j.m6820d(); i++) {
            ((ImageStateHolder) this.f6327j.m6817b(i)).m6821j();
        }
        this.f6333p = null;
    }

    private void m6794g(int i) {
        while (this.f6327j.m6820d() < i) {
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = this.f6320b;
            genericDraweeHierarchyBuilder.f = this.f6319a.getDrawable(2131362786);
            GenericDraweeHierarchy u = genericDraweeHierarchyBuilder.u();
            u.a().setCallback(this);
            DraweeHolder imageStateHolder = new ImageStateHolder(u);
            getContext();
            this.f6327j.m6814a(imageStateHolder);
        }
    }

    private static void m6783a(ImageStateHolder imageStateHolder, DraweeController draweeController, PointF pointF) {
        imageStateHolder.m6821j();
        ((GenericDraweeHierarchy) imageStateHolder.f()).a(pointF);
        imageStateHolder.a(draweeController);
        imageStateHolder.f6346b = true;
    }

    @VisibleForTesting
    MultiDraweeHolder getImageStateHoldersForTesting() {
        return this.f6327j;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f6333p == null) {
            this.f6321c.a(f6318g, "onDraw() called on unbound View");
            return;
        }
        canvas.save();
        canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
        ImmutableList a = this.f6333p.m6775a();
        for (int i = 0; i < a.size(); i++) {
            ImageStateHolder imageStateHolder = (ImageStateHolder) this.f6327j.m6817b(i);
            if (imageStateHolder.f6346b) {
                imageStateHolder.h().draw(canvas);
                if (((CollageItem) a.get(i)).mo563a()) {
                    this.f6323e.m6811a(canvas, imageStateHolder.f6345a);
                }
                if (m6802b(i)) {
                    m6782a(canvas, imageStateHolder.h().getBounds());
                }
            }
        }
        canvas.restore();
    }

    public final boolean m6802b(int i) {
        return i == getVisibleAttachmentsCount() + -1 && this.f6329l >= 2;
    }

    private void m6791e() {
        this.f6330m.c(this.f6319a.getColor(2131361920)).b(this.f6319a.getDimensionPixelSize(2131430379)).a(Alignment.ALIGN_CENTER);
        this.f6331n.setColor(this.f6319a.getColor(2131363102));
    }

    private void m6782a(Canvas canvas, Rect rect) {
        canvas.drawRect(rect, this.f6331n);
        Layout d = this.f6330m.a(getContext().getString(2131235680, new Object[]{Integer.valueOf(this.f6329l)})).a(rect.width()).d();
        canvas.translate((float) rect.left, (float) (rect.centerY() - (d.getHeight() / 2)));
        d.draw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        if (this.f6333p == null) {
            this.f6321c.a(f6318g, "onMeasure() called on unbound View");
            setMeasuredDimension(size, size);
            super.onMeasure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            return;
        }
        setMeasuredDimension(size, this.f6339v ? this.f6322d.e() : (getPaddingTop() + getPaddingBottom()) + this.f6333p.m6773a(size - (getPaddingLeft() + getPaddingRight())));
        super.onMeasure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 810946781);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f6333p == null) {
            this.f6321c.a(f6318g, "onSizeChanged() called on unbound View");
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -945027303, a);
            return;
        }
        m6795h(i - (getPaddingLeft() + getPaddingRight()));
        LogUtils.g(1326260498, a);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1133764981);
        if (this.f6339v) {
            boolean a2 = this.f6327j.m6816a(motionEvent);
            Logger.a(2, EntryType.UI_INPUT_END, 1499375951, a);
            return a2;
        }
        this.f6336s.a(motionEvent);
        LogUtils.a(1066577430, a);
        return true;
    }

    public final void m6801b() {
        if (this.f6334q == null) {
            this.f6334q = new CollageAttachmentAccessibilityHelper(this);
            ViewCompat.a(this, this.f6334q);
        }
    }

    public final void m6804c() {
        this.f6334q = null;
        ViewCompat.a(this, null);
    }

    public void setContentDescriptions(String[] strArr) {
        this.f6335r = strArr;
    }

    public String[] getContentDescriptions() {
        return this.f6335r;
    }

    @VisibleForTesting
    CollageAttachmentAccessibilityHelper getAccessibilityHelper() {
        return this.f6334q;
    }

    @Nullable
    public final Rect m6803c(int i) {
        Preconditions.checkPositionIndex(i, this.f6327j.m6820d());
        Drawable h = this.f6327j.m6817b(i).h();
        return h == null ? null : h.getBounds();
    }

    public final GenericDraweeHierarchy m6805d(int i) {
        Preconditions.checkPositionIndex(i, this.f6327j.m6820d());
        return (GenericDraweeHierarchy) this.f6327j.m6817b(i).f();
    }

    private void m6795h(int i) {
        Preconditions.checkNotNull(this.f6333p);
        for (int i2 = 0; i2 < this.f6333p.m6775a().size(); i2++) {
            int c;
            ImageStateHolder imageStateHolder = (ImageStateHolder) this.f6327j.m6817b(i2);
            Rect rect = imageStateHolder.f6345a;
            if (this.f6339v) {
                rect.set(0, 0, i, this.f6322d.e());
            } else {
                CollageLayoutCalculator collageLayoutCalculator = this.f6333p;
                int i3 = (i - (collageLayoutCalculator.f6298c * 2)) / collageLayoutCalculator.f6299d;
                int i4 = collageLayoutCalculator.f6298c + (collageLayoutCalculator.f6301f[i2].left * i3);
                int i5 = collageLayoutCalculator.f6298c + (collageLayoutCalculator.f6301f[i2].top * i3);
                rect.set(i4, i5, (collageLayoutCalculator.f6301f[i2].width() * i3) + i4, (i3 * collageLayoutCalculator.f6301f[i2].height()) + i5);
            }
            int a = this.f6333p.m6774a(i2, this.f6326i.left);
            int b = this.f6333p.m6776b(i2, this.f6326i.right);
            if (this.f6324f.a(ExperimentsForNewsFeedAbTestModule.ai, false)) {
                c = this.f6333p.m6777c(i2, this.f6326i.bottom);
            } else {
                c = this.f6326i.bottom;
            }
            imageStateHolder.h().setBounds(a + rect.left, rect.top + this.f6326i.top, rect.right - b, rect.bottom - c);
        }
    }

    int getVisibleAttachmentsCount() {
        Preconditions.checkNotNull(this.f6333p);
        return this.f6333p.m6775a().size();
    }

    public ImmutableList<T> getVisibleAttachments() {
        Preconditions.checkNotNull(this.f6333p);
        return this.f6333p.m6775a();
    }

    final Rect m6806e(int i) {
        return ((ImageStateHolder) this.f6327j.m6817b(i)).f6345a;
    }

    public final boolean m6807f(int i) {
        return ((ImageStateHolder) this.f6327j.m6817b(i)).f6346b;
    }

    int getInvisiblePhotoCount() {
        return this.f6329l;
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.f6334q == null || !this.f6334q.a(motionEvent)) {
            return super.dispatchHoverEvent(motionEvent);
        }
        return true;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1766399596);
        super.onAttachedToWindow();
        this.f6327j.m6812a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -182054367, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 458157379);
        super.onDetachedFromWindow();
        this.f6327j.m6818b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -247875498, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f6327j.m6818b();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f6327j.m6812a();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return this.f6327j.m6815a(drawable) || super.verifyDrawable(drawable);
    }

    private void m6784a(@Nullable OnImageClickListener onImageClickListener, int i) {
        this.f6328k.setOnClickListener(new 1(this, onImageClickListener, i));
    }

    private void m6781a(Resources resources, GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder, AbstractFbErrorReporter abstractFbErrorReporter, DialtoneController dialtoneController, VideoPlayIconDrawingHelper videoPlayIconDrawingHelper, QeAccessor qeAccessor) {
        this.f6319a = resources;
        this.f6320b = genericDraweeHierarchyBuilder;
        this.f6321c = abstractFbErrorReporter;
        this.f6322d = dialtoneController;
        this.f6323e = videoPlayIconDrawingHelper;
        this.f6324f = qeAccessor;
    }

    private void m6792f() {
        if (!this.f6332o) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 83;
            addView(this.f6328k, layoutParams);
            this.f6332o = true;
        }
    }

    public final void m6798a(int i, int i2, OnImageClickListener onImageClickListener, int i3) {
        if (i != 0) {
            m6793g();
            this.f6328k.a(i, i2);
            m6784a(onImageClickListener, i3);
            this.f6328k.setVisibility(0);
        } else if (this.f6328k != null) {
            m6784a(null, 0);
            this.f6328k.setVisibility(8);
        }
    }

    private void m6793g() {
        if (this.f6328k == null) {
            this.f6328k = new PostPostBadge(getContext());
            m6792f();
        }
    }
}
