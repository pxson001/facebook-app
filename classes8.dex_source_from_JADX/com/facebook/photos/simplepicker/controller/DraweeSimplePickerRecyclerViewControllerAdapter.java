package com.facebook.photos.simplepicker.controller;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.facebook.friendsharing.souvenirs.attachment.SouvenirAttachmentPagerAdapter.Delegate;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.inject.Assisted;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.photos.simplepicker.SimplePickerFragment.AnonymousClass20;
import com.facebook.photos.simplepicker.SimplePickerFragment.BitmapRenderedCallback;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03817;
import com.facebook.photos.simplepicker.SimplePickerFragment.C03828;
import com.facebook.photos.simplepicker.view.PickerLongPressProgressBar;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: should_be_cu */
public class DraweeSimplePickerRecyclerViewControllerAdapter implements SimplePickerViewControllerAdapter {
    private final AnonymousClass20 f2988a;
    public final RecyclerView f2989b;
    private final ImmutableList<SouvenirModel> f2990c;
    private final DraweeSimplePickerRecyclerViewAdapterProvider f2991d;
    private final C03817 f2992e;
    private final boolean f2993f;
    private int f2994g = 0;
    @Nullable
    public DraweeSimplePickerRecyclerViewAdapter f2995h;
    private C03828 f2996i;
    @Nullable
    private FramePackModel f2997j;

    @Inject
    public DraweeSimplePickerRecyclerViewControllerAdapter(@Assisted Delegate delegate, @Assisted View view, @Assisted ImmutableList<SouvenirModel> immutableList, DraweeSimplePickerRecyclerViewAdapterProvider draweeSimplePickerRecyclerViewAdapterProvider, @Assisted BitmapRenderedCallback bitmapRenderedCallback, @Assisted boolean z) {
        this.f2988a = delegate;
        this.f2989b = (RecyclerView) view.findViewById(2131559427);
        this.f2990c = immutableList;
        this.f2991d = draweeSimplePickerRecyclerViewAdapterProvider;
        this.f2992e = bitmapRenderedCallback;
        this.f2993f = z;
    }

    public final int mo142a() {
        return this.f2989b.getChildCount();
    }

    public final View mo143a(int i) {
        return this.f2989b.getChildAt(i);
    }

    public final void mo144a(Cursor cursor, PickerSelectionController pickerSelectionController, Optional<PickerLongPressProgressBar> optional, boolean z) {
        this.f2995h = this.f2991d.m3044a(this.f2988a, cursor, this.f2992e, pickerSelectionController, optional, z, this.f2993f, this.f2990c);
        final GridLayoutManager gridLayoutManager = (GridLayoutManager) this.f2989b.getLayoutManager();
        gridLayoutManager.h = new SpanSizeLookup(this) {
            final /* synthetic */ DraweeSimplePickerRecyclerViewControllerAdapter f2987c;

            public final int m3045a(int i) {
                if (this.f2987c.f2995h == null) {
                    return gridLayoutManager.c;
                }
                if (this.f2987c.f2995h.m3043f(i)) {
                    return gridLayoutManager.c;
                }
                return 1;
            }
        };
        this.f2995h.f2982h = this.f2994g;
        this.f2989b.setAdapter(this.f2995h);
        m3046g();
        if (this.f2996i != null) {
            mo148a(this.f2996i);
        }
    }

    public final int mo149b() {
        if (this.f2995h != null) {
            return this.f2995h.aZ_();
        }
        return 0;
    }

    public final void mo145a(Bundle bundle) {
        if (this.f2995h != null) {
            bundle.putInt("souvenir_pager_indicator_index", this.f2995h.f2982h);
        }
    }

    public final void mo150b(Bundle bundle) {
        if (bundle != null) {
            this.f2994g = bundle.getInt("souvenir_pager_indicator_index");
        }
    }

    public final void mo146a(SupportedMediaType supportedMediaType) {
        if (this.f2995h != null) {
            DraweeSimplePickerRecyclerViewAdapter draweeSimplePickerRecyclerViewAdapter = this.f2995h;
            draweeSimplePickerRecyclerViewAdapter.f2983i.m3031a(supportedMediaType, false);
            draweeSimplePickerRecyclerViewAdapter.notifyDataSetChanged();
        }
    }

    public final void mo151c() {
        if (this.f2995h != null) {
            this.f2995h.f2983i.m3033c();
        }
    }

    public final void mo152d() {
        if (this.f2995h != null) {
            this.f2995h.f2983i.m3034d();
            this.f2995h.notifyDataSetChanged();
        }
    }

    public final int mo153e() {
        if (this.f2995h != null) {
            return this.f2995h.m3042e();
        }
        return 0;
    }

    public final void mo147a(FramePackModel framePackModel) {
        this.f2997j = framePackModel;
        m3046g();
    }

    public final void mo148a(C03828 c03828) {
        this.f2996i = c03828;
        if (this.f2995h != null) {
            this.f2995h.f2983i.f2956H = c03828;
        }
    }

    private void m3046g() {
        if (this.f2995h != null && this.f2997j != null) {
            DraweeSimplePickerRecyclerViewAdapter draweeSimplePickerRecyclerViewAdapter = this.f2995h;
            draweeSimplePickerRecyclerViewAdapter.f2983i.m3032a(this.f2997j);
        }
    }
}
