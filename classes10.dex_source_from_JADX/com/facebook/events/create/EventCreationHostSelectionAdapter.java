package com.facebook.events.create;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.events.create.EventCreationHostSelectionFragment.C22471;
import com.facebook.events.create.protocol.PageEventCreationGraphQLModels.PageHostInfoFragmentModel;
import com.facebook.events.create.ui.EventCreationHostSelectionBottomViewHolder;
import com.facebook.events.create.ui.EventCreationHostSelectionItemViewHolder;
import com.facebook.events.create.ui.EventCreationHostSelectionLoadingViewHolder;
import com.facebook.events.create.ui.EventCreationHostSelectionTextViewHolder;
import com.facebook.inject.Assisted;
import com.facebook.user.model.User;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: contact_sync_permanent_row_conf_dialog_cancel */
public class EventCreationHostSelectionAdapter extends Adapter<ViewHolder> {
    public static final Object f16118a = new Object();
    private static final Object f16119b = new Object();
    public static final Object f16120c = new Object();
    public static final Object f16121d = new Object();
    public List<Object> f16122e = ImmutableList.of(this.f16125h.get(), f16118a, f16119b, f16121d);
    public String f16123f;
    public C22471 f16124g;
    public Provider<User> f16125h;

    @Inject
    public EventCreationHostSelectionAdapter(@Assisted String str, Provider<User> provider) {
        this.f16123f = str;
        this.f16125h = provider;
    }

    public final ViewHolder m16483a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i == 2131558628) {
            return new EventCreationHostSelectionItemViewHolder(from.inflate(2130904021, viewGroup, false));
        }
        if (i == 2131558629) {
            return new EventCreationHostSelectionTextViewHolder(from.inflate(2130904020, viewGroup, false));
        }
        if (i == 2131558630) {
            return new EventCreationHostSelectionLoadingViewHolder(from.inflate(2130904022, viewGroup, false));
        }
        if (i == 2131558631) {
            return new EventCreationHostSelectionTextViewHolder(from.inflate(2130904023, viewGroup, false));
        }
        if (i == 2131558632) {
            return new EventCreationHostSelectionBottomViewHolder(from.inflate(2130904018, viewGroup, false));
        }
        throw new IllegalArgumentException("Invalid view type: " + i);
    }

    public final void m16484a(ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == 2131558628) {
            String x;
            boolean equal;
            String str;
            String str2;
            EventCreationHostSelectionItemViewHolder eventCreationHostSelectionItemViewHolder = (EventCreationHostSelectionItemViewHolder) viewHolder;
            Object obj = this.f16122e.get(i);
            String str3;
            String g;
            if (Objects.equal(obj, this.f16125h.get())) {
                str3 = ((User) obj).a;
                g = ((User) obj).e.g();
                x = ((User) obj).x();
                equal = Objects.equal(this.f16123f, ((User) obj).a);
                str = g;
                str2 = str3;
            } else {
                str3 = ((PageHostInfoFragmentModel) obj).m16741l();
                g = ((PageHostInfoFragmentModel) obj).m16742m();
                x = ((PageHostInfoFragmentModel) obj).m16743n().b();
                equal = Objects.equal(this.f16123f, ((PageHostInfoFragmentModel) obj).m16741l());
                str = g;
                str2 = str3;
            }
            eventCreationHostSelectionItemViewHolder.m16825a(str2, str, x, equal, this.f16124g);
        }
    }

    public final int aZ_() {
        return this.f16122e.size();
    }

    public int getItemViewType(int i) {
        Object obj = this.f16122e.get(i);
        if (Objects.equal(obj, this.f16125h.get())) {
            return 2131558628;
        }
        if (Objects.equal(obj, f16118a)) {
            return 2131558629;
        }
        if (Objects.equal(obj, f16119b)) {
            return 2131558630;
        }
        if (Objects.equal(obj, f16120c)) {
            return 2131558631;
        }
        if (Objects.equal(obj, f16121d)) {
            return 2131558632;
        }
        return 2131558628;
    }
}
