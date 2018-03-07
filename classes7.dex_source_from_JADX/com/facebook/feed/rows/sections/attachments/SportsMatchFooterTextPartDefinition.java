package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
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
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: X-ZERO-CARRIER-ID */
public class SportsMatchFooterTextPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, BetterTextView> {
    public static final ViewType f20786a = ViewType.a(2130907195);
    private static SportsMatchFooterTextPartDefinition f20787f;
    private static final Object f20788g = new Object();
    private final BackgroundPartDefinition f20789b;
    private final DefaultPaddingStyleResolver f20790c;
    private final TextPartDefinition f20791d;
    private final AttachmentLinkPartDefinition<E> f20792e;

    private static SportsMatchFooterTextPartDefinition m23754b(InjectorLike injectorLike) {
        return new SportsMatchFooterTextPartDefinition(BackgroundPartDefinition.a(injectorLike), DefaultPaddingStyleResolver.a(injectorLike), TextPartDefinition.a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike));
    }

    public final Object m23756a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        Builder a = Builder.a();
        a.b = -this.f20790c.d();
        subParts.a(this.f20789b, new StylingData(AttachmentProps.e(feedProps), a.i(), 2130843438, -1));
        subParts.a(2131560628, this.f20791d, graphQLStoryAttachment.n().a());
        subParts.a(this.f20792e, new Props(feedProps));
        return null;
    }

    public final boolean m23757a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        return (graphQLStoryAttachment.n() == null || graphQLStoryAttachment.n().a() == null) ? false : true;
    }

    @Inject
    public SportsMatchFooterTextPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DefaultPaddingStyleResolver defaultPaddingStyleResolver, TextPartDefinition textPartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition) {
        this.f20789b = backgroundPartDefinition;
        this.f20790c = defaultPaddingStyleResolver;
        this.f20791d = textPartDefinition;
        this.f20792e = attachmentLinkPartDefinition;
    }

    public final ViewType<BetterTextView> m23755a() {
        return f20786a;
    }

    public static SportsMatchFooterTextPartDefinition m23753a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SportsMatchFooterTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20788g) {
                SportsMatchFooterTextPartDefinition sportsMatchFooterTextPartDefinition;
                if (a2 != null) {
                    sportsMatchFooterTextPartDefinition = (SportsMatchFooterTextPartDefinition) a2.a(f20788g);
                } else {
                    sportsMatchFooterTextPartDefinition = f20787f;
                }
                if (sportsMatchFooterTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23754b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20788g, b3);
                        } else {
                            f20787f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = sportsMatchFooterTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
