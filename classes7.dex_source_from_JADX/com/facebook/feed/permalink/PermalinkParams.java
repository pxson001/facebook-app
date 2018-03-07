package com.facebook.feed.permalink;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.NotificationSource;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.ipc.feed.StoryPermalinkParamsType;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: afterCursor */
public class PermalinkParams implements Parcelable {
    public static final Creator<PermalinkParams> CREATOR = new C16971();
    public StoryPermalinkParamsType f19615a;
    public String f19616b;
    public String f19617c;
    public String f19618d;
    public String f19619e;
    public String f19620f;
    private String f19621g;
    public CommentOrderType f19622h;
    public boolean f19623i;
    public NotificationSource f19624j;
    public NotificationLogObject f19625k;
    public GraphQLComment f19626l;
    public GraphQLComment f19627m;
    public boolean f19628n;
    public boolean f19629o;
    public int f19630p;
    public FeedbackLoggingParams f19631q;
    public boolean f19632r;

    /* compiled from: afterCursor */
    final class C16971 implements Creator<PermalinkParams> {
        C16971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PermalinkParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PermalinkParams[i];
        }
    }

    /* compiled from: afterCursor */
    public class Builder {
        public StoryPermalinkParamsType f19597a;
        public String f19598b;
        public String f19599c;
        public String f19600d;
        public String f19601e;
        public String f19602f;
        public String f19603g;
        public CommentOrderType f19604h;
        public boolean f19605i;
        public NotificationSource f19606j;
        public NotificationLogObject f19607k;
        public GraphQLComment f19608l;
        public GraphQLComment f19609m;
        public boolean f19610n;
        public boolean f19611o;
        public int f19612p;
        public FeedbackLoggingParams f19613q;
        public boolean f19614r;

        public final PermalinkParams m22901a() {
            Preconditions.checkNotNull(this.f19597a);
            return new PermalinkParams(this);
        }
    }

    public PermalinkParams(Parcel parcel) {
        Integer valueOf;
        this.f19615a = StoryPermalinkParamsType.valueOf(parcel.readString());
        this.f19616b = parcel.readString();
        this.f19617c = parcel.readString();
        this.f19618d = parcel.readString();
        this.f19619e = parcel.readString();
        this.f19620f = parcel.readString();
        Object readString = parcel.readString();
        if (!StringUtil.a(readString)) {
            this.f19622h = CommentOrderType.getOrder(readString);
        }
        this.f19623i = ParcelUtil.a(parcel);
        readString = parcel.readString();
        if (!StringUtil.a(readString)) {
            this.f19624j = NotificationSource.valueOf(readString);
        }
        this.f19625k = (NotificationLogObject) parcel.readParcelable(NotificationLogObject.class.getClassLoader());
        this.f19626l = (GraphQLComment) FlatBufferModelHelper.a(parcel);
        this.f19627m = (GraphQLComment) FlatBufferModelHelper.a(parcel);
        this.f19628n = ParcelUtil.a(parcel);
        this.f19629o = ParcelUtil.a(parcel);
        if (parcel.readInt() == 1) {
            valueOf = Integer.valueOf(parcel.readInt());
        } else {
            valueOf = null;
        }
        this.f19630p = valueOf.intValue();
        this.f19631q = (FeedbackLoggingParams) parcel.readParcelable(FeedbackLoggingParams.class.getClassLoader());
        this.f19632r = ParcelUtil.a(parcel);
    }

    public PermalinkParams(Builder builder) {
        this.f19615a = builder.f19597a;
        this.f19616b = builder.f19598b;
        this.f19617c = builder.f19599c;
        this.f19618d = builder.f19600d;
        this.f19619e = builder.f19601e;
        this.f19620f = builder.f19602f;
        this.f19622h = builder.f19604h;
        this.f19623i = builder.f19605i;
        this.f19624j = builder.f19606j;
        this.f19625k = builder.f19607k;
        this.f19621g = builder.f19603g;
        this.f19626l = builder.f19608l;
        this.f19627m = builder.f19609m;
        this.f19628n = builder.f19610n;
        this.f19629o = builder.f19611o;
        this.f19630p = builder.f19612p;
        this.f19631q = builder.f19613q;
        this.f19632r = builder.f19614r;
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str;
        parcel.writeString(this.f19615a.toString());
        parcel.writeString(this.f19616b);
        parcel.writeString(this.f19617c);
        parcel.writeString(this.f19618d);
        parcel.writeString(this.f19619e);
        parcel.writeString(this.f19620f);
        if (this.f19622h == null) {
            str = null;
        } else {
            str = this.f19622h.toString();
        }
        parcel.writeString(str);
        ParcelUtil.a(parcel, this.f19623i);
        if (this.f19624j == null) {
            str = null;
        } else {
            str = this.f19624j.toString();
        }
        parcel.writeString(str);
        parcel.writeParcelable(this.f19625k, i);
        FlatBufferModelHelper.a(parcel, this.f19626l);
        FlatBufferModelHelper.a(parcel, this.f19627m);
        ParcelUtil.a(parcel, this.f19628n);
        ParcelUtil.a(parcel, this.f19629o);
        Integer valueOf = Integer.valueOf(this.f19630p);
        if (valueOf == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(valueOf.intValue());
        }
        parcel.writeParcelable(this.f19631q, i);
        ParcelUtil.a(parcel, this.f19632r);
    }

    @Nullable
    public final String m22902d() {
        return this.f19618d;
    }

    public int describeContents() {
        return 0;
    }

    public final Bundle m22903q() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("permalink_params", this);
        return bundle;
    }

    public final String m22904r() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Story Permalink Params Type: ").append(this.f19615a).append("\n");
        stringBuilder.append("Story Fetch Id: ").append(this.f19616b).append("\n");
        stringBuilder.append("Story Cache Id: ").append(this.f19617c).append("\n");
        stringBuilder.append("Relevant Comment Id: ").append(this.f19619e).append("\n");
        stringBuilder.append("Relevant Comment Parent Id: ").append(this.f19620f).append("\n");
        stringBuilder.append("Default Comment Ordering: ").append(this.f19622h).append("\n");
        stringBuilder.append("Notif Log Object: ").append(this.f19625k.toString()).append("\n");
        stringBuilder.append("Relevant reaction key: ").append(this.f19630p).append("\n");
        return stringBuilder.toString();
    }
}
