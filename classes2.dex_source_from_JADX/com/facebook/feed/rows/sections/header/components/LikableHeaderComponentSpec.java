package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: freshness */
public class LikableHeaderComponentSpec<E extends CanLikePage & HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher & HasRowKey & HasContext> {
    private static LikableHeaderComponentSpec f23192d;
    private static final Object f23193e = new Object();
    public final HeaderActorComponent<E> f23194a;
    public final HeaderTitleAndSubtitleComponent<E> f23195b;
    public final HeaderLikeButtonComponent<E> f23196c;

    private static LikableHeaderComponentSpec m31306b(InjectorLike injectorLike) {
        return new LikableHeaderComponentSpec(HeaderActorComponent.m28151a(injectorLike), HeaderTitleAndSubtitleComponent.m28242a(injectorLike), HeaderLikeButtonComponent.m31307a(injectorLike));
    }

    @Inject
    public LikableHeaderComponentSpec(HeaderActorComponent headerActorComponent, HeaderTitleAndSubtitleComponent headerTitleAndSubtitleComponent, HeaderLikeButtonComponent headerLikeButtonComponent) {
        this.f23194a = headerActorComponent;
        this.f23195b = headerTitleAndSubtitleComponent;
        this.f23196c = headerLikeButtonComponent;
    }

    public static LikableHeaderComponentSpec m31305a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LikableHeaderComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23193e) {
                LikableHeaderComponentSpec likableHeaderComponentSpec;
                if (a2 != null) {
                    likableHeaderComponentSpec = (LikableHeaderComponentSpec) a2.mo818a(f23193e);
                } else {
                    likableHeaderComponentSpec = f23192d;
                }
                if (likableHeaderComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31306b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23193e, b3);
                        } else {
                            f23192d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = likableHeaderComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
