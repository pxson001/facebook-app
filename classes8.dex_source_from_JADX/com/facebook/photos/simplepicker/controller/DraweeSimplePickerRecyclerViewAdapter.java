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
import com.facebook.widget.viewpageindicator.HScrollCirclePageIndicator;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: should_shadow */
public class DraweeSimplePickerRecyclerViewAdapter extends Adapter<ViewHolder> {
    public final AnonymousClass20 f2975a;
    private final DraweeSimplePickerGridViewCursorAdapterProvider f2976b;
    public final ImmutableList<SouvenirModel> f2977c;
    public final SouvenirAttachmentPagerAdapterProvider f2978d;
    private final SimplePickerHeaderHolderProvider f2979e;
    private final SimplePickerItemHolderProvider f2980f;
    private final boolean f2981g;
    public int f2982h = 0;
    public DraweeSimplePickerGridViewCursorAdapter f2983i;
    public SouvenirAttachmentPagerAdapter f2984j;
    public HScrollCirclePageIndicator f2985k;

    /* compiled from: should_shadow */
    public class C03891 implements OnPageChangeListener {
        final /* synthetic */ DraweeSimplePickerRecyclerViewAdapter f2974a;

        public C03891(DraweeSimplePickerRecyclerViewAdapter draweeSimplePickerRecyclerViewAdapter) {
            this.f2974a = draweeSimplePickerRecyclerViewAdapter;
        }

        public final void m3036a(int i, float f, int i2) {
            this.f2974a.f2984j.a(i, f);
        }

        public final void e_(int i) {
            this.f2974a.f2982h = i;
            DraweeSimplePickerRecyclerViewAdapter.m3039h(this.f2974a, i);
            this.f2974a.f2975a.m2968b(i, (SouvenirModel) this.f2974a.f2977c.get(i));
        }

        public final void m3037b(int i) {
        }
    }

    @Inject
    public DraweeSimplePickerRecyclerViewAdapter(@Assisted Delegate delegate, @Assisted Cursor cursor, @Assisted BitmapRenderedCallback bitmapRenderedCallback, @Assisted PickerSelectionController pickerSelectionController, @Assisted Optional<PickerLongPressProgressBar> optional, @Assisted boolean z, @Assisted boolean z2, @Assisted ImmutableList<SouvenirModel> immutableList, DraweeSimplePickerGridViewCursorAdapterProvider draweeSimplePickerGridViewCursorAdapterProvider, SouvenirAttachmentPagerAdapterProvider souvenirAttachmentPagerAdapterProvider, SimplePickerHeaderHolderProvider simplePickerHeaderHolderProvider, SimplePickerItemHolderProvider simplePickerItemHolderProvider) {
        this.f2975a = delegate;
        this.f2976b = draweeSimplePickerGridViewCursorAdapterProvider;
        this.f2983i = this.f2976b.m3035a(cursor, bitmapRenderedCallback, pickerSelectionController, optional, z, z2);
        this.f2977c = immutableList;
        this.f2978d = souvenirAttachmentPagerAdapterProvider;
        this.f2979e = simplePickerHeaderHolderProvider;
        this.f2980f = simplePickerItemHolderProvider;
        boolean z3 = (this.f2977c == null || this.f2977c.isEmpty()) ? false : true;
        this.f2981g = z3;
    }

    public final ViewHolder m3040a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            SimplePickerHeaderHolder a = SimplePickerHeaderHolderProvider.m3145a(LayoutInflater.from(viewGroup.getContext()).inflate(2130907182, viewGroup, false));
            ViewPager viewPager = a.f3141l;
            this.f2985k = a.f3142m;
            this.f2984j = this.f2978d.a(this.f2975a, this.f2977c);
            viewPager.setAdapter(this.f2984j);
            viewPager.setCurrentItem(this.f2982h);
            this.f2975a.m2968b(this.f2982h, (SouvenirModel) this.f2977c.get(this.f2982h));
            if (this.f2977c.size() <= 1) {
                this.f2985k.setVisibility(8);
            } else {
                this.f2985k.setMaxCircles(5);
                this.f2985k.setCount(this.f2977c.size());
            }
            m3039h(this, this.f2982h);
            return a;
        } else if (m3038g(i)) {
            return SimplePickerItemHolderProvider.m3146a(this.f2983i.a(viewGroup.getContext(), this.f2983i.a(), viewGroup));
        } else {
            throw new IllegalStateException("Unsupported item view type: " + i);
        }
    }

    public final void m3041a(ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            ((SimplePickerHeaderHolder) viewHolder).f3141l.setOnPageChangeListener(new C03891(this));
        } else if (m3038g(itemViewType)) {
            this.f2983i.a().moveToPosition(i - m3042e());
            DraweeSimplePickerGridViewCursorAdapter draweeSimplePickerGridViewCursorAdapter = this.f2983i;
            View view = ((SimplePickerItemHolder) viewHolder).f3143l;
            ((SimplePickerItemHolder) viewHolder).f3143l.getContext();
            draweeSimplePickerGridViewCursorAdapter.a(view, this.f2983i.a());
        } else {
            throw new IllegalStateException("Unsupported item view type: " + getItemViewType(i));
        }
    }

    private boolean m3038g(int i) {
        return i == -1 || (i > 0 && i < this.f2983i.getViewTypeCount() + 1);
    }

    public static void m3039h(DraweeSimplePickerRecyclerViewAdapter draweeSimplePickerRecyclerViewAdapter, int i) {
        draweeSimplePickerRecyclerViewAdapter.f2985k.a(i, Math.min(i, 4), false);
    }

    public final int aZ_() {
        return this.f2983i.getCount() + m3042e();
    }

    public int getItemViewType(int i) {
        if (m3043f(i)) {
            return 0;
        }
        int itemViewType = this.f2983i.getItemViewType(i - m3042e());
        return itemViewType != -1 ? itemViewType + 1 : itemViewType;
    }

    public final int m3042e() {
        return this.f2981g ? 1 : 0;
    }

    public final boolean m3043f(int i) {
        return this.f2981g && i == 0;
    }
}
