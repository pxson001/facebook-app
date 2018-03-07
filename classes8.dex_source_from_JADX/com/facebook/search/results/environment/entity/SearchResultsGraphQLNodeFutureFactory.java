package com.facebook.search.results.environment.entity;

import android.content.Context;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams.Builder;
import com.facebook.api.ufiservices.common.TogglePageLikeParams;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.mutators.EventsRsvpMutator;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestCancelRef;
import com.facebook.friends.constants.FriendRequestHowFound;
import com.facebook.friends.constants.FriendRequestResponse;
import com.facebook.friends.constants.FriendRequestResponseRef;
import com.facebook.graphql.calls.GroupRequestToJoinInputData.Source;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SearchAwareness */
public class SearchResultsGraphQLNodeFutureFactory {
    private static SearchResultsGraphQLNodeFutureFactory f22705e;
    private static final Object f22706f = new Object();
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FriendingClient> f22707a = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FeedbackGraphQLGenerator> f22708b = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GroupsClient> f22709c = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<EventsRsvpMutator> f22710d = UltralightRuntime.b;

    private static SearchResultsGraphQLNodeFutureFactory m26253b(InjectorLike injectorLike) {
        SearchResultsGraphQLNodeFutureFactory searchResultsGraphQLNodeFutureFactory = new SearchResultsGraphQLNodeFutureFactory();
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 2073);
        com.facebook.inject.Lazy a2 = IdBasedLazy.a(injectorLike, 995);
        com.facebook.inject.Lazy a3 = IdBasedLazy.a(injectorLike, 7066);
        com.facebook.inject.Lazy a4 = IdBasedLazy.a(injectorLike, 5623);
        searchResultsGraphQLNodeFutureFactory.f22707a = a;
        searchResultsGraphQLNodeFutureFactory.f22708b = a2;
        searchResultsGraphQLNodeFutureFactory.f22709c = a3;
        searchResultsGraphQLNodeFutureFactory.f22710d = a4;
        return searchResultsGraphQLNodeFutureFactory;
    }

    public final ListenableFuture m26263a(GraphQLNode graphQLNode) {
        int g = graphQLNode.j() != null ? graphQLNode.j().g() : 0;
        switch (g) {
            case 2479791:
                return m26257c(graphQLNode);
            case 2645995:
                return m26254b(graphQLNode);
            case 67338874:
                return m26261e(graphQLNode);
            case 69076575:
                return m26259d(graphQLNode);
            default:
                throw new IllegalArgumentException("Unsupported node type: " + g);
        }
    }

    public final ListenableFuture m26264a(NodeModel nodeModel) {
        int g = nodeModel.m9745b() != null ? nodeModel.m9745b().g() : 0;
        switch (g) {
            case 2479791:
                return m26258c(nodeModel);
            case 2645995:
                return m26255b(nodeModel);
            case 67338874:
                return m26262e(nodeModel);
            case 69076575:
                return m26260d(nodeModel);
            default:
                throw new IllegalArgumentException("Unsupported node type: " + g);
        }
    }

    public static SearchResultsGraphQLNodeFutureFactory m26249a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsGraphQLNodeFutureFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22706f) {
                SearchResultsGraphQLNodeFutureFactory searchResultsGraphQLNodeFutureFactory;
                if (a2 != null) {
                    searchResultsGraphQLNodeFutureFactory = (SearchResultsGraphQLNodeFutureFactory) a2.a(f22706f);
                } else {
                    searchResultsGraphQLNodeFutureFactory = f22705e;
                }
                if (searchResultsGraphQLNodeFutureFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26253b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22706f, b3);
                        } else {
                            f22705e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsGraphQLNodeFutureFactory;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private ListenableFuture m26254b(GraphQLNode graphQLNode) {
        return m26250a(graphQLNode.cU(), graphQLNode.dp());
    }

    private ListenableFuture m26255b(NodeModel nodeModel) {
        return m26250a(nodeModel.m9762w(), nodeModel.mo572C());
    }

    private ListenableFuture m26250a(GraphQLFriendshipStatus graphQLFriendshipStatus, String str) {
        if (graphQLFriendshipStatus == GraphQLFriendshipStatus.CAN_REQUEST) {
            return ((FriendingClient) this.f22707a.get()).b(Long.parseLong(str), FriendRequestHowFound.SEARCH, null, null);
        }
        if (graphQLFriendshipStatus == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
            return ((FriendingClient) this.f22707a.get()).a(Long.parseLong(str), FriendRequestCancelRef.SEARCH);
        }
        if (graphQLFriendshipStatus == GraphQLFriendshipStatus.INCOMING_REQUEST) {
            return ((FriendingClient) this.f22707a.get()).a(Long.parseLong(str), FriendRequestResponse.CONFIRM, FriendRequestResponseRef.SEARCH);
        }
        throw new IllegalArgumentException("This type of friend event is not supported.");
    }

    private ListenableFuture m26257c(GraphQLNode graphQLNode) {
        return m26252a(graphQLNode.dp(), graphQLNode.bP());
    }

    private ListenableFuture m26258c(NodeModel nodeModel) {
        return m26252a(nodeModel.mo572C(), nodeModel.m9758s());
    }

    private ListenableFuture m26252a(String str, boolean z) {
        Builder builder = new Builder();
        builder.c = "keyword_search";
        FeedbackLoggingParams a = builder.a();
        TogglePageLikeParams.Builder a2 = TogglePageLikeParams.a();
        a2.a = str;
        TogglePageLikeParams.Builder builder2 = a2;
        builder2.b = !z;
        a2 = builder2;
        a2.d = a;
        return ((FeedbackGraphQLGenerator) this.f22708b.get()).a(a2.a(), null);
    }

    private ListenableFuture m26259d(GraphQLNode graphQLNode) {
        return m26251a(graphQLNode.dp());
    }

    private ListenableFuture m26260d(NodeModel nodeModel) {
        return m26251a(nodeModel.mo572C());
    }

    private ListenableFuture m26251a(String str) {
        return ((GroupsClient) this.f22709c.get()).m16964a(str, Source.SEARCH);
    }

    private ListenableFuture m26261e(GraphQLNode graphQLNode) {
        return m26256b(graphQLNode.dp());
    }

    private ListenableFuture m26262e(NodeModel nodeModel) {
        return m26256b(nodeModel.mo572C());
    }

    private ListenableFuture m26256b(String str) {
        return ((EventsRsvpMutator) this.f22710d.get()).a(str, GraphQLEventGuestStatus.GOING, "unknown", "graph_search_results_page", ActionMechanism.SEARCH_RESULT_ACTIONS);
    }
}
