package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasScrollListenerSupport;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
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
/* compiled from: [a-zA-Z]+ */
public class AnimatedImageShareAttachmentSelectorPartDefinition<E extends HasInvalidate & HasPositionInformation & HasFeedListType & HasPersistentState & HasPrefetcher & HasScrollListenerSupport> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E> {
    private static AnimatedImageShareAttachmentSelectorPartDefinition f20516c;
    private static final Object f20517d = new Object();
    private final Lazy<ImageShareAttachmentPartDefinition<E>> f20518a;
    private final Lazy<TranscodedAnimatedImageShareAttachmentPartDefinition<E>> f20519b;

    private static AnimatedImageShareAttachmentSelectorPartDefinition m23582b(InjectorLike injectorLike) {
        return new AnimatedImageShareAttachmentSelectorPartDefinition(IdBasedLazy.a(injectorLike, 5980), IdBasedLazy.a(injectorLike, 5999));
    }

    public final Object m23583a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f20519b, feedProps).a(this.f20518a, feedProps);
        return null;
    }

    public final boolean m23584a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (!((TranscodedAnimatedImageShareAttachmentPartDefinition) this.f20519b.get()).m23801a(feedProps)) {
            this.f20518a.get();
            if (!ImageShareAttachmentPartDefinition.m23639a(feedProps)) {
                return false;
            }
        }
        return true;
    }

    @Inject
    public AnimatedImageShareAttachmentSelectorPartDefinition(Lazy<ImageShareAttachmentPartDefinition> lazy, Lazy<TranscodedAnimatedImageShareAttachmentPartDefinition> lazy2) {
        this.f20518a = lazy;
        this.f20519b = lazy2;
    }

    public static AnimatedImageShareAttachmentSelectorPartDefinition m23581a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AnimatedImageShareAttachmentSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20517d) {
                AnimatedImageShareAttachmentSelectorPartDefinition animatedImageShareAttachmentSelectorPartDefinition;
                if (a2 != null) {
                    animatedImageShareAttachmentSelectorPartDefinition = (AnimatedImageShareAttachmentSelectorPartDefinition) a2.a(f20517d);
                } else {
                    animatedImageShareAttachmentSelectorPartDefinition = f20516c;
                }
                if (animatedImageShareAttachmentSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23582b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20517d, b3);
                        } else {
                            f20516c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = animatedImageShareAttachmentSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
