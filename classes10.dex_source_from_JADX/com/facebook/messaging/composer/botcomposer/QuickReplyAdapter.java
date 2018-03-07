package com.facebook.messaging.composer.botcomposer;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.inject.Assisted;
import com.facebook.messaging.composer.botcomposer.QuickReplyController.C02852;
import com.facebook.messaging.composer.botcomposer.QuickReplyViewHolder.C02911;
import com.facebook.messaging.model.messagemetadata.QuickReplyItem;
import java.util.List;
import javax.inject.Inject;

/* compiled from: tg_TJ */
public class QuickReplyAdapter extends Adapter<QuickReplyViewHolder> {
    private final C02852 f1744a;
    private List<QuickReplyItem> f1745b;

    public final void m1720a(ViewHolder viewHolder, int i) {
        QuickReplyViewHolder quickReplyViewHolder = (QuickReplyViewHolder) viewHolder;
        if (this.f1745b != null) {
            QuickReplyItem quickReplyItem = (QuickReplyItem) this.f1745b.get(i);
            C02852 c02852 = this.f1744a;
            quickReplyViewHolder.f1778l.setText(quickReplyItem.a);
            quickReplyViewHolder.f1779m.setOnClickListener(new C02911(quickReplyViewHolder, c02852, quickReplyItem));
        }
    }

    @Inject
    public QuickReplyAdapter(@Assisted C02852 c02852) {
        this.f1744a = c02852;
    }

    public final ViewHolder m1719a(ViewGroup viewGroup, int i) {
        return new QuickReplyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130905643, viewGroup, false));
    }

    public final int aZ_() {
        if (this.f1745b == null) {
            return 0;
        }
        return this.f1745b.size();
    }

    public final void m1721a(List<QuickReplyItem> list) {
        this.f1745b = list;
        notifyDataSetChanged();
    }
}
