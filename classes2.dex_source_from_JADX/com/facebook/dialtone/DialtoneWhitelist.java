package com.facebook.dialtone;

import android.net.Uri;
import android.util.Base64;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.dialtone.DialtoneWhitelistRegexes.WhitelistSetType;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sms_body */
public class DialtoneWhitelist {
    public static String f4584a = DialtoneWhitelist.class.getName();
    private static volatile DialtoneWhitelist f4585d;
    public DialtoneWhitelistRegexes f4586b;
    private ObjectMapper f4587c;

    public static com.facebook.dialtone.DialtoneWhitelist m8345a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4585d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.dialtone.DialtoneWhitelist.class;
        monitor-enter(r1);
        r0 = f4585d;	 Catch:{ all -> 0x003a }
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
        r0 = m8347b(r0);	 Catch:{ all -> 0x0035 }
        f4585d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4585d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.dialtone.DialtoneWhitelist.a(com.facebook.inject.InjectorLike):com.facebook.dialtone.DialtoneWhitelist");
    }

    private static DialtoneWhitelist m8347b(InjectorLike injectorLike) {
        return new DialtoneWhitelist(DialtoneWhitelistRegexes.m8350a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    @Inject
    public DialtoneWhitelist(DialtoneWhitelistRegexes dialtoneWhitelistRegexes, ObjectMapper objectMapper) {
        this.f4586b = dialtoneWhitelistRegexes;
        this.f4587c = objectMapper;
    }

    public static boolean m8346a(String str, Set<Pattern> set) {
        if (str == null) {
            return false;
        }
        for (Pattern matcher : set) {
            if (matcher.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    public final boolean m8349a(Uri uri) {
        return uri != null && (m8346a(uri.toString(), this.f4586b.m8356a(WhitelistSetType.URI)) || m8348b(uri));
    }

    private boolean m8348b(Uri uri) {
        String queryParameter = uri.getQueryParameter("efg");
        if (queryParameter == null) {
            return false;
        }
        try {
            return ((Map) this.f4587c.m6657a(new String(Base64.decode(queryParameter, 0), "UTF-8"), Map.class)).containsKey("dtw");
        } catch (UnsupportedEncodingException e) {
            return false;
        } catch (JsonMappingException e2) {
            return false;
        } catch (JsonParseException e3) {
            return false;
        } catch (IOException e4) {
            return false;
        }
    }
}
