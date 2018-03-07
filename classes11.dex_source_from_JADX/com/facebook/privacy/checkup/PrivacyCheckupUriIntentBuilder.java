package com.facebook.privacy.checkup;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.fbreact.fragment.ImmersiveReactFragment.Builder;
import com.facebook.fbreact.fragment.ReactActivity;
import com.facebook.privacy.checkup.photofeed.PerObjectPrivacyPhotoCheckupActivity;
import com.facebook.privacy.checkup.ui.PrivacyCheckupActivity;
import com.facebook.privacy.checkup.ui.PrivacyCheckupSingleStepActivity;
import com.facebook.privacy.checkup.ui.PrivacyGenericCheckupActivity;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: page/{#%s}/services_list */
public class PrivacyCheckupUriIntentBuilder extends UriIntentBuilder {
    private static volatile PrivacyCheckupUriIntentBuilder f4411a;

    public static com.facebook.privacy.checkup.PrivacyCheckupUriIntentBuilder m5402a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4411a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.privacy.checkup.PrivacyCheckupUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f4411a;	 Catch:{ all -> 0x0039 }
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
        r0 = m5403b();	 Catch:{ all -> 0x0034 }
        f4411a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f4411a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.checkup.PrivacyCheckupUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.privacy.checkup.PrivacyCheckupUriIntentBuilder");
    }

    private static PrivacyCheckupUriIntentBuilder m5403b() {
        return new PrivacyCheckupUriIntentBuilder();
    }

    @Inject
    public PrivacyCheckupUriIntentBuilder() {
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.cJ, "{source unknown}"), PrivacyCheckupActivity.class);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.cK, "{checkup_type}"), PrivacyCheckupSingleStepActivity.class);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.cL, "{checkup_id}"), PrivacyGenericCheckupActivity.class);
        Builder newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "PrivacyCheckupRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.cM, "{checkup_id}"), ReactActivity.class, newBuilder.a());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.cN, "{source unknown}", "{checkup_type PROFILE_PHOTO_CHECKUP}"), PerObjectPrivacyPhotoCheckupActivity.class);
    }

    public final Intent m5404a(Context context, String str) {
        Intent a = super.a(context, str);
        if (a != null && str.startsWith(FBLinks.b)) {
            a.putExtra("uri", str.substring(FBLinks.b.length() - 1));
        }
        return a;
    }
}
