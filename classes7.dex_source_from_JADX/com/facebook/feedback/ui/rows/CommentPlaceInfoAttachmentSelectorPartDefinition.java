package com.facebook.feedback.ui.rows;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.CommentPlaceInfoAttachmentHScrollPartDefinition.Props;
import com.facebook.feedback.ui.rows.views.CommentRowPadding;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPlaceListItem;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_opt_in */
public class CommentPlaceInfoAttachmentSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, CommentsEnvironment> {
    private static final String f4990a = CommentPlaceInfoAttachmentSelectorPartDefinition.class.getSimpleName();
    private static CommentPlaceInfoAttachmentSelectorPartDefinition f4991f;
    private static final Object f4992g = new Object();
    private final CommentPlaceInfoAttachmentHScrollPartDefinition f4993b;
    private final CommentPlaceInfoAttachmentPartDefinition f4994c;
    private final CommentAddPlaceInfoAttachmentPartDefinition f4995d;
    private final AbstractFbErrorReporter f4996e;

    private static CommentPlaceInfoAttachmentSelectorPartDefinition m5474b(InjectorLike injectorLike) {
        return new CommentPlaceInfoAttachmentSelectorPartDefinition(CommentPlaceInfoAttachmentHScrollPartDefinition.m5460a(injectorLike), CommentPlaceInfoAttachmentPartDefinition.m5466a(injectorLike), CommentAddPlaceInfoAttachmentPartDefinition.m5406a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public final Object m5475a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLComment h = AttachmentProps.h(feedProps);
        if (h == null || h.y() == null) {
            this.f4996e.b(f4990a, "CommentPlaceInfoAttachment does not reference a valid comment");
        } else {
            ImmutableList a;
            boolean z;
            GraphQLNode z2 = ((GraphQLStoryAttachment) feedProps.a).z();
            if (z2.fu() != null) {
                a = z2.fu().a();
            } else {
                a = RegularImmutableList.a;
            }
            ImmutableList kJ = z2.kJ();
            CommentRowPadding commentRowPadding = CommentLevel.THREADED.equals(CommentLevel.getCommentLevelFromAttachment(feedProps)) ? CommentRowPadding.THREADED_PROFILE_PICTURE_OFFSET : CommentRowPadding.PROFILE_PICTURE_OFFSET;
            if (a.size() + kJ.size() > 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                baseMultiRowSubParts.a(this.f4993b, new Props(feedProps, commentRowPadding));
            } else if (a.size() == 1) {
                baseMultiRowSubParts.a(this.f4994c, new CommentPlaceInfoAttachmentPartDefinition.Props(feedProps, ((GraphQLPlaceListItem) a.get(0)).k(), 0, true, commentRowPadding));
            } else if (kJ.size() == 1) {
                baseMultiRowSubParts.a(this.f4994c, new CommentPlaceInfoAttachmentPartDefinition.Props(feedProps, (GraphQLPage) kJ.get(0), 0, false, commentRowPadding));
            } else {
                baseMultiRowSubParts.a(this.f4995d, new CommentAddPlaceInfoAttachmentPartDefinition.Props(h.y(), commentRowPadding));
            }
        }
        return null;
    }

    @Inject
    public CommentPlaceInfoAttachmentSelectorPartDefinition(CommentPlaceInfoAttachmentHScrollPartDefinition commentPlaceInfoAttachmentHScrollPartDefinition, CommentPlaceInfoAttachmentPartDefinition commentPlaceInfoAttachmentPartDefinition, CommentAddPlaceInfoAttachmentPartDefinition commentAddPlaceInfoAttachmentPartDefinition, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f4993b = commentPlaceInfoAttachmentHScrollPartDefinition;
        this.f4994c = commentPlaceInfoAttachmentPartDefinition;
        this.f4995d = commentAddPlaceInfoAttachmentPartDefinition;
        this.f4996e = abstractFbErrorReporter;
    }

    public static CommentPlaceInfoAttachmentSelectorPartDefinition m5473a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentPlaceInfoAttachmentSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4992g) {
                CommentPlaceInfoAttachmentSelectorPartDefinition commentPlaceInfoAttachmentSelectorPartDefinition;
                if (a2 != null) {
                    commentPlaceInfoAttachmentSelectorPartDefinition = (CommentPlaceInfoAttachmentSelectorPartDefinition) a2.a(f4992g);
                } else {
                    commentPlaceInfoAttachmentSelectorPartDefinition = f4991f;
                }
                if (commentPlaceInfoAttachmentSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5474b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4992g, b3);
                        } else {
                            f4991f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentPlaceInfoAttachmentSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m5476a(Object obj) {
        return true;
    }
}
