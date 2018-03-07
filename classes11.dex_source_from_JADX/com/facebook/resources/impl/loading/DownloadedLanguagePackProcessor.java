package com.facebook.resources.impl.loading;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.impl.FbResourcesLogger;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.zip.ZipInputStream;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: PRIVACY_CHECKUP_APP_STEP_NEXT */
public class DownloadedLanguagePackProcessor {
    private static volatile DownloadedLanguagePackProcessor f12511c;
    private final MoreFileUtils f12512a;
    private final FbResourcesLogger f12513b;

    public static com.facebook.resources.impl.loading.DownloadedLanguagePackProcessor m12913a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f12511c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.resources.impl.loading.DownloadedLanguagePackProcessor.class;
        monitor-enter(r1);
        r0 = f12511c;	 Catch:{ all -> 0x003a }
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
        r0 = m12914b(r0);	 Catch:{ all -> 0x0035 }
        f12511c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12511c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.resources.impl.loading.DownloadedLanguagePackProcessor.a(com.facebook.inject.InjectorLike):com.facebook.resources.impl.loading.DownloadedLanguagePackProcessor");
    }

    private static DownloadedLanguagePackProcessor m12914b(InjectorLike injectorLike) {
        return new DownloadedLanguagePackProcessor(MoreFileUtils.a(injectorLike), FbResourcesLogger.a(injectorLike));
    }

    @Inject
    public DownloadedLanguagePackProcessor(MoreFileUtils moreFileUtils, FbResourcesLogger fbResourcesLogger) {
        this.f12512a = moreFileUtils;
        this.f12513b = fbResourcesLogger;
    }

    public final void m12915a(InputStream inputStream, String str, File file) {
        byte[] a = ByteStreams.a(inputStream);
        if (SecureHashUtil.b(a).equals(str)) {
            InputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(a));
            zipInputStream.getNextEntry();
            this.f12512a.a(zipInputStream, file);
            return;
        }
        String group;
        FbResourcesLogger fbResourcesLogger = this.f12513b;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fbresources_corrupt_language_pack_download");
        Matcher matcher = LanguageFileResolver.a.matcher(file.getName());
        if (matcher.matches()) {
            group = matcher.group(1);
        } else {
            group = null;
        }
        honeyClientEvent.b("locale", group);
        honeyClientEvent.a("raw_file_size", file.length());
        ((AnalyticsLogger) fbResourcesLogger.b.get()).a(honeyClientEvent);
        throw new RuntimeException("Downloaded file checksum does not match!");
    }
}
