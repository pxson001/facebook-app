package com.facebook.stickers.keyboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.stickers.client.StickerDownloadManager;
import com.facebook.stickers.client.StickerDownloadManager.C11521;
import com.facebook.stickers.client.StickersLoader;
import com.facebook.stickers.client.StickersLoader.Params;
import com.facebook.stickers.client.StickersLoader.Results;
import com.facebook.stickers.keyboard.StickerKeyboardView.C11642;
import com.facebook.stickers.keyboard.StickerTabbedPagerAdapter.C11761;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.service.FetchStickerPacksParams;
import com.facebook.stickers.service.FetchStickerPacksParams.Builder;
import com.facebook.stickers.ui.StickerGridController;
import com.facebook.stickers.ui.StickerGridController.Listener;
import com.facebook.stickers.ui.StickerGridControllerProvider;
import com.facebook.stickers.ui.StickerGridViewAdapter;
import com.facebook.stickers.ui.StickerGridViewAdapterProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import javax.inject.Inject;

/* compiled from: edit_privacy_fragment_set_api_error */
public class StickerPackPageView extends CustomFrameLayout {
    private static final CallerContext f16716a = CallerContext.a(StickerKeyboardTabView.class, "sticker_keyboard");
    public final StickerDownloadManager f16717b;
    public final StickersLoader f16718c;
    private final SelfRegistrableReceiverImpl f16719d;
    private final StickerGridViewAdapterProvider f16720e;
    private final StickerInterface f16721f;
    private final Sizes f16722g;
    private final StickerGridController f16723h;
    public final GridView f16724i = ((GridView) c(2131565139));
    public StickerPackInfoView f16725j;
    public ProgressBar f16726k;
    public ImageButton f16727l;
    public StickerGridViewAdapter f16728m;
    public View f16729n;
    public ViewStub f16730o = ((ViewStub) c(2131565138));
    public C11761 f16731p;
    public String f16732q;
    public StickerPack f16733r;

    /* compiled from: edit_privacy_fragment_set_api_error */
    class C11721 implements Callback<Params, Results, Throwable> {
        final /* synthetic */ StickerPackPageView f16711a;

        C11721(StickerPackPageView stickerPackPageView) {
            this.f16711a = stickerPackPageView;
        }

        public final void m24516b(Object obj, Object obj2) {
            this.f16711a.f16728m.m24761a(ImmutableList.copyOf(((Results) obj2).f16477a));
            StickerPackPageView.m24520a(this.f16711a);
            if (this.f16711a.f16731p != null) {
                C11761 c11761 = this.f16711a.f16731p;
                String str = this.f16711a.f16732q;
                if (c11761.f16734a.f16760o != null && str.equals(c11761.f16734a.f16769x)) {
                    c11761.f16734a.f16760o.m24483c();
                    c11761.f16734a.f16769x = null;
                }
            }
        }

        public final /* bridge */ /* synthetic */ void m24517c(Object obj, Object obj2) {
        }

        public final void m24514a(Object obj, ListenableFuture listenableFuture) {
            this.f16711a.f16724i.setEmptyView(this.f16711a.findViewById(2131562398));
            if (this.f16711a.f16731p != null) {
                C11761 c11761 = this.f16711a.f16731p;
                String str = this.f16711a.f16732q;
                if (c11761.f16734a.f16760o != null && str.equals(c11761.f16734a.f16769x)) {
                    C11642 c11642 = c11761.f16734a.f16760o;
                    if (c11642.f16653a.f16685f != null) {
                        c11642.f16653a.f16685f.m24498c();
                    }
                    c11761.f16734a.f16749d.a(listenableFuture);
                }
            }
        }
    }

    /* compiled from: edit_privacy_fragment_set_api_error */
    class C11732 implements Listener {
        final /* synthetic */ StickerPackPageView f16712a;

        C11732(StickerPackPageView stickerPackPageView) {
            this.f16712a = stickerPackPageView;
        }

        public final void mo1271a(Sticker sticker) {
            if (this.f16712a.f16731p != null) {
                C11761 c11761 = this.f16712a.f16731p;
                String str = this.f16712a.f16732q;
                if (c11761.f16734a.f16760o != null) {
                    c11761.f16734a.f16760o.m24480a(sticker, str);
                }
            }
        }
    }

    /* compiled from: edit_privacy_fragment_set_api_error */
    class C11743 implements ActionReceiver {
        final /* synthetic */ StickerPackPageView f16713a;

        C11743(StickerPackPageView stickerPackPageView) {
            this.f16713a = stickerPackPageView;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 2041490777);
            StickerPackPageView stickerPackPageView = this.f16713a;
            StickerPack stickerPack = (StickerPack) intent.getParcelableExtra("stickerPack");
            if (stickerPackPageView.f16733r != null && Objects.equal(stickerPack.f4955a, stickerPackPageView.f16733r.f4955a)) {
                if (intent.getAction().equals("com.facebook.orca.stickers.DOWNLOAD_PROGRESS")) {
                    stickerPackPageView.f16726k.setProgress(intent.getIntExtra("progress", 0));
                } else if (intent.getAction().equals("com.facebook.orca.stickers.DOWNLOAD_SUCCESS")) {
                    stickerPackPageView.f16718c.m23952a(new Params(stickerPackPageView.f16733r.f4974t));
                }
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 626767744, a);
        }
    }

    /* compiled from: edit_privacy_fragment_set_api_error */
    public class C11754 implements OnClickListener {
        final /* synthetic */ StickerPack f16714a;
        final /* synthetic */ StickerPackPageView f16715b;

        public C11754(StickerPackPageView stickerPackPageView, StickerPack stickerPack) {
            this.f16715b = stickerPackPageView;
            this.f16714a = stickerPack;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1030152465);
            StickerDownloadManager stickerDownloadManager = this.f16715b.f16717b;
            StickerPack stickerPack = this.f16714a;
            if (stickerDownloadManager.m23937c(stickerPack)) {
                FutureAndCallbackHolder futureAndCallbackHolder = (FutureAndCallbackHolder) stickerDownloadManager.f16458g.get(stickerPack.f4955a);
                if (futureAndCallbackHolder != null) {
                    futureAndCallbackHolder.a(false);
                }
                FetchStickerPacksParams a2 = new Builder(StickerPackType.DOWNLOADED_PACKS, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE).a();
                Bundle bundle = new Bundle();
                bundle.putParcelable("fetchStickerPacksParams", a2);
                Futures.b(BlueServiceOperationFactoryDetour.a(stickerDownloadManager.f16454c, "fetch_sticker_packs", bundle, ErrorPropagation.BY_EXCEPTION, StickerDownloadManager.f16451a, 511698527).a(), new C11521(stickerDownloadManager, stickerPack), stickerDownloadManager.f16455d);
            } else {
                BLog.a(StickerDownloadManager.f16452b, "Download manager was not downloading this sticker pack.");
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1468763497, a);
        }
    }

    @Inject
    public StickerPackPageView(Context context, StickerDownloadManager stickerDownloadManager, StickersLoader stickersLoader, BaseFbBroadcastManager baseFbBroadcastManager, StickerGridControllerProvider stickerGridControllerProvider, StickerGridViewAdapterProvider stickerGridViewAdapterProvider, @Assisted StickerInterface stickerInterface, @Assisted Sizes sizes) {
        super(context);
        this.f16717b = stickerDownloadManager;
        this.f16718c = stickersLoader;
        this.f16720e = stickerGridViewAdapterProvider;
        this.f16721f = stickerInterface;
        this.f16722g = sizes;
        setContentView(2130905860);
        this.f16724i.setNumColumns(this.f16722g.f7725a);
        this.f16718c.m23951a(new C11721(this));
        this.f16723h = stickerGridControllerProvider.m24758a(this.f16724i, this.f16721f);
        this.f16723h.f17054e = new C11732(this);
        C11743 c11743 = new C11743(this);
        this.f16719d = baseFbBroadcastManager.a().a("com.facebook.orca.stickers.DOWNLOAD_PROGRESS", c11743).a("com.facebook.orca.stickers.DOWNLOAD_SUCCESS", c11743).a();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1315315159);
        super.onAttachedToWindow();
        this.f16719d.b();
        if (!(this.f16733r == null || this.f16717b.m23937c(this.f16733r) || !this.f16728m.isEmpty())) {
            m24520a(this);
            this.f16718c.m23952a(new Params(this.f16733r.f4974t));
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2016455541, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -638365727);
        super.onDetachedFromWindow();
        this.f16719d.c();
        this.f16718c.m23950a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -43678331, a);
    }

    public final void m24521a(List<Sticker> list, String str) {
        this.f16718c.m23950a();
        this.f16732q = str;
        this.f16724i.setEmptyView(null);
        this.f16728m = this.f16720e.m24762a(getContext(), str, this.f16722g);
        this.f16728m.f17068i = f16716a;
        this.f16728m.m24761a(ImmutableList.copyOf(list));
        this.f16724i.setAdapter(this.f16728m);
        m24520a(this);
    }

    public static void m24520a(StickerPackPageView stickerPackPageView) {
        stickerPackPageView.f16724i.setVisibility(0);
        if (stickerPackPageView.f16729n != null) {
            stickerPackPageView.f16729n.setVisibility(8);
        }
    }
}
