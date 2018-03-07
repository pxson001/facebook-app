package com.facebook.fbreact.marketplace;

import com.facebook.fbreact.search.ReactSearchEventBus;
import com.facebook.fbreact.search.ReactSearchEvents.ResignKeyboardEvent;
import com.facebook.fbreact.search.ReactSearchEvents.UpdateSearcyQueryEvent;
import com.facebook.inject.Assisted;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: extra_composer_saved_session */
public class FBReactSearchInputNativeModule extends ReactContextBaseJavaModule {
    public final ReactSearchEventBus f7383a;
    private final Executor f7384b;

    @Inject
    public FBReactSearchInputNativeModule(@Assisted ReactApplicationContext reactApplicationContext, ReactSearchEventBus reactSearchEventBus, Executor executor) {
        super(reactApplicationContext);
        this.f7383a = reactSearchEventBus;
        this.f7384b = executor;
    }

    @ReactMethod
    public void updateNativeSearchQuery(final String str, final int i) {
        ExecutorDetour.a(this.f7384b, new Runnable(this) {
            final /* synthetic */ FBReactSearchInputNativeModule f7380c;

            public void run() {
                this.f7380c.f7383a.a(new UpdateSearcyQueryEvent(i, str));
            }
        }, 1169864765);
    }

    @ReactMethod
    public void resignKeyboardViewForReactTag(final int i) {
        ExecutorDetour.a(this.f7384b, new Runnable(this) {
            final /* synthetic */ FBReactSearchInputNativeModule f7382b;

            public void run() {
                this.f7382b.f7383a.a(new ResignKeyboardEvent(i));
            }
        }, -1673849412);
    }

    public String getName() {
        return "FBReactSearchInputNativeModule";
    }

    public final Map<String, Object> m8560a() {
        HashMap hashMap = new HashMap();
        hashMap.put("marketplaceSearch", "MarketplaceSearch");
        hashMap.put("marketplaceSearchOther", "MarketplaceSearchOther");
        hashMap.put("groupsDiscoverySearch", "GroupsDiscoverySearch");
        Map hashMap2 = new HashMap();
        hashMap2.put("modules", hashMap);
        return hashMap2;
    }
}
