package com.facebook.reaction.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.friendinviter.protocol.SendPageLikeInviteMethod.Params;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.ui.attachment.handler.ReactionFriendYouMayInviteToLikePageHandler;
import com.facebook.reaction.ui.attachment.handler.ReactionFriendYouMayInviteToLikePageHandler.C22041;
import com.facebook.reaction.ui.attachment.handler.ReactionFriendYouMayInviteToLikePageHandler.C22052;
import com.facebook.reaction.ui.attachment.handler.ReactionFriendYouMayInviteToLikePageHandler.C22073;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.BetterTextView;

/* compiled from: XConfig upgrade sync failed */
public class ReactionFriendToInviteToPageItem extends CustomLinearLayout {
    private final float f20765a = 1.0f;
    public final GlyphView f20766b;
    public final FbDraweeView f20767c;
    public final BetterTextView f20768d;

    /* compiled from: XConfig upgrade sync failed */
    public class C21971 implements OnClickListener {
        final /* synthetic */ C22041 f20763a;
        final /* synthetic */ ReactionFriendToInviteToPageItem f20764b;

        public C21971(ReactionFriendToInviteToPageItem reactionFriendToInviteToPageItem, C22041 c22041) {
            this.f20764b = reactionFriendToInviteToPageItem;
            this.f20763a = c22041;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 290592713);
            C22041 c22041 = this.f20763a;
            view.getContext();
            ReactionAttachmentHandler reactionAttachmentHandler = c22041.f20864c;
            ReactionFriendToInviteToPageItem reactionFriendToInviteToPageItem = c22041.f20862a;
            ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel = c22041.f20863b;
            ViewGroup viewGroup = (ViewGroup) reactionFriendToInviteToPageItem.getParent();
            Animation loadAnimation = AnimationUtils.loadAnimation(reactionAttachmentHandler.f18821d, 2130968716);
            loadAnimation.setDuration(300);
            loadAnimation.setAnimationListener(new C22073(reactionAttachmentHandler, viewGroup, reactionStoryAttachmentFragmentModel));
            reactionFriendToInviteToPageItem.startAnimation(loadAnimation);
            ReactionFriendYouMayInviteToLikePageHandler reactionFriendYouMayInviteToLikePageHandler = c22041.f20864c;
            ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel2 = c22041.f20863b;
            String b = reactionStoryAttachmentFragmentModel2.s().b();
            String b2 = reactionStoryAttachmentFragmentModel2.A().b();
            Bundle bundle = new Bundle();
            bundle.putParcelable("sendPageLikeInviteParams", new Params(b2, b));
            ((DefaultAndroidThreadUtil) reactionFriendYouMayInviteToLikePageHandler.f20870b.get()).a(BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) reactionFriendYouMayInviteToLikePageHandler.f20871c.get(), "send_page_like_invite", bundle, 1263077965).a(), new C22052(reactionFriendYouMayInviteToLikePageHandler));
            Logger.a(2, EntryType.UI_INPUT_END, -1605566360, a);
        }
    }

    public ReactionFriendToInviteToPageItem(Context context) {
        super(context);
        setContentView(2130906670);
        setOrientation(1);
        this.f20766b = (GlyphView) a(2131566718);
        this.f20767c = (FbDraweeView) a(2131566716);
        this.f20768d = (BetterTextView) a(2131566717);
        Resources resources = getResources();
        CustomViewUtils.b(this, resources.getDrawable(2130841042));
        int dimensionPixelSize = (((int) (((float) resources.getDisplayMetrics().widthPixels) * 0.6666667f)) - resources.getDimensionPixelSize(2131427416)) - (resources.getDimensionPixelSize(2131431363) * 2);
        this.f20767c.getLayoutParams().width = dimensionPixelSize;
        this.f20767c.getLayoutParams().height = dimensionPixelSize;
    }
}
