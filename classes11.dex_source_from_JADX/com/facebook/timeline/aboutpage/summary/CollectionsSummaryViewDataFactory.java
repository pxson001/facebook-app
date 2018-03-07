package com.facebook.timeline.aboutpage.summary;

import com.facebook.inject.InjectorLike;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.CollectionsUriIntentBuilder;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldInfoModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldSectionInfoModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.util.TimelineAppSectionUrlBuilder;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory.ItemData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: LocationUpdateMutation */
public class CollectionsSummaryViewDataFactory {
    private static volatile CollectionsSummaryViewDataFactory f13645d;
    private final CollectionStyleMapper f13646a;
    private final TimelineAppSectionUrlBuilder f13647b;
    private final CollectionsUriIntentBuilder f13648c;

    public static com.facebook.timeline.aboutpage.summary.CollectionsSummaryViewDataFactory m14845a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13645d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.aboutpage.summary.CollectionsSummaryViewDataFactory.class;
        monitor-enter(r1);
        r0 = f13645d;	 Catch:{ all -> 0x003a }
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
        r0 = m14847b(r0);	 Catch:{ all -> 0x0035 }
        f13645d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13645d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.summary.CollectionsSummaryViewDataFactory.a(com.facebook.inject.InjectorLike):com.facebook.timeline.aboutpage.summary.CollectionsSummaryViewDataFactory");
    }

    private static CollectionsSummaryViewDataFactory m14847b(InjectorLike injectorLike) {
        return new CollectionsSummaryViewDataFactory(CollectionStyleMapper.m14915a(injectorLike), TimelineAppSectionUrlBuilder.m14867a(injectorLike), CollectionsUriIntentBuilder.m13782a(injectorLike));
    }

    @Inject
    public CollectionsSummaryViewDataFactory(CollectionStyleMapper collectionStyleMapper, TimelineAppSectionUrlBuilder timelineAppSectionUrlBuilder, CollectionsUriIntentBuilder collectionsUriIntentBuilder) {
        this.f13646a = collectionStyleMapper;
        this.f13647b = timelineAppSectionUrlBuilder;
        this.f13648c = collectionsUriIntentBuilder;
    }

    public final ItemData m14848a(CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel, ProfileViewerContext profileViewerContext, String str) {
        CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions = (CollectionWithItemsOrRequestablesModel) collectionsAppSectionWithItemsOrRequestablesModel.m14583j().m14562a().get(0);
        return new ItemData(collectionsAppSectionWithItemsOrRequestablesModel.mo389c(), collectionsAppSectionWithItemsOrRequestablesModel.mo390d(), collectionsAppSectionWithItemsOrRequestablesModel.m14587n() == null ? collectionsAppSectionWithItemsOrRequestablesModel.mo390d() : collectionsAppSectionWithItemsOrRequestablesModel.m14587n().m14392a(), collectionsAppSectionWithItemsOrRequestablesModel.m14586m() == null ? null : collectionsAppSectionWithItemsOrRequestablesModel.m14586m().m14387a(), collectionsAppSectionWithItemsOrRequestablesModel.mo388b(), collectionsAppSectionWithItemsOrRequestablesModel.nR_(), collectionWithItemsAndSuggestions, collectionWithItemsAndSuggestions.m14527g(), collectionWithItemsAndSuggestions.nT_(), collectionsAppSectionWithItemsOrRequestablesModel.nQ_(), this.f13647b.m14872a(collectionsAppSectionWithItemsOrRequestablesModel, profileViewerContext, false), TimelineAppSectionUrlBuilder.m14866a(collectionsAppSectionWithItemsOrRequestablesModel, str), this.f13648c.m13786a(collectionWithItemsAndSuggestions, collectionsAppSectionWithItemsOrRequestablesModel.nP_(), this.f13646a.m14916a(collectionWithItemsAndSuggestions.mo396d())), collectionsAppSectionWithItemsOrRequestablesModel.nP_(), profileViewerContext, false);
    }

    public static ItemData m14846a(ProfileFieldSectionInfoModel profileFieldSectionInfoModel) {
        String a = profileFieldSectionInfoModel.m14085a();
        if (profileFieldSectionInfoModel.m14087j() == null || !((ProfileFieldInfoModel) profileFieldSectionInfoModel.m14087j().m14065a().get(0)).m14047m()) {
            a = null;
        }
        return new ItemData(null, null, profileFieldSectionInfoModel.m14088k() == null ? null : profileFieldSectionInfoModel.m14088k().m14076a(), null, null, a, null, null, null, null, null, null, null, null, null, a != null);
    }
}
