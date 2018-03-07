package com.facebook.ufiservices.data;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.Tuple;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActor.Builder;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.feed.ProfileListParamType;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ufiservices.flyout.ProfileListParams;
import com.facebook.ufiservices.graphql.FetchProfilesGraphQL.FetchProfilesQueryString;
import com.facebook.ufiservices.graphql.FetchProfilesGraphQLModels.FetchProfilesQueryModel;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: daily_dialogue_contact_importer */
public class ProfilesByIdsLoader implements ProfilesListLoader {
    private static ProfilesByIdsLoader f17998e;
    private static final Object f17999f = new Object();
    private final GraphQLQueryExecutor f18000a;
    private final GraphQLStoryHelper f18001b;
    private final GraphQLImageHelper f18002c;
    private final DefaultAndroidThreadUtil f18003d;

    /* compiled from: daily_dialogue_contact_importer */
    class C13021 implements Function<List<FetchProfilesQueryModel>, Tuple<List<GraphQLActor>, GraphQLPageInfo>> {
        final /* synthetic */ ProfilesByIdsLoader f17997a;

        C13021(ProfilesByIdsLoader profilesByIdsLoader) {
            this.f17997a = profilesByIdsLoader;
        }

        public Object apply(Object obj) {
            List<FetchProfilesQueryModel> list = (List) obj;
            if (list == null) {
                return null;
            }
            List arrayList = new ArrayList();
            for (FetchProfilesQueryModel fetchProfilesQueryModel : list) {
                GraphQLImage a = GraphQLHelper.a(fetchProfilesQueryModel.m26774n().b(), 0, 0);
                GraphQLObjectType j = fetchProfilesQueryModel.m26770j();
                Builder builder = new Builder();
                builder.B = fetchProfilesQueryModel.m26772l();
                builder = builder;
                builder.V = fetchProfilesQueryModel.m26773m();
                builder = builder;
                builder.ad = a;
                Builder builder2 = builder;
                builder2.aH = j;
                arrayList.add(builder2.a(fetchProfilesQueryModel.m26771k()).a());
            }
            return new Tuple(arrayList, GraphQLHelper.a(null, null, false, false));
        }
    }

    private static ProfilesByIdsLoader m26518b(InjectorLike injectorLike) {
        return new ProfilesByIdsLoader(GraphQLQueryExecutor.a(injectorLike), GraphQLStoryHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public ProfilesByIdsLoader(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f18000a = graphQLQueryExecutor;
        this.f18001b = graphQLStoryHelper;
        this.f18002c = graphQLImageHelper;
        this.f18003d = defaultAndroidThreadUtil;
    }

    public static ProfilesByIdsLoader m26517a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProfilesByIdsLoader b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17999f) {
                ProfilesByIdsLoader profilesByIdsLoader;
                if (a2 != null) {
                    profilesByIdsLoader = (ProfilesByIdsLoader) a2.a(f17999f);
                } else {
                    profilesByIdsLoader = f17998e;
                }
                if (profilesByIdsLoader == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26518b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f17999f, b3);
                        } else {
                            f17998e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = profilesByIdsLoader;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void mo1346a(ProfileListParams profileListParams, AbstractDisposableFutureCallback<Tuple<List<GraphQLActor>, GraphQLPageInfo>> abstractDisposableFutureCallback, boolean z, String str, CallerContext callerContext) {
        this.f18003d.a(Futures.a(GraphQLQueryExecutor.b(this.f18000a.a(GraphQLRequest.a((FetchProfilesQueryString) new FetchProfilesQueryString().a("profile_ids", profileListParams.m26566b()).a("profile_image_size", this.f18001b.c()).a("profile_pic_media_type", this.f18002c.b())).a(GraphQLCachePolicy.c))), new C13021(this), MoreExecutors.a()), abstractDisposableFutureCallback);
    }

    public final ProfileListParamType mo1345a() {
        return ProfileListParamType.PROFILES_BY_IDS;
    }

    public final boolean mo1347b() {
        return false;
    }
}
