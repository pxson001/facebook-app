package com.facebook.resources.impl.loading;

import android.content.Context;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.impl.FbResourcesLogger;
import com.facebook.resources.impl.loading.GetLanguagePackInfoMethod.NoLanguagePackInfoException;
import com.facebook.resources.impl.loading.GetLanguagePackInfoMethod.Params;
import com.facebook.resources.impl.loading.LanguageRequest.Type;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.common.base.Throwables;
import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: PREF_SKIP */
public class LanguagePrefetcher {
    public static final Class<?> f12529a = LanguagePrefetcher.class;
    private static volatile LanguagePrefetcher f12530l;
    private final LanguageRequest f12531b;
    private final AbstractSingleMethodRunner f12532c;
    private final GetLanguagePackInfoMethod f12533d;
    public final FbResourcesLogger f12534e;
    public final LanguageFileResolver f12535f;
    public final Context f12536g;
    public final JsonFactory f12537h;
    public final DownloadedLanguagePackProcessor f12538i;
    private final SimpleDownloadManager f12539j;
    public final LanguageFilesCleaner f12540k;

    /* compiled from: PREF_SKIP */
    public class C14801 {
        final /* synthetic */ LanguagePrefetcher f12528a;

        C14801(LanguagePrefetcher languagePrefetcher) {
            this.f12528a = languagePrefetcher;
        }

        public final void m12932a(InputStream inputStream, String str) {
            try {
                LanguagePackInfo languagePackInfo = (LanguagePackInfo) this.f12528a.f12537h.b(str).a(LanguagePackInfo.class);
                if (!LanguagePrefetcher.m12935a(this.f12528a, languagePackInfo)) {
                    File a = this.f12528a.f12535f.a(this.f12528a.f12536g, languagePackInfo.locale, (long) languagePackInfo.versionCode);
                    this.f12528a.f12538i.m12915a(inputStream, languagePackInfo.checksum, a);
                    new StringBuilder("Fetched language file successfully and saved as: ").append(a.getAbsolutePath());
                    this.f12528a.f12534e.e(languagePackInfo.locale, languagePackInfo.versionCode);
                    this.f12528a.f12540k.a();
                }
            } catch (Throwable e) {
                BLog.b(LanguagePrefetcher.f12529a, "Failure while trying to save pre-fetched file:", e);
                this.f12528a.f12534e.a(str);
            }
        }

        public final void m12933a(Throwable th) {
            BLog.b(LanguagePrefetcher.f12529a, "Prefetch download failed", th);
        }
    }

    public static com.facebook.resources.impl.loading.LanguagePrefetcher m12934a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12530l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.resources.impl.loading.LanguagePrefetcher.class;
        monitor-enter(r1);
        r0 = f12530l;	 Catch:{ all -> 0x003a }
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
        r0 = m12936b(r0);	 Catch:{ all -> 0x0035 }
        f12530l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12530l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.resources.impl.loading.LanguagePrefetcher.a(com.facebook.inject.InjectorLike):com.facebook.resources.impl.loading.LanguagePrefetcher");
    }

    private static LanguagePrefetcher m12936b(InjectorLike injectorLike) {
        return new LanguagePrefetcher((Context) injectorLike.getInstance(Context.class), AppVersionInfoMethodAutoProvider.a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), GetLanguagePackInfoMethod.m12920b(injectorLike), FbResourcesLogger.a(injectorLike), LanguageFileResolver.a(injectorLike), JsonFactoryMethodAutoProvider.a(injectorLike), DownloadedLanguagePackProcessor.m12913a(injectorLike), SimpleDownloadManager.a(injectorLike), LanguageFilesCleaner.b(injectorLike), Locales.a(injectorLike));
    }

    @Inject
    public LanguagePrefetcher(Context context, AppVersionInfo appVersionInfo, AbstractSingleMethodRunner abstractSingleMethodRunner, GetLanguagePackInfoMethod getLanguagePackInfoMethod, FbResourcesLogger fbResourcesLogger, LanguageFileResolver languageFileResolver, JsonFactory jsonFactory, DownloadedLanguagePackProcessor downloadedLanguagePackProcessor, SimpleDownloadManager simpleDownloadManager, LanguageFilesCleaner languageFilesCleaner, Locales locales) {
        this.f12536g = context;
        this.f12532c = abstractSingleMethodRunner;
        this.f12533d = getLanguagePackInfoMethod;
        this.f12534e = fbResourcesLogger;
        this.f12535f = languageFileResolver;
        this.f12537h = jsonFactory;
        this.f12538i = downloadedLanguagePackProcessor;
        this.f12539j = simpleDownloadManager;
        this.f12540k = languageFilesCleaner;
        this.f12531b = new LanguageRequest(Type.PREFETCH, context, locales.a(), appVersionInfo);
    }

    public final void m12940a() {
        LanguagePackInfo c = m12938c();
        if (c != null && !m12935a(this, c)) {
            m12937b(c);
        }
    }

    public static boolean m12935a(LanguagePrefetcher languagePrefetcher, LanguagePackInfo languagePackInfo) {
        return languagePrefetcher.f12535f.a(languagePrefetcher.f12536g, languagePackInfo.locale, (long) languagePackInfo.versionCode).exists();
    }

    private void m12937b(LanguagePackInfo languagePackInfo) {
        this.f12539j.a("strings-file", languagePackInfo.downloadUrl, new C14801(this), m12939c(languagePackInfo));
        FbResourcesLogger fbResourcesLogger = this.f12534e;
        ((AnalyticsLogger) fbResourcesLogger.b.get()).a(FbResourcesLogger.a(languagePackInfo.locale, languagePackInfo.versionCode, "fbresources_start_prefetch_download"));
    }

    private String m12939c(LanguagePackInfo languagePackInfo) {
        Writer stringWriter = new StringWriter();
        try {
            this.f12537h.a(stringWriter).a(languagePackInfo);
            return stringWriter.toString();
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        }
    }

    @Nullable
    private LanguagePackInfo m12938c() {
        try {
            LanguagePackInfo languagePackInfo = (LanguagePackInfo) this.f12532c.a(this.f12533d, new Params(this.f12531b), CallerContext.a(getClass()));
            this.f12534e.c(languagePackInfo.locale, languagePackInfo.versionCode);
            return languagePackInfo;
        } catch (NoLanguagePackInfoException e) {
            this.f12534e.a(this.f12531b.d(), this.f12531b.c());
            return null;
        } catch (Throwable e2) {
            this.f12534e.b(this.f12531b.d(), this.f12531b.c());
            BLog.b(f12529a, "Exception while executing prefetch query", e2);
            return null;
        }
    }
}
