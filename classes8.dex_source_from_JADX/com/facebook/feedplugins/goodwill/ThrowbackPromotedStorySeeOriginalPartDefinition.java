package com.facebook.feedplugins.goodwill;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feed.ui.FeedStoryPermalinkOnClickListenerProvider;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger$Events;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

/* compiled from: goodfriends_placeholder_shown */
public class ThrowbackPromotedStorySeeOriginalPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment, SegmentedLinearLayout> {
    public static final ViewType f12505a = ViewType.a(2130907420);
    private static final PaddingStyle f12506b;
    private final BackgroundPartDefinition f12507c;
    public final FeedStoryPermalinkOnClickListenerProvider f12508d;
    private final ClickListenerPartDefinition f12509e;
    private final TextPartDefinition f12510f;
    public final GoodwillAnalyticsLogger f12511g;
    public final String f12512h;

    public final Object m14390a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(2131558927, this.f12510f, StoryActionLinkHelper.a((GraphQLStory) feedProps.a, -2102769345).aB());
        subParts.a(this.f12507c, new StylingData(feedProps, f12506b));
        final FeedProps feedProps2 = feedProps.b;
        subParts.a(this.f12509e, new OnClickListener(this) {
            final /* synthetic */ ThrowbackPromotedStorySeeOriginalPartDefinition f12504b;

            public void onClick(View view) {
                String str;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 925462954);
                GoodwillAnalyticsLogger goodwillAnalyticsLogger = this.f12504b.f12511g;
                String str2 = this.f12504b.f12512h;
                String str3 = this.f12504b.f12512h;
                Object obj = -1;
                switch (str3.hashCode()) {
                    case 538789955:
                        if (str3.equals("reshare_status_update")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 1468166591:
                        if (str3.equals("reshare_photo")) {
                            obj = 1;
                            break;
                        }
                        break;
                    case 1473726472:
                        if (str3.equals("reshare_video")) {
                            obj = 2;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        str = "reshare_status_update";
                        break;
                    case 1:
                        str = "reshare_photo";
                        break;
                    case 2:
                        str = "reshare_video";
                        break;
                    default:
                        str = null;
                        break;
                }
                String str4 = str;
                str3 = ((GraphQLStory) feedProps2.a).l().j();
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent(GoodwillAnalyticsLogger$Events.GOODWILL_THROWBACK_RESHARE_PROMOTION_SEE_ORIGINAL_POST.name);
                honeyClientEvent.c = "goodwill";
                goodwillAnalyticsLogger.a.a(honeyClientEvent.b("render_style", str2).b("story_type", str4).b("story_id", str3));
                this.f12504b.f12508d.a(feedProps2).onClick(view);
                Logger.a(2, EntryType.UI_INPUT_END, 761447062, a);
            }
        });
        return null;
    }

    public final boolean m14391a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        FeedProps feedProps2 = feedProps.b;
        if (feedProps2 == null || feedProps2.a == null) {
            return false;
        }
        GraphQLStoryActionLink a = StoryActionLinkHelper.a((GraphQLStory) feedProps.a, -2102769345);
        return (a == null || TextUtils.isEmpty(a.aB())) ? false : true;
    }

    static {
        Builder a = Builder.a();
        a.c = -8.0f;
        f12506b = a.i();
    }

    @Inject
    public ThrowbackPromotedStorySeeOriginalPartDefinition(BackgroundPartDefinition backgroundPartDefinition, FeedStoryPermalinkOnClickListenerProvider feedStoryPermalinkOnClickListenerProvider, ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition, GoodwillAnalyticsLogger goodwillAnalyticsLogger, @Assisted String str) {
        this.f12507c = backgroundPartDefinition;
        this.f12508d = feedStoryPermalinkOnClickListenerProvider;
        this.f12509e = clickListenerPartDefinition;
        this.f12510f = textPartDefinition;
        this.f12511g = goodwillAnalyticsLogger;
        this.f12512h = str;
    }

    public final ViewType m14389a() {
        return f12505a;
    }
}
