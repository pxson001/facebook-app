package com.facebook.commerce.publishing.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import com.facebook.commerce.publishing.graphql.CommercePublishingQueryFragmentsModels.AdminCommerceProductItemModel.OrderedImagesModel;
import com.facebook.ipc.media.MediaItem;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: date DESC */
public class AddEditProductImagesDataProvider {
    public final List<ImageProviderModel> f15443a = new ArrayList();
    public Adapter f15444b;

    /* compiled from: date DESC */
    public class ImageProviderModel {
        public final Object f15441a;
        public final Type f15442b;

        /* compiled from: date DESC */
        public enum Type {
            PRODUCT_IMAGE,
            MEDIA_ITEM
        }

        public ImageProviderModel(Object obj) {
            if (obj == null) {
                throw new NullPointerException("Can't add NULL productImage");
            }
            if (obj instanceof OrderedImagesModel) {
                this.f15442b = Type.PRODUCT_IMAGE;
            } else if (obj instanceof MediaItem) {
                this.f15442b = Type.MEDIA_ITEM;
            } else {
                throw new IllegalArgumentException("Invalid Object type: '" + obj.getClass() + "'");
            }
            this.f15441a = obj;
        }

        public final String m15978b() {
            if (this.f15442b == Type.PRODUCT_IMAGE) {
                return ((OrderedImagesModel) this.f15441a).c().a();
            }
            return ((MediaItem) this.f15441a).f().toString();
        }

        public String toString() {
            return m15978b();
        }
    }

    public AddEditProductImagesDataProvider(List<ImageProviderModel> list) {
        if (list != null) {
            this.f15443a.addAll(list);
        }
    }

    public final int m15979a() {
        return this.f15443a.size();
    }

    public final String m15981a(int i) {
        return ((ImageProviderModel) this.f15443a.get(i)).m15978b();
    }

    public final ImmutableList<MediaItem> m15982b() {
        Builder builder = new Builder();
        for (ImageProviderModel imageProviderModel : this.f15443a) {
            if (imageProviderModel.f15442b == Type.MEDIA_ITEM) {
                builder.c((MediaItem) imageProviderModel.f15441a);
            }
        }
        return builder.b();
    }

    public final ImmutableList<String> m15980a(boolean z) {
        Builder builder = new Builder();
        for (ImageProviderModel imageProviderModel : this.f15443a) {
            if (imageProviderModel.f15442b == Type.PRODUCT_IMAGE) {
                builder.c(((OrderedImagesModel) imageProviderModel.f15441a).b());
            } else if (z) {
                builder.c("pending_media_item_upload");
            }
        }
        return builder.b();
    }
}
