package com.facebook.pages.fb4a.admin_activity.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger.BoostedComponentModule;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger.Event;
import com.facebook.adinterfaces.util.AdInterfacesHelper;
import com.facebook.graphql.enums.GraphQLBoostedActionStatus;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLInterfaces.FetchPageActivityQuery.ActivityAdminInfo;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLModels.FetchPageActivityQueryModel.ActivityAdminInfoModel;
import com.facebook.pages.fb4a.admin_activity.fragment.PageActivityFragment.UpdateViewListener;
import com.facebook.pages.fb4a.admin_activity.views.PageActivityInsightsUniController.InsightsUniCard;
import com.facebook.pages.fb4a.admin_activity.views.PageIdentityLinkView.WebViewLaunchedListener;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: quickpromotion */
public class PageActivityUniUpsellCardView extends CustomFrameLayout implements InsightsUniCard {
    private FbButton f2867a;
    public PagesAnalytics f2868b;
    public AdInterfacesHelper f2869c;
    private AdInterfacesExternalLogger f2870d;

    private static <T extends View> void m3822a(Class<T> cls, T t) {
        m3823a((Object) t, t.getContext());
    }

    private static void m3823a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageActivityUniUpsellCardView) obj).m3821a(PagesAnalytics.a(fbInjector), AdInterfacesHelper.a(fbInjector), AdInterfacesExternalLogger.a(fbInjector));
    }

    public PageActivityUniUpsellCardView(Context context) {
        super(context);
        m3820a();
    }

    public PageActivityUniUpsellCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3820a();
    }

    public PageActivityUniUpsellCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3820a();
    }

    private void m3820a() {
        setContentView(2130905952);
        m3822a(PageActivityUniUpsellCardView.class, (View) this);
        this.f2867a = (FbButton) c(2131565316);
        ((ImageView) c(2131565313)).setImageResource(2130842434);
        ((FbTextView) c(2131565314)).setText(2131235088);
        ((FbTextView) c(2131565315)).setText(2131235089);
    }

    @Inject
    private void m3821a(PagesAnalytics pagesAnalytics, AdInterfacesHelper adInterfacesHelper, AdInterfacesExternalLogger adInterfacesExternalLogger) {
        this.f2868b = pagesAnalytics;
        this.f2869c = adInterfacesHelper;
        this.f2870d = adInterfacesExternalLogger;
    }

    public final void mo74a(long j, @Nullable ActivityAdminInfo activityAdminInfo, Optional<? extends WebViewLaunchedListener> optional) {
        if (activityAdminInfo == null || !activityAdminInfo.mT_()) {
            setVisibility(8);
            return;
        }
        GraphQLBoostedActionStatus a = activityAdminInfo.m2746c() != null ? activityAdminInfo.m2746c().m2714a() : null;
        Event event = (a == GraphQLBoostedActionStatus.ERROR || a == GraphQLBoostedActionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) ? Event.EVENT_RENDER_FAIL_ENTRY_POINT : Event.EVENT_RENDER_CREATE_ENTRY_POINT;
        this.f2870d.a(BoostedComponentModule.PROMOTE_PAGE_MOBILE_MODULE, event, String.valueOf(j), "pages_manager_activity_tab");
        this.f2867a.setText(activityAdminInfo.m2747d());
        final long j2 = j;
        final ActivityAdminInfoModel activityAdminInfoModel = activityAdminInfo;
        final Optional<? extends WebViewLaunchedListener> optional2 = optional;
        this.f2867a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageActivityUniUpsellCardView f2866d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 259764835);
                this.f2866d.f2868b.a(j2, activityAdminInfoModel.m2747d(), "upsell_card");
                if (!this.f2866d.f2869c.b() && optional2.isPresent()) {
                    ((UpdateViewListener) optional2.get()).m3741a();
                }
                this.f2866d.f2869c.a(view.getContext(), j2);
                Logger.a(2, EntryType.UI_INPUT_END, -1419354487, a);
            }
        });
    }
}
