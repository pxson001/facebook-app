package com.facebook.assetdownload.local;

import android.content.Context;
import com.facebook.assetdownload.AssetDownloadConfiguration;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.mediastorage.MediaStorage;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.File;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: facebook.android@gmail.com */
public class DownloadLocalFileMapper {
    public static final Class<DownloadLocalFileMapper> f12345a = DownloadLocalFileMapper.class;
    private final MediaStorage f12346b;
    private final Context f12347c;
    private StatFsHelper f12348d;

    public static DownloadLocalFileMapper m13029b(InjectorLike injectorLike) {
        return new DownloadLocalFileMapper(MediaStorage.m13039a(injectorLike), (Context) injectorLike.getInstance(Context.class), StatFsHelperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DownloadLocalFileMapper(MediaStorage mediaStorage, Context context, StatFsHelper statFsHelper) {
        this.f12346b = mediaStorage;
        this.f12347c = context;
        this.f12348d = statFsHelper;
    }

    public final File m13036a(AssetDownloadConfiguration assetDownloadConfiguration, boolean z) {
        switch (1.a[assetDownloadConfiguration.mStorageConstraint.ordinal()]) {
            case 1:
                File file = null;
                File g = assetDownloadConfiguration.g();
                if (g == null) {
                    BLog.a(f12345a, "configuration has StorageConstraint.MUST_BE_CUSTOM_LOCATION but no customLocation: %s", new Object[]{assetDownloadConfiguration});
                } else if (!(z && g.exists() && !g.canWrite())) {
                    file = g;
                }
                return file;
            case 2:
                return m13033c(assetDownloadConfiguration, z);
            case 3:
                File d = m13034d(assetDownloadConfiguration, z);
                File c = m13033c(assetDownloadConfiguration, z);
                if (d == null) {
                    return c;
                }
                if (d.exists() || c == null || !c.exists()) {
                    return d;
                }
                return c;
            default:
                return null;
        }
    }

    public final boolean m13037a(AssetDownloadConfiguration assetDownloadConfiguration) {
        File a = m13036a(assetDownloadConfiguration, false);
        if (a == null || !a.exists()) {
            return false;
        }
        return true;
    }

    public final ImmutableList<File> m13035a() {
        File c = m13032c();
        Builder builder = new Builder();
        builder.c(m13030b());
        if (c != null) {
            builder.c(c);
        }
        return builder.b();
    }

    private static String m13031b(AssetDownloadConfiguration assetDownloadConfiguration) {
        return StringFormatUtil.a("%s%s.%s", new Object[]{"asset_", assetDownloadConfiguration.mIdentifier, "dat"});
    }

    private File m13033c(AssetDownloadConfiguration assetDownloadConfiguration, boolean z) {
        File file = new File(m13030b(), m13031b(assetDownloadConfiguration));
        if (!z || ((!file.exists() || file.canWrite()) && this.f12348d.a(StorageType.INTERNAL) >= 104857600)) {
            return file;
        }
        return null;
    }

    private File m13034d(AssetDownloadConfiguration assetDownloadConfiguration, boolean z) {
        File c = m13032c();
        if (c == null) {
            return null;
        }
        File file = new File(c, m13031b(assetDownloadConfiguration));
        if (z) {
            if (!MediaStorage.m13045b()) {
                return null;
            }
            if ((!file.exists() || file.canWrite()) && this.f12348d.a(StorageType.EXTERNAL) >= 104857600) {
                return file;
            }
            return null;
        } else if (MediaStorage.m13042a()) {
            return file;
        } else {
            return null;
        }
    }

    private File m13030b() {
        return new File(this.f12347c.getFilesDir(), "assetdownload");
    }

    @Nullable
    private File m13032c() {
        File externalFilesDir = this.f12347c.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        return new File(externalFilesDir, "assetdownload");
    }
}
