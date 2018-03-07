package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: graph_search_results_page_reaction */
public class FriendversaryDataCardAttachmentHeaderPartDefinition<E extends HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, LinearLayout> {
    public static final ViewType f12247a = ViewType.a(2130904612);
    private static final CallerContext f12248e = CallerContext.a(FriendversaryDataCardHeaderPartDefinition.class, "goodwill_throwback");
    private static FriendversaryDataCardAttachmentHeaderPartDefinition f12249f;
    private static final Object f12250g = new Object();
    private final FbDraweePartDefinition f12251b;
    private final BackgroundPartDefinition f12252c;
    private final FriendversaryDataCardAttachmentHeaderPolaroidPartDefinition f12253d;

    private static FriendversaryDataCardAttachmentHeaderPartDefinition m14214b(InjectorLike injectorLike) {
        return new FriendversaryDataCardAttachmentHeaderPartDefinition(FbDraweePartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), FriendversaryDataCardAttachmentHeaderPolaroidPartDefinition.m14218a(injectorLike));
    }

    public final Object m14216a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        GraphQLImage graphQLImage = (GraphQLImage) graphQLStoryAttachment.z().r().get(0);
        GraphQLImage graphQLImage2 = (GraphQLImage) graphQLStoryAttachment.z().r().get(1);
        FbDraweePartDefinition fbDraweePartDefinition = this.f12251b;
        Builder a = new Builder().a(graphQLImage.b());
        a.c = f12248e;
        subParts.a(2131562585, fbDraweePartDefinition, a.a(graphQLImage.c(), graphQLImage.a()).a());
        FbDraweePartDefinition fbDraweePartDefinition2 = this.f12251b;
        Builder a2 = new Builder().a(graphQLImage2.b());
        a2.c = f12248e;
        subParts.a(2131562587, fbDraweePartDefinition2, a2.a(graphQLImage2.c(), graphQLImage2.a()).a());
        subParts.a(this.f12252c, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.a));
        subParts.a(2131562586, this.f12253d, feedProps);
        return null;
    }

    public final boolean m14217a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        if (graphQLStoryAttachment.z() == null) {
            return false;
        }
        ImmutableList im = graphQLStoryAttachment.z().im();
        if (im == null || im.size() < 2) {
            return false;
        }
        int i;
        for (i = 0; i < 2; i++) {
            GraphQLMedia graphQLMedia = (GraphQLMedia) im.get(i);
            if (graphQLMedia == null || graphQLMedia.S() == null || graphQLMedia.S().b() == null) {
                return false;
            }
        }
        im = graphQLStoryAttachment.z().r();
        if (im == null || im.size() < 2) {
            return false;
        }
        for (i = 0; i < 2; i++) {
            GraphQLImage graphQLImage = (GraphQLImage) im.get(i);
            if (graphQLImage == null || graphQLImage.b() == null) {
                return false;
            }
        }
        if (graphQLStoryAttachment == null || graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().it() == null) {
            return false;
        }
        return true;
    }

    @Inject
    public FriendversaryDataCardAttachmentHeaderPartDefinition(FbDraweePartDefinition fbDraweePartDefinition, BackgroundPartDefinition backgroundPartDefinition, FriendversaryDataCardAttachmentHeaderPolaroidPartDefinition friendversaryDataCardAttachmentHeaderPolaroidPartDefinition) {
        this.f12251b = fbDraweePartDefinition;
        this.f12252c = backgroundPartDefinition;
        this.f12253d = friendversaryDataCardAttachmentHeaderPolaroidPartDefinition;
    }

    public static FriendversaryDataCardAttachmentHeaderPartDefinition m14213a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendversaryDataCardAttachmentHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12250g) {
                FriendversaryDataCardAttachmentHeaderPartDefinition friendversaryDataCardAttachmentHeaderPartDefinition;
                if (a2 != null) {
                    friendversaryDataCardAttachmentHeaderPartDefinition = (FriendversaryDataCardAttachmentHeaderPartDefinition) a2.a(f12250g);
                } else {
                    friendversaryDataCardAttachmentHeaderPartDefinition = f12249f;
                }
                if (friendversaryDataCardAttachmentHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14214b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12250g, b3);
                        } else {
                            f12249f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendversaryDataCardAttachmentHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m14215a() {
        return f12247a;
    }
}
