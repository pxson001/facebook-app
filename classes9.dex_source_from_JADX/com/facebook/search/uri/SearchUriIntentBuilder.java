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
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.quickpromotion.SearchAwarenessTutorialNuxActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: user_input_email */
public class SearchUriIntentBuilder extends UriIntentBuilder {
    private static volatile SearchUriIntentBuilder f713a;

    /* compiled from: user_input_email */
    public class SearchTypeaheadIntentBuilder implements IUriTemplateIntentBuilder {
        private final Provider<ComponentName> f712a;

        public SearchTypeaheadIntentBuilder(@FragmentChromeActivity Provider<ComponentName> provider) {
            this.f712a = provider;
        }

        public final Intent m792a(Context context, Bundle bundle) {
            String decode;
            try {
                decode = URLDecoder.decode(bundle.getString("query"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                decode = bundle.getString("query");
            }
            return new Intent().setComponent((ComponentName) this.f712a.get()).putExtra("target_fragment", ContentFragmentType.SEARCH_FRAGMENT.ordinal()).putExtra("initial_typeahead_query", GraphSearchQuery.a(decode));
        }
    }

    public static com.facebook.search.uri.SearchUriIntentBuilder m793a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f713a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.uri.SearchUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f713a;	 Catch:{ all -> 0x003a }
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
        r0 = m794b(r0);	 Catch:{ all -> 0x0035 }
        f713a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f713a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.uri.SearchUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.search.uri.SearchUriIntentBuilder");
    }

    private static SearchUriIntentBuilder m794b(InjectorLike injectorLike) {
        return new SearchUriIntentBuilder(IdBasedProvider.a(injectorLike, 12));
    }

    @Inject
    public SearchUriIntentBuilder(@FragmentChromeActivity Provider<ComponentName> provider) {
        String str = FBLinks.b;
        Bundle bundle = new Bundle();
        bundle.putBoolean("extra_parent_activity", true);
        a(StringFormatUtil.formatStrLocaleSafe(str + "search?config={%s}", "config"), FragmentChromeActivity.class, ContentFragmentType.SEARCH_FRAGMENT.ordinal(), bundle);
        a(StringFormatUtil.formatStrLocaleSafe(str + "search?query={%s}", "query"), new SearchTypeaheadIntentBuilder(provider));
        a(str + "search", FragmentChromeActivity.class, ContentFragmentType.SEARCH_FRAGMENT.ordinal(), bundle);
        a(str + "search/awareness/tutorial_nux", SearchAwarenessTutorialNuxActivity.class);
    }
}
