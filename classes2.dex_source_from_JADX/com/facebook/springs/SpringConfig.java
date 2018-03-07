package com.facebook.springs;

/* compiled from: sponsored_full_view_logging_enabled */
public class SpringConfig {
    public double f4245a;
    public double f4246b;

    public static SpringConfig m7842a(double d, double d2) {
        return new SpringConfig(((d - 30.0d) * 3.62d) + 194.0d, QcValueConverter.m11554b(d2));
    }

    public static SpringConfig m7843b(double d, double d2) {
        Bouncy3Conversion bouncy3Conversion = new Bouncy3Conversion(d, d2);
        return m7842a(bouncy3Conversion.f6961b, bouncy3Conversion.f6962c);
    }

    public SpringConfig(double d, double d2) {
        this.f4246b = d;
        this.f4245a = d2;
    }
}
