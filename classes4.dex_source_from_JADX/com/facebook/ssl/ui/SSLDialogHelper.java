package com.facebook.ssl.ui;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.manifest.AppBuildInfo;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: ui_thread */
public class SSLDialogHelper {
    public final SecureContextHelper f615a;
    private final Lazy<AppBuildInfo> f616b;
    private final Clock f617c;

    public static SSLDialogHelper m990b(InjectorLike injectorLike) {
        return new SSLDialogHelper((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 5142), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SSLDialogHelper(SecureContextHelper secureContextHelper, Lazy<AppBuildInfo> lazy, Clock clock) {
        this.f615a = secureContextHelper;
        this.f616b = lazy;
        this.f617c = clock;
    }

    public final void m991a(Context context, String str) {
        CharSequence charSequence;
        String string = context.getString(2131230804);
        if (BuildConstants.i) {
            charSequence = str + "\n" + string;
        } else {
            Object obj = string;
        }
        View findViewById = LayoutInflater.from(context).inflate(2130907208, null).findViewById(2131567596);
        ((TextView) findViewById.findViewById(2131558966)).setText(charSequence);
        new Builder(new ContextThemeWrapper(context, 16973939)).m14348b(true).m14329a(2131230725).m14345b(findViewById).mo963a((CharSequence) "Change date settings", new 1(this, context)).mo965b(2131230727, null).m14349b();
    }

    public static SSLDialogHelper m989a(InjectorLike injectorLike) {
        return m990b(injectorLike);
    }

    public final boolean m992b(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        double abs = Math.abs(((double) (((AppBuildInfo) this.f616b.get()).c - this.f617c.a())) / 3.1536E10d);
        if (!str.contains("Could not validate certificate: current time:") && !str.contains("DATE_ERROR") && abs <= 1.0d) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        m991a(context, str);
        return true;
    }
}
