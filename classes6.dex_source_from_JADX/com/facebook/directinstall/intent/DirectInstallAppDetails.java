package com.facebook.directinstall.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nullable;

/* compiled from: old_review_length */
public class DirectInstallAppDetails implements Parcelable {
    public static final Creator<DirectInstallAppDetails> CREATOR = new C05831();
    @Nullable
    public final String f8799a;
    @Nullable
    public final String f8800b;
    @Nullable
    public final String f8801c;
    @Nullable
    public final String f8802d;
    public final int f8803e;
    public final int f8804f;
    @Nullable
    private final String f8805g;
    @Nullable
    public final String f8806h;
    @Nullable
    public final String f8807i;
    @Nullable
    public final String f8808j;
    @Nullable
    public final TextWithEntities f8809k;
    @Nullable
    private final TextWithEntities f8810l;
    public final ImmutableList<Screenshot> f8811m;
    public final ImmutableList<Screenshot> f8812n;

    /* compiled from: old_review_length */
    final class C05831 implements Creator<DirectInstallAppDetails> {
        C05831() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DirectInstallAppDetails(parcel);
        }

        public final Object[] newArray(int i) {
            return new DirectInstallAppDetails[i];
        }
    }

    /* compiled from: old_review_length */
    public class Builder {
        @Nullable
        public String f8778a = null;
        @Nullable
        public String f8779b = null;
        @Nullable
        public String f8780c = null;
        @Nullable
        public String f8781d = null;
        private int f8782e;
        private int f8783f;
        @Nullable
        public String f8784g = null;
        @Nullable
        public String f8785h = null;
        @Nullable
        public String f8786i = null;
        @Nullable
        public String f8787j = null;
        @Nullable
        public TextWithEntities f8788k = null;
        @Nullable
        public TextWithEntities f8789l = null;
        @Nullable
        public ImmutableList<Screenshot> f8790m;
        @Nullable
        public ImmutableList<Screenshot> f8791n;

        public final DirectInstallAppDetails m12543a() {
            return new DirectInstallAppDetails(this.f8778a, this.f8779b, this.f8780c, this.f8781d, this.f8782e, this.f8783f, this.f8784g, this.f8785h, this.f8786i, this.f8787j, this.f8788k, this.f8789l, this.f8790m == null ? ImmutableList.of() : this.f8790m, this.f8791n == null ? ImmutableList.of() : this.f8791n);
        }
    }

    /* compiled from: old_review_length */
    public class Screenshot implements Parcelable {
        public static final Creator<Screenshot> CREATOR = new C05841();
        public final String f8792a;
        public final int f8793b;
        public final int f8794c;

        /* compiled from: old_review_length */
        final class C05841 implements Creator<Screenshot> {
            C05841() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Screenshot(parcel);
            }

            public final Object[] newArray(int i) {
                return new Screenshot[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f8792a);
            parcel.writeInt(this.f8793b);
            parcel.writeInt(this.f8794c);
        }

        public Screenshot(Parcel parcel) {
            this.f8792a = parcel.readString();
            this.f8793b = parcel.readInt();
            this.f8794c = parcel.readInt();
        }

        public Screenshot(String str, int i, int i2) {
            this.f8792a = str;
            this.f8793b = i;
            this.f8794c = i2;
        }
    }

    /* compiled from: old_review_length */
    public class TextWithEntities implements Parcelable {
        public static final Creator<TextWithEntities> CREATOR = new C05851();
        public String f8797a;
        public ArrayList<Entity> f8798b = new ArrayList();

        /* compiled from: old_review_length */
        final class C05851 implements Creator<TextWithEntities> {
            C05851() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new TextWithEntities(parcel);
            }

            public final Object[] newArray(int i) {
                return new TextWithEntities[i];
            }
        }

        /* compiled from: old_review_length */
        public class Entity implements Parcelable {
            public static final Creator<Entity> CREATOR = new C05861();
            private String f8795a;
            public String f8796b;

            /* compiled from: old_review_length */
            final class C05861 implements Creator<Entity> {
                C05861() {
                }

                public final Object createFromParcel(Parcel parcel) {
                    return new Entity(parcel);
                }

                public final Object[] newArray(int i) {
                    return new Entity[i];
                }
            }

            public Entity(String str, String str2) {
                this.f8795a = str;
                this.f8796b = str2;
            }

            public Entity(Parcel parcel) {
                this.f8795a = parcel.readString();
                this.f8796b = parcel.readString();
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(this.f8795a);
                parcel.writeString(this.f8796b);
            }
        }

        public TextWithEntities(String str) {
            this.f8797a = str;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f8797a);
            parcel.writeList(this.f8798b);
        }

        public TextWithEntities(Parcel parcel) {
            this.f8797a = parcel.readString();
            parcel.readList(this.f8798b, Entity.class.getClassLoader());
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8799a);
        parcel.writeString(this.f8800b);
        parcel.writeString(this.f8801c);
        parcel.writeString(this.f8802d);
        parcel.writeInt(this.f8803e);
        parcel.writeInt(this.f8804f);
        parcel.writeString(this.f8805g);
        parcel.writeString(this.f8806h);
        parcel.writeString(this.f8807i);
        parcel.writeString(this.f8808j);
        parcel.writeParcelable(this.f8809k, 0);
        parcel.writeParcelable(this.f8810l, 0);
        parcel.writeList(this.f8811m);
        parcel.writeList(this.f8812n);
    }

    private DirectInstallAppDetails(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i, int i2, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable TextWithEntities textWithEntities, @Nullable TextWithEntities textWithEntities2, ImmutableList<Screenshot> immutableList, ImmutableList<Screenshot> immutableList2) {
        this.f8799a = str;
        this.f8800b = str2;
        this.f8801c = str3;
        this.f8802d = str4;
        this.f8803e = i;
        this.f8804f = i2;
        this.f8805g = str5;
        this.f8806h = str6;
        this.f8807i = str7;
        this.f8808j = str8;
        this.f8809k = textWithEntities;
        this.f8810l = textWithEntities2;
        this.f8811m = immutableList;
        this.f8812n = immutableList2;
    }

    public DirectInstallAppDetails(Parcel parcel) {
        this.f8799a = parcel.readString();
        this.f8800b = parcel.readString();
        this.f8801c = parcel.readString();
        this.f8802d = parcel.readString();
        this.f8803e = parcel.readInt();
        this.f8804f = parcel.readInt();
        this.f8805g = parcel.readString();
        this.f8806h = parcel.readString();
        this.f8807i = parcel.readString();
        this.f8808j = parcel.readString();
        this.f8809k = (TextWithEntities) parcel.readParcelable(TextWithEntities.class.getClassLoader());
        this.f8810l = (TextWithEntities) parcel.readParcelable(TextWithEntities.class.getClassLoader());
        Collection arrayList = new ArrayList();
        parcel.readList(arrayList, Screenshot.class.getClassLoader());
        this.f8811m = ImmutableList.copyOf(arrayList);
        arrayList = new ArrayList();
        parcel.readList(arrayList, Screenshot.class.getClassLoader());
        this.f8812n = ImmutableList.copyOf(arrayList);
    }

    public final String m12544a() {
        return this.f8799a;
    }

    public final String m12545b() {
        return this.f8800b;
    }

    public final String m12546c() {
        return this.f8801c;
    }

    public final String m12547d() {
        return this.f8802d;
    }

    @Nullable
    public final String m12548g() {
        return this.f8805g;
    }

    @Nullable
    public final String m12549h() {
        return this.f8806h;
    }

    public final String m12550i() {
        return this.f8807i;
    }

    public final String m12551j() {
        return this.f8808j;
    }
}
