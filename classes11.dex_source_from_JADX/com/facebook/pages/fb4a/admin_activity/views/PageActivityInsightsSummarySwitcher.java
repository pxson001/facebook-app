package com.facebook.pages.fb4a.admin_activity.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.AdminActivityTabEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLModels.FetchPageActivityQueryModel.ActivityAdminInfoModel.PageInsightsSummaryModel;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: quicksilver_start_time */
public class PageActivityInsightsSummarySwitcher extends CustomLinearLayout {
    PagesAnalytics f2770a;
    private Resources f2771b;
    public InsightsSwitcherStateListener f2772c;
    public InsightsSwitcherState f2773d;
    private long f2774e = -1;
    private RelativeLayout f2775f;
    private FbTextView f2776g;
    private FbTextView f2777h;
    private RelativeLayout f2778i;
    private FbTextView f2779j;
    private FbTextView f2780k;
    private NumberTruncationUtil f2781l;

    /* compiled from: quicksilver_start_time */
    class C03701 implements OnClickListener {
        final /* synthetic */ PageActivityInsightsSummarySwitcher f2768a;

        C03701(PageActivityInsightsSummarySwitcher pageActivityInsightsSummarySwitcher) {
            this.f2768a = pageActivityInsightsSummarySwitcher;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1165711559);
            this.f2768a.setSwitcherState(InsightsSwitcherState.WEEKLY_LIKE);
            Logger.a(2, EntryType.UI_INPUT_END, 1399614607, a);
        }
    }

    /* compiled from: quicksilver_start_time */
    class C03712 implements OnClickListener {
        final /* synthetic */ PageActivityInsightsSummarySwitcher f2769a;

        C03712(PageActivityInsightsSummarySwitcher pageActivityInsightsSummarySwitcher) {
            this.f2769a = pageActivityInsightsSummarySwitcher;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1786654516);
            this.f2769a.setSwitcherState(InsightsSwitcherState.WEEKLY_POST_REACH);
            Logger.a(2, EntryType.UI_INPUT_END, 517824963, a);
        }
    }

    /* compiled from: quicksilver_start_time */
    public enum InsightsSwitcherState {
        WEEKLY_LIKE,
        WEEKLY_POST_REACH
    }

    /* compiled from: quicksilver_start_time */
    public interface InsightsSwitcherStateListener {
        void mo73a(InsightsSwitcherState insightsSwitcherState);
    }

    private static <T extends View> void m3764a(Class<T> cls, T t) {
        m3765a((Object) t, t.getContext());
    }

    private static void m3765a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageActivityInsightsSummarySwitcher) obj).m3763a(NumberTruncationUtil.a(fbInjector), PagesAnalytics.a(fbInjector));
    }

    public PageActivityInsightsSummarySwitcher(Context context) {
        super(context);
        m3762a();
    }

    public PageActivityInsightsSummarySwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3762a();
    }

    public PageActivityInsightsSummarySwitcher(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3762a();
    }

    private void m3762a() {
        setContentView(2130905953);
        m3764a(PageActivityInsightsSummarySwitcher.class, (View) this);
        this.f2775f = (RelativeLayout) a(2131565317);
        this.f2776g = (FbTextView) a(2131565318);
        this.f2777h = (FbTextView) a(2131565319);
        this.f2778i = (RelativeLayout) a(2131565321);
        this.f2779j = (FbTextView) a(2131565322);
        this.f2780k = (FbTextView) a(2131565323);
        this.f2771b = getResources();
        this.f2775f.setOnClickListener(new C03701(this));
        this.f2778i.setOnClickListener(new C03712(this));
    }

    @Inject
    private void m3763a(NumberTruncationUtil numberTruncationUtil, PagesAnalytics pagesAnalytics) {
        this.f2781l = numberTruncationUtil;
        this.f2770a = pagesAnalytics;
    }

    public final void m3769a(@Nullable PageInsightsSummaryModel pageInsightsSummaryModel, long j) {
        if (pageInsightsSummaryModel != null) {
            this.f2774e = j;
            m3766c(pageInsightsSummaryModel.m2731a());
            m3767d(pageInsightsSummaryModel.m2735b());
            setVisibility(0);
        }
    }

    public void setSwitcherState(InsightsSwitcherState insightsSwitcherState) {
        if (this.f2773d != insightsSwitcherState) {
            if (this.f2772c != null) {
                if (this.f2773d != null && insightsSwitcherState == InsightsSwitcherState.WEEKLY_LIKE) {
                    this.f2770a.b(AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_INSIGHTS_WEEKLY_LIKE, this.f2774e);
                } else if (this.f2773d != null && insightsSwitcherState == InsightsSwitcherState.WEEKLY_POST_REACH) {
                    this.f2770a.b(AdminActivityTabEvent.EVENT_ADMIN_ACTIVITY_CLICK_INSIGHTS_WEEKLY_POST_REACH, this.f2774e);
                }
                this.f2772c.mo73a(insightsSwitcherState);
            }
            this.f2773d = insightsSwitcherState;
        }
    }

    public InsightsSwitcherState getSwitcherState() {
        return this.f2773d;
    }

    public void setInsightsSwitcherStateListener(InsightsSwitcherStateListener insightsSwitcherStateListener) {
        this.f2772c = insightsSwitcherStateListener;
    }

    private void m3766c(int i) {
        this.f2776g.setText(m3768e(i));
        CharSequence quantityString = this.f2771b.getQuantityString(2131689605, i);
        this.f2777h.setText(quantityString);
        this.f2777h.setContentDescription(quantityString);
    }

    private void m3767d(int i) {
        this.f2779j.setText(m3768e(i));
        CharSequence string = this.f2771b.getString(2131235087);
        this.f2780k.setText(string);
        this.f2780k.setContentDescription(string);
    }

    private String m3768e(int i) {
        if (i >= 10000) {
            return this.f2781l.a(i);
        }
        return StringLocaleUtil.a("%,d", new Object[]{Integer.valueOf(i)});
    }
}
