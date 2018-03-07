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
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.video.videohome.data.VideoHomeReactionFragmentToNodeConverter;
import javax.inject.Inject;

@ContextScoped
/* compiled from: since_last_activity_query */
public class VideoHomeUnitBodyPartDefinition extends BaseMultiRowGroupPartDefinition<Props, Void, AnyEnvironment> {
    private static VideoHomeUnitBodyPartDefinition f3189f;
    private static final Object f3190g = new Object();
    private final VideoHomeVScrollListPartDefinition f3191a;
    private final VideoHomeVerticalListPartDefinition f3192b;
    private final VideoHomeHScrollListPartDefinition f3193c;
    private final VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition f3194d;
    private final VideoHomeGapPartDefinition f3195e;

    /* compiled from: since_last_activity_query */
    public class Props {
        public final ReactionUnitFragment f3187a;
        public final int f3188b;

        public Props(ReactionUnitFragment reactionUnitFragment, int i) {
            this.f3187a = reactionUnitFragment;
            this.f3188b = i;
        }
    }

    private static VideoHomeUnitBodyPartDefinition m3040b(InjectorLike injectorLike) {
        return new VideoHomeUnitBodyPartDefinition(VideoHomeVScrollListPartDefinition.m3059a(injectorLike), VideoHomeVerticalListPartDefinition.m3064a(injectorLike), VideoHomeHScrollListPartDefinition.m2943a(injectorLike), VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition.m2971a(injectorLike), VideoHomeGapPartDefinition.m2937a(injectorLike));
    }

    public final Object m3041a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        ReactionUnitComponentNode a = VideoHomeReactionFragmentToNodeConverter.m2708a(props.f3187a, props.f3188b);
        SubPartsSelector.a(baseMultiRowSubParts, this.f3191a, a).a(this.f3192b, a).a(this.f3193c, a).a(this.f3194d, a);
        if (VideoHomeVScrollListPartDefinition.m3060a(a) || VideoHomeVerticalListPartDefinition.m3065a(a) || VideoHomeHScrollListPartDefinition.m2944a(a) || this.f3194d.m2982a(a)) {
            baseMultiRowSubParts.a(this.f3195e, new com.facebook.video.videohome.partdefinitions.VideoHomeGapPartDefinition.Props(2131431510, 17170445));
        }
        return null;
    }

    public final boolean m3042a(Object obj) {
        Props props = (Props) obj;
        return props.f3187a.s().size() > props.f3188b;
    }

    @Inject
    public VideoHomeUnitBodyPartDefinition(VideoHomeVScrollListPartDefinition videoHomeVScrollListPartDefinition, VideoHomeVerticalListPartDefinition videoHomeVerticalListPartDefinition, VideoHomeHScrollListPartDefinition videoHomeHScrollListPartDefinition, VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition videoHomePaginatedHscrollLiveVideoComponentListPartDefinition, VideoHomeGapPartDefinition videoHomeGapPartDefinition) {
        this.f3191a = videoHomeVScrollListPartDefinition;
        this.f3192b = videoHomeVerticalListPartDefinition;
        this.f3193c = videoHomeHScrollListPartDefinition;
        this.f3194d = videoHomePaginatedHscrollLiveVideoComponentListPartDefinition;
        this.f3195e = videoHomeGapPartDefinition;
    }

    public static VideoHomeUnitBodyPartDefinition m3039a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeUnitBodyPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3190g) {
                VideoHomeUnitBodyPartDefinition videoHomeUnitBodyPartDefinition;
                if (a2 != null) {
                    videoHomeUnitBodyPartDefinition = (VideoHomeUnitBodyPartDefinition) a2.a(f3190g);
                } else {
                    videoHomeUnitBodyPartDefinition = f3189f;
                }
                if (videoHomeUnitBodyPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3040b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3190g, b3);
                        } else {
                            f3189f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeUnitBodyPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
