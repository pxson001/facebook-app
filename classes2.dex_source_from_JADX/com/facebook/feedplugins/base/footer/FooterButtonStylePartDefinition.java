package com.facebook.feedplugins.base.footer;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.ufi.UFIFooterButtonStyleDefinition.FooterLayoutType;
import com.facebook.feed.ufi.UFIParams;
import com.facebook.feed.ufi.UFIParams.I18nStyleType;
import com.facebook.feed.ufi.UFIStyle;
import com.facebook.feed.ufi.UFIStyleProvider;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.feedplugins.base.footer.ui.Footer;
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
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: get_payment_methods_Info */
public class FooterButtonStylePartDefinition<V extends View & Footer> extends BaseSinglePartDefinition<Props, State, AnyEnvironment, V> {
    private static FooterButtonStylePartDefinition f22432e;
    private static final Object f22433f = new Object();
    private final FeedRenderUtils f22434a;
    private final Resources f22435b;
    @Nullable
    private UFIStyleProvider f22436c;
    @Nullable
    private UFIStyle f22437d;

    /* compiled from: get_payment_methods_Info */
    public class Props {
        public final boolean f22448a;
        public final boolean f22449b;
        public final boolean f22450c;
        public final FooterBackgroundStyleDefinition f22451d;

        public Props(boolean z, boolean z2, boolean z3, FooterBackgroundStyleDefinition footerBackgroundStyleDefinition) {
            this.f22448a = z;
            this.f22449b = z2;
            this.f22450c = z3;
            this.f22451d = footerBackgroundStyleDefinition;
        }
    }

    /* compiled from: get_payment_methods_Info */
    public class State {
        public final boolean f22486a;
        public final float[] f22487b;

        public State(boolean z, float[] fArr) {
            this.f22486a = z;
            this.f22487b = fArr;
        }
    }

    private static FooterButtonStylePartDefinition m30337b(InjectorLike injectorLike) {
        return new FooterButtonStylePartDefinition(FeedRenderUtils.m14652a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike), (UFIStyleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(UFIStyleProvider.class));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        UFIParams a = m30339a().m30347a(props.f22448a, props.f22449b, props.f22450c);
        I18nStyleType a2 = a.m30353a(m30338a(props.f22451d));
        return new State(I18nStyleType.hasIcons(a2), a.m30355a(a2));
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1057134614);
        m30336a((State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -719747048, a);
    }

    public static FooterButtonStylePartDefinition m30335a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FooterButtonStylePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f22433f) {
                FooterButtonStylePartDefinition footerButtonStylePartDefinition;
                if (a2 != null) {
                    footerButtonStylePartDefinition = (FooterButtonStylePartDefinition) a2.mo818a(f22433f);
                } else {
                    footerButtonStylePartDefinition = f22432e;
                }
                if (footerButtonStylePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m30337b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f22433f, b3);
                        } else {
                            f22432e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = footerButtonStylePartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FooterButtonStylePartDefinition(FeedRenderUtils feedRenderUtils, Resources resources, UFIStyleProvider uFIStyleProvider) {
        this.f22434a = feedRenderUtils;
        this.f22435b = resources;
        this.f22436c = uFIStyleProvider;
    }

    private static void m30336a(State state, V v) {
        ((Footer) v).setButtonWeights(state.f22487b);
        ((Footer) v).setShowIcons(state.f22486a);
    }

    @VisibleForTesting
    public final int m30338a(FooterBackgroundStyleDefinition footerBackgroundStyleDefinition) {
        return this.f22434a.m14654a() - (SizeUtil.m19192a(this.f22435b, footerBackgroundStyleDefinition.f18971c.f18966a) * 2);
    }

    public final UFIStyle m30339a() {
        if (this.f22436c != null) {
            this.f22437d = this.f22436c.m30342a(FooterLayoutType.INLINE);
            this.f22436c = null;
        }
        return this.f22437d;
    }
}
