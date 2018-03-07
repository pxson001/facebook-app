package com.facebook.search.results.environment.entity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestHowFound;
import com.facebook.friends.controllers.FriendingExceptionHandler;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPageCallToAction;
import com.facebook.inject.Assisted;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionClickHandler;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.CanReplaceFeedItem;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.SearchResultsModelEntityUtils;
import com.facebook.search.results.model.mutator.SearchResultsGraphQLNodeMutator;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Provider;

@Deprecated
/* compiled from: SearchSpotlightCollectionUnit[ */
public class OldCanApplyEntityInlineActionImpl implements OldCanApplyEntityInlineAction {
    public final CanReplaceFeedItem f22689a;
    public final HasInvalidate f22690b;
    public final HasSearchResultsContext f22691c;
    public final CanProvideRoleForEntity f22692d;
    private final HasContext f22693e;
    public final SearchResultsLogger f22694f;
    public final TasksManager f22695g;
    public final SearchResultsGraphQLNodeFutureFactory f22696h;
    public final FriendingExceptionHandler f22697i;
    public final FriendingClient f22698j;
    private final PageCallToActionClickHandler f22699k;
    public final GraphSearchErrorReporter f22700l;
    private final Provider<FbUriIntentHandler> f22701m;

    /* compiled from: SearchSpotlightCollectionUnit[ */
    public class C24143 implements OnClickListener {
        final /* synthetic */ GraphQLNode f22684a;
        final /* synthetic */ GraphQLNode f22685b;
        final /* synthetic */ String f22686c;
        final /* synthetic */ OldCanApplyEntityInlineActionImpl f22687d;

        /* compiled from: SearchSpotlightCollectionUnit[ */
        class C24121 implements Callable<ListenableFuture> {
            final /* synthetic */ C24143 f22682a;

            C24121(C24143 c24143) {
                this.f22682a = c24143;
            }

            public Object call() {
                return this.f22682a.f22687d.f22698j.a(Long.parseLong(this.f22682a.f22686c), FriendRequestHowFound.SEARCH, null, null);
            }
        }

        /* compiled from: SearchSpotlightCollectionUnit[ */
        class C24132 extends AbstractDisposableFutureCallback {
            final /* synthetic */ C24143 f22683a;

            C24132(C24143 c24143) {
                this.f22683a = c24143;
            }

            protected final void m26241a(Object obj) {
            }

            protected final void m26242a(Throwable th) {
                this.f22683a.f22687d.f22697i.a(th);
                this.f22683a.f22687d.f22689a.mo1241a(this.f22683a.f22685b, this.f22683a.f22684a);
                this.f22683a.f22687d.f22690b.hL_();
            }
        }

        public C24143(OldCanApplyEntityInlineActionImpl oldCanApplyEntityInlineActionImpl, GraphQLNode graphQLNode, GraphQLNode graphQLNode2, String str) {
            this.f22687d = oldCanApplyEntityInlineActionImpl;
            this.f22684a = graphQLNode;
            this.f22685b = graphQLNode2;
            this.f22686c = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f22687d.f22689a.mo1241a(this.f22684a, this.f22685b);
            this.f22687d.f22690b.hL_();
            this.f22687d.f22695g.a("warn_override_" + this.f22686c, new C24121(this), new C24132(this));
        }
    }

    /* compiled from: SearchSpotlightCollectionUnit[ */
    /* synthetic */ class C24154 {
        static final /* synthetic */ int[] f22688a = new int[GraphQLPageCallToActionType.values().length];

        static {
            try {
                f22688a[GraphQLPageCallToActionType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22688a[GraphQLPageCallToActionType.CALL_NOW.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22688a[GraphQLPageCallToActionType.EMAIL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public OldCanApplyEntityInlineActionImpl(@Assisted CanReplaceFeedItem canReplaceFeedItem, @Assisted HasInvalidate hasInvalidate, @Assisted HasSearchResultsContext hasSearchResultsContext, @Assisted CanProvideRoleForEntity canProvideRoleForEntity, @Assisted HasContext hasContext, SearchResultsLogger searchResultsLogger, TasksManager tasksManager, SearchResultsGraphQLNodeFutureFactory searchResultsGraphQLNodeFutureFactory, FriendingExceptionHandler friendingExceptionHandler, FriendingClient friendingClient, PageCallToActionClickHandler pageCallToActionClickHandler, GraphSearchErrorReporter graphSearchErrorReporter, Provider<FbUriIntentHandler> provider) {
        this.f22689a = canReplaceFeedItem;
        this.f22690b = hasInvalidate;
        this.f22691c = hasSearchResultsContext;
        this.f22692d = canProvideRoleForEntity;
        this.f22693e = hasContext;
        this.f22694f = searchResultsLogger;
        this.f22695g = tasksManager;
        this.f22696h = searchResultsGraphQLNodeFutureFactory;
        this.f22697i = friendingExceptionHandler;
        this.f22698j = friendingClient;
        this.f22699k = pageCallToActionClickHandler;
        this.f22700l = graphSearchErrorReporter;
        this.f22701m = provider;
    }

    public final void mo1250a(final GraphQLNode graphQLNode) {
        GraphQLPageCallToActionType a = SearchResultsModelEntityUtils.m27079a(graphQLNode);
        if (a != null) {
            m26243a(a, graphQLNode);
        } else if (graphQLNode.cU() == GraphQLFriendshipStatus.ARE_FRIENDS) {
            m26244b(graphQLNode);
        } else {
            final GraphQLNode a2 = SearchResultsGraphQLNodeMutator.m27119a(graphQLNode);
            this.f22689a.mo1241a(graphQLNode, a2);
            this.f22690b.hL_();
            this.f22695g.a("apply_mutation_" + graphQLNode.dp(), new Callable<ListenableFuture>(this) {
                final /* synthetic */ OldCanApplyEntityInlineActionImpl f22678b;

                public Object call() {
                    return this.f22678b.f22696h.m26263a(graphQLNode);
                }
            }, new AbstractDisposableFutureCallback(this) {
                final /* synthetic */ OldCanApplyEntityInlineActionImpl f22681c;

                protected final void m26239a(Object obj) {
                    this.f22681c.f22694f.m25466a(a2, this.f22681c.f22691c.mo1248s(), this.f22681c.f22692d.mo1252c(a2), this.f22681c.f22692d.mo1253d(a2));
                }

                protected final void m26240a(Throwable th) {
                    OldCanApplyEntityInlineActionImpl oldCanApplyEntityInlineActionImpl = this.f22681c;
                    GraphQLNode graphQLNode = graphQLNode;
                    GraphQLNode graphQLNode2 = a2;
                    if (graphQLNode.j() != null && graphQLNode.j().g() == 2645995) {
                        oldCanApplyEntityInlineActionImpl.f22697i.a(th, new C24143(oldCanApplyEntityInlineActionImpl, graphQLNode, graphQLNode2, graphQLNode.dp()));
                    }
                    oldCanApplyEntityInlineActionImpl.f22700l.a(GraphSearchError.FAILED_MUTATION, th);
                    oldCanApplyEntityInlineActionImpl.f22689a.mo1241a(graphQLNode2, graphQLNode);
                    oldCanApplyEntityInlineActionImpl.f22690b.hL_();
                }
            });
        }
    }

    private void m26243a(GraphQLPageCallToActionType graphQLPageCallToActionType, GraphQLNode graphQLNode) {
        GraphQLPageCallToAction kN = graphQLNode.kN();
        switch (C24154.f22688a[graphQLPageCallToActionType.ordinal()]) {
            case 1:
                m26244b(graphQLNode);
                return;
            case 2:
                this.f22699k.m19686a(kN.u() == null ? null : kN.u().m(), kN.r());
                return;
            case 3:
                this.f22699k.m19687a(graphQLNode.eP(), kN.r(), kN.p());
                return;
            default:
                throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Unimplemented call to action of type %s", graphQLPageCallToActionType.toString()));
        }
    }

    private void m26244b(GraphQLNode graphQLNode) {
        ((FbUriIntentHandler) this.f22701m.get()).a(this.f22693e.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.R, graphQLNode.dp()));
        this.f22694f.m25466a(graphQLNode, this.f22691c.mo1248s(), this.f22692d.mo1252c(graphQLNode), this.f22692d.mo1253d(graphQLNode));
    }
}
