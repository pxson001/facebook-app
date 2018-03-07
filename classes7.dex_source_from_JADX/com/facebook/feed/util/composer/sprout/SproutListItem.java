package com.facebook.feed.util.composer.sprout;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import com.facebook.widget.LazyView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TRIPLE_ITEMS_THIRD_PORTRAIT */
public class SproutListItem extends ImageBlockLayout {
    @Inject
    public Lazy<SpringSystem> f22440h;
    public TextView f22441i;
    public TextView f22442j;
    public ImageView f22443k;
    public SproutIconDrawable f22444l;
    private Spring f22445m;
    public LazyView<View> f22446n;
    private boolean f22447o;
    private SproutNuxProvider f22448p;
    private final Runnable f22449q;

    /* compiled from: TRIPLE_ITEMS_THIRD_PORTRAIT */
    class C19351 implements Runnable {
        final /* synthetic */ SproutListItem f22436a;

        C19351(SproutListItem sproutListItem) {
            this.f22436a = sproutListItem;
        }

        public void run() {
            this.f22436a.f22443k;
        }
    }

    /* compiled from: TRIPLE_ITEMS_THIRD_PORTRAIT */
    class SpringListener extends SimpleSpringListener {
        final /* synthetic */ SproutListItem f22439a;

        public SpringListener(SproutListItem sproutListItem) {
            this.f22439a = sproutListItem;
        }

        public final void m25032a(Spring spring) {
            float d = (float) spring.d();
            this.f22439a.f22441i.setVisibility(0);
            this.f22439a.f22441i.setAlpha(Math.min(1.0f, d));
            if (SproutListItem.m25049i(this.f22439a)) {
                this.f22439a.f22442j.setVisibility(0);
                this.f22439a.f22442j.setAlpha(Math.min(1.0f, d));
            }
            if (SproutListItem.m25050j(this.f22439a)) {
                this.f22439a.f22446n.a().setVisibility(0);
                this.f22439a.f22446n.a().setAlpha(Math.min(1.0f, d));
            }
            this.f22439a.f22443k.setVisibility(0);
            float a = 1.6f - ((float) SpringUtil.a((double) d, 0.0d, 1.0d, 0.0d, 0.6000000238418579d));
            this.f22439a.f22443k.setScaleX(a);
            this.f22439a.f22443k.setScaleY(a);
            this.f22439a.f22443k.setAlpha((float) SpringUtil.a((double) d, 0.0d, 1.0d, 0.25d, 1.0d));
            this.f22439a.f22443k.setRotation((float) SpringUtil.a((double) d, 0.0d, 1.0d, -90.0d, 0.0d));
        }

        public final void m25033b(Spring spring) {
            this.f22439a.f22441i.setAlpha(1.0f);
            if (SproutListItem.m25049i(this.f22439a)) {
                this.f22439a.f22442j.setAlpha(1.0f);
            }
            if (SproutListItem.m25050j(this.f22439a)) {
                this.f22439a.f22446n.a().setAlpha(1.0f);
            }
            this.f22439a.f22443k.setScaleX(1.0f);
            this.f22439a.f22443k.setScaleX(1.0f);
            this.f22439a.f22443k.setRotation(0.0f);
            this.f22439a.f22443k.setAlpha(1.0f);
        }
    }

    private static <T extends View> void m25038a(Class<T> cls, T t) {
        m25039a((Object) t, t.getContext());
    }

    private static void m25039a(Object obj, Context context) {
        ((SproutListItem) obj).f22440h = IdBasedLazy.a(FbInjector.get(context), 3433);
    }

    private void m25037a(Lazy<SpringSystem> lazy) {
        this.f22440h = lazy;
    }

    public static SproutListItem m25035a(Context context, ViewGroup viewGroup) {
        return (SproutListItem) LayoutInflater.from(context).inflate(2130907203, viewGroup, false);
    }

    public SproutListItem(Context context) {
        super(context);
        this.f22447o = false;
        this.f22449q = new C19351(this);
        m25044f();
    }

    public SproutListItem(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SproutListItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22447o = false;
        this.f22449q = new C19351(this);
        m25044f();
    }

    private void m25044f() {
        m25038a(SproutListItem.class, (View) this);
        setContentView(2130907204);
        this.f22441i = (TextView) getView(2131567593);
        this.f22442j = (TextView) getView(2131567594);
        this.f22443k = (ImageView) getView(2131567592);
        this.f22446n = new LazyView((ViewStub) getView(2131563172));
        this.f22444l = new SproutIconDrawable(getResources());
        this.f22444l.setCallback(this.f22443k);
        this.f22443k.setImageDrawable(this.f22444l);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (BuildConstants.i) {
            int a = m25034a(getResources());
            if (getMeasuredHeight() != a) {
                throw new IllegalStateException("Unexpected height! expected=" + a + ", actual=" + getMeasuredHeight());
            }
        }
    }

    public SproutIconDrawable getIcon() {
        return this.f22444l;
    }

    public void setTitle(String str) {
        this.f22441i.setText(str);
        m25048h();
    }

    public void setSubtitle(String str) {
        this.f22442j.setText(str);
        if (m25049i(this)) {
            this.f22442j.setVisibility(0);
        } else {
            this.f22442j.setVisibility(8);
        }
        m25048h();
    }

    public void setNuxProvider(final SproutNuxProvider sproutNuxProvider) {
        this.f22448p = sproutNuxProvider;
        if (m25050j(this)) {
            this.f22446n.a(this.f22448p.mo1592a());
            this.f22446n.a().setVisibility(0);
            if (sproutNuxProvider.mo1594c() != null) {
                this.f22446n.a().setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ SproutListItem f22438b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1733587873);
                        this.f22438b.f22446n.a().setVisibility(8);
                        sproutNuxProvider.mo1594c().run();
                        Logger.a(2, EntryType.UI_INPUT_END, 744350592, a);
                    }
                });
                return;
            }
            return;
        }
        this.f22446n.c();
    }

    private static int m25034a(Resources resources) {
        return resources.getDimensionPixelSize(2131429789);
    }

    public final void m25051a() {
        this.f22443k.setVisibility(4);
        this.f22441i.setVisibility(4);
        if (m25049i(this)) {
            this.f22442j.setVisibility(4);
        }
        if (m25050j(this)) {
            this.f22446n.a().setVisibility(4);
        }
    }

    public final void m25052a(long j) {
        postDelayed(this.f22449q, j);
    }

    public static void m25047g(SproutListItem sproutListItem) {
        if (!sproutListItem.f22447o) {
            sproutListItem.f22447o = true;
            if (sproutListItem.f22445m == null) {
                sproutListItem.f22445m = ((SpringSystem) sproutListItem.f22440h.get()).a().a(SpringConfig.b(16.0d, 10.0d)).a(new SpringListener(sproutListItem));
            }
            sproutListItem.f22445m.a(0.0d).b(1.0d);
        }
    }

    private void m25048h() {
        if (m25049i(this)) {
            setContentDescription(this.f22441i.getText() + ": " + this.f22442j.getText());
        } else {
            setContentDescription(this.f22441i.getText());
        }
    }

    public static boolean m25049i(SproutListItem sproutListItem) {
        return !StringUtil.a(sproutListItem.f22442j.getText().toString());
    }

    public static boolean m25050j(SproutListItem sproutListItem) {
        return sproutListItem.f22448p != null && sproutListItem.f22448p.mo1593b();
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -855574617);
        if (this.f22445m != null) {
            this.f22445m.m();
        }
        removeCallbacks(this.f22449q);
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1946177486, a);
    }
}
