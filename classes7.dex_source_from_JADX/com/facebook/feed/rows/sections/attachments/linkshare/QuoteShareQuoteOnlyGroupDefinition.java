package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: VideoHomePrefetchMetadataNoBadgingQuery */
public class QuoteShareQuoteOnlyGroupDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static QuoteShareQuoteOnlyGroupDefinition f21005b;
    private static final Object f21006c = new Object();
    private final QuoteShareWithVerticalBarPartDefinition f21007a;

    private static QuoteShareQuoteOnlyGroupDefinition m23899b(InjectorLike injectorLike) {
        return new QuoteShareQuoteOnlyGroupDefinition(QuoteShareWithVerticalBarPartDefinition.m23913a(injectorLike));
    }

    public final Object m23900a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f21007a, (FeedProps) obj);
        return null;
    }

    @Inject
    public QuoteShareQuoteOnlyGroupDefinition(QuoteShareWithVerticalBarPartDefinition quoteShareWithVerticalBarPartDefinition) {
        this.f21007a = quoteShareWithVerticalBarPartDefinition;
    }

    public final boolean m23901a(Object obj) {
        return true;
    }

    public static QuoteShareQuoteOnlyGroupDefinition m23898a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuoteShareQuoteOnlyGroupDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21006c) {
                QuoteShareQuoteOnlyGroupDefinition quoteShareQuoteOnlyGroupDefinition;
                if (a2 != null) {
                    quoteShareQuoteOnlyGroupDefinition = (QuoteShareQuoteOnlyGroupDefinition) a2.a(f21006c);
                } else {
                    quoteShareQuoteOnlyGroupDefinition = f21005b;
                }
                if (quoteShareQuoteOnlyGroupDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23899b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21006c, b3);
                        } else {
                            f21005b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quoteShareQuoteOnlyGroupDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
