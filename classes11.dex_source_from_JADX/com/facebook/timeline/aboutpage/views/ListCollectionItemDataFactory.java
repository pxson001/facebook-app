package com.facebook.timeline.aboutpage.views;

import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionSuggestionFieldsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Singleton;

@Singleton
/* compiled from: Ljava/util/ArrayList */
public class ListCollectionItemDataFactory {
    private static volatile ListCollectionItemDataFactory f13849a;

    public static com.facebook.timeline.aboutpage.views.ListCollectionItemDataFactory m14997a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f13849a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.timeline.aboutpage.views.ListCollectionItemDataFactory.class;
        monitor-enter(r1);
        r0 = f13849a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m14996a();	 Catch:{ all -> 0x0034 }
        f13849a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f13849a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.views.ListCollectionItemDataFactory.a(com.facebook.inject.InjectorLike):com.facebook.timeline.aboutpage.views.ListCollectionItemDataFactory");
    }

    private static ListCollectionItemDataFactory m14996a() {
        return new ListCollectionItemDataFactory();
    }

    public static ImmutableList<ListCollectionItemData> m14998a(CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
        Builder builder = ImmutableList.builder();
        ImmutableList b;
        int size;
        int i;
        if (collectionWithItemsAndSuggestions.nU_() != null && !collectionWithItemsAndSuggestions.nU_().m14346b().isEmpty()) {
            b = collectionWithItemsAndSuggestions.nU_().m14346b();
            size = b.size();
            for (i = 0; i < size; i++) {
                builder.c(ListCollectionItemData.m14994a((AppCollectionItemModel) b.get(i), graphQLTimelineAppSectionType));
            }
        } else if (!(collectionWithItemsAndSuggestions.mo404q() == null || collectionWithItemsAndSuggestions.mo404q().m14409a().isEmpty())) {
            b = collectionWithItemsAndSuggestions.mo404q().m14409a();
            size = b.size();
            for (i = 0; i < size; i++) {
                builder.c(ListCollectionItemData.m14995a((AppCollectionSuggestionFieldsModel) b.get(i), graphQLTimelineAppSectionType));
            }
        }
        return builder.b();
    }
}
