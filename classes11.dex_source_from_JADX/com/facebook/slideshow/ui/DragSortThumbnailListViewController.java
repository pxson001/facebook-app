package com.facebook.slideshow.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.facebook.inject.Assisted;
import com.facebook.ipc.media.MediaItem;
import com.facebook.slideshow.analytics.SlideshowLogger;
import com.facebook.slideshow.ui.DragSortThumbnailListAdapter.MediaItemViewHolder;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: PLACE_INFO */
public class DragSortThumbnailListViewController {
    public ImmutableList<MediaItem> f12571a;
    public DragSortThumbnailListView f12572b;
    public DragSortThumbnailListAdapter f12573c;
    public SlideshowLogger f12574d;
    @Nullable
    public ItemListListener f12575e = this.f12558b;
    public String f12576f;

    /* compiled from: PLACE_INFO */
    public interface ItemListListener {
        void mo359a();

        void mo360a(ImmutableList<MediaItem> immutableList);

        void mo361b();
    }

    /* compiled from: PLACE_INFO */
    class SlideshowDragCallback extends Callback {
        final /* synthetic */ DragSortThumbnailListViewController f12570a;

        public SlideshowDragCallback(DragSortThumbnailListViewController dragSortThumbnailListViewController) {
            this.f12570a = dragSortThumbnailListViewController;
        }

        public final int m12974a(ViewHolder viewHolder) {
            if (viewHolder.e == 0) {
                return Callback.b(0, 0);
            }
            return Callback.b(15, 0);
        }

        @Nullable
        public final ViewHolder m12975a(ViewHolder viewHolder, List<ViewHolder> list, int i, int i2) {
            ViewHolder viewHolder2 = null;
            int i3 = Integer.MAX_VALUE;
            int height = i2 + viewHolder.a.getHeight();
            int width = i + viewHolder.a.getWidth();
            int left = i - viewHolder.a.getLeft();
            int i4 = 0;
            while (i4 < list.size()) {
                ViewHolder viewHolder3;
                int i5;
                ViewHolder viewHolder4 = (ViewHolder) list.get(i4);
                if (i2 <= viewHolder4.a.getBottom() && height >= viewHolder4.a.getTop()) {
                    int width2 = (viewHolder4.a.getWidth() / 2) + viewHolder4.a.getLeft();
                    int abs = Math.abs(viewHolder4.a.getLeft() - i);
                    if (((left < 0 && width > width2) || (left > 0 && i < width2)) && i3 > abs) {
                        int i6 = abs;
                        viewHolder3 = viewHolder4;
                        i5 = i6;
                        i4++;
                        viewHolder2 = viewHolder3;
                        i3 = i5;
                    }
                }
                i5 = i3;
                viewHolder3 = viewHolder2;
                i4++;
                viewHolder2 = viewHolder3;
                i3 = i5;
            }
            return viewHolder2;
        }

        public final void m12976a(ViewHolder viewHolder, int i) {
            super.a(viewHolder, i);
            if (viewHolder != null && viewHolder.e == 1 && i == 2) {
                ((MediaItemViewHolder) viewHolder).f12563m.setIsSelected(true);
                this.f12570a.f12572b.f12569l = true;
                if (this.f12570a.f12575e != null) {
                    this.f12570a.f12575e.mo359a();
                }
            }
        }

        public final boolean m12980b(ViewHolder viewHolder) {
            if (viewHolder.e == 1) {
                return true;
            }
            return false;
        }

        public final boolean m12977a(ViewHolder viewHolder, ViewHolder viewHolder2) {
            int e = viewHolder.e();
            int e2 = viewHolder2.e();
            DragSortThumbnailListAdapter dragSortThumbnailListAdapter = this.f12570a.f12573c;
            dragSortThumbnailListAdapter.f12568e.add(e2, (MediaItem) dragSortThumbnailListAdapter.f12568e.remove(e));
            dragSortThumbnailListAdapter.b(e, e2);
            return true;
        }

        public final void m12978b(RecyclerView recyclerView, ViewHolder viewHolder) {
            int i = 0;
            super.b(recyclerView, viewHolder);
            ((MediaItemViewHolder) viewHolder).f12563m.setIsSelected(false);
            this.f12570a.f12572b.f12569l = false;
            if (this.f12570a.f12575e != null) {
                this.f12570a.f12575e.mo361b();
            }
            ArrayList arrayList = this.f12570a.f12573c.f12568e;
            while (i < arrayList.size()) {
                if (arrayList.get(i) != this.f12570a.f12571a.get(i)) {
                    this.f12570a.f12574d.b = this.f12570a.f12576f;
                    this.f12570a.f12574d.g();
                    this.f12570a.f12571a = ImmutableList.copyOf(arrayList);
                    if (this.f12570a.f12575e != null) {
                        this.f12570a.f12575e.mo360a(this.f12570a.f12571a);
                        return;
                    }
                    return;
                }
                i++;
            }
        }

        public final void m12981f() {
        }

        public final boolean m12979b() {
            return false;
        }
    }

    @Inject
    public DragSortThumbnailListViewController(@Assisted DragSortThumbnailListView dragSortThumbnailListView, @Assisted String str, SlideshowLogger slideshowLogger, DragSortThumbnailListAdapter dragSortThumbnailListAdapter) {
        this.f12572b = dragSortThumbnailListView;
        this.f12576f = str;
        this.f12574d = slideshowLogger;
        this.f12573c = dragSortThumbnailListAdapter;
        m12985b();
    }

    private void m12985b() {
        this.f12572b.setAdapter(this.f12573c);
        new ItemTouchHelper(new SlideshowDragCallback(this)).a(this.f12572b);
    }

    public final void m12992a(ImmutableList<MediaItem> immutableList) {
        this.f12571a = immutableList;
        DragSortThumbnailListAdapter dragSortThumbnailListAdapter = this.f12573c;
        dragSortThumbnailListAdapter.f12568e = new ArrayList(immutableList);
        dragSortThumbnailListAdapter.notifyDataSetChanged();
    }

    public final ImmutableList<MediaItem> m12990a() {
        return this.f12571a;
    }

    public final void m12991a(ItemListListener itemListListener) {
        this.f12575e = itemListListener;
    }
}
