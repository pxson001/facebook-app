package com.facebook.xconfig.sync;

import com.facebook.auth.component.persistent.AbstractPersistentComponent;
import com.facebook.config.background.ConfigurationComponent;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.xconfig.core.STATICDI_MULTIBIND_PROVIDER$XConfigSyncListener;
import com.facebook.xconfig.core.XConfigStorage;
import com.facebook.xconfig.core.XConfigSyncListener;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: style_list */
public class XSyncComponent extends AbstractPersistentComponent implements ConfigurationComponent {
    private final Provider<String> f1615a;
    private final XConfigStorage f1616b;
    public final XSyncHandlerProvider f1617c;
    public final XSyncApiMethodProvider f1618d;
    private final Lazy<ExecutorService> f1619e;
    private final Provider<Long> f1620f;
    private final Lazy<Set<XConfigSyncListener>> f1621g;

    /* compiled from: style_list */
    final class XConfigBatchComponent implements BatchComponent {
        final /* synthetic */ XSyncComponent f1623a;
        private final XSyncHandler f1624b;
        private final XSyncApiMethod f1625c;

        public XConfigBatchComponent(XSyncComponent xSyncComponent, @Nullable String str) {
            this.f1623a = xSyncComponent;
            this.f1624b = xSyncComponent.f1617c.m1858a(str);
            this.f1625c = xSyncComponent.f1618d.m1859a(str);
        }

        public final Iterable<BatchOperation> mo99a() {
            Builder a = BatchOperation.m12541a(this.f1625c, this.f1624b.m1867b());
            a.f11927c = "XConfigSync";
            return ImmutableList.of(a.m12549a());
        }

        public final void mo100a(Map<String, Object> map) {
            XSyncResult xSyncResult = (XSyncResult) map.get("XConfigSync");
            if (xSyncResult == null) {
                BLog.c("XSyncComponent", "No result for xconfig sync");
                return;
            }
            try {
                this.f1624b.m1866a(xSyncResult);
            } catch (XSyncException e) {
                BLog.c("XSyncComponent", e, "Failed to write new values to storage following xconfig sync", new Object[0]);
            }
        }
    }

    public static XSyncComponent m1854b(InjectorLike injectorLike) {
        return new XSyncComponent(IdBasedProvider.a(injectorLike, 4443), XConfigStorage.a(injectorLike), (XSyncHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(XSyncHandlerProvider.class), (XSyncApiMethodProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(XSyncApiMethodProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 3834), IdBasedProvider.a(injectorLike, 4434), ProviderLazy.a(new STATICDI_MULTIBIND_PROVIDER$XConfigSyncListener(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()));
    }

    @Inject
    public XSyncComponent(Provider<String> provider, XConfigStorage xConfigStorage, XSyncHandlerProvider xSyncHandlerProvider, XSyncApiMethodProvider xSyncApiMethodProvider, Lazy<ExecutorService> lazy, Provider<Long> provider2, Lazy<Set<XConfigSyncListener>> lazy2) {
        this.f1615a = provider;
        this.f1616b = xConfigStorage;
        this.f1617c = xSyncHandlerProvider;
        this.f1618d = xSyncApiMethodProvider;
        this.f1619e = lazy;
        this.f1620f = provider2;
        this.f1621g = lazy2;
    }

    public final BatchComponent mo101b() {
        return new XConfigBatchComponent(this, (String) this.f1615a.get());
    }

    public final boolean cn_() {
        if (!this.f1616b.c((String) this.f1615a.get())) {
            return false;
        }
        for (XConfigSyncListener xConfigSyncListener : (Set) this.f1621g.get()) {
            xConfigSyncListener.mo138a(xConfigSyncListener.mo137a());
        }
        return true;
    }

    public final BatchComponent mo95c() {
        String str = (String) this.f1615a.get();
        if (Strings.isNullOrEmpty(str)) {
            BLog.c("XSyncComponent", "User ID was null during attempt to sync xconfig at login");
        }
        return new XConfigBatchComponent(this, str);
    }

    public final void mo97d() {
        ExecutorDetour.a((ExecutorService) this.f1619e.get(), new 1(this), 932018667);
    }

    public final long co_() {
        return ((Long) this.f1620f.get()).longValue();
    }
}
