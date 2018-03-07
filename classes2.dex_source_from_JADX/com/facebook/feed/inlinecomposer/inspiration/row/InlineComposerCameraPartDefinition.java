package com.facebook.feed.inlinecomposer.inspiration.row;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.inlinecomposer.inspiration.abtest.ExperimentsForInspirationAbTestModule;
import com.facebook.feed.inlinecomposer.inspiration.view.InlineComposerCameraView;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.creativecam.CreativeCamLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.creativecam.activity.CreativeCamLauncherImpl;
import com.facebook.photos.creativeediting.analytics.BaseCreativeEditingUsageLoggerEventListener;
import com.facebook.photos.creativeediting.swipeable.common.FramesAggregator;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableController;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableControllerProvider;
import com.facebook.photos.creativeediting.swipeable.composer.SwipeableDraweeControllerGeneratorImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ultralight.Inject;
import com.google.common.base.Preconditions;
import javax.inject.Provider;

@ContextScoped
/* compiled from: mp_init_in_background_thread */
public class InlineComposerCameraPartDefinition<E extends HasContext> extends MultiRowSinglePartDefinition<Props, State, E, InlineComposerCameraView> {
    public static final ViewType f13284a = new C05341();
    private static InlineComposerCameraPartDefinition f13285h;
    private static final Object f13286i = new Object();
    private final Provider<SwipeableDraweeControllerGeneratorImpl> f13287b;
    private final CreativeEditingSwipeableControllerProvider f13288c;
    private final FramesAggregator f13289d;
    private final QeAccessor f13290e;
    private final TasksManager f13291f;
    public final CreativeCamLauncher f13292g;

    /* compiled from: mp_init_in_background_thread */
    final class C05341 extends ViewType {
        C05341() {
        }

        public final View mo1995a(Context context) {
            return (InlineComposerCameraView) LayoutInflater.from(context).inflate(2130904308, null);
        }
    }

    /* compiled from: mp_init_in_background_thread */
    public class Props {
    }

    private static InlineComposerCameraPartDefinition m19549b(InjectorLike injectorLike) {
        return new InlineComposerCameraPartDefinition(IdBasedProvider.m1811a(injectorLike, 9288), (CreativeEditingSwipeableControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CreativeEditingSwipeableControllerProvider.class), FramesAggregator.m19559b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), TasksManager.m14550b(injectorLike), CreativeCamLauncherImpl.m19535a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        HasContext hasContext = (HasContext) anyEnvironment;
        CreativeEditingSwipeableController a = this.f13288c.m19557a(new BaseCreativeEditingUsageLoggerEventListener(), (SwipeableDraweeControllerGeneratorImpl) this.f13287b.get(), null, "-1");
        State state = new State(a);
        state.e = new 2(this, hasContext, state, a);
        this.f13291f.m14553a((Object) "inline_composer_fetch_frames", this.f13289d.m19560a(), new 3(this, state));
        return state;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -458448515);
        State state = (State) obj2;
        InlineComposerCameraView inlineComposerCameraView = (InlineComposerCameraView) view;
        inlineComposerCameraView.a.d();
        if (!(inlineComposerCameraView.getWidth() == 0 || inlineComposerCameraView.getHeight() == 0)) {
            state.a.a(inlineComposerCameraView.b, inlineComposerCameraView.getWidth(), inlineComposerCameraView.getHeight(), true);
            state.a.a(state.e);
            state.a.L.i = true;
            if (state.c != null) {
                m19550b(state);
            }
        }
        Logger.a(8, EntryType.MARK_POP, 1426586646, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        ((InlineComposerCameraView) view).a.b();
        if (state.a.k()) {
            state.d = state.a.g();
            state.a.b(false);
            state.a.a(null);
            state.a.j();
        }
    }

    public static InlineComposerCameraPartDefinition m19548a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerCameraPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13286i) {
                InlineComposerCameraPartDefinition inlineComposerCameraPartDefinition;
                if (a2 != null) {
                    inlineComposerCameraPartDefinition = (InlineComposerCameraPartDefinition) a2.mo818a(f13286i);
                } else {
                    inlineComposerCameraPartDefinition = f13285h;
                }
                if (inlineComposerCameraPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19549b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13286i, b3);
                        } else {
                            f13285h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerCameraPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    private InlineComposerCameraPartDefinition(Provider<SwipeableDraweeControllerGeneratorImpl> provider, CreativeEditingSwipeableControllerProvider creativeEditingSwipeableControllerProvider, FramesAggregator framesAggregator, QeAccessor qeAccessor, TasksManager tasksManager, CreativeCamLauncher creativeCamLauncher) {
        this.f13287b = provider;
        this.f13288c = creativeEditingSwipeableControllerProvider;
        this.f13289d = framesAggregator;
        this.f13290e = qeAccessor;
        this.f13291f = tasksManager;
        this.f13292g = creativeCamLauncher;
    }

    public final boolean m19554a(Object obj) {
        return this.f13290e.mo596a(ExperimentsForInspirationAbTestModule.f13421a, false);
    }

    public final ViewType mo2547a() {
        return f13284a;
    }

    public static void m19550b(State state) {
        Preconditions.checkNotNull(state.a);
        state.a.b(state.c, null, state.d);
        state.a.b(true);
    }
}
