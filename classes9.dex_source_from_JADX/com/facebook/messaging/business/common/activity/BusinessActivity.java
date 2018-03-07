package com.facebook.messaging.business.common.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.banner.BannerNotificationController;
import com.facebook.common.banner.BannerNotificationPrioritizer;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory;
import com.facebook.messaging.connectivity.ConnectionStatusNotification;
import com.facebook.messaging.connectivity.ConnectionStatusNotificationProvider;
import com.facebook.messaging.connectivity.MessagesConnectivityModule;
import com.facebook.messaging.connectivity.annotations.ConnectionStatusForBusinessActivity;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: next_step */
public final class BusinessActivity extends FbFragmentActivity {
    @Inject
    public AppCompatActivityOverrider f8678p;
    @Inject
    BannerNotificationController f8679q;
    @Inject
    @ConnectionStatusForBusinessActivity
    ConnectionStatusNotification f8680r;
    @Inject
    BusinessRequestErrorBannerNotification f8681s;
    @ForBusinessBannerNotification
    @Inject
    BannerNotificationPrioritizer f8682t;
    @Inject
    public Set<Factory> f8683u;
    @Nullable
    public ActionBarBasedFbTitleBar f8684v;
    public String f8685w;

    /* compiled from: next_step */
    class C09911 implements EventListener {
        final /* synthetic */ BusinessActivity f8677a;

        C09911(BusinessActivity businessActivity) {
            this.f8677a = businessActivity;
        }

        public final void mo313a() {
            this.f8677a.f8679q.b(this.f8677a.f8681s);
        }

        public final void mo314b() {
            this.f8677a.f8679q.a(this.f8677a.f8681s);
        }
    }

    public static void m8891a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BusinessActivity) obj).m8890a(AppCompatActivityOverrider.b(injectorLike), BannerNotificationController.b(injectorLike), MessagesConnectivityModule.c((ConnectionStatusNotificationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ConnectionStatusNotificationProvider.class)), new BusinessRequestErrorBannerNotification(LayoutInflaterMethodAutoProvider.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class)), (BannerNotificationPrioritizer) BusinessBannerNotificationPrioritizer.m8895a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$BusinessActivityFragment_Factory(injectorLike)));
    }

    public static Intent m8889a(Context context, String str, @Nullable Parcelable parcelable) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        Intent intent = new Intent(context, BusinessActivity.class);
        intent.putExtra("fragment_name", str);
        if (parcelable != null) {
            intent.putExtra("fragment_params", parcelable);
        }
        return intent;
    }

    protected final void m8892a(Bundle bundle) {
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = BusinessActivity.class;
        m8891a(this, this);
        this.f8679q.a(ImmutableSet.of(this.f8680r, this.f8681s), this.f8682t);
        a(this.f8678p);
    }

    protected final void m8893b(Bundle bundle) {
        BusinessActivityFragment businessActivityFragment;
        super.b(bundle);
        Bundle extras = getIntent().getExtras();
        String string = extras.getString("fragment_name");
        Parcelable parcelable = extras.getParcelable("fragment_params");
        Preconditions.checkNotNull(string);
        setContentView(2130903458);
        FragmentManager kO_ = kO_();
        BusinessActivityFragment businessActivityFragment2 = (BusinessActivityFragment) kO_.a(string);
        if (businessActivityFragment2 == null) {
            BusinessActivityFragment b;
            for (Factory factory : this.f8683u) {
                if (factory.mo307a().equals(string)) {
                    b = factory.mo308b();
                    break;
                }
            }
            b = null;
            businessActivityFragment = b;
            kO_.a().b(2131560066, (FbFragment) businessActivityFragment, string).b();
        } else {
            businessActivityFragment = businessActivityFragment2;
        }
        Preconditions.checkNotNull(businessActivityFragment);
        businessActivityFragment.mo311a(new C09911(this));
        if (parcelable != null) {
            businessActivityFragment.mo310a(parcelable);
        }
        this.f8685w = businessActivityFragment.mo309a((Context) this);
        ActionBar g;
        if (Strings.isNullOrEmpty(this.f8685w)) {
            g = this.f8678p.g();
            if (g != null) {
                g.d();
            }
        } else {
            g = this.f8678p.g();
            if (g != null) {
                g.c();
                this.f8684v = new ActionBarBasedFbTitleBar(this, g);
                this.f8684v.setHasBackButton(true);
                this.f8684v.setTitle(this.f8685w);
            }
        }
        this.f8679q.h = (ViewGroup) a(2131560065);
        overridePendingTransition(2130968681, 2130968689);
    }

    private void m8890a(AppCompatActivityOverrider appCompatActivityOverrider, BannerNotificationController bannerNotificationController, ConnectionStatusNotification connectionStatusNotification, BusinessRequestErrorBannerNotification businessRequestErrorBannerNotification, BannerNotificationPrioritizer bannerNotificationPrioritizer, Set<Factory> set) {
        this.f8678p = appCompatActivityOverrider;
        this.f8679q = bannerNotificationController;
        this.f8680r = connectionStatusNotification;
        this.f8681s = businessRequestErrorBannerNotification;
        this.f8682t = bannerNotificationPrioritizer;
        this.f8683u = set;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z;
        if (menuItem.getItemId() == 16908332) {
            finish();
            overridePendingTransition(2130968586, 2130968689);
            z = true;
        } else {
            z = this.f8684v != null ? this.f8684v.a(menuItem) : false;
        }
        if (z || super.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return false;
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        menu.clear();
        if (this.f8684v != null) {
            this.f8684v.a(menu);
        }
        return onCreateOptionsMenu;
    }

    public final void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1028597922);
        super.onResume();
        this.f8679q.a();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1675721625, a);
    }

    public final void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -2107983825);
        super.onPause();
        this.f8679q.b();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1537780177, a);
    }

    public final void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2130968586, 2130968689);
    }
}
