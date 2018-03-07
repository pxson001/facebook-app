package com.facebook.goodwill.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.goodwill.ui.PolaroidDrawable;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.DefaultChoreographerWrapper;
import com.facebook.ui.choreographer.FrameCallbackWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VOIP_GROUP_CALL_LIST */
public class ThrowbackAnimatedHeaderView extends FrameLayout {
    private Handler f21148A;
    public Interpolator f21149B;
    @Inject
    ChoreographerWrapper f21150a;
    @Inject
    ImagePipeline f21151b;
    @BackgroundExecutorService
    @Inject
    ExecutorService f21152c;
    private final int f21153d = 7;
    private final int f21154e = 30;
    private final int f21155f = 10;
    private final int f21156g = 45;
    public final int f21157h = getResources().getDimensionPixelSize(2131433107);
    public final int f21158i = getResources().getDimensionPixelSize(2131433107);
    public final int f21159j = getResources().getDimensionPixelSize(2131433108);
    public final int f21160k = getResources().getDimensionPixelSize(2131433108);
    private final int f21161l = 100;
    private final int f21162m = 20;
    private final double f21163n = 0.8d;
    private final int f21164o = 4;
    private final int f21165p = 7;
    private final String f21166q = "LEFT";
    private final String f21167r = "RIGHT";
    public final ArrayList<AnimatedObject> f21168s = new ArrayList(7);
    private AnimatedObject f21169t = null;
    private final PointF f21170u = new PointF();
    private final Random f21171v = new Random();
    private int f21172w;
    public final FrameCallbackWrapper f21173x = new FrameAnimator(this);
    public boolean f21174y;
    public boolean f21175z;

    /* compiled from: VOIP_GROUP_CALL_LIST */
    class C30051 implements Comparator<AnimatedObject> {
        final /* synthetic */ ThrowbackAnimatedHeaderView f21124a;

        C30051(ThrowbackAnimatedHeaderView throwbackAnimatedHeaderView) {
            this.f21124a = throwbackAnimatedHeaderView;
        }

        public int compare(Object obj, Object obj2) {
            return ((AnimatedObject) obj2).m22083b() - ((AnimatedObject) obj).m22083b();
        }
    }

    /* compiled from: VOIP_GROUP_CALL_LIST */
    public class AnimatedObject {
        public AnimatedObjectState f21127a;
        PolaroidDrawable f21128b;
        public long f21129c;
        int f21130d;
        int f21131e;
        Point f21132f;
        Point f21133g;
        int f21134h;
        int f21135i;
        public int f21136j;
        final /* synthetic */ ThrowbackAnimatedHeaderView f21137k;
        private final CallerContext f21138l = CallerContext.a(ThrowbackAnimatedHeaderView.class, "goodwill_throwback");
        private final int f21139m = this.f21137k.getResources().getDimensionPixelSize(2131433100);
        private final int f21140n = this.f21137k.getResources().getDimensionPixelSize(2131433101);
        private final int f21141o = this.f21137k.getResources().getDimensionPixelSize(2131433102);
        private final int f21142p = this.f21137k.getResources().getDimensionPixelSize(2131433103);

        AnimatedObject(final ThrowbackAnimatedHeaderView throwbackAnimatedHeaderView, String str, boolean z) {
            int c;
            boolean z2 = false;
            this.f21137k = throwbackAnimatedHeaderView;
            int dimensionPixelSize = z ? throwbackAnimatedHeaderView.getResources().getDimensionPixelSize(2131433104) : throwbackAnimatedHeaderView.m22102b(this.f21142p, this.f21141o);
            this.f21132f = new Point(0, ((this.f21140n + dimensionPixelSize) + this.f21139m) * -2);
            this.f21133g = new Point(0, ((this.f21140n + dimensionPixelSize) + this.f21139m) * -2);
            if (z) {
                c = ThrowbackAnimatedHeaderView.m22108c(throwbackAnimatedHeaderView, 10, 45);
            } else {
                c = throwbackAnimatedHeaderView.m22102b(-30, 30);
            }
            this.f21127a = AnimatedObjectState.BEFORE_INITIAL_ANIMATION;
            this.f21134h = throwbackAnimatedHeaderView.f21159j;
            this.f21135i = throwbackAnimatedHeaderView.f21160k;
            Resources resources = throwbackAnimatedHeaderView.getContext().getResources();
            int i = z ? 0 : this.f21140n;
            int i2 = z ? 0 : this.f21139m;
            if (!z) {
                z2 = true;
            }
            this.f21128b = new PolaroidDrawable(resources, i, i2, dimensionPixelSize, z2);
            this.f21136j = c;
            this.f21128b.a((float) c);
            ImageRequest a = ImageRequest.a(str);
            if (a != null) {
                throwbackAnimatedHeaderView.f21151b.c(a, this.f21138l).a(new BaseBitmapDataSubscriber(this) {
                    final /* synthetic */ AnimatedObject f21126b;

                    public final void m22072a(@Nullable Bitmap bitmap) {
                        PolaroidDrawable polaroidDrawable = this.f21126b.f21128b;
                        polaroidDrawable.a(new BitmapDrawable(polaroidDrawable.a, bitmap));
                    }

                    public final void m22073f(DataSource<CloseableReference<CloseableImage>> dataSource) {
                    }
                }, throwbackAnimatedHeaderView.f21152c);
            }
        }

        final int m22078a() {
            return this.f21128b.getIntrinsicHeight();
        }

        final int m22083b() {
            return this.f21128b.getIntrinsicWidth();
        }

        private int m22074e() {
            return this.f21132f.x + m22083b();
        }

        private int m22075f() {
            return this.f21132f.y + m22078a();
        }

        final boolean m22087c() {
            return (this.f21133g.x == this.f21132f.x && this.f21133g.y == this.f21132f.y) ? false : true;
        }

        final void m22079a(int i, int i2) {
            this.f21133g.set(i, i2);
        }

        final void m22084b(int i, int i2) {
            this.f21133g.offset(i, i2);
        }

        final void m22086c(int i, int i2) {
            this.f21133g.set(i, i2);
            this.f21132f.set(i, i2);
        }

        final void m22089d(int i, int i2) {
            this.f21134h = i;
            this.f21135i = i2;
        }

        final AnimatedObjectState m22088d() {
            return this.f21127a;
        }

        final void m22082a(AnimatedObjectState animatedObjectState) {
            this.f21127a = animatedObjectState;
        }

        final void m22080a(long j) {
            this.f21129c = j;
        }

        final void m22090e(int i, int i2) {
            this.f21130d = i;
            this.f21131e = i2;
        }

        final void m22085b(long j) {
            int i;
            int i2;
            if (this.f21127a == AnimatedObjectState.DURING_INITIAL_ANIMATION) {
                float interpolation = this.f21137k.f21149B.getInterpolation((float) ((((double) (j - this.f21129c)) / 1.0E9d) / 0.8d));
                i = (int) (((((float) (this.f21133g.x - this.f21130d)) * interpolation) + ((float) this.f21130d)) - ((float) this.f21132f.x));
                i2 = (int) (((interpolation * ((float) (this.f21133g.y - this.f21131e))) + ((float) this.f21131e)) - ((float) this.f21132f.y));
                this.f21134h = this.f21137k.f21157h;
                this.f21135i = this.f21137k.f21158i;
            } else {
                i = this.f21133g.x - this.f21132f.x;
                i2 = this.f21133g.y - this.f21132f.y;
            }
            i = Math.max(Math.min(this.f21134h, i), -this.f21134h);
            i2 = Math.max(Math.min(this.f21135i, i2), -this.f21135i);
            m22077g(i, i2);
            this.f21132f.offset(i, i2);
        }

        private void m22077g(int i, int i2) {
            int min = Math.min(this.f21132f.y, this.f21132f.y + i2) - (m22076g() / 3);
            this.f21137k.invalidate(Math.min(this.f21132f.x, this.f21132f.x + i) - (m22076g() / 3), min, Math.max(m22074e(), m22074e() + i) + (m22076g() / 3), Math.max(m22075f(), m22075f() + i2) + (m22076g() / 3));
        }

        final void m22081a(Canvas canvas) {
            this.f21128b.a(this.f21132f.x, this.f21132f.y);
            this.f21128b.draw(canvas);
        }

        private int m22076g() {
            return Math.max(m22083b(), m22078a());
        }

        public final boolean m22091f(int i, int i2) {
            return this.f21132f.x < i && m22074e() > i && this.f21132f.y < i2 && m22075f() > i2;
        }
    }

    /* compiled from: VOIP_GROUP_CALL_LIST */
    enum AnimatedObjectState {
        BEFORE_INITIAL_ANIMATION,
        DURING_INITIAL_ANIMATION,
        AFTER_INITIAL_ANIMATION
    }

    /* compiled from: VOIP_GROUP_CALL_LIST */
    public class DelayedAnimationRunnable implements Runnable {
        final /* synthetic */ ThrowbackAnimatedHeaderView f21143a;
        private AnimatedObject f21144b;
        private int f21145c;
        private int f21146d;

        public DelayedAnimationRunnable(ThrowbackAnimatedHeaderView throwbackAnimatedHeaderView, AnimatedObject animatedObject, int i, int i2) {
            this.f21143a = throwbackAnimatedHeaderView;
            this.f21144b = animatedObject;
            this.f21145c = i;
            this.f21146d = i2;
        }

        public void run() {
            this.f21144b.m22079a(this.f21145c, this.f21146d);
            this.f21143a.f21159j;
        }
    }

    /* compiled from: VOIP_GROUP_CALL_LIST */
    public class FrameAnimator extends FrameCallbackWrapper {
        final /* synthetic */ ThrowbackAnimatedHeaderView f21147a;

        public FrameAnimator(ThrowbackAnimatedHeaderView throwbackAnimatedHeaderView) {
            this.f21147a = throwbackAnimatedHeaderView;
        }

        public final void m22092a(long j) {
            int size = this.f21147a.f21168s.size();
            int i = 0;
            boolean z = false;
            while (i < size) {
                boolean z2;
                AnimatedObject animatedObject = (AnimatedObject) this.f21147a.f21168s.get(i);
                if (animatedObject.m22087c()) {
                    AnimatedObjectState animatedObjectState = animatedObject.f21127a;
                    if (animatedObjectState == AnimatedObjectState.BEFORE_INITIAL_ANIMATION) {
                        animatedObject.f21129c = j;
                        animatedObject.f21127a = AnimatedObjectState.DURING_INITIAL_ANIMATION;
                    }
                    animatedObject.m22085b(j);
                    if (animatedObject.m22087c()) {
                        z2 = true;
                        i++;
                        z = z2;
                    } else if (animatedObjectState == AnimatedObjectState.DURING_INITIAL_ANIMATION) {
                        animatedObject.f21127a = AnimatedObjectState.AFTER_INITIAL_ANIMATION;
                    }
                }
                z2 = z;
                i++;
                z = z2;
            }
            if (z) {
                this.f21147a.f21150a.a(this.f21147a.f21173x);
            } else {
                this.f21147a.f21174y = false;
            }
        }
    }

    private static <T extends View> void m22099a(Class<T> cls, T t) {
        m22100a((Object) t, t.getContext());
    }

    private static void m22100a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ThrowbackAnimatedHeaderView) obj).m22098a((ChoreographerWrapper) DefaultChoreographerWrapper.a(fbInjector), ImagePipelineMethodAutoProvider.a(fbInjector), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(fbInjector));
    }

    public ThrowbackAnimatedHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22099a(ThrowbackAnimatedHeaderView.class, (View) this);
        setWillNotDraw(false);
        this.f21148A = new Handler();
        this.f21149B = PathInterpolatorCompat.a(0.0f, 0.0f, 0.0f, 1.0f);
    }

    public void onDraw(Canvas canvas) {
        int size = this.f21168s.size();
        for (int i = 0; i < size; i++) {
            ((AnimatedObject) this.f21168s.get(i)).m22081a(canvas);
        }
    }

    private Point m22095a(int i, int i2, int i3, String str) {
        int b;
        if ("LEFT".equals(str)) {
            b = m22102b(0 - (i / 2), ((getWidth() / 2) - (this.f21172w / 2)) - i);
        } else {
            b = m22102b((getWidth() / 2) + (this.f21172w / 2), getWidth() - (i / 2));
        }
        double ceil = (double) ((int) Math.ceil(Math.sqrt(Math.pow((double) getResources().getDimensionPixelSize(2131433104), 2.0d) / 2.0d)));
        return new Point(b, m22102b(0, Math.max(1, (getHeight() - (i2 / 2)) - ((int) Math.ceil(ceil * Math.cos(Math.toRadians((double) Math.abs(i3))))))));
    }

    private void m22098a(ChoreographerWrapper choreographerWrapper, ImagePipeline imagePipeline, ExecutorService executorService) {
        this.f21150a = choreographerWrapper;
        this.f21151b = imagePipeline;
        this.f21152c = executorService;
    }

    private Point m22094a(int i, int i2) {
        int b;
        if (RTLUtil.a(getContext())) {
            b = m22102b(0, (getWidth() - this.f21172w) - i);
        } else {
            b = m22102b(this.f21172w, getWidth() - i);
        }
        return new Point(b, m22102b(0, getHeight() - i2));
    }

    private Point m22105b(int i, int i2, int i3, String str) {
        if (this.f21175z) {
            return m22095a(i, i2, i3, str);
        }
        return m22094a(i, i2);
    }

    private ArrayList<Point> m22096a() {
        ArrayList<Point> arrayList = new ArrayList();
        for (int i = 0; i < this.f21168s.size(); i++) {
            String str;
            AnimatedObject animatedObject = (AnimatedObject) this.f21168s.get(i);
            if (i < this.f21168s.size() / 2) {
                str = "LEFT";
            } else {
                str = "RIGHT";
            }
            Object b = m22105b(animatedObject.m22083b(), animatedObject.m22078a(), animatedObject.f21136j, str);
            if (!arrayList.isEmpty()) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < 20) {
                    Point point;
                    Point b2 = m22105b(animatedObject.m22083b(), animatedObject.m22078a(), animatedObject.f21136j, str);
                    int i4 = Integer.MAX_VALUE;
                    int size = arrayList.size();
                    int i5 = 0;
                    while (i5 < size) {
                        point = (Point) arrayList.get(i5);
                        int i6 = point.x - b2.x;
                        int i7 = point.y - b2.y;
                        i7 = (i7 * i7) + (i6 * i6);
                        if (i7 >= i4) {
                            i7 = i4;
                        }
                        i5++;
                        i4 = i7;
                    }
                    if (i3 < i4) {
                        point = b2;
                    } else {
                        i4 = i3;
                        point = r8;
                    }
                    i2++;
                    Point point2 = point;
                    i3 = i4;
                }
            }
            arrayList.add(b);
        }
        return arrayList;
    }

    public final void m22114a(int i) {
        if (getWidth() > 0 && getHeight() > 0) {
            this.f21172w = i;
            int width = getWidth();
            ArrayList a = m22096a();
            int size = this.f21168s.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                AnimatedObject animatedObject = (AnimatedObject) this.f21168s.get(i2);
                Point point = (Point) a.get(i3);
                int a2 = point.y + (animatedObject.m22078a() * 2);
                int i4 = point.x;
                if (point.x > width / 2) {
                    a2 = -a2;
                }
                a2 += i4;
                animatedObject.m22086c(a2, animatedObject.m22078a() * -2);
                animatedObject.m22090e(a2, animatedObject.m22078a() * -2);
                HandlerDetour.b(this.f21148A, new DelayedAnimationRunnable(this, animatedObject, point.x, point.y), (long) (i3 * 100), -800252133);
                i2++;
                i3++;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1696405260);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                for (int size = this.f21168s.size() - 1; size >= 0; size--) {
                    AnimatedObject animatedObject = (AnimatedObject) this.f21168s.get(size);
                    if (animatedObject.m22091f(x, y)) {
                        this.f21169t = animatedObject;
                        this.f21169t.m22089d(this.f21157h, this.f21158i);
                        requestDisallowInterceptTouchEvent(true);
                        break;
                    }
                }
                requestDisallowInterceptTouchEvent(true);
            case 2:
                if (this.f21169t != null) {
                    this.f21169t.m22084b(x - ((int) this.f21170u.x), y - ((int) this.f21170u.y));
                    break;
                }
                break;
            default:
                if (this.f21169t != null) {
                    this.f21169t.m22084b(x - ((int) this.f21170u.x), y - ((int) this.f21170u.y));
                    this.f21169t = null;
                    break;
                }
                break;
        }
        this.f21170u.set(motionEvent.getX(), motionEvent.getY());
        this.f21159j;
        LogUtils.a(1675869291, a);
        return true;
    }

    public static void m22106b(ThrowbackAnimatedHeaderView throwbackAnimatedHeaderView) {
        if (!throwbackAnimatedHeaderView.f21174y) {
            throwbackAnimatedHeaderView.f21150a.a(throwbackAnimatedHeaderView.f21173x);
            throwbackAnimatedHeaderView.f21174y = true;
        }
    }

    private int m22102b(int i, int i2) {
        return this.f21171v.nextInt(i2 - i) + i;
    }

    public static int m22108c(ThrowbackAnimatedHeaderView throwbackAnimatedHeaderView, int i, int i2) {
        int abs = Math.abs(i);
        abs = Math.abs(abs + throwbackAnimatedHeaderView.f21171v.nextInt(Math.abs(i2) - abs));
        return throwbackAnimatedHeaderView.f21171v.nextInt(2) == 0 ? -abs : abs;
    }

    public void setUseIPBStyle(boolean z) {
        this.f21175z = z;
    }

    public void setImageURLs(List<String> list) {
        int i;
        if (this.f21175z) {
            i = 4;
        } else {
            i = 7;
        }
        this.f21168s.clear();
        int i2 = 0;
        while (i2 < 7 && i2 < Math.min(list.size(), r1)) {
            this.f21168s.add(new AnimatedObject(this, (String) list.get(i2), this.f21175z));
            i2++;
        }
        Collections.sort(this.f21168s, new C30051(this));
    }
}
