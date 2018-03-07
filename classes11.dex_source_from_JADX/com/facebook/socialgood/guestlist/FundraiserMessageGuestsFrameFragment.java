package com.facebook.socialgood.guestlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForUiThreadImmediate;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.graphql.calls.FundraiserIncrementPersonalUpdatesCountInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil;
import com.facebook.socialgood.guestlist.FundraiserGuestList.FundraiserIncrementPersonalUpdatesCountMutationString;
import com.facebook.socialgood.guestlist.FundraiserGuestListModels.FundraiserIncrementPersonalUpdatesCountMutationModel;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* compiled from: PAGE */
public class FundraiserMessageGuestsFrameFragment extends FbFragment {
    @Inject
    public SendAsMessageUtil f12698a;
    private HasTitleBar al;
    private TitleBarButtonSpec am;
    @Inject
    @ForUiThreadImmediate
    private ExecutorService f12699b;
    @Inject
    public GraphQLQueryExecutor f12700c;
    @Inject
    private AnalyticsLogger f12701d;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FbErrorReporter> f12702e = UltralightRuntime.b;
    public FundraiserGuestListPagerAdapter f12703f;
    public String f12704g;
    private int f12705h;
    private boolean f12706i;

    /* compiled from: PAGE */
    class C14981 extends OnToolbarButtonListener {
        final /* synthetic */ FundraiserMessageGuestsFrameFragment f12693a;

        C14981(FundraiserMessageGuestsFrameFragment fundraiserMessageGuestsFrameFragment) {
            this.f12693a = fundraiserMessageGuestsFrameFragment;
        }

        public final void m13199a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            ImmutableSet f = this.f12693a.f12703f.m13165f();
            if (f != null && !f.isEmpty()) {
                this.f12693a.f12698a.a(this.f12693a.ao(), this.f12693a.f12704g, this.f12693a.s.getString("fundraiser_title"), this.f12693a.m13207e(), this.f12693a.aq(), this.f12693a.ar(), f, "fundraiser", 113);
            }
        }
    }

    /* compiled from: PAGE */
    class FundraiserIncrementPersonalUpdatesCountMutationCallback implements FutureCallback<GraphQLResult<FundraiserIncrementPersonalUpdatesCountMutationModel>> {
        private String f12694a;
        private int f12695b;
        private AnalyticsLogger f12696c;
        private AbstractFbErrorReporter f12697d;

        public FundraiserIncrementPersonalUpdatesCountMutationCallback(String str, int i, AnalyticsLogger analyticsLogger, AbstractFbErrorReporter abstractFbErrorReporter) {
            this.f12694a = str;
            this.f12695b = i;
            this.f12696c = analyticsLogger;
            this.f12697d = abstractFbErrorReporter;
        }

        public void onSuccess(@Nullable Object obj) {
            AnalyticsLogger analyticsLogger = this.f12696c;
            String str = this.f12694a;
            int i = this.f12695b;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fundraiser_personal_update_mutation_success");
            honeyClientEvent.c = "social_good";
            analyticsLogger.a(honeyClientEvent.b("fundraiser_campaign_id", str).a("selected_guest_count", i));
        }

        public void onFailure(Throwable th) {
            AnalyticsLogger analyticsLogger = this.f12696c;
            String str = this.f12694a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fundraiser_personal_update_mutation_failure");
            honeyClientEvent.c = "social_good";
            analyticsLogger.a(honeyClientEvent.b("fundraiser_campaign_id", str));
            this.f12697d.a("personal_update_mutation_failure", th);
        }
    }

    public static void m13201a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FundraiserMessageGuestsFrameFragment) obj).m13200a(SendAsMessageUtil.a(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494));
    }

    public final View m13202a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 628689314);
        View inflate = layoutInflater.inflate(2130904561, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -861456186, a);
        return inflate;
    }

    public final void m13206c(Bundle bundle) {
        super.c(bundle);
        Class cls = FundraiserMessageGuestsFrameFragment.class;
        m13201a((Object) this, getContext());
        this.f12704g = this.s.getString("fundraiser_campaign_id");
        this.f12705h = bundle == null ? 0 : bundle.getInt("SELECTED_GUEST_COUNT");
        this.f12703f = new FundraiserGuestListPagerAdapter(s(), getContext(), Arrays.asList(new FundraiserGuestListTab[]{FundraiserGuestListTab.DONATED, FundraiserGuestListTab.NOT_DONATED}), this.f12704g);
    }

    public final void m13205a(View view, Bundle bundle) {
        super.a(view, bundle);
        ViewPager viewPager = (ViewPager) e(2131562456);
        viewPager.setAdapter(this.f12703f);
        FundraiserGuestListPagerAdapter fundraiserGuestListPagerAdapter = this.f12703f;
        for (int i = 0; i < fundraiserGuestListPagerAdapter.f12679c.size(); i++) {
            FbFragment[] fbFragmentArr = fundraiserGuestListPagerAdapter.f12678b;
            String str = fundraiserGuestListPagerAdapter.f12681e;
            FundraiserGuestListTab fundraiserGuestListTab = (FundraiserGuestListTab) fundraiserGuestListPagerAdapter.f12679c.get(i);
            Bundle bundle2 = new Bundle();
            bundle2.putString("FUNDRAISER_GUEST_LIST_TAB", fundraiserGuestListTab.toString());
            bundle2.putString("fundraiser_campaign_id", str);
            FundraiserMessageGuestsFragment fundraiserMessageGuestsFragment = new FundraiserMessageGuestsFragment();
            fundraiserMessageGuestsFragment.g(bundle2);
            fbFragmentArr[i] = fundraiserMessageGuestsFragment;
        }
        ((TabbedViewPagerIndicator) e(2131562455)).setViewPager(viewPager);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1080711973);
        super.mi_();
        at();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2014555577, a);
    }

    private void at() {
        this.al = (HasTitleBar) a(HasTitleBar.class);
        if (this.al != null) {
            Builder a = TitleBarButtonSpec.a();
            a.a = 1;
            a = a;
            a.g = jW_().getString(2131230744);
            a = a;
            a.h = -2;
            a = a;
            a.d = this.f12706i;
            this.am = a.a();
            this.al.a(this.am);
            this.al.a(new C14981(this));
            this.al.a_(au());
            this.al.c(true);
        }
    }

    public final void m13208e(Bundle bundle) {
        bundle.putInt("SELECTED_GUEST_COUNT", this.f12705h);
        super.e(bundle);
    }

    public final void m13203a() {
        int size = this.f12703f.m13165f().size();
        this.f12705h = size;
        this.f12706i = size > 0;
        this.am.t = this.f12706i;
        this.al.a(this.am);
        this.al.a_(au());
    }

    private String au() {
        if (this.f12705h <= 0) {
            return jW_().getString(2131242346);
        }
        return jW_().getString(2131242345, new Object[]{Integer.valueOf(this.f12705h)});
    }

    public final void m13204a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i == 113) {
            AnalyticsLogger analyticsLogger;
            String str;
            HoneyClientEvent honeyClientEvent;
            if (i2 == -1) {
                String str2 = this.f12704g;
                int i3 = this.f12705h;
                FundraiserIncrementPersonalUpdatesCountInputData fundraiserIncrementPersonalUpdatesCountInputData = new FundraiserIncrementPersonalUpdatesCountInputData();
                fundraiserIncrementPersonalUpdatesCountInputData.a("fundraiser_campaign_id", str2);
                GraphQlCallInput graphQlCallInput = fundraiserIncrementPersonalUpdatesCountInputData;
                graphQlCallInput.a("number_updated", Integer.valueOf(i3));
                Futures.a(this.f12700c.a(GraphQLRequest.a((FundraiserIncrementPersonalUpdatesCountMutationString) new FundraiserIncrementPersonalUpdatesCountMutationString().a("0", graphQlCallInput))), new FundraiserIncrementPersonalUpdatesCountMutationCallback(this.f12704g, this.f12705h, this.f12701d, (AbstractFbErrorReporter) this.f12702e.get()), this.f12699b);
                analyticsLogger = this.f12701d;
                str = this.f12704g;
                honeyClientEvent = new HoneyClientEvent("fundraiser_page_personal_message_send");
                honeyClientEvent.c = "social_good";
                analyticsLogger.a(honeyClientEvent.b("fundraiser_campaign_id", str));
            } else {
                analyticsLogger = this.f12701d;
                str = this.f12704g;
                honeyClientEvent = new HoneyClientEvent("fundraiser_page_personal_message_failure");
                honeyClientEvent.c = "social_good";
                analyticsLogger.a(honeyClientEvent.b("fundraiser_campaign_id", str));
            }
            o().finish();
        }
    }

    private void m13200a(SendAsMessageUtil sendAsMessageUtil, ExecutorService executorService, GraphQLQueryExecutor graphQLQueryExecutor, AnalyticsLogger analyticsLogger, com.facebook.inject.Lazy<FbErrorReporter> lazy) {
        this.f12698a = sendAsMessageUtil;
        this.f12699b = executorService;
        this.f12700c = graphQLQueryExecutor;
        this.f12701d = analyticsLogger;
        this.f12702e = lazy;
    }

    public final String aq() {
        return this.s.getString("extra_fundraiser_subtitle");
    }

    public final String ar() {
        return this.s.getString("extra_fundraiser_progress_text");
    }

    public final String m13207e() {
        return this.s.getString("owner_profile_picture_url");
    }
}
