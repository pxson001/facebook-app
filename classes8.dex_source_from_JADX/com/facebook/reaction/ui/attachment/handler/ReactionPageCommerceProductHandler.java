package com.facebook.reaction.ui.attachment.handler;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.commerce.core.ui.ProductItemAtGlanceView;
import com.facebook.commerce.core.ui.ProductItemAtGlanceViewModel;
import com.facebook.commerce.core.util.CommerceCurrencyUtil;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionAttachmentListener;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.interfaces.ReactionUnitParent;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionAttachmentActionFragmentModel;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: View quick promotion configuration */
public class ReactionPageCommerceProductHandler extends ReactionAttachmentHandler {
    private static final CallerContext f20888a = CallerContext.a(ReactionPageCommerceProductHandler.class, "timeline");
    private final ReactionIntentFactory f20889b;
    private LinearLayout f20890c;
    private LinearLayout f20891d;
    private LinearLayout f20892e;
    private int f20893f;
    private int f20894g;
    private int f20895h;

    @Inject
    public ReactionPageCommerceProductHandler(ReactionIntentLauncher reactionIntentLauncher, ReactionIntentFactory reactionIntentFactory) {
        super(reactionIntentLauncher);
        this.f20889b = reactionIntentFactory;
    }

    public final void mo1127a(ReactionAttachmentListener reactionAttachmentListener, ViewGroup viewGroup, ReactionCardContainer reactionCardContainer, String str, Surface surface, @Nullable ReactionUnitParent reactionUnitParent) {
        super.mo1127a(reactionAttachmentListener, viewGroup, reactionCardContainer, str, surface, reactionUnitParent);
        this.f20890c = (LinearLayout) m22840a(2130906007);
        this.f20891d = (LinearLayout) this.f20890c.findViewById(2131565436);
        this.f20892e = (LinearLayout) this.f20890c.findViewById(2131565437);
        this.f18820c.addView(this.f20890c);
        this.f20895h = viewGroup.getResources().getDimensionPixelSize(2131427419);
    }

    protected final int mo1128b(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel) {
        this.f20893f = m24518b(reactionAttachmentsModel.b().size());
        this.f20894g = 0;
        this.f20891d.removeAllViews();
        this.f20892e.removeAllViews();
        if (this.f20893f < 2) {
            this.f20892e.setVisibility(8);
        } else {
            this.f20892e.setVisibility(0);
        }
        if (this.f20893f == 0) {
            return 0;
        }
        return super.mo1128b(str, str2, reactionAttachmentsModel);
    }

    protected final void mo1132a(View view) {
        if (this.f20894g < this.f20893f) {
            if (this.f20894g < 2) {
                this.f20891d.addView(view);
            } else {
                this.f20892e.addView(view);
            }
            this.f20894g++;
        }
    }

    protected final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        ProductItemAtGlanceView productItemAtGlanceView = new ProductItemAtGlanceView(this.f20890c.getContext());
        productItemAtGlanceView.setLayoutParams(layoutParams);
        productItemAtGlanceView.setPadding(this.f20895h, this.f20895h, this.f20895h, this.f20895h);
        productItemAtGlanceView.a(new ProductItemAtGlanceViewModel(Uri.parse(reactionStoryAttachmentFragmentModel.L().c().a()), reactionStoryAttachmentFragmentModel.L().d(), CommerceCurrencyUtil.a(reactionStoryAttachmentFragmentModel.L().eO_())));
        return productItemAtGlanceView;
    }

    protected final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        if (reactionStoryAttachmentFragmentModel.b() == null || reactionStoryAttachmentFragmentModel.b().isEmpty() || reactionStoryAttachmentFragmentModel.b().get(0) == null || ((ReactionAttachmentActionFragmentModel) reactionStoryAttachmentFragmentModel.b().get(0)).c() == null || ((ReactionAttachmentActionFragmentModel) reactionStoryAttachmentFragmentModel.b().get(0)).c().b() == null || reactionStoryAttachmentFragmentModel.L() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.L().b())) {
            return null;
        }
        return this.f20889b.m22769d(view.getContext(), ((ReactionAttachmentActionFragmentModel) reactionStoryAttachmentFragmentModel.b().get(0)).c().b(), reactionStoryAttachmentFragmentModel.L().b());
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel == null || reactionStoryAttachmentFragmentModel.L() == null || reactionStoryAttachmentFragmentModel.L().c() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.L().c().a()) || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.L().d()) || reactionStoryAttachmentFragmentModel.L().eO_() == null) ? false : true;
    }

    public static int m24518b(int i) {
        if (i <= 0) {
            return 0;
        }
        if (i != 1) {
            return (i <= 1 || i >= 5) ? 5 : 2;
        } else {
            return i;
        }
    }
}
