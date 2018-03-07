package com.facebook.events.tickets.modal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.LinkableTextWithEntitiesModel;
import javax.annotation.Nullable;

/* compiled from: args_button */
public class EventBuyTicketsModel implements Parcelable {
    public static final Creator<EventBuyTicketsModel> CREATOR = new C27221();
    @Nullable
    public final String f19208A;
    @Nullable
    public final LinkableTextWithEntitiesModel f19209B;
    public final State f19210C;
    public final String f19211a;
    public final String f19212b;
    public final String f19213c;
    public final int f19214d;
    public final int f19215e;
    public final String f19216f;
    public final int f19217g;
    public final String f19218h;
    public final String f19219i;
    public final Uri f19220j;
    @Nullable
    public final LinkableTextWithEntitiesModel f19221k;
    @Nullable
    public final LinkableTextWithEntitiesModel f19222l;
    @Nullable
    public final LinkableTextWithEntitiesModel f19223m;
    public final String f19224n;
    public final String f19225o;
    public final String f19226p;
    public final String f19227q;
    public final String f19228r;
    public final GraphQLEventWatchStatus f19229s;
    public final String f19230t;
    public final String f19231u;
    public final int f19232v;
    public final String f19233w;
    public final String f19234x;
    public final boolean f19235y;
    @Nullable
    public final String f19236z;

    /* compiled from: args_button */
    final class C27221 implements Creator<EventBuyTicketsModel> {
        C27221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventBuyTicketsModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventBuyTicketsModel[i];
        }
    }

    /* compiled from: args_button */
    public interface Mutator {
        Mutator mo863a(int i);

        Mutator mo864a(State state);

        Mutator mo865a(LinkableTextWithEntitiesModel linkableTextWithEntitiesModel);

        Mutator mo866a(String str);

        Mutator mo867a(boolean z);

        EventBuyTicketsModel mo868a();

        Mutator mo869b(String str);

        Mutator mo870c(String str);

        Mutator mo871d(String str);

        Mutator mo872e(String str);

        Mutator mo873f(String str);

        Mutator mo874g(String str);
    }

    /* compiled from: args_button */
    public enum State {
        FETCH,
        SELECT,
        CHECKOUT,
        BUYING,
        BOUGHT,
        ERROR
    }

    public EventBuyTicketsModel(String str, String str2, String str3, int i, int i2, String str4, int i3, String str5, String str6, Uri uri, LinkableTextWithEntitiesModel linkableTextWithEntitiesModel, LinkableTextWithEntitiesModel linkableTextWithEntitiesModel2, LinkableTextWithEntitiesModel linkableTextWithEntitiesModel3, String str7, String str8, String str9, String str10, String str11, GraphQLEventWatchStatus graphQLEventWatchStatus, String str12, String str13, int i4, String str14, String str15, boolean z, String str16, String str17, LinkableTextWithEntitiesModel linkableTextWithEntitiesModel4, State state) {
        this.f19211a = str;
        this.f19212b = str2;
        this.f19213c = str3;
        this.f19214d = i;
        this.f19215e = i2;
        this.f19216f = str4;
        this.f19217g = i3;
        this.f19218h = str5;
        this.f19219i = str6;
        this.f19220j = uri;
        this.f19222l = linkableTextWithEntitiesModel2;
        this.f19223m = linkableTextWithEntitiesModel3;
        this.f19224n = str7;
        this.f19225o = str8;
        this.f19221k = linkableTextWithEntitiesModel;
        this.f19226p = str9;
        this.f19227q = str10;
        this.f19228r = str11;
        this.f19229s = graphQLEventWatchStatus;
        this.f19230t = str12;
        this.f19231u = str13;
        this.f19232v = i4;
        this.f19233w = str14;
        this.f19234x = str15;
        this.f19235y = z;
        this.f19236z = str16;
        this.f19208A = str17;
        this.f19209B = linkableTextWithEntitiesModel4;
        this.f19210C = state;
    }

    public EventBuyTicketsModel(Parcel parcel) {
        this.f19211a = parcel.readString();
        this.f19212b = parcel.readString();
        this.f19213c = parcel.readString();
        this.f19214d = parcel.readInt();
        this.f19215e = parcel.readInt();
        this.f19216f = parcel.readString();
        this.f19217g = parcel.readInt();
        this.f19218h = parcel.readString();
        this.f19219i = parcel.readString();
        this.f19220j = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f19221k = (LinkableTextWithEntitiesModel) FlatBufferModelHelper.a(parcel);
        this.f19222l = (LinkableTextWithEntitiesModel) FlatBufferModelHelper.a(parcel);
        this.f19223m = (LinkableTextWithEntitiesModel) FlatBufferModelHelper.a(parcel);
        this.f19224n = parcel.readString();
        this.f19225o = parcel.readString();
        this.f19226p = parcel.readString();
        this.f19227q = parcel.readString();
        this.f19228r = parcel.readString();
        this.f19229s = GraphQLEventWatchStatus.values()[parcel.readInt()];
        this.f19230t = parcel.readString();
        this.f19231u = parcel.readString();
        this.f19232v = parcel.readInt();
        this.f19233w = parcel.readString();
        this.f19234x = parcel.readString();
        this.f19235y = ParcelUtil.a(parcel);
        this.f19236z = parcel.readString();
        this.f19208A = parcel.readString();
        this.f19209B = (LinkableTextWithEntitiesModel) FlatBufferModelHelper.a(parcel);
        this.f19210C = State.values()[parcel.readInt()];
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19211a);
        parcel.writeString(this.f19212b);
        parcel.writeString(this.f19213c);
        parcel.writeInt(this.f19214d);
        parcel.writeInt(this.f19215e);
        parcel.writeString(this.f19216f);
        parcel.writeInt(this.f19217g);
        parcel.writeString(this.f19218h);
        parcel.writeString(this.f19219i);
        parcel.writeParcelable(this.f19220j, i);
        FlatBufferModelHelper.a(parcel, this.f19221k);
        FlatBufferModelHelper.a(parcel, this.f19222l);
        FlatBufferModelHelper.a(parcel, this.f19223m);
        parcel.writeString(this.f19224n);
        parcel.writeString(this.f19225o);
        parcel.writeString(this.f19226p);
        parcel.writeString(this.f19227q);
        parcel.writeString(this.f19228r);
        parcel.writeInt(this.f19229s.ordinal());
        parcel.writeString(this.f19230t);
        parcel.writeString(this.f19231u);
        parcel.writeInt(this.f19232v);
        parcel.writeString(this.f19233w);
        parcel.writeString(this.f19234x);
        ParcelUtil.a(parcel, this.f19235y);
        parcel.writeString(this.f19236z);
        parcel.writeString(this.f19208A);
        FlatBufferModelHelper.a(parcel, this.f19209B);
        parcel.writeInt(this.f19210C.ordinal());
    }

    public int describeContents() {
        return 0;
    }

    public final Mutator m19413a() {
        EventBuyTicketsModelBuilder eventBuyTicketsModelBuilder = new EventBuyTicketsModelBuilder();
        eventBuyTicketsModelBuilder.f19240a = this.f19211a;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19241b = this.f19212b;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19242c = this.f19213c;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19243d = this.f19214d;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19244e = this.f19215e;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19245f = this.f19216f;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19246g = this.f19217g;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19247h = this.f19218h;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19248i = this.f19219i;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19249j = this.f19220j;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19250k = this.f19221k;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19251l = this.f19222l;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19252m = this.f19223m;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19253n = this.f19224n;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19254o = this.f19225o;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19255p = this.f19226p;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19256q = this.f19227q;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19257r = this.f19228r;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19258s = this.f19229s;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19262w = this.f19230t;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19263x = this.f19231u;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19264y = this.f19232v;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19265z = this.f19233w;
        eventBuyTicketsModelBuilder = eventBuyTicketsModelBuilder;
        eventBuyTicketsModelBuilder.f19237A = this.f19234x;
        return eventBuyTicketsModelBuilder.mo867a(this.f19235y).mo873f(this.f19236z).mo874g(this.f19208A).mo865a(this.f19209B).mo864a(this.f19210C);
    }
}
