package com.facebook.widget.listview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: pending_send_media_attachment */
public abstract class FbBaseAdapter extends BaseAdapter implements FbListAdapter {
    private boolean f10292a = false;

    public abstract View mo1985a(int i, ViewGroup viewGroup);

    public abstract void mo1986a(int i, Object obj, View view, int i2, ViewGroup viewGroup);

    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        boolean z = true;
        try {
            View a;
            this.f10292a = true;
            int itemViewType = getItemViewType(i);
            if (view == null) {
                a = mo1985a(itemViewType, viewGroup);
                if (a == null) {
                    z = false;
                }
                Preconditions.checkState(z, "createView() shall not return null value!");
            } else {
                a = view;
            }
            mo1986a(i, getItem(i), a, itemViewType, viewGroup);
            return a;
        } finally {
            this.f10292a = false;
        }
    }

    public void notifyDataSetChanged() {
        Preconditions.checkArgument(!this.f10292a, "Call to notifyDataSetChanged while the adapter is getting a view!");
        super.notifyDataSetChanged();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        try {
            View b;
            this.f10292a = true;
            int itemViewType = getItemViewType(i);
            if (view == null) {
                b = m15361b(itemViewType, viewGroup);
                if (b == null) {
                    z = false;
                }
                Preconditions.checkState(z, "createDropDownView() shall not return null value!");
            } else {
                b = view;
            }
            m15362b(i, getItem(i), b, itemViewType, viewGroup);
            return b;
        } finally {
            this.f10292a = false;
        }
    }

    private View m15361b(int i, ViewGroup viewGroup) {
        return mo1985a(i, viewGroup);
    }

    private void m15362b(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        mo1986a(i, obj, view, i2, viewGroup);
    }
}
