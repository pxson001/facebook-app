package com.facebook.http.common;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: reengagement_fallback */
public class NetworkSystemSettings {
    private static volatile NetworkSystemSettings f7847b;
    private final Context f7848a;

    public static com.facebook.http.common.NetworkSystemSettings m12388a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7847b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.NetworkSystemSettings.class;
        monitor-enter(r1);
        r0 = f7847b;	 Catch:{ all -> 0x003a }
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
        r0 = m12389b(r0);	 Catch:{ all -> 0x0035 }
        f7847b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7847b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.NetworkSystemSettings.a(com.facebook.inject.InjectorLike):com.facebook.http.common.NetworkSystemSettings");
    }

    private static NetworkSystemSettings m12389b(InjectorLike injectorLike) {
        return new NetworkSystemSettings((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public NetworkSystemSettings(Context context) {
        this.f7848a = context;
    }

    public final Optional<Boolean> m12390a() {
        boolean z = true;
        try {
            if (VERSION.SDK_INT < 17) {
                if (System.getInt(this.f7848a.getContentResolver(), "airplane_mode_on") == 0) {
                    z = false;
                }
                return Optional.of(Boolean.valueOf(z));
            }
            if (Global.getInt(this.f7848a.getContentResolver(), "airplane_mode_on") == 0) {
                z = false;
            }
            return Optional.of(Boolean.valueOf(z));
        } catch (SettingNotFoundException e) {
            return Absent.withType();
        }
    }

    public final Optional<Boolean> m12391b() {
        boolean z = true;
        try {
            if (VERSION.SDK_INT < 17) {
                if (Secure.getInt(this.f7848a.getContentResolver(), "mobile_data") == 0) {
                    z = false;
                }
                return Optional.of(Boolean.valueOf(z));
            }
            if (Global.getInt(this.f7848a.getContentResolver(), "mobile_data") == 0) {
                z = false;
            }
            return Optional.of(Boolean.valueOf(z));
        } catch (SettingNotFoundException e) {
            return Absent.withType();
        }
    }
}
