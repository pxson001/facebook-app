package com.facebook.vault.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.vault.prefs.SyncModePref;
import com.facebook.vault.service.UploadManagerConnectivity;
import com.facebook.vault.service.VaultHelpers;
import javax.inject.Inject;

/* compiled from: text/vnd.wap.co */
public class VaultSyncScreenErrorBar extends LinearLayout {
    @Inject
    DeviceConditionHelper f2035a;
    @Inject
    SyncModePref f2036b;
    @Inject
    VaultHelpers f2037c;
    @Inject
    SecureContextHelper f2038d;
    private Context f2039e;
    private ImageView f2040f;
    private TextView f2041g;
    private State f2042h = State.INVISIBLE;

    /* compiled from: text/vnd.wap.co */
    enum State {
        SYNC_IS_OFF,
        REQUIRES_WIFI,
        LOW_BATTERY,
        NO_INTERNET,
        INVISIBLE
    }

    private static <T extends View> void m2063a(Class<T> cls, T t) {
        m2064a((Object) t, t.getContext());
    }

    private static void m2064a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VaultSyncScreenErrorBar) obj).m2062a(DeviceConditionHelper.a(fbInjector), SyncModePref.a(fbInjector), VaultHelpers.b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    public VaultSyncScreenErrorBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2039e = context;
        m2063a(VaultSyncScreenErrorBar.class, (View) this);
    }

    private void m2062a(DeviceConditionHelper deviceConditionHelper, SyncModePref syncModePref, VaultHelpers vaultHelpers, SecureContextHelper secureContextHelper) {
        this.f2035a = deviceConditionHelper;
        this.f2036b = syncModePref;
        this.f2037c = vaultHelpers;
        this.f2038d = secureContextHelper;
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -622217916);
        this.f2040f = (ImageView) findViewById(2131568271);
        this.f2041g = (TextView) findViewById(2131568272);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -453054720, a);
    }

    public final void m2066a() {
        switch (this.f2042h) {
            case SYNC_IS_OFF:
            case REQUIRES_WIFI:
                this.f2038d.a(new Intent(this.f2039e, VaultSettingsActivity.class), this.f2039e);
                return;
            default:
                return;
        }
    }

    public final void m2067b() {
        String a = this.f2036b.a();
        if ((a.equals("MOBILE_RADIO") || a.equals("WIFI_ONLY")) && !UploadManagerConnectivity.m1959a(this.f2039e)) {
            this.f2042h = State.NO_INTERNET;
        } else if (a.equals("WIFI_ONLY") && !this.f2035a.b()) {
            this.f2042h = State.REQUIRES_WIFI;
        } else if (a.equals("OFF")) {
            this.f2042h = State.SYNC_IS_OFF;
        } else if (this.f2037c.d()) {
            this.f2042h = State.LOW_BATTERY;
        } else {
            this.f2042h = State.INVISIBLE;
        }
        m2065c();
    }

    private void m2065c() {
        switch (this.f2042h) {
            case SYNC_IS_OFF:
                this.f2040f.setImageResource(2130843865);
                this.f2041g.setText(this.f2039e.getString(2131234332));
                setVisibility(0);
                return;
            case REQUIRES_WIFI:
                this.f2040f.setImageResource(2130843873);
                this.f2041g.setText(this.f2039e.getString(2131234331));
                setVisibility(0);
                return;
            case NO_INTERNET:
                this.f2040f.setImageResource(2130840212);
                this.f2041g.setText(this.f2039e.getString(2131234330));
                setVisibility(0);
                return;
            case LOW_BATTERY:
                this.f2040f.setImageResource(2130843859);
                this.f2041g.setText(this.f2039e.getString(2131234333));
                setVisibility(0);
                return;
            default:
                setVisibility(8);
                return;
        }
    }
}
