package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.PhotoAttachmentPartDefinition;
import com.facebook.feedplugins.attachments.collage.CollageAttachmentPartDefinition;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLMedia;
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
/* compiled from: graph_search_results_error */
public class FriendversaryOrFaceversaryCollageAttachmentGroupPartDefinition<E extends HasFeedListType & HasInvalidate & HasImageLoadListener & HasPositionInformation & HasPrefetcher> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E> {
    private static FriendversaryOrFaceversaryCollageAttachmentGroupPartDefinition f12295e;
    private static final Object f12296f = new Object();
    private final FriendversaryInProductBrandingAttachmentHeaderPartDefinition f12297a;
    private final FriendversaryOrFaceversaryAttachmentHeaderPartDefinition f12298b;
    private final CollageAttachmentPartDefinition<E> f12299c;
    private final PhotoAttachmentPartDefinition f12300d;

    private static FriendversaryOrFaceversaryCollageAttachmentGroupPartDefinition m14256b(InjectorLike injectorLike) {
        return new FriendversaryOrFaceversaryCollageAttachmentGroupPartDefinition(FriendversaryInProductBrandingAttachmentHeaderPartDefinition.m14245a(injectorLike), FriendversaryOrFaceversaryAttachmentHeaderPartDefinition.m14251a(injectorLike), CollageAttachmentPartDefinition.a(injectorLike), PhotoAttachmentPartDefinition.a(injectorLike));
    }

    public final Object m14257a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (GraphQLStoryAttachmentUtil.a((GraphQLStoryAttachment) feedProps.a, GraphQLStoryAttachmentStyle.GOODWILL_THROWBACK_FRIENDVERSARY_COLLAGE_CARD_IPB)) {
            baseMultiRowSubParts.a(this.f12297a, feedProps);
        } else {
            baseMultiRowSubParts.a(this.f12298b, feedProps);
        }
        ImmutableList in = graphQLStoryAttachment.z().in();
        Builder builder = new Builder();
        if (in.size() != 1) {
            builder.r = in;
            baseMultiRowSubParts.a(this.f12299c, feedProps.b(builder.a()));
        } else if (!(in.get(0) == null || ((GraphQLStoryAttachment) in.get(0)).r() == null)) {
            Builder.a((GraphQLStoryAttachment) in.get(0));
            builder.l = GraphQLMedia.Builder.a(((GraphQLStoryAttachment) in.get(0)).r()).a();
            baseMultiRowSubParts.a(this.f12300d, feedProps.a(builder.a()));
        }
        return null;
    }

    @Inject
    public FriendversaryOrFaceversaryCollageAttachmentGroupPartDefinition(FriendversaryInProductBrandingAttachmentHeaderPartDefinition friendversaryInProductBrandingAttachmentHeaderPartDefinition, FriendversaryOrFaceversaryAttachmentHeaderPartDefinition friendversaryOrFaceversaryAttachmentHeaderPartDefinition, CollageAttachmentPartDefinition collageAttachmentPartDefinition, PhotoAttachmentPartDefinition photoAttachmentPartDefinition) {
        this.f12298b = friendversaryOrFaceversaryAttachmentHeaderPartDefinition;
        this.f12297a = friendversaryInProductBrandingAttachmentHeaderPartDefinition;
        this.f12299c = collageAttachmentPartDefinition;
        this.f12300d = photoAttachmentPartDefinition;
    }

    public static FriendversaryOrFaceversaryCollageAttachmentGroupPartDefinition m14255a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendversaryOrFaceversaryCollageAttachmentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12296f) {
                FriendversaryOrFaceversaryCollageAttachmentGroupPartDefinition friendversaryOrFaceversaryCollageAttachmentGroupPartDefinition;
                if (a2 != null) {
                    friendversaryOrFaceversaryCollageAttachmentGroupPartDefinition = (FriendversaryOrFaceversaryCollageAttachmentGroupPartDefinition) a2.a(f12296f);
                } else {
                    friendversaryOrFaceversaryCollageAttachmentGroupPartDefinition = f12295e;
                }
                if (friendversaryOrFaceversaryCollageAttachmentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14256b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12296f, b3);
                        } else {
                            f12295e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendversaryOrFaceversaryCollageAttachmentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m14258a(Object obj) {
        return true;
    }
}
