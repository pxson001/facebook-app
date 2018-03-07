package com.facebook.bookmark.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AutoGenJsonDeserializer
@JsonDeserialize(using = BookmarksGroupDeserializer.class)
/* compiled from: redial_button */
public class BookmarksGroup implements Parcelable {
    public static final Creator<BookmarksGroup> CREATOR = new C06031();
    private boolean f5671a;
    private int f5672b;
    @JsonProperty("id")
    public final String id;
    @JsonProperty("all")
    private List<Bookmark> mAll;
    @JsonProperty("visible_count")
    private int mVisibleCount;
    @JsonProperty("name")
    public final String name;

    /* compiled from: redial_button */
    final class C06031 implements Creator<BookmarksGroup> {
        C06031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BookmarksGroup(parcel);
        }

        public final Object[] newArray(int i) {
            return new BookmarksGroup[i];
        }
    }

    public /* synthetic */ Object clone() {
        return m5884f();
    }

    private BookmarksGroup() {
        this.id = null;
        this.name = null;
        this.mVisibleCount = 0;
        this.f5672b = -1;
        this.mAll = new ArrayList();
        this.f5671a = false;
    }

    public BookmarksGroup(String str, String str2, int i, int i2, List<Bookmark> list) {
        this.id = (String) Preconditions.checkNotNull(str);
        this.name = (String) Preconditions.checkNotNull(str2);
        this.mVisibleCount = i;
        this.f5672b = i2;
        this.mAll = (List) Preconditions.checkNotNull(list);
        this.f5671a = false;
    }

    public BookmarksGroup(String str, String str2, int i, List<Bookmark> list) {
        this(str, str2, i, list.size(), list);
    }

    public final int m5873a() {
        return this.f5672b == -1 ? this.mAll.size() : this.f5672b;
    }

    public final int m5877b() {
        return this.mVisibleCount;
    }

    public final boolean m5880c() {
        return this.f5671a;
    }

    private void m5872i() {
        this.f5671a = true;
    }

    public final List<Bookmark> m5882d() {
        return Collections.unmodifiableList(this.mAll);
    }

    public final List<Bookmark> m5883e() {
        return this.mAll.subList(0, this.mVisibleCount);
    }

    public final void m5874a(long j) {
        for (int i = 0; i < this.mAll.size(); i++) {
            if (((Bookmark) this.mAll.get(i)).id == j) {
                this.mAll.remove(i);
                this.f5672b--;
                if (i < this.mVisibleCount) {
                    this.mVisibleCount--;
                    return;
                }
                return;
            }
        }
    }

    public final void m5875a(Bookmark bookmark) {
        if (!this.mAll.contains(bookmark)) {
            this.mAll.add(this.mVisibleCount, bookmark);
            this.mVisibleCount++;
            this.f5672b++;
            this.f5671a = false;
        }
    }

    public final void m5876a(Collection<Bookmark> collection) {
        this.mAll.addAll(collection);
    }

    public final boolean m5879b(Bookmark bookmark) {
        return m5878b(bookmark.id);
    }

    public final boolean m5878b(long j) {
        for (Bookmark bookmark : this.mAll) {
            if (bookmark.id == j) {
                return true;
            }
        }
        return false;
    }

    public final boolean m5881c(Bookmark bookmark) {
        return m5871c(bookmark.id);
    }

    private boolean m5871c(long j) {
        int i = 0;
        while (i < this.mVisibleCount && i < this.mAll.size()) {
            if (((Bookmark) this.mAll.get(i)).id == j) {
                return true;
            }
            i++;
        }
        return false;
    }

    public final BookmarksGroup m5884f() {
        BookmarksGroup bookmarksGroup = new BookmarksGroup(this.id, this.name, this.mVisibleCount, m5873a(), new ArrayList(m5882d()));
        if (this.f5671a) {
            bookmarksGroup.m5872i();
        }
        return bookmarksGroup;
    }

    public final boolean m5885g() {
        return m5873a() > this.mVisibleCount;
    }

    public final boolean m5886h() {
        return this.f5672b > this.mAll.size();
    }

    public BookmarksGroup(Parcel parcel) {
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.mVisibleCount = parcel.readInt();
        this.mAll = new ArrayList();
        this.f5671a = false;
        parcel.readTypedList(this.mAll, Bookmark.CREATOR);
        this.f5672b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeInt(this.mVisibleCount);
        parcel.writeTypedList(this.mAll);
        parcel.writeInt(this.f5672b);
    }

    public static boolean m5870a(List<BookmarksGroup> list, List<BookmarksGroup> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!m5869a((BookmarksGroup) list.get(i), (BookmarksGroup) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean m5869a(BookmarksGroup bookmarksGroup, BookmarksGroup bookmarksGroup2) {
        return Objects.equal(bookmarksGroup.id, bookmarksGroup2.id) && Objects.equal(bookmarksGroup.name, bookmarksGroup2.name) && bookmarksGroup.mVisibleCount == bookmarksGroup2.mVisibleCount && Bookmark.m5859a(bookmarksGroup.mAll, bookmarksGroup2.mAll);
    }
}
