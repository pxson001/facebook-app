package com.facebook.zero;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import javax.inject.Inject;

/* compiled from: com.facebook.platform.extra.DATA_FAILURES_FATAL */
public class MessageCapForwardController {
    private final Context f20209a;
    private final MessageCapAccessor f20210b;
    private final FbSharedPreferences f20211c;

    /* compiled from: com.facebook.platform.extra.DATA_FAILURES_FATAL */
    public interface ForwardAction {
        void m28834a();
    }

    @Inject
    public MessageCapForwardController(Context context, MessageCapAccessor messageCapAccessor, FbSharedPreferences fbSharedPreferences) {
        this.f20209a = context;
        this.f20210b = messageCapAccessor;
        this.f20211c = fbSharedPreferences;
    }

    public final void m28835a(final ForwardAction forwardAction) {
        String a = this.f20211c.a(ZeroPrefKeys.j, this.f20209a.getString(2131232601));
        if (!MessageCapAccessor.m28827a() || MessageCapAccessor.m28830e() || MessageCapAccessor.m28828b() > 0) {
            try {
                forwardAction.m28834a();
                return;
            } catch (Throwable e) {
                Log.e("MESSAGE_CAP_FORWARD", e.getMessage(), e);
                return;
            }
        }
        new MessageCapReachedDialogBuilder(this.f20209a, MessageCapAccessor.m28829c(), a, new OnClickListener(this) {
            final /* synthetic */ MessageCapForwardController f20208b;

            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    forwardAction.m28834a();
                } catch (Throwable e) {
                    Log.e("MESSAGE_CAP_FORWARD", e.getMessage(), e);
                }
            }
        }).m28857f().b();
    }
}
