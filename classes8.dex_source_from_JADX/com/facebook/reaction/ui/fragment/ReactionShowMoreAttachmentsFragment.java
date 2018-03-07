package com.facebook.reaction.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionThemedContextHelper;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentStyleMapper;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.common.ReactionInteractionTrackerProvider;
import com.facebook.reaction.common.ReactionRecyclableAttachmentHandler;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.ui.attachment.ReactionShowMoreAttachmentsAdapter;
import com.facebook.reaction.ui.attachment.ReactionShowMoreAttachmentsAdapterProvider;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.DividerDecorator;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unknown item type for PersonCardActionBarPresenter.handlePersonActionBarItem  */
public class ReactionShowMoreAttachmentsFragment<VH extends ViewHolder> extends FbFragment implements ReactionCardContainer {
    public ReactionShowMoreAttachmentsAdapter<VH> f21134a;
    public BetterRecyclerView al;
    private String am;
    private ReactionSession an;
    private Surface ao;
    private ReactionInteractionTracker ap;
    private final OnScrollListener aq = new C22391(this);
    private final AdapterDataObserver ar = new C22402(this);
    private ReactionShowMoreAttachmentsAdapterProvider f21135b;
    private ReactionRecyclableAttachmentHandler<VH> f21136c;
    private ReactionAttachmentStyleMapper f21137d;
    public BetterLinearLayoutManager f21138e;
    public ImageView f21139f;
    private ReactionThemedContextHelper f21140g;
    private ReactionSessionManager f21141h;
    private ReactionInteractionTrackerProvider f21142i;

    /* compiled from: Unknown item type for PersonCardActionBarPresenter.handlePersonActionBarItem  */
    class C22391 extends OnScrollListener {
        final /* synthetic */ ReactionShowMoreAttachmentsFragment f21132a;

        C22391(ReactionShowMoreAttachmentsFragment reactionShowMoreAttachmentsFragment) {
            this.f21132a = reactionShowMoreAttachmentsFragment;
        }

        public final void m24770a(RecyclerView recyclerView, int i, int i2) {
            int n = this.f21132a.f21138e.n();
            int aZ_ = this.f21132a.f21134a.aZ_();
            if (aZ_ > 0 && n >= (aZ_ - 1) - 1) {
                this.f21132a.f21134a.m24431e();
            }
        }
    }

    /* compiled from: Unknown item type for PersonCardActionBarPresenter.handlePersonActionBarItem  */
    class C22402 extends AdapterDataObserver {
        final /* synthetic */ ReactionShowMoreAttachmentsFragment f21133a;

        C22402(ReactionShowMoreAttachmentsFragment reactionShowMoreAttachmentsFragment) {
            this.f21133a = reactionShowMoreAttachmentsFragment;
        }

        public final void bb_() {
            if (this.f21133a.f21134a.aZ_() != 0) {
                this.f21133a.f21139f.setVisibility(8);
                this.f21133a.f21139f.clearAnimation();
                this.f21133a.al.setVisibility(0);
            }
        }
    }

    public static void m24772a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ReactionShowMoreAttachmentsFragment) obj).m24771a((ReactionShowMoreAttachmentsAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionShowMoreAttachmentsAdapterProvider.class), ReactionAttachmentStyleMapper.m22863a(injectorLike), ReactionThemedContextHelper.m22628a(injectorLike), ReactionSessionManager.m22590a(injectorLike), (ReactionInteractionTrackerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionInteractionTrackerProvider.class));
    }

    @Inject
    private void m24771a(ReactionShowMoreAttachmentsAdapterProvider reactionShowMoreAttachmentsAdapterProvider, ReactionAttachmentStyleMapper reactionAttachmentStyleMapper, ReactionThemedContextHelper reactionThemedContextHelper, ReactionSessionManager reactionSessionManager, ReactionInteractionTrackerProvider reactionInteractionTrackerProvider) {
        this.f21135b = reactionShowMoreAttachmentsAdapterProvider;
        this.f21137d = reactionAttachmentStyleMapper;
        this.f21140g = reactionThemedContextHelper;
        this.f21141h = reactionSessionManager;
        this.f21142i = reactionInteractionTrackerProvider;
    }

    public final void m24777c(@Nullable Bundle bundle) {
        Class cls = ReactionShowMoreAttachmentsFragment.class;
        m24772a((Object) this, getContext());
        Preconditions.checkState(this.s.containsKey("attachment_style"), "ATTACHMENT_STYLE_TAG must be present");
        Preconditions.checkState(this.s.containsKey("reaction_session_id"), "REACTION_SESSION_ID_TAG must be present");
        Preconditions.checkState(this.s.get("reaction_surface") instanceof Surface, "REACTION_SURFACE_TAG must be a (non-null) Surface instance");
        Preconditions.checkState(this.s.containsKey("reaction_unit_id"), "UNIT_ID_TAG must be present");
        ReactionAttachmentHandler a = this.f21137d.m22865a((GraphQLReactionStoryAttachmentsStyle) this.s.getSerializable("attachment_style"));
        Preconditions.checkState(a instanceof ReactionRecyclableAttachmentHandler, "You must inherit from ReactionRecyclableAttachmentHandler to use this fragment");
        this.f21136c = (ReactionRecyclableAttachmentHandler) a;
        this.am = this.s.getString("reaction_session_id");
        this.an = this.f21141h.m22614b(this.am);
        this.f21138e = new BetterLinearLayoutManager(getContext());
        this.ap = this.f21142i.m22880a(this.an, this.f21138e);
        this.ao = (Surface) this.s.get("reaction_surface");
        this.f21134a = this.f21135b.m24432a(this.f21136c, this, this.am, this.ao, this.s.getString("reaction_unit_id"));
        super.c(bundle);
    }

    public final View m24773a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1819810862);
        View inflate = LayoutInflater.from(ReactionThemedContextHelper.m22627a(getContext(), (Surface) this.s.get("reaction_surface"))).inflate(2130906711, viewGroup, false);
        this.al = (BetterRecyclerView) inflate.findViewById(2131566779);
        this.f21139f = (ImageView) inflate.findViewById(2131566778);
        this.f21139f.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968602));
        this.al.setLayoutManager(this.f21138e);
        this.al.a(new DividerDecorator(getContext().getResources().getColor(2131361983), getContext().getResources().getDimensionPixelSize(2131427382)));
        this.al.setAdapter(this.f21134a);
        this.al.setOnScrollListener(this.aq);
        this.f21134a.a(this.ar);
        this.f21134a.m24431e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -851148461, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 164103490);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            String string = this.s.getString("show_more_title");
            if (string != null) {
                hasTitleBar.a_(string);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -342172346, a);
    }

    public final boolean mo728a(ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType) {
        return false;
    }

    public final boolean mo729a(String str, CardSearchType cardSearchType) {
        return false;
    }

    @Nullable
    public final ReactionUnitFragment mo725a(String str) {
        return null;
    }

    public ViewGroup getCardViewGroup() {
        return this.al;
    }

    @Nullable
    public Fragment getFragment() {
        return this;
    }

    @Nullable
    public ReactionInteractionTracker getInteractionTracker() {
        return this.ap;
    }

    public String getSessionId() {
        return this.am != null ? this.am : "NO_SESSION_ID";
    }

    @Nullable
    public Surface getSurface() {
        return this.ao;
    }
}
