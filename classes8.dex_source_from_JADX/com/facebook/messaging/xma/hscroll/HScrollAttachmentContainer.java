package com.facebook.messaging.xma.hscroll;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.SizeUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel.SubattachmentsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.xma.StyleRendererManager;
import com.facebook.messaging.xma.ui.XMALongClickHelper;
import com.facebook.messaging.xma.ui.XMALongClickHelper.LongClickListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tiled_places_search */
public final class HScrollAttachmentContainer extends CustomFrameLayout {
    @Inject
    HScrollAttachmentAdapter f1589a;
    @Inject
    AnalyticsLogger f1590b;
    @Inject
    XMALongClickHelper f1591c;
    private HScrollAttachmentViewPager f1592d;
    private int f1593e;
    private Rect f1594f;
    public boolean f1595g;
    @Nullable
    public String f1596h;
    @Nullable
    public OnPageChangeListener f1597i;

    /* compiled from: tiled_places_search */
    class C01661 implements android.support.v4.view.ViewPager.OnPageChangeListener {
        final /* synthetic */ HScrollAttachmentContainer f1587a;

        C01661(HScrollAttachmentContainer hScrollAttachmentContainer) {
            this.f1587a = hScrollAttachmentContainer;
        }

        public final void m1764a(int i, float f, int i2) {
            if (this.f1587a.f1595g) {
                this.f1587a.invalidate();
            }
            if (this.f1587a.f1597i != null) {
                this.f1587a.f1597i.m1769a(i, i2);
            }
        }

        public final void e_(int i) {
            Preconditions.checkNotNull(this.f1587a.f1596h);
            this.f1587a.m1776a(this.f1587a.f1596h, i, this.f1587a.f1589a.m1763f(i));
            if (this.f1587a.f1597i != null) {
                this.f1587a.f1597i.m1768a(i);
            }
        }

        public final void m1765b(int i) {
            boolean z;
            HScrollAttachmentContainer hScrollAttachmentContainer = this.f1587a;
            if (i != 0) {
                z = true;
            } else {
                z = false;
            }
            hScrollAttachmentContainer.f1595g = z;
        }
    }

    /* compiled from: tiled_places_search */
    class C01672 implements LongClickListener {
        final /* synthetic */ HScrollAttachmentContainer f1588a;

        C01672(HScrollAttachmentContainer hScrollAttachmentContainer) {
            this.f1588a = hScrollAttachmentContainer;
        }

        public final void mo69a() {
            this.f1588a.performLongClick();
        }
    }

    /* compiled from: tiled_places_search */
    public interface OnPageChangeListener {
        void m1768a(int i);

        void m1769a(int i, int i2);
    }

    private static <T extends View> void m1774a(Class<T> cls, T t) {
        m1775a((Object) t, t.getContext());
    }

    private static void m1775a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((HScrollAttachmentContainer) obj).m1772a(new HScrollAttachmentAdapter((Context) injectorLike.getInstance(Context.class), RecyclableViewPoolManager.a(injectorLike), StyleRendererManager.m1739a(injectorLike)), AnalyticsLoggerMethodAutoProvider.a(injectorLike), XMALongClickHelper.m1799b(injectorLike));
    }

    private void m1772a(HScrollAttachmentAdapter hScrollAttachmentAdapter, AnalyticsLogger analyticsLogger, XMALongClickHelper xMALongClickHelper) {
        this.f1589a = hScrollAttachmentAdapter;
        this.f1590b = analyticsLogger;
        this.f1591c = xMALongClickHelper;
    }

    public HScrollAttachmentContainer(Context context) {
        super(context);
        m1770a();
    }

    public HScrollAttachmentContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m1770a();
    }

    public HScrollAttachmentContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1770a();
    }

    private void m1770a() {
        m1774a(HScrollAttachmentContainer.class, (View) this);
        this.f1594f = new Rect();
        this.f1593e = SizeUtil.a(getContext(), 4.0f);
        if (VERSION.SDK_INT > 11 && VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        setClipChildren(false);
        m1780b();
        m1782e();
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m1780b() {
        this.f1592d = new HScrollAttachmentViewPager(getContext());
        this.f1592d.setLayoutParams(new LayoutParams(-1, -2));
        this.f1592d.b(0, true);
        this.f1592d.setClipChildren(false);
        this.f1592d.setPageMargin(this.f1593e);
        addView(this.f1592d);
        this.f1592d.setOnPageChangeListener(new C01661(this));
    }

    public final HScrollAttachmentAdapter getAdapter() {
        return this.f1589a;
    }

    public final void setOnPageScrolledListener(OnPageChangeListener onPageChangeListener) {
        this.f1597i = onPageChangeListener;
    }

    public final void m1785a(XMAModel xMAModel, int i) {
        Preconditions.checkNotNull(xMAModel);
        Preconditions.checkState(!Strings.isNullOrEmpty(xMAModel.b()));
        Preconditions.checkNotNull(xMAModel.c());
        this.f1596h = xMAModel.b();
        this.f1589a.m1759a(xMAModel.c().aO_());
        this.f1592d.setAdapter(this.f1589a);
        this.f1592d.setCurrentItem(i);
        if (this.f1589a.b() != 0) {
            m1776a(this.f1596h, 0, this.f1589a.m1763f(0));
        }
    }

    public final void m1784a(int i, int i2, int i3, int i4) {
        HScrollAttachmentAdapter hScrollAttachmentAdapter = this.f1589a;
        hScrollAttachmentAdapter.f1583d[0] = i;
        hScrollAttachmentAdapter.f1583d[1] = i2;
        hScrollAttachmentAdapter.f1583d[2] = i3;
        hScrollAttachmentAdapter.f1583d[3] = i4;
    }

    public final void m1783a(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f1592d.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        this.f1592d.setLayoutParams(layoutParams);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -11820465);
        this.f1591c.m1801b(motionEvent);
        if (getViewPagerVisibleRect().contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            motionEvent.offsetLocation(-this.f1592d.getX(), -this.f1592d.getY());
            boolean dispatchTouchEvent = this.f1592d.dispatchTouchEvent(motionEvent);
            motionEvent.offsetLocation(this.f1592d.getX(), this.f1592d.getY());
            LogUtils.a(1687287793, a);
            return dispatchTouchEvent;
        }
        dispatchTouchEvent = super.onTouchEvent(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -839172170, a);
        return dispatchTouchEvent;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1591c.m1800a(motionEvent) || super.onInterceptTouchEvent(motionEvent);
    }

    protected final void onMeasure(int i, int i2) {
        m1771a(MeasureSpec.getSize(i));
        super.onMeasure(i, i2);
    }

    private void m1771a(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f1592d.getLayoutParams();
        int i2 = i - (layoutParams.leftMargin + layoutParams.rightMargin);
        int i3 = layoutParams.leftMargin / i2;
        if (layoutParams.leftMargin % i2 > 0) {
            i3++;
        }
        int i4 = i - (layoutParams.leftMargin + i2);
        int i5 = i4 / i2;
        if (i4 % i2 > 0) {
            i5++;
        }
        this.f1592d.setOffscreenPageLimit(Math.max(i3, i5) + 1);
    }

    private Rect getViewPagerVisibleRect() {
        int x = ((int) this.f1592d.getX()) - this.f1592d.getScrollX();
        int y = ((int) this.f1592d.getY()) - this.f1592d.getScrollY();
        int b = this.f1589a.b();
        this.f1594f.set(x, y, ((b - 1) * this.f1592d.q) + ((this.f1592d.getWidth() * b) + x), this.f1592d.getHeight() + y);
        return this.f1594f;
    }

    private void m1776a(String str, int i, SubattachmentsModel subattachmentsModel) {
        String str2 = null;
        if (!(subattachmentsModel.g() == null || subattachmentsModel.g().c() == null)) {
            str2 = subattachmentsModel.g().c();
        }
        AnalyticsLogger analyticsLogger = this.f1590b;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("messenger_hscroll_impression");
        honeyClientEvent.c = "messenger_hscroll";
        analyticsLogger.a(honeyClientEvent.b("xma_id", str).a("page_position", i).b("attachment_target_id", str2));
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m1782e() {
        this.f1591c.f1607b = new C01672(this);
    }
}
