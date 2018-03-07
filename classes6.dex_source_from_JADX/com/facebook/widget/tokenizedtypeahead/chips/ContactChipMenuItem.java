package com.facebook.widget.tokenizedtypeahead.chips;

import android.graphics.drawable.Drawable;
import com.facebook.user.model.User;
import com.facebook.user.tiles.UserTileDrawableController;
import com.facebook.user.tiles.UserTileView$OnUserTileUpdatedListener;
import javax.annotation.Nullable;

/* compiled from: com.facebook.push.mqtt.ipc.MqttPublishArrivedListener */
public class ContactChipMenuItem {
    public final User f20050a;
    public final String f20051b;
    public final String f20052c;
    public final UserTileDrawableController f20053d;
    public Drawable f20054e;

    /* compiled from: com.facebook.push.mqtt.ipc.MqttPublishArrivedListener */
    public class C15061 implements UserTileView$OnUserTileUpdatedListener {
        final /* synthetic */ ContactChipMenuItem f20049a;

        public C15061(ContactChipMenuItem contactChipMenuItem) {
            this.f20049a = contactChipMenuItem;
        }

        public final void mo1519a() {
            this.f20049a.f20054e = this.f20049a.f20053d.m;
        }
    }

    public ContactChipMenuItem(User user, @Nullable String str, @Nullable String str2, UserTileDrawableController userTileDrawableController) {
        this.f20050a = user;
        this.f20051b = str;
        this.f20052c = str2;
        this.f20053d = userTileDrawableController;
    }
}
