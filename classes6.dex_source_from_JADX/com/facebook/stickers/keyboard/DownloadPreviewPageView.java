package com.facebook.stickers.keyboard;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.stickers.keyboard.StickerKeyboardView.C11642;
import com.facebook.stickers.keyboard.StickerKeyboardView.C11696;
import com.facebook.stickers.keyboard.StickerTabbedPagerAdapter.C11783;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.util.concurrent.Futures;

/* compiled from: educationType */
public class DownloadPreviewPageView extends CustomLinearLayout {
    public final StickerPackInfoView f16626a = ((StickerPackInfoView) a(2131565133));
    private final FbButton f16627b = ((FbButton) a(2131565134));
    private final FbButton f16628c;
    public C11783 f16629d;

    /* compiled from: educationType */
    class C11601 implements OnClickListener {
        final /* synthetic */ DownloadPreviewPageView f16624a;

        C11601(DownloadPreviewPageView downloadPreviewPageView) {
            this.f16624a = downloadPreviewPageView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -328852851);
            if (this.f16624a.f16629d != null) {
                C11783 c11783 = this.f16624a.f16629d;
                c11783.f16738b.f16752g.m23894a(c11783.f16737a.f16646a.f4955a);
                if (c11783.f16738b.f16760o != null) {
                    c11783.f16738b.f16760o.m24482b(c11783.f16737a.f16646a);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1260686505, a);
        }
    }

    /* compiled from: educationType */
    class C11612 implements OnClickListener {
        final /* synthetic */ DownloadPreviewPageView f16625a;

        C11612(DownloadPreviewPageView downloadPreviewPageView) {
            this.f16625a = downloadPreviewPageView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1044865173);
            if (this.f16625a.f16629d != null) {
                C11783 c11783 = this.f16625a.f16629d;
                c11783.f16738b.f16752g.m23895b(c11783.f16737a.f16646a.f4955a);
                if (c11783.f16738b.f16760o != null) {
                    C11642 c11642 = c11783.f16738b.f16760o;
                    Object obj = c11783.f16737a.f16646a;
                    StickerKeyboardView.m24503c(c11642.f16653a, obj);
                    StickerKeyboardView stickerKeyboardView = c11642.f16653a;
                    stickerKeyboardView.f16671C.remove(obj);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("stickerPack", obj);
                    OperationFuture a2 = BlueServiceOperationFactoryDetour.a(stickerKeyboardView.f16694o, "add_closed_download_preview_sticker_pack", bundle, 1742029978).a();
                    C11696 c11696 = new C11696(stickerKeyboardView, obj);
                    stickerKeyboardView.f16698s = FutureAndCallbackHolder.a(a2, c11696);
                    Futures.a(a2, c11696, stickerKeyboardView.f16688i);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -359926082, a);
        }
    }

    public DownloadPreviewPageView(Context context) {
        super(context);
        setContentView(2130905856);
        this.f16627b.setOnClickListener(new C11601(this));
        this.f16628c = (FbButton) a(2131560414);
        this.f16628c.setOnClickListener(new C11612(this));
    }
}
