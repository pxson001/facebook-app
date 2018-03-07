package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.video.videohome.partdefinitions.VideoHomeUnitBodyPartDefinition.Props;
import javax.inject.Inject;

@ContextScoped
/* compiled from: since_action_id */
public class VideoHomeUnitNoHeaderPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitFragment, Void, AnyEnvironment> {
    private static VideoHomeUnitNoHeaderPartDefinition f3196b;
    private static final Object f3197c = new Object();
    private final VideoHomeUnitBodyPartDefinition f3198a;

    private static VideoHomeUnitNoHeaderPartDefinition m3044b(InjectorLike injectorLike) {
        return new VideoHomeUnitNoHeaderPartDefinition(VideoHomeUnitBodyPartDefinition.m3039a(injectorLike));
    }

    public final Object m3045a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f3198a, new Props((ReactionUnitFragment) obj, 0));
        return null;
    }

    @Inject
    public VideoHomeUnitNoHeaderPartDefinition(VideoHomeUnitBodyPartDefinition videoHomeUnitBodyPartDefinition) {
        this.f3198a = videoHomeUnitBodyPartDefinition;
    }

    public final boolean m3046a(Object obj) {
        return true;
    }

    public static VideoHomeUnitNoHeaderPartDefinition m3043a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeUnitNoHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3197c) {
                VideoHomeUnitNoHeaderPartDefinition videoHomeUnitNoHeaderPartDefinition;
                if (a2 != null) {
                    videoHomeUnitNoHeaderPartDefinition = (VideoHomeUnitNoHeaderPartDefinition) a2.a(f3197c);
                } else {
                    videoHomeUnitNoHeaderPartDefinition = f3196b;
                }
                if (videoHomeUnitNoHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3044b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3197c, b3);
                        } else {
                            f3196b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeUnitNoHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
