package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
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
import com.facebook.quotes.QuoteExtractor;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

@ContextScoped
/* compiled from: VideoChannelSetPinStateMutation */
public class QuoteShareWithVerticalBarPartDefinition<E extends HasPositionInformation & HasInvalidate & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, CustomLinearLayout> {
    public static final ViewType f21016a = ViewType.a(2130906569);
    private static final PaddingStyle f21017b = PaddingStyle.e;
    private static QuoteShareWithVerticalBarPartDefinition f21018e;
    private static final Object f21019f = new Object();
    private final BackgroundPartDefinition f21020c;
    private final QuoteShareTextPartDefinition f21021d;

    private static QuoteShareWithVerticalBarPartDefinition m23914b(InjectorLike injectorLike) {
        return new QuoteShareWithVerticalBarPartDefinition(BackgroundPartDefinition.a(injectorLike), QuoteShareTextPartDefinition.m23902a(injectorLike));
    }

    public final Object m23916a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f21020c, new StylingData(AttachmentProps.e(feedProps), f21017b));
        String a = QuoteExtractor.a((GraphQLStoryAttachment) feedProps.a);
        if (a != null) {
            subParts.a(2131566532, this.f21021d, a);
        }
        return null;
    }

    @Inject
    public QuoteShareWithVerticalBarPartDefinition(BackgroundPartDefinition backgroundPartDefinition, QuoteShareTextPartDefinition quoteShareTextPartDefinition) {
        this.f21020c = backgroundPartDefinition;
        this.f21021d = quoteShareTextPartDefinition;
    }

    public final ViewType m23915a() {
        return f21016a;
    }

    public final boolean m23917a(Object obj) {
        return true;
    }

    public static QuoteShareWithVerticalBarPartDefinition m23913a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuoteShareWithVerticalBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21019f) {
                QuoteShareWithVerticalBarPartDefinition quoteShareWithVerticalBarPartDefinition;
                if (a2 != null) {
                    quoteShareWithVerticalBarPartDefinition = (QuoteShareWithVerticalBarPartDefinition) a2.a(f21019f);
                } else {
                    quoteShareWithVerticalBarPartDefinition = f21018e;
                }
                if (quoteShareWithVerticalBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23914b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21019f, b3);
                        } else {
                            f21018e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quoteShareWithVerticalBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
