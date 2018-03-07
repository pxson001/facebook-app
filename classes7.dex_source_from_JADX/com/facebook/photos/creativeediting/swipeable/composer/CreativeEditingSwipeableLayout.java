package com.facebook.photos.creativeediting.swipeable.composer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.abtest.ExperimentsForCreativeEditingAbtestModule;
import com.facebook.photos.creativeediting.model.DraweeSwipeableItem;
import com.facebook.photos.creativeediting.model.SwipingTouchEventState;
import com.facebook.photos.creativeediting.model.SwipingTouchEventState.SwipingState;
import com.facebook.photos.creativeediting.swipeable.common.FrameImageView;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableDrawHelper;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableDrawHelper.DrawingType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.LazyView;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: long_url */
public class CreativeEditingSwipeableLayout extends CustomFrameLayout {
    @Inject
    public QeAccessor f9836a;
    private ImageView f9837b;
    private FrameImageView f9838c;
    public LazyView<ViewGroup> f9839d;
    private TextPaint f9840e;
    private Paint f9841f;
    private int f9842g;
    @Nullable
    public SwipeableLayoutEventListener f9843h;
    public DataProvider f9844i;

    /* compiled from: long_url */
    public interface SwipeableLayoutEventListener {
        void mo517a();

        void mo518a(SwipingTouchEventState swipingTouchEventState, SwipingState swipingState);

        void mo519b();
    }

    /* compiled from: long_url */
    public interface DataProvider {
        boolean mo520a();

        @Nullable
        DraweeSwipeableItem mo521b();

        @Nullable
        DraweeSwipeableItem mo522c();

        @Nullable
        DraweeSwipeableItem mo523d();

        SwipingTouchEventState mo524e();

        float mo525f();
    }

    private static <T extends View> void m11793a(Class<T> cls, T t) {
        m11794a((Object) t, t.getContext());
    }

    private static void m11794a(Object obj, Context context) {
        ((CreativeEditingSwipeableLayout) obj).f9836a = (QeAccessor) QeInternalImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public CreativeEditingSwipeableLayout(Context context) {
        this(context, null, 0);
        m11798h();
    }

    public CreativeEditingSwipeableLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m11798h();
    }

    public CreativeEditingSwipeableLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11798h();
    }

    public void setDataProvider(DataProvider dataProvider) {
        this.f9844i = dataProvider;
    }

    public void setEventListener(SwipeableLayoutEventListener swipeableLayoutEventListener) {
        this.f9843h = swipeableLayoutEventListener;
    }

    public final void m11799a() {
        DraweeSwipeableItem c = this.f9844i.mo522c();
        if (c != null) {
            if (c.c != null) {
                this.f9837b.setImageDrawable(c.c.h());
                this.f9837b.invalidate();
            }
            this.f9838c.setSwipeableItem(c);
            this.f9838c.setActualImageBounds(getActualImageBounds());
        }
    }

    public final void m11800b() {
        DraweeSwipeableItem b = this.f9844i.mo521b();
        DraweeSwipeableItem d = this.f9844i.mo523d();
        this.f9844i.mo522c();
        if (!(b == null || b.c == null)) {
            Preconditions.checkNotNull(b.c.h(), "left item's drawable hierarchy was not properly set up");
            b.c.h().setCallback(this);
        }
        if (d != null && d.c != null) {
            Preconditions.checkNotNull(d.c.h(), "right item's drawable hierarchy was not properly set up");
            d.c.h().setCallback(this);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (this.f9844i != null) {
            if (this.f9844i.mo521b() != null && this.f9844i.mo521b().a(drawable)) {
                return true;
            }
            if (this.f9844i.mo522c() != null && this.f9844i.mo522c().a(drawable)) {
                return true;
            }
            if (this.f9844i.mo523d() != null && this.f9844i.mo523d().a(drawable)) {
                return true;
            }
        }
        return super.verifyDrawable(drawable);
    }

    private void m11797g() {
        if (this.f9844i.mo522c() != null) {
            this.f9837b.setContentDescription(this.f9844i.mo522c().a);
            this.f9837b.sendAccessibilityEvent(16384);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1587673861);
        super.onAttachedToWindow();
        if (this.f9843h != null) {
            this.f9843h.mo519b();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 637196060, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.f9843h != null) {
            this.f9843h.mo517a();
        }
    }

    public final void m11801e() {
        m11799a();
        m11797g();
    }

    @Nullable
    public SwipeableLayoutEventListener getEventListener() {
        return this.f9843h;
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 37814248);
        super.onDetachedFromWindow();
        if (this.f9843h != null) {
            this.f9843h.mo517a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1278905322, a);
    }

    protected void dispatchDraw(Canvas canvas) {
        this.f9838c.setActualImageBounds(getActualImageBounds());
        super.dispatchDraw(canvas);
        if (this.f9844i != null) {
            int measuredHeight = getMeasuredHeight();
            if (!this.f9844i.mo524e().f() && this.f9844i.mo520a()) {
                float f = this.f9844i.mo525f();
                SwipingTouchEventState e = this.f9844i.mo524e();
                m11790a(canvas, measuredHeight, f);
                DrawingType type = DrawingType.getType(e, this.f9844i.mo521b(), this.f9844i.mo522c(), this.f9844i.mo523d());
                int measuredWidth = getMeasuredWidth();
                int measuredHeight2 = getMeasuredHeight();
                switch (type) {
                    case FRAME_TO_FRAME:
                        SwipeableDrawHelper.m11694a(canvas, e, this.f9838c, this.f9844i.mo521b(), this.f9844i.mo522c(), this.f9844i.mo523d(), getActualImageBounds(), measuredWidth, (int) f);
                        m11791a(canvas, e, f);
                        return;
                    case FILTER_TO_FILTER:
                        SwipeableDrawHelper.m11692a(canvas, this.f9844i.mo521b(), this.f9844i.mo523d(), e, measuredWidth, measuredHeight2, (int) f);
                        m11796b(canvas, e, f);
                        return;
                    case FRAME_TO_FILTER:
                        SwipeableDrawHelper.m11695a(canvas, e, this.f9838c, this.f9844i.mo521b(), this.f9844i.mo522c(), this.f9844i.mo523d(), getActualImageBounds(), measuredWidth, measuredHeight2, (int) f);
                        m11796b(canvas, e, f);
                        return;
                    case FILTER_TO_FRAME:
                        SwipeableDrawHelper.m11693a(canvas, e, this.f9838c, this.f9844i.mo521b(), this.f9844i.mo523d(), getActualImageBounds(), measuredWidth, measuredHeight2, (int) f);
                        m11791a(canvas, e, f);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public final void m11802f() {
        this.f9837b.setImageBitmap(null);
        this.f9838c.setSwipeableItem(null);
    }

    private void m11798h() {
        m11793a(CreativeEditingSwipeableLayout.class, (View) this);
        LayoutInflater.from(getContext()).inflate(2130903529, this);
        this.f9837b = (ImageView) c(2131560269);
        this.f9838c = (FrameImageView) c(2131560271);
        this.f9837b.setContentDescription(getContentDescription());
        this.f9839d = new LazyView((ViewStub) c(2131560270));
        this.f9840e = new TextPaint(3);
        this.f9840e.setColor(-1);
        this.f9840e.setShadowLayer(1.0f, 0.0f, 1.0f, getResources().getColor(2131361921));
        this.f9840e.setTextSize((float) getResources().getDimensionPixelSize(2131429553));
        this.f9842g = getResources().getDimensionPixelSize(2131429554);
        this.f9841f = new Paint();
        this.f9841f.setStrokeWidth(5.0f);
        this.f9841f.setColor(getResources().getColor(17170443));
    }

    private void m11792a(QeAccessor qeAccessor) {
        this.f9836a = qeAccessor;
    }

    private boolean m11795a(float f, float f2) {
        return f2 - f > this.f9840e.getTextSize() + ((float) this.f9842g);
    }

    private void m11791a(Canvas canvas, SwipingTouchEventState swipingTouchEventState, float f) {
        if (this.f9836a.a(ExperimentsForCreativeEditingAbtestModule.f, false)) {
            m11796b(canvas, swipingTouchEventState, f);
        }
    }

    private void m11796b(Canvas canvas, SwipingTouchEventState swipingTouchEventState, float f) {
        int width = (int) ((f / ((float) getWidth())) * 255.0f);
        String str = this.f9844i.mo521b().a;
        if (swipingTouchEventState.d()) {
            width = 255 - width;
            str = this.f9844i.mo523d().a;
        }
        if (!StringUtil.a(str)) {
            Rect rect = new Rect();
            getLocalVisibleRect(rect);
            if (m11795a((float) rect.top, ((float) canvas.getHeight()) - (3.0f * this.f9840e.getTextSize()))) {
                int save = canvas.save();
                this.f9840e.setAlpha(width);
                Rect rect2 = new Rect();
                this.f9840e.getTextBounds(str, 0, str.length() - 1, rect2);
                canvas.drawText(str, (float) ((getMeasuredWidth() / 2) - (rect2.width() / 2)), (float) ((rect.top == 0 ? (int) getActualImageBounds().top : rect.top) + this.f9842g), this.f9840e);
                canvas.restoreToCount(save);
            }
        }
    }

    public RectF getActualImageBounds() {
        RectF rectF = new RectF();
        if (this.f9844i == null || this.f9844i.mo522c() == null || this.f9844i.mo522c().c == null) {
            return new RectF(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        }
        ((GenericDraweeHierarchy) this.f9844i.mo522c().c.f()).a(rectF);
        return rectF;
    }

    private void m11790a(Canvas canvas, int i, float f) {
        canvas.save();
        canvas.drawLine(f, 0.0f, f, (float) i, this.f9841f);
        canvas.restore();
    }

    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        this.f9838c.invalidate();
    }

    public LazyView<ViewGroup> getNuxView() {
        return this.f9839d;
    }
}
