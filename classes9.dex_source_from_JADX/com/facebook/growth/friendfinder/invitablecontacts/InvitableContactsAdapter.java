package com.facebook.growth.friendfinder.invitablecontacts;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.growth.contactimporter.GrowthUtils;
import com.facebook.growth.friendfinder.invitablecontacts.InvitableContactsCandidate.InviteState;
import com.facebook.inject.Assisted;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.text.BetterTextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: pages_greeting */
public class InvitableContactsAdapter extends Adapter<ViewHolder> implements Filterable {
    public final List<InvitableContactsCandidate> f7336a;
    private final InvitableContactsListBinder f7337b;
    public final Resources f7338c;
    public final Locales f7339d;
    public final GrowthUtils f7340e;
    private final Context f7341f;
    public int f7342g = 0;
    public boolean f7343h = false;
    public State f7344i = State.DEFAULT;
    public RetryClickedListener f7345j;
    public List<InvitableContactsCandidate> f7346k;
    private Filter f7347l;

    /* compiled from: pages_greeting */
    class HeaderViewHolder extends ViewHolder {
        public BetterTextView f7331l;

        public HeaderViewHolder(BetterTextView betterTextView) {
            super(betterTextView);
            this.f7331l = betterTextView;
        }
    }

    /* compiled from: pages_greeting */
    class InvitableContactsAdapterFilter extends Filter {
        final /* synthetic */ InvitableContactsAdapter f7332a;
        private List<InvitableContactsCandidate> f7333b;

        public InvitableContactsAdapterFilter(InvitableContactsAdapter invitableContactsAdapter) {
            this.f7332a = invitableContactsAdapter;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            if (!StringUtil.a(charSequence)) {
                Locale a;
                Locale locale = this.f7332a.f7338c.getConfiguration().locale;
                if (locale == null) {
                    a = this.f7332a.f7339d.a();
                } else {
                    a = locale;
                }
                this.f7333b = new ArrayList(this.f7332a.f7336a.size());
                for (InvitableContactsCandidate invitableContactsCandidate : this.f7332a.f7336a) {
                    String toLowerCase = invitableContactsCandidate.f7349b.toLowerCase(a);
                    String toLowerCase2 = invitableContactsCandidate.f7350c.toLowerCase(a);
                    CharSequence toLowerCase3 = charSequence.toString().toLowerCase(a);
                    Object obj = (toLowerCase.contains(toLowerCase3) || toLowerCase2.contains(toLowerCase3)) ? 1 : null;
                    if (obj != null) {
                        this.f7333b.add(invitableContactsCandidate);
                    }
                }
            }
            return null;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            if (StringUtil.a(charSequence)) {
                this.f7332a.f7346k = this.f7332a.f7336a;
            } else {
                this.f7332a.f7346k = this.f7333b;
            }
            this.f7332a.notifyDataSetChanged();
        }
    }

    /* compiled from: pages_greeting */
    class ItemViewHolder extends ViewHolder {
        public InvitableContactsItemRow f7334l;

        public ItemViewHolder(InvitableContactsItemRow invitableContactsItemRow) {
            super(invitableContactsItemRow);
            this.f7334l = invitableContactsItemRow;
        }
    }

    /* compiled from: pages_greeting */
    class LoadingViewHolder extends ViewHolder {
        public LoadingIndicatorView f7335l;

        public LoadingViewHolder(LoadingIndicatorView loadingIndicatorView) {
            super(loadingIndicatorView);
            this.f7335l = loadingIndicatorView;
        }
    }

    /* compiled from: pages_greeting */
    @interface RowType {
    }

    /* compiled from: pages_greeting */
    public enum State {
        DEFAULT,
        LOADING_MORE,
        FAILURE
    }

    @Inject
    public InvitableContactsAdapter(InvitableContactsListBinderProvider invitableContactsListBinderProvider, GrowthUtils growthUtils, Locales locales, @Assisted CIFlow cIFlow, @Assisted Context context) {
        this.f7337b = new InvitableContactsListBinder(AllCapsTransformationMethod.b(invitableContactsListBinderProvider), (InvitableContactsControllerProvider) invitableContactsListBinderProvider.getOnDemandAssistedProviderForStaticDi(InvitableContactsControllerProvider.class), cIFlow, this, context.getResources());
        this.f7340e = growthUtils;
        this.f7339d = locales;
        this.f7341f = context;
        this.f7338c = context.getResources();
        List arrayList = new ArrayList();
        this.f7346k = arrayList;
        this.f7336a = arrayList;
        if (growthUtils.m7386b()) {
            this.f7342g = 1;
            this.f7343h = true;
        }
    }

    public final ViewHolder m7688a(ViewGroup viewGroup, @RowType int i) {
        switch (i) {
            case 0:
                return new HeaderViewHolder((BetterTextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130904970, viewGroup, false));
            case 1:
                return new ItemViewHolder(new InvitableContactsItemRow(viewGroup.getContext()));
            case 2:
            case 3:
                return new LoadingViewHolder((LoadingIndicatorView) LayoutInflater.from(viewGroup.getContext()).inflate(2130904476, viewGroup, false));
            default:
                throw new IllegalArgumentException("Not a supported ViewType");
        }
    }

    public final void m7689a(ViewHolder viewHolder, int i) {
        if (viewHolder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) viewHolder).f7331l.setText(this.f7337b.f7395a.getString(2131236379));
        } else if (viewHolder instanceof ItemViewHolder) {
            this.f7337b.m7717a(((ItemViewHolder) viewHolder).f7334l, (InvitableContactsCandidate) this.f7346k.get(i - this.f7342g));
        } else if (!(viewHolder instanceof LoadingViewHolder)) {
        } else {
            if (this.f7344i == State.LOADING_MORE) {
                ((LoadingViewHolder) viewHolder).f7335l.a();
            } else if (this.f7344i == State.FAILURE) {
                ((LoadingViewHolder) viewHolder).f7335l.a(this.f7338c.getString(2131230761), this.f7345j);
            }
        }
    }

    public final int aZ_() {
        return (this.f7344i != State.DEFAULT ? 1 : 0) + (this.f7342g + this.f7346k.size());
    }

    @RowType
    public int getItemViewType(int i) {
        if (i == 0 && this.f7342g == 1) {
            return 0;
        }
        if (i != this.f7342g + this.f7336a.size()) {
            return 1;
        }
        if (this.f7344i == State.LOADING_MORE) {
            return 2;
        }
        if (this.f7344i == State.FAILURE) {
            return 3;
        }
        return 1;
    }

    public Filter getFilter() {
        if (this.f7347l == null) {
            this.f7347l = new InvitableContactsAdapterFilter(this);
        }
        return this.f7347l;
    }

    public final void m7691f() {
        for (InvitableContactsCandidate invitableContactsCandidate : this.f7336a) {
            invitableContactsCandidate.f7352e = InviteState.INVITED;
        }
        notifyDataSetChanged();
    }

    public final void m7690a(State state) {
        if (state != this.f7344i) {
            this.f7344i = state;
            notifyDataSetChanged();
        }
    }
}
