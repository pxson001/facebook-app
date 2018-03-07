package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: video_preview_image */
public abstract class ActionProvider {
    private final Context f277a;
    public SubUiVisibilityListener f278b;
    private VisibilityListener f279c;

    /* compiled from: video_preview_image */
    public interface SubUiVisibilityListener {
        void mo422a(boolean z);
    }

    /* compiled from: video_preview_image */
    public interface VisibilityListener {
        void mo315a();
    }

    public abstract View mo316a();

    public ActionProvider(Context context) {
        this.f277a = context;
    }

    public View mo324a(MenuItem menuItem) {
        return mo316a();
    }

    public boolean mo326b() {
        return false;
    }

    public boolean mo327c() {
        return true;
    }

    public boolean mo318d() {
        return false;
    }

    public boolean mo319e() {
        return false;
    }

    public void mo317a(SubMenu subMenu) {
    }

    public final void m315a(boolean z) {
        if (this.f278b != null) {
            this.f278b.mo422a(z);
        }
    }

    public void mo325a(VisibilityListener visibilityListener) {
        if (!(this.f279c == null || visibilityListener == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f279c = visibilityListener;
    }
}
