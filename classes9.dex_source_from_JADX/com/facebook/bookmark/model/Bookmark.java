package com.facebook.bookmark.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = BookmarkDeserializer.class)
/* compiled from: reference_no_2 */
public class Bookmark implements Parcelable {
    public static final Creator<Bookmark> CREATOR = new C06021();
    @JsonIgnore
    @Nullable
    public final BookmarksGroup f5668a;
    @JsonIgnore
    public boolean f5669b;
    @JsonProperty("client_token")
    @Nullable
    public final String clientToken;
    @JsonProperty("id")
    public final long id;
    @JsonProperty("count")
    private int mCount;
    @JsonProperty("count_string")
    private String mCountString;
    @JsonProperty("name")
    public final String name;
    @JsonProperty("pic")
    @Nullable
    public final String pic;
    @JsonProperty("type")
    @Nullable
    public final String type;
    @JsonProperty("url")
    public String url;

    /* compiled from: reference_no_2 */
    final class C06021 implements Creator<Bookmark> {
        C06021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Bookmark(parcel);
        }

        public final Object[] newArray(int i) {
            return new Bookmark[i];
        }
    }

    private Bookmark() {
        this.f5669b = false;
        this.id = -1;
        this.name = null;
        this.url = null;
        this.mCount = 0;
        this.mCountString = null;
        this.pic = null;
        this.type = null;
        this.clientToken = null;
        this.f5668a = null;
    }

    public Bookmark(long j, String str, String str2, int i, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this(j, str, str2, i, str3, str4, str5, str6, null);
    }

    private Bookmark(long j, String str, String str2, int i, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable BookmarksGroup bookmarksGroup) {
        this.f5669b = false;
        this.id = j;
        this.name = str;
        this.url = str2;
        this.mCount = i;
        this.mCountString = str3;
        this.pic = str4;
        this.type = str5;
        this.clientToken = str6;
        this.f5668a = bookmarksGroup;
    }

    public Bookmark(Parcel parcel) {
        boolean z;
        this.f5669b = false;
        this.id = parcel.readLong();
        this.name = parcel.readString();
        this.url = parcel.readString();
        this.mCount = parcel.readInt();
        this.mCountString = parcel.readString();
        this.pic = parcel.readString();
        this.type = parcel.readString();
        this.clientToken = parcel.readString();
        this.f5668a = (BookmarksGroup) parcel.readParcelable(BookmarksGroup.class.getClassLoader());
        if (parcel.readLong() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f5669b = z;
    }

    public final boolean m5862a() {
        return this.f5669b;
    }

    public final void m5861a(boolean z) {
        this.f5669b = z;
    }

    public final int m5863b() {
        return this.mCount;
    }

    public final void m5860a(int i) {
        this.mCount = i;
    }

    public final String m5864c() {
        return this.mCountString;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeInt(this.mCount);
        parcel.writeString(this.mCountString);
        parcel.writeString(this.pic);
        parcel.writeString(this.type);
        parcel.writeString(this.clientToken);
        parcel.writeParcelable(this.f5668a, 0);
        parcel.writeLong(this.f5669b ? 1 : 0);
    }

    public static boolean m5859a(List<Bookmark> list, List<Bookmark> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!m5858a((Bookmark) list.get(i), (Bookmark) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean m5858a(Bookmark bookmark, Bookmark bookmark2) {
        return bookmark.id == bookmark2.id && Objects.equal(bookmark.name, bookmark2.name) && Objects.equal(bookmark.pic, bookmark2.pic) && Objects.equal(bookmark.url, bookmark2.url) && Objects.equal(bookmark.type, bookmark2.type) && Objects.equal(bookmark.clientToken, bookmark2.clientToken) && bookmark.mCount == bookmark2.mCount && Objects.equal(bookmark.mCountString, bookmark2.mCountString) && Objects.equal(bookmark.f5668a, bookmark2.f5668a) && bookmark.f5669b == bookmark2.f5669b;
    }

    public String toString() {
        return this.name;
    }
}
