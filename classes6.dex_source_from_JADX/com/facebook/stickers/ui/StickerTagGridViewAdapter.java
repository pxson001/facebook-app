package com.facebook.stickers.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerTag;
import com.facebook.stickers.search.StickerSearchContainer;
import com.facebook.stickers.search.StickerSearchContainer.AnonymousClass10;
import com.facebook.stickers.search.StickerSearchContainer.State;
import com.facebook.stickers.search.TaggedStickersLoader.Params;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: dt */
public class StickerTagGridViewAdapter extends BaseAdapter {
    private Context f17071a;
    private ImmutableList<StickerTag> f17072b;
    public AnonymousClass10 f17073c;

    public StickerTagGridViewAdapter(Context context) {
        this.f17071a = context;
    }

    public final void m24764a(ImmutableList<StickerTag> immutableList) {
        this.f17072b = immutableList;
        AdapterDetour.a(this, -406576200);
    }

    public int getCount() {
        return this.f17072b.size();
    }

    public Object getItem(int i) {
        return this.f17072b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return m24763a(view, getItem(i));
    }

    private View m24763a(@Nullable View view, Object obj) {
        View stickerTagItemView;
        if (view == null) {
            stickerTagItemView = new StickerTagItemView(this.f17071a);
        } else {
            stickerTagItemView = view;
        }
        final StickerTag stickerTag = (StickerTag) obj;
        StickerTagItemView stickerTagItemView2 = (StickerTagItemView) stickerTagItemView;
        ((GradientDrawable) stickerTagItemView2.getBackground()).setColor(Color.parseColor("#" + stickerTag.f5001c));
        stickerTagItemView2.f17076c.setText(StringUtil.c(stickerTag.f5000b));
        if (stickerTag.f5004f.equals("")) {
            stickerTagItemView2.f17077d.a(null, StickerTagItemView.f17074b);
        } else {
            Uri parse = Uri.parse(stickerTag.f5004f);
            int dimensionPixelSize = stickerTagItemView2.getContext().getResources().getDimensionPixelSize(2131428602);
            ImageRequestBuilder a = ImageRequestBuilder.a(parse);
            a.d = new ResizeOptions(dimensionPixelSize, dimensionPixelSize);
            stickerTagItemView2.f17077d.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) stickerTagItemView2.f17075a.a(StickerTagItemView.f17074b).c(true)).c(a.m())).s());
        }
        stickerTagItemView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ StickerTagGridViewAdapter f17070b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1045983670);
                if (this.f17070b.f17073c != null) {
                    AnonymousClass10 anonymousClass10 = this.f17070b.f17073c;
                    StickerTag stickerTag = stickerTag;
                    String c = StringUtil.c(stickerTag.f5000b);
                    anonymousClass10.f16789a.f16825K.mo1274a(c);
                    if ((anonymousClass10.f16789a.f16831Q == StickerInterface.SMS || !anonymousClass10.f16789a.f16850u.m23889a()) && !anonymousClass10.f16789a.f16829O) {
                        anonymousClass10.f16789a.f16828N = true;
                        anonymousClass10.f16789a.f16855z.setText(c);
                        anonymousClass10.f16789a.f16855z.setSelection(anonymousClass10.f16789a.f16855z.getText().length());
                        anonymousClass10.f16789a.f16848s.m23904a(stickerTag.f4999a);
                        StickerSearchContainer stickerSearchContainer = anonymousClass10.f16789a;
                        String str = stickerTag.f4999a;
                        stickerSearchContainer.f16840k.m11055a();
                        StickerSearchContainer.setCurrentState(stickerSearchContainer, State.WAIT_FOR_TAGGED_STICKERS);
                        stickerSearchContainer.f16840k.m11057a(new Params(str));
                    }
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1423083573, a);
            }
        });
        return stickerTagItemView;
    }
}
