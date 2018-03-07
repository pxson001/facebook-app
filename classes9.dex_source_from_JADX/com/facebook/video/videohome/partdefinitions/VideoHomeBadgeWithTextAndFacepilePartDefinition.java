package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.feed.environment.HasContext;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.FacepilePartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.multirow.parts.VisibilityPartDefinition;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.ProfilesModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.SubMessageModel;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: smsreply */
public class VideoHomeBadgeWithTextAndFacepilePartDefinition<E extends HasContext> extends BaseSinglePartDefinition<Props, Void, E, View> {
    private static VideoHomeBadgeWithTextAndFacepilePartDefinition f3027d;
    private static final Object f3028e = new Object();
    private final FacepilePartDefinition f3029a;
    private final VisibilityPartDefinition<E> f3030b;
    private final TextPartDefinition f3031c;

    /* compiled from: smsreply */
    public class Props {
        final ReactionUnitComponentFields f3023a;
        @Nullable
        final Float f3024b;
        @Nullable
        final Integer f3025c;
        @Nullable
        final Integer f3026d;

        public Props(ReactionUnitComponentFields reactionUnitComponentFields) {
            this(reactionUnitComponentFields, null, null, null);
        }

        public Props(ReactionUnitComponentFields reactionUnitComponentFields, Float f, Integer num, Integer num2) {
            this.f3023a = reactionUnitComponentFields;
            this.f3024b = f;
            this.f3025c = num;
            this.f3026d = num2;
        }
    }

    private static VideoHomeBadgeWithTextAndFacepilePartDefinition m2904b(InjectorLike injectorLike) {
        return new VideoHomeBadgeWithTextAndFacepilePartDefinition(FacepilePartDefinition.a(injectorLike), VisibilityPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m2905a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        int i = 0;
        ReactionUnitComponentFields reactionUnitComponentFields = props.f3023a;
        SubMessageModel cG = reactionUnitComponentFields.cG();
        ImmutableList ca = reactionUnitComponentFields.ca();
        subParts.a(2131568413, this.f3030b, Integer.valueOf(cG != null ? 0 : 8));
        VisibilityPartDefinition visibilityPartDefinition = this.f3030b;
        if (ca.isEmpty()) {
            i = 8;
        }
        subParts.a(2131568414, visibilityPartDefinition, Integer.valueOf(i));
        if (cG != null) {
            subParts.a(2131560278, this.f3031c, cG.a());
        }
        if (!ca.isEmpty()) {
            float floatValue;
            FacepilePartDefinition facepilePartDefinition = this.f3029a;
            ImmutableList a = m2903a(reactionUnitComponentFields);
            Context context = hasContext.getContext();
            if (props.f3024b != null) {
                floatValue = props.f3024b.floatValue();
            } else {
                floatValue = 0.0f;
            }
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.b = true;
            roundingParams = roundingParams.c(floatValue);
            roundingParams.f = context.getResources().getColor(2131363378);
            subParts.a(2131568414, facepilePartDefinition, new com.facebook.multirow.parts.FacepilePartDefinition.Props(a, null, 3, roundingParams, props.f3025c, props.f3026d));
        }
        return null;
    }

    public static VideoHomeBadgeWithTextAndFacepilePartDefinition m2902a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeBadgeWithTextAndFacepilePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3028e) {
                VideoHomeBadgeWithTextAndFacepilePartDefinition videoHomeBadgeWithTextAndFacepilePartDefinition;
                if (a2 != null) {
                    videoHomeBadgeWithTextAndFacepilePartDefinition = (VideoHomeBadgeWithTextAndFacepilePartDefinition) a2.a(f3028e);
                } else {
                    videoHomeBadgeWithTextAndFacepilePartDefinition = f3027d;
                }
                if (videoHomeBadgeWithTextAndFacepilePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2904b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3028e, b3);
                        } else {
                            f3027d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeBadgeWithTextAndFacepilePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoHomeBadgeWithTextAndFacepilePartDefinition(FacepilePartDefinition facepilePartDefinition, VisibilityPartDefinition visibilityPartDefinition, TextPartDefinition textPartDefinition) {
        this.f3029a = facepilePartDefinition;
        this.f3030b = visibilityPartDefinition;
        this.f3031c = textPartDefinition;
    }

    private static ImmutableList<Uri> m2903a(ReactionUnitComponentFields reactionUnitComponentFields) {
        Collection arrayList = new ArrayList();
        ImmutableList ca = reactionUnitComponentFields.ca();
        int size = ca.size();
        for (int i = 0; i < size; i++) {
            ProfilesModel profilesModel = (ProfilesModel) ca.get(i);
            if (profilesModel.d() != null) {
                arrayList.add(Uri.parse(profilesModel.d().b()));
            }
        }
        return ImmutableList.copyOf(arrayList);
    }
}
