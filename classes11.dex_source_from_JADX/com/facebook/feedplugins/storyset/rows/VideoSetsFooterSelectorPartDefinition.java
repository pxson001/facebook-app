package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: audience_educator_composer_action */
public class VideoSetsFooterSelectorPartDefinition<E extends CanShowVideoInFullScreen & HasPersistentState & HasPositionInformation, V extends View> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, V> {
    private static VideoSetsFooterSelectorPartDefinition f9811b;
    private static final Object f9812c = new Object();
    private final StorySetPageReactionsFooterPartDefinition f9813a;

    private static VideoSetsFooterSelectorPartDefinition m10229b(InjectorLike injectorLike) {
        return new VideoSetsFooterSelectorPartDefinition(StorySetPageReactionsFooterPartDefinition.m10182a(injectorLike));
    }

    public final Object m10230a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f9813a, (FeedProps) obj);
        return null;
    }

    @Inject
    public VideoSetsFooterSelectorPartDefinition(StorySetPageReactionsFooterPartDefinition storySetPageReactionsFooterPartDefinition) {
        this.f9813a = storySetPageReactionsFooterPartDefinition;
    }

    public static VideoSetsFooterSelectorPartDefinition m10228a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoSetsFooterSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9812c) {
                VideoSetsFooterSelectorPartDefinition videoSetsFooterSelectorPartDefinition;
                if (a2 != null) {
                    videoSetsFooterSelectorPartDefinition = (VideoSetsFooterSelectorPartDefinition) a2.a(f9812c);
                } else {
                    videoSetsFooterSelectorPartDefinition = f9811b;
                }
                if (videoSetsFooterSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10229b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9812c, b3);
                        } else {
                            f9811b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoSetsFooterSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
