package com.facebook.assetdownload.background;

import com.facebook.assetdownload.AssetDownloadXConfig;
import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerInfo;
import com.facebook.conditionalworker.ConditionalWorkerInfo.Trigger;
import com.facebook.conditionalworker.RequiredStates;
import com.facebook.conditionalworker.RequiredStates.Builder;
import com.facebook.conditionalworker.States.AppState;
import com.facebook.conditionalworker.States.BatteryState;
import com.facebook.conditionalworker.States.LoginState;
import com.facebook.conditionalworker.States.NetworkState;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: is_banned_by_page_viewer */
public class AssetDownloadConditionalWorkerInfo implements ConditionalWorkerInfo {
    private final Provider<AssetDownloadConditionalWorker> f10110b;
    private final Provider<Boolean> f10111c;
    private final XConfigReader f10112d;

    @Inject
    public AssetDownloadConditionalWorkerInfo(Provider<AssetDownloadConditionalWorker> provider, Provider<Boolean> provider2, XConfigReader xConfigReader) {
        this.f10110b = provider;
        this.f10111c = provider2;
        this.f10112d = xConfigReader;
    }

    public final boolean mo788a() {
        return ((Boolean) this.f10111c.get()).booleanValue();
    }

    public final Trigger mo789b() {
        return Trigger.INTERVAL;
    }

    public final Provider<? extends ConditionalWorker> mo790c() {
        return this.f10110b;
    }

    public final RequiredStates mo791d() {
        return new Builder().m10806a(NetworkState.CONNECTED).m10803a(AppState.BACKGROUND).m10804a(BatteryState.NOT_LOW).m10805a(LoginState.LOGGED_IN).m10807a();
    }

    public final long mo792e() {
        return this.f10112d.a(AssetDownloadXConfig.f1667d, 21600000);
    }
}
