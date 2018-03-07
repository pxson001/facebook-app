package com.facebook.pages.identity.cards.reviews;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.feed.ui.DisabledFeedStoryMenuHelper;
import com.facebook.inject.FbInjector;
import com.facebook.pages.identity.common.PageReactionCardViewContainer;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionThemedContextHelper;
import com.facebook.reaction.common.ReactionInteractionTrackerProvider;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoriesModel.EdgesModel;
import com.facebook.reaction.ui.recyclerview.ReactionMixedRecyclerViewAdapter;
import com.facebook.reaction.ui.recyclerview.ReactionMixedRecyclerViewAdapterProvider;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: post_option_type */
public class PageIdentityReactionReviewsCardViewContainer extends PageReactionCardViewContainer {
    private static final String f3655j = PageIdentityReactionReviewsCardViewContainer.class.getName();
    @Inject
    ReactionUnitValidator f3656a;
    @Inject
    ReactionInteractionTrackerProvider f3657b;
    @Inject
    ReactionThemedContextHelper f3658c;
    @Inject
    ReactionMixedRecyclerViewAdapterProvider f3659d;
    @Inject
    DisabledFeedStoryMenuHelper f3660e;
    @Inject
    AbstractFbErrorReporter f3661f;
    private Context f3662k;

    public static void m4687a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityReactionReviewsCardViewContainer) obj).m4686a(ReactionUnitValidator.b(fbInjector), (ReactionInteractionTrackerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ReactionInteractionTrackerProvider.class), ReactionThemedContextHelper.a(fbInjector), (ReactionMixedRecyclerViewAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ReactionMixedRecyclerViewAdapterProvider.class), DisabledFeedStoryMenuHelper.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector));
    }

    public PageIdentityReactionReviewsCardViewContainer(Context context, FbFragment fbFragment) {
        super(context, fbFragment);
        Class cls = PageIdentityReactionReviewsCardViewContainer.class;
        m4687a((Object) this, getContext());
    }

    @Nullable
    public final View m4688a(@Nullable ReactionSession reactionSession) {
        if (reactionSession == null || reactionSession.p() == null) {
            return null;
        }
        this.h = reactionSession;
        ViewGroup linearLayout = new LinearLayout(getReactionWrapperContext());
        linearLayout.setOrientation(1);
        if (m4689a(reactionSession, linearLayout)) {
            return linearLayout;
        }
        this.f3661f.a(f3655j, "Unable to set reaction reviews card data");
        return null;
    }

    private Context getReactionWrapperContext() {
        if (this.f3662k == null) {
            this.f3662k = ReactionThemedContextHelper.a(getContext(), this.f3653h.c);
        }
        return this.f3662k;
    }

    public final boolean m4689a(@Nullable ReactionSession reactionSession, ViewGroup viewGroup) {
        if (reactionSession == null || reactionSession.p() == null) {
            return false;
        }
        this.h = reactionSession;
        ImmutableList p = this.f3653h.p();
        int size = p.size();
        for (int i = 0; i < size; i++) {
            ImmutableList a = ((ReactionStories) p.get(i)).a();
            int size2 = a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ReactionUnitFragment a2 = ((EdgesModel) a.get(i2)).a();
                if (a2 != null) {
                    if ("SUCCESS".equals(this.f3656a.a(a2).d)) {
                        this.i = this.f3657b.a(this.f3653h, null);
                        viewGroup.removeAllViews();
                        ReactionMixedRecyclerViewAdapter a3 = this.f3659d.a(getReactionWrapperContext(), PagesReviewReactionCardFeedListType.f3704a, this.f3660e, this);
                        a3.a(reactionSession);
                        for (int i3 = 0; i3 < a3.aZ_(); i3++) {
                            ViewHolder a4 = a3.a(viewGroup, a3.getItemViewType(i3));
                            viewGroup.addView(a4.a);
                            a3.a(a4, i3);
                        }
                        a3.j();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void m4686a(ReactionUnitValidator reactionUnitValidator, ReactionInteractionTrackerProvider reactionInteractionTrackerProvider, ReactionThemedContextHelper reactionThemedContextHelper, ReactionMixedRecyclerViewAdapterProvider reactionMixedRecyclerViewAdapterProvider, DisabledFeedStoryMenuHelper disabledFeedStoryMenuHelper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f3656a = reactionUnitValidator;
        this.f3657b = reactionInteractionTrackerProvider;
        this.f3658c = reactionThemedContextHelper;
        this.f3659d = reactionMixedRecyclerViewAdapterProvider;
        this.f3660e = disabledFeedStoryMenuHelper;
        this.f3661f = abstractFbErrorReporter;
    }
}
