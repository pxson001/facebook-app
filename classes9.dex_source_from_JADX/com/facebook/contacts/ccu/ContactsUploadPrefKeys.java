package com.facebook.contacts.ccu;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: profile/edit/questions/.* */
public class ContactsUploadPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f6220a = ((PrefKey) f6225f.a("last_upload_success_timestamp"));
    public static final PrefKey f6221b = ((PrefKey) f6225f.a("last_upload_client_root_hash"));
    public static final PrefKey f6222c = ((PrefKey) f6226g.a("scoped_continuous_upload_status"));
    public static final PrefKey f6223d = ((PrefKey) f6227h.a("continuous_import"));
    public static final PrefKey f6224e = ((PrefKey) f6225f.a("synced_ccu_setting_with_server"));
    private static final PrefKey f6225f = ((PrefKey) SharedPrefKeys.a.a("contacts_ccu_upload/"));
    private static final PrefKey f6226g = ((PrefKey) SharedPrefKeys.c.a("contacts_ccu_persist/"));
    private static final PrefKey f6227h = ((PrefKey) SharedPrefKeys.c.a("contacts_persist/"));

    public static ContactsUploadPrefKeys m6534a(InjectorLike injectorLike) {
        return new ContactsUploadPrefKeys();
    }

    public final ImmutableSet<PrefKey> m6535b() {
        return ImmutableSet.of(f6225f);
    }
}
