package com.facebook.nearby.v2.resultlist.util;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.nearby.v2.logging.NearbyPlacesSessionProvider;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.AddressModel;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.perflog.ReactionPerfLogger;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.timeline.intent.ModelBundle;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: date_info */
public final class NearbyPlacesV2PageActionHandler {
    private static volatile NearbyPlacesV2PageActionHandler f15871i;
    private final Clock f15872a;
    private final ReactionIntentFactory f15873b;
    private final FbUriIntentHandler f15874c;
    private final MediaGalleryLauncher f15875d;
    private final MediaGalleryLauncherParamsFactory f15876e;
    private final Lazy<ReactionPerfLogger> f15877f;
    private final SecureContextHelper f15878g;
    private final Provider<SearchResultsIntentBuilder> f15879h;

    public static com.facebook.nearby.v2.resultlist.util.NearbyPlacesV2PageActionHandler m18723a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15871i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.nearby.v2.resultlist.util.NearbyPlacesV2PageActionHandler.class;
        monitor-enter(r1);
        r0 = f15871i;	 Catch:{ all -> 0x003a }
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
        r0 = m18727b(r0);	 Catch:{ all -> 0x0035 }
        f15871i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15871i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.nearby.v2.resultlist.util.NearbyPlacesV2PageActionHandler.a(com.facebook.inject.InjectorLike):com.facebook.nearby.v2.resultlist.util.NearbyPlacesV2PageActionHandler");
    }

    private static NearbyPlacesV2PageActionHandler m18727b(InjectorLike injectorLike) {
        return new NearbyPlacesV2PageActionHandler((Clock) SystemClockMethodAutoProvider.a(injectorLike), FbUriIntentHandler.a(injectorLike), (MediaGalleryLauncher) DefaultMediaGalleryLauncher.m2459a(injectorLike), MediaGalleryLauncherParamsFactory.a(injectorLike), ReactionIntentFactory.m22683a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3255), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3375));
    }

    @Inject
    public NearbyPlacesV2PageActionHandler(Clock clock, FbUriIntentHandler fbUriIntentHandler, MediaGalleryLauncher mediaGalleryLauncher, MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory, ReactionIntentFactory reactionIntentFactory, Lazy<ReactionPerfLogger> lazy, SecureContextHelper secureContextHelper, Provider<SearchResultsIntentBuilder> provider) {
        this.f15872a = clock;
        this.f15874c = fbUriIntentHandler;
        this.f15875d = mediaGalleryLauncher;
        this.f15876e = mediaGalleryLauncherParamsFactory;
        this.f15873b = reactionIntentFactory;
        this.f15877f = lazy;
        this.f15878g = secureContextHelper;
        this.f15879h = provider;
    }

    public final void m18728a(Context context, NearbyPlacesPlaceModel nearbyPlacesPlaceModel, @Nullable Location location, @Nullable NearbyPlacesSessionProvider nearbyPlacesSessionProvider, Fragment fragment, Class<?> cls) {
        if (nearbyPlacesSessionProvider == null || nearbyPlacesSessionProvider.f15299a == null || nearbyPlacesSessionProvider.f15299a.f15294d == null) {
            m18725a(nearbyPlacesPlaceModel, location, context, (Class) cls);
        } else {
            m18726a(nearbyPlacesPlaceModel, nearbyPlacesSessionProvider.f15299a.f15294d, fragment);
        }
    }

    private void m18725a(NearbyPlacesPlaceModel nearbyPlacesPlaceModel, Location location, Context context, Class<?> cls) {
        Preconditions.checkNotNull(nearbyPlacesPlaceModel);
        String b = nearbyPlacesPlaceModel.m17738b();
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.af, b);
        SecureHashUtil.b(b + this.f15872a.a());
        Bundle bundle = new Bundle();
        ModelBundle.b(bundle, b, nearbyPlacesPlaceModel.m17737a(), nearbyPlacesPlaceModel.m17740d().m17807d());
        bundle.putParcelable("extra_user_location", location);
        m18724a(context, formatStrLocaleSafe, bundle, (Class) cls);
    }

    private void m18726a(NearbyPlacesPlaceModel nearbyPlacesPlaceModel, SearchResultsMutableContext searchResultsMutableContext, Fragment fragment) {
        ReactionPerfLogger reactionPerfLogger = (ReactionPerfLogger) this.f15877f.get();
        String uuid = SafeUUIDGenerator.a().toString();
        Surface surface = Surface.ANDROID_SEARCH_LOCAL_PLACES_TAB;
        reactionPerfLogger.b(1966082, uuid, surface);
        reactionPerfLogger.a(1966090, uuid, surface);
        this.f15878g.a(((SearchResultsIntentBuilder) this.f15879h.get()).b(nearbyPlacesPlaceModel.m17738b(), nearbyPlacesPlaceModel.m17737a(), uuid, searchResultsMutableContext.f23367b, surface, searchResultsMutableContext.f23369d), 11111, fragment);
    }

    public final void m18730a(ImmutableList<String> immutableList, String str, Context context) {
        Preconditions.checkArgument(!TextUtils.isEmpty(str));
        Preconditions.checkNotNull(context);
        Builder a = MediaGalleryLauncherParamsFactory.f(immutableList).a(str);
        a.m = true;
        this.f15875d.a(context, a.a(FullscreenGallerySource.NEARBYPLACES).b(), null);
    }

    public final void m18732a(String str, String str2, Context context, String str3) {
        this.f15878g.a(this.f15873b.m22765c(context, str3, str, str2).f18831d, context);
    }

    public final void m18731a(String str, Context context, Class<?> cls) {
        Preconditions.checkArgument(!StringUtil.a(str));
        SecureHashUtil.b(str + this.f15872a.a());
        m18724a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.am, str), new Bundle(), (Class) cls);
    }

    public final void m18729a(NearbyPlacesPlaceModel nearbyPlacesPlaceModel, Context context, Class<?> cls) {
        Preconditions.checkNotNull(nearbyPlacesPlaceModel);
        Object b = nearbyPlacesPlaceModel.m17738b();
        Preconditions.checkArgument(!StringUtil.a(b));
        Bundle bundle = new Bundle();
        bundle.putLong("com.facebook.katana.profile.id", Long.parseLong(b));
        bundle.putString("profile_name", nearbyPlacesPlaceModel.m17737a());
        m18724a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.dx, b), bundle, (Class) cls);
    }

    public final void m18733b(NearbyPlacesPlaceModel nearbyPlacesPlaceModel, Context context, Class<?> cls) {
        Preconditions.checkNotNull(nearbyPlacesPlaceModel);
        Location f = nearbyPlacesPlaceModel.m17742f();
        Preconditions.checkNotNull(f);
        Bundle bundle = new Bundle();
        bundle.putString("place_name", nearbyPlacesPlaceModel.m17737a());
        bundle.putDouble("latitude", f.getLatitude());
        bundle.putDouble("longitude", f.getLongitude());
        bundle.putFloat("zoom", 15.0f);
        AddressModel c = nearbyPlacesPlaceModel.m17739c();
        if (!(c == null || c.m17838b() == null || c.m17837a() == null)) {
            bundle.putString("address", StringFormatUtil.formatStrLocaleSafe(context.getResources().getString(2131236707), c.m17838b(), c.m17837a()));
        }
        m18724a(context, FBLinks.eP, bundle, (Class) cls);
    }

    private void m18724a(Context context, String str, Bundle bundle, Class<?> cls) {
        boolean z;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(cls);
        if (StringUtil.a(str)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (!this.f15874c.a(context, str, bundle)) {
            BLog.b(cls, "Failed navigating to url = %s ", new Object[]{str});
        }
    }
}
