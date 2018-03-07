package com.facebook.feedplugins.musicstory;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.content.SecureContextHelper;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import javax.inject.Inject;

/* compiled from: composer_load_model_from_saved_session_failed */
public class SimpleMusicPopupManager {
    public final SecureContextHelper f8198a;

    /* compiled from: composer_load_model_from_saved_session_failed */
    public @interface MENU_TYPE {
    }

    @Inject
    public SimpleMusicPopupManager(SecureContextHelper secureContextHelper) {
        this.f8198a = secureContextHelper;
    }

    public final void m9186a(Context context, Uri[] uriArr) {
        Resources resources = context.getResources();
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(context);
        if (uriArr[0] != null) {
            bottomSheetAdapter.a(resources.getString(2131242489)).setOnMenuItemClickListener(m9185a(context, uriArr, 0));
        }
        if (uriArr[1] != null) {
            bottomSheetAdapter.a(resources.getString(2131242490)).setOnMenuItemClickListener(m9185a(context, uriArr, 1));
        }
        if (bottomSheetAdapter.aZ_() != 0) {
            bottomSheetDialog.a(bottomSheetAdapter);
            bottomSheetDialog.show();
        }
    }

    private OnMenuItemClickListener m9185a(final Context context, final Uri[] uriArr, @MENU_TYPE int i) {
        if (i == 0) {
            return new OnMenuItemClickListener(this) {
                final /* synthetic */ SimpleMusicPopupManager f8194c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    Intent a = NativeThirdPartyUriHelper.a(context, null, uriArr[0], null, null);
                    if (a != null) {
                        this.f8194c.f8198a.b(a, context);
                    }
                    return true;
                }
            };
        }
        return i == 1 ? new OnMenuItemClickListener(this) {
            final /* synthetic */ SimpleMusicPopupManager f8197c;

            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent a = NativeThirdPartyUriHelper.a(context, uriArr[1], null, null, null);
                if (a != null) {
                    this.f8197c.f8198a.b(a, context);
                }
                return true;
            }
        } : null;
    }
}
