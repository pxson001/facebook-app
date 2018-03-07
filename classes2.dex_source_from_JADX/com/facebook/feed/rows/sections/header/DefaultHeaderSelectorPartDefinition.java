package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.components.DefaultHeaderComponentPartDefinition;
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
/* compiled from: href */
public class DefaultHeaderSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static DefaultHeaderSelectorPartDefinition f20807c;
    private static final Object f20808d = new Object();
    private final Lazy<DefaultHeaderComponentPartDefinition<FeedEnvironment>> f20809a;
    private final Lazy<DefaultHeaderPartDefinition<FeedEnvironment>> f20810b;

    private static DefaultHeaderSelectorPartDefinition m28533b(InjectorLike injectorLike) {
        return new DefaultHeaderSelectorPartDefinition(IdBasedLazy.m1808a(injectorLike, 1628), IdBasedLazy.m1808a(injectorLike, 1590));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        SubPartsSelector.m19115a(baseMultiRowSubParts, this.f20809a, obj).m19119a(this.f20810b, obj);
        return null;
    }

    @Inject
    public DefaultHeaderSelectorPartDefinition(Lazy<DefaultHeaderComponentPartDefinition> lazy, Lazy<DefaultHeaderPartDefinition> lazy2) {
        this.f20809a = lazy;
        this.f20810b = lazy2;
    }

    public final boolean mo2536a(Object obj) {
        return true;
    }

    public static DefaultHeaderSelectorPartDefinition m28532a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultHeaderSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20808d) {
                DefaultHeaderSelectorPartDefinition defaultHeaderSelectorPartDefinition;
                if (a2 != null) {
                    defaultHeaderSelectorPartDefinition = (DefaultHeaderSelectorPartDefinition) a2.mo818a(f20808d);
                } else {
                    defaultHeaderSelectorPartDefinition = f20807c;
                }
                if (defaultHeaderSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28533b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20808d, b3);
                        } else {
                            f20807c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultHeaderSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
