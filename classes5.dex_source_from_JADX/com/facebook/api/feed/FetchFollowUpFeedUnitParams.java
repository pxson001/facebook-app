package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.enums.GraphQLFollowUpFeedUnitActionType;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;

/* compiled from: attribution_uri */
public class FetchFollowUpFeedUnitParams implements Parcelable {
    public static final Creator<FetchFollowUpFeedUnitParams> CREATOR = new C09422();
    public final ImmutableList<FollowUpFeedUnitType> f8695a;
    public final String f8696b;
    public final String f8697c;
    public final GraphQLFollowUpFeedUnitActionType f8698d;
    public final int f8699e;
    private final boolean f8700f;
    private final boolean f8701g;

    /* compiled from: attribution_uri */
    public class C09411 implements Function<FollowUpFeedUnitType, String> {
        final /* synthetic */ FetchFollowUpFeedUnitParams f8694a;

        public C09411(FetchFollowUpFeedUnitParams fetchFollowUpFeedUnitParams) {
            this.f8694a = fetchFollowUpFeedUnitParams;
        }

        public Object apply(Object obj) {
            return ((FollowUpFeedUnitType) obj).name();
        }
    }

    /* compiled from: attribution_uri */
    final class C09422 implements Creator<FetchFollowUpFeedUnitParams> {
        C09422() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchFollowUpFeedUnitParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchFollowUpFeedUnitParams[i];
        }
    }

    /* compiled from: attribution_uri */
    public enum FollowUpFeedUnitType {
        ARTICLE_CHAINING,
        INSTAGRAM_PHOTO_CHAINING,
        PEOPLE_YOU_MAY_KNOW,
        PHOTO_CHAINING,
        TRENDING_STORIES,
        VIDEO_CHAINING,
        RELATED_EVENTS_CHAINING,
        UNSEEN_STORIES_CHAINING;
        
        private static final ImmutableList<FollowUpFeedUnitType> defaultList = null;

        static {
            defaultList = ImmutableList.copyOf(values());
        }

        public static ImmutableList<FollowUpFeedUnitType> getAllSupportedUnitTypes() {
            return defaultList;
        }

        public static ImmutableList<FollowUpFeedUnitType> getSupportedUnitTypes(List<FollowUpFeedUnitType> list) {
            if (list == null || list.isEmpty()) {
                return defaultList;
            }
            Builder builder = ImmutableList.builder();
            int size = defaultList.size();
            for (int i = 0; i < size; i++) {
                FollowUpFeedUnitType followUpFeedUnitType = (FollowUpFeedUnitType) defaultList.get(i);
                if (!list.contains(followUpFeedUnitType)) {
                    builder.c(followUpFeedUnitType);
                }
            }
            return builder.b();
        }
    }

    public FetchFollowUpFeedUnitParams(String str, String str2, GraphQLFollowUpFeedUnitActionType graphQLFollowUpFeedUnitActionType) {
        this(str, str2, graphQLFollowUpFeedUnitActionType, 1);
    }

    private FetchFollowUpFeedUnitParams(String str, String str2, GraphQLFollowUpFeedUnitActionType graphQLFollowUpFeedUnitActionType, int i) {
        this(str, str2, graphQLFollowUpFeedUnitActionType, i, FollowUpFeedUnitType.getAllSupportedUnitTypes(), false);
    }

    public FetchFollowUpFeedUnitParams(String str, String str2, GraphQLFollowUpFeedUnitActionType graphQLFollowUpFeedUnitActionType, int i, ImmutableList<FollowUpFeedUnitType> immutableList, boolean z) {
        this.f8696b = str;
        this.f8697c = str2;
        this.f8698d = graphQLFollowUpFeedUnitActionType;
        this.f8699e = i;
        this.f8695a = immutableList;
        this.f8700f = false;
        this.f8701g = z;
    }

    public FetchFollowUpFeedUnitParams(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f8696b = parcel.readString();
        this.f8697c = parcel.readString();
        this.f8698d = GraphQLFollowUpFeedUnitActionType.fromString(parcel.readString());
        this.f8699e = parcel.readInt();
        this.f8695a = ImmutableListHelper.a(parcel.readArrayList(FollowUpFeedUnitType.class.getClassLoader()));
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f8700f = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f8701g = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f8696b);
        parcel.writeString(this.f8697c);
        parcel.writeString(this.f8698d.toString());
        parcel.writeInt(this.f8699e);
        parcel.writeList(this.f8695a);
        if (this.f8700f) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.f8701g) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }
}
