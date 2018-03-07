package com.facebook.katana.urimap;

import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriTemplateMap;
import com.facebook.common.uri.UriTemplateMap.InvalidUriException;
import com.facebook.common.uri.UriTemplateMap.UriMatch;
import com.facebook.common.util.StringUtil;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: timeline_unexpected_section_id_from_server */
public class LegacyFacebookUriRedirector {
    private static volatile LegacyFacebookUriRedirector f1227b;
    private UriTemplateMap<String> f1228a = new UriTemplateMap();

    public static com.facebook.katana.urimap.LegacyFacebookUriRedirector m1256a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f1227b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.katana.urimap.LegacyFacebookUriRedirector.class;
        monitor-enter(r1);
        r0 = f1227b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m1255a();	 Catch:{ all -> 0x0034 }
        f1227b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1227b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.urimap.LegacyFacebookUriRedirector.a(com.facebook.inject.InjectorLike):com.facebook.katana.urimap.LegacyFacebookUriRedirector");
    }

    private static LegacyFacebookUriRedirector m1255a() {
        return new LegacyFacebookUriRedirector();
    }

    @Inject
    public LegacyFacebookUriRedirector() {
        this.f1228a.a("facebook:/events", FBLinks.by);
        this.f1228a.a("facebook:/chat", FBLinks.O);
        this.f1228a.a("facebook:/friends", FBLinks.cP);
        this.f1228a.a("facebook:/inbox", FBLinks.O);
        this.f1228a.a("facebook:/newsfeed", FBLinks.bT);
        this.f1228a.a("facebook:/requests", FBLinks.b + "requests");
        this.f1228a.a("facebook:/wall?user={user}", FBLinks.b + "profile/<user>");
        this.f1228a.a("facebook:/wall", FBLinks.cm);
        this.f1228a.a("facebook:/info?user={user}", FBLinks.b + "profile/<user>");
        this.f1228a.a("facebook:/notifications", FBLinks.ci);
        this.f1228a.a("facebook:/feedback?user={uid}&post={post_id}", FBLinks.b + "post/<post_id>");
        this.f1228a.a("facebook:/photos?user={uid}&album={aid}&photo={pid}", FBLinks.b + "native_album/<aid>");
        this.f1228a.a("facebook:/photos?user={uid}&album={aid}", FBLinks.b + "native_album/<aid>");
        this.f1228a.a("facebook:/photos?user={uid}&photo={pid}", FBLinks.b + "albums/<uid>");
        this.f1228a.a("facebook:/photos?user={uid}", FBLinks.b + "albums/<uid>");
        this.f1228a.a("facebook:/photos", FBLinks.bm);
    }

    public final String m1257a(String str) {
        try {
            UriMatch a = this.f1228a.a(str);
            if (a == null) {
                return null;
            }
            String str2 = (String) a.a;
            String str3 = str2;
            for (String str22 : a.b.keySet()) {
                str3 = str3.replaceAll("<" + str22 + ">", StringUtil.a(a.b, str22));
            }
            return str3;
        } catch (InvalidUriException e) {
            return null;
        }
    }
}
