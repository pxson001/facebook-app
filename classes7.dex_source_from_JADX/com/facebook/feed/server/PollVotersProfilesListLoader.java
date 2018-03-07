package com.facebook.feed.server;

import android.content.Context;
import com.facebook.api.graphql.poll.FetchPollVotersGraphQL.FetchPollVotersString;
import com.facebook.api.graphql.poll.FetchPollVotersGraphQLModels.FetchPollVotersModel;
import com.facebook.api.graphql.poll.FetchPollVotersGraphQLModels.FetchPollVotersModel.VotersModel;
import com.facebook.api.graphql.poll.FetchPollVotersGraphQLModels.FetchPollVotersModel.VotersModel.NodesModel;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.Tuple;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
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
import com.facebook.ufiservices.data.ProfilesListLoader;
import com.facebook.ufiservices.flyout.ProfileListParams;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: UG Launcher holder view not available */
public class PollVotersProfilesListLoader implements ProfilesListLoader {
    private static PollVotersProfilesListLoader f21641e;
    private static final Object f21642f = new Object();
    public final GraphQLQueryExecutor f21643a;
    public final GraphQLStoryHelper f21644b;
    public final GraphQLImageHelper f21645c;
    private final DefaultAndroidThreadUtil f21646d;

    /* compiled from: UG Launcher holder view not available */
    public class C18131 implements Function<GraphQLResult<FetchPollVotersModel>, Tuple<List<GraphQLActor>, GraphQLPageInfo>> {
        final /* synthetic */ PollVotersProfilesListLoader f21640a;

        public C18131(PollVotersProfilesListLoader pollVotersProfilesListLoader) {
            this.f21640a = pollVotersProfilesListLoader;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return null;
            }
            List arrayList = new ArrayList();
            VotersModel a = ((FetchPollVotersModel) graphQLResult.e).m667a();
            if (a == null) {
                return null;
            }
            ImmutableList a2 = a.m664a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                NodesModel nodesModel = (NodesModel) a2.get(i);
                GraphQLImage a3 = GraphQLHelper.a(nodesModel.ho_().b(), 0, 0);
                Builder builder = new Builder();
                builder.B = nodesModel.m649c();
                builder = builder;
                builder.V = nodesModel.m650d();
                builder = builder;
                builder.ad = a3;
                Builder builder2 = builder;
                builder2.at = nodesModel.ho_().b();
                builder2 = builder2;
                builder2.aH = new GraphQLObjectType(2645995);
                arrayList.add(builder2.a(nodesModel.m648b()).a());
            }
            return new Tuple(arrayList, GraphQLHelper.a(a.m665j().m660l(), a.m665j().m656a(), a.m665j().m659k(), a.m665j().m658j()));
        }
    }

    private static PollVotersProfilesListLoader m24230b(InjectorLike injectorLike) {
        return new PollVotersProfilesListLoader(GraphQLQueryExecutor.a(injectorLike), GraphQLStoryHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public PollVotersProfilesListLoader(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f21643a = graphQLQueryExecutor;
        this.f21644b = graphQLStoryHelper;
        this.f21645c = graphQLImageHelper;
        this.f21646d = defaultAndroidThreadUtil;
    }

    public final ProfileListParamType m24231a() {
        return ProfileListParamType.VOTERS_FOR_POLL_OPTION_ID;
    }

    public static PollVotersProfilesListLoader m24229a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PollVotersProfilesListLoader b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21642f) {
                PollVotersProfilesListLoader pollVotersProfilesListLoader;
                if (a2 != null) {
                    pollVotersProfilesListLoader = (PollVotersProfilesListLoader) a2.a(f21642f);
                } else {
                    pollVotersProfilesListLoader = f21641e;
                }
                if (pollVotersProfilesListLoader == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24230b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21642f, b3);
                        } else {
                            f21641e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pollVotersProfilesListLoader;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m24232a(ProfileListParams profileListParams, AbstractDisposableFutureCallback<Tuple<List<GraphQLActor>, GraphQLPageInfo>> abstractDisposableFutureCallback, boolean z, String str, CallerContext callerContext) {
        this.f21646d.a(Futures.a(this.f21643a.a(GraphQLRequest.a((FetchPollVotersString) new FetchPollVotersString().a("poll_option_id", profileListParams.a).a("profile_image_size", this.f21644b.c()).a("profile_pic_media_type", this.f21645c.b()).a("after_poll_option_voters", str).a("max_poll_option_voters", Integer.valueOf(15))).a(GraphQLCachePolicy.c)), new C18131(this), MoreExecutors.a()), abstractDisposableFutureCallback);
    }

    public final boolean m24233b() {
        return true;
    }
}
