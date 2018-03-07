package com.facebook.resources;

import android.content.res.Configuration;
import android.content.res.Resources;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;

/* compiled from: values/ */
public abstract class FbResources extends Resources {
    private final Resources f1308a;
    private final FbResourcesUsageLogger f1309b;
    private int f1310c;

    public abstract ListenableFuture<Void> mo355b();

    public FbResources(Resources resources, FbResourcesUsageLogger fbResourcesUsageLogger) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1308a = resources;
        this.f1309b = fbResourcesUsageLogger;
    }

    public final void m2553a() {
        Configuration configuration = this.f1308a.getConfiguration();
        int i = configuration.orientation;
        if (i != this.f1310c) {
            this.f1310c = i;
            updateConfiguration(configuration, this.f1308a.getDisplayMetrics());
        }
    }

    public void mo354a(Locale locale) {
        Configuration configuration = this.f1308a.getConfiguration();
        if (!locale.equals(configuration.locale)) {
            configuration.locale = locale;
            this.f1308a.updateConfiguration(configuration, this.f1308a.getDisplayMetrics());
            m2553a();
        }
    }

    protected final void m2554a(long j) {
        this.f1309b.m2561a(j, this.f1308a.getConfiguration().locale);
    }

    public CharSequence getQuantityText(int i, int i2) {
        m2554a((long) i);
        return super.getQuantityText(i, i2);
    }

    public CharSequence getText(int i) {
        m2554a((long) i);
        return super.getText(i);
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        return super.getText(i);
    }

    public CharSequence[] getTextArray(int i) {
        m2554a((long) i);
        return super.getTextArray(i);
    }
}
