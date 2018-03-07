package com.facebook.crowdsourcing.loader;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.crowdsourcing.loader.FetchSuggestEditsGraphQLRequest.C14351;
import com.facebook.crowdsourcing.loader.FetchSuggestEditsGraphQLRequest.C14362;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEdits.SuggestEditsHeaderQueryString;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEdits.SuggestEditsSectionsQueryString;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsHeader;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsSections;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsHeaderModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsSectionsModel;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController.SuggestEditsPart;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED */
public class SuggestEditsLoader {
    private static volatile SuggestEditsLoader f17438c;
    private final FetchSuggestEditsGraphQLRequest f17439a;
    private final TasksManager<String> f17440b;

    public static com.facebook.crowdsourcing.loader.SuggestEditsLoader m21337a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17438c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.crowdsourcing.loader.SuggestEditsLoader.class;
        monitor-enter(r1);
        r0 = f17438c;	 Catch:{ all -> 0x003a }
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
        r0 = m21338b(r0);	 Catch:{ all -> 0x0035 }
        f17438c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17438c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.crowdsourcing.loader.SuggestEditsLoader.a(com.facebook.inject.InjectorLike):com.facebook.crowdsourcing.loader.SuggestEditsLoader");
    }

    private static SuggestEditsLoader m21338b(InjectorLike injectorLike) {
        return new SuggestEditsLoader(new FetchSuggestEditsGraphQLRequest(GraphQLQueryExecutor.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike)), TasksManager.b(injectorLike));
    }

    @Inject
    public SuggestEditsLoader(FetchSuggestEditsGraphQLRequest fetchSuggestEditsGraphQLRequest, TasksManager tasksManager) {
        this.f17439a = fetchSuggestEditsGraphQLRequest;
        this.f17440b = tasksManager;
    }

    public final void m21339a(String str, int i, final SuggestEditsController suggestEditsController) {
        TasksManager tasksManager = this.f17440b;
        String str2 = "key_load_suggest_edits_header" + str;
        FetchSuggestEditsGraphQLRequest fetchSuggestEditsGraphQLRequest = this.f17439a;
        GraphQlQueryString suggestEditsHeaderQueryString = new SuggestEditsHeaderQueryString();
        suggestEditsHeaderQueryString.a("page_id", str).a("image_size", String.valueOf(i));
        tasksManager.a(str2, Futures.a(fetchSuggestEditsGraphQLRequest.f17432a.a(GraphQLRequest.a(suggestEditsHeaderQueryString)), new C14362(fetchSuggestEditsGraphQLRequest), fetchSuggestEditsGraphQLRequest.f17433b), new AbstractDisposableFutureCallback<SuggestEditsHeader>(this) {
            final /* synthetic */ SuggestEditsLoader f17435b;

            protected final void m21333a(Object obj) {
                SuggestEditsHeaderModel suggestEditsHeaderModel = (SuggestEditsHeaderModel) obj;
                if (suggestEditsHeaderModel == null) {
                    suggestEditsController.m21477a(new Throwable("Empty result returned for Suggest Edits header GraphQL query"));
                    return;
                }
                SuggestEditsController suggestEditsController = suggestEditsController;
                suggestEditsController.f17635w.m21509a(suggestEditsHeaderModel);
                if (!SuggestEditsController.m21470b(suggestEditsHeaderModel)) {
                    suggestEditsController.f17637y.m21462a(SuggestEditsPart.HEADER);
                }
                suggestEditsController.f17638z.m21462a(SuggestEditsPart.HEADER);
            }

            protected final void m21334a(Throwable th) {
                suggestEditsController.m21477a(th);
            }
        });
    }

    public final void m21340a(String str, final SuggestEditsController suggestEditsController) {
        TasksManager tasksManager = this.f17440b;
        String str2 = "key_load_suggest_edits_sections" + str;
        FetchSuggestEditsGraphQLRequest fetchSuggestEditsGraphQLRequest = this.f17439a;
        GraphQlQueryString suggestEditsSectionsQueryString = new SuggestEditsSectionsQueryString();
        suggestEditsSectionsQueryString.a("page_id", str).a("scale", GraphQlQueryDefaults.a());
        tasksManager.a(str2, Futures.a(fetchSuggestEditsGraphQLRequest.f17432a.a(GraphQLRequest.a(suggestEditsSectionsQueryString)), new C14351(fetchSuggestEditsGraphQLRequest), fetchSuggestEditsGraphQLRequest.f17433b), new AbstractDisposableFutureCallback<SuggestEditsSections>(this) {
            final /* synthetic */ SuggestEditsLoader f17437b;

            protected final void m21335a(Object obj) {
                SuggestEditsSectionsModel suggestEditsSectionsModel = (SuggestEditsSectionsModel) obj;
                if (suggestEditsSectionsModel == null) {
                    suggestEditsController.m21479b(new Throwable("Empty result returned for Suggest Edits section GraphQL query"));
                    return;
                }
                SuggestEditsController suggestEditsController = suggestEditsController;
                suggestEditsController.f17634v = suggestEditsSectionsModel;
                suggestEditsController.f17633u.setVisibility(8);
                suggestEditsController.f17636x = suggestEditsController.f17624l.m21670a(suggestEditsController.f17631s, suggestEditsController, suggestEditsController.f17632t, suggestEditsSectionsModel, suggestEditsController.f17629q);
                if (suggestEditsController.f17636x.isEmpty()) {
                    suggestEditsController.f17637y.m21462a(SuggestEditsPart.SECTIONS);
                }
                suggestEditsController.f17638z.m21462a(SuggestEditsPart.SECTIONS);
            }

            protected final void m21336a(Throwable th) {
                suggestEditsController.m21479b(th);
            }
        });
    }
}
