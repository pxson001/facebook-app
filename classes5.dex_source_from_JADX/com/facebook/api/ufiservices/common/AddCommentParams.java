package com.facebook.api.ufiservices.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLComment;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: android_place_picker_add_button */
public class AddCommentParams implements Parcelable {
    public static final Creator<AddCommentParams> CREATOR = new C09861();
    public final String f10276a;
    public final String f10277b;
    public final String f10278c;
    @Nullable
    public final String f10279d;
    public final GraphQLComment f10280e;
    public final FeedbackLoggingParams f10281f;
    public String f10282g;
    public final String f10283h;
    public final String f10284i;
    public final boolean f10285j;
    public final int f10286k;
    public final ViewerContext f10287l;

    /* compiled from: android_place_picker_add_button */
    final class C09861 implements Creator<AddCommentParams> {
        C09861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddCommentParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddCommentParams[i];
        }
    }

    /* compiled from: android_place_picker_add_button */
    public class Builder {
        public String f10264a;
        public String f10265b;
        public String f10266c;
        public GraphQLComment f10267d;
        public FeedbackLoggingParams f10268e;
        public String f10269f;
        public String f10270g;
        public String f10271h = Boolean.toString(false);
        public String f10272i = Boolean.toString(false);
        public ViewerContext f10273j;
        public boolean f10274k = false;
        public int f10275l = 0;

        public final AddCommentParams m18407a() {
            Preconditions.checkNotNull(this.f10264a);
            Preconditions.checkNotNull(this.f10265b);
            Preconditions.checkNotNull(this.f10266c);
            Preconditions.checkNotNull(this.f10269f);
            return new AddCommentParams(this);
        }
    }

    protected AddCommentParams(Builder builder) {
        this.f10276a = builder.f10264a;
        this.f10277b = builder.f10265b;
        this.f10278c = builder.f10266c;
        this.f10280e = builder.f10267d;
        this.f10281f = builder.f10268e;
        this.f10282g = builder.f10269f;
        this.f10279d = builder.f10270g;
        this.f10284i = builder.f10272i;
        this.f10283h = builder.f10271h;
        this.f10287l = builder.f10273j;
        this.f10285j = builder.f10274k;
        this.f10286k = builder.f10275l;
    }

    public AddCommentParams(Parcel parcel) {
        this.f10276a = parcel.readString();
        this.f10277b = parcel.readString();
        this.f10278c = parcel.readString();
        this.f10280e = (GraphQLComment) FlatBufferModelHelper.m4278a(parcel);
        this.f10281f = (FeedbackLoggingParams) parcel.readParcelable(FeedbackLoggingParams.class.getClassLoader());
        this.f10282g = parcel.readString();
        this.f10279d = parcel.readString();
        this.f10283h = parcel.readString();
        this.f10284i = parcel.readString();
        this.f10287l = (ViewerContext) parcel.readParcelable(ViewerContext.class.getClassLoader());
        this.f10285j = parcel.readByte() == (byte) 1;
        this.f10286k = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10276a);
        parcel.writeString(this.f10277b);
        parcel.writeString(this.f10278c);
        FlatBufferModelHelper.m4288a(parcel, this.f10280e);
        parcel.writeParcelable(this.f10281f, i);
        parcel.writeString(this.f10282g);
        parcel.writeString(this.f10279d);
        parcel.writeString(this.f10284i);
        parcel.writeString(this.f10283h);
        parcel.writeParcelable(this.f10287l, i);
        parcel.writeByte((byte) (this.f10285j ? 1 : 0));
        parcel.writeInt(this.f10286k);
    }

    public static Builder m18408a() {
        return new Builder();
    }
}
