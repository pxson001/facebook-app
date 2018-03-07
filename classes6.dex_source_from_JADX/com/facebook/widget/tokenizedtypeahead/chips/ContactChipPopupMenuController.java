package com.facebook.widget.tokenizedtypeahead.chips;

import android.content.Context;
import android.view.View;
import com.facebook.orca.contacts.picker.UserTokenFactory.1;
import com.facebook.user.tiles.UserTileDrawableController;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.push.mqtt.ipc.IMqttPushService */
public class ContactChipPopupMenuController {
    private final Provider<UserTileDrawableController> f20069a;
    private final ContactChipUserStringUtil f20070b;

    @Inject
    public ContactChipPopupMenuController(Provider<UserTileDrawableController> provider, ContactChipUserStringUtil contactChipUserStringUtil) {
        this.f20069a = provider;
        this.f20070b = contactChipUserStringUtil;
    }

    public final void m28745a(Context context, ContactChipToken contactChipToken, boolean z, View view, int i, int i2, @Nullable Integer num, @Nullable 1 1) {
        ContactChipPopupMenu contactChipPopupMenu = new ContactChipPopupMenu(context, contactChipToken, z, (UserTileDrawableController) this.f20069a.get(), this.f20070b);
        contactChipPopupMenu.f20068h = num;
        contactChipPopupMenu.f20066f = 1;
        contactChipPopupMenu.m28744a(view, i, i2);
    }
}
