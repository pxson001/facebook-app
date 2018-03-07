package com.facebook.maps;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: your_photos */
class FbStaticMapView$1 implements OnClickListener {
    final /* synthetic */ FbStaticMapView f167a;

    /* compiled from: your_photos */
    class C00241 implements Listener {
        final /* synthetic */ FbStaticMapView$1 f166a;

        C00241(FbStaticMapView$1 fbStaticMapView$1) {
            this.f166a = fbStaticMapView$1;
        }

        public final void m132a(Object obj) {
            this.f166a.f167a.i.a("dialtone_upgrade_dialog");
            this.f166a.f167a.setZeroRatingEnabled(false);
            if (this.f166a.f167a.h != null) {
                FbStaticMapView$ZeroRatingCallback fbStaticMapView$ZeroRatingCallback = this.f166a.f167a.h;
            }
        }

        public final void m131a() {
        }
    }

    FbStaticMapView$1(FbStaticMapView fbStaticMapView) {
        this.f167a = fbStaticMapView;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 423286767);
        this.f167a.g.a(this.f167a.f, this.f167a.getResources().getString(2131232927), new C00241(this));
        this.f167a.g.a(this.f167a.f, this.f167a.k);
        Logger.a(2, EntryType.UI_INPUT_END, 1612863849, a);
    }
}
