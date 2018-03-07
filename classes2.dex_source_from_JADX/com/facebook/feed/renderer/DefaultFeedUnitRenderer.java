package com.facebook.feed.renderer;

import android.content.Context;
import android.os.Bundle;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams.Builder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.directinstall.util.DirectInstallApplicationUtils;
import com.facebook.events.common.ActionSource;
import com.facebook.feed.analytics.LongClickTracker;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.renderer.spannable.NativeThirdPartyUriClickHandler;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.util.event.FeedEvent;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents$OutboundClickedEvent;
import com.facebook.feedback.ui.FeedbackPopoverLauncher;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.linkutil.LinkExtractorConverter;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ufiservices.util.LinkifyUtil.ClickableEntitySpanWithCallback;
import com.facebook.ufiservices.util.LinkifyUtil.ExternalClickableSpan;
import com.facebook.ufiservices.util.MessageSpannableBuilder;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: is_verified */
public class DefaultFeedUnitRenderer {
    public static final String f18752a = DefaultFeedUnitRenderer.class.getSimpleName();
    private static DefaultFeedUnitRenderer f18753u;
    private static final Object f18754v = new Object();
    public final Context f18755b;
    private final IFeedIntentBuilder f18756c;
    public final AnalyticsLogger f18757d;
    public final NavigationLogger f18758e;
    public final GraphQLLinkExtractor f18759f;
    public final NewsFeedAnalyticsEventBuilder f18760g;
    private final CommonEventsBuilder f18761h;
    public final LongClickTracker f18762i;
    public final FeedEventBus f18763j;
    public final Toaster f18764k;
    public final AbstractFbErrorReporter f18765l;
    public final FeedbackPopoverLauncher f18766m;
    public final Lazy<NativeThirdPartyUriClickHandler> f18767n;
    private final MessageSpannableBuilder f18768o;
    public final C07451 f18769p = new C07451(this);
    public final C07473 f18770q = new C07473(this);
    private final OnClickListener f18771r = new C07462(this);
    private final OnClickListener f18772s = new C07484(this);
    private final OnClickListener f18773t = new C07495(this);

    /* compiled from: is_verified */
    public class C07451 {
        final /* synthetic */ DefaultFeedUnitRenderer f18888a;

        C07451(DefaultFeedUnitRenderer defaultFeedUnitRenderer) {
            this.f18888a = defaultFeedUnitRenderer;
        }

        public final void m26568a(ExternalClickableSpan externalClickableSpan) {
            this.f18888a.f18762i.m14090a(externalClickableSpan.f21827e, externalClickableSpan.f21825c);
            if (!StringUtil.m3589a((CharSequence) externalClickableSpan.f)) {
                this.f18888a.f18763j.mo651a(new StoryEvents$OutboundClickedEvent(externalClickableSpan.f, externalClickableSpan.g));
            }
        }
    }

    /* compiled from: is_verified */
    class C07462 implements OnClickListener {
        final /* synthetic */ DefaultFeedUnitRenderer f18889a;

        C07462(DefaultFeedUnitRenderer defaultFeedUnitRenderer) {
            this.f18889a = defaultFeedUnitRenderer;
        }

        public void onClick(View view) {
            boolean booleanValue;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -882414040);
            HoneyClientEvent honeyClientEvent = (HoneyClientEvent) view.getTag(2131558518);
            if (!TrackingNodes.m27144a(honeyClientEvent)) {
                TrackingNodes.m27142a(honeyClientEvent, view);
            }
            this.f18889a.f18757d.mo528a(honeyClientEvent);
            this.f18889a.f18758e.m5498a((String) view.getTag(2131558524));
            boolean booleanValue2 = view.getTag(2131558521) != null ? ((Boolean) view.getTag(2131558521)).booleanValue() : false;
            if (view.getTag(2131558522) != null) {
                booleanValue = ((Boolean) view.getTag(2131558522)).booleanValue();
            } else {
                booleanValue = false;
            }
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) view.getTag(2131558520);
            FeedbackLoggingParams feedbackLoggingParams = (FeedbackLoggingParams) view.getTag(2131558523);
            if (feedbackLoggingParams.f22391c == null) {
                String am_;
                Builder builder = new Builder();
                Builder a2 = Builder.m30316a(feedbackLoggingParams);
                DefaultFeedUnitRenderer defaultFeedUnitRenderer = this.f18889a;
                if (defaultFeedUnitRenderer.f18755b instanceof AnalyticsActivity) {
                    am_ = ((AnalyticsActivity) defaultFeedUnitRenderer.f18755b).am_();
                    if (am_ == null) {
                        am_ = "unknown";
                    }
                } else {
                    am_ = "unknown";
                }
                a2.f22399c = am_;
                feedbackLoggingParams = a2.m30319a();
            }
            FeedbackParams.Builder builder2 = new FeedbackParams.Builder();
            builder2.a = graphQLFeedback;
            builder2 = builder2;
            builder2.d = graphQLFeedback.z_();
            builder2 = builder2;
            builder2.e = graphQLFeedback.mo2933j();
            FeedbackParams.Builder builder3 = builder2;
            builder3.g = feedbackLoggingParams;
            builder3 = builder3;
            builder3.i = booleanValue2;
            builder3 = builder3;
            builder3.j = booleanValue;
            this.f18889a.f18766m.m26455a(this.f18889a.f18755b, builder3.a());
            FbEvent fbEvent = (FeedEvent) view.getTag(2131558515);
            if (fbEvent != null) {
                this.f18889a.f18763j.mo651a(fbEvent);
            }
            LogUtils.a(1717115642, a);
        }
    }

    /* compiled from: is_verified */
    public class C07473 {
        final /* synthetic */ DefaultFeedUnitRenderer f18890a;

        C07473(DefaultFeedUnitRenderer defaultFeedUnitRenderer) {
            this.f18890a = defaultFeedUnitRenderer;
        }

        public final void m26569a(ClickableEntitySpanWithCallback clickableEntitySpanWithCallback) {
            View view;
            NativeThirdPartyUriClickHandler nativeThirdPartyUriClickHandler = (NativeThirdPartyUriClickHandler) this.f18890a.f18767n.get();
            String str = clickableEntitySpanWithCallback.f21825c;
            if (clickableEntitySpanWithCallback.f21832j != null) {
                view = (View) clickableEntitySpanWithCallback.f21832j.get();
            } else {
                view = null;
            }
            nativeThirdPartyUriClickHandler.a(str, view, clickableEntitySpanWithCallback.f21827e);
        }
    }

    /* compiled from: is_verified */
    class C07484 implements OnClickListener {
        final /* synthetic */ DefaultFeedUnitRenderer f18891a;

        C07484(DefaultFeedUnitRenderer defaultFeedUnitRenderer) {
            this.f18891a = defaultFeedUnitRenderer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -358115003);
            try {
                ((NativeThirdPartyUriClickHandler) this.f18891a.f18767n.get()).a((String) view.getTag(2131558527), view, null);
            } catch (Throwable e) {
                this.f18891a.f18765l.mo336a(SoftError.a(DefaultFeedUnitRenderer.f18752a + "_DefaultFeedUnitRenderer.viewToUrlListener.onClick", "Couldn't launch external Activity for URI").a(e).g());
                this.f18891a.f18764k.m6456b(new ToastBuilder(2131233634));
            }
            LogUtils.a(-319235372, a);
        }
    }

    /* compiled from: is_verified */
    class C07495 implements OnClickListener {
        final /* synthetic */ DefaultFeedUnitRenderer f18892a;

        C07495(DefaultFeedUnitRenderer defaultFeedUnitRenderer) {
            this.f18892a = defaultFeedUnitRenderer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2144469189);
            this.f18892a.m26375a(view, (LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL) view.getTag(2131558516), (Bundle) view.getTag(2131558517));
            Logger.a(2, EntryType.UI_INPUT_END, 628596732, a);
        }
    }

    private static DefaultFeedUnitRenderer m26364b(InjectorLike injectorLike) {
        return new DefaultFeedUnitRenderer((Context) injectorLike.getInstance(Context.class), DefaultFeedIntentBuilder.m26214a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), GraphQLLinkExtractor.m26442a(injectorLike), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), CommonEventsBuilder.m14539b(injectorLike), LongClickTracker.m14087a(injectorLike), FeedEventBus.m4573a(injectorLike), Toaster.m6454b(injectorLike), NavigationLogger.m5475a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), FeedbackPopoverLauncher.m26450a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 5900), MessageSpannableBuilder.m26520a(injectorLike));
    }

    public static DefaultFeedUnitRenderer m26362a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultFeedUnitRenderer b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18754v) {
                DefaultFeedUnitRenderer defaultFeedUnitRenderer;
                if (a2 != null) {
                    defaultFeedUnitRenderer = (DefaultFeedUnitRenderer) a2.mo818a(f18754v);
                } else {
                    defaultFeedUnitRenderer = f18753u;
                }
                if (defaultFeedUnitRenderer == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26364b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18754v, b3);
                        } else {
                            f18753u = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultFeedUnitRenderer;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final CharSequence m26373a(FeedProps<GraphQLStory> feedProps, int i, boolean z) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        GraphQLTextWithEntities b = StoryHierarchyHelper.m27435b(graphQLStory);
        if (b == null) {
            this.f18765l.m2340a(DefaultFeedUnitRenderer.class.getSimpleName(), StringFormatUtil.formatStrLocaleSafe("Story has null message: %s", graphQLStory));
            return "";
        }
        CharSequence c = m26366c(feedProps, i, z);
        if (c != null) {
            return c;
        }
        String a = b.mo2911a();
        if (a != null) {
            return a;
        }
        this.f18765l.m2340a(DefaultFeedUnitRenderer.class.getSimpleName(), StringFormatUtil.formatStrLocaleSafe("Story has null message text: %s", graphQLStory));
        return "";
    }

    @Inject
    public DefaultFeedUnitRenderer(Context context, IFeedIntentBuilder iFeedIntentBuilder, AnalyticsLogger analyticsLogger, GraphQLLinkExtractor graphQLLinkExtractor, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, CommonEventsBuilder commonEventsBuilder, LongClickTracker longClickTracker, FeedEventBus feedEventBus, Toaster toaster, NavigationLogger navigationLogger, FbErrorReporter fbErrorReporter, FeedbackPopoverLauncher feedbackPopoverLauncher, Lazy<NativeThirdPartyUriClickHandler> lazy, MessageSpannableBuilder messageSpannableBuilder) {
        Preconditions.checkNotNull(context);
        this.f18755b = context;
        this.f18756c = iFeedIntentBuilder;
        this.f18757d = analyticsLogger;
        this.f18762i = longClickTracker;
        this.f18759f = graphQLLinkExtractor;
        this.f18760g = newsFeedAnalyticsEventBuilder;
        this.f18761h = commonEventsBuilder;
        this.f18763j = feedEventBus;
        this.f18764k = toaster;
        this.f18758e = navigationLogger;
        this.f18765l = fbErrorReporter;
        this.f18766m = feedbackPopoverLauncher;
        this.f18767n = lazy;
        this.f18768o = messageSpannableBuilder;
    }

    public final void m26375a(View view, LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL, Bundle bundle) {
        Preconditions.checkNotNull(linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL);
        String a = this.f18759f.m26445a(linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3202b(), linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3203d());
        if (a != null) {
            String b;
            HoneyClientEvent honeyClientEvent = (HoneyClientEvent) view.getTag(2131558518);
            if (!TrackingNodes.m27144a(honeyClientEvent)) {
                TrackingNodes.m27142a(honeyClientEvent, view);
            }
            this.f18757d.mo528a(honeyClientEvent);
            String str = (String) view.getTag(2131558524);
            this.f18758e.f3312w = (String) view.getTag(2131558525);
            if (honeyClientEvent != null && honeyClientEvent.f3106j) {
                this.f18758e.m5498a("tap_profile_pic_sponsored");
            } else if (str != null) {
                this.f18758e.m5498a(str);
            } else {
                this.f18758e.m5498a("tap_profile_pic");
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            int g = linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3202b().m22301g();
            String d = linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3203d();
            if (linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.ad_() != null) {
                b = linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.ad_().mo3198b();
            } else {
                b = null;
            }
            ModelBundle.a(bundle, g, d, b, linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.C_());
            this.f18756c.mo3017a(view.getContext(), a, bundle, null);
        }
    }

    public final CharSequence m26374a(FeedProps<GraphQLStory> feedProps, boolean z) {
        return m26373a((FeedProps) feedProps, 0, z);
    }

    @Nullable
    private CharSequence m26366c(FeedProps<GraphQLStory> feedProps, int i, boolean z) {
        CharSequence charSequence;
        if (!z || Strings.isNullOrEmpty(((GraphQLStory) feedProps.f13444a).mo2507g())) {
            charSequence = null;
        } else {
            charSequence = this.f18768o.m26527b(feedProps, i);
        }
        return m26363a((FeedProps) feedProps, charSequence, i);
    }

    @Nullable
    public final CharSequence m26376b(FeedProps<GraphQLStory> feedProps, int i, boolean z) {
        CharSequence charSequence;
        if (!z || Strings.isNullOrEmpty(((GraphQLStory) feedProps.f13444a).mo2507g())) {
            charSequence = null;
        } else {
            charSequence = this.f18768o.m26526b((FeedProps) feedProps);
        }
        return m26363a((FeedProps) feedProps, charSequence, i);
    }

    @Nullable
    private CharSequence m26363a(FeedProps<GraphQLStory> feedProps, @Nullable CharSequence charSequence, int i) {
        CharSequence a;
        if (charSequence == null) {
            a = this.f18768o.m26525a((FeedProps) feedProps, i);
        } else {
            a = charSequence;
        }
        if (a == null) {
            return null;
        }
        if (!(a instanceof Spannable)) {
            return a;
        }
        Spannable spannable = (Spannable) a;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        for (ClickableEntitySpanWithCallback clickableEntitySpanWithCallback : (ClickableEntitySpanWithCallback[]) spannable.getSpans(0, spannable.length(), ClickableEntitySpanWithCallback.class)) {
            if (NativeThirdPartyUriHelper.m29571a(clickableEntitySpanWithCallback.f21825c)) {
                C07473 c07473 = this.f18770q;
                clickableEntitySpanWithCallback.f21823a = c07473 != null ? new WeakReference(c07473) : null;
            } else if (clickableEntitySpanWithCallback instanceof ExternalClickableSpan) {
                String g;
                ExternalClickableSpan externalClickableSpan = (ExternalClickableSpan) clickableEntitySpanWithCallback;
                externalClickableSpan.f = graphQLStory.mo2507g();
                GraphQLStory d = StoryProps.m27457d(feedProps);
                if (d != null) {
                    g = d.mo2507g();
                } else {
                    g = null;
                }
                externalClickableSpan.g = g;
                C07451 c07451 = this.f18769p;
                externalClickableSpan.c = c07451 != null ? new WeakReference(c07451) : null;
            }
        }
        return a;
    }

    @Deprecated
    @Nullable
    public final OnClickListener m26368a(View view, LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL, @Nullable HoneyClientEvent honeyClientEvent, @Nullable Bundle bundle, @Nullable String str, @Nullable String str2) {
        if (view == null || linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL == null) {
            return null;
        }
        view.setTag(2131558518, honeyClientEvent);
        view.setTag(2131558516, linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL);
        view.setTag(2131558517, bundle);
        view.setTag(2131558524, str);
        view.setTag(2131558525, str2);
        return this.f18773t;
    }

    @Deprecated
    public final OnClickListener m26367a(View view, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams, HoneyClientEvent honeyClientEvent, String str) {
        if (view == null || graphQLFeedback == null) {
            return null;
        }
        view.setTag(2131558518, honeyClientEvent);
        view.setTag(2131558520, graphQLFeedback);
        view.setTag(2131558523, feedbackLoggingParams);
        view.setTag(2131558524, str);
        view.setOnClickListener(this.f18771r);
        return this.f18771r;
    }

    public final OnClickListener m26371a(String str, HoneyClientEvent honeyClientEvent) {
        return new 6(this, str, honeyClientEvent);
    }

    @Nullable
    public final OnClickListener m26372a(@Nullable String str, @Nullable HoneyClientEvent honeyClientEvent, @Nullable Map<String, Object> map) {
        boolean z = honeyClientEvent == null || map == null;
        Preconditions.checkState(z);
        return str == null ? null : new WithTagsClickListener(this.f18772s, 2131558518, honeyClientEvent, 2131558534, map, 2131558527, str);
    }

    @Nullable
    public final OnClickListener m26370a(FeedProps<GraphQLStoryAttachment> feedProps, GraphQLStoryActionLink graphQLStoryActionLink) {
        Preconditions.checkNotNull(feedProps);
        Preconditions.checkNotNull(graphQLStoryActionLink);
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        FeedProps e = AttachmentProps.m28715e(feedProps);
        Preconditions.checkNotNull(graphQLStoryAttachment);
        Preconditions.checkNotNull(graphQLStoryActionLink);
        String aE = graphQLStoryActionLink.aE();
        if (Strings.isNullOrEmpty(aE) && graphQLStoryAttachment.m23987z() != null) {
            aE = this.f18759f.m26449a(LinkExtractorConverter.a(graphQLStoryAttachment.m23987z()));
        }
        if (Strings.isNullOrEmpty(aE)) {
            aE = graphQLStoryAttachment.m23966C();
        }
        String str = aE;
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        GraphQLStory graphQLStory;
        7 7 = new 7(this, e, feedProps, str, graphQLStoryAttachment);
        if (e == null) {
            graphQLStory = null;
        } else {
            graphQLStory = (GraphQLStory) e.f13444a;
        }
        return new WithTagsClickListener(7, 2131558539, graphQLStoryActionLink.m22894U(), 2131558540, DirectInstallApplicationUtils.a(graphQLStoryAttachment, graphQLStory, str));
    }

    @Nullable
    private HoneyClientEvent m26360a(View view, String str, boolean z, ArrayNode arrayNode, String str2) {
        String str3 = (String) view.getTag(2131558543);
        Integer num = (Integer) view.getTag(2131558537);
        if (num == null) {
            return this.f18761h.m14543a(str, z, arrayNode, "native_newsfeed", str3, str2);
        }
        HoneyClientEvent a = this.f18761h.m14542a(str, z, (JsonNode) arrayNode, "native_newsfeed", num.intValue());
        Object obj = (view.getTag(2131558538) == null || a == null) ? null : 1;
        if (obj == null) {
            return a;
        }
        a.m5090b("cta_click", "1");
        return a;
    }

    public final OnClickListener m26369a(FeedProps<GraphQLStoryAttachment> feedProps, HoneyClientEvent honeyClientEvent, String str) {
        Object obj;
        Object obj2;
        Object obj3;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        if (GraphQLStoryAttachmentUtil.m28051a(graphQLStoryAttachment, ImmutableList.of(GraphQLStoryAttachmentStyle.AVATAR))) {
            obj = FriendRequestMakeRef.NEWSFEED;
            obj2 = null;
            obj3 = null;
        } else if (GraphQLStoryAttachmentUtil.m28051a(graphQLStoryAttachment, ImmutableList.of(GraphQLStoryAttachmentStyle.EVENT))) {
            obj3 = ActionSource.NEWSFEED;
            obj2 = Boolean.TRUE;
            obj = null;
        } else {
            obj2 = null;
            obj3 = null;
            obj = null;
        }
        return new WithTagsClickListener(m26372a(str, honeyClientEvent, null), 2131558542, m26365c(this, feedProps), 2131558544, obj, 2131558545, obj3, 2131558547, obj2);
    }

    public static ArrayNode m26365c(DefaultFeedUnitRenderer defaultFeedUnitRenderer, FeedProps feedProps) {
        if (AttachmentProps.m28717g(feedProps) == null) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
            String graphQLObjectType = (graphQLStoryAttachment.m23987z() == null || graphQLStoryAttachment.m23987z().m23390j() == null) ? "" : graphQLStoryAttachment.m23987z().m23390j().toString();
            defaultFeedUnitRenderer.f18765l.m2340a("ATTACHMENT_MISSING_PARENT_STORY_" + graphQLObjectType, "Dedupe key: " + graphQLStoryAttachment.m23974m());
        }
        return TrackableFeedProps.m27451a(feedProps);
    }
}
