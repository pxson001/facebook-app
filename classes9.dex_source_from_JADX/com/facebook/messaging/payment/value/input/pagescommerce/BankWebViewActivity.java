package com.facebook.messaging.payment.value.input.pagescommerce;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: enableBuiltInAGC(%b) */
public class BankWebViewActivity extends FbFragmentActivity implements ActionBarOwner {
    @Inject
    public AppCompatActivityOverrider f15786p;
    public BankWebViewFragment f15787q;
    private ActionBarBasedFbTitleBar f15788r;

    public static void m15979a(Object obj, Context context) {
        ((BankWebViewActivity) obj).f15786p = AppCompatActivityOverrider.b(FbInjector.get(context));
    }

    public static Intent m15978a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, BankWebViewActivity.class);
        intent.putExtra("web_view_title", str);
        intent.putExtra("web_view_start_url", str2);
        intent.putExtra("web_view_dismiss_url", str3);
        return intent;
    }

    protected final void m15981a(Bundle bundle) {
        super.a(bundle);
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = BankWebViewActivity.class;
        m15979a(this, this);
        a(this.f15786p);
        this.f15788r = new ActionBarBasedFbTitleBar(this, this.f15786p.g());
    }

    protected final void m15982b(@Nullable Bundle bundle) {
        super.b(bundle);
        setContentView(2130903383);
        this.f15786p.g().a(getIntent().getStringExtra("web_view_title"));
        if (this.f15787q == null) {
            String stringExtra = getIntent().getStringExtra("web_view_start_url");
            String stringExtra2 = getIntent().getStringExtra("web_view_dismiss_url");
            BankWebViewFragment bankWebViewFragment = new BankWebViewFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("oauth_url", stringExtra);
            bundle2.putString("dismiss_url", stringExtra2);
            bankWebViewFragment.g(bundle2);
            this.f15787q = bankWebViewFragment;
            kO_().a().b(2131559903, this.f15787q).b();
        }
    }

    public final ActionBar m15980a() {
        return this.f15786p.g();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        menu.clear();
        this.f15788r.a(menu);
        return onCreateOptionsMenu;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
