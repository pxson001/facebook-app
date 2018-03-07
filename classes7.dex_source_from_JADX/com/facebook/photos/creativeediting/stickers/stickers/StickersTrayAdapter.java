package com.facebook.photos.creativeediting.stickers.stickers;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.util.TriState;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.Assisted;
import com.facebook.photos.creativeediting.stickers.services.StickerPackMetadataLoader;
import com.facebook.photos.creativeediting.stickers.services.StickerPackMetadataLoader.Params;
import com.facebook.photos.creativeediting.stickers.services.StickerPackMetadataLoader.Results;
import com.facebook.stickers.model.StickerPack;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mPaintMapConfig */
public class StickersTrayAdapter extends BaseAdapter {
    public static final Object f9646a = new Object();
    private static final CallerContext f9647b = CallerContext.a(StickersTrayAdapter.class, "stickers_in_composer");
    public ImmutableList<StickerPack> f9648c = RegularImmutableList.a;
    public StickerPackMetadataLoader f9649d;
    private final Provider<TriState> f9650e;
    private Context f9651f;

    /* compiled from: mPaintMapConfig */
    public class C07881 implements Callback<Params, Results, Throwable> {
        final /* synthetic */ StickersTrayAdapter f9645a;

        public C07881(StickersTrayAdapter stickersTrayAdapter) {
            this.f9645a = stickersTrayAdapter;
        }

        public final void m11570b(Object obj, Object obj2) {
            Results results = (Results) obj2;
            BaseAdapter baseAdapter = this.f9645a;
            if (results.f9616a != null && results.f9616a.size() > 0 && baseAdapter.f9648c.size() != results.f9616a.size()) {
                baseAdapter.f9648c = ImmutableList.copyOf(results.f9616a);
                AdapterDetour.a(baseAdapter, -124078496);
            }
        }

        public final /* bridge */ /* synthetic */ void m11571c(Object obj, Object obj2) {
        }
    }

    @Inject
    public StickersTrayAdapter(@Assisted Context context, StickerPackMetadataLoader stickerPackMetadataLoader, Provider<TriState> provider) {
        this.f9651f = context;
        this.f9649d = stickerPackMetadataLoader;
        this.f9650e = provider;
    }

    protected final boolean m11572b() {
        return ((TriState) this.f9650e.get()).asBoolean(false);
    }

    public int getCount() {
        return (m11572b() ? 1 : 0) + this.f9648c.size();
    }

    public Object getItem(int i) {
        if (!m11572b()) {
            return this.f9648c.get(i);
        }
        if (i == 0) {
            return f9646a;
        }
        return this.f9648c.get(i - 1);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Object item = getItem(i);
        if (item == f9646a) {
            return LayoutInflater.from(this.f9651f).inflate(2130906581, viewGroup, false);
        }
        if (view == null || view.findViewById(2131565159) == null) {
            view = LayoutInflater.from(this.f9651f).inflate(2130906583, viewGroup, false);
        }
        FbDraweeView fbDraweeView = (FbDraweeView) view.findViewById(2131565159);
        Uri uri = ((StickerPack) item).e;
        fbDraweeView.setScaleType(ScaleType.CENTER_INSIDE);
        fbDraweeView.a(uri, f9647b);
        return view;
    }
}
