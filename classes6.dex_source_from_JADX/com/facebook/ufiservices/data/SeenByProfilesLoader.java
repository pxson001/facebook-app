package com.facebook.ufiservices.data;

import android.content.Context;
import com.facebook.api.graphql.seenby.FetchSeenByGraphQL.FetchSeenByString;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.Tuple;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLSeenByConnection;
import com.facebook.graphql.query.GraphQlQueryString;
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
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@ContextScoped
/* compiled from: daa77ca52d9fe4b2127efc171851dca8 */
public class SeenByProfilesLoader implements ProfilesListLoader {
    private static SeenByProfilesLoader f18007f;
    private static final Object f18008g = new Object();
    private final DefaultAndroidThreadUtil f18009a;
    private final GraphQLStoryHelper f18010b;
    private final GraphQLImageHelper f18011c;
    private GraphQLQueryExecutor f18012d;
    private ExecutorService f18013e;

    /* compiled from: daa77ca52d9fe4b2127efc171851dca8 */
    class C13031 implements Function<GraphQLResult<GraphQLNode>, Tuple<List<GraphQLActor>, GraphQLPageInfo>> {
        final /* synthetic */ SeenByProfilesLoader f18006a;

        C13031(SeenByProfilesLoader seenByProfilesLoader) {
            this.f18006a = seenByProfilesLoader;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                return null;
            }
            Tuple tuple;
            GraphQLNode graphQLNode = (GraphQLNode) graphQLResult.e;
            if (graphQLNode == null || graphQLNode.gR() == null || GraphQLHelper.b(graphQLNode.gR()).isEmpty()) {
                tuple = null;
            } else {
                GraphQLSeenByConnection gR = graphQLNode.gR();
                tuple = new Tuple(GraphQLHelper.b(gR), gR.k() == null ? new GraphQLPageInfo() : gR.k());
            }
            return tuple;
        }
    }

    private static SeenByProfilesLoader m26523b(InjectorLike injectorLike) {
        return new SeenByProfilesLoader(DefaultAndroidThreadUtil.b(injectorLike), GraphQLStoryHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SeenByProfilesLoader(DefaultAndroidThreadUtil defaultAndroidThreadUtil, GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService) {
        this.f18009a = defaultAndroidThreadUtil;
        this.f18010b = graphQLStoryHelper;
        this.f18011c = graphQLImageHelper;
        this.f18012d = graphQLQueryExecutor;
        this.f18013e = executorService;
    }

    public static SeenByProfilesLoader m26522a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SeenByProfilesLoader b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18008g) {
                SeenByProfilesLoader seenByProfilesLoader;
                if (a2 != null) {
                    seenByProfilesLoader = (SeenByProfilesLoader) a2.a(f18008g);
                } else {
                    seenByProfilesLoader = f18007f;
                }
                if (seenByProfilesLoader == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26523b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18008g, b3);
                        } else {
                            f18007f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = seenByProfilesLoader;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ProfileListParamType mo1345a() {
        return ProfileListParamType.SEEN_BY_FOR_FEEDBACK_ID;
    }

    public final void mo1346a(ProfileListParams profileListParams, AbstractDisposableFutureCallback<Tuple<List<GraphQLActor>, GraphQLPageInfo>> abstractDisposableFutureCallback, boolean z, String str, CallerContext callerContext) {
        GraphQlQueryString fetchSeenByString = new FetchSeenByString();
        fetchSeenByString.a("profile_image_size", GraphQLStoryHelper.a()).a("profile_pic_media_type", this.f18011c.b()).a("feedback_id", profileListParams.f18089a).a("max_seen_by", "25").a("after_seen_by", str);
        this.f18009a.a(Futures.a(this.f18012d.a(GraphQLRequest.a(fetchSeenByString).a(GraphQLCachePolicy.c)), new C13031(this), this.f18013e), abstractDisposableFutureCallback);
    }

    public final boolean mo1347b() {
        return true;
    }
}
