package com.facebook.widget.bottomsheet.sharesheet;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;

/* compiled from: extension_uri */
public class ShareSheetIntentLauncher {
    private final SecureContextHelper f12986a;

    public static ShareSheetIntentLauncher m13019b(InjectorLike injectorLike) {
        return new ShareSheetIntentLauncher((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    private ShareSheetIntentLauncher(SecureContextHelper secureContextHelper) {
        this.f12986a = secureContextHelper;
    }

    public final void m13020a(Context context, Intent intent, ActivityInfo activityInfo) {
        Intent intent2 = new Intent(intent);
        intent2.setClassName(activityInfo.packageName, activityInfo.name);
        intent2.setFlags(268435456);
        this.f12986a.b(intent2, context);
    }
}
