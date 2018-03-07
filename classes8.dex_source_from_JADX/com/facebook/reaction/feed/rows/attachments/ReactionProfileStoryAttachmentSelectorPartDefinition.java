package com.facebook.reaction.feed.rows.attachments;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import javax.inject.Inject;

@ContextScoped
/* compiled from: applicationId cannot be null */
public class ReactionProfileStoryAttachmentSelectorPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionInteractionTracker> extends BaseMultiRowGroupPartDefinition<ReactionAttachmentNode, Void, E> {
    private static ReactionProfileStoryAttachmentSelectorPartDefinition f19359c;
    private static final Object f19360d = new Object();
    private final ReactionProfileStoryAttachmentPartDefinition f19361a;
    private final ReactionProfileStoryWithIconAttachmentPartDefinition f19362b;

    private static ReactionProfileStoryAttachmentSelectorPartDefinition m23364b(InjectorLike injectorLike) {
        return new ReactionProfileStoryAttachmentSelectorPartDefinition(ReactionProfileStoryAttachmentPartDefinition.m23358a(injectorLike), ReactionProfileStoryWithIconAttachmentPartDefinition.m23372a(injectorLike));
    }

    public final Object m23365a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionAttachmentNode reactionAttachmentNode = (ReactionAttachmentNode) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f19362b, reactionAttachmentNode).a(this.f19361a, reactionAttachmentNode);
        return null;
    }

    @Inject
    public ReactionProfileStoryAttachmentSelectorPartDefinition(ReactionProfileStoryAttachmentPartDefinition reactionProfileStoryAttachmentPartDefinition, ReactionProfileStoryWithIconAttachmentPartDefinition reactionProfileStoryWithIconAttachmentPartDefinition) {
        this.f19361a = reactionProfileStoryAttachmentPartDefinition;
        this.f19362b = reactionProfileStoryWithIconAttachmentPartDefinition;
    }

    public final boolean m23366a(Object obj) {
        return true;
    }

    public static ReactionProfileStoryAttachmentSelectorPartDefinition m23363a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionProfileStoryAttachmentSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19360d) {
                ReactionProfileStoryAttachmentSelectorPartDefinition reactionProfileStoryAttachmentSelectorPartDefinition;
                if (a2 != null) {
                    reactionProfileStoryAttachmentSelectorPartDefinition = (ReactionProfileStoryAttachmentSelectorPartDefinition) a2.a(f19360d);
                } else {
                    reactionProfileStoryAttachmentSelectorPartDefinition = f19359c;
                }
                if (reactionProfileStoryAttachmentSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23364b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19360d, b3);
                        } else {
                            f19359c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionProfileStoryAttachmentSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
