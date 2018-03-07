package android.support.v4.app;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;

/* compiled from: wizard_classmates_coworkers */
public class ActivityFragmentHost extends AbstractFragmentHost {
    private final Activity f26a;

    public ActivityFragmentHost(Activity activity) {
        super(activity);
        this.f26a = activity;
    }

    public final Window mo10j() {
        return this.f26a.getWindow();
    }

    public final Resources mo11k() {
        return h().getResources();
    }

    public final boolean mo12n() {
        return false;
    }

    public final View m54a(int i) {
        return this.f26a.findViewById(i);
    }

    public final boolean m59s() {
        Window window = this.f26a.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    public final boolean mo13q() {
        return this.f26a.isFinishing();
    }
}
