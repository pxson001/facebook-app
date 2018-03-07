package com.facebook.facecastdisplay.whoswatching;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.text.BetterTextView;

/* compiled from: assertive */
public class LiveWhosWatchingAdapter extends Adapter<WhosWatchingViewHolder> {

    /* compiled from: assertive */
    public class WhosWatchingViewHolder extends ViewHolder {
        public UserTileView f19108l;
        public BetterTextView f19109m;

        public WhosWatchingViewHolder(View view) {
            super(view);
            this.f19108l = (UserTileView) view.findViewById(2131568538);
            this.f19109m = (BetterTextView) view.findViewById(2131568539);
        }
    }

    public final void m22660a(ViewHolder viewHolder, int i) {
        WhosWatchingViewHolder whosWatchingViewHolder = (WhosWatchingViewHolder) viewHolder;
        whosWatchingViewHolder.f19108l.setParams(UserTileViewParams.a(UserKey.b("100001500408498")));
        whosWatchingViewHolder.f19109m.setText("Jason Hu forthewin");
    }

    public final ViewHolder m22659a(ViewGroup viewGroup, int i) {
        return new WhosWatchingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130907778, viewGroup, false));
    }

    public final int aZ_() {
        return 16;
    }
}
