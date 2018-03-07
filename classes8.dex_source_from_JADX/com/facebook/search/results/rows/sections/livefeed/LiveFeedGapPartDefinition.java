package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: PmaPageFirstPostsByOthersStoriesSequence */
public class LiveFeedGapPartDefinition extends MultiRowSinglePartDefinition<GraphQLStory, Void, AnyEnvironment, View> {
    public static final ViewType f24439a = new C25811();
    private static LiveFeedGapPartDefinition f24440b;
    private static final Object f24441c = new Object();

    /* compiled from: PmaPageFirstPostsByOthersStoriesSequence */
    final class C25811 extends ViewType {
        C25811() {
        }

        public final View m27913a(Context context) {
            return LayoutInflater.from(context).inflate(2130905069, null);
        }
    }

    private static LiveFeedGapPartDefinition m27915c() {
        return new LiveFeedGapPartDefinition();
    }

    public final ViewType m27916a() {
        return f24439a;
    }

    public final boolean m27917a(Object obj) {
        return true;
    }

    public static LiveFeedGapPartDefinition m27914a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedGapPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24441c) {
                LiveFeedGapPartDefinition liveFeedGapPartDefinition;
                if (a2 != null) {
                    liveFeedGapPartDefinition = (LiveFeedGapPartDefinition) a2.a(f24441c);
                } else {
                    liveFeedGapPartDefinition = f24440b;
                }
                if (liveFeedGapPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m27915c();
                        if (a2 != null) {
                            a2.a(f24441c, c);
                        } else {
                            f24440b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = liveFeedGapPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
