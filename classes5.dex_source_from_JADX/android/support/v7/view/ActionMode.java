package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* compiled from: upsell_pin_label */
public abstract class ActionMode {
    public Object f657a;
    public boolean f658b;

    /* compiled from: upsell_pin_label */
    public interface Callback {
        void mo230a(ActionMode actionMode);

        boolean mo231a(ActionMode actionMode, Menu menu);

        boolean mo232a(ActionMode actionMode, MenuItem menuItem);

        boolean mo233b(ActionMode actionMode, Menu menu);
    }

    public abstract MenuInflater mo242a();

    public abstract void mo243a(int i);

    public abstract void mo244a(View view);

    public abstract void mo245a(CharSequence charSequence);

    public abstract Menu mo247b();

    public abstract void mo248b(int i);

    public abstract void mo249b(CharSequence charSequence);

    public abstract void mo250c();

    public abstract void mo251d();

    public abstract CharSequence mo252f();

    public abstract CharSequence mo253g();

    public abstract View mo255i();

    public void mo246a(boolean z) {
        this.f658b = z;
    }

    public boolean mo254h() {
        return false;
    }
}
