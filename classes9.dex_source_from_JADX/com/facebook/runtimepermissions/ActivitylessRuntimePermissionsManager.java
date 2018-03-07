package com.facebook.runtimepermissions;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.base.fragment.AbstractFbFragmentListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.ui.dialogs.AbstractDialogFragmentEventListener;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ultralight.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: apn */
public class ActivitylessRuntimePermissionsManager implements RuntimePermissionsManager {
    public static int f20391b = 1337;
    @Inject
    public Context f20392c;
    @Inject
    public RuntimePermissionsUtil f20393d;
    @Inject
    public SecureContextHelper f20394e;
    public final Fragment f20395f;
    public RuntimePermissionsListener f20396g;

    /* compiled from: apn */
    public class C24031 extends AbstractFbFragmentListener {
        final /* synthetic */ ActivitylessRuntimePermissionsManager f20389a;

        public C24031(ActivitylessRuntimePermissionsManager activitylessRuntimePermissionsManager) {
            this.f20389a = activitylessRuntimePermissionsManager;
        }

        public final void m19951a(int i, int i2, Intent intent) {
            if (i == ActivitylessRuntimePermissionsManager.f20391b) {
                ((FbFragment) this.f20389a.f20395f).b(this);
                if (i2 == -1) {
                    ActivitylessRuntimePermissionsManager.m19953a(this.f20389a, intent);
                }
            }
        }
    }

    /* compiled from: apn */
    public class C24042 extends AbstractDialogFragmentEventListener {
        final /* synthetic */ ActivitylessRuntimePermissionsManager f20390a;

        public C24042(ActivitylessRuntimePermissionsManager activitylessRuntimePermissionsManager) {
            this.f20390a = activitylessRuntimePermissionsManager;
        }

        public final void m19952a(int i, int i2, Intent intent) {
            if (i == ActivitylessRuntimePermissionsManager.f20391b) {
                ((FbDialogFragment) this.f20390a.f20395f).al.b(this);
                if (i2 == -1) {
                    ActivitylessRuntimePermissionsManager.m19953a(this.f20390a, intent);
                }
            }
        }
    }

    @Inject
    public ActivitylessRuntimePermissionsManager(@Assisted Fragment fragment) {
        this.f20395f = fragment;
    }

    public final boolean m19956a(String[] strArr) {
        return this.f20393d.a(strArr);
    }

    public final void m19955a(String[] strArr, RuntimePermissionsListener runtimePermissionsListener) {
        m19954a(strArr, a, runtimePermissionsListener);
    }

    public final void m19954a(String[] strArr, RequestPermissionsConfig requestPermissionsConfig, RuntimePermissionsListener runtimePermissionsListener) {
        if (m19956a(strArr)) {
            runtimePermissionsListener.a();
            return;
        }
        this.f20396g = runtimePermissionsListener;
        if (this.f20395f instanceof FbFragment) {
            ((FbFragment) this.f20395f).a(new C24031(this));
        } else if (this.f20395f instanceof FbDialogFragment) {
            ((FbDialogFragment) this.f20395f).al.a(new C24042(this));
        }
        this.f20394e.a(RequestPermissionsActivity.m19961a(this.f20392c, strArr, requestPermissionsConfig), f20391b, this.f20395f);
    }

    public static void m19953a(ActivitylessRuntimePermissionsManager activitylessRuntimePermissionsManager, Intent intent) {
        HashMap hashMap = (HashMap) intent.getSerializableExtra("extra_permission_results");
        int i = 1;
        for (Integer intValue : hashMap.values()) {
            i = (intValue.intValue() == 0 ? 1 : 0) & i;
        }
        if (i != 0) {
            activitylessRuntimePermissionsManager.f20396g.a();
            return;
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (Entry entry : hashMap.entrySet()) {
            if (((Integer) entry.getValue()).intValue() == 1) {
                arrayList.add(entry.getKey());
            } else if (((Integer) entry.getValue()).intValue() == 2) {
                arrayList2.add(entry.getKey());
            }
        }
        activitylessRuntimePermissionsManager.f20396g.a((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]));
    }
}
