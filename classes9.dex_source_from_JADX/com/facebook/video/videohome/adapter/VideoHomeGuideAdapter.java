package com.facebook.video.videohome.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.inject.Assisted;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.VideoTopicListModel;
import com.facebook.video.videohome.adapter.viewholders.DefaultTopicClickListener;
import com.facebook.video.videohome.adapter.viewholders.HeaderViewHolder;
import com.facebook.video.videohome.adapter.viewholders.TopicViewHolder;
import com.facebook.video.videohome.adapter.viewholders.VideoTopicItemBaseViewHolder;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Inject;

/* compiled from: storedBalanceStatus */
public class VideoHomeGuideAdapter extends Adapter<VideoTopicItemBaseViewHolder> {
    public VideoTopicListModel f2749a;
    private DefaultTopicClickListener f2750b;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: storedBalanceStatus */
    public @interface ItemType {
    }

    public final ViewHolder m2641a(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130907716, viewGroup, false));
            case 1:
                return new TopicViewHolder(LayoutInflater.from(new ContextThemeWrapper(viewGroup.getContext(), 2131625885)).inflate(2130907717, viewGroup, false), this.f2750b);
            default:
                throw new IllegalStateException("Unexpected ViewType");
        }
    }

    public final void m2642a(ViewHolder viewHolder, int i) {
        VideoTopicItemBaseViewHolder videoTopicItemBaseViewHolder = (VideoTopicItemBaseViewHolder) viewHolder;
        switch (getItemViewType(i)) {
            case 0:
                videoTopicItemBaseViewHolder.mo81b(Integer.valueOf(2131237325));
                return;
            case 1:
                videoTopicItemBaseViewHolder.mo81b(this.f2749a.a().get(i - 1));
                return;
            default:
                throw new IllegalStateException("Unexpected ViewType");
        }
    }

    @Inject
    public VideoHomeGuideAdapter(@Assisted DefaultTopicClickListener defaultTopicClickListener) {
        this.f2750b = defaultTopicClickListener;
    }

    public final int aZ_() {
        int size;
        if (this.f2749a != null) {
            size = this.f2749a.a().size();
        } else {
            size = 0;
        }
        if (size == 0) {
            return 0;
        }
        return size + 1;
    }

    public int getItemViewType(int i) {
        return m2643e(i);
    }

    public final int m2643e(int i) {
        if (i == 0) {
            return 0;
        }
        return 1;
    }
}
