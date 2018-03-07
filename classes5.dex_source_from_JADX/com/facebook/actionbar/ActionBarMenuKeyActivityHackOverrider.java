package com.facebook.actionbar;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Window;
import com.facebook.base.activity.AbstractFbActivityOverrider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: bd_friends_tab */
public class ActionBarMenuKeyActivityHackOverrider extends AbstractFbActivityOverrider {
    private final GatekeeperStoreImpl f8004a;

    @Inject
    public ActionBarMenuKeyActivityHackOverrider(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f8004a = gatekeeperStoreImpl;
    }

    public final Optional<Boolean> m14139b(Activity activity, int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82) {
            return Absent.INSTANCE;
        }
        if (!this.f8004a.a(8, false)) {
            return Absent.INSTANCE;
        }
        Window window = activity.getWindow();
        window.closePanel(0);
        window.openPanel(0, keyEvent);
        return Optional.fromNullable(Boolean.valueOf(true));
    }
}
