package com.facebook.redspace.pagerindicator;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.viewpageindicator.PageIndicator;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PageLoadFirstCard */
public class SwipeImagePageIndicator extends CustomFrameLayout implements PageIndicator {
    private FbDraweeView f12149a;
    private FbDraweeView f12150b;
    private CustomViewPager f12151c;
    private List<OnPageChangeListener> f12152d;
    public ViewPager f12153e;
    public TouchablePagerContainer f12154f;
    private CrossfadeBackgroundHelper f12155g;
    private float f12156h;
    private RatioAwareScroller f12157i;
    public boolean f12158j;
    public int f12159k;
    private final DataSetObserver f12160l;

    /* compiled from: PageLoadFirstCard */
    class C14451 extends DataSetObserver {
        final /* synthetic */ SwipeImagePageIndicator f12144a;

        C14451(SwipeImagePageIndicator swipeImagePageIndicator) {
            this.f12144a = swipeImagePageIndicator;
        }

        public void onChanged() {
            super.onChanged();
            this.f12144a.m12600a();
        }
    }

    /* compiled from: PageLoadFirstCard */
    class C14462 implements OnGlobalLayoutListener {
        final /* synthetic */ SwipeImagePageIndicator f12145a;

        C14462(SwipeImagePageIndicator swipeImagePageIndicator) {
            this.f12145a = swipeImagePageIndicator;
        }

        public void onGlobalLayout() {
            SwipeImagePageIndicator.m12598f(this.f12145a);
            SwipeImagePageIndicator.m12599g(this.f12145a);
            if (VERSION.SDK_INT >= 16) {
                this.f12145a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                this.f12145a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* compiled from: PageLoadFirstCard */
    class ViewPagerAdapter extends PagerAdapter {
        final /* synthetic */ SwipeImagePageIndicator f12146a;
        private final Context f12147b;
        private final SwipeImagePagerAdapter f12148c;

        public ViewPagerAdapter(SwipeImagePageIndicator swipeImagePageIndicator, Context context) {
            this.f12146a = swipeImagePageIndicator;
            this.f12147b = context;
            this.f12148c = (SwipeImagePagerAdapter) swipeImagePageIndicator.f12153e.getAdapter();
        }

        public final int m12587b() {
            return this.f12148c.mo328b();
        }

        public final boolean m12586a(View view, Object obj) {
            return view == obj;
        }

        public final Object m12583a(ViewGroup viewGroup, int i) {
            ViewPager viewPager = (ViewPager) viewGroup;
            View a = m12582a(i);
            viewPager.addView(a);
            return a;
        }

        public final void m12584a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        private View m12582a(int i) {
            View inflate = View.inflate(this.f12147b, 2130907738, null);
            m12585a((BadgableDraweeView) FindViewUtil.b(inflate, 2131568441), i);
            return inflate;
        }

        public final void m12585a(BadgableDraweeView badgableDraweeView, int i) {
            Uri b = this.f12148c.mo329b(i);
            int I_ = this.f12148c.I_(i);
            badgableDraweeView.setImageURI(b);
            badgableDraweeView.setBadgeCount(I_);
            badgableDraweeView.setContentDescription(this.f12148c.mo331e(i));
            badgableDraweeView.setTag(Integer.valueOf(i));
            if (this.f12146a.f12158j && i == this.f12146a.f12159k) {
                this.f12146a.f12158j = false;
                badgableDraweeView.setScaleX(1.3f);
                badgableDraweeView.setScaleY(1.3f);
                badgableDraweeView.setDimValue(0.0f);
            }
        }
    }

    public SwipeImagePageIndicator(Context context) {
        this(context, null);
    }

    public SwipeImagePageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12158j = true;
        this.f12160l = new C14451(this);
        m12591b();
        if (attributeSet != null) {
            setupAttributes(attributeSet);
        }
    }

    private void m12591b() {
        setContentView(2130907739);
        this.f12152d = new ArrayList();
        this.f12149a = (FbDraweeView) c(2131568443);
        this.f12150b = (FbDraweeView) c(2131568442);
        this.f12151c = (CustomViewPager) c(2131568445);
        this.f12154f = (TouchablePagerContainer) c(2131568444);
        this.f12151c.a = false;
        setClipChildren(false);
        this.f12156h = getResources().getDimension(2131430520);
        this.f12151c.a(true, new SwipeImagePageTransformer());
        m12597e();
    }

    private void setupAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SwipeImagePageIndicator);
        int dimension = (int) obtainStyledAttributes.getDimension(0, 0.0f);
        obtainStyledAttributes.recycle();
        setTopOffset(dimension);
    }

    public void setTopOffset(int i) {
        ((LayoutParams) this.f12151c.getLayoutParams()).topMargin = i;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m12597e();
    }

    private void m12597e() {
        getViewTreeObserver().addOnGlobalLayoutListener(new C14462(this));
    }

    public static void m12598f(SwipeImagePageIndicator swipeImagePageIndicator) {
        swipeImagePageIndicator.f12151c.setOffscreenPageLimit(((int) Math.ceil((double) (((float) swipeImagePageIndicator.f12153e.getWidth()) / swipeImagePageIndicator.f12156h))) + 1);
    }

    public static void m12599g(SwipeImagePageIndicator swipeImagePageIndicator) {
        swipeImagePageIndicator.m12588a(swipeImagePageIndicator.f12151c, ((float) swipeImagePageIndicator.f12151c.getWidth()) / ((float) swipeImagePageIndicator.f12153e.getWidth()));
    }

    private void m12588a(ViewPager viewPager, float f) {
        Preconditions.checkNotNull(this.f12157i, "The ViewPager must be bound before adding slaves");
        this.f12157i.f12140c.put(viewPager, Float.valueOf(f));
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager != this.f12153e) {
            if (this.f12153e != null) {
                this.f12153e.getAdapter().b(this.f12160l);
            }
            viewPager.getAdapter().a(this.f12160l);
            PagerAdapter adapter = viewPager.getAdapter();
            Preconditions.checkNotNull(adapter, "The ViewPager doesnt have an adapter");
            Preconditions.checkArgument(adapter instanceof SwipeImagePagerAdapter, "The ViewPager adapter must implement SwipeImagePagerAdapter");
            this.f12153e = viewPager;
            viewPager.setOnPageChangeListener(this);
            this.f12151c.setAdapter(new ViewPagerAdapter(this, getContext()));
            this.f12154f.f12165b = this.f12153e;
            this.f12157i = new RatioAwareScroller(this, this.f12153e);
            if (this.f12155g != null) {
                m12592b(this.f12155g);
            }
            this.f12155g = new CrossfadeBackgroundHelper((SwipeImagePagerAdapter) viewPager.getAdapter(), this.f12149a, this.f12150b);
            m12602a(this.f12155g);
        }
    }

    public final void m12603a(ViewPager viewPager, int i) {
        setViewPager(viewPager);
        setCurrentItem(i);
    }

    public void setCurrentItem(int i) {
        Preconditions.checkNotNull(this.f12153e, "The ViewPager must be bound before changing items");
        this.f12159k = i;
        this.f12153e.setCurrentItem(i);
        this.f12151c.setCurrentItem(i);
        this.f12149a.a(((SwipeImagePagerAdapter) this.f12153e.getAdapter()).mo330c(i), CallerContext.a(getContext()));
        this.f12155g.m12578c(i);
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        m12602a(onPageChangeListener);
    }

    public final void m12602a(OnPageChangeListener onPageChangeListener) {
        this.f12152d.add(onPageChangeListener);
    }

    private void m12592b(OnPageChangeListener onPageChangeListener) {
        this.f12152d.remove(onPageChangeListener);
    }

    public final void m12600a() {
        this.f12151c.getAdapter().kR_();
        setCurrentItem(this.f12153e.k);
        int i = this.f12153e.B;
        int i2 = this.f12153e.k - i;
        int i3 = this.f12153e.k + i;
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) this.f12151c.getAdapter();
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 >= this.f12151c.getAdapter().b()) {
            i3 = this.f12151c.getAdapter().b() - 1;
        }
        for (int i4 = i2; i4 <= i3; i4++) {
            BadgableDraweeView badgableDraweeView = (BadgableDraweeView) this.f12151c.findViewWithTag(Integer.valueOf(i4));
            if (badgableDraweeView != null) {
                viewPagerAdapter.m12585a(badgableDraweeView, i4);
                if (i4 == this.f12153e.k) {
                    badgableDraweeView.setDimValue(0.0f);
                }
            }
        }
    }

    public int getCurrentItem() {
        return this.f12153e.k;
    }

    public ViewPager getImageViewPager() {
        return this.f12151c;
    }

    public TouchablePagerContainer getImageViewPagerContainer() {
        return this.f12154f;
    }

    public FbDraweeView getBackgroundImageView() {
        return this.f12149a;
    }

    public final void m12601a(int i, float f, int i2) {
        this.f12154f.invalidate();
        for (int i3 = 0; i3 < this.f12152d.size(); i3++) {
            ((OnPageChangeListener) this.f12152d.get(i3)).a(i, f, i2);
        }
    }

    public final void e_(int i) {
        setCurrentItem(i);
        for (int i2 = 0; i2 < this.f12152d.size(); i2++) {
            ((OnPageChangeListener) this.f12152d.get(i2)).e_(i);
        }
    }

    public final void m12604b(int i) {
        for (int i2 = 0; i2 < this.f12152d.size(); i2++) {
            ((OnPageChangeListener) this.f12152d.get(i2)).b(i);
        }
    }
}
