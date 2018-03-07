package com.facebook.feedback.ui.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.feedback.ui.rows.views.FeedbackAttachmentStyleMap;
import com.facebook.feedback.ui.rows.views.FeedbackAttachmentStyleMap.C05161;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.PartWithIsNeeded;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ridge_post_optout_tooltip_seen */
public class CommentAttachmentsPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLComment>, Void, CommentsEnvironment> {
    private static CommentAttachmentsPartDefinition f4881c;
    private static final Object f4882d = new Object();
    private final QeAccessor f4883a;
    private FeedbackAttachmentStyleMap f4884b;

    private static CommentAttachmentsPartDefinition m5412b(InjectorLike injectorLike) {
        return new CommentAttachmentsPartDefinition((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), new FeedbackAttachmentStyleMap(IdBasedLazy.a(injectorLike, 6141), IdBasedLazy.a(injectorLike, 6152), IdBasedLazy.a(injectorLike, 6148), IdBasedLazy.a(injectorLike, 6149), IdBasedLazy.a(injectorLike, 6144)));
    }

    public final Object m5413a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLComment graphQLComment = (GraphQLComment) feedProps.a;
        if (GraphQLCommentHelper.b(graphQLComment)) {
            GraphQLStoryAttachment c = GraphQLCommentHelper.c(graphQLComment);
            ImmutableList w = c.w();
            int size = w.size();
            int i = 0;
            while (i < size) {
                PartWithIsNeeded partWithIsNeeded;
                GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle = (GraphQLStoryAttachmentStyle) w.get(i);
                FeedbackAttachmentStyleMap feedbackAttachmentStyleMap = this.f4884b;
                switch (C05161.f5212a[graphQLStoryAttachmentStyle.ordinal()]) {
                    case 1:
                        partWithIsNeeded = (PartWithIsNeeded) feedbackAttachmentStyleMap.f5213a.get();
                        break;
                    case 2:
                        partWithIsNeeded = (PartWithIsNeeded) feedbackAttachmentStyleMap.f5214b.get();
                        break;
                    case 3:
                        partWithIsNeeded = (PartWithIsNeeded) feedbackAttachmentStyleMap.f5215c.get();
                        break;
                    case 4:
                        partWithIsNeeded = (PartWithIsNeeded) feedbackAttachmentStyleMap.f5216d.get();
                        break;
                    case 5:
                        partWithIsNeeded = (PartWithIsNeeded) feedbackAttachmentStyleMap.f5217e.get();
                        break;
                    default:
                        partWithIsNeeded = null;
                        break;
                }
                MultiRowPartWithIsNeeded multiRowPartWithIsNeeded = (MultiRowPartWithIsNeeded) partWithIsNeeded;
                if (multiRowPartWithIsNeeded != null) {
                    baseMultiRowSubParts.a(multiRowPartWithIsNeeded, feedProps.a(c));
                } else {
                    i++;
                }
            }
        }
        return null;
    }

    public final boolean m5414a(Object obj) {
        return this.f4883a.a(ExperimentsForFeedbackTestModule.A, false) && GraphQLCommentHelper.b((GraphQLComment) ((FeedProps) obj).a);
    }

    @Inject
    public CommentAttachmentsPartDefinition(QeAccessor qeAccessor, FeedbackAttachmentStyleMap feedbackAttachmentStyleMap) {
        this.f4883a = qeAccessor;
        this.f4884b = feedbackAttachmentStyleMap;
    }

    public static CommentAttachmentsPartDefinition m5411a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentAttachmentsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4882d) {
                CommentAttachmentsPartDefinition commentAttachmentsPartDefinition;
                if (a2 != null) {
                    commentAttachmentsPartDefinition = (CommentAttachmentsPartDefinition) a2.a(f4882d);
                } else {
                    commentAttachmentsPartDefinition = f4881c;
                }
                if (commentAttachmentsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5412b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4882d, b3);
                        } else {
                            f4881c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commentAttachmentsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
