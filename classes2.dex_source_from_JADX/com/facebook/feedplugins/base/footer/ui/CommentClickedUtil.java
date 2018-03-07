package com.facebook.feedplugins.base.footer.ui;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.ui.FlyoutLauncher;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: has_seen_deactivations_nux */
public class CommentClickedUtil {
    private static CommentClickedUtil f21291c;
    private static final Object f21292d = new Object();
    public final FlyoutLauncher f21293a;
    public final FeedEventBus f21294b;

    private static CommentClickedUtil m28993b(InjectorLike injectorLike) {
        return new CommentClickedUtil(FlyoutLauncher.m28357a(injectorLike), FeedEventBus.m4573a(injectorLike));
    }

    @Inject
    public CommentClickedUtil(FlyoutLauncher flyoutLauncher, FeedEventBus feedEventBus) {
        this.f21293a = flyoutLauncher;
        this.f21294b = feedEventBus;
    }

    public static CommentClickedUtil m28992a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommentClickedUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21292d) {
                CommentClickedUtil commentClickedUtil;
                if (a2 != null) {
                    commentClickedUtil = (CommentClickedUtil) a2.mo818a(f21292d);
                } else {
                    commentClickedUtil = f21291c;
                }
                if (commentClickedUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28993b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21292d, b3);
                        } else {
                            f21291c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = commentClickedUtil;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
