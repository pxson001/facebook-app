package com.facebook.messaging.attribution;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.text.style.URLSpan;
import android.widget.TextView;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.widget.text.BetterLinkMovementMethod;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: outgoingMessage */
public class PlatformLaunchDialogHelper {
    private final BetterLinkMovementMethod f7867a;
    private final Clock f7868b;
    public final Context f7869c;
    private final ErrorDialogs f7870d;
    public final FbSharedPreferences f7871e;
    public final PlatformAttributionLogging f7872f;
    public final Resources f7873g;

    /* compiled from: outgoingMessage */
    public enum AppScopedIdsDialogVisibility {
        MUST_SHOW,
        HIDE_FOR_NOW,
        DONT_SHOW
    }

    @Inject
    public PlatformLaunchDialogHelper(BetterLinkMovementMethod betterLinkMovementMethod, Clock clock, Context context, ErrorDialogs errorDialogs, FbSharedPreferences fbSharedPreferences, PlatformAttributionLogging platformAttributionLogging, Resources resources) {
        this.f7867a = betterLinkMovementMethod;
        this.f7868b = clock;
        this.f7869c = context;
        this.f7870d = errorDialogs;
        this.f7871e = fbSharedPreferences;
        this.f7872f = platformAttributionLogging;
        this.f7873g = resources;
    }

    public final AppScopedIdsDialogVisibility m8092a(String str) {
        boolean a = this.f7871e.a(MessagingPrefKeys.A, false);
        if (Strings.isNullOrEmpty(str) || a) {
            return AppScopedIdsDialogVisibility.DONT_SHOW;
        }
        if (this.f7868b.a() - this.f7871e.a(MessagingPrefKeys.B, 0) >= ((long) this.f7871e.a(MessagingPrefKeys.C, 0)) * 86400000) {
            return AppScopedIdsDialogVisibility.MUST_SHOW;
        }
        return AppScopedIdsDialogVisibility.HIDE_FOR_NOW;
    }

    public final void m8094a(final OnClickListener onClickListener, final OnClickListener onClickListener2, final String str, @Nullable final String str2, Fragment fragment) {
        TextView textView = (TextView) new FbAlertDialogBuilder(fragment.getContext()).a(2131240009).b(new StyledStringBuilder(this.f7873g).a(this.f7873g.getString(2131240010)).a("[[link]]", this.f7873g.getString(2131240011), new URLSpan("https://www.facebook.com/help/messenger-app/677222715664928/"), 33).b()).a(2131230726, new OnClickListener(this) {
            final /* synthetic */ PlatformLaunchDialogHelper f7862d;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f7862d.f7871e.edit().putBoolean(MessagingPrefKeys.A, true).commit();
                this.f7862d.f7872f.m8086b(str, str2);
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i);
                }
            }
        }).b(2131230737, new OnClickListener(this) {
            final /* synthetic */ PlatformLaunchDialogHelper f7866d;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f7866d.f7872f.m8089c(str, str2);
                PlatformLaunchDialogHelper platformLaunchDialogHelper = this.f7866d;
                int a = platformLaunchDialogHelper.f7871e.a(MessagingPrefKeys.C, 0);
                platformLaunchDialogHelper.f7871e.edit().a(MessagingPrefKeys.C, Math.min(a == 0 ? 1 : a * 2, 32)).commit();
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, i);
                }
            }
        }).b().findViewById(2131559674);
        if (textView != null) {
            textView.setLinkTextColor(this.f7873g.getColor(2131362241));
            textView.setMovementMethod(this.f7867a);
        }
        this.f7872f.m8083a(str, str2);
        this.f7871e.edit().a(MessagingPrefKeys.B, this.f7868b.a()).commit();
    }

    public final void m8093a() {
        ErrorDialogs errorDialogs = this.f7870d;
        ErrorDialogParamsBuilder a = ErrorDialogParams.a(this.f7873g);
        a.c = this.f7873g.getString(2131240012);
        errorDialogs.a(a.l());
    }
}
