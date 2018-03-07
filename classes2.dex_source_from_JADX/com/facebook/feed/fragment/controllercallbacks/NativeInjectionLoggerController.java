package com.facebook.feed.fragment.controllercallbacks;

import android.content.Context;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.feed.analytics.NativeInjectionLogger;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.feed.rows.core.FeedUnitAdapter;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.core.traversal.SinglePartHolder;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.controllercallbacks.AdapterDataChangedCallback;
import java.util.HashSet;
import java.util.Set;

@ContextScoped
/* compiled from: phone_is_verified */
public class NativeInjectionLoggerController extends BaseController implements AdapterDataChangedCallback {
    private static NativeInjectionLoggerController f10140f;
    private static final Object f10141g = new Object();
    private final Set<RowKey> f10142a = new HashSet();
    @Inject
    public NativeInjectionLogger f10143b;
    @Inject
    public GatekeeperStoreImpl f10144c;
    @Inject
    public AbstractFbErrorReporter f10145d;
    @Inject
    public DefaultAndroidThreadUtil f10146e;

    private static NativeInjectionLoggerController m15243b(InjectorLike injectorLike) {
        NativeInjectionLoggerController nativeInjectionLoggerController = new NativeInjectionLoggerController();
        GatekeeperStoreImpl a = GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike);
        AbstractFbErrorReporter a2 = FbErrorReporterImpl.m2317a(injectorLike);
        DefaultAndroidThreadUtil b = DefaultAndroidThreadUtil.m1646b(injectorLike);
        nativeInjectionLoggerController.f10143b = NativeInjectionLogger.m15245a(injectorLike);
        nativeInjectionLoggerController.f10144c = a;
        nativeInjectionLoggerController.f10145d = a2;
        nativeInjectionLoggerController.f10146e = b;
        return nativeInjectionLoggerController;
    }

    public final boolean kJ_() {
        return this.f10144c.m2189a(663, false);
    }

    public final void mo1951a(BasicAdapter basicAdapter) {
        m15242a(basicAdapter, 0, basicAdapter.aZ_());
    }

    private void m15242a(BasicAdapter basicAdapter, int i, int i2) {
        while (i < i2) {
            Object item = basicAdapter.getItem(i);
            if (item instanceof BoundedAdapter) {
                BoundedAdapter boundedAdapter = (BoundedAdapter) item;
                RowKey d = boundedAdapter.m19813d();
                if (!this.f10142a.contains(d)) {
                    this.f10142a.add(d);
                    FeedUnit c = boundedAdapter.m19812c();
                    if (c instanceof GraphQLStory) {
                        String c2 = ((GraphQLStory) c).m22350c();
                        NativeInjectionLogger nativeInjectionLogger = this.f10143b;
                        FeedUnitAdapter feedUnitAdapter = boundedAdapter.f13446a;
                        String name = ((SinglePartHolder) feedUnitAdapter.f12965j.get(boundedAdapter.f13447b)).f13428a.getClass().getName();
                        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("triggered_code");
                        honeyClientEvent.f3099c = "native_injection";
                        honeyClientEvent.m5090b("code_path", name);
                        honeyClientEvent.m5090b("story_id", c2);
                        nativeInjectionLogger.f10148a.mo526a(honeyClientEvent);
                    }
                }
            }
            i++;
        }
    }

    public static NativeInjectionLoggerController m15241a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NativeInjectionLoggerController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f10141g) {
                NativeInjectionLoggerController nativeInjectionLoggerController;
                if (a2 != null) {
                    nativeInjectionLoggerController = (NativeInjectionLoggerController) a2.mo818a(f10141g);
                } else {
                    nativeInjectionLoggerController = f10140f;
                }
                if (nativeInjectionLoggerController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m15243b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f10141g, b3);
                        } else {
                            f10140f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = nativeInjectionLoggerController;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
