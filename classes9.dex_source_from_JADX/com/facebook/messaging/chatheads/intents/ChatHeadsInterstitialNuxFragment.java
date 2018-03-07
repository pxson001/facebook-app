package com.facebook.messaging.chatheads.intents;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ViewFlipper;
import com.facebook.chatheads.view.ChatHeadTextBubbleView;
import com.facebook.chatheads.view.ChatHeadTextBubbleView.Origin;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.chatheads.prefs.ChatHeadsPrefKeys;
import com.facebook.messaging.fullscreendialog.FullScreenDialogFragment;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.resources.ui.FbTextView;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

/* compiled from: messenger_pay_type */
public class ChatHeadsInterstitialNuxFragment extends FullScreenDialogFragment {
    @Inject
    public FbSharedPreferences am;
    @Inject
    @ForUiThread
    public Handler an;
    @Inject
    public RuntimePermissionsUtil ao;
    @Inject
    public SecureContextHelper ap;
    private ViewFlipper aq;
    public ChatHeadTextBubbleView ar;
    private FbTextView as;
    private FbTextView at;
    private final Runnable au = new C11261(this);

    /* compiled from: messenger_pay_type */
    class C11261 implements Runnable {
        final /* synthetic */ ChatHeadsInterstitialNuxFragment f9747a;

        C11261(ChatHeadsInterstitialNuxFragment chatHeadsInterstitialNuxFragment) {
            this.f9747a = chatHeadsInterstitialNuxFragment;
        }

        public void run() {
            this.f9747a.ar.m6043a();
            this.f9747a.ar.m6045e();
        }
    }

    /* compiled from: messenger_pay_type */
    class C11272 implements OnClickListener {
        final /* synthetic */ ChatHeadsInterstitialNuxFragment f9748a;

        C11272(ChatHeadsInterstitialNuxFragment chatHeadsInterstitialNuxFragment) {
            this.f9748a = chatHeadsInterstitialNuxFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -984738046);
            RuntimePermissionsUtil runtimePermissionsUtil = this.f9748a.ao;
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(Uri.parse("package:" + runtimePermissionsUtil.a.getPackageName()));
            if (null != null) {
                intent.addFlags(268435456);
            }
            this.f9748a.ap.b(intent, 82, this.f9748a);
            Logger.a(2, EntryType.UI_INPUT_END, -198754259, a);
        }
    }

    /* compiled from: messenger_pay_type */
    class C11283 implements OnClickListener {
        final /* synthetic */ ChatHeadsInterstitialNuxFragment f9749a;

        C11283(ChatHeadsInterstitialNuxFragment chatHeadsInterstitialNuxFragment) {
            this.f9749a = chatHeadsInterstitialNuxFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2057923689);
            ChatHeadsInterstitialNuxFragment.ar(this.f9749a);
            Logger.a(2, EntryType.UI_INPUT_END, -550859342, a);
        }
    }

    public static void m10324a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ChatHeadsInterstitialNuxFragment chatHeadsInterstitialNuxFragment = (ChatHeadsInterstitialNuxFragment) obj;
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        Handler b = Handler_ForUiThreadMethodAutoProvider.b(fbInjector);
        RuntimePermissionsUtil b2 = RuntimePermissionsUtil.b(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        chatHeadsInterstitialNuxFragment.am = fbSharedPreferences;
        chatHeadsInterstitialNuxFragment.an = b;
        chatHeadsInterstitialNuxFragment.ao = b2;
        chatHeadsInterstitialNuxFragment.ap = secureContextHelper;
    }

    public final void m10329a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1028194247);
        super.a(bundle);
        Class cls = ChatHeadsInterstitialNuxFragment.class;
        m10324a((Object) this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1504354713, a);
    }

    public final Dialog m10331c(Bundle bundle) {
        Dialog c = super.c(bundle);
        c.getWindow().getAttributes().windowAnimations = 2131625030;
        return c;
    }

    public final View m10327a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -574887383);
        View inflate = layoutInflater.inflate(2130903558, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 954619935, a);
        return inflate;
    }

    public final void m10330a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.aq = (ViewFlipper) e(2131560298);
        this.aq.setAutoStart(true);
        this.aq.setFlipInterval(3000);
        this.aq.setInAnimation(getContext(), 2130968607);
        this.aq.setOutAnimation(getContext(), 2130968608);
        this.ar = (ChatHeadTextBubbleView) e(2131560300);
        this.ar.setMessage(new SpannableStringBuilder(b(2131230902)));
        this.ar.setOrigin(Origin.RIGHT);
        this.as = (FbTextView) e(2131560304);
        this.as.setOnClickListener(new C11272(this));
        this.at = (FbTextView) e(2131560305);
        this.at.setOnClickListener(new C11283(this));
    }

    public final void m10325G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -964479529);
        super.G();
        HandlerDetour.b(this.an, this.au, 1000, 819168440);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1008733100, a);
    }

    public final void m10326H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -413575908);
        super.H();
        this.ar.m6044b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 259084447, a);
    }

    public final void m10328a(int i, int i2, Intent intent) {
        ar(this);
    }

    public static void ar(ChatHeadsInterstitialNuxFragment chatHeadsInterstitialNuxFragment) {
        if (chatHeadsInterstitialNuxFragment.ao.a()) {
            chatHeadsInterstitialNuxFragment.am.edit().putBoolean(ChatHeadsPrefKeys.d, true).commit();
        }
        chatHeadsInterstitialNuxFragment.b();
    }
}
