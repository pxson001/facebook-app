package com.facebook.vault.service;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiException;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.vault.model.FacebookVaultDevice;
import com.facebook.vault.prefs.DeviceCreationTimePref;
import com.facebook.vault.prefs.DeviceIDPref;
import com.facebook.vault.prefs.LastSyncedDatePref;
import com.facebook.vault.prefs.SyncModePref;
import com.facebook.vault.prefs.SyncOldPhotoPref;
import com.facebook.vault.prefs.VaultPrefKeys;
import com.facebook.vault.protocol.VaultDeviceGetMethod;
import com.facebook.vault.protocol.VaultDeviceGetParams;
import com.facebook.vault.protocol.VaultDevicePostMethod;
import com.facebook.vault.protocol.VaultDevicePostParams;
import com.facebook.vault.protocol.VaultDeviceUpdateMethod;
import com.facebook.vault.protocol.VaultDeviceUpdateParams;
import javax.inject.Inject;

/* compiled from: floating */
public class VaultDeviceSetup {
    private static final String f11519a = VaultDeviceSetup.class.getSimpleName();
    private final AbstractSingleMethodRunner f11520b;
    private final VaultDevicePostMethod f11521c;
    private final VaultDeviceGetMethod f11522d;
    private final VaultDeviceUpdateMethod f11523e;
    private final UniqueIdForDeviceHolderImpl f11524f;
    private long f11525g = this.f11527i.m9821a();
    private long f11526h = this.f11528j.m12124a();
    private DeviceIDPref f11527i;
    private LastSyncedDatePref f11528j;
    private DeviceCreationTimePref f11529k;
    private SyncOldPhotoPref f11530l;
    private SyncModePref f11531m;
    private VaultManager f11532n;
    private final AbstractFbErrorReporter f11533o;

    public static VaultDeviceSetup m12012b(InjectorLike injectorLike) {
        return new VaultDeviceSetup((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), new VaultDevicePostMethod(JsonFactoryMethodAutoProvider.a(injectorLike)), VaultDeviceGetMethod.m12116b(injectorLike), VaultDeviceUpdateMethod.m12119a(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike), DeviceIDPref.m9819a(injectorLike), LastSyncedDatePref.m12122a(injectorLike), DeviceCreationTimePref.m12087a(injectorLike), SyncOldPhotoPref.m12126a(injectorLike), SyncModePref.m9802a(injectorLike), VaultManager.m9796a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public VaultDeviceSetup(AbstractSingleMethodRunner abstractSingleMethodRunner, VaultDevicePostMethod vaultDevicePostMethod, VaultDeviceGetMethod vaultDeviceGetMethod, VaultDeviceUpdateMethod vaultDeviceUpdateMethod, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl, DeviceIDPref deviceIDPref, LastSyncedDatePref lastSyncedDatePref, DeviceCreationTimePref deviceCreationTimePref, SyncOldPhotoPref syncOldPhotoPref, SyncModePref syncModePref, VaultManager vaultManager, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f11520b = abstractSingleMethodRunner;
        this.f11521c = vaultDevicePostMethod;
        this.f11522d = vaultDeviceGetMethod;
        this.f11523e = vaultDeviceUpdateMethod;
        this.f11524f = uniqueIdForDeviceHolderImpl;
        this.f11527i = deviceIDPref;
        this.f11528j = lastSyncedDatePref;
        this.f11529k = deviceCreationTimePref;
        this.f11530l = syncOldPhotoPref;
        this.f11531m = syncModePref;
        this.f11532n = vaultManager;
        this.f11533o = abstractFbErrorReporter;
    }

    public final boolean m12016a() {
        return this.f11525g > 0;
    }

    public final boolean m12017b() {
        Object vaultDevicePostParams;
        String a = this.f11524f.a();
        String a2 = this.f11531m.m9804a();
        boolean a3 = this.f11530l.m12129a();
        if (FacebookVaultDevice.m12371a(a2)) {
            vaultDevicePostParams = new VaultDevicePostParams(a, true, a2, a3);
        } else {
            vaultDevicePostParams = new VaultDevicePostParams(a);
        }
        try {
            FacebookVaultDevice facebookVaultDevice = (FacebookVaultDevice) this.f11520b.a(this.f11521c, vaultDevicePostParams);
            if (facebookVaultDevice != null) {
                this.f11525g = facebookVaultDevice.mFbid;
                m12013e();
                if (facebookVaultDevice.mLastSyncTime > 0) {
                    Long.valueOf(this.f11525g);
                    Long.valueOf(facebookVaultDevice.mLastSyncTime);
                    this.f11526h = facebookVaultDevice.mLastSyncTime * 1000;
                    this.f11528j.m12125a(this.f11526h);
                    this.f11529k.m12089a(facebookVaultDevice.mTimeCreated * 1000);
                    this.f11530l.m12128a(facebookVaultDevice.mSyncOlderPhotos);
                    return true;
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j = currentTimeMillis / 1000;
                this.f11526h = currentTimeMillis;
                this.f11528j.m12125a(this.f11526h);
                this.f11529k.m12089a(currentTimeMillis);
                m12014a(this.f11525g, j);
                Long.valueOf(this.f11525g);
                Long.valueOf(currentTimeMillis);
                return false;
            }
        } catch (Throwable e) {
            BLog.b(f11519a, "setupAndUpdateDeviceFromServer", e);
            if (e instanceof ApiException) {
                this.f11533o.a(f11519a, "exception when running mDevicePostMethod", e);
            }
        }
        return false;
    }

    public final boolean m12018c() {
        try {
            FacebookVaultDevice facebookVaultDevice = (FacebookVaultDevice) this.f11520b.a(this.f11522d, new VaultDeviceGetParams(this.f11524f.a()));
            if (facebookVaultDevice != null) {
                this.f11525g = facebookVaultDevice.mFbid;
                this.f11526h = facebookVaultDevice.mLastSyncTime * 1000;
                if (!facebookVaultDevice.mEnabled) {
                    this.f11531m.m9805a("OFF");
                    this.f11532n.m9800a();
                } else if (FacebookVaultDevice.m12371a(facebookVaultDevice.mSyncMode)) {
                    this.f11531m.m9805a(facebookVaultDevice.mSyncMode);
                    this.f11532n.m9800a();
                } else {
                    BLog.b(f11519a, "invalid sync mode for device: " + facebookVaultDevice.mSyncMode);
                    this.f11533o.a("vault_device_setup bad sync mode", "invalid sync mode for device: " + facebookVaultDevice.mSyncMode);
                    return false;
                }
                m12013e();
                this.f11529k.m12089a(facebookVaultDevice.mTimeCreated * 1000);
                this.f11530l.m12128a(facebookVaultDevice.mSyncOlderPhotos);
                return true;
            }
        } catch (Throwable e) {
            BLog.b(f11519a, "setupDeviceFromServer", e);
            if (e instanceof ApiException) {
                this.f11533o.a(f11519a, "exception when running mDevicePostMethod", e);
            }
        }
        return false;
    }

    public final boolean m12019d() {
        boolean z = false;
        long a = this.f11527i.m9821a();
        String a2 = this.f11531m.m9804a();
        boolean z2 = !a2.equals("OFF") ? true : z;
        Long.valueOf(a);
        VaultDeviceUpdateParams vaultDeviceUpdateParams = new VaultDeviceUpdateParams(a);
        vaultDeviceUpdateParams.a(z2);
        if (z2) {
            vaultDeviceUpdateParams.a(a2);
        }
        try {
            z = ((Boolean) this.f11520b.a(this.f11523e, vaultDeviceUpdateParams)).booleanValue();
        } catch (Throwable e) {
            BLog.b(f11519a, "updateDeviceEnabledOnServer", e);
            if (e instanceof ApiException) {
                this.f11533o.a("vault_device_update_api exception: " + e.getMessage(), e.getMessage(), e);
            }
        }
        return z;
    }

    public final void m12014a(long j, long j2) {
        VaultDeviceUpdateParams vaultDeviceUpdateParams = new VaultDeviceUpdateParams(j);
        vaultDeviceUpdateParams.a(j2 / 1000);
        try {
            this.f11520b.a(this.f11523e, vaultDeviceUpdateParams);
        } catch (Throwable e) {
            BLog.b(f11519a, "updateDeviceLastSyncOnServer", e);
            if (e instanceof ApiException) {
                this.f11533o.a("vault_device_update_api exception", e.getMessage());
            }
        }
    }

    public final void m12015a(long j, boolean z) {
        VaultDeviceUpdateParams vaultDeviceUpdateParams = new VaultDeviceUpdateParams(j);
        vaultDeviceUpdateParams.b(z);
        try {
            this.f11520b.a(this.f11523e, vaultDeviceUpdateParams);
        } catch (Throwable e) {
            BLog.b(f11519a, "updateDeviceSyncOlderPhotosOnServer", e);
            if (e instanceof ApiException) {
                this.f11533o.a("vault_device_update_api exception", e.getMessage());
            }
        }
    }

    private void m12013e() {
        DeviceIDPref deviceIDPref = this.f11527i;
        long j = this.f11525g;
        Editor edit = deviceIDPref.f9440a.edit();
        edit.a(VaultPrefKeys.f11554i, j);
        edit.commit();
        Long.valueOf(this.f11525g);
    }
}
