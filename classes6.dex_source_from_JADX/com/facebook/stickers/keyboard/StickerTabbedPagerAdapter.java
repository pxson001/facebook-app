package com.facebook.stickers.keyboard;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.common.util.ContextUtils;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.tabbedpager.ItemBasedTabbedPagerAdapter;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.resources.ui.FbTextView;
import com.facebook.stickers.analytics.DownloadPreviewStickerPacksLogger;
import com.facebook.stickers.analytics.StickerLogger;
import com.facebook.stickers.client.StickerAssetManager;
import com.facebook.stickers.client.StickersLoader.Params;
import com.facebook.stickers.keyboard.StickerKeyboardPackPopupTabItem.TabType;
import com.facebook.stickers.keyboard.StickerKeyboardView.C11642;
import com.facebook.stickers.keyboard.StickerPackPageView.C11754;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerUtil;
import com.facebook.stickers.perf.StickerSequences;
import com.facebook.stickers.preferences.StickerPrefKeys;
import com.facebook.stickers.search.ExpandableFrameLayout;
import com.facebook.stickers.search.StickerSearchContainer;
import com.facebook.stickers.search.StickerSearchContainer.StickerSearchListener;
import com.facebook.stickers.service.MessagesStickerServiceGatekeepers;
import com.facebook.stickers.store.StickerStoreActivity;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: edit_post_feature_capabilities */
public class StickerTabbedPagerAdapter implements ItemBasedTabbedPagerAdapter<StickerKeyboardTabItem> {
    private static final CallerContext f16746a = CallerContext.a(StickerKeyboardTabView.class, "sticker_keyboard");
    private static final int f16747b = TabViewType.values().length;
    public final Resources f16748c;
    public final DefaultAppChoreographer f16749d;
    private final StickerAssetManager f16750e;
    private final StickerKeyboardLogger f16751f;
    public final DownloadPreviewStickerPacksLogger f16752g;
    public final FbSharedPreferences f16753h;
    private final StickerPackPageViewProvider f16754i;
    public final Context f16755j;
    private final LayoutInflater f16756k;
    private final int f16757l;
    private final MessagesStickerServiceGatekeepers f16758m;
    public Sizes f16759n;
    public C11642 f16760o;
    private C11761 f16761p;
    private StickerKeyboardTabView f16762q;
    private ImmutableList<Sticker> f16763r = RegularImmutableList.a;
    private StickerPackPageView f16764s;
    @Nullable
    public ExpandableFrameLayout f16765t;
    @Nullable
    public StickerSearchContainer f16766u;
    @Nullable
    public Bundle f16767v;
    public StickerInterface f16768w;
    public String f16769x;

    /* compiled from: edit_post_feature_capabilities */
    public class C11761 {
        public final /* synthetic */ StickerTabbedPagerAdapter f16734a;

        C11761(StickerTabbedPagerAdapter stickerTabbedPagerAdapter) {
            this.f16734a = stickerTabbedPagerAdapter;
        }
    }

    /* compiled from: edit_post_feature_capabilities */
    public class StickerPackTabViewHolder extends ViewHolder {
        public final StickerKeyboardTabView f16745l;

        public StickerPackTabViewHolder(StickerKeyboardTabView stickerKeyboardTabView) {
            super(stickerKeyboardTabView);
            this.f16745l = stickerKeyboardTabView;
        }
    }

    /* compiled from: edit_post_feature_capabilities */
    enum TabViewType {
        SEARCH,
        RECENTS,
        STICKER_PACK
    }

    public final View mo1278a(Object obj, @Nullable View view, ViewGroup viewGroup, boolean z) {
        View d;
        final StickerKeyboardTabItem stickerKeyboardTabItem = (StickerKeyboardTabItem) obj;
        this.f16769x = z ? this.f16769x : stickerKeyboardTabItem.f16645c;
        if (stickerKeyboardTabItem == StickerKeyboardView.f16665a) {
            d = m24538d(stickerKeyboardTabItem);
        } else if (stickerKeyboardTabItem == StickerKeyboardView.f16666b) {
            ExpandableFrameLayout expandableFrameLayout = new ExpandableFrameLayout(this.f16755j);
            this.f16765t = expandableFrameLayout;
            this.f16766u = new StickerSearchContainer(this.f16755j, this.f16768w);
            this.f16766u.setStickerSearchListener(new StickerSearchListener(this) {
                final /* synthetic */ StickerTabbedPagerAdapter f16736b;

                public final void mo1273a(Sticker sticker) {
                    if (this.f16736b.f16760o != null) {
                        this.f16736b.f16760o.m24480a(sticker, stickerKeyboardTabItem.f16645c);
                    }
                }

                public final void mo1274a(String str) {
                    this.f16736b.f16760o.m24481a(str);
                }

                public final void mo1272a() {
                    this.f16736b.f16760o.f16653a.f16675G = true;
                    this.f16736b.f16760o.m24481a("");
                }

                public final void mo1275b() {
                    this.f16736b.f16760o.f16653a.f16675G = false;
                }
            });
            if (this.f16767v != null) {
                this.f16766u.f16827M = this.f16767v.getString("query");
                this.f16767v = null;
            }
            expandableFrameLayout.addView(this.f16766u);
            d = expandableFrameLayout;
        } else if (stickerKeyboardTabItem instanceof StickerKeyboardPackPopupTabItem) {
            StickerKeyboardPackPopupTabItem stickerKeyboardPackPopupTabItem = (StickerKeyboardPackPopupTabItem) stickerKeyboardTabItem;
            switch (stickerKeyboardPackPopupTabItem.f16647b) {
                case DOWNLOADED:
                    d = m24531a(stickerKeyboardPackPopupTabItem);
                    break;
                case DOWNLOAD_PREVIEW:
                    d = m24537b(stickerKeyboardPackPopupTabItem);
                    break;
                case PULSING_DOWNLOAD_PREVIEW:
                    d = m24537b(stickerKeyboardPackPopupTabItem);
                    break;
                case PROMOTED:
                    d = m24532a(stickerKeyboardPackPopupTabItem, viewGroup);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown item type");
            }
        } else {
            d = null;
        }
        if (!(!z || (stickerKeyboardTabItem instanceof StickerKeyboardPackPopupTabItem) || this.f16760o == null)) {
            this.f16760o.m24483c();
        }
        return d;
    }

    public final String mo1279a(Object obj) {
        return ((StickerKeyboardTabItem) obj).f16645c;
    }

    public final void mo1280a(ViewHolder viewHolder, Object obj) {
        StickerKeyboardTabItem stickerKeyboardTabItem = (StickerKeyboardTabItem) obj;
        switch (TabViewType.values()[m24536b(stickerKeyboardTabItem)]) {
            case RECENTS:
                return;
            case SEARCH:
                m24533a(viewHolder);
                return;
            case STICKER_PACK:
                m24534a(viewHolder, (StickerKeyboardPackPopupTabItem) stickerKeyboardTabItem);
                return;
            default:
                throw new IllegalArgumentException("Unknown item type");
        }
    }

    public final /* synthetic */ int mo1282c(Object obj) {
        return m24536b((StickerKeyboardTabItem) obj);
    }

    public final void mo1283d(Object obj) {
        StickerKeyboardTabItem stickerKeyboardTabItem = (StickerKeyboardTabItem) obj;
        if (stickerKeyboardTabItem == StickerKeyboardView.f16665a) {
            if (this.f16764s != null) {
                m24535a(stickerKeyboardTabItem.f16645c);
            }
            this.f16751f.m24478a(stickerKeyboardTabItem.f16645c, false);
        } else if (stickerKeyboardTabItem == StickerKeyboardView.f16666b) {
            this.f16753h.edit().putBoolean(StickerPrefKeys.q, true).commit();
            if (this.f16762q != null) {
                this.f16762q.setPlaceholderResourceId(2130842317);
            }
            this.f16751f.m24478a(stickerKeyboardTabItem.f16645c, false);
        } else if (stickerKeyboardTabItem instanceof StickerKeyboardPackPopupTabItem) {
            this.f16751f.m24478a(stickerKeyboardTabItem.f16645c, ((StickerKeyboardPackPopupTabItem) stickerKeyboardTabItem).f16647b == TabType.PROMOTED);
            if (((StickerKeyboardPackPopupTabItem) stickerKeyboardTabItem).f16647b == TabType.DOWNLOAD_PREVIEW) {
                this.f16752g.m23896c(stickerKeyboardTabItem.f16645c);
            }
        }
    }

    @Inject
    StickerTabbedPagerAdapter(Resources resources, DefaultAppChoreographer defaultAppChoreographer, StickerAssetManager stickerAssetManager, StickerKeyboardLogger stickerKeyboardLogger, DownloadPreviewStickerPacksLogger downloadPreviewStickerPacksLogger, FbSharedPreferences fbSharedPreferences, StickerPackPageViewProvider stickerPackPageViewProvider, @Assisted Context context, @Assisted LayoutInflater layoutInflater, MessagesStickerServiceGatekeepers messagesStickerServiceGatekeepers) {
        this.f16748c = resources;
        this.f16749d = defaultAppChoreographer;
        this.f16750e = stickerAssetManager;
        this.f16751f = stickerKeyboardLogger;
        this.f16752g = downloadPreviewStickerPacksLogger;
        this.f16753h = fbSharedPreferences;
        this.f16754i = stickerPackPageViewProvider;
        this.f16755j = context;
        this.f16756k = layoutInflater;
        this.f16758m = messagesStickerServiceGatekeepers;
        this.f16757l = ContextUtils.b(this.f16755j, 2130773095, 2130842315);
        this.f16761p = new C11761(this);
    }

    public final void m24545a(StickerInterface stickerInterface) {
        this.f16768w = stickerInterface;
        if (this.f16766u != null) {
            this.f16766u.setStickerInterface(stickerInterface);
        }
        if (this.f16764s != null) {
            m24535a("recentStickers");
        }
    }

    final void m24544a(C11642 c11642) {
        this.f16760o = c11642;
    }

    final void m24546a(List<Sticker> list) {
        this.f16763r = ImmutableList.copyOf(list);
    }

    public final int mo1276a() {
        return ContextUtils.e(this.f16755j, 2130773097, this.f16748c.getDimensionPixelSize(2131428498));
    }

    public final int mo1281b(Object obj) {
        return -1;
    }

    private static int m24536b(StickerKeyboardTabItem stickerKeyboardTabItem) {
        if (stickerKeyboardTabItem == StickerKeyboardView.f16665a) {
            return TabViewType.RECENTS.ordinal();
        }
        if (stickerKeyboardTabItem == StickerKeyboardView.f16666b) {
            return TabViewType.SEARCH.ordinal();
        }
        if (stickerKeyboardTabItem instanceof StickerKeyboardPackPopupTabItem) {
            return TabViewType.STICKER_PACK.ordinal();
        }
        throw new IllegalArgumentException("Unknown item type");
    }

    public final ViewHolder mo1277a(ViewGroup viewGroup, int i) {
        StickerKeyboardTabView stickerKeyboardTabView;
        switch (TabViewType.values()[i]) {
            case RECENTS:
                stickerKeyboardTabView = new StickerKeyboardTabView(viewGroup.getContext());
                stickerKeyboardTabView.setPlaceholderResourceId(2130842316);
                stickerKeyboardTabView.setContentDescription(this.f16755j.getString(2131231709));
                return new StickerPackTabViewHolder(stickerKeyboardTabView);
            case SEARCH:
                stickerKeyboardTabView = new StickerKeyboardTabView(viewGroup.getContext());
                stickerKeyboardTabView.setContentDescription(this.f16748c.getString(2131231337));
                return new StickerPackTabViewHolder(stickerKeyboardTabView);
            case STICKER_PACK:
                stickerKeyboardTabView = new StickerKeyboardTabView(viewGroup.getContext());
                stickerKeyboardTabView.setPlaceholderResourceId(2130839430);
                return new StickerPackTabViewHolder(stickerKeyboardTabView);
            default:
                throw new IllegalArgumentException("Unknown item type");
        }
    }

    private void m24533a(ViewHolder viewHolder) {
        StickerKeyboardTabView stickerKeyboardTabView = ((StickerPackTabViewHolder) viewHolder).f16745l;
        if (this.f16753h.a(StickerPrefKeys.q, false)) {
            stickerKeyboardTabView.setPlaceholderResourceId(2130842317);
            return;
        }
        this.f16762q = stickerKeyboardTabView;
        stickerKeyboardTabView.setPlaceholderResourceId(2130842318);
    }

    private void m24534a(ViewHolder viewHolder, StickerKeyboardPackPopupTabItem stickerKeyboardPackPopupTabItem) {
        StickerKeyboardTabView stickerKeyboardTabView = ((StickerPackTabViewHolder) viewHolder).f16745l;
        Uri uri = stickerKeyboardPackPopupTabItem.f16646a.f4959e;
        if (this.f16758m.a() && stickerKeyboardPackPopupTabItem.f16646a.f4960f != null) {
            uri = stickerKeyboardPackPopupTabItem.f16646a.f4960f;
        }
        stickerKeyboardTabView.f16650b.a(uri, StickerKeyboardTabView.f16649a);
        stickerKeyboardTabView.setContentDescription(stickerKeyboardPackPopupTabItem.f16646a.f4958d);
        if (stickerKeyboardPackPopupTabItem.f16647b == TabType.PROMOTED) {
            stickerKeyboardTabView.setForeground(stickerKeyboardTabView.getResources().getDrawable(this.f16757l));
            stickerKeyboardTabView.setForegroundGravity(53);
        } else {
            stickerKeyboardTabView.setForeground(null);
        }
        stickerKeyboardTabView.setIconPulsing(stickerKeyboardPackPopupTabItem.f16647b == TabType.PULSING_DOWNLOAD_PREVIEW);
    }

    public final boolean mo1284e(Object obj) {
        return true;
    }

    private View m24538d(StickerKeyboardTabItem stickerKeyboardTabItem) {
        this.f16764s = this.f16754i.m24522a(this.f16768w, this.f16759n);
        m24535a(stickerKeyboardTabItem.f16645c);
        this.f16764s.f16731p = this.f16761p;
        return this.f16764s;
    }

    private View m24531a(StickerKeyboardPackPopupTabItem stickerKeyboardPackPopupTabItem) {
        StickerPackPageView a = this.f16754i.m24522a(this.f16768w, this.f16759n);
        StickerPack stickerPack = stickerKeyboardPackPopupTabItem.f16646a;
        a.f16733r = stickerPack;
        a.m24521a(RegularImmutableList.a, stickerPack.f4955a);
        if (a.f16717b.m23937c(stickerPack)) {
            if (a.f16729n == null) {
                a.f16729n = a.f16730o.inflate();
                a.f16725j = (StickerPackInfoView) a.c(2131565133);
                a.f16726k = (ProgressBar) a.c(2131559418);
                a.f16727l = (ImageButton) a.c(2131560414);
            }
            a.f16725j.m24513a(stickerPack);
            a.f16727l.setOnClickListener(new C11754(a, stickerPack));
            a.f16724i.setVisibility(8);
            a.f16729n.setVisibility(0);
        } else {
            StickerPackPageView.m24520a(a);
            a.f16718c.m23952a(new Params(stickerPack.f4974t));
        }
        a.f16731p = this.f16761p;
        return a;
    }

    private View m24537b(final StickerKeyboardPackPopupTabItem stickerKeyboardPackPopupTabItem) {
        DownloadPreviewPageView downloadPreviewPageView = new DownloadPreviewPageView(this.f16755j);
        downloadPreviewPageView.f16629d = new Object(this) {
            public final /* synthetic */ StickerTabbedPagerAdapter f16738b;
        };
        downloadPreviewPageView.f16626a.m24513a(stickerKeyboardPackPopupTabItem.f16646a);
        return downloadPreviewPageView;
    }

    private View m24532a(StickerKeyboardPackPopupTabItem stickerKeyboardPackPopupTabItem, ViewGroup viewGroup) {
        View inflate = this.f16756k.inflate(2130905858, viewGroup, false);
        FbDraweeView fbDraweeView = (FbDraweeView) inflate.findViewById(2131562910);
        FbTextView fbTextView = (FbTextView) inflate.findViewById(2131560124);
        FbTextView fbTextView2 = (FbTextView) inflate.findViewById(2131565135);
        FbTextView fbTextView3 = (FbTextView) inflate.findViewById(2131560464);
        FbTextView fbTextView4 = (FbTextView) inflate.findViewById(2131559627);
        Button button = (Button) inflate.findViewById(2131565136);
        Button button2 = (Button) inflate.findViewById(2131565134);
        final StickerPack stickerPack = stickerKeyboardPackPopupTabItem.f16646a;
        fbDraweeView.a(stickerPack.m7729e(), f16746a);
        fbTextView.setText(stickerPack.m7726b());
        fbTextView2.setText(stickerPack.m7727c());
        if ((stickerPack.m7731i() == 0 ? null : new DecimalFormat("$0.00").format(((double) stickerPack.m7731i()) / 100.0d)) == null) {
            fbTextView3.setText(2131231293);
        } else {
            fbTextView3.setText(stickerPack.m7731i());
        }
        fbTextView4.setText(stickerPack.m7728d());
        button.setText(2131231298);
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ StickerTabbedPagerAdapter f16740b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 349942423);
                if (this.f16740b.f16760o != null) {
                    C11642 c11642 = this.f16740b.f16760o;
                    Parcelable parcelable = stickerPack;
                    StickerKeyboardIntentUtil stickerKeyboardIntentUtil = c11642.f16653a.f16692m;
                    Serializable serializable = c11642.f16653a.f16683O;
                    StickerKeyboardLogger stickerKeyboardLogger = stickerKeyboardIntentUtil.f16632c;
                    HoneyClientEvent a2 = StickerLogger.m23897a("sticker_keyboard");
                    a2.b("action", "sticker_store_pack_opened");
                    a2.b("sticker_pack", parcelable.f4955a);
                    a2.a("promoted_download", false);
                    stickerKeyboardLogger.f16635a.m23900a(a2);
                    Intent intent = new Intent(stickerKeyboardIntentUtil.f16630a, StickerStoreActivity.class);
                    intent.putExtra("stickerPack", parcelable);
                    intent.putExtra("startDownload", false);
                    intent.putExtra("stickerContext", serializable);
                    if (serializable == StickerInterface.COMMENTS) {
                        stickerKeyboardIntentUtil.f16634e.a(StickerSequences.f16773d);
                    }
                    stickerKeyboardIntentUtil.f16631b.a(intent, stickerKeyboardIntentUtil.f16630a);
                    StickerKeyboardView.m24508k(c11642.f16653a);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 521320477, a);
            }
        });
        button2.setText(2131231295);
        button2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ StickerTabbedPagerAdapter f16742b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -724974212);
                if (this.f16742b.f16760o != null) {
                    this.f16742b.f16760o.m24482b(stickerPack);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 421012848, a);
            }
        });
        return inflate;
    }

    private void m24535a(String str) {
        if (this.f16768w == StickerInterface.SMS) {
            StickerPackPageView stickerPackPageView = this.f16764s;
            ImmutableList immutableList = this.f16763r;
            Builder builder = ImmutableList.builder();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                Object obj;
                Sticker sticker = (Sticker) immutableList.get(i);
                String str2 = sticker.f4939b;
                if (str2 == null || !StickerUtil.f5011a.contains(str2)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    builder.c(sticker);
                }
            }
            stickerPackPageView.m24521a(builder.b(), str);
            return;
        }
        this.f16764s.m24521a(this.f16763r, str);
    }
}
