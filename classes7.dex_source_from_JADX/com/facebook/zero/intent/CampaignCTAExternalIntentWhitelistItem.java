package com.facebook.zero.intent;

import android.content.Intent;
import android.net.Uri;
import com.facebook.common.util.TriState;
import com.facebook.zero.common.intent.ExternalIntentWhitelistItem;
import com.facebook.zero.sdk.request.ZeroIndicatorData;
import com.facebook.zero.service.FbZeroIndicatorManager;
import com.google.common.base.Objects;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ृ */
public class CampaignCTAExternalIntentWhitelistItem implements ExternalIntentWhitelistItem {
    private final FbZeroIndicatorManager f108a;
    private Provider<Boolean> f109b;

    @Inject
    public CampaignCTAExternalIntentWhitelistItem(FbZeroIndicatorManager fbZeroIndicatorManager, Provider<Boolean> provider) {
        this.f108a = fbZeroIndicatorManager;
        this.f109b = provider;
    }

    public final TriState m98a(Intent intent) {
        if (!((Boolean) this.f109b.get()).booleanValue()) {
            return TriState.UNSET;
        }
        Uri data = intent.getData();
        if (data == null) {
            return TriState.UNSET;
        }
        ZeroIndicatorData c = this.f108a.c();
        if (c == null) {
            return TriState.UNSET;
        }
        if (Objects.equal(data.toString(), c.d())) {
            return TriState.YES;
        }
        return TriState.UNSET;
    }
}
