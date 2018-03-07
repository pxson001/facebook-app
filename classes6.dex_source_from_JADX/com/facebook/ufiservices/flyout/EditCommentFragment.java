package com.facebook.ufiservices.flyout;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.ufiservices.common.EditCommentParams;
import com.facebook.attachments.AttachmentStyleUtil;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.draggable.Direction;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.graphql.model.GraphQLEditHistoryConnection;
import com.facebook.graphql.model.GraphQLEditHistoryConnection.Builder;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.sentry.SentryUtil;
import com.facebook.sentry.SentryUtil.SentryBlockTitle;
import com.facebook.tagging.graphql.data.CommentTaggingDataSource;
import com.facebook.tagging.graphql.utils.MentionsSpannableStringBuilder;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.ufiservices.event.CommentEvents.UpdateCommentEvent;
import com.facebook.ufiservices.event.FlyoutEventBus;
import com.facebook.ufiservices.flyout.views.FlyoutCommentEditView;
import com.facebook.ufiservices.futures.UFIFuturesGenerator;
import com.facebook.ufiservices.module.C1336x1da0976a;
import com.facebook.ufiservices.ui.CommentAttachmentView;
import com.facebook.ufiservices.ui.CommentEditView;
import com.facebook.ufiservices.ui.CommentEditView.C13371;
import com.facebook.ufiservices.ui.CommentEditView.C13382;
import com.facebook.ufiservices.ui.CommentEditView.C13393;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ui.errordialog.ErrorMessageGenerator;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.listeners.BaseAnimationListener;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Callables;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: da41209781b42d6b70d86635a403e095 */
public class EditCommentFragment extends FbFragment implements UFIContentFragment {
    public AnalyticsLogger f18030a;
    private FlyoutEventBus al;
    private FlyoutUtil am;
    public TasksManager an;
    private Toaster ao;
    private UFIFuturesGenerator ap;
    public FeedbackGraphQLGenerator aq;
    private GraphQLComment ar;
    private C13041 as;
    private View at;
    public FlyoutCommentEditView au;
    public String av;
    public GraphQLFeedback aw;
    private boolean ax;
    public PopoverFragmentContainer ay;
    private Rect az = new Rect();
    public AttachmentStyleUtil f18031b;
    private CommentTaggingDataSource f18032c;
    public CommonEventsBuilder f18033d;
    private ErrorDialogs f18034e;
    private ErrorMessageGenerator f18035f;
    public EventsStream f18036g;
    public FeedbackLoader f18037h;
    public FeedbackMutator f18038i;

    /* compiled from: da41209781b42d6b70d86635a403e095 */
    public class C13041 {
        public final /* synthetic */ EditCommentFragment f18022a;

        C13041(EditCommentFragment editCommentFragment) {
            this.f18022a = editCommentFragment;
        }

        public final void m26530a(GraphQLComment graphQLComment, Editable editable) {
            EditCommentFragment editCommentFragment = this.f18022a;
            if (editable != null) {
                int a;
                editCommentFragment.f18030a.a(CommonEventsBuilder.a("comment_edit", graphQLComment.l().j(), editCommentFragment.av));
                GraphQLTextWithEntities a2 = GraphQLHelper.a(editable.toString(), MentionsUtils.m25503b(editable), Lists.a(), Lists.a());
                Builder builder = new Builder();
                if (graphQLComment.x() != null) {
                    a = graphQLComment.x().a() + 1;
                } else {
                    a = 1;
                }
                builder.d = a;
                GraphQLEditHistoryConnection a3 = builder.a();
                GraphQLComment.Builder a4 = GraphQLComment.Builder.a(graphQLComment);
                a4.h = a2;
                GraphQLComment.Builder builder2 = a4;
                builder2.n = a3;
                GraphQLComment a5 = builder2.a();
                String str = null;
                if (GraphQLCommentHelper.b(graphQLComment)) {
                    Object obj;
                    GraphQLStoryAttachmentStyle a6 = editCommentFragment.f18031b.m10451a(FeedProps.c(graphQLComment).a(GraphQLCommentHelper.c(graphQLComment)));
                    if (a6 == GraphQLStoryAttachmentStyle.PHOTO || a6 == GraphQLStoryAttachmentStyle.VIDEO) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (!(obj == null || ((GraphQLStoryAttachment) graphQLComment.j().get(0)).r() == null)) {
                        str = ((GraphQLStoryAttachment) graphQLComment.j().get(0)).r().b();
                    }
                }
                editCommentFragment.f18036g.a(new UpdateCommentEvent(a5, editCommentFragment.aw.j()));
                ListenableFuture a7 = editCommentFragment.aq.a(new EditCommentParams(editCommentFragment.aw.j(), graphQLComment.l().j(), MentionsUtils.m25500a(editable), str, a5));
                editCommentFragment.an.a("edit_comment_" + graphQLComment.l().j(), Callables.a(a7), new C13085(editCommentFragment, graphQLComment, a5));
            }
            this.f18022a.ay.O_();
        }
    }

    /* compiled from: da41209781b42d6b70d86635a403e095 */
    class C13052 implements OnClickListener {
        final /* synthetic */ EditCommentFragment f18023a;

        C13052(EditCommentFragment editCommentFragment) {
            this.f18023a = editCommentFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -536608306);
            this.f18023a.au.m26723a();
            Logger.a(2, EntryType.UI_INPUT_END, 893566489, a);
        }
    }

    /* compiled from: da41209781b42d6b70d86635a403e095 */
    class C13063 extends Animation {
        final /* synthetic */ EditCommentFragment f18024a;

        C13063(EditCommentFragment editCommentFragment) {
            this.f18024a = editCommentFragment;
        }
    }

    /* compiled from: da41209781b42d6b70d86635a403e095 */
    class C13074 extends BaseAnimationListener {
        final /* synthetic */ EditCommentFragment f18025a;

        C13074(EditCommentFragment editCommentFragment) {
            this.f18025a = editCommentFragment;
        }

        public void onAnimationEnd(Animation animation) {
            this.f18025a.ay.dC_();
        }
    }

    /* compiled from: da41209781b42d6b70d86635a403e095 */
    public class C13085 extends OperationResultFutureCallback {
        final /* synthetic */ GraphQLComment f18026a;
        final /* synthetic */ GraphQLComment f18027b;
        final /* synthetic */ EditCommentFragment f18028c;

        public C13085(EditCommentFragment editCommentFragment, GraphQLComment graphQLComment, GraphQLComment graphQLComment2) {
            this.f18028c = editCommentFragment;
            this.f18026a = graphQLComment;
            this.f18027b = graphQLComment2;
        }

        public final void m26531a(ServiceException serviceException) {
            this.f18028c.f18036g.a(new UpdateCommentEvent(this.f18026a, this.f18028c.aw.z_()));
            EditCommentFragment.m26540a(this.f18028c, serviceException);
            AnalyticsLogger analyticsLogger = this.f18028c.f18030a;
            CommonEventsBuilder commonEventsBuilder = this.f18028c.f18033d;
            analyticsLogger.a(CommonEventsBuilder.a("comment_edit_failed", this.f18026a.l().j(), this.f18028c.av));
        }

        public final void m26532a(Object obj) {
            if (this.f18028c.aw != null) {
                this.f18028c.aw = this.f18028c.f18038i.b(this.f18028c.aw, this.f18027b);
                if (!Strings.isNullOrEmpty(this.f18027b.y())) {
                    EditCommentFragment editCommentFragment = this.f18028c;
                    String y = this.f18027b.y();
                    ListenableFuture a = editCommentFragment.f18037h.a(editCommentFragment.aw.j(), y, null, false, GraphQLHelper.b(editCommentFragment.aw));
                    editCommentFragment.an.a("fetch_comment_" + y, Callables.a(a), new C13096(editCommentFragment));
                }
            }
        }
    }

    /* compiled from: da41209781b42d6b70d86635a403e095 */
    public class C13096 extends AbstractDisposableFutureCallback<GraphQLComment> {
        final /* synthetic */ EditCommentFragment f18029a;

        public C13096(EditCommentFragment editCommentFragment) {
            this.f18029a = editCommentFragment;
        }

        protected final void m26533a(Object obj) {
            GraphQLComment graphQLComment = (GraphQLComment) obj;
            if (this.f18029a.aw != null) {
                this.f18029a.aw = this.f18029a.f18038i.b(this.f18029a.aw, graphQLComment);
            }
            if (graphQLComment != null) {
                this.f18029a.f18036g.a(new UpdateCommentEvent(graphQLComment, this.f18029a.aw.j()));
            }
        }

        protected final void m26534a(Throwable th) {
            EditCommentFragment.m26540a(this.f18029a, ServiceException.a(th));
        }
    }

    public static void m26541a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EditCommentFragment) obj).m26539a(AnalyticsLoggerMethodAutoProvider.a(fbInjector), C1336x1da0976a.m26778a(fbInjector), CommentTaggingDataSource.m25219b(fbInjector), CommonEventsBuilder.b(fbInjector), ErrorDialogs.a(fbInjector), ErrorMessageGenerator.b(fbInjector), EventsStream.a(fbInjector), FeedbackLoader.a(fbInjector), FeedbackMutator.a(fbInjector), FlyoutEventBus.a(fbInjector), FlyoutUtil.m26559a(fbInjector), TasksManager.b(fbInjector), Toaster.b(fbInjector), UFIFuturesGenerator.m26751a(fbInjector), FeedbackGraphQLGenerator.a(fbInjector));
    }

    @Inject
    private void m26539a(AnalyticsLogger analyticsLogger, AttachmentStyleUtil attachmentStyleUtil, CommentTaggingDataSource commentTaggingDataSource, CommonEventsBuilder commonEventsBuilder, ErrorDialogs errorDialogs, ErrorMessageGenerator errorMessageGenerator, EventsStream eventsStream, FeedbackLoader feedbackLoader, FeedbackMutator feedbackMutator, FlyoutEventBus flyoutEventBus, FlyoutUtil flyoutUtil, TasksManager tasksManager, Toaster toaster, UFIFuturesGenerator uFIFuturesGenerator, FeedbackGraphQLGenerator feedbackGraphQLGenerator) {
        this.f18030a = analyticsLogger;
        this.f18031b = attachmentStyleUtil;
        this.f18032c = commentTaggingDataSource;
        this.f18033d = commonEventsBuilder;
        this.f18034e = errorDialogs;
        this.f18035f = errorMessageGenerator;
        this.f18036g = eventsStream;
        this.f18037h = feedbackLoader;
        this.f18038i = feedbackMutator;
        this.al = flyoutEventBus;
        this.am = flyoutUtil;
        this.an = tasksManager;
        this.ao = toaster;
        this.ap = uFIFuturesGenerator;
        this.aq = feedbackGraphQLGenerator;
    }

    public final void m26548c(Bundle bundle) {
        super.c(bundle);
        Class cls = EditCommentFragment.class;
        m26541a((Object) this, getContext());
        Bundle bundle2 = this.s;
        this.av = bundle2.getString("moduleName");
        this.aw = (GraphQLFeedback) FlatBufferModelHelper.a(bundle2, "feedback");
        this.ar = (GraphQLComment) FlatBufferModelHelper.a(bundle2, "comment");
        this.ax = bundle2.getBoolean("standalone");
        this.as = new C13041(this);
        this.ay = (PopoverFragmentContainer) this.G;
    }

    public final View m26542a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 674858198);
        this.at = layoutInflater.inflate(2130904383, viewGroup, false);
        View view = this.at;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 842951094, a);
        return view;
    }

    public final void m26544a(View view, Bundle bundle) {
        this.au = (FlyoutCommentEditView) e(2131562088);
        this.au.f18181g.setExtraDataSource(this.f18032c);
        CommentEditView commentEditView = this.au;
        FeedProps c = FeedProps.c(this.ar);
        C13041 c13041 = this.as;
        commentEditView.f18187m = c;
        commentEditView.f18186l = (GraphQLComment) c.a;
        commentEditView.f18188n = c13041;
        if (commentEditView.f18186l.r().ai() != null) {
            commentEditView.f18180f.a(Uri.parse(commentEditView.f18186l.r().ai().b()), CommentEditView.f18175d);
        } else {
            commentEditView.f18180f.a(null, CommentEditView.f18175d);
        }
        commentEditView.f18181g.setText(MentionsSpannableStringBuilder.m25489a(commentEditView.f18186l.s(), commentEditView.f18179e.getResources(), commentEditView.f18177b));
        if (CommentEditView.m26722c(commentEditView)) {
            if (commentEditView.f18185k == null) {
                commentEditView.f18185k = (CommentAttachmentView) commentEditView.f18184j.a();
            }
            commentEditView.f18185k.setVisibility(0);
            commentEditView.f18185k.m26782a(commentEditView.f18187m, commentEditView.f18178c);
        } else if (commentEditView.f18185k != null) {
            commentEditView.f18185k.setVisibility(8);
        }
        if (!commentEditView.f18189o) {
            commentEditView.f18189o = true;
            commentEditView.f18181g.addTextChangedListener(new C13371(commentEditView));
            commentEditView.f18182h.setOnClickListener(new C13382(commentEditView));
            commentEditView.f18183i.setOnClickListener(new C13393(commentEditView));
        }
        if (!this.ax) {
            e(2131562085).setVisibility(0);
            e(2131562084).setOnClickListener(new C13052(this));
        }
    }

    public final Animation m26543a(int i, boolean z, int i2) {
        Animation animation = null;
        if (!this.am.f18076a) {
            animation = new C13063(this);
            animation.setDuration(0);
        } else if (i2 != 0) {
            animation = AnimationUtils.loadAnimation(getContext(), i2);
        }
        if (animation != null) {
            animation.setAnimationListener(new C13074(this));
        }
        return animation;
    }

    public final boolean mo1354b() {
        return false;
    }

    public final void mo1355e() {
    }

    public final void aq() {
    }

    public static void m26540a(EditCommentFragment editCommentFragment, ServiceException serviceException) {
        CharSequence a = editCommentFragment.f18035f.a(serviceException, true, true);
        if (!editCommentFragment.f18035f.b(serviceException) || editCommentFragment.E == null) {
            editCommentFragment.ao.b(new ToastBuilder(a));
            return;
        }
        ErrorDialogs errorDialogs = editCommentFragment.f18034e;
        ErrorDialogParamsBuilder a2 = ErrorDialogParams.a(editCommentFragment.jW_()).a(SentryBlockTitle.SENTRY_COMMENT_EDIT_BLOCK.getTitleId());
        a2.c = a;
        ErrorDialogParamsBuilder c = a2.c(2131230784);
        c.e = SentryUtil.f15951a;
        errorDialogs.a(c.l());
    }

    public final boolean mo1348a(float f, float f2, Direction direction) {
        TextView textView = this.au.f18181g;
        textView.getGlobalVisibleRect(this.az);
        boolean z = textView.getLineCount() * textView.getLineHeight() > textView.getHeight();
        if (this.az.contains((int) f, (int) f2) && z) {
            return false;
        }
        return direction.isYAxis();
    }

    public final View at() {
        return null;
    }

    public final void mo1353b(View view) {
    }

    public final String ar() {
        return "flyout_comments_edit_animation_perf";
    }

    public final void as() {
    }
}
