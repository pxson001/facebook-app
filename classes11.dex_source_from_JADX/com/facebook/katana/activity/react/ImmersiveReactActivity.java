package com.facebook.katana.activity.react;

import android.view.KeyEvent;
import com.facebook.base.fragment.CanHandleMenuPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.catalyst.modules.core.PermissionAwareActivity;
import com.facebook.catalyst.modules.permissions.PermissionsModule;
import com.facebook.common.componentmap.ComponentMapConfig;
import com.facebook.katana.activity.ImmersiveActivity;
import javax.annotation.Nullable;

@ComponentMapConfig
/* compiled from: zero_push_on_free_facebook_launch */
public class ImmersiveReactActivity extends ImmersiveActivity implements PermissionAwareActivity {
    @Nullable
    private PermissionsModule f55q;

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        FbFragment a = a();
        if (i == 82 && (a instanceof CanHandleMenuPressed) && ((CanHandleMenuPressed) a).a()) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final void m65a(String[] strArr, int i, PermissionsModule permissionsModule) {
        this.f55q = permissionsModule;
        requestPermissions(strArr, i);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.f55q != null && this.f55q.m6917a(i, iArr)) {
            this.f55q = null;
        }
    }
}
