package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: feedback logging params or feedback source is null */
public class TextHeaderSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static TextHeaderSelectorPartDefinition f24462e;
    private static final Object f24463f = new Object();
    private final Lazy<FeedClientSideBumpedTextHeaderPartDefinition<FeedEnvironment>> f24464a;
    private final Lazy<FeedSeeFirstTextHeaderPartDefinition<FeedEnvironment>> f24465b;
    private final Lazy<FeedTextHeaderComponentPartDefinition<FeedEnvironment>> f24466c;
    private final Lazy<FeedTextHeaderPartDefinition<FeedEnvironment>> f24467d;

    private static TextHeaderSelectorPartDefinition m32774b(InjectorLike injectorLike) {
        return new TextHeaderSelectorPartDefinition(IdBasedLazy.m1808a(injectorLike, 1598), IdBasedLazy.m1808a(injectorLike, 1599), IdBasedLazy.m1808a(injectorLike, 1597), IdBasedLazy.m1808a(injectorLike, 1596));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        SubPartsSelector.m19115a(baseMultiRowSubParts, this.f24465b, obj).m19119a(this.f24464a, obj).m19119a(this.f24466c, obj).m19119a(this.f24467d, obj);
        return null;
    }

    @Inject
    public TextHeaderSelectorPartDefinition(Lazy<FeedTextHeaderComponentPartDefinition> lazy, Lazy<FeedTextHeaderPartDefinition> lazy2, Lazy<FeedSeeFirstTextHeaderPartDefinition> lazy3, Lazy<FeedClientSideBumpedTextHeaderPartDefinition> lazy4) {
        this.f24464a = lazy4;
        this.f24465b = lazy3;
        this.f24466c = lazy;
        this.f24467d = lazy2;
    }

    public final boolean mo2536a(Object obj) {
        return true;
    }

    public static TextHeaderSelectorPartDefinition m32773a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TextHeaderSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24463f) {
                TextHeaderSelectorPartDefinition textHeaderSelectorPartDefinition;
                if (a2 != null) {
                    textHeaderSelectorPartDefinition = (TextHeaderSelectorPartDefinition) a2.mo818a(f24463f);
                } else {
                    textHeaderSelectorPartDefinition = f24462e;
                }
                if (textHeaderSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32774b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24463f, b3);
                        } else {
                            f24462e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = textHeaderSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
