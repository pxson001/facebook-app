package com.facebook.search.api.protocol;

import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationCache;
import com.facebook.location.ImmutableLocation;
import com.facebook.search.api.SearchTypeaheadResult.Type;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Strings;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

@Singleton
/* compiled from: extra_last_auto_retry_attempt_time */
public class SearchTypeaheadApiMethodUtil {
    private static volatile SearchTypeaheadApiMethodUtil f15566b;
    private final FbLocationCache f15567a;

    public static com.facebook.search.api.protocol.SearchTypeaheadApiMethodUtil m23179a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15566b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.api.protocol.SearchTypeaheadApiMethodUtil.class;
        monitor-enter(r1);
        r0 = f15566b;	 Catch:{ all -> 0x003a }
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
        r0 = m23180b(r0);	 Catch:{ all -> 0x0035 }
        f15566b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15566b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.api.protocol.SearchTypeaheadApiMethodUtil.a(com.facebook.inject.InjectorLike):com.facebook.search.api.protocol.SearchTypeaheadApiMethodUtil");
    }

    private static SearchTypeaheadApiMethodUtil m23180b(InjectorLike injectorLike) {
        return new SearchTypeaheadApiMethodUtil(FbLocationCache.b(injectorLike));
    }

    @Inject
    public SearchTypeaheadApiMethodUtil(FbLocationCache fbLocationCache) {
        this.f15567a = fbLocationCache;
    }

    public final void m23181a(FetchSearchTypeaheadResultParams fetchSearchTypeaheadResultParams, List<NameValuePair> list) {
        if (!Strings.isNullOrEmpty(fetchSearchTypeaheadResultParams.f15554b)) {
            list.add(new BasicNameValuePair("uuid", fetchSearchTypeaheadResultParams.f15554b));
        }
        String str = "filter";
        List list2 = fetchSearchTypeaheadResultParams.f15556d;
        StringBuilder stringBuilder = new StringBuilder("[");
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            stringBuilder.append("'").append(((Type) it.next()).name().toLowerCase(Locale.US)).append("'");
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        list.add(new BasicNameValuePair(str, stringBuilder.append("]").toString()));
        list.add(new BasicNameValuePair("photo_size", Integer.toString(fetchSearchTypeaheadResultParams.f15555c)));
        list.add(new BasicNameValuePair("context", "mobile_search_android"));
        if (fetchSearchTypeaheadResultParams.f15557e > 0) {
            list.add(new BasicNameValuePair("limit", Integer.toString(fetchSearchTypeaheadResultParams.f15557e)));
        }
        list.add(new BasicNameValuePair("include_native_android_url", "true"));
        list.add(new BasicNameValuePair("format", "json"));
        String str2 = "";
        ImmutableLocation a = this.f15567a.a();
        if (a != null) {
            ObjectNode c = JsonNodeFactory.a.c();
            c.a("latitude", a.a());
            c.a("longitude", a.b());
            c.a("accuracy", (Float) a.c().get());
            c.a("timestamp", (int) (((float) ((Long) a.g().get()).longValue()) / 1000.0f));
            str2 = c.toString();
        }
        list.add(new BasicNameValuePair("viewer_coordinates", str2));
    }
}
