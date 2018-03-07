package com.facebook.friendsharing.souvenirs.prompt.v3;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.inlinecomposer.multirow.common.BaseV3PromptPartDefinition;
import com.facebook.feed.inlinecomposer.multirow.common.BaseV3PromptPartDefinition.Props;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.friendsharing.souvenirs.manager.SouvenirPromptManager;
import com.facebook.friendsharing.souvenirs.prompt.SouvenirPromptTitleGenerator;
import com.facebook.friendsharing.souvenirs.prompt.model.SouvenirPromptObject;
import com.facebook.friendsharing.souvenirs.util.SouvenirsLogger;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.productionprompts.common.v3.ProductionPromptSmallView;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.PromptObject;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RELATIVE */
public class SouvenirPromptSmallPartDefinition<E extends HasPositionInformation & PromptViewStateUpdater & HasContext> extends MultiRowSinglePartDefinition<PromptPartDefinitionProps, State, E, ProductionPromptSmallView> {
    public static final ViewType f24133a = new C21031();
    public static final CallerContext f24134b = CallerContext.a(SouvenirPromptSmallPartDefinition.class);
    private static SouvenirPromptSmallPartDefinition f24135g;
    private static final Object f24136h = new Object();
    private final SouvenirPromptTitleGenerator f24137c;
    public final SouvenirsLogger f24138d;
    public final SouvenirPromptManager f24139e;
    private final BaseV3PromptPartDefinition f24140f;

    /* compiled from: RELATIVE */
    final class C21031 extends ViewType {
        C21031() {
        }

        public final View m26257a(Context context) {
            return new ProductionPromptSmallView(context);
        }
    }

    /* compiled from: RELATIVE */
    public class State {
        public final Uri f24129a;
        public final String f24130b;
        public final SpannableStringBuilder f24131c;
        public boolean f24132d = false;

        public State(Uri uri, String str, SpannableStringBuilder spannableStringBuilder) {
            this.f24129a = uri;
            this.f24130b = str;
            this.f24131c = spannableStringBuilder;
        }
    }

    private static SouvenirPromptSmallPartDefinition m26259b(InjectorLike injectorLike) {
        return new SouvenirPromptSmallPartDefinition(SouvenirPromptTitleGenerator.b(injectorLike), SouvenirsLogger.b(injectorLike), SouvenirPromptManager.a(injectorLike), BaseV3PromptPartDefinition.m22760a(injectorLike));
    }

    public final Object m26261a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        subParts.a(this.f24140f, Props.m22759a(promptPartDefinitionProps));
        SouvenirPromptObject souvenirPromptObject = (SouvenirPromptObject) promptPartDefinitionProps.a.a;
        return new State(souvenirPromptObject.m26256e(), this.f24137c.a(souvenirPromptObject), this.f24137c.a(((HasContext) hasPositionInformation).getContext().getResources(), ((HasContext) hasPositionInformation).getContext().getString(2131238467)));
    }

    public final /* bridge */ /* synthetic */ void m26262a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1815957251);
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        State state = (State) obj2;
        ((ProductionPromptSmallView) view).a(state.f24129a, f24134b);
        PromptObject a2 = InlineComposerPromptSession.a(promptPartDefinitionProps.a);
        Preconditions.checkArgument(a2 instanceof SouvenirPromptObject, "Didn't get a souvenir prompt object");
        SouvenirPromptObject souvenirPromptObject = (SouvenirPromptObject) a2;
        if (!state.f24132d) {
            this.f24138d.b(souvenirPromptObject);
            this.f24139e.a(a2.b());
            state.f24132d = true;
        }
        Logger.a(8, EntryType.MARK_POP, -2128400252, a);
    }

    public final boolean m26263a(Object obj) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        return (promptPartDefinitionProps == null || promptPartDefinitionProps.a == null || promptPartDefinitionProps.a.a == null || !(promptPartDefinitionProps.a.a instanceof SouvenirPromptObject)) ? false : true;
    }

    public static SouvenirPromptSmallPartDefinition m26258a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SouvenirPromptSmallPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24136h) {
                SouvenirPromptSmallPartDefinition souvenirPromptSmallPartDefinition;
                if (a2 != null) {
                    souvenirPromptSmallPartDefinition = (SouvenirPromptSmallPartDefinition) a2.a(f24136h);
                } else {
                    souvenirPromptSmallPartDefinition = f24135g;
                }
                if (souvenirPromptSmallPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26259b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24136h, b3);
                        } else {
                            f24135g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = souvenirPromptSmallPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SouvenirPromptSmallPartDefinition(SouvenirPromptTitleGenerator souvenirPromptTitleGenerator, SouvenirsLogger souvenirsLogger, SouvenirPromptManager souvenirPromptManager, BaseV3PromptPartDefinition baseV3PromptPartDefinition) {
        this.f24137c = souvenirPromptTitleGenerator;
        this.f24138d = souvenirsLogger;
        this.f24139e = souvenirPromptManager;
        this.f24140f = baseV3PromptPartDefinition;
    }

    public final ViewType<ProductionPromptSmallView> m26260a() {
        return f24133a;
    }
}
