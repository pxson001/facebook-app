package com.facebook.feed.inlinecomposer.multirow;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.android.FragmentActivityMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.inlinecomposer.logging.InlineComposerLogger;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.composer.launch.FeedComposerLauncherProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: pages_public_view */
public class ScrollAwayComposerController {
    private static ScrollAwayComposerController f10405h;
    private static final Object f10406i = new Object();
    public final Context f10407a;
    public final QeAccessor f10408b;
    public final FragmentActivity f10409c;
    public final GlyphColorizer f10410d;
    public final InlineComposerLogger f10411e;
    public final LoggedInUserSessionManager f10412f;
    public final FeedComposerLauncherProvider f10413g;

    private static ScrollAwayComposerController m15503b(InjectorLike injectorLike) {
        return new ScrollAwayComposerController((Context) injectorLike.getInstance(Context.class), QeInternalImplMethodAutoProvider.m3744a(injectorLike), FragmentActivityMethodAutoProvider.m15506b(injectorLike), GlyphColorizer.m11486a(injectorLike), InlineComposerLogger.m15507a(injectorLike), LoggedInUserSessionManager.m2511a(injectorLike), (FeedComposerLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedComposerLauncherProvider.class));
    }

    @Inject
    public ScrollAwayComposerController(Context context, QeAccessor qeAccessor, FragmentActivity fragmentActivity, GlyphColorizer glyphColorizer, InlineComposerLogger inlineComposerLogger, LoggedInUserSessionManager loggedInUserSessionManager, FeedComposerLauncherProvider feedComposerLauncherProvider) {
        this.f10407a = context;
        this.f10408b = qeAccessor;
        this.f10409c = fragmentActivity;
        this.f10410d = glyphColorizer;
        this.f10411e = inlineComposerLogger;
        this.f10412f = loggedInUserSessionManager;
        this.f10413g = feedComposerLauncherProvider;
    }

    public final boolean m15504a() {
        return this.f10408b.mo596a(ExperimentsForFeedUtilComposerAbtestModule.aj, false);
    }

    public static ScrollAwayComposerController m15502a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ScrollAwayComposerController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f10406i) {
                ScrollAwayComposerController scrollAwayComposerController;
                if (a2 != null) {
                    scrollAwayComposerController = (ScrollAwayComposerController) a2.mo818a(f10406i);
                } else {
                    scrollAwayComposerController = f10405h;
                }
                if (scrollAwayComposerController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m15503b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f10406i, b3);
                        } else {
                            f10405h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = scrollAwayComposerController;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
