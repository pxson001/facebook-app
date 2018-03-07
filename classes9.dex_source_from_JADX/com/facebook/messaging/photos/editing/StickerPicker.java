package com.facebook.messaging.photos.editing;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import com.facebook.common.loader.AbstractFbLoaderCallback;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.photos.editing.PhotoEditingController.C18935;
import com.facebook.stickers.client.StickersLoader;
import com.facebook.stickers.keyboard.StickerKeyboardMetadataLoader;
import com.facebook.stickers.keyboard.StickerKeyboardMetadataLoader.Params;
import com.facebook.stickers.keyboard.StickerKeyboardMetadataLoader.Results;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerPack;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.CustomViewUtils;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: dialtone_switcher_enter_full_fb_upsell_dialog_confirm */
public class StickerPicker extends CustomFrameLayout {
    @Inject
    public StickerKeyboardMetadataLoader f16253a;
    @Inject
    public StickersLoader f16254b;
    public State f16255c;
    public RotatingGridLayoutManager f16256d;
    public RotatingGridLayoutManager f16257e;
    public List<StickerPack> f16258f;
    public StickerPackAdapter f16259g;
    public StickerListAdapter f16260h;
    public RecyclerView f16261i;
    public RecyclerView f16262j;
    public C18935 f16263k;
    public float f16264l;
    public final int f16265m;
    public final int f16266n;
    public final int f16267o;
    public final int f16268p;
    public final int f16269q;
    public final int f16270r;

    /* compiled from: dialtone_switcher_enter_full_fb_upsell_dialog_confirm */
    public class C19111 {
        public final /* synthetic */ StickerPicker f16248a;

        C19111(StickerPicker stickerPicker) {
            this.f16248a = stickerPicker;
        }
    }

    /* compiled from: dialtone_switcher_enter_full_fb_upsell_dialog_confirm */
    public class C19122 {
        public final /* synthetic */ StickerPicker f16249a;

        C19122(StickerPicker stickerPicker) {
            this.f16249a = stickerPicker;
        }
    }

    /* compiled from: dialtone_switcher_enter_full_fb_upsell_dialog_confirm */
    class C19133 extends SpanSizeLookup {
        final /* synthetic */ StickerPicker f16250b;

        C19133(StickerPicker stickerPicker) {
            this.f16250b = stickerPicker;
        }

        public final int m16333a(int i) {
            return 1;
        }
    }

    /* compiled from: dialtone_switcher_enter_full_fb_upsell_dialog_confirm */
    class C19144 extends SpanSizeLookup {
        final /* synthetic */ StickerPicker f16251b;

        C19144(StickerPicker stickerPicker) {
            this.f16251b = stickerPicker;
        }

        public final int m16334a(int i) {
            int itemViewType = this.f16251b.f16260h.getItemViewType(i);
            if (itemViewType == 0 || itemViewType == 2) {
                return this.f16251b.f16256d.c;
            }
            return 1;
        }
    }

    /* compiled from: dialtone_switcher_enter_full_fb_upsell_dialog_confirm */
    public class C19155 extends AbstractFbLoaderCallback<Params, Results, Throwable> {
        final /* synthetic */ StickerPicker f16252a;

        public C19155(StickerPicker stickerPicker) {
            this.f16252a = stickerPicker;
        }

        public final void m16335b(Object obj, Object obj2) {
            Results results = (Results) obj2;
            StickerPicker stickerPicker = this.f16252a;
            ImmutableList immutableList = results.a;
            stickerPicker.f16258f = immutableList;
            if (stickerPicker.f16259g != null) {
                stickerPicker.f16259g.m16331a(immutableList);
            }
        }
    }

    /* compiled from: dialtone_switcher_enter_full_fb_upsell_dialog_confirm */
    public enum State {
        HIDDEN,
        PACKLIST,
        STICKERLIST
    }

    public static void m16336a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        StickerPicker stickerPicker = (StickerPicker) obj;
        StickerKeyboardMetadataLoader a = StickerKeyboardMetadataLoader.a(fbInjector);
        StickersLoader b = StickersLoader.b(fbInjector);
        stickerPicker.f16253a = a;
        stickerPicker.f16254b = b;
    }

    public StickerPicker(Context context, int i, int i2) {
        super(context);
        Class cls = StickerPicker.class;
        m16336a(this, getContext());
        setContentView(2130907238);
        CustomViewUtils.b(this, new ColorDrawable(getResources().getColor(2131362541)));
        this.f16253a.a();
        this.f16253a.a(new C19155(this));
        this.f16253a.a(new Params(false, StickerInterface.COMPOSER));
        this.f16253a.a(new Params(true, StickerInterface.COMPOSER));
        if (getResources().getConfiguration().orientation == 1) {
            this.f16269q = 3;
            this.f16270r = 5;
        } else {
            this.f16269q = 5;
            this.f16270r = 3;
        }
        this.f16265m = i2;
        this.f16266n = i;
        this.f16267o = i;
        this.f16268p = i2;
        this.f16259g = new StickerPackAdapter();
        this.f16259g.m16331a(this.f16258f);
        this.f16259g.f16241b = new C19111(this);
        this.f16260h = new StickerListAdapter(this.f16254b);
        this.f16260h.f16237d = new C19122(this);
        this.f16261i = (RecyclerView) findViewById(2131567653);
        this.f16262j = (RecyclerView) findViewById(2131567654);
        this.f16257e = new RotatingGridLayoutManager(getContext(), this.f16269q);
        this.f16257e.h = new C19133(this);
        this.f16261i.setLayoutManager(this.f16257e);
        this.f16261i.setAdapter(this.f16259g);
        this.f16256d = new RotatingGridLayoutManager(getContext(), this.f16269q);
        this.f16256d.h = new C19144(this);
        this.f16262j.setLayoutManager(this.f16256d);
        this.f16262j.setAdapter(this.f16260h);
    }

    public void setStateAndVisibilities(State state) {
        this.f16255c = state;
        if (state == State.HIDDEN) {
            setVisibility(8);
            this.f16261i.setVisibility(8);
            this.f16262j.setVisibility(8);
        } else if (state == State.PACKLIST) {
            setVisibility(0);
            this.f16261i.setVisibility(0);
            this.f16262j.setVisibility(8);
        } else if (state == State.STICKERLIST) {
            setVisibility(0);
            this.f16261i.setVisibility(8);
            this.f16262j.setVisibility(0);
        }
    }
}
