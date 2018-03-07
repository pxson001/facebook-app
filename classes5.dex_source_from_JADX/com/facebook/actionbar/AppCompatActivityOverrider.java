package com.facebook.actionbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.app.AppCompatDelegateImplV11;
import android.support.v7.app.AppCompatDelegateImplV7;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.base.activity.AbstractFbActivityOverrider;
import com.facebook.base.activity.FbActivitySuper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: bd_fc_requests */
public class AppCompatActivityOverrider extends AbstractFbActivityOverrider {
    private final ActionBarMenuKeyActivityHackOverrider f8006a;
    private AppCompatDelegate f8007b;

    /* compiled from: bd_fc_requests */
    class C09031 implements AppCompatCallback {
        final /* synthetic */ AppCompatActivityOverrider f8005a;

        C09031(AppCompatActivityOverrider appCompatActivityOverrider) {
            this.f8005a = appCompatActivityOverrider;
        }
    }

    public static AppCompatActivityOverrider m14142b(InjectorLike injectorLike) {
        return new AppCompatActivityOverrider(new ActionBarMenuKeyActivityHackOverrider(GatekeeperStoreImplMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public AppCompatActivityOverrider(ActionBarMenuKeyActivityHackOverrider actionBarMenuKeyActivityHackOverrider) {
        this.f8006a = actionBarMenuKeyActivityHackOverrider;
    }

    public final ActionBar m14155g() {
        return this.f8007b.mo203a();
    }

    public final void m14146a(Activity activity, FbActivitySuper fbActivitySuper) {
        AppCompatDelegate appCompatDelegateImplV11;
        AppCompatCallback c09031 = new C09031(this);
        if (VERSION.SDK_INT >= 11) {
            appCompatDelegateImplV11 = new AppCompatDelegateImplV11((Context) activity, activity.getWindow(), c09031);
        } else {
            appCompatDelegateImplV11 = new AppCompatDelegateImplV7((Context) activity, activity.getWindow(), c09031);
        }
        this.f8007b = appCompatDelegateImplV11;
        this.f8006a.a(activity, fbActivitySuper);
    }

    public final void m14145a(Activity activity, @Nullable Bundle bundle) {
        if (activity instanceof PreferenceActivity) {
            this.f8007b.mo204a(bundle);
        }
    }

    public final void m14151b(Activity activity, Bundle bundle) {
        if (!(activity instanceof PreferenceActivity)) {
            this.f8007b.mo204a(bundle);
        }
    }

    public final MenuInflater m14154c() {
        return this.f8007b.mo205b();
    }

    public final boolean m14152b(int i) {
        this.f8007b.mo209a(i);
        return true;
    }

    public final boolean m14147a(View view) {
        this.f8007b.mo210a(view);
        return true;
    }

    public final boolean m14148a(View view, LayoutParams layoutParams) {
        this.f8007b.mo211a(view, layoutParams);
        return true;
    }

    public final boolean m14153b(View view, LayoutParams layoutParams) {
        this.f8007b.mo216b(view, layoutParams);
        return true;
    }

    public final boolean m14149a(FbActivitySuper fbActivitySuper) {
        fbActivitySuper.a();
        this.f8007b.mo221d();
        return true;
    }

    public final Optional<Boolean> m14144a(Activity activity, FbActivitySuper fbActivitySuper, int i, MenuItem menuItem) {
        if (fbActivitySuper.a(i, menuItem)) {
            return Optional.of(Boolean.valueOf(true));
        }
        ActionBar g = m14155g();
        if (menuItem.getItemId() != 16908332 || g == null || (g.mo270b() & 4) == 0) {
            return Optional.of(Boolean.valueOf(false));
        }
        return Optional.of(Boolean.valueOf(m14156j(activity)));
    }

    private static void m14141a(Activity activity, TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.m218a(activity);
    }

    public final boolean m14156j(Activity activity) {
        Intent a = NavUtils.m117a(activity);
        if (a == null) {
            return false;
        }
        if (NavUtils.m119a(activity, a)) {
            TaskStackBuilder a2 = TaskStackBuilder.m216a((Context) activity);
            m14141a(activity, a2);
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

    public final Optional<Boolean> m14143a(Activity activity, int i, KeyEvent keyEvent) {
        return this.f8006a.a(activity, i, keyEvent);
    }

    public final Optional<Boolean> m14150b(Activity activity, int i, KeyEvent keyEvent) {
        return this.f8006a.b(activity, i, keyEvent);
    }
}
