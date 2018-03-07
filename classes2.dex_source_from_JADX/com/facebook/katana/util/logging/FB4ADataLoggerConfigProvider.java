package com.facebook.katana.util.logging;

import android.content.Context;
import com.facebook.common.build.BuildConstants;
import com.facebook.config.server.NetworkLogUrl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.constants.Constants$URL;
import com.facebook.zero.Boolean_IsBootstrapEnabledMethodAutoProvider;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.regex.Pattern;
import javax.inject.Inject;

/* compiled from: likerProfile */
public class FB4ADataLoggerConfigProvider {
    private static volatile FB4ADataLoggerConfigProvider f17513b;
    private Context f17514a;

    public static com.facebook.katana.util.logging.FB4ADataLoggerConfigProvider m24637a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17513b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.util.logging.FB4ADataLoggerConfigProvider.class;
        monitor-enter(r1);
        r0 = f17513b;	 Catch:{ all -> 0x003a }
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
        r0 = m24639b(r0);	 Catch:{ all -> 0x0035 }
        f17513b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17513b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.util.logging.FB4ADataLoggerConfigProvider.a(com.facebook.inject.InjectorLike):com.facebook.katana.util.logging.FB4ADataLoggerConfigProvider");
    }

    private static FB4ADataLoggerConfigProvider m24639b(InjectorLike injectorLike) {
        return new FB4ADataLoggerConfigProvider((Context) injectorLike.getInstance(Context.class, ForAppContext.class));
    }

    @Inject
    public FB4ADataLoggerConfigProvider(@ForAppContext Context context) {
        this.f17514a = context;
    }

    public final void m24640a(Builder<String, String> builder) {
        String a;
        String e = Constants$URL.m24647e(this.f17514a);
        e = e.substring(0, e.length() - 1);
        Builder b = builder.m609b(Constants$URL.m24648n(this.f17514a), "api").m609b(Constants$URL.m24645d(this.f17514a), "api").m609b(Constants$URL.m24644c(this.f17514a), "api").m609b(NetworkLogUrl.m12161a(this.f17514a, "https://api-video.%s/restserver.php"), "api_video");
        Context context = this.f17514a;
        if (Boolean_IsBootstrapEnabledMethodAutoProvider.m9500a(FbInjector.get(context)).booleanValue()) {
            a = NetworkLogUrl.m12161a(context, "https://b-api.%s/restserver.php");
        } else {
            a = Constants$URL.m24644c(context);
        }
        Builder b2 = b.m609b(a, "api").m609b(e, "graph").m609b(NetworkLogUrl.m12161a(this.f17514a, "https://graph-video.%s/"), "video_upload");
        Context context2 = this.f17514a;
        if (BuildConstants.i) {
            a = NetworkLogUrl.m12161a(context2, "https://www.%s/mobile/android_beta_crash_logs/");
        } else {
            a = NetworkLogUrl.m12161a(context2, "https://www.%s/mobile/android_crash_logs/");
        }
        b2.m609b(a, "crash_report").m609b(NetworkLogUrl.m12161a(this.f17514a, "https://www.%s/impression.php"), "log").m609b(NetworkLogUrl.m12161a(this.f17514a, "https://api.%s/method/logging.clientevent"), "log").m609b(NetworkLogUrl.m12161a(this.f17514a, "https://b-api.%s/method/logging.clientevent"), "log").m609b(NetworkLogUrl.m12161a(this.f17514a, "https://m.%s/promotion.php"), "deal").m609b(NetworkLogUrl.m12161a(this.f17514a, "https://www.%s/ai.php"), "ad_log").m609b(NetworkLogUrl.m12161a(this.f17514a, "http://www.%s/images/emoji/unicode/"), "emoji");
    }

    public final void m24641b(Builder<Pattern, String> builder) {
        builder.m609b(m24638a(this.f17514a, "photos"), "photo_upload").m609b(m24638a(this.f17514a, "message_images"), "photo_upload").m609b(Pattern.compile(Pattern.quote(Constants$URL.m24647e(this.f17514a)) + "(me|\\d+)" + Pattern.quote("/videos")), "video_upload");
    }

    private static Pattern m24638a(Context context, String str) {
        return Pattern.compile(Pattern.quote(Constants$URL.m24647e(context)) + "(me|\\d+)" + Pattern.quote("/" + str));
    }
}
