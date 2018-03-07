package com.facebook.contacts.service;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.init.AppInitLock;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;

/* compiled from: oxygen_map_here_upsell_dialog_map_image_download_success */
public class ContactLocaleChangeService extends FbIntentService {
    private static final Class<?> f8496a = ContactLocaleChangeService.class;

    public ContactLocaleChangeService() {
        super(f8496a.getSimpleName());
    }

    protected final void m12306a(Intent intent) {
        new StringBuilder("Received intent: %s").append(intent);
        FbInjector a = a();
        AppInitLock.a(a).b();
        DefaultBlueServiceOperationFactory b = DefaultBlueServiceOperationFactory.b(a);
        if (IdBasedProvider.a(a, 3595).get() != null) {
            Bundle bundle = new Bundle();
            BlueServiceOperationFactoryDetour.a(b, "reindex_omnistore_contacts", bundle, -911603083).a(true).a();
            BlueServiceOperationFactoryDetour.a(b, "mark_full_contact_sync_required", bundle, -1292308584).a(true).a();
            BlueServiceOperationFactoryDetour.a(b, "sync_contacts_partial", bundle, 720721122).a(true).a();
            new StringBuilder("Done handling intent: %s").append(intent);
        }
    }
}
