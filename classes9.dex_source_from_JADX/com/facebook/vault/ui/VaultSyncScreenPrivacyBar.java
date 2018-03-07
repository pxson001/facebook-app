package com.facebook.vault.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.vault.service.VaultHelpers;
import com.facebook.vault.service.VaultNotificationManager;
import javax.inject.Inject;

/* compiled from: text/css */
public class VaultSyncScreenPrivacyBar extends RelativeLayout {
    @Inject
    VaultNotificationManager f2075a;
    @Inject
    VaultHelpers f2076b;
    private Context f2077c;
    private ImageView f2078d;
    private ImageView f2079e;
    private Animation f2080f;

    /* compiled from: text/css */
    class C02021 implements OnClickListener {
        final /* synthetic */ VaultSyncScreenPrivacyBar f2074a;

        C02021(VaultSyncScreenPrivacyBar vaultSyncScreenPrivacyBar) {
            this.f2074a = vaultSyncScreenPrivacyBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1864293948);
            if (this.f2074a.f2076b.a(12)) {
                this.f2074a.m2093b();
                this.f2074a.f2076b.c(12);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 674586474, a);
        }
    }

    private static <T extends View> void m2089a(Class<T> cls, T t) {
        m2090a((Object) t, t.getContext());
    }

    private static void m2090a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VaultSyncScreenPrivacyBar) obj).m2088a(VaultNotificationManager.a(fbInjector), VaultHelpers.b(fbInjector));
    }

    public VaultSyncScreenPrivacyBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2077c = context;
        m2089a(VaultSyncScreenPrivacyBar.class, (View) this);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -992377074);
        this.f2078d = (ImageView) findViewById(2131568268);
        this.f2078d.setOnClickListener(new C02021(this));
        this.f2079e = (ImageView) findViewById(2131568269);
        this.f2080f = AnimationUtils.loadAnimation(this.f2077c, 2130968788);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 610397060, a);
    }

    private void m2088a(VaultNotificationManager vaultNotificationManager, VaultHelpers vaultHelpers) {
        this.f2075a = vaultNotificationManager;
        this.f2076b = vaultHelpers;
    }

    public final void m2092a() {
        if (this.f2075a.e().equals("end_vault_upload")) {
            m2094c();
        } else {
            m2093b();
        }
    }

    private void m2091d() {
        this.f2079e.setVisibility(8);
        this.f2079e.clearAnimation();
        this.f2078d.setVisibility(8);
    }

    public final void m2093b() {
        if (this.f2076b.a(12)) {
            this.f2078d.setVisibility(8);
            this.f2079e.setVisibility(0);
            this.f2079e.startAnimation(this.f2080f);
            return;
        }
        m2091d();
    }

    public final void m2094c() {
        if (this.f2076b.a(12)) {
            this.f2079e.setVisibility(8);
            this.f2079e.clearAnimation();
            this.f2078d.setVisibility(0);
            return;
        }
        m2091d();
    }
}
