package com.facebook.feedplugins.graphqlstory.inlinecomments;

import android.content.Context;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.styling.animators.FeedAnimators;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: inbox */
public class InlineRowAnimator {
    private static InlineRowAnimator f20248c;
    private static final Object f20249d = new Object();
    public final FeedAnimators f20250a;
    public final DefaultAndroidThreadUtil f20251b;

    private static InlineRowAnimator m27918b(InjectorLike injectorLike) {
        return new InlineRowAnimator(FeedAnimators.m27920a(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike));
    }

    @Inject
    public InlineRowAnimator(FeedAnimators feedAnimators, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f20250a = feedAnimators;
        this.f20251b = defaultAndroidThreadUtil;
    }

    public static InlineRowAnimator m27917a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineRowAnimator b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20249d) {
                InlineRowAnimator inlineRowAnimator;
                if (a2 != null) {
                    inlineRowAnimator = (InlineRowAnimator) a2.mo818a(f20249d);
                } else {
                    inlineRowAnimator = f20248c;
                }
                if (inlineRowAnimator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27918b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20249d, b3);
                        } else {
                            f20248c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineRowAnimator;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
