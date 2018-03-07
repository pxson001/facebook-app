package com.facebook.timeline.pymk;

import android.content.Context;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: failed to get actor info */
public class PeopleYouMayKnowData implements ListItemCollection<Object> {
    private static PeopleYouMayKnowData f12463b;
    private static final Object f12464c = new Object();
    @Nullable
    public PeopleYouMayKnowModel f12465a;

    private static PeopleYouMayKnowData m12493b() {
        return new PeopleYouMayKnowData();
    }

    public final int m12494a() {
        return this.f12465a == null ? 0 : 1;
    }

    public final Object m12495a(int i) {
        if (i <= 0) {
            return this.f12465a;
        }
        throw new IllegalArgumentException("PeopleYouMayKnowData can only be of size 1");
    }

    public static PeopleYouMayKnowData m12492a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowData b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12464c) {
                PeopleYouMayKnowData peopleYouMayKnowData;
                if (a2 != null) {
                    peopleYouMayKnowData = (PeopleYouMayKnowData) a2.a(f12464c);
                } else {
                    peopleYouMayKnowData = f12463b;
                }
                if (peopleYouMayKnowData == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m12493b();
                        if (a2 != null) {
                            a2.a(f12464c, b3);
                        } else {
                            f12463b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowData;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
