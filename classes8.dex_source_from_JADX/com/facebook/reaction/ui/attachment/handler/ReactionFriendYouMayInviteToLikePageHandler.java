package com.facebook.reaction.ui.attachment.handler;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.Lazy;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionAttachmentListener;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.interfaces.ReactionUnitParent;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.ui.ReactionFriendToInviteToPageItem;
import com.facebook.reaction.ui.ReactionFriendToInviteToPageItem.C21971;
import com.facebook.reaction.ui.attachment.handler.AbstractReactionHscrollHandler.C22001;
import com.facebook.reaction.ui.attachment.handler.AbstractReactionHscrollHandler.ReactionHscrollHandlerItemPaddingStyle;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: WAITING_FOR_MOVES */
public class ReactionFriendYouMayInviteToLikePageHandler extends AbstractReactionHscrollHandler {
    public final Lazy<AndroidThreadUtil> f20870b;
    public final Lazy<BlueServiceOperationFactory> f20871c;
    public final Lazy<Toaster> f20872d;

    /* compiled from: WAITING_FOR_MOVES */
    public class C22052 extends OperationResultFutureCallback {
        final /* synthetic */ ReactionFriendYouMayInviteToLikePageHandler f20865a;

        public C22052(ReactionFriendYouMayInviteToLikePageHandler reactionFriendYouMayInviteToLikePageHandler) {
            this.f20865a = reactionFriendYouMayInviteToLikePageHandler;
        }

        protected final void m24492a(ServiceException serviceException) {
            ((Toaster) this.f20865a.f20872d.get()).b(new ToastBuilder(2131239344));
        }

        protected final void m24493a(Object obj) {
            ((Toaster) this.f20865a.f20872d.get()).b(new ToastBuilder(2131237292));
        }
    }

    /* compiled from: WAITING_FOR_MOVES */
    public class C22073 implements AnimationListener {
        final /* synthetic */ ViewGroup f20867a;
        final /* synthetic */ ReactionStoryAttachmentFragmentModel f20868b;
        final /* synthetic */ ReactionFriendYouMayInviteToLikePageHandler f20869c;

        /* compiled from: WAITING_FOR_MOVES */
        class C22061 implements Runnable {
            final /* synthetic */ C22073 f20866a;

            C22061(C22073 c22073) {
                this.f20866a = c22073;
            }

            public void run() {
                AbstractReactionHscrollHandler abstractReactionHscrollHandler = this.f20866a.f20869c;
                abstractReactionHscrollHandler.f20806b.f20800c.remove(this.f20866a.f20868b);
                abstractReactionHscrollHandler.f20806b.kR_();
            }
        }

        public C22073(ReactionFriendYouMayInviteToLikePageHandler reactionFriendYouMayInviteToLikePageHandler, ViewGroup viewGroup, ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
            this.f20869c = reactionFriendYouMayInviteToLikePageHandler;
            this.f20867a = viewGroup;
            this.f20868b = reactionStoryAttachmentFragmentModel;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f20867a.post(new C22061(this));
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    @Inject
    public ReactionFriendYouMayInviteToLikePageHandler(Lazy<AndroidThreadUtil> lazy, Lazy<BlueServiceOperationFactory> lazy2, ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher, ReactionUtil reactionUtil, Lazy<Toaster> lazy3) {
        super(reactionIntentFactory, reactionIntentLauncher, reactionUtil);
        this.f20870b = lazy;
        this.f20871c = lazy2;
        this.f20872d = lazy3;
    }

    public final void mo1127a(ReactionAttachmentListener reactionAttachmentListener, ViewGroup viewGroup, ReactionCardContainer reactionCardContainer, String str, Surface surface, @Nullable ReactionUnitParent reactionUnitParent) {
        super.mo1127a(reactionAttachmentListener, viewGroup, reactionCardContainer, str, surface, reactionUnitParent);
        switch (C22001.f20792a[ReactionHscrollHandlerItemPaddingStyle.FIG_STANDARD_PADDING.ordinal()]) {
            case 1:
                this.f20810f.setPageMargin(0);
                return;
            case 2:
                this.f20810f.setPageMargin(this.f20810f.getResources().getDimensionPixelSize(2131427416));
                return;
            default:
                return;
        }
    }

    protected final View mo1118a(final ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        final ReactionFriendToInviteToPageItem reactionFriendToInviteToPageItem = new ReactionFriendToInviteToPageItem(this.f18821d);
        C22041 c22041 = new Object(this) {
            public final /* synthetic */ ReactionFriendYouMayInviteToLikePageHandler f20864c;
        };
        reactionFriendToInviteToPageItem.f20768d.setText(reactionStoryAttachmentFragmentModel.s().c());
        reactionFriendToInviteToPageItem.f20766b.setOnClickListener(new C21971(reactionFriendToInviteToPageItem, c22041));
        reactionFriendToInviteToPageItem.f20767c.setAspectRatio(1.0f);
        reactionFriendToInviteToPageItem.f20767c.setImageURI(Uri.parse(reactionStoryAttachmentFragmentModel.s().d().b()));
        return reactionFriendToInviteToPageItem;
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.s() == null || reactionStoryAttachmentFragmentModel.s().b() == null || reactionStoryAttachmentFragmentModel.s().c() == null || reactionStoryAttachmentFragmentModel.A() == null || reactionStoryAttachmentFragmentModel.A().b() == null) ? false : true;
    }

    protected final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return this.f20808d.m22761b(reactionStoryAttachmentFragmentModel.s().b(), UnitInteractionType.PROFILE_TAP);
    }

    protected final float mo1133i() {
        return 0.6666667f;
    }
}
