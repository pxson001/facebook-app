package com.facebook.widget.mediareorderview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.SizeUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.ScrollingAwareScrollView;
import com.facebook.widget.ScrollingAwareScrollView.OnScrollListener;
import com.facebook.widget.mediareorderview.ImagesReorderViewStateManager.State;
import com.facebook.widget.mediareorderview.MovableImageView.EventListener;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.List;
import javax.inject.Inject;

/* compiled from: zip_code */
public class ImagesReorderView extends CustomFrameLayout {
    private static final SpringConfig f9848e = SpringConfig.a(150.0d, 16.0d);
    private static final SpringConfig f9849f = SpringConfig.a(150.0d, 16.0d);
    private static final SpringConfig f9850g = SpringConfig.a(250.0d, 20.0d);
    private static final CallerContext f9851h = CallerContext.b(ImagesReorderView.class, "composer");
    @Inject
    SpringSystem f9852a;
    @Inject
    Resources f9853b;
    @Inject
    FbDraweeControllerBuilder f9854c;
    @Inject
    UnderwoodBitmapWidthHelper f9855d;
    private MovableImageView f9856i;
    public ScrollingAwareScrollView f9857j;
    public CustomViewGroup f9858k;
    public View f9859l;
    public View f9860m;
    public List<MovableImageView> f9861n;
    public ImagesReorderViewStateManager f9862o;
    public ImagesReorderViewDimensions f9863p;
    private ImagesReorderViewScrollController f9864q;
    public Spring f9865r;
    private ShrinkSpringListener f9866s;
    private int f9867t;
    private int f9868u;
    private EventCallback f9869v;
    private float f9870w = -1.0f;
    private boolean f9871x = false;
    private final OnScrollListener f9872y = new C10412(this);

    /* compiled from: zip_code */
    public interface EventCallback {
        void mo5a();

        void mo6a(int i, int i2);
    }

    /* compiled from: zip_code */
    class C10401 implements OnGlobalLayoutListener {
        final /* synthetic */ ImagesReorderView f9844a;

        C10401(ImagesReorderView imagesReorderView) {
            this.f9844a = imagesReorderView;
        }

        public void onGlobalLayout() {
            this.f9844a.f9857j.scrollTo(0, this.f9844a.f9863p.f9881i);
            this.f9844a.f9865r.a(0.0d).b(1.0d);
            CustomViewUtils.a(this.f9844a.f9858k, this);
        }
    }

    /* compiled from: zip_code */
    class C10412 implements OnScrollListener {
        final /* synthetic */ ImagesReorderView f9845a;

        C10412(ImagesReorderView imagesReorderView) {
            this.f9845a = imagesReorderView;
        }

        public final void m11556a(int i, int i2) {
            if (i != i2) {
                this.f9845a.m11575e();
            }
        }
    }

    /* compiled from: zip_code */
    class FloatingImageEventListener implements EventListener {
        final /* synthetic */ ImagesReorderView f9846a;

        public FloatingImageEventListener(ImagesReorderView imagesReorderView) {
            this.f9846a = imagesReorderView;
        }

        public final void mo626a() {
            Preconditions.checkArgument(this.f9846a.f9862o.m11607c(State.INVISIBLE));
            if (this.f9846a.f9862o.m11606b(State.REORDER)) {
                this.f9846a.m11575e();
            }
        }

        public final void mo627b() {
            Preconditions.checkArgument(this.f9846a.f9862o.m11607c(State.INVISIBLE));
            if (this.f9846a.f9862o.m11606b(State.EXPAND)) {
                this.f9846a.m11579g();
            }
        }
    }

    /* compiled from: zip_code */
    class ShrinkSpringListener extends SimpleSpringListener {
        final /* synthetic */ ImagesReorderView f9847a;

        public ShrinkSpringListener(ImagesReorderView imagesReorderView) {
            this.f9847a = imagesReorderView;
        }

        public final void m11561a(Spring spring) {
            boolean z = this.f9847a.f9862o.m11606b(State.SHRINK) || this.f9847a.f9862o.m11606b(State.EXPAND);
            Preconditions.checkArgument(z);
            double d = spring.d();
            this.f9847a.f9860m.setAlpha(this.f9847a.f9862o.m11606b(State.SHRINK) ? (float) (1.0d - (SpringUtil.a(d, 0.0d, 0.5d) / 0.5d)) : (float) (SpringUtil.a(d, 0.0d, 0.5d) / 0.5d));
            for (MovableImageView a : this.f9847a.f9861n) {
                a.m11620a(d, 0.0d, 1.0d);
            }
            this.f9847a.f9859l.setScaleX((((float) ((MovableImageView) this.f9847a.f9861n.get(0)).getCurrentWidth()) / ((float) this.f9847a.f9863p.f9873a)) + 0.1f);
        }

        public final void m11562b(Spring spring) {
            boolean z = this.f9847a.f9862o.m11606b(State.SHRINK) || this.f9847a.f9862o.m11606b(State.EXPAND);
            Preconditions.checkArgument(z);
            if (this.f9847a.f9862o.m11606b(State.SHRINK)) {
                this.f9847a.f9857j;
            } else {
                this.f9847a.f9860m;
            }
        }
    }

    private static <T extends View> void m11567a(Class<T> cls, T t) {
        m11568a((Object) t, t.getContext());
    }

    private static void m11568a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ImagesReorderView) obj).m11566a(SpringSystem.b(fbInjector), ResourcesMethodAutoProvider.a(fbInjector), FbDraweeControllerBuilder.b(fbInjector), UnderwoodBitmapWidthHelper.m11626a(fbInjector));
    }

    private void m11566a(SpringSystem springSystem, Resources resources, FbDraweeControllerBuilder fbDraweeControllerBuilder, UnderwoodBitmapWidthHelper underwoodBitmapWidthHelper) {
        this.f9852a = springSystem;
        this.f9853b = resources;
        this.f9854c = fbDraweeControllerBuilder;
        this.f9855d = underwoodBitmapWidthHelper;
    }

    public ImagesReorderView(Context context) {
        super(context);
        m11564a();
    }

    public ImagesReorderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11564a();
    }

    private void m11564a() {
        m11567a(ImagesReorderView.class, (View) this);
        setContentView(2130904841);
        this.f9857j = (ScrollingAwareScrollView) c(2131563060);
        this.f9858k = (CustomViewGroup) c(2131563061);
        this.f9859l = c(2131563059);
        this.f9862o = new ImagesReorderViewStateManager();
        this.f9861n = Lists.a();
        this.f9866s = new ShrinkSpringListener(this);
        Spring a = this.f9852a.a().a(f9848e);
        a.c = true;
        this.f9865r = a.a(this.f9866s);
        this.f9864q = new ImagesReorderViewScrollController(this.f9857j, this.f9852a);
        this.f9856i = new MovableImageView(getContext());
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 712368888);
        if (this.f9870w == -1.0f) {
            this.f9870w = motionEvent.getY();
        }
        if (this.f9862o.m11606b(State.INVISIBLE) || this.f9862o.m11606b(State.EXPAND)) {
            Logger.a(2, EntryType.UI_INPUT_END, 1380093413, a);
        } else {
            switch (motionEvent.getAction()) {
                case 1:
                    this.f9870w = -1.0f;
                    this.f9871x = false;
                    break;
                case 2:
                    int a2 = (int) SpringUtil.a((double) motionEvent.getY(), 0.0d, (double) this.f9863p.f9874b);
                    this.f9856i.m11624c((int) SpringUtil.a((double) motionEvent.getX(), 0.0d, (double) this.f9863p.f9873a), a2);
                    if (Math.abs(this.f9870w - motionEvent.getY()) > TypedValue.applyDimension(1, 20.0f, getContext().getResources().getDisplayMetrics())) {
                        this.f9871x = true;
                        if (this.f9862o.m11606b(State.REORDER)) {
                            this.f9864q.m11602a(a2);
                            break;
                        }
                    }
                    break;
                case 3:
                    break;
            }
            m11578f();
            LogUtils.a(68495068, a);
        }
        return true;
    }

    public final void m11588a(List<Pair<Uri, Rect>> list, List<Float> list2, Uri uri, int i, View view, EventCallback eventCallback, Point point) {
        MovableImageView movableImageView;
        int floatValue;
        Preconditions.checkState(list.size() == list2.size());
        this.f9862o.m11605a(State.SHRINK);
        this.f9857j.setBackgroundDrawable(new ColorDrawable(-1));
        this.f9857j.setVisibility(0);
        this.f9856i.setVisibility(0);
        this.f9867t = i;
        this.f9868u = i;
        this.f9860m = view;
        this.f9869v = eventCallback;
        this.f9863p = new ImagesReorderViewDimensions(view.getWidth(), view.getHeight(), this.f9853b.getDimensionPixelSize(2131429609), this.f9853b.getDimensionPixelSize(2131429610), this.f9853b.getDimensionPixelSize(2131429611), i, list2);
        m11569a((List) list, (List) list2);
        this.f9864q.m11603a(this.f9863p);
        this.f9858k.setMinimumHeight(this.f9863p.f9879g);
        this.f9858k.getViewTreeObserver().addOnGlobalLayoutListener(new C10401(this));
        int i2 = 0;
        int i3 = this.f9863p.f9875c;
        while (i2 < this.f9861n.size()) {
            movableImageView = (MovableImageView) this.f9861n.get(i2);
            floatValue = (int) (((float) this.f9863p.f9878f) / ((Float) list2.get(i2)).floatValue());
            int i4 = (this.f9863p.f9873a - this.f9863p.f9878f) / 2;
            Rect rect = new Rect(i4, i3, this.f9863p.f9878f + i4, i3 + floatValue);
            movableImageView.m11621a(0, this.f9863p.f9881i);
            movableImageView.setEndRect(rect);
            i2++;
            i3 += this.f9863p.f9877e + floatValue;
        }
        floatValue = (int) (((float) this.f9863p.f9878f) / ((Float) list2.get(i)).floatValue());
        movableImageView = (MovableImageView) this.f9861n.get(i);
        movableImageView.setAlpha(0.3f);
        if (this.f9856i.getParent() == null) {
            addView(this.f9856i, this.f9863p.f9878f, floatValue);
        }
        if (!uri.isAbsolute()) {
            uri = Uri.fromFile(new File(uri.toString()));
        }
        FbDraweeControllerBuilder a = this.f9854c.a(f9851h);
        ImageRequestBuilder a2 = ImageRequestBuilder.a(uri);
        a2.d = new ResizeOptions(this.f9863p.f9878f, floatValue);
        this.f9856i.setController(((FbDraweeControllerBuilder) a.c(a2.m())).s());
        this.f9856i.setCurrentRect((Rect) ((Pair) list.get(i)).second);
        this.f9856i.setEndRect(movableImageView.getEndRect());
        this.f9856i.m11624c(point.x, point.y);
        this.f9856i.f9903k = new FloatingImageEventListener(this);
        this.f9856i.setSpringConfig(f9849f);
        m11572b(list, list2);
    }

    private void m11569a(List<Pair<Uri, Rect>> list, List<Float> list2) {
        MovableImageView movableImageView;
        int i = 0;
        int size = list.size() - this.f9861n.size();
        int i2;
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                this.f9861n.add(new MovableImageView(getContext()));
            }
            for (i2 = 0; i2 < this.f9861n.size(); i2++) {
                movableImageView = (MovableImageView) this.f9861n.get(i2);
                if (movableImageView.getParent() == null) {
                    this.f9858k.addView(movableImageView, this.f9863p.f9878f, (int) (((float) this.f9863p.f9878f) / ((Float) list2.get(i2)).floatValue()));
                }
            }
        } else if (size < 0) {
            i2 = size * -1;
            for (size = 0; size < i2; size++) {
                this.f9858k.removeView((MovableImageView) this.f9861n.remove(size));
            }
        }
        while (i < list.size()) {
            movableImageView = (MovableImageView) this.f9861n.get(i);
            movableImageView.m11625d();
            movableImageView.setCurrentRect((Rect) ((Pair) list.get(i)).second);
            i++;
        }
    }

    private void m11572b(List<Pair<Uri, Rect>> list, List<Float> list2) {
        for (int i = 0; i < list.size(); i++) {
            int a = SizeUtil.a(getContext(), (float) this.f9855d.m11628a());
            int floatValue = (int) (((float) a) / ((Float) list2.get(i)).floatValue());
            FbDraweeControllerBuilder a2 = this.f9854c.a(f9851h);
            ImageRequestBuilder a3 = ImageRequestBuilder.a((Uri) ((Pair) list.get(i)).first);
            a3.d = new ResizeOptions(a, floatValue);
            ((MovableImageView) this.f9861n.get(i)).setController(((FbDraweeControllerBuilder) a2.c(a3.m())).s());
        }
    }

    public static void m11571b(ImagesReorderView imagesReorderView) {
        imagesReorderView.f9871x = false;
        imagesReorderView.f9862o.m11605a(State.REORDER);
        for (MovableImageView c : imagesReorderView.f9861n) {
            c.m11623c();
        }
        imagesReorderView.f9857j.a(imagesReorderView.f9872y);
        imagesReorderView.f9856i.setSpringConfig(f9850g);
    }

    private void m11575e() {
        Preconditions.checkArgument(this.f9862o.m11606b(State.REORDER));
        if (this.f9864q.m11604b() && this.f9871x) {
            int currentRectCenterY = this.f9856i.getCurrentRectCenterY() + this.f9857j.getScrollY();
            MovableImageView movableImageView = (MovableImageView) this.f9861n.get(this.f9868u);
            int i;
            int i2;
            if (currentRectCenterY < movableImageView.getEndRectCenterY()) {
                i = this.f9868u - 1;
                while (i >= 0 && currentRectCenterY < ((MovableImageView) this.f9861n.get(i)).getEndRectCenterY()) {
                    m11565a(i);
                    i2 = i - 1;
                    this.f9868u--;
                    i = i2;
                }
            } else if (currentRectCenterY > movableImageView.getEndRectCenterY()) {
                i = this.f9868u + 1;
                while (i < this.f9861n.size() && currentRectCenterY > ((MovableImageView) this.f9861n.get(i)).getEndRectCenterY()) {
                    m11565a(i - 1);
                    i2 = i + 1;
                    this.f9868u++;
                    i = i2;
                }
            }
        }
    }

    private void m11565a(int i) {
        MovableImageView movableImageView = (MovableImageView) this.f9861n.remove(i);
        MovableImageView movableImageView2 = (MovableImageView) this.f9861n.get(i);
        this.f9861n.add(i + 1, movableImageView);
        movableImageView.m11622b(0, movableImageView2.getCurrentHeight() + this.f9863p.f9877e);
        movableImageView2.m11622b(0, (-movableImageView.getCurrentHeight()) - this.f9863p.f9877e);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f9862o.m11606b(State.REORDER) || this.f9862o.m11606b(State.SHRINK)) {
            m11578f();
        }
    }

    private void m11578f() {
        Rect currentRect;
        this.f9857j.b(this.f9872y);
        this.f9865r.b(this.f9866s);
        if (this.f9862o.m11606b(State.SHRINK)) {
            this.f9865r.l();
            currentRect = ((MovableImageView) this.f9861n.get(this.f9868u)).getCurrentRect();
        } else {
            this.f9864q.m11601a();
            currentRect = ((MovableImageView) this.f9861n.get(this.f9868u)).getEndRect();
        }
        currentRect.offset(0, -this.f9857j.getScrollY());
        this.f9856i.setSpringConfig(f9849f);
        this.f9856i.setEndRect(currentRect);
        this.f9862o.m11605a(State.EXPAND);
    }

    private void m11579g() {
        this.f9856i.setVisibility(8);
        ((MovableImageView) this.f9861n.get(this.f9868u)).setAlpha(1.0f);
        this.f9869v.mo6a(this.f9868u, this.f9867t);
    }

    public List<DraweeController> getDraweeControllers() {
        List<DraweeController> a = Lists.a();
        for (int i = 0; i < this.f9861n.size(); i++) {
            a.add(((MovableImageView) this.f9861n.get(i)).getController());
        }
        return a;
    }

    public final void m11587a(List<Rect> list) {
        Preconditions.checkArgument(this.f9862o.m11606b(State.EXPAND));
        int i = 0;
        for (MovableImageView movableImageView : this.f9861n) {
            movableImageView.m11625d();
            int i2 = i + 1;
            Rect rect = (Rect) list.get(i);
            rect.offset(0, this.f9857j.getScrollY());
            movableImageView.setEndRect(rect);
            i = i2;
        }
        this.f9865r.a(this.f9866s);
        this.f9865r.a(0.0d).b(1.0d);
    }

    public static void m11582h(ImagesReorderView imagesReorderView) {
        imagesReorderView.f9857j.setVisibility(8);
        imagesReorderView.f9862o.m11605a(State.INVISIBLE);
        imagesReorderView.f9869v.mo5a();
        imagesReorderView.f9859l.setScaleX(1.0f);
    }
}
