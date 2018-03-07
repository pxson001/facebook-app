package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import javax.inject.Inject;

@ContextScoped
/* compiled from: small_preview_size */
public class VideoHomeItemSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment> {
    private static VideoHomeItemSelectorPartDefinition f3078d;
    private static final Object f3079e = new Object();
    private final VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition f3080a;
    private final VideoHomeSectionHeaderPartDefinition f3081b;
    private final VideoHomeVideoChannelFeedUnitGroupPartDefinition f3082c;

    private static VideoHomeItemSelectorPartDefinition m2953b(InjectorLike injectorLike) {
        return new VideoHomeItemSelectorPartDefinition(VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition.m2971a(injectorLike), VideoHomeSectionHeaderPartDefinition.m2998a(injectorLike), VideoHomeVideoChannelFeedUnitGroupPartDefinition.m3069a(injectorLike));
    }

    public final Object m2954a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f3080a, reactionUnitComponentNode).a(this.f3081b, reactionUnitComponentNode).a(this.f3082c, reactionUnitComponentNode);
        return null;
    }

    public final boolean m2955a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return this.f3080a.m2982a(reactionUnitComponentNode) || VideoHomeSectionHeaderPartDefinition.m2999a(reactionUnitComponentNode) || this.f3082c.m3072a(reactionUnitComponentNode);
    }

    @Inject
    public VideoHomeItemSelectorPartDefinition(VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition videoHomePaginatedHscrollLiveVideoComponentListPartDefinition, VideoHomeSectionHeaderPartDefinition videoHomeSectionHeaderPartDefinition, VideoHomeVideoChannelFeedUnitGroupPartDefinition videoHomeVideoChannelFeedUnitGroupPartDefinition) {
        this.f3080a = videoHomePaginatedHscrollLiveVideoComponentListPartDefinition;
        this.f3081b = videoHomeSectionHeaderPartDefinition;
        this.f3082c = videoHomeVideoChannelFeedUnitGroupPartDefinition;
    }

    public static VideoHomeItemSelectorPartDefinition m2952a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeItemSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3079e) {
                VideoHomeItemSelectorPartDefinition videoHomeItemSelectorPartDefinition;
                if (a2 != null) {
                    videoHomeItemSelectorPartDefinition = (VideoHomeItemSelectorPartDefinition) a2.a(f3079e);
                } else {
                    videoHomeItemSelectorPartDefinition = f3078d;
                }
                if (videoHomeItemSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2953b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3079e, b3);
                        } else {
                            f3078d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeItemSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
