package com.facebook.feed.inlinecomposer.multirow.common;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: mutateAndDeleteInSingleTransaction */
public class InlineComposerExposedBackgroundPartDefinition<E extends HasNextDefinitionInfo & HasPreviousDefinitionInfo> extends BaseSinglePartDefinition<Props, State, E, View> {
    private static InlineComposerExposedBackgroundPartDefinition f13169c;
    private static final Object f13170d = new Object();
    private final Resources f13171a;
    private final PromptsExperimentHelper f13172b;

    @Immutable
    /* compiled from: mutateAndDeleteInSingleTransaction */
    public class Props {
        public final boolean f14302a;
        public final boolean f14303b;
        public final boolean f14304c;
        public final boolean f14305d;

        public Props(boolean z, boolean z2, boolean z3, boolean z4) {
            this.f14302a = z;
            this.f14303b = z2;
            this.f14304c = z3;
            this.f14305d = z4;
        }

        public static Props m20687a(boolean z) {
            return new Props(false, false, false, z);
        }

        public static Props m20688b(boolean z) {
            return new Props(false, false, true, z);
        }
    }

    /* compiled from: mutateAndDeleteInSingleTransaction */
    public class State {
        public final int f14314a;
        public final int f14315b;
        public final int f14316c;
        public final int f14317d;

        public State(int i, int i2, int i3, int i4) {
            this.f14314a = i;
            this.f14315b = i2;
            this.f14316c = i3;
            this.f14317d = i4;
        }
    }

    private static InlineComposerExposedBackgroundPartDefinition m19367b(InjectorLike injectorLike) {
        return new InlineComposerExposedBackgroundPartDefinition(ResourcesMethodAutoProvider.m6510a(injectorLike), PromptsExperimentHelper.m15312b(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        int i2;
        Props props = (Props) obj;
        InlineComposerEnvironment inlineComposerEnvironment = (InlineComposerEnvironment) anyEnvironment;
        boolean z = inlineComposerEnvironment.f12854t;
        boolean z2 = inlineComposerEnvironment.f12853s;
        int i3 = (!this.f13172b.m15314c() || props.f14305d) ? z ? z2 ? 2130840258 : 2130840256 : z2 ? 2130840259 : 2130840257 : 2130840257;
        int i4 = i3;
        int dimensionPixelSize = props.f14303b ? this.f13171a.getDimensionPixelSize(2131427645) : 0;
        int dimensionPixelSize2 = this.f13171a.getDimensionPixelSize(2131427416);
        int dimensionPixelSize3 = this.f13171a.getDimensionPixelSize(2131427594);
        if (props.f14302a) {
            i = dimensionPixelSize2;
        } else {
            i = 0;
        }
        i += dimensionPixelSize3;
        if (!props.f14304c) {
            dimensionPixelSize2 = 0;
        }
        dimensionPixelSize2 += dimensionPixelSize3;
        if (z) {
            i2 = i - dimensionPixelSize3;
        } else {
            i2 = i;
        }
        if (this.f13172b.m15314c()) {
            if (props.f14305d) {
                i = dimensionPixelSize2 - dimensionPixelSize3;
            }
            i = dimensionPixelSize2;
        } else {
            if (z2) {
                i = dimensionPixelSize2 - dimensionPixelSize3;
            }
            i = dimensionPixelSize2;
        }
        return new State(i4, dimensionPixelSize, i2, i);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1317364387);
        State state = (State) obj2;
        view.setBackgroundResource(state.f14314a);
        view.setPadding(state.f14315b, state.f14316c, state.f14315b, state.f14317d);
        Logger.a(8, EntryType.MARK_POP, -2102268472, a);
    }

    public static InlineComposerExposedBackgroundPartDefinition m19366a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerExposedBackgroundPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13170d) {
                InlineComposerExposedBackgroundPartDefinition inlineComposerExposedBackgroundPartDefinition;
                if (a2 != null) {
                    inlineComposerExposedBackgroundPartDefinition = (InlineComposerExposedBackgroundPartDefinition) a2.mo818a(f13170d);
                } else {
                    inlineComposerExposedBackgroundPartDefinition = f13169c;
                }
                if (inlineComposerExposedBackgroundPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19367b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13170d, b3);
                        } else {
                            f13169c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerExposedBackgroundPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public InlineComposerExposedBackgroundPartDefinition(Resources resources, PromptsExperimentHelper promptsExperimentHelper) {
        this.f13171a = resources;
        this.f13172b = promptsExperimentHelper;
    }
}
