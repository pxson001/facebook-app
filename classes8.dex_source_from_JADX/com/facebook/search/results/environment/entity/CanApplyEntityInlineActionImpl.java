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
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.inject.Assisted;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.CanReplaceSearchResult;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.model.mutator.SearchResultsGraphQLNodeMutator;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Selected menu item not valid. */
public class CanApplyEntityInlineActionImpl implements CanApplyEntityInlineAction {
    public final CanReplaceSearchResult f22658a;
    public final HasInvalidate f22659b;
    public final HasSearchResultsContext f22660c;
    public final HasContext f22661d;
    public final SearchResultsLogger f22662e;
    public final TasksManager f22663f;
    public final SearchResultsGraphQLNodeFutureFactory f22664g;
    public final FriendingExceptionHandler f22665h;
    public final FriendingClient f22666i;
    public final GraphSearchErrorReporter f22667j;
    public final Provider<FbUriIntentHandler> f22668k;

    /* compiled from: Selected menu item not valid. */
    public class C24093 implements OnClickListener {
        final /* synthetic */ SearchResultsEdgeModel f22654a;
        final /* synthetic */ SearchResultsEdgeModel f22655b;
        final /* synthetic */ String f22656c;
        final /* synthetic */ CanApplyEntityInlineActionImpl f22657d;

        /* compiled from: Selected menu item not valid. */
        class C24071 implements Callable<ListenableFuture> {
            final /* synthetic */ C24093 f22652a;

            C24071(C24093 c24093) {
                this.f22652a = c24093;
            }

            public Object call() {
                return this.f22652a.f22657d.f22666i.a(Long.parseLong(this.f22652a.f22656c), FriendRequestHowFound.SEARCH, null, null);
            }
        }

        /* compiled from: Selected menu item not valid. */
        class C24082 extends AbstractDisposableFutureCallback {
            final /* synthetic */ C24093 f22653a;

            C24082(C24093 c24093) {
                this.f22653a = c24093;
            }

            protected final void m26224a(Object obj) {
            }

            protected final void m26225a(Throwable th) {
                this.f22653a.f22657d.f22665h.a(th);
                this.f22653a.f22657d.f22658a.mo1243a(this.f22653a.f22655b, this.f22653a.f22654a);
                this.f22653a.f22657d.f22659b.hL_();
            }
        }

        public C24093(CanApplyEntityInlineActionImpl canApplyEntityInlineActionImpl, SearchResultsEdgeModel searchResultsEdgeModel, SearchResultsEdgeModel searchResultsEdgeModel2, String str) {
            this.f22657d = canApplyEntityInlineActionImpl;
            this.f22654a = searchResultsEdgeModel;
            this.f22655b = searchResultsEdgeModel2;
            this.f22656c = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f22657d.f22658a.mo1243a(this.f22654a, this.f22655b);
            this.f22657d.f22659b.hL_();
            this.f22657d.f22663f.a("warn_override_" + this.f22656c, new C24071(this), new C24082(this));
        }
    }

    @Inject
    public CanApplyEntityInlineActionImpl(@Assisted CanReplaceSearchResult canReplaceSearchResult, @Assisted HasInvalidate hasInvalidate, @Assisted HasSearchResultsContext hasSearchResultsContext, @Assisted HasContext hasContext, SearchResultsLogger searchResultsLogger, TasksManager tasksManager, SearchResultsGraphQLNodeFutureFactory searchResultsGraphQLNodeFutureFactory, FriendingExceptionHandler friendingExceptionHandler, FriendingClient friendingClient, GraphSearchErrorReporter graphSearchErrorReporter, Provider<FbUriIntentHandler> provider) {
        this.f22658a = canReplaceSearchResult;
        this.f22659b = hasInvalidate;
        this.f22660c = hasSearchResultsContext;
        this.f22661d = hasContext;
        this.f22662e = searchResultsLogger;
        this.f22663f = tasksManager;
        this.f22664g = searchResultsGraphQLNodeFutureFactory;
        this.f22665h = friendingExceptionHandler;
        this.f22666i = friendingClient;
        this.f22667j = graphSearchErrorReporter;
        this.f22668k = provider;
    }

    public final void mo1255b(SearchResultsProps searchResultsProps) {
        final NodeModel nodeModel = (NodeModel) searchResultsProps.f23388a;
        final SearchResultsEdgeModel searchResultsEdgeModel = searchResultsProps.f23390c;
        if (nodeModel.m9762w() == GraphQLFriendshipStatus.ARE_FRIENDS) {
            ((FbUriIntentHandler) this.f22668k.get()).a(this.f22661d.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.R, nodeModel.mo572C()));
            this.f22662e.m25486a(nodeModel, this.f22660c.mo1248s(), null, null);
            return;
        }
        final SearchResultsEdgeModel a = SearchResultsGraphQLNodeMutator.m27120a(searchResultsProps);
        this.f22658a.mo1243a(searchResultsEdgeModel, a);
        this.f22659b.hL_();
        this.f22663f.a("apply_mutation_" + nodeModel.mo572C(), new Callable<ListenableFuture>(this) {
            final /* synthetic */ CanApplyEntityInlineActionImpl f22648b;

            public Object call() {
                return this.f22648b.f22664g.m26264a(nodeModel);
            }
        }, new AbstractDisposableFutureCallback(this) {
            final /* synthetic */ CanApplyEntityInlineActionImpl f22651c;

            protected final void m26222a(Object obj) {
                this.f22651c.f22662e.m25486a(a.m9770a(), this.f22651c.f22660c.mo1248s(), null, null);
            }

            protected final void m26223a(Throwable th) {
                CanApplyEntityInlineActionImpl canApplyEntityInlineActionImpl = this.f22651c;
                SearchResultsEdgeModel searchResultsEdgeModel = searchResultsEdgeModel;
                SearchResultsEdgeModel searchResultsEdgeModel2 = a;
                NodeModel a = searchResultsEdgeModel.m9770a();
                GraphQLObjectType b = a.m9745b();
                if (b != null && b.g() == 2645995) {
                    canApplyEntityInlineActionImpl.f22665h.a(th, new C24093(canApplyEntityInlineActionImpl, searchResultsEdgeModel, searchResultsEdgeModel2, a.mo572C()));
                }
                canApplyEntityInlineActionImpl.f22667j.a(GraphSearchError.FAILED_MUTATION, th);
                canApplyEntityInlineActionImpl.f22658a.mo1243a(searchResultsEdgeModel2, searchResultsEdgeModel);
                canApplyEntityInlineActionImpl.f22659b.hL_();
            }
        });
    }
}
