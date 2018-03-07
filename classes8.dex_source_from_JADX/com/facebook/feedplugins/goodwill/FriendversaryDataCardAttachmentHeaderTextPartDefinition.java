package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
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
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: graph_search_results_page_commerce */
public class FriendversaryDataCardAttachmentHeaderTextPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, HasPositionInformation, LinearLayout> {
    public static final ViewType f12256a = ViewType.a(2130904615);
    private static final PaddingStyle f12257d;
    private static FriendversaryDataCardAttachmentHeaderTextPartDefinition f12258e;
    private static final Object f12259f = new Object();
    private final TextPartDefinition f12260b;
    private final BackgroundPartDefinition f12261c;

    private static FriendversaryDataCardAttachmentHeaderTextPartDefinition m14223b(InjectorLike injectorLike) {
        return new FriendversaryDataCardAttachmentHeaderTextPartDefinition(TextPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m14225a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f12261c, new StylingData(AttachmentProps.e(feedProps), f12257d, Position.MIDDLE));
        subParts.a(2131561593, this.f12260b, ((GraphQLStoryAttachment) feedProps.a).z().it().a());
        return null;
    }

    public final boolean m14226a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        return (graphQLStoryAttachment == null || graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().it() == null) ? false : true;
    }

    static {
        Builder f = Builder.f();
        f.c = 10.0f;
        f12257d = f.i();
    }

    @Inject
    public FriendversaryDataCardAttachmentHeaderTextPartDefinition(TextPartDefinition textPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f12260b = textPartDefinition;
        this.f12261c = backgroundPartDefinition;
    }

    public final ViewType m14224a() {
        return f12256a;
    }

    public static FriendversaryDataCardAttachmentHeaderTextPartDefinition m14222a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendversaryDataCardAttachmentHeaderTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12259f) {
                FriendversaryDataCardAttachmentHeaderTextPartDefinition friendversaryDataCardAttachmentHeaderTextPartDefinition;
                if (a2 != null) {
                    friendversaryDataCardAttachmentHeaderTextPartDefinition = (FriendversaryDataCardAttachmentHeaderTextPartDefinition) a2.a(f12259f);
                } else {
                    friendversaryDataCardAttachmentHeaderTextPartDefinition = f12258e;
                }
                if (friendversaryDataCardAttachmentHeaderTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14223b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12259f, b3);
                        } else {
                            f12258e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendversaryDataCardAttachmentHeaderTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
