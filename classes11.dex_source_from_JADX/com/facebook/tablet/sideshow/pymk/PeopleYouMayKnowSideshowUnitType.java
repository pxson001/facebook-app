package com.facebook.tablet.sideshow.pymk;

import android.content.Context;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.friends.FriendingClient;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.facebook.tablet.sideshow.SideshowHost.HostInterfaceImpl;
import com.facebook.tablet.sideshow.SideshowUnit;
import com.facebook.tablet.sideshow.SideshowUnitType;
import com.facebook.tablet.sideshow.analytics.SideshowAnalyticsLogger;
import com.facebook.tablet.sideshow.pymk.graphql.FetchPeopleYouMayKnowSideshowDataRequest;
import com.facebook.tablet.sideshow.pymk.ui.PeopleYouMayKnowListAdapter;
import com.facebook.tablet.sideshow.widget.SideshowUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: onLoad */
public class PeopleYouMayKnowSideshowUnitType implements SideshowUnitType {
    private static final ContentFragmentType[] f4733l = new ContentFragmentType[]{ContentFragmentType.NATIVE_NEWS_FEED_FRAGMENT, ContentFragmentType.SEARCH_FRAGMENT, ContentFragmentType.GROUP_ALBUM_FRAGMENT, ContentFragmentType.FRIEND_REQUESTS_FRAGMENT, ContentFragmentType.NOTIFICATIONS_FRAGMENT, ContentFragmentType.NOTIFICATIONS_FRIENDING_FRAGMENT, ContentFragmentType.THROWBACK_FEED_FRAGMENT};
    private static final Set<ContentFragmentType> f4734m = new HashSet(Arrays.asList(f4733l));
    private static volatile PeopleYouMayKnowSideshowUnitType f4735n;
    private PeopleYouMayKnowListAdapter f4736a;
    private FetchPeopleYouMayKnowSideshowDataRequest f4737b;
    private TabletExperimentConfiguration f4738c;
    private SideshowAnalyticsLogger f4739d;
    private SideshowUtils f4740e;
    private SecureContextHelper f4741f;
    private UriIntentMapper f4742g;
    private FriendingClient f4743h;
    private FbEventSubscriberListManager f4744i;
    private FeedEventBus f4745j;
    private DefaultAndroidThreadUtil f4746k;

    public static com.facebook.tablet.sideshow.pymk.PeopleYouMayKnowSideshowUnitType m5913a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4735n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.tablet.sideshow.pymk.PeopleYouMayKnowSideshowUnitType.class;
        monitor-enter(r1);
        r0 = f4735n;	 Catch:{ all -> 0x003a }
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
        r0 = m5914b(r0);	 Catch:{ all -> 0x0035 }
        f4735n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4735n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tablet.sideshow.pymk.PeopleYouMayKnowSideshowUnitType.a(com.facebook.inject.InjectorLike):com.facebook.tablet.sideshow.pymk.PeopleYouMayKnowSideshowUnitType");
    }

    private static PeopleYouMayKnowSideshowUnitType m5914b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowSideshowUnitType(new PeopleYouMayKnowListAdapter((Context) injectorLike.getInstance(Context.class), FeedEventBus.a(injectorLike)), FetchPeopleYouMayKnowSideshowDataRequest.m5918a(injectorLike), TabletExperimentConfiguration.a(injectorLike), SideshowAnalyticsLogger.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), SideshowUtils.b(injectorLike), FriendingClient.b(injectorLike), FbEventSubscriberListManager.a(injectorLike), FeedEventBus.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public PeopleYouMayKnowSideshowUnitType(PeopleYouMayKnowListAdapter peopleYouMayKnowListAdapter, FetchPeopleYouMayKnowSideshowDataRequest fetchPeopleYouMayKnowSideshowDataRequest, TabletExperimentConfiguration tabletExperimentConfiguration, SideshowAnalyticsLogger sideshowAnalyticsLogger, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, SideshowUtils sideshowUtils, FriendingClient friendingClient, FbEventSubscriberListManager fbEventSubscriberListManager, FeedEventBus feedEventBus, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f4736a = peopleYouMayKnowListAdapter;
        this.f4737b = fetchPeopleYouMayKnowSideshowDataRequest;
        this.f4738c = tabletExperimentConfiguration;
        this.f4739d = sideshowAnalyticsLogger;
        this.f4741f = secureContextHelper;
        this.f4742g = uriIntentMapper;
        this.f4740e = sideshowUtils;
        this.f4743h = friendingClient;
        this.f4744i = fbEventSubscriberListManager;
        this.f4745j = feedEventBus;
        this.f4746k = defaultAndroidThreadUtil;
    }

    public final int m5915a(ContentFragmentType contentFragmentType) {
        if (!this.f4738c.e() || f4734m.contains(contentFragmentType)) {
            return 0;
        }
        return 3;
    }

    public final SideshowUnit m5916a(HostInterfaceImpl hostInterfaceImpl) {
        return new PeopleYouMayKnowSideshowUnit(this.f4736a, this.f4737b, this.f4739d, this.f4741f, this.f4742g, this.f4740e, this.f4743h, this.f4744i, this.f4745j, this.f4746k);
    }
}
