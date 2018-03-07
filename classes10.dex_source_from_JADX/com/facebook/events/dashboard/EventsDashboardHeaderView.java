package com.facebook.events.dashboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dashboard.EventsDashboardFilterView.OnFilterTypeChangedListener;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventCountsQueryModel.EventCountsModel;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Supplier;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: commerce/admin/products/{#%s}/edit */
public class EventsDashboardHeaderView extends SegmentedLinearLayout {
    @Inject
    EventsDashboardController f16676a;
    @Inject
    EventPermalinkController f16677b;
    @Inject
    EventsDashboardPerformanceLogger f16678c;
    private EventsDashboardFilterView f16679d;
    private ImageWithTextView f16680e;
    public EventAnalyticsParams f16681f;

    /* compiled from: commerce/admin/products/{#%s}/edit */
    class C23281 implements OnFilterTypeChangedListener {
        final /* synthetic */ EventsDashboardHeaderView f16674a;

        C23281(EventsDashboardHeaderView eventsDashboardHeaderView) {
            this.f16674a = eventsDashboardHeaderView;
        }

        public final void mo789a(@Nonnull DashboardFilterType dashboardFilterType) {
            if (dashboardFilterType != this.f16674a.f16676a.f16570c) {
                this.f16674a.f16678c.m17098b(dashboardFilterType.name());
                this.f16674a.f16676a.m16979a(dashboardFilterType);
            }
        }
    }

    /* compiled from: commerce/admin/products/{#%s}/edit */
    class C23292 implements OnClickListener {
        final /* synthetic */ EventsDashboardHeaderView f16675a;

        C23292(EventsDashboardHeaderView eventsDashboardHeaderView) {
            this.f16675a = eventsDashboardHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -487670660);
            this.f16675a.f16677b.m18265a(this.f16675a.getContext(), this.f16675a.f16681f, ActionMechanism.DASHBOARD_HEADER);
            Logger.a(2, EntryType.UI_INPUT_END, -70369901, a);
        }
    }

    private static <T extends View> void m17078a(Class<T> cls, T t) {
        m17079a((Object) t, t.getContext());
    }

    private static void m17079a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventsDashboardHeaderView) obj).m17077a(EventsDashboardController.m16975a(injectorLike), EventPermalinkController.m18262b(injectorLike), EventsDashboardPerformanceLogger.m17093a(injectorLike));
    }

    public EventsDashboardHeaderView(Context context) {
        super(context);
        m17076a();
    }

    public EventsDashboardHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17076a();
    }

    private void m17076a() {
        m17078a(EventsDashboardHeaderView.class, (View) this);
        setContentView(2130904128);
        this.f16679d = (EventsDashboardFilterView) a(2131561511);
        this.f16679d.setDashboardFilterType(this.f16676a.f16570c);
        this.f16679d.f16596l = new C23281(this);
        this.f16680e = (ImageWithTextView) a(2131561512);
        this.f16680e.setOnClickListener(new C23292(this));
    }

    private void m17077a(EventsDashboardController eventsDashboardController, EventPermalinkController eventPermalinkController, EventsDashboardPerformanceLogger eventsDashboardPerformanceLogger) {
        this.f16676a = eventsDashboardController;
        this.f16677b = eventPermalinkController;
        this.f16678c = eventsDashboardPerformanceLogger;
    }

    public final void m17080a(@Nonnull Supplier<EventCountsModel> supplier, EventAnalyticsParams eventAnalyticsParams) {
        this.f16679d.f16597m = supplier;
        this.f16681f = eventAnalyticsParams;
    }
}
