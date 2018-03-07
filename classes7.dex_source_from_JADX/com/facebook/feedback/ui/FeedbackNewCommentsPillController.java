package com.facebook.feedback.ui;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feedback.ui.FriendsOnlySocialPillHelper.Mode;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.widget.LazyView;
import com.facebook.widget.listview.BaseProxyOnScrollListener;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: sOverlay */
public class FeedbackNewCommentsPillController extends AbstractPillController {
    public CommentListScrollStateController f4570a;
    public FriendsOnlySocialPillHelper f4571b;
    public GraphQLComment f4572c;
    public LazyView<NewCommentsPillView> f4573d;

    /* compiled from: sOverlay */
    public class C04351 extends BaseProxyOnScrollListener {
        final /* synthetic */ FeedbackNewCommentsPillController f4568a;

        public C04351(FeedbackNewCommentsPillController feedbackNewCommentsPillController) {
            this.f4568a = feedbackNewCommentsPillController;
        }

        public final void m5122a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            if (this.f4568a.f4570a.m4879a()) {
                this.f4568a.m3238b();
                this.f4568a.f4571b.m5139b();
            }
        }
    }

    /* compiled from: sOverlay */
    class C04362 implements OnClickListener {
        final /* synthetic */ FeedbackNewCommentsPillController f4569a;

        C04362(FeedbackNewCommentsPillController feedbackNewCommentsPillController) {
            this.f4569a = feedbackNewCommentsPillController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1468507422);
            this.f4569a.m3238b();
            if (this.f4569a.f4572c != null) {
                this.f4569a.f4570a.m4881a(this.f4569a.f4572c.y());
            }
            this.f4569a.f4571b.m5139b();
            Logger.a(2, EntryType.UI_INPUT_END, -285780051, a);
        }
    }

    public static FeedbackNewCommentsPillController m5123a(InjectorLike injectorLike) {
        return new FeedbackNewCommentsPillController(SpringSystem.b(injectorLike), ViewHelperViewAnimatorFactory.a(injectorLike), new FriendsOnlySocialPillHelper());
    }

    @Inject
    public FeedbackNewCommentsPillController(SpringSystem springSystem, ViewHelperViewAnimatorFactory viewHelperViewAnimatorFactory, FriendsOnlySocialPillHelper friendsOnlySocialPillHelper) {
        super(springSystem, viewHelperViewAnimatorFactory);
        this.f4571b = friendsOnlySocialPillHelper;
    }

    protected final LazyView<? extends View> mo130g() {
        return this.f4573d;
    }

    public final void m5124a(GraphQLComment graphQLComment) {
        if (this.f4570a != null && graphQLComment != null) {
            this.f4572c = graphQLComment;
            if (this.f4570a.m4879a()) {
                this.f4570a.m4881a(graphQLComment.y());
                return;
            }
            ImmutableList immutableList;
            FriendsOnlySocialPillHelper friendsOnlySocialPillHelper = this.f4571b;
            if (!(graphQLComment == null || graphQLComment.r() == null)) {
                friendsOnlySocialPillHelper.f4586d++;
                if (graphQLComment.r().S()) {
                    friendsOnlySocialPillHelper.f4584b.add(FriendsOnlySocialPillHelper.m5137b(graphQLComment));
                    if (!(graphQLComment == null || graphQLComment.r() == null || graphQLComment.r().ai() == null || graphQLComment.r().ai().b() == null)) {
                        Uri a = ImageUtil.a(graphQLComment.r().ai());
                        if (!friendsOnlySocialPillHelper.f4583a.contains(a)) {
                            if (friendsOnlySocialPillHelper.f4583a.size() >= 3) {
                                friendsOnlySocialPillHelper.f4583a.remove(0);
                            }
                            friendsOnlySocialPillHelper.f4583a.add(a);
                        }
                    }
                    friendsOnlySocialPillHelper.f4587e = graphQLComment;
                } else {
                    friendsOnlySocialPillHelper.f4585c.add(FriendsOnlySocialPillHelper.m5137b(graphQLComment));
                }
                if (friendsOnlySocialPillHelper.f4584b.isEmpty()) {
                    friendsOnlySocialPillHelper.f4588f = Mode.NO_FRIENDS;
                } else if (friendsOnlySocialPillHelper.f4584b.size() == 1 && friendsOnlySocialPillHelper.f4585c.isEmpty()) {
                    friendsOnlySocialPillHelper.f4588f = Mode.ONE_FRIEND_ONLY;
                } else if (friendsOnlySocialPillHelper.f4584b.size() == 2 && friendsOnlySocialPillHelper.f4585c.isEmpty()) {
                    friendsOnlySocialPillHelper.f4588f = Mode.TWO_FRIENDS_ONLY;
                } else {
                    friendsOnlySocialPillHelper.f4588f = Mode.FRIEND_AND_OTHERS;
                }
            }
            ((NewCommentsPillView) this.f4573d.a()).setPillText(this.f4571b.m5138a(((NewCommentsPillView) this.f4573d.a()).getContext()));
            NewCommentsPillView newCommentsPillView = (NewCommentsPillView) this.f4573d.a();
            FriendsOnlySocialPillHelper friendsOnlySocialPillHelper2 = this.f4571b;
            if (friendsOnlySocialPillHelper2.f4588f == Mode.NO_FRIENDS) {
                immutableList = null;
            } else {
                immutableList = ImmutableList.copyOf(friendsOnlySocialPillHelper2.f4583a);
            }
            newCommentsPillView.setPillProfilePictures(immutableList);
            ((NewCommentsPillView) this.f4573d.a()).setOnClickListener(new C04362(this));
            mo230a();
        }
    }
}
