package com.facebook.appinvites.data;

import com.facebook.appinvites.protocol.AppInvitesMutations.AppRequestBlockApplicationCoreMutationString;
import com.facebook.appinvites.protocol.AppInvitesMutations.AppRequestBlockUserCoreMutationString;
import com.facebook.graphql.calls.ApplicationRequestBlockApplicationInputData;
import com.facebook.graphql.calls.ApplicationRequestBlockUserInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: edit_group_notif_setting */
public class AppInvitesGraphqlMutationHelper {
    private static volatile AppInvitesGraphqlMutationHelper f14576b;
    public final GraphQLQueryExecutor f14577a;

    public static com.facebook.appinvites.data.AppInvitesGraphqlMutationHelper m14748a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14576b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.appinvites.data.AppInvitesGraphqlMutationHelper.class;
        monitor-enter(r1);
        r0 = f14576b;	 Catch:{ all -> 0x003a }
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
        r0 = m14749b(r0);	 Catch:{ all -> 0x0035 }
        f14576b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14576b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appinvites.data.AppInvitesGraphqlMutationHelper.a(com.facebook.inject.InjectorLike):com.facebook.appinvites.data.AppInvitesGraphqlMutationHelper");
    }

    private static AppInvitesGraphqlMutationHelper m14749b(InjectorLike injectorLike) {
        return new AppInvitesGraphqlMutationHelper(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public AppInvitesGraphqlMutationHelper(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f14577a = graphQLQueryExecutor;
    }

    public final void m14751b(String str) {
        ApplicationRequestBlockApplicationInputData applicationRequestBlockApplicationInputData = new ApplicationRequestBlockApplicationInputData();
        applicationRequestBlockApplicationInputData.a("application_id", str);
        this.f14577a.a(GraphQLRequest.a((AppRequestBlockApplicationCoreMutationString) new AppRequestBlockApplicationCoreMutationString().a("input", applicationRequestBlockApplicationInputData)));
    }

    public final void m14750a(String str, String str2) {
        ApplicationRequestBlockUserInputData applicationRequestBlockUserInputData = new ApplicationRequestBlockUserInputData();
        applicationRequestBlockUserInputData.a("user_id", str);
        GraphQlCallInput graphQlCallInput = applicationRequestBlockUserInputData;
        graphQlCallInput.a("application_id", str2);
        this.f14577a.a(GraphQLRequest.a((AppRequestBlockUserCoreMutationString) new AppRequestBlockUserCoreMutationString().a("input", graphQlCallInput)));
    }
}
