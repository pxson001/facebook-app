package com.facebook.reaction.feed.rows.attachments;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
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
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel.ActorsModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: app_provided_hashtag */
public class ReactionProfileStoryWithIconAttachmentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionInteractionTracker> extends MultiRowSinglePartDefinition<ReactionAttachmentNode, Void, E, ImageBlockLayout> {
    public static final ViewType<ImageBlockLayout> f19371a = ViewType.a(2130906685);
    private static final CallerContext f19372b = CallerContext.a(ReactionProfileStoryWithIconAttachmentPartDefinition.class, "reaction_dialog", "attachment_icon");
    private static ReactionProfileStoryWithIconAttachmentPartDefinition f19373e;
    private static final Object f19374f = new Object();
    private final FbDraweePartDefinition f19375c;
    private final ReactionProfileStoryImageBlockPartDefinition f19376d;

    private static ReactionProfileStoryWithIconAttachmentPartDefinition m23373b(InjectorLike injectorLike) {
        return new ReactionProfileStoryWithIconAttachmentPartDefinition(FbDraweePartDefinition.a(injectorLike), ReactionProfileStoryImageBlockPartDefinition.m23368a(injectorLike));
    }

    public final Object m23375a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionAttachmentNode reactionAttachmentNode = (ReactionAttachmentNode) obj;
        Uri parse = Uri.parse(reactionAttachmentNode.f18832a.Y().b());
        FbDraweePartDefinition fbDraweePartDefinition = this.f19375c;
        Builder a = FbDraweePartDefinition.a().a(parse);
        a.c = f19372b;
        subParts.a(2131566620, fbDraweePartDefinition, a.a());
        subParts.a(this.f19376d, reactionAttachmentNode);
        return null;
    }

    public final boolean m23376a(Object obj) {
        ReactionAttachmentNode reactionAttachmentNode = (ReactionAttachmentNode) obj;
        ReactionStoryAttachmentStoryFragmentModel W = reactionAttachmentNode.f18832a.W();
        return (W == null || Strings.isNullOrEmpty(W.g()) || !CollectionUtil.b(W.b()) || Strings.isNullOrEmpty(((ActorsModel) W.b().get(0)).b()) || reactionAttachmentNode.f18832a.Y() == null || Strings.isNullOrEmpty(reactionAttachmentNode.f18832a.Y().b())) ? false : true;
    }

    @Inject
    public ReactionProfileStoryWithIconAttachmentPartDefinition(FbDraweePartDefinition fbDraweePartDefinition, ReactionProfileStoryImageBlockPartDefinition reactionProfileStoryImageBlockPartDefinition) {
        this.f19375c = fbDraweePartDefinition;
        this.f19376d = reactionProfileStoryImageBlockPartDefinition;
    }

    public static ReactionProfileStoryWithIconAttachmentPartDefinition m23372a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionProfileStoryWithIconAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19374f) {
                ReactionProfileStoryWithIconAttachmentPartDefinition reactionProfileStoryWithIconAttachmentPartDefinition;
                if (a2 != null) {
                    reactionProfileStoryWithIconAttachmentPartDefinition = (ReactionProfileStoryWithIconAttachmentPartDefinition) a2.a(f19374f);
                } else {
                    reactionProfileStoryWithIconAttachmentPartDefinition = f19373e;
                }
                if (reactionProfileStoryWithIconAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23373b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19374f, b3);
                        } else {
                            f19373e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionProfileStoryWithIconAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ImageBlockLayout> m23374a() {
        return f19371a;
    }
}
