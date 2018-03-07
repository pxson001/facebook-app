package com.facebook.messaging.photos.editing;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.util.FindViewUtil;
import com.facebook.stickers.model.StickerPack;
import com.google.common.collect.ImmutableList;

/* compiled from: dialtone_switcher_zero_balance_tooltip_impression */
public class StickerPackCopyrightsViewHolder extends ViewHolder {
    private final TextView f16242l;

    public StickerPackCopyrightsViewHolder(View view) {
        super(view);
        this.f16242l = (TextView) FindViewUtil.b(view, 2131565165);
    }

    public final void m16332a(StickerPack stickerPack) {
        CharSequence stringBuilder = new StringBuilder();
        Object obj = 1;
        ImmutableList immutableList = stickerPack.s;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) immutableList.get(i);
            if (obj == null) {
                stringBuilder.append('\n');
            } else {
                obj = null;
            }
            stringBuilder.append(str);
        }
        this.f16242l.setText(stringBuilder);
    }
}
