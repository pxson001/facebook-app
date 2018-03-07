package com.facebook.common.uri;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.file.FileUtils.CreateDirectoryException;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.common.util.PlatformTempFileManager;
import java.io.File;
import java.io.InputStream;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: age */
public class FbUriResolver {
    private static volatile FbUriResolver f11140e;
    private ContentResolver f11141a;
    private Context f11142b;
    private MoreFileUtils f11143c;
    private AbstractFbErrorReporter f11144d;

    public static com.facebook.common.uri.FbUriResolver m19124a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11140e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.uri.FbUriResolver.class;
        monitor-enter(r1);
        r0 = f11140e;	 Catch:{ all -> 0x003a }
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
        r0 = m19126b(r0);	 Catch:{ all -> 0x0035 }
        f11140e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11140e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.uri.FbUriResolver.a(com.facebook.inject.InjectorLike):com.facebook.common.uri.FbUriResolver");
    }

    private static FbUriResolver m19126b(InjectorLike injectorLike) {
        return new FbUriResolver(ContentResolverMethodAutoProvider.b(injectorLike), (Context) injectorLike.getInstance(Context.class), MoreFileUtils.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public FbUriResolver(ContentResolver contentResolver, Context context, MoreFileUtils moreFileUtils, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f11141a = contentResolver;
        this.f11142b = context;
        this.f11143c = moreFileUtils;
        this.f11144d = abstractFbErrorReporter;
    }

    public static boolean m19125a(Uri uri) {
        return (uri == null || !"content".equals(uri.getScheme()) || uri.getAuthority() == null || uri.getAuthority().startsWith("media")) ? false : true;
    }

    public final Uri m19127a(Uri uri, String str) {
        if ("content".equals(uri.getScheme()) && m19125a(uri)) {
            String str2 = SafeUUIDGenerator.a().toString() + "." + MimeTypeMap.getSingleton().getExtensionFromMimeType(this.f11141a.getType(uri));
            try {
                PlatformTempFileManager platformTempFileManager = new PlatformTempFileManager(this.f11142b, this.f11143c);
                InputStream openInputStream = this.f11141a.openInputStream(uri);
                File a = platformTempFileManager.a(SafeUUIDGenerator.a().toString(), str2);
                this.f11143c.a(openInputStream, a);
                uri = Uri.fromFile(a);
            } catch (CreateDirectoryException e) {
                this.f11144d.b(str, StringFormatUtil.formatStrLocaleSafe("%s %s", "Could not open a temp image file:", str2), e);
            } catch (Throwable e2) {
                this.f11144d.b(str, StringFormatUtil.formatStrLocaleSafe("%s %s", "Could not write a temp image file:", str2), e2);
            }
        }
        return uri;
    }
}
