package com.facebook.adsexperiencetool;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.RecyclerListener;
import com.facebook.adpreview.protocol.FetchGraphQLAdPreviewMethod;
import com.facebook.adsexperiencetool.protocol.AdsExperienceMutations.AdsExperienceDeclineMutationString;
import com.facebook.adsexperiencetool.protocol.AdsExperienceMutations.AdsExperienceInjectMutationString;
import com.facebook.adsexperiencetool.protocol.AdsExperienceMutator;
import com.facebook.adsexperiencetool.protocol.FetchAdsExperienceMethod;
import com.facebook.adsexperiencetool.protocol.FetchAdsExperienceQuery.FetchAdsExperienceQueryString;
import com.facebook.adsexperiencetool.protocol.FetchAdsExperienceQueryModels.AdsExperienceFragmentModel;
import com.facebook.adsexperiencetool.ui.AdsInjectIntroView;
import com.facebook.adsexperiencetool.ui.AdsInjectIntroView.AdsInjectIntroViewListener;
import com.facebook.adsexperiencetool.ui.NonInteractableAdsPreviewView;
import com.facebook.api.story.FetchSingleStoryParams;
import com.facebook.base.activity.FragmentBaseActivity;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.menu.permalink.PermalinkFeedStoryMenuHelperFactory;
import com.facebook.feed.permalink.PermalinkCommentNavigationDelegate;
import com.facebook.feed.permalink.PermalinkCommentNavigationDelegateProvider;
import com.facebook.feed.permalink.PermalinkEnvironmentProvider;
import com.facebook.feed.permalink.PermalinkFeedListType;
import com.facebook.feed.rows.FeedAdapterFactory;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.permalink.StoryPermalinkAdapter;
import com.facebook.feedback.ui.Bindable;
import com.facebook.feedback.ui.CommentAdapter;
import com.facebook.feedback.ui.CommentAdapterFactory;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironmentProvider;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.graphql.calls.AdsExperienceDeclineInputData;
import com.facebook.graphql.calls.AdsExperienceInjectInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.enums.GraphQLAdsExperienceStatusEnum;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorController;
import com.facebook.widget.loadingindicator.LoadingIndicatorState;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: error getting stored string */
public class AdsInjectConfirmationFragment extends FbFragment {
    public static final String as = AdsInjectConfirmationFragment.class.getSimpleName();
    @Inject
    public FetchAdsExperienceMethod f14425a;
    private LoadingIndicatorState aA;
    public final RetryClickedListener aB = new RetryTrigger(this);
    private AdsInjectIntroViewListener aC = new C20121(this);
    @Inject
    CommentAdapterFactory al;
    @Inject
    AbstractFbErrorReporter am;
    @Inject
    MultipleRowsStoriesRecycleCallback an;
    @Inject
    DefaultAndroidThreadUtil ao;
    @Inject
    SecureContextHelper ap;
    @Inject
    @FragmentBaseActivity
    Provider<ComponentName> aq;
    @Inject
    AdsExperienceMutator ar;
    public AdsExperienceFragmentModel at;
    public MultiAdapterListAdapter au;
    public AdsInjectIntroView av;
    public NonInteractableAdsPreviewView aw;
    private StoryPermalinkAdapter ax;
    private LoadingIndicatorView ay;
    public LoadingIndicatorController az;
    @Inject
    GraphQLQueryExecutor f14426b;
    @Inject
    FetchGraphQLAdPreviewMethod f14427c;
    @Inject
    TasksManager f14428d;
    @Inject
    PermalinkEnvironmentProvider f14429e;
    @Inject
    PermalinkFeedStoryMenuHelperFactory f14430f;
    @Inject
    FeedAdapterFactory f14431g;
    @Inject
    PermalinkCommentNavigationDelegateProvider f14432h;
    @Inject
    BaseCommentsEnvironmentProvider f14433i;

    /* compiled from: error getting stored string */
    class C20121 implements AdsInjectIntroViewListener {
        final /* synthetic */ AdsInjectConfirmationFragment f14418a;

        C20121(AdsInjectConfirmationFragment adsInjectConfirmationFragment) {
            this.f14418a = adsInjectConfirmationFragment;
        }

        public final void mo747a() {
            if (this.f14418a.at != null) {
                AdsExperienceMutator adsExperienceMutator = this.f14418a.ar;
                String l = this.f14418a.at.m14642l();
                Preconditions.checkNotNull(l);
                AdsExperienceInjectInputData adsExperienceInjectInputData = new AdsExperienceInjectInputData();
                adsExperienceInjectInputData.a("actor_id", (String) adsExperienceMutator.f14448b.get());
                GraphQlCallInput graphQlCallInput = adsExperienceInjectInputData;
                graphQlCallInput.a("ads_experience_id", l);
                graphQlCallInput = graphQlCallInput;
                GraphQlQueryString adsExperienceInjectMutationString = new AdsExperienceInjectMutationString();
                adsExperienceInjectMutationString.a("input", graphQlCallInput);
                adsExperienceMutator.f14447a.a(GraphQLRequest.a(adsExperienceInjectMutationString));
                AdsInjectConfirmationFragment.m14513a(this.f14418a, true);
            }
        }

        public final void mo748b() {
            if (this.f14418a.at != null) {
                AdsExperienceMutator adsExperienceMutator = this.f14418a.ar;
                String l = this.f14418a.at.m14642l();
                Preconditions.checkNotNull(l);
                AdsExperienceDeclineInputData adsExperienceDeclineInputData = new AdsExperienceDeclineInputData();
                adsExperienceDeclineInputData.a("actor_id", (String) adsExperienceMutator.f14448b.get());
                GraphQlCallInput graphQlCallInput = adsExperienceDeclineInputData;
                graphQlCallInput.a("ads_experience_id", l);
                graphQlCallInput = graphQlCallInput;
                GraphQlQueryString adsExperienceDeclineMutationString = new AdsExperienceDeclineMutationString();
                adsExperienceDeclineMutationString.a("input", graphQlCallInput);
                adsExperienceMutator.f14447a.a(GraphQLRequest.a(adsExperienceDeclineMutationString));
                AdsInjectConfirmationFragment.m14513a(this.f14418a, false);
            }
        }

        public final void mo749c() {
            AdsInjectConfirmationFragment.m14513a(this.f14418a, false);
        }
    }

    /* compiled from: error getting stored string */
    public class C20132 implements FutureCallback<GraphQLResult<AdsExperienceFragmentModel>> {
        final /* synthetic */ AdsInjectConfirmationFragment f14419a;

        public C20132(AdsInjectConfirmationFragment adsInjectConfirmationFragment) {
            this.f14419a = adsInjectConfirmationFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            AdsExperienceFragmentModel adsExperienceFragmentModel;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            AdsInjectConfirmationFragment adsInjectConfirmationFragment = this.f14419a;
            if (graphQLResult == null) {
                adsExperienceFragmentModel = null;
            } else {
                adsExperienceFragmentModel = (AdsExperienceFragmentModel) graphQLResult.e;
            }
            adsInjectConfirmationFragment.at = adsExperienceFragmentModel;
            if (this.f14419a.at != null) {
                if (this.f14419a.at.m14641k() == GraphQLAdsExperienceStatusEnum.ACTIVE) {
                    AdsInjectConfirmationFragment.ar(this.f14419a);
                    this.f14419a.av.setConfirmationTextForActiveSharedAds(this.f14419a.at.m14643m().m14632j());
                } else {
                    this.f14419a.av.setConfirmationTextForInactiveSharedAds(this.f14419a.at.m14643m().m14632j());
                }
                this.f14419a.av.setProfilePicture(Uri.parse(this.f14419a.at.m14643m().m14633k().m14624a()));
            }
        }

        public void onFailure(Throwable th) {
            this.f14419a.am.a(AdsInjectConfirmationFragment.as, "Failed to ad experience.");
        }
    }

    /* compiled from: error getting stored string */
    class C20143 implements Callable<ListenableFuture<GraphQLResult<FeedUnit>>> {
        final /* synthetic */ AdsInjectConfirmationFragment f14420a;

        C20143(AdsInjectConfirmationFragment adsInjectConfirmationFragment) {
            this.f14420a = adsInjectConfirmationFragment;
        }

        public Object call() {
            return this.f14420a.f14426b.a(GraphQLRequest.a(this.f14420a.f14427c.m14169a(new FetchSingleStoryParams("", DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA), this.f14420a.at.m14640j()), FeedUnit.class));
        }
    }

    /* compiled from: error getting stored string */
    class C20154 extends AbstractDisposableFutureCallback<GraphQLResult<FeedUnit>> {
        final /* synthetic */ AdsInjectConfirmationFragment f14421a;

        C20154(AdsInjectConfirmationFragment adsInjectConfirmationFragment) {
            this.f14421a = adsInjectConfirmationFragment;
        }

        protected final void m14510a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                this.f14421a.m14518a((FeedUnit) graphQLResult.e);
            }
            this.f14421a.az.b();
        }

        protected final void m14511a(Throwable th) {
            this.f14421a.az.a(this.f14421a.b(2131230811), this.f14421a.aB);
            this.f14421a.am.a(AdsInjectConfirmationFragment.as, "Failed to fetch ad preview.");
        }
    }

    /* compiled from: error getting stored string */
    class C20165 implements RecyclerListener {
        final /* synthetic */ AdsInjectConfirmationFragment f14422a;

        C20165(AdsInjectConfirmationFragment adsInjectConfirmationFragment) {
            this.f14422a = adsInjectConfirmationFragment;
        }

        public void onMovedToScrapHeap(View view) {
            MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback = this.f14422a.an;
            MultipleRowsStoriesRecycleCallback.a(view);
        }
    }

    /* compiled from: error getting stored string */
    class C20176 implements Runnable {
        final /* synthetic */ AdsInjectConfirmationFragment f14423a;

        C20176(AdsInjectConfirmationFragment adsInjectConfirmationFragment) {
            this.f14423a = adsInjectConfirmationFragment;
        }

        public void run() {
            AdapterDetour.a(AdsInjectConfirmationFragment.as(this.f14423a), -1269781500);
        }
    }

    /* compiled from: error getting stored string */
    class RetryTrigger implements RetryClickedListener {
        final /* synthetic */ AdsInjectConfirmationFragment f14424a;

        public RetryTrigger(AdsInjectConfirmationFragment adsInjectConfirmationFragment) {
            this.f14424a = adsInjectConfirmationFragment;
        }

        public final void m14512a() {
            AdsInjectConfirmationFragment.ar(this.f14424a);
        }
    }

    public static void m14515a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AdsInjectConfirmationFragment) obj).m14514a(FetchAdsExperienceMethod.m14595a(fbInjector), GraphQLQueryExecutor.a(fbInjector), FetchGraphQLAdPreviewMethod.m14167b(fbInjector), TasksManager.a(fbInjector), (PermalinkEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PermalinkEnvironmentProvider.class), PermalinkFeedStoryMenuHelperFactory.a(fbInjector), FeedAdapterFactory.a(fbInjector), (PermalinkCommentNavigationDelegateProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PermalinkCommentNavigationDelegateProvider.class), (BaseCommentsEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(BaseCommentsEnvironmentProvider.class), CommentAdapterFactory.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), MultipleRowsStoriesRecycleCallback.a(fbInjector), DefaultAndroidThreadUtil.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), IdBasedSingletonScopeProvider.a(fbInjector, 11), AdsExperienceMutator.m14594a(fbInjector));
    }

    private void m14514a(FetchAdsExperienceMethod fetchAdsExperienceMethod, GraphQLQueryExecutor graphQLQueryExecutor, FetchGraphQLAdPreviewMethod fetchGraphQLAdPreviewMethod, TasksManager tasksManager, PermalinkEnvironmentProvider permalinkEnvironmentProvider, PermalinkFeedStoryMenuHelperFactory permalinkFeedStoryMenuHelperFactory, FeedAdapterFactory feedAdapterFactory, PermalinkCommentNavigationDelegateProvider permalinkCommentNavigationDelegateProvider, BaseCommentsEnvironmentProvider baseCommentsEnvironmentProvider, CommentAdapterFactory commentAdapterFactory, FbErrorReporter fbErrorReporter, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, AndroidThreadUtil androidThreadUtil, SecureContextHelper secureContextHelper, Provider<ComponentName> provider, AdsExperienceMutator adsExperienceMutator) {
        this.f14425a = fetchAdsExperienceMethod;
        this.f14426b = graphQLQueryExecutor;
        this.f14427c = fetchGraphQLAdPreviewMethod;
        this.f14428d = tasksManager;
        this.f14429e = permalinkEnvironmentProvider;
        this.f14430f = permalinkFeedStoryMenuHelperFactory;
        this.f14431g = feedAdapterFactory;
        this.f14432h = permalinkCommentNavigationDelegateProvider;
        this.f14433i = baseCommentsEnvironmentProvider;
        this.al = commentAdapterFactory;
        this.am = fbErrorReporter;
        this.an = multipleRowsStoriesRecycleCallback;
        this.ao = androidThreadUtil;
        this.ap = secureContextHelper;
        this.aq = provider;
        this.ar = adsExperienceMutator;
    }

    public final void m14519c(Bundle bundle) {
        super.c(bundle);
        Class cls = AdsInjectConfirmationFragment.class;
        m14515a((Object) this, getContext());
        if (bundle != null) {
            this.aA = (LoadingIndicatorState) bundle.getParcelable("loading_indicator_state");
        }
        this.az = new LoadingIndicatorController(this.aA, this.aB);
    }

    public final View m14516a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -125437931);
        View inflate = layoutInflater.inflate(2130903194, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 333787494, a);
        return inflate;
    }

    public final void m14517a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.av = (AdsInjectIntroView) e(2131559447);
        this.aw = (NonInteractableAdsPreviewView) e(2131559449);
        this.ay = (LoadingIndicatorView) e(2131559448);
        String string = o().getIntent().getExtras().getString("extra_ads_experience_id");
        if (string != null) {
            FetchAdsExperienceMethod fetchAdsExperienceMethod = this.f14425a;
            C20132 c20132 = new C20132(this);
            Preconditions.checkNotNull(string);
            Preconditions.checkNotNull(c20132, "no callback");
            GraphQlQueryString fetchAdsExperienceQueryString = new FetchAdsExperienceQueryString();
            fetchAdsExperienceQueryString.a("experienceID", string);
            fetchAdsExperienceQueryString.a("scale", null);
            Futures.a(fetchAdsExperienceMethod.f14449a.a(GraphQLRequest.a(fetchAdsExperienceQueryString)), c20132, fetchAdsExperienceMethod.f14450b);
        }
        this.av.f14472b = this.aC;
        this.aw.setEmptyView(this.ay);
        this.az.a(this.ay);
    }

    public final void m14520e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("loading_indicator_state", this.aA);
    }

    public static void ar(AdsInjectConfirmationFragment adsInjectConfirmationFragment) {
        adsInjectConfirmationFragment.az.a();
        adsInjectConfirmationFragment.f14428d.a(adsInjectConfirmationFragment.at.m14640j(), new C20143(adsInjectConfirmationFragment), new C20154(adsInjectConfirmationFragment));
    }

    @VisibleForTesting
    public final void m14518a(FeedUnit feedUnit) {
        this.ao.a();
        this.aw.setAdapter(as(this));
        this.aw.setRecyclerListener(new C20165(this));
        ((Bindable) this.ax).a(feedUnit);
        Preconditions.checkNotNull(this.au);
        int count = this.au.getCount();
        int i = 0;
        int i2 = 0;
        while (i < count) {
            int measuredHeight;
            View view = this.au.getView(i, null, this.aw);
            if (view instanceof RichVideoAttachmentView) {
                RichVideoPlayer richVideoPlayer = ((RichVideoAttachmentView) view).getRichVideoPlayer();
                richVideoPlayer.measure(0, 0);
                measuredHeight = richVideoPlayer.getMeasuredHeight() + i2;
            } else {
                view.measure(0, 0);
                measuredHeight = view.getMeasuredHeight() + i2;
            }
            i++;
            i2 = measuredHeight;
        }
        this.aw.getLayoutParams().height = i2;
        this.aw.requestLayout();
    }

    public static MultiAdapterListAdapter as(AdsInjectConfirmationFragment adsInjectConfirmationFragment) {
        if (adsInjectConfirmationFragment.au != null) {
            return adsInjectConfirmationFragment.au;
        }
        Runnable c20176 = new C20176(adsInjectConfirmationFragment);
        Context contextThemeWrapper = new ContextThemeWrapper(adsInjectConfirmationFragment.getContext(), 2131626110);
        adsInjectConfirmationFragment.ax = adsInjectConfirmationFragment.f14431g.a(PermalinkEnvironmentProvider.a(contextThemeWrapper, PermalinkFeedListType.a, HasScrollListenerSupportImpl.a(), adsInjectConfirmationFragment.f14430f, c20176));
        PermalinkCommentNavigationDelegate a = adsInjectConfirmationFragment.f14432h.a(contextThemeWrapper);
        CommentAdapter a2 = adsInjectConfirmationFragment.al.a(a, adsInjectConfirmationFragment.f14433i.a(contextThemeWrapper, a, c20176), null);
        Builder builder = ImmutableList.builder();
        builder.c((FbListAdapter) adsInjectConfirmationFragment.ax).c(a2);
        adsInjectConfirmationFragment.au = MultiAdapterListAdapter.a(builder.b());
        return adsInjectConfirmationFragment.au;
    }

    public static void m14513a(AdsInjectConfirmationFragment adsInjectConfirmationFragment, boolean z) {
        Parcelable data = new Intent("android.intent.action.VIEW").setData(Uri.parse(FBLinks.bT));
        data.putExtra("refresh_feed", z);
        Intent intent = new Intent();
        intent.putExtra("tabbar_target_intent", data);
        intent.setFlags(67108864);
        intent.setComponent((ComponentName) adsInjectConfirmationFragment.aq.get());
        adsInjectConfirmationFragment.ap.a(intent, adsInjectConfirmationFragment.getContext());
        adsInjectConfirmationFragment.o().finish();
    }
}
