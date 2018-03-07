package com.facebook.feedplugins.pymk.rows.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@LayoutSpec
@ContextScoped
/* compiled from: THREAD_DB */
public class PeopleYouMayKnowHScrollComponentSpec<E extends HasContext & HasFeedListType & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> {
    private static PeopleYouMayKnowHScrollComponentSpec f24910a;
    private static final Object f24911b = new Object();

    private static PeopleYouMayKnowHScrollComponentSpec m26685a() {
        return new PeopleYouMayKnowHScrollComponentSpec();
    }

    public static PeopleYouMayKnowHScrollComponentSpec m26686a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowHScrollComponentSpec a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f24911b) {
                PeopleYouMayKnowHScrollComponentSpec peopleYouMayKnowHScrollComponentSpec;
                if (a3 != null) {
                    peopleYouMayKnowHScrollComponentSpec = (PeopleYouMayKnowHScrollComponentSpec) a3.a(f24911b);
                } else {
                    peopleYouMayKnowHScrollComponentSpec = f24910a;
                }
                if (peopleYouMayKnowHScrollComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m26685a();
                        if (a3 != null) {
                            a3.a(f24911b, a2);
                        } else {
                            f24910a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = peopleYouMayKnowHScrollComponentSpec;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
