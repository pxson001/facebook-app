package com.facebook.feedplugins.storyset.rows.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.sections.header.components.HeaderComponentLayouts;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: assisted_reg_send_invite_with_source */
public class StorySetPageHeaderComponentSpec<E extends HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher & HasRowKey & HasContext> {
    private static StorySetPageHeaderComponentSpec f9838b;
    private static final Object f9839c = new Object();
    public final HeaderComponentLayouts<E> f9840a;

    private static StorySetPageHeaderComponentSpec m10247b(InjectorLike injectorLike) {
        return new StorySetPageHeaderComponentSpec(HeaderComponentLayouts.b(injectorLike));
    }

    @Inject
    public StorySetPageHeaderComponentSpec(HeaderComponentLayouts headerComponentLayouts) {
        this.f9840a = headerComponentLayouts;
    }

    public static StorySetPageHeaderComponentSpec m10246a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetPageHeaderComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9839c) {
                StorySetPageHeaderComponentSpec storySetPageHeaderComponentSpec;
                if (a2 != null) {
                    storySetPageHeaderComponentSpec = (StorySetPageHeaderComponentSpec) a2.a(f9839c);
                } else {
                    storySetPageHeaderComponentSpec = f9838b;
                }
                if (storySetPageHeaderComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10247b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9839c, b3);
                        } else {
                            f9838b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetPageHeaderComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
