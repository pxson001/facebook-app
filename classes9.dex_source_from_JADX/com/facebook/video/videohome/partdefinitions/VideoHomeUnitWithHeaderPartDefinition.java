package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
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
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.facebook.video.videohome.data.VideoHomeReactionFragmentToNodeConverter;
import com.facebook.video.videohome.partdefinitions.VideoHomeUnitBodyPartDefinition.Props;
import javax.inject.Inject;

@ContextScoped
/* compiled from: signup_message */
public class VideoHomeUnitWithHeaderPartDefinition extends BaseMultiRowGroupPartDefinition<ReactionUnitFragment, Void, AnyEnvironment> {
    private static VideoHomeUnitWithHeaderPartDefinition f3206c;
    private static final Object f3207d = new Object();
    private final VideoHomeSectionHeaderPartDefinition f3208a;
    private final VideoHomeUnitBodyPartDefinition f3209b;

    private static VideoHomeUnitWithHeaderPartDefinition m3056b(InjectorLike injectorLike) {
        return new VideoHomeUnitWithHeaderPartDefinition(VideoHomeSectionHeaderPartDefinition.m2998a(injectorLike), VideoHomeUnitBodyPartDefinition.m3039a(injectorLike));
    }

    public final Object m3057a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitFragment reactionUnitFragment = (ReactionUnitFragment) obj;
        baseMultiRowSubParts.a(this.f3208a, VideoHomeReactionFragmentToNodeConverter.m2708a(reactionUnitFragment, 0));
        baseMultiRowSubParts.a(this.f3209b, new Props(reactionUnitFragment, 1));
        return null;
    }

    public final boolean m3058a(Object obj) {
        ReactionUnitFragment reactionUnitFragment = (ReactionUnitFragment) obj;
        int size = reactionUnitFragment.s().size();
        if (size >= 2) {
            return true;
        }
        if (size <= 0) {
            return false;
        }
        return ((ReactionUnitComponentModel) reactionUnitFragment.s().get(0)).a() == GraphQLReactionUnitComponentStyle.VIDEO_HOME_SECTION_HEADER;
    }

    @Inject
    public VideoHomeUnitWithHeaderPartDefinition(VideoHomeSectionHeaderPartDefinition videoHomeSectionHeaderPartDefinition, VideoHomeUnitBodyPartDefinition videoHomeUnitBodyPartDefinition) {
        this.f3208a = videoHomeSectionHeaderPartDefinition;
        this.f3209b = videoHomeUnitBodyPartDefinition;
    }

    public static VideoHomeUnitWithHeaderPartDefinition m3055a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeUnitWithHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3207d) {
                VideoHomeUnitWithHeaderPartDefinition videoHomeUnitWithHeaderPartDefinition;
                if (a2 != null) {
                    videoHomeUnitWithHeaderPartDefinition = (VideoHomeUnitWithHeaderPartDefinition) a2.a(f3207d);
                } else {
                    videoHomeUnitWithHeaderPartDefinition = f3206c;
                }
                if (videoHomeUnitWithHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3056b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3207d, b3);
                        } else {
                            f3206c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeUnitWithHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
