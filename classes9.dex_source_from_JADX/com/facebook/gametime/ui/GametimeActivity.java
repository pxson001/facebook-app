package com.facebook.gametime.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator.OnTabClickListener;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQL;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQL.GametimeMatchHeaderQueryString;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQL.GametimeMatchHeaderUpdateSubscriptionString;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimeMatchHeaderQueryModel;
import com.facebook.gametime.ui.GametimePagerAdapter.TabInfo;
import com.facebook.gametime.ui.reaction.GametimeReactionUtil.LoadType;
import com.facebook.graphql.calls.GametimeMatchDataUpdateSubscribeInputData;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionConnectorException;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UriMatchPatterns
/* compiled from: TDCU 1ZZ */
public class GametimeActivity extends FbFragmentActivity {
    private TabbedViewPagerIndicator f25066A;
    private ViewPager f25067B;
    @Inject
    GraphQLSubscriptionConnector f25068p;
    @Inject
    RTLUtil f25069q;
    @Inject
    GraphQLSubscriptionHolder f25070r;
    @Inject
    TasksManager f25071s;
    @Inject
    ComposerPublishServiceHelper f25072t;
    @Inject
    AnalyticsLogger f25073u;
    private GraphQLSubscriptionHandle f25074v;
    public GametimeHeaderView f25075w;
    private String f25076x;
    private GametimePagerAdapter f25077y;
    public List<TabInfo> f25078z;

    /* compiled from: TDCU 1ZZ */
    class C30051 implements OnTabClickListener {
        final /* synthetic */ GametimeActivity f25063a;

        C30051(GametimeActivity gametimeActivity) {
            this.f25063a = gametimeActivity;
        }

        public final void m27060a(int i, int i2) {
            if (i != i2) {
                this.f25063a.m27066a(((TabInfo) this.f25063a.f25078z.get(i)).f25088b);
            }
        }
    }

    /* compiled from: TDCU 1ZZ */
    class C30062 extends AbstractDisposableFutureCallback<GraphQLResult<GametimeMatchHeaderQueryModel>> {
        final /* synthetic */ GametimeActivity f25064a;

        C30062(GametimeActivity gametimeActivity) {
            this.f25064a = gametimeActivity;
        }

        protected final void m27061a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e != null && ((GametimeMatchHeaderQueryModel) graphQLResult.e).m26931j() != null) {
                this.f25064a.f25075w.setMatchData(((GametimeMatchHeaderQueryModel) graphQLResult.e).m26931j());
            }
        }

        protected final void m27062a(Throwable th) {
        }
    }

    /* compiled from: TDCU 1ZZ */
    class C30073 implements OnClickListener {
        final /* synthetic */ GametimeActivity f25065a;

        C30073(GametimeActivity gametimeActivity) {
            this.f25065a = gametimeActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1479374515);
            this.f25065a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -1331729481, a);
        }
    }

    private static <T extends Context> void m27068a(Class<T> cls, T t) {
        m27069a((Object) t, (Context) t);
    }

    public static void m27069a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GametimeActivity) obj).m27067a(GraphQLSubscriptionConnector.a(fbInjector), RTLUtil.a(fbInjector), GraphQLSubscriptionHolder.b(fbInjector), TasksManager.b(fbInjector), ComposerPublishServiceHelper.b(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector));
    }

    private void m27067a(GraphQLSubscriptionConnector graphQLSubscriptionConnector, RTLUtil rTLUtil, GraphQLSubscriptionHolder graphQLSubscriptionHolder, TasksManager tasksManager, ComposerPublishServiceHelper composerPublishServiceHelper, AnalyticsLogger analyticsLogger) {
        this.f25068p = graphQLSubscriptionConnector;
        this.f25069q = rTLUtil;
        this.f25070r = graphQLSubscriptionHolder;
        this.f25071s = tasksManager;
        this.f25072t = composerPublishServiceHelper;
        this.f25073u = analyticsLogger;
    }

    public final void m27075b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = GametimeActivity.class;
        m27069a((Object) this, (Context) this);
        m27073k();
        setContentView(2130904574);
        this.f25076x = getIntent().getExtras().getString("page_id") == null ? "-1" : getIntent().getExtras().getString("page_id");
        this.f25077y = new GametimePagerAdapter(this.f25076x, this.f25078z, kO_());
        this.f25067B = (ViewPager) a(2131562491);
        this.f25067B.setAdapter(this.f25077y);
        this.f25066A = (TabbedViewPagerIndicator) a(2131562490);
        this.f25066A.setViewPager(this.f25067B);
        this.f25066A.m = new C30051(this);
        this.f25075w = (GametimeHeaderView) a(2131562489);
        m27064a((ImageView) a(2131562492));
        m27071i();
        m27072j();
        m27074l();
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1746766882);
        super.onPause();
        this.f25070r.d();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1569866830, a);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -397146488);
        super.onResume();
        this.f25070r.e();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1948255755, a);
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1253592254);
        super.onStop();
        this.f25071s.c("task_header_fetch");
        if (this.f25074v != null) {
            this.f25068p.a(Collections.singleton(this.f25074v));
            this.f25074v = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1314277807, a);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1324253737);
        super.onDestroy();
        this.f25070r.a();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -875156090, a);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1756:
                case 1758:
                    this.f25072t.c(intent);
                    return;
                default:
                    super.onActivityResult(i, i2, intent);
                    return;
            }
        }
    }

    private void m27072j() {
        GametimeMatchHeaderUpdateSubscriptionString f = GametimeFragmentsGraphQL.m26789f();
        f.a("input", new GametimeMatchDataUpdateSubscribeInputData().a(this.f25076x));
        try {
            this.f25074v = this.f25068p.a(f);
        } catch (GraphQLSubscriptionConnectorException e) {
        }
    }

    private void m27064a(ImageView imageView) {
        imageView.setOnClickListener(new C30073(this));
        imageView.setImageDrawable(this.f25069q.a(2130838002));
    }

    private void m27073k() {
        this.f25078z = new ArrayList();
        this.f25078z.add(new TabInfo(LoadType.TAIL_LOAD, Surface.ANDROID_GAMETIME_MATCHUP_TAB, getString(2131241432)));
        this.f25078z.add(new TabInfo(LoadType.TAIL_LOAD, Surface.ANDROID_GAMETIME_FRIEND_STORIES, getString(2131241431)));
        this.f25078z.add(new TabInfo(LoadType.TAIL_LOAD, Surface.ANDROID_GAMETIME_EXPERT_STORIES, getString(2131241429)));
        this.f25078z.add(new TabInfo(LoadType.TAIL_LOAD, Surface.ANDROID_GAMETIME_MATCH_STATS, getString(2131241434)));
    }

    private void m27074l() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("gametime_match_entry");
        honeyClientEvent.b("page_id", this.f25076x);
        if (getIntent().getExtras().containsKey("gametime_ref")) {
            honeyClientEvent.a("referral", getIntent().getExtras().getSerializable("gametime_ref"));
        }
        this.f25073u.a(honeyClientEvent);
    }

    private void m27066a(Surface surface) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("gametime_match_tab_switch");
        honeyClientEvent.b("page_id", this.f25076x);
        honeyClientEvent.a("reaction_surface", surface);
        this.f25073u.a(honeyClientEvent);
    }

    private void m27071i() {
        GraphQlQueryString gametimeMatchHeaderQueryString = new GametimeMatchHeaderQueryString();
        gametimeMatchHeaderQueryString.a("page_id", this.f25076x);
        GraphQLRequest a = GraphQLRequest.a(gametimeMatchHeaderQueryString);
        a.b = true;
        a = a.a(GraphQLCachePolicy.d);
        C30062 c30062 = new C30062(this);
        this.f25071s.a("task_header_fetch", this.f25070r.a(a, c30062, "gametime_header_" + this.f25076x), c30062);
    }
}
