package com.facebook.pages.fb4a.admintabs;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.apptab.ui.NavigationTabsPageIndicator;
import com.facebook.content.event.FbEvent;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.constants.PagesPerfConstants.PageSequences;
import com.facebook.pages.common.eventbus.PageEventBus;
import com.facebook.pages.common.eventbus.PageEvents.PagesActivityDataChangeEventSubscriber;
import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TabSwitchEvent;
import com.facebook.pages.common.sequencelogger.PageFirstStoriesSequenceLoggerHelper;
import com.facebook.pages.common.sequencelogger.PageHeaderSequenceLoggerHelper;
import com.facebook.pages.common.sequencelogger.PagesSequenceLoggerHelper;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.view.ControlledView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.viewpager.ViewPagerWithCompositeOnPageChangeListener;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: pulsars */
public class PageIdentityAdminTabsView extends CustomFrameLayout {
    public static final List<PageIdentityAdminTabs> f2929f = ImmutableList.copyOf(PageIdentityAdminTabs.values());
    @Inject
    PagesAnalytics f2930a;
    @Inject
    PageHeaderSequenceLoggerHelper f2931b;
    @Inject
    PagesSequenceLoggerHelper f2932c;
    @Inject
    PageFirstStoriesSequenceLoggerHelper f2933d;
    @Inject
    PageEventBus f2934e;
    private NavigationTabsPageIndicator f2935g;
    public BadgeTextView f2936h;
    private ViewPagerWithCompositeOnPageChangeListener f2937i;
    private Handler f2938j;
    public PageIdentityAdminTabsView f2939k;
    public PageAdminsTabsViewData f2940l;
    private boolean f2941m = true;
    private final OnClickListener f2942n = new C03921(this);
    private final PagesActivityDataChangeEventSubscriber f2943o = new C03932(this);

    /* compiled from: pulsars */
    class C03921 implements OnClickListener {
        final /* synthetic */ PageIdentityAdminTabsView f2915a;

        C03921(PageIdentityAdminTabsView pageIdentityAdminTabsView) {
            this.f2915a = pageIdentityAdminTabsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1146853110);
            PageIdentityAdminTabs pageIdentityAdminTabs = (PageIdentityAdminTabs) view.getTag();
            if (pageIdentityAdminTabs != this.f2915a.f2940l.f2928f) {
                this.f2915a.m3896a(pageIdentityAdminTabs);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -578111765, a);
        }
    }

    /* compiled from: pulsars */
    class C03932 extends PagesActivityDataChangeEventSubscriber {
        final /* synthetic */ PageIdentityAdminTabsView f2916a;

        C03932(PageIdentityAdminTabsView pageIdentityAdminTabsView) {
            this.f2916a = pageIdentityAdminTabsView;
        }

        public final void m3875b(FbEvent fbEvent) {
            this.f2916a.m3896a(PageIdentityAdminTabs.ACTIVITY);
        }
    }

    /* compiled from: pulsars */
    class C03943 extends SimpleOnPageChangeListener {
        final /* synthetic */ PageIdentityAdminTabsView f2917a;

        C03943(PageIdentityAdminTabsView pageIdentityAdminTabsView) {
            this.f2917a = pageIdentityAdminTabsView;
        }

        public final void e_(int i) {
            this.f2917a.m3896a((PageIdentityAdminTabs) PageIdentityAdminTabsView.f2929f.get(i));
        }
    }

    /* compiled from: pulsars */
    class C03965 implements OnPageChangeListener {
        final /* synthetic */ PageIdentityAdminTabsView f2920a;
        private boolean f2921b = false;
        private int f2922c = -1;

        C03965(PageIdentityAdminTabsView pageIdentityAdminTabsView) {
            this.f2920a = pageIdentityAdminTabsView;
        }

        public final void m3876a(int i, float f, int i2) {
        }

        public final void e_(int i) {
            this.f2921b = true;
            this.f2922c = i;
        }

        public final void m3877b(int i) {
            if (i == 0 && this.f2921b && this.f2922c == 0) {
                this.f2920a.f2940l.f2927e = this.f2922c;
                this.f2920a.setVisibility(this.f2920a.f2940l.f2926d);
            }
            this.f2921b = false;
            this.f2922c = -1;
        }
    }

    /* compiled from: pulsars */
    public class PageAdminsTabsViewData {
        public long f2923a;
        public String f2924b;
        public long f2925c;
        public int f2926d;
        public int f2927e;
        public PageIdentityAdminTabs f2928f;

        public PageAdminsTabsViewData() {
            this.f2926d = 8;
            this.f2927e = 0;
            this.f2928f = PageIdentityAdminTabs.PAGE;
        }
    }

    /* compiled from: pulsars */
    public enum PageIdentityAdminTabs {
        PAGE("page", 2131565426, 2131565426),
        ACTIVITY("activity", 2131565427, 2131565427),
        INSIGHTS("insights", 2131565428, 2131565428);
        
        public final int tabButtonId;
        public final String tabName;
        public final int tabTextViewId;

        private PageIdentityAdminTabs(String str, int i, int i2) {
            this.tabName = str;
            this.tabButtonId = i;
            this.tabTextViewId = i2;
        }
    }

    private static <T extends View> void m3898a(Class<T> cls, T t) {
        m3899a((Object) t, t.getContext());
    }

    private static void m3899a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityAdminTabsView) obj).m3895a(PagesAnalytics.a(fbInjector), PageHeaderSequenceLoggerHelper.a(fbInjector), PagesSequenceLoggerHelper.b(fbInjector), PageFirstStoriesSequenceLoggerHelper.a(fbInjector), PageEventBus.m2423a(fbInjector));
    }

    public PageIdentityAdminTabsView(Context context) {
        super(context);
        m3901b();
    }

    public PageIdentityAdminTabsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3901b();
    }

    public PageIdentityAdminTabsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3901b();
    }

    private void m3901b() {
        setContentView(2130906003);
        m3898a(PageIdentityAdminTabsView.class, (View) this);
        this.f2940l = new PageAdminsTabsViewData();
        this.f2936h = (BadgeTextView) c(2131565427);
        for (PageIdentityAdminTabs pageIdentityAdminTabs : f2929f) {
            View c = c(pageIdentityAdminTabs.tabButtonId);
            c(pageIdentityAdminTabs.tabTextViewId);
            c.setTag(pageIdentityAdminTabs);
            c.setOnClickListener(this.f2942n);
        }
        this.f2935g = (NavigationTabsPageIndicator) ((ControlledView) findViewById(2131565429)).a;
        this.f2935g.c = new C03943(this);
        this.f2938j = new Handler(Looper.getMainLooper());
    }

    protected final void gI_() {
        super.gI_();
        this.f2934e.a(this.f2943o);
    }

    protected final void gJ_() {
        super.gJ_();
        this.f2934e.b(this.f2943o);
    }

    public long getActivityBadgeCount() {
        return this.f2940l.f2925c;
    }

    public void setActivityBadgeCount(final long j) {
        this.f2940l.f2925c = j;
        HandlerDetour.b(this.f2938j, new Runnable(this) {
            final /* synthetic */ PageIdentityAdminTabsView f2919b;

            public void run() {
                PageIdentityAdminTabsView.m3902b(this.f2919b.getContext(), this.f2919b.f2936h, j);
                if (this.f2919b.f2939k != null) {
                    PageIdentityAdminTabsView.m3902b(this.f2919b.getContext(), this.f2919b.f2939k.f2936h, j);
                }
            }
        }, 100, 669405297);
    }

    public final void m3904a(long j, String str) {
        this.f2940l.f2923a = j;
        this.f2940l.f2924b = str;
    }

    public void setPrimaryTabsView(PageIdentityAdminTabsView pageIdentityAdminTabsView) {
        if (pageIdentityAdminTabsView != null) {
            this.f2939k = pageIdentityAdminTabsView;
            pageIdentityAdminTabsView.f2939k = this;
            this.f2940l = pageIdentityAdminTabsView.f2940l;
            this.f2937i = pageIdentityAdminTabsView.f2937i;
            this.f2935g.a(pageIdentityAdminTabsView.f2937i);
            this.f2941m = false;
        }
    }

    public void setVisibility(int i) {
        boolean z = true;
        int i2 = 8;
        this.f2940l.f2926d = i;
        if (this.f2939k == null) {
            setViewVisibility(i);
            return;
        }
        boolean z2;
        boolean z3 = this.f2941m;
        if (this.f2939k.f2941m) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z3 != z2) {
            z = false;
        }
        Preconditions.checkState(z);
        if (this.f2940l.f2927e == 0) {
            setViewVisibility(this.f2941m ? 8 : this.f2940l.f2926d);
            PageIdentityAdminTabsView pageIdentityAdminTabsView = this.f2939k;
            if (this.f2941m) {
                i2 = this.f2940l.f2926d;
            }
            pageIdentityAdminTabsView.setViewVisibility(i2);
            return;
        }
        setViewVisibility(!this.f2941m ? 8 : this.f2940l.f2926d);
        pageIdentityAdminTabsView = this.f2939k;
        if (!this.f2941m) {
            i2 = this.f2940l.f2926d;
        }
        pageIdentityAdminTabsView.setViewVisibility(i2);
    }

    public void setViewPager(ViewPagerWithCompositeOnPageChangeListener viewPagerWithCompositeOnPageChangeListener) {
        this.f2937i = viewPagerWithCompositeOnPageChangeListener;
        this.f2935g.a(this.f2937i);
        this.f2937i.setOnPageChangeListener(new C03965(this));
    }

    private void m3895a(PagesAnalytics pagesAnalytics, PageHeaderSequenceLoggerHelper pageHeaderSequenceLoggerHelper, PagesSequenceLoggerHelper pagesSequenceLoggerHelper, PageFirstStoriesSequenceLoggerHelper pageFirstStoriesSequenceLoggerHelper, PageEventBus pageEventBus) {
        this.f2930a = pagesAnalytics;
        this.f2931b = pageHeaderSequenceLoggerHelper;
        this.f2932c = pagesSequenceLoggerHelper;
        this.f2933d = pageFirstStoriesSequenceLoggerHelper;
        this.f2934e = pageEventBus;
    }

    private void m3896a(PageIdentityAdminTabs pageIdentityAdminTabs) {
        if (this.f2937i != null) {
            int i = this.f2940l.f2927e;
            this.f2940l.f2927e = f2929f.indexOf(pageIdentityAdminTabs);
            if (i == 0 && i != this.f2940l.f2927e) {
                setVisibility(this.f2940l.f2926d);
            }
            m3893a(this.f2940l.f2927e);
            this.f2937i.setCurrentItem(pageIdentityAdminTabs.ordinal());
            this.f2940l.f2928f = pageIdentityAdminTabs;
            this.f2931b.b(this.f2940l.f2924b);
            this.f2932c.c(PageSequences.f);
            this.f2933d.b();
        }
    }

    private void m3893a(int i) {
        if (!this.f2941m) {
            Preconditions.checkNotNull(this.f2939k);
            Preconditions.checkState(this.f2939k.f2941m);
            this.f2939k.m3893a(i);
        } else if (this.f2937i != null) {
            PagerAdapter adapter = this.f2937i.getAdapter();
            if (adapter != null && adapter.b() > 1) {
                PageAnalyticsEvent pageAnalyticsEvent;
                if (i == PageIdentityAdminTabs.PAGE.ordinal()) {
                    pageAnalyticsEvent = TabSwitchEvent.EVENT_VISIT_PAGE_TAB;
                } else if (i == PageIdentityAdminTabs.ACTIVITY.ordinal()) {
                    pageAnalyticsEvent = TabSwitchEvent.EVENT_VISIT_ACTIVITY_TAB;
                } else if (i == PageIdentityAdminTabs.INSIGHTS.ordinal()) {
                    pageAnalyticsEvent = TabSwitchEvent.EVENT_VISIT_INSIGHTS_TAB;
                } else {
                    return;
                }
                this.f2930a.a(pageAnalyticsEvent, this.f2940l.f2923a);
            }
        }
    }

    protected void setViewVisibility(int i) {
        super.setVisibility(i);
    }

    public static void m3902b(Context context, BadgeTextView badgeTextView, long j) {
        if (j == 0) {
            badgeTextView.setBadgeText(null);
        } else {
            badgeTextView.setBadgeText(m3891a(context, Long.valueOf(j)));
        }
    }

    private static CharSequence m3891a(Context context, Long l) {
        if (l.longValue() > 20) {
            return context.getText(2131235086);
        }
        return String.valueOf(l);
    }
}
