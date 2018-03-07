package com.facebook.ufiservices.data;

import android.content.Context;
import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.api.ufiservices.FetchLikersMethod;
import com.facebook.api.ufiservices.common.FetchNodeListParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.Tuple;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feedback.events.FeedbackEvents.UpdateLikeFeedbackEvent;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.feed.ProfileListParamType;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ufiservices.flyout.ProfileListParams;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@ContextScoped
/* compiled from: dark_icon */
public class LikersProfilesLoader implements ProfilesListLoader {
    private static LikersProfilesLoader f17990f;
    private static final Object f17991g = new Object();
    public final EventsStream f17992a;
    private final DefaultAndroidThreadUtil f17993b;
    private FetchLikersMethod f17994c;
    private GraphQLQueryExecutor f17995d;
    private ExecutorService f17996e;

    /* compiled from: dark_icon */
    class C13011 implements Function<GraphQLResult<GraphQLFeedback>, Tuple<List<GraphQLActor>, GraphQLPageInfo>> {
        final /* synthetic */ LikersProfilesLoader f17989a;

        C13011(LikersProfilesLoader likersProfilesLoader) {
            this.f17989a = likersProfilesLoader;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                return null;
            }
            Tuple tuple;
            this.f17989a.f17992a.a(new UpdateLikeFeedbackEvent((GraphQLFeedback) graphQLResult.e));
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLResult.e;
            if (graphQLFeedback == null || GraphQLHelper.o(graphQLFeedback) == null || GraphQLHelper.o(graphQLFeedback).j().isEmpty()) {
                tuple = null;
            } else {
                GraphQLLikersOfContentConnection o = GraphQLHelper.o(graphQLFeedback);
                tuple = new Tuple(o.j(), GraphQLHelper.a(o));
            }
            return tuple;
        }
    }

    private static LikersProfilesLoader m26513b(InjectorLike injectorLike) {
        return new LikersProfilesLoader(EventsStream.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), new FetchLikersMethod(FetchFeedbackMethod.b(injectorLike), GraphQLStoryHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike)), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LikersProfilesLoader(EventsStream eventsStream, DefaultAndroidThreadUtil defaultAndroidThreadUtil, FetchLikersMethod fetchLikersMethod, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService) {
        this.f17992a = eventsStream;
        this.f17993b = defaultAndroidThreadUtil;
        this.f17994c = fetchLikersMethod;
        this.f17995d = graphQLQueryExecutor;
        this.f17996e = executorService;
    }

    public static LikersProfilesLoader m26512a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LikersProfilesLoader b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17991g) {
                LikersProfilesLoader likersProfilesLoader;
                if (a2 != null) {
                    likersProfilesLoader = (LikersProfilesLoader) a2.a(f17991g);
                } else {
                    likersProfilesLoader = f17990f;
                }
                if (likersProfilesLoader == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26513b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f17991g, b3);
                        } else {
                            f17990f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = likersProfilesLoader;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ProfileListParamType mo1345a() {
        return ProfileListParamType.LIKERS_FOR_FEEDBACK_ID;
    }

    public final void mo1346a(ProfileListParams profileListParams, AbstractDisposableFutureCallback<Tuple<List<GraphQLActor>, GraphQLPageInfo>> abstractDisposableFutureCallback, boolean z, String str, CallerContext callerContext) {
        this.f17993b.a(Futures.a(this.f17995d.a(this.f17994c.m10335a(new FetchNodeListParams(profileListParams.f18089a, 25, null, str, z ? DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA : DataFreshnessParam.STALE_DATA_OKAY), callerContext)), new C13011(this), this.f17996e), abstractDisposableFutureCallback);
    }

    public final boolean mo1347b() {
        return true;
    }
}
