package com.facebook.search.uri;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: user_mobile_phone */
public class SearchResultUriIntentBuilder extends UriIntentBuilder {
    public static final String[][] f710a;
    private static volatile SearchResultUriIntentBuilder f711b;

    /* compiled from: user_mobile_phone */
    class SearchResultIntentBuilder implements IUriTemplateIntentBuilder {
        private final Provider<ComponentName> f709a;

        public SearchResultIntentBuilder(@FragmentChromeActivity Provider<ComponentName> provider) {
            this.f709a = provider;
        }

        public final Intent m789a(Context context, Bundle bundle) {
            Intent putExtra = new Intent().setComponent((ComponentName) this.f709a.get()).putExtra("target_fragment", ContentFragmentType.SEARCH_FRAGMENT.ordinal());
            if (bundle != null) {
                for (String[] strArr : SearchResultUriIntentBuilder.f710a) {
                    m788a(bundle, strArr[0]);
                }
                bundle.putString("query_title", bundle.getString("title"));
                putExtra.putExtras(bundle);
            }
            return putExtra;
        }

        private static void m788a(Bundle bundle, String str) {
            Object string = bundle.getString(str);
            if (!StringUtil.a(string)) {
                try {
                    bundle.putString(str, URLDecoder.decode(string, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                }
            }
        }
    }

    public static com.facebook.search.uri.SearchResultUriIntentBuilder m790a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f711b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.uri.SearchResultUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f711b;	 Catch:{ all -> 0x003a }
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
        r0 = m791b(r0);	 Catch:{ all -> 0x0035 }
        f711b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f711b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.uri.SearchResultUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.search.uri.SearchResultUriIntentBuilder");
    }

    private static SearchResultUriIntentBuilder m791b(InjectorLike injectorLike) {
        return new SearchResultUriIntentBuilder(IdBasedProvider.a(injectorLike, 12));
    }

    static {
        String[][] strArr = new String[5][];
        strArr[0] = new String[]{"query_function", null};
        strArr[1] = new String[]{"source", null};
        strArr[2] = new String[]{"title", null};
        strArr[3] = new String[]{"result_type", "blended"};
        strArr[4] = new String[]{"query_vertical", "content"};
        f710a = strArr;
    }

    @Inject
    public SearchResultUriIntentBuilder(@FragmentChromeActivity Provider<ComponentName> provider) {
        StringBuilder append = new StringBuilder().append(FBLinks.b).append("search_result_page?");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < f710a.length; i++) {
            String str = f710a[i][0];
            String str2 = f710a[i][1];
            stringBuilder.append(str).append("={").append(str).append(str2 == null ? "" : " " + str2).append("}&");
        }
        a(StringFormatUtil.formatStrLocaleSafe(append.append(stringBuilder.substring(0, stringBuilder.length() - 1)).toString()), new SearchResultIntentBuilder(provider));
    }
}
