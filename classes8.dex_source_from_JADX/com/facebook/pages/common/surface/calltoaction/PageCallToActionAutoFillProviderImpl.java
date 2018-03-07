package com.facebook.pages.common.surface.calltoaction;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.surface.calltoaction.graphql.PageCallToActionAutoFillGraphQL.PageCallToActionAutoFillQueryString;
import com.facebook.ui.futures.TasksManager;
import java.util.HashSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: creation_entered */
public class PageCallToActionAutoFillProviderImpl {
    private static volatile PageCallToActionAutoFillProviderImpl f16611e;
    public final GraphQLQueryExecutor f16612a;
    private final TasksManager f16613b;
    public final Lazy<FbErrorReporter> f16614c;
    public final HashSet<String> f16615d = new HashSet();

    /* compiled from: creation_entered */
    class C17961 extends AbstractDisposableFutureCallback<Object> {
        final /* synthetic */ PageCallToActionAutoFillProviderImpl f16610a;

        C17961(PageCallToActionAutoFillProviderImpl pageCallToActionAutoFillProviderImpl) {
            this.f16610a = pageCallToActionAutoFillProviderImpl;
        }

        protected final void m19647a(Throwable th) {
            ((AbstractFbErrorReporter) this.f16610a.f16614c.get()).a(PageCallToActionAutoFillProviderImpl.class.getSimpleName(), th);
        }
    }

    public static com.facebook.pages.common.surface.calltoaction.PageCallToActionAutoFillProviderImpl m19648a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16611e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.common.surface.calltoaction.PageCallToActionAutoFillProviderImpl.class;
        monitor-enter(r1);
        r0 = f16611e;	 Catch:{ all -> 0x003a }
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
        r0 = m19649b(r0);	 Catch:{ all -> 0x0035 }
        f16611e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16611e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.calltoaction.PageCallToActionAutoFillProviderImpl.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.surface.calltoaction.PageCallToActionAutoFillProviderImpl");
    }

    private static PageCallToActionAutoFillProviderImpl m19649b(InjectorLike injectorLike) {
        return new PageCallToActionAutoFillProviderImpl(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public PageCallToActionAutoFillProviderImpl(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, Lazy<FbErrorReporter> lazy) {
        this.f16612a = graphQLQueryExecutor;
        this.f16613b = tasksManager;
        this.f16614c = lazy;
    }

    public final void m19650a() {
        this.f16613b.a("fetch_auto_fill_data", GraphQLQueryExecutor.a(this.f16612a.a(GraphQLRequest.a(new PageCallToActionAutoFillQueryString()).a(GraphQLCachePolicy.a).a(172800))), new C17961(this));
    }
}
