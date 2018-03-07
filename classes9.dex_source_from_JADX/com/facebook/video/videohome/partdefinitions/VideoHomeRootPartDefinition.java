package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import com.facebook.api.feed.data.EndOfFeedSentinel.EndOfFeedSentinelFeedUnit;
import com.facebook.api.feed.data.LoadingMoreSentinel.LoadingMoreSentinelFeedUnit;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.RootPartSelector;
import com.facebook.feed.rows.sections.common.EmptyPartDefinition;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitMultiRowGroupPartDefinition;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.video.videohome.data.VideoHomeComposerItem;
import com.facebook.video.videohome.environment.VideoHomeEnvironment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: sizes */
public class VideoHomeRootPartDefinition extends BaseMultiRowGroupPartDefinition<Object, Void, VideoHomeEnvironment> {
    private static VideoHomeRootPartDefinition f3139b;
    private static final Object f3140c = new Object();
    private final RootPartSelector<VideoHomeEnvironment> f3141a;

    private static VideoHomeRootPartDefinition m2992b(InjectorLike injectorLike) {
        return new VideoHomeRootPartDefinition(IdBasedLazy.a(injectorLike, 11689), IdBasedLazy.a(injectorLike, 6023), IdBasedLazy.a(injectorLike, 11667), IdBasedLazy.a(injectorLike, 11684), IdBasedLazy.a(injectorLike, 6019), IdBasedLazy.a(injectorLike, 11673));
    }

    @Inject
    public VideoHomeRootPartDefinition(Lazy<VideoHomeUnitPartDefinition> lazy, Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> lazy2, Lazy<VideoHomeComposerPartDefinition> lazy3, Lazy<VideoHomeSpinnerPartDefinition> lazy4, Lazy<EmptyPartDefinition> lazy5, Lazy<VideoHomeItemSelectorPartDefinition> lazy6) {
        this.f3141a = RootPartSelector.a().a(VideoHomeComposerItem.class, lazy3).a(ReactionUnitFragment.class, lazy).a(ReactionUnitComponentNode.class, lazy6).a(LoadingMoreSentinelFeedUnit.class, lazy4).a(EndOfFeedSentinelFeedUnit.class, lazy5).a(Object.class, lazy2);
    }

    public final boolean m2994a(Object obj) {
        return true;
    }

    public final Object m2993a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        this.f3141a.a(baseMultiRowSubParts, obj);
        return null;
    }

    public static VideoHomeRootPartDefinition m2991a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3140c) {
                VideoHomeRootPartDefinition videoHomeRootPartDefinition;
                if (a2 != null) {
                    videoHomeRootPartDefinition = (VideoHomeRootPartDefinition) a2.a(f3140c);
                } else {
                    videoHomeRootPartDefinition = f3139b;
                }
                if (videoHomeRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2992b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3140c, b3);
                        } else {
                            f3139b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
