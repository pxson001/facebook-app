package com.facebook.interstitial.manager;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.HashCodeUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TOPIC_DIALOG */
public class InterstitialTriggerContext implements Parcelable {
    public static final Creator<InterstitialTriggerContext> CREATOR = new C13221();
    public final ImmutableMap<String, String> f13876a;

    /* compiled from: TOPIC_DIALOG */
    final class C13221 implements Creator<InterstitialTriggerContext> {
        C13221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new InterstitialTriggerContext(parcel);
        }

        public final Object[] newArray(int i) {
            return new InterstitialTriggerContext[i];
        }
    }

    public InterstitialTriggerContext() {
        this.f13876a = RegularImmutableBiMap.a;
    }

    public InterstitialTriggerContext(Map<String, String> map) {
        this.f13876a = ImmutableMap.copyOf(map);
    }

    public InterstitialTriggerContext(Parcel parcel) {
        this.f13876a = ImmutableMap.copyOf(parcel.readHashMap(HashMap.class.getClassLoader()));
    }

    public final ImmutableSet<String> m23252a() {
        return this.f13876a.keySet();
    }

    public final String m23253a(String str) {
        return (String) this.f13876a.get(str);
    }

    public final ImmutableMap<String, String> m23254b() {
        return this.f13876a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f13876a);
    }

    public String toString() {
        return this.f13876a.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof InterstitialTriggerContext) {
            InterstitialTriggerContext interstitialTriggerContext = (InterstitialTriggerContext) obj;
            if (this.f13876a != null && this.f13876a.equals(interstitialTriggerContext.f13876a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return HashCodeUtil.a(this.f13876a);
    }
}
