package com.facebook.interstitial.omnistore;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.listeners.GatekeeperListenersImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperListeners;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.OnGatekeeperChangeListener;
import com.facebook.gk.store.internal.GatekeeperListenersImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialControllersHolder;
import com.facebook.interstitial.manager.InterstitialControllersHolderImpl;
import com.facebook.omnistore.Collection;
import com.facebook.omnistore.CollectionName;
import com.facebook.omnistore.Delta;
import com.facebook.omnistore.IndexedFields;
import com.facebook.omnistore.Omnistore;
import com.facebook.omnistore.SubscriptionParams;
import com.facebook.omnistore.SubscriptionParams.Builder;
import com.facebook.omnistore.module.OmnistoreComponent;
import com.facebook.omnistore.module.OmnistoreComponent$SubscriptionInfo;
import com.facebook.omnistore.module.OmnistoreComponentManager;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.nio.ByteBuffer;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* compiled from: large_image_page_like_ads */
public class InterstitialOmnistoreComponent extends OnGatekeeperChangeListener implements OmnistoreComponent {
    private static final Class<?> f9620a = InterstitialOmnistoreComponent.class;
    private static volatile InterstitialOmnistoreComponent f9621i;
    private final GatekeeperListenersImpl f9622b;
    private final GatekeeperStoreImpl f9623c;
    private final Provider<String> f9624d;
    private final Provider<OmnistoreComponentManager> f9625e;
    private final InterstitialControllersHolder f9626f;
    private final Lazy<FbErrorReporter> f9627g;
    private final InterstitialConfigurationOmnistoreSubscriber f9628h;

    public static com.facebook.interstitial.omnistore.InterstitialOmnistoreComponent m10067a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9621i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.interstitial.omnistore.InterstitialOmnistoreComponent.class;
        monitor-enter(r1);
        r0 = f9621i;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m10069b(r0);	 Catch:{ all -> 0x0035 }
        f9621i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9621i;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.interstitial.omnistore.InterstitialOmnistoreComponent.a(com.facebook.inject.InjectorLike):com.facebook.interstitial.omnistore.InterstitialOmnistoreComponent");
    }

    private static InterstitialOmnistoreComponent m10069b(InjectorLike injectorLike) {
        return new InterstitialOmnistoreComponent(GatekeeperListenersImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4443), IdBasedSingletonScopeProvider.a(injectorLike, 2868), (InterstitialControllersHolder) InterstitialControllersHolderImpl.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), InterstitialConfigurationOmnistoreSubscriber.m10075a(injectorLike));
    }

    @Inject
    public InterstitialOmnistoreComponent(GatekeeperListeners gatekeeperListeners, GatekeeperStore gatekeeperStore, Provider<String> provider, Provider<OmnistoreComponentManager> provider2, InterstitialControllersHolder interstitialControllersHolder, Lazy<FbErrorReporter> lazy, InterstitialConfigurationOmnistoreSubscriber interstitialConfigurationOmnistoreSubscriber) {
        this.f9622b = gatekeeperListeners;
        this.f9623c = gatekeeperStore;
        this.f9624d = provider;
        this.f9625e = provider2;
        this.f9626f = interstitialControllersHolder;
        this.f9627g = lazy;
        this.f9628h = interstitialConfigurationOmnistoreSubscriber;
    }

    public final void m10070a(GatekeeperStoreImpl gatekeeperStoreImpl, int i) {
        ((OmnistoreComponentManager) this.f9625e.get()).checkComponentSubscription(this);
    }

    public OmnistoreComponent$SubscriptionInfo provideSubscriptionInfo(Omnistore omnistore) {
        this.f9622b.a(this, 272);
        CollectionName build = omnistore.createCollectionNameBuilder("fql_user_nux_status").addSegment((String) this.f9624d.get()).addDeviceId().build();
        if (this.f9623c.a(272, false)) {
            return OmnistoreComponent$SubscriptionInfo.forOpenSubscription(build, m10068a());
        }
        return OmnistoreComponent$SubscriptionInfo.IGNORED_INFO;
    }

    public void onCollectionAvailable(Collection collection) {
        this.f9628h.m10079a(collection);
    }

    public void onDeltasReceived(List<Delta> list) {
        this.f9628h.m10078a();
    }

    public IndexedFields indexObject(String str, String str2, ByteBuffer byteBuffer) {
        return new IndexedFields();
    }

    public void onCollectionInvalidated() {
        this.f9628h.m10079a(null);
    }

    private SubscriptionParams m10068a() {
        String jSONObject;
        String str = "";
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            for (String jSONObject4 : this.f9626f.a()) {
                arrayNode.h(jSONObject4);
            }
            jSONObject3.put("nux_ids", arrayNode);
            jSONObject2.put("render_object_list_query_params", jSONObject3);
            jSONObject4 = jSONObject2.toString();
        } catch (Throwable e) {
            ((AbstractFbErrorReporter) this.f9627g.get()).a(f9620a.getSimpleName(), e);
            jSONObject4 = str;
        }
        return new Builder().collectionParams(jSONObject4).idl("namespace com.facebook.interstitial.omnistore;\n\ntable UserNuxStatus {\n nux_id:string; \n rank:int; \n nux_data:string;\n fetch_time:long;\n}\n\nroot_type UserNuxStatus;\n").build();
    }
}
