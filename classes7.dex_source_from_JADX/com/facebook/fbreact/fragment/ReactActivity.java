package com.facebook.fbreact.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import com.facebook.analytics.tagging.AnalyticsActivityWithExtraData;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.catalyst.modules.core.PermissionAwareActivity;
import com.facebook.catalyst.modules.permissions.PermissionsModule;
import com.facebook.fbreact.fragment.ImmersiveReactFragment.Builder;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: staging_ground_tap_cancel */
public class ReactActivity extends FbFragmentActivity implements AnalyticsActivityWithExtraData, PermissionAwareActivity {
    protected ImmersiveReactFragment f3493p;
    private String f3494q = "unknown";
    private Map<String, Object> f3495r;
    @Nullable
    private PermissionsModule f3496s;

    public final void m4193a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof ImmersiveReactFragment) {
            this.f3493p = (ImmersiveReactFragment) fragment;
        }
    }

    public void m4195b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130906585);
        Bundle extras = getIntent().getExtras();
        if (this.f3493p == null) {
            String string = extras.getString("uri");
            String string2 = extras.getString("route_name");
            String string3 = extras.getString("module_name");
            Bundle bundle2 = extras.getBundle("init_props");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2 = m4196c(bundle2);
            int i = extras.getInt("requested_orientation", -1);
            Builder builder;
            Builder builder2;
            if (string != null) {
                Builder newBuilder = ImmersiveReactFragment.newBuilder();
                newBuilder.f3466a = string;
                builder = newBuilder;
                builder.f3467b = string2;
                builder = builder;
                builder.f3471f = bundle2;
                builder2 = builder;
                builder2.f3473h = i;
                this.f3493p = builder2.m4169b();
            } else {
                builder = ImmersiveReactFragment.newBuilder();
                builder.f3468c = string3;
                builder = builder;
                builder.f3471f = bundle2;
                builder2 = builder;
                builder2.f3473h = i;
                this.f3493p = builder2.m4169b();
            }
            kO_().a().a(2131566579, this.f3493p).b();
        }
        if (extras != null) {
            this.f3494q = extras.getString("analytics_tag");
            this.f3495r = (Map) extras.getSerializable("analytics_extra_data");
        }
    }

    protected Bundle m4196c(Bundle bundle) {
        return bundle;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.f3493p != null) {
            this.f3493p.a(i, i2, intent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 82 && this.f3493p.m4182a()) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onBackPressed() {
        if (!this.f3493p.O_()) {
            super.onBackPressed();
        }
    }

    public final String am_() {
        if (this.f3494q == "unknown") {
            return this.f3493p.am_();
        }
        return this.f3494q;
    }

    public final Map<String, Object> m4197c() {
        return this.f3495r;
    }

    public final void mo165a(String[] strArr, int i, PermissionsModule permissionsModule) {
        this.f3496s = permissionsModule;
        requestPermissions(strArr, i);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.f3496s != null && this.f3496s.a(i, iArr)) {
            this.f3496s = null;
        }
    }
}
