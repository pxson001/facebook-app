package com.facebook.analytics.tagging;

import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: tag */
public class CurrentModuleHolder {
    private static volatile CurrentModuleHolder f3333d;
    private final Object f3334a = new Object();
    @GuardedBy("lock")
    private Stack<ModuleInfo> f3335b = new Stack();
    public final Lazy<Set<NavigationEventListener>> f3336c;

    /* compiled from: tag */
    public class NotifyModuleChangedCallback {
        public final String f8473a;
        public final String f8474b;
        public final Map<String, ?> f8475c;
        final /* synthetic */ CurrentModuleHolder f8476d;

        public NotifyModuleChangedCallback(CurrentModuleHolder currentModuleHolder, String str, String str2, @Nullable Map<String, ?> map) {
            this.f8476d = currentModuleHolder;
            this.f8473a = str;
            this.f8474b = str2;
            this.f8475c = map;
        }

        public final void m13033a() {
            CurrentModuleHolder currentModuleHolder = this.f8476d;
            String str = this.f8473a;
            String str2 = this.f8474b;
            Map map = this.f8475c;
            for (NavigationEventListener a : (Set) currentModuleHolder.f3336c.get()) {
                a.mo1751a(str, str2, map);
            }
        }
    }

    public static com.facebook.analytics.tagging.CurrentModuleHolder m5545a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3333d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.tagging.CurrentModuleHolder.class;
        monitor-enter(r1);
        r0 = f3333d;	 Catch:{ all -> 0x003a }
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
        r0 = m5546b(r0);	 Catch:{ all -> 0x0035 }
        f3333d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3333d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.tagging.CurrentModuleHolder.a(com.facebook.inject.InjectorLike):com.facebook.analytics.tagging.CurrentModuleHolder");
    }

    private static CurrentModuleHolder m5546b(InjectorLike injectorLike) {
        return new CurrentModuleHolder(ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$NavigationEventListener(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()));
    }

    @Inject
    public CurrentModuleHolder(Lazy<Set<NavigationEventListener>> lazy) {
        this.f3336c = lazy;
    }

    public final Stack<ModuleInfo> m5550a() {
        Stack<ModuleInfo> stack;
        synchronized (this.f3334a) {
            stack = (Stack) this.f3335b.clone();
        }
        return stack;
    }

    public final void m5551a(Stack<ModuleInfo> stack) {
        synchronized (this.f3334a) {
            this.f3335b = stack;
        }
    }

    public final String m5554b() {
        return m5549a("unknown");
    }

    public final String m5549a(String str) {
        ModuleInfo c = m5555c();
        if (c == null) {
            return str;
        }
        String str2 = c.f8470a;
        if (str2 != null) {
            return str2;
        }
        return str;
    }

    public final ModuleInfo m5555c() {
        ModuleInfo moduleInfo;
        synchronized (this.f3334a) {
            if (this.f3335b.isEmpty()) {
                moduleInfo = null;
            } else {
                moduleInfo = (ModuleInfo) this.f3335b.peek();
            }
        }
        return moduleInfo;
    }

    public final NotifyModuleChangedCallback m5548a(String str, Map<String, ?> map) {
        String str2;
        synchronized (this.f3334a) {
            if (this.f3335b.isEmpty()) {
                str2 = null;
            } else {
                str2 = ((ModuleInfo) this.f3335b.peek()).m13031a();
            }
            this.f3335b.push(new ModuleInfo(str, map != null ? (String) map.get("dest_module_class") : null, map));
        }
        return new NotifyModuleChangedCallback(this, str2, str, map);
    }

    public final NotifyModuleChangedCallback m5553b(String str, @Nullable Map<String, ?> map) {
        String str2 = null;
        synchronized (this.f3334a) {
            if (!(this.f3335b.empty() || str == null || ((ModuleInfo) this.f3335b.peek()).m13031a() == null || !((ModuleInfo) this.f3335b.peek()).m13031a().equals(str))) {
                this.f3335b.pop();
            }
            if (!this.f3335b.isEmpty()) {
                str2 = ((ModuleInfo) this.f3335b.peek()).m13031a();
            }
        }
        return new NotifyModuleChangedCallback(this, str, str2, map);
    }

    public final NotifyModuleChangedCallback m5547a(String str, String str2, Map<String, ?> map) {
        synchronized (this.f3334a) {
            this.f3335b.clear();
            this.f3335b.push(new ModuleInfo(str2, (String) map.get("dest_module_class"), map));
        }
        return new NotifyModuleChangedCallback(this, str, str2, map);
    }

    public final void m5556d() {
        synchronized (this.f3334a) {
            this.f3335b.clear();
        }
    }

    public final NotifyModuleChangedCallback m5552b(String str, String str2, Map<String, ?> map) {
        return new NotifyModuleChangedCallback(this, str, str2, map);
    }
}
