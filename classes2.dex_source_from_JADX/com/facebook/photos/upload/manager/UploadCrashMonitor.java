package com.facebook.photos.upload.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.init.INeedInit;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.process.ProcessUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.LoggingTypes$UploadType;
import com.facebook.photos.base.analytics.LoggingTypes.UploadMethodType;
import com.facebook.photos.upload.disk.UploadTempFileManager;
import com.facebook.photos.upload.manager.UploadManager.RequestType;
import com.facebook.photos.upload.operation.UploadInterruptionCause;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.photos.upload.operation.UploadOperationCounters;
import com.facebook.photos.upload.operation.UploadOperationHelper;
import com.facebook.photos.upload.operation.UploadRecord;
import com.facebook.photos.upload.operation.UploadRecords;
import com.facebook.photos.upload.receiver.ConnectivityChangeHelper;
import com.facebook.resources.FbResources;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@SuppressLint({"SharedPreferencesUse"})
/* compiled from: tier_status */
public class UploadCrashMonitor implements INeedInit {
    private static final Class<?> f2969a = UploadCrashMonitor.class;
    private static volatile UploadCrashMonitor f2970v;
    private final Context f2971b;
    private final Lazy<FbResources> f2972c;
    private final Lazy<UploadOperationHelper> f2973d;
    private final Provider<String> f2974e;
    private final AppVersionInfo f2975f;
    private final Lazy<UploadManager> f2976g;
    private final Lazy<UploadTempFileManager> f2977h;
    private final SystemClock f2978i;
    private final Lazy<MoreFileUtils> f2979j;
    private final Lazy<Executor> f2980k;
    private final DefaultProcessUtil f2981l;
    private final Lazy<FbErrorReporter> f2982m;
    private final UploadQueueFileManager f2983n;
    public final UploadQueueFileManager f2984o;
    private final Lazy<ConnectivityChangeHelper> f2985p;
    private final Provider<Boolean> f2986q;
    private final GatekeeperStoreImpl f2987r;
    private OutputStreamWriter f2988s = null;
    public boolean f2989t = false;
    private UploadOperation f2990u;

    public static com.facebook.photos.upload.manager.UploadCrashMonitor m4914a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f2970v;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.upload.manager.UploadCrashMonitor.class;
        monitor-enter(r1);
        r0 = f2970v;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m4923b(r0);	 Catch:{ all -> 0x0035 }
        f2970v = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2970v;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.manager.UploadCrashMonitor.a(com.facebook.inject.InjectorLike):com.facebook.photos.upload.manager.UploadCrashMonitor");
    }

    private static UploadCrashMonitor m4923b(InjectorLike injectorLike) {
        return new UploadCrashMonitor((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3278), IdBasedLazy.m1808a(injectorLike, 9468), IdBasedProvider.m1811a(injectorLike, 4442), AppVersionInfoMethodAutoProvider.m2629a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2984), IdBasedSingletonScopeProvider.m1810b(injectorLike, 9458), SystemClockMethodAutoProvider.m1498a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 538), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3863), DefaultProcessUtil.m2387a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), IdBasedProvider.m1811a(injectorLike, 2985), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2991), IdBasedProvider.m1811a(injectorLike, 4256), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public UploadCrashMonitor(Context context, Lazy<FbResources> lazy, Lazy<UploadOperationHelper> lazy2, Provider<String> provider, AppVersionInfo appVersionInfo, Lazy<UploadManager> lazy3, Lazy<UploadTempFileManager> lazy4, SystemClock systemClock, Lazy<MoreFileUtils> lazy5, Lazy<Executor> lazy6, ProcessUtil processUtil, Lazy<FbErrorReporter> lazy7, Provider<UploadQueueFileManager> provider2, Lazy<ConnectivityChangeHelper> lazy8, Provider<Boolean> provider3, GatekeeperStore gatekeeperStore) {
        this.f2971b = context;
        this.f2972c = lazy;
        this.f2973d = lazy2;
        this.f2974e = provider;
        this.f2975f = appVersionInfo;
        this.f2976g = lazy3;
        this.f2977h = lazy4;
        this.f2978i = systemClock;
        this.f2979j = lazy5;
        this.f2980k = lazy6;
        this.f2981l = processUtil;
        this.f2982m = lazy7;
        this.f2983n = (UploadQueueFileManager) provider2.get();
        this.f2984o = (UploadQueueFileManager) provider2.get();
        this.f2985p = lazy8;
        this.f2986q = provider3;
        this.f2987r = gatekeeperStore;
    }

    public void init() {
        boolean z = true;
        if (!this.f2981l.m2389a().e()) {
            return;
        }
        if (this.f2989t) {
            ((AbstractFbErrorReporter) this.f2982m.get()).m2340a(f2969a.getSimpleName(), "double init");
            return;
        }
        this.f2983n.m4947a(m4924b("upload_queue"), this.f2975f.mo369c(), Build.FINGERPRINT);
        this.f2984o.m4947a(m4924b("failed_upload"), this.f2975f.mo369c(), Build.FINGERPRINT);
        this.f2989t = true;
        SharedPreferences d = m4930d();
        try {
            boolean z2;
            boolean z3 = m4922a(d, LoggingTypes$UploadType.PHOTO, "photo_upload_in_progress_waterfallid") || m4922a(d, LoggingTypes$UploadType.VIDEO, "video_upload_in_progress_waterfallid") || m4922a(d, LoggingTypes$UploadType.MULTIMEDIA, "multimedia_upload_in_progress_waterfallid");
            if (this.f2983n.m4948b() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.f2984o.m4948b() <= 0) {
                z = false;
            }
            if (z2 || r0 || z3) {
                m4929c();
                ((UploadTempFileManager) this.f2977h.get()).b();
                Futures.m2458a(((FbResources) this.f2972c.get()).mo355b(), new 1(this), (Executor) this.f2980k.get());
                return;
            }
            ((ConnectivityChangeHelper) this.f2985p.get()).m4955b();
        } catch (Throwable e) {
            ((AbstractFbErrorReporter) this.f2982m.get()).m2346a(f2969a.getSimpleName(), e);
            m4917a(d);
        }
    }

    public static void m4919a(UploadCrashMonitor uploadCrashMonitor) {
        String str;
        Object obj;
        boolean a = uploadCrashMonitor.f2987r.m2189a(496, false);
        if (uploadCrashMonitor.f2990u != null) {
            String str2 = uploadCrashMonitor.f2990u.p;
            String str3;
            if (a || ((UploadManager) uploadCrashMonitor.f2976g.get()).b(uploadCrashMonitor.f2990u)) {
                str = uploadCrashMonitor.f2990u.p;
                str3 = "Resume";
                uploadCrashMonitor.m4920a(uploadCrashMonitor.f2990u, str3);
                ((UploadManager) uploadCrashMonitor.f2976g.get()).a(uploadCrashMonitor.f2990u, RequestType.Resume, str3);
                obj = str2;
            } else {
                str = uploadCrashMonitor.f2990u.p;
                uploadCrashMonitor.m4920a(uploadCrashMonitor.f2990u, "Not Resume");
                ((UploadManager) uploadCrashMonitor.f2976g.get()).f(uploadCrashMonitor.f2990u);
                str3 = str2;
            }
        } else {
            obj = null;
        }
        List<UploadOperation> c = uploadCrashMonitor.f2983n.m4950c();
        if (c != null) {
            for (UploadOperation uploadOperation : c) {
                if (!Objects.equal(obj, uploadOperation.p)) {
                    if (uploadOperation.Z) {
                        str = uploadOperation.p;
                    } else {
                        str = uploadOperation.p;
                        String str4 = "Interrupted re-enqueue";
                        uploadCrashMonitor.m4920a(uploadOperation, str4);
                        ((UploadManager) uploadCrashMonitor.f2976g.get()).c(uploadOperation, RequestType.Restore, str4);
                    }
                }
            }
        }
        c = uploadCrashMonitor.f2984o.m4950c();
        if (c != null) {
            for (UploadOperation uploadOperation2 : c) {
                if (uploadOperation2.Z) {
                    str = uploadOperation2.p;
                } else {
                    str = uploadOperation2.p;
                    String str5 = "Recover failed operation";
                    uploadCrashMonitor.m4920a(uploadOperation2, str5);
                    if (a) {
                        ((UploadManager) uploadCrashMonitor.f2976g.get()).c(uploadOperation2, RequestType.Restore, str5);
                    } else {
                        ((UploadManager) uploadCrashMonitor.f2976g.get()).f(uploadOperation2);
                    }
                }
            }
        }
        ((UploadManager) uploadCrashMonitor.f2976g.get()).c("Crash Monitor recover");
    }

    private void m4920a(UploadOperation uploadOperation, String str) {
        DefaultPhotoFlowLogger d = ((UploadOperationHelper) this.f2973d.get()).d(uploadOperation);
        d.a(d.a("2.1", UploadMethodType.CHUNKED), uploadOperation, str);
    }

    public final void m4934a(UploadOperation uploadOperation) {
        m4928b(uploadOperation, "photo_upload_in_progress_waterfallid");
        m4932h(uploadOperation);
    }

    public final void m4938b(UploadOperation uploadOperation) {
        m4928b(uploadOperation, "multimedia_upload_in_progress_waterfallid");
        m4932h(uploadOperation);
    }

    public final boolean m4937a(String str, UploadRecord uploadRecord) {
        if (this.f2988s != null) {
            try {
                String a = uploadRecord.a();
                this.f2988s.write(str);
                this.f2988s.write(10);
                this.f2988s.write(a);
                this.f2988s.write(10);
                this.f2988s.flush();
                return true;
            } catch (IOException e) {
                this.f2988s = null;
            }
        }
        return false;
    }

    private void m4927b() {
        if (this.f2988s != null) {
            try {
                this.f2988s.close();
            } catch (Throwable e) {
                BLog.a(f2969a, e, "Failed to close partial records", new Object[0]);
            }
            this.f2988s = null;
        }
    }

    public final void m4941e(UploadOperation uploadOperation) {
        m4928b(uploadOperation, "video_upload_in_progress_waterfallid");
        m4932h(uploadOperation);
    }

    private void m4932h(UploadOperation uploadOperation) {
        try {
            this.f2988s = new OutputStreamWriter(new FileOutputStream(m4925b(uploadOperation.N(), "_partial_uploads")), Charset.forName("UTF-8"));
        } catch (Throwable e) {
            this.f2988s = null;
            BLog.a(f2969a, e, "Failed to create partial upload file", new Object[0]);
        }
    }

    public final void m4936a(String str) {
        m4921a(str, "video_upload_in_progress_waterfallid");
        m4927b();
    }

    public final void m4942f(UploadOperation uploadOperation) {
        if (this.f2989t) {
            this.f2983n.m4946a(uploadOperation);
        }
    }

    public final void m4935a(UploadOperation uploadOperation, int i) {
        if (!this.f2989t) {
            return;
        }
        if (i == 0) {
            this.f2983n.m4945a();
        } else {
            this.f2983n.m4949b(uploadOperation);
        }
    }

    private void m4921a(String str, String str2) {
        m4918a(m4930d(), str2);
        m4925b(str, "_upload_operation").delete();
        m4925b(str, "_partial_uploads").delete();
    }

    private boolean m4922a(SharedPreferences sharedPreferences, LoggingTypes$UploadType loggingTypes$UploadType, String str) {
        if (!sharedPreferences.contains(str)) {
            return false;
        }
        m4926b(sharedPreferences, loggingTypes$UploadType, str);
        m4918a(sharedPreferences, str);
        return true;
    }

    private String m4926b(SharedPreferences sharedPreferences, LoggingTypes$UploadType loggingTypes$UploadType, String str) {
        String string = sharedPreferences.getString(str, null);
        String string2 = sharedPreferences.getString("uploader_user_id", null);
        String string3 = sharedPreferences.getString("upload_system_version", null);
        int i = sharedPreferences.getInt("upload_app_build_number", -1);
        if (string == null || string.length() <= 0) {
            return "Invalid waterfall ID";
        }
        if (string3 == null || !string3.equals(Build.FINGERPRINT)) {
            return m4916a(string, loggingTypes$UploadType, "Error: System version mismatch");
        }
        if (i != this.f2975f.mo369c()) {
            return m4916a(string, loggingTypes$UploadType, "Error: Build number mismatch");
        }
        string3 = (String) this.f2974e.get();
        if (string2 == null || !string2.equals(string3)) {
            return m4916a(string, loggingTypes$UploadType, "Error: User ID mismatch");
        }
        UploadOperation b = UploadOperation.b(m4925b(string, "_upload_operation"));
        if (b == null) {
            return m4916a(string, loggingTypes$UploadType, "Error: Couldn't read operation");
        }
        int size;
        UploadRecords i2 = m4933i(b);
        if (i2 != null) {
            size = i2.a().size();
        } else {
            size = 0;
        }
        if (!b.p.equals(string)) {
            return m4915a(b, size, "Error: Waterfall ID mismatch");
        }
        b.a(new UploadInterruptionCause(new AppInterruptedException(this)));
        if (((Boolean) this.f2986q.get()).booleanValue()) {
            UploadRecords uploadRecords = b.F;
            if (uploadRecords == null) {
                uploadRecords = i2;
            } else if (i2 != null) {
                uploadRecords.a.putAll(i2.a());
            }
            b.F = uploadRecords;
        } else {
            b.F = i2;
        }
        this.f2990u = b;
        UploadOperationCounters uploadOperationCounters = b.D;
        uploadOperationCounters.d++;
        return m4915a(b, size, StringFormatUtil.a(((UploadManager) this.f2976g.get()).b(b) ? "Resume after interruption #%d" : "Interrupt notification after %d interruptions", new Object[]{Integer.valueOf(b.f())}));
    }

    private void m4928b(UploadOperation uploadOperation, String str) {
        if (uploadOperation.a(m4925b(uploadOperation.p, "_upload_operation"))) {
            m4930d().edit().putString(str, uploadOperation.p).putString("uploader_user_id", (String) this.f2974e.get()).putInt("upload_app_build_number", this.f2975f.mo369c()).putString("upload_system_version", Build.FINGERPRINT).commit();
        }
    }

    public final void m4939c(UploadOperation uploadOperation) {
        m4921a(uploadOperation.p, "multimedia_upload_in_progress_waterfallid");
        m4927b();
    }

    public final void m4940d(UploadOperation uploadOperation) {
        m4921a(uploadOperation.p, "photo_upload_in_progress_waterfallid");
        m4927b();
    }

    private String m4915a(UploadOperation uploadOperation, int i, String str) {
        ((UploadOperationHelper) this.f2973d.get()).d(uploadOperation).a("2.0", uploadOperation.a(), ((UploadManager) this.f2976g.get()).g(uploadOperation), uploadOperation, i, str, this.f2978i.mo211a() - uploadOperation.ae());
        return str;
    }

    private String m4916a(String str, LoggingTypes$UploadType loggingTypes$UploadType, String str2) {
        Type type;
        DefaultPhotoFlowLogger a = ((UploadOperationHelper) this.f2973d.get()).a(str);
        String str3 = "2.0";
        this.f2976g.get();
        if (loggingTypes$UploadType == LoggingTypes$UploadType.VIDEO) {
            type = Type.VIDEO;
        } else {
            type = Type.OWN_TIMELINE;
        }
        a.a(str3, loggingTypes$UploadType, UploadManager.a(type), null, -1, str2, -1);
        return str2;
    }

    private void m4929c() {
        this.f2979j.get();
        FileTree.a(m4931e());
    }

    private static void m4918a(SharedPreferences sharedPreferences, String str) {
        sharedPreferences.edit().remove(str).remove("uploader_user_id").remove("upload_system_version").remove("upload_app_build_number").commit();
    }

    private void m4917a(SharedPreferences sharedPreferences) {
        m4918a(sharedPreferences, "photo_upload_in_progress_waterfallid");
        m4918a(sharedPreferences, "video_upload_in_progress_waterfallid");
        m4929c();
    }

    private SharedPreferences m4930d() {
        return this.f2971b.getSharedPreferences("upload_crash_monitor", 0);
    }

    private File m4931e() {
        return this.f2971b.getDir("upload_crash_monitor_temp", 0);
    }

    private File m4925b(String str, String str2) {
        return new File(m4931e(), str.replace(File.pathSeparatorChar, '_').replace(File.separatorChar, '_') + str2);
    }

    private File m4924b(String str) {
        return new File(m4931e(), str);
    }

    private UploadRecords m4933i(UploadOperation uploadOperation) {
        BufferedReader bufferedReader;
        Throwable th;
        Map c = Maps.m838c();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(m4925b(uploadOperation.N(), "_partial_uploads")), "UTF-8"));
            while (bufferedReader.ready()) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String readLine2 = bufferedReader.readLine();
                        if (readLine2 != null) {
                            UploadRecord a = UploadRecord.a(readLine2);
                            if (a != null) {
                                c.put(readLine, a);
                            }
                        }
                    }
                } catch (IOException e) {
                } catch (NumberFormatException e2) {
                } catch (FileNotFoundException e3) {
                } catch (UnsupportedEncodingException e4) {
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException e5) {
            }
            if (c.size() == 0) {
                return null;
            }
            Integer.valueOf(c.size());
            return new UploadRecords(c);
        } catch (FileNotFoundException e6) {
            bufferedReader = null;
            if (bufferedReader == null) {
                return null;
            }
            try {
                bufferedReader.close();
                return null;
            } catch (IOException e7) {
                return null;
            }
        } catch (UnsupportedEncodingException e8) {
            bufferedReader = null;
            if (bufferedReader == null) {
                return null;
            }
            try {
                bufferedReader.close();
                return null;
            } catch (IOException e9) {
                return null;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedReader = null;
            th = th4;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e10) {
                }
            }
            throw th;
        }
    }
}
