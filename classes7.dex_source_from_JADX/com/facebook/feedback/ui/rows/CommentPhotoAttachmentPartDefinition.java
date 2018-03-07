package com.facebook.feedback.ui.rows;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.CommentStylingPartDefinition.Props;
import com.facebook.feedback.ui.rows.views.CommentPhotoView;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
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
/* compiled from: ridge_opt_in_learn_more_tapped */
public class CommentPhotoAttachmentPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, CommentsEnvironment, CommentPhotoView> {
    public static final ViewType f4942a = new C04841();
    private static CommentPhotoAttachmentPartDefinition f4943d;
    private static final Object f4944e = new Object();
    private final CommentStylingPartDefinition f4945b;
    public final AutomaticPhotoCaptioningUtils f4946c;

    /* compiled from: ridge_opt_in_learn_more_tapped */
    final class C04841 extends ViewType {
        C04841() {
        }

        public final View m5450a(Context context) {
            return new CommentPhotoView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    private static CommentPhotoAttachmentPartDefinition m5452b(InjectorLike injectorLike) {
        return new CommentPhotoAttachmentPartDefinition(CommentStylingPartDefinition.m5508a(injectorLike), AutomaticPhotoCaptioningUtils.b(injectorLike));
    }

    public final Object m5454a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f4945b, new Props(CommentLevel.THREADED.equals(CommentLevel.getCommentLevelFromAttachment((FeedProps) obj)) ? CommentRowPadding.THREADED_PROFILE_PICTURE_OFFSET : CommentRowPadding.PROFILE_PICTURE_OFFSET));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m5455a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 126939840);
        FeedProps feedProps = (FeedProps) obj;
        CommentPhotoView commentPhotoView = (CommentPhotoView) view;
        CharSequence k = this.f4946c.a() ? ((GraphQLStoryAttachment) feedProps.a).r().k() : null;
        FbDraweeView fbDraweeView = commentPhotoView.f978i;
        if (k == null) {
            k = commentPhotoView.getContext().getString(2131230814);
        }
        fbDraweeView.setContentDescription(k);
        commentPhotoView.m951a(feedProps);
        Logger.a(8, EntryType.MARK_POP, -1702554635, a);
    }

    public final boolean m5456a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        return (graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().S() == null) ? false : true;
    }

    public final void m5457b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        CommentPhotoView commentPhotoView = (CommentPhotoView) view;
        commentPhotoView.setOnClickListener(null);
        commentPhotoView.f978i.setOnClickListener(null);
    }

    @Inject
    public CommentPhotoAttachmentPartDefinition(CommentStylingPartDefinition commentStylingPartDefinition, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        this.f4945b = commentStylingPartDefinition;
        this.f4946c = automaticPhotoCaptioningUtils;
    }

    public final ViewType<CommentPhotoView> m5453a() {
        return f4942a;
    }

    public static CommentPhotoAttachmentPartDefinition m5451a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentPhotoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4944e) {
                CommentPhotoAttachmentPartDefinition commentPhotoAttachmentPartDefinition;
                if (a2 != null) {
                    commentPhotoAttachmentPartDefinition = (CommentPhotoAttachmentPartDefinition) a2.a(f4944e);
                } else {
                    commentPhotoAttachmentPartDefinition = f4943d;
                }
                if (commentPhotoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5452b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4944e, b3);
                        } else {
                            f4943d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentPhotoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
