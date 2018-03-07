package com.facebook.events.dashboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.locale.Locales;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventCountsQueryModel.EventCountsModel;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomHorizontalScrollView;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: composer/draft/?story_id={%s} */
public class EventsDashboardCaspianHeaderView extends CustomHorizontalScrollView {
    @Inject
    EventsDashboardPerformanceLogger f16551a;
    @Inject
    EventEventLogger f16552b;
    @Inject
    Locales f16553c;
    @Inject
    NumberTruncationUtil f16554d;
    private ImmutableList<EventsDashboardFilterTextView> f16555e;
    private boolean f16556f = false;
    public DashboardFilterType f16557g;
    private EventsDashboardFilterTextView f16558h;
    private Supplier<EventCountsModel> f16559i;
    public int f16560j = -1;
    public OnFilterClickedListener f16561k;

    /* compiled from: composer/draft/?story_id={%s} */
    public interface OnFilterClickedListener {
        void mo780a(DashboardFilterType dashboardFilterType);
    }

    private static <T extends View> void m16964a(Class<T> cls, T t) {
        m16965a((Object) t, t.getContext());
    }

    private static void m16965a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventsDashboardCaspianHeaderView) obj).m16963a(EventsDashboardPerformanceLogger.m17093a(injectorLike), EventEventLogger.m18119b(injectorLike), Locales.a(injectorLike), NumberTruncationUtil.a(injectorLike));
    }

    public EventsDashboardCaspianHeaderView(Context context) {
        super(context);
        m16961a();
    }

    public EventsDashboardCaspianHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m16961a();
    }

    protected EventsDashboardCaspianHeaderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16961a();
    }

    private void m16963a(EventsDashboardPerformanceLogger eventsDashboardPerformanceLogger, EventEventLogger eventEventLogger, Locales locales, NumberTruncationUtil numberTruncationUtil) {
        this.f16551a = eventsDashboardPerformanceLogger;
        this.f16552b = eventEventLogger;
        this.f16553c = locales;
        this.f16554d = numberTruncationUtil;
    }

    public void setCountsSummarySupplier(Supplier<EventCountsModel> supplier) {
        this.f16559i = supplier;
        m16970d();
    }

    public void setOnFilterClickedListener(OnFilterClickedListener onFilterClickedListener) {
        this.f16561k = onFilterClickedListener;
    }

    public void setShouldShowBirthdays(boolean z) {
        this.f16556f = z;
        m16967b();
    }

    private void m16961a() {
        m16964a(EventsDashboardCaspianHeaderView.class, (View) this);
        setContentView(2130904125);
        setHorizontalScrollBarEnabled(false);
        m16967b();
    }

    private void m16967b() {
        int i = 0;
        Builder builder = new Builder();
        builder.c((EventsDashboardFilterTextView) a(2131561506));
        builder.c((EventsDashboardFilterTextView) a(2131561507));
        builder.c((EventsDashboardFilterTextView) a(2131561508));
        builder.c((EventsDashboardFilterTextView) a(2131561509));
        if (this.f16556f) {
            builder.c((EventsDashboardFilterTextView) a(2131561510));
            a(2131561510).setVisibility(0);
        }
        this.f16555e = builder.b();
        DashboardFilterType[] values = DashboardFilterType.values();
        int length = values.length;
        int i2 = 0;
        while (i2 < length) {
            final DashboardFilterType dashboardFilterType = values[i2];
            if (i < this.f16555e.size()) {
                int i3;
                if (this.f16556f || dashboardFilterType != DashboardFilterType.BIRTHDAYS) {
                    EventsDashboardFilterTextView eventsDashboardFilterTextView = (EventsDashboardFilterTextView) this.f16555e.get(i);
                    if (dashboardFilterType == DashboardFilterType.INVITED) {
                        this.f16558h = eventsDashboardFilterTextView;
                    }
                    eventsDashboardFilterTextView.setText(getContext().getResources().getString(dashboardFilterType.menuStringResId).toUpperCase(this.f16553c.a()));
                    eventsDashboardFilterTextView.f16582a = dashboardFilterType;
                    eventsDashboardFilterTextView.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ EventsDashboardCaspianHeaderView f16550c;

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, 1575803854);
                            EventsDashboardCaspianHeaderView.m16968b(this.f16550c, i);
                            if (this.f16550c.f16557g != dashboardFilterType) {
                                this.f16550c.setDashboardFilterType(dashboardFilterType);
                                this.f16550c.f16552b.m18141c(dashboardFilterType.name());
                                this.f16550c.f16551a.m17098b(dashboardFilterType.name());
                                if (this.f16550c.f16561k != null) {
                                    this.f16550c.f16561k.mo780a(dashboardFilterType);
                                }
                            }
                            Logger.a(2, EntryType.UI_INPUT_END, 196906433, a);
                        }
                    });
                    i3 = i + 1;
                } else {
                    i3 = i;
                }
                i2++;
                i = i3;
            } else {
                return;
            }
        }
    }

    public static void m16968b(EventsDashboardCaspianHeaderView eventsDashboardCaspianHeaderView, int i) {
        int size = eventsDashboardCaspianHeaderView.f16555e.size();
        if (i >= 0 && i < size) {
            int left = ((View) eventsDashboardCaspianHeaderView.f16555e.get(i)).getLeft();
            if (i > 0) {
                size = ((View) eventsDashboardCaspianHeaderView.f16555e.get(i - 1)).getWidth() / 2;
            } else {
                size = 0;
            }
            eventsDashboardCaspianHeaderView.scrollTo(left - size, 0);
        }
    }

    public void setDashboardFilterType(DashboardFilterType dashboardFilterType) {
        this.f16557g = dashboardFilterType;
        m16969c();
    }

    private void m16969c() {
        int size = this.f16555e.size();
        for (int i = 0; i < size; i++) {
            EventsDashboardFilterTextView eventsDashboardFilterTextView = (EventsDashboardFilterTextView) this.f16555e.get(i);
            if (eventsDashboardFilterTextView.f16582a == this.f16557g) {
                eventsDashboardFilterTextView.setTextColor(getResources().getColor(2131361916));
            } else {
                eventsDashboardFilterTextView.setTextColor(getResources().getColor(2131361974));
            }
        }
        if (this.f16558h != null) {
            m16971e();
        }
    }

    private void m16970d() {
        if (this.f16559i != null && this.f16559i.get() != null) {
            this.f16560j = ((EventCountsModel) this.f16559i.get()).a();
            m16971e();
        }
    }

    private void m16971e() {
        if (this.f16558h == null) {
            return;
        }
        if (this.f16560j > 0) {
            this.f16558h.setBadgeText(this.f16554d.a(this.f16560j));
        } else {
            this.f16558h.setBadgeText(null);
        }
    }

    public void setBadge(int i) {
        this.f16560j = i;
        m16971e();
    }

    public int getBadgeCount() {
        return this.f16560j;
    }
}
