package com.facebook.feed.rows.animations;

import android.content.Context;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.environment.HasPersistentState;
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
import com.facebook.ui.animations.persistent.PersistentAnimation;
import com.facebook.ui.animations.persistent.PersistentAnimationBuilder;
import com.facebook.ui.animations.persistent.PersistentAnimations;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: multimedia_upload_op */
public class AnimationsPartDefinition<D, V extends View> extends BaseSinglePartDefinition<Props<D, V>, State<D>, HasPersistentState, V> {
    private static AnimationsPartDefinition f13196c;
    private static final Object f13197d = new Object();
    public final Clock f13198a;
    private final AbstractFbErrorReporter f13199b;

    private static AnimationsPartDefinition m19404b(InjectorLike injectorLike) {
        return new AnimationsPartDefinition(FbErrorReporterImpl.m2317a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        return new State((PersistentState) ((HasPersistentState) anyEnvironment).mo2425a(new 1(this, props), props.b));
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -257028508);
        m19403a((Props) obj, (State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, 636403685, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        if (state.b == null) {
            this.f13199b.m2340a(getClass().getSimpleName(), "T7742735: unbind() called without matching bind()");
            return;
        }
        PersistentAnimations persistentAnimations = state.b;
        persistentAnimations.g = true;
        if (persistentAnimations.e != null) {
            persistentAnimations.e.cancel();
        }
        PersistentAnimations.c(persistentAnimations);
        state.b = null;
    }

    public static AnimationsPartDefinition m19402a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AnimationsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13197d) {
                AnimationsPartDefinition animationsPartDefinition;
                if (a2 != null) {
                    animationsPartDefinition = (AnimationsPartDefinition) a2.mo818a(f13197d);
                } else {
                    animationsPartDefinition = f13196c;
                }
                if (animationsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19404b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13197d, b3);
                        } else {
                            f13196c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = animationsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public AnimationsPartDefinition(AbstractFbErrorReporter abstractFbErrorReporter, Clock clock) {
        this.f13199b = abstractFbErrorReporter;
        this.f13198a = clock;
    }

    private void m19403a(Props<D, V> props, State<D> state, V v) {
        PersistentState persistentState = state.a;
        if (persistentState.a == null) {
            Object obj;
            if (props.d == null) {
                obj = props.c;
            } else {
                obj = props.d;
            }
            persistentState.a = obj;
        }
        Object obj2 = persistentState.a;
        Object obj3 = props.c;
        PersistentAnimationBuilder a = PersistentAnimationBuilder.a(this.f13198a);
        long a2 = m19400a(persistentState, a);
        AnimationBuilder animationBuilder = props.e;
        List arrayList = new ArrayList();
        animationBuilder.mo2759a(arrayList, obj2, obj3, v);
        a.c = new 2(this, animationBuilder, obj2, obj3, v, a2, m19401a(a, arrayList), persistentState);
        state.b = a.a();
        state.b.a();
    }

    private long m19400a(PersistentState persistentState, PersistentAnimationBuilder persistentAnimationBuilder) {
        long a = ((persistentState.b > 0 ? 1 : (persistentState.b == 0 ? 0 : -1)) != 0 ? 1 : null) != null ? persistentState.b : this.f13198a.mo211a();
        persistentState.b = a;
        persistentAnimationBuilder.d = a;
        return a;
    }

    private static long m19401a(PersistentAnimationBuilder persistentAnimationBuilder, List<PersistentAnimation> list) {
        long j = 0;
        for (int i = 0; i < list.size(); i++) {
            PersistentAnimation persistentAnimation = (PersistentAnimation) list.get(i);
            j += persistentAnimation.a();
            persistentAnimationBuilder.b.add(persistentAnimation);
        }
        return j;
    }
}
