package com.facebook.messaging.emoji;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.facebook.ui.emoji.model.Emoji;

/* compiled from: manual_transfer_info */
public abstract class EmojiViewHolder extends ViewHolder {
    private Context f10891l;
    public Emoji f10892m;

    protected abstract void mo423a(Emoji emoji);

    public EmojiViewHolder(View view) {
        super(view);
        this.f10891l = view.getContext();
    }

    public final void m11309b(Emoji emoji) {
        this.f10892m = emoji;
        mo423a(emoji);
        if (emoji.d != 0) {
            this.a.setContentDescription(this.f10891l.getString(emoji.d));
        } else {
            this.a.setContentDescription(this.f10891l.getString(2131232443));
        }
    }
}
