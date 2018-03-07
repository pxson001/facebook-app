package com.facebook.groups.memberlist.intent;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.IntentResolver;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog.Builder;

/* compiled from: extra_logging */
public class GroupMemberActions {

    /* compiled from: extra_logging */
    public final class C15771 implements OnClickListener {
        final /* synthetic */ SecureContextHelper f14440a;
        final /* synthetic */ Context f14441b;

        public C15771(SecureContextHelper secureContextHelper, Context context) {
            this.f14440a = secureContextHelper;
            this.f14441b = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("http://m.facebook.com/mobile/messenger"));
            this.f14440a.b(intent, this.f14441b);
            dialogInterface.cancel();
        }
    }

    public static boolean m15975a(String str, SecureContextHelper secureContextHelper, Activity activity, Resources resources, Context context) {
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("fb-messenger://user/%s", str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(formatStrLocaleSafe));
        intent.setFlags(268435456);
        if (IntentResolver.a(context, intent)) {
            secureContextHelper.a(intent, activity);
            return true;
        }
        new Builder(context).b(resources.getString(2131239488)).a(true).b(resources.getString(2131239490), null).a(resources.getString(2131239489), new C15771(secureContextHelper, context)).a().show();
        return false;
    }
}
