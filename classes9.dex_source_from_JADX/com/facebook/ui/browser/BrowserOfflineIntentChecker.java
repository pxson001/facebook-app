package com.facebook.ui.browser;

import android.content.Intent;
import com.facebook.attachments.angora.actionbutton.SavedOfflineSnackbarActionControllerProvider;
import com.facebook.browser.lite.BrowserLiteActivity;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.offlinemode.intentchecker.OfflineIntentChecker;
import com.facebook.offlinemode.ui.OfflineSnackbarActionController;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: topic_feeds_composer_start */
public class BrowserOfflineIntentChecker implements OfflineIntentChecker {
    private final Provider<TriState> f1516a;
    private final SavedOfflineSnackbarActionControllerProvider f1517b;
    private final GatekeeperStoreImpl f1518c;

    @Inject
    public BrowserOfflineIntentChecker(SavedOfflineSnackbarActionControllerProvider savedOfflineSnackbarActionControllerProvider, Provider<TriState> provider, GatekeeperStore gatekeeperStore) {
        this.f1517b = savedOfflineSnackbarActionControllerProvider;
        this.f1516a = provider;
        this.f1518c = gatekeeperStore;
    }

    public final boolean m1584a(Intent intent) {
        if (intent.getComponent() == null || !this.f1518c.a(21, false)) {
            return false;
        }
        String className = intent.getComponent().getClassName();
        String name = BrowserActivity.class.getName();
        String name2 = BrowserLiteActivity.class.getName();
        if (StringUtil.a(className, name) || StringUtil.a(className, name2)) {
            return true;
        }
        return false;
    }

    public final boolean m1583a() {
        return true;
    }

    @Nullable
    public final OfflineSnackbarActionController m1585b(Intent intent) {
        if (!((TriState) this.f1516a.get()).asBoolean(false)) {
            return null;
        }
        if (!intent.hasExtra("parent_story_id") && intent.getData().toString() == null) {
            return null;
        }
        if (intent.hasExtra("parent_story_id")) {
            return this.f1517b.a(intent.getStringExtra("parent_story_id"), null, null, null, intent.getStringExtra("tracking_codes"));
        }
        return this.f1517b.a(null, null, intent.getData().toString(), null, intent.getStringExtra("tracking_codes"));
    }
}
