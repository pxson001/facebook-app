package com.facebook.messaging.peopleyoumaycall;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: require('MPagesPlatformPaymentNativeBridge').updatePaymentMethod('{ */
public class PeopleYouMayCallAdapter extends Adapter<PeopleYouMayCallItemViewHolder> {
    private final LayoutInflater f3445a;
    public PeopleYouMayCallViewData f3446b;
    public ImmutableList<PersonYouMayCall> f3447c;
    public PeopleYouMayCallListener f3448d;
    private final OnClickListener f3449e = new C05481(this);
    private final OnLongClickListener f3450f = new C05492(this);

    /* compiled from: require('MPagesPlatformPaymentNativeBridge').updatePaymentMethod('{ */
    class C05481 implements OnClickListener {
        final /* synthetic */ PeopleYouMayCallAdapter f3443a;

        C05481(PeopleYouMayCallAdapter peopleYouMayCallAdapter) {
            this.f3443a = peopleYouMayCallAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 42564053);
            PeopleYouMayCallAdapter peopleYouMayCallAdapter = this.f3443a;
            view.getTag();
            Logger.a(2, EntryType.UI_INPUT_END, 178147661, a);
        }
    }

    /* compiled from: require('MPagesPlatformPaymentNativeBridge').updatePaymentMethod('{ */
    class C05492 implements OnLongClickListener {
        final /* synthetic */ PeopleYouMayCallAdapter f3444a;

        C05492(PeopleYouMayCallAdapter peopleYouMayCallAdapter) {
            this.f3444a = peopleYouMayCallAdapter;
        }

        public boolean onLongClick(View view) {
            boolean z;
            PeopleYouMayCallAdapter peopleYouMayCallAdapter = this.f3444a;
            if (((PersonYouMayCall) view.getTag()) == null || peopleYouMayCallAdapter.f3448d == null) {
                z = false;
            } else {
                z = peopleYouMayCallAdapter.f3448d.m3339a();
            }
            return z;
        }
    }

    public final void m3332a(ViewHolder viewHolder, int i) {
        PeopleYouMayCallItemView peopleYouMayCallItemView = (PeopleYouMayCallItemView) ((PeopleYouMayCallItemViewHolder) viewHolder).a;
        PersonYouMayCall personYouMayCall = (PersonYouMayCall) this.f3447c.get(i);
        peopleYouMayCallItemView.m3337a(personYouMayCall);
        peopleYouMayCallItemView.m3338a(this.f3446b.f3460b);
        peopleYouMayCallItemView.setTag(personYouMayCall);
    }

    @Inject
    public PeopleYouMayCallAdapter(LayoutInflater layoutInflater) {
        this.f3445a = layoutInflater;
    }

    public final ViewHolder m3331a(ViewGroup viewGroup, int i) {
        View inflate = this.f3445a.inflate(2130906163, viewGroup, false);
        inflate.setOnClickListener(this.f3449e);
        inflate.setOnLongClickListener(this.f3450f);
        return new PeopleYouMayCallItemViewHolder(inflate);
    }

    public final int aZ_() {
        return this.f3447c == null ? 0 : this.f3447c.size();
    }
}
