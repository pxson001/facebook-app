package com.facebook.orca.contacts.favorites;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.titlebar.FbActionBarUtil;

/* compiled from: onFetchMoreMessagesSucceeded */
public class EditFavoritesActivity extends FbFragmentActivity implements ActionBarOwner, AnalyticsActivity {
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AppCompatActivityOverrider> f5969p = UltralightRuntime.b;
    @Inject
    private FbActionBarUtil f5970q;
    private boolean f5971r;
    private DivebarEditFavoritesFragment f5972s;

    private static <T extends Context> void m5627a(Class<T> cls, T t) {
        m5628a((Object) t, (Context) t);
    }

    public static void m5628a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EditFavoritesActivity) obj).m5626a(IdBasedLazy.a(fbInjector, 4577), FbActionBarUtil.a(fbInjector));
    }

    protected final void m5631a(Bundle bundle) {
        super.a(bundle);
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = EditFavoritesActivity.class;
        m5628a((Object) this, (Context) this);
        this.f5971r = this.f5970q.a();
        if (this.f5971r) {
            a((ActivityListener) this.f5969p.get());
        }
    }

    protected final void m5632b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130905688);
        this.f5972s = (DivebarEditFavoritesFragment) kO_().a(2131564844);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        ((AppCompatActivityOverrider) this.f5969p.get()).j(this);
        m5629i();
        return true;
    }

    public void onBackPressed() {
        if (this.f5972s == null || !this.f5972s.m5612e()) {
            super.onBackPressed();
            m5629i();
        }
    }

    private void m5629i() {
        if (this.f5971r) {
            overridePendingTransition(2130968682, 2130968687);
        }
    }

    public final ActionBar m5630a() {
        if (this.f5971r) {
            return ((AppCompatActivityOverrider) this.f5969p.get()).g();
        }
        return null;
    }

    public final String am_() {
        return "edit_messaging_favorites";
    }

    private void m5626a(com.facebook.inject.Lazy<AppCompatActivityOverrider> lazy, FbActionBarUtil fbActionBarUtil) {
        this.f5969p = lazy;
        this.f5970q = fbActionBarUtil;
    }
}
