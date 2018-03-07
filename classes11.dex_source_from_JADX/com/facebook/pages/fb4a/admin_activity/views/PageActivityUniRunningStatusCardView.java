package com.facebook.pages.fb4a.admin_activity.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger.BoostedComponentModule;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger.Event;
import com.facebook.adinterfaces.util.AdInterfacesHelper;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.graphql.enums.GraphQLAdproLimitResetPeriod;
import com.facebook.graphql.enums.GraphQLBoostedActionStatus;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLInterfaces.FetchPageActivityQuery.ActivityAdminInfo;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLModels.FetchPageActivityQueryModel.ActivityAdminInfoModel.BoostedPageLikePromotionInfoModel;
import com.facebook.pages.fb4a.admin_activity.fragment.PageActivityFragment.UpdateViewListener;
import com.facebook.pages.fb4a.admin_activity.views.PageActivityInsightsUniController.InsightsUniCard;
import com.facebook.pages.fb4a.admin_activity.views.PageIdentityLinkView.WebViewLaunchedListener;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Optional;
import java.sql.Date;
import java.text.DateFormat;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: quicksilver */
public class PageActivityUniRunningStatusCardView extends CustomFrameLayout implements InsightsUniCard {
    private ImageView f2846a;
    private FbTextView f2847b;
    private FbTextView f2848c;
    private FbTextView f2849d;
    private FbTextView f2850e;
    public PageActivityUniRunningStatusCardRow f2851f;
    public PageActivityUniRunningStatusCardRow f2852g;
    private PageActivityUniRunningStatusCardRow f2853h;
    private ImageView f2854i;
    private FbTextView f2855j;
    private LinearLayout f2856k;
    private View f2857l;
    private NumberTruncationUtil f2858m;
    public PagesAnalytics f2859n;
    public AdInterfacesHelper f2860o;
    private AdInterfacesExternalLogger f2861p;
    public Resources f2862q;

    /* compiled from: quicksilver */
    public /* synthetic */ class C03812 {
        public static final /* synthetic */ int[] f2844a = new int[GraphQLAdproLimitResetPeriod.values().length];
        static final /* synthetic */ int[] f2845b = new int[GraphQLBoostedActionStatus.values().length];

        static {
            try {
                f2845b[GraphQLBoostedActionStatus.CREATING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2845b[GraphQLBoostedActionStatus.ACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2845b[GraphQLBoostedActionStatus.PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2845b[GraphQLBoostedActionStatus.PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2845b[GraphQLBoostedActionStatus.FINISHED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2844a[GraphQLAdproLimitResetPeriod.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2844a[GraphQLAdproLimitResetPeriod.MONTH.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f2844a[GraphQLAdproLimitResetPeriod.LIFETIME.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    private static <T extends View> void m3815a(Class<T> cls, T t) {
        m3816a((Object) t, t.getContext());
    }

    private static void m3816a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageActivityUniRunningStatusCardView) obj).m3814a(NumberTruncationUtil.a(fbInjector), PagesAnalytics.a(fbInjector), AdInterfacesHelper.a(fbInjector), AdInterfacesExternalLogger.a(fbInjector));
    }

    public PageActivityUniRunningStatusCardView(Context context) {
        super(context);
        m3813a();
    }

    public PageActivityUniRunningStatusCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3813a();
    }

    public PageActivityUniRunningStatusCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3813a();
    }

    private void m3813a() {
        setContentView(2130905957);
        m3815a(PageActivityUniRunningStatusCardView.class, (View) this);
        this.f2846a = (ImageView) c(2131565328);
        this.f2847b = (FbTextView) c(2131565329);
        this.f2848c = (FbTextView) c(2131565330);
        this.f2849d = (FbTextView) c(2131565332);
        this.f2850e = (FbTextView) c(2131565333);
        this.f2851f = (PageActivityUniRunningStatusCardRow) c(2131565334);
        this.f2852g = (PageActivityUniRunningStatusCardRow) c(2131565335);
        this.f2853h = (PageActivityUniRunningStatusCardRow) c(2131565336);
        this.f2856k = (LinearLayout) c(2131565338);
        this.f2854i = (ImageView) c(2131565339);
        this.f2855j = (FbTextView) c(2131565340);
        this.f2857l = c(2131565337);
        this.f2862q = getResources();
    }

    public final void mo74a(final long j, @Nullable ActivityAdminInfo activityAdminInfo, final Optional<? extends WebViewLaunchedListener> optional) {
        if (activityAdminInfo == null || activityAdminInfo.m2746c() == null) {
            setVisibility(8);
            return;
        }
        String string;
        GraphQLBoostedActionStatus a = activityAdminInfo.m2746c().m2714a();
        Event event = (a == GraphQLBoostedActionStatus.ERROR || a == GraphQLBoostedActionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) ? Event.EVENT_RENDER_FAIL_ENTRY_POINT : Event.EVENT_RENDER_EDIT_ENTRY_POINT;
        this.f2861p.a(BoostedComponentModule.PROMOTE_PAGE_MOBILE_MODULE, event, String.valueOf(j), "pages_manager_activity_tab");
        this.f2846a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageActivityUniRunningStatusCardView f2843c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1377489039);
                this.f2843c.f2859n.a(j);
                if (!this.f2843c.f2860o.b() && optional.isPresent()) {
                    ((UpdateViewListener) optional.get()).m3741a();
                }
                this.f2843c.f2860o.a(view.getContext(), j);
                Logger.a(2, EntryType.UI_INPUT_END, -1213910352, a);
            }
        });
        BoostedPageLikePromotionInfoModel c = activityAdminInfo.m2746c();
        setupCounts(c);
        switch (C03812.f2844a[c.m2720g().ordinal()]) {
            case 1:
                string = this.f2862q.getString(2131235095);
                break;
            case 2:
                string = this.f2862q.getString(2131235096);
                break;
            case 3:
                string = this.f2862q.getString(2131235097);
                break;
            default:
                string = this.f2862q.getString(2131235098);
                break;
        }
        this.f2852g.setName(string);
        this.f2852g.setValue(c.m2717b());
        this.f2851f.setName(this.f2862q.getString(2131235094));
        this.f2851f.setValue(c.mV_());
        setupDuration(c);
        setupStatus(c);
    }

    @Inject
    private void m3814a(NumberTruncationUtil numberTruncationUtil, PagesAnalytics pagesAnalytics, AdInterfacesHelper adInterfacesHelper, AdInterfacesExternalLogger adInterfacesExternalLogger) {
        this.f2858m = numberTruncationUtil;
        this.f2859n = pagesAnalytics;
        this.f2860o = adInterfacesHelper;
        this.f2860o = adInterfacesHelper;
        this.f2861p = adInterfacesExternalLogger;
    }

    private void setupCounts(BoostedPageLikePromotionInfoModel boostedPageLikePromotionInfoModel) {
        int d = boostedPageLikePromotionInfoModel.m2719d();
        this.f2847b.setText(m3812a(d));
        this.f2848c.setText(this.f2862q.getQuantityString(2131689606, d));
        this.f2849d.setText(m3812a(boostedPageLikePromotionInfoModel.mU_()));
        this.f2850e.setText(2131235093);
    }

    private void setupDuration(BoostedPageLikePromotionInfoModel boostedPageLikePromotionInfoModel) {
        String a;
        this.f2853h.setName(this.f2862q.getString(2131235099));
        String format = DateFormat.getDateInstance().format(new Date(boostedPageLikePromotionInfoModel.mW_() * 1000));
        if (boostedPageLikePromotionInfoModel.m2721j() != 0) {
            a = StringFormatUtil.a(this.f2862q.getString(2131235100), new Object[]{format, r0.format(new Date(boostedPageLikePromotionInfoModel.m2721j() * 1000))});
        } else {
            a = StringFormatUtil.a(this.f2862q.getString(2131235101), new Object[]{format});
        }
        this.f2853h.setValue(a);
    }

    private void setupStatus(BoostedPageLikePromotionInfoModel boostedPageLikePromotionInfoModel) {
        CharSequence string;
        int i;
        int color = this.f2862q.getColor(2131361936);
        switch (C03812.f2845b[boostedPageLikePromotionInfoModel.m2714a().ordinal()]) {
            case 1:
                string = this.f2862q.getString(2131235107);
                i = 0;
                break;
            case 2:
                string = this.f2862q.getString(2131235103);
                color = this.f2862q.getColor(2131363051);
                i = 2130842430;
                break;
            case 3:
                string = this.f2862q.getString(2131235104);
                i = 2130842431;
                break;
            case 4:
                string = this.f2862q.getString(2131235106);
                i = 0;
                break;
            case 5:
                string = this.f2862q.getString(2131235105);
                i = 0;
                break;
            default:
                string = null;
                i = 0;
                break;
        }
        if (string == null) {
            this.f2856k.setVisibility(8);
            this.f2857l.setVisibility(8);
            return;
        }
        this.f2855j.setText(string);
        this.f2855j.setTextColor(color);
        if (i != 0) {
            this.f2854i.setVisibility(0);
            this.f2854i.setImageResource(i);
            return;
        }
        this.f2854i.setVisibility(8);
    }

    private String m3812a(int i) {
        if (i >= 10000) {
            return this.f2858m.a(i);
        }
        return StringLocaleUtil.a("%,d", new Object[]{Integer.valueOf(i)});
    }
}
