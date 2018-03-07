package com.facebook.feed.renderer.spannable;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.common.uri.NativeAppDetails;
import com.facebook.common.uri.NativeUri;
import com.facebook.common.uri.NativeUri.Builder;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.ActionSource;
import com.facebook.feed.analytics.LongClickTracker;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.util.event.FeedEvent;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.graphql.model.GraphQLLinkTargetStoreData;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: simplepicker_livecam_cell */
public class NativeThirdPartyUriClickHandler {
    private static volatile NativeThirdPartyUriClickHandler f3673g;
    private final NewsFeedAnalyticsEventBuilder f3674a;
    private final IFeedIntentBuilder f3675b;
    private final AnalyticsLogger f3676c;
    private final LongClickTracker f3677d;
    private final FeedEventBus f3678e;
    private final SecureContextHelper f3679f;

    public static com.facebook.feed.renderer.spannable.NativeThirdPartyUriClickHandler m4383a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3673g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.renderer.spannable.NativeThirdPartyUriClickHandler.class;
        monitor-enter(r1);
        r0 = f3673g;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m4386b(r0);	 Catch:{ all -> 0x0035 }
        f3673g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3673g;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.renderer.spannable.NativeThirdPartyUriClickHandler.a(com.facebook.inject.InjectorLike):com.facebook.feed.renderer.spannable.NativeThirdPartyUriClickHandler");
    }

    private static NativeThirdPartyUriClickHandler m4386b(InjectorLike injectorLike) {
        return new NativeThirdPartyUriClickHandler(NewsFeedAnalyticsEventBuilder.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), LongClickTracker.a(injectorLike), FeedEventBus.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public NativeThirdPartyUriClickHandler(NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, IFeedIntentBuilder iFeedIntentBuilder, AnalyticsLogger analyticsLogger, LongClickTracker longClickTracker, FeedEventBus feedEventBus, SecureContextHelper secureContextHelper) {
        this.f3674a = newsFeedAnalyticsEventBuilder;
        this.f3675b = iFeedIntentBuilder;
        this.f3676c = analyticsLogger;
        this.f3677d = longClickTracker;
        this.f3678e = feedEventBus;
        this.f3679f = secureContextHelper;
    }

    public final void m4388a(@Nullable String str, View view, @Nullable JsonNode jsonNode) {
        m4385a(str, view, jsonNode, (Map) view.getTag(2131558534), (HoneyClientEvent) view.getTag(2131558518));
    }

    public final void m4387a(@Nullable String str, View view, @Nullable HoneyClientEvent honeyClientEvent) {
        m4385a(str, view, null, null, honeyClientEvent);
    }

    private void m4385a(@Nullable String str, View view, @Nullable JsonNode jsonNode, @Nullable Map<String, Object> map, @Nullable HoneyClientEvent honeyClientEvent) {
        if (!TextUtils.isEmpty(str)) {
            boolean z;
            Object tag = view.getTag(2131558541);
            if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                z = true;
            } else {
                z = false;
            }
            boolean z2 = z;
            Bundle bundle = new Bundle();
            FriendRequestMakeRef friendRequestMakeRef = (FriendRequestMakeRef) view.getTag(2131558544);
            if (!(friendRequestMakeRef == null || str == null || !FacebookUriUtil.g(Uri.parse(str)))) {
                bundle.putSerializable("timeline_friend_request_ref", friendRequestMakeRef);
            }
            ActionSource actionSource = (ActionSource) view.getTag(2131558545);
            if (actionSource != null) {
                bundle.putParcelable("action_ref", actionSource);
            }
            ArrayNode arrayNode = (ArrayNode) view.getTag(2131558542);
            Boolean bool = (Boolean) view.getTag(2131558547);
            if (!(arrayNode == null || bool == null || !bool.booleanValue())) {
                bundle.putString("tracking_codes", arrayNode.toString());
            }
            Bundle bundle2 = bundle;
            ArrayNode arrayNode2 = (ArrayNode) view.getTag(2131558542);
            FeedEvent feedEvent = (FeedEvent) view.getTag(2131558515);
            if (jsonNode != null) {
                arrayNode2 = new ArrayNode(JsonNodeFactory.a);
                arrayNode2.a(jsonNode);
                map = NewsFeedAnalyticsEventBuilder.d(z2, jsonNode);
                map.put("tn", arrayNode2);
            } else if (arrayNode2 != null && arrayNode2.e() > 0) {
                jsonNode = arrayNode2.a(0);
            }
            Integer num = (Integer) view.getTag(2131558537);
            if (!(num == null || map == null)) {
                map.put("item_index", num);
            }
            GraphQLLinkTargetStoreData graphQLLinkTargetStoreData = (GraphQLLinkTargetStoreData) view.getTag(2131558539);
            if (graphQLLinkTargetStoreData != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putBoolean("show_beeper", graphQLLinkTargetStoreData.k());
            }
            NativeAppDetails nativeAppDetails = (NativeAppDetails) view.getTag(2131558540);
            if (nativeAppDetails != null) {
                nativeAppDetails.r = bundle2;
                nativeAppDetails.s = map;
            }
            if (NativeThirdPartyUriHelper.a(str)) {
                Builder f = NativeUri.f();
                f.a = str;
                f = f;
                f.d = nativeAppDetails;
                Builder a = f.a(map);
                a.b = bundle2;
                a = a;
                a.e = "NEWSFEED";
                this.f3675b.a(view.getContext(), a.a());
            } else if (!this.f3675b.a(view.getContext(), str, bundle2, map)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (str.startsWith("http://maps.google.com")) {
                    intent.putExtra("com.facebook.intent.extra.SKIP_IN_APP_BROWSER", true);
                }
                intent.setData(Uri.parse(str));
                m4384a(view.getContext(), intent, str);
            }
            if (honeyClientEvent != null) {
                if (!TrackingNodes.a(honeyClientEvent)) {
                    TrackingNodes.a(honeyClientEvent, view);
                }
                this.f3676c.a(honeyClientEvent);
            }
            if (feedEvent != null) {
                this.f3678e.a(feedEvent);
            }
            if (jsonNode != null) {
                this.f3677d.a(jsonNode, str);
            }
        }
    }

    private void m4384a(Context context, Intent intent, String str) {
        if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
            this.f3679f.b(intent, context);
            return;
        }
        HoneyClientEventFast a = this.f3676c.a("external_activity_launch_failure", false);
        if (a.a()) {
            if (!TextUtils.isEmpty(str)) {
                a = a.a("url", str);
            }
            a.b();
        }
    }
}
