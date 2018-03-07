package com.facebook.resources.impl.loading;

import android.content.Context;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.inject.InjectorLike;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: thread_participants */
public class LanguageFileResolver {
    public static final Pattern f3035a = Pattern.compile("([a-z]+(?:_[A-Z]+)?)-([0-9]+)\\.fbstr");
    private static volatile LanguageFileResolver f3036c;
    private final MoreFileUtils f3037b;

    public static com.facebook.resources.impl.loading.LanguageFileResolver m5018a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3036c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.resources.impl.loading.LanguageFileResolver.class;
        monitor-enter(r1);
        r0 = f3036c;	 Catch:{ all -> 0x003a }
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
        r0 = m5019b(r0);	 Catch:{ all -> 0x0035 }
        f3036c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3036c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.resources.impl.loading.LanguageFileResolver.a(com.facebook.inject.InjectorLike):com.facebook.resources.impl.loading.LanguageFileResolver");
    }

    private static LanguageFileResolver m5019b(InjectorLike injectorLike) {
        return new LanguageFileResolver(MoreFileUtils.m5023a(injectorLike));
    }

    @Inject
    public LanguageFileResolver(MoreFileUtils moreFileUtils) {
        this.f3037b = moreFileUtils;
    }

    public final File m5021a(Context context, String str, long j) {
        return MoreFileUtils.m5025a(m5020a(context), str + "-" + j + ".fbstr");
    }

    public final File m5022a(LanguageRequest languageRequest) {
        return m5021a(languageRequest.f3009a, languageRequest.m4962d(), (long) languageRequest.m4961c());
    }

    public static int m5017a(String str) {
        Matcher matcher = f3035a.matcher(str);
        if (matcher.matches()) {
            return Integer.parseInt(matcher.group(2));
        }
        return 0;
    }

    public final File m5020a(Context context) {
        File a = MoreFileUtils.m5025a(context.getFilesDir(), "strings");
        if (a.exists() || a.mkdir()) {
            return a;
        }
        throw new RuntimeException("Error creating directory for strings file");
    }
}
