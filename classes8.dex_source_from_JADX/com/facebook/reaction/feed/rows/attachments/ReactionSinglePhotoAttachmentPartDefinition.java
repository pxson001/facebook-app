package com.facebook.reaction.feed.rows.attachments;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
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
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.feed.environment.HasReactionCardContainer;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.rows.attachments.ReactionAttachmentActionPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStoryAttachmentFragment;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: app_invite_id */
public class ReactionSinglePhotoAttachmentPartDefinition<E extends HasContext & HasReactionCardContainer & HasReactionInteractionTracker & HasPrefetcher & HasRowKey> extends MultiRowSinglePartDefinition<ReactionAttachmentNode, Void, E, FbDraweeView> {
    public static final ViewType f19381a = ViewType.a(2130906687);
    private static final CallerContext f19382b = CallerContext.a(ReactionSinglePhotoAttachmentPartDefinition.class, "reaction_photos");
    private static ReactionSinglePhotoAttachmentPartDefinition f19383f;
    private static final Object f19384g = new Object();
    private final ReactionAttachmentActionPartDefinition f19385c;
    private final FbDraweePartDefinition<E> f19386d;
    private final ReactionIntentFactory f19387e;

    private static ReactionSinglePhotoAttachmentPartDefinition m23384b(InjectorLike injectorLike) {
        return new ReactionSinglePhotoAttachmentPartDefinition(ReactionAttachmentActionPartDefinition.m23324a(injectorLike), FbDraweePartDefinition.a(injectorLike), ReactionIntentFactory.m22683a(injectorLike));
    }

    public final Object m23386a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionAttachmentNode reactionAttachmentNode = (ReactionAttachmentNode) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        FbDraweePartDefinition fbDraweePartDefinition = this.f19386d;
        Builder a = FbDraweePartDefinition.a().a(reactionAttachmentNode.f18832a.E().be_().b());
        a.b = 2.3333333f;
        a = a;
        a.c = f19382b;
        subParts.a(fbDraweePartDefinition, a.a());
        subParts.a(this.f19385c, new Props(m23382a(hasContext, reactionAttachmentNode.f18832a), reactionAttachmentNode.f18833b, reactionAttachmentNode.f18834c));
        return null;
    }

    public final boolean m23387a(Object obj) {
        SizeAwareMedia E = ((ReactionAttachmentNode) obj).f18832a.E();
        return (E == null || Strings.isNullOrEmpty(E.d()) || E.be_() == null || Strings.isNullOrEmpty(E.be_().b())) ? false : true;
    }

    @Inject
    public ReactionSinglePhotoAttachmentPartDefinition(ReactionAttachmentActionPartDefinition reactionAttachmentActionPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, ReactionIntentFactory reactionIntentFactory) {
        this.f19385c = reactionAttachmentActionPartDefinition;
        this.f19386d = fbDraweePartDefinition;
        this.f19387e = reactionIntentFactory;
    }

    public static ReactionSinglePhotoAttachmentPartDefinition m23383a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionSinglePhotoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19384g) {
                ReactionSinglePhotoAttachmentPartDefinition reactionSinglePhotoAttachmentPartDefinition;
                if (a2 != null) {
                    reactionSinglePhotoAttachmentPartDefinition = (ReactionSinglePhotoAttachmentPartDefinition) a2.a(f19384g);
                } else {
                    reactionSinglePhotoAttachmentPartDefinition = f19383f;
                }
                if (reactionSinglePhotoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23384b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19384g, b3);
                        } else {
                            f19383f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionSinglePhotoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23385a() {
        return f19381a;
    }

    @Nullable
    private ReactionAttachmentIntent m23382a(E e, ReactionStoryAttachmentFragment reactionStoryAttachmentFragment) {
        ReactionAttachmentIntent reactionAttachmentIntent = null;
        SizeAwareMedia E = reactionStoryAttachmentFragment.E();
        try {
            reactionAttachmentIntent = ReactionIntentFactory.m22684a(e.getContext(), Long.parseLong(E.d()), null, E.be_().b());
        } catch (NumberFormatException e2) {
        }
        return reactionAttachmentIntent;
    }
}
