package com.facebook.appirater;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import com.facebook.appirater.Appirater.1;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: cta_lead_gen_open_popover */
public class DefaultAppiraterDialogMaker {
    SecureContextHelper f16464a;
    public Resources f16465b;

    /* compiled from: cta_lead_gen_open_popover */
    public class C12961 implements OnClickListener {
        final /* synthetic */ 1 f16456a;
        final /* synthetic */ String f16457b;
        final /* synthetic */ Activity f16458c;
        final /* synthetic */ DefaultAppiraterDialogMaker f16459d;

        public C12961(DefaultAppiraterDialogMaker defaultAppiraterDialogMaker, 1 1, String str, Activity activity) {
            this.f16459d = defaultAppiraterDialogMaker;
            this.f16456a = 1;
            this.f16457b = str;
            this.f16458c = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f16456a != null) {
                1 1 = this.f16456a;
                1.a.a = false;
                1.a.g.edit().a(AppiraterPrefKeys.g, 1.a.d.a()).commit();
            }
            this.f16459d.f16464a.b(new Intent("android.intent.action.VIEW").setFlags(268435456).setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe("market://details?id=%s", this.f16457b))), this.f16458c);
        }
    }

    /* compiled from: cta_lead_gen_open_popover */
    public class C12972 implements OnClickListener {
        final /* synthetic */ 1 f16460a;
        final /* synthetic */ DefaultAppiraterDialogMaker f16461b;

        public C12972(DefaultAppiraterDialogMaker defaultAppiraterDialogMaker, 1 1) {
            this.f16461b = defaultAppiraterDialogMaker;
            this.f16460a = 1;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f16460a != null) {
                1 1 = this.f16460a;
                1.a.a = false;
                1.a.g.edit().a(AppiraterPrefKeys.h, 1.a.d.a()).commit();
            }
        }
    }

    /* compiled from: cta_lead_gen_open_popover */
    public class C12983 implements OnCancelListener {
        final /* synthetic */ 1 f16462a;
        final /* synthetic */ DefaultAppiraterDialogMaker f16463b;

        public C12983(DefaultAppiraterDialogMaker defaultAppiraterDialogMaker, 1 1) {
            this.f16463b = defaultAppiraterDialogMaker;
            this.f16462a = 1;
        }

        public void onCancel(DialogInterface dialogInterface) {
            if (this.f16462a != null) {
                this.f16462a.a.a = false;
            }
        }
    }

    public static DefaultAppiraterDialogMaker m20533b(InjectorLike injectorLike) {
        return new DefaultAppiraterDialogMaker((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DefaultAppiraterDialogMaker(SecureContextHelper secureContextHelper, Resources resources) {
        this.f16464a = secureContextHelper;
        this.f16465b = resources;
    }
}
