package com.facebook.actionbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.app.ViewGroupFragmentHost;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.app.AppCompatDelegateImplV11;
import android.support.v7.app.AppCompatDelegateImplV7;
import android.support.v7.app.FragmentWindowLike;
import android.support.v7.app.WindowLike;
import android.support.v7.app.WindowLikeImpl;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.base.fragment.AbstractFbFragmentOverrider;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Optional;

/* compiled from: bd_fc_friends */
public class AppCompatFragmentOverrider extends AbstractFbFragmentOverrider {
    public AppCompatDelegate f8011a;
    public ActivityActionBarActivityOverriderHost f8012b;
    private boolean f8013c;

    /* compiled from: bd_fc_friends */
    class C09041 implements AppCompatCallback {
        final /* synthetic */ AppCompatFragmentOverrider f8008a;

        C09041(AppCompatFragmentOverrider appCompatFragmentOverrider) {
            this.f8008a = appCompatFragmentOverrider;
        }
    }

    public static AppCompatFragmentOverrider m14157a(InjectorLike injectorLike) {
        return new AppCompatFragmentOverrider();
    }

    public final ActionBar m14170f() {
        if (this.f8013c) {
            return this.f8011a.mo203a();
        }
        return null;
    }

    public final void m14163a(Bundle bundle) {
        this.f8011a.mo204a(bundle);
    }

    public final void m14162a() {
        this.f8011a.mo221d();
    }

    public final Optional<View> m14161a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Optional<View> of = Optional.of(this.f8011a.mo208a(layoutInflater, viewGroup, bundle));
        this.f8013c = of.orNull() != null;
        return of;
    }

    public final void m14167b(Fragment fragment) {
        super.b(fragment);
        this.f8013c = false;
        this.f8011a.mo219c();
    }

    public final void m14169e(Fragment fragment) {
        super.e(fragment);
        this.f8011a.mo206e();
    }

    public final Optional<Boolean> m14160a(Fragment fragment, MenuItem menuItem) {
        ActionBar f = m14170f();
        if (menuItem.getItemId() != 16908332 || f == null || (f.mo270b() & 4) == 0) {
            return Optional.of(Boolean.valueOf(false));
        }
        return Optional.of(Boolean.valueOf(m14159g(fragment)));
    }

    public final MenuInflater m14168e() {
        return this.f8011a.mo205b();
    }

    public final boolean m14165a(int i) {
        return this.f8011a.mo217b(i);
    }

    private static void m14158a(Activity activity, TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.m218a(activity);
    }

    private boolean m14159g(Fragment fragment) {
        if (!(fragment.getContext() instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) fragment.getContext();
        Intent a = NavUtils.m117a(activity);
        if (a == null) {
            return false;
        }
        if (NavUtils.m119a(activity, a)) {
            TaskStackBuilder a2 = TaskStackBuilder.m216a((Context) activity);
            m14158a(activity, a2);
            a2.m219a();
            try {
                ActivityCompat.m53a(activity);
            } catch (IllegalStateException e) {
                activity.finish();
            }
        } else {
            NavUtils.m122b(activity, a);
        }
        return true;
    }

    public final void m14171f(final Fragment fragment) {
        FragmentWindowLike windowLikeImpl;
        AppCompatDelegate appCompatDelegateImplV11;
        Activity activity = (Activity) ContextUtils.a(fragment.getContext(), Activity.class);
        if (activity != null) {
            windowLikeImpl = new WindowLikeImpl(activity.getWindow());
        } else {
            windowLikeImpl = new FragmentWindowLike(fragment, new Callback(this) {
                final /* synthetic */ AppCompatFragmentOverrider f8010b;

                public boolean dispatchKeyEvent(KeyEvent keyEvent) {
                    return fragment.T.dispatchKeyEvent(keyEvent);
                }

                public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
                    return fragment.T.dispatchKeyShortcutEvent(keyEvent);
                }

                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    return fragment.T.dispatchTouchEvent(motionEvent);
                }

                public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
                    return fragment.T.dispatchTrackballEvent(motionEvent);
                }

                public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
                    return fragment.T.dispatchGenericMotionEvent(motionEvent);
                }

                public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
                    return fragment.T.dispatchPopulateAccessibilityEvent(accessibilityEvent);
                }

                public View onCreatePanelView(int i) {
                    return (!fragment.K && i == 0 && (fragment.E instanceof ViewGroupFragmentHost)) ? ((ViewGroupFragmentHost) fragment.E).f20b.w() : null;
                }

                public boolean onCreatePanelMenu(int i, Menu menu) {
                    if (fragment.K || i != 0 || !(fragment.E instanceof ViewGroupFragmentHost)) {
                        return false;
                    }
                    ViewGroupFragmentHost viewGroupFragmentHost = (ViewGroupFragmentHost) fragment.E;
                    boolean a = viewGroupFragmentHost.f20b.a(menu, this.f8010b.f8011a.mo205b());
                    return true;
                }

                public boolean onPreparePanel(int i, View view, Menu menu) {
                    if (i != 0 || !(fragment.E instanceof ViewGroupFragmentHost)) {
                        return false;
                    }
                    boolean a = ((ViewGroupFragmentHost) fragment.E).f20b.a(menu);
                    return true;
                }

                public boolean onMenuOpened(int i, Menu menu) {
                    return false;
                }

                public boolean onMenuItemSelected(int i, MenuItem menuItem) {
                    return fragment.E instanceof ViewGroupFragmentHost ? ((ViewGroupFragmentHost) fragment.E).f20b.a(menuItem) : fragment.a_(menuItem);
                }

                public void onWindowAttributesChanged(LayoutParams layoutParams) {
                }

                public void onContentChanged() {
                }

                public void onWindowFocusChanged(boolean z) {
                    fragment.T.onWindowFocusChanged(z);
                }

                public void onAttachedToWindow() {
                }

                public void onDetachedFromWindow() {
                }

                public void onPanelClosed(int i, Menu menu) {
                }

                public boolean onSearchRequested() {
                    return false;
                }

                public boolean onSearchRequested(SearchEvent searchEvent) {
                    return false;
                }

                public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
                    return fragment.T.startActionMode(callback);
                }

                public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
                    return fragment.T.startActionMode(callback, i);
                }

                public void onActionModeStarted(ActionMode actionMode) {
                }

                public void onActionModeFinished(ActionMode actionMode) {
                }
            });
        }
        WindowLike windowLike = windowLikeImpl;
        AppCompatCallback c09041 = new C09041(this);
        if (VERSION.SDK_INT >= 11) {
            appCompatDelegateImplV11 = new AppCompatDelegateImplV11(fragment, windowLike, c09041);
        } else {
            appCompatDelegateImplV11 = new AppCompatDelegateImplV7(fragment, windowLike, c09041);
        }
        this.f8011a = appCompatDelegateImplV11;
    }

    public final void m14164a(Fragment fragment) {
        if (fragment.T != null) {
            this.f8011a.mo221d();
        }
    }

    public final boolean m14166a(Fragment fragment, Menu menu) {
        if (fragment.T == null) {
            return false;
        }
        fragment.a(menu, this.f8011a.mo205b());
        return true;
    }
}
