package com.facebook.notifications.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.notifications.protocol.C0508x6391dc83;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = NotificationStoriesDeserializer.class)
/* compiled from: hashes */
public class NotificationStories implements Parcelable {
    public static final Creator<NotificationStories> CREATOR = new C05091();
    @JsonProperty("deltas")
    public final C0508x6391dc83 deltaStories;
    @JsonProperty("edges")
    public final List<FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel> newStories;
    @JsonProperty("page_info")
    public final GraphQLPageInfo pageInfo;

    /* compiled from: hashes */
    final class C05091 implements Creator<NotificationStories> {
        C05091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NotificationStories(parcel);
        }

        public final Object[] newArray(int i) {
            return new NotificationStories[i];
        }
    }

    protected NotificationStories() {
        this.newStories = null;
        this.deltaStories = null;
        this.pageInfo = null;
    }

    private NotificationStories(List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> list, C0508x6391dc83 c0508x6391dc83, GraphQLPageInfo graphQLPageInfo) {
        List arrayList = new ArrayList();
        for (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields a : list) {
            arrayList.add(FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.m11248a(a));
        }
        this.newStories = arrayList;
        this.deltaStories = c0508x6391dc83;
        this.pageInfo = graphQLPageInfo;
    }

    public NotificationStories(List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> list) {
        this(list, null, null);
    }

    @Nullable
    public final List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> m11244a() {
        return this.newStories == null ? null : ImmutableList.copyOf(this.newStories);
    }

    @Nullable
    public final ImmutableList<FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel> m11245b() {
        return this.newStories == null ? null : ImmutableList.copyOf(this.newStories);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.newStories);
        FlatBufferModelHelper.a(parcel, this.deltaStories);
        FlatBufferModelHelper.a(parcel, this.pageInfo);
    }

    public NotificationStories(Parcel parcel) {
        this.newStories = FlatBufferModelHelper.b(parcel);
        this.deltaStories = (C0508x6391dc83) FlatBufferModelHelper.a(parcel);
        this.pageInfo = (GraphQLPageInfo) FlatBufferModelHelper.a(parcel);
    }
}
