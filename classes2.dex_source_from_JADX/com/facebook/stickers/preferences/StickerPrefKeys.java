package com.facebook.stickers.preferences;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: time_elapsed_since_fetch_result */
public class StickerPrefKeys {
    public static final PrefKey f2921a;
    public static final PrefKey f2922b;
    public static final PrefKey f2923c;
    public static final PrefKey f2924d = ((PrefKey) f2922b.m2011a("page"));
    public static final PrefKey f2925e = ((PrefKey) f2922b.m2011a("scroll_position"));
    public static final PrefKey f2926f;
    public static final PrefKey f2927g;
    public static final PrefKey f2928h = ((PrefKey) f2926f.m2011a("unseen_pack_count"));
    public static final PrefKey f2929i = ((PrefKey) f2921a.m2011a("has_downloaded_sticker_pack"));
    public static final PrefKey f2930j;
    public static final PrefKey f2931k;
    public static final PrefKey f2932l = ((PrefKey) f2930j.m2011a("last_cleanup"));
    public static final PrefKey f2933m = ((PrefKey) f2930j.m2011a("last_asset_flush_xconfig_ver"));
    public static final PrefKey f2934n = ((PrefKey) f2930j.m2011a("last_asset_flush_check_time"));
    public static final PrefKey f2935o = ((PrefKey) f2930j.m2011a("last_asset_flush_completion_time"));
    public static final PrefKey f2936p = ((PrefKey) f2930j.m2011a("assets_download/"));
    public static final PrefKey f2937q = ((PrefKey) f2922b.m2011a("sticker_search_has_opened"));
    public static final PrefKey f2938r = ((PrefKey) f2921a.m2011a("sticker_in_comments_nux"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("stickers/");
        f2921a = prefKey;
        prefKey = (PrefKey) prefKey.m2011a("popup/");
        f2922b = prefKey;
        f2923c = (PrefKey) prefKey.m2011a("tab_id");
        prefKey = (PrefKey) f2921a.m2011a("store/");
        f2926f = prefKey;
        f2927g = (PrefKey) prefKey.m2011a("last_store_visit_time");
        prefKey = (PrefKey) f2921a.m2011a("background_task/");
        f2930j = prefKey;
        f2931k = (PrefKey) prefKey.m2011a("unused_file/");
    }
}
