package com.facebook.reaction.ui.recyclerview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewStub;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel;
import com.facebook.entitycards.contextitems.handler.ContextItemsOnClickListener;
import com.facebook.entitycards.contextitems.surface.ContextItemSurfaces;
import com.facebook.entitycards.contextitems.ui.ContextItemsAdapter;
import com.facebook.entitycards.contextitems.ui.ContextItemsAdapter.EntityData;
import com.facebook.entitycards.contextitems.ui.ContextItemsContainer;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.model.GraphQLRating;
import com.facebook.graphql.model.GraphQLRating.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import com.facebook.pages.identity.contextitems.handler.PageContextItemsClickHandler;
import com.facebook.reaction.analytics.ReactionAnalytics.WelcomeHeaderInteractionType;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionPageFieldsWithPlaceTipsInfoModel;
import com.facebook.reaction.ui.welcomeheader.ReactionWelcomeHeaderActionButtonsView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unknown ContactpointType */
public class ReactionContextItemsView extends CustomLinearLayout {
    @Inject
    public Lazy<ContextItemsAdapter> f21163a;
    @Inject
    public Lazy<PageContextItemsClickHandler> f21164b;
    private ReactionWelcomeHeaderActionButtonsView f21165c;
    public View f21166d;
    public ContextItemsContainer f21167e;
    public AnimatorSet f21168f;
    public ReactionPageFieldsWithPlaceTipsInfoModel f21169g;
    public Fragment f21170h;
    public Surface f21171i;
    public ReactionInteractionTracker f21172j;

    /* compiled from: Unknown ContactpointType */
    public class C22451 implements AnimatorListener {
        final /* synthetic */ View f21157a;
        final /* synthetic */ ReactionContextItemsView f21158b;

        public C22451(ReactionContextItemsView reactionContextItemsView, View view) {
            this.f21158b = reactionContextItemsView;
            this.f21157a = view;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f21157a.setVisibility(8);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public static void m24797a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ReactionContextItemsView reactionContextItemsView = (ReactionContextItemsView) obj;
        Lazy a = IdBasedLazy.a(fbInjector, 5512);
        Lazy a2 = IdBasedLazy.a(fbInjector, 9062);
        reactionContextItemsView.f21163a = a;
        reactionContextItemsView.f21164b = a2;
    }

    public ReactionContextItemsView(Context context) {
        super(context);
        Class cls = ReactionContextItemsView.class;
        m24797a((Object) this, getContext());
        setContentView(2130906657);
    }

    public final void m24798a(boolean z, GraphQLSubscribeStatus graphQLSubscribeStatus) {
        if (this.f21166d == null) {
            this.f21166d = ((ViewStub) findViewById(2131566699)).inflate();
            this.f21167e = (ContextItemsContainer) this.f21166d.findViewById(2131566697);
            this.f21165c = (ReactionWelcomeHeaderActionButtonsView) this.f21166d.findViewById(2131566698);
            setContextItems(this.f21169g);
            this.f21165c.m24849a(this.f21169g, this.f21170h, this.f21171i, this.f21172j, z, graphQLSubscribeStatus);
        }
        int i = 0;
        if (this.f21168f != null) {
            this.f21168f.end();
        }
        this.f21166d.setVisibility(0);
        while (i < this.f21167e.getChildCount()) {
            final View childAt = this.f21167e.getChildAt(i);
            childAt.setVisibility(8);
            Animator loadAnimator = AnimatorInflater.loadAnimator(getContext(), 2131034112);
            loadAnimator.addListener(new AnimatorListener(this) {
                final /* synthetic */ ReactionContextItemsView f21160b;

                public void onAnimationStart(Animator animator) {
                    childAt.setVisibility(0);
                }

                public void onAnimationEnd(Animator animator) {
                }

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }
            });
            loadAnimator.setTarget(childAt);
            loadAnimator.setStartDelay((long) (i * 30));
            loadAnimator.start();
            i++;
        }
    }

    private void setContextItems(ReactionPageFieldsWithPlaceTipsInfoModel reactionPageFieldsWithPlaceTipsInfoModel) {
        boolean a;
        boolean z = false;
        this.f21167e.setSegmentedDivider(new ColorDrawable(getResources().getColor(2131361984)));
        EntityData entityData = new EntityData(reactionPageFieldsWithPlaceTipsInfoModel.eG_(), m24796a(reactionPageFieldsWithPlaceTipsInfoModel));
        ContextItemsAdapter contextItemsAdapter = (ContextItemsAdapter) this.f21163a.get();
        this.f21167e.setAdapter(contextItemsAdapter);
        contextItemsAdapter.m12860a(reactionPageFieldsWithPlaceTipsInfoModel.d(), ContextItemSurfaces.PLACE_TIPS, entityData);
        if (reactionPageFieldsWithPlaceTipsInfoModel.j() != null) {
            a = reactionPageFieldsWithPlaceTipsInfoModel.j().a();
            z = reactionPageFieldsWithPlaceTipsInfoModel.j().b();
        } else {
            a = false;
        }
        final PageContextItemHandlingData pageContextItemHandlingData = new PageContextItemHandlingData(Long.parseLong(reactionPageFieldsWithPlaceTipsInfoModel.eG_()), reactionPageFieldsWithPlaceTipsInfoModel.k(), null, reactionPageFieldsWithPlaceTipsInfoModel.eH_(), reactionPageFieldsWithPlaceTipsInfoModel.b(), null, a, z);
        this.f21167e.f10935g = new ContextItemsOnClickListener(this) {
            final /* synthetic */ ReactionContextItemsView f21162b;

            public final void mo1157a(View view, ContextItemFieldsModel contextItemFieldsModel) {
                this.f21162b.f21172j.m18937a(this.f21162b.f21169g.eG_(), WelcomeHeaderInteractionType.HEADER_CONTEXT_ITEM_TAP, contextItemFieldsModel.d().name());
                ((PageContextItemsClickHandler) this.f21162b.f21164b.get()).mo1040a(view, contextItemFieldsModel, pageContextItemHandlingData);
            }
        };
    }

    @Nullable
    private static GraphQLRating m24796a(ReactionPageFieldsWithPlaceTipsInfoModel reactionPageFieldsWithPlaceTipsInfoModel) {
        if (reactionPageFieldsWithPlaceTipsInfoModel.l() == null) {
            return null;
        }
        Builder builder = new Builder();
        builder.d = reactionPageFieldsWithPlaceTipsInfoModel.l().a();
        builder = builder;
        builder.f = reactionPageFieldsWithPlaceTipsInfoModel.l().b();
        return builder.a();
    }
}
