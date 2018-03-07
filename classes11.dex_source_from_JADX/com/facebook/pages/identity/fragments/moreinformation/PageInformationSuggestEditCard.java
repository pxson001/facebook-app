package com.facebook.pages.identity.fragments.moreinformation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.logging.SuggestEditsAnalyticsLogger;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TapEvent;
import com.facebook.places.suggestions.PlaceSuggestionsIntentBuilder;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: pages_activity_result_handler */
public class PageInformationSuggestEditCard extends CustomFrameLayout {
    public Button f4046a;
    @Inject
    PlaceSuggestionsIntentBuilder f4047b;
    @Inject
    AbstractFbErrorReporter f4048c;
    @Inject
    SecureContextHelper f4049d;
    @Inject
    PagesAnalytics f4050e;
    @Inject
    SuggestEditsAnalyticsLogger f4051f;

    private static <T extends View> void m4966a(Class<T> cls, T t) {
        m4967a((Object) t, t.getContext());
    }

    private static void m4967a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageInformationSuggestEditCard) obj).m4965a(PlaceSuggestionsIntentBuilder.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), PagesAnalytics.a(fbInjector), SuggestEditsAnalyticsLogger.a(fbInjector));
    }

    public PageInformationSuggestEditCard(Context context) {
        super(context);
        m4964a();
    }

    public PageInformationSuggestEditCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4964a();
    }

    public PageInformationSuggestEditCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4964a();
    }

    private void m4964a() {
        m4966a(PageInformationSuggestEditCard.class, (View) this);
        setContentView(2130906060);
        this.f4046a = (Button) c(2131565606);
    }

    public final void m4968a(final String str, final String str2) {
        this.f4051f.a(CrowdEntryPoint.PAGE_MORE_INFORMATION_SUGGEST_EDITS, Optional.of(str));
        this.f4046a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageInformationSuggestEditCard f4045c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1876022248);
                Intent a2 = this.f4045c.f4047b.a(Long.parseLong(str), str2, "", null, CrowdEntryPoint.PAGE_MORE_INFORMATION_SUGGEST_EDITS);
                if (a2 == null) {
                    this.f4045c.f4048c.a("page_identity_suggest_edit_fail", "Failed to resolve suggest edits intent!");
                    Logger.a(2, EntryType.UI_INPUT_END, 2045895747, a);
                    return;
                }
                this.f4045c.f4050e.a(TapEvent.EVENT_TAPPED_SUGGEST_EDIT, Long.parseLong(str));
                this.f4045c.f4049d.a(a2, 10102, (Activity) this.f4045c.getContext());
                LogUtils.a(-689252306, a);
            }
        });
    }

    private void m4965a(PlaceSuggestionsIntentBuilder placeSuggestionsIntentBuilder, AbstractFbErrorReporter abstractFbErrorReporter, SecureContextHelper secureContextHelper, PagesAnalytics pagesAnalytics, SuggestEditsAnalyticsLogger suggestEditsAnalyticsLogger) {
        this.f4047b = placeSuggestionsIntentBuilder;
        this.f4048c = abstractFbErrorReporter;
        this.f4049d = secureContextHelper;
        this.f4050e = pagesAnalytics;
        this.f4051f = suggestEditsAnalyticsLogger;
    }
}
