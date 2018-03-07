package com.facebook.tagging.graphql.data;

import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.data.TagTypeaheadDataSource.SourceResultsListener;
import com.facebook.tagging.data.TagTypeaheadDataSource.TagTypeaheadDataType;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQL;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQL.TagSearchString;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLModels.FBTagSearchProfileModel;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLModels.TagSearchModel;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.user.model.Name;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: dest_latitude */
public class GraphQLTaggingDataSource extends TagTypeaheadDataSource {
    public static final Class<?> f17426a = GraphQLTaggingDataSource.class;
    private static final Object f17427f = new Object();
    private final GraphQLQueryExecutor f17428b;
    private final ViewerContext f17429c;
    private final TaggingProfiles f17430d;
    private final Provider<String> f17431e;

    private static GraphQLTaggingDataSource m25244b(InjectorLike injectorLike) {
        return new GraphQLTaggingDataSource(GraphQLQueryExecutor.a(injectorLike), ViewerContextMethodAutoProvider.b(injectorLike), TaggingProfiles.m25203b(injectorLike), IdBasedProvider.a(injectorLike, 4443));
    }

    @Inject
    public GraphQLTaggingDataSource(GraphQLQueryExecutor graphQLQueryExecutor, ViewerContext viewerContext, TaggingProfiles taggingProfiles, Provider<String> provider) {
        this.f17428b = graphQLQueryExecutor;
        this.f17429c = viewerContext;
        this.f17430d = taggingProfiles;
        this.f17431e = provider;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.tagging.graphql.data.GraphQLTaggingDataSource m25241a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f17427f;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m25244b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f17427f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.tagging.graphql.data.GraphQLTaggingDataSource) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.tagging.graphql.data.GraphQLTaggingDataSource) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f17427f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.tagging.graphql.data.GraphQLTaggingDataSource) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tagging.graphql.data.GraphQLTaggingDataSource.a(com.facebook.inject.InjectorLike):com.facebook.tagging.graphql.data.GraphQLTaggingDataSource");
    }

    public final void mo1314a(CharSequence charSequence, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, SourceResultsListener sourceResultsListener) {
        if (charSequence.length() < 3) {
            sourceResultsListener.mo1121a(charSequence, null);
            return;
        }
        TagSearchString a = TagSearchGraphQL.m25372a();
        a.a("search_key", charSequence.toString()).a("result_type", this.f17429c.d() ? "mobile_pages_manager_tagger" : "mobile_android_tagger");
        final boolean z6 = z;
        final boolean z7 = z2;
        final boolean z8 = z3;
        final SourceResultsListener sourceResultsListener2 = sourceResultsListener;
        final CharSequence charSequence2 = charSequence;
        Futures.a(this.f17428b.a(GraphQLRequest.a(a)), new FutureCallback<GraphQLResult<TagSearchModel>>(this) {
            final /* synthetic */ GraphQLTaggingDataSource f17425f;

            public void onSuccess(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                List a = Lists.a();
                ImmutableList a2 = ((TagSearchModel) graphQLResult.d()).m25463a().m25459a();
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    FBTagSearchProfileModel fBTagSearchProfileModel = (FBTagSearchProfileModel) a2.get(i);
                    if (fBTagSearchProfileModel != null) {
                        try {
                            Type a3 = GraphQLTaggingDataSource.m25242a(this.f17425f, fBTagSearchProfileModel);
                            if ((z6 || a3 != Type.SELF) && ((z7 || a3 != Type.USER) && (z8 || a3 != Type.PAGE))) {
                                a.add(GraphQLTaggingDataSource.m25243a(this.f17425f, fBTagSearchProfileModel, "graphql_search", TagTypeaheadDataType.OTHERS.toString()));
                            }
                        } catch (Throwable e) {
                            BLog.a(GraphQLTaggingDataSource.f17426a, "Error handling tag search result", e);
                        }
                    }
                }
                sourceResultsListener2.mo1121a(charSequence2, a);
            }

            public void onFailure(Throwable th) {
            }
        });
    }

    public static TaggingProfile m25243a(GraphQLTaggingDataSource graphQLTaggingDataSource, FBTagSearchProfileModel fBTagSearchProfileModel, String str, String str2) {
        String str3;
        if (graphQLTaggingDataSource.f17429c.mIsPageContext || fBTagSearchProfileModel.m25453n() == null) {
            str3 = null;
        } else {
            str3 = fBTagSearchProfileModel.m25453n().m25443a();
        }
        return graphQLTaggingDataSource.f17430d.m25207a(new Name(null, null, fBTagSearchProfileModel.m25451l()), Long.parseLong(fBTagSearchProfileModel.m25450k()), fBTagSearchProfileModel.m25452m().m25437a(), m25242a(graphQLTaggingDataSource, fBTagSearchProfileModel), str3, str, str2);
    }

    public static Type m25242a(GraphQLTaggingDataSource graphQLTaggingDataSource, FBTagSearchProfileModel fBTagSearchProfileModel) {
        String str = (String) graphQLTaggingDataSource.f17431e.get();
        if (str == null || !str.equals(fBTagSearchProfileModel.m25450k())) {
            return TaggingProfile.m25527a(fBTagSearchProfileModel.m25449j());
        }
        return Type.SELF;
    }

    public final boolean mo1315a() {
        return true;
    }

    public final String mo1316b() {
        return "graphql_search";
    }
}
