package com.facebook.photos.simplepicker.controller;

import android.database.Cursor;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.friendsharing.souvenirs.attachment.SouvenirAttachmentPagerAdapter;
import com.facebook.friendsharing.souvenirs.attachment.SouvenirAttachmentPagerAdapter.Delegate;
import com.facebook.friendsharing.souvenirs.attachment.SouvenirAttachmentPagerAdapterProvider;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.inject.Assisted;
import com.facebook.photos.simplepicker.SimplePickerFragment.AnonymousClass20;
import com.facebook.photos.simplepicker.SimplePickerFragment.BitmapRenderedCallback;
import com.facebook.photos.simplepicker.view.PickerLongPressProgressBar;
import com.facebook.photos.thumbnailsource.ThumbnailSource;
import com.facebook.widget.viewpageindicator.HScrollCirclePageIndicator;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: share_to_twitter */
public class LegacySimplePickerRecyclerViewAdapter extends Adapter<ViewHolder> {
    public final AnonymousClass20 f3064a;
    private final LegacySimplePickerGridViewCursorAdapterProvider f3065b;
    public final ImmutableList<SouvenirModel> f3066c;
    public final SouvenirAttachmentPagerAdapterProvider f3067d;
    private final SimplePickerHeaderHolderProvider f3068e;
    private final SimplePickerItemHolderProvider f3069f;
    private final boolean f3070g;
    public int f3071h = 0;
    public LegacySimplePickerGridViewCursorAdapter f3072i;
    public SouvenirAttachmentPagerAdapter f3073j;
    public HScrollCirclePageIndicator f3074k;

    /* compiled from: share_to_twitter */
    public class C03961 implements OnPageChangeListener {
        final /* synthetic */ LegacySimplePickerRecyclerViewAdapter f3063a;

        public C03961(LegacySimplePickerRecyclerViewAdapter legacySimplePickerRecyclerViewAdapter) {
            this.f3063a = legacySimplePickerRecyclerViewAdapter;
        }

        public final void m3097a(int i, float f, int i2) {
            this.f3063a.f3073j.a(i, f);
        }

        public final void e_(int i) {
            this.f3063a.f3071h = i;
            LegacySimplePickerRecyclerViewAdapter.m3100h(this.f3063a, i);
            this.f3063a.f3064a.m2968b(i, (SouvenirModel) this.f3063a.f3066c.get(i));
        }

        public final void m3098b(int i) {
        }
    }

    @Inject
    public LegacySimplePickerRecyclerViewAdapter(@Assisted Delegate delegate, @Assisted ThumbnailSource thumbnailSource, @Assisted Cursor cursor, @Assisted BitmapRenderedCallback bitmapRenderedCallback, @Assisted PickerSelectionController pickerSelectionController, @Assisted Optional<PickerLongPressProgressBar> optional, @Assisted boolean z, @Assisted boolean z2, @Assisted ImmutableList<SouvenirModel> immutableList, LegacySimplePickerGridViewCursorAdapterProvider legacySimplePickerGridViewCursorAdapterProvider, SouvenirAttachmentPagerAdapterProvider souvenirAttachmentPagerAdapterProvider, SimplePickerHeaderHolderProvider simplePickerHeaderHolderProvider, SimplePickerItemHolderProvider simplePickerItemHolderProvider) {
        this.f3064a = delegate;
        this.f3065b = legacySimplePickerGridViewCursorAdapterProvider;
        this.f3072i = this.f3065b.m3096a(thumbnailSource, cursor, bitmapRenderedCallback, pickerSelectionController, optional, z, z2);
        this.f3066c = immutableList;
        this.f3067d = souvenirAttachmentPagerAdapterProvider;
        this.f3068e = simplePickerHeaderHolderProvider;
        this.f3069f = simplePickerItemHolderProvider;
        boolean z3 = (this.f3066c == null || this.f3066c.isEmpty()) ? false : true;
        this.f3070g = z3;
    }

    public final ViewHolder m3101a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            SimplePickerHeaderHolder a = SimplePickerHeaderHolderProvider.m3145a(LayoutInflater.from(viewGroup.getContext()).inflate(2130907182, viewGroup, false));
            ViewPager viewPager = a.f3141l;
            this.f3074k = a.f3142m;
            this.f3073j = this.f3067d.a(this.f3064a, this.f3066c);
            viewPager.setAdapter(this.f3073j);
            viewPager.setCurrentItem(this.f3071h);
            this.f3064a.m2968b(this.f3071h, (SouvenirModel) this.f3066c.get(this.f3071h));
            if (this.f3066c.size() <= 1) {
                this.f3074k.setVisibility(8);
            } else {
                this.f3074k.setMaxCircles(5);
                this.f3074k.setCount(this.f3066c.size());
            }
            m3100h(this, this.f3071h);
            return a;
        } else if (m3099g(i)) {
            return SimplePickerItemHolderProvider.m3146a(this.f3072i.a(viewGroup.getContext(), this.f3072i.a(), viewGroup));
        } else {
            throw new IllegalStateException("Unsupported item view type: " + i);
        }
    }

    public final void m3102a(ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            ((SimplePickerHeaderHolder) viewHolder).f3141l.setOnPageChangeListener(new C03961(this));
        } else if (m3099g(itemViewType)) {
            this.f3072i.a().moveToPosition(i - m3103e());
            LegacySimplePickerGridViewCursorAdapter legacySimplePickerGridViewCursorAdapter = this.f3072i;
            View view = ((SimplePickerItemHolder) viewHolder).f3143l;
            ((SimplePickerItemHolder) viewHolder).f3143l.getContext();
            legacySimplePickerGridViewCursorAdapter.a(view, this.f3072i.a());
        } else {
            throw new IllegalStateException("Unsupported item view type: " + getItemViewType(i));
        }
    }

    private boolean m3099g(int i) {
        return i == -1 || (i > 0 && i < this.f3072i.getViewTypeCount() + 1);
    }

    public static void m3100h(LegacySimplePickerRecyclerViewAdapter legacySimplePickerRecyclerViewAdapter, int i) {
        legacySimplePickerRecyclerViewAdapter.f3074k.a(i, Math.min(i, 4), false);
    }

    public final int aZ_() {
        return this.f3072i.getCount() + m3103e();
    }

    public int getItemViewType(int i) {
        if (m3104f(i)) {
            return 0;
        }
        int itemViewType = this.f3072i.getItemViewType(i - m3103e());
        return itemViewType != -1 ? itemViewType + 1 : itemViewType;
    }

    public final int m3103e() {
        return this.f3070g ? 1 : 0;
    }

    public final boolean m3104f(int i) {
        return this.f3070g && i == 0;
    }
}
