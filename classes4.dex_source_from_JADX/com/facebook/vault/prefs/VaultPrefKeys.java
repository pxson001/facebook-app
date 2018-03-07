package com.facebook.vault.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: first_visible_item_index */
public class VaultPrefKeys {
    public static final PrefKey f11546a;
    public static final PrefKey f11547b;
    public static final PrefKey f11548c = ((PrefKey) f11546a.a("upload_state"));
    public static final PrefKey f11549d = ((PrefKey) f11546a.a("sync_old_photo"));
    public static final PrefKey f11550e = ((PrefKey) f11546a.a("retry_millis"));
    public static final PrefKey f11551f = ((PrefKey) f11546a.a("sync_mode"));
    public static final PrefKey f11552g = ((PrefKey) f11546a.a("device_created_time"));
    public static final PrefKey f11553h = ((PrefKey) f11546a.a("last_synced_date"));
    public static final PrefKey f11554i = ((PrefKey) f11546a.a("device_fbid"));
    public static final PrefKey f11555j = ((PrefKey) f11546a.a("vault_blacklisted_sync_paths"));
    public static final PrefKey f11556k = ((PrefKey) f11546a.a("last_blacklist_synced_time"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.e.a("vault/");
        f11546a = prefKey;
        f11547b = (PrefKey) prefKey.a("vault_table_cutoff_time");
    }
}
