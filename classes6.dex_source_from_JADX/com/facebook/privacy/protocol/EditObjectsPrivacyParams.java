package com.facebook.privacy.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.enums.GraphQLEditablePrivacyScopeType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Locale;

/* compiled from: sticker_store_opened */
public class EditObjectsPrivacyParams implements Parcelable {
    public static final Creator<EditObjectsPrivacyParams> CREATOR = new C02301();
    public final String f4131a;
    public ImmutableList<ObjectPrivacyEdit> f4132b;

    /* compiled from: sticker_store_opened */
    final class C02301 implements Creator<EditObjectsPrivacyParams> {
        C02301() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditObjectsPrivacyParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditObjectsPrivacyParams[i];
        }
    }

    /* compiled from: sticker_store_opened */
    public class ObjectPrivacyEdit implements Parcelable {
        public static final Creator<ObjectPrivacyEdit> CREATOR = new C02311();
        public String f4127a;
        public long f4128b;
        public GraphQLEditablePrivacyScopeType f4129c;
        public String f4130d;

        /* compiled from: sticker_store_opened */
        final class C02311 implements Creator<ObjectPrivacyEdit> {
            C02311() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new ObjectPrivacyEdit(parcel);
            }

            public final Object[] newArray(int i) {
                return new ObjectPrivacyEdit[i];
            }
        }

        public ObjectPrivacyEdit(String str, long j, GraphQLEditablePrivacyScopeType graphQLEditablePrivacyScopeType, String str2) {
            this.f4127a = str;
            this.f4128b = j;
            this.f4129c = graphQLEditablePrivacyScopeType;
            this.f4130d = str2;
        }

        public ObjectPrivacyEdit(Parcel parcel) {
            this.f4127a = parcel.readString();
            this.f4128b = parcel.readLong();
            this.f4129c = GraphQLEditablePrivacyScopeType.valueOf(parcel.readString().toUpperCase(Locale.US));
            this.f4130d = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f4127a);
            parcel.writeLong(this.f4128b);
            parcel.writeString(this.f4129c.toString());
            parcel.writeString(this.f4130d);
        }

        public int describeContents() {
            return 0;
        }
    }

    public EditObjectsPrivacyParams(String str, ImmutableList<ObjectPrivacyEdit> immutableList) {
        this.f4131a = str;
        this.f4132b = immutableList;
    }

    public EditObjectsPrivacyParams(Parcel parcel) {
        this.f4131a = parcel.readString();
        int readInt = parcel.readInt();
        Builder builder = new Builder();
        for (int i = 0; i < readInt; i++) {
            builder.c((ObjectPrivacyEdit) parcel.readParcelable(ObjectPrivacyEdit.class.getClassLoader()));
        }
        this.f4132b = builder.b();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4131a);
        parcel.writeInt(this.f4132b.size());
        int size = this.f4132b.size();
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeParcelable((ObjectPrivacyEdit) this.f4132b.get(i2), i);
        }
    }

    public int describeContents() {
        return 0;
    }
}
