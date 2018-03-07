package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.CommentStylingPartDefinition.Props;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
import com.facebook.feedback.ui.rows.views.CommentShareView;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_mic_permission_canceled */
public class CommentShareAttachmentPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, CommentsEnvironment, CommentShareView> {
    public static final ViewType f5013a = new C04931();
    private static CommentShareAttachmentPartDefinition f5014c;
    private static final Object f5015d = new Object();
    private final CommentStylingPartDefinition f5016b;

    /* compiled from: ridge_mic_permission_canceled */
    final class C04931 extends ViewType {
        C04931() {
        }

        public final View m5494a(Context context) {
            return new CommentShareView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    private static CommentShareAttachmentPartDefinition m5496b(InjectorLike injectorLike) {
        return new CommentShareAttachmentPartDefinition(CommentStylingPartDefinition.m5508a(injectorLike));
    }

    public final Object m5498a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f5016b, new Props(CommentLevel.THREADED.equals(CommentLevel.getCommentLevelFromAttachment((FeedProps) obj)) ? CommentRowPadding.THREADED_PROFILE_PICTURE_OFFSET : CommentRowPadding.PROFILE_PICTURE_OFFSET));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m5499a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2110889637);
        CommentShareView commentShareView = (CommentShareView) view;
        commentShareView.f5196b.m998a(commentShareView.f5197c, (GraphQLStoryAttachment) ((FeedProps) obj).a);
        Logger.a(8, EntryType.MARK_POP, -51820883, a);
    }

    public final boolean m5500a(Object obj) {
        return ((GraphQLStoryAttachment) ((FeedProps) obj).a).C() != null;
    }

    @Inject
    public CommentShareAttachmentPartDefinition(CommentStylingPartDefinition commentStylingPartDefinition) {
        this.f5016b = commentStylingPartDefinition;
    }

    public final ViewType<CommentShareView> m5497a() {
        return f5013a;
    }

    public static CommentShareAttachmentPartDefinition m5495a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5015d) {
                CommentShareAttachmentPartDefinition commentShareAttachmentPartDefinition;
                if (a2 != null) {
                    commentShareAttachmentPartDefinition = (CommentShareAttachmentPartDefinition) a2.a(f5015d);
                } else {
                    commentShareAttachmentPartDefinition = f5014c;
                }
                if (commentShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5496b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5015d, b3);
                        } else {
                            f5014c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
