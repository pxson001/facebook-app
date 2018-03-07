package com.facebook.assetdownload.background;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.assetdownload.AssetDownloadConfiguration;
import com.facebook.assetdownload.AssetDownloadHandler;
import com.facebook.assetdownload.STATICDI_MULTIBIND_PROVIDER$AssetDownloadHandler;
import com.facebook.assetdownload.local.DownloadLocalFileManager;
import com.facebook.assetdownload.logging.AssetDownloadLogger;
import com.facebook.assetdownload.remote.DownloadExecutionRequest;
import com.facebook.assetdownload.remote.DownloadExecutionResult;
import com.facebook.assetdownload.remote.DownloadExecutor;
import com.facebook.assetdownload.repository.AssetDownloadConfigurationRepository;
import com.facebook.common.android.ConnectivityManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.inject.Inject;

/* compiled from: profile_question_tapped_cancel */
public class AssetDownloadRunner {
    private static final Class f7277a = AssetDownloadRunner.class;
    public final Clock f7278b;
    private final MonotonicClock f7279c;
    private final AssetDownloadScheduler f7280d;
    private final DownloadExecutor f7281e;
    private final AssetDownloadConfigurationRepository f7282f;
    private final ConnectivityManager f7283g;
    private final TempFileManager f7284h;
    private final DownloadLocalFileManager f7285i;
    private final AbstractFbErrorReporter f7286j;
    private final DefaultAndroidThreadUtil f7287k;
    private final Set<AssetDownloadHandler> f7288l;
    private final AssetDownloadLogger f7289m;
    public final HashSet<EligibilityCallback> f7290n = Sets.a();
    public TimeLimitEligibilityCallback f7291o;
    public DataLimitEligibilityCallback f7292p;
    public DataLimitEligibilityCallback f7293q;
    private FailureCountEligibilityCallback f7294r;

    /* compiled from: profile_question_tapped_cancel */
    public interface EligibilityCallback {
        boolean mo903a();

        void mo904b();

        String mo905c();
    }

    /* compiled from: profile_question_tapped_cancel */
    public class DataLimitEligibilityCallback implements EligibilityCallback {
        private long f7270a;
        private final long f7271b;

        public DataLimitEligibilityCallback(long j) {
            this.f7271b = j;
            mo904b();
        }

        public final boolean mo903a() {
            return this.f7270a < this.f7271b;
        }

        public final void mo904b() {
            this.f7270a = 0;
        }

        public final void m10393a(long j) {
            this.f7270a += j;
        }

        public final String mo905c() {
            return "DataLimit";
        }
    }

    /* compiled from: profile_question_tapped_cancel */
    public class FailureCountEligibilityCallback implements EligibilityCallback {
        private final int f7272a;
        public int f7273b;

        public FailureCountEligibilityCallback(int i) {
            this.f7272a = i;
            mo904b();
        }

        public final boolean mo903a() {
            return this.f7273b <= this.f7272a;
        }

        public final void mo904b() {
            this.f7273b = 0;
        }

        public final String mo905c() {
            return "FailureCount";
        }
    }

    /* compiled from: profile_question_tapped_cancel */
    public class TimeLimitEligibilityCallback implements EligibilityCallback {
        private final Clock f7274a;
        private final long f7275b;
        private long f7276c;

        public TimeLimitEligibilityCallback(Clock clock, long j) {
            this.f7274a = clock;
            this.f7275b = j;
            mo904b();
        }

        public final void mo904b() {
            this.f7276c = this.f7274a.a() + this.f7275b;
        }

        public final boolean mo903a() {
            return this.f7274a.a() <= this.f7276c;
        }

        public final String mo905c() {
            return "TimeLimit";
        }
    }

    public static AssetDownloadRunner m10406b(InjectorLike injectorLike) {
        return new AssetDownloadRunner((Clock) SystemClockMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), AssetDownloadScheduler.m10415b(injectorLike), DownloadExecutor.m10446b(injectorLike), AssetDownloadConfigurationRepository.b(injectorLike), ConnectivityManagerMethodAutoProvider.b(injectorLike), TempFileManager.a(injectorLike), DownloadLocalFileManager.m10425b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), STATICDI_MULTIBIND_PROVIDER$AssetDownloadHandler.m10384a(injectorLike), AssetDownloadLogger.m10432a(injectorLike));
    }

    @Inject
    public AssetDownloadRunner(Clock clock, MonotonicClock monotonicClock, AssetDownloadScheduler assetDownloadScheduler, DownloadExecutor downloadExecutor, AssetDownloadConfigurationRepository assetDownloadConfigurationRepository, ConnectivityManager connectivityManager, TempFileManager tempFileManager, DownloadLocalFileManager downloadLocalFileManager, FbErrorReporter fbErrorReporter, AndroidThreadUtil androidThreadUtil, Set<AssetDownloadHandler> set, AssetDownloadLogger assetDownloadLogger) {
        this.f7278b = clock;
        this.f7279c = monotonicClock;
        this.f7280d = assetDownloadScheduler;
        this.f7281e = downloadExecutor;
        this.f7282f = assetDownloadConfigurationRepository;
        this.f7283g = connectivityManager;
        this.f7284h = tempFileManager;
        this.f7285i = downloadLocalFileManager;
        this.f7286j = fbErrorReporter;
        this.f7287k = androidThreadUtil;
        this.f7288l = set;
        this.f7289m = assetDownloadLogger;
        m10413b();
    }

    public final boolean m10412a() {
        int i;
        int i2;
        Exception e;
        this.f7287k.b();
        long now = this.f7279c.now();
        this.f7285i.m10426a();
        m10407c();
        int i3 = 0;
        int i4 = 0;
        long j = 0;
        while (m10408d()) {
            long now2 = this.f7279c.now();
            boolean e2 = m10409e();
            AssetDownloadConfiguration a = this.f7280d.m10416a(m10409e());
            Boolean.valueOf(e2);
            if (a == null) {
                break;
            } else if (a.m10373a() == null) {
                this.f7286j.a("assetdownload_runner_source_null", StringFormatUtil.a("currentConfig: %s", new Object[]{a}));
                this.f7282f.b(a.m10376e(), this.f7278b.a());
                this.f7280d.m10417a(a);
            } else {
                int i5 = i3 + 1;
                if (this.f7285i.m10428a(a)) {
                    this.f7282f.a(a.m10376e(), this.f7278b.a());
                    this.f7280d.m10417a(a);
                    i3 = i5;
                } else {
                    File a2 = m10403a(a);
                    DownloadExecutionRequest downloadExecutionRequest = new DownloadExecutionRequest(a, a2);
                    if (a2 == null) {
                        m10405a("assetdownload_runner_tempfile_null", new IOException("tempFile is null"), downloadExecutionRequest);
                        i = i5;
                        break;
                    }
                    ListenableFuture a3 = this.f7281e.m10447a(downloadExecutionRequest);
                    this.f7280d.m10417a(a);
                    long j2;
                    try {
                        DownloadExecutionResult downloadExecutionResult = (DownloadExecutionResult) FutureDetour.a(a3, 30000, TimeUnit.MILLISECONDS, -1678736490);
                        if (m10409e() && this.f7292p != null) {
                            this.f7292p.m10393a(downloadExecutionResult.m10444a());
                        } else if (this.f7293q != null) {
                            this.f7293q.m10393a(downloadExecutionResult.m10444a());
                        }
                        j += downloadExecutionResult.m10444a();
                        File a4 = this.f7285i.m10427a(a, a2, true);
                        if (a4 == null) {
                            throw new ExecutionException(new IOException("copyToLocalFile() was not successful"));
                        }
                        this.f7282f.a(a.m10376e(), this.f7278b.a());
                        m10404a(a, a4);
                        i2 = i4 + 1;
                        try {
                            this.f7289m.m10435a(a, now2, downloadExecutionResult.m10444a(), e2);
                            i4 = i2;
                            j2 = j;
                        } catch (InterruptedException e3) {
                            e = e3;
                            m10405a("assetdownload_runner_interrupted_exception", e, downloadExecutionRequest);
                            this.f7289m.m10436a(a, now2, e, e2);
                            i4 = i2;
                            j2 = j;
                            if (this.f7294r != null) {
                            }
                            j = j2;
                            i3 = i5;
                        } catch (ExecutionException e4) {
                            e = e4;
                            m10405a("assetdownload_runner_execution_exception", e, downloadExecutionRequest);
                            this.f7289m.m10436a(a, now2, e, e2);
                            i4 = i2;
                            j2 = j;
                            if (this.f7294r != null) {
                            }
                            j = j2;
                            i3 = i5;
                        } catch (TimeoutException e5) {
                            e = e5;
                            m10405a("assetdownload_runner_timeout_exception", e, downloadExecutionRequest);
                            this.f7289m.m10436a(a, now2, e, e2);
                            i4 = i2;
                            j2 = j;
                            if (this.f7294r != null) {
                            }
                            j = j2;
                            i3 = i5;
                        }
                        if (this.f7294r != null || this.f7294r.mo903a()) {
                            j = j2;
                            i3 = i5;
                        } else {
                            this.f7289m.m10434a(now, this.f7290n, i5, i4, j2, m10409e());
                            return false;
                        }
                    } catch (InterruptedException e6) {
                        e = e6;
                        i2 = i4;
                        m10405a("assetdownload_runner_interrupted_exception", e, downloadExecutionRequest);
                        this.f7289m.m10436a(a, now2, e, e2);
                        i4 = i2;
                        j2 = j;
                        if (this.f7294r != null) {
                        }
                        j = j2;
                        i3 = i5;
                    } catch (ExecutionException e7) {
                        e = e7;
                        i2 = i4;
                        m10405a("assetdownload_runner_execution_exception", e, downloadExecutionRequest);
                        this.f7289m.m10436a(a, now2, e, e2);
                        i4 = i2;
                        j2 = j;
                        if (this.f7294r != null) {
                        }
                        j = j2;
                        i3 = i5;
                    } catch (TimeoutException e8) {
                        e = e8;
                        i2 = i4;
                        m10405a("assetdownload_runner_timeout_exception", e, downloadExecutionRequest);
                        this.f7289m.m10436a(a, now2, e, e2);
                        i4 = i2;
                        j2 = j;
                        if (this.f7294r != null) {
                        }
                        j = j2;
                        i3 = i5;
                    }
                }
            }
        }
        i = i3;
        this.f7289m.m10434a(now, this.f7290n, i, i4, j, m10409e());
        return true;
    }

    public final void m10410a(int i) {
        if (this.f7294r != null) {
            this.f7290n.remove(this.f7294r);
        }
        this.f7294r = new FailureCountEligibilityCallback(i);
        m10411a(this.f7294r);
    }

    public final void m10411a(EligibilityCallback eligibilityCallback) {
        this.f7290n.add(eligibilityCallback);
    }

    public final void m10413b() {
        this.f7290n.clear();
        this.f7291o = null;
        this.f7292p = null;
        this.f7293q = null;
        this.f7294r = null;
        m10410a(0);
    }

    private void m10407c() {
        Iterator it = this.f7290n.iterator();
        while (it.hasNext()) {
            ((EligibilityCallback) it.next()).mo904b();
        }
    }

    private boolean m10408d() {
        Iterator it = this.f7290n.iterator();
        while (it.hasNext()) {
            EligibilityCallback eligibilityCallback = (EligibilityCallback) it.next();
            if (eligibilityCallback != null && !eligibilityCallback.mo903a()) {
                return false;
            }
        }
        return true;
    }

    private boolean m10409e() {
        NetworkInfo activeNetworkInfo = this.f7283g.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
            return true;
        }
        return false;
    }

    private File m10403a(AssetDownloadConfiguration assetDownloadConfiguration) {
        return this.f7284h.a("asset_tmp_" + assetDownloadConfiguration.mIdentifier, ".tmp", Privacy.REQUIRE_PRIVATE);
    }

    private void m10405a(String str, Exception exception, DownloadExecutionRequest downloadExecutionRequest) {
        this.f7286j.a(str, StringFormatUtil.a("currentRequest=%s", new Object[]{downloadExecutionRequest}), exception);
        this.f7282f.b(downloadExecutionRequest.f7337a.mIdentifier, this.f7278b.a());
        if (this.f7294r != null) {
            FailureCountEligibilityCallback failureCountEligibilityCallback = this.f7294r;
            failureCountEligibilityCallback.f7273b++;
        }
    }

    private void m10404a(AssetDownloadConfiguration assetDownloadConfiguration, File file) {
        for (AssetDownloadHandler assetDownloadHandler : this.f7288l) {
            if (assetDownloadHandler.mo1017a(assetDownloadConfiguration)) {
                assetDownloadHandler.mo1016a(assetDownloadConfiguration, file);
            }
        }
    }
}
