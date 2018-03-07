package com.facebook.goodfriends.prompt;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.environment.HasContext;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;

@ContextScoped
/* compiled from: mqtt_client_nonsticky_subscription_data */
public class InlineComposerGoodFriendsPromptPartDefinition<V extends View> extends BaseSinglePartDefinition<Void, State, HasContext, V> {
    private static InlineComposerGoodFriendsPromptPartDefinition f13264c;
    private static final Object f13265d = new Object();
    private Runnable f13266a;
    public final GoodFriendsPromptController f13267b;

    private static InlineComposerGoodFriendsPromptPartDefinition m19524b(InjectorLike injectorLike) {
        return new InlineComposerGoodFriendsPromptPartDefinition((Context) injectorLike.getInstance(Context.class), new GoodFriendsPromptController(FbSharedPreferencesImpl.m1826a(injectorLike)));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Tooltip tooltip;
        Context context = ((HasContext) anyEnvironment).getContext();
        if (this.f13267b.m19528a()) {
            Tooltip tooltip2 = new Tooltip(context, 2);
            tooltip2.a(context.getResources().getString(2131236171));
            tooltip2.t = -1;
            tooltip2.a(Position.ABOVE);
            tooltip = tooltip2;
        } else {
            tooltip = null;
        }
        return new State(tooltip);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        Void voidR = (Void) obj;
        State state = (State) obj2;
        HasContext hasContext = (HasContext) anyEnvironment;
        if (this.f13266a != null) {
            view.removeCallbacks(this.f13266a);
        }
        if (state.a != null) {
            state.a.l();
        }
        this.f13266a = null;
        state.a = null;
        super.mo2544b(voidR, state, hasContext, view);
    }

    @Inject
    public InlineComposerGoodFriendsPromptPartDefinition(Context context, GoodFriendsPromptController goodFriendsPromptController) {
        this.f13267b = goodFriendsPromptController;
    }

    public static InlineComposerGoodFriendsPromptPartDefinition m19522a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerGoodFriendsPromptPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13265d) {
                InlineComposerGoodFriendsPromptPartDefinition inlineComposerGoodFriendsPromptPartDefinition;
                if (a2 != null) {
                    inlineComposerGoodFriendsPromptPartDefinition = (InlineComposerGoodFriendsPromptPartDefinition) a2.mo818a(f13265d);
                } else {
                    inlineComposerGoodFriendsPromptPartDefinition = f13264c;
                }
                if (inlineComposerGoodFriendsPromptPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19524b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13265d, b3);
                        } else {
                            f13264c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerGoodFriendsPromptPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private void m19523a(Void voidR, State state, HasContext hasContext, V v) {
        super.mo2543a(voidR, state, hasContext, v);
        if (this.f13267b.m19528a() && state.a != null && v.getVisibility() == 0) {
            this.f13266a = new 1(this, state, v);
            v.post(this.f13266a);
        }
    }
}
