package com.facebook.stickers.ui;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: e0c9df1fc4f8887f8f4648ec9031d017 */
public class Boolean_IsStickerPreviewDialogEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(974, false));
    }
}
