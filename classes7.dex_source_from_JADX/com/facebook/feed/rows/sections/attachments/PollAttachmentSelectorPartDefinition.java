package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.poll.PollAttachmentListPartDefinition;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: You must bind this controller before setting its swipeable params list */
public class PollAttachmentSelectorPartDefinition<V extends View & AttachmentHasLabel & AttachmentHasClear> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static PollAttachmentSelectorPartDefinition f20738c;
    private static final Object f20739d = new Object();
    private final Lazy<QuestionAttachmentPartDefinition<FeedEnvironment, V>> f20740a;
    private final Lazy<PollAttachmentListPartDefinition<FeedEnvironment>> f20741b;

    private static PollAttachmentSelectorPartDefinition m23724b(InjectorLike injectorLike) {
        return new PollAttachmentSelectorPartDefinition(IdBasedLazy.a(injectorLike, 6184), IdBasedLazy.a(injectorLike, 5990));
    }

    public final Object m23725a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f20741b, feedProps).a(this.f20740a, feedProps);
        return null;
    }

    @Inject
    public PollAttachmentSelectorPartDefinition(Lazy<PollAttachmentListPartDefinition> lazy, Lazy<QuestionAttachmentPartDefinition> lazy2) {
        this.f20741b = lazy;
        this.f20740a = lazy2;
    }

    public final boolean m23726a(Object obj) {
        return true;
    }

    public static PollAttachmentSelectorPartDefinition m23723a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PollAttachmentSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20739d) {
                PollAttachmentSelectorPartDefinition pollAttachmentSelectorPartDefinition;
                if (a2 != null) {
                    pollAttachmentSelectorPartDefinition = (PollAttachmentSelectorPartDefinition) a2.a(f20739d);
                } else {
                    pollAttachmentSelectorPartDefinition = f20738c;
                }
                if (pollAttachmentSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23724b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20739d, b3);
                        } else {
                            f20738c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pollAttachmentSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
