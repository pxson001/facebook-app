package com.facebook.events.prefs;

import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: auth_type */
public class EventsPrefKeys implements IHaveNonCriticalKeysToClear, IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f19007a = ((PrefKey) f19016j.a("guest_list_invited_seen_state_megaphone"));
    public static final PrefKey f19008b = ((PrefKey) f19016j.a("locked_privacy_education"));
    public static final PrefKey f19009c = ((PrefKey) f19017k.a("events_cover_photo_selector_theme_nux"));
    public static final PrefKey f19010d = ((PrefKey) f19017k.a("events_interested_connection_nux"));
    public static final PrefKey f19011e = ((PrefKey) f19017k.a("events_invite_through_messenger_nux"));
    public static final PrefKey f19012f = ((PrefKey) f19017k.a("events_extended_invite_add_contacts_button_nux"));
    public static final PrefKey f19013g = ((PrefKey) f19017k.a("events_extended_invite_add_note_nux"));
    public static final PrefKey f19014h = ((PrefKey) f19017k.a("events_extended_invite_note_nux"));
    private static final PrefKey f19015i;
    private static final PrefKey f19016j;
    private static final PrefKey f19017k = ((PrefKey) f19015i.a("non_critical/"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("events/");
        f19015i = prefKey;
        f19016j = (PrefKey) prefKey.a("privacy_critical/");
    }

    public final ImmutableSet<PrefKey> m19247b() {
        return ImmutableSet.of(f19016j);
    }

    public final ImmutableSet<PrefKey> m19246a() {
        return ImmutableSet.of(f19017k);
    }
}
