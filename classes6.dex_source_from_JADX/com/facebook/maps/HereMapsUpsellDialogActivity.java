package com.facebook.maps;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: widthPercentage */
public class HereMapsUpsellDialogActivity extends FbFragmentActivity {
    @Inject
    ExternalMapLauncher f226p;
    @Inject
    SecureContextHelper f227q;

    /* compiled from: widthPercentage */
    class C00361 implements OnDismissListener {
        final /* synthetic */ HereMapsUpsellDialogActivity f225a;

        C00361(HereMapsUpsellDialogActivity hereMapsUpsellDialogActivity) {
            this.f225a = hereMapsUpsellDialogActivity;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f225a.finish();
        }
    }

    private static <T extends Context> void m217a(Class<T> cls, T t) {
        m218a((Object) t, (Context) t);
    }

    public static void m218a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((HereMapsUpsellDialogActivity) obj).m216a(ExternalMapLauncher.m86a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    public static Intent m215a(Context context, Intent intent, double d, double d2, String str, @Nullable String str2) {
        Intent putExtra = new Intent(context, HereMapsUpsellDialogActivity.class).putExtra("external_map_intent", intent).putExtra("dest_latitude", d).putExtra("dset_longitude", d2).putExtra("dest_name", str);
        if (str2 != null) {
            putExtra.putExtra("dest_address", str2);
        }
        return putExtra;
    }

    protected final void m219b(@Nullable Bundle bundle) {
        Object obj;
        super.b(bundle);
        Class cls = HereMapsUpsellDialogActivity.class;
        m218a((Object) this, (Context) this);
        Intent intent = getIntent();
        Intent intent2 = (Intent) intent.getParcelableExtra("external_map_intent");
        if (intent.hasExtra("dest_latitude") && intent.hasExtra("dset_longitude") && this.f226p.m91a(this, intent2, intent.getDoubleExtra("dest_latitude", 0.0d), intent.getDoubleExtra("dset_longitude", 0.0d), intent.getStringExtra("dest_name"), intent.getStringExtra("dest_address"), new C00361(this))) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            this.f227q.b(intent2, this);
            finish();
        }
    }

    private void m216a(ExternalMapLauncher externalMapLauncher, SecureContextHelper secureContextHelper) {
        this.f226p = externalMapLauncher;
        this.f227q = secureContextHelper;
    }
}
