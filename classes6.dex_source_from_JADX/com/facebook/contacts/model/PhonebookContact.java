package com.facebook.contacts.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: passenger_infos */
public class PhonebookContact implements Parcelable {
    public static final Creator<PhonebookContact> CREATOR = new C05121();
    public final String f8289a;
    public final String f8290b;
    public final String f8291c;
    public final String f8292d;
    public final String f8293e;
    public final String f8294f;
    public final String f8295g;
    public final String f8296h;
    public final String f8297i;
    public final String f8298j;
    public final boolean f8299k;
    public final boolean f8300l;
    public final ImmutableList<PhonebookPhoneNumber> f8301m;
    public final ImmutableList<PhonebookEmailAddress> f8302n;
    public final ImmutableList<PhonebookInstantMessaging> f8303o;
    public final ImmutableList<PhonebookNickname> f8304p;
    public final ImmutableList<PhonebookAddress> f8305q;
    public final ImmutableList<PhonebookWebsite> f8306r;
    public final ImmutableList<PhonebookRelation> f8307s;
    public final ImmutableList<PhonebookOrganization> f8308t;
    public final ImmutableList<PhonebookEvent> f8309u;
    public final ImmutableList<PhonebookContactMetadata> f8310v;
    public final ImmutableList<PhonebookWhatsappProfile> f8311w;

    /* compiled from: passenger_infos */
    final class C05121 implements Creator<PhonebookContact> {
        C05121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhonebookContact(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhonebookContact[i];
        }
    }

    /* compiled from: passenger_infos */
    final class C05132 implements Comparator {
        C05132() {
        }

        public final int compare(Object obj, Object obj2) {
            return obj.hashCode() - obj2.hashCode();
        }
    }

    /* compiled from: passenger_infos */
    public class Builder {
        public final String f8266a;
        public String f8267b;
        public String f8268c;
        public String f8269d;
        public String f8270e;
        public String f8271f;
        public String f8272g;
        public String f8273h;
        public String f8274i;
        public String f8275j;
        public boolean f8276k;
        public boolean f8277l;
        public final Set<PhonebookPhoneNumber> f8278m = new HashSet();
        public final Set<PhonebookEmailAddress> f8279n = new HashSet();
        public final Set<PhonebookInstantMessaging> f8280o = new HashSet();
        public final Set<PhonebookNickname> f8281p = new HashSet();
        public final Set<PhonebookAddress> f8282q = new HashSet();
        public final Set<PhonebookWebsite> f8283r = new HashSet();
        public final Set<PhonebookRelation> f8284s = new HashSet();
        public final Set<PhonebookOrganization> f8285t = new HashSet();
        public final Set<PhonebookEvent> f8286u = new HashSet();
        public final Set<PhonebookContactMetadata> f8287v = new HashSet();
        public final Set<PhonebookWhatsappProfile> f8288w = new HashSet();

        public Builder(String str) {
            this.f8266a = str;
        }

        public final Builder m12104a(String str) {
            this.f8267b = str;
            return this;
        }

        public final Builder m12103a(PhonebookPhoneNumber phonebookPhoneNumber) {
            if (phonebookPhoneNumber != null) {
                this.f8278m.add(phonebookPhoneNumber);
            }
            return this;
        }

        public final Builder m12102a(PhonebookEmailAddress phonebookEmailAddress) {
            if (phonebookEmailAddress != null) {
                this.f8279n.add(phonebookEmailAddress);
            }
            return this;
        }

        public final PhonebookContact m12105c() {
            return new PhonebookContact(this);
        }
    }

    public PhonebookContact(Builder builder) {
        this.f8289a = builder.f8266a;
        this.f8290b = builder.f8267b;
        this.f8291c = builder.f8268c;
        this.f8292d = builder.f8269d;
        this.f8293e = builder.f8270e;
        this.f8294f = builder.f8271f;
        this.f8295g = builder.f8272g;
        this.f8296h = builder.f8273h;
        this.f8297i = builder.f8274i;
        this.f8298j = builder.f8275j;
        this.f8299k = builder.f8276k;
        this.f8300l = builder.f8277l;
        this.f8301m = ImmutableList.copyOf(builder.f8278m);
        this.f8302n = ImmutableList.copyOf(builder.f8279n);
        this.f8303o = ImmutableList.copyOf(builder.f8280o);
        this.f8304p = ImmutableList.copyOf(builder.f8281p);
        this.f8305q = ImmutableList.copyOf(builder.f8282q);
        this.f8306r = ImmutableList.copyOf(builder.f8283r);
        this.f8307s = ImmutableList.copyOf(builder.f8284s);
        this.f8308t = ImmutableList.copyOf(builder.f8285t);
        this.f8309u = ImmutableList.copyOf(builder.f8286u);
        this.f8310v = ImmutableList.copyOf(builder.f8287v);
        this.f8311w = ImmutableList.copyOf(builder.f8288w);
    }

    public PhonebookContact(Parcel parcel) {
        ImmutableList immutableList;
        this.f8289a = parcel.readString();
        this.f8290b = parcel.readString();
        this.f8291c = parcel.readString();
        this.f8292d = parcel.readString();
        this.f8293e = parcel.readString();
        this.f8294f = parcel.readString();
        this.f8295g = parcel.readString();
        this.f8296h = parcel.readString();
        this.f8297i = parcel.readString();
        this.f8298j = parcel.readString();
        this.f8299k = ParcelUtil.a(parcel);
        this.f8300l = ParcelUtil.a(parcel);
        Collection readArrayList = parcel.readArrayList(PhonebookPhoneNumber.class.getClassLoader());
        if (readArrayList == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList);
        }
        this.f8301m = immutableList;
        Collection readArrayList2 = parcel.readArrayList(PhonebookEmailAddress.class.getClassLoader());
        if (readArrayList2 == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList2);
        }
        this.f8302n = immutableList;
        readArrayList2 = parcel.readArrayList(PhonebookInstantMessaging.class.getClassLoader());
        if (readArrayList2 == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList2);
        }
        this.f8303o = immutableList;
        readArrayList2 = parcel.readArrayList(PhonebookNickname.class.getClassLoader());
        if (readArrayList2 == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList2);
        }
        this.f8304p = immutableList;
        readArrayList2 = parcel.readArrayList(PhonebookAddress.class.getClassLoader());
        if (readArrayList2 == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList2);
        }
        this.f8305q = immutableList;
        readArrayList2 = parcel.readArrayList(PhonebookWebsite.class.getClassLoader());
        if (readArrayList2 == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList2);
        }
        this.f8306r = immutableList;
        readArrayList2 = parcel.readArrayList(PhonebookRelation.class.getClassLoader());
        if (readArrayList == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList2);
        }
        this.f8307s = immutableList;
        readArrayList2 = parcel.readArrayList(PhonebookOrganization.class.getClassLoader());
        if (readArrayList2 == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList2);
        }
        this.f8308t = immutableList;
        readArrayList2 = parcel.readArrayList(PhonebookEvent.class.getClassLoader());
        if (readArrayList2 == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList2);
        }
        this.f8309u = immutableList;
        readArrayList2 = parcel.readArrayList(PhonebookContactMetadata.class.getClassLoader());
        if (readArrayList2 == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList2);
        }
        this.f8310v = immutableList;
        readArrayList2 = parcel.readArrayList(PhonebookWhatsappProfile.class.getClassLoader());
        if (readArrayList2 == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList2);
        }
        this.f8311w = immutableList;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8289a);
        parcel.writeString(this.f8290b);
        parcel.writeString(this.f8291c);
        parcel.writeString(this.f8292d);
        parcel.writeString(this.f8293e);
        parcel.writeString(this.f8294f);
        parcel.writeString(this.f8295g);
        parcel.writeString(this.f8296h);
        parcel.writeString(this.f8297i);
        parcel.writeString(this.f8298j);
        ParcelUtil.a(parcel, this.f8299k);
        ParcelUtil.a(parcel, this.f8300l);
        parcel.writeList(this.f8301m);
        parcel.writeList(this.f8302n);
        parcel.writeList(this.f8303o);
        parcel.writeList(this.f8304p);
        parcel.writeList(this.f8305q);
        parcel.writeList(this.f8306r);
        parcel.writeList(this.f8307s);
        parcel.writeList(this.f8308t);
        parcel.writeList(this.f8309u);
        parcel.writeList(this.f8310v);
        parcel.writeList(this.f8311w);
    }

    public final String m12107a() {
        return this.f8289a;
    }

    public final boolean m12108b() {
        PhonebookContactMetadata phonebookContactMetadata = (PhonebookContactMetadata) Iterables.a(this.f8310v, null);
        return phonebookContactMetadata != null && phonebookContactMetadata.f8319h;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f8289a, this.f8290b, this.f8291c, this.f8292d, this.f8293e, this.f8294f, this.f8295g, this.f8296h, this.f8297i, this.f8298j, Boolean.valueOf(this.f8299k), Boolean.valueOf(this.f8300l), m12106a(this.f8301m), m12106a(this.f8302n), m12106a(this.f8303o), m12106a(this.f8304p), m12106a(this.f8305q), m12106a(this.f8306r), m12106a(this.f8307s), m12106a(this.f8308t), m12106a(this.f8309u), m12106a(this.f8310v), m12106a(this.f8311w)});
    }

    private static ImmutableList m12106a(List list) {
        Collection arrayList = new ArrayList(list);
        Collections.sort(arrayList, new C05132());
        return ImmutableList.copyOf(arrayList);
    }
}
