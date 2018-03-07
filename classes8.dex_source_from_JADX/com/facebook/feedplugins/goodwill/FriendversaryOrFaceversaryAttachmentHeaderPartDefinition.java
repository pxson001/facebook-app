package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.facebookvoice.FacebookVoiceBasePartDefinition;
import com.facebook.feedplugins.facebookvoice.FacebookVoiceBasePartDefinition.State;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: graph_search_results_filter */
public class FriendversaryOrFaceversaryAttachmentHeaderPartDefinition extends FacebookVoiceBasePartDefinition<GraphQLStoryAttachment, HasPositionInformation> {
    private static FriendversaryOrFaceversaryAttachmentHeaderPartDefinition f12292c;
    private static final Object f12293d = new Object();
    private final BackgroundPartDefinition f12294b;

    private static FriendversaryOrFaceversaryAttachmentHeaderPartDefinition m14252b(InjectorLike injectorLike) {
        return new FriendversaryOrFaceversaryAttachmentHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m14253a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m14250a(subParts, (FeedProps) obj);
    }

    public final boolean m14254a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        return (graphQLStoryAttachment == null || graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().it() == null) ? false : true;
    }

    @Inject
    public FriendversaryOrFaceversaryAttachmentHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f12294b = backgroundPartDefinition;
    }

    private State m14250a(SubParts<HasPositionInformation> subParts, FeedProps<GraphQLStoryAttachment> feedProps) {
        boolean z;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a();
        subParts.a(this.f12294b, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.a));
        String a = graphQLStoryAttachment.z().it().a();
        GraphQLImage k = graphQLStoryAttachment.z().k();
        if (GraphQLStoryAttachmentUtil.a((GraphQLStoryAttachment) feedProps.a(), GraphQLStoryAttachmentStyle.GOODWILL_THROWBACK_FACEVERSARY_COLLAGE_CARD)) {
            z = false;
        } else {
            z = true;
        }
        return new State(a, null, null, false, k, -16777216, true, null, z, null, 0, 0.0f);
    }

    public static FriendversaryOrFaceversaryAttachmentHeaderPartDefinition m14251a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendversaryOrFaceversaryAttachmentHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12293d) {
                FriendversaryOrFaceversaryAttachmentHeaderPartDefinition friendversaryOrFaceversaryAttachmentHeaderPartDefinition;
                if (a2 != null) {
                    friendversaryOrFaceversaryAttachmentHeaderPartDefinition = (FriendversaryOrFaceversaryAttachmentHeaderPartDefinition) a2.a(f12293d);
                } else {
                    friendversaryOrFaceversaryAttachmentHeaderPartDefinition = f12292c;
                }
                if (friendversaryOrFaceversaryAttachmentHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14252b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12293d, b3);
                        } else {
                            f12292c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendversaryOrFaceversaryAttachmentHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
