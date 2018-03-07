package com.facebook.events.model;

import android.net.Uri;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.google.common.base.Objects;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import javax.annotation.Nonnull;

/* compiled from: syncApiVersion */
public class EventTicketInfo {
    public final String f2723a;
    private final Clock f2724b;
    public final Price f2725c;
    public final Price f2726d;
    public final boolean f2727e;
    public final boolean f2728f;
    public final long f2729g;
    public final boolean f2730h;
    public final boolean f2731i;
    public final boolean f2732j;
    public final String f2733k;
    public final Uri f2734l;
    private final Uri f2735m;

    /* compiled from: syncApiVersion */
    public class Builder {
        public Clock f2707a;
        public Price f2708b;
        public Price f2709c;
        public boolean f2710d;
        public boolean f2711e;
        public long f2712f;
        public boolean f2713g;
        public boolean f2714h;
        public boolean f2715i;
        public String f2716j;
        public Uri f2717k;
        public Uri f2718l;
        public String f2719m;

        public final EventTicketInfo m3010a() {
            return new EventTicketInfo(this.f2707a, this.f2719m, this.f2708b, this.f2709c, this.f2710d, this.f2711e, this.f2712f, this.f2713g, this.f2714h, this.f2715i, this.f2716j, this.f2717k, this.f2718l);
        }
    }

    /* compiled from: syncApiVersion */
    public class Price implements Comparable<Price> {
        public static final Price f2720a = new Price(-1, "USD");
        @Nonnull
        public final BigDecimal f2721b;
        public final Currency f2722c;

        public /* synthetic */ int compareTo(Object obj) {
            return m3013b((Price) obj);
        }

        private Price(int i, @Nonnull String str) {
            this.f2721b = BigDecimal.valueOf((long) i);
            this.f2722c = Currency.getInstance(str);
        }

        public Price(int i, int i2, @Nonnull String str) {
            this.f2721b = BigDecimal.valueOf((long) i).divide(BigDecimal.valueOf((long) i2));
            this.f2722c = Currency.getInstance(str);
        }

        public static boolean m3011a(Price price) {
            return price != null && price.f2721b.compareTo(BigDecimal.ZERO) >= 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Price)) {
                return false;
            }
            Price price = (Price) obj;
            if (Objects.equal(this.f2721b, price.f2721b) && Objects.equal(this.f2722c, price.f2722c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.f2721b, this.f2722c});
        }

        public final String m3012a() {
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.getDefault());
            currencyInstance.setCurrency(this.f2722c);
            currencyInstance.setMaximumFractionDigits(0);
            currencyInstance.setMinimumFractionDigits(0);
            return currencyInstance.format(this.f2721b);
        }

        public final int m3013b(Price price) {
            return this.f2721b.compareTo(price.f2721b);
        }
    }

    public EventTicketInfo(Clock clock, String str, Price price, Price price2, boolean z, boolean z2, long j, boolean z3, boolean z4, boolean z5, String str2, Uri uri, Uri uri2) {
        this.f2723a = str;
        if (clock == null) {
            clock = SystemClock.b();
        }
        this.f2724b = clock;
        this.f2725c = price;
        this.f2726d = price2;
        this.f2727e = z;
        this.f2728f = z2;
        this.f2729g = j;
        this.f2730h = z3;
        this.f2731i = z4;
        this.f2732j = z5;
        this.f2733k = str2;
        this.f2734l = uri;
        this.f2735m = uri2;
    }

    public final boolean m3014f() {
        return this.f2724b.a() < this.f2729g;
    }

    public final boolean m3015m() {
        return Price.m3011a(this.f2725c);
    }

    public final boolean m3016n() {
        return Price.m3011a(this.f2726d);
    }

    public final boolean m3017o() {
        return m3015m() && m3016n() && this.f2725c.equals(this.f2726d);
    }

    public final boolean m3018p() {
        if (this.f2727e || this.f2728f) {
            return true;
        }
        if (!Price.m3011a(this.f2725c)) {
            return false;
        }
        if (Price.m3011a(this.f2725c) && Price.m3011a(this.f2726d) && !this.f2725c.f2722c.equals(this.f2726d.f2722c)) {
            return false;
        }
        Object obj;
        if (this.f2725c.f2721b.compareTo(BigDecimal.ZERO) == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            if (!Price.m3011a(this.f2726d)) {
                return false;
            }
            obj = 1;
            if (this.f2726d.f2721b.compareTo(BigDecimal.ZERO) != 1) {
                obj = null;
            }
            if (obj != null) {
                return true;
            }
            return false;
        } else if (!Price.m3011a(this.f2726d) || this.f2726d.m3013b(this.f2725c) >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
