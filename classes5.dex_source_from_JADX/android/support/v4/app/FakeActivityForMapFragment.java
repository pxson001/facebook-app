package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.Window;

/* compiled from: wilde_groups_tab_menu */
class FakeActivityForMapFragment extends FragmentActivity {
    private final Fragment f61p;

    FakeActivityForMapFragment(Fragment fragment, Context context) {
        this.f61p = fragment;
        attachBaseContext(context);
    }

    public Window getWindow() {
        for (Fragment fragment = this.f61p; fragment != null; fragment = fragment.D.p) {
            if (fragment instanceof DialogFragment) {
                return ((DialogFragment) fragment).f.getWindow();
            }
        }
        return null;
    }

    public ComponentName getComponentName() {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        return launchIntentForPackage != null ? launchIntentForPackage.getComponent() : null;
    }
}
