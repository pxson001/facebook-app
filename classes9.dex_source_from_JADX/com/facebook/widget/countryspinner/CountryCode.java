package com.facebook.widget.countryspinner;

import com.google.common.base.Objects;
import java.text.CollationKey;
import java.text.Collator;

/* compiled from: sharer?u={share_link}&app_id={#app_id 0}&in_app={in_app false} */
public class CountryCode implements Comparable<CountryCode> {
    private static final Collator f3546d = Collator.getInstance();
    public final String f3547a;
    public final String f3548b;
    public final String f3549c;
    private final CollationKey f3550e = f3546d.getCollationKey(toString());

    public int compareTo(Object obj) {
        return this.f3550e.compareTo(((CountryCode) obj).f3550e);
    }

    public CountryCode(String str, String str2, String str3) {
        this.f3547a = str;
        this.f3548b = str2;
        this.f3549c = str3;
    }

    public String toString() {
        return this.f3549c + " (" + this.f3548b + ")";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equal(this.f3550e, ((CountryCode) obj).f3550e);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f3550e});
    }
}
