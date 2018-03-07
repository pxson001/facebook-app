package com.facebook.slideshow.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.recyclerview.BetterRecyclerView.ViewHolder;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: PLAYBACK_DURATION */
public class DragSortThumbnailListAdapter extends Adapter {
    public static final CallerContext f12564a = CallerContext.a(PlayableSlideshowView.class, "slideshow_in_composer");
    public final Context f12565b;
    private final LayoutInflater f12566c;
    public final SecureContextHelper f12567d;
    public ArrayList<MediaItem> f12568e;

    /* compiled from: PLAYBACK_DURATION */
    class C14851 implements OnClickListener {
        final /* synthetic */ DragSortThumbnailListAdapter f12562a;

        C14851(DragSortThumbnailListAdapter dragSortThumbnailListAdapter) {
            this.f12562a = dragSortThumbnailListAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1028024182);
            Builder i = new Builder(SimplePickerSource.SLIDESHOW_EDIT).b(3, 7).a(ImmutableList.copyOf(this.f12562a.f12568e)).a(Action.NONE).i();
            i.d.k = false;
            this.f12562a.f12567d.a(SimplePickerIntent.a(this.f12562a.f12565b, i.k()), 0, (Activity) this.f12562a.f12565b);
            Logger.a(2, EntryType.UI_INPUT_END, 1536101184, a);
        }
    }

    /* compiled from: PLAYBACK_DURATION */
    public class MediaItemViewHolder extends ViewHolder {
        public final SelectableSlideshowThumbnailView f12563m;

        public MediaItemViewHolder(View view) {
            super(view);
            this.f12563m = (SelectableSlideshowThumbnailView) FindViewUtil.b(view, 2131562910);
        }
    }

    /* compiled from: PLAYBACK_DURATION */
    class OpenPickerViewHolder extends ViewHolder {
        public OpenPickerViewHolder(View view) {
            super(view);
        }
    }

    @Inject
    public DragSortThumbnailListAdapter(Context context, SecureContextHelper secureContextHelper) {
        this.f12565b = context;
        this.f12566c = LayoutInflater.from(context);
        this.f12567d = secureContextHelper;
    }

    public final RecyclerView.ViewHolder m12968a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new OpenPickerViewHolder(this.f12566c.inflate(2130907131, viewGroup, false));
        }
        return new MediaItemViewHolder(this.f12566c.inflate(2130907133, viewGroup, false));
    }

    public final void m12969a(RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == 1) {
            ((MediaItemViewHolder) viewHolder).f12563m.a(((MediaItem) this.f12568e.get(i)).f(), f12564a);
            return;
        }
        viewHolder.a.setOnClickListener(new C14851(this));
    }

    public final int aZ_() {
        if (this.f12568e == null) {
            return 1;
        }
        return this.f12568e.size() < 7 ? this.f12568e.size() + 1 : this.f12568e.size();
    }

    public int getItemViewType(int i) {
        return (this.f12568e == null || i == this.f12568e.size()) ? 0 : 1;
    }
}
