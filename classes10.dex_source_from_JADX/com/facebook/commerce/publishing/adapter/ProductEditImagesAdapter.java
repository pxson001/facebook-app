package com.facebook.commerce.publishing.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.commerce.publishing.adapter.AddEditProductImagesDataProvider.ImageProviderModel;
import com.facebook.commerce.publishing.adapter.AddEditProductImagesDataProvider.ImageProviderModel.Type;
import com.facebook.commerce.publishing.fragments.adminproduct.AdminProductFragment;
import com.facebook.commerce.publishing.fragments.adminproduct.AdminProductFragment.C21674;
import com.facebook.commerce.publishing.ui.ProductImageViewHolder;
import com.facebook.commerce.publishing.util.ProductItemImageHelper;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.Assisted;
import com.facebook.ipc.editgallery.CropMode;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.ipc.editgallery.EditGalleryIntentCreator;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration.Builder;
import com.facebook.ipc.editgallery.EntryPoint;
import com.facebook.ipc.media.MediaItem;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: d9310532211f82f853f0f641886df93f */
public class ProductEditImagesAdapter extends Adapter {
    public static final CallerContext f15499a = CallerContext.a(ProductEditImagesAdapter.class, "commerce_product_edit_images_adapter");
    private int f15500b = 10;
    public LayoutInflater f15501c;
    public AddProductImageViewHolder f15502d;
    public OnClickListener f15503e;
    public AddEditProductImagesDataProvider f15504f;
    public C21674 f15505g;

    /* compiled from: d9310532211f82f853f0f641886df93f */
    public class AddProductImageViewHolder extends ViewHolder {
        public AddProductImageViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: d9310532211f82f853f0f641886df93f */
    public class HorizontalSpacingDecoration extends ItemDecoration {
        private int f15498a;

        public HorizontalSpacingDecoration(int i) {
            this.f15498a = i;
        }

        public final void m16014a(Rect rect, View view, RecyclerView recyclerView, State state) {
            rect.left = RecyclerView.d(view) == 0 ? 0 : this.f15498a;
        }
    }

    @Inject
    public ProductEditImagesAdapter(@Assisted Context context, @Assisted AddEditProductImagesDataProvider addEditProductImagesDataProvider, @Assisted OnClickListener onClickListener) {
        this.f15501c = LayoutInflater.from(context);
        this.f15504f = addEditProductImagesDataProvider;
        this.f15503e = onClickListener;
    }

    public final ViewHolder m16015a(ViewGroup viewGroup, int i) {
        if (i != 1) {
            return new ProductImageViewHolder((ViewGroup) this.f15501c.inflate(2130906415, viewGroup, false), f15499a);
        }
        AddProductImageViewHolder addProductImageViewHolder;
        if (this.f15502d != null) {
            addProductImageViewHolder = this.f15502d;
        } else {
            ViewGroup viewGroup2 = (ViewGroup) this.f15501c.inflate(2130906406, viewGroup, false);
            viewGroup2.setOnClickListener(this.f15503e);
            this.f15502d = new AddProductImageViewHolder(viewGroup2);
            addProductImageViewHolder = this.f15502d;
        }
        return addProductImageViewHolder;
    }

    public final void m16016a(ViewHolder viewHolder, int i) {
        if (getItemViewType(i) != 1) {
            final ProductImageViewHolder productImageViewHolder = (ProductImageViewHolder) viewHolder;
            final ImageProviderModel imageProviderModel = (ImageProviderModel) this.f15504f.f15443a.get(i);
            productImageViewHolder.f15638n.a(Uri.parse(this.f15504f.m15981a(i)), productImageViewHolder.f15639o);
            productImageViewHolder.f15636l.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ProductEditImagesAdapter f15494b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1243445417);
                    ProductEditImagesAdapter productEditImagesAdapter = this.f15494b;
                    int e = productImageViewHolder.e();
                    Preconditions.checkPositionIndex(e, productEditImagesAdapter.f15504f.m15979a());
                    AddEditProductImagesDataProvider addEditProductImagesDataProvider = productEditImagesAdapter.f15504f;
                    addEditProductImagesDataProvider.f15443a.remove(e);
                    if (addEditProductImagesDataProvider.f15444b != null) {
                        addEditProductImagesDataProvider.f15444b.l_(e);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, 103397467, a);
                }
            });
            if (imageProviderModel.f15442b == Type.MEDIA_ITEM) {
                productImageViewHolder.m16109b(new OnClickListener(this) {
                    final /* synthetic */ ProductEditImagesAdapter f15497c;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -858668684);
                        if (this.f15497c.f15505g != null) {
                            C21674 c21674 = this.f15497c.f15505g;
                            productImageViewHolder.e();
                            ImageProviderModel imageProviderModel = imageProviderModel;
                            view.getParent();
                            if (imageProviderModel != null && imageProviderModel.f15442b == Type.MEDIA_ITEM) {
                                ProductItemImageHelper productItemImageHelper = c21674.f15581a.aq;
                                AdminProductFragment adminProductFragment = c21674.f15581a;
                                MediaItem mediaItem = (MediaItem) imageProviderModel.f15441a;
                                Preconditions.checkNotNull(mediaItem);
                                Builder a2 = new Builder().a(Uri.parse(mediaItem.e()), mediaItem.d().toString()).a(EditFeature.DOODLE).b(EditFeature.TEXT).a(CropMode.DEFAULT_CROP);
                                a2.f = true;
                                a2 = a2;
                                a2.h = true;
                                Intent a3 = EditGalleryIntentCreator.a(adminProductFragment.o(), EntryPoint.PRODUCT_ITEM.toString(), a2.a());
                                productItemImageHelper.f15642a = mediaItem;
                                productItemImageHelper.f15643b.a(a3, 9420, adminProductFragment);
                            }
                        }
                        Logger.a(2, EntryType.UI_INPUT_END, 807626769, a);
                    }
                });
            } else {
                productImageViewHolder.m16109b(null);
            }
        }
    }

    public final int aZ_() {
        if (this.f15504f.m15979a() < this.f15500b) {
            return this.f15504f.m15979a() + 1;
        }
        return this.f15504f.m15979a();
    }

    public int getItemViewType(int i) {
        return i == this.f15504f.m15979a() ? 1 : 0;
    }
}
