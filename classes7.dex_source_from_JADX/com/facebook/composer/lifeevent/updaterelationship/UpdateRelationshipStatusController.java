package com.facebook.composer.lifeevent.updaterelationship;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: contrast */
public final class UpdateRelationshipStatusController {
    public final OnClickListener f16809a;
    public final OnDismissListener f16810b;
    public final Context f16811c;

    /* compiled from: contrast */
    public class C13511 implements OnClickListener {
        final /* synthetic */ UpdateRelationshipStatusController f16808a;

        public C13511(UpdateRelationshipStatusController updateRelationshipStatusController) {
            this.f16808a = updateRelationshipStatusController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    @Inject
    public UpdateRelationshipStatusController(@Assisted OnClickListener onClickListener, @Assisted OnDismissListener onDismissListener, @Assisted Context context) {
        this.f16809a = onClickListener;
        this.f16810b = onDismissListener;
        this.f16811c = context;
    }
}
