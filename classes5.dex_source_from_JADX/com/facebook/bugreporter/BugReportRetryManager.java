package com.facebook.bugreporter;

import android.net.Uri;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.bugreporter.analytics.BugReporterAnalyticsLogger;
import com.facebook.bugreporter.analytics.BugReporterAnalyticsLogger.CoreEvent;
import com.facebook.bugreporter.scheduler.BugReportRetryScheduler;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: android.permission.BIND_JOB_SERVICE */
public class BugReportRetryManager {
    private static final String f10477a = BugReportRetryManager.class.getName();
    private static final PrefKey f10478b = ((PrefKey) ((PrefKey) SharedPrefKeys.b.a(f10477a)).a("reports"));
    private static final PrefKey f10479c = ((PrefKey) ((PrefKey) SharedPrefKeys.b.a(f10477a)).a("attachments"));
    private static final PrefKey f10480d = ((PrefKey) ((PrefKey) SharedPrefKeys.b.a(f10477a)).a("attachment_meta"));
    private static volatile BugReportRetryManager f10481l;
    private final BugReporterFileUtil f10482e;
    private final BugReportUploader f10483f;
    private final BugReportAttachmentUploader f10484g;
    private final BugReporterAnalyticsLogger f10485h;
    private final FbSharedPreferences f10486i;
    private final BugReportRetryScheduler f10487j;
    private final XConfigReader f10488k;

    public static com.facebook.bugreporter.BugReportRetryManager m18550a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10481l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.bugreporter.BugReportRetryManager.class;
        monitor-enter(r1);
        r0 = f10481l;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m18556b(r0);	 Catch:{ all -> 0x0035 }
        f10481l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10481l;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bugreporter.BugReportRetryManager.a(com.facebook.inject.InjectorLike):com.facebook.bugreporter.BugReportRetryManager");
    }

    private static BugReportRetryManager m18556b(InjectorLike injectorLike) {
        return new BugReportRetryManager(BugReporterFileUtil.m18646a(injectorLike), BugReportUploader.m18590a(injectorLike), BugReportAttachmentUploader.m18530a(injectorLike), BugReporterAnalyticsLogger.m18744b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), BugReportRetryScheduler.a(injectorLike), XConfigReader.a(injectorLike));
    }

    @Inject
    public BugReportRetryManager(BugReporterFileUtil bugReporterFileUtil, BugReportUploader bugReportUploader, BugReportAttachmentUploader bugReportAttachmentUploader, BugReporterAnalyticsLogger bugReporterAnalyticsLogger, FbSharedPreferences fbSharedPreferences, BugReportRetryScheduler bugReportRetryScheduler, XConfigReader xConfigReader) {
        this.f10482e = bugReporterFileUtil;
        this.f10483f = bugReportUploader;
        this.f10484g = bugReportAttachmentUploader;
        this.f10485h = bugReporterAnalyticsLogger;
        this.f10486i = fbSharedPreferences;
        this.f10487j = bugReportRetryScheduler;
        this.f10488k = xConfigReader;
    }

    private void m18557b() {
        Map e = this.f10486i.e(f10478b);
        if (e.size() > 20) {
            Map map = e;
            while (map.size() > 20) {
                Entry entry = (Entry) map.entrySet().iterator().next();
                int parseInt = Integer.parseInt(((PrefKey) entry.getKey()).b(f10478b));
                int i = parseInt;
                Entry entry2 = entry;
                for (Entry entry3 : map.entrySet()) {
                    Entry entry4;
                    int i2;
                    parseInt = Integer.parseInt(((PrefKey) entry3.getKey()).b(f10478b));
                    if (i > parseInt) {
                        int i3 = parseInt;
                        entry4 = entry3;
                        i2 = i3;
                    } else {
                        i2 = i;
                        entry4 = entry2;
                    }
                    i = i2;
                    entry2 = entry4;
                }
                this.f10485h.m18745a();
                BugReporterFileUtil.m18648a(new File((String) entry2.getValue()));
                File b = this.f10482e.m18656b(String.valueOf(i));
                if (b != null) {
                    BugReporterFileUtil.m18648a(b);
                }
                this.f10486i.edit().a((PrefKey) entry2.getKey()).commit();
                map = this.f10486i.e(f10478b);
            }
        }
    }

    private void m18558c() {
        Map e = this.f10486i.e(f10478b);
        File[] listFiles = new File(this.f10482e.f10626b.getCacheDir(), "bugreports").listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file : listFiles) {
                if (!e.containsKey(f10478b.a(file.getName()))) {
                    BugReporterFileUtil.m18648a(file);
                    this.f10485h.m18746a(CoreEvent.BUG_REPORT_UNTRACKED_DIRECTORY_DELETED);
                }
            }
        }
    }

    public final void m18560a(BugReport bugReport) {
        this.f10486i.edit().a((PrefKey) f10478b.a(bugReport.f10411g), bugReport.f10405a.getPath()).commit();
        if (!this.f10487j.a(0)) {
            BLog.b(f10477a, "Failed to schedule upload for a bug report.");
        }
        BugReporterAnalyticsLogger bugReporterAnalyticsLogger = this.f10485h;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("bug_report_created");
        honeyClientEvent.c = "bugreporter";
        bugReporterAnalyticsLogger.f10727a.c(honeyClientEvent.b("bug_creation_ttime", bugReport.f10422r).b("bug_source", bugReport.f10421q.getName()).b("bug_category_id", bugReport.f10412h).b("bug_description", bugReport.f10406b).b("bug_build_number", bugReport.f10415k).b("bug_build_timestamp", bugReport.f10416l).b("bug_git_hash", bugReport.f10414j).b("bug_git_branch", bugReport.f10417m).b("bug_network_type", bugReport.f10418n).b("bug_network_subtype", bugReport.f10419o).b("bug_report_id", bugReport.f10411g).b("bug_timed_out_attachments", bugReport.f10427w));
        m18557b();
        m18558c();
    }

    public final boolean m18561a() {
        boolean z = true;
        for (Entry entry : this.f10486i.e(f10478b).entrySet()) {
            boolean z2;
            boolean a = m18554a(new File((String) entry.getValue()));
            if (a) {
                this.f10486i.edit().a((PrefKey) entry.getKey()).commit();
            }
            if (z && a) {
                z2 = true;
            } else {
                z2 = false;
            }
            z = z2;
        }
        if (m18559d() && z) {
            return true;
        }
        return false;
    }

    private boolean m18559d() {
        boolean z = true;
        for (Entry entry : this.f10486i.e(f10479c).entrySet()) {
            File file;
            PrefKey prefKey = (PrefKey) entry.getKey();
            PrefKey prefKey2 = (PrefKey) f10480d.a(prefKey.b(f10479c));
            String a = this.f10486i.a((PrefKey) prefKey2.a("report_id"), null);
            Integer valueOf = Integer.valueOf(this.f10486i.a((PrefKey) prefKey2.a("retry_num"), 0));
            String a2 = this.f10486i.a((PrefKey) prefKey2.a("filename"), null);
            try {
                file = new File(new URI((String) entry.getValue()));
            } catch (Throwable e) {
                e.printStackTrace();
                BLog.b("TAG", e, "Ignoring invalid debug attachment: %s", new Object[]{a2});
                file = null;
            }
            if (file == null || !file.exists()) {
                this.f10486i.edit().a(prefKey).b(prefKey2).commit();
            } else if (file.isDirectory() || file.length() == 0) {
                m18552a(file, prefKey, prefKey2);
            } else {
                boolean a3 = m18555a(a2, file, a);
                if (a3) {
                    if (valueOf.intValue() == 0) {
                        this.f10485h.m18747a(CoreEvent.BUG_REPORT_ATTACHMENT_DID_UPLOAD, a2, a, file.length());
                    } else {
                        this.f10485h.m18747a(CoreEvent.BUG_REPORT_ATTACHMENT_RETRY_UPLOAD_SUCCESS, a2, a, file.length());
                    }
                    m18552a(file, prefKey, prefKey2);
                } else if (valueOf.intValue() >= this.f10488k.a(BugReportingXConfig.c, 2)) {
                    m18552a(file, prefKey, prefKey2);
                    this.f10485h.m18747a(CoreEvent.BUG_REPORT_ATTACHMENT_FAILED_EXCEEDED_RETRIES, a2, a, file.length());
                } else {
                    this.f10486i.edit().a((PrefKey) prefKey2.a("retry_num"), Integer.valueOf(valueOf.intValue() + 1).intValue()).commit();
                    this.f10485h.m18747a(CoreEvent.BUG_REPORT_ATTACHMENT_FAILED_TO_UPLOAD, a2, a, file.length());
                    BLog.a(f10477a, "Failed to upload bug report attachment. Path: %s", new Object[]{file.getPath()});
                }
                boolean z2 = z && a3;
                z = z2;
            }
        }
        return z;
    }

    private void m18553a(String str, ImmutableList<Uri> immutableList, Map<String, String> map) {
        Editor edit = this.f10486i.edit();
        if (this.f10488k.a(BugReportingXConfig.q, false)) {
            int size = immutableList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                m18551a(edit, str, StringFormatUtil.formatStrLocaleSafe("screenshot-%d.png", Integer.valueOf(i)), ((Uri) immutableList.get(i2)).toString());
                i++;
            }
        }
        if (map != null) {
            for (String str2 : map.keySet()) {
                m18551a(edit, str, str2, (String) map.get(str2));
            }
        }
        edit.commit();
    }

    private static void m18551a(Editor editor, String str, String str2, String str3) {
        editor.a((PrefKey) ((PrefKey) f10479c.a(str)).a(str2), str3);
        PrefKey prefKey = (PrefKey) ((PrefKey) f10480d.a(str)).a(str2);
        editor.a((PrefKey) prefKey.a("report_id"), str);
        editor.a((PrefKey) prefKey.a("filename"), str2);
    }

    private void m18552a(File file, PrefKey prefKey, PrefKey prefKey2) {
        File parentFile = file.getParentFile();
        file.delete();
        if (parentFile != null && parentFile.list().length == 0) {
            parentFile.delete();
        }
        this.f10486i.edit().a(prefKey).b(prefKey2).commit();
    }

    private boolean m18555a(String str, File file, String str2) {
        return this.f10484g.m18532a(str, file, str2);
    }

    private boolean m18554a(File file) {
        BugReport b = BugReporterFileUtil.m18652b(file);
        if (b == null) {
            BugReporterFileUtil.m18648a(file);
            this.f10485h.m18746a(CoreEvent.BUG_REPORT_CORRUPTED_DIRECTORY_DELETED);
            return true;
        }
        String a = this.f10483f.m18596a(b);
        if (a != null) {
            m18553a(a, b.f10408d, (Map) b.f10424t);
            BugReporterFileUtil.m18648a(file);
            if (b.f10423s > 0) {
                this.f10485h.m18746a(CoreEvent.BUG_REPORT_RETRY_UPLOAD_SUCCESS);
            } else {
                this.f10485h.m18746a(CoreEvent.BUG_REPORT_DID_UPLOAD);
            }
            return true;
        } else if (b.f10423s >= this.f10488k.a(BugReportingXConfig.d, 3)) {
            if (b.f10424t != null) {
                Iterator it = b.f10424t.values().iterator();
                while (it.hasNext()) {
                    new File((String) it.next()).delete();
                }
            }
            BugReporterFileUtil.m18648a(file);
            this.f10485h.m18748b();
            return true;
        } else {
            this.f10482e.m18654a(b);
            this.f10485h.m18746a(CoreEvent.BUG_REPORT_FAILED_TO_UPLOAD);
            BLog.a(f10477a, "Failed to upload bug report during. Path: %s", new Object[]{file.toString()});
            return false;
        }
    }
}
