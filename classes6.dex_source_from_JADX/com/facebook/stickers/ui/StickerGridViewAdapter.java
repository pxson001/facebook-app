package com.facebook.stickers.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerUtil;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: durationMs */
public class StickerGridViewAdapter extends BaseAdapter {
    private final Boolean f17060a;
    private final StickerUrls f17061b;
    private final FbDraweeControllerBuilder f17062c;
    private final Context f17063d;
    private final String f17064e;
    private final Sizes f17065f;
    private final LayoutInflater f17066g;
    private ImmutableList<Sticker> f17067h;
    public CallerContext f17068i = CallerContext.a(StickerGridViewAdapter.class, "sticker_keyboard");

    /* compiled from: durationMs */
    class C12331 extends BaseControllerListener {
        final /* synthetic */ StickerGridViewAdapter f17059a;

        C12331(StickerGridViewAdapter stickerGridViewAdapter) {
            this.f17059a = stickerGridViewAdapter;
        }

        public final void m24759a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m24760a(i);
    }

    @Inject
    public StickerGridViewAdapter(StickerUrls stickerUrls, FbDraweeControllerBuilder fbDraweeControllerBuilder, Provider<Boolean> provider, @Assisted Context context, @Assisted String str, @Assisted Sizes sizes) {
        this.f17060a = (Boolean) provider.get();
        this.f17061b = stickerUrls;
        this.f17062c = fbDraweeControllerBuilder;
        this.f17063d = context;
        this.f17064e = str;
        this.f17065f = sizes;
        this.f17066g = LayoutInflater.from(this.f17063d).cloneInContext(this.f17063d);
    }

    public final void m24761a(ImmutableList<Sticker> immutableList) {
        this.f17067h = immutableList;
        AdapterDetour.a(this, 1709952319);
    }

    public int getCount() {
        return this.f17067h.size();
    }

    private Sticker m24760a(int i) {
        return (Sticker) this.f17067h.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Object[] objArr;
        Object obj;
        ControllerListener controllerListener = null;
        Sticker a = m24760a(i);
        view = (FbDraweeView) view;
        if (view == null) {
            FbDraweeView fbDraweeView = (FbDraweeView) this.f17066g.inflate(2130905854, viewGroup, false);
            int i2 = this.f17065f.f7733i;
            int c = this.f17065f.m11036c();
            int d = this.f17065f.m11037d();
            int f = this.f17065f.m11039f();
            int e = this.f17065f.m11038e();
            int g = this.f17065f.m11040g();
            fbDraweeView.setLayoutParams(new LayoutParams(i2, c));
            fbDraweeView.setPadding(d, f, e, g);
            view = fbDraweeView;
        }
        if (StickerUtil.m7770a(a) && this.f17060a.booleanValue()) {
            ImageRequest[] b = this.f17061b.m24771b(a);
            ImageRequest c2 = StickerUrls.m24770c(a);
            C12331 c12331 = new C12331(this);
            objArr = b;
            obj = c2;
            controllerListener = c12331;
        } else {
            objArr = StickerUrls.m24768a(a);
            obj = null;
        }
        view.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f17062c.a(this.f17068i).a(objArr)).d(obj)).a(controllerListener)).s());
        view.setContentDescription(this.f17063d.getString(2131231708));
        return view;
    }
}
