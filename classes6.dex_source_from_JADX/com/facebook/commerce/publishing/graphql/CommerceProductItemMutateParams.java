package com.facebook.commerce.publishing.graphql;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsInterfaces.AdminCommerceProductItem;
import com.facebook.common.util.TriState;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: post_failure_data.txt */
public class CommerceProductItemMutateParams implements Parcelable {
    public static final Creator<CommerceProductItemMutateParams> CREATOR = new C04521();
    public final String f7586a;
    public final String f7587b;
    public final String f7588c;
    public final String f7589d;
    public final String f7590e;
    public final String f7591f;
    public final Integer f7592g;
    public final String f7593h;
    public final ImmutableList<String> f7594i;
    public final TriState f7595j;
    public final TriState f7596k;
    public final AdminCommerceProductItem f7597l;
    public final String f7598m;
    public final ViewerContext f7599n;

    /* compiled from: post_failure_data.txt */
    final class C04521 implements Creator<CommerceProductItemMutateParams> {
        C04521() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CommerceProductItemMutateParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CommerceProductItemMutateParams[i];
        }
    }

    /* compiled from: post_failure_data.txt */
    public class Builder {
        public String f7572a;
        public String f7573b;
        public String f7574c;
        public String f7575d;
        public String f7576e;
        public String f7577f;
        public Integer f7578g;
        public String f7579h;
        public ImmutableList<String> f7580i;
        public TriState f7581j = TriState.UNSET;
        public TriState f7582k = TriState.UNSET;
        private AdminCommerceProductItem f7583l;
        private String f7584m;
        public ViewerContext f7585n;

        public static Builder m10728a(CommerceProductItemMutateParams commerceProductItemMutateParams) {
            Builder builder = new Builder();
            builder.f7572a = commerceProductItemMutateParams.f7586a;
            builder = builder;
            builder.f7573b = commerceProductItemMutateParams.f7587b;
            builder = builder;
            builder.f7574c = commerceProductItemMutateParams.f7588c;
            builder = builder;
            builder.f7575d = commerceProductItemMutateParams.f7589d;
            builder = builder;
            builder.f7576e = commerceProductItemMutateParams.f7590e;
            builder = builder;
            builder.f7577f = commerceProductItemMutateParams.f7591f;
            builder = builder;
            builder.f7578g = commerceProductItemMutateParams.f7592g;
            builder = builder;
            builder.f7579h = commerceProductItemMutateParams.f7593h;
            builder = builder;
            builder.f7580i = commerceProductItemMutateParams.f7594i;
            builder = builder;
            builder.f7581j = commerceProductItemMutateParams.f7595j;
            builder = builder;
            builder.f7582k = commerceProductItemMutateParams.f7596k;
            builder = builder.m10729a(commerceProductItemMutateParams.f7597l, commerceProductItemMutateParams.f7598m);
            builder.f7585n = commerceProductItemMutateParams.f7599n;
            return builder;
        }

        public final Builder m10729a(AdminCommerceProductItem adminCommerceProductItem, String str) {
            this.f7583l = adminCommerceProductItem;
            this.f7584m = str;
            return this;
        }

        public final CommerceProductItemMutateParams m10730a() {
            return new CommerceProductItemMutateParams(this.f7572a, this.f7573b, this.f7574c, this.f7575d, this.f7576e, this.f7577f, this.f7578g, this.f7579h, this.f7580i, this.f7581j, this.f7582k, this.f7583l, this.f7584m, this.f7585n);
        }
    }

    private CommerceProductItemMutateParams(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, ImmutableList<String> immutableList, TriState triState, TriState triState2, AdminCommerceProductItem adminCommerceProductItem, String str8, ViewerContext viewerContext) {
        this.f7586a = str;
        this.f7587b = str2;
        this.f7588c = str3;
        this.f7589d = str4;
        this.f7590e = str5;
        this.f7591f = str6;
        this.f7592g = num;
        this.f7593h = str7;
        this.f7594i = immutableList;
        this.f7595j = triState;
        this.f7596k = triState2;
        this.f7597l = adminCommerceProductItem;
        this.f7598m = str8;
        this.f7599n = viewerContext;
    }

    public CommerceProductItemMutateParams(Parcel parcel) {
        this.f7586a = parcel.readString();
        this.f7587b = parcel.readString();
        this.f7588c = parcel.readString();
        this.f7589d = parcel.readString();
        this.f7590e = parcel.readString();
        this.f7591f = parcel.readString();
        this.f7592g = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.f7593h = parcel.readString();
        Collection readArrayList = parcel.readArrayList(String.class.getClassLoader());
        this.f7594i = readArrayList != null ? ImmutableList.copyOf(readArrayList) : null;
        this.f7595j = TriState.fromDbValue(parcel.readInt());
        this.f7596k = TriState.fromDbValue(parcel.readInt());
        this.f7597l = (AdminCommerceProductItem) FlatBufferModelHelper.a(parcel);
        this.f7598m = parcel.readString();
        this.f7599n = (ViewerContext) parcel.readParcelable(ViewerContext.class.getClassLoader());
    }

    public final CommerceProductItemMutateParams m10731a(List<Long> list) {
        if (list == null || list.isEmpty()) {
            return this;
        }
        if (this.f7594i == null || this.f7594i.isEmpty()) {
            throw new IllegalStateException("Cannot add photoIds with no corresponding PENDING_MEDIA_ITEM_UPLOAD placeholders.");
        }
        int size = list.size();
        Collection arrayList = new ArrayList();
        int size2 = this.f7594i.size();
        int i = 0;
        int i2 = 0;
        while (i < size2) {
            int i3;
            String str = (String) this.f7594i.get(i);
            if ("pending_media_item_upload".equals(str)) {
                i3 = i2 + 1;
                arrayList.add(String.valueOf(list.get(i2)));
            } else {
                arrayList.add(str);
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        Preconditions.checkState(size == i2);
        Builder a = Builder.m10728a(this);
        a.f7580i = ImmutableList.copyOf(arrayList);
        return a.m10730a();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7586a);
        parcel.writeString(this.f7587b);
        parcel.writeString(this.f7588c);
        parcel.writeString(this.f7589d);
        parcel.writeString(this.f7590e);
        parcel.writeString(this.f7591f);
        parcel.writeValue(this.f7592g);
        parcel.writeString(this.f7593h);
        parcel.writeList(this.f7594i);
        parcel.writeInt(this.f7595j.getDbValue());
        parcel.writeInt(this.f7596k.getDbValue());
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f7597l);
        parcel.writeString(this.f7598m);
        parcel.writeParcelable(this.f7599n, i);
    }
}
