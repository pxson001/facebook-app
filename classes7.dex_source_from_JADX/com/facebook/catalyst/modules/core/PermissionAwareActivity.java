package com.facebook.catalyst.modules.core;

import com.facebook.catalyst.modules.permissions.PermissionsModule;

/* compiled from: unseenCount */
public interface PermissionAwareActivity {
    void mo165a(String[] strArr, int i, PermissionsModule permissionsModule);

    int checkPermission(String str, int i, int i2);

    int checkSelfPermission(String str);

    boolean shouldShowRequestPermissionRationale(String str);
}
