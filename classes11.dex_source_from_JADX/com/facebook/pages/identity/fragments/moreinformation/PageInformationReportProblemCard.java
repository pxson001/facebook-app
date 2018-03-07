package com.facebook.pages.identity.fragments.moreinformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.bugreporter.BugReportFlowStartParams;
import com.facebook.bugreporter.BugReporter;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TapEvent;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: pages_browser */
public class PageInformationReportProblemCard extends CustomFrameLayout {
    public final TextView f4040a;
    @Inject
    Lazy<BugReporter> f4041b;
    @Inject
    PagesAnalytics f4042c;

    private static <T extends View> void m4962a(Class<T> cls, T t) {
        m4963a((Object) t, t.getContext());
    }

    private static void m4963a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageInformationReportProblemCard) obj).m4961a(IdBasedSingletonScopeProvider.b(fbInjector, 5011), PagesAnalytics.a(fbInjector));
    }

    public PageInformationReportProblemCard(Context context) {
        this(context, null);
    }

    public PageInformationReportProblemCard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageInformationReportProblemCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906057);
        this.f4040a = (TextView) c(2131565600);
        m4962a(PageInformationReportProblemCard.class, (View) this);
    }

    public void setupOnClickReportBug(final long j) {
        this.f4040a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageInformationReportProblemCard f4039b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1478093373);
                this.f4039b.f4042c.a(TapEvent.EVENT_TAPPED_REPORT_PROBLEM, j);
                ((BugReporter) this.f4039b.f4041b.get()).a(BugReportFlowStartParams.newBuilder().a(this.f4039b.getContext()).a());
                Logger.a(2, EntryType.UI_INPUT_END, 949432800, a);
            }
        });
    }

    private void m4961a(Lazy<BugReporter> lazy, PagesAnalytics pagesAnalytics) {
        this.f4041b = lazy;
        this.f4042c = pagesAnalytics;
    }
}
