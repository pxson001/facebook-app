package com.facebook.timeline.aboutpage.summary;

import com.facebook.common.util.StringUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldStatus;
import com.facebook.graphql.enums.GraphQLProfileFieldStyle;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.inject.InjectorLike;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldInfoModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLInterfaces.CollectionsAppSectionWithItemsOrRequestables;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionRequestableFieldModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory.ItemData;
import com.facebook.timeline.aboutpage.views.ListCollectionItemDataFactory;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Login */
public class CollectionsSummaryItemsListFactory {
    private static final ImmutableList<GraphQLProfileFieldStyle> f13638f = ImmutableList.of(GraphQLProfileFieldStyle.PARAGRAPH, GraphQLProfileFieldStyle.PAGE_TAGS, GraphQLProfileFieldStyle.TEXT_LISTS, GraphQLProfileFieldStyle.UPSELL, GraphQLProfileFieldStyle.DATE, GraphQLProfileFieldStyle.TEXT_LINK, GraphQLProfileFieldStyle.ADDRESS, GraphQLProfileFieldStyle.PHONE, GraphQLProfileFieldStyle.EMAIL, GraphQLProfileFieldStyle.STRING, GraphQLProfileFieldStyle.LIST_OF_STRINGS);
    private static volatile CollectionsSummaryItemsListFactory f13639g;
    private final CollectionsSummaryViewDataFactory f13640a;
    private final ListCollectionItemDataFactory f13641b;
    private final CollectionStyleMapper f13642c;
    private final boolean f13643d;
    private final QeAccessor f13644e;

    /* compiled from: Login */
    public class ProfileFieldItem {
        public final ProfileFieldInfoModel f13631a;
        public boolean f13632b;

        public ProfileFieldItem(ProfileFieldInfoModel profileFieldInfoModel) {
            boolean z;
            if (profileFieldInfoModel != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            this.f13631a = profileFieldInfoModel;
            this.f13632b = false;
        }
    }

    /* compiled from: Login */
    public class SummaryListItem {
        @Nullable
        public final AppCollectionItemModel f13633a;
        @Nullable
        public final CollectionsAppSectionRequestableFieldModel f13634b;
        public final GraphQLTimelineAppSectionType f13635c;
        public final boolean f13636d;
        public final boolean f13637e;

        @VisibleForTesting
        SummaryListItem(AppCollectionItemModel appCollectionItemModel, CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType, boolean z, boolean z2) {
            boolean z3 = (appCollectionItemModel == null && collectionsAppSectionRequestableFieldModel == null) ? false : true;
            Preconditions.checkArgument(z3);
            this.f13633a = appCollectionItemModel;
            this.f13634b = collectionsAppSectionRequestableFieldModel;
            this.f13635c = graphQLTimelineAppSectionType;
            this.f13636d = z;
            this.f13637e = z2;
        }
    }

    public static com.facebook.timeline.aboutpage.summary.CollectionsSummaryItemsListFactory m14840a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13639g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.aboutpage.summary.CollectionsSummaryItemsListFactory.class;
        monitor-enter(r1);
        r0 = f13639g;	 Catch:{ all -> 0x003a }
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
        r0 = m14843b(r0);	 Catch:{ all -> 0x0035 }
        f13639g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13639g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.summary.CollectionsSummaryItemsListFactory.a(com.facebook.inject.InjectorLike):com.facebook.timeline.aboutpage.summary.CollectionsSummaryItemsListFactory");
    }

    private static CollectionsSummaryItemsListFactory m14843b(InjectorLike injectorLike) {
        return new CollectionsSummaryItemsListFactory(CollectionsSummaryViewDataFactory.m14845a(injectorLike), ListCollectionItemDataFactory.m14997a(injectorLike), CollectionStyleMapper.m14915a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CollectionsSummaryItemsListFactory(CollectionsSummaryViewDataFactory collectionsSummaryViewDataFactory, ListCollectionItemDataFactory listCollectionItemDataFactory, CollectionStyleMapper collectionStyleMapper, Boolean bool, QeAccessor qeAccessor) {
        this.f13640a = collectionsSummaryViewDataFactory;
        this.f13641b = listCollectionItemDataFactory;
        this.f13642c = collectionStyleMapper;
        this.f13643d = bool.booleanValue();
        this.f13644e = qeAccessor;
    }

    public static boolean m14841a(ProfileFieldInfoModel profileFieldInfoModel) {
        if (profileFieldInfoModel.m14041b().isEmpty()) {
            return false;
        }
        GraphQLProfileFieldStyle graphQLProfileFieldStyle = (GraphQLProfileFieldStyle) profileFieldInfoModel.m14041b().get(0);
        if (!f13638f.contains(graphQLProfileFieldStyle)) {
            return false;
        }
        if (graphQLProfileFieldStyle == GraphQLProfileFieldStyle.PARAGRAPH) {
            int i = (profileFieldInfoModel.m14042c() == null || StringUtil.a(profileFieldInfoModel.m14042c().m14026a())) ? 0 : 1;
            if (i == 0) {
                if (profileFieldInfoModel.m14039a() == null || profileFieldInfoModel.m14043d() == null || StringUtil.a(profileFieldInfoModel.m14043d().m14036a())) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public final ImmutableList<Object> m14844a(CollectionsAppSectionWithItemsOrRequestables collectionsAppSectionWithItemsOrRequestables, ProfileViewerContext profileViewerContext, String str) {
        if (!m14842a(collectionsAppSectionWithItemsOrRequestables, profileViewerContext.f())) {
            return ImmutableList.of();
        }
        if (GraphQLTimelineAppSectionType.ABOUT.equals(collectionsAppSectionWithItemsOrRequestables.nP_()) || GraphQLTimelineAppSectionType.CONTACT.equals(collectionsAppSectionWithItemsOrRequestables.nP_())) {
            Builder builder = ImmutableList.builder();
            if (!GraphQLTimelineAppSectionType.ABOUT.equals(collectionsAppSectionWithItemsOrRequestables.nP_())) {
                builder.c(this.f13640a.m14848a(collectionsAppSectionWithItemsOrRequestables, profileViewerContext, str));
            }
            CollectionWithItemsOrRequestablesModel collectionWithItemsOrRequestablesModel = (CollectionWithItemsOrRequestablesModel) collectionsAppSectionWithItemsOrRequestables.m14583j().m14562a().get(0);
            ArrayList a = Lists.a();
            if (collectionWithItemsOrRequestablesModel.nU_() != null) {
                ImmutableList b = collectionWithItemsOrRequestablesModel.nU_().m14346b();
                int size = b.size();
                for (int i = 0; i < size; i++) {
                    a.add((AppCollectionItemModel) b.get(i));
                }
            }
            if (collectionWithItemsOrRequestablesModel.nT_() != null) {
                ImmutableList a2 = collectionWithItemsOrRequestablesModel.nT_().m14557a();
                int size2 = a2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel = (CollectionsAppSectionRequestableFieldModel) a2.get(i2);
                    if (!GraphQLInfoRequestFieldStatus.FILLED.equals(m14839a(CollectionsAppSectionRequestableFieldModel.m14545a(collectionsAppSectionRequestableFieldModel)))) {
                        a.add(collectionsAppSectionRequestableFieldModel);
                    }
                }
            }
            for (int i3 = 0; i3 < a.size(); i3++) {
                boolean z;
                boolean z2;
                AppCollectionItemModel appCollectionItemModel;
                CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel2;
                Object obj = a.get(i3);
                if (i3 == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (i3 == a.size() - 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (obj instanceof AppCollectionItemModel) {
                    appCollectionItemModel = (AppCollectionItemModel) obj;
                } else {
                    appCollectionItemModel = null;
                }
                if (obj instanceof CollectionsAppSectionRequestableFieldModel) {
                    collectionsAppSectionRequestableFieldModel2 = (CollectionsAppSectionRequestableFieldModel) obj;
                } else {
                    collectionsAppSectionRequestableFieldModel2 = null;
                }
                builder.c(new SummaryListItem(appCollectionItemModel, collectionsAppSectionRequestableFieldModel2, collectionsAppSectionWithItemsOrRequestables.nP_(), z2, z));
            }
            if (GraphQLTimelineAppSectionType.ABOUT.equals(collectionsAppSectionWithItemsOrRequestables.nP_()) && !this.f13643d) {
                builder.c(this.f13640a.m14848a(collectionsAppSectionWithItemsOrRequestables, profileViewerContext, str));
            }
            return builder.b();
        }
        ImmutableList a3;
        ItemData a4 = this.f13640a.m14848a(collectionsAppSectionWithItemsOrRequestables, profileViewerContext, str);
        GraphQLTimelineAppCollectionStyle a5 = this.f13642c.m14916a(a4.f13787g.mo396d());
        if (GraphQLTimelineAppCollectionStyle.LIST.equals(a5)) {
            a3 = ListCollectionItemDataFactory.m14998a(a4.f13787g, a4.f13794n);
        } else {
            a3 = a4.f13787g.nU_().m14346b();
        }
        return ImmutableList.of(new SectionItemData(collectionsAppSectionWithItemsOrRequestables, a4, a5, a3));
    }

    public static GraphQLInfoRequestFieldStatus m14839a(CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel) {
        GraphQLInfoRequestFieldStatus graphQLInfoRequestFieldStatus = collectionsAppSectionRequestableFieldModel.m14552j().a;
        return (graphQLInfoRequestFieldStatus == null || graphQLInfoRequestFieldStatus.equals(GraphQLInfoRequestFieldStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)) ? collectionsAppSectionRequestableFieldModel.m14550c() : graphQLInfoRequestFieldStatus;
    }

    private boolean m14842a(CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel, boolean z) {
        if (collectionsAppSectionWithItemsOrRequestablesModel == null || collectionsAppSectionWithItemsOrRequestablesModel.m14583j() == null || collectionsAppSectionWithItemsOrRequestablesModel.m14583j().m14562a() == null || collectionsAppSectionWithItemsOrRequestablesModel.m14583j().m14562a().isEmpty()) {
            return false;
        }
        boolean a = this.f13644e.a(ExperimentsForTimelineAbTestModule.ax, false);
        boolean equals = GraphQLTimelineAppSectionType.ABOUT.equals(collectionsAppSectionWithItemsOrRequestablesModel.nP_());
        boolean equals2 = GraphQLTimelineAppSectionType.CONTACT.equals(collectionsAppSectionWithItemsOrRequestablesModel.nP_());
        if (a && (equals || equals2)) {
            return false;
        }
        if (equals || (z && equals2)) {
            return true;
        }
        Object obj;
        Object obj2;
        ImmutableList a2;
        int size;
        int i;
        CollectionWithItemsOrRequestablesModel collectionWithItemsOrRequestablesModel = (CollectionWithItemsOrRequestablesModel) collectionsAppSectionWithItemsOrRequestablesModel.m14583j().m14562a().get(0);
        if (collectionWithItemsOrRequestablesModel.nU_() == null || collectionWithItemsOrRequestablesModel.nU_().m14346b() == null || collectionWithItemsOrRequestablesModel.nU_().m14346b().isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            if (collectionWithItemsOrRequestablesModel.mo404q() == null || collectionWithItemsOrRequestablesModel.mo404q().m14409a() == null || collectionWithItemsOrRequestablesModel.mo404q().m14409a().isEmpty()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                obj2 = null;
                if (obj2 != null) {
                    return true;
                }
                if (equals2) {
                    if (collectionWithItemsOrRequestablesModel.nT_() != null || collectionWithItemsOrRequestablesModel.nT_().m14557a() == null || collectionWithItemsOrRequestablesModel.nT_().m14557a().isEmpty()) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        a2 = collectionWithItemsOrRequestablesModel.nT_().m14557a();
                        size = a2.size();
                        for (i = 0; i < size; i++) {
                            if (!GraphQLInfoRequestFieldStatus.FILLED.equals(m14839a(CollectionsAppSectionRequestableFieldModel.m14545a((CollectionsAppSectionRequestableFieldModel) a2.get(i))))) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        }
        obj2 = 1;
        if (obj2 != null) {
            return true;
        }
        if (equals2) {
            if (collectionWithItemsOrRequestablesModel.nT_() != null) {
            }
            obj2 = null;
            if (obj2 != null) {
                a2 = collectionWithItemsOrRequestablesModel.nT_().m14557a();
                size = a2.size();
                for (i = 0; i < size; i++) {
                    if (!GraphQLInfoRequestFieldStatus.FILLED.equals(m14839a(CollectionsAppSectionRequestableFieldModel.m14545a((CollectionsAppSectionRequestableFieldModel) a2.get(i))))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
