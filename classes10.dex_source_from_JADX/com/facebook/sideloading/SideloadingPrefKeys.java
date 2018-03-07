package com.facebook.sideloading;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: hasClickedOnCoverPhotoThemes */
public class SideloadingPrefKeys {
    public static final PrefKey f10086a;
    public static final PrefKey f10087b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("sideloading/");
        f10086a = prefKey;
        f10087b = (PrefKey) prefKey.a("download");
    }

    public static PrefKey m10157a(String str) {
        return (PrefKey) f10087b.a(str);
    }

    public static PrefKey m10158b(String str) {
        return (PrefKey) m10157a(str).a("download_id");
    }

    public static PrefKey m10159d(String str) {
        return (PrefKey) m10157a(str).a("local_file");
    }

    public static PrefKey m10160e(String str) {
        return (PrefKey) m10157a(str).a("file_size");
    }

    public static PrefKey m10161f(String str) {
        return (PrefKey) m10157a(str).a("mimetype");
    }

    public static PrefKey m10162g(String str) {
        return (PrefKey) m10157a(str).a("download_status");
    }
}
