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
import com.facebook.photos.thumbnailsource.ThumbnailSource;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: share_source */
public class LegacySimplePickerRecyclerViewControllerAdapter implements SimplePickerViewControllerAdapter {
    private final AnonymousClass20 f3077a;
    private final RecyclerView f3078b;
    private final ImmutableList<SouvenirModel> f3079c;
    private final LegacySimplePickerRecyclerViewAdapterProvider f3080d;
    private final ThumbnailSource f3081e;
    private final C03817 f3082f;
    private final boolean f3083g;
    private int f3084h = 0;
    @Nullable
    public LegacySimplePickerRecyclerViewAdapter f3085i;
    private C03828 f3086j;
    @Nullable
    private FramePackModel f3087k;

    @Inject
    public LegacySimplePickerRecyclerViewControllerAdapter(@Assisted Delegate delegate, @Assisted View view, @Assisted ImmutableList<SouvenirModel> immutableList, LegacySimplePickerRecyclerViewAdapterProvider legacySimplePickerRecyclerViewAdapterProvider, @Assisted ThumbnailSource thumbnailSource, @Assisted BitmapRenderedCallback bitmapRenderedCallback, @Assisted boolean z) {
        this.f3077a = delegate;
        this.f3078b = (RecyclerView) view.findViewById(2131559427);
        this.f3079c = immutableList;
        this.f3080d = legacySimplePickerRecyclerViewAdapterProvider;
        this.f3081e = thumbnailSource;
        this.f3082f = bitmapRenderedCallback;
        this.f3083g = z;
    }

    public final int mo142a() {
        return this.f3078b.getChildCount();
    }

    public final View mo143a(int i) {
        return this.f3078b.getChildAt(i);
    }

    public final void mo144a(Cursor cursor, PickerSelectionController pickerSelectionController, Optional<PickerLongPressProgressBar> optional, boolean z) {
        this.f3085i = this.f3080d.m3105a(this.f3077a, this.f3081e, cursor, this.f3082f, pickerSelectionController, optional, z, this.f3083g, this.f3079c);
        m3107f();
        this.f3085i.f3071h = this.f3084h;
        this.f3078b.setAdapter(this.f3085i);
        m3108g();
        if (this.f3086j != null) {
            mo148a(this.f3086j);
        }
    }

    private void m3107f() {
        final GridLayoutManager gridLayoutManager = (GridLayoutManager) this.f3078b.getLayoutManager();
        gridLayoutManager.h = new SpanSizeLookup(this) {
            final /* synthetic */ LegacySimplePickerRecyclerViewControllerAdapter f3076c;

            public final int m3106a(int i) {
                if (this.f3076c.f3085i == null) {
                    return gridLayoutManager.c;
                }
                if (this.f3076c.f3085i.m3104f(i)) {
                    return gridLayoutManager.c;
                }
                return 1;
            }
        };
    }

    public final int mo149b() {
        if (this.f3085i != null) {
            return this.f3085i.aZ_();
        }
        return 0;
    }

    public final void mo145a(Bundle bundle) {
        if (this.f3085i != null) {
            bundle.putInt("souvenir_pager_indicator_index", this.f3085i.f3071h);
        }
    }

    public final void mo150b(Bundle bundle) {
        if (bundle != null) {
            this.f3084h = bundle.getInt("souvenir_pager_indicator_index");
        }
    }

    public final void mo146a(SupportedMediaType supportedMediaType) {
        if (this.f3085i != null) {
            LegacySimplePickerRecyclerViewAdapter legacySimplePickerRecyclerViewAdapter = this.f3085i;
            legacySimplePickerRecyclerViewAdapter.f3072i.m3092a(supportedMediaType, false);
            legacySimplePickerRecyclerViewAdapter.notifyDataSetChanged();
        }
    }

    public final void mo151c() {
        if (this.f3085i != null) {
            this.f3085i.f3072i.m3094c();
        }
    }

    public final void mo152d() {
        if (this.f3085i != null) {
            this.f3085i.f3072i.m3095d();
            this.f3085i.notifyDataSetChanged();
        }
    }

    public final int mo153e() {
        if (this.f3085i != null) {
            return this.f3085i.m3103e();
        }
        return 0;
    }

    public final void mo147a(FramePackModel framePackModel) {
        this.f3087k = framePackModel;
        m3108g();
    }

    public final void mo148a(C03828 c03828) {
        this.f3086j = c03828;
        if (this.f3085i != null) {
            this.f3085i.f3072i.f3042H = c03828;
        }
    }

    private void m3108g() {
        if (this.f3085i != null && this.f3087k != null) {
            LegacySimplePickerRecyclerViewAdapter legacySimplePickerRecyclerViewAdapter = this.f3085i;
            legacySimplePickerRecyclerViewAdapter.f3072i.m3093a(this.f3087k);
        }
    }
}
