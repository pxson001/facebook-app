package com.facebook.events.permalink.multirow;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.events.permalink.adapters.EventPermalinkItemCollection;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: batch_app_id */
public class PostingStoryProgressBarRootPartDefinition extends MultiRowSinglePartDefinition<Object, Void, AnyEnvironment, View> {
    public static final ViewType f18715a = ViewType.a(2130904082);
    private static PostingStoryProgressBarRootPartDefinition f18716b;
    private static final Object f18717c = new Object();

    private static PostingStoryProgressBarRootPartDefinition m19005b() {
        return new PostingStoryProgressBarRootPartDefinition();
    }

    public final boolean m19007a(Object obj) {
        return obj == EventPermalinkItemCollection.f18163a;
    }

    public final ViewType<View> m19006a() {
        return f18715a;
    }

    public static PostingStoryProgressBarRootPartDefinition m19004a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PostingStoryProgressBarRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18717c) {
                PostingStoryProgressBarRootPartDefinition postingStoryProgressBarRootPartDefinition;
                if (a2 != null) {
                    postingStoryProgressBarRootPartDefinition = (PostingStoryProgressBarRootPartDefinition) a2.a(f18717c);
                } else {
                    postingStoryProgressBarRootPartDefinition = f18716b;
                }
                if (postingStoryProgressBarRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m19005b();
                        if (a2 != null) {
                            a2.a(f18717c, b3);
                        } else {
                            f18716b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = postingStoryProgressBarRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
