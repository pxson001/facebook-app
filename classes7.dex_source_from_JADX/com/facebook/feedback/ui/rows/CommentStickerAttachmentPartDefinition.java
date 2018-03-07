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
import com.facebook.feedback.ui.rows.views.CommentStickerView;
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
/* compiled from: ridge_match_found */
public class CommentStickerAttachmentPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, CommentsEnvironment, CommentStickerView> {
    public static final ViewType f5017a = new C04941();
    private static CommentStickerAttachmentPartDefinition f5018c;
    private static final Object f5019d = new Object();
    private final CommentStylingPartDefinition f5020b;

    /* compiled from: ridge_match_found */
    final class C04941 extends ViewType {
        C04941() {
        }

        public final View m5501a(Context context) {
            return new CommentStickerView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    private static CommentStickerAttachmentPartDefinition m5503b(InjectorLike injectorLike) {
        return new CommentStickerAttachmentPartDefinition(CommentStylingPartDefinition.m5508a(injectorLike));
    }

    public final Object m5505a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f5020b, new Props(CommentLevel.THREADED.equals(CommentLevel.getCommentLevelFromAttachment((FeedProps) obj)) ? CommentRowPadding.THREADED_PROFILE_PICTURE_OFFSET : CommentRowPadding.PROFILE_PICTURE_OFFSET));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m5506a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1849431376);
        ((CommentStickerView) view).m979a((FeedProps) obj);
        Logger.a(8, EntryType.MARK_POP, -1306244792, a);
    }

    @Inject
    public CommentStickerAttachmentPartDefinition(CommentStylingPartDefinition commentStylingPartDefinition) {
        this.f5020b = commentStylingPartDefinition;
    }

    public final boolean m5507a(Object obj) {
        return true;
    }

    public final ViewType<CommentStickerView> m5504a() {
        return f5017a;
    }

    public static CommentStickerAttachmentPartDefinition m5502a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentStickerAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5019d) {
                CommentStickerAttachmentPartDefinition commentStickerAttachmentPartDefinition;
                if (a2 != null) {
                    commentStickerAttachmentPartDefinition = (CommentStickerAttachmentPartDefinition) a2.a(f5019d);
                } else {
                    commentStickerAttachmentPartDefinition = f5018c;
                }
                if (commentStickerAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5503b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5019d, b3);
                        } else {
                            f5018c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentStickerAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
