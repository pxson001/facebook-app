package com.facebook.components.feed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentTree;
import com.facebook.components.ComponentTree.Builder;
import com.facebook.components.ComponentView;
import com.facebook.components.ComponentsConstants;
import com.facebook.components.ComponentsLogger;
import com.facebook.components.ComponentsPools;
import com.facebook.components.SizeSpec;
import com.facebook.components.ThreadUtils;
import com.facebook.components.fb.logger.QPLComponentsLogger;
import com.facebook.components.feed.api.ComponentPart;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.qe.ExperimentsForMultiRowQEModule;
import com.facebook.feed.util.render.FeedRenderUtils;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.SubParts;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: icon */
public class ComponentPartHelper<P, E extends HasContext & HasIsAsync & HasPersistentState> {
    private static ComponentPartHelper f20630d;
    private static final Object f20631e = new Object();
    private final Lazy<ComponentsLogger> f20632a;
    private final FeedRenderUtils f20633b;
    private final AndroidComponentsExperimentHelper f20634c;

    private static ComponentPartHelper m28381b(InjectorLike injectorLike) {
        return new ComponentPartHelper(IdBasedSingletonScopeProvider.m1810b(injectorLike, 841), FeedRenderUtils.m14652a(injectorLike), AndroidComponentsExperimentHelper.m10053a(injectorLike));
    }

    @Inject
    public ComponentPartHelper(Lazy<ComponentsLogger> lazy, FeedRenderUtils feedRenderUtils, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        this.f20632a = lazy;
        this.f20633b = feedRenderUtils;
        this.f20634c = androidComponentsExperimentHelper;
        boolean z = false;
        if (androidComponentsExperimentHelper.f5914r == null) {
            androidComponentsExperimentHelper.f5914r = Boolean.valueOf(androidComponentsExperimentHelper.f5897a.mo596a(ExperimentsForMultiRowQEModule.f5936t, false));
        }
        if (androidComponentsExperimentHelper.f5914r.booleanValue() || androidComponentsExperimentHelper.m10064s()) {
            z = true;
        }
        if (z) {
            ComponentsConstants.f22749b = true;
        }
    }

    public static ComponentPartHelper m28376a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ComponentPartHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20631e) {
                ComponentPartHelper componentPartHelper;
                if (a2 != null) {
                    componentPartHelper = (ComponentPartHelper) a2.mo818a(f20631e);
                } else {
                    componentPartHelper = f20630d;
                }
                if (componentPartHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28381b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20631e, b3);
                        } else {
                            f20630d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = componentPartHelper;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ComponentTree m28382a(SubParts<E> subParts, P p, E e, String str, ComponentPart<P, E> componentPart) {
        Component a = componentPart.mo3130a(new ComponentContext(e.getContext()), p, e);
        ComponentTree a2 = m28375a(a, (Object) p, (HasContext) e, str, (ComponentPart) componentPart);
        boolean hM_ = ((HasIsAsync) e).hM_();
        boolean a3 = componentPart.mo3133a(e);
        m28380a(a, componentPart.mo3131b(p) != null, hM_, a3, str);
        int a4 = this.f20633b.m14654a();
        if (a4 > 0) {
            if (hM_ && a3) {
                a2.m30637a(a, SizeSpec.m30705a(a4, 1073741824), SizeSpec.m30705a(0, 0));
            } else {
                a2.m30640b(a, SizeSpec.m30705a(a4, 1073741824), SizeSpec.m30705a(0, 0));
            }
        }
        componentPart.mo3132a(subParts, p);
        m28379a(a);
        return a2;
    }

    public final void m28383a(E e, ComponentTree componentTree, P p, String str, ComponentPart<P, E> componentPart) {
        CacheableEntity b = componentPart.mo3131b(p);
        if (b != null) {
            ((HasPersistentState) e).mo2439a(new ComponentTreePersistentStateKey(m28378a(p, b), str, null, null, null), null);
        }
        AndroidComponentsExperimentHelper androidComponentsExperimentHelper = this.f20634c;
        boolean z = false;
        if (androidComponentsExperimentHelper.f5916t == null) {
            androidComponentsExperimentHelper.f5916t = Boolean.valueOf(androidComponentsExperimentHelper.f5897a.mo596a(ExperimentsForMultiRowQEModule.f5931o, false));
        }
        if (androidComponentsExperimentHelper.f5916t.booleanValue() || androidComponentsExperimentHelper.m10064s()) {
            z = true;
        }
        if (z) {
            ThreadUtils.m30579b();
            ComponentView componentView = componentTree.f22681m;
            if (componentView != null) {
                componentView.setComponent(null);
            }
            componentTree.m30646l();
        }
    }

    private void m28380a(Component component, boolean z, boolean z2, boolean z3, String str) {
        QPLComponentsLogger qPLComponentsLogger = (QPLComponentsLogger) this.f20632a.get();
        if (qPLComponentsLogger != null) {
            qPLComponentsLogger.m30614a(4, component, "log_tag", str);
            qPLComponentsLogger.m30615b(4, component, "tree_diff_enabled", String.valueOf(z));
            qPLComponentsLogger.m30615b(4, component, "is_async_prepare", String.valueOf(z2));
            qPLComponentsLogger.m30615b(4, component, "is_async_layout", String.valueOf(z3));
        }
    }

    private void m28379a(Component<?> component) {
        QPLComponentsLogger qPLComponentsLogger = (QPLComponentsLogger) this.f20632a.get();
        if (qPLComponentsLogger != null) {
            qPLComponentsLogger.m30613a(4, component, 16);
        }
    }

    private ComponentTree m28375a(Component<?> component, P p, E e, String str, ComponentPart<P, E> componentPart) {
        String str2;
        String str3 = null;
        QPLComponentsLogger qPLComponentsLogger = (QPLComponentsLogger) this.f20632a.get();
        ComponentContext componentContext = new ComponentContext(e.getContext());
        CacheableEntity b = componentPart.mo3131b(p);
        AndroidComponentsExperimentHelper androidComponentsExperimentHelper = this.f20634c;
        boolean z = true;
        if (androidComponentsExperimentHelper.f5915s == null) {
            androidComponentsExperimentHelper.f5915s = Boolean.valueOf(androidComponentsExperimentHelper.f5897a.mo596a(ExperimentsForMultiRowQEModule.f5929m, true));
        }
        if (!(androidComponentsExperimentHelper.f5915s.booleanValue() || androidComponentsExperimentHelper.m10064s())) {
            z = false;
        }
        if (z) {
            if (b != null) {
                str3 = m28378a(p, b);
            }
            str2 = str3;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            Builder a = ComponentsPools.m30512a(componentContext, (Component) component);
            a.f22742i = str;
            a = a;
            a.f22741h = qPLComponentsLogger;
            return a.m30701b();
        }
        return (ComponentTree) ((HasPersistentState) e).mo2425a(new ComponentTreePersistentStateKey(str2, str, componentContext, component, qPLComponentsLogger), b);
    }

    @Nullable
    public static CacheableEntity m28377a(FeedProps<? extends CacheableEntity> feedProps) {
        CacheableEntity cacheableEntity;
        Flattenable b = feedProps.m19806b();
        if (b instanceof CacheableEntity) {
            cacheableEntity = (CacheableEntity) b;
        } else {
            cacheableEntity = (CacheableEntity) feedProps.f13444a;
        }
        if (StringUtil.m3589a(cacheableEntity.mo2507g())) {
            return null;
        }
        return cacheableEntity;
    }

    private static String m28378a(P p, CacheableEntity cacheableEntity) {
        if (!(p instanceof FeedProps) || !(((FeedProps) p).f13444a instanceof CacheableEntity)) {
            return cacheableEntity.mo2507g();
        }
        FeedProps feedProps = (FeedProps) p;
        Flattenable b = feedProps.m19806b();
        return (b instanceof CacheableEntity ? ((CacheableEntity) b).mo2507g() : "") + ((CacheableEntity) feedProps.f13444a).mo2507g();
    }
}
