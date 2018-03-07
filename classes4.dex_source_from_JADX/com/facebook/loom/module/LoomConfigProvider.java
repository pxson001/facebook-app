package com.facebook.loom.module;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.config.ColdStartTraceControlConfiguration;
import com.facebook.loom.config.Config;
import com.facebook.loom.config.Config.RootControllerConfig;
import com.facebook.loom.config.ConfigProvider;
import com.facebook.loom.config.ConfigProvider.ConfigUpdateListener;
import com.facebook.loom.config.DefaultConfigProvider;
import com.facebook.loom.config.LoomConfiguration;
import com.facebook.loom.config.QPLControllerConfig;
import com.facebook.loom.config.QPLTraceControlConfiguration;
import com.facebook.loom.config.coldstart.InitFileConfigProvider;
import com.facebook.loom.config.coldstart.InitFileConfigProvider.InitFileConfigData;
import com.facebook.loom.core.TraceOrchestrator;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.xconfig.core.XConfigSyncListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: get_app_permissions_method */
public class LoomConfigProvider implements ConfigProvider, XConfigSyncListener {
    public static final int[] f11083a = new int[]{2293779};
    private static volatile LoomConfigProvider f11084h;
    private final XConfigReader f11085b;
    private final ObjectMapper f11086c;
    private final Lazy<FbErrorReporter> f11087d;
    private final Context f11088e;
    @GuardedBy("this")
    private Config f11089f = m11508c();
    @GuardedBy("this")
    @Nullable
    private ConfigUpdateListener f11090g;

    public static com.facebook.loom.module.LoomConfigProvider m11505a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11084h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.loom.module.LoomConfigProvider.class;
        monitor-enter(r1);
        r0 = f11084h;	 Catch:{ all -> 0x003a }
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
        r0 = m11507b(r0);	 Catch:{ all -> 0x0035 }
        f11084h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11084h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.loom.module.LoomConfigProvider.a(com.facebook.inject.InjectorLike):com.facebook.loom.module.LoomConfigProvider");
    }

    private static LoomConfigProvider m11507b(InjectorLike injectorLike) {
        return new LoomConfigProvider((Context) injectorLike.getInstance(Context.class), XConfigReader.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    LoomConfigProvider(Context context, XConfigReader xConfigReader, FbObjectMapper fbObjectMapper, Lazy<FbErrorReporter> lazy) {
        this.f11088e = context;
        this.f11085b = xConfigReader;
        this.f11086c = fbObjectMapper;
        this.f11087d = lazy;
    }

    public final synchronized void m11512a(@Nullable ConfigUpdateListener configUpdateListener) {
        this.f11090g = configUpdateListener;
    }

    public final synchronized Config m11514b() {
        return this.f11089f;
    }

    @GuardedBy("this")
    private Config m11508c() {
        LoomConfiguration e = m11510e();
        m11509d();
        if (e == null) {
            Object obj;
            if (TraceOrchestrator.c.get() != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return TraceOrchestrator.b().e;
            }
            return DefaultConfigProvider.a;
        } else if (e.m11516a() == null) {
            return DefaultConfigProvider.a;
        } else {
            m11506a(e);
            return e;
        }
    }

    private void m11506a(LoomConfiguration loomConfiguration) {
        RootControllerConfig a = loomConfiguration.m11516a();
        if (a != null) {
            ArrayList arrayList = new ArrayList();
            ColdStartTraceControlConfiguration coldStartTraceControlConfiguration = (ColdStartTraceControlConfiguration) a.a(8);
            if (coldStartTraceControlConfiguration != null) {
                arrayList.add(new InitFileConfigData(8, coldStartTraceControlConfiguration.m11537e(), coldStartTraceControlConfiguration.m11538f(), coldStartTraceControlConfiguration.m11536d(), coldStartTraceControlConfiguration.m11534b(), coldStartTraceControlConfiguration.m11535c()));
            }
            QPLControllerConfig qPLControllerConfig = (QPLControllerConfig) a.a(1);
            if (qPLControllerConfig != null) {
                for (int i : f11083a) {
                    QPLTraceControlConfiguration a2 = qPLControllerConfig.a(i);
                    if (a2 != null) {
                        arrayList.add(new InitFileConfigData(1, a.b(), a.c(), a2.b(), a2.c(), i));
                    }
                }
            }
            try {
                InitFileConfigProvider.a(this.f11088e, loomConfiguration.m11519d(), arrayList);
            } catch (Throwable e) {
                ((AbstractFbErrorReporter) this.f11087d.get()).a("LoomConfigProvider", "Could not write init file based config", e);
            }
        }
    }

    private void m11509d() {
        try {
            InitFileConfigProvider.a(this.f11088e);
        } catch (Throwable e) {
            ((AbstractFbErrorReporter) this.f11087d.get()).a("LoomConfigProvider", "Could not remove init file based config", e);
        }
    }

    @Nullable
    private LoomConfiguration m11510e() {
        String a = this.f11085b.a(LoomXConfig.f11092d, null);
        if (a != null) {
            try {
                return (LoomConfiguration) this.f11086c.a(a, LoomConfiguration.class);
            } catch (Throwable th) {
                ((AbstractFbErrorReporter) this.f11087d.get()).a("LoomConfigProvider", "Failure in parsing json from XConfig.", th);
            }
        }
        return null;
    }

    public final synchronized void mo138a(XConfigName xConfigName) {
        this.f11089f = m11508c();
        if (this.f11090g != null) {
            this.f11090g.a(this.f11089f);
        }
    }

    public final XConfigName mo137a() {
        return LoomXConfig.f11091c;
    }
}
