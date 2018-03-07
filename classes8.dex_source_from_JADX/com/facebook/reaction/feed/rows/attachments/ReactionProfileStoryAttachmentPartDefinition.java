package com.facebook.reaction.feed.rows.attachments;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel.ActorsModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: applied_filters */
public class ReactionProfileStoryAttachmentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionInteractionTracker> extends MultiRowSinglePartDefinition<ReactionAttachmentNode, Void, E, ImageBlockLayout> {
    public static final ViewType<ImageBlockLayout> f19355a = ViewType.a(2130906684);
    private static ReactionProfileStoryAttachmentPartDefinition f19356c;
    private static final Object f19357d = new Object();
    private final ReactionProfileStoryImageBlockPartDefinition f19358b;

    private static ReactionProfileStoryAttachmentPartDefinition m23359b(InjectorLike injectorLike) {
        return new ReactionProfileStoryAttachmentPartDefinition(ReactionProfileStoryImageBlockPartDefinition.m23368a(injectorLike));
    }

    public final Object m23361a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f19358b, (ReactionAttachmentNode) obj);
        return null;
    }

    public final boolean m23362a(Object obj) {
        ReactionStoryAttachmentStoryFragmentModel W = ((ReactionAttachmentNode) obj).f18832a.W();
        return (W == null || Strings.isNullOrEmpty(W.g()) || !CollectionUtil.b(W.b()) || Strings.isNullOrEmpty(((ActorsModel) W.b().get(0)).b()) || W.eN_() == null) ? false : true;
    }

    @Inject
    public ReactionProfileStoryAttachmentPartDefinition(ReactionProfileStoryImageBlockPartDefinition reactionProfileStoryImageBlockPartDefinition) {
        this.f19358b = reactionProfileStoryImageBlockPartDefinition;
    }

    public final ViewType<ImageBlockLayout> m23360a() {
        return f19355a;
    }

    public static ReactionProfileStoryAttachmentPartDefinition m23358a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionProfileStoryAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19357d) {
                ReactionProfileStoryAttachmentPartDefinition reactionProfileStoryAttachmentPartDefinition;
                if (a2 != null) {
                    reactionProfileStoryAttachmentPartDefinition = (ReactionProfileStoryAttachmentPartDefinition) a2.a(f19357d);
                } else {
                    reactionProfileStoryAttachmentPartDefinition = f19356c;
                }
                if (reactionProfileStoryAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23359b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19357d, b3);
                        } else {
                            f19356c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionProfileStoryAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
