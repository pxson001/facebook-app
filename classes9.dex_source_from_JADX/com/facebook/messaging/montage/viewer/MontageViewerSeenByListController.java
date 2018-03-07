package com.facebook.messaging.montage.viewer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.facebook.messaging.montage.viewer.AbstractMontageItemFragment.C14066;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import javax.inject.Inject;

/* compiled from: is_client_paying_for_invoices */
public class MontageViewerSeenByListController {
    public BottomSheetDialog f12627a;
    public MontageViewerSeenByListAdapter f12628b;
    public C14066 f12629c;
    public final Context f12630d;

    /* compiled from: is_client_paying_for_invoices */
    public class C14191 implements OnDismissListener {
        final /* synthetic */ MontageViewerSeenByListController f12626a;

        public C14191(MontageViewerSeenByListController montageViewerSeenByListController) {
            this.f12626a = montageViewerSeenByListController;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (this.f12626a.f12629c != null) {
                this.f12626a.f12629c.f12569a.aw();
            }
        }
    }

    @Inject
    public MontageViewerSeenByListController(Context context) {
        this.f12630d = context;
    }

    public final boolean m13082a() {
        return this.f12627a != null && this.f12627a.isShowing();
    }
}
