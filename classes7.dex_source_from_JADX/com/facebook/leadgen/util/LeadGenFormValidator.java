package com.facebook.leadgen.util;

import android.content.Context;
import android.util.Patterns;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputDomain;
import com.facebook.graphql.model.GraphQLLeadGenInfoFieldData;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: photo_location_suggestion_effective */
public class LeadGenFormValidator {
    private static LeadGenFormValidator f6560a;
    private static final Object f6561b = new Object();

    private static LeadGenFormValidator m8499a() {
        return new LeadGenFormValidator();
    }

    public static boolean m8501a(LeadGenInfoFieldUserData leadGenInfoFieldUserData) {
        Object trim = leadGenInfoFieldUserData.f6562a.trim();
        GraphQLLeadGenInfoFieldData graphQLLeadGenInfoFieldData = leadGenInfoFieldUserData.f6563b;
        if (!graphQLLeadGenInfoFieldData.n()) {
            return true;
        }
        if (graphQLLeadGenInfoFieldData.o() && trim.isEmpty()) {
            return false;
        }
        if (graphQLLeadGenInfoFieldData.k() != GraphQLLeadGenInfoFieldInputDomain.EMAIL) {
            return true;
        }
        int i = 0;
        if (Patterns.EMAIL_ADDRESS.matcher(trim).matches()) {
            String[] split = trim.split("@", 2);
            if (split.length == 2 && !split[0].endsWith(".")) {
                i = 1;
            }
        }
        if (i == 0) {
            return false;
        }
        return true;
    }

    public static LeadGenFormValidator m8500a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LeadGenFormValidator a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f6561b) {
                LeadGenFormValidator leadGenFormValidator;
                if (a3 != null) {
                    leadGenFormValidator = (LeadGenFormValidator) a3.a(f6561b);
                } else {
                    leadGenFormValidator = f6560a;
                }
                if (leadGenFormValidator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m8499a();
                        if (a3 != null) {
                            a3.a(f6561b, a2);
                        } else {
                            f6560a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = leadGenFormValidator;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
