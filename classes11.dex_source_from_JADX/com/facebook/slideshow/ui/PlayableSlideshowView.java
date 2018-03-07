package com.facebook.slideshow.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.slideshow.analytics.SlideshowLogger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.collect.ImmutableList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: PLACES_LOADING */
public class PlayableSlideshowView extends CustomFrameLayout {
    @Inject
    public SlideshowLogger f12585a;
    private FbDraweeView f12586b;
    private ImageView f12587c;
    private SlideshowViewConfiguration f12588d;
    private MultiDraweeHolder<GenericDraweeHierarchy> f12589e;
    private ScaleType f12590f;
    private int f12591g;
    private int f12592h;
    private ImmutableList<DraweeController> f12593i;
    private FadeDrawable f12594j;
    private Timer f12595k;
    public Handler f12596l;
    private String f12597m;
    public final Runnable f12598n;
    private final AtomicBoolean f12599o;
    private final OnClickListener f12600p;
    private final OnClickListener f12601q;

    /* compiled from: PLACES_LOADING */
    class C14861 implements OnClickListener {
        final /* synthetic */ PlayableSlideshowView f12577a;

        C14861(PlayableSlideshowView playableSlideshowView) {
            this.f12577a = playableSlideshowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 107127018);
            this.f12577a.f12585a.e();
            this.f12577a.m13008b();
            Logger.a(2, EntryType.UI_INPUT_END, -1361508575, a);
        }
    }

    /* compiled from: PLACES_LOADING */
    class C14872 implements OnClickListener {
        final /* synthetic */ PlayableSlideshowView f12578a;

        C14872(PlayableSlideshowView playableSlideshowView) {
            this.f12578a = playableSlideshowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -710349472);
            this.f12578a.f12585a.f();
            this.f12578a.m13006a();
            Logger.a(2, EntryType.UI_INPUT_END, 1353922915, a);
        }
    }

    /* compiled from: PLACES_LOADING */
    class C14883 implements Runnable {
        final /* synthetic */ PlayableSlideshowView f12579a;

        C14883(PlayableSlideshowView playableSlideshowView) {
            this.f12579a = playableSlideshowView;
        }

        public void run() {
            PlayableSlideshowView.m13002f(this.f12579a);
        }
    }

    /* compiled from: PLACES_LOADING */
    class C14894 extends TimerTask {
        final /* synthetic */ PlayableSlideshowView f12580a;

        C14894(PlayableSlideshowView playableSlideshowView) {
            this.f12580a = playableSlideshowView;
        }

        public void run() {
            HandlerDetour.a(this.f12580a.f12596l, this.f12580a.f12598n, -277412844);
        }
    }

    /* compiled from: PLACES_LOADING */
    public class SlideshowViewConfiguration {
        public final int f12581a;
        public final int f12582b;
        public final int f12583c;
        public final boolean f12584d;

        public SlideshowViewConfiguration(int i, int i2, int i3, boolean z) {
            this.f12581a = i;
            this.f12582b = i2;
            this.f12583c = i3;
            this.f12584d = z;
        }
    }

    private static <T extends View> void m12996a(Class<T> cls, T t) {
        m12997a((Object) t, t.getContext());
    }

    private static void m12997a(Object obj, Context context) {
        ((PlayableSlideshowView) obj).f12585a = SlideshowLogger.b(FbInjector.get(context));
    }

    private void m12995a(SlideshowLogger slideshowLogger) {
        this.f12585a = slideshowLogger;
    }

    public PlayableSlideshowView(Context context) {
        this(context, null);
    }

    public PlayableSlideshowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayableSlideshowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12996a(PlayableSlideshowView.class, (View) this);
        setContentView(2130906332);
        this.f12586b = (FbDraweeView) c(2131566156);
        this.f12587c = (ImageView) c(2131566157);
        this.f12600p = new C14861(this);
        this.f12587c.setOnClickListener(this.f12600p);
        this.f12601q = new C14872(this);
        this.f12589e = new MultiDraweeHolder();
        this.f12598n = new C14883(this);
        this.f12596l = new Handler(Looper.getMainLooper());
        this.f12599o = new AtomicBoolean(false);
    }

    public static void m13002f(PlayableSlideshowView playableSlideshowView) {
        if (!playableSlideshowView.f12599o.getAndSet(true)) {
            int size = (playableSlideshowView.f12591g + 1) % playableSlideshowView.f12593i.size();
            int d = (playableSlideshowView.f12592h + 1) % playableSlideshowView.f12589e.d();
            playableSlideshowView.f12589e.b(d).a((DraweeController) playableSlideshowView.f12593i.get(size));
            playableSlideshowView.f12594j.c(playableSlideshowView.f12588d.f12583c);
            playableSlideshowView.f12594j.f(d);
            playableSlideshowView.f12591g = size;
            playableSlideshowView.f12592h = d;
            playableSlideshowView.f12599o.set(false);
        }
        if (playableSlideshowView.f12591g == 0 && !playableSlideshowView.f12588d.f12584d) {
            playableSlideshowView.m13006a();
        }
    }

    public final void m13006a() {
        m13003g();
        m13004h();
        m13005i();
    }

    public final void m13007a(String str, ImmutableList<DraweeController> immutableList, SlideshowViewConfiguration slideshowViewConfiguration) {
        m12998a(str, immutableList, slideshowViewConfiguration, ScaleType.g);
    }

    private void m12998a(String str, ImmutableList<DraweeController> immutableList, SlideshowViewConfiguration slideshowViewConfiguration, ScaleType scaleType) {
        this.f12597m = str;
        this.f12585a.b = this.f12597m;
        this.f12593i = immutableList;
        this.f12588d = slideshowViewConfiguration;
        if (scaleType != this.f12590f || this.f12589e.d() == 0) {
            this.f12590f = scaleType;
            this.f12589e.c();
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
            this.f12589e.a(DraweeHolder.a(genericDraweeHierarchyBuilder.a().e(this.f12590f).u(), getContext()));
            this.f12589e.a(DraweeHolder.a(genericDraweeHierarchyBuilder.a().e(this.f12590f).u(), getContext()));
            this.f12594j = new FadeDrawable(new Drawable[]{this.f12589e.b(0).h(), this.f12589e.b(1).h()});
            this.f12586b.setImageDrawable(this.f12594j);
        }
        m13003g();
        m13004h();
    }

    public final void m13008b() {
        this.f12595k = new Timer(getClass().getName());
        this.f12587c.setVisibility(8);
        this.f12586b.setOnClickListener(this.f12601q);
        this.f12595k.scheduleAtFixedRate(new C14894(this), (long) (this.f12588d.f12581a + this.f12588d.f12582b), (long) (this.f12588d.f12582b + this.f12588d.f12583c));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -617592152);
        super.onAttachedToWindow();
        this.f12589e.a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 58083952, a);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f12589e.a();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f12589e.b();
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1596460387);
        super.onDetachedFromWindow();
        this.f12589e.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 761027035, a);
    }

    public final void m13009e() {
        m13006a();
    }

    private void m13003g() {
        if (this.f12595k != null) {
            this.f12595k.cancel();
            this.f12595k.purge();
            this.f12595k = null;
        }
    }

    private void m13004h() {
        this.f12592h = 0;
        this.f12591g = 0;
        this.f12589e.b(this.f12592h).a((DraweeController) this.f12593i.get(this.f12591g));
        this.f12594j.f(this.f12592h);
        this.f12594j.g();
    }

    private void m13005i() {
        this.f12587c.setVisibility(0);
        this.f12586b.setOnClickListener(this.f12600p);
    }
}
