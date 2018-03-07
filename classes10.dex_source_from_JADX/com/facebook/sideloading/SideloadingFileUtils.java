package com.facebook.sideloading;

import android.app.DownloadManager;
import com.facebook.common.android.DownloadManagerMethodAutoProvider;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import java.io.File;
import java.net.URI;
import javax.inject.Inject;

/* compiled from: has_clicked_on_cover_photo_selector */
public class SideloadingFileUtils {
    private static final Class<?> f10029a = SideloadingFileUtils.class;
    private final MoreFileUtils f10030b;
    private final FbSharedPreferences f10031c;
    private final DownloadManager f10032d;

    public static SideloadingFileUtils m10115b(InjectorLike injectorLike) {
        return new SideloadingFileUtils(MoreFileUtils.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DownloadManagerMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public SideloadingFileUtils(MoreFileUtils moreFileUtils, FbSharedPreferences fbSharedPreferences, DownloadManager downloadManager) {
        this.f10030b = moreFileUtils;
        this.f10031c = fbSharedPreferences;
        this.f10032d = downloadManager;
    }

    public final void m10118a(String str) {
        long a = this.f10031c.a(SideloadingPrefKeys.m10158b(str), -1);
        if (a != -1) {
            try {
                this.f10032d.remove(new long[]{a});
            } catch (Exception e) {
                Long.valueOf(a);
                return;
            }
        }
        String a2 = this.f10031c.a(SideloadingPrefKeys.m10159d(str), null);
        if (a2 != null) {
            m10117d(a2);
        }
        this.f10031c.edit().b(SideloadingPrefKeys.m10157a(str)).commit();
    }

    public final boolean m10119b(String str) {
        if (m10116c(this.f10031c.a(SideloadingPrefKeys.m10159d(str), null)) && this.f10031c.a(SideloadingPrefKeys.m10161f(str), "application/vnd.android.package-archive").equals("application/vnd.android.package-archive")) {
            return true;
        }
        return false;
    }

    private boolean m10116c(String str) {
        try {
            File a;
            URI uri = new URI(str);
            if (uri.isAbsolute()) {
                a = MoreFileUtils.a(uri);
            } else {
                a = MoreFileUtils.a(str);
            }
            if (a == null || !a.exists()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean m10117d(String str) {
        try {
            File a;
            URI uri = new URI(str);
            if (uri.isAbsolute() && "file".equals(uri.getScheme())) {
                try {
                    a = MoreFileUtils.a(uri);
                } catch (IllegalArgumentException e) {
                    a = null;
                }
            } else {
                a = MoreFileUtils.a(str);
            }
            if (a == null || !a.delete()) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }
}
