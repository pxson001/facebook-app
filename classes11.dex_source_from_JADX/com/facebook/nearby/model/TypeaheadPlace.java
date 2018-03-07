package com.facebook.nearby.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStreetAddress;
import java.util.List;

/* compiled from: unread message count */
public class TypeaheadPlace implements Parcelable {
    public static final Creator<TypeaheadPlace> CREATOR = new C00551();
    public final String f396a;
    public final String f397b;
    public final double f398c;
    public final GraphQLImage f399d;
    public final GraphQLLocation f400e;
    public final List<String> f401f;
    public final GraphQLStreetAddress f402g;
    public final int f403h;
    public final GraphQLPlaceType f404i;
    public final boolean f405j;
    public final GraphQLSavedState f406k;
    public final boolean f407l;
    public final boolean f408m;

    /* compiled from: unread message count */
    final class C00551 implements Creator<TypeaheadPlace> {
        C00551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TypeaheadPlace(parcel);
        }

        public final Object[] newArray(int i) {
            return new TypeaheadPlace[i];
        }
    }

    public TypeaheadPlace(GraphQLNode graphQLNode) {
        this.f396a = graphQLNode.dp();
        this.f397b = graphQLNode.eP();
        this.f401f = graphQLNode.aZ();
        this.f402g = graphQLNode.s();
        this.f398c = graphQLNode.eY();
        this.f399d = graphQLNode.gi();
        this.f400e = graphQLNode.er();
        this.f403h = graphQLNode.ev();
        this.f404i = graphQLNode.fz();
        this.f405j = graphQLNode.dR();
        this.f406k = graphQLNode.jn();
        this.f407l = graphQLNode.bP();
        this.f408m = graphQLNode.dQ();
    }

    public TypeaheadPlace(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f396a = parcel.readString();
        this.f397b = parcel.readString();
        this.f401f = parcel.readArrayList(String.class.getClassLoader());
        this.f402g = (GraphQLStreetAddress) FlatBufferModelHelper.a(parcel);
        this.f398c = parcel.readDouble();
        this.f399d = (GraphQLImage) FlatBufferModelHelper.a(parcel);
        this.f400e = (GraphQLLocation) FlatBufferModelHelper.a(parcel);
        this.f403h = parcel.readInt();
        this.f404i = GraphQLPlaceType.fromString(parcel.readString());
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.f405j = z;
        this.f406k = GraphQLSavedState.fromString(parcel.readString());
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f407l = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f408m = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        int i2;
        String str = null;
        int i3 = 1;
        parcel.writeString(this.f396a);
        parcel.writeString(this.f397b);
        parcel.writeList(this.f401f);
        FlatBufferModelHelper.a(parcel, this.f402g);
        parcel.writeDouble(this.f398c);
        FlatBufferModelHelper.a(parcel, this.f399d);
        FlatBufferModelHelper.a(parcel, this.f400e);
        parcel.writeInt(this.f403h);
        parcel.writeString(this.f404i != null ? this.f404i.name() : null);
        if (this.f405j) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.f406k != null) {
            str = this.f406k.name();
        }
        parcel.writeString(str);
        if (this.f407l) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.f408m) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }
}
