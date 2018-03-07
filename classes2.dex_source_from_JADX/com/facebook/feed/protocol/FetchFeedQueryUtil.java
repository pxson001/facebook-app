package com.facebook.feed.protocol;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feedcache.db.CacheStoriesRange;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.hardware.BatteryStateManager$ChargeState;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.location.FbLocationCache;
import com.facebook.location.LocationAgeUtil;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.StringWriter;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: rm */
public class FetchFeedQueryUtil {
    private static volatile FetchFeedQueryUtil f6576i;
    private final GraphQLStoryHelper f6577a;
    private final GraphQLImageHelper f6578b;
    private final SizeAwareImageUtil f6579c;
    private final CacheStoriesRange f6580d;
    public final Lazy<AppStateManager> f6581e;
    public final Lazy<FbLocationCache> f6582f;
    public final Lazy<LocationAgeUtil> f6583g;
    private final QeAccessor f6584h;

    /* compiled from: rm */
    /* synthetic */ class C02971 {
        static final /* synthetic */ int[] f6741a = new int[BatteryStateManager$ChargeState.values().length];

        static {
            try {
                f6741a[BatteryStateManager$ChargeState.CHARGING_USB.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6741a[BatteryStateManager$ChargeState.CHARGING_AC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6741a[BatteryStateManager$ChargeState.CHARGING_WIRELESS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static com.facebook.feed.protocol.FetchFeedQueryUtil m11402a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6576i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.protocol.FetchFeedQueryUtil.class;
        monitor-enter(r1);
        r0 = f6576i;	 Catch:{ all -> 0x003a }
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
        r0 = m11407b(r0);	 Catch:{ all -> 0x0035 }
        f6576i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6576i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.protocol.FetchFeedQueryUtil.a(com.facebook.inject.InjectorLike):com.facebook.feed.protocol.FetchFeedQueryUtil");
    }

    private static FetchFeedQueryUtil m11407b(InjectorLike injectorLike) {
        return new FetchFeedQueryUtil(GraphQLStoryHelper.m10197a(injectorLike), GraphQLImageHelper.m10139a(injectorLike), SizeAwareImageUtil.m10234a(injectorLike), CacheStoriesRange.m11415a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 476), IdBasedLazy.m1808a(injectorLike, 2478), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2487), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public FetchFeedQueryUtil(GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, SizeAwareImageUtil sizeAwareImageUtil, CacheStoriesRange cacheStoriesRange, Lazy<AppStateManager> lazy, Lazy<FbLocationCache> lazy2, Lazy<LocationAgeUtil> lazy3, QeAccessor qeAccessor) {
        this.f6577a = graphQLStoryHelper;
        this.f6578b = graphQLImageHelper;
        this.f6579c = sizeAwareImageUtil;
        this.f6580d = cacheStoriesRange;
        this.f6582f = lazy2;
        this.f6581e = lazy;
        this.f6583g = lazy3;
        this.f6584h = qeAccessor;
    }

    public final GraphQlQueryString m11409a(GraphQlQueryString graphQlQueryString) {
        graphQlQueryString.m11314a("profile_image_size", GraphQLStoryHelper.m10198a());
        graphQlQueryString.m11315a("action_location", NegativeFeedbackExperienceLocation.NEWSFEED.stringValueOf());
        return graphQlQueryString;
    }

    public final GraphQlQueryString m11410a(GraphQlQueryString graphQlQueryString, @Nullable FetchFeedParams fetchFeedParams, String str) {
        if (!(fetchFeedParams == null || fetchFeedParams.f5786d == null || fetchFeedParams.f5787e != null)) {
            CacheStoriesRange cacheStoriesRange = this.f6580d;
            String str2 = fetchFeedParams.f5786d;
            FeedType feedType = fetchFeedParams.f5784b;
            String str3 = null;
            if (cacheStoriesRange.f6587b.mo596a(ExperimentsForNewsFeedAbTestModule.f5098Y, false)) {
                String a = cacheStoriesRange.f6586a.m9162a(str2, feedType);
                if (a != null) {
                    a = cacheStoriesRange.f6586a.m9171b(feedType, a);
                } else {
                    a = null;
                }
                if (a == null) {
                    a = cacheStoriesRange.f6586a.m9183g(feedType);
                }
                if (a != null) {
                    ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
                    objectNode.m5137a("start_cursor", str2);
                    objectNode.m5137a("end_cursor", a);
                    str3 = objectNode.toString();
                }
            }
            graphQlQueryString.m11315a(str, str3);
        }
        return graphQlQueryString;
    }

    public static GraphQlQueryString m11404a(GraphQlQueryString graphQlQueryString, SystemBatteryStateManager systemBatteryStateManager) {
        BatteryStateManager$ChargeState b = systemBatteryStateManager.m11468b();
        float a = systemBatteryStateManager.m11465a();
        if (!(b == BatteryStateManager$ChargeState.UNKNOWN && a == -1.0f)) {
            StringWriter stringWriter = new StringWriter(40);
            stringWriter.write(123);
            if (b != BatteryStateManager$ChargeState.UNKNOWN) {
                Object obj = null;
                switch (C02971.f6741a[b.ordinal()]) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    case 3:
                        obj = 1;
                        break;
                }
                stringWriter.write("is_charging:");
                stringWriter.write(obj != null ? "\"true\"" : "\"false\"");
            }
            if (a != -1.0f) {
                if (b != BatteryStateManager$ChargeState.UNKNOWN) {
                    stringWriter.write(44);
                }
                stringWriter.write("battery_level:");
                stringWriter.write(String.valueOf((int) (100.0f * a)));
            }
            stringWriter.append('}');
            graphQlQueryString.m11315a("battery_context", stringWriter.toString());
        }
        return graphQlQueryString;
    }

    public static GraphQlQueryString m11406a(GraphQlQueryString graphQlQueryString, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        graphQlQueryString.m11315a("device_id", uniqueIdForDeviceHolderImpl.m4346a());
        return graphQlQueryString;
    }

    public static GraphQlQueryString m11405a(GraphQlQueryString graphQlQueryString, FbDataConnectionManager fbDataConnectionManager) {
        ConnectionQuality c = fbDataConnectionManager.m3801c();
        if (!ConnectionQuality.UNKNOWN.equals(c)) {
            graphQlQueryString.m11315a("connection_class", c.toString());
        }
        return graphQlQueryString;
    }

    public static GraphQlQueryString m11403a(GraphQlQueryString graphQlQueryString, @Nullable FetchFeedParams fetchFeedParams, String str, String str2) {
        if (fetchFeedParams.f5786d != null) {
            graphQlQueryString.m11315a(str, fetchFeedParams.f5786d);
        }
        if (fetchFeedParams.f5787e != null) {
            graphQlQueryString.m11315a(str2, fetchFeedParams.f5787e);
        }
        return graphQlQueryString;
    }

    public final GraphQlQueryString m11411b(GraphQlQueryString graphQlQueryString) {
        this.f6579c.m10238a(graphQlQueryString, this.f6578b.m10146c());
        graphQlQueryString.m11314a("image_large_aspect_height", this.f6577a.m10231z());
        graphQlQueryString.m11314a("image_large_aspect_width", this.f6577a.m10230y());
        return graphQlQueryString;
    }

    public final GraphQlQueryString m11412c(GraphQlQueryString graphQlQueryString) {
        graphQlQueryString.m11314a("angora_attachment_cover_image_size", this.f6577a.m10223r());
        graphQlQueryString.m11314a("angora_attachment_profile_image_size", this.f6577a.m10224s());
        graphQlQueryString.m11314a("reading_attachment_profile_image_width", this.f6577a.m10213L()).m11314a("reading_attachment_profile_image_height", this.f6577a.m10214M());
        graphQlQueryString.m11314a("question_poll_count", GraphQLStoryHelper.f6084c).m11314a("poll_voters_count", GraphQLStoryHelper.f6085d).m11314a("poll_facepile_size", this.f6577a.m10215P());
        return graphQlQueryString;
    }

    public static GraphQlQueryString m11408d(GraphQlQueryString graphQlQueryString) {
        Enum a = GraphQlQueryDefaults.m11417a();
        String str = "default_image_scale";
        if (a == null) {
            a = GraphQlQueryDefaults.f6588a;
        }
        graphQlQueryString.m11313a(str, a);
        return graphQlQueryString;
    }

    public final GraphQlQueryString m11413e(GraphQlQueryString graphQlQueryString) {
        graphQlQueryString.m11312a("with_actor_profile_video_playback", Boolean.valueOf(this.f6584h.mo596a(ExperimentsForTimelineAbTestModule.aN, false)));
        return graphQlQueryString;
    }

    public final GraphQlQueryString m11414g(GraphQlQueryString graphQlQueryString) {
        boolean z = false;
        boolean a = this.f6584h.mo596a(ExperimentsForNewsFeedAbTestModule.f5119t, false);
        graphQlQueryString.m11312a("include_feedback_to_prefetch", Boolean.valueOf(a));
        String str = "include_read_likelihood";
        if (!a) {
            z = true;
        }
        graphQlQueryString.m11312a(str, Boolean.valueOf(z));
        return graphQlQueryString;
    }
}
