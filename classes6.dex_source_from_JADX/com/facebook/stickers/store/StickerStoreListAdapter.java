package com.facebook.stickers.store;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.facebook.common.util.ContextUtils;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.store.StickerStoreFragment.C12162;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.DragSortListView.DragSortListAdapter;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: e251fd3ac26a3fdfb94f601894577cce */
public class StickerStoreListAdapter extends ArrayAdapter<StickerPack> implements DragSortListAdapter {
    public C12162 f16977a;
    public LinkedHashMap<String, StickerPack> f16978b;
    public boolean f16979c;
    public boolean f16980d;
    private Context f16981e = ContextUtils.a(getContext(), 2130773101, 2131625136);
    private final StickerInterface f16982f;

    public StickerStoreListAdapter(Context context, StickerInterface stickerInterface) {
        super(context, 0);
        this.f16982f = stickerInterface;
    }

    public final void m24708a(List<StickerPack> list, LinkedHashMap<String, StickerPack> linkedHashMap, boolean z) {
        this.f16978b = linkedHashMap;
        this.f16979c = z;
        this.f16980d = false;
        setNotifyOnChange(false);
        clear();
        for (StickerPack stickerPack : list) {
            if (!this.f16979c || this.f16978b.containsKey(stickerPack.f4955a)) {
                add(stickerPack);
            }
        }
        AdapterDetour.a(this, 822042078);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        StickerStoreListItemView stickerStoreListItemView;
        if ((view instanceof StickerStoreListItemView) && ((StickerStoreListItemView) view).f17005w) {
            stickerStoreListItemView = (StickerStoreListItemView) view;
        } else {
            stickerStoreListItemView = new StickerStoreListItemView(this.f16981e);
        }
        final StickerPack stickerPack = (StickerPack) getItem(i);
        final boolean containsKey = this.f16978b.containsKey(stickerPack.f4955a);
        stickerStoreListItemView.m24715a(stickerPack, containsKey, null, this.f16979c, this.f16982f);
        stickerStoreListItemView.f16990h.setOnClickListener(new OnClickListener(this, null) {
            final /* synthetic */ StickerStoreListAdapter f16973d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1038538917);
                if (this.f16973d.f16977a != null) {
                    this.f16973d.f16977a.m24650a(stickerPack, containsKey, null);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -944058744, a);
            }
        });
        stickerStoreListItemView.f16989g.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ StickerStoreListAdapter f16976c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1445750827);
                if (this.f16976c.f16977a != null) {
                    this.f16976c.f16977a.m24649a(stickerPack, this.f16976c, this.f16976c.f16979c, stickerStoreListItemView);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1502235843, a);
            }
        });
        return stickerStoreListItemView;
    }

    public final int mo1289b() {
        return 0;
    }

    public final int mo1290c() {
        return getCount() - 1;
    }
}
