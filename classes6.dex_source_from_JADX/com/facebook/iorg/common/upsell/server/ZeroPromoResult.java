package com.facebook.iorg.common.upsell.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: mBigPictureUrl */
public class ZeroPromoResult implements Parcelable {
    public static final Creator<ZeroPromoResult> CREATOR = new C07091();
    public final String f11308a;
    private final String f11309b;
    public final UpsellPromo f11310c;
    public final ImmutableList<UpsellDialogScreenContent> f11311d;
    @Deprecated
    public final Page f11312e;

    /* compiled from: mBigPictureUrl */
    final class C07091 implements Creator<ZeroPromoResult> {
        C07091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ZeroPromoResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new ZeroPromoResult[i];
        }
    }

    /* compiled from: mBigPictureUrl */
    public enum Code {
        SUCCESS,
        MAYBE_SUCCESS,
        ERROR;

        public static Code fromStatus(String str) {
            try {
                switch (Integer.parseInt(str)) {
                    case 0:
                        return SUCCESS;
                    case 1:
                        return MAYBE_SUCCESS;
                    default:
                        return ERROR;
                }
            } catch (NumberFormatException e) {
                return ERROR;
            }
        }
    }

    /* compiled from: mBigPictureUrl */
    public class Page implements Parcelable {
        public static final Creator<Page> CREATOR = new C07101();
        public final String f11303a;
        public final String f11304b;
        public final String f11305c;
        public final String f11306d;
        public final String f11307e;

        /* compiled from: mBigPictureUrl */
        final class C07101 implements Creator<Page> {
            C07101() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Page(parcel);
            }

            public final Object[] newArray(int i) {
                return new Page[i];
            }
        }

        public Page() {
            this.f11303a = null;
            this.f11304b = null;
            this.f11305c = null;
            this.f11306d = null;
            this.f11307e = null;
        }

        public Page(String str, String str2, String str3, String str4, String str5) {
            this.f11303a = str;
            this.f11304b = str2;
            this.f11305c = str3;
            this.f11306d = str4;
            this.f11307e = str5;
        }

        public Page(Parcel parcel) {
            this.f11303a = parcel.readString();
            this.f11304b = parcel.readString();
            this.f11305c = parcel.readString();
            this.f11306d = parcel.readString();
            this.f11307e = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f11303a);
            parcel.writeString(this.f11304b);
            parcel.writeString(this.f11305c);
            parcel.writeString(this.f11306d);
            parcel.writeString(this.f11307e);
        }
    }

    public ZeroPromoResult() {
        this.f11308a = null;
        this.f11309b = null;
        this.f11312e = null;
        this.f11310c = null;
        this.f11311d = RegularImmutableList.a;
    }

    private ZeroPromoResult(String str, String str2, Page page, UpsellPromo upsellPromo, ImmutableList<UpsellDialogScreenContent> immutableList) {
        this.f11308a = str;
        this.f11309b = str2;
        this.f11312e = page;
        this.f11310c = upsellPromo;
        this.f11311d = immutableList;
    }

    public ZeroPromoResult(Parcel parcel) {
        this.f11308a = parcel.readString();
        this.f11309b = parcel.readString();
        this.f11312e = (Page) parcel.readParcelable(Page.class.getClassLoader());
        this.f11310c = (UpsellPromo) parcel.readParcelable(UpsellPromo.class.getClassLoader());
        Collection arrayList = new ArrayList();
        parcel.readTypedList(arrayList, UpsellDialogScreenContent.CREATOR);
        this.f11311d = ImmutableList.copyOf(arrayList);
    }

    public final UpsellDialogScreenContent m18137c() {
        return (UpsellDialogScreenContent) this.f11311d.get(0);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11308a);
        parcel.writeString(this.f11309b);
        parcel.writeParcelable(this.f11312e, i);
        parcel.writeParcelable(this.f11310c, i);
        parcel.writeTypedList(this.f11311d);
    }

    public static ZeroPromoResult m18135a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return new ZeroPromoResult();
        }
        Page page;
        String optString = jSONObject.optString("status");
        String optString2 = jSONObject.optString("description");
        JSONObject optJSONObject = jSONObject.optJSONObject("page");
        if (optJSONObject == null) {
            page = new Page();
        } else {
            page = new Page(optJSONObject.optString("title"), optJSONObject.optString("content"), optJSONObject.optString("top_message"), optJSONObject.optString("message"), optJSONObject.optString("button_text"));
        }
        return new ZeroPromoResult(optString, optString2, page, UpsellPromo.m18134a(jSONObject.optJSONObject("loan")), m18136a(jSONObject.optJSONArray("pages")));
    }

    private static ImmutableList<UpsellDialogScreenContent> m18136a(@Nullable JSONArray jSONArray) {
        if (jSONArray == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < jSONArray.length(); i++) {
            UpsellDialogScreenContent upsellDialogScreenContent;
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                upsellDialogScreenContent = new UpsellDialogScreenContent();
            } else {
                upsellDialogScreenContent = new UpsellDialogScreenContent(optJSONObject.optString("title"), optJSONObject.optString("content"), optJSONObject.optString("primary_button"), optJSONObject.optString("secondary_button"), optJSONObject.optString("third_button"));
            }
            builder.c(upsellDialogScreenContent);
        }
        return builder.b();
    }
}
