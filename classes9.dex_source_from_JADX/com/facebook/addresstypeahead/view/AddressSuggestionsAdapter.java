package com.facebook.addresstypeahead.view;

import android.location.Address;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.addresstypeahead.view.AddressTypeAheadSearchView.C03533;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: senders_flat_buffer */
public final class AddressSuggestionsAdapter extends Adapter<ViewHolder> {
    private final LayoutInflater f3934a;
    private ImmutableList<Address> f3935b;
    public boolean f3936c = false;
    @Nullable
    public C03533 f3937d;

    /* compiled from: senders_flat_buffer */
    public class AddressViewHolder extends ViewHolder {
        final /* synthetic */ AddressSuggestionsAdapter f3931l;
        public ContentView f3932m;

        /* compiled from: senders_flat_buffer */
        public class C03501 implements OnClickListener {
            final /* synthetic */ Address f3929a;
            final /* synthetic */ AddressViewHolder f3930b;

            public C03501(AddressViewHolder addressViewHolder, Address address) {
                this.f3930b = addressViewHolder;
                this.f3929a = address;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 512000642);
                if (this.f3930b.f3931l.f3937d != null) {
                    this.f3930b.f3931l.f3937d.m3826a(this.f3930b.e(), this.f3929a);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -1783105527, a);
            }
        }

        public AddressViewHolder(AddressSuggestionsAdapter addressSuggestionsAdapter, ContentView contentView) {
            this.f3931l = addressSuggestionsAdapter;
            super(contentView);
            this.f3932m = contentView;
        }
    }

    /* compiled from: senders_flat_buffer */
    class FooterViewHolder extends ViewHolder {
        View f3933l;

        public FooterViewHolder(View view) {
            super(view);
            this.f3933l = view;
        }
    }

    @Inject
    public AddressSuggestionsAdapter(LayoutInflater layoutInflater) {
        this.f3934a = layoutInflater;
        this.f3935b = RegularImmutableList.a;
    }

    public final int getItemViewType(int i) {
        return i == aZ_() + -1 ? 1 : 0;
    }

    public final void m3823a(@Nullable ImmutableList<Address> immutableList) {
        if (immutableList == null) {
            immutableList = RegularImmutableList.a;
        }
        this.f3935b = immutableList;
        notifyDataSetChanged();
    }

    @Nullable
    public final ViewHolder m3821a(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return new AddressViewHolder(this, (ContentView) this.f3934a.inflate(2130903175, viewGroup, false));
            case 1:
                return new FooterViewHolder(this.f3934a.inflate(2130903173, viewGroup, false));
            default:
                return null;
        }
    }

    public final void m3822a(ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case 0:
                AddressViewHolder addressViewHolder = (AddressViewHolder) viewHolder;
                Address address = (Address) this.f3935b.get(i);
                if (address.getMaxAddressLineIndex() >= 0) {
                    addressViewHolder.f3932m.setTitleText(address.getAddressLine(0));
                    addressViewHolder.f3932m.setSubtitleText(address.getLocality());
                } else {
                    addressViewHolder.f3932m.setTitleText(address.getLocality());
                }
                addressViewHolder.f3932m.setOnClickListener(new C03501(addressViewHolder, address));
                return;
            case 1:
                if (!this.f3936c) {
                    ((FooterViewHolder) viewHolder).f3933l.setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final int aZ_() {
        return this.f3935b.size() + 1;
    }
}
