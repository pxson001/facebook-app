package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import javax.inject.Inject;

@ContextScoped
/* compiled from: VideoHomePrefetchMetadataQuery */
public class QuoteShareAttachmentGroupDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static QuoteShareAttachmentGroupDefinition f21001c;
    private static final Object f21002d = new Object();
    private final Lazy<QuoteShareWithVerticalBarPartDefinition> f21003a;
    private final Lazy<SmallPhotoShareAttachmentPartDefinition> f21004b;

    private static QuoteShareAttachmentGroupDefinition m23895b(InjectorLike injectorLike) {
        return new QuoteShareAttachmentGroupDefinition(IdBasedLazy.a(injectorLike, 6014), IdBasedLazy.a(injectorLike, 1569));
    }

    public final Object m23896a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f21003a.get(), feedProps);
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f21004b.get(), feedProps);
        return null;
    }

    @Inject
    public QuoteShareAttachmentGroupDefinition(Lazy<QuoteShareWithVerticalBarPartDefinition> lazy, Lazy<SmallPhotoShareAttachmentPartDefinition> lazy2) {
        this.f21003a = lazy;
        this.f21004b = lazy2;
    }

    public final boolean m23897a(Object obj) {
        return true;
    }

    public static QuoteShareAttachmentGroupDefinition m23894a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuoteShareAttachmentGroupDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21002d) {
                QuoteShareAttachmentGroupDefinition quoteShareAttachmentGroupDefinition;
                if (a2 != null) {
                    quoteShareAttachmentGroupDefinition = (QuoteShareAttachmentGroupDefinition) a2.a(f21002d);
                } else {
                    quoteShareAttachmentGroupDefinition = f21001c;
                }
                if (quoteShareAttachmentGroupDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23895b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21002d, b3);
                        } else {
                            f21001c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quoteShareAttachmentGroupDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
