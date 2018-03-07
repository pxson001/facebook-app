package com.facebook.messaging.payment.prefs.receipts.manual;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.inject.Assisted;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogFragment;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogParams;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogParamsBuilder;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaSource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: getPaymentRequest */
public class InvoicesProofOfPaymentMediaController {
    public final InvoicesProofOfPaymentFragment f14174a;

    /* compiled from: getPaymentRequest */
    public class C16131 implements OnClickListener {
        final /* synthetic */ InvoicesProofOfPaymentMediaController f14173a;

        public C16131(InvoicesProofOfPaymentMediaController invoicesProofOfPaymentMediaController) {
            this.f14173a = invoicesProofOfPaymentMediaController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            PickMediaSource pickMediaSource;
            InvoicesProofOfPaymentMediaController invoicesProofOfPaymentMediaController = this.f14173a;
            if (i == 0) {
                pickMediaSource = PickMediaSource.CAMERA;
            } else {
                pickMediaSource = PickMediaSource.GALLERY;
            }
            PickMediaDialogParamsBuilder newBuilder = PickMediaDialogParams.newBuilder();
            newBuilder.f11781d = ImmutableSet.of(Type.PHOTO);
            newBuilder = newBuilder;
            newBuilder.f11778a = pickMediaSource;
            PickMediaDialogFragment.m12396a(newBuilder.m12411j()).a(this.f14173a.f14174a.s(), "receipt_image_media_picker_fragment");
        }
    }

    @Inject
    public InvoicesProofOfPaymentMediaController(@Assisted InvoicesProofOfPaymentFragment invoicesProofOfPaymentFragment) {
        this.f14174a = invoicesProofOfPaymentFragment;
    }
}
