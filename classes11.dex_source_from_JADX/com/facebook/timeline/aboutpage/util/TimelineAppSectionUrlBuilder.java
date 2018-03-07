package com.facebook.timeline.aboutpage.util;

import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.TriState;
import com.facebook.friendlist.constants.FriendListSource;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.CollectionsUriIntentBuilder;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsAppSection;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsNodeIdFields;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsNodePeekFields;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionsPeekFieldsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: Ljava/util/concurrent/ScheduledExecutorService; */
public class TimelineAppSectionUrlBuilder {
    private static volatile TimelineAppSectionUrlBuilder f13671g;
    private final CollectionStyleMapper f13672a;
    private final Provider<Boolean> f13673b;
    private final AbstractFbErrorReporter f13674c;
    private final CollectionsUriIntentBuilder f13675d;
    public final Provider<TriState> f13676e;
    public final Provider<TriState> f13677f;

    /* compiled from: Ljava/util/concurrent/ScheduledExecutorService; */
    /* synthetic */ class C15771 {
        static final /* synthetic */ int[] f13670a = new int[GraphQLTimelineAppSectionType.values().length];

        static {
            try {
                f13670a[GraphQLTimelineAppSectionType.ABOUT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13670a[GraphQLTimelineAppSectionType.CONTACT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13670a[GraphQLTimelineAppSectionType.REVIEWS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f13670a[GraphQLTimelineAppSectionType.FRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f13670a[GraphQLTimelineAppSectionType.PHOTOS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static com.facebook.timeline.aboutpage.util.TimelineAppSectionUrlBuilder m14867a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13671g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.aboutpage.util.TimelineAppSectionUrlBuilder.class;
        monitor-enter(r1);
        r0 = f13671g;	 Catch:{ all -> 0x003a }
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
        r0 = m14871b(r0);	 Catch:{ all -> 0x0035 }
        f13671g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13671g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.util.TimelineAppSectionUrlBuilder.a(com.facebook.inject.InjectorLike):com.facebook.timeline.aboutpage.util.TimelineAppSectionUrlBuilder");
    }

    private static TimelineAppSectionUrlBuilder m14871b(InjectorLike injectorLike) {
        return new TimelineAppSectionUrlBuilder(CollectionStyleMapper.m14915a(injectorLike), IdBasedProvider.a(injectorLike, 4351), CollectionsUriIntentBuilder.m13782a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 777), IdBasedProvider.a(injectorLike, 778));
    }

    @Inject
    public TimelineAppSectionUrlBuilder(CollectionStyleMapper collectionStyleMapper, Provider<Boolean> provider, CollectionsUriIntentBuilder collectionsUriIntentBuilder, FbErrorReporter fbErrorReporter, Provider<TriState> provider2, Provider<TriState> provider3) {
        this.f13672a = collectionStyleMapper;
        this.f13673b = provider;
        this.f13675d = collectionsUriIntentBuilder;
        this.f13674c = fbErrorReporter;
        this.f13676e = provider2;
        this.f13677f = provider3;
    }

    public final String m14872a(CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel, ProfileViewerContext profileViewerContext, boolean z) {
        switch (C15771.f13670a[collectionsAppSectionWithItemsOrRequestablesModel.nP_().ordinal()]) {
            case 1:
                if (z) {
                    return StringFormatUtil.formatStrLocaleSafe(FBLinks.aY, profileViewerContext.a);
                }
                break;
            case 2:
            case 3:
                break;
            case 4:
                return StringFormatUtil.formatStrLocaleSafe(FBLinks.bf, profileViewerContext.a, FriendListType.ALL_FRIENDS.name(), FriendListSource.TIMELINE_ABOUT_FRIENDS_APP.name());
            case 5:
                if (profileViewerContext.f()) {
                    return FBLinks.bm;
                }
                return StringFormatUtil.formatStrLocaleSafe(FBLinks.bn, profileViewerContext.a);
            default:
                Object obj = 1;
                if (!((this.f13677f.get() == TriState.YES && !Strings.isNullOrEmpty(m14868a((CollectionsAppSection) collectionsAppSectionWithItemsOrRequestablesModel, z)) && collectionsAppSectionWithItemsOrRequestablesModel.nP_() == GraphQLTimelineAppSectionType.MAP) || (this.f13676e.get() == TriState.YES && !Strings.isNullOrEmpty(m14868a((CollectionsAppSection) collectionsAppSectionWithItemsOrRequestablesModel, z)) && (collectionsAppSectionWithItemsOrRequestablesModel.nP_() == GraphQLTimelineAppSectionType.MOVIES || collectionsAppSectionWithItemsOrRequestablesModel.nP_() == GraphQLTimelineAppSectionType.BOOKS || collectionsAppSectionWithItemsOrRequestablesModel.nP_() == GraphQLTimelineAppSectionType.TV_SHOWS || collectionsAppSectionWithItemsOrRequestablesModel.nP_() == GraphQLTimelineAppSectionType.MUSIC)))) {
                    obj = null;
                }
                if (obj != null || (!((Boolean) this.f13673b.get()).booleanValue() && (collectionsAppSectionWithItemsOrRequestablesModel.nP_() == GraphQLTimelineAppSectionType.SUBSCRIPTIONS || collectionsAppSectionWithItemsOrRequestablesModel.nP_() == GraphQLTimelineAppSectionType.SUBSCRIBERS))) {
                    return m14868a((CollectionsAppSection) collectionsAppSectionWithItemsOrRequestablesModel, z);
                }
                if (collectionsAppSectionWithItemsOrRequestablesModel.m14584k() != null && collectionsAppSectionWithItemsOrRequestablesModel.m14585l() == null) {
                    this.f13674c.b("TimelineAppSectionUrlBuilder_nullCollectionsPeek", "collectionsPeek is null, collectionsNoItems will be ignored");
                }
                if (collectionsAppSectionWithItemsOrRequestablesModel.m14585l() == null || collectionsAppSectionWithItemsOrRequestablesModel.m14585l().m14439a() <= 0 || !m14870a(collectionsAppSectionWithItemsOrRequestablesModel.m14585l())) {
                    return m14868a((CollectionsAppSection) collectionsAppSectionWithItemsOrRequestablesModel, z);
                }
                if (collectionsAppSectionWithItemsOrRequestablesModel.m14584k() != null && collectionsAppSectionWithItemsOrRequestablesModel.m14584k().m14568a() != null && collectionsAppSectionWithItemsOrRequestablesModel.m14584k().m14568a().size() == 1) {
                    return CollectionsUriIntentBuilder.m13783a((CollectionsNodeIdFields) collectionsAppSectionWithItemsOrRequestablesModel.m14584k().m14568a().get(0), String.valueOf(profileViewerContext.a), collectionsAppSectionWithItemsOrRequestablesModel.mo389c());
                }
                if (collectionsAppSectionWithItemsOrRequestablesModel.m14585l() == null || collectionsAppSectionWithItemsOrRequestablesModel.m14585l().m14439a() != 1 || collectionsAppSectionWithItemsOrRequestablesModel.m14585l().m14443b() == null || collectionsAppSectionWithItemsOrRequestablesModel.m14585l().m14443b().isEmpty()) {
                    return m14869a(String.valueOf(profileViewerContext.a), collectionsAppSectionWithItemsOrRequestablesModel.mo389c());
                }
                return CollectionsUriIntentBuilder.m13783a((CollectionsNodeIdFields) collectionsAppSectionWithItemsOrRequestablesModel.m14585l().m14443b().get(0), String.valueOf(profileViewerContext.a), collectionsAppSectionWithItemsOrRequestablesModel.mo389c());
        }
        return m14868a((CollectionsAppSection) collectionsAppSectionWithItemsOrRequestablesModel, z);
    }

    public static String m14869a(String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        return StringFormatUtil.formatStrLocaleSafe(FBLinks.df, str, str2);
    }

    public static Bundle m14866a(CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel, String str) {
        Bundle bundle = new Bundle();
        if (collectionsAppSectionWithItemsOrRequestablesModel.nP_() == GraphQLTimelineAppSectionType.PHOTOS) {
            bundle.putBoolean("has_tagged_mediaset", true);
            bundle.putString("profile_name", str);
        }
        return bundle;
    }

    public static String m14868a(CollectionsAppSection collectionsAppSection, boolean z) {
        return z ? collectionsAppSection.nR_() : collectionsAppSection.mo391g();
    }

    private boolean m14870a(CollectionsPeekFieldsModel collectionsPeekFieldsModel) {
        if (collectionsPeekFieldsModel.m14443b() == null) {
            return true;
        }
        ImmutableList b = collectionsPeekFieldsModel.m14443b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            if (this.f13672a.m14916a(((CollectionsNodePeekFields) b.get(i)).mo396d()).equals(GraphQLTimelineAppCollectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)) {
                return false;
            }
        }
        return true;
    }
}
