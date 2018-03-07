package com.facebook.privacy.service;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.config.background.AbstractConfigurationAndLoginComponent;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.privacy.abtest.ExperimentsForPrivacyAbTestModule;
import com.facebook.privacy.model.PrivacyOptionsResultFactory;
import com.facebook.privacy.protocol.FetchComposerPrivacyOptionsMethod;
import com.facebook.privacy.service.PrivacyAnalyticsLogger.Events;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: sms_is_enabled_for_tracking */
public final class ComposerPrivacyOptionsFetchComponent extends AbstractConfigurationAndLoginComponent {
    private final Lazy<FbObjectMapper> f2077a;
    public final Lazy<FetchComposerPrivacyOptionsMethod> f2078b;
    public final Lazy<PrivacyOptionsResultFactory> f2079c;
    public final Lazy<PrivacyAnalyticsLogger> f2080d;
    public final Lazy<PrivacyCacheServiceHandler> f2081e;
    private final Lazy<QeAccessor> f2082f;

    /* compiled from: sms_is_enabled_for_tracking */
    class C01071 implements BatchComponent {
        final /* synthetic */ ComposerPrivacyOptionsFetchComponent f2086a;

        C01071(ComposerPrivacyOptionsFetchComponent composerPrivacyOptionsFetchComponent) {
            this.f2086a = composerPrivacyOptionsFetchComponent;
        }

        public final Iterable<BatchOperation> mo99a() {
            Builder a = BatchOperation.m12541a((ApiMethod) this.f2086a.f2078b.get(), null);
            a.f11927c = "fetchComposerPrivacyOptions";
            return ImmutableList.of(a.m12549a());
        }

        public final void mo100a(Map<String, Object> map) {
            ((PrivacyCacheServiceHandler) this.f2086a.f2081e.get()).m2362a(((PrivacyOptionsResultFactory) this.f2086a.f2079c.get()).m2334a((GraphQLViewer) map.get("fetchComposerPrivacyOptions"), true), null);
            int e = ComposerPrivacyOptionsFetchComponent.m2176e(this.f2086a);
            if (e != -1) {
                long a = (long) ComposerPrivacyOptionsFetchComponent.m2174a(this.f2086a, map);
                ((PrivacyAnalyticsLogger) this.f2086a.f2080d.get()).f2186a.a(PrivacyAnalyticsLogger.m2363a(Events.COMPOSER_OPTIONS_REQUEST_RESULT.eventName).a("response_size", a).b("qe_group", Integer.toString(e)));
            }
        }
    }

    public static ComposerPrivacyOptionsFetchComponent m2175b(InjectorLike injectorLike) {
        return new ComposerPrivacyOptionsFetchComponent(IdBasedSingletonScopeProvider.b(injectorLike, 572), IdBasedLazy.a(injectorLike, 3113), IdBasedLazy.a(injectorLike, 3108), IdBasedLazy.a(injectorLike, 3115), IdBasedSingletonScopeProvider.b(injectorLike, 3116), IdBasedSingletonScopeProvider.b(injectorLike, 3219));
    }

    @Inject
    ComposerPrivacyOptionsFetchComponent(Lazy<FbObjectMapper> lazy, Lazy<FetchComposerPrivacyOptionsMethod> lazy2, Lazy<PrivacyOptionsResultFactory> lazy3, Lazy<PrivacyAnalyticsLogger> lazy4, Lazy<PrivacyCacheServiceHandler> lazy5, Lazy<QeAccessor> lazy6) {
        this.f2077a = lazy;
        this.f2078b = lazy2;
        this.f2079c = lazy3;
        this.f2080d = lazy4;
        this.f2081e = lazy5;
        this.f2082f = lazy6;
    }

    public final BatchComponent mo149c() {
        return new C01071(this);
    }

    public final long co_() {
        int e = m2176e(this);
        if (e == -1) {
            return 86400000;
        }
        return ((long) e) * 3600000;
    }

    public static int m2176e(ComposerPrivacyOptionsFetchComponent composerPrivacyOptionsFetchComponent) {
        return ((QeAccessor) composerPrivacyOptionsFetchComponent.f2082f.get()).a(Liveness.Live, ExperimentsForPrivacyAbTestModule.f2204a, -1);
    }

    public static int m2174a(ComposerPrivacyOptionsFetchComponent composerPrivacyOptionsFetchComponent, Map map) {
        try {
            return ((FbObjectMapper) composerPrivacyOptionsFetchComponent.f2077a.get()).a(map).length() * 2;
        } catch (Exception e) {
            return -1;
        }
    }
}
