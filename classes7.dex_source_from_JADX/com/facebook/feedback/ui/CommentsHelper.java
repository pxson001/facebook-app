package com.facebook.feedback.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewStub;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil;
import com.facebook.feedback.ui.CommentListScrollStateController.ScrollingProxy;
import com.facebook.feedback.ui.FeedbackNewCommentsPillController.C04351;
import com.facebook.feedback.ui.FeedbackTypingPillController.C04371;
import com.facebook.feedback.ui.FeedbackTypingPillController.C04382;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedback.Builder;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.Assisted;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialManager.1;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.simplecamera.SimpleCameraCallback;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.photos.simplecamera.SimpleCamera;
import com.facebook.photos.simplecamera.SimpleCamera.CameraType;
import com.facebook.places.checkin.launcher.PlacePickerResultHandler;
import com.facebook.qe.api.QeAccessor;
import com.facebook.ufiservices.qe.UfiFlyoutQuickExperimentController;
import com.facebook.widget.LazyView;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.listview.ScrollingViewProxy.RecyclerListener;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: second-fetch */
public class CommentsHelper implements Bindable<FeedProps<GraphQLFeedback>> {
    public MediaItem f4354A;
    public NotificationLogObject f4355B;
    public boolean f4356C;
    private final CommentAdapter f4357a;
    private final BaseCommentsEnvironment f4358b;
    private final CommentListAutoscrollController f4359c = CommentListAutoscrollControllerProvider.m4873a(this.f4357a, this.f4360d);
    private final CommentListScrollStateController f4360d;
    public final CommentPhotoPickerUtil f4361e;
    private final FeedbackEventSubscriber f4362f;
    private final FeedbackGraphQLSubscriber f4363g;
    private final FeedbackNewCommentsPillController f4364h;
    private final FeedbackNewCommentsLoadingController f4365i;
    private final FeedbackTypingPillController f4366j;
    private final MultipleRowsStoriesRecycleCallback f4367k;
    private final Set<Bindable<FeedProps<GraphQLFeedback>>> f4368l = Sets.a(new Bindable[]{this.f4357a});
    public final Set<Bindable<GraphQLFeedback>> f4369m = Sets.a(new Bindable[]{this.f4358b, this.f4362f, this.f4363g});
    public final InterstitialManager f4370n;
    private final PlacePickerResultHandler f4371o;
    private final QeAccessor f4372p;
    private final FeedbackMutator f4373q;
    private final UfiFlyoutQuickExperimentController f4374r;
    private final OfflineCommentCache f4375s;
    public final SecureContextHelper f4376t;
    public CommentComposerView f4377u;
    public CommentsDisabledNoticeViewHelper f4378v;
    public FeedbackLoggingParams f4379w;
    public Fragment f4380x;
    private FeedProps<GraphQLFeedback> f4381y;
    public Long f4382z;

    /* compiled from: second-fetch */
    class C03951 implements RecyclerListener {
        final /* synthetic */ CommentsHelper f4340a;

        C03951(CommentsHelper commentsHelper) {
            this.f4340a = commentsHelper;
        }

        public final void m4949a(View view) {
            MultipleRowsStoriesRecycleCallback.a(view);
        }
    }

    /* compiled from: second-fetch */
    class C03962 implements SimpleCameraCallback {
        final /* synthetic */ CommentsHelper f4341a;

        C03962(CommentsHelper commentsHelper) {
            this.f4341a = commentsHelper;
        }

        public final void mo201a(ImmutableList<MediaItem> immutableList, boolean z) {
            this.f4341a.m4960a((MediaItem) Iterables.a(immutableList, null));
        }
    }

    /* compiled from: second-fetch */
    public class C04006 {
        public final /* synthetic */ CommentsHelper f4352a;

        public C04006(CommentsHelper commentsHelper) {
            this.f4352a = commentsHelper;
        }
    }

    /* compiled from: second-fetch */
    public class C04017 {
        public final /* synthetic */ CommentsHelper f4353a;

        public C04017(CommentsHelper commentsHelper) {
            this.f4353a = commentsHelper;
        }
    }

    public final void mo198a(Object obj) {
        FeedProps b;
        FeedProps feedProps = (FeedProps) obj;
        if (feedProps != null) {
            GraphQLFeedback graphQLFeedback;
            FeedbackMutator feedbackMutator = this.f4373q;
            GraphQLFeedback graphQLFeedback2 = (GraphQLFeedback) feedProps.a;
            if (graphQLFeedback2 == null) {
                graphQLFeedback = null;
            } else {
                Builder a = Builder.a(graphQLFeedback2);
                a.s = feedbackMutator.b.a();
                Builder builder = a;
                ImmutableList.Builder builder2 = new ImmutableList.Builder();
                ImmutableList i = GraphQLHelper.i(graphQLFeedback2);
                int size = i.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    int i4;
                    GraphQLComment graphQLComment = (GraphQLComment) i.get(i2);
                    if (FeedbackMutator.a(graphQLComment)) {
                        i4 = i3 + 1;
                    } else {
                        builder2.c(graphQLComment);
                        i4 = i3;
                    }
                    i2++;
                    i3 = i4;
                }
                graphQLFeedback = FeedbackMutator.a(builder, builder2.b(), GraphQLHelper.f(graphQLFeedback2) - i3, GraphQLHelper.h(graphQLFeedback2));
            }
            b = feedProps.b(graphQLFeedback);
        } else {
            b = null;
        }
        this.f4381y = b;
        for (Bindable a2 : this.f4368l) {
            a2.mo198a(this.f4381y);
        }
        for (Bindable a22 : this.f4369m) {
            a22.mo198a(this.f4381y != null ? (GraphQLFeedback) this.f4381y.a : null);
        }
    }

    @Inject
    public CommentsHelper(@Assisted Fragment fragment, @Assisted CommentAdapter commentAdapter, @Assisted CommentsEnvironment commentsEnvironment, @Assisted ScrollingProxy scrollingProxy, @Assisted Function<GraphQLFeedback, Void> function, CommentListAutoscrollControllerProvider commentListAutoscrollControllerProvider, CommentPhotoPickerUtil commentPhotoPickerUtil, RootFeedbackEventSubscriberProvider rootFeedbackEventSubscriberProvider, NestedFeedbackEventSubscriberProvider nestedFeedbackEventSubscriberProvider, FeedbackGraphQLSubscriber feedbackGraphQLSubscriber, FeedbackNewCommentsPillController feedbackNewCommentsPillController, FeedbackNewCommentsLoadingController feedbackNewCommentsLoadingController, FeedbackTypingPillController feedbackTypingPillController, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, InterstitialManager interstitialManager, PlacePickerResultHandler placePickerResultHandler, QeAccessor qeAccessor, FeedbackMutator feedbackMutator, UfiFlyoutQuickExperimentController ufiFlyoutQuickExperimentController, OfflineCommentCache offlineCommentCache, CommentsDisabledNoticeViewHelper commentsDisabledNoticeViewHelper, SecureContextHelper secureContextHelper, InlineReplyExpansionExperimentUtil inlineReplyExpansionExperimentUtil) {
        this.f4357a = commentAdapter;
        this.f4358b = commentsEnvironment;
        this.f4360d = new CommentListScrollStateController(commentAdapter, scrollingProxy);
        this.f4361e = commentPhotoPickerUtil;
        this.f4363g = feedbackGraphQLSubscriber;
        this.f4364h = feedbackNewCommentsPillController;
        this.f4365i = feedbackNewCommentsLoadingController;
        this.f4366j = feedbackTypingPillController;
        this.f4380x = fragment;
        this.f4367k = multipleRowsStoriesRecycleCallback;
        this.f4370n = interstitialManager;
        this.f4371o = placePickerResultHandler;
        this.f4372p = qeAccessor;
        this.f4373q = feedbackMutator;
        this.f4374r = ufiFlyoutQuickExperimentController;
        this.f4375s = offlineCommentCache;
        this.f4378v = commentsDisabledNoticeViewHelper;
        this.f4362f = m4952a(rootFeedbackEventSubscriberProvider, nestedFeedbackEventSubscriberProvider, commentAdapter, function, inlineReplyExpansionExperimentUtil);
        this.f4376t = secureContextHelper;
    }

    public final void m4958a(View view, ScrollingViewProxy scrollingViewProxy) {
        ViewStub viewStub = (ViewStub) FindViewUtil.b(view, 2131558484);
        FeedbackNewCommentsPillController feedbackNewCommentsPillController = this.f4364h;
        CommentListScrollStateController commentListScrollStateController = this.f4360d;
        feedbackNewCommentsPillController.f4573d = new LazyView(viewStub);
        feedbackNewCommentsPillController.f4570a = commentListScrollStateController;
        feedbackNewCommentsPillController.f4570a.m4878a(new C04351(feedbackNewCommentsPillController));
        Optional a = FindViewUtil.a(view, 2131562053);
        if (a.isPresent()) {
            FeedbackNewCommentsLoadingController feedbackNewCommentsLoadingController = this.f4365i;
            viewStub = (ViewStub) a.get();
            commentListScrollStateController = this.f4360d;
            feedbackNewCommentsLoadingController.f4563c = new LazyView(viewStub);
            feedbackNewCommentsLoadingController.f4562b = commentListScrollStateController;
        }
        viewStub = (ViewStub) FindViewUtil.b(view, 2131558485);
        FeedbackTypingPillController feedbackTypingPillController = this.f4366j;
        commentListScrollStateController = this.f4360d;
        feedbackTypingPillController.f4578b = new LazyView(viewStub);
        feedbackTypingPillController.f4577a = commentListScrollStateController;
        feedbackTypingPillController.f4577a.m4878a(new C04371(feedbackTypingPillController));
        feedbackTypingPillController.f4579c = new C04382(feedbackTypingPillController);
        this.f4366j.m3236a(this.f4364h);
        this.f4366j.m3236a(this.f4365i);
        CommentListScrollStateController commentListScrollStateController2 = this.f4360d;
        commentListScrollStateController2.f4281c = scrollingViewProxy;
        commentListScrollStateController2.f4281c.b(commentListScrollStateController2.f4286h);
        if (!commentListScrollStateController2.f4287i.isEmpty()) {
            for (OnScrollListener b : commentListScrollStateController2.f4287i) {
                commentListScrollStateController2.f4281c.b(b);
            }
            commentListScrollStateController2.f4287i.clear();
        }
        scrollingViewProxy.a(new C03951(this));
        this.f4377u = (CommentComposerView) FindViewUtil.b(view, 2131558483);
        this.f4377u.setOnMediaPickerOpenListener(new C04006(this));
        this.f4377u.setTransliterationClickListener(new C04017(this));
        this.f4377u.setVisibility(0);
        this.f4369m.add(this.f4377u);
        this.f4377u.setReshareButtonExperimentClicked(this.f4356C);
        if (this.f4379w != null) {
            this.f4377u.setFeedbackLoggingParams(this.f4379w);
        }
        if (this.f4355B != null) {
            this.f4377u.setNotificationLogObject(this.f4355B);
        }
        if (this.f4354A != null) {
            this.f4377u.setMediaItem(this.f4354A);
            this.f4354A = null;
        }
        if (this.f4382z != null) {
            this.f4377u.setGroupIdForTagging(this.f4382z);
        }
        this.f4378v.f4339c = (ViewStub) view.findViewById(2131558492);
        this.f4369m.add(this.f4378v);
    }

    public final void m4956a() {
        if (this.f4377u != null) {
            this.f4377u.mo244g();
            this.f4377u.setOnMediaPickerOpenListener(null);
            this.f4369m.remove(this.f4377u);
            this.f4377u = null;
        }
        CommentListScrollStateController commentListScrollStateController = this.f4360d;
        if (commentListScrollStateController.f4281c != null) {
            commentListScrollStateController.f4281c.a(null);
            commentListScrollStateController.f4281c.c(commentListScrollStateController.f4286h);
            commentListScrollStateController.f4281c = null;
        }
        this.f4364h.f4573d = null;
        this.f4365i.f4563c = null;
        this.f4366j.f4578b = null;
        this.f4369m.remove(this.f4378v);
        CommentsDisabledNoticeViewHelper commentsDisabledNoticeViewHelper = this.f4378v;
        commentsDisabledNoticeViewHelper.f4339c = null;
        commentsDisabledNoticeViewHelper.f4338b = null;
    }

    public final void m4967b() {
        this.f4362f.mo234a();
        this.f4363g.m5083a();
        this.f4360d.f4287i = null;
        this.f4379w = null;
        this.f4354A = null;
        this.f4355B = null;
        this.f4380x = null;
    }

    public final void m4968c() {
        this.f4363g.m5083a();
    }

    public final void m4969d() {
        GraphQLFeedback graphQLFeedback;
        FeedbackGraphQLSubscriber feedbackGraphQLSubscriber = this.f4363g;
        if (this.f4381y != null) {
            graphQLFeedback = (GraphQLFeedback) this.f4381y.a;
        } else {
            graphQLFeedback = null;
        }
        feedbackGraphQLSubscriber.m5084a(graphQLFeedback);
    }

    public final void m4957a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent.hasExtra("transliterated_text")) {
                        this.f4377u.mo242a(intent.getStringExtra("transliterated_text"), true);
                        return;
                    }
                    return;
                case 954:
                    m4960a(CommentPhotoPickerUtil.m4886a(i, i2, intent));
                    return;
                case 955:
                    CommentPhotoPickerUtil commentPhotoPickerUtil = this.f4361e;
                    SimpleCameraCallback c03962 = new C03962(this);
                    if (i2 == -1 && i == 955) {
                        ((SimpleCamera) commentPhotoPickerUtil.f4292d.get()).m12923a(CameraType.IMAGE, intent, c03962);
                    }
                    return;
                case 5002:
                    this.f4371o.a(intent);
                    return;
                default:
                    return;
            }
        }
    }

    public final void m4964a(String str) {
        CommentListAutoscrollController commentListAutoscrollController = this.f4359c;
        if (!commentListAutoscrollController.f4274c && str != null) {
            commentListAutoscrollController.f4274c = commentListAutoscrollController.f4273b.m4881a(str);
            if (commentListAutoscrollController.f4274c) {
                commentListAutoscrollController.f4272a.m4795a(str);
            }
        }
    }

    public final void m4970e() {
        CommentListAutoscrollController commentListAutoscrollController = this.f4359c;
        if (!commentListAutoscrollController.f4274c && commentListAutoscrollController.f4273b.m4883f()) {
            commentListAutoscrollController.f4274c = true;
        }
    }

    public final void m4965a(boolean z) {
        this.f4356C = z;
        if (this.f4377u != null) {
            this.f4377u.setReshareButtonExperimentClicked(z);
        }
    }

    public final boolean m4971f() {
        if (this.f4377u == null) {
            return false;
        }
        this.f4377u.mo248i();
        return true;
    }

    public final void m4959a(FeedbackLoggingParams feedbackLoggingParams) {
        this.f4379w = feedbackLoggingParams;
        this.f4357a.m4792a(this.f4379w);
        if (this.f4377u != null) {
            this.f4377u.setFeedbackLoggingParams(feedbackLoggingParams);
        }
    }

    public final void m4961a(NotificationLogObject notificationLogObject) {
        this.f4355B = notificationLogObject;
        CommentAdapter commentAdapter = this.f4357a;
        commentAdapter.f4169a.mo207a(notificationLogObject);
        commentAdapter.f4170b.mo207a(notificationLogObject);
        if (this.f4377u != null) {
            this.f4377u.setNotificationLogObject(notificationLogObject);
        }
    }

    public final boolean m4966a(Context context) {
        if (this.f4377u == null) {
            return false;
        }
        if (this.f4377u.mo247h()) {
            return true;
        }
        if (!this.f4377u.mo249j()) {
            return false;
        }
        String a = this.f4372p.a(ExperimentsForFeedbackTestModule.e, "");
        if ("education_reminder".equals(a) || "match_post_composer".equals(a) || "education_nux".equals(a)) {
            return m4954a(context, a);
        }
        return false;
    }

    private boolean m4954a(Context context, final String str) {
        final InterstitialController a = this.f4370n.a(CommentDraftEducationInterstitialController.a, CommentDraftEducationInterstitialController.class);
        if (!(a instanceof CommentDraftEducationInterstitialController) && !"match_post_composer".equals(str)) {
            return false;
        }
        CharSequence string = "match_post_composer".equals(str) ? context.getString(2131234587) : context.getString(2131233338);
        CharSequence string2 = "match_post_composer".equals(str) ? context.getString(2131234579) : context.getString(2131233339);
        CharSequence string3 = context.getString(2131234597);
        if ("education_reminder".equals(str)) {
            string3 = context.getString(2131233341);
        } else if ("education_nux".equals(str)) {
            string3 = context.getString(2131233340);
        }
        CharSequence string4 = "match_post_composer".equals(str) ? context.getString(2131234594) : context.getString(2131233342);
        final Activity activity = (Activity) ContextUtils.a(context, Activity.class);
        Fragment fragment = null;
        if (activity instanceof FbFragmentActivity) {
            fragment = ((FbFragmentActivity) activity).kO_().a("chromeless:content:fragment:tag");
        }
        final C03995 c03995 = new Runnable(this) {
            final /* synthetic */ CommentsHelper f4351c;

            public void run() {
                if (fragment == null || !(fragment instanceof DialogFragment)) {
                    activity.finish();
                } else {
                    ((DialogFragment) fragment).a();
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.a(true);
        builder.a(string);
        builder.b(string2);
        builder.a(string3, new OnClickListener(this) {
            final /* synthetic */ CommentsHelper f4345d;

            public void onClick(DialogInterface dialogInterface, int i) {
                if (!(a == null || "match_post_composer".equals(str))) {
                    InterstitialManager interstitialManager = this.f4345d.f4370n;
                    String b = a.b();
                    Futures.a(interstitialManager.a().e(b), new 1(interstitialManager, b), MoreExecutors.a());
                }
                if ("match_post_composer".equals(str)) {
                    this.f4345d.f4377u.mo250k();
                }
                dialogInterface.dismiss();
                c03995.run();
            }
        });
        if (!"education_nux".equals(str)) {
            builder.b(string4, new OnClickListener(this) {
                final /* synthetic */ CommentsHelper f4348c;

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if ("education_reminder".equals(str)) {
                        c03995.run();
                    }
                }
            });
        }
        builder.a().show();
        return true;
    }

    public final void m4962a(Long l) {
        this.f4382z = l;
        if (this.f4377u != null) {
            this.f4377u.setGroupIdForTagging(l);
        }
    }

    public final GraphQLFeedback m4955a(@Nullable GraphQLFeedback graphQLFeedback) {
        if (!(graphQLFeedback == null || graphQLFeedback.z_() == null)) {
            ImmutableList a = this.f4375s.m5178a(graphQLFeedback.z_());
            int size = a.size();
            for (int i = 0; i < size; i++) {
                graphQLFeedback = this.f4373q.a(graphQLFeedback, (GraphQLComment) a.get(i));
            }
        }
        return graphQLFeedback;
    }

    public final void m4960a(MediaItem mediaItem) {
        this.f4354A = mediaItem;
        if (this.f4377u != null) {
            this.f4377u.setMediaItem(this.f4354A);
            this.f4354A = null;
        }
    }

    public final void m4972g() {
        GraphQLFeedback graphQLFeedback;
        FeedbackNewCommentsLoadingController feedbackNewCommentsLoadingController = this.f4365i;
        if (this.f4381y != null) {
            graphQLFeedback = (GraphQLFeedback) this.f4381y.a;
        } else {
            graphQLFeedback = null;
        }
        if (feedbackNewCommentsLoadingController.f4563c != null) {
            if (graphQLFeedback != null) {
                ImmutableList i = GraphQLHelper.i(graphQLFeedback);
                if (!i.isEmpty()) {
                    feedbackNewCommentsLoadingController.f4567g = (GraphQLComment) i.get(0);
                }
            }
            feedbackNewCommentsLoadingController.mo230a();
        }
    }

    public final void m4973h() {
        GraphQLFeedback graphQLFeedback;
        FeedbackNewCommentsLoadingController feedbackNewCommentsLoadingController = this.f4365i;
        if (this.f4381y != null) {
            graphQLFeedback = (GraphQLFeedback) this.f4381y.a;
        } else {
            graphQLFeedback = null;
        }
        feedbackNewCommentsLoadingController.m5120b(graphQLFeedback);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @javax.annotation.Nullable
    public static com.facebook.graphql.model.GraphQLFeedback m4953a(@javax.annotation.Nullable com.facebook.graphql.model.GraphQLFeedback r9, @javax.annotation.Nullable java.lang.String r10, @javax.annotation.Nullable com.facebook.graphql.model.GraphQLComment r11, com.facebook.notifications.abtest.Notifications2gImprovementsExperimentController r12) {
        /*
        r1 = 1;
        r0 = 0;
        if (r10 == 0) goto L_0x003a;
    L_0x0004:
        r2 = r1;
    L_0x0005:
        if (r9 == 0) goto L_0x0010;
    L_0x0007:
        r5 = 0;
        if (r9 == 0) goto L_0x000c;
    L_0x000a:
        if (r10 != 0) goto L_0x003c;
    L_0x000c:
        r4 = r5;
    L_0x000d:
        r3 = r4;
        if (r3 != 0) goto L_0x0011;
    L_0x0010:
        r0 = r1;
    L_0x0011:
        if (r2 == 0) goto L_0x0039;
    L_0x0013:
        if (r0 == 0) goto L_0x0039;
    L_0x0015:
        r0 = r12.b();
        if (r0 == 0) goto L_0x0039;
    L_0x001b:
        if (r11 == 0) goto L_0x0039;
    L_0x001d:
        r0 = com.google.common.collect.ImmutableList.of(r11);
        r1 = new com.facebook.graphql.model.GraphQLCommentsConnection$Builder;
        r1.<init>();
        r1.e = r0;
        r0 = r1;
        r0 = r0.a();
        r1 = new com.facebook.graphql.model.GraphQLFeedback$Builder;
        r1.<init>();
        r1.l = r0;
        r0 = r1;
        r9 = r0.a();
    L_0x0039:
        return r9;
    L_0x003a:
        r2 = r0;
        goto L_0x0005;
    L_0x003c:
        r7 = com.facebook.graphql.model.GraphQLHelper.i(r9);
        r8 = r7.size();
        r6 = r5;
    L_0x0045:
        if (r6 >= r8) goto L_0x005d;
    L_0x0047:
        r4 = r7.get(r6);
        r4 = (com.facebook.graphql.model.GraphQLComment) r4;
        r4 = r4.y();
        r4 = r10.equals(r4);
        if (r4 == 0) goto L_0x0059;
    L_0x0057:
        r4 = 1;
        goto L_0x000d;
    L_0x0059:
        r4 = r6 + 1;
        r6 = r4;
        goto L_0x0045;
    L_0x005d:
        r4 = r5;
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.ui.CommentsHelper.a(com.facebook.graphql.model.GraphQLFeedback, java.lang.String, com.facebook.graphql.model.GraphQLComment, com.facebook.notifications.abtest.Notifications2gImprovementsExperimentController):com.facebook.graphql.model.GraphQLFeedback");
    }

    private FeedbackEventSubscriber m4952a(RootFeedbackEventSubscriberProvider rootFeedbackEventSubscriberProvider, NestedFeedbackEventSubscriberProvider nestedFeedbackEventSubscriberProvider, CommentAdapter commentAdapter, Function<GraphQLFeedback, Void> function, InlineReplyExpansionExperimentUtil inlineReplyExpansionExperimentUtil) {
        if (inlineReplyExpansionExperimentUtil.a()) {
            return nestedFeedbackEventSubscriberProvider.m5173a(function, commentAdapter, this.f4360d, this.f4364h, this.f4366j);
        }
        return rootFeedbackEventSubscriberProvider.m5222a(function, commentAdapter, this.f4360d, this.f4364h, this.f4366j);
    }
}
