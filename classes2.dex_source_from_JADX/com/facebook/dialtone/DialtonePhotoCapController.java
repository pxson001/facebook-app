package com.facebook.dialtone;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.dialtone.protocol.DialtoneGraphQLModels.DialtonePhotoUnblockMutationModel.DialtonePhotoQuotaModel;
import com.facebook.dialtone.protocol.DialtoneGraphQLModels.DialtonePhotoUnblockMutationModel.DialtonePhotoQuotaModel.FreePhotosModel;
import com.facebook.dialtone.protocol.DialtoneGraphQLModels.FetchDialtonePhotoQuotaModel;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ui.toaster.Toaster;
import com.facebook.zero.common.constants.DialtonePrefKeys;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: log_tag */
public class DialtonePhotoCapController {
    private static final String f16248a = DialtonePhotoCapController.class.getSimpleName();
    private static volatile DialtonePhotoCapController f16249j;
    public final Context f16250b;
    private final Provider<Boolean> f16251c;
    public final Toaster f16252d;
    private final AbstractFbErrorReporter f16253e;
    private FbSharedPreferences f16254f;
    public int f16255g = 0;
    public long f16256h = 0;
    private Map<String, Long> f16257i = null;

    public static com.facebook.dialtone.DialtonePhotoCapController m23074a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16249j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.dialtone.DialtonePhotoCapController.class;
        monitor-enter(r1);
        r0 = f16249j;	 Catch:{ all -> 0x003a }
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
        r0 = m23076b(r0);	 Catch:{ all -> 0x0035 }
        f16249j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16249j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.dialtone.DialtonePhotoCapController.a(com.facebook.inject.InjectorLike):com.facebook.dialtone.DialtonePhotoCapController");
    }

    private static DialtonePhotoCapController m23076b(InjectorLike injectorLike) {
        return new DialtonePhotoCapController((Context) injectorLike.getInstance(Context.class), IdBasedProvider.m1811a(injectorLike, 3958), Toaster.m6454b(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public DialtonePhotoCapController(Context context, Provider<Boolean> provider, Toaster toaster, FbSharedPreferences fbSharedPreferences, FbErrorReporter fbErrorReporter) {
        this.f16250b = context;
        this.f16251c = provider;
        this.f16252d = toaster;
        this.f16254f = fbSharedPreferences;
        this.f16253e = fbErrorReporter;
    }

    private synchronized void m23075a(int i, long j, Map<String, Long> map) {
        this.f16255g = i;
        this.f16256h = j;
        this.f16254f.edit().mo1275a(DialtonePrefKeys.f2501x, this.f16256h).commit();
        if (this.f16257i == null) {
            this.f16257i = new HashMap();
        } else {
            this.f16257i.clear();
        }
        this.f16257i.putAll(map);
        try {
            String a = new ObjectMapper().m6659a((Object) map);
            if (a != null) {
                this.f16254f.edit().mo1276a(DialtonePrefKeys.f2500w, a).commit();
            }
        } catch (Throwable e) {
            this.f16253e.m2343a(f16248a, "Error while serializing freePhotos", e);
        }
    }

    public final void m23077a(DialtonePhotoQuotaModel dialtonePhotoQuotaModel) {
        if (dialtonePhotoQuotaModel != null) {
            Map hashMap = new HashMap();
            UnmodifiableListIterator listIterator = dialtonePhotoQuotaModel.j().listIterator();
            while (listIterator.hasNext()) {
                FreePhotosModel freePhotosModel = (FreePhotosModel) listIterator.next();
                hashMap.put(freePhotosModel.j(), Long.valueOf(freePhotosModel.a()));
            }
            m23075a(dialtonePhotoQuotaModel.k(), dialtonePhotoQuotaModel.a(), hashMap);
        }
    }

    public final void m23078a(FetchDialtonePhotoQuotaModel.DialtonePhotoQuotaModel dialtonePhotoQuotaModel) {
        if (dialtonePhotoQuotaModel != null) {
            Map hashMap = new HashMap();
            UnmodifiableListIterator listIterator = dialtonePhotoQuotaModel.j().listIterator();
            while (listIterator.hasNext()) {
                FetchDialtonePhotoQuotaModel.DialtonePhotoQuotaModel.FreePhotosModel freePhotosModel = (FetchDialtonePhotoQuotaModel.DialtonePhotoQuotaModel.FreePhotosModel) listIterator.next();
                hashMap.put(freePhotosModel.j(), Long.valueOf(freePhotosModel.a()));
            }
            m23075a(dialtonePhotoQuotaModel.k(), dialtonePhotoQuotaModel.a(), hashMap);
        }
    }

    public final boolean m23079a(Uri uri) {
        if (!((Boolean) this.f16251c.get()).booleanValue()) {
            return false;
        }
        String a;
        if (this.f16257i == null) {
            a = this.f16254f.mo278a(DialtonePrefKeys.f2500w, null);
            if (a != null) {
                try {
                    HashMap hashMap = (HashMap) new ObjectMapper().m6655a(a, new 1(this));
                    if (hashMap != null) {
                        this.f16257i = new HashMap(hashMap);
                    }
                } catch (Throwable e) {
                    this.f16253e.m2343a(f16248a, "Error while de-serializing freePhotos", e);
                }
            }
        }
        if (this.f16257i != null) {
            for (String a2 : this.f16257i.keySet()) {
                if (!uri.toString().equals(a2)) {
                    if (uri.toString().matches(a2)) {
                    }
                }
                return true;
            }
        }
        return false;
    }
}
