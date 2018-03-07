package com.facebook.notifications.util;

import android.os.Handler;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.abtest.NotificationsJewelExperimentController;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: expected_source */
public class NotificationsRowWithActionHelper {
    private static volatile NotificationsRowWithActionHelper f12623l;
    private final ExecutorService f12624a;
    public final AbstractFbErrorReporter f12625b;
    public final FbSharedPreferences f12626c;
    public final NotificationsJewelExperimentController f12627d;
    public final GraphQLNotificationsContentProviderHelper f12628e;
    public final NotificationsInlineActionsHelper f12629f;
    public final Runnable f12630g = new C05971(this);
    public final Handler f12631h = new Handler();
    public Runnable f12632i;
    public RowWithActionTaken f12633j;
    public final Map<String, RowWithActionTaken> f12634k = new HashMap();

    /* compiled from: expected_source */
    class C05971 implements Runnable {
        final /* synthetic */ NotificationsRowWithActionHelper f12635a;

        C05971(NotificationsRowWithActionHelper notificationsRowWithActionHelper) {
            this.f12635a = notificationsRowWithActionHelper;
        }

        public void run() {
            this.f12635a.m13442a(null);
        }
    }

    public static com.facebook.notifications.util.NotificationsRowWithActionHelper m13438a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12623l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.util.NotificationsRowWithActionHelper.class;
        monitor-enter(r1);
        r0 = f12623l;	 Catch:{ all -> 0x003a }
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
        r0 = m13439b(r0);	 Catch:{ all -> 0x0035 }
        f12623l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12623l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.util.NotificationsRowWithActionHelper.a(com.facebook.inject.InjectorLike):com.facebook.notifications.util.NotificationsRowWithActionHelper");
    }

    private static NotificationsRowWithActionHelper m13439b(InjectorLike injectorLike) {
        return new NotificationsRowWithActionHelper((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GraphQLNotificationsContentProviderHelper.m7861a(injectorLike), NotificationsJewelExperimentController.m8058b(injectorLike), NotificationsInlineActionsHelper.m13381a(injectorLike));
    }

    @Inject
    public NotificationsRowWithActionHelper(ExecutorService executorService, AbstractFbErrorReporter abstractFbErrorReporter, FbSharedPreferences fbSharedPreferences, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, NotificationsJewelExperimentController notificationsJewelExperimentController, NotificationsInlineActionsHelper notificationsInlineActionsHelper) {
        this.f12624a = executorService;
        this.f12625b = abstractFbErrorReporter;
        this.f12626c = fbSharedPreferences;
        this.f12628e = graphQLNotificationsContentProviderHelper;
        this.f12627d = notificationsJewelExperimentController;
        this.f12629f = notificationsInlineActionsHelper;
    }

    public final void m13442a(@Nullable RowWithActionTaken rowWithActionTaken) {
        if (this.f12629f.m13399d()) {
            if (rowWithActionTaken != null || !this.f12634k.isEmpty()) {
                if (this.f12634k.isEmpty() || rowWithActionTaken != null) {
                    this.f12634k.put(rowWithActionTaken.a, rowWithActionTaken);
                } else {
                    m13440b(null);
                    return;
                }
            }
            return;
        } else if (rowWithActionTaken != null || this.f12633j != null) {
            if (this.f12633j != null) {
                m13440b(rowWithActionTaken);
                return;
            }
            this.f12633j = rowWithActionTaken;
        } else {
            return;
        }
        if (this.f12632i != null) {
            this.f12632i.run();
        }
    }

    private void m13440b(RowWithActionTaken rowWithActionTaken) {
        ExecutorDetour.a(this.f12624a, new 2(this, rowWithActionTaken), 1145789202);
    }

    public final boolean m13443b(String str) {
        if (this.f12629f.m13399d()) {
            return this.f12634k.containsKey(str);
        }
        return (this.f12633j == null || this.f12633j.a == null) ? false : this.f12633j.a.equals(str);
    }

    public final RowWithActionTaken m13444c(String str) {
        if (this.f12629f.m13399d()) {
            return (RowWithActionTaken) this.f12634k.get(str);
        }
        return this.f12633j;
    }

    public final 3 m13441a(String str, String str2) {
        return new 3(this, str, str2);
    }
}
