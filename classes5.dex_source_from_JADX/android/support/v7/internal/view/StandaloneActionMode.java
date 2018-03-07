package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: upsell_borrow_loan_confirm_impression */
public class StandaloneActionMode extends ActionMode implements Callback {
    private Context f711a;
    private ActionBarContextView f712b;
    private ActionMode.Callback f713c;
    private WeakReference<View> f714d;
    private boolean f715e;
    private boolean f716f;
    private MenuBuilder f717g;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z) {
        this.f711a = context;
        this.f712b = actionBarContextView;
        this.f713c = callback;
        MenuBuilder menuBuilder = new MenuBuilder(context);
        this.f717g = menuBuilder;
        this.f717g.mo330a((Callback) this);
        this.f716f = z;
    }

    public final void mo249b(CharSequence charSequence) {
        this.f712b.setTitle(charSequence);
    }

    public final void mo245a(CharSequence charSequence) {
        this.f712b.setSubtitle(charSequence);
    }

    public final void mo243a(int i) {
        mo249b(this.f711a.getString(i));
    }

    public final void mo248b(int i) {
        mo245a(this.f711a.getString(i));
    }

    public final void mo246a(boolean z) {
        super.mo246a(z);
        this.f712b.setTitleOptional(z);
    }

    public final boolean mo254h() {
        return this.f712b.f1008t;
    }

    public final void mo244a(View view) {
        this.f712b.setCustomView(view);
        this.f714d = view != null ? new WeakReference(view) : null;
    }

    public final void mo251d() {
        this.f713c.mo233b(this, this.f717g);
    }

    public final void mo250c() {
        if (!this.f715e) {
            this.f715e = true;
            this.f712b.sendAccessibilityEvent(32);
            this.f713c.mo230a(this);
        }
    }

    public final Menu mo247b() {
        return this.f717g;
    }

    public final CharSequence mo252f() {
        return this.f712b.f998j;
    }

    public final CharSequence mo253g() {
        return this.f712b.f999k;
    }

    public final View mo255i() {
        return this.f714d != null ? (View) this.f714d.get() : null;
    }

    public final MenuInflater mo242a() {
        return new MenuInflater(this.f711a);
    }

    public final boolean mo214a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f713c.mo232a((ActionMode) this, menuItem);
    }

    public final void b_(MenuBuilder menuBuilder) {
        mo251d();
        this.f712b.mo344a();
    }
}
