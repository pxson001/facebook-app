package com.facebook.backstage.consumption.stack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.facebook.backstage.consumption.BackstagePanelImageView;
import com.facebook.backstage.data.BackstageProfile.SeenByUser;
import com.facebook.resources.ui.FbTextView;
import com.google.common.collect.ImmutableList;

/* compiled from: retry_after_reconnect */
public class BackstagePopupWindowAdapter extends BaseAdapter implements ListAdapter {
    public ImmutableList<SeenByUser> f4987a;

    public int getCount() {
        return this.f4987a.size();
    }

    public Object getItem(int i) {
        return this.f4987a.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view != null) {
            m4828a(view, (SeenByUser) this.f4987a.get(i));
            return view;
        }
        view = LayoutInflater.from(viewGroup.getContext()).inflate(2130905366, viewGroup, false);
        m4828a(view, (SeenByUser) this.f4987a.get(i));
        return view;
    }

    private static void m4828a(View view, SeenByUser seenByUser) {
        BackstagePanelImageView backstagePanelImageView = (BackstagePanelImageView) view.findViewById(2131564039);
        backstagePanelImageView.m4505a(true);
        backstagePanelImageView.setImage(seenByUser.f5102c);
        ((FbTextView) view.findViewById(2131564040)).setText(seenByUser.f5100a);
        FbTextView fbTextView = (FbTextView) view.findViewById(2131564041);
        if (seenByUser.m4896b()) {
            fbTextView.setVisibility(0);
            fbTextView.setText(seenByUser.f5111a);
            return;
        }
        fbTextView.setVisibility(8);
    }
}
