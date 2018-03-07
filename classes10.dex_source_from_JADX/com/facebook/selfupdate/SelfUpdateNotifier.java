package com.facebook.selfupdate;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.android.DownloadManagerMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.selfupdate.Fb4aSelfUpdateMegaphoneHandler;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@TargetApi(9)
/* compiled from: has_launched_login */
public class SelfUpdateNotifier {
    private static volatile SelfUpdateNotifier f10007n;
    public final Context f10008a;
    private final FbSharedPreferences f10009b;
    private final AppVersionInfo f10010c;
    private final SelfUpdateLogger f10011d;
    public final SecureContextHelper f10012e;
    private final DefaultAndroidThreadUtil f10013f;
    private final SelfUpdateActivityListener f10014g;
    private final MoreFileUtils f10015h;
    private final DownloadManager f10016i;
    private final SelfUpdateNotificationHandler f10017j;
    private final Clock f10018k;
    public final SelfUpdateChecker f10019l;
    private final ObjectMapper f10020m;

    public static com.facebook.selfupdate.SelfUpdateNotifier m10094a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10007n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.selfupdate.SelfUpdateNotifier.class;
        monitor-enter(r1);
        r0 = f10007n;	 Catch:{ all -> 0x003a }
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
        r0 = m10097b(r0);	 Catch:{ all -> 0x0035 }
        f10007n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10007n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.selfupdate.SelfUpdateNotifier.a(com.facebook.inject.InjectorLike):com.facebook.selfupdate.SelfUpdateNotifier");
    }

    private static SelfUpdateNotifier m10097b(InjectorLike injectorLike) {
        return new SelfUpdateNotifier((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), AppVersionInfoMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), SelfUpdateLogger.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), SelfUpdateActivityListener.a(injectorLike), MoreFileUtils.a(injectorLike), DownloadManagerMethodAutoProvider.b(injectorLike), (SelfUpdateNotificationHandler) Fb4aSelfUpdateMegaphoneHandler.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), SelfUpdateChecker.b(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SelfUpdateNotifier(Context context, FbSharedPreferences fbSharedPreferences, AppVersionInfo appVersionInfo, DefaultAndroidThreadUtil defaultAndroidThreadUtil, SelfUpdateLogger selfUpdateLogger, SecureContextHelper secureContextHelper, SelfUpdateActivityListener selfUpdateActivityListener, MoreFileUtils moreFileUtils, DownloadManager downloadManager, SelfUpdateNotificationHandler selfUpdateNotificationHandler, Clock clock, SelfUpdateChecker selfUpdateChecker, ObjectMapper objectMapper) {
        this.f10008a = context;
        this.f10009b = fbSharedPreferences;
        this.f10010c = appVersionInfo;
        this.f10013f = defaultAndroidThreadUtil;
        this.f10011d = selfUpdateLogger;
        this.f10012e = secureContextHelper;
        this.f10014g = selfUpdateActivityListener;
        this.f10015h = moreFileUtils;
        this.f10016i = downloadManager;
        this.f10017j = selfUpdateNotificationHandler;
        this.f10018k = clock;
        this.f10019l = selfUpdateChecker;
        this.f10020m = objectMapper;
    }

    private Intent m10092a(ObjectNode objectNode) {
        int a;
        try {
            a = this.f10009b.a(SelfUpdateConstants.d, -1);
        } catch (ClassCastException e) {
            String a2;
            try {
                a2 = this.f10009b.a(SelfUpdateConstants.d, "");
            } catch (Exception e2) {
                a2 = "error getting stored string";
            }
            this.f10011d.a("SelfUpdateNotifier.createIntent - Stored new_version data type does not match: " + a2);
            a = -1;
        }
        int b = this.f10010c.b();
        String a3 = this.f10009b.a(SelfUpdateConstants.h, null);
        String a4 = this.f10009b.a(SelfUpdateConstants.f, null);
        boolean a5 = this.f10009b.a(SelfUpdateConstants.i, false);
        String a6 = this.f10009b.a(SelfUpdateConstants.j, null);
        String a7 = this.f10009b.a(SelfUpdateConstants.o, null);
        boolean a8 = m10103a(a3);
        if (b < a && a8) {
            return m10093a(a3, a4, a5, a6, a7);
        }
        objectNode.a("createintent_currentversion", b);
        objectNode.a("createintent_newversion", a);
        objectNode.a("createintent_isvalidfile", a8);
        return null;
    }

    public final boolean m10103a(String str) {
        if (str == null) {
            return false;
        }
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

    private Intent m10093a(String str, String str2, boolean z, String str3, String str4) {
        Intent intent = new Intent(this.f10008a, SelfUpdateInstallActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("local_uri", str);
        if (str2 != null) {
            intent.putExtra("release_notes", str2);
        }
        intent.putExtra("no_cancel", z);
        if (z) {
            intent.setFlags(32768);
        }
        if (str3 != null) {
            intent.putExtra("app_name", str3);
        }
        if (!(str4 == null || str4.equals("no_megaphone"))) {
            intent.putExtra("megaphone", str4);
        }
        return intent;
    }

    public final synchronized void m10101a() {
        int a = this.f10009b.a(SelfUpdateConstants.n, 0);
        String a2 = this.f10009b.a(SelfUpdateConstants.o, "no_megaphone");
        String a3 = this.f10009b.a(SelfUpdateConstants.p, "application/vnd.android.package-archive");
        int a4 = this.f10009b.a(SelfUpdateConstants.d, 0);
        boolean a5 = m10096a(a4);
        if (a == 2 && !a5 && a2.equals("no_megaphone") && a3.equals("application/vnd.android.package-archive")) {
            m10099d();
        } else {
            this.f10011d.a("selfupdate_skip_showing_activity", ImmutableMap.of("megaphone_string", a2, "mime_type", a3, "downloaded_version", Integer.valueOf(a4), "update_postponed", Boolean.valueOf(m10096a(a4))));
        }
    }

    private synchronized void m10099d() {
        ObjectNode e = this.f10020m.e();
        Intent a = m10092a(e);
        if (a != null) {
            a.addFlags(268435456);
            Activity b = this.f10014g.b();
            boolean z = b instanceof SelfUpdateInstallActivity;
            if (b == null) {
                this.f10011d.a("selfupdate_skip_showing_activity", ImmutableBiMap.b("currentactivity_null", Boolean.valueOf(true)));
                this.f10017j.m10091a(a);
                m10100e();
            } else if (z || this.f10014g.c()) {
                this.f10011d.a("selfupdate_skip_showing_activity", ImmutableMap.of("currently_showing_activity", Boolean.valueOf(z), "activity_already_shown", Boolean.valueOf(this.f10014g.c())));
            } else {
                m10095a(a);
            }
        } else {
            m10102a("could_not_create_intent_for_activity", e);
        }
    }

    private void m10095a(final Intent intent) {
        this.f10013f.a(new Runnable(this) {
            final /* synthetic */ SelfUpdateNotifier f10006b;

            public void run() {
                this.f10006b.f10012e.a(intent, this.f10006b.f10008a);
            }
        });
    }

    public final synchronized void m10104b() {
        ObjectNode e = this.f10020m.e();
        Intent a = m10092a(e);
        if (a != null) {
            this.f10017j.m10091a(a);
            m10100e();
        } else {
            m10102a("could_not_create_intent_for_notification", e);
        }
    }

    private void m10100e() {
        this.f10011d.a("selfupdate_post_notification", ImmutableBiMap.b("source", this.f10009b.a(SelfUpdateConstants.r, "")));
    }

    private boolean m10098b(String str) {
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

    public final void m10105c() {
        int a = this.f10009b.a(SelfUpdateConstants.d, 0);
        if (a != 0) {
            this.f10009b.edit().a(SelfUpdateConstants.l, a).a(SelfUpdateConstants.m, this.f10018k.a() + 86400000).commit();
        }
    }

    public final void m10102a(String str, @Nullable ObjectNode objectNode) {
        Map hashMap = new HashMap();
        hashMap.put("caller_reason", str);
        if (objectNode != null) {
            hashMap.put("caller_data", objectNode);
        }
        hashMap.put("update_build", Integer.valueOf(this.f10009b.a(SelfUpdateConstants.d, -1)));
        hashMap.put("download_status", SelfUpdateConstants.a(this.f10009b.a(SelfUpdateConstants.n, -1)));
        hashMap.put("source", this.f10009b.a(SelfUpdateConstants.r, null));
        this.f10011d.a("selfupdate_clean_update_info", hashMap);
        this.f10017j.m10090a();
        long a = this.f10009b.a(SelfUpdateConstants.g, -1);
        if (a != -1) {
            try {
                this.f10016i.remove(new long[]{a});
            } catch (Throwable e) {
                this.f10011d.a("Failed to remove download ID from DownloadManager: " + a, e);
            }
        }
        String a2 = this.f10009b.a(SelfUpdateConstants.h, null);
        if (a2 != null) {
            m10098b(a2);
        }
        MoreFileUtils.a(this.f10008a.getFilesDir(), 36, "^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$", 5242880);
        this.f10009b.edit().a(SelfUpdateConstants.d).a(SelfUpdateConstants.e).a(SelfUpdateConstants.f).a(SelfUpdateConstants.n).a(SelfUpdateConstants.i).a(SelfUpdateConstants.g).a(SelfUpdateConstants.h).a(SelfUpdateConstants.j).a(SelfUpdateConstants.o).a(SelfUpdateConstants.p).commit();
    }

    private boolean m10096a(int i) {
        if (i == 0) {
            return false;
        }
        int a = this.f10009b.a(SelfUpdateConstants.l, 0);
        long a2 = this.f10009b.a(SelfUpdateConstants.m, 0);
        if (i != a || this.f10018k.a() >= a2) {
            return false;
        }
        return true;
    }
}
