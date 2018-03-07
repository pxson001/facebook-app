package com.facebook.photos.tagging.shared;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.tagging.shared.protocols.FamilyNonUserMemberTagQuery.FamilyNonUserMemberTagQueryString;
import com.facebook.photos.tagging.shared.protocols.FamilyNonUserMemberTagQueryModels.FamilyNonUserMemberTagQueryModel;
import com.facebook.photos.tagging.shared.protocols.FamilyNonUserMemberTagQueryModels.FamilyNonUserMemberTagQueryModel.FamilyNonUserMembersModel.EdgesModel;
import com.facebook.photos.tagging.shared.protocols.FamilyNonUserMemberTagQueryModels.FamilyNonUserMemberTagQueryModel.FamilyNonUserMembersModel.EdgesModel.NodeModel;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.model.TaggingProfile.Builder;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.user.model.Name;
import com.facebook.user.names.NameNormalizer;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: has_more_friends */
public class FamilyTagTypeaheadUtil {
    private static final List<TaggingProfile> f13296a = Lists.a();
    private static final Object f13297k = new Object();
    private final Provider<String> f13298b;
    private Lazy<GraphQLQueryExecutor> f13299c;
    public NameNormalizer f13300d;
    private Provider<Boolean> f13301e;
    private GraphQLImageHelper f13302f;
    private GraphQLStoryHelper f13303g;
    public AbstractFbErrorReporter f13304h;
    public List<TaggingProfile> f13305i = f13296a;
    public boolean f13306j = false;

    /* compiled from: has_more_friends */
    class C08541 implements FutureCallback<GraphQLResult<FamilyNonUserMemberTagQueryModel>> {
        final /* synthetic */ FamilyTagTypeaheadUtil f13295a;

        C08541(FamilyTagTypeaheadUtil familyTagTypeaheadUtil) {
            this.f13295a = familyTagTypeaheadUtil;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            FamilyTagTypeaheadUtil familyTagTypeaheadUtil = this.f13295a;
            String str = null;
            if (!(graphQLResult == null || graphQLResult.e == null || ((FamilyNonUserMemberTagQueryModel) graphQLResult.e).m21117j() == null || ((FamilyNonUserMemberTagQueryModel) graphQLResult.e).m21117j().m21109a() == null)) {
                List a = Lists.a();
                int size = ((FamilyNonUserMemberTagQueryModel) graphQLResult.e).m21117j().m21109a().size();
                for (int i = 0; i < size; i++) {
                    String str2;
                    NodeModel a2 = ((EdgesModel) ((FamilyNonUserMemberTagQueryModel) graphQLResult.e).m21117j().m21109a().get(i)).m21105a();
                    Name name = new Name(null, a2.m21100k().toString(), null);
                    String toLowerCase = a2.m21100k().toLowerCase(Locale.getDefault());
                    long parseLong = Long.parseLong(a2.m21099j());
                    if (a2.m21101l() == null || a2.m21101l().m21094a() == null) {
                        str2 = null;
                    } else {
                        str2 = a2.m21101l().m21094a();
                    }
                    Builder builder = new Builder();
                    builder.f17529a = name;
                    Builder builder2 = builder;
                    builder2.f17535g = familyTagTypeaheadUtil.f13300d.a(toLowerCase);
                    builder2 = builder2;
                    builder2.f17534f = toLowerCase;
                    builder2 = builder2;
                    builder2.f17530b = parseLong;
                    builder2 = builder2;
                    builder2.f17533e = Type.FAMILY_NONUSER_MEMBER;
                    builder2 = builder2;
                    builder2.f17531c = str2;
                    a.add(builder2.m25525j());
                }
                Object obj2 = a;
            }
            String str3 = str;
            if (str3 != null) {
                this.f13295a.f13305i = str3;
            }
            this.f13295a.f13306j = false;
        }

        public void onFailure(Throwable th) {
            this.f13295a.f13304h.a("familyTagTypeahead", "Could not fetch family tags: ", th);
            this.f13295a.f13306j = false;
        }
    }

    private static FamilyTagTypeaheadUtil m20959b(InjectorLike injectorLike) {
        return new FamilyTagTypeaheadUtil(IdBasedProvider.a(injectorLike, 4442), IdBasedLazy.a(injectorLike, 2164), NameNormalizer.b(injectorLike), IdBasedProvider.a(injectorLike, 4253), GraphQLImageHelper.a(injectorLike), GraphQLStoryHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.photos.tagging.shared.FamilyTagTypeaheadUtil m20957a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f13297k;	 Catch:{ all -> 0x006c }
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
        r1 = m20959b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f13297k;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.photos.tagging.shared.FamilyTagTypeaheadUtil) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.photos.tagging.shared.FamilyTagTypeaheadUtil) r0;	 Catch:{  }
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
        r0 = f13297k;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.photos.tagging.shared.FamilyTagTypeaheadUtil) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.tagging.shared.FamilyTagTypeaheadUtil.a(com.facebook.inject.InjectorLike):com.facebook.photos.tagging.shared.FamilyTagTypeaheadUtil");
    }

    @Inject
    public FamilyTagTypeaheadUtil(Provider<String> provider, Lazy<GraphQLQueryExecutor> lazy, NameNormalizer nameNormalizer, Provider<Boolean> provider2, GraphQLImageHelper graphQLImageHelper, GraphQLStoryHelper graphQLStoryHelper, FbErrorReporter fbErrorReporter) {
        this.f13298b = provider;
        this.f13299c = lazy;
        this.f13300d = nameNormalizer;
        this.f13301e = provider2;
        this.f13302f = graphQLImageHelper;
        this.f13303g = graphQLStoryHelper;
        this.f13304h = fbErrorReporter;
    }

    private ListenableFuture<GraphQLResult<FamilyNonUserMemberTagQueryModel>> m20958a(String str) {
        GraphQlQueryString familyNonUserMemberTagQueryString = new FamilyNonUserMemberTagQueryString();
        familyNonUserMemberTagQueryString.a("targetId", str).a("profile_media_type", this.f13302f.b()).a("profile_image_size", GraphQLStoryHelper.a());
        return ((GraphQLQueryExecutor) this.f13299c.get()).a(GraphQLRequest.a(familyNonUserMemberTagQueryString).a(GraphQLCachePolicy.a).a(60));
    }

    private boolean m20960c() {
        return ((Boolean) this.f13301e.get()).booleanValue();
    }

    public final List<TaggingProfile> m20961a() {
        m20962b();
        return this.f13305i;
    }

    public final synchronized void m20962b() {
        if (m20960c() && !this.f13306j) {
            ListenableFuture a = m20958a((String) this.f13298b.get());
            this.f13306j = true;
            Futures.a(a, new C08541(this), MoreExecutors.a());
        }
    }
}
