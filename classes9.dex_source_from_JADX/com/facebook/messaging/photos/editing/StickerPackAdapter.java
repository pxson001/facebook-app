package com.facebook.messaging.photos.editing;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.photos.editing.StickerPicker.C19111;
import com.facebook.messaging.photos.editing.StickerPicker.State;
import com.facebook.stickers.model.StickerPack;
import java.util.List;

/* compiled from: dialtone_zero_balance_tooltip */
public class StickerPackAdapter extends Adapter<ViewHolder> {
    public List<StickerPack> f16240a;
    public C19111 f16241b;

    public final void m16331a(List<StickerPack> list) {
        this.f16240a = list;
        notifyDataSetChanged();
    }

    public final ViewHolder m16329a(ViewGroup viewGroup, int i) {
        return new StickerPackViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130907236, viewGroup, false));
    }

    public final void m16330a(ViewHolder viewHolder, final int i) {
        StickerPackViewHolder stickerPackViewHolder = (StickerPackViewHolder) viewHolder;
        stickerPackViewHolder.f16247l.a(((StickerPack) this.f16240a.get(i)).e, CallerContext.a(StickerPackViewHolder.class));
        stickerPackViewHolder.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ StickerPackAdapter f16239b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 788828724);
                if (this.f16239b.f16241b != null) {
                    StickerPack stickerPack = (StickerPack) this.f16239b.f16240a.get(i);
                    StickerPicker stickerPicker = this.f16239b.f16241b.f16248a;
                    stickerPicker.setStateAndVisibilities(State.STICKERLIST);
                    stickerPicker.f16260h.m16328a(stickerPack);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1979021761, a);
            }
        });
    }

    public int getItemViewType(int i) {
        return 2;
    }

    public final int aZ_() {
        return this.f16240a != null ? this.f16240a.size() : 0;
    }
}
