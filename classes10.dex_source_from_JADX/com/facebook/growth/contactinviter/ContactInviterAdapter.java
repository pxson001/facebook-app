package com.facebook.growth.contactinviter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.locale.Locales;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: TEXT_ACTIVE */
public class ContactInviterAdapter extends Adapter<ViewHolder> {
    public ContactInviterFragment f23265a;
    public Locales f23266b;
    public List<PhoneContactToken> f23267c = new ArrayList();
    private FreeFbJsonParams f23268d;

    /* compiled from: TEXT_ACTIVE */
    public class HeaderViewHolder extends ViewHolder {
        public BetterTextView f23262l;
        public BetterTextView f23263m;

        public HeaderViewHolder(View view) {
            super(view);
            this.f23262l = (BetterTextView) view.findViewById(2131559441);
            this.f23263m = (BetterTextView) view.findViewById(2131559627);
        }
    }

    /* compiled from: TEXT_ACTIVE */
    public class ItemViewHolder extends ViewHolder {
        public ContactInviterItemRow f23264l;

        public ItemViewHolder(ContactInviterItemRow contactInviterItemRow) {
            super(contactInviterItemRow);
            this.f23264l = contactInviterItemRow;
        }
    }

    @Inject
    public ContactInviterAdapter(Locales locales, FreeFbJsonParams freeFbJsonParams) {
        this.f23266b = locales;
        this.f23268d = freeFbJsonParams;
    }

    public final ViewHolder m24598a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130903763, viewGroup, false));
        }
        return new ItemViewHolder(new ContactInviterItemRow(viewGroup.getContext()));
    }

    public final void m24599a(ViewHolder viewHolder, int i) {
        if (viewHolder instanceof HeaderViewHolder) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) viewHolder;
            if (this.f23267c.isEmpty()) {
                headerViewHolder.f23263m.setVisibility(8);
                return;
            }
            CharSequence charSequence = this.f23268d.f23302a;
            if (!Strings.isNullOrEmpty(charSequence)) {
                headerViewHolder.f23263m.setVisibility(0);
                headerViewHolder.f23263m.setText(Html.fromHtml(charSequence));
                headerViewHolder.f23263m.setMovementMethod(LinkMovementMethod.getInstance());
            }
            headerViewHolder.f23263m.setContentDescription(charSequence);
            headerViewHolder.f23262l.setText(2131236424);
            return;
        }
        PhoneContactToken phoneContactToken;
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
        ContactInviterItemRow contactInviterItemRow = itemViewHolder.f23264l;
        int i2 = i - 1;
        if (i - 1 < 0) {
            phoneContactToken = null;
        } else {
            phoneContactToken = (PhoneContactToken) this.f23267c.get(i - 1);
        }
        contactInviterItemRow.m24620a(i2, phoneContactToken);
        itemViewHolder.f23264l.f23293d = this.f23265a;
    }

    public final int aZ_() {
        return this.f23267c.size() + 1;
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        return 1;
    }
}
