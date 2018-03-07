package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLReactionUnitStyle;
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
/* compiled from: sinceActionId */
public class VideoHomeUnitPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitFragment, Void, AnyEnvironment> {
    private static VideoHomeUnitPartDefinition f3199b;
    private static final Object f3200c = new Object();
    private final VideoHomeUnitSelectorPartDefinition f3201a;

    private static VideoHomeUnitPartDefinition m3048b(InjectorLike injectorLike) {
        return new VideoHomeUnitPartDefinition(VideoHomeUnitSelectorPartDefinition.m3051a(injectorLike));
    }

    public final Object m3049a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f3201a, (ReactionUnitFragment) obj);
        return null;
    }

    public final boolean m3050a(Object obj) {
        return ((ReactionUnitFragment) obj).m() == GraphQLReactionUnitStyle.VERTICAL_COMPONENTS;
    }

    @Inject
    public VideoHomeUnitPartDefinition(VideoHomeUnitSelectorPartDefinition videoHomeUnitSelectorPartDefinition) {
        this.f3201a = videoHomeUnitSelectorPartDefinition;
    }

    public static VideoHomeUnitPartDefinition m3047a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeUnitPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3200c) {
                VideoHomeUnitPartDefinition videoHomeUnitPartDefinition;
                if (a2 != null) {
                    videoHomeUnitPartDefinition = (VideoHomeUnitPartDefinition) a2.a(f3200c);
                } else {
                    videoHomeUnitPartDefinition = f3199b;
                }
                if (videoHomeUnitPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3048b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3200c, b3);
                        } else {
                            f3199b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeUnitPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
