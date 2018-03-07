package com.facebook.places.pagetopics.stores;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.service.OperationResult.NoResultDataParcelableException;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQL.PlaceCategoryPickerChildrenString;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLModels.PlaceCategoryPickerChildrenModel;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLModels.PlaceCategoryPickerChildrenModel.ChildCategoriesModel.EdgesModel;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: flow_name */
public class PlaceCategoriesChildrenStore extends PlaceCategoriesListenableStore {
    private static volatile PlaceCategoriesChildrenStore f14782e;
    public Optional<String> f14783a = Absent.INSTANCE;
    private Map<String, ImmutableList<PlacePickerCategory>> f14784b = Maps.c();
    private final GraphQLQueryExecutor f14785c;
    public final TasksManager<Integer> f14786d;

    public static com.facebook.places.pagetopics.stores.PlaceCategoriesChildrenStore m22434a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14782e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.places.pagetopics.stores.PlaceCategoriesChildrenStore.class;
        monitor-enter(r1);
        r0 = f14782e;	 Catch:{ all -> 0x003a }
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
        r0 = m22437b(r0);	 Catch:{ all -> 0x0035 }
        f14782e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14782e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.pagetopics.stores.PlaceCategoriesChildrenStore.a(com.facebook.inject.InjectorLike):com.facebook.places.pagetopics.stores.PlaceCategoriesChildrenStore");
    }

    private static PlaceCategoriesChildrenStore m22437b(InjectorLike injectorLike) {
        return new PlaceCategoriesChildrenStore(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public PlaceCategoriesChildrenStore(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f14785c = graphQLQueryExecutor;
        this.f14786d = tasksManager;
    }

    public final ImmutableList<PlacePickerCategory> m22440a(PlacePickerCategory placePickerCategory) {
        if (!m22439c(placePickerCategory)) {
            m22438b(placePickerCategory);
            return RegularImmutableList.a;
        } else if (this.f14784b.containsKey(placePickerCategory.f14793a)) {
            return (ImmutableList) this.f14784b.get(placePickerCategory.f14793a);
        } else {
            return RegularImmutableList.a;
        }
    }

    private void m22438b(final PlacePickerCategory placePickerCategory) {
        if (!m22439c(placePickerCategory)) {
            this.f14786d.c(Integer.valueOf(1));
            this.f14783a = Optional.of(placePickerCategory.f14793a);
            this.f14786d.a(Integer.valueOf(1), GraphQLQueryExecutor.a(this.f14785c.a(GraphQLRequest.a((PlaceCategoryPickerChildrenString) new PlaceCategoryPickerChildrenString().a("category_id", placePickerCategory.f14793a)))), new AbstractDisposableFutureCallback<PlaceCategoryPickerChildrenModel>(this) {
                final /* synthetic */ PlaceCategoriesChildrenStore f14780b;

                protected final void m22428a(Object obj) {
                    try {
                        PlaceCategoriesChildrenStore.m22436a(this.f14780b, placePickerCategory.f14793a, (PlaceCategoryPickerChildrenModel) obj);
                        this.f14780b.f14783a = Absent.withType();
                        this.f14780b.m22432b();
                    } catch (NoResultDataParcelableException e) {
                        this.f14780b.f14783a = Absent.withType();
                        this.f14780b.m22432b();
                    }
                }

                protected final void m22429a(Throwable th) {
                    this.f14780b.f14783a = Absent.INSTANCE;
                    this.f14780b.m22432b();
                }
            });
            m22432b();
        }
    }

    private boolean m22439c(PlacePickerCategory placePickerCategory) {
        return this.f14784b.containsKey(placePickerCategory.f14793a) || (this.f14783a.isPresent() && ((String) this.f14783a.get()).equals(placePickerCategory.f14793a));
    }

    public static void m22436a(PlaceCategoriesChildrenStore placeCategoriesChildrenStore, String str, PlaceCategoryPickerChildrenModel placeCategoryPickerChildrenModel) {
        Builder builder = ImmutableList.builder();
        ImmutableList a = placeCategoryPickerChildrenModel.m22345a().m22339a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            builder.c(PlaceCategoriesListenableStore.m22430a(((EdgesModel) a.get(i)).m22335a()));
        }
        placeCategoriesChildrenStore.f14784b.put(str, builder.b());
    }
}
