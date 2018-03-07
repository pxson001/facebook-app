package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;

@GwtCompatible
/* compiled from: bug_report_attachment_failed_to_upload */
public final class DoubleMath {
    @VisibleForTesting
    static final double[] f7652a = new double[]{1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};
    private static final double f7653b = Math.log(2.0d);

    public static boolean m13818a(double d, double d2, double d3) {
        MathPreconditions.a("tolerance", d3);
        return Math.copySign(d - d2, 1.0d) <= d3 || d == d2 || (Double.isNaN(d) && Double.isNaN(d2));
    }

    private DoubleMath() {
    }
}
