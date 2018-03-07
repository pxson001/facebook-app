package com.facebook.contacts.upload.prefs;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: groupThreadId */
public class ContactsUploadPrefKeys implements IHavePrivacyCriticalKeysToClear {
    @Deprecated
    static final PrefKey f10958a = ((PrefKey) f10977t.a("continuous_import"));
    public static final PrefKey f10959b = ((PrefKey) f10978u.a("continuous_import"));
    public static final PrefKey f10960c = ((PrefKey) f10977t.a("starting_contact_import"));
    public static final PrefKey f10961d = ((PrefKey) f10977t.a("contacts_upload_running"));
    public static final PrefKey f10962e = ((PrefKey) f10977t.a("upload_contacts_batch_size"));
    public static final PrefKey f10963f = ((PrefKey) f10976s.a("last_full_upload_success_timestamp"));
    public static final PrefKey f10964g = ((PrefKey) f10976s.a("first_full_upload_success_timestamp"));
    public static final PrefKey f10965h = ((PrefKey) f10978u.a("last_contacts_upload_attempt_timestamp"));
    public static final PrefKey f10966i = ((PrefKey) f10976s.a("last_phone_address_book_update"));
    public static final PrefKey f10967j = ((PrefKey) f10976s.a("phone_address_book_version_hash"));
    public static final PrefKey f10968k = ((PrefKey) f10976s.a("last_upload_client_root_hash"));
    public static final PrefKey f10969l = ((PrefKey) f10976s.a("continuous_import_upsell_decline_ms"));
    public static final PrefKey f10970m = ((PrefKey) f10976s.a("continuous_import_upsell_decline_count"));
    public static final PrefKey f10971n = ((PrefKey) f10976s.a("continuous_import_upsell_completed_version"));
    public static final PrefKey f10972o = ((PrefKey) f10976s.a("contacts_upload_import_id"));
    public static final PrefKey f10973p = ((PrefKey) f10976s.a("has_seen_contacts_upload_dialog"));
    public static final PrefKey f10974q = ((PrefKey) f10976s.a("contacts_upload_dialog_show_generic_error_screen"));
    public static final PrefKey f10975r = ((PrefKey) f10976s.a("new_contacts_count_for_tab_badge"));
    private static final PrefKey f10976s = ((PrefKey) SharedPrefKeys.a.a("contacts_upload/"));
    private static final PrefKey f10977t = ((PrefKey) SharedPrefKeys.c.a("contacts/"));
    private static final PrefKey f10978u = ((PrefKey) SharedPrefKeys.c.a("contacts_persist/"));

    public final ImmutableSet<PrefKey> m11420b() {
        return ImmutableSet.of(f10976s, f10977t);
    }
}
