package com.facebook.feedplugins.multishare;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.leadgen.LeadGenUtil;
import javax.inject.Inject;

@ContextScoped
/* compiled from: network_bandwidth/ */
public class MultiShareLinkUtil {
    private static MultiShareLinkUtil f7234b;
    private static final Object f7235c = new Object();
    private final LeadGenUtil f7236a;

    private static MultiShareLinkUtil m7561b(InjectorLike injectorLike) {
        return new MultiShareLinkUtil(LeadGenUtil.a(injectorLike));
    }

    @Inject
    public MultiShareLinkUtil(LeadGenUtil leadGenUtil) {
        this.f7236a = leadGenUtil;
    }

    public final boolean m7562a(GraphQLStoryAttachment graphQLStoryAttachment) {
        return LeadGenUtil.a(graphQLStoryAttachment) != null;
    }

    public static MultiShareLinkUtil m7560a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MultiShareLinkUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7235c) {
                MultiShareLinkUtil multiShareLinkUtil;
                if (a2 != null) {
                    multiShareLinkUtil = (MultiShareLinkUtil) a2.a(f7235c);
                } else {
                    multiShareLinkUtil = f7234b;
                }
                if (multiShareLinkUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7561b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7235c, b3);
                        } else {
                            f7234b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = multiShareLinkUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
