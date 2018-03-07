package com.facebook.tablet.sideshow.ads.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.renderer.spannable.NativeThirdPartyUriClickHandler;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tablet.sideshow.ads.model.AppAdsSideshowRow;
import com.facebook.tablet.sideshow.ads.model.AppAdsSideshowSecondaryAction;
import com.facebook.tablet.sideshow.ads.model.AppAdsSideshowSecondaryAction.SecondaryActionType;
import com.facebook.tablet.sideshow.analytics.SideshowAnalyticsLogger;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.CustomLinearLayout;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.Map;
import javax.inject.Provider;

/* compiled from: onShow */
public class AppAdsSideshowRowView extends CustomLinearLayout {
    public static final CallerContext f4679a = CallerContext.a(AppAdsSideshowRowView.class, "sideshow");
    public AppAdsSideshowRow f4680b;
    public final FbDraweeControllerBuilder f4681c;
    public final AnalyticsLogger f4682d;
    public final FbUriIntentHandler f4683e;
    public final NewsFeedAnalyticsEventBuilder f4684f;
    public final SideshowAnalyticsLogger f4685g;
    public final NativeThirdPartyUriClickHandler f4686h;
    private final SideshowExpandableListView f4687i;
    public final AdsSideshowListAdapter f4688j;
    public final Context f4689k;
    public final TextView f4690l = ((TextView) a(2131559642));
    public final FbDraweeView f4691m = ((FbDraweeView) a(2131559641));
    public final TextView f4692n = ((TextView) a(2131559622));
    public final TextView f4693o = ((TextView) a(2131559643));
    public final ImageView f4694p = ((ImageView) a(2131559640));
    public final PopoverMenuWindow f4695q;

    /* compiled from: onShow */
    class C06351 implements OnClickListener {
        final /* synthetic */ AppAdsSideshowRowView f4675a;

        C06351(AppAdsSideshowRowView appAdsSideshowRowView) {
            this.f4675a = appAdsSideshowRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 28067909);
            this.f4675a.f4695q.f(this.f4675a.f4694p);
            Logger.a(2, EntryType.UI_INPUT_END, -1737458742, a);
        }
    }

    /* compiled from: onShow */
    public class C06362 implements OnClickListener {
        final /* synthetic */ AppAdsSideshowRowView f4676a;

        public C06362(AppAdsSideshowRowView appAdsSideshowRowView) {
            this.f4676a = appAdsSideshowRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1744821416);
            AppAdsSideshowRowView appAdsSideshowRowView = this.f4676a;
            appAdsSideshowRowView.f4685g.b("sideshow_ads");
            ArrayNode a2 = TrackableFeedProps.a(appAdsSideshowRowView.f4680b.f4652a);
            Map d = NewsFeedAnalyticsEventBuilder.d(((GraphQLStory) appAdsSideshowRowView.f4680b.f4652a.a).u(), a2);
            d.put("tn", a2);
            d.put("cta_click", Boolean.TRUE);
            appAdsSideshowRowView.f4693o.setTag(2131558534, d);
            appAdsSideshowRowView.f4686h.a(appAdsSideshowRowView.f4680b.f4659h, appAdsSideshowRowView.f4693o, null);
            Logger.a(2, EntryType.UI_INPUT_END, 1696694380, a);
        }
    }

    /* compiled from: onShow */
    public class C06373 implements OnMenuItemClickListener {
        final /* synthetic */ AppAdsSideshowRowView f4677a;

        public C06373(AppAdsSideshowRowView appAdsSideshowRowView) {
            this.f4677a = appAdsSideshowRowView;
        }

        public final boolean m5864a(MenuItem menuItem) {
            switch (SecondaryActionType.values()[menuItem.getItemId()]) {
                case LEARN_MORE:
                    this.f4677a.m5866b();
                    break;
                case HIDE:
                case HIDE_AD:
                case HIDE_ADVERTISER:
                    AppAdsSideshowRowView appAdsSideshowRowView = this.f4677a;
                    FeedProps feedProps = this.f4677a.f4680b.f4652a;
                    GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent("ad_nfb");
                    honeyClientEvent.b("hideable_token", graphQLStory.y());
                    honeyClientEvent.a("tracking", TrackableFeedProps.a(feedProps));
                    if (graphQLStory.ay() != null) {
                        honeyClientEvent.b("client_token", graphQLStory.ay().l());
                    }
                    honeyClientEvent.b("objectID", appAdsSideshowRowView.f4680b.f4659h);
                    honeyClientEvent.b("objectType", "url");
                    honeyClientEvent.b(graphQLStory.u());
                    appAdsSideshowRowView.f4682d.a(honeyClientEvent);
                    AdsSideshowListAdapter adsSideshowListAdapter = this.f4677a.f4688j;
                    adsSideshowListAdapter.f4667b.m5856a(this.f4677a.f4680b);
                    AdapterDetour.a(adsSideshowListAdapter, -1070998140);
                    break;
                case SHOW_AD_PREFERENCES:
                    this.f4677a.f4683e.a(this.f4677a.f4689k, StringLocaleUtil.a(FBLinks.dB, new Object[]{TrackableFeedProps.a(this.f4677a.f4680b.f4652a).toString()}));
                    break;
                case ADS_PREFERENCES_FEEDBACK_USEFUL:
                    NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f4677a.f4684f;
                    ArrayNode a = TrackableFeedProps.a(this.f4677a.f4680b.f4652a);
                    AppAdsSideshowRow appAdsSideshowRow = this.f4677a.f4680b;
                    appAdsSideshowRow.f4660i = Boolean.valueOf(!appAdsSideshowRow.f4660i.booleanValue());
                    this.f4677a.f4682d.a(NewsFeedAnalyticsEventBuilder.a(a, appAdsSideshowRow.f4660i.booleanValue()));
                    if (!this.f4677a.f4680b.f4660i.booleanValue()) {
                        menuItem.setTitle(this.f4677a.f4689k.getString(2131233631));
                        break;
                    }
                    menuItem.setTitle(this.f4677a.f4689k.getString(2131233633));
                    break;
            }
            return true;
        }
    }

    public AppAdsSideshowRowView(Context context, Provider<FbDraweeControllerBuilder> provider, AnalyticsLogger analyticsLogger, FbUriIntentHandler fbUriIntentHandler, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, SideshowAnalyticsLogger sideshowAnalyticsLogger, NativeThirdPartyUriClickHandler nativeThirdPartyUriClickHandler, SideshowExpandableListView sideshowExpandableListView, AdsSideshowListAdapter adsSideshowListAdapter) {
        super(context, null);
        setContentView(2130903272);
        this.f4689k = context;
        this.f4681c = (FbDraweeControllerBuilder) provider.get();
        this.f4682d = analyticsLogger;
        this.f4683e = fbUriIntentHandler;
        this.f4684f = newsFeedAnalyticsEventBuilder;
        this.f4685g = sideshowAnalyticsLogger;
        this.f4686h = nativeThirdPartyUriClickHandler;
        this.f4687i = sideshowExpandableListView;
        this.f4688j = adsSideshowListAdapter;
        this.f4695q = new PopoverMenuWindow(context);
        this.f4694p.setOnClickListener(new C06351(this));
    }

    public final void m5865a(AppAdsSideshowRow appAdsSideshowRow) {
        this.f4680b = appAdsSideshowRow;
        if (this.f4680b == null) {
            setVisibility(8);
            return;
        }
        CharSequence string;
        if (this.f4680b.f4653b != null) {
            GenericDraweeHierarchyBuilder e = new GenericDraweeHierarchyBuilder(getContext().getResources()).e(ScaleType.c);
            e.u = new RoundingParams().a(2131363883, 1.0f);
            this.f4691m.setHierarchy(e.u());
            this.f4691m.setController(this.f4681c.b(this.f4680b.f4653b).a(f4679a).s());
        }
        if (this.f4680b.f4654c != null) {
            this.f4692n.setText(this.f4680b.f4654c);
        }
        if (this.f4680b.f4657f != null) {
            this.f4690l.setText(this.f4680b.f4657f);
        }
        if (this.f4680b.f4658g != null) {
            this.f4693o.setText(this.f4680b.f4658g);
        } else {
            this.f4693o.setText(this.f4689k.getString(2131241701));
        }
        this.f4693o.setOnClickListener(new C06362(this));
        this.f4695q.c().clear();
        this.f4695q.c().a(SecondaryActionType.LEARN_MORE.ordinal(), 0, this.f4689k.getString(2131241702)).setIcon(2130839943);
        AppAdsSideshowSecondaryAction appAdsSideshowSecondaryAction = (AppAdsSideshowSecondaryAction) this.f4680b.f4661j.get(SecondaryActionType.HIDE);
        if (!(appAdsSideshowSecondaryAction == null || appAdsSideshowSecondaryAction.f4664c == null)) {
            this.f4695q.c().a(appAdsSideshowSecondaryAction.f4662a, 0, appAdsSideshowSecondaryAction.f4664c).setIcon(2130839920);
        }
        this.f4695q.c().a(SecondaryActionType.SHOW_AD_PREFERENCES.ordinal(), 0, this.f4689k.getString(2131233630)).setIcon(2130839943);
        if (this.f4680b.f4660i.booleanValue()) {
            string = this.f4689k.getString(2131233633);
        } else {
            string = this.f4689k.getString(2131233631);
        }
        this.f4695q.c().a(SecondaryActionType.ADS_PREFERENCES_FEEDBACK_USEFUL.ordinal(), 0, string).setIcon(2130839774);
        this.f4695q.p = new C06373(this);
    }

    public final void m5866b() {
        this.f4685g.b("sideshow_ads");
        this.f4686h.a(this.f4680b.f4659h, this.f4687i, TrackableFeedProps.a(this.f4680b.f4652a));
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.f4695q != null && configuration.orientation == 1) {
            this.f4695q.l();
        }
    }
}
