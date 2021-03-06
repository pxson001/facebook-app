package com.facebook.securitycheckup;

import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.SecurityCheckupLoggingInputData;
import com.facebook.graphql.calls.SecurityCheckupLoggingInputData.Event;
import com.facebook.graphql.calls.SecurityCheckupLoggingInputData.Source;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.securitycheckup.api.SecurityCheckupLoggingMutation.SecurityCheckupLoggingMutationString;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: inbox_recommend_video */
public class SecurityCheckupLogger {
    private static volatile SecurityCheckupLogger f9672c;
    private Lazy<GraphQLQueryExecutor> f9673a;
    private Source f9674b = Source.QP;

    public static com.facebook.securitycheckup.SecurityCheckupLogger m9901a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9672c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.securitycheckup.SecurityCheckupLogger.class;
        monitor-enter(r1);
        r0 = f9672c;	 Catch:{ all -> 0x003a }
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
        r0 = m9902b(r0);	 Catch:{ all -> 0x0035 }
        f9672c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9672c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.securitycheckup.SecurityCheckupLogger.a(com.facebook.inject.InjectorLike):com.facebook.securitycheckup.SecurityCheckupLogger");
    }

    private static SecurityCheckupLogger m9902b(InjectorLike injectorLike) {
        return new SecurityCheckupLogger(IdBasedLazy.a(injectorLike, 2164));
    }

    @Inject
    public SecurityCheckupLogger(Lazy<GraphQLQueryExecutor> lazy) {
        this.f9673a = lazy;
    }

    public final void m9903a(Event event) {
        SecurityCheckupLoggingInputData securityCheckupLoggingInputData = new SecurityCheckupLoggingInputData();
        securityCheckupLoggingInputData.a("event", event);
        GraphQlCallInput graphQlCallInput = securityCheckupLoggingInputData;
        graphQlCallInput.a("source", this.f9674b);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString securityCheckupLoggingMutationString = new SecurityCheckupLoggingMutationString();
        securityCheckupLoggingMutationString.a("input", graphQlCallInput);
        ((GraphQLQueryExecutor) this.f9673a.get()).a(GraphQLRequest.a(securityCheckupLoggingMutationString));
    }

    public final void m9904a(Source source) {
        this.f9674b = source;
    }
}
