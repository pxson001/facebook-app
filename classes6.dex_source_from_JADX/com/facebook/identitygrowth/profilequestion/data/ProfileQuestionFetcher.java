package com.facebook.identitygrowth.profilequestion.data;

import android.os.Bundle;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.identitygrowth.protocol.FetchProfileQuestionParams;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQL;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQL.ProfileQuestionQueryString;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionQueryModel;
import com.facebook.identitygrowth.protocol.SaveProfileQuestionParams;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mIsVideoMuted */
public class ProfileQuestionFetcher {
    private static volatile ProfileQuestionFetcher f11042c;
    private GraphQLQueryExecutor f11043a;
    private DefaultBlueServiceOperationFactory f11044b;

    public static com.facebook.identitygrowth.profilequestion.data.ProfileQuestionFetcher m17769a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11042c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.identitygrowth.profilequestion.data.ProfileQuestionFetcher.class;
        monitor-enter(r1);
        r0 = f11042c;	 Catch:{ all -> 0x003a }
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
        r0 = m17771b(r0);	 Catch:{ all -> 0x0035 }
        f11042c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11042c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.identitygrowth.profilequestion.data.ProfileQuestionFetcher.a(com.facebook.inject.InjectorLike):com.facebook.identitygrowth.profilequestion.data.ProfileQuestionFetcher");
    }

    private static ProfileQuestionFetcher m17771b(InjectorLike injectorLike) {
        return new ProfileQuestionFetcher(GraphQLQueryExecutor.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public ProfileQuestionFetcher(GraphQLQueryExecutor graphQLQueryExecutor, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f11043a = graphQLQueryExecutor;
        this.f11044b = defaultBlueServiceOperationFactory;
    }

    public final ListenableFuture<GraphQLResult<ProfileQuestionQueryModel>> m17772a(@Nonnull String str, @Nonnull String str2) {
        return m17770a(str, str2, null);
    }

    private ListenableFuture<GraphQLResult<ProfileQuestionQueryModel>> m17770a(@Nonnull String str, @Nonnull String str2, @Nullable String str3) {
        ProfileQuestionQueryString a = ProfileQuestionGraphQL.m17946a();
        GraphQlQueryString a2 = a.a("scale", GraphQlQueryDefaults.a()).a("ref", str);
        String str4 = "session";
        if (str3 == null) {
            str3 = "";
        }
        a2.a(str4, str3).a("surface", str2);
        return this.f11043a.a(GraphQLRequest.a(a));
    }

    public final ListenableFuture<OperationResult> m17773a(@Nullable String str, @Nonnull String str2, @Nullable String str3, @Nullable String str4, @Nonnull String str5, @Nonnull String str6, @Nonnull String str7, @Nonnull String str8) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saveProfileQuestionParams", new SaveProfileQuestionParams(str, str6, str2, str3, str4, str5));
        bundle.putParcelable("fetchProfileQuestionParams", new FetchProfileQuestionParams(str7, str8, str2));
        return BlueServiceOperationFactoryDetour.a(this.f11044b, "identitygrowth_save_profile_question", bundle, -1425667731).a();
    }
}
