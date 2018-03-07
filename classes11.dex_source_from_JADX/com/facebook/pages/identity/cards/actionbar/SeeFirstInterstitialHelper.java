package com.facebook.pages.identity.cards.actionbar;

import android.graphics.Rect;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar;
import com.facebook.fbui.widget.inlineactionbar.InlineActionButton;
import com.facebook.feed.seefirst.seefirstnux.SeeFirstNuxManager;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.nux.interstitial.SeeFirstPromptNuxController;
import com.facebook.pages.identity.cards.actionbar.PagesActionBarItemFactory.PageActionType;
import com.facebook.pages.identity.protocol.graphql.ViewerTopPagesGraphQL.ViewerTopPagesQueryString;
import com.facebook.pages.identity.protocol.graphql.ViewerTopPagesGraphQLModels.ViewerTopPagesQueryModel;
import com.facebook.pages.identity.protocol.graphql.ViewerTopPagesGraphQLModels.ViewerTopPagesQueryModel.FollowedProfilesModel.NodesModel;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: privacy_checkup_single_step_manager_missing_privacy_edit */
public class SeeFirstInterstitialHelper {
    public InterstitialManager f3309a;
    public SeeFirstNuxManager f3310b;
    private GraphQLQueryExecutor f3311c;
    private ListeningExecutorService f3312d;
    private DefaultAppChoreographer f3313e;
    public boolean f3314f = false;

    /* compiled from: privacy_checkup_single_step_manager_missing_privacy_edit */
    public class C04452 implements Runnable {
        final /* synthetic */ InlineActionBar f3306a;
        final /* synthetic */ SeeFirstPromptNuxController f3307b;
        final /* synthetic */ SeeFirstInterstitialHelper f3308c;

        public C04452(SeeFirstInterstitialHelper seeFirstInterstitialHelper, InlineActionBar inlineActionBar, SeeFirstPromptNuxController seeFirstPromptNuxController) {
            this.f3308c = seeFirstInterstitialHelper;
            this.f3306a = inlineActionBar;
            this.f3307b = seeFirstPromptNuxController;
        }

        public void run() {
            InlineActionButton inlineActionButton = (InlineActionButton) this.f3306a.findViewById(PageActionType.FOLLOW.ordinal());
            if (inlineActionButton != null && inlineActionButton.getText().equals(this.f3306a.getContext().getString(2131234907))) {
                Rect rect = new Rect();
                inlineActionButton.getGlobalVisibleRect(rect);
                if (rect.height() >= inlineActionButton.getHeight()) {
                    SeeFirstPromptNuxController.a(inlineActionButton);
                    this.f3308c.f3309a.a().a(this.f3307b.b());
                    this.f3308c.f3310b.b();
                    this.f3308c.f3314f = true;
                }
            }
        }
    }

    @Inject
    public SeeFirstInterstitialHelper(InterstitialManager interstitialManager, SeeFirstNuxManager seeFirstNuxManager, GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService, DefaultAppChoreographer defaultAppChoreographer) {
        this.f3309a = interstitialManager;
        this.f3310b = seeFirstNuxManager;
        this.f3311c = graphQLQueryExecutor;
        this.f3312d = listeningExecutorService;
        this.f3313e = defaultAppChoreographer;
    }

    public final void m4451a(final InlineActionBar inlineActionBar, final long j) {
        if (!this.f3314f && this.f3310b.a()) {
            GraphQLQueryFuture a = this.f3311c.a(GraphQLRequest.a((ViewerTopPagesQueryString) new ViewerTopPagesQueryString().a("num_top_pages", Integer.valueOf(5))).a(RequestPriority.INTERACTIVE).a(GraphQLCachePolicy.a).a(259200));
            this.f3313e.a(a);
            Futures.a(a, new FutureCallback<GraphQLResult<ViewerTopPagesQueryModel>>(this) {
                final /* synthetic */ SeeFirstInterstitialHelper f3305c;

                public void onSuccess(@Nullable Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (graphQLResult != null && graphQLResult.e != null && ((ViewerTopPagesQueryModel) graphQLResult.e).a() != null) {
                        ImmutableList a = ((ViewerTopPagesQueryModel) graphQLResult.e).a().a();
                        int size = a.size();
                        for (int i = 0; i < size; i++) {
                            if (((NodesModel) a.get(i)).b().equals(String.valueOf(j))) {
                                SeeFirstInterstitialHelper seeFirstInterstitialHelper = this.f3305c;
                                InlineActionBar inlineActionBar = inlineActionBar;
                                SeeFirstPromptNuxController seeFirstPromptNuxController = (SeeFirstPromptNuxController) seeFirstInterstitialHelper.f3309a.a(new InterstitialTrigger(Action.PAGE_ACTIONBAR), SeeFirstPromptNuxController.class);
                                if (seeFirstPromptNuxController != null) {
                                    inlineActionBar.post(new C04452(seeFirstInterstitialHelper, inlineActionBar, seeFirstPromptNuxController));
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }

                public void onFailure(Throwable th) {
                }
            }, this.f3312d);
        }
    }
}
