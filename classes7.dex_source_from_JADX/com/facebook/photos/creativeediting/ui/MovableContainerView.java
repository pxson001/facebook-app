package com.facebook.photos.creativeediting.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.photos.creativeediting.interfaces.UriAwarePhotoOverlayItem;
import com.facebook.photos.creativeediting.model.PhotoOverlayItemFactory;
import com.facebook.photos.creativeediting.model.PhotoOverlayItemFactory.PhotoOverlayItemBuilder;
import com.facebook.photos.creativeediting.renderers.MovableItemContainer;
import com.facebook.photos.creativeediting.ui.MovableItemAnimationController.StickerTrashingAnimationState;
import com.facebook.photos.creativeediting.ui.RotateGestureDetector.SimpleOnRotateGestureListener;
import com.facebook.photos.creativeediting.utilities.PhotoOverlayObjectMapper;
import com.facebook.springs.Spring;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: mModelSubContainer */
public abstract class MovableContainerView extends CustomFrameLayout {
    @Inject
    public PhotoOverlayObjectMapper f9652a;
    protected ImageView f9653b;
    protected String f9654c;
    public Rect f9655d;
    public int f9656e;
    public GestureDetector f9657f;
    public ScaleGestureDetector f9658g;
    public RotateGestureDetector f9659h;
    public boolean f9660i;
    public ColorDrawable[] f9661j;
    public boolean f9662k = true;

    /* compiled from: mModelSubContainer */
    class C08371 implements OnClickListener {
        final /* synthetic */ MovableContainerView f9984a;

        C08371(MovableContainerView movableContainerView) {
            this.f9984a = movableContainerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1319423306);
            this.f9984a.mo501a();
            Logger.a(2, EntryType.UI_INPUT_END, 1900632117, a);
        }
    }

    /* compiled from: mModelSubContainer */
    class GestureListener extends SimpleOnGestureListener {
        final /* synthetic */ MovableContainerView f9985a;

        public GestureListener(MovableContainerView movableContainerView) {
            this.f9985a = movableContainerView;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            int[] iArr = new int[2];
            MovableContainerView.m11574a(this.f9985a, iArr, motionEvent);
            boolean a = MovableContainerView.m11576a(this.f9985a, iArr[0], iArr[1], true);
            if (a) {
                this.f9985a.invalidate();
            }
            this.f9985a.mo503a(a);
            return a;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            int[] iArr = new int[2];
            MovableContainerView.m11574a(this.f9985a, iArr, motionEvent);
            MovableContainerView.m11576a(this.f9985a, iArr[0], iArr[1], false);
            if (this.f9985a.getMovableItemContainer().f9592k == null) {
                return false;
            }
            MovableItemContainer movableItemContainer = this.f9985a.getMovableItemContainer();
            boolean z = false;
            if (movableItemContainer.f9592k.i()) {
                boolean h = movableItemContainer.f9592k.h();
                DraweeHolder draweeHolder = (DraweeHolder) movableItemContainer.f9583b.get(movableItemContainer.f9592k);
                movableItemContainer.f9583b.remove(movableItemContainer.f9592k);
                PhotoOverlayItemBuilder a = PhotoOverlayItemFactory.a(movableItemContainer.f9592k);
                if (!h) {
                    z = true;
                }
                movableItemContainer.f9592k = a.a(z).b();
                movableItemContainer.f9583b.put(movableItemContainer.f9592k, draweeHolder);
                z = true;
            }
            if (z) {
                this.f9985a.invalidate();
            }
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!this.f9985a.f9660i) {
                int[] iArr = new int[2];
                MovableContainerView.m11574a(this.f9985a, iArr, motionEvent);
                MovableContainerView.m11576a(this.f9985a, iArr[0], iArr[1], false);
            }
            if (this.f9985a.getMovableItemContainer().f9592k == null) {
                return false;
            }
            this.f9985a.f9660i = true;
            PhotoOverlayItem photoOverlayItem = this.f9985a.getMovableItemContainer().f9592k;
            float d = (float) this.f9985a.getMovableItemContainer().m11518d(photoOverlayItem);
            float width = (float) this.f9985a.getWidth();
            float height = (float) this.f9985a.getHeight();
            float e = ((float) this.f9985a.getMovableItemContainer().m11520e(photoOverlayItem)) - f2;
            d = Math.max(-width, Math.min(d - f, width));
            e = Math.max(-height, Math.min(e, height));
            this.f9985a.getMovableItemContainer().m11505a((int) d);
            this.f9985a.getMovableItemContainer().m11512b((int) e);
            if (!this.f9985a.getAnimationController().f9997c) {
                MovableItemAnimationController animationController = this.f9985a.getAnimationController();
                if (!animationController.f10000f.m11510a()) {
                    Spring a = animationController.f10002h.a(MovableItemAnimationController.f9996b);
                    a.c = false;
                    a.b(1.0d);
                }
            }
            MovableContainerView.m11583p(this.f9985a);
            this.f9985a.invalidate();
            return true;
        }
    }

    /* compiled from: mModelSubContainer */
    public class OnRotateGenstureListener extends SimpleOnRotateGestureListener {
        final /* synthetic */ MovableContainerView f9986a;
        public final List<Float> f9987b = new ArrayList();
        public boolean f9988c = false;

        public OnRotateGenstureListener(MovableContainerView movableContainerView) {
            this.f9986a = movableContainerView;
        }

        public final boolean mo542a(RotateGestureDetector rotateGestureDetector) {
            int i = (int) rotateGestureDetector.f10039c;
            int i2 = (int) rotateGestureDetector.f10040d;
            if (this.f9986a.getMovableItemContainer().f9592k == null) {
                MovableContainerView.m11576a(this.f9986a, i, i2, false);
            }
            if (this.f9986a.getMovableItemContainer().f9592k != null) {
                return true;
            }
            return false;
        }

        public final void mo541a() {
            if (this.f9986a.getMovableItemContainer().f9592k != null) {
                float c = this.f9986a.getMovableItemContainer().f9592k.c();
                boolean z = false;
                this.f9987b.add(Float.valueOf(Math.abs(c)));
                if (this.f9987b.size() > 1) {
                    int i = 0;
                    int i2 = 0;
                    while (i < this.f9987b.size() - 1) {
                        if (((Float) this.f9987b.get(i)).floatValue() > ((Float) this.f9987b.get(i + 1)).floatValue()) {
                            i2++;
                            if (((Float) this.f9987b.get(i)).floatValue() < 5.0f || ((Float) this.f9987b.get(i + 1)).floatValue() < 5.0f) {
                                z = true;
                                break;
                            }
                        }
                        i++;
                    }
                    if (i2 >= this.f9987b.size() / 2 || r6) {
                        this.f9988c = true;
                    }
                }
                if (this.f9988c) {
                    if (Math.abs(c - 0.0f) < 5.0f) {
                        this.f9986a.getMovableItemContainer().m11504a(0.0f);
                        this.f9987b.clear();
                    }
                    this.f9988c = false;
                }
            }
        }

        public final boolean mo543b(RotateGestureDetector rotateGestureDetector) {
            PhotoOverlayItem photoOverlayItem = this.f9986a.getMovableItemContainer().f9592k;
            if (photoOverlayItem == null) {
                return false;
            }
            this.f9986a.getMovableItemContainer().m11504a((photoOverlayItem.c() - RotateGestureDetector.m11965a(rotateGestureDetector.f10051o, rotateGestureDetector.f10050n, rotateGestureDetector.f10047k, rotateGestureDetector.f10046j)) % 360.0f);
            this.f9986a.invalidate();
            return true;
        }
    }

    /* compiled from: mModelSubContainer */
    class OnScaleGestureListener extends SimpleOnScaleGestureListener {
        final /* synthetic */ MovableContainerView f9989a;

        public OnScaleGestureListener(MovableContainerView movableContainerView) {
            this.f9989a = movableContainerView;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            int focusX = (int) scaleGestureDetector.getFocusX();
            int focusY = (int) scaleGestureDetector.getFocusY();
            if (this.f9989a.getMovableItemContainer().f9592k == null) {
                MovableContainerView.m11576a(this.f9989a, focusX, focusY, false);
            }
            if (this.f9989a.getMovableItemContainer().f9592k != null) {
                return true;
            }
            return false;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            PhotoOverlayItem photoOverlayItem = this.f9989a.getMovableItemContainer().f9592k;
            if (photoOverlayItem == null) {
                return false;
            }
            double scaleFactor = (double) scaleGestureDetector.getScaleFactor();
            double c = this.f9989a.getMovableItemContainer().m11515c(photoOverlayItem);
            if (Math.abs(1.0d - scaleFactor) < 0.005d) {
                return false;
            }
            this.f9989a.getMovableItemContainer().m11503a(Math.max(0.8d, Math.min(scaleFactor, 1.2d)) * c);
            this.f9989a.invalidate();
            return true;
        }
    }

    /* compiled from: mModelSubContainer */
    class RootViewOnTouchListener implements OnTouchListener {
        final /* synthetic */ MovableContainerView f9990a;

        public RootViewOnTouchListener(MovableContainerView movableContainerView) {
            this.f9990a = movableContainerView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!this.f9990a.f9662k || this.f9990a.f9655d == null) {
                return false;
            }
            int actionMasked = motionEvent.getActionMasked();
            this.f9990a.f9658g.onTouchEvent(motionEvent);
            this.f9990a.f9659h.m11968a(motionEvent);
            this.f9990a.f9657f.onTouchEvent(motionEvent);
            if (actionMasked != 1) {
                return true;
            }
            this.f9990a.f9660i = false;
            this.f9990a.getAnimationController().m11947b();
            MovableContainerView.m11582n(this.f9990a);
            this.f9990a.m11592i();
            MovableContainerView.m11578f(this.f9990a);
            this.f9990a.invalidate();
            return true;
        }
    }

    public static void m11575a(Object obj, Context context) {
        ((MovableContainerView) obj).f9652a = PhotoOverlayObjectMapper.a(FbInjector.get(context));
    }

    protected abstract void mo501a();

    protected abstract void mo502a(PhotoOverlayItem photoOverlayItem);

    protected abstract void mo503a(boolean z);

    public abstract MovableItemAnimationController getAnimationController();

    public abstract MovableItemContainer getMovableItemContainer();

    public MovableContainerView(Context context) {
        super(context);
        mo583k();
    }

    public MovableContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo583k();
    }

    public MovableContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo583k();
    }

    public final void m11588b() {
        this.f9653b.setVisibility(4);
    }

    public final void m11590e() {
        this.f9653b.setVisibility(0);
    }

    private void mo583k() {
        Class cls = MovableContainerView.class;
        m11575a(this, getContext());
        LayoutInflater.from(getContext()).inflate(2130906578, this);
        this.f9653b = (ImageView) findViewById(2131566559);
        this.f9653b.setOnClickListener(new C08371(this));
        this.f9661j = new ColorDrawable[4];
        this.f9662k = true;
        this.f9659h = new RotateGestureDetector(getContext(), new OnRotateGenstureListener(this));
        this.f9658g = new ScaleGestureDetector(getContext(), new OnScaleGestureListener(this));
        this.f9657f = new GestureDetector(getContext(), new GestureListener(this));
        this.f9657f.setIsLongpressEnabled(false);
        setOnTouchListener(new RootViewOnTouchListener(this));
    }

    public void setPhotoBounds(Rect rect) {
        this.f9655d = rect;
        getMovableItemContainer().m11517c(rect);
    }

    public void setVisibleArea(RectF rectF) {
        this.f9652a.a(rectF, this.f9656e);
    }

    public final boolean m11591g() {
        Preconditions.checkNotNull(this.f9655d);
        if (!getMovableItemContainer().m11510a()) {
            Object obj;
            MovableItemContainer movableItemContainer = getMovableItemContainer();
            Rect rect = this.f9655d;
            for (UriAwarePhotoOverlayItem a : movableItemContainer.f9583b.keySet()) {
                if (a.a(rect).intersect(rect)) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public int getNumOfItems() {
        if (m11591g()) {
            return 0;
        }
        return getMovableItemContainer().f9583b.size();
    }

    private void m11573a(Canvas canvas) {
        for (ColorDrawable colorDrawable : this.f9661j) {
            if (colorDrawable != null) {
                colorDrawable.draw(canvas);
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        getMovableItemContainer().m11506a(canvas, this.f9655d);
        if (this.f9653b.getVisibility() == 0) {
            m11573a(canvas);
            super.dispatchDraw(canvas);
            getMovableItemContainer().m11513b(canvas, this.f9655d);
            return;
        }
        getMovableItemContainer().m11513b(canvas, this.f9655d);
        m11573a(canvas);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable)) {
            return true;
        }
        return getMovableItemContainer().m11511a(drawable);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 603252277);
        super.onAttachedToWindow();
        mo584l();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 162134920, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        mo585m();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        mo584l();
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 923656904);
        super.onDetachedFromWindow();
        mo585m();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -542379557, a);
    }

    private void mo584l() {
        getMovableItemContainer().m11516c();
    }

    private void mo585m() {
        getMovableItemContainer().m11519d();
    }

    public static void m11574a(MovableContainerView movableContainerView, int[] iArr, MotionEvent motionEvent) {
        movableContainerView.getLocationOnScreen(iArr);
        iArr[0] = (int) (motionEvent.getRawX() - ((float) iArr[0]));
        iArr[1] = (int) (motionEvent.getRawY() - ((float) iArr[1]));
    }

    public final void m11592i() {
        Preconditions.checkNotNull(this.f9655d);
        MovableItemContainer movableItemContainer = getMovableItemContainer();
        Rect rect = this.f9655d;
        Rect rect2 = new Rect();
        for (UriAwarePhotoOverlayItem a : movableItemContainer.f9583b.keySet()) {
            rect2.union(a.a(rect));
        }
        Rect rect3 = rect2;
        if (rect3.left < this.f9655d.left && this.f9661j[0] == null) {
            this.f9661j[0] = new ColorDrawable(getResources().getColor(2131363492));
            this.f9661j[0].setBounds(0, 0, this.f9655d.left, getHeight());
        }
        if (rect3.top < this.f9655d.top && this.f9661j[1] == null) {
            this.f9661j[1] = new ColorDrawable(getResources().getColor(2131363492));
            this.f9661j[1].setBounds(this.f9655d.left, 0, this.f9655d.right, this.f9655d.top);
        }
        if (rect3.right > this.f9655d.right && this.f9661j[2] == null) {
            this.f9661j[2] = new ColorDrawable(getResources().getColor(2131363492));
            this.f9661j[2].setBounds(this.f9655d.right, 0, getWidth(), getHeight());
        }
        if (rect3.bottom > this.f9655d.bottom && this.f9661j[3] == null) {
            this.f9661j[3] = new ColorDrawable(getResources().getColor(2131363492));
            this.f9661j[3].setBounds(this.f9655d.left, this.f9655d.bottom, this.f9655d.right, getHeight());
        }
    }

    private boolean m11577c(PhotoOverlayItem photoOverlayItem) {
        Preconditions.checkNotNull(this.f9655d);
        RectF a = photoOverlayItem.a();
        Rect rect = new Rect(((int) (a.left * ((float) this.f9655d.width()))) + this.f9655d.left, ((int) (a.top * ((float) this.f9655d.height()))) + this.f9655d.top, ((int) (a.right * ((float) this.f9655d.width()))) + this.f9655d.left, ((int) (a.bottom * ((float) this.f9655d.height()))) + this.f9655d.top);
        Rect rect2 = new Rect();
        this.f9653b.getHitRect(rect2);
        int i = (int) (((double) (rect2.right - rect2.left)) * 0.25d);
        rect2.top -= i;
        rect2.bottom += i;
        rect2.left -= i;
        rect2.right = i + rect2.right;
        return rect2.intersect(rect);
    }

    public static void m11582n(MovableContainerView movableContainerView) {
        PhotoOverlayItem photoOverlayItem = movableContainerView.getMovableItemContainer().f9592k;
        if (photoOverlayItem != null && movableContainerView.m11577c(photoOverlayItem)) {
            movableContainerView.m11589b(photoOverlayItem);
        }
    }

    public final void m11589b(PhotoOverlayItem photoOverlayItem) {
        Preconditions.checkNotNull(photoOverlayItem);
        MovableItemContainer movableItemContainer = getMovableItemContainer();
        if (movableItemContainer.f9592k != null) {
            movableItemContainer.f9583b.remove(movableItemContainer.f9592k);
            movableItemContainer.f9592k = null;
        }
        MovableItemAnimationController animationController = getAnimationController();
        animationController.f10006l = StickerTrashingAnimationState.DEFAULT;
        animationController.m11947b();
        mo502a(photoOverlayItem);
    }

    public static boolean m11576a(MovableContainerView movableContainerView, int i, int i2, boolean z) {
        UriAwarePhotoOverlayItem uriAwarePhotoOverlayItem;
        UriAwarePhotoOverlayItem uriAwarePhotoOverlayItem2 = movableContainerView.getMovableItemContainer().f9592k;
        MovableItemContainer movableItemContainer = movableContainerView.getMovableItemContainer();
        Rect rect = movableContainerView.f9655d;
        ArrayList a = Lists.a(movableItemContainer.f9583b.keySet());
        for (int size = movableItemContainer.f9583b.size() - 1; size >= 0; size--) {
            uriAwarePhotoOverlayItem = (UriAwarePhotoOverlayItem) a.get(size);
            if (uriAwarePhotoOverlayItem.k() && uriAwarePhotoOverlayItem.a(rect).contains(i, i2)) {
                movableItemContainer.m11514b((PhotoOverlayItem) uriAwarePhotoOverlayItem);
                break;
            }
        }
        uriAwarePhotoOverlayItem = null;
        PhotoOverlayItem photoOverlayItem = uriAwarePhotoOverlayItem;
        if (photoOverlayItem != null) {
            movableContainerView.getMovableItemContainer().m11514b(photoOverlayItem);
        } else if (z) {
            movableContainerView.getMovableItemContainer().m11521g();
        }
        return !(uriAwarePhotoOverlayItem2 == null || uriAwarePhotoOverlayItem2.equals(photoOverlayItem)) || (uriAwarePhotoOverlayItem2 == null && photoOverlayItem != null);
    }

    static /* synthetic */ void m11578f(MovableContainerView movableContainerView) {
        PhotoOverlayItem photoOverlayItem = movableContainerView.getMovableItemContainer().f9592k;
        if (photoOverlayItem != null) {
            RectF a = photoOverlayItem.a();
            Rect rect = new Rect(((int) (a.left * ((float) movableContainerView.f9655d.width()))) + movableContainerView.f9655d.left, ((int) (a.top * ((float) movableContainerView.f9655d.height()))) + movableContainerView.f9655d.top, ((int) (a.right * ((float) movableContainerView.f9655d.width()))) + movableContainerView.f9655d.left, ((int) (a.bottom * ((float) movableContainerView.f9655d.height()))) + movableContainerView.f9655d.top);
            if (!rect.intersects(movableContainerView.f9655d.left, movableContainerView.f9655d.top, movableContainerView.f9655d.right, movableContainerView.f9655d.bottom)) {
                int i = rect.left;
                int i2 = rect.top;
                if (rect.left > movableContainerView.f9655d.right) {
                    i = movableContainerView.f9655d.right - rect.width();
                } else if (rect.right < movableContainerView.f9655d.left) {
                    i = movableContainerView.f9655d.left;
                }
                if (rect.top > movableContainerView.f9655d.bottom) {
                    i2 = movableContainerView.f9655d.bottom - rect.height();
                } else if (rect.bottom < movableContainerView.f9655d.top) {
                    i2 = movableContainerView.f9655d.top;
                }
                MovableItemAnimationController animationController = movableContainerView.getAnimationController();
                int i3 = rect.left;
                int i4 = rect.top;
                animationController.f10004j.a((double) i3).b((double) i);
                animationController.f10005k.a((double) i4).b((double) i2);
            }
        }
    }

    public static void m11583p(MovableContainerView movableContainerView) {
        PhotoOverlayItem photoOverlayItem = movableContainerView.getMovableItemContainer().f9592k;
        if (photoOverlayItem != null) {
            MovableItemAnimationController animationController = movableContainerView.getAnimationController();
            boolean c = movableContainerView.m11577c(photoOverlayItem);
            PhotoOverlayItem photoOverlayItem2;
            if (c && animationController.f10006l == StickerTrashingAnimationState.DEFAULT) {
                animationController.f9999e.setImageResource(2130842881);
                Spring a = animationController.f10002h.a(MovableItemAnimationController.f9995a);
                a.c = true;
                a.b(1.5d);
                photoOverlayItem2 = animationController.f10000f.f9592k;
                if (photoOverlayItem2 != null) {
                    animationController.f10007m = animationController.f10000f.m11515c(photoOverlayItem2);
                    animationController.f10000f.m11508a(photoOverlayItem2, 100);
                    animationController.f10003i.a(animationController.f10000f.m11515c(photoOverlayItem2)).b(0.5d);
                    animationController.f10004j.a((double) animationController.f10000f.m11518d(photoOverlayItem2)).b((double) animationController.f9999e.getLeft());
                    animationController.f10005k.a((double) animationController.f10000f.m11520e(photoOverlayItem2)).b((double) animationController.f9999e.getTop());
                }
                animationController.f10006l = StickerTrashingAnimationState.OPENING;
            } else if (!c && animationController.f10006l == StickerTrashingAnimationState.OPENING_COMPLETE) {
                animationController.f9999e.setImageResource(2130842880);
                animationController.f10002h.b(1.0d);
                photoOverlayItem2 = animationController.f10000f.f9592k;
                if (photoOverlayItem2 != null) {
                    animationController.f10000f.m11508a(photoOverlayItem2, 255);
                    animationController.f10003i.b(animationController.f10007m);
                }
                animationController.f10006l = StickerTrashingAnimationState.CLOSING;
            }
        }
    }

    public final void m11585a(int i, int i2, int i3) {
        MovableItemAnimationController animationController = getAnimationController();
        animationController.f10008n = i;
        animationController.f9999e.setImageResource(animationController.f10008n);
        setContentDescription(getResources().getText(i2));
        this.f9653b.setContentDescription(getResources().getString(i3));
    }

    public final void m11593j() {
        getMovableItemContainer().m11521g();
    }
}
