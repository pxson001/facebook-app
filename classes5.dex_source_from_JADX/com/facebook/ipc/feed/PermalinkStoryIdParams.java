package com.facebook.ipc.feed;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.NotificationSource;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.ipc.intent.FacebookOnlyIntentParams;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: TILT_TO_PAN */
public class PermalinkStoryIdParams implements FacebookOnlyIntentParams {
    public static final Creator<PermalinkStoryIdParams> CREATOR = new C13441();
    public String f14052a;
    public String f14053b;
    public String f14054c;
    public String f14055d;
    public String f14056e;
    public String f14057f;
    public String f14058g;
    public CommentOrderType f14059h;
    private Boolean f14060i;
    public NotificationSource f14061j;
    public GraphQLComment f14062k;
    public GraphQLComment f14063l;
    private Boolean f14064m;
    public int f14065n;

    /* compiled from: TILT_TO_PAN */
    final class C13441 implements Creator<PermalinkStoryIdParams> {
        C13441() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PermalinkStoryIdParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PermalinkStoryIdParams[i];
        }
    }

    /* compiled from: TILT_TO_PAN */
    public class Builder {
        public String f14038a;
        public String f14039b;
        public String f14040c;
        public String f14041d;
        public String f14042e;
        public String f14043f;
        public String f14044g;
        public CommentOrderType f14045h;
        public Boolean f14046i;
        public NotificationSource f14047j;
        public GraphQLComment f14048k;
        public GraphQLComment f14049l;
        public Boolean f14050m;
        public int f14051n;

        public final Builder m23420a(String str) {
            this.f14038a = str;
            return this;
        }

        public final Builder m23424b(String str) {
            this.f14039b = str;
            return this;
        }

        public final Builder m23419a(GraphQLStory graphQLStory) {
            GraphQLComment b = GraphQLHelper.b(graphQLStory);
            if (b != null) {
                this.f14040c = b.y();
            }
            return this;
        }

        public final Builder m23425c(GraphQLStory graphQLStory) {
            this.f14049l = GraphQLHelper.c(graphQLStory);
            return this;
        }

        public final Builder m23427d(String str) {
            this.f14042e = str;
            return this;
        }

        public final Builder m23429e(String str) {
            this.f14044g = str;
            return this;
        }

        public final Builder m23428e(@Nullable GraphQLStory graphQLStory) {
            String h = GraphQLHelper.h(graphQLStory);
            if (h != null) {
                this.f14045h = CommentOrderType.getOrder(h);
                this.f14043f = Strings.nullToEmpty(graphQLStory.ai());
            } else if (!(graphQLStory == null || graphQLStory.L() == null)) {
                m23428e(graphQLStory.L());
            }
            return this;
        }

        public final Builder m23430f(@Nullable GraphQLStory graphQLStory) {
            m23421a(GraphQLHelper.i(graphQLStory));
            return this;
        }

        public final Builder m23421a(boolean z) {
            this.f14046i = Boolean.valueOf(z);
            return this;
        }

        public final Builder m23417a(CommentOrderType commentOrderType) {
            this.f14045h = commentOrderType;
            return this;
        }

        public final Builder m23418a(NotificationSource notificationSource) {
            this.f14047j = notificationSource;
            return this;
        }

        public final Builder m23416a(int i) {
            this.f14051n = i;
            return this;
        }

        public final PermalinkStoryIdParams m23422a() {
            return new PermalinkStoryIdParams(this);
        }

        public final Builder m23423b(GraphQLStory graphQLStory) {
            GraphQLComment c = GraphQLHelper.c(graphQLStory);
            if (c == null) {
                c = null;
            } else {
                c = c.v();
            }
            this.f14048k = c;
            return this;
        }

        public final Builder m23426d(GraphQLStory graphQLStory) {
            GraphQLFeedback graphQLFeedback;
            if (graphQLStory == null || graphQLStory.L() == null || graphQLStory.L().l() == null) {
                graphQLFeedback = null;
            } else {
                graphQLFeedback = graphQLStory.L().l();
            }
            GraphQLFeedback graphQLFeedback2 = graphQLFeedback;
            if (graphQLFeedback2 != null) {
                this.f14041d = graphQLFeedback2.z_();
            }
            return this;
        }
    }

    public PermalinkStoryIdParams(Builder builder) {
        boolean z = false;
        this.f14052a = builder.f14038a;
        this.f14053b = builder.f14039b;
        this.f14054c = builder.f14040c;
        this.f14055d = builder.f14041d;
        this.f14056e = builder.f14042e;
        this.f14058g = builder.f14044g;
        this.f14059h = builder.f14045h;
        this.f14060i = Boolean.valueOf(builder.f14046i == null ? false : builder.f14046i.booleanValue());
        this.f14061j = builder.f14047j;
        this.f14057f = builder.f14043f;
        this.f14062k = builder.f14048k;
        this.f14063l = builder.f14049l;
        if (builder.f14050m != null) {
            z = builder.f14050m.booleanValue();
        }
        this.f14064m = Boolean.valueOf(z);
        this.f14065n = builder.f14051n;
    }

    public PermalinkStoryIdParams(Parcel parcel) {
        this.f14052a = parcel.readString();
        this.f14053b = parcel.readString();
        this.f14054c = parcel.readString();
        this.f14055d = parcel.readString();
        this.f14056e = parcel.readString();
        this.f14058g = parcel.readString();
        String readString = parcel.readString();
        if (readString != null) {
            this.f14059h = CommentOrderType.getOrder(readString);
        }
        this.f14060i = Boolean.valueOf(ParcelUtil.m3827a(parcel));
        readString = parcel.readString();
        if (readString != null) {
            this.f14061j = NotificationSource.valueOf(readString);
        }
        this.f14062k = (GraphQLComment) FlatBufferModelHelper.m4278a(parcel);
        this.f14063l = (GraphQLComment) FlatBufferModelHelper.m4278a(parcel);
        this.f14064m = Boolean.valueOf(ParcelUtil.m3827a(parcel));
        this.f14065n = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str;
        parcel.writeString(this.f14052a);
        parcel.writeString(this.f14053b);
        parcel.writeString(this.f14054c);
        parcel.writeString(this.f14055d);
        parcel.writeString(this.f14056e);
        parcel.writeString(this.f14058g);
        if (this.f14059h == null) {
            str = null;
        } else {
            str = this.f14059h.toString();
        }
        parcel.writeString(str);
        ParcelUtil.m3826a(parcel, m23431i());
        if (this.f14061j == null) {
            str = null;
        } else {
            str = this.f14061j.toString();
        }
        parcel.writeString(str);
        FlatBufferModelHelper.m4288a(parcel, (Flattenable) this.f14062k);
        FlatBufferModelHelper.m4288a(parcel, (Flattenable) this.f14063l);
        ParcelUtil.m3826a(parcel, m23432m());
        parcel.writeInt(this.f14065n);
    }

    public final boolean m23431i() {
        return this.f14060i.booleanValue();
    }

    public final boolean m23432m() {
        return this.f14064m.booleanValue();
    }

    public int describeContents() {
        return 0;
    }
}
