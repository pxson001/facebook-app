package com.facebook.ipc.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

@AutoGenJsonDeserializer
@JsonDeserialize(using = PageTopicDeserializer.class)
/* compiled from: TEST_USER */
public class PageTopic implements Parcelable {
    public static final Creator<PageTopic> CREATOR = new C13631();
    @JsonProperty("name")
    public final String displayName;
    @JsonProperty("id")
    public final long id;
    @JsonProperty("count")
    public final int pageCount;
    @JsonProperty("parent_ids")
    public final List<Long> parentIds;
    @JsonProperty("pic_square")
    public final String pic;

    /* compiled from: TEST_USER */
    final class C13631 implements Creator<PageTopic> {
        C13631() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PageTopic(parcel);
        }

        public final Object[] newArray(int i) {
            return new PageTopic[i];
        }
    }

    private PageTopic() {
        this.id = -1;
        this.displayName = null;
        this.pic = null;
        this.parentIds = Lists.a();
        this.pageCount = -1;
    }

    public PageTopic(long j, String str, String str2, List<Long> list, int i) {
        this.id = j;
        this.displayName = str;
        this.pic = str2;
        this.parentIds = new ArrayList(list);
        this.pageCount = i;
    }

    protected PageTopic(Parcel parcel) {
        this.id = parcel.readLong();
        this.displayName = parcel.readString();
        this.pic = parcel.readString();
        this.parentIds = new ArrayList();
        parcel.readList(this.parentIds, List.class.getClassLoader());
        this.pageCount = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.displayName);
        parcel.writeString(this.pic);
        parcel.writeList(this.parentIds);
        parcel.writeInt(this.pageCount);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PageTopic) && this.id == ((PageTopic) obj).id) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) this.id;
    }
}
