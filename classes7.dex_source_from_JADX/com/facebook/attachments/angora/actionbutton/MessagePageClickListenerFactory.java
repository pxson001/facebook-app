package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil;
import com.facebook.messaging.util.MessengerAppUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: user_scrolled */
public class MessagePageClickListenerFactory {
    private static MessagePageClickListenerFactory f856i;
    private static final Object f857j = new Object();
    public final Provider<ViewerContext> f858a;
    public final Toaster f859b;
    private final AnalyticsLogger f860c;
    private final NewsFeedAnalyticsEventBuilder f861d;
    private final Context f862e;
    private final IFeedIntentBuilder f863f;
    private final SendAsMessageUtil f864g;
    private final MessengerAppUtils f865h;

    /* compiled from: user_scrolled */
    public class MessagePageClickListener implements OnClickListener {
        final /* synthetic */ MessagePageClickListenerFactory f854a;
        private final FeedProps<GraphQLStoryAttachment> f855b;

        public MessagePageClickListener(MessagePageClickListenerFactory messagePageClickListenerFactory, FeedProps<GraphQLStoryAttachment> feedProps) {
            this.f854a = messagePageClickListenerFactory;
            this.f855b = feedProps;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2061276036);
            FeedProps e = AttachmentProps.e(this.f855b);
            ViewerContext viewerContext = (ViewerContext) this.f854a.f858a.get();
            if (viewerContext.mIsPageContext) {
                GraphQLActor b = StoryActorHelper.b((GraphQLStory) e.a);
                if (viewerContext.mUserId.equals(b == null ? null : b.H())) {
                    this.f854a.f859b.b(new ToastBuilder(2131233635));
                } else {
                    this.f854a.f859b.b(new ToastBuilder(2131233636));
                }
                LogUtils.a(467971687, a);
                return;
            }
            MessagePageClickListenerFactory.m858b(this.f854a, e);
            Logger.a(2, EntryType.UI_INPUT_END, 1564579266, a);
        }
    }

    private static MessagePageClickListenerFactory m857b(InjectorLike injectorLike) {
        return new MessagePageClickListenerFactory(IdBasedProvider.a(injectorLike, 372), Toaster.b(injectorLike), SendAsMessageUtil.m9486a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), (Context) injectorLike.getInstance(Context.class), NewsFeedAnalyticsEventBuilder.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), MessengerAppUtils.a(injectorLike));
    }

    @Inject
    public MessagePageClickListenerFactory(Provider<ViewerContext> provider, Toaster toaster, SendAsMessageUtil sendAsMessageUtil, IFeedIntentBuilder iFeedIntentBuilder, Context context, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, MessengerAppUtils messengerAppUtils) {
        this.f858a = provider;
        this.f859b = toaster;
        this.f864g = sendAsMessageUtil;
        this.f863f = iFeedIntentBuilder;
        this.f862e = context;
        this.f861d = newsFeedAnalyticsEventBuilder;
        this.f860c = analyticsLogger;
        this.f865h = messengerAppUtils;
    }

    public static MessagePageClickListenerFactory m856a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MessagePageClickListenerFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f857j) {
                MessagePageClickListenerFactory messagePageClickListenerFactory;
                if (a2 != null) {
                    messagePageClickListenerFactory = (MessagePageClickListenerFactory) a2.a(f857j);
                } else {
                    messagePageClickListenerFactory = f856i;
                }
                if (messagePageClickListenerFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m857b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f857j, b3);
                        } else {
                            f856i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = messagePageClickListenerFactory;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final MessagePageClickListener m859a(FeedProps<GraphQLStoryAttachment> feedProps) {
        return new MessagePageClickListener(this, feedProps);
    }

    public static void m858b(MessagePageClickListenerFactory messagePageClickListenerFactory, FeedProps feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        GraphQLActor b = StoryActorHelper.b(graphQLStory);
        if (b != null) {
            String str;
            String H = b.H();
            if (graphQLStory.l() == null) {
                str = null;
            } else {
                str = graphQLStory.l().j();
            }
            String a = GraphQLActorUtil.a(b);
            if (H != null && str != null) {
                HoneyAnalyticsEvent honeyAnalyticsEvent;
                boolean a2 = MessagePageActionButton.m850a(messagePageClickListenerFactory.f865h);
                if (a2) {
                    messagePageClickListenerFactory.f864g.m9497a(feedProps, messagePageClickListenerFactory.f862e, a, Long.parseLong(H), str, "page");
                } else {
                    messagePageClickListenerFactory.f863f.a(messagePageClickListenerFactory.f862e, StringFormatUtil.formatStrLocaleSafe(FBLinks.aG, graphQLStory.l().j()));
                }
                ArrayNode a3 = TrackableFeedProps.a(feedProps);
                if (a3 == null || a3.e() == 0) {
                    honeyAnalyticsEvent = null;
                } else {
                    HoneyClientEvent b2 = new HoneyClientEvent("message_cta_click").a("tracking", a3).b("redirect_type", a2 ? "messenger" : "mtouch").b("page_id", H).b("post_id", str);
                    b2.c = "native_newsfeed";
                    honeyAnalyticsEvent = b2;
                }
                messagePageClickListenerFactory.f860c.c(honeyAnalyticsEvent);
            }
        }
    }
}
