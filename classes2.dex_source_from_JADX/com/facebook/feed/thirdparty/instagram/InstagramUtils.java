package com.facebook.feed.thirdparty.instagram;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.C0087xd695ba9d;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.uri.NativeUri;
import com.facebook.common.uri.NativeUri.Builder;
import com.facebook.common.util.DeviceUtil;
import com.facebook.feed.thirdparty.instagram.InstagramGalleryDeepLinkBinder.InstagramDeepLinkBinderConfig;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLOpenGraphAction;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.external.ExternalIntentHandler;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.intent.ufiservices.DefaultUriIntentGenerator;
import com.facebook.intent.ufiservices.UriIntentGenerator;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: loom */
public class InstagramUtils {
    private static InstagramUtils f15943i;
    private static final Object f15944j = new Object();
    private final PackageManager f15945a;
    private final GooglePlayIntentHelper f15946b;
    private final Lazy<UriIntentGenerator> f15947c;
    private final ExternalIntentHandler f15948d;
    private final AnalyticsLogger f15949e;
    private final ExecutorService f15950f;
    private final GatekeeperStoreImpl f15951g;
    private final FbUriIntentHandler f15952h;

    private static InstagramUtils m22707b(InjectorLike injectorLike) {
        return new InstagramUtils((Context) injectorLike.getInstance(Context.class), GooglePlayIntentHelper.m22732b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2350), ExternalIntentHandler.m22740a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), C0087xd695ba9d.m2486a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), FbUriIntentHandler.m8626a(injectorLike));
    }

    @Inject
    public InstagramUtils(Context context, GooglePlayIntentHelper googlePlayIntentHelper, Lazy<UriIntentGenerator> lazy, ExternalIntentHandler externalIntentHandler, AnalyticsLogger analyticsLogger, ExecutorService executorService, GatekeeperStore gatekeeperStore, FbUriIntentHandler fbUriIntentHandler) {
        this.f15945a = context.getPackageManager();
        this.f15946b = googlePlayIntentHelper;
        this.f15947c = lazy;
        this.f15948d = externalIntentHandler;
        this.f15949e = analyticsLogger;
        this.f15950f = executorService;
        this.f15951g = gatekeeperStore;
        this.f15952h = fbUriIntentHandler;
    }

    public static InstagramUtils m22703a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstagramUtils b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f15944j) {
                InstagramUtils instagramUtils;
                if (a2 != null) {
                    instagramUtils = (InstagramUtils) a2.mo818a(f15944j);
                } else {
                    instagramUtils = f15943i;
                }
                if (instagramUtils == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m22707b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f15944j, b3);
                        } else {
                            f15943i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = instagramUtils;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final boolean m22716a() {
        return DeviceUtil.a(this.f15945a, "com.instagram.android");
    }

    public static boolean m22705a(GraphQLStory graphQLStory) {
        return (graphQLStory == null || graphQLStory.m22324J() == null || !"124024574287414".equals(graphQLStory.m22324J().m23672u())) ? false : true;
    }

    public final int m22719d() {
        if (m22704a(InstagramGatekeepers.f18213e)) {
            return 99;
        }
        if (m22704a(InstagramGatekeepers.f18212d)) {
            return 75;
        }
        if (m22704a(InstagramGatekeepers.f18211c)) {
            return 50;
        }
        if (m22704a(InstagramGatekeepers.f18210b)) {
            return 25;
        }
        if (m22704a(InstagramGatekeepers.f18209a)) {
            return 15;
        }
        return 0;
    }

    public final boolean m22720e() {
        return m22704a(1007);
    }

    public final int m22721f() {
        if (m22704a(InstagramGatekeepers.f18223o)) {
            return 99;
        }
        if (m22704a(InstagramGatekeepers.f18222n)) {
            return 75;
        }
        if (m22704a(InstagramGatekeepers.f18221m)) {
            return 50;
        }
        if (m22704a(InstagramGatekeepers.f18220l)) {
            return 25;
        }
        if (m22704a(InstagramGatekeepers.f18219k)) {
            return 15;
        }
        return 0;
    }

    private boolean m22709c(InstagramEntryPoint instagramEntryPoint) {
        switch (1.a[instagramEntryPoint.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return m22704a(InstagramGatekeepers.f18224p);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return m22704a(InstagramGatekeepers.f18226r);
            default:
                return false;
        }
    }

    private boolean m22710d(InstagramEntryPoint instagramEntryPoint) {
        switch (1.a[instagramEntryPoint.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return m22704a(InstagramGatekeepers.f18227s);
            default:
                return false;
        }
    }

    public final boolean m22722g() {
        return m22704a(InstagramGatekeepers.f18228t);
    }

    public final boolean m22723h() {
        return m22704a(InstagramGatekeepers.f18225q);
    }

    public final boolean m22724i() {
        return m22704a(InstagramGatekeepers.f18215g);
    }

    public final boolean m22725j() {
        return m22704a(InstagramGatekeepers.f18216h);
    }

    public final boolean m22726k() {
        return m22704a(InstagramGatekeepers.f18218j);
    }

    public final boolean m22727l() {
        return m22704a(InstagramGatekeepers.f18217i);
    }

    private boolean m22704a(int i) {
        return this.f15951g.m2189a(i, false);
    }

    public final boolean m22717a(InstagramEntryPoint instagramEntryPoint) {
        boolean c = m22716a() ? m22709c(instagramEntryPoint) : m22710d(instagramEntryPoint);
        if (c) {
            m22718b(instagramEntryPoint);
        }
        return c;
    }

    private String m22708c(GraphQLStory graphQLStory) {
        String a;
        if (graphQLStory.m22320F() != null) {
            ImmutableList F = graphQLStory.m22320F();
            int size = F.size();
            for (int i = 0; i < size; i++) {
                GraphQLOpenGraphAction graphQLOpenGraphAction = (GraphQLOpenGraphAction) F.get(i);
                if (graphQLOpenGraphAction.m23735n() != null && graphQLOpenGraphAction.m23735n().ij() != null && graphQLOpenGraphAction.m23735n().ij().m24600a() != null) {
                    a = graphQLOpenGraphAction.m23735n().ij().m24600a();
                    break;
                }
            }
        }
        a = null;
        String str = a;
        return str != null ? "http://instagram.com/_uid/" + str : null;
    }

    private Intent m22706b(Context context, InstagramEntryPoint instagramEntryPoint, @Nullable GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return null;
        }
        Object obj;
        String c;
        switch (1.a[instagramEntryPoint.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
            case 6:
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            c = m22708c(graphQLStory);
            if (c != null) {
                Intent a = ((DefaultUriIntentGenerator) this.f15947c.get()).a(c);
                a.setPackage("com.instagram.android");
                List queryIntentActivities = context.getPackageManager().queryIntentActivities(a, 0);
                if (!(queryIntentActivities == null || queryIntentActivities.isEmpty())) {
                    return a;
                }
            }
        }
        if (m22716a()) {
            c = GraphQLStoryUtil.m9566a(graphQLStory);
            if (c != null) {
                return ((DefaultUriIntentGenerator) this.f15947c.get()).a(c);
            }
        }
        return null;
    }

    public final void m22714a(Context context, InstagramEntryPoint instagramEntryPoint, @Nullable GraphQLStory graphQLStory, JsonNode jsonNode) {
        String str = null;
        Intent b = m22706b(context, instagramEntryPoint, graphQLStory);
        boolean z = b != null;
        if (z) {
            this.f15948d.m22745a(b, context, jsonNode, false, null);
        } else {
            this.f15946b.m22736a(context, "com.instagram.android");
        }
        if (z) {
            str = b.getData().toString();
        }
        m22712a(context, new InstagramClickEvent(instagramEntryPoint, graphQLStory, str));
    }

    public final void m22715a(Context context, String str, InstagramEntryPoint instagramEntryPoint) {
        if (NativeThirdPartyUriHelper.m29571a(str)) {
            Builder f = NativeUri.f();
            f.a = str;
            f = f;
            f.d = null;
            this.f15952h.m8631a(context, f.a());
        }
        m22712a(context, new InstagramClickEvent(instagramEntryPoint, null, str));
    }

    public final void m22713a(Context context, InstagramEntryPoint instagramEntryPoint, @Nullable GraphQLStory graphQLStory) {
        this.f15946b.m22736a(context, "com.instagram.android");
        m22712a(context, new InstagramClickEvent(instagramEntryPoint, graphQLStory, null));
    }

    public final void m22712a(Context context, HoneyClientEvent honeyClientEvent) {
        ExecutorDetour.a(this.f15950f, new InstagramAttributionLogRunnable(context, this.f15949e, honeyClientEvent), 101918138);
    }

    public final void m22718b(InstagramEntryPoint instagramEntryPoint) {
        if (instagramEntryPoint.shouldLogImpression()) {
            this.f15949e.mo526a(new InstagramImpressionEvent(instagramEntryPoint));
        }
    }

    public final InstagramDeepLinkBinderConfig m22711a(boolean z, String str) {
        return m22702a(z, str, null);
    }

    public static InstagramDeepLinkBinderConfig m22702a(boolean z, String str, String str2) {
        return new InstagramDeepLinkBinderConfig(z, str, str2);
    }
}
