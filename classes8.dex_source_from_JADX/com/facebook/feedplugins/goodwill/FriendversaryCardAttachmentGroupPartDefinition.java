package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.collage.CollageAttachmentPartDefinition;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: graph_search_results_see_more_on_module_tapped */
public class FriendversaryCardAttachmentGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static FriendversaryCardAttachmentGroupPartDefinition f12226e;
    private static final Object f12227f = new Object();
    private final FriendversaryInProductBrandingAttachmentHeaderPartDefinition f12228a;
    private final FriendversaryOrFaceversaryAttachmentHeaderPartDefinition f12229b;
    private final CollageAttachmentPartDefinition<FeedEnvironment> f12230c;
    private final DualPhotoPartDefinition<FeedEnvironment> f12231d;

    private static FriendversaryCardAttachmentGroupPartDefinition m14196b(InjectorLike injectorLike) {
        return new FriendversaryCardAttachmentGroupPartDefinition(FriendversaryInProductBrandingAttachmentHeaderPartDefinition.m14245a(injectorLike), CollageAttachmentPartDefinition.a(injectorLike), DualPhotoPartDefinition.m14189a(injectorLike), FriendversaryOrFaceversaryAttachmentHeaderPartDefinition.m14251a(injectorLike));
    }

    public final Object m14197a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        if (!GraphQLStoryAttachmentUtil.a((GraphQLStoryAttachment) feedProps.a, GraphQLStoryAttachmentStyle.GOODWILL_THROWBACK_FRIENDVERSARY_POLAROIDS_CARD_IPB) || ((GraphQLStoryAttachment) feedProps.a).z() == null) {
            baseMultiRowSubParts.a(this.f12229b, feedProps);
            baseMultiRowSubParts.a(this.f12231d, feedProps);
        } else {
            baseMultiRowSubParts.a(this.f12228a, feedProps);
            ImmutableList in = ((GraphQLStoryAttachment) feedProps.a).z().in();
            Builder builder = new Builder();
            builder.r = in;
            baseMultiRowSubParts.a(this.f12230c, feedProps.b(builder.a()));
        }
        return null;
    }

    @Inject
    public FriendversaryCardAttachmentGroupPartDefinition(FriendversaryInProductBrandingAttachmentHeaderPartDefinition friendversaryInProductBrandingAttachmentHeaderPartDefinition, CollageAttachmentPartDefinition collageAttachmentPartDefinition, DualPhotoPartDefinition dualPhotoPartDefinition, FriendversaryOrFaceversaryAttachmentHeaderPartDefinition friendversaryOrFaceversaryAttachmentHeaderPartDefinition) {
        this.f12229b = friendversaryOrFaceversaryAttachmentHeaderPartDefinition;
        this.f12228a = friendversaryInProductBrandingAttachmentHeaderPartDefinition;
        this.f12230c = collageAttachmentPartDefinition;
        this.f12231d = dualPhotoPartDefinition;
    }

    public final boolean m14198a(Object obj) {
        return true;
    }

    public static FriendversaryCardAttachmentGroupPartDefinition m14195a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendversaryCardAttachmentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12227f) {
                FriendversaryCardAttachmentGroupPartDefinition friendversaryCardAttachmentGroupPartDefinition;
                if (a2 != null) {
                    friendversaryCardAttachmentGroupPartDefinition = (FriendversaryCardAttachmentGroupPartDefinition) a2.a(f12227f);
                } else {
                    friendversaryCardAttachmentGroupPartDefinition = f12226e;
                }
                if (friendversaryCardAttachmentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14196b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12227f, b3);
                        } else {
                            f12226e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendversaryCardAttachmentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
