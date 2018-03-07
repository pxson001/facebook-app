package com.facebook.groups.fb4a.react;

import android.os.Bundle;
import com.facebook.base.activity.ReactFragmentActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.common.util.StringUtil;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: payments_card_scanner_used */
public class FB4AGroupsReactUriIntentBuilder extends UriIntentBuilder {
    private static volatile FB4AGroupsReactUriIntentBuilder f6904a;

    public static com.facebook.groups.fb4a.react.FB4AGroupsReactUriIntentBuilder m7187a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6904a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.groups.fb4a.react.FB4AGroupsReactUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f6904a;	 Catch:{ all -> 0x0039 }
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
        r0 = m7189b();	 Catch:{ all -> 0x0034 }
        f6904a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f6904a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.fb4a.react.FB4AGroupsReactUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.groups.fb4a.react.FB4AGroupsReactUriIntentBuilder");
    }

    private static FB4AGroupsReactUriIntentBuilder m7189b() {
        return new FB4AGroupsReactUriIntentBuilder();
    }

    @Inject
    FB4AGroupsReactUriIntentBuilder() {
        m7190b("FBGroupsDiscoveryCategoryRoute", StringFormatUtil.formatStrLocaleSafe(FBLinks.J, "category_id"));
        m7188a("FBGroupsDiscoveryCategoriesRoute", "/groups_discovery_categories", FBLinks.K);
    }

    private void m7190b(String str, String str2) {
        m7188a(str, null, str2);
    }

    private void m7188a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("route", str);
        if (!StringUtil.c(str2)) {
            bundle.putString("uri", str2);
        }
        a(str3, ReactFragmentActivity.class, ContentFragmentType.GENERAL_GROUPS_REACT_FRAGMENT.ordinal(), bundle);
    }
}
