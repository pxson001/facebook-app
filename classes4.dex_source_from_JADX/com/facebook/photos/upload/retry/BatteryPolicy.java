package com.facebook.photos.upload.retry;

import com.facebook.common.hardware.BatteryStateManager.ChargeState;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.photos.upload.abtest.AutoRetryPolicyController;
import javax.inject.Inject;

/* compiled from: node tray_button is missing */
public class BatteryPolicy {
    ChargeState f7060a;
    private AutoRetryPolicyController f7061b;
    private final SystemBatteryStateManager f7062c;
    private final long f7063d = 0;
    private long f7064e;
    private float f7065f;

    @Inject
    public BatteryPolicy(AutoRetryPolicyController autoRetryPolicyController, SystemBatteryStateManager systemBatteryStateManager) {
        this.f7061b = autoRetryPolicyController;
        this.f7062c = systemBatteryStateManager;
        this.f7064e = 0;
    }

    public final void m7352a() {
        this.f7065f = this.f7062c.a();
        this.f7060a = this.f7062c.b();
    }

    public final boolean m7353b() {
        if (this.f7065f == -1.0f) {
            return true;
        }
        if (this.f7065f < this.f7061b.m7363e()) {
            return false;
        }
        if (m7351e() || this.f7065f >= this.f7061b.m7364f()) {
            return true;
        }
        return false;
    }

    public final long m7354c() {
        double l = (double) this.f7061b.m7370l();
        if (l == 1.0d) {
            return m7350d();
        }
        if (this.f7064e == 0) {
            this.f7064e = m7350d();
        } else {
            this.f7064e = Math.round(l * ((double) this.f7064e));
        }
        return this.f7064e;
    }

    private long m7350d() {
        if (this.f7065f == -1.0f) {
            return this.f7061b.m7368j();
        }
        if (this.f7065f < this.f7061b.m7363e()) {
            return this.f7061b.m7367i();
        }
        if (m7351e()) {
            return this.f7061b.m7369k();
        }
        if (this.f7065f < this.f7061b.m7365g()) {
            return this.f7061b.m7367i();
        }
        if (this.f7065f < this.f7061b.m7366h()) {
            return this.f7061b.m7368j();
        }
        return this.f7061b.m7369k();
    }

    private boolean m7351e() {
        return this.f7060a == ChargeState.CHARGING_AC || this.f7060a == ChargeState.CHARGING_USB || this.f7060a == ChargeState.CHARGING_WIRELESS || this.f7060a == ChargeState.FULL;
    }
}
