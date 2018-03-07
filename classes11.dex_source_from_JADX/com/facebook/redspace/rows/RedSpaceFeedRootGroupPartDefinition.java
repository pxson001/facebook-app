package com.facebook.redspace.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
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
import com.facebook.redspace.rows.header.RedSpaceHeaderGroupPartDefinition;
import com.facebook.timeline.feed.parts.TimelineFeedUnitRootPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PageCreateToFetchCards */
public class RedSpaceFeedRootGroupPartDefinition extends BaseMultiRowGroupPartDefinition<Object, Void, RedSpaceEnvironment> {
    private static RedSpaceFeedRootGroupPartDefinition f12188e;
    private static final Object f12189f = new Object();
    private final Lazy<TimelineFeedUnitRootPartDefinition> f12190a;
    private final Lazy<RedSpaceProfileNavigationPartDefinition> f12191b;
    private final Lazy<RedSpaceHeaderGroupPartDefinition> f12192c;
    private final Lazy<RedSpaceNewsFeedTitlePartDefinition> f12193d;

    private static RedSpaceFeedRootGroupPartDefinition m12656b(InjectorLike injectorLike) {
        return new RedSpaceFeedRootGroupPartDefinition(IdBasedLazy.a(injectorLike, 11235), IdBasedLazy.a(injectorLike, 10208), IdBasedLazy.a(injectorLike, 10209), IdBasedLazy.a(injectorLike, 10207));
    }

    @Inject
    public RedSpaceFeedRootGroupPartDefinition(Lazy<TimelineFeedUnitRootPartDefinition> lazy, Lazy<RedSpaceProfileNavigationPartDefinition> lazy2, Lazy<RedSpaceHeaderGroupPartDefinition> lazy3, Lazy<RedSpaceNewsFeedTitlePartDefinition> lazy4) {
        this.f12190a = lazy;
        this.f12191b = lazy2;
        this.f12192c = lazy3;
        this.f12193d = lazy4;
    }

    public final boolean m12658a(Object obj) {
        return true;
    }

    public final Object m12657a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SubPartsSelector.a(baseMultiRowSubParts, this.f12191b, obj).a(this.f12193d, obj).a(this.f12192c, obj).a(this.f12190a, obj);
        return null;
    }

    public static RedSpaceFeedRootGroupPartDefinition m12655a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceFeedRootGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12189f) {
                RedSpaceFeedRootGroupPartDefinition redSpaceFeedRootGroupPartDefinition;
                if (a2 != null) {
                    redSpaceFeedRootGroupPartDefinition = (RedSpaceFeedRootGroupPartDefinition) a2.a(f12189f);
                } else {
                    redSpaceFeedRootGroupPartDefinition = f12188e;
                }
                if (redSpaceFeedRootGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12656b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12189f, b3);
                        } else {
                            f12188e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceFeedRootGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
