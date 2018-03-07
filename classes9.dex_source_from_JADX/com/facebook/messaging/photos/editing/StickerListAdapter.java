package com.facebook.messaging.photos.editing;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.loader.AbstractFbLoaderCallback;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.photos.editing.PhotoEditingController.C18935;
import com.facebook.messaging.photos.editing.StickerPicker.C19122;
import com.facebook.messaging.photos.editing.StickerPicker.State;
import com.facebook.stickers.client.StickersLoader;
import com.facebook.stickers.client.StickersLoader.Params;
import com.facebook.stickers.client.StickersLoader.Results;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerPack;
import java.util.ArrayList;
import java.util.List;

/* compiled from: didRemoveMember() not supported yet */
public class StickerListAdapter extends Adapter<ViewHolder> {
    public StickerPack f16234a;
    public StickersLoader f16235b;
    public List<Sticker> f16236c;
    public C19122 f16237d;

    /* compiled from: didRemoveMember() not supported yet */
    public class C19081 extends AbstractFbLoaderCallback<Params, Results, Throwable> {
        final /* synthetic */ StickerListAdapter f16231a;

        public C19081(StickerListAdapter stickerListAdapter) {
            this.f16231a = stickerListAdapter;
        }

        public final void m16323b(Object obj, Object obj2) {
            Results results = (Results) obj2;
            StickerListAdapter stickerListAdapter = this.f16231a;
            stickerListAdapter.f16236c = results.a;
            stickerListAdapter.notifyDataSetChanged();
        }
    }

    public StickerListAdapter(StickersLoader stickersLoader) {
        this.f16235b = stickersLoader;
    }

    public final void m16328a(StickerPack stickerPack) {
        if (stickerPack != this.f16234a) {
            this.f16236c = new ArrayList();
            boolean f = m16325f();
            this.f16234a = stickerPack;
            notifyDataSetChanged();
            if (this.f16234a != null) {
                this.f16235b.a();
                this.f16235b.a(new C19081(this));
                this.f16235b.a(new Params(this.f16234a.t));
                j_(0);
                if (m16325f() != f) {
                    notifyDataSetChanged();
                } else if (m16325f()) {
                    j_(aZ_() - 1);
                }
            }
        }
    }

    public final ViewHolder m16326a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i == 0) {
            return new StickerPackInfoViewHolder(from.inflate(2130907237, viewGroup, false));
        }
        if (i == 1) {
            return new StickerViewHolder(from.inflate(2130907233, viewGroup, false));
        }
        if (i == 2) {
            return new StickerPackCopyrightsViewHolder(from.inflate(2130907235, viewGroup, false));
        }
        return null;
    }

    public final void m16327a(ViewHolder viewHolder, int i) {
        if (viewHolder instanceof StickerPackInfoViewHolder) {
            StickerPackInfoViewHolder stickerPackInfoViewHolder = (StickerPackInfoViewHolder) viewHolder;
            StickerPack stickerPack = this.f16234a;
            if (stickerPack == null || stickerPack.e.toString().isEmpty()) {
                stickerPackInfoViewHolder.f16243l.setImageBitmap(null);
            } else {
                stickerPackInfoViewHolder.f16243l.a(stickerPack.e, CallerContext.a(StickerPackInfoViewHolder.class));
            }
            stickerPackInfoViewHolder.f16244m.setText(stickerPack.b);
            stickerPackInfoViewHolder.f16245n.setText(stickerPack.c);
            stickerPackInfoViewHolder.f16246o.setText(stickerPack.d);
        } else if (viewHolder instanceof StickerPackCopyrightsViewHolder) {
            ((StickerPackCopyrightsViewHolder) viewHolder).m16332a(this.f16234a);
        } else if (viewHolder instanceof StickerViewHolder) {
            final int i2 = i - 1;
            StickerViewHolder stickerViewHolder = (StickerViewHolder) viewHolder;
            if (this.f16236c == null || this.f16236c.isEmpty()) {
                stickerViewHolder.f16271l.setImageResource(2130841095);
            } else {
                stickerViewHolder.f16271l.a(((Sticker) this.f16236c.get(i2)).c, CallerContext.a(StickerViewHolder.class));
            }
            stickerViewHolder.a.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ StickerListAdapter f16233b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1459976141);
                    if (this.f16233b.f16237d != null && i2 >= 0 && i2 < this.f16233b.f16236c.size()) {
                        Sticker sticker = (Sticker) this.f16233b.f16236c.get(i2);
                        StickerPicker stickerPicker = this.f16233b.f16237d.f16249a;
                        if (stickerPicker.f16263k != null) {
                            C18935 c18935 = stickerPicker.f16263k;
                            c18935.f16078a.f16087h.m16295a(new StickerLayer(sticker));
                        }
                        stickerPicker.setStateAndVisibilities(State.HIDDEN);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -1512295136, a);
                }
            });
        }
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == aZ_() - 1 && m16325f()) {
            return 2;
        }
        return 1;
    }

    public final int aZ_() {
        if (this.f16236c == null || this.f16236c.isEmpty()) {
            return this.f16234a != null ? this.f16234a.t.size() + m16324e() : 0;
        } else {
            return this.f16236c.size() + m16324e();
        }
    }

    private int m16324e() {
        if (m16325f()) {
            return 2;
        }
        return 1;
    }

    private boolean m16325f() {
        return (this.f16234a == null || this.f16234a.s.isEmpty()) ? false : true;
    }
}
