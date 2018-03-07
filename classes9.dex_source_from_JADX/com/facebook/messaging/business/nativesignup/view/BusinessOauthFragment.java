package com.facebook.messaging.business.nativesignup.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
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
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: msg_to */
public final class BusinessOauthFragment extends FbFragment implements BusinessActivityFragment {
    @Inject
    public MessengerWebViewHelper f8982a;
    private String f8983b;
    private String f8984c;
    public String f8985d;
    private FrameLayout f8986e;

    /* compiled from: msg_to */
    public class C10351 implements DismissUrlHandler {
        final /* synthetic */ BusinessOauthFragment f8981a;

        public C10351(BusinessOauthFragment businessOauthFragment) {
            this.f8981a = businessOauthFragment;
        }

        public final void mo328a() {
            this.f8981a.ao().setResult(-1);
            this.f8981a.ao().finish();
        }
    }

    /* compiled from: msg_to */
    public class Factory implements com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory {
        public final String mo307a() {
            return "BusinessOauthFragment";
        }

        public final BusinessActivityFragment mo308b() {
            return new BusinessOauthFragment();
        }
    }

    public static void m9236a(Object obj, Context context) {
        ((BusinessOauthFragment) obj).f8982a = MessengerWebViewHelper.m8634b(FbInjector.get(context));
    }

    public final void m9243c(Bundle bundle) {
        super.c(bundle);
        Class cls = BusinessOauthFragment.class;
        m9236a((Object) this, getContext());
    }

    public final String mo309a(Context context) {
        return Strings.isNullOrEmpty(this.f8984c) ? context.getString(2131241108) : this.f8984c;
    }

    public final void mo311a(EventListener eventListener) {
    }

    public final void mo310a(Parcelable parcelable) {
        this.f8983b = ((Bundle) parcelable).getString("oauth_url");
        this.f8984c = ((Bundle) parcelable).getString("fragment_title");
        this.f8985d = ((Bundle) parcelable).getString("dismiss_url");
    }

    public final View m9238a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 513730062);
        View inflate = layoutInflater.inflate(2130903470, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 725430180, a);
        return inflate;
    }

    @SuppressLint({"BadMethodUse-android.webkit.WebView.loadUrl"})
    public final void m9241a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f8986e = (FrameLayout) e(2131560104);
        this.f8982a.f8343d = (ProgressBar) e(2131560105);
        this.f8982a.m8637a(this.f8985d, new C10351(this));
        View a = this.f8982a.m8636a();
        this.f8986e.addView(a);
        a.loadUrl(this.f8983b);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1847442603);
        ao().setRequestedOrientation(1);
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -843490788, a);
    }

    public final void m9237H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1896263601);
        super.H();
        KeyboardUtils.a(getContext(), this.T);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2127647790, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -766042655);
        super.mY_();
        this.f8982a.m8638b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1792558716, a);
    }
}
