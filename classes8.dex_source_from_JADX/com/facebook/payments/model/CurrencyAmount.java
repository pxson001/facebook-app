package com.facebook.payments.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.payments.currency.DefaultCurrencyConfig;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: target_privacy_picker_friend_selected */
public class CurrencyAmount implements Parcelable, Comparable<CurrencyAmount> {
    public static final Creator<CurrencyAmount> CREATOR = new C01831();
    private static final Pattern f1760a = Pattern.compile("([^\\.,]*?)([0-9]*[\\.,]?[0-9]+).*");
    public final String f1761b;
    public final BigDecimal f1762c;

    /* compiled from: target_privacy_picker_friend_selected */
    final class C01831 implements Creator<CurrencyAmount> {
        C01831() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CurrencyAmount(parcel);
        }

        public final Object[] newArray(int i) {
            return new CurrencyAmount[i];
        }
    }

    public int compareTo(Object obj) {
        CurrencyAmount currencyAmount = (CurrencyAmount) obj;
        Preconditions.checkNotNull(currencyAmount);
        Preconditions.checkArgument(this.f1761b.equals(currencyAmount.f1761b), "%s != $s", new Object[]{this.f1761b, currencyAmount.f1761b});
        return this.f1762c.compareTo(currencyAmount.f1762c);
    }

    public CurrencyAmount(String str, BigDecimal bigDecimal) {
        boolean z;
        boolean z2 = true;
        this.f1761b = (String) Preconditions.checkNotNull(str);
        if (str.length() == 3) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid currency length: %s", new Object[]{str});
        if (str.isEmpty()) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f1762c = (BigDecimal) Preconditions.checkNotNull(bigDecimal);
    }

    public CurrencyAmount(Parcel parcel) {
        this(parcel.readString(), (BigDecimal) parcel.readSerializable());
    }

    public final String m1957c() {
        return DefaultCurrencyConfig.a(this.f1761b);
    }

    public String toString() {
        return StringFormatUtil.formatStrLocaleSafe("%s%." + Currency.getInstance(this.f1761b).getDefaultFractionDigits() + "f", m1957c(), Double.valueOf(this.f1762c.doubleValue()));
    }

    @VisibleForTesting
    public static double m1956b(CharSequence charSequence) {
        Matcher matcher = f1760a.matcher(charSequence.toString());
        return matcher.matches() ? Double.parseDouble(matcher.group(2)) : Double.NaN;
    }

    public static BigDecimal m1955a(int i, long j) {
        BigDecimal bigDecimal = new BigDecimal(j);
        double pow = (i <= 1 || i >= 10) ? (double) i : Math.pow(10.0d, (double) i);
        return bigDecimal.divide(new BigDecimal(pow));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CurrencyAmount currencyAmount = (CurrencyAmount) obj;
        if (Objects.equal(this.f1761b, currencyAmount.f1761b) && Objects.equal(this.f1762c, currencyAmount.f1762c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f1761b, this.f1762c});
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1761b);
        parcel.writeSerializable(this.f1762c);
    }

    public CurrencyAmount(String str, long j) {
        this(str, m1955a(Integer.parseInt((String) ((ImmutableMap) DefaultCurrencyConfig.b.get(str)).get("offset")), j));
    }
}
