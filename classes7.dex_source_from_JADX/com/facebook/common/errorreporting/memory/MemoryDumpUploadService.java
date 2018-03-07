package com.facebook.common.errorreporting.memory;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.android.ActivityManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.memory.MemoryDumpUploadMethodParams.Builder;
import com.facebook.common.fileupload.FileUploadUtils;
import com.facebook.common.process.ProcessName;
import com.facebook.common.process.ProcessNameMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.config.application.FbAppType;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import java.io.File;
import java.util.regex.Matcher;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.json.JSONObject;

/* compiled from: typed_headers */
public class MemoryDumpUploadService extends FbIntentService {
    private static final CallerContext f1185k = CallerContext.a(MemoryDumpUploadService.class, "infrastructure");
    @Inject
    MemoryDumpUploadMethod f1186a;
    @Inject
    AbstractSingleMethodRunner f1187b;
    @Inject
    DeviceConditionHelper f1188c;
    @Inject
    FileUploadUtils f1189d;
    @Inject
    AppVersionInfo f1190e;
    @Inject
    ActivityManager f1191f;
    @Inject
    @LoggedInUserId
    String f1192g;
    @Inject
    ProcessName f1193h;
    @Inject
    FbAppType f1194i;
    @Inject
    MemoryDumpMetadataHandler f1195j;

    private static <T extends Context> void m1258a(Class<T> cls, T t) {
        m1259a((Object) t, (Context) t);
    }

    public static void m1259a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MemoryDumpUploadService) obj).m1257a(new MemoryDumpUploadMethod(), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(fbInjector), DeviceConditionHelper.a(fbInjector), FileUploadUtils.a(fbInjector), AppVersionInfoMethodAutoProvider.a(fbInjector), ActivityManagerMethodAutoProvider.b(fbInjector), String_LoggedInUserIdMethodAutoProvider.b(fbInjector), ProcessNameMethodAutoProvider.b(fbInjector), (FbAppType) fbInjector.getInstance(FbAppType.class), MemoryDumpMetadataHandler.a(fbInjector));
    }

    private void m1257a(MemoryDumpUploadMethod memoryDumpUploadMethod, AbstractSingleMethodRunner abstractSingleMethodRunner, DeviceConditionHelper deviceConditionHelper, FileUploadUtils fileUploadUtils, AppVersionInfo appVersionInfo, ActivityManager activityManager, String str, ProcessName processName, FbAppType fbAppType, MemoryDumpMetadataHandler memoryDumpMetadataHandler) {
        this.f1186a = memoryDumpUploadMethod;
        this.f1187b = abstractSingleMethodRunner;
        this.f1188c = deviceConditionHelper;
        this.f1189d = fileUploadUtils;
        this.f1190e = appVersionInfo;
        this.f1191f = activityManager;
        this.f1192g = str;
        this.f1193h = processName;
        this.f1194i = fbAppType;
        this.f1195j = memoryDumpMetadataHandler;
    }

    public MemoryDumpUploadService() {
        super("MemDumpUploadService");
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 1355519198);
        super.onCreate();
        Class cls = MemoryDumpUploadService.class;
        m1259a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -1442389774, a);
    }

    protected final void m1260a(Intent intent) {
        File file;
        Throwable th;
        File[] a = this.f1189d.a(this.f1189d.a(), MemoryDumpConstants.a);
        String a2 = MemoryDumpMetadataHandler.a();
        boolean a3 = this.f1188c.a(true);
        if (a != null && a.length != 0) {
            try {
                for (File file2 : a) {
                    if (a3) {
                        try {
                            String group;
                            Matcher matcher = MemoryDumpConstants.a.matcher(file2.getName());
                            if (matcher.matches()) {
                                group = matcher.group(1);
                            } else {
                                group = null;
                            }
                            TracerDetour.a("hprof_compression", 99902653);
                            try {
                                file = new File(StringFormatUtil.formatStrLocaleSafe("%s.gz", file2.getPath()));
                                try {
                                    this.f1189d.a(file2, file);
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                Object obj = null;
                            }
                            try {
                                TracerDetour.a(2057920760);
                                Boolean.valueOf(((Boolean) this.f1187b.a(this.f1186a, m1256a(file, group, 5, a2), f1185k)).booleanValue());
                            } catch (Exception e) {
                                th = e;
                                try {
                                    BLog.a("MemoryDumpUploadService", "Error uploading hprof file: ", th);
                                    file2.delete();
                                    if (file != null) {
                                        file.delete();
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            }
                        } catch (Exception e2) {
                            th = e2;
                            file = null;
                            BLog.a("MemoryDumpUploadService", "Error uploading hprof file: ", th);
                            file2.delete();
                            if (file != null) {
                                file.delete();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            file = null;
                        }
                    } else {
                        file = null;
                    }
                    file2.delete();
                    if (file != null) {
                        file.delete();
                    }
                }
                return;
            } finally {
                this.f1195j.b();
            }
        } else {
            return;
        }
        TracerDetour.a(1927339002);
        throw th;
        file2.delete();
        if (file != null) {
            file.delete();
        }
        throw th;
    }

    private MemoryDumpUploadMethodParams m1256a(File file, String str, int i, @Nullable String str2) {
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (!(str2 == null || str2.isEmpty())) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                str3 = jSONObject.getString("Dump cause");
                str4 = jSONObject.getString("Is Backgrounded");
                str5 = jSONObject.getString("Was Ever Foregrounded");
            } catch (Throwable e) {
                BLog.a("MemoryDumpUploadService", "Error: Metadata can't be decoded to json format ", e);
            }
        }
        return new Builder(file).m1244a(str).m1246b(i).m1243a(this.f1190e.b()).m1248c(this.f1191f.getMemoryClass()).m1247b(this.f1190e.a()).m1249c(this.f1194i.b()).m1250d(this.f1193h.b()).m1251e(this.f1192g).m1252f(str3).m1253g(str4).m1254h(str5).m1245a();
    }
}
