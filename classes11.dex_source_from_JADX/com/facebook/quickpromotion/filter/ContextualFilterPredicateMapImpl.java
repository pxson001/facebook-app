package com.facebook.quickpromotion.filter;

import com.facebook.contacts.promotion.qpfilter.CIContinuousSyncUserConsentFilterPredicate;
import com.facebook.contacts.promotion.qpfilter.CIUserConsentFilterPredicate;
import com.facebook.dialtone.filter.DialtoneActiveFilterPredicate;
import com.facebook.dialtone.filter.DialtoneAvailableFilterPredicate;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.HasUnreadMessagesFilterPredicate;
import com.facebook.messaging.bannertriggers.OmnistoreKeyJustWrittenFilterPredicate;
import com.facebook.messaging.quickpromotion.ClockSkewBannerEligibleFilterPredicate;
import com.facebook.messaging.quickpromotion.ContactLogsUploadFilterPredicate;
import com.facebook.messaging.quickpromotion.ContactsUploadEnabledFilterPredicate;
import com.facebook.messaging.quickpromotion.HasMadeRtcCallContextualFilterPredicate;
import com.facebook.messaging.quickpromotion.HasNoProfilePicturePredicate;
import com.facebook.messaging.quickpromotion.PhotoRemindersEverEnabledFilterPredicate;
import com.facebook.messaging.quickpromotion.PhotoRemindersNuxEligibleFilterPredicate;
import com.facebook.messaging.quickpromotion.SmsTakeoverDelayedReadOnlyThreadViewBannerEligibleFilterPredicate;
import com.facebook.messaging.quickpromotion.SmsTakeoverFullThreadViewBannerEligibleFilterPredicate;
import com.facebook.messaging.quickpromotion.SmsTakeoverRecentReadOnlyThreadViewBannerEligibleFilterPredicate;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter.Type;
import com.facebook.timeline.profilevideo.qp.filter.ProfileVideoCannotCreateFilter;
import com.facebook.timeline.profilevideo.qp.filter.ProfileVideoCannotViewFilter;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: ST */
public class ContextualFilterPredicateMapImpl implements ContextualFilterPredicateMap {
    private static volatile ContextualFilterPredicateMapImpl ab;
    @Inject
    volatile Provider<DirectInstallEnabledFilterPredicate> f11294A = UltralightRuntime.a;
    @Inject
    volatile Provider<BatteryLowContextualFilterPredicate> f11295B = UltralightRuntime.a;
    @Inject
    volatile Provider<AssetsReadyFilter> f11296C = UltralightRuntime.a;
    @Inject
    volatile Provider<ApplicationMinVersionFilterPredicate> f11297D = UltralightRuntime.a;
    @Inject
    volatile Provider<ApplicationMaxVersionFilterPredicate> f11298E = UltralightRuntime.a;
    @Inject
    volatile Provider<ApplicationMaxStorageSpaceFilterPredicate> f11299F = UltralightRuntime.a;
    @Inject
    volatile Provider<ApplicationInstallSpaceFilterPredicate> f11300G = UltralightRuntime.a;
    @Inject
    volatile Provider<AppNotInstalledFilterPredicate> f11301H = UltralightRuntime.a;
    @Inject
    volatile Provider<AppInstalledFilterPredicate> f11302I = UltralightRuntime.a;
    @Inject
    volatile Provider<AndroidPermissionsAnyDisabledFilterPredicate> f11303J = UltralightRuntime.a;
    @Inject
    volatile Provider<AggregateImpressionsFilterPredicate> f11304K = UltralightRuntime.a;
    @Inject
    volatile Provider<SmsTakeoverRecentReadOnlyThreadViewBannerEligibleFilterPredicate> f11305L = UltralightRuntime.a;
    @Inject
    volatile Provider<SmsTakeoverFullThreadViewBannerEligibleFilterPredicate> f11306M = UltralightRuntime.a;
    @Inject
    volatile Provider<SmsTakeoverDelayedReadOnlyThreadViewBannerEligibleFilterPredicate> f11307N = UltralightRuntime.a;
    @Inject
    volatile Provider<PhotoRemindersNuxEligibleFilterPredicate> f11308O = UltralightRuntime.a;
    @Inject
    volatile Provider<PhotoRemindersEverEnabledFilterPredicate> f11309P = UltralightRuntime.a;
    @Inject
    volatile Provider<HasNoProfilePicturePredicate> f11310Q = UltralightRuntime.a;
    @Inject
    volatile Provider<HasMadeRtcCallContextualFilterPredicate> f11311R = UltralightRuntime.a;
    @Inject
    volatile Provider<ContactsUploadEnabledFilterPredicate> f11312S = UltralightRuntime.a;
    @Inject
    volatile Provider<ContactLogsUploadFilterPredicate> f11313T = UltralightRuntime.a;
    @Inject
    volatile Provider<ClockSkewBannerEligibleFilterPredicate> f11314U = UltralightRuntime.a;
    @Inject
    volatile Provider<OmnistoreKeyJustWrittenFilterPredicate> f11315V = UltralightRuntime.a;
    @Inject
    volatile Provider<HasUnreadMessagesFilterPredicate> f11316W = UltralightRuntime.a;
    @Inject
    volatile Provider<DialtoneAvailableFilterPredicate> f11317X = UltralightRuntime.a;
    @Inject
    volatile Provider<DialtoneActiveFilterPredicate> f11318Y = UltralightRuntime.a;
    @Inject
    volatile Provider<CIUserConsentFilterPredicate> f11319Z = UltralightRuntime.a;
    @Inject
    volatile Provider<ProfileVideoCannotViewFilter> f11320a = UltralightRuntime.a;
    @Inject
    volatile Provider<CIContinuousSyncUserConsentFilterPredicate> aa = UltralightRuntime.a;
    @Inject
    volatile Provider<ProfileVideoCannotCreateFilter> f11321b = UltralightRuntime.a;
    @Inject
    volatile Provider<WifiConnectedContextualFilterPredicate> f11322c = UltralightRuntime.a;
    @Inject
    volatile Provider<UserRankContextualFilterPredicate> f11323d = UltralightRuntime.a;
    @Inject
    volatile Provider<UnknownContextualFilterPredicate> f11324e = UltralightRuntime.a;
    @Inject
    volatile Provider<TimeSinceImpressionFilter> f11325f = UltralightRuntime.a;
    @Inject
    volatile Provider<TimeSinceForegroundFilterPredicate> f11326g = UltralightRuntime.a;
    @Inject
    volatile Provider<TimeSinceDismissFilter> f11327h = UltralightRuntime.a;
    @Inject
    volatile Provider<TimeOfDayBeforeFilterPredicate> f11328i = UltralightRuntime.a;
    @Inject
    volatile Provider<TimeOfDayAfterFilterPredicate> f11329j = UltralightRuntime.a;
    @Inject
    volatile Provider<SecondsSinceMeteredConnectionChangedFilter> f11330k = UltralightRuntime.a;
    @Inject
    volatile Provider<SecondsSinceMessageSentPredicate> f11331l = UltralightRuntime.a;
    @Inject
    volatile Provider<SecondsSinceMessageReceivedPredicate> f11332m = UltralightRuntime.a;
    @Inject
    volatile Provider<RtcPresenceContextualFilterPredicate> f11333n = UltralightRuntime.a;
    @Inject
    volatile Provider<PreInstalledContextualFilterPredicate> f11334o = UltralightRuntime.a;
    @Inject
    volatile Provider<OtherPromotionEventFilterPredicate> f11335p = UltralightRuntime.a;
    @Inject
    volatile Provider<NetworkConnectivityFilterPredicate> f11336q = UltralightRuntime.a;
    @Inject
    volatile Provider<MobileNetworkAvailableFilterPredicate> f11337r = UltralightRuntime.a;
    @Inject
    volatile Provider<MessengerInstalledContextualFilterPredicate> f11338s = UltralightRuntime.a;
    @Inject
    volatile Provider<MessagesSentOneAfterTheOtherPredicate> f11339t = UltralightRuntime.a;
    @Inject
    volatile Provider<ManualNewsfeedRefreshFilterPredicate> f11340u = UltralightRuntime.a;
    @Inject
    volatile Provider<LocaleFilterPredicate> f11341v = UltralightRuntime.a;
    @Inject
    volatile Provider<IsOtherBirthdayContextualFilterPredicate> f11342w = UltralightRuntime.a;
    @Inject
    volatile Provider<IsMeteredConnectionFilter> f11343x = UltralightRuntime.a;
    @Inject
    volatile Provider<GooglePlayContextualFilterPredicate> f11344y = UltralightRuntime.a;
    @Inject
    volatile Provider<GoogleAccountContextualFilterPredicate> f11345z = UltralightRuntime.a;

    public static com.facebook.quickpromotion.filter.ContextualFilterPredicateMapImpl m11668a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = ab;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quickpromotion.filter.ContextualFilterPredicateMapImpl.class;
        monitor-enter(r1);
        r0 = ab;	 Catch:{ all -> 0x003a }
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
        r0 = m11670b(r0);	 Catch:{ all -> 0x0035 }
        ab = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = ab;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.filter.ContextualFilterPredicateMapImpl.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.filter.ContextualFilterPredicateMapImpl");
    }

    private static ContextualFilterPredicateMapImpl m11670b(InjectorLike injectorLike) {
        ContextualFilterPredicateMapImpl contextualFilterPredicateMapImpl = new ContextualFilterPredicateMapImpl();
        contextualFilterPredicateMapImpl.m11669a(IdBasedProvider.a(injectorLike, 11315), IdBasedProvider.a(injectorLike, 11314), IdBasedProvider.a(injectorLike, 9818), IdBasedProvider.a(injectorLike, 9817), IdBasedProvider.a(injectorLike, 9816), IdBasedProvider.a(injectorLike, 9815), IdBasedProvider.a(injectorLike, 9814), IdBasedProvider.a(injectorLike, 9813), IdBasedSingletonScopeProvider.a(injectorLike, 9812), IdBasedSingletonScopeProvider.a(injectorLike, 9811), IdBasedProvider.a(injectorLike, 9810), IdBasedSingletonScopeProvider.a(injectorLike, 9809), IdBasedSingletonScopeProvider.a(injectorLike, 9808), IdBasedProvider.a(injectorLike, 9807), IdBasedProvider.a(injectorLike, 9804), IdBasedProvider.a(injectorLike, 9803), IdBasedSingletonScopeProvider.a(injectorLike, 9802), IdBasedSingletonScopeProvider.a(injectorLike, 9801), IdBasedProvider.a(injectorLike, 9800), IdBasedSingletonScopeProvider.a(injectorLike, 9799), IdBasedSingletonScopeProvider.a(injectorLike, 9798), IdBasedSingletonScopeProvider.a(injectorLike, 9797), IdBasedProvider.a(injectorLike, 9796), IdBasedProvider.a(injectorLike, 9795), IdBasedProvider.a(injectorLike, 9794), IdBasedProvider.a(injectorLike, 9793), IdBasedProvider.a(injectorLike, 9790), IdBasedProvider.a(injectorLike, 9784), IdBasedProvider.a(injectorLike, 9783), IdBasedProvider.a(injectorLike, 9782), IdBasedProvider.a(injectorLike, 9781), IdBasedProvider.a(injectorLike, 9780), IdBasedProvider.a(injectorLike, 9779), IdBasedProvider.a(injectorLike, 9778), IdBasedProvider.a(injectorLike, 9777), IdBasedProvider.a(injectorLike, 9776), IdBasedProvider.a(injectorLike, 9775), IdBasedProvider.a(injectorLike, 8325), IdBasedProvider.a(injectorLike, 8324), IdBasedProvider.a(injectorLike, 8323), IdBasedProvider.a(injectorLike, 8319), IdBasedProvider.a(injectorLike, 8318), IdBasedProvider.a(injectorLike, 8316), IdBasedProvider.a(injectorLike, 8315), IdBasedProvider.a(injectorLike, 8314), IdBasedProvider.a(injectorLike, 8313), IdBasedProvider.a(injectorLike, 8312), IdBasedProvider.a(injectorLike, 7548), IdBasedProvider.a(injectorLike, 7340), IdBasedProvider.a(injectorLike, 5489), IdBasedProvider.a(injectorLike, 5488), IdBasedProvider.a(injectorLike, 5385), IdBasedProvider.a(injectorLike, 5384));
        return contextualFilterPredicateMapImpl;
    }

    private void m11669a(Provider<ProfileVideoCannotViewFilter> provider, Provider<ProfileVideoCannotCreateFilter> provider2, Provider<WifiConnectedContextualFilterPredicate> provider3, Provider<UserRankContextualFilterPredicate> provider4, Provider<UnknownContextualFilterPredicate> provider5, Provider<TimeSinceImpressionFilter> provider6, Provider<TimeSinceForegroundFilterPredicate> provider7, Provider<TimeSinceDismissFilter> provider8, Provider<TimeOfDayBeforeFilterPredicate> provider9, Provider<TimeOfDayAfterFilterPredicate> provider10, Provider<SecondsSinceMeteredConnectionChangedFilter> provider11, Provider<SecondsSinceMessageSentPredicate> provider12, Provider<SecondsSinceMessageReceivedPredicate> provider13, Provider<RtcPresenceContextualFilterPredicate> provider14, Provider<PreInstalledContextualFilterPredicate> provider15, Provider<OtherPromotionEventFilterPredicate> provider16, Provider<NetworkConnectivityFilterPredicate> provider17, Provider<MobileNetworkAvailableFilterPredicate> provider18, Provider<MessengerInstalledContextualFilterPredicate> provider19, Provider<MessagesSentOneAfterTheOtherPredicate> provider20, Provider<ManualNewsfeedRefreshFilterPredicate> provider21, Provider<LocaleFilterPredicate> provider22, Provider<IsOtherBirthdayContextualFilterPredicate> provider23, Provider<IsMeteredConnectionFilter> provider24, Provider<GooglePlayContextualFilterPredicate> provider25, Provider<GoogleAccountContextualFilterPredicate> provider26, Provider<DirectInstallEnabledFilterPredicate> provider27, Provider<BatteryLowContextualFilterPredicate> provider28, Provider<AssetsReadyFilter> provider29, Provider<ApplicationMinVersionFilterPredicate> provider30, Provider<ApplicationMaxVersionFilterPredicate> provider31, Provider<ApplicationMaxStorageSpaceFilterPredicate> provider32, Provider<ApplicationInstallSpaceFilterPredicate> provider33, Provider<AppNotInstalledFilterPredicate> provider34, Provider<AppInstalledFilterPredicate> provider35, Provider<AndroidPermissionsAnyDisabledFilterPredicate> provider36, Provider<AggregateImpressionsFilterPredicate> provider37, Provider<SmsTakeoverRecentReadOnlyThreadViewBannerEligibleFilterPredicate> provider38, Provider<SmsTakeoverFullThreadViewBannerEligibleFilterPredicate> provider39, Provider<SmsTakeoverDelayedReadOnlyThreadViewBannerEligibleFilterPredicate> provider40, Provider<PhotoRemindersNuxEligibleFilterPredicate> provider41, Provider<PhotoRemindersEverEnabledFilterPredicate> provider42, Provider<HasNoProfilePicturePredicate> provider43, Provider<HasMadeRtcCallContextualFilterPredicate> provider44, Provider<ContactsUploadEnabledFilterPredicate> provider45, Provider<ContactLogsUploadFilterPredicate> provider46, Provider<ClockSkewBannerEligibleFilterPredicate> provider47, Provider<OmnistoreKeyJustWrittenFilterPredicate> provider48, Provider<HasUnreadMessagesFilterPredicate> provider49, Provider<DialtoneAvailableFilterPredicate> provider50, Provider<DialtoneActiveFilterPredicate> provider51, Provider<CIUserConsentFilterPredicate> provider52, Provider<CIContinuousSyncUserConsentFilterPredicate> provider53) {
        this.f11320a = provider;
        this.f11321b = provider2;
        this.f11322c = provider3;
        this.f11323d = provider4;
        this.f11324e = provider5;
        this.f11325f = provider6;
        this.f11326g = provider7;
        this.f11327h = provider8;
        this.f11328i = provider9;
        this.f11329j = provider10;
        this.f11330k = provider11;
        this.f11331l = provider12;
        this.f11332m = provider13;
        this.f11333n = provider14;
        this.f11334o = provider15;
        this.f11335p = provider16;
        this.f11336q = provider17;
        this.f11337r = provider18;
        this.f11338s = provider19;
        this.f11339t = provider20;
        this.f11340u = provider21;
        this.f11341v = provider22;
        this.f11342w = provider23;
        this.f11343x = provider24;
        this.f11344y = provider25;
        this.f11345z = provider26;
        this.f11294A = provider27;
        this.f11295B = provider28;
        this.f11296C = provider29;
        this.f11297D = provider30;
        this.f11298E = provider31;
        this.f11299F = provider32;
        this.f11300G = provider33;
        this.f11301H = provider34;
        this.f11302I = provider35;
        this.f11303J = provider36;
        this.f11304K = provider37;
        this.f11305L = provider38;
        this.f11306M = provider39;
        this.f11307N = provider40;
        this.f11308O = provider41;
        this.f11309P = provider42;
        this.f11310Q = provider43;
        this.f11311R = provider44;
        this.f11312S = provider45;
        this.f11313T = provider46;
        this.f11314U = provider47;
        this.f11315V = provider48;
        this.f11316W = provider49;
        this.f11317X = provider50;
        this.f11318Y = provider51;
        this.f11319Z = provider52;
        this.aa = provider53;
    }

    public final AbstractContextualFilterPredicate m11671a(Type type) {
        switch (type.ordinal()) {
            case 0:
                return (WifiConnectedContextualFilterPredicate) this.f11322c.get();
            case 1:
                return (NetworkConnectivityFilterPredicate) this.f11336q.get();
            case 2:
                return (MobileNetworkAvailableFilterPredicate) this.f11337r.get();
            case 3:
                return (AndroidPermissionsAnyDisabledFilterPredicate) this.f11303J.get();
            case 4:
                return (ApplicationInstallSpaceFilterPredicate) this.f11300G.get();
            case 5:
                return (ApplicationMaxStorageSpaceFilterPredicate) this.f11299F.get();
            case 6:
                return (MessengerInstalledContextualFilterPredicate) this.f11338s.get();
            case 7:
                return (TimeOfDayBeforeFilterPredicate) this.f11328i.get();
            case 8:
                return (TimeOfDayAfterFilterPredicate) this.f11329j.get();
            case 9:
                return (ApplicationMinVersionFilterPredicate) this.f11297D.get();
            case 10:
                return (ApplicationMaxVersionFilterPredicate) this.f11298E.get();
            case 11:
                return (TimeSinceImpressionFilter) this.f11325f.get();
            case 12:
                return (GooglePlayContextualFilterPredicate) this.f11344y.get();
            case 13:
                return (PreInstalledContextualFilterPredicate) this.f11334o.get();
            case 14:
                return (TimeSinceForegroundFilterPredicate) this.f11326g.get();
            case 15:
                return (GoogleAccountContextualFilterPredicate) this.f11345z.get();
            case 16:
                return (AggregateImpressionsFilterPredicate) this.f11304K.get();
            case 17:
                return (AssetsReadyFilter) this.f11296C.get();
            case 18:
                return (SecondsSinceMessageReceivedPredicate) this.f11332m.get();
            case 19:
                return (SecondsSinceMessageSentPredicate) this.f11331l.get();
            case 20:
                return (AppInstalledFilterPredicate) this.f11302I.get();
            case 21:
                return (AppNotInstalledFilterPredicate) this.f11301H.get();
            case 22:
                return (IsMeteredConnectionFilter) this.f11343x.get();
            case 23:
                return (SecondsSinceMeteredConnectionChangedFilter) this.f11330k.get();
            case 24:
                return (ManualNewsfeedRefreshFilterPredicate) this.f11340u.get();
            case 25:
                return (BatteryLowContextualFilterPredicate) this.f11295B.get();
            case 26:
                return (OtherPromotionEventFilterPredicate) this.f11335p.get();
            case 27:
                return (CIContinuousSyncUserConsentFilterPredicate) this.aa.get();
            case 28:
                return (CIUserConsentFilterPredicate) this.f11319Z.get();
            case 29:
                return (ContactsUploadEnabledFilterPredicate) this.f11312S.get();
            case 30:
                return (SmsTakeoverRecentReadOnlyThreadViewBannerEligibleFilterPredicate) this.f11305L.get();
            case 31:
                return (SmsTakeoverDelayedReadOnlyThreadViewBannerEligibleFilterPredicate) this.f11307N.get();
            case 32:
                return (SmsTakeoverFullThreadViewBannerEligibleFilterPredicate) this.f11306M.get();
            case 33:
                return (ClockSkewBannerEligibleFilterPredicate) this.f11314U.get();
            case 34:
                return (DirectInstallEnabledFilterPredicate) this.f11294A.get();
            case 35:
                return (DialtoneActiveFilterPredicate) this.f11318Y.get();
            case 37:
                return (DialtoneAvailableFilterPredicate) this.f11317X.get();
            case 38:
                return (HasUnreadMessagesFilterPredicate) this.f11316W.get();
            case 40:
                return (RtcPresenceContextualFilterPredicate) this.f11333n.get();
            case 41:
                return (UserRankContextualFilterPredicate) this.f11323d.get();
            case 42:
                return (OmnistoreKeyJustWrittenFilterPredicate) this.f11315V.get();
            case 43:
                return (HasMadeRtcCallContextualFilterPredicate) this.f11311R.get();
            case 44:
                return (IsOtherBirthdayContextualFilterPredicate) this.f11342w.get();
            case 45:
                return (MessagesSentOneAfterTheOtherPredicate) this.f11339t.get();
            case 46:
                return (TimeSinceDismissFilter) this.f11327h.get();
            case 47:
                return (ProfileVideoCannotViewFilter) this.f11320a.get();
            case 48:
                return (ProfileVideoCannotCreateFilter) this.f11321b.get();
            case 49:
                return (LocaleFilterPredicate) this.f11341v.get();
            case 50:
                return (ContactLogsUploadFilterPredicate) this.f11313T.get();
            case 51:
                return (PhotoRemindersEverEnabledFilterPredicate) this.f11309P.get();
            case 52:
                return (PhotoRemindersNuxEligibleFilterPredicate) this.f11308O.get();
            case 53:
                return (HasNoProfilePicturePredicate) this.f11310Q.get();
            case 54:
                return (UnknownContextualFilterPredicate) this.f11324e.get();
            default:
                return null;
        }
    }
}
