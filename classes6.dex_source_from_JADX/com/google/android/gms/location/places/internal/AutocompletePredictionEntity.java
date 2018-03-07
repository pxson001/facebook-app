package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

public class AutocompletePredictionEntity implements SafeParcelable, AutocompletePrediction {
    public static final Creator<AutocompletePredictionEntity> CREATOR = new zza();
    private static final List<SubstringEntity> f6487k = Collections.emptyList();
    public final int f6488a;
    public final String f6489b;
    public final String f6490c;
    public final List<Integer> f6491d;
    public final List<SubstringEntity> f6492e;
    public final int f6493f;
    public final String f6494g;
    public final List<SubstringEntity> f6495h;
    public final String f6496i;
    public final List<SubstringEntity> f6497j;

    public class SubstringEntity implements SafeParcelable {
        public static final Creator<SubstringEntity> CREATOR = new zzv();
        public final int f6484a;
        public final int f6485b;
        public final int f6486c;

        public SubstringEntity(int i, int i2, int i3) {
            this.f6484a = i;
            this.f6485b = i2;
            this.f6486c = i3;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubstringEntity)) {
                return false;
            }
            SubstringEntity substringEntity = (SubstringEntity) obj;
            return zzw.a(Integer.valueOf(this.f6485b), Integer.valueOf(substringEntity.f6485b)) && zzw.a(Integer.valueOf(this.f6486c), Integer.valueOf(substringEntity.f6486c));
        }

        public int hashCode() {
            return zzw.a(new Object[]{Integer.valueOf(this.f6485b), Integer.valueOf(this.f6486c)});
        }

        public String toString() {
            return zzw.a(this).a("offset", Integer.valueOf(this.f6485b)).a("length", Integer.valueOf(this.f6486c)).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int a = zzb.a(parcel);
            zzb.a(parcel, 1, this.f6485b);
            zzb.a(parcel, 1000, this.f6484a);
            zzb.a(parcel, 2, this.f6486c);
            zzb.c(parcel, a);
        }
    }

    AutocompletePredictionEntity(int i, String str, List<Integer> list, int i2, String str2, List<SubstringEntity> list2, String str3, List<SubstringEntity> list3, String str4, List<SubstringEntity> list4) {
        this.f6488a = i;
        this.f6490c = str;
        this.f6491d = list;
        this.f6493f = i2;
        this.f6489b = str2;
        this.f6492e = list2;
        this.f6494g = str3;
        this.f6495h = list3;
        this.f6496i = str4;
        this.f6497j = list4;
    }

    public static AutocompletePredictionEntity m8974a(String str, List<Integer> list, int i, String str2, List<SubstringEntity> list2, String str3, List<SubstringEntity> list3, String str4, List<SubstringEntity> list4) {
        return new AutocompletePredictionEntity(0, str, list, i, (String) zzx.a(str2), list2, str3, list3, str4, list4);
    }

    public final CharSequence mo488a(CharacterStyle characterStyle) {
        return zzc.m9017a(this.f6494g, this.f6495h, characterStyle);
    }

    public final Object m8976a() {
        return this;
    }

    public final CharSequence mo489b(CharacterStyle characterStyle) {
        return zzc.m9017a(this.f6496i, this.f6497j, characterStyle);
    }

    public final String mo490b() {
        return this.f6490c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompletePredictionEntity)) {
            return false;
        }
        AutocompletePredictionEntity autocompletePredictionEntity = (AutocompletePredictionEntity) obj;
        return zzw.a(this.f6490c, autocompletePredictionEntity.f6490c) && zzw.a(this.f6491d, autocompletePredictionEntity.f6491d) && zzw.a(Integer.valueOf(this.f6493f), Integer.valueOf(autocompletePredictionEntity.f6493f)) && zzw.a(this.f6489b, autocompletePredictionEntity.f6489b) && zzw.a(this.f6492e, autocompletePredictionEntity.f6492e) && zzw.a(this.f6494g, autocompletePredictionEntity.f6494g) && zzw.a(this.f6495h, autocompletePredictionEntity.f6495h) && zzw.a(this.f6496i, autocompletePredictionEntity.f6496i) && zzw.a(this.f6497j, autocompletePredictionEntity.f6497j);
    }

    public int hashCode() {
        return zzw.a(new Object[]{this.f6490c, this.f6491d, Integer.valueOf(this.f6493f), this.f6489b, this.f6492e, this.f6494g, this.f6495h, this.f6496i, this.f6497j});
    }

    public String toString() {
        return zzw.a(this).a("placeId", this.f6490c).a("placeTypes", this.f6491d).a("fullText", this.f6489b).a("fullTextMatchedSubstrings", this.f6492e).a("primaryText", this.f6494g).a("primaryTextMatchedSubstrings", this.f6495h).a("secondaryText", this.f6496i).a("secondaryTextMatchedSubstrings", this.f6497j).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6489b, false);
        zzb.a(parcel, 1000, this.f6488a);
        zzb.a(parcel, 2, this.f6490c, false);
        zzb.a(parcel, 3, this.f6491d, false);
        zzb.c(parcel, 4, this.f6492e, false);
        zzb.a(parcel, 5, this.f6493f);
        zzb.a(parcel, 6, this.f6494g, false);
        zzb.c(parcel, 7, this.f6495h, false);
        zzb.a(parcel, 8, this.f6496i, false);
        zzb.c(parcel, 9, this.f6497j, false);
        zzb.c(parcel, a);
    }
}
