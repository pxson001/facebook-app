package com.facebook.vault.service;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.vault.prefs.BlacklistedSyncPathsPref;
import com.facebook.vault.prefs.VaultPrefKeys;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: thread */
class VaultManager$1 implements FutureCallback<OperationResult> {
    final /* synthetic */ VaultManager f1886a;

    VaultManager$1(VaultManager vaultManager) {
        this.f1886a = vaultManager;
    }

    public void onSuccess(Object obj) {
        String str = ((OperationResult) obj).c;
        BlacklistedSyncPathsPref blacklistedSyncPathsPref = this.f1886a.f;
        blacklistedSyncPathsPref.a.edit().a(VaultPrefKeys.j, str).a(VaultPrefKeys.k, blacklistedSyncPathsPref.c.a()).commit();
        VaultManager.e(this.f1886a);
    }

    public void onFailure(Throwable th) {
        new StringBuilder("Error fetching blacklisted sync paths: ").append(th.getMessage());
        this.f1886a.i.a("Error fetching blacklisted sync paths", StringFormatUtil.a("Error fetching blacklisted sync paths: %s", new Object[]{th.getMessage()}), th);
        VaultManager.e(this.f1886a);
    }
}
