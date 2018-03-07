package com.facebook.entitycards.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;

/* compiled from: image_fbid */
public class EntityCardsParameters implements Parcelable {
    public static final Creator<EntityCardsParameters> CREATOR = new C11851();
    public final String f11005a;
    public final Optional<String> f11006b;
    public final ImmutableList<String> f11007c;
    public final String f11008d;
    public final String f11009e;
    public final String f11010f;

    /* compiled from: image_fbid */
    final class C11851 implements Creator<EntityCardsParameters> {
        C11851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EntityCardsParameters(parcel);
        }

        public final Object[] newArray(int i) {
            return new EntityCardsParameters[i];
        }
    }

    public EntityCardsParameters(String str, Optional<String> optional, ImmutableList<String> immutableList, String str2, String str3, @Nullable String str4) {
        this.f11005a = str;
        this.f11006b = optional;
        this.f11007c = immutableList;
        this.f11008d = str2;
        this.f11009e = str3;
        this.f11010f = str4;
        m12943a();
    }

    public EntityCardsParameters(Parcel parcel) {
        this.f11005a = parcel.readString();
        this.f11006b = Optional.fromNullable(parcel.readString());
        this.f11007c = ImmutableList.copyOf(parcel.createStringArrayList());
        this.f11008d = parcel.readString();
        this.f11009e = parcel.readString();
        this.f11010f = parcel.readString();
        m12943a();
    }

    private void m12943a() {
        ImmutableSet b = ImmutableSet.builder().b(this.f11007c).b();
        Preconditions.checkArgument(b.size() == this.f11007c.size(), "Duplicate entity IDs are not supported");
        Preconditions.checkArgument(b.contains(this.f11008d), "initialEntityId must be in initialEntityIds");
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11005a);
        parcel.writeString((String) this.f11006b.orNull());
        parcel.writeStringList(Lists.a(this.f11007c));
        parcel.writeString(this.f11008d);
        parcel.writeString(this.f11009e);
        parcel.writeString(this.f11010f);
    }
}
