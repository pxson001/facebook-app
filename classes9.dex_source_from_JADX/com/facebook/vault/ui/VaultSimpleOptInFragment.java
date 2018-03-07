package com.facebook.vault.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.vault.prefs.DeviceIDPref;
import com.facebook.vault.prefs.SyncModePref;
import com.facebook.vault.service.VaultLogger;
import com.facebook.vault.service.VaultManager;
import com.facebook.vault.service.VaultNotificationManager;
import com.facebook.vault.ui.VaultSyncScreenFragment.C01995;
import javax.inject.Inject;

/* compiled from: text/vnd.wap.si */
public class VaultSimpleOptInFragment extends FbFragment implements OnClickListener {
    private static final String al = VaultSimpleOptInFragment.class.getSimpleName();
    public String f2025a;
    public C01995 am;
    private Button an;
    public int f2026b = 2130907643;
    @Inject
    SyncModePref f2027c;
    @Inject
    DeviceIDPref f2028d;
    @Inject
    VaultNotificationManager f2029e;
    @Inject
    VaultLogger f2030f;
    @Inject
    VaultManager f2031g;
    @Inject
    UriIntentMapper f2032h;
    @Inject
    SecureContextHelper f2033i;

    /* compiled from: text/vnd.wap.si */
    class C01931 implements OnClickListener {
        final /* synthetic */ VaultSimpleOptInFragment f2024a;

        C01931(VaultSimpleOptInFragment vaultSimpleOptInFragment) {
            this.f2024a = vaultSimpleOptInFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -436888492);
            if (this.f2024a.f2032h == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 1014765566, a);
                return;
            }
            Intent a2 = this.f2024a.f2032h.a(this.f2024a.getContext(), FBLinks.a("photosync_help"));
            if (a2 == null) {
                LogUtils.a(1014560950, a);
                return;
            }
            a2.addFlags(268435456);
            this.f2024a.f2033i.a(a2, this.f2024a.getContext());
            LogUtils.a(2079633804, a);
        }
    }

    public static void m2057a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VaultSimpleOptInFragment) obj).m2056a(SyncModePref.a(fbInjector), DeviceIDPref.a(fbInjector), VaultNotificationManager.a(fbInjector), VaultLogger.c(fbInjector), VaultManager.a(fbInjector), (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    private void m2056a(SyncModePref syncModePref, DeviceIDPref deviceIDPref, VaultNotificationManager vaultNotificationManager, VaultLogger vaultLogger, VaultManager vaultManager, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper) {
        this.f2027c = syncModePref;
        this.f2028d = deviceIDPref;
        this.f2029e = vaultNotificationManager;
        this.f2030f = vaultLogger;
        this.f2031g = vaultManager;
        this.f2032h = uriIntentMapper;
        this.f2033i = secureContextHelper;
    }

    public final View m2058a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1098800293);
        View inflate = layoutInflater.inflate(this.f2026b, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 548279617, a);
        return inflate;
    }

    public final void m2059c(Bundle bundle) {
        super.c(bundle);
        Class cls = VaultSimpleOptInFragment.class;
        m2057a(this, getContext());
    }

    public final void m2060d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 33022105);
        super.d(bundle);
        this.an = (Button) this.T.findViewById(2131568262);
        this.an.setOnClickListener(this);
        this.T.findViewById(2131568264).setOnClickListener(new C01931(this));
        String str = "<b><u>" + b(2131234328) + "</u></b>";
        ((TextView) this.T.findViewById(2131568261)).setText(Html.fromHtml(StringLocaleUtil.a(b(2131234327), new Object[]{str})));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 450262861, a);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1037563195);
        String str = "MOBILE_RADIO";
        if (view.getId() == 2131568262) {
            this.f2030f.d(str);
            this.f2027c.a(str);
            this.f2031g.a();
            this.an.setBackgroundColor(jW_().getColor(2131362884));
            this.an.setEnabled(false);
            if (this.f2028d.a() != 0) {
                this.f2029e.a();
            }
            C01995 c01995 = this.am;
            VaultSyncScreenFragment.m2079e(c01995.f2049a);
            VaultSyncScreenFragment.ar(c01995.f2049a);
            c01995.f2049a.aC.m2067b();
        }
        Logger.a(2, EntryType.UI_INPUT_END, 939475921, a);
    }
}
