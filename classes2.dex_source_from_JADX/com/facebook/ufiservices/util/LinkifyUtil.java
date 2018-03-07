package com.facebook.ufiservices.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.MetricAffectingSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.unicode.CodePointRange;
import com.facebook.common.unicode.RangeConverter;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.uri.NativeAppDetails;
import com.facebook.common.uri.NativeUri;
import com.facebook.common.uri.NativeUri.Builder;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.directinstall.util.DirectInstallApplicationUtils;
import com.facebook.earlyfetch.EarlyFetchController;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer.C07473;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLObjectType.ObjectType;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.intent.external.ExternalIntentHandler;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.intent.ufiservices.UriIntentGenerator;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL;
import com.facebook.notes.gk.NotesGatekeepers;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.text.CustomFontUtil;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import com.facebook.ufiservices.flyout.ProfileListPopoverLauncher;
import com.facebook.ufiservices.flyout.UFIProfileListFragmentGraphQLInterfaces.UFIProfileListFragmentGraphQL;
import com.facebook.ufiservices.source.UFISource;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL.Ranges;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces$LinkableUtilApplyAggregatedLinksGraphQL.AggregatedRanges;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels$LinkableUtilApplyAggregatedLinksGraphQLModel$AggregatedRangesModel.SampleEntitiesModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilAddLikeSentenceLinkGraphQLModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilAddLikeSentenceLinkGraphQLModel.AggregatedRangesModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilAddLikeSentenceLinkGraphQLModel.RangesModel;
import com.facebook.widget.text.span.SpanUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_sold */
public class LinkifyUtil {
    private static volatile LinkifyUtil f18855F;
    public static final int f18856a = 2131362717;
    public static final Comparator<Ranges> f18857b = new C07421();
    public static final Comparator<AggregatedRanges> f18858c = new C07432();
    private static final Function<LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL, Bundle> f18859e = new C07443();
    private final Lazy<LinkifySpanFactory> f18860A;
    private final Lazy<MessageTruncator> f18861B;
    public final InteractionTTILogger f18862C;
    public final NewsFeedAnalyticsEventBuilder f18863D;
    private final GatekeeperStoreImpl f18864E;
    @Inject
    NotesGatekeepers f18865d;
    private final String f18866f = this.f18870j.getResources().getString(2131230738);
    public final String f18867g = this.f18870j.getResources().getString(2131233418);
    private final String f18868h = this.f18870j.getString(2131233419);
    private final String f18869i = this.f18870j.getString(2131233617);
    public final Context f18870j;
    public final Lazy<CommonEventsBuilder> f18871k;
    public final AnalyticsLogger f18872l;
    public final Lazy<NavigationLogger> f18873m;
    public final SecureContextHelper f18874n;
    public final ExternalIntentHandler f18875o;
    private final CustomFontUtil f18876p;
    public final Lazy<ProfileListPopoverLauncher> f18877q;
    public final Lazy<UFISource> f18878r;
    public final Lazy<UriIntentGenerator> f18879s;
    public final Provider<EarlyFetchController> f18880t;
    public final Lazy<UriIntentMapper> f18881u;
    public final Lazy<FbUriIntentHandler> f18882v;
    private final Lazy<GraphQLLinkExtractor> f18883w;
    private final Lazy<Boolean> f18884x;
    private final int f18885y = 2131362716;
    private final Provider<ComponentName> f18886z;

    /* compiled from: is_sold */
    final class C07421 implements Comparator<Ranges> {
        C07421() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((Ranges) obj).mo3227c() - ((Ranges) obj2).mo3227c();
        }
    }

    /* compiled from: is_sold */
    final class C07432 implements Comparator<AggregatedRanges> {
        C07432() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((C0891x165ff5b) obj).m29968b() - ((C0891x165ff5b) obj2).m29968b();
        }
    }

    /* compiled from: is_sold */
    final class C07443 implements Function<LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL, Bundle> {
        C07443() {
        }

        @Nullable
        public final Object apply(@Nullable Object obj) {
            LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL = (LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL) obj;
            String str = null;
            if (linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL == null) {
                return null;
            }
            Bundle bundle = new Bundle(1);
            int g = linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3202b().m22301g();
            String d = linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3203d();
            if (linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.ad_() != null) {
                str = linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.ad_().mo3198b();
            }
            ModelBundle.a(bundle, g, d, str, linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.C_());
            return bundle;
        }
    }

    /* compiled from: is_sold */
    class InternalClickableSpanWithExtras<T> extends InternalClickableSpan {
        final /* synthetic */ LinkifyUtil f21818d;
        private final Function<T, Bundle> f21819e;
        private final T f21820f;

        public InternalClickableSpanWithExtras(LinkifyUtil linkifyUtil, String str, SecureContextHelper secureContextHelper, Context context, @Nullable JsonNode jsonNode, int i, @Nullable C0886x4c591671 c0886x4c591671, @Nullable String str2, Function<T, Bundle> function, @Nullable T t) {
            this.f21818d = linkifyUtil;
            super(linkifyUtil, str, secureContextHelper, context, jsonNode, i, c0886x4c591671, str2);
            this.f21819e = function;
            this.f21820f = t;
        }

        protected final Bundle mo3204g() {
            return (Bundle) this.f21819e.apply(this.f21820f);
        }
    }

    /* compiled from: is_sold */
    class InternalClickableSpan extends ClickableEntitySpanWithCallback {
        final /* synthetic */ LinkifyUtil f21821c;
        private final SecureContextHelper f21822d;

        private void m29591a(JsonNode jsonNode) {
            C0886x4c591671 c0886x4c591671 = this.f21830h;
            int i = this.f21829g;
            if (i == -1932766292) {
                ((NavigationLogger) this.f21821c.f18873m.get()).m5517b("native_newsfeed", ObjectType.m22303a(i), c0886x4c591671.mo3234g(), jsonNode != null ? ImmutableBiMap.m978b("tracking", jsonNode) : null);
            }
        }

        public InternalClickableSpan(LinkifyUtil linkifyUtil, String str, SecureContextHelper secureContextHelper, Context context, @Nullable JsonNode jsonNode, int i, @Nullable C0886x4c591671 c0886x4c591671, @Nullable String str2) {
            this.f21821c = linkifyUtil;
            super(linkifyUtil, str, context, jsonNode, i, c0886x4c591671, str2);
            this.f21822d = secureContextHelper;
        }

        protected Bundle mo3204g() {
            return null;
        }

        protected final void mo3205a(Context context, String str, JsonNode jsonNode, boolean z, @Nullable TrackingNode trackingNode) {
            this.f21821c.f18862C.m4248a(context, "InternalClickableSpan");
            Bundle g = mo3204g();
            ((EarlyFetchController) this.f21821c.f18880t.get()).m28205a(this.f21829g, this.f21831i, g);
            m29591a(jsonNode);
            m29596a(z, trackingNode, jsonNode);
            C07473 c07473 = this.f21823a != null ? (C07473) this.f21823a.get() : null;
            if (c07473 != null) {
                c07473.m26569a(this);
            }
            Intent a = ((UriIntentMapper) this.f21821c.f18881u.get()).mo1267a(context, str);
            if (a != null) {
                if (g != null) {
                    a.putExtras(g);
                }
                this.f21822d.mo662a(a, context);
                return;
            }
            this.f21821c.f18862C.m4245a();
        }
    }

    /* compiled from: is_sold */
    public class ClickableEntitySpanWithCallback extends ClickableSpan {
        public WeakReference<ClickableSpanCallback> f21823a;
        final /* synthetic */ LinkifyUtil f21824b;
        public final String f21825c;
        private final Context f21826d;
        public final JsonNode f21827e;
        public int f21828f = 2131362716;
        public final int f21829g;
        public final C0886x4c591671 f21830h;
        public final String f21831i;
        public WeakReference<View> f21832j;

        public ClickableEntitySpanWithCallback(LinkifyUtil linkifyUtil, String str, Context context, @Nullable JsonNode jsonNode, int i, @Nullable C0886x4c591671 c0886x4c591671, @Nullable String str2) {
            this.f21824b = linkifyUtil;
            this.f21825c = str;
            this.f21826d = context;
            this.f21827e = jsonNode;
            this.f21829g = i;
            this.f21830h = c0886x4c591671;
            this.f21831i = str2;
            this.f21832j = null;
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f21826d.getResources().getColor(this.f21828f));
        }

        public final void m29594a(int i) {
            this.f21828f = i;
        }

        protected void mo3205a(Context context, String str, JsonNode jsonNode, boolean z, TrackingNode trackingNode) {
            NativeAppDetails nativeAppDetails = null;
            C07473 c07473 = this.f21823a != null ? (C07473) this.f21823a.get() : null;
            int i = this.f21829g;
            if (c07473 != null) {
                if (!(i == -355769904 || NativeThirdPartyUriHelper.m29571a(str))) {
                    m29596a(z, trackingNode, jsonNode);
                }
                c07473.m26569a(this);
                return;
            }
            Map d;
            if (i == -355769904) {
                C0886x4c591671 c0886x4c591671 = this.f21830h;
                nativeAppDetails = DirectInstallApplicationUtils.a(c0886x4c591671, null, c0886x4c591671.D_());
                NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f21824b.f18863D;
                d = NewsFeedAnalyticsEventBuilder.m14121d(true, jsonNode);
                if (trackingNode != null) {
                    d.put("tn", trackingNode);
                }
            } else {
                d = null;
            }
            if (NativeThirdPartyUriHelper.m29571a(str)) {
                Builder f = NativeUri.f();
                f.a = str;
                f = f;
                f.d = nativeAppDetails;
                Builder a = f.a(d);
                a.e = "NEWSFEED";
                ((FbUriIntentHandler) this.f21824b.f18882v.get()).m8631a(context, a.a());
                return;
            }
            this.f21824b.f18862C.m4248a(context, getClass().getSimpleName());
            Intent a2 = ((UriIntentMapper) this.f21824b.f18881u.get()).mo1267a(context, str);
            if (a2 != null) {
                m29596a(z, trackingNode, jsonNode);
                Uri parse = Uri.parse(str);
                if (!FacebookUriUtil.m20919c(parse) || FacebookUriUtil.m20916a(parse)) {
                    if (i == -245095862) {
                        HoneyClientEventFast a3 = this.f21824b.f18872l.mo535a("instagram_tag_interactions", true);
                        if (a3.m17388a()) {
                            a3.m17385a("event", "android_click");
                            a3.m17390b();
                        }
                    }
                    this.f21824b.f18874n.mo665b(a2, context);
                    this.f21824b.f18862C.m4245a();
                    return;
                }
                this.f21824b.f18874n.mo662a(a2, context);
                return;
            }
            this.f21824b.f18862C.m4245a();
        }

        protected final void m29596a(boolean z, @Nullable TrackingNode trackingNode, @Nullable JsonNode jsonNode) {
            ((NavigationLogger) this.f21824b.f18873m.get()).f3312w = jsonNode != null ? jsonNode.toString() : null;
            if (this.f21827e != null) {
                HoneyClientEvent a = ((CommonEventsBuilder) this.f21824b.f18871k.get()).m14541a(this.f21825c, z, this.f21827e, "native_newsfeed");
                TrackingNodes.m27143a(a, trackingNode);
                this.f21824b.f18872l.mo528a(a);
            }
        }

        public void onClick(View view) {
            boolean z;
            Object tag = view.getTag(2131558541);
            if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                z = true;
            } else {
                z = false;
            }
            boolean z2 = z;
            TrackingNode a = TrackingNodes.m27140a(view);
            this.f21832j = new WeakReference(view);
            ((NavigationLogger) this.f21824b.f18873m.get()).m5498a(z2 ? "tap_sponsored_link" : "tap_link");
            mo3205a(view.getContext(), this.f21825c, this.f21827e, z2, a);
        }
    }

    public static com.facebook.ufiservices.util.LinkifyUtil m26532a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f18855F;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ufiservices.util.LinkifyUtil.class;
        monitor-enter(r1);
        r0 = f18855F;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m26545b(r0);	 Catch:{ all -> 0x0035 }
        f18855F = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18855F;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.LinkifyUtil.a(com.facebook.inject.InjectorLike):com.facebook.ufiservices.util.LinkifyUtil");
    }

    private static LinkifyUtil m26545b(InjectorLike injectorLike) {
        LinkifyUtil linkifyUtil = new LinkifyUtil((Context) injectorLike.getInstance(Context.class), IdBasedLazy.m1808a(injectorLike, 126), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 137), IdBasedSingletonScopeProvider.m1810b(injectorLike, 11470), DefaultSecureContextHelper.m4636a(injectorLike), ExternalIntentHandler.m22740a(injectorLike), CustomFontUtil.m26563a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3535), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2350), IdBasedSingletonScopeProvider.m1809a(injectorLike, 1120), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2436), IdBasedSingletonScopeProvider.m1810b(injectorLike, 616), IdBasedLazy.m1808a(injectorLike, 4354), IdBasedLazy.m1808a(injectorLike, 2189), IdBasedProvider.m1811a(injectorLike, 12), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3536), IdBasedLazy.m1808a(injectorLike, 3540), InteractionTTILogger.m4228a(injectorLike), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
        linkifyUtil.m26534a(NotesGatekeepers.m26565a(injectorLike));
        return linkifyUtil;
    }

    private void m26534a(NotesGatekeepers notesGatekeepers) {
        this.f18865d = notesGatekeepers;
    }

    @Inject
    public LinkifyUtil(Context context, Lazy<CommonEventsBuilder> lazy, AnalyticsLogger analyticsLogger, Lazy<NavigationLogger> lazy2, Lazy<ProfileListPopoverLauncher> lazy3, SecureContextHelper secureContextHelper, ExternalIntentHandler externalIntentHandler, CustomFontUtil customFontUtil, Lazy<UFISource> lazy4, Lazy<UriIntentGenerator> lazy5, Provider<EarlyFetchController> provider, Lazy<UriIntentMapper> lazy6, Lazy<FbUriIntentHandler> lazy7, Lazy<Boolean> lazy8, Lazy<GraphQLLinkExtractor> lazy9, @FragmentChromeActivity Provider<ComponentName> provider2, Lazy<LinkifySpanFactory> lazy10, Lazy<MessageTruncator> lazy11, InteractionTTILogger interactionTTILogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, GatekeeperStore gatekeeperStore) {
        this.f18870j = context;
        this.f18871k = lazy;
        this.f18872l = analyticsLogger;
        this.f18873m = lazy2;
        this.f18877q = lazy3;
        this.f18874n = secureContextHelper;
        this.f18875o = externalIntentHandler;
        this.f18876p = customFontUtil;
        this.f18878r = lazy4;
        this.f18879s = lazy5;
        this.f18880t = provider;
        this.f18881u = lazy6;
        this.f18882v = lazy7;
        this.f18884x = lazy8;
        this.f18883w = lazy9;
        this.f18886z = provider2;
        this.f18860A = lazy10;
        this.f18861B = lazy11;
        this.f18862C = interactionTTILogger;
        this.f18863D = newsFeedAnalyticsEventBuilder;
        this.f18864E = gatekeeperStore;
    }

    private MetricAffectingSpan m26531a() {
        return CustomFontUtil.m26562a();
    }

    public final Spannable m26547a(@Nullable LinkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL, boolean z, @Nullable JsonNode jsonNode) {
        return m26548a(linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL, z, jsonNode, 0);
    }

    public final Spannable m26548a(@Nullable LinkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL, boolean z, @Nullable JsonNode jsonNode, int i) {
        CharSequence a = (linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL == null || linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL.mo3223a() == null) ? "" : linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL.mo3223a();
        Spannable valueOf = SpannableString.valueOf(a);
        m26536a(linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL, null, valueOf, z, jsonNode, i);
        return valueOf;
    }

    public final CharSequence m26558a(LinkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL) {
        return m26533a(m26547a(linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL, true, null));
    }

    public final Spannable m26550a(LinkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel, @Nullable FeedUnit feedUnit, @Nullable FlyoutClickSource flyoutClickSource, JsonNode jsonNode) {
        return m26551a(linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel, flyoutClickSource, jsonNode, 0);
    }

    public final Spannable m26551a(LinkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel, @Nullable FlyoutClickSource flyoutClickSource, JsonNode jsonNode, int i) {
        if (linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel == null) {
            return null;
        }
        return m26530a(linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel, flyoutClickSource, SpannableString.valueOf(linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel.mo3223a() != null ? linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel.mo3223a() : ""), jsonNode, i);
    }

    private Spannable m26529a(LinkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel, @Nullable FlyoutClickSource flyoutClickSource, Spannable spannable, JsonNode jsonNode) {
        return m26530a(linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel, flyoutClickSource, spannable, jsonNode, 0);
    }

    private Spannable m26530a(LinkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel, @Nullable FlyoutClickSource flyoutClickSource, Spannable spannable, JsonNode jsonNode, int i) {
        if (spannable == null) {
            return null;
        }
        Spannable spannable2 = (Spannable) spannable.subSequence(0, spannable.length());
        m26535a((LinkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL) linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel, flyoutClickSource, spannable2, jsonNode, i);
        m26537a((C0881xeef6f5c8) linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel, spannable2, jsonNode, i);
        return spannable2;
    }

    private Spannable m26528a(LinkableUtilAddLikeSentenceLinkGraphQLModel linkableUtilAddLikeSentenceLinkGraphQLModel) {
        int i = 0;
        CharSequence a = (linkableUtilAddLikeSentenceLinkGraphQLModel == null || linkableUtilAddLikeSentenceLinkGraphQLModel.a() == null) ? "" : linkableUtilAddLikeSentenceLinkGraphQLModel.a();
        Spannable valueOf = SpannableString.valueOf(a);
        if (!linkableUtilAddLikeSentenceLinkGraphQLModel.b().isEmpty()) {
            ImmutableList b = linkableUtilAddLikeSentenceLinkGraphQLModel.b();
            int size = b.size();
            for (int i2 = 0; i2 < size; i2++) {
                RangesModel rangesModel = (RangesModel) b.get(i2);
                if (!(rangesModel.a() == null || rangesModel.a().b() == null)) {
                    UTF16Range a2 = RangeConverter.m29945a(linkableUtilAddLikeSentenceLinkGraphQLModel.a(), new CodePointRange(rangesModel.c(), rangesModel.b()));
                    valueOf.setSpan(m26531a(), a2.f22086a, a2.m29947c(), 17);
                }
            }
        }
        if (!linkableUtilAddLikeSentenceLinkGraphQLModel.c().isEmpty()) {
            ImmutableList c = linkableUtilAddLikeSentenceLinkGraphQLModel.c();
            int size2 = c.size();
            while (i < size2) {
                AggregatedRangesModel aggregatedRangesModel = (AggregatedRangesModel) c.get(i);
                a2 = RangeConverter.m29945a(linkableUtilAddLikeSentenceLinkGraphQLModel.a(), new CodePointRange(aggregatedRangesModel.b(), aggregatedRangesModel.a()));
                valueOf.setSpan(m26531a(), a2.f22086a, a2.m29947c(), 17);
                i++;
            }
        }
        return valueOf;
    }

    public final Spannable m26549a(LinkableUtilAddLikeSentenceLinkGraphQLModel linkableUtilAddLikeSentenceLinkGraphQLModel, boolean z, @Nullable JsonNode jsonNode) {
        if (linkableUtilAddLikeSentenceLinkGraphQLModel == null) {
            return null;
        }
        if (linkableUtilAddLikeSentenceLinkGraphQLModel.c().isEmpty()) {
            return m26547a((LinkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL) linkableUtilAddLikeSentenceLinkGraphQLModel, z, jsonNode);
        }
        return m26528a(linkableUtilAddLikeSentenceLinkGraphQLModel);
    }

    public final Spannable m26546a(LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL, @Nullable JsonNode jsonNode, int i, boolean z) {
        if (linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL == null) {
            return null;
        }
        Object C_;
        if (linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.C_() != null) {
            C_ = linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.C_();
        } else {
            String str = "";
        }
        String a = ((GraphQLLinkExtractor) this.f18883w.get()).m26445a(linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3202b(), linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3203d());
        Spannable valueOf = SpannableString.valueOf(C_);
        m26561a(a, 0, C_.length(), valueOf, false, i, z, jsonNode, linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL);
        return valueOf;
    }

    public static CharSequence m26533a(Spannable spannable) {
        return TextUtils.concat(new CharSequence[]{spannable, " "});
    }

    public final Spannable m26552a(LinkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel, JsonNode jsonNode) {
        if (linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel == null) {
            return null;
        }
        Resources resources = this.f18870j.getResources();
        CharSequence a = (linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel == null || linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel.mo3223a() == null) ? "" : linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel.mo3223a();
        Spannable valueOf = SpannableString.valueOf(a);
        valueOf.setSpan(new ForegroundColorSpan(resources.getColor(2131362052)), 0, valueOf.length(), 33);
        CharSequence a2 = m26529a(linkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel, FlyoutClickSource.SUFFIX, valueOf, jsonNode);
        valueOf = new SpannableStringBuilder();
        valueOf.append(" ");
        valueOf.append(SpannableString.valueOf(resources.getString(2131233480)));
        valueOf.append(" ");
        valueOf.setSpan(new ForegroundColorSpan(resources.getColor(2131362052)), 0, valueOf.length(), 33);
        valueOf.append(a2);
        return valueOf;
    }

    public final Spannable m26554a(CharSequence charSequence, OnClickListener onClickListener) {
        return m26556a(charSequence, onClickListener, this.f18867g);
    }

    public final Spannable m26556a(CharSequence charSequence, OnClickListener onClickListener, String str) {
        return m26553a(charSequence, charSequence.length(), ((DefaultLinkifySpanFactory) this.f18860A.get()).m30358a(onClickListener), ((MessageTruncator) this.f18861B.get()).m31231a(charSequence, false), str);
    }

    public final Spannable m26555a(CharSequence charSequence, OnClickListener onClickListener, int i, String str) {
        return m26553a(charSequence, charSequence.length(), ((DefaultLinkifySpanFactory) this.f18860A.get()).m30358a(onClickListener), i, str);
    }

    public final Spannable m26553a(CharSequence charSequence, int i, CharacterStyle characterStyle, int i2, String str) {
        SpannableString.valueOf(str).setSpan(characterStyle, 0, str.length(), 33);
        int i3 = 0;
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (charSequence.charAt(i4) == '\n') {
                i3++;
            }
            if (i3 >= 7) {
                return SpannableString.valueOf(TextUtils.concat(new CharSequence[]{SpanUtils.a(charSequence, 0, Math.min(i4, i2)), this.f18866f, " ", r3}));
            }
        }
        if (i <= i2) {
            return null;
        }
        if (str.length() + charSequence.toString().substring(0, i2).trim().length() >= i) {
            return null;
        }
        return SpannableString.valueOf(TextUtils.concat(new CharSequence[]{SpanUtils.a(charSequence, 0, charSequence.toString().substring(0, i2).trim().length()), this.f18866f, " ", r3}));
    }

    public final SpannableStringBuilder m26557a(SpannableStringBuilder spannableStringBuilder, GraphQLTranslatabilityType graphQLTranslatabilityType) {
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        if (!((Boolean) this.f18884x.get()).booleanValue()) {
            return null;
        }
        SeeTranslationSpan seeTranslationSpan = ((DefaultLinkifySpanFactory) this.f18860A.get()).f22503c;
        Object obj = graphQLTranslatabilityType == GraphQLTranslatabilityType.SEE_CONVERSION ? this.f18869i : this.f18868h;
        CharSequence valueOf = SpannableString.valueOf(obj);
        valueOf.setSpan(seeTranslationSpan, 0, obj.length(), 33);
        spannableStringBuilder2.append('\n');
        return spannableStringBuilder2.append(valueOf);
    }

    private void m26536a(LinkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL, @Nullable FlyoutClickSource flyoutClickSource, Spannable spannable, boolean z, @Nullable JsonNode jsonNode, int i) {
        if (linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL != null) {
            if (i == 0) {
                i = 2131361972;
            }
            List<C0884x53bd6f74> a = Lists.m1298a(linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL.mo3224b());
            Collections.sort(a, f18857b);
            boolean a2 = m26542a(flyoutClickSource);
            boolean z2 = a2;
            for (C0884x53bd6f74 c0884x53bd6f74 : a) {
                if (!(c0884x53bd6f74.mo3228d() == null || c0884x53bd6f74.mo3228d().mo3202b() == null)) {
                    boolean z3;
                    int i2;
                    int g = c0884x53bd6f74.mo3228d().mo3202b().m22301g();
                    if (m26544a((C0885xba9ef6ad) c0884x53bd6f74, g, a2)) {
                        int i3;
                        z3 = false;
                        if (a2) {
                            i3 = 2131361972;
                        } else {
                            i3 = this.f18885y;
                        }
                        i2 = i3;
                    } else {
                        z3 = z;
                        i2 = i;
                    }
                    if (m26543a(c0884x53bd6f74.mo3228d(), this.f18872l)) {
                        m26539a(linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL.mo3223a(), (C0883x3380bccd) c0884x53bd6f74, spannable, i2, z3, jsonNode);
                    } else if (g == -1932766292) {
                        m26541a(linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL.mo3223a(), c0884x53bd6f74, spannable, z2, i2, z3, jsonNode);
                    } else if (g == 105285582) {
                        m26540a(linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL.mo3223a(), c0884x53bd6f74, spannable, i2, jsonNode);
                    } else {
                        LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL n;
                        UTF16Range a3 = RangeConverter.m29945a(linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL.mo3223a(), new CodePointRange(c0884x53bd6f74.mo3227c(), c0884x53bd6f74.mo3226b()));
                        if (c0884x53bd6f74.mo3228d().mo3239n() != null) {
                            n = c0884x53bd6f74.mo3228d().mo3239n();
                        } else {
                            n = c0884x53bd6f74.mo3228d();
                        }
                        CharSequence a4 = ((GraphQLLinkExtractor) this.f18883w.get()).m26448a(c0884x53bd6f74.mo3228d());
                        if (!(c0884x53bd6f74.mo3228d().mo3233c() == null || c0884x53bd6f74.mo3228d().mo3233c().isEmpty())) {
                            a4 = (String) c0884x53bd6f74.mo3228d().mo3233c().get(0);
                        }
                        if (!StringUtil.m3589a(a4)) {
                            m26561a(a4, a3.m29946a(), a3.m29947c(), spannable, z2, i2, z3, jsonNode, n);
                        }
                    }
                    if (z2) {
                        z2 = false;
                    }
                }
            }
        }
    }

    private static boolean m26544a(C0885xba9ef6ad c0885xba9ef6ad, int i, boolean z) {
        if (i == 1607392245) {
            return true;
        }
        if (i != 514783620) {
            return false;
        }
        if (z && FacebookUriUtil.m20920d(Uri.parse(c0885xba9ef6ad.dI_().D_()))) {
            return false;
        }
        return true;
    }

    private static boolean m26542a(@Nullable FlyoutClickSource flyoutClickSource) {
        return FlyoutClickSource.TITLE.equals(flyoutClickSource);
    }

    public final void m26559a(LinkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL, @Nullable FlyoutClickSource flyoutClickSource, Spannable spannable, JsonNode jsonNode) {
        m26535a(linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL, flyoutClickSource, spannable, jsonNode, 0);
    }

    private void m26535a(LinkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL, @Nullable FlyoutClickSource flyoutClickSource, Spannable spannable, JsonNode jsonNode, int i) {
        m26536a(linkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL, flyoutClickSource, spannable, true, jsonNode, i);
    }

    public final void m26561a(@Nullable String str, int i, int i2, Spannable spannable, boolean z, int i3, boolean z2, @Nullable JsonNode jsonNode, LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL) {
        if (str != null) {
            ClickableEntitySpanWithCallback externalClickableSpan;
            if (linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL == null || !Objects.equal(this.f18878r.get(), UFISource.FEED) || linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3202b() == null || linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3202b().m22301g() == 514783620 || linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3202b().m22301g() == -1304042141 || linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3202b().m22301g() == 1607392245) {
                externalClickableSpan = new ExternalClickableSpan(this, str, this.f18875o, this.f18870j, jsonNode);
            } else {
                String formatStrLocaleSafe;
                if (this.f18865d.m26567a() && linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3202b().m22301g() == 2434066) {
                    formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aV, linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3203d());
                } else {
                    formatStrLocaleSafe = str;
                }
                externalClickableSpan = new InternalClickableSpanWithExtras(this, formatStrLocaleSafe, this.f18874n, this.f18870j, jsonNode, linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3202b().m22301g(), null, linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.mo3203d(), f18859e, linkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL);
            }
            externalClickableSpan.m29594a(i3);
            spannable.setSpan(externalClickableSpan, i, i2, 33);
            if (z || z2) {
                spannable.setSpan(m26531a(), i, i2, 33);
            }
        }
    }

    private void m26541a(String str, LinkifyUtilGraphQLInterfaces$LinkableUtilApplyHashtagLinkGraphQL linkifyUtilGraphQLInterfaces$LinkableUtilApplyHashtagLinkGraphQL, Spannable spannable, boolean z, int i, boolean z2, JsonNode jsonNode) {
        C0886x4c591671 dH_ = linkifyUtilGraphQLInterfaces$LinkableUtilApplyHashtagLinkGraphQL.dH_();
        if (dH_ != null && dH_.mo3234g() != null) {
            CharSequence a;
            String str2 = null;
            if (!(dH_.mo3233c() == null || dH_.mo3233c().isEmpty())) {
                str2 = (String) dH_.mo3233c().get(0);
            }
            if (Strings.isNullOrEmpty(str2)) {
                a = ((GraphQLLinkExtractor) this.f18883w.get()).m26448a(linkifyUtilGraphQLInterfaces$LinkableUtilApplyHashtagLinkGraphQL.dH_());
            } else {
                Object obj = str2;
            }
            if (!StringUtil.m3589a(a)) {
                ClickableEntitySpanWithCallback internalClickableSpan = new InternalClickableSpan(this, a, this.f18874n, this.f18870j, jsonNode, -1932766292, dH_, null);
                UTF16Range a2 = RangeConverter.m29945a(str, new CodePointRange(linkifyUtilGraphQLInterfaces$LinkableUtilApplyHashtagLinkGraphQL.mo3227c(), linkifyUtilGraphQLInterfaces$LinkableUtilApplyHashtagLinkGraphQL.mo3226b()));
                int a3 = a2.m29946a();
                int c = a2.m29947c();
                internalClickableSpan.m29594a(i);
                spannable.setSpan(internalClickableSpan, a3, c, 33);
                if (z || z2) {
                    spannable.setSpan(m26531a(), a3 + 1, c, 33);
                }
            }
        }
    }

    private void m26540a(String str, C0884x53bd6f74 c0884x53bd6f74, Spannable spannable, int i, JsonNode jsonNode) {
        GraphQLLinkExtractorGraphQLInterfaces$GetEntityFbLinkGraphQL g = c0884x53bd6f74.mo3232g();
        if (g != null && g.mo3203d() != null) {
            CharSequence a = ((GraphQLLinkExtractor) this.f18883w.get()).m26448a(g);
            if (!StringUtil.m3589a(a)) {
                ClickableEntitySpanWithCallback internalClickableSpan = new InternalClickableSpan(this, a, this.f18874n, this.f18870j, jsonNode, 105285582, g, g.mo3203d());
                UTF16Range a2 = RangeConverter.m29945a(str, new CodePointRange(c0884x53bd6f74.mo3227c(), c0884x53bd6f74.mo3226b()));
                int a3 = a2.m29946a();
                int c = a2.m29947c();
                internalClickableSpan.f21828f = i;
                spannable.setSpan(internalClickableSpan, a3, c, 33);
                spannable.setSpan(m26531a(), a3, c, 33);
            }
        }
    }

    private static boolean m26543a(C0889x95241f73 c0889x95241f73, AnalyticsLogger analyticsLogger) {
        if (c0889x95241f73.mo3233c() != null && !c0889x95241f73.mo3233c().isEmpty() && !StringUtil.m3589a((CharSequence) c0889x95241f73.mo3233c().get(0)) && ((String) c0889x95241f73.mo3233c().get(0)).startsWith("fbrpc")) {
            return true;
        }
        if (c0889x95241f73.mo3202b() != null && c0889x95241f73.mo3202b().m22301g() == -245095862) {
            HoneyClientEventFast a = analyticsLogger.mo535a("instagram_tag_interactions", false);
            if (a.m17388a()) {
                a.m17385a("event", "android_view");
                a.m17390b();
            }
            return true;
        } else if (c0889x95241f73.mo3202b() == null || c0889x95241f73.mo3202b().m22301g() != -1476137794) {
            return !StringUtil.m3589a(c0889x95241f73.D_()) && c0889x95241f73.D_().startsWith("fbrpc");
        } else {
            return true;
        }
    }

    private void m26539a(String str, C0883x3380bccd c0883x3380bccd, Spannable spannable, int i, boolean z, JsonNode jsonNode) {
        if (c0883x3380bccd != null && c0883x3380bccd.dG_() != null && c0883x3380bccd.dG_().mo3202b() != null) {
            CharSequence D_;
            if (c0883x3380bccd.dG_().mo3202b().m22301g() == -1476137794) {
                D_ = c0883x3380bccd.dG_().D_();
            } else if (c0883x3380bccd.dG_().mo3233c() == null || c0883x3380bccd.dG_().mo3233c().isEmpty()) {
                D_ = c0883x3380bccd.dG_().D_() != null ? c0883x3380bccd.dG_().D_() : null;
            } else {
                Object obj = (String) c0883x3380bccd.dG_().mo3233c().get(0);
            }
            if (!StringUtil.m3589a(D_)) {
                ClickableEntitySpanWithCallback clickableEntitySpanWithCallback = new ClickableEntitySpanWithCallback(this, D_, this.f18870j, jsonNode, c0883x3380bccd.dG_().mo3202b().m22301g(), c0883x3380bccd.dG_(), null);
                clickableEntitySpanWithCallback.f21828f = i;
                UTF16Range a = RangeConverter.m29945a(str, new CodePointRange(c0883x3380bccd.mo3227c(), c0883x3380bccd.mo3226b()));
                spannable.setSpan(clickableEntitySpanWithCallback, a.m29946a(), a.m29947c(), 33);
                if (z) {
                    spannable.setSpan(m26531a(), a.m29946a(), a.m29947c(), 33);
                }
            }
        }
    }

    public final void m26560a(C0881xeef6f5c8 c0881xeef6f5c8, Spannable spannable, JsonNode jsonNode) {
        m26537a(c0881xeef6f5c8, spannable, jsonNode, 0);
    }

    private void m26537a(C0881xeef6f5c8 c0881xeef6f5c8, Spannable spannable, JsonNode jsonNode, int i) {
        int i2;
        if (c0881xeef6f5c8.mo3225c() == null || c0881xeef6f5c8.mo3225c().size() == 0 || c0881xeef6f5c8.mo3225c().get(0) == null || ((C0891x165ff5b) c0881xeef6f5c8.mo3225c().get(0)).m29969c() == null || ((C0891x165ff5b) c0881xeef6f5c8.mo3225c().get(0)).m29969c().get(0) == null || ((SampleEntitiesModel) ((C0891x165ff5b) c0881xeef6f5c8.mo3225c().get(0)).m29969c().get(0)).g() == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i2 != 0) {
            List<C0891x165ff5b> a = Lists.m1298a(c0881xeef6f5c8.mo3225c());
            Collections.sort(a, f18858c);
            for (C0891x165ff5b c0891x165ff5b : a) {
                UTF16Range a2 = RangeConverter.m29945a(c0881xeef6f5c8.mo3223a(), new CodePointRange(c0891x165ff5b.m29968b(), c0891x165ff5b.m29964a()));
                m26538a(c0891x165ff5b.m29969c(), a2.f22086a, a2.m29947c(), spannable, jsonNode, i);
            }
        }
    }

    private void m26538a(ImmutableList<? extends UFIProfileListFragmentGraphQL> immutableList, int i, int i2, Spannable spannable, JsonNode jsonNode, int i3) {
        if (i3 == 0) {
            i3 = 2131361972;
        }
        spannable.setSpan(new FlyoutSpanNoUnderline(this, immutableList, jsonNode, i3), i, i2, 33);
    }
}
