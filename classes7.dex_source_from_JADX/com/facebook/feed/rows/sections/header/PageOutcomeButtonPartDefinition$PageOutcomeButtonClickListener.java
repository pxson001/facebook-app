package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLPageCallToActionRef;
import com.facebook.graphql.model.GraphQLPageOutcomeButton;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: Unsaving something that isn't a Story or SavedCollectionFeedUnit. Item not unsaved. */
public class PageOutcomeButtonPartDefinition$PageOutcomeButtonClickListener implements OnClickListener {
    final /* synthetic */ PageOutcomeButtonPartDefinition f21168a;
    public final FeedProps<GraphQLStory> f21169b;
    public final Lazy<SecureContextHelper> f21170c;
    public final Lazy<UriIntentMapper> f21171d;
    public final Lazy<FbErrorReporter> f21172e;
    public final Lazy<AnalyticsLogger> f21173f;

    public PageOutcomeButtonPartDefinition$PageOutcomeButtonClickListener(PageOutcomeButtonPartDefinition pageOutcomeButtonPartDefinition, FeedProps<GraphQLStory> feedProps, Lazy<SecureContextHelper> lazy, Lazy<UriIntentMapper> lazy2, Lazy<FbErrorReporter> lazy3, Lazy<AnalyticsLogger> lazy4) {
        this.f21168a = pageOutcomeButtonPartDefinition;
        this.f21169b = feedProps;
        this.f21170c = lazy;
        this.f21171d = lazy2;
        this.f21172e = lazy3;
        this.f21173f = lazy4;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1273314064);
        GraphQLStoryActionLink c = StoryActionLinkHelper.c((GraphQLStory) this.f21169b.a);
        if (!StoryActorHelper.a((GraphQLStory) this.f21169b.a) || c == null || c.a() == null || c.a().g() != 1850349541) {
            Logger.a(2, EntryType.UI_INPUT_END, -228950405, a);
            return;
        }
        GraphQLPageOutcomeButton aG = c.aG();
        if (aG == null || aG.k() == null) {
            LogUtils.a(-1849214867, a);
            return;
        }
        Context context;
        Intent intent;
        switch (PageOutcomeButtonPartDefinition$1.f21167a[aG.k().ordinal()]) {
            case 1:
                context = view.getContext();
                if (aG.l() != null) {
                    intent = new Intent("android.intent.action.DIAL");
                    intent.setData(Uri.parse(aG.l()));
                    ((SecureContextHelper) this.f21170c.get()).b(intent, context);
                }
                break;
            case 2:
                context = view.getContext();
                ((SecureContextHelper) this.f21170c.get()).b(((UriIntentMapper) this.f21171d.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.R, StoryActorHelper.b((GraphQLStory) this.f21169b.a).H())), context);
                break;
            case 3:
                context = view.getContext();
                if (aG.l() != null) {
                    intent = new Intent("android.intent.action.SEND");
                    intent.setData(Uri.parse(aG.l()));
                    ((SecureContextHelper) this.f21170c.get()).b(intent, context);
                }
                break;
            default:
                context = view.getContext();
                if (aG.l() != null) {
                    String l = aG.l();
                    if (!StringUtil.a(l)) {
                        Intent a2 = ((UriIntentMapper) this.f21171d.get()).a(context, l);
                        if (a2 != null) {
                            if (!FacebookUriUtil.a(Uri.parse(l))) {
                                ((SecureContextHelper) this.f21170c.get()).a(a2, context);
                                break;
                            } else {
                                ((SecureContextHelper) this.f21170c.get()).b(a2, context);
                                break;
                            }
                        }
                        a2 = new Intent("android.intent.action.VIEW");
                        a2.setData(Uri.parse(l));
                        ((SecureContextHelper) this.f21170c.get()).b(a2, context);
                        break;
                    }
                    ((AbstractFbErrorReporter) this.f21172e.get()).a(PageOutcomeButtonPartDefinition$PageOutcomeButtonClickListener.class.getSimpleName(), "No valid actions for Page Outcomes button: " + aG.k());
                    break;
                }
                break;
        }
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("tapped_call_to_action");
        honeyClientEvent.c = "pages_public_view";
        ((AnalyticsLogger) this.f21173f.get()).c(honeyClientEvent.b("page_id", StoryActorHelper.b((GraphQLStory) this.f21169b.a).H()).b("event_type", aG.k().name()).b("ccta_type", aG.k().name()).a("ccta_ref", GraphQLPageCallToActionRef.FEED_STORY).b("story_id", ((GraphQLStory) this.f21169b.a).c()));
        LogUtils.a(-234056948, a);
    }
}
