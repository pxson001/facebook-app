package com.facebook.places.pagetopics.stores;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.service.OperationResult.NoResultDataParcelableException;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQL.PlaceCategoryPickerSearchString;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLModels.PlaceCategoryPickerSearchModel;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLModels.PlaceCategoryPickerSearchModel.CategoryResultsModel.EdgesModel;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: flowStartCount */
public class PlaceCategoriesSearchResultsStore extends PlaceCategoriesListenableStore {
    private static volatile PlaceCategoriesSearchResultsStore f14788e;
    private Optional<String> f14789a = Absent.INSTANCE;
    private Optional<ImmutableList<PlacePickerCategory>> f14790b = Absent.INSTANCE;
    private final GraphQLQueryExecutor f14791c;
    private final TasksManager<Integer> f14792d;

    /* compiled from: flowStartCount */
    class C09541 extends AbstractDisposableFutureCallback<PlaceCategoryPickerSearchModel> {
        final /* synthetic */ PlaceCategoriesSearchResultsStore f14787a;

        C09541(PlaceCategoriesSearchResultsStore placeCategoriesSearchResultsStore) {
            this.f14787a = placeCategoriesSearchResultsStore;
        }

        protected final void m22441a(Object obj) {
            try {
                PlaceCategoriesSearchResultsStore.m22444a(this.f14787a, (PlaceCategoryPickerSearchModel) obj);
                this.f14787a.m22432b();
            } catch (NoResultDataParcelableException e) {
            }
        }

        protected final void m22442a(Throwable th) {
        }
    }

    public static com.facebook.places.pagetopics.stores.PlaceCategoriesSearchResultsStore m22443a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14788e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.places.pagetopics.stores.PlaceCategoriesSearchResultsStore.class;
        monitor-enter(r1);
        r0 = f14788e;	 Catch:{ all -> 0x003a }
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
        r0 = m22445b(r0);	 Catch:{ all -> 0x0035 }
        f14788e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14788e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.pagetopics.stores.PlaceCategoriesSearchResultsStore.a(com.facebook.inject.InjectorLike):com.facebook.places.pagetopics.stores.PlaceCategoriesSearchResultsStore");
    }

    private static PlaceCategoriesSearchResultsStore m22445b(InjectorLike injectorLike) {
        return new PlaceCategoriesSearchResultsStore(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public PlaceCategoriesSearchResultsStore(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f14791c = graphQLQueryExecutor;
        this.f14792d = tasksManager;
    }

    public final boolean m22449a() {
        return this.f14792d.b().contains(Integer.valueOf(1));
    }

    public final ImmutableList<PlacePickerCategory> m22448a(String str) {
        if (m22447c(str)) {
            return (ImmutableList) this.f14790b.or(RegularImmutableList.a);
        }
        m22446b(str);
        return RegularImmutableList.a;
    }

    private void m22446b(String str) {
        if (!m22447c(str) || (!this.f14790b.isPresent() && !this.f14792d.a(Integer.valueOf(1)))) {
            this.f14789a = Optional.of(str);
            this.f14790b = Absent.INSTANCE;
            this.f14792d.a(Integer.valueOf(1), GraphQLQueryExecutor.a(this.f14791c.a(GraphQLRequest.a((PlaceCategoryPickerSearchString) new PlaceCategoryPickerSearchString().a("query", str)))), new C09541(this));
            m22432b();
        }
    }

    private boolean m22447c(String str) {
        return this.f14789a.isPresent() && ((String) this.f14789a.get()).equals(str);
    }

    public static void m22444a(PlaceCategoriesSearchResultsStore placeCategoriesSearchResultsStore, PlaceCategoryPickerSearchModel placeCategoryPickerSearchModel) {
        Builder builder = ImmutableList.builder();
        ImmutableList a = placeCategoryPickerSearchModel.m22369a().m22364a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            builder.c(PlaceCategoriesListenableStore.m22430a(((EdgesModel) a.get(i)).m22353a()));
        }
        placeCategoriesSearchResultsStore.f14790b = Optional.of(builder.b());
    }
}
