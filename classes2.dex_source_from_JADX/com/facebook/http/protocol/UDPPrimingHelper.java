package com.facebook.http.protocol;

import android.content.SharedPreferences.Editor;
import android.net.Uri;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.udppriming.client.ColdStartPrimingInformation;
import com.facebook.common.udppriming.client.EncryptChannelInformation;
import com.facebook.common.udppriming.client.UDPPrimingDNSInfo;
import com.facebook.config.server.ServerConfig;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.debug.log.BLog;
import com.facebook.http.onion.TorProxy;
import com.facebook.http.onion.TorProxyMethodAutoProvider;
import com.facebook.http.qe.ExperimentsForHttpQeModule;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbandroidProductionConfig;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

@Singleton
/* compiled from: server_disable_client_prompts_gatekeeper */
public class UDPPrimingHelper {
    private static volatile UDPPrimingHelper f5543f;
    private final boolean f5544a;
    public String f5545b;
    public ExecutorService f5546c;
    private QeAccessor f5547d;
    private TorProxy f5548e;

    public static com.facebook.http.protocol.UDPPrimingHelper m9443a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5543f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.protocol.UDPPrimingHelper.class;
        monitor-enter(r1);
        r0 = f5543f;	 Catch:{ all -> 0x003a }
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
        r0 = m9447b(r0);	 Catch:{ all -> 0x0035 }
        f5543f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5543f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.protocol.UDPPrimingHelper.a(com.facebook.inject.InjectorLike):com.facebook.http.protocol.UDPPrimingHelper");
    }

    private static UDPPrimingHelper m9447b(InjectorLike injectorLike) {
        return new UDPPrimingHelper(FbandroidProductionConfig.m9456a(injectorLike), C0055x2995691a.m1881a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), TorProxyMethodAutoProvider.m3888b(injectorLike));
    }

    @Inject
    public UDPPrimingHelper(ServerConfig serverConfig, ExecutorService executorService, QeAccessor qeAccessor, TorProxy torProxy) {
        boolean z;
        this.f5545b = serverConfig.mo1357d();
        this.f5546c = executorService;
        this.f5547d = qeAccessor;
        String str = BuildConstants.m;
        if (str == null || !str.toLowerCase(Locale.US).contains("x86")) {
            z = false;
        } else {
            z = true;
        }
        this.f5544a = z;
        this.f5548e = torProxy;
    }

    public static boolean m9446a(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("udp_prime_succeeded");
        if (firstHeader != null) {
            return firstHeader.getValue().equals("1");
        }
        return false;
    }

    public static void m9445a(HttpUriRequest httpUriRequest) {
        httpUriRequest.addHeader("X-FB-Priming-Channel-ID", EncryptChannelInformation.a.c);
    }

    public final boolean m9453a() {
        return m9448e() || m9449f();
    }

    private boolean m9448e() {
        return !this.f5548e.mo562a() && this.f5547d.mo596a(ExperimentsForHttpQeModule.bj, false);
    }

    private boolean m9449f() {
        return !this.f5548e.mo562a() && this.f5547d.mo596a(ExperimentsForHttpQeModule.bk, false);
    }

    public static void m9450g(UDPPrimingHelper uDPPrimingHelper) {
        ColdStartPrimingInformation coldStartPrimingInformation = ColdStartPrimingInformation.a;
        Boolean valueOf = Boolean.valueOf(uDPPrimingHelper.m9448e());
        if (coldStartPrimingInformation.l != valueOf.booleanValue()) {
            coldStartPrimingInformation.l = valueOf.booleanValue();
            if (coldStartPrimingInformation.c != null) {
                Editor edit = coldStartPrimingInformation.c.edit();
                edit.putBoolean("COLD_START_PRIME_INFO/COLD_START_ADVANCE_PRIME_ENABLED", coldStartPrimingInformation.l);
                edit.commit();
            }
        }
        valueOf = Boolean.valueOf(uDPPrimingHelper.m9449f());
        if (coldStartPrimingInformation.m != valueOf.booleanValue()) {
            coldStartPrimingInformation.m = valueOf.booleanValue();
            if (coldStartPrimingInformation.c != null) {
                edit = coldStartPrimingInformation.c.edit();
                edit.putBoolean("COLD_START_PRIME_INFO/COLD_START_ADVANCE_PRIME_FROM_NODEX_ENABLED", coldStartPrimingInformation.m);
                edit.commit();
            }
        }
    }

    public final void m9452a(ParamsCollectionMap paramsCollectionMap) {
        paramsCollectionMap.m5421a("primed", "true");
        paramsCollectionMap.m5421a("user-agent", this.f5545b);
    }

    public final void m9451a(Uri uri) {
        String host = uri.getHost();
        if (host != null) {
            Object obj;
            UDPPrimingDNSInfo uDPPrimingDNSInfo = UDPPrimingDNSInfo.a;
            if (!uDPPrimingDNSInfo.c.equals(host) || UDPPrimingDNSInfo.a(uDPPrimingDNSInfo.e, 7200000)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                ExecutorDetour.a(this.f5546c, new 1(this, host), -1978014186);
            }
        }
    }

    public final boolean m9454c() {
        boolean z;
        ColdStartPrimingInformation coldStartPrimingInformation = ColdStartPrimingInformation.a;
        Object obj = (coldStartPrimingInformation.l == m9448e() && coldStartPrimingInformation.m == m9449f()) ? null : 1;
        Object obj2 = obj;
        if (m9453a()) {
            Object obj3;
            obj = 1;
            if (!coldStartPrimingInformation.n || coldStartPrimingInformation.d == null || coldStartPrimingInformation.i == null || coldStartPrimingInformation.j == null) {
                obj3 = null;
            } else {
                obj3 = 1;
            }
            if (obj3 != null) {
                obj = null;
            }
            if (obj != null) {
                z = true;
                if (obj2 == null || r2) {
                    return true;
                }
                return false;
            }
        }
        z = false;
        if (obj2 == null) {
        }
        return true;
    }

    public final String m9455d() {
        return this.f5545b;
    }

    public static void m9444a(String str) {
        if (str != null && str.endsWith(".facebook.com")) {
            try {
                InetAddress inetAddress = InetAddress.getAllByName(str)[0];
                if (inetAddress == null) {
                    throw new UnknownHostException();
                }
                UDPPrimingDNSInfo.a().a(str, inetAddress.getAddress());
            } catch (Throwable e) {
                BLog.b("UDPPrimingHelper", "Probably bad host name", e);
            } catch (Throwable e2) {
                BLog.b("UDPPrimingHelper", "Permission error", e2);
            }
        }
    }
}
