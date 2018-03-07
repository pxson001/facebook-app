package com.facebook.appupdate;

import java.io.File;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;

/* compiled from: UNPRESSING */
public class AppUpdateState implements Serializable {
    final long downloadId;
    public final long downloadProgress;
    public final long downloadSize;
    public final Throwable failureReason;
    public final long installLaunchTs;
    public final boolean isBackgroundMode;
    public final boolean isSelfUpdate;
    public final boolean isWifiOnly;
    public final File localFile;
    public final int operationState;
    public final String operationUuid;
    public final ReleaseInfo releaseInfo;

    /* compiled from: UNPRESSING */
    public class Builder {
        private final AppUpdateState f23804a;
        @Nullable
        private ReleaseInfo f23805b = null;
        public int f23806c = -1;
        public long f23807d = -1;
        public long f23808e = -1;
        public long f23809f = -1;
        @Nullable
        public File f23810g = null;
        @Nullable
        private Throwable f23811h = null;
        public long f23812i = -1;

        public Builder(AppUpdateState appUpdateState) {
            this.f23804a = appUpdateState;
        }

        public final Builder m25816a(int i) {
            this.f23806c = i;
            return this;
        }

        public final Builder m25817a(Throwable th) {
            this.f23811h = th;
            return this;
        }

        public final AppUpdateState m25818a() {
            return new AppUpdateState(this.f23805b == null ? this.f23804a.releaseInfo : this.f23805b, this.f23804a.isBackgroundMode, this.f23804a.isSelfUpdate, this.f23804a.isWifiOnly, this.f23806c == -1 ? this.f23804a.operationState : this.f23806c, this.f23804a.operationUuid, this.f23807d == -1 ? this.f23804a.downloadId : this.f23807d, this.f23808e == -1 ? this.f23804a.downloadProgress : this.f23808e, this.f23809f == -1 ? this.f23804a.downloadSize : this.f23809f, this.f23810g == null ? this.f23804a.localFile : this.f23810g, this.f23811h == null ? this.f23804a.failureReason : this.f23811h, this.f23812i == -1 ? this.f23804a.installLaunchTs : this.f23812i);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: UNPRESSING */
    public @interface UpdateState {
    }

    public AppUpdateState(ReleaseInfo releaseInfo, String str, boolean z, boolean z2, boolean z3) {
        this(releaseInfo, z, z2, z3, 0, str, -1, -1, -1, null, null, -1);
    }

    public AppUpdateState(ReleaseInfo releaseInfo, boolean z, boolean z2, boolean z3, int i, String str, long j, long j2, long j3, File file, Throwable th, long j4) {
        this.releaseInfo = releaseInfo;
        this.isBackgroundMode = z;
        this.isSelfUpdate = z2;
        this.isWifiOnly = z3;
        this.operationState = i;
        this.operationUuid = str;
        this.downloadId = j;
        this.downloadProgress = j2;
        this.downloadSize = j3;
        this.localFile = file;
        this.failureReason = th;
        this.installLaunchTs = j4;
    }
}
