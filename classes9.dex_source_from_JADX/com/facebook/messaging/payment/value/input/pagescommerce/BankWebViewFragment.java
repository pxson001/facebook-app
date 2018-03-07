package com.facebook.messaging.payment.value.input.pagescommerce;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.browser.MessengerWebViewHelper;
import com.facebook.messaging.browser.MessengerWebViewHelper.DismissUrlHandler;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: enableBuiltInAEC(%b) */
public final class BankWebViewFragment extends FbFragment {
    @Inject
    public MessengerWebViewHelper f15790a;
    private FrameLayout f15791b;
    private MenuItem f15792c;

    /* compiled from: enableBuiltInAEC(%b) */
    public class C18571 implements DismissUrlHandler {
        final /* synthetic */ BankWebViewFragment f15789a;

        public C18571(BankWebViewFragment bankWebViewFragment) {
            this.f15789a = bankWebViewFragment;
        }

        public final void mo328a() {
            BankWebViewFragment.m15985e(this.f15789a);
            this.f15789a.ao().setResult(-1);
            this.f15789a.ao().finish();
        }
    }

    public static void m15984a(Object obj, Context context) {
        ((BankWebViewFragment) obj).f15790a = MessengerWebViewHelper.m8634b(FbInjector.get(context));
    }

    public final void m15991c(Bundle bundle) {
        super.c(bundle);
        e(true);
        Class cls = BankWebViewFragment.class;
        m15984a((Object) this, getContext());
    }

    public final View m15987a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 806728953);
        View inflate = layoutInflater.inflate(2130903384, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1083168526, a);
        return inflate;
    }

    @SuppressLint({"BadMethodUse-android.webkit.WebView.loadUrl"})
    public final void m15990a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f15791b = (FrameLayout) e(2131559905);
        this.f15790a.f8343d = (ProgressBar) e(2131559906);
        String string = this.s.getString("dismiss_url");
        if (Strings.isNullOrEmpty(string)) {
            m15985e(this);
        } else {
            this.f15790a.m8637a(string, new C18571(this));
        }
        View a = this.f15790a.m8636a();
        this.f15791b.addView(a);
        a.loadUrl(this.s.getString("oauth_url"));
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1347438504);
        ao().setRequestedOrientation(1);
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -740778209, a);
    }

    public final void m15986H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -540522269);
        super.H();
        KeyboardUtils.a(getContext(), this.T);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -220017179, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -259962900);
        super.mY_();
        this.f15790a.m8638b();
        this.f15791b = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 913382452, a);
    }

    public final void m15989a(Menu menu, MenuInflater menuInflater) {
        super.a(menu, menuInflater);
        menuInflater.inflate(2131820583, menu);
    }

    public final void m15988a(Menu menu) {
        this.f15792c = menu.findItem(2131568680);
    }

    public final boolean a_(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131568680) {
            return false;
        }
        ao().setResult(-1);
        ao().finish();
        return true;
    }

    public static void m15985e(BankWebViewFragment bankWebViewFragment) {
        if (bankWebViewFragment.f15792c != null) {
            bankWebViewFragment.f15792c.setEnabled(true);
        }
    }
}
