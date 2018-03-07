package com.facebook.feedplugins.attachments.video;

import android.text.TextUtils;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.video.util.RichVideoPlayerParamsUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideoChannel;
import com.facebook.inject.InjectorLike;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.channelfeed.abtest.ChannelFeedConfig;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetch_payment_account_enabled_status */
public class ChannelFeedEligibilityUtil {
    private static final Map<FeedListName, EntryPointInputVideoChannelEntryPoint> f23985d = new Builder().m609b(FeedListName.FEED, EntryPointInputVideoChannelEntryPoint.NEWSFEED).m609b(FeedListName.PAGE_TIMELINE, EntryPointInputVideoChannelEntryPoint.PAGE).m609b(FeedListName.MY_TIMELINE, EntryPointInputVideoChannelEntryPoint.PROFILE).m609b(FeedListName.OTHER_PERSON_TIMELINE, EntryPointInputVideoChannelEntryPoint.PROFILE).m609b(FeedListName.GROUPS, EntryPointInputVideoChannelEntryPoint.GROUP).m609b(FeedListName.PERMALINK, EntryPointInputVideoChannelEntryPoint.NEWSFEED).m609b(FeedListName.VIDEO_HOME, EntryPointInputVideoChannelEntryPoint.VIDEO_HOME).m609b(FeedListName.SEARCH_RESULTS, EntryPointInputVideoChannelEntryPoint.SEARCH).m610b();
    private static volatile ChannelFeedEligibilityUtil f23986e;
    private final ChannelFeedConfig f23987a;
    public final boolean f23988b;
    private final Video360PlayerConfig f23989c;

    public static com.facebook.feedplugins.attachments.video.ChannelFeedEligibilityUtil m32392a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23986e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.attachments.video.ChannelFeedEligibilityUtil.class;
        monitor-enter(r1);
        r0 = f23986e;	 Catch:{ all -> 0x003a }
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
        r0 = m32394b(r0);	 Catch:{ all -> 0x0035 }
        f23986e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23986e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.attachments.video.ChannelFeedEligibilityUtil.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.attachments.video.ChannelFeedEligibilityUtil");
    }

    private static ChannelFeedEligibilityUtil m32394b(InjectorLike injectorLike) {
        return new ChannelFeedEligibilityUtil(ChannelFeedConfig.m10184a(injectorLike), Video360PlayerConfig.m26762b(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public ChannelFeedEligibilityUtil(ChannelFeedConfig channelFeedConfig, Video360PlayerConfig video360PlayerConfig, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f23987a = channelFeedConfig;
        this.f23989c = video360PlayerConfig;
        this.f23988b = gatekeeperStoreImpl.m2189a(473, false);
    }

    public final ChannelEligibility m32395a(FeedProps<GraphQLStoryAttachment> feedProps, FeedListName feedListName) {
        if (!this.f23987a.f6034a) {
            return ChannelEligibility.CHANNEL_DISABLED;
        }
        GraphQLMedia r = ((GraphQLStoryAttachment) feedProps.f13444a).m23979r();
        if (r != null && r.m24453j().m22301g() == 82650203 && (!r.al() || feedListName == FeedListName.VIDEO_HOME)) {
            Object obj;
            if (this.f23988b && RichVideoPlayerParamsUtil.a(r)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null && !(r.ap() && this.f23989c.f19045q)) {
                FeedProps e = AttachmentProps.m28715e(feedProps);
                if (e != null && StoryProps.m27466p(e)) {
                    return ChannelEligibility.SPONSORED_VIDEO;
                }
                if (!f23985d.containsKey(feedListName)) {
                    return ChannelEligibility.UNSUPPORTED_LOCATION;
                }
                if (this.f23987a.f6043j) {
                    GraphQLVideoChannel bm = r.bm();
                    if (bm == null || TextUtils.isEmpty(bm.m24939k())) {
                        return ChannelEligibility.NO_RELATED;
                    }
                }
                return ChannelEligibility.ELIGIBLE;
            }
        }
        return ChannelEligibility.WRONG_STORY_TYPE;
    }

    @Nullable
    public static EntryPointInputVideoChannelEntryPoint m32393a(FeedListName feedListName) {
        return (EntryPointInputVideoChannelEntryPoint) f23985d.get(feedListName);
    }
}
