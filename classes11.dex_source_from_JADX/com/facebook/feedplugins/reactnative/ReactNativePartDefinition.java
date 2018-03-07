package com.facebook.feedplugins.reactnative;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbreact.instance.FbReactInstanceHolder;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.model.ReactNativeFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.react.views.view.ReactViewGroup;
import javax.inject.Inject;

@ContextScoped
/* compiled from: canonicalization */
public class ReactNativePartDefinition extends MultiRowSinglePartDefinition<ReactNativeFeedUnit, State, AnyEnvironment, FrameLayout> {
    public static final ViewType<FrameLayout> f9028a = new C10931();
    private static ReactNativePartDefinition f9029d;
    private static final Object f9030e = new Object();
    private final FbReactInstanceHolder f9031b;
    private final Context f9032c;

    /* compiled from: canonicalization */
    final class C10931 extends ViewType<FrameLayout> {
        C10931() {
        }

        public final View m9727a(Context context) {
            return new FrameLayout(context);
        }
    }

    /* compiled from: canonicalization */
    class C10942 implements DefaultHardwareBackBtnHandler {
        final /* synthetic */ ReactNativePartDefinition f9023a;

        C10942(ReactNativePartDefinition reactNativePartDefinition) {
            this.f9023a = reactNativePartDefinition;
        }

        public final void m9728a() {
        }
    }

    /* compiled from: canonicalization */
    public final class State {
        public final ReactRootView f9026a;
        public final OnGlobalLayoutListener f9027b;

        public State(ReactRootView reactRootView, OnGlobalLayoutListener onGlobalLayoutListener) {
            this.f9026a = reactRootView;
            this.f9027b = onGlobalLayoutListener;
        }
    }

    private static ReactNativePartDefinition m9730b(InjectorLike injectorLike) {
        return new ReactNativePartDefinition(FbReactInstanceHolder.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object m9732a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactNativeFeedUnit reactNativeFeedUnit = (ReactNativeFeedUnit) obj;
        final ReactRootView reactRootView = new ReactRootView(this.f9032c);
        reactRootView.setLayoutParams(new LayoutParams(-1, 200));
        Bundle bundle = new Bundle();
        bundle.putString("uri", reactNativeFeedUnit.a);
        bundle.putString("routeName", reactNativeFeedUnit.b);
        ReactInstanceManager c = this.f9031b.c();
        reactRootView.a(c, reactNativeFeedUnit.c, bundle);
        c.a(null, new C10942(this));
        return new State(reactRootView, new OnGlobalLayoutListener(this) {
            final /* synthetic */ ReactNativePartDefinition f9025b;

            public void onGlobalLayout() {
                View childAt;
                ViewGroup viewGroup = reactRootView;
                while (true) {
                    if (((viewGroup instanceof ReactRootView) || (viewGroup instanceof ReactViewGroup)) && !(viewGroup instanceof ReactScrollView)) {
                        if (viewGroup.getChildCount() > 0) {
                            childAt = viewGroup.getChildAt(0);
                            if (!(childAt instanceof ViewGroup)) {
                                break;
                            }
                            viewGroup = (ViewGroup) childAt;
                        } else {
                            return;
                        }
                    }
                    break;
                }
                if (viewGroup.getChildCount() > 0) {
                    childAt = viewGroup.getChildAt(0);
                    if (childAt.getMeasuredHeight() != reactRootView.getMeasuredHeight()) {
                        ViewGroup.LayoutParams layoutParams = reactRootView.getLayoutParams();
                        layoutParams.height = childAt.getMeasuredHeight();
                        reactRootView.setLayoutParams(layoutParams);
                    }
                }
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m9733a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1153458258);
        State state = (State) obj2;
        ((FrameLayout) view).addView(state.f9026a);
        state.f9026a.getViewTreeObserver().addOnGlobalLayoutListener(state.f9027b);
        Logger.a(8, EntryType.MARK_POP, -1054953087, a);
    }

    public final void m9735b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        ((FrameLayout) view).removeViewAt(0);
        state.f9026a.a();
        state.f9026a.getViewTreeObserver().removeOnGlobalLayoutListener(state.f9027b);
    }

    public static ReactNativePartDefinition m9729a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactNativePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9030e) {
                ReactNativePartDefinition reactNativePartDefinition;
                if (a2 != null) {
                    reactNativePartDefinition = (ReactNativePartDefinition) a2.a(f9030e);
                } else {
                    reactNativePartDefinition = f9029d;
                }
                if (reactNativePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9730b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9030e, b3);
                        } else {
                            f9029d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactNativePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactNativePartDefinition(FbReactInstanceHolder fbReactInstanceHolder, Context context) {
        this.f9031b = fbReactInstanceHolder;
        this.f9032c = context;
    }

    public final ViewType<FrameLayout> m9731a() {
        return f9028a;
    }

    public final boolean m9734a(Object obj) {
        return true;
    }
}
