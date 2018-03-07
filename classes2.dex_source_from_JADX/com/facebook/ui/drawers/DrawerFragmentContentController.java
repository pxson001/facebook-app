package com.facebook.ui.drawers;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.view.View;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: queueTime */
public abstract class DrawerFragmentContentController extends BaseDrawerContentController implements OnBackStackChangedListener {
    private static final Class<?> f8379g = DrawerFragmentContentController.class;
    public LoadStrategy f8380h = LoadStrategy.LOAD_WHEN_IDLE_FORCE_WHEN_VISIBLE;
    public FragmentManager f8381i = null;
    public FragmentManager f8382j = null;
    public BackStackFragment f8383k = null;
    public boolean f8384l = false;
    private final IdleHandler f8385m = new C03651(this);

    /* compiled from: queueTime */
    public enum LoadStrategy {
        LOAD_IMMEDIATELY,
        LOAD_WHEN_VISIBLE,
        LOAD_WHEN_FOCUSED,
        LOAD_WHEN_IDLE_FORCE_WHEN_VISIBLE,
        LOAD_WHEN_IDLE_FORCE_WHEN_FOCUSED;

        public final boolean shouldLoadImmediately() {
            return this == LOAD_IMMEDIATELY;
        }

        public final boolean shouldLoadWhenIdle() {
            return this == LOAD_WHEN_IDLE_FORCE_WHEN_VISIBLE || this == LOAD_WHEN_IDLE_FORCE_WHEN_FOCUSED;
        }

        public final boolean shouldLoadWhenVisible() {
            return this == LOAD_WHEN_VISIBLE || this == LOAD_WHEN_IDLE_FORCE_WHEN_VISIBLE;
        }

        public final boolean shouldLoadWhenFocused() {
            return this == LOAD_WHEN_FOCUSED || this == LOAD_WHEN_IDLE_FORCE_WHEN_FOCUSED;
        }
    }

    /* compiled from: queueTime */
    class C03651 implements IdleHandler {
        final /* synthetic */ DrawerFragmentContentController f8412a;

        C03651(DrawerFragmentContentController drawerFragmentContentController) {
            this.f8412a = drawerFragmentContentController;
        }

        public boolean queueIdle() {
            if (this.f8412a.m12915p()) {
                DrawerFragmentContentController.m12899s(this.f8412a);
            }
            return false;
        }
    }

    public abstract int mo1737j();

    public abstract DrawerContentFragment mo1738k();

    public DrawerFragmentContentController(DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        super(defaultAndroidThreadUtil);
    }

    public void mo1732a(DrawerContentFragment drawerContentFragment) {
    }

    @Nullable
    public View mo1735b(Context context) {
        return null;
    }

    public void mo1733a(DrawerController drawerController) {
        super.mo1733a(drawerController);
        this.f8381i = drawerController.m12953d();
    }

    public void mo1736b(DrawerController drawerController) {
        m12901u();
        if (this.f8383k != null && this.f8383k.hn_()) {
            this.f8381i.mo842a().mo1844a(this.f8383k).mo1847b();
        }
        super.mo1736b(drawerController);
        this.f8381i = null;
        this.f8384l = false;
        this.f8382j = null;
        this.f8383k = null;
    }

    public final View mo1739a(Context context) {
        View customFrameLayout = new CustomFrameLayout(context);
        customFrameLayout.setId(mo1737j());
        return customFrameLayout;
    }

    public final void m12914o() {
        if (!this.f8384l) {
            if (this.f8380h.shouldLoadImmediately() || !m12922e()) {
                m12899s(this);
            } else if (this.f8380h.shouldLoadWhenIdle() && m12922e()) {
                m12900t();
            }
        }
    }

    public final void lb_() {
        if (this.f8383k == null) {
            int j = mo1737j();
            this.f8383k = (BackStackFragment) this.f8381i.mo839a(j);
            if (this.f8383k == null) {
                Bundle bundle = new Bundle(1);
                bundle.putInt("argument_stack_container_id", j);
                BackStackFragment backStackFragment = new BackStackFragment();
                backStackFragment.m271g(bundle);
                this.f8383k = backStackFragment;
                this.f8381i.mo842a().mo1842a(j, this.f8383k).mo1851c();
            } else if (this.f8383k.mx_() && this.f8383k.f116T != null && this.f8383k.f116T.getParent() == null) {
                this.f8381i.mo842a().mo1853d(this.f8383k).mo1854e(this.f8383k).mo1847b();
            }
            this.f8383k.b = this;
        }
    }

    public final void m12903a(BackStackFragment backStackFragment, boolean z) {
        Preconditions.checkArgument(this.f8383k == backStackFragment, "Unexpected BackStackFragment");
        this.f8382j = backStackFragment.m279s();
        this.f8382j.mo845a((OnBackStackChangedListener) this);
        if (z || !m12922e() || this.f8380h.shouldLoadImmediately() || ((this.f8387b && this.f8380h.shouldLoadWhenFocused()) || (this.f8386a && this.f8380h.shouldLoadWhenVisible()))) {
            m12899s(this);
        } else if (this.f8380h.shouldLoadWhenIdle() && m12915p()) {
            m12900t();
        }
    }

    public static void m12899s(DrawerFragmentContentController drawerFragmentContentController) {
        if (!drawerFragmentContentController.f8384l && drawerFragmentContentController.f8382j != null) {
            DrawerContentFragment drawerContentFragment = (DrawerContentFragment) drawerFragmentContentController.f8382j.mo839a(drawerFragmentContentController.mo1737j());
            if (drawerContentFragment == null) {
                if (drawerFragmentContentController.f8382j.mo851c()) {
                    drawerContentFragment = drawerFragmentContentController.mo1738k();
                    drawerFragmentContentController.f8383k.b(drawerContentFragment);
                } else {
                    return;
                }
            }
            drawerFragmentContentController.mo1732a(drawerContentFragment);
            drawerFragmentContentController.f8384l = true;
        }
    }

    private void m12900t() {
        m12901u();
        Looper.myQueue().addIdleHandler(this.f8385m);
    }

    private void m12901u() {
        Looper.myQueue().removeIdleHandler(this.f8385m);
    }

    public final void le_() {
        DrawerContentFragment drawerContentFragment = (DrawerContentFragment) this.f8382j.mo839a(mo1737j());
        if (drawerContentFragment != null) {
            mo1732a(drawerContentFragment);
        }
    }

    public final boolean m12912m() {
        FragmentManager fragmentManager = this.f8382j;
        if (fragmentManager == null || fragmentManager.mo854f() <= 0) {
            return false;
        }
        fragmentManager.mo852d();
        return true;
    }

    public final boolean ld_() {
        return m12912m();
    }

    public final void m12913n() {
        if (m12922e() && this.f8380h.shouldLoadWhenIdle()) {
            m12901u();
        }
    }

    public void mo1734a(boolean z) {
        super.mo1734a(z);
        if (z && this.f8380h.shouldLoadWhenVisible()) {
            m12899s(this);
        }
        if (this.f8382j != null) {
            Fragment a = this.f8382j.mo839a(mo1737j());
            if (a != null) {
                a.mo1860g(z);
            }
        }
    }

    public final void mo1740b(boolean z) {
        super.mo1740b(z);
        if (z && this.f8380h.shouldLoadWhenFocused()) {
            m12899s(this);
        }
    }

    public final boolean m12915p() {
        return this.f8383k != null && this.f8383k.f137y;
    }
}
