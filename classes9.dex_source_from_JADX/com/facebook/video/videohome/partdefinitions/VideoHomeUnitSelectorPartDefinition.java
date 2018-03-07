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
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: silent_call */
public class VideoHomeUnitSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitFragment, Void, AnyEnvironment> {
    private static VideoHomeUnitSelectorPartDefinition f3202c;
    private static final Object f3203d = new Object();
    private final VideoHomeUnitWithHeaderPartDefinition f3204a;
    private final VideoHomeUnitNoHeaderPartDefinition f3205b;

    private static VideoHomeUnitSelectorPartDefinition m3052b(InjectorLike injectorLike) {
        return new VideoHomeUnitSelectorPartDefinition(VideoHomeUnitWithHeaderPartDefinition.m3055a(injectorLike), VideoHomeUnitNoHeaderPartDefinition.m3043a(injectorLike));
    }

    public final Object m3053a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitFragment reactionUnitFragment = (ReactionUnitFragment) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f3204a, reactionUnitFragment).a(this.f3205b, reactionUnitFragment);
        return null;
    }

    public final boolean m3054a(Object obj) {
        return !((ReactionUnitFragment) obj).s().isEmpty();
    }

    @Inject
    public VideoHomeUnitSelectorPartDefinition(VideoHomeUnitWithHeaderPartDefinition videoHomeUnitWithHeaderPartDefinition, VideoHomeUnitNoHeaderPartDefinition videoHomeUnitNoHeaderPartDefinition) {
        this.f3204a = videoHomeUnitWithHeaderPartDefinition;
        this.f3205b = videoHomeUnitNoHeaderPartDefinition;
    }

    public static VideoHomeUnitSelectorPartDefinition m3051a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeUnitSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3203d) {
                VideoHomeUnitSelectorPartDefinition videoHomeUnitSelectorPartDefinition;
                if (a2 != null) {
                    videoHomeUnitSelectorPartDefinition = (VideoHomeUnitSelectorPartDefinition) a2.a(f3203d);
                } else {
                    videoHomeUnitSelectorPartDefinition = f3202c;
                }
                if (videoHomeUnitSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3052b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3203d, b3);
                        } else {
                            f3202c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeUnitSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
