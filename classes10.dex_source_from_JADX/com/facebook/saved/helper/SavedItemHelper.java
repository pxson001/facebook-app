package com.facebook.saved.helper;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.inject.InjectorLike;
import com.facebook.saved.data.SavedDashboardItem;
import com.facebook.saved.data.SavedDashboardListSectionHeader;
import com.facebook.saved.data.SavedDashboardPaginatedSavedItems;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.FetchSavedItemsGraphQLModel;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.SavedItemModel;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.SavedItemsEdgeModel;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: invite_friends_upsell_not_now */
public class SavedItemHelper {
    private static volatile SavedItemHelper f9169d;
    public final GraphQLLinkExtractor f9170a;
    private final SavedListItemHelper f9171b;
    private final Clock f9172c;

    /* compiled from: invite_friends_upsell_not_now */
    public /* synthetic */ class C13931 {
        public static final /* synthetic */ int[] f9168a = new int[GraphQLSavedState.values().length];

        static {
            try {
                f9168a[GraphQLSavedState.ARCHIVED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9168a[GraphQLSavedState.SAVED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static com.facebook.saved.helper.SavedItemHelper m9171a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9169d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.saved.helper.SavedItemHelper.class;
        monitor-enter(r1);
        r0 = f9169d;	 Catch:{ all -> 0x003a }
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
        r0 = m9172b(r0);	 Catch:{ all -> 0x0035 }
        f9169d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9169d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.saved.helper.SavedItemHelper.a(com.facebook.inject.InjectorLike):com.facebook.saved.helper.SavedItemHelper");
    }

    private static SavedItemHelper m9172b(InjectorLike injectorLike) {
        return new SavedItemHelper(GraphQLLinkExtractor.a(injectorLike), SavedListItemHelper.m9178a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SavedItemHelper(GraphQLLinkExtractor graphQLLinkExtractor, SavedListItemHelper savedListItemHelper, Clock clock) {
        this.f9170a = graphQLLinkExtractor;
        this.f9171b = savedListItemHelper;
        this.f9172c = clock;
    }

    public final SavedDashboardPaginatedSavedItems m9175a(@Nullable GraphQLResult<FetchSavedItemsGraphQLModel> graphQLResult) {
        Long l = null;
        if (graphQLResult == null) {
            return new SavedDashboardPaginatedSavedItems(Absent.INSTANCE, false, null);
        }
        boolean z;
        if (graphQLResult.clientTimeMs > 0) {
            l = Long.valueOf(this.f9172c.a() - graphQLResult.clientTimeMs);
        }
        ImmutableList<SavedDashboardItem> c = m9173c(graphQLResult);
        Object obj = null;
        Builder builder = ImmutableList.builder();
        for (SavedDashboardItem savedDashboardItem : c) {
            if (!StringUtil.a(savedDashboardItem.f9109d)) {
                if (!savedDashboardItem.f9109d.equals(obj)) {
                    builder.c(new SavedDashboardListSectionHeader(savedDashboardItem.f9109d));
                    obj = savedDashboardItem.f9109d;
                }
                builder.c(savedDashboardItem);
            }
        }
        Optional of = Optional.of(builder.b());
        if (graphQLResult == null || graphQLResult.e == null || ((FetchSavedItemsGraphQLModel) graphQLResult.e).m9295a() == null || ((FetchSavedItemsGraphQLModel) graphQLResult.e).m9295a().m9291j() == null) {
            z = false;
        } else {
            z = ((FetchSavedItemsGraphQLModel) graphQLResult.e).m9295a().m9291j().m9286a();
        }
        return new SavedDashboardPaginatedSavedItems(of, z, l);
    }

    private ImmutableList<SavedDashboardItem> m9173c(@Nullable GraphQLResult<FetchSavedItemsGraphQLModel> graphQLResult) {
        if (graphQLResult == null || graphQLResult.e == null || ((FetchSavedItemsGraphQLModel) graphQLResult.e).m9295a() == null || ((FetchSavedItemsGraphQLModel) graphQLResult.e).m9295a().m9290a().isEmpty()) {
            return RegularImmutableList.a;
        }
        ImmutableList<SavedItemsEdgeModel> a = ((FetchSavedItemsGraphQLModel) graphQLResult.e).m9295a().m9290a();
        Builder builder = ImmutableList.builder();
        for (SavedItemsEdgeModel savedItemsEdgeModel : a) {
            if (!(savedItemsEdgeModel.m9416k() == null || savedItemsEdgeModel.m9415j() == null || StringUtil.a(savedItemsEdgeModel.m9415j().m9410a()))) {
                String str;
                SavedItemModel k = savedItemsEdgeModel.m9416k();
                String str2 = null;
                SavedDashboardItem.Builder builder2 = new SavedDashboardItem.Builder();
                builder2.f9100g = k.m9399l();
                builder2 = builder2;
                builder2.f9104k = k.m9400m();
                builder2 = builder2;
                builder2.f9101h = k.m9401n();
                builder2 = builder2;
                builder2.f9098e = k.m9404q();
                SavedDashboardItem.Builder builder3 = builder2;
                if (k.m9398k() == null) {
                    str = null;
                } else {
                    str = k.m9398k().b();
                }
                builder3.f9099f = str;
                builder3 = builder3;
                if (k.m9403p() == null) {
                    str = null;
                } else {
                    str = k.m9403p().m9391a();
                }
                builder3.f9094a = str;
                builder3 = builder3;
                if (k.m9402o() == null) {
                    str = null;
                } else {
                    str = k.m9402o().m9386a();
                }
                builder3.f9095b = str;
                builder2 = builder3;
                if (k.m9394a() != null) {
                    str2 = k.m9394a().m9334a();
                }
                builder2.f9096c = str2;
                builder2 = builder2;
                builder2.f9103j = false;
                builder2 = builder2;
                builder2.f9105l = k.m9397j();
                SavedDashboardItem.Builder builder4 = builder2;
                builder4.f9097d = savedItemsEdgeModel.m9415j().m9410a();
                builder4 = builder4;
                builder4.f9102i = savedItemsEdgeModel.m9414a();
                builder.c(builder4.m9103a());
            }
        }
        return builder.b();
    }

    @Nullable
    public static GraphQLSavedState m9174d(@Nullable SavedDashboardItem savedDashboardItem) {
        if (savedDashboardItem == null || savedDashboardItem.f9112g == null) {
            return null;
        }
        return savedDashboardItem.f9112g.m9306F();
    }

    public final boolean m9176f(SavedDashboardItem savedDashboardItem) {
        GraphQLSavedState d = m9174d(savedDashboardItem);
        return savedDashboardItem.f9115j && (GraphQLSavedState.ARCHIVED.equals(d) || GraphQLSavedState.SAVED.equals(d));
    }
}
