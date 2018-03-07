package com.facebook.feed.rows.sections.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.ui.FlyoutLauncher;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;
import javax.inject.Provider;

@LayoutSpec
@ContextScoped
/* compiled from: id_backed_privacy_checkup/checkup_id=%s */
public class FeedStoryMessageFlyoutComponentSpec {
    private static FeedStoryMessageFlyoutComponentSpec f20608c;
    private static final Object f20609d = new Object();
    public final Provider<Boolean> f20610a;
    public final FlyoutLauncher f20611b;

    private static FeedStoryMessageFlyoutComponentSpec m28356b(InjectorLike injectorLike) {
        return new FeedStoryMessageFlyoutComponentSpec(IdBasedProvider.m1811a(injectorLike, 4008), FlyoutLauncher.m28357a(injectorLike));
    }

    @Inject
    public FeedStoryMessageFlyoutComponentSpec(Provider<Boolean> provider, FlyoutLauncher flyoutLauncher) {
        this.f20610a = provider;
        this.f20611b = flyoutLauncher;
    }

    public static FeedStoryMessageFlyoutComponentSpec m28355a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedStoryMessageFlyoutComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20609d) {
                FeedStoryMessageFlyoutComponentSpec feedStoryMessageFlyoutComponentSpec;
                if (a2 != null) {
                    feedStoryMessageFlyoutComponentSpec = (FeedStoryMessageFlyoutComponentSpec) a2.mo818a(f20609d);
                } else {
                    feedStoryMessageFlyoutComponentSpec = f20608c;
                }
                if (feedStoryMessageFlyoutComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28356b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20609d, b3);
                        } else {
                            f20608c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedStoryMessageFlyoutComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
