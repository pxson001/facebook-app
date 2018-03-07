package com.facebook.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.inject.InjectorLike;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: send_description */
public class IntentSanitizer {
    private static final String f2845b = IntentSanitizer.class.getSimpleName();
    private static volatile IntentSanitizer f2846c;
    AbstractFbErrorReporter f2847a;

    public static com.facebook.content.IntentSanitizer m3981a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2846c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.content.IntentSanitizer.class;
        monitor-enter(r1);
        r0 = f2846c;	 Catch:{ all -> 0x003a }
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
        r0 = m3983b(r0);	 Catch:{ all -> 0x0035 }
        f2846c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2846c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.content.IntentSanitizer.a(com.facebook.inject.InjectorLike):com.facebook.content.IntentSanitizer");
    }

    private static IntentSanitizer m3983b(InjectorLike injectorLike) {
        return new IntentSanitizer((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public IntentSanitizer(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f2847a = abstractFbErrorReporter;
    }

    public final void m3984a(@Nullable Intent intent) {
        if (intent != null) {
            ClassLoader classLoader = IntentSanitizer.class.getClassLoader();
            if (!m3982a(intent.getComponent())) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    Set<String> keySet = extras.keySet();
                    List<String> arrayList = new ArrayList();
                    for (String str : keySet) {
                        Object obj = extras.get(str);
                        if (obj != null && classLoader.equals(obj.getClass().getClassLoader())) {
                            arrayList.add(str);
                        }
                    }
                    for (String str2 : arrayList) {
                        Object obj2 = extras.get(str2);
                        AbstractFbErrorReporter abstractFbErrorReporter = this.f2847a;
                        SoftErrorBuilder a = SoftError.a(f2845b + ".sanitizeExternalIntent", "IntentSanitizer found an inner class in an external intent: " + str2 + " => " + obj2);
                        a.c = new RuntimeException();
                        abstractFbErrorReporter.a(a.g());
                        intent.removeExtra(str2);
                    }
                }
            }
        }
    }

    private static boolean m3982a(ComponentName componentName) {
        ClassLoader classLoader = IntentSanitizer.class.getClassLoader();
        if (componentName != null) {
            try {
                if (classLoader.equals(Class.forName(componentName.getClassName()).getClassLoader())) {
                    return true;
                }
            } catch (ClassNotFoundException e) {
            }
        }
        return false;
    }
}
