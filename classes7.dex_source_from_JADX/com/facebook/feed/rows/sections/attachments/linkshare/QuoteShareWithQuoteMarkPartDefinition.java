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
/* compiled from: VideoHome visit mutation failed. */
public class QuoteShareWithQuoteMarkPartDefinition<E extends HasPositionInformation & HasInvalidate & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, CustomLinearLayout> {
    public static final ViewType f21010a = ViewType.a(2130906568);
    private static final PaddingStyle f21011b = PaddingStyle.e;
    private static QuoteShareWithQuoteMarkPartDefinition f21012e;
    private static final Object f21013f = new Object();
    private final BackgroundPartDefinition f21014c;
    private final QuoteShareTextPartDefinition f21015d;

    private static QuoteShareWithQuoteMarkPartDefinition m23909b(InjectorLike injectorLike) {
        return new QuoteShareWithQuoteMarkPartDefinition(BackgroundPartDefinition.a(injectorLike), QuoteShareTextPartDefinition.m23902a(injectorLike));
    }

    public final Object m23911a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f21014c, new StylingData(AttachmentProps.e(feedProps), f21011b));
        String a = QuoteExtractor.a((GraphQLStoryAttachment) feedProps.a);
        if (a != null) {
            subParts.a(2131566532, this.f21015d, a);
        }
        return null;
    }

    @Inject
    public QuoteShareWithQuoteMarkPartDefinition(BackgroundPartDefinition backgroundPartDefinition, QuoteShareTextPartDefinition quoteShareTextPartDefinition) {
        this.f21014c = backgroundPartDefinition;
        this.f21015d = quoteShareTextPartDefinition;
    }

    public final ViewType m23910a() {
        return f21010a;
    }

    public final boolean m23912a(Object obj) {
        return true;
    }

    public static QuoteShareWithQuoteMarkPartDefinition m23908a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuoteShareWithQuoteMarkPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21013f) {
                QuoteShareWithQuoteMarkPartDefinition quoteShareWithQuoteMarkPartDefinition;
                if (a2 != null) {
                    quoteShareWithQuoteMarkPartDefinition = (QuoteShareWithQuoteMarkPartDefinition) a2.a(f21013f);
                } else {
                    quoteShareWithQuoteMarkPartDefinition = f21012e;
                }
                if (quoteShareWithQuoteMarkPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23909b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21013f, b3);
                        } else {
                            f21012e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quoteShareWithQuoteMarkPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
