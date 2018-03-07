package com.facebook.tablet.sideshow.pyml;

import android.content.Context;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.RawLikeHelper;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.facebook.tablet.sideshow.SideshowHost.HostInterfaceImpl;
import com.facebook.tablet.sideshow.SideshowUnit;
import com.facebook.tablet.sideshow.SideshowUnitType;
import com.facebook.tablet.sideshow.analytics.SideshowAnalyticsLogger;
import com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowDataRequest;
import com.facebook.tablet.sideshow.pyml.ui.PagesYouMayLikeListAdapter;
import com.facebook.tablet.sideshow.widget.SideshowUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: onBlurCapture */
public class PagesYouMayLikeSideshowUnitType implements SideshowUnitType {
    private static final ContentFragmentType[] f4802j = new ContentFragmentType[]{ContentFragmentType.NATIVE_NEWS_FEED_FRAGMENT, ContentFragmentType.SEARCH_FRAGMENT, ContentFragmentType.GROUP_ALBUM_FRAGMENT, ContentFragmentType.FRIEND_REQUESTS_FRAGMENT, ContentFragmentType.NOTIFICATIONS_FRAGMENT, ContentFragmentType.NOTIFICATIONS_FRIENDING_FRAGMENT, ContentFragmentType.THROWBACK_FEED_FRAGMENT};
    private static final Set<ContentFragmentType> f4803k = new HashSet(Arrays.asList(f4802j));
    private static volatile PagesYouMayLikeSideshowUnitType f4804l;
    private PagesYouMayLikeListAdapter f4805a;
    private FetchPagesYouMayLikeSideshowDataRequest f4806b;
    private TabletExperimentConfiguration f4807c;
    private SideshowAnalyticsLogger f4808d;
    private SecureContextHelper f4809e;
    private UriIntentMapper f4810f;
    private FeedEventBus f4811g;
    private RawLikeHelper f4812h;
    private SideshowUtils f4813i;

    public static com.facebook.tablet.sideshow.pyml.PagesYouMayLikeSideshowUnitType m5992a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4804l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.tablet.sideshow.pyml.PagesYouMayLikeSideshowUnitType.class;
        monitor-enter(r1);
        r0 = f4804l;	 Catch:{ all -> 0x003a }
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
        r0 = m5993b(r0);	 Catch:{ all -> 0x0035 }
        f4804l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4804l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tablet.sideshow.pyml.PagesYouMayLikeSideshowUnitType.a(com.facebook.inject.InjectorLike):com.facebook.tablet.sideshow.pyml.PagesYouMayLikeSideshowUnitType");
    }

    private static PagesYouMayLikeSideshowUnitType m5993b(InjectorLike injectorLike) {
        return new PagesYouMayLikeSideshowUnitType(new PagesYouMayLikeListAdapter((Context) injectorLike.getInstance(Context.class), FeedEventBus.a(injectorLike)), FetchPagesYouMayLikeSideshowDataRequest.m5997a(injectorLike), TabletExperimentConfiguration.a(injectorLike), SideshowAnalyticsLogger.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), FeedEventBus.a(injectorLike), RawLikeHelper.b(injectorLike), SideshowUtils.b(injectorLike));
    }

    @Inject
    public PagesYouMayLikeSideshowUnitType(PagesYouMayLikeListAdapter pagesYouMayLikeListAdapter, FetchPagesYouMayLikeSideshowDataRequest fetchPagesYouMayLikeSideshowDataRequest, TabletExperimentConfiguration tabletExperimentConfiguration, SideshowAnalyticsLogger sideshowAnalyticsLogger, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, FeedEventBus feedEventBus, RawLikeHelper rawLikeHelper, SideshowUtils sideshowUtils) {
        this.f4805a = pagesYouMayLikeListAdapter;
        this.f4806b = fetchPagesYouMayLikeSideshowDataRequest;
        this.f4807c = tabletExperimentConfiguration;
        this.f4808d = sideshowAnalyticsLogger;
        this.f4809e = secureContextHelper;
        this.f4810f = uriIntentMapper;
        this.f4811g = feedEventBus;
        this.f4812h = rawLikeHelper;
        this.f4813i = sideshowUtils;
    }

    public final int m5994a(ContentFragmentType contentFragmentType) {
        if (!this.f4807c.e() || f4803k.contains(contentFragmentType)) {
            return 0;
        }
        return 3;
    }

    public final SideshowUnit m5995a(HostInterfaceImpl hostInterfaceImpl) {
        return new PagesYouMayLikeSideshowUnit(this.f4805a, this.f4806b, this.f4808d, this.f4809e, this.f4810f, this.f4811g, this.f4812h, this.f4813i);
    }
}
