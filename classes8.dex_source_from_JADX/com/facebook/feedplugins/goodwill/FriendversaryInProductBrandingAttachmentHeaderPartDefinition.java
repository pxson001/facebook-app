package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: graph_search_results_item_in_module_tapped */
public class FriendversaryInProductBrandingAttachmentHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, HasPositionInformation, LinearLayout> {
    public static final ViewType f12281a = ViewType.a(2130904616);
    private static final PaddingStyle f12282h;
    private static final CallerContext f12283i = CallerContext.a(FriendversaryDataCardHeaderPartDefinition.class, "goodwill_throwback");
    private static FriendversaryInProductBrandingAttachmentHeaderPartDefinition f12284j;
    private static final Object f12285k = new Object();
    private final FbDraweePartDefinition f12286b;
    private final BackgroundPartDefinition f12287c;
    private final TextPartDefinition f12288d;
    private final ClickListenerPartDefinition f12289e;
    public final FbUriIntentHandler f12290f;
    private final LinkifyUtil f12291g;

    private static FriendversaryInProductBrandingAttachmentHeaderPartDefinition m14246b(InjectorLike injectorLike) {
        return new FriendversaryInProductBrandingAttachmentHeaderPartDefinition(FbDraweePartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), FbUriIntentHandler.a(injectorLike), LinkifyUtil.a(injectorLike));
    }

    public final Object m14248a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        GraphQLImage graphQLImage = (GraphQLImage) graphQLStoryAttachment.z().r().get(0);
        GraphQLImage graphQLImage2 = (GraphQLImage) graphQLStoryAttachment.z().r().get(1);
        final GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) graphQLStoryAttachment.z().l().get(0);
        Object a = graphQLStoryAttachment.z().it() != null ? this.f12291g.a(LinkifyUtilConverter.c(graphQLStoryAttachment.z().it()), true, null) : "";
        FbDraweePartDefinition fbDraweePartDefinition = this.f12286b;
        Builder a2 = new Builder().a(graphQLImage.b());
        a2.c = f12283i;
        subParts.a(2131562585, fbDraweePartDefinition, a2.a(graphQLImage.c(), graphQLImage.a()).a());
        FbDraweePartDefinition fbDraweePartDefinition2 = this.f12286b;
        Builder a3 = new Builder().a(graphQLImage2.b());
        a3.c = f12283i;
        subParts.a(2131562587, fbDraweePartDefinition2, a3.a(graphQLImage2.c(), graphQLImage2.a()).a());
        subParts.a(this.f12287c, new StylingData(AttachmentProps.e(feedProps), f12282h));
        subParts.a(2131558926, this.f12289e, new OnClickListener(this) {
            final /* synthetic */ FriendversaryInProductBrandingAttachmentHeaderPartDefinition f12280b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1168491267);
                this.f12280b.f12290f.a(view.getContext(), graphQLStoryActionLink.aE());
                Logger.a(2, EntryType.UI_INPUT_END, 1011784956, a);
            }
        });
        subParts.a(2131558927, this.f12288d, a);
        subParts.a(2131558926, this.f12288d, graphQLStoryActionLink.aB());
        return null;
    }

    public final boolean m14249a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        ImmutableList l = graphQLStoryAttachment.z().l();
        if (l == null || l.size() <= 0 || l.get(0) == null) {
            return false;
        }
        ImmutableList r = graphQLStoryAttachment.z().r();
        if (r == null || r.size() < 2) {
            return false;
        }
        for (int i = 0; i < 2; i++) {
            GraphQLImage graphQLImage = (GraphQLImage) r.get(i);
            if (graphQLImage == null || graphQLImage.b() == null || graphQLImage.a() <= 0 || graphQLImage.c() <= 0) {
                return false;
            }
        }
        if (graphQLStoryAttachment == null || graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().it() == null) {
            return false;
        }
        return true;
    }

    static {
        PaddingStyle.Builder a = PaddingStyle.Builder.a();
        a.d = -11.0f;
        f12282h = a.i();
    }

    public static FriendversaryInProductBrandingAttachmentHeaderPartDefinition m14245a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendversaryInProductBrandingAttachmentHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12285k) {
                FriendversaryInProductBrandingAttachmentHeaderPartDefinition friendversaryInProductBrandingAttachmentHeaderPartDefinition;
                if (a2 != null) {
                    friendversaryInProductBrandingAttachmentHeaderPartDefinition = (FriendversaryInProductBrandingAttachmentHeaderPartDefinition) a2.a(f12285k);
                } else {
                    friendversaryInProductBrandingAttachmentHeaderPartDefinition = f12284j;
                }
                if (friendversaryInProductBrandingAttachmentHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14246b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12285k, b3);
                        } else {
                            f12284j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendversaryInProductBrandingAttachmentHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FriendversaryInProductBrandingAttachmentHeaderPartDefinition(FbDraweePartDefinition fbDraweePartDefinition, BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, FbUriIntentHandler fbUriIntentHandler, LinkifyUtil linkifyUtil) {
        this.f12286b = fbDraweePartDefinition;
        this.f12287c = backgroundPartDefinition;
        this.f12288d = textPartDefinition;
        this.f12289e = clickListenerPartDefinition;
        this.f12290f = fbUriIntentHandler;
        this.f12291g = linkifyUtil;
    }

    public final ViewType m14247a() {
        return f12281a;
    }
}
