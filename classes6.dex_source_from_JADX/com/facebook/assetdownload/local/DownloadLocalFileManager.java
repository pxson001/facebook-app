package com.facebook.assetdownload.local;

import com.facebook.assetdownload.AssetDownloadConfiguration;
import com.facebook.assetdownload.AssetDownloadConfiguration.StorageConstraint;
import com.facebook.assetdownload.repository.AssetDownloadConfigurationRepository;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.io.Files;
import java.io.File;
import javax.inject.Inject;

/* compiled from: profile_pic_revert_temporary */
public class DownloadLocalFileManager {
    private static final Class<?> f7320a = DownloadLocalFileManager.class;
    private final DownloadLocalFileMapper f7321b;
    private final AbstractFbErrorReporter f7322c;
    private final Clock f7323d;
    private final MoreFileUtils f7324e;
    private final Lazy<AssetDownloadConfigurationRepository> f7325f;

    public static DownloadLocalFileManager m10425b(InjectorLike injectorLike) {
        return new DownloadLocalFileManager(DownloadLocalFileMapper.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), MoreFileUtils.a(injectorLike), IdBasedLazy.a(injectorLike, 313));
    }

    @Inject
    public DownloadLocalFileManager(DownloadLocalFileMapper downloadLocalFileMapper, FbErrorReporter fbErrorReporter, Clock clock, MoreFileUtils moreFileUtils, Lazy<AssetDownloadConfigurationRepository> lazy) {
        this.f7321b = downloadLocalFileMapper;
        this.f7322c = fbErrorReporter;
        this.f7323d = clock;
        this.f7324e = moreFileUtils;
        this.f7325f = lazy;
    }

    public final File m10427a(AssetDownloadConfiguration assetDownloadConfiguration, File file, boolean z) {
        if (this.f7321b.a(assetDownloadConfiguration) && !z) {
            return null;
        }
        File a = this.f7321b.a(assetDownloadConfiguration, true);
        if (a == null) {
            BLog.a(f7320a, "destination is null; perhaps no accessible storage is available.");
            return null;
        } else if (!file.exists()) {
            this.f7322c.a("assetdownload:copyToLocalFile source_file_does_not_exist", StringFormatUtil.a("Source file: %s", new Object[]{file.getPath()}));
            return null;
        } else if (!a.exists() || a.canWrite()) {
            try {
                if (assetDownloadConfiguration.m10375d() == StorageConstraint.MUST_BE_CUSTOM_LOCATION) {
                    Files.c(a);
                } else {
                    m10426a();
                }
                Files.a(file, a);
                return a;
            } catch (Throwable e) {
                this.f7322c.a("assetdownload:copyToLocalFile io_exception_during_copy", e.getLocalizedMessage(), e);
                return null;
            }
        } else {
            this.f7322c.a("assetdownload:copyToLocalFile destination_file_is_not_writable", StringFormatUtil.a("Destination file: %s", new Object[]{a.getPath()}));
            return null;
        }
    }

    public final ImmutableList<File> m10426a() {
        ImmutableList a = this.f7321b.a();
        Builder builder = new Builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            File file = (File) a.get(i);
            int i2;
            if (file.exists()) {
                if (!file.isDirectory()) {
                    this.f7322c.a("assetdownload:setupLocalDirectories path_exists_and_is_a_file", StringFormatUtil.a("Directory path is a file: %s", new Object[]{file.getPath()}));
                }
                if (!file.canWrite() || file.setWritable(true)) {
                    i2 = true;
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    builder.c(file);
                } else {
                    BLog.a(f7320a, "Failed to set directory writable: %s", new Object[]{file.getPath()});
                }
            } else {
                if (!file.mkdirs()) {
                    this.f7322c.a("assetdownload:setupLocalDirectories mkdirs_failed", StringFormatUtil.a("Failed to create directory: %s", new Object[]{file.getPath()}));
                }
                if (file.canWrite()) {
                }
                i2 = true;
                if (i2 == 0) {
                    BLog.a(f7320a, "Failed to set directory writable: %s", new Object[]{file.getPath()});
                } else {
                    builder.c(file);
                }
            }
        }
        return builder.b();
    }

    public final boolean m10428a(AssetDownloadConfiguration assetDownloadConfiguration) {
        return this.f7321b.a(assetDownloadConfiguration);
    }

    public final long m10429b() {
        ImmutableList a = this.f7321b.a();
        long j = 0;
        for (int i = 0; i < a.size(); i++) {
            j += this.f7324e.d((File) a.get(i));
        }
        return j;
    }

    public final long m10430c() {
        ImmutableList a = ((AssetDownloadConfigurationRepository) this.f7325f.get()).a();
        long j = 0;
        int size = a.size();
        int i = 0;
        while (i < size) {
            long j2;
            AssetDownloadConfiguration assetDownloadConfiguration = (AssetDownloadConfiguration) a.get(i);
            if (assetDownloadConfiguration.mStorageConstraint != StorageConstraint.MUST_BE_CUSTOM_LOCATION || assetDownloadConfiguration.m10377g() == null) {
                j2 = j;
            } else {
                j2 = assetDownloadConfiguration.m10377g().length() + j;
            }
            i++;
            j = j2;
        }
        return j;
    }
}
