package com.facebook.messaging.sms.migration;

import android.content.res.Resources;
import android.graphics.Color;
import com.facebook.inject.Assisted;
import com.facebook.messaging.sms.migration.abtest.ExperimentsForSMSMigrationModule;
import com.facebook.messaging.sms.migration.util.SMSContactsMigrationTextUtil;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;

/* compiled from: qrcode_code_imported */
public class SMSContactPickerConfig {
    public PickerMode f4147a;
    private final QeAccessor f4148b;
    private final Resources f4149c;
    private final SMSContactsMigrationTextUtil f4150d;

    /* compiled from: qrcode_code_imported */
    public enum PickerMode {
        LOCAL,
        MATCHED
    }

    @Inject
    public SMSContactPickerConfig(@Assisted PickerMode pickerMode, QeAccessor qeAccessor, Resources resources, SMSContactsMigrationTextUtil sMSContactsMigrationTextUtil) {
        this.f4147a = pickerMode;
        this.f4148b = qeAccessor;
        this.f4149c = resources;
        this.f4150d = sMSContactsMigrationTextUtil;
    }

    public final boolean m3805b() {
        return m3801a(ExperimentsForSMSMigrationModule.f4232p, true);
    }

    public final boolean m3806c() {
        if (this.f4147a == PickerMode.LOCAL) {
            return false;
        }
        return m3801a(ExperimentsForSMSMigrationModule.f4231o, false);
    }

    public final String m3807d() {
        return m3799a(ExperimentsForSMSMigrationModule.f4234r, 2131240080);
    }

    public final int m3808e() {
        try {
            return Color.parseColor(m3800a(ExperimentsForSMSMigrationModule.f4233q, "#0084FF"));
        } catch (IllegalArgumentException e) {
            return Color.parseColor("#0084FF");
        }
    }

    public final String m3803a(int i, int i2) {
        if (this.f4147a == PickerMode.LOCAL) {
            return m3799a(ExperimentsForSMSMigrationModule.f4224h, 2131240061);
        }
        if (i == i2) {
            return this.f4149c.getQuantityString(2131689758, i, new Object[]{Integer.valueOf(i)});
        }
        return this.f4149c.getQuantityString(2131689757, i2, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final CharSequence m3802a(int i) {
        if (this.f4147a != PickerMode.LOCAL) {
            return this.f4149c.getQuantityString(2131689759, i);
        }
        return this.f4150d.m3865a(m3799a(ExperimentsForSMSMigrationModule.f4223g, 2131240062), "{learn_more_link}", m3799a(ExperimentsForSMSMigrationModule.f4222f, 2131240057));
    }

    public final String m3804b(int i, int i2) {
        if (this.f4147a == PickerMode.LOCAL) {
            return m3799a(ExperimentsForSMSMigrationModule.f4221e, 2131240063);
        }
        if (i == 0) {
            return this.f4149c.getQuantityString(2131689760, i2, new Object[]{Integer.valueOf(i2)});
        }
        return this.f4149c.getQuantityString(2131689761, i, new Object[]{Integer.valueOf(i)});
    }

    private String m3799a(char c, int i) {
        return this.f4148b.a(Liveness.Cached, ExposureLogging.Off, c, i, this.f4149c);
    }

    private String m3800a(char c, String str) {
        return this.f4148b.a(Liveness.Cached, ExposureLogging.Off, c, str);
    }

    private boolean m3801a(short s, boolean z) {
        return this.f4148b.a(Liveness.Cached, ExposureLogging.Off, s, z);
    }
}
