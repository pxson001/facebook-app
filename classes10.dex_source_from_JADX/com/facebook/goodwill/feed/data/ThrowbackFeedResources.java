package com.facebook.goodwill.feed.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLModels.ThrowbackFeedFragmentModel.ThemeModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: Video is too large to send. */
public class ThrowbackFeedResources implements Parcelable {
    public static final Creator<ThrowbackFeedResources> CREATOR = new C30021();
    public final long f21083a;
    public final DefaultImageFields f21084b;
    public final ThemeModel f21085c;
    public final DefaultImageFields f21086d;
    public final String f21087e;
    public final DefaultImageFields f21088f;
    public final String f21089g;
    public final String f21090h;
    public final String f21091i;
    public final String f21092j;
    public final String f21093k;
    public final String f21094l;
    public final ImmutableList<String> f21095m;
    public final String f21096n;
    public final DefaultImageFields f21097o;
    public final String f21098p;
    public final DefaultImageFields f21099q;

    /* compiled from: Video is too large to send. */
    final class C30021 implements Creator<ThrowbackFeedResources> {
        C30021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThrowbackFeedResources(parcel);
        }

        public final Object[] newArray(int i) {
            return new ThrowbackFeedResources[i];
        }
    }

    public ThrowbackFeedResources(long j, DefaultImageFields defaultImageFields, ThemeModel themeModel, DefaultImageFields defaultImageFields2, String str, DefaultImageFields defaultImageFields3, String str2, String str3, String str4, String str5, String str6, String str7, ImmutableList<String> immutableList, String str8, DefaultImageFields defaultImageFields4, String str9, DefaultImageFields defaultImageFields5) {
        this.f21083a = j;
        this.f21084b = defaultImageFields;
        this.f21085c = themeModel;
        this.f21086d = defaultImageFields2;
        this.f21087e = str;
        this.f21088f = defaultImageFields3;
        this.f21089g = str2;
        this.f21090h = str3;
        this.f21091i = str4;
        this.f21092j = str5;
        this.f21093k = str6;
        this.f21094l = str7;
        this.f21095m = immutableList;
        this.f21096n = str8;
        this.f21097o = defaultImageFields4;
        this.f21098p = str9;
        this.f21099q = defaultImageFields5;
    }

    public ThrowbackFeedResources(Parcel parcel) {
        this.f21083a = parcel.readLong();
        this.f21084b = (DefaultImageFields) FlatBufferModelHelper.a(parcel);
        this.f21085c = (ThemeModel) FlatBufferModelHelper.a(parcel);
        this.f21086d = (DefaultImageFields) FlatBufferModelHelper.a(parcel);
        this.f21087e = parcel.readString();
        this.f21088f = (DefaultImageFields) FlatBufferModelHelper.a(parcel);
        this.f21089g = parcel.readString();
        this.f21090h = parcel.readString();
        this.f21091i = parcel.readString();
        this.f21092j = parcel.readString();
        this.f21093k = parcel.readString();
        this.f21094l = parcel.readString();
        Collection arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.f21095m = ImmutableList.copyOf(arrayList);
        this.f21096n = parcel.readString();
        this.f21097o = (DefaultImageFields) FlatBufferModelHelper.a(parcel);
        this.f21098p = parcel.readString();
        this.f21099q = (DefaultImageFields) FlatBufferModelHelper.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f21083a);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f21084b);
        FlatBufferModelHelper.a(parcel, this.f21085c);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f21086d);
        parcel.writeString(this.f21087e);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f21088f);
        parcel.writeString(this.f21089g);
        parcel.writeString(this.f21090h);
        parcel.writeString(this.f21091i);
        parcel.writeString(this.f21092j);
        parcel.writeString(this.f21093k);
        parcel.writeString(this.f21094l);
        parcel.writeStringList(this.f21095m);
        parcel.writeString(this.f21096n);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f21097o);
        parcel.writeString(this.f21098p);
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f21099q);
    }
}
