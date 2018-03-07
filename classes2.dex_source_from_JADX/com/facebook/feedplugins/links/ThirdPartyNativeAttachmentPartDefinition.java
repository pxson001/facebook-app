package com.facebook.feedplugins.links;

import android.content.Context;
import android.view.View;
import com.facebook.browser.lite.BrowserLiteIntentServiceHelper.BrowserProcessWarmupRunnable;
import com.facebook.browser.prefetch.BrowserPrefetcher;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_sticker_packs_by_id */
public class ThirdPartyNativeAttachmentPartDefinition<E extends HasInvalidate> extends BaseSinglePartDefinition<Props, State, E, View> {
    private static ThirdPartyNativeAttachmentPartDefinition f23924e;
    private static final Object f23925f = new Object();
    public final BrowserPrefetcher f23926a;
    public final GatekeeperStoreImpl f23927b;
    private final ArticlePrefetchingPartDefinition f23928c;
    public final ThirdPartyNativeAttachmentClickHandler f23929d;

    private static ThirdPartyNativeAttachmentPartDefinition m32308b(InjectorLike injectorLike) {
        return new ThirdPartyNativeAttachmentPartDefinition(BrowserPrefetcher.m14282a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), ArticlePrefetchingPartDefinition.m32246a(injectorLike), ThirdPartyNativeAttachmentClickHandler.m32312a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        BrowserProcessWarmupRunnable browserProcessWarmupRunnable;
        Props props = (Props) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        subParts.mo2756a(this.f23928c, props.b);
        1 1 = new 1(this, props, hasInvalidate);
        if (this.f23927b.m2185a(117) == TriState.NO) {
            browserProcessWarmupRunnable = null;
        } else {
            browserProcessWarmupRunnable = new BrowserProcessWarmupRunnable();
        }
        return new State(1, browserProcessWarmupRunnable);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2119278945);
        State state = (State) obj2;
        View a2 = m32306a((Props) obj, view);
        if (a2 != null) {
            a2.setOnClickListener(state.a);
        }
        if (view != null) {
            Context applicationContext = view.getContext().getApplicationContext();
            BrowserProcessWarmupRunnable browserProcessWarmupRunnable = state.b;
            if (browserProcessWarmupRunnable != null) {
                browserProcessWarmupRunnable.a = applicationContext;
                HandlerDetour.b(this.f23926a.f9324j, browserProcessWarmupRunnable, 2000, 1215591707);
            }
        }
        Logger.a(8, EntryType.MARK_POP, 138574007, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        View a = m32306a((Props) obj, view);
        if (a != null) {
            a.setOnClickListener(null);
        }
        BrowserProcessWarmupRunnable browserProcessWarmupRunnable = state.b;
        if (browserProcessWarmupRunnable != null) {
            HandlerDetour.a(this.f23926a.f9324j, browserProcessWarmupRunnable);
        }
    }

    public static ThirdPartyNativeAttachmentPartDefinition m32307a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThirdPartyNativeAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23925f) {
                ThirdPartyNativeAttachmentPartDefinition thirdPartyNativeAttachmentPartDefinition;
                if (a2 != null) {
                    thirdPartyNativeAttachmentPartDefinition = (ThirdPartyNativeAttachmentPartDefinition) a2.mo818a(f23925f);
                } else {
                    thirdPartyNativeAttachmentPartDefinition = f23924e;
                }
                if (thirdPartyNativeAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32308b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23925f, b3);
                        } else {
                            f23924e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = thirdPartyNativeAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ThirdPartyNativeAttachmentPartDefinition(BrowserPrefetcher browserPrefetcher, GatekeeperStoreImpl gatekeeperStoreImpl, ArticlePrefetchingPartDefinition articlePrefetchingPartDefinition, ThirdPartyNativeAttachmentClickHandler thirdPartyNativeAttachmentClickHandler) {
        this.f23926a = browserPrefetcher;
        this.f23927b = gatekeeperStoreImpl;
        this.f23928c = articlePrefetchingPartDefinition;
        this.f23929d = thirdPartyNativeAttachmentClickHandler;
    }

    public static View m32306a(Props props, View view) {
        return props.d.mo3509a(view);
    }
}
