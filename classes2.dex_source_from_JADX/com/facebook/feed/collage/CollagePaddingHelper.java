package com.facebook.feed.collage;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.styling.PositionResolver;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: groups/members/{%s} */
public class CollagePaddingHelper {
    private static CollagePaddingHelper f21570d;
    private static final Object f21571e = new Object();
    public final QeAccessor f21572a;
    public final PositionResolver f21573b;
    public final GraphQLStoryUtil f21574c;

    private static CollagePaddingHelper m29279b(InjectorLike injectorLike) {
        return new CollagePaddingHelper(QeInternalImplMethodAutoProvider.m3744a(injectorLike), PositionResolver.m19143a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike));
    }

    @Inject
    public CollagePaddingHelper(QeAccessor qeAccessor, PositionResolver positionResolver, GraphQLStoryUtil graphQLStoryUtil) {
        this.f21572a = qeAccessor;
        this.f21573b = positionResolver;
        this.f21574c = graphQLStoryUtil;
    }

    public static CollagePaddingHelper m29278a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CollagePaddingHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21571e) {
                CollagePaddingHelper collagePaddingHelper;
                if (a2 != null) {
                    collagePaddingHelper = (CollagePaddingHelper) a2.mo818a(f21571e);
                } else {
                    collagePaddingHelper = f21570d;
                }
                if (collagePaddingHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29279b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21571e, b3);
                        } else {
                            f21570d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = collagePaddingHelper;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
