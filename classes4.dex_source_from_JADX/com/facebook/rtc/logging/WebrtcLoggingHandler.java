package com.facebook.rtc.logging;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.media.AudioManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.cpu.ProcessorInfoUtil;
import com.facebook.common.cpu.ProcessorInfoUtilMethodAutoProvider;
import com.facebook.common.executors.DefaultSerialListeningExecutorService;
import com.facebook.common.executors.DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.SerialListeningExecutorService;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.common.hardware.TelephonyManagerUtils;
import com.facebook.common.init.INeedInit;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.fbtrace.FbTraceEvent;
import com.facebook.fbtrace.FbTraceEventAnnotations;
import com.facebook.fbtrace.FbTraceEventAnnotationsUtil;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.fbtrace.FbTracer;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.push.mqtt.service.ChannelConnectivityTracker;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.bugreporter.RtcBugReportLogger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.webrtc.IWebrtcLoggingInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: location_service_enabled */
public class WebrtcLoggingHandler implements INeedInit, IWebrtcLoggingInterface {
    private static volatile WebrtcLoggingHandler f9116N;
    public static final Class<?> f9117a = WebrtcLoggingHandler.class;
    private int f9118A = -1;
    private int f9119B = 0;
    private int f9120C = 0;
    public int f9121D = -1;
    private String f9122E = null;
    private int f9123F;
    private int f9124G;
    private int f9125H;
    private long f9126I;
    public long f9127J;
    private HashMap<String, String> f9128K = null;
    private HashMap<String, String> f9129L = null;
    private final RtcBugReportLogger f9130M;
    private final Context f9131b;
    private final AnalyticsLogger f9132c;
    private final ChannelConnectivityTracker f9133d;
    private final DeviceConditionHelper f9134e;
    private final FbNetworkManager f9135f;
    private final TelephonyManager f9136g;
    private final Clock f9137h;
    private final ProcessorInfoUtil f9138i;
    public final DefaultSerialListeningExecutorService f9139j;
    private final Random f9140k;
    private final FbTracer f9141l;
    private final Set<Long> f9142m;
    private final Provider<Boolean> f9143n;
    private final ObjectMapper f9144o;
    private final SystemBatteryStateManager f9145p;
    private final AudioManager f9146q;
    private final QeAccessor f9147r;
    public File f9148s;
    public String f9149t;
    public long f9150u;
    public long f9151v;
    public long f9152w;
    private int f9153x;
    private int f9154y;
    private int f9155z = -1;

    /* compiled from: location_service_enabled */
    public class C05481 implements Runnable {
        final /* synthetic */ WebrtcLoggingHandler f11394a;

        public C05481(WebrtcLoggingHandler webrtcLoggingHandler) {
            this.f11394a = webrtcLoggingHandler;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r13 = this;
            r0 = r13.f11394a;
            r0 = r0.f9148s;
            r5 = r0.listFiles();
            if (r5 != 0) goto L_0x000b;
        L_0x000a:
            return;
        L_0x000b:
            r6 = r5.length;
            r0 = 0;
            r4 = r0;
        L_0x000e:
            if (r4 >= r6) goto L_0x000a;
        L_0x0010:
            r7 = r5[r4];
            r3 = 0;
            r0 = 2;
            r1 = new java.util.Date;	 Catch:{ EOFException -> 0x0072, Throwable -> 0x0124, all -> 0x0175 }
            r1.<init>();	 Catch:{ EOFException -> 0x0072, Throwable -> 0x0124, all -> 0x0175 }
            r8 = r1.getTime();	 Catch:{ EOFException -> 0x0072, Throwable -> 0x0124, all -> 0x0175 }
            r10 = r7.lastModified();	 Catch:{ EOFException -> 0x0072, Throwable -> 0x0124, all -> 0x0175 }
            r8 = r8 - r10;
            r10 = 172800000; // 0xa4cb800 float:9.856849E-33 double:8.53745436E-316;
            r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
            if (r1 >= 0) goto L_0x004a;
        L_0x0029:
            r1 = 1;
            r2 = new java.io.FileInputStream;	 Catch:{ EOFException -> 0x01cb, Throwable -> 0x01be, all -> 0x01aa }
            r2.<init>(r7);	 Catch:{ EOFException -> 0x01cb, Throwable -> 0x01be, all -> 0x01aa }
            r3 = new java.io.ObjectInputStream;	 Catch:{ EOFException -> 0x01d0, Throwable -> 0x01c2, all -> 0x01b0 }
            r3.<init>(r2);	 Catch:{ EOFException -> 0x01d0, Throwable -> 0x01c2, all -> 0x01b0 }
            r0 = r3.readObject();	 Catch:{ EOFException -> 0x01d0, Throwable -> 0x01c2, all -> 0x01b0 }
            r0 = (java.util.HashMap) r0;	 Catch:{ EOFException -> 0x01d0, Throwable -> 0x01c2, all -> 0x01b0 }
            r8 = "crash";
            r9 = "1";
            r0.put(r8, r9);	 Catch:{ EOFException -> 0x01d0, Throwable -> 0x01c2, all -> 0x01b0 }
            r8 = r13.f11394a;	 Catch:{ EOFException -> 0x01d0, Throwable -> 0x01c2, all -> 0x01b0 }
            com.facebook.rtc.logging.WebrtcLoggingHandler.m9460a(r8, r0);	 Catch:{ EOFException -> 0x01d0, Throwable -> 0x01c2, all -> 0x01b0 }
            r0 = 0;
            r3.close();	 Catch:{ EOFException -> 0x01d5, Throwable -> 0x01c5, all -> 0x01b5 }
        L_0x004a:
            r1 = r7.delete();
            if (r0 <= 0) goto L_0x006b;
        L_0x0050:
            if (r1 == 0) goto L_0x006b;
        L_0x0052:
            r1 = r13.f11394a;
            r2 = new java.lang.StringBuilder;
            r3 = "Deleted non-uploaded call summary due to: ";
            r2.<init>(r3);
            r3 = 1;
            if (r0 != r3) goto L_0x006f;
        L_0x005e:
            r0 = "exception";
        L_0x0060:
            r0 = r2.append(r0);
            r0 = r0.toString();
            r1.m9474a(r0);
        L_0x006b:
            r0 = r4 + 1;
            r4 = r0;
            goto L_0x000e;
        L_0x006f:
            r0 = "old";
            goto L_0x0060;
        L_0x0072:
            r1 = move-exception;
            r1 = r3;
        L_0x0074:
            r2 = r7.getName();	 Catch:{ Throwable -> 0x00fc, all -> 0x01b7 }
            r3 = 45;
            r3 = r2.indexOf(r3);	 Catch:{ Throwable -> 0x00fc, all -> 0x01b7 }
            r8 = 46;
            r8 = r2.indexOf(r8);	 Catch:{ Throwable -> 0x00fc, all -> 0x01b7 }
            r9 = -1;
            if (r8 == r9) goto L_0x0096;
        L_0x0087:
            r9 = -1;
            if (r3 == r9) goto L_0x0096;
        L_0x008a:
            r9 = r2.substring(r8);	 Catch:{ Throwable -> 0x00fc, all -> 0x01b7 }
            r10 = ".callsum";
            r9 = r9.equals(r10);	 Catch:{ Throwable -> 0x00fc, all -> 0x01b7 }
            if (r9 != 0) goto L_0x00c4;
        L_0x0096:
            r2 = r13.f11394a;	 Catch:{ Throwable -> 0x00fc, all -> 0x01b7 }
            r3 = "Unable to upload crashed call summary: The file cannot be parsed";
            r2.m9474a(r3);	 Catch:{ Throwable -> 0x00fc, all -> 0x01b7 }
        L_0x009d:
            if (r1 == 0) goto L_0x00a2;
        L_0x009f:
            r1.close();	 Catch:{ IOException -> 0x0118 }
        L_0x00a2:
            r1 = r7.delete();
            if (r0 <= 0) goto L_0x006b;
        L_0x00a8:
            if (r1 == 0) goto L_0x006b;
        L_0x00aa:
            r1 = r13.f11394a;
            r2 = new java.lang.StringBuilder;
            r3 = "Deleted non-uploaded call summary due to: ";
            r2.<init>(r3);
            r3 = 1;
            if (r0 != r3) goto L_0x0121;
        L_0x00b6:
            r0 = "exception";
        L_0x00b8:
            r0 = r2.append(r0);
            r0 = r0.toString();
            r1.m9474a(r0);
            goto L_0x006b;
        L_0x00c4:
            r9 = 0;
            r9 = r2.substring(r9, r3);	 Catch:{  }
            r10 = java.lang.Long.parseLong(r9);	 Catch:{  }
            r3 = r3 + 1;
            r2 = r2.substring(r3, r8);	 Catch:{  }
            r2 = java.lang.Long.parseLong(r2);	 Catch:{  }
            r8 = new java.util.HashMap;	 Catch:{  }
            r8.<init>();	 Catch:{  }
            r9 = "call_id";
            r10 = java.lang.Long.toString(r10);	 Catch:{  }
            r8.put(r9, r10);	 Catch:{  }
            r9 = "peer_id";
            r2 = java.lang.Long.toString(r2);	 Catch:{  }
            r8.put(r9, r2);	 Catch:{  }
            r2 = "crash";
            r3 = "1";
            r8.put(r2, r3);	 Catch:{  }
            r2 = r13.f11394a;	 Catch:{  }
            com.facebook.rtc.logging.WebrtcLoggingHandler.m9460a(r2, r8);	 Catch:{  }
            r0 = 0;
            goto L_0x009d;
        L_0x00fc:
            r2 = move-exception;
            r3 = r13.f11394a;	 Catch:{ Throwable -> 0x0116, all -> 0x01b7 }
            r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0116, all -> 0x01b7 }
            r9 = "Unable to upload crashed call summary: ";
            r8.<init>(r9);	 Catch:{ Throwable -> 0x0116, all -> 0x01b7 }
            r2 = com.facebook.common.util.ExceptionUtil.a(r2);	 Catch:{ Throwable -> 0x0116, all -> 0x01b7 }
            r2 = r8.append(r2);	 Catch:{ Throwable -> 0x0116, all -> 0x01b7 }
            r2 = r2.toString();	 Catch:{ Throwable -> 0x0116, all -> 0x01b7 }
            r3.m9474a(r2);	 Catch:{ Throwable -> 0x0116, all -> 0x01b7 }
            goto L_0x009d;
        L_0x0116:
            r2 = move-exception;
            goto L_0x009d;
        L_0x0118:
            r1 = move-exception;
            r2 = com.facebook.rtc.logging.WebrtcLoggingHandler.f9117a;
            r3 = "Failed to close dangling Stream";
            com.facebook.debug.log.BLog.b(r2, r3, r1);
            goto L_0x00a2;
        L_0x0121:
            r0 = "old";
            goto L_0x00b8;
        L_0x0124:
            r1 = move-exception;
            r2 = r3;
            r12 = r0;
            r0 = r1;
            r1 = r12;
        L_0x0129:
            r3 = r13.f11394a;	 Catch:{ Throwable -> 0x01bc, all -> 0x01b0 }
            r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01bc, all -> 0x01b0 }
            r9 = "Unable to upload crashed call summary: ";
            r8.<init>(r9);	 Catch:{ Throwable -> 0x01bc, all -> 0x01b0 }
            r0 = com.facebook.common.util.ExceptionUtil.a(r0);	 Catch:{ Throwable -> 0x01bc, all -> 0x01b0 }
            r0 = r8.append(r0);	 Catch:{ Throwable -> 0x01bc, all -> 0x01b0 }
            r0 = r0.toString();	 Catch:{ Throwable -> 0x01bc, all -> 0x01b0 }
            r3.m9474a(r0);	 Catch:{ Throwable -> 0x01bc, all -> 0x01b0 }
        L_0x0141:
            if (r2 == 0) goto L_0x0146;
        L_0x0143:
            r2.close();	 Catch:{ IOException -> 0x0169 }
        L_0x0146:
            r0 = r7.delete();
            if (r1 <= 0) goto L_0x006b;
        L_0x014c:
            if (r0 == 0) goto L_0x006b;
        L_0x014e:
            r2 = r13.f11394a;
            r3 = new java.lang.StringBuilder;
            r0 = "Deleted non-uploaded call summary due to: ";
            r3.<init>(r0);
            r0 = 1;
            if (r1 != r0) goto L_0x0172;
        L_0x015a:
            r0 = "exception";
        L_0x015c:
            r0 = r3.append(r0);
            r0 = r0.toString();
            r2.m9474a(r0);
            goto L_0x006b;
        L_0x0169:
            r0 = move-exception;
            r2 = com.facebook.rtc.logging.WebrtcLoggingHandler.f9117a;
            r3 = "Failed to close dangling Stream";
            com.facebook.debug.log.BLog.b(r2, r3, r0);
            goto L_0x0146;
        L_0x0172:
            r0 = "old";
            goto L_0x015c;
        L_0x0175:
            r1 = move-exception;
            r2 = r3;
        L_0x0177:
            if (r2 == 0) goto L_0x017c;
        L_0x0179:
            r2.close();	 Catch:{ IOException -> 0x019e }
        L_0x017c:
            r2 = r7.delete();
            if (r0 <= 0) goto L_0x019d;
        L_0x0182:
            if (r2 == 0) goto L_0x019d;
        L_0x0184:
            r2 = r13.f11394a;
            r3 = new java.lang.StringBuilder;
            r4 = "Deleted non-uploaded call summary due to: ";
            r3.<init>(r4);
            r4 = 1;
            if (r0 != r4) goto L_0x01a7;
        L_0x0190:
            r0 = "exception";
        L_0x0192:
            r0 = r3.append(r0);
            r0 = r0.toString();
            r2.m9474a(r0);
        L_0x019d:
            throw r1;
        L_0x019e:
            r2 = move-exception;
            r3 = com.facebook.rtc.logging.WebrtcLoggingHandler.f9117a;
            r4 = "Failed to close dangling Stream";
            com.facebook.debug.log.BLog.b(r3, r4, r2);
            goto L_0x017c;
        L_0x01a7:
            r0 = "old";
            goto L_0x0192;
        L_0x01aa:
            r0 = move-exception;
            r2 = r3;
            r12 = r1;
            r1 = r0;
            r0 = r12;
            goto L_0x0177;
        L_0x01b0:
            r0 = move-exception;
            r12 = r0;
            r0 = r1;
            r1 = r12;
            goto L_0x0177;
        L_0x01b5:
            r1 = move-exception;
            goto L_0x0177;
        L_0x01b7:
            r2 = move-exception;
            r12 = r2;
            r2 = r1;
            r1 = r12;
            goto L_0x0177;
        L_0x01bc:
            r0 = move-exception;
            goto L_0x0141;
        L_0x01be:
            r0 = move-exception;
            r2 = r3;
            goto L_0x0129;
        L_0x01c2:
            r0 = move-exception;
            goto L_0x0129;
        L_0x01c5:
            r1 = move-exception;
            r12 = r1;
            r1 = r0;
            r0 = r12;
            goto L_0x0129;
        L_0x01cb:
            r0 = move-exception;
            r0 = r1;
            r1 = r3;
            goto L_0x0074;
        L_0x01d0:
            r0 = move-exception;
            r0 = r1;
            r1 = r2;
            goto L_0x0074;
        L_0x01d5:
            r1 = move-exception;
            r1 = r2;
            goto L_0x0074;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.logging.WebrtcLoggingHandler.1.run():void");
        }
    }

    public static com.facebook.rtc.logging.WebrtcLoggingHandler m9451a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9116N;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtc.logging.WebrtcLoggingHandler.class;
        monitor-enter(r1);
        r0 = f9116N;	 Catch:{ all -> 0x003a }
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
        r0 = m9463b(r0);	 Catch:{ all -> 0x0035 }
        f9116N = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9116N;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.logging.WebrtcLoggingHandler.a(com.facebook.inject.InjectorLike):com.facebook.rtc.logging.WebrtcLoggingHandler");
    }

    private static WebrtcLoggingHandler m9463b(InjectorLike injectorLike) {
        return new WebrtcLoggingHandler((Context) injectorLike.getInstance(Context.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), ChannelConnectivityTracker.a(injectorLike), DeviceConditionHelper.a(injectorLike), FbNetworkManager.a(injectorLike), TelephonyManagerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ProcessorInfoUtilMethodAutoProvider.a(injectorLike), Random_InsecureRandomMethodAutoProvider.a(injectorLike), DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), FbTracer.a(injectorLike), IdBasedProvider.a(injectorLike, 4305), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), SystemBatteryStateManager.a(injectorLike), AudioManagerMethodAutoProvider.a(injectorLike), RtcBugReportLogger.m9491a(injectorLike));
    }

    @Inject
    public WebrtcLoggingHandler(Context context, AnalyticsLogger analyticsLogger, ChannelConnectivityTracker channelConnectivityTracker, DeviceConditionHelper deviceConditionHelper, FbNetworkManager fbNetworkManager, TelephonyManager telephonyManager, Clock clock, ProcessorInfoUtil processorInfoUtil, Random random, SerialListeningExecutorService serialListeningExecutorService, FbTracer fbTracer, Provider<Boolean> provider, ObjectMapper objectMapper, QeAccessor qeAccessor, SystemBatteryStateManager systemBatteryStateManager, AudioManager audioManager, RtcBugReportLogger rtcBugReportLogger) {
        this.f9131b = context;
        this.f9132c = analyticsLogger;
        this.f9133d = channelConnectivityTracker;
        this.f9134e = deviceConditionHelper;
        this.f9135f = fbNetworkManager;
        this.f9136g = telephonyManager;
        this.f9137h = clock;
        this.f9138i = processorInfoUtil;
        this.f9140k = random;
        this.f9139j = serialListeningExecutorService;
        this.f9141l = fbTracer;
        this.f9143n = provider;
        this.f9144o = objectMapper;
        this.f9147r = qeAccessor;
        this.f9142m = Sets.b();
        this.f9145p = systemBatteryStateManager;
        this.f9146q = audioManager;
        this.f9130M = rtcBugReportLogger;
    }

    public final void m9470a() {
        this.f9155z = m9465k();
    }

    public final void m9481b() {
        this.f9118A = m9465k();
    }

    public void init() {
        this.f9148s = this.f9131b.getDir("call_stats", 0);
        this.f9120C = 0;
        ExecutorDetour.a(this.f9139j, new C05481(this), -1505391793);
    }

    private void m9455a(HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.c = "webrtc";
        this.f9132c.c(honeyClientEvent);
    }

    public void setLastCallId(long j) {
        this.f9150u = j;
    }

    public void logInitialBatteryLevel() {
        this.f9153x = Math.round(this.f9145p.a() * 100.0f);
    }

    public final void m9471a(int i) {
        this.f9154y = i;
    }

    public void logReceivedMessage(String str, long j, long j2, long j3, long j4, String str2) {
        Long.valueOf(j);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("received_message");
        honeyClientEvent.b("type", str);
        honeyClientEvent.a("msg_id", j);
        if (j2 != 0) {
            honeyClientEvent.a("ack_msg_id", j2);
        }
        honeyClientEvent.a("call_id", j3);
        honeyClientEvent.a("from", j4);
        honeyClientEvent.b("content", str2);
        m9455a(honeyClientEvent);
        this.f9130M.m9493a(StringFormatUtil.a("Message received: call_id[%d] msg_id[%d] type[%s] peer_id[%d] contents[%s]", new Object[]{Long.valueOf(j3), Long.valueOf(j), str, Long.valueOf(j4), str2}));
    }

    public void logSentMessage(String str, long j, long j2, long j3, long j4, String str2, String str3) {
        Long.valueOf(j);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("sent_message");
        honeyClientEvent.b("type", str);
        honeyClientEvent.a("msg_id", j);
        if (j2 != 0) {
            honeyClientEvent.a("ack_msg_id", j2);
        }
        honeyClientEvent.a("call_id", j3);
        honeyClientEvent.a("to", j4);
        honeyClientEvent.b("content", str3);
        honeyClientEvent.b("destination", str2);
        m9455a(honeyClientEvent);
        this.f9130M.m9493a(StringFormatUtil.a("Message sent: call_id[%d] msg_id[%d] type[%s] peer_id[%d] destination[%s] contents[%s]", new Object[]{Long.valueOf(j3), Long.valueOf(j), str, Long.valueOf(j4), str2, str3}));
    }

    public void logSentMessageSuccess(long j, long j2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("send_succeeded");
        honeyClientEvent.a("msg_id", j);
        honeyClientEvent.a("call_id", j2);
        m9455a(honeyClientEvent);
        this.f9130M.m9493a(StringFormatUtil.formatStrLocaleSafe("Messege success: call_id[%d] msg_id[%d]", Long.valueOf(j2), Long.valueOf(j)));
    }

    public void logSentMessageFailure(long j, int i, String str, String str2, long j2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("send_failed");
        honeyClientEvent.a("msg_id", j);
        honeyClientEvent.b("error", str2);
        honeyClientEvent.a("error_code", i);
        honeyClientEvent.b("error_domain", str);
        honeyClientEvent.a("call_id", j2);
        m9455a(honeyClientEvent);
        this.f9130M.m9493a(StringFormatUtil.a("Message failure: call_id[%d] msg_id[%d] domain[%s] code[%d] err_desc[%s]", new Object[]{Long.valueOf(j2), Long.valueOf(j), str, Integer.valueOf(i), str2}));
    }

    public void logCallAction(long j, long j2, String str, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("call_action");
        honeyClientEvent.a("call_id", j);
        honeyClientEvent.a("peer_id", j2);
        honeyClientEvent.b("call_action", str);
        honeyClientEvent.b("content", str2);
        m9464b(honeyClientEvent);
        if ("start_call".equals(str)) {
            this.f9130M.m9493a(StringFormatUtil.a("Call action: call_id[%d] peer_id[%d] call_action[%s] details[%s] trigger[%s]", new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2, this.f9149t}));
            honeyClientEvent.b("trigger", this.f9149t);
            this.f9149t = null;
            if (this.f9151v > 0) {
                honeyClientEvent.a("callable_freshness", this.f9137h.a() - this.f9151v);
            } else {
                honeyClientEvent.a("callable_freshness", -1);
            }
            this.f9152w = this.f9151v;
            this.f9151v = 0;
            this.f9150u = j;
        } else if ("end_call".equals(str)) {
            this.f9130M.m9493a(StringFormatUtil.formatStrLocaleSafe("Call action: call_id[%d] peer_id[%d] call_action[%s] details[%s]", Long.valueOf(j), Long.valueOf(j2), str, str2));
            this.f9150u = 0;
        } else if ("set_video_on".equals(str)) {
            this.f9130M.m9493a(StringFormatUtil.formatStrLocaleSafe("Call action: call_id[%d] peer_id[%d] call_action[%s] details[%s]", Long.valueOf(j), Long.valueOf(j2), str, str2));
            honeyClientEvent.a("num_cam", Camera.getNumberOfCameras());
            honeyClientEvent.a("id", this.f9123F);
            honeyClientEvent.a("width", this.f9124G);
            honeyClientEvent.a("height", this.f9125H);
            if (this.f9123F >= 0) {
                CameraInfo cameraInfo = new CameraInfo();
                Camera.getCameraInfo(this.f9123F, cameraInfo);
                honeyClientEvent.a("facing", cameraInfo.facing);
                honeyClientEvent.a("orient", cameraInfo.orientation);
            }
        }
        m9455a(honeyClientEvent);
    }

    public void logConnectionStatus(boolean z, String str, long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("connection_status");
        honeyClientEvent.b("is_connected", Boolean.toString(z));
        honeyClientEvent.a("call_id", j);
        honeyClientEvent.b("content", str);
        m9455a(honeyClientEvent);
        Boolean.valueOf(z);
        this.f9130M.m9493a(StringFormatUtil.formatStrLocaleSafe("Connection status: call_id[%d] is_connected[%b] details[%s]", Long.valueOf(j), Boolean.valueOf(z), str));
    }

    public void logIceConnectionState(long j, int i) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("ice_connection_state");
        honeyClientEvent.b("call_id", Long.toString(j));
        honeyClientEvent.b("state", Integer.toString(i));
        m9455a(honeyClientEvent);
        this.f9130M.m9493a(StringFormatUtil.formatStrLocaleSafe("Ice connection state: call_id[%d] state[%d]", Long.valueOf(j), Integer.valueOf(i)));
    }

    public void logInternalInfo(String str, String str2, long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("info");
        honeyClientEvent.b("tag", str);
        honeyClientEvent.b("content", str2);
        honeyClientEvent.a("call_id", j);
        m9455a(honeyClientEvent);
        Long.valueOf(j);
        this.f9130M.m9493a(StringFormatUtil.formatStrLocaleSafe("call_id[%d] tag[%s]: %s", Long.valueOf(j), str, str2));
    }

    public void logInternalError(String str, long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("internal_error");
        honeyClientEvent.b("error", str);
        honeyClientEvent.a("call_id", j);
        m9455a(honeyClientEvent);
        BLog.b(f9117a, "internal error: callid=%d: %s", new Object[]{Long.valueOf(j), str});
        this.f9130M.m9493a(StringFormatUtil.formatStrLocaleSafe("InternalError call_id[%d], %s", Long.valueOf(j), str));
    }

    public void logEndCallSummary(long j, String str) {
        m9454a(j, m9469a(j, str));
        this.f9142m.remove(Long.valueOf(j));
        this.f9130M.m9493a(StringFormatUtil.formatStrLocaleSafe("EndCallSummary call_id[%d] %s", Long.valueOf(j), str));
    }

    private int m9465k() {
        int mode = this.f9146q.getMode() & 7;
        if (this.f9146q.isBluetoothA2dpOn()) {
            mode |= 8;
        }
        if (this.f9146q.isBluetoothScoOn()) {
            mode |= 16;
        }
        if (this.f9146q.isMicrophoneMute()) {
            mode |= 32;
        }
        if (this.f9146q.isMusicActive()) {
            mode |= 64;
        }
        if (this.f9146q.isSpeakerphoneOn()) {
            return mode | 128;
        }
        return mode;
    }

    public void periodicLogging(long j, String str) {
        refreshLogUploadPause();
        ExecutorDetour.a(this.f9139j, new 2(this, str, j), -393148406);
        int k = m9465k();
        if (k != this.f9119B) {
            this.f9120C++;
            this.f9119B = k;
        }
    }

    private void m9454a(long j, HashMap<String, String> hashMap) {
        m9460a(this, (HashMap) hashMap);
        m9453a(j);
    }

    public void discardCall(long j) {
        m9453a(j);
        this.f9142m.remove(Long.valueOf(j));
    }

    public final void m9478a(String str, String str2, boolean z, String str3) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        ObjectNode a = objectNode.k("core_metrics").a("ver", 20).a("call_type", z ? "direct_video" : "voip").a("caller", 1).a("peer_id", str);
        a.k("end").a("conn_type", "").a("ctd", 0).a("remote_ended", 0).a("end_call_reason_string", "AbortedCall").a("end_call_subreason_string", str3);
        a.k("signaling").a("start_time", new Date().getTime()).a("trigger", str2).k("time_from_start").a("started", 0).a("ended", 0);
        m9460a(this, m9469a(m9466l(), objectNode.toString()));
    }

    private long m9466l() {
        long abs;
        do {
            abs = (long) Math.abs(this.f9140k.nextInt());
        } while (abs == 0);
        return abs;
    }

    public final void m9473a(int i, boolean z, boolean z2, long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("survey");
        honeyClientEvent.a("rating5", i);
        honeyClientEvent.a("speaker_on", z);
        honeyClientEvent.a("microphone_mute", z2);
        honeyClientEvent.a("call_id", j);
        honeyClientEvent.a("android_sdk", VERSION.SDK_INT);
        m9455a(honeyClientEvent);
        this.f9130M.m9493a(StringFormatUtil.formatStrLocaleSafe("Survey: call_id[%d] rating[%d]", Long.valueOf(j), Integer.valueOf(i)));
    }

    public void logFbTraceRequestReceived(String str) {
        if (!Strings.isNullOrEmpty(str)) {
            FbTraceNode b = this.f9141l.b(str);
            FbTraceEventAnnotations a = FbTraceEventAnnotationsUtil.m12132a(b);
            a.put("op", "app_to_engine_receive");
            a.put("service", "receiver_webrtc_engine_layer");
            this.f9141l.a(b, FbTraceEvent.REQUEST_RECEIVE, a);
        }
    }

    public void logFbTraceReplySentSuccess(String str, String str2, long j, long j2, long j3, long j4) {
        if (!Strings.isNullOrEmpty(str)) {
            this.f9142m.add(Long.valueOf(j3));
            FbTraceNode b = this.f9141l.b(str);
            FbTraceEventAnnotations a = FbTraceEventAnnotationsUtil.m12132a(b);
            a.put("msg_type", str2);
            m9457a(a, j2, j, j3);
            a.put("sender_id", Long.valueOf(j4));
            a.put("success", "true");
            a.put("op", "app_to_engine_receive");
            a.put("service", "receiver_webrtc_engine_layer");
            this.f9141l.a(b, FbTraceEvent.RESPONSE_SEND, a);
        }
    }

    public void logFbTraceReplySentFailure(String str, long j, long j2, long j3, long j4, String str2) {
        if (!Strings.isNullOrEmpty(str)) {
            this.f9142m.add(Long.valueOf(j3));
            FbTraceNode b = this.f9141l.b(str);
            FbTraceEventAnnotations a = FbTraceEventAnnotationsUtil.m12132a(b);
            m9458a(a, j2, j, j3, str2);
            a.put("sender_id", Long.valueOf(j4));
            a.put("op", "app_to_engine_receive");
            a.put("service", "receiver_webrtc_engine_layer");
            this.f9141l.a(b, FbTraceEvent.RESPONSE_SEND, a);
        }
    }

    public String logFbTraceRequestSent(String str, long j, long j2, long j3, long j4, String str2, int i, String str3, String str4) {
        FbTraceNode b;
        if (this.f9142m.contains(Long.valueOf(j3)) || ((Boolean) this.f9143n.get()).booleanValue()) {
            b = FbTracer.b();
        } else {
            b = this.f9141l.a("voip_sampling_rate");
        }
        if (b == FbTraceNode.a) {
            return "";
        }
        this.f9142m.add(Long.valueOf(j3));
        FbTraceEventAnnotations a = FbTraceEventAnnotationsUtil.m12132a(b);
        m9457a(a, j2, j, j3);
        a.put("msg_type", str);
        a.put("recipient_id", Long.valueOf(j4));
        a.put("op", "engine_to_app_send");
        a.put("service", "sender_webrtc_application_layer");
        a.put("destination", str2);
        a.put("retry_count", Integer.valueOf(i));
        a.put("trigger", str3);
        if (!(str4.isEmpty() || m9461a(a, str4))) {
            a.put("callability_raw", str4);
        }
        this.f9141l.a(b, FbTraceEvent.REQUEST_SEND, a);
        return b.a();
    }

    private boolean m9461a(FbTraceEventAnnotations fbTraceEventAnnotations, String str) {
        try {
            for (Entry entry : ((Map) this.f9144o.a(this.f9144o.a(str), Map.class)).entrySet()) {
                fbTraceEventAnnotations.put(entry.getKey(), entry.getValue());
            }
            return true;
        } catch (IOException e) {
            return false;
        } catch (IllegalArgumentException e2) {
            return false;
        } catch (ClassCastException e3) {
            return false;
        }
    }

    public void logFbTraceReplyReceivedSuccess(String str, long j, long j2) {
        if (!Strings.isNullOrEmpty(str)) {
            FbTraceNode b = this.f9141l.b(str);
            FbTraceEventAnnotations a = FbTraceEventAnnotationsUtil.m12132a(b);
            m9456a(a, j, j2);
            a.put("success", "true");
            a.put("op", "engine_to_app_send");
            a.put("service", "sender_webrtc_application_layer");
            this.f9141l.a(b, FbTraceEvent.RESPONSE_RECEIVE, a);
        }
    }

    public void logFbTraceReplyReceivedFailure(String str, long j, long j2, String str2) {
        if (!Strings.isNullOrEmpty(str)) {
            FbTraceNode b = this.f9141l.b(str);
            FbTraceEventAnnotations a = FbTraceEventAnnotationsUtil.m12132a(b);
            m9459a(a, j, j2, str2);
            a.put("op", "engine_to_app_send");
            a.put("service", "sender_webrtc_application_layer");
            this.f9141l.a(b, FbTraceEvent.RESPONSE_RECEIVE, a);
        }
    }

    private void m9458a(FbTraceEventAnnotations fbTraceEventAnnotations, long j, long j2, long j3, String str) {
        fbTraceEventAnnotations.put("ack_msg_id", Long.valueOf(j2));
        m9459a(fbTraceEventAnnotations, j, j3, str);
    }

    private void m9457a(FbTraceEventAnnotations fbTraceEventAnnotations, long j, long j2, long j3) {
        fbTraceEventAnnotations.put("ack_msg_id", Long.valueOf(j2));
        m9456a(fbTraceEventAnnotations, j, j3);
    }

    private void m9459a(FbTraceEventAnnotations fbTraceEventAnnotations, long j, long j2, String str) {
        fbTraceEventAnnotations.put("error_code", str);
        fbTraceEventAnnotations.put("success", "false");
        m9456a(fbTraceEventAnnotations, j, j2);
    }

    private static void m9456a(FbTraceEventAnnotations fbTraceEventAnnotations, long j, long j2) {
        fbTraceEventAnnotations.put("msg_id", Long.valueOf(j));
        fbTraceEventAnnotations.put("call_id", Long.valueOf(j2));
    }

    public final void m9472a(int i, int i2, int i3) {
        this.f9123F = i;
        this.f9124G = i2;
        this.f9125H = i3;
    }

    public final void m9476a(String str, long j, long j2, long j3, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("dropped_message");
        honeyClientEvent.b("type", str);
        honeyClientEvent.a("msg_id", j);
        honeyClientEvent.a("call_id", j2);
        honeyClientEvent.a("from", j3);
        honeyClientEvent.b("source", str2);
        m9455a(honeyClientEvent);
    }

    public final void m9475a(String str, long j) {
        this.f9149t = str;
        this.f9151v = j;
    }

    public void logEngineCreationEvent(boolean z) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("client_event");
        if (z) {
            honeyClientEvent.b("content", "engine_creation_succeeded");
        } else {
            honeyClientEvent.b("content", "engine_creation_failed");
        }
        m9455a(honeyClientEvent);
    }

    public final void m9479a(boolean z) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("client_event");
        honeyClientEvent.b("content", "failed_set_audio_mode");
        honeyClientEvent.a("modify_audio", z);
        honeyClientEvent.a("android_sdk", VERSION.SDK_INT);
        m9455a(honeyClientEvent);
    }

    public final void m9485d() {
        if (this.f9150u != 0) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("connectivity_status");
            String o = m9468o();
            honeyClientEvent.a("call_id", this.f9150u);
            honeyClientEvent.a("mqtt", this.f9133d.f());
            honeyClientEvent.a("wifi", this.f9134e.b());
            if (this.f9136g != null) {
                honeyClientEvent.b("network_type", TelephonyManagerUtils.a(this.f9136g.getNetworkType()));
                honeyClientEvent.b("phone_type", TelephonyManagerUtils.c(this.f9136g));
            }
            honeyClientEvent.b("connectivity", o);
            m9455a(honeyClientEvent);
            Long.valueOf(this.f9150u);
        }
    }

    public final void m9474a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("client_error");
        honeyClientEvent.a("call_id", this.f9150u);
        honeyClientEvent.b("content", str);
        m9455a(honeyClientEvent);
    }

    public final void m9486e() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("client_event");
        honeyClientEvent.b("content", "ringtone_toast_shown");
        m9455a(honeyClientEvent);
    }

    private void m9464b(HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.b("connectivity", m9468o());
        honeyClientEvent.a("net_sid", this.f9135f.p);
        Optional e = this.f9135f.e();
        if (e.isPresent()) {
            honeyClientEvent.a("net_duration", e.get());
        }
        int r = this.f9135f.r();
        if (r != Integer.MIN_VALUE) {
            honeyClientEvent.a("rssi100", WifiManager.calculateSignalLevel(r, 10));
        }
        NetworkInfo c = this.f9134e.c();
        String str = "";
        if (c != null) {
            str = c.getState().name();
            if (!c.isConnected()) {
                honeyClientEvent.a("is_connected", false);
            }
        }
        honeyClientEvent.b("net_state", str);
        if (this.f9136g != null) {
            honeyClientEvent.b("network_type", TelephonyManagerUtils.a(this.f9136g.getNetworkType()));
            honeyClientEvent.b("phone_type", TelephonyManagerUtils.c(this.f9136g));
            honeyClientEvent.b("sim_home_location", TelephonyManagerUtils.a(TelephonyManagerUtils.e(this.f9136g)));
            honeyClientEvent.b("sim_current_location", TelephonyManagerUtils.a(TelephonyManagerUtils.f(this.f9136g)));
        }
        honeyClientEvent.a("mqtt", this.f9133d.e());
        honeyClientEvent.a("wifi", this.f9134e.b());
    }

    public void pauseLogUpload() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("control_event");
        honeyClientEvent.a("pause_upload", "90000");
        m9455a(honeyClientEvent);
    }

    public void resumeLogUpload() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("control_event");
        honeyClientEvent.a("unpause_upload", "1");
        m9455a(honeyClientEvent);
    }

    public void refreshLogUploadPause() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("control_event");
        honeyClientEvent.a("pause_upload", "30000");
        m9455a(honeyClientEvent);
    }

    public static long m9462b(WebrtcLoggingHandler webrtcLoggingHandler, String str) {
        return webrtcLoggingHandler.f9144o.a(str).c("core_metrics").c("peer_id").a(-1);
    }

    private void m9467n() {
        BufferedReader bufferedReader;
        Throwable th;
        Reader reader;
        FileReader fileReader = null;
        if (this.f9122E == null) {
            try {
                File file = new File("/proc/asound/cards");
                if (file.exists()) {
                    try {
                        Reader fileReader2 = new FileReader(file);
                        try {
                            bufferedReader = new BufferedReader(fileReader2);
                            try {
                                this.f9122E = bufferedReader.readLine();
                                bufferedReader.close();
                                fileReader2.close();
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                reader = fileReader2;
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (fileReader != null) {
                                    fileReader.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = null;
                            reader = fileReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = null;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        throw th;
                    }
                }
                this.f9122E = "unknown";
            } catch (IOException e) {
                this.f9122E = "unknown";
            }
        }
    }

    public final void m9487f() {
        m9467n();
    }

    public final HashMap<String, String> m9469a(long j, String str) {
        if (StringUtil.a(str)) {
            return null;
        }
        HashMap<String, String> c = Maps.c();
        c.put("content", str);
        c.put("call_id", Long.toString(j));
        if (this.f9153x >= 0) {
            c.put("battery_start", Integer.toString(this.f9153x));
        }
        int round = Math.round(this.f9145p.a() * 100.0f);
        if (round >= 0) {
            c.put("battery_end", Integer.toString(round));
        }
        c.put("hw_au_md_cfg", Integer.toString(this.f9154y));
        if (this.f9155z != -1) {
            c.put("start_au_manager", Integer.toString(this.f9155z));
        }
        if (this.f9118A != -1) {
            c.put("end_au_manager", Integer.toString(this.f9118A));
        }
        c.put("num_au_manager_changed", Integer.toString(this.f9120C));
        if (VERSION.SDK_INT < 19) {
            return c;
        }
        if (this.f9122E != null) {
            c.put("au_chip", this.f9122E);
        }
        c.put("cpu_cores", Integer.toString(this.f9138i.d()));
        c.put("cpu_mhz", Integer.toString(this.f9138i.e().intValue() / 1000));
        return c;
    }

    private void m9453a(long j) {
        ExecutorDetour.a(this.f9139j, new 3(this, j), 1746872455);
    }

    public static void m9460a(WebrtcLoggingHandler webrtcLoggingHandler, HashMap hashMap) {
        if (hashMap != null) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("info");
            honeyClientEvent.b("tag", "endcallstats");
            honeyClientEvent.a(hashMap);
            webrtcLoggingHandler.m9464b(honeyClientEvent);
            if (webrtcLoggingHandler.f9121D != -1) {
                honeyClientEvent.a("cell_lvl", webrtcLoggingHandler.f9121D);
            }
            if (webrtcLoggingHandler.f9147r.a(Liveness.Cached, ExperimentsForRtcLoggingModule.a, false)) {
                honeyClientEvent.c = "webrtc";
                webrtcLoggingHandler.f9132c.d(honeyClientEvent);
            } else {
                webrtcLoggingHandler.m9455a(honeyClientEvent);
            }
            if (BLog.a() <= 3) {
                String d = honeyClientEvent.d();
                int length = d.length();
                if (length >= 4000) {
                    int i = 0;
                    while (i < length / 4000) {
                        d.substring(i * 4000, ((i + 1) * 4000) - 1);
                        Integer.valueOf(i + 1);
                        i++;
                    }
                    d.substring((i * 4000) - 1, length - 1);
                    Integer.valueOf(i + 1);
                }
            }
        }
    }

    public static File m9452a(WebrtcLoggingHandler webrtcLoggingHandler, long j, long j2) {
        return new File(webrtcLoggingHandler.f9148s, j + "-" + j2 + ".callsum");
    }

    public final void m9482b(int i) {
        this.f9121D = i;
    }

    public final synchronized void m9483b(long j, String str) {
        this.f9126I = j;
        this.f9128K = m9469a(j, str);
        if (this.f9129L != null) {
            for (Entry entry : this.f9129L.entrySet()) {
                this.f9128K.put(entry.getKey(), entry.getValue());
            }
            this.f9129L = null;
        }
    }

    public final synchronized void m9477a(String str, String str2) {
        if (this.f9128K == null) {
            if (this.f9129L == null) {
                this.f9129L = Maps.c();
            }
            this.f9129L.put(str, str2);
        } else {
            this.f9128K.put(str, str2);
        }
    }

    public final boolean m9484b(String str, long j) {
        if (j == 0) {
            return false;
        }
        m9477a(str, String.valueOf(j));
        return true;
    }

    public final boolean m9480a(String str, boolean z) {
        if (!z) {
            return false;
        }
        m9477a(str, "1");
        return true;
    }

    public final void m9488h() {
        if (this.f9128K != null) {
            m9454a(this.f9126I, this.f9128K);
            this.f9128K = null;
            this.f9126I = 0;
            m9489i();
        }
    }

    public final void m9489i() {
        if (this.f9128K != null || this.f9129L != null) {
            logCallAction(0, 0, "logging_not_reset", this.f9128K != null ? "end_call_summary" : "temp_call_summary");
            this.f9128K = null;
            this.f9129L = null;
            this.f9126I = 0;
        }
    }

    private String m9468o() {
        NetworkInfo c = this.f9134e.c();
        if (c == null || !c.isConnectedOrConnecting()) {
            return "none";
        }
        if (c.getType() == 0) {
            return "cell";
        }
        if (c.getType() == 1 || !"mobile2".equals(c.getTypeName())) {
            return c.getTypeName();
        }
        return "cell";
    }
}
