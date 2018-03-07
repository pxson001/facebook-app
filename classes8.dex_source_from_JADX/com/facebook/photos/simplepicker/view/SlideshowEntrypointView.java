package com.facebook.photos.simplepicker.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.facebook.fbui.facepile.Face;
import com.facebook.fbui.facepile.FacepileGridView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: show_top_gradient */
public class SlideshowEntrypointView extends CustomLinearLayout {
    private static final CallerContext f3320b = CallerContext.a(SlideshowEntrypointView.class, "unknown");
    @Inject
    public FbDraweeControllerBuilder f3321a;
    private final GenericDraweeHierarchyBuilder f3322c;
    private final MultiDraweeHolder<GenericDraweeHierarchy> f3323d;
    private final FacepileGridView f3324e;
    private final FbDraweeView f3325f;
    private final View f3326g;
    private final View f3327h;
    private final TextView f3328i;
    private final TextView f3329j;
    private final RadioButton f3330k;
    private final RadioButton f3331l;
    public final Handler f3332m;
    private CollageSlideshowSwitchListener f3333n;
    private AtomicBoolean f3334o;
    private Timer f3335p;
    public FadeDrawable f3336q;
    private int f3337r;

    /* compiled from: show_top_gradient */
    public interface CollageSlideshowSwitchListener {
        void mo140a(boolean z);
    }

    /* compiled from: show_top_gradient */
    class C04191 implements OnClickListener {
        final /* synthetic */ SlideshowEntrypointView f3316a;

        C04191(SlideshowEntrypointView slideshowEntrypointView) {
            this.f3316a = slideshowEntrypointView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1070283487);
            this.f3316a.f3336q;
            Logger.a(2, EntryType.UI_INPUT_END, 1478929717, a);
        }
    }

    /* compiled from: show_top_gradient */
    class C04202 implements OnClickListener {
        final /* synthetic */ SlideshowEntrypointView f3317a;

        C04202(SlideshowEntrypointView slideshowEntrypointView) {
            this.f3317a = slideshowEntrypointView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -755482757);
            SlideshowEntrypointView.m3274c(this.f3317a);
            Logger.a(2, EntryType.UI_INPUT_END, 1706288373, a);
        }
    }

    /* compiled from: show_top_gradient */
    class C04223 extends TimerTask {
        final /* synthetic */ SlideshowEntrypointView f3319a;

        /* compiled from: show_top_gradient */
        class C04211 implements Runnable {
            final /* synthetic */ C04223 f3318a;

            C04211(C04223 c04223) {
                this.f3318a = c04223;
            }

            public void run() {
                this.f3318a.f3319a.f3336q.f(SlideshowEntrypointView.m3274c(this.f3318a.f3319a) % 3);
            }
        }

        C04223(SlideshowEntrypointView slideshowEntrypointView) {
            this.f3319a = slideshowEntrypointView;
        }

        public void run() {
            HandlerDetour.a(this.f3319a.f3332m, new C04211(this), -712081590);
        }
    }

    private static <T extends View> void m3269a(Class<T> cls, T t) {
        m3270a((Object) t, t.getContext());
    }

    private static void m3270a(Object obj, Context context) {
        ((SlideshowEntrypointView) obj).f3321a = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    static /* synthetic */ int m3274c(SlideshowEntrypointView slideshowEntrypointView) {
        int i = slideshowEntrypointView.f3337r + 1;
        slideshowEntrypointView.f3337r = i;
        return i;
    }

    public SlideshowEntrypointView(Context context) {
        this(context, null);
    }

    public SlideshowEntrypointView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideshowEntrypointView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3269a(SlideshowEntrypointView.class, (View) this);
        this.f3322c = new GenericDraweeHierarchyBuilder(getResources());
        this.f3323d = new MultiDraweeHolder();
        setContentView(2130907129);
        this.f3324e = (FacepileGridView) a(2131567488);
        this.f3325f = (FbDraweeView) a(2131567492);
        this.f3326g = a(2131567487);
        this.f3327h = a(2131567491);
        this.f3328i = (TextView) a(2131567489);
        this.f3329j = (TextView) a(2131567493);
        this.f3330k = (RadioButton) a(2131567490);
        this.f3331l = (RadioButton) a(2131567494);
        this.f3330k.setClickable(false);
        this.f3331l.setClickable(false);
        Resources resources = getResources();
        float dimensionPixelSize = (float) resources.getDimensionPixelSize(2131429495);
        this.f3324e.setFaces(ImmutableList.of(new Face(new RoundedColorDrawable(dimensionPixelSize, resources.getColor(2131362106)), 1, 2), new Face(new RoundedColorDrawable(dimensionPixelSize, resources.getColor(2131362104)), 1, 1), new Face(new RoundedColorDrawable(dimensionPixelSize, resources.getColor(2131362109)), 1, 1)));
        this.f3332m = new Handler(Looper.getMainLooper());
    }

    public final void m3280a(boolean z, boolean z2, CollageSlideshowSwitchListener collageSlideshowSwitchListener) {
        this.f3328i.setText(z ? 2131234436 : 2131234435);
        this.f3334o = new AtomicBoolean(z2);
        this.f3333n = (CollageSlideshowSwitchListener) Preconditions.checkNotNull(collageSlideshowSwitchListener);
    }

    public final boolean m3281a() {
        return this.f3334o.get();
    }

    public final void m3279a(Uri uri, Uri uri2, Uri uri3) {
        m3271a(this.f3334o.get());
        this.f3326g.setOnClickListener(new C04191(this));
        this.f3327h.setOnClickListener(new C04202(this));
        if (this.f3323d.d() != 6) {
            m3272b();
        }
        m3267a(this.f3323d.b(0), uri);
        m3267a(this.f3323d.b(1), uri2);
        m3267a(this.f3323d.b(2), uri3);
        this.f3324e.setFaces(ImmutableList.of(new Face(this.f3323d.b(0).h(), 1, 2), new Face(this.f3323d.b(1).h(), 1, 1), new Face(this.f3323d.b(2).h(), 1, 1)));
        m3267a(this.f3323d.b(3), uri);
        m3267a(this.f3323d.b(4), uri2);
        m3267a(this.f3323d.b(5), uri3);
        this.f3325f.setImageDrawable(this.f3336q);
        if (this.f3335p != null) {
            this.f3335p.cancel();
            this.f3335p.purge();
        }
        this.f3335p = new Timer();
        this.f3337r = 2;
        this.f3335p.schedule(new C04223(this), 0, 1500);
    }

    private void m3266a(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f3321a = fbDraweeControllerBuilder;
    }

    private void m3267a(DraweeHolder draweeHolder, Uri uri) {
        draweeHolder.a(((FbDraweeControllerBuilder) this.f3321a.b(draweeHolder.f)).b(uri).s());
    }

    private void m3272b() {
        float dimensionPixelSize = (float) getResources().getDimensionPixelSize(2131429495);
        this.f3321a.a(f3320b);
        this.f3322c.e(ScaleType.g);
        this.f3323d.c();
        this.f3323d.a(m3265a(RoundingParams.b(dimensionPixelSize, 0.0f, 0.0f, dimensionPixelSize)));
        this.f3323d.a(m3265a(RoundingParams.b(0.0f, dimensionPixelSize, 0.0f, 0.0f)));
        this.f3323d.a(m3265a(RoundingParams.b(0.0f, 0.0f, dimensionPixelSize, 0.0f)));
        this.f3323d.a(m3265a(RoundingParams.b(dimensionPixelSize)));
        this.f3323d.a(m3265a(RoundingParams.b(dimensionPixelSize)));
        this.f3323d.a(m3265a(RoundingParams.b(dimensionPixelSize)));
        this.f3336q = new FadeDrawable(new Drawable[]{this.f3323d.b(3).h(), this.f3323d.b(4).h(), this.f3323d.b(5).h()});
        this.f3336q.c(500);
    }

    private DraweeHolder m3265a(RoundingParams roundingParams) {
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = this.f3322c;
        genericDraweeHierarchyBuilder.u = roundingParams;
        return DraweeHolder.a(genericDraweeHierarchyBuilder.u(), getContext());
    }

    private void m3271a(boolean z) {
        int i;
        int color = getResources().getColor(2131362110);
        int color2 = getResources().getColor(2131361917);
        TextView textView = this.f3328i;
        if (z) {
            i = color;
        } else {
            i = color2;
        }
        textView.setTextColor(i);
        this.f3330k.setChecked(!z);
        TextView textView2 = this.f3329j;
        if (!z) {
            color2 = color;
        }
        textView2.setTextColor(color2);
        this.f3331l.setChecked(z);
    }

    public static void m3275c(SlideshowEntrypointView slideshowEntrypointView) {
        if (!slideshowEntrypointView.f3334o.get() && slideshowEntrypointView.f3333n != null) {
            slideshowEntrypointView.m3271a(true);
            slideshowEntrypointView.f3333n.mo140a(true);
            slideshowEntrypointView.f3334o.set(true);
        }
    }

    public static void m3277d(SlideshowEntrypointView slideshowEntrypointView) {
        if (slideshowEntrypointView.f3334o.get() && slideshowEntrypointView.f3333n != null) {
            slideshowEntrypointView.m3271a(false);
            slideshowEntrypointView.f3333n.mo140a(false);
            slideshowEntrypointView.f3334o.set(false);
        }
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1030126582);
        super.onAttachedToWindow();
        this.f3323d.a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1962786475, a);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f3323d.a();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f3323d.b();
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1393384225);
        super.onDetachedFromWindow();
        this.f3323d.b();
        if (this.f3335p != null) {
            this.f3335p.cancel();
            this.f3335p.purge();
            this.f3335p = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1383445156, a);
    }
}
