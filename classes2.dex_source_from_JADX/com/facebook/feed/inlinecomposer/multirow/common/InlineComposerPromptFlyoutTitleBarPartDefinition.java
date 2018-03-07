package com.facebook.feed.inlinecomposer.multirow.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.inlinecomposer.v2attachment.CanRenderV2Prompt;
import com.facebook.feed.inlinecomposer.v2attachment.V2PromptUtil;
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
import com.facebook.productionprompts.common.views.HasPromptTitleBar;
import com.facebook.resources.utils.TextViewUtils;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: mqtt_status */
public class InlineComposerPromptFlyoutTitleBarPartDefinition<V extends View & HasPromptTitleBar, E extends HasContext> extends BaseSinglePartDefinition<Props, State, E, V> {
    private static InlineComposerPromptFlyoutTitleBarPartDefinition f13252b;
    private static final Object f13253c = new Object();
    private final V2PromptUtil f13254a;

    /* compiled from: mqtt_status */
    public class Props {
        public final CanRenderV2Prompt f19755a;

        public Props(CanRenderV2Prompt canRenderV2Prompt) {
            this.f19755a = canRenderV2Prompt;
        }
    }

    /* compiled from: mqtt_status */
    public class State {
        public final String f19767a;
        public final String f19768b;
        public final Drawable f19769c;
        public final Drawable f19770d;
        public final int f19771e;

        public State(String str, String str2, Drawable drawable, Drawable drawable2, int i) {
            this.f19767a = str;
            this.f19768b = str2;
            this.f19769c = drawable;
            this.f19770d = drawable2;
            this.f19771e = i;
        }
    }

    private static InlineComposerPromptFlyoutTitleBarPartDefinition m19506b(InjectorLike injectorLike) {
        return new InlineComposerPromptFlyoutTitleBarPartDefinition(V2PromptUtil.m18713b(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String b;
        Drawable a;
        String str;
        Drawable drawable = null;
        CanRenderV2Prompt canRenderV2Prompt = ((Props) obj).f19755a;
        int i = 0;
        if (canRenderV2Prompt != null) {
            Integer valueOf;
            if (canRenderV2Prompt.mo2627c() == null) {
                valueOf = Integer.valueOf(this.f13254a.f12621a.getResources().getColor(2131361917));
            } else {
                valueOf = canRenderV2Prompt.mo2627c();
            }
            i = valueOf.intValue();
            String a2 = canRenderV2Prompt.mo2625a() == null ? "" : canRenderV2Prompt.mo2625a();
            b = canRenderV2Prompt.mo2626b() == null ? "" : canRenderV2Prompt.mo2626b();
            a = m19503a(canRenderV2Prompt.mo2628d());
            drawable = m19503a(canRenderV2Prompt.mo2629e());
            str = b;
            b = a2;
        } else {
            a = null;
            str = null;
            b = null;
        }
        return new State(b, str, a, drawable, i);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -768715745);
        m19505a((Props) obj, (State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, 948626707, a);
    }

    public static InlineComposerPromptFlyoutTitleBarPartDefinition m19504a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerPromptFlyoutTitleBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13253c) {
                InlineComposerPromptFlyoutTitleBarPartDefinition inlineComposerPromptFlyoutTitleBarPartDefinition;
                if (a2 != null) {
                    inlineComposerPromptFlyoutTitleBarPartDefinition = (InlineComposerPromptFlyoutTitleBarPartDefinition) a2.mo818a(f13253c);
                } else {
                    inlineComposerPromptFlyoutTitleBarPartDefinition = f13252b;
                }
                if (inlineComposerPromptFlyoutTitleBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19506b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13253c, b3);
                        } else {
                            f13252b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerPromptFlyoutTitleBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public InlineComposerPromptFlyoutTitleBarPartDefinition(V2PromptUtil v2PromptUtil) {
        this.f13254a = v2PromptUtil;
    }

    private static void m19505a(Props props, State state, V v) {
        int i = 8;
        if (props.f19755a != null) {
            TextView promptTitleView = ((HasPromptTitleBar) v).getPromptTitleView();
            promptTitleView.setVisibility(Strings.isNullOrEmpty(state.f19767a) ? 8 : 0);
            promptTitleView.setText(state.f19767a);
            TextView promptSubtitleView = ((HasPromptTitleBar) v).getPromptSubtitleView();
            if (state.f19768b.length() != 0) {
                i = 0;
            }
            promptSubtitleView.setVisibility(i);
            promptSubtitleView.setTransformationMethod(null);
            promptSubtitleView.setText(state.f19768b);
            promptSubtitleView.setTextColor(state.f19771e);
            if (state.f19769c != null) {
                TextViewUtils.b(promptSubtitleView, state.f19769c, null, null, null);
            }
            if (state.f19770d != null) {
                TextViewUtils.b(promptSubtitleView, null, null, state.f19770d, null);
            }
        }
    }

    private static Drawable m19503a(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        return drawable;
    }
}
