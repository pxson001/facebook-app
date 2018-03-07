package com.facebook.payments.contactinfo.form;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: business_id */
public class SimpleContactInfoFormManager {
    private static SimpleContactInfoFormManager f18677b;
    private static final Object f18678c = new Object();
    private final ImmutableMap<ContactInfoFormStyle, ContactInfoFormStyleAssociation> f18679a;

    private static SimpleContactInfoFormManager m18691b(InjectorLike injectorLike) {
        return new SimpleContactInfoFormManager(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ContactInfoFormStyleAssociation(injectorLike)));
    }

    @Inject
    public SimpleContactInfoFormManager(Set<ContactInfoFormStyleAssociation> set) {
        Builder builder = ImmutableMap.builder();
        for (ContactInfoFormStyleAssociation contactInfoFormStyleAssociation : set) {
            builder.b(contactInfoFormStyleAssociation.f18669a, contactInfoFormStyleAssociation);
        }
        this.f18679a = builder.b();
    }

    public final SimpleContactInfoFormMutator m18692a(ContactInfoFormStyle contactInfoFormStyle) {
        if (!this.f18679a.containsKey(contactInfoFormStyle)) {
            contactInfoFormStyle = ContactInfoFormStyle.SIMPLE;
        }
        return (SimpleContactInfoFormMutator) ((ContactInfoFormStyleAssociation) this.f18679a.get(contactInfoFormStyle)).f18670b.get();
    }

    public static SimpleContactInfoFormManager m18690a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SimpleContactInfoFormManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18678c) {
                SimpleContactInfoFormManager simpleContactInfoFormManager;
                if (a2 != null) {
                    simpleContactInfoFormManager = (SimpleContactInfoFormManager) a2.a(f18678c);
                } else {
                    simpleContactInfoFormManager = f18677b;
                }
                if (simpleContactInfoFormManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18691b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18678c, b3);
                        } else {
                            f18677b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = simpleContactInfoFormManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
