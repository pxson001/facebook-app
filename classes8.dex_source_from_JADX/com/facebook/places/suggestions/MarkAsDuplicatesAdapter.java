package com.facebook.places.suggestions;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: seconds_since_claim */
public class MarkAsDuplicatesAdapter extends BaseAdapter {
    private final Context f3628a;
    public ImmutableList<PlaceRow> f3629b;

    public /* synthetic */ Object getItem(int i) {
        return m3561a(i);
    }

    @Inject
    public MarkAsDuplicatesAdapter(Context context) {
        this.f3628a = context;
    }

    public boolean hasStableIds() {
        return true;
    }

    public int getCount() {
        return this.f3629b.size();
    }

    private PlaceRow m3561a(int i) {
        return (PlaceRow) this.f3629b.get(i);
    }

    public long getItemId(int i) {
        return Long.parseLong(m3561a(i).f3645a.cf_());
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        view = (PlaceRowView) view;
        if (view == null) {
            view = new PlaceRowView(this.f3628a);
        }
        view.setInfo(m3561a(i));
        return view;
    }
}
