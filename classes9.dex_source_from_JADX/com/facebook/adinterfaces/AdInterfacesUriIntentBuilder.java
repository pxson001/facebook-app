package com.facebook.adinterfaces;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: about/graphsearch.* */
public class AdInterfacesUriIntentBuilder extends UriIntentBuilder {
    private static volatile AdInterfacesUriIntentBuilder f21543a;

    public static com.facebook.adinterfaces.AdInterfacesUriIntentBuilder m22512a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21543a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.adinterfaces.AdInterfacesUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f21543a;	 Catch:{ all -> 0x0039 }
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
        r0 = m22515b();	 Catch:{ all -> 0x0034 }
        f21543a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f21543a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.AdInterfacesUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.adinterfaces.AdInterfacesUriIntentBuilder");
    }

    private static AdInterfacesUriIntentBuilder m22515b() {
        return new AdInterfacesUriIntentBuilder();
    }

    @Inject
    public AdInterfacesUriIntentBuilder() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("objective", ObjectiveType.BOOST_POST);
        bundle.putInt("title", 2131234020);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.e, m22513a("page_id"), m22513a("storyId"), m22513a("legacyStoryId"), m22513a("referral")), AdInterfacesObjectiveActivity.class, bundle);
        String str = FBLinks.f;
        Object[] objArr = new Object[]{m22513a("page_id"), m22513a("storyId"), m22513a("legacyStoryId"), m22513a("promotion_target_id"), m22513a("placement_extra"), m22513a("referral")};
        bundle = new Bundle();
        bundle.putSerializable("objective", ObjectiveType.BOOST_EVENT);
        bundle.putInt("title", 2131234090);
        a(StringFormatUtil.a(str, objArr), AdInterfacesObjectiveActivity.class, bundle);
        bundle = new Bundle();
        bundle.putSerializable("objective", ObjectiveType.PROMOTE_PRODUCT);
        bundle.putInt("title", 2131234050);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.l, m22513a("page_id"), m22513a("promotion_target_id"), m22513a("referral")), AdInterfacesObjectiveActivity.class, bundle);
        str = FBLinks.g;
        bundle = new Bundle();
        bundle.putSerializable("objective", ObjectiveType.LOCAL_AWARENESS);
        bundle.putInt("title", 2131233909);
        m22514a(str, bundle);
        str = FBLinks.h;
        bundle = new Bundle();
        bundle.putSerializable("objective", ObjectiveType.PROMOTE_WEBSITE);
        bundle.putInt("title", 2131234048);
        m22514a(str, bundle);
        str = FBLinks.i;
        bundle = new Bundle();
        bundle.putSerializable("objective", ObjectiveType.PAGE_LIKE);
        bundle.putInt("title", 2131234049);
        m22514a(str, bundle);
        str = FBLinks.j;
        bundle = new Bundle();
        bundle.putSerializable("objective", ObjectiveType.PROMOTE_CTA);
        bundle.putInt("title", 2131234051);
        m22514a(str, bundle);
    }

    private void m22514a(String str, Bundle bundle) {
        a(StringFormatUtil.formatStrLocaleSafe(str, m22513a("page_id"), m22513a("source"), m22513a("referral")), AdInterfacesObjectiveActivity.class, bundle);
    }

    private static String m22513a(String str) {
        return "{" + str + " UNKNOWN}";
    }

    public final Intent m22516a(Context context, String str) {
        Intent a = super.a(context, str);
        if (a != null) {
            a.setFlags(603979776);
            a.putExtra("uri_extra", str);
        }
        return a;
    }
}
