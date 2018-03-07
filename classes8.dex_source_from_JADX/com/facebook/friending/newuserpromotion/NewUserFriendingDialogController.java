package com.facebook.friending.newuserpromotion;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.time.SystemClock;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import javax.inject.Inject;

/* compiled from: fill-color */
public class NewUserFriendingDialogController {
    private static final CallerContext f13353a = CallerContext.a(NewUserFriendingDialogController.class);
    public final Context f13354b;
    public final FbUriIntentHandler f13355c;
    private final FbSharedPreferences f13356d;
    private final SystemClock f13357e;

    @Inject
    public NewUserFriendingDialogController(Context context, FbUriIntentHandler fbUriIntentHandler, FbSharedPreferences fbSharedPreferences, SystemClock systemClock) {
        this.f13354b = context;
        this.f13355c = fbUriIntentHandler;
        this.f13356d = fbSharedPreferences;
        this.f13357e = systemClock;
    }

    public final void m14999a(Uri uri, String str, long j) {
        if (this.f13357e.a() - this.f13356d.a(NewUserFriendingPrefKeys.f13374b, 0) >= j) {
            this.f13356d.edit().a(NewUserFriendingPrefKeys.f13374b, this.f13357e.a()).commit();
            FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(this.f13354b);
            View inflate = LayoutInflater.from(this.f13354b).inflate(2130904506, null);
            FbDraweeView fbDraweeView = (FbDraweeView) inflate.findViewById(2131562308);
            fbDraweeView.a(uri, f13353a);
            fbDraweeView.setContentDescription(str);
            Button button = (Button) inflate.findViewById(2131562310);
            Button button2 = (Button) inflate.findViewById(2131562309);
            final AlertDialog a = fbAlertDialogBuilder.a(inflate, 0, 0, 0, 0).a();
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NewUserFriendingDialogController f13350b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -364370142);
                    this.f13350b.f13355c.a(this.f13350b.f13354b, FBLinks.cc);
                    a.dismiss();
                    Logger.a(2, EntryType.UI_INPUT_END, -1936048216, a);
                }
            });
            button2.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NewUserFriendingDialogController f13352b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 821254514);
                    a.dismiss();
                    Logger.a(2, EntryType.UI_INPUT_END, 189862305, a);
                }
            });
            a.show();
        }
    }
}
