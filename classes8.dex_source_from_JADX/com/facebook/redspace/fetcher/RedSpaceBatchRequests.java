package com.facebook.redspace.fetcher;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.executor.RequestObservable.6;
import com.facebook.graphql.executor.RequestObservable.ZipFunc2;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceStoriesQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceUnreadFriendsQueryModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceVisitsQueryModel;
import rx.Observable;

@ContextScoped
/* compiled from: USER_UNFOCUSED_MEDIA */
public class RedSpaceBatchRequests {
    private static RedSpaceBatchRequests f21316a;
    private static final Object f21317b = new Object();

    /* compiled from: USER_UNFOCUSED_MEDIA */
    class C22701 implements ZipFunc2<GraphQLResult<RedSpaceFriendsQueryModel>, GraphQLResult<RedSpaceFriendsQueryModel>, RedSpaceFriendsWithFriendsResult> {
        final /* synthetic */ RedSpaceBatchRequests f21308a;

        C22701(RedSpaceBatchRequests redSpaceBatchRequests) {
            this.f21308a = redSpaceBatchRequests;
        }

        public final Object m24926a(Object obj, Object obj2) {
            return new RedSpaceFriendsWithFriendsResult((GraphQLResult) obj, (GraphQLResult) obj2);
        }
    }

    /* compiled from: USER_UNFOCUSED_MEDIA */
    class C22712 implements ZipFunc2<GraphQLResult<RedSpaceFriendsQueryModel>, GraphQLResult<RedSpaceFriendsOverflowCountQueryModel>, RedSpaceFriendsWithOverflowResult> {
        final /* synthetic */ RedSpaceBatchRequests f21309a;

        C22712(RedSpaceBatchRequests redSpaceBatchRequests) {
            this.f21309a = redSpaceBatchRequests;
        }

        public final Object m24927a(Object obj, Object obj2) {
            return new RedSpaceFriendsWithOverflowResult((GraphQLResult) obj, (GraphQLResult) obj2);
        }
    }

    /* compiled from: USER_UNFOCUSED_MEDIA */
    public class C22723 {
        final /* synthetic */ RedSpaceBatchRequests f21310a;

        C22723(RedSpaceBatchRequests redSpaceBatchRequests) {
            this.f21310a = redSpaceBatchRequests;
        }

        public final Object m24928a(Object obj, Object obj2, Object obj3) {
            return new RedSpaceTabBadgeWithFriendsResult((GraphQLResult) obj, (GraphQLResult) obj2, (GraphQLResult) obj3);
        }
    }

    /* compiled from: USER_UNFOCUSED_MEDIA */
    public class C22734 implements ZipFunc2<GraphQLResult<RedSpaceStoriesQueryModel>, GraphQLResult<RedSpaceVisitsQueryModel>, RedSpaceWallResult> {
        final /* synthetic */ RedSpaceBatchRequests f21311a;

        public C22734(RedSpaceBatchRequests redSpaceBatchRequests) {
            this.f21311a = redSpaceBatchRequests;
        }

        public final Object m24929a(Object obj, Object obj2) {
            return new RedSpaceWallResult((GraphQLResult) obj, (GraphQLResult) obj2);
        }
    }

    /* compiled from: USER_UNFOCUSED_MEDIA */
    public class C22745 implements ZipFunc2<GraphQLResult<RedSpaceFeedProfileFragmentModel>, GraphQLResult<RedSpaceVisitsQueryModel>, RedSpaceProfileWithVisitsResult> {
        final /* synthetic */ RedSpaceBatchRequests f21312a;

        public C22745(RedSpaceBatchRequests redSpaceBatchRequests) {
            this.f21312a = redSpaceBatchRequests;
        }

        public final Object m24930a(Object obj, Object obj2) {
            return new RedSpaceProfileWithVisitsResult((GraphQLResult) obj, (GraphQLResult) obj2);
        }
    }

    /* compiled from: USER_UNFOCUSED_MEDIA */
    class RedSpaceBatchResult2<T, U> {
        private GraphQLResult<T> f21313a;
        private GraphQLResult<U> f21314b;

        public RedSpaceBatchResult2(GraphQLResult<T> graphQLResult, GraphQLResult<U> graphQLResult2) {
            this.f21313a = graphQLResult;
            this.f21314b = graphQLResult2;
        }

        public GraphQLResult<T> mo1159a() {
            return this.f21313a;
        }

        public GraphQLResult<U> mo1160b() {
            return this.f21314b;
        }

        public String toString() {
            return "RedSpaceBatchResult2{mResult1=" + this.f21313a + ", mResult2=" + this.f21314b + "} " + super.toString();
        }
    }

    /* compiled from: USER_UNFOCUSED_MEDIA */
    class RedSpaceBatchResult3<T, U, V> extends RedSpaceBatchResult2<T, U> {
        private GraphQLResult<V> f21315a;

        public RedSpaceBatchResult3(GraphQLResult<T> graphQLResult, GraphQLResult<U> graphQLResult2, GraphQLResult<V> graphQLResult3) {
            super(graphQLResult, graphQLResult2);
            this.f21315a = graphQLResult3;
        }

        public GraphQLResult<V> m24933c() {
            return this.f21315a;
        }

        public String toString() {
            return "RedSpaceBatchResult3{mResult3=" + this.f21315a + "} " + super.toString();
        }
    }

    /* compiled from: USER_UNFOCUSED_MEDIA */
    public class RedSpaceFriendsWithFriendsResult extends RedSpaceBatchResult2<RedSpaceFriendsQueryModel, RedSpaceFriendsQueryModel> {
        public RedSpaceFriendsWithFriendsResult(GraphQLResult<RedSpaceFriendsQueryModel> graphQLResult, GraphQLResult<RedSpaceFriendsQueryModel> graphQLResult2) {
            super(graphQLResult, graphQLResult2);
        }
    }

    /* compiled from: USER_UNFOCUSED_MEDIA */
    public class RedSpaceFriendsWithOverflowResult extends RedSpaceBatchResult2<RedSpaceFriendsQueryModel, RedSpaceFriendsOverflowCountQueryModel> {
        public RedSpaceFriendsWithOverflowResult(GraphQLResult<RedSpaceFriendsQueryModel> graphQLResult, GraphQLResult<RedSpaceFriendsOverflowCountQueryModel> graphQLResult2) {
            super(graphQLResult, graphQLResult2);
        }
    }

    /* compiled from: USER_UNFOCUSED_MEDIA */
    public class RedSpaceProfileWithVisitsResult extends RedSpaceBatchResult2<RedSpaceFeedProfileFragmentModel, RedSpaceVisitsQueryModel> {
        public RedSpaceProfileWithVisitsResult(GraphQLResult<RedSpaceFeedProfileFragmentModel> graphQLResult, GraphQLResult<RedSpaceVisitsQueryModel> graphQLResult2) {
            super(graphQLResult, graphQLResult2);
        }
    }

    /* compiled from: USER_UNFOCUSED_MEDIA */
    public class RedSpaceTabBadgeWithFriendsResult extends RedSpaceBatchResult3<RedSpaceUnreadFriendsQueryModel, RedSpaceFriendsQueryModel, RedSpaceFriendsOverflowCountQueryModel> {
        public final /* bridge */ /* synthetic */ GraphQLResult mo1159a() {
            return super.mo1159a();
        }

        public final /* bridge */ /* synthetic */ GraphQLResult mo1160b() {
            return super.mo1160b();
        }

        public RedSpaceTabBadgeWithFriendsResult(GraphQLResult<RedSpaceUnreadFriendsQueryModel> graphQLResult, GraphQLResult<RedSpaceFriendsQueryModel> graphQLResult2, GraphQLResult<RedSpaceFriendsOverflowCountQueryModel> graphQLResult3) {
            super(graphQLResult, graphQLResult2, graphQLResult3);
        }
    }

    /* compiled from: USER_UNFOCUSED_MEDIA */
    public class RedSpaceWallResult extends RedSpaceBatchResult2<RedSpaceStoriesQueryModel, RedSpaceVisitsQueryModel> {
        public RedSpaceWallResult(GraphQLResult<RedSpaceStoriesQueryModel> graphQLResult, GraphQLResult<RedSpaceVisitsQueryModel> graphQLResult2) {
            super(graphQLResult, graphQLResult2);
        }
    }

    private static RedSpaceBatchRequests m24936a() {
        return new RedSpaceBatchRequests();
    }

    public final RequestObservable<RedSpaceFriendsWithFriendsResult> m24938a(GraphQLBatchRequest graphQLBatchRequest, GraphQLRequest<RedSpaceFriendsQueryModel> graphQLRequest, GraphQLRequest<RedSpaceFriendsQueryModel> graphQLRequest2) {
        return RequestObservable.a(graphQLBatchRequest.a(graphQLRequest), graphQLBatchRequest.a(graphQLRequest2), new C22701(this));
    }

    public final RequestObservable<RedSpaceFriendsWithOverflowResult> m24940b(GraphQLBatchRequest graphQLBatchRequest, GraphQLRequest<RedSpaceFriendsQueryModel> graphQLRequest, GraphQLRequest<RedSpaceFriendsOverflowCountQueryModel> graphQLRequest2) {
        return RequestObservable.a(graphQLBatchRequest.a(graphQLRequest), graphQLBatchRequest.a(graphQLRequest2), new C22712(this));
    }

    public static RedSpaceBatchRequests m24937a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceBatchRequests a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f21317b) {
                RedSpaceBatchRequests redSpaceBatchRequests;
                if (a3 != null) {
                    redSpaceBatchRequests = (RedSpaceBatchRequests) a3.a(f21317b);
                } else {
                    redSpaceBatchRequests = f21316a;
                }
                if (redSpaceBatchRequests == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m24936a();
                        if (a3 != null) {
                            a3.a(f21317b, a2);
                        } else {
                            f21316a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = redSpaceBatchRequests;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }

    public final RequestObservable<RedSpaceTabBadgeWithFriendsResult> m24939a(GraphQLBatchRequest graphQLBatchRequest, GraphQLRequest<RedSpaceUnreadFriendsQueryModel> graphQLRequest, GraphQLRequest<RedSpaceFriendsQueryModel> graphQLRequest2, GraphQLRequest<RedSpaceFriendsOverflowCountQueryModel> graphQLRequest3) {
        RequestObservable a = graphQLBatchRequest.a(graphQLRequest);
        RequestObservable a2 = graphQLBatchRequest.a(graphQLRequest2);
        RequestObservable a3 = graphQLBatchRequest.a(graphQLRequest3);
        return new RequestObservable(Observable.a(a.a, a2.a, a3.a, new 6(new C22723(this))));
    }
}
