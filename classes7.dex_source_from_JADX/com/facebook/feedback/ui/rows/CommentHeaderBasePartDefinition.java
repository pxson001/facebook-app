package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewStub;
import com.facebook.attachments.AttachmentStyleUtil;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.CommentStylingPartDefinition.Props;
import com.facebook.feedback.ui.rows.views.CommentHeaderBaseView;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.conversion.ActorToProfileConverter;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.renderers.RendererUtils;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ufiservices.cache.PendingCommentCache;
import com.facebook.ufiservices.module.AttachmentStyleUtil_UfiSupportedAttachmentStyleMethodAutoProvider;
import com.facebook.ufiservices.util.LinkifyUtil;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_opt_in_nux_finish */
public class CommentHeaderBasePartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLComment>, State, CommentsEnvironment, CommentHeaderBaseView> {
    public static final CallerContext f4919a = CallerContext.a(CommentHeaderBaseView.class);
    private static CommentHeaderBasePartDefinition f4920j;
    private static final Object f4921k = new Object();
    private final LinkifyUtil f4922b;
    public final AttachmentStyleUtil f4923c;
    private final TextPartDefinition f4924d;
    private final CommentStylingPartDefinition f4925e;
    private final CommentFailedStatusPartDefinition f4926f;
    private final QeAccessor f4927g;
    public final PendingCommentCache f4928h;
    public final boolean f4929i = this.f4927g.a(ExperimentsForFeedbackTestModule.A, false);

    /* compiled from: ridge_opt_in_nux_finish */
    public class State {
        public final Uri f4918a;

        public State(Uri uri) {
            this.f4918a = uri;
        }
    }

    private static CommentHeaderBasePartDefinition m5433b(InjectorLike injectorLike) {
        return new CommentHeaderBasePartDefinition(LinkifyUtil.a(injectorLike), AttachmentStyleUtil_UfiSupportedAttachmentStyleMethodAutoProvider.a(injectorLike), TextPartDefinition.a(injectorLike), CommentStylingPartDefinition.m5508a(injectorLike), CommentFailedStatusPartDefinition.m5416a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), PendingCommentCache.a(injectorLike));
    }

    public final Object m5434a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        GraphQLComment graphQLComment = (GraphQLComment) feedProps.a;
        Uri parse = Uri.parse(GraphQLHelper.a(graphQLComment.r()));
        Context context = baseCommentsEnvironment.getContext();
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(2130773278, typedValue, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(typedValue.resourceId, new int[]{16842904});
        int resourceId = obtainStyledAttributes.getResourceId(0, 2131361848);
        obtainStyledAttributes.recycle();
        CharSequence a = LinkifyUtil.a(this.f4922b.a(LinkifyTargetBuilder.a(graphQLComment.r()), null, resourceId, false));
        CommentRowPadding commentRowPadding = CommentLevel.TOP_LEVEL.equals(CommentLevel.getCommentLevel(feedProps)) ? CommentRowPadding.NO_OFFSET : CommentRowPadding.PROFILE_PICTURE_OFFSET;
        subParts.a(2131560434, this.f4924d, a);
        subParts.a(this.f4925e, new Props(commentRowPadding));
        subParts.a(2131568180, this.f4926f, feedProps);
        return new State(parse);
    }

    public final /* bridge */ /* synthetic */ void m5435a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int i;
        int i2;
        int a = Logger.a(8, EntryType.MARK_PUSH, 1169727718);
        FeedProps feedProps = (FeedProps) obj;
        BaseCommentsEnvironment baseCommentsEnvironment = (BaseCommentsEnvironment) anyEnvironment;
        CommentHeaderBaseView commentHeaderBaseView = (CommentHeaderBaseView) view;
        GraphQLComment graphQLComment = (GraphQLComment) feedProps.a;
        commentHeaderBaseView.m5624a(ActorToProfileConverter.a(graphQLComment.r()), ((State) obj2).f4918a, f4919a);
        commentHeaderBaseView.setVerifiedBadgeVisibility(graphQLComment.A());
        commentHeaderBaseView.setPinnedIconVisibility(graphQLComment.C());
        boolean z = (graphQLComment.r() == null || !graphQLComment.r().T() || graphQLComment.r().aM()) ? false : true;
        commentHeaderBaseView.setWorkMultiCompanyIconVisibiity(z);
        if (this.f4929i) {
            Object obj3;
            if (commentHeaderBaseView.f5167j.getVisibility() == 0) {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if (obj3 != null) {
                i = 48;
            } else {
                i = 16;
            }
            commentHeaderBaseView.setGravity(i);
        } else {
            commentHeaderBaseView.m5623a(feedProps, this.f4923c);
        }
        if (CommentLevel.TOP_LEVEL.equals(CommentLevel.getCommentLevel(feedProps))) {
            i2 = baseCommentsEnvironment.f4812i.f4820a;
            i = baseCommentsEnvironment.f4812i.f4824e;
        } else {
            i2 = baseCommentsEnvironment.f4812i.f4821b;
            i = baseCommentsEnvironment.f4812i.f4825f;
        }
        commentHeaderBaseView.setThumbnailSize(i);
        commentHeaderBaseView.setPadding(commentHeaderBaseView.getPaddingLeft(), i2, commentHeaderBaseView.getPaddingRight(), 0);
        if (this.f4928h.c(graphQLComment.H()) == GraphQLFeedOptimisticPublishState.FAILED) {
            ViewStub viewStub = (ViewStub) RendererUtils.a(commentHeaderBaseView, 2131560437);
            if (!(viewStub == null || viewStub.getParent() == null)) {
                viewStub.inflate();
            }
        }
        Logger.a(8, EntryType.MARK_POP, 1364073392, a);
    }

    public static CommentHeaderBasePartDefinition m5432a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentHeaderBasePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4921k) {
                CommentHeaderBasePartDefinition commentHeaderBasePartDefinition;
                if (a2 != null) {
                    commentHeaderBasePartDefinition = (CommentHeaderBasePartDefinition) a2.a(f4921k);
                } else {
                    commentHeaderBasePartDefinition = f4920j;
                }
                if (commentHeaderBasePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5433b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4921k, b3);
                        } else {
                            f4920j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentHeaderBasePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public CommentHeaderBasePartDefinition(LinkifyUtil linkifyUtil, AttachmentStyleUtil attachmentStyleUtil, TextPartDefinition textPartDefinition, CommentStylingPartDefinition commentStylingPartDefinition, CommentFailedStatusPartDefinition commentFailedStatusPartDefinition, QeAccessor qeAccessor, PendingCommentCache pendingCommentCache) {
        this.f4922b = linkifyUtil;
        this.f4923c = attachmentStyleUtil;
        this.f4924d = textPartDefinition;
        this.f4925e = commentStylingPartDefinition;
        this.f4926f = commentFailedStatusPartDefinition;
        this.f4927g = qeAccessor;
        this.f4928h = pendingCommentCache;
    }
}
