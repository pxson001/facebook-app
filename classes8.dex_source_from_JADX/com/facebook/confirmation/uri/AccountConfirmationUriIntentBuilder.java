package com.facebook.confirmation.uri;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.confirmation.activity.SimpleConfirmAccountActivity;
import com.facebook.growth.model.Contactpoint;
import com.facebook.growth.model.ContactpointType;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: inline_friend_request */
public class AccountConfirmationUriIntentBuilder extends UriIntentBuilder {
    private static volatile AccountConfirmationUriIntentBuilder f10809a;

    /* compiled from: inline_friend_request */
    class AccountConfirmationIntentBuilder implements IUriTemplateIntentBuilder {
        AccountConfirmationIntentBuilder() {
        }

        public final Intent m12746a(Context context, Bundle bundle) {
            Parcelable a;
            boolean z = false;
            String str = "";
            String string = bundle.getString("normalized");
            ContactpointType valueOf = ContactpointType.valueOf(bundle.getString("type"));
            if (valueOf == ContactpointType.EMAIL) {
                a = Contactpoint.m17343a(string);
            } else if (valueOf == ContactpointType.PHONE) {
                a = Contactpoint.m17344a(string, bundle.getString("country"));
                z = Boolean.valueOf(bundle.getString("phone_number")).booleanValue();
                str = bundle.getString("quick_promotion");
            } else {
                throw new RuntimeException("Unknown ContactpointType");
            }
            Intent intent = new Intent(context, SimpleConfirmAccountActivity.class);
            intent.putExtra("extra_cancel_allowed", true);
            intent.putExtra("extra_contactpoint", a);
            intent.putExtra("extra_for_phone_number_confirmation", z);
            intent.putExtra("extra_phone_number_acquisition_quick_promotion_id", str);
            return intent;
        }
    }

    public static com.facebook.confirmation.uri.AccountConfirmationUriIntentBuilder m12747a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10809a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.confirmation.uri.AccountConfirmationUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f10809a;	 Catch:{ all -> 0x0039 }
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
        r0 = m12748b();	 Catch:{ all -> 0x0034 }
        f10809a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f10809a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.confirmation.uri.AccountConfirmationUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.confirmation.uri.AccountConfirmationUriIntentBuilder");
    }

    private static AccountConfirmationUriIntentBuilder m12748b() {
        return new AccountConfirmationUriIntentBuilder();
    }

    @Inject
    public AccountConfirmationUriIntentBuilder() {
        String a = FBLinks.a("confirmAccount/?normalized_contactpoint={%s}&contactpoint_type={%s}");
        a(StringFormatUtil.a(a + "&iso_country_code={%s}&for_phone_number_confirmation={%s}" + "&quick_promotion_id={%s}", new Object[]{"normalized", "type", "country", "phone_number", "quick_promotion"}), new AccountConfirmationIntentBuilder());
        a(StringFormatUtil.formatStrLocaleSafe(a + "&iso_country_code={%s}", "normalized", "type", "country"), new AccountConfirmationIntentBuilder());
        a(StringFormatUtil.formatStrLocaleSafe(a, "normalized", "type"), new AccountConfirmationIntentBuilder());
    }
}
