package com.facebook.orca.compose;

import android.content.Intent;
import com.facebook.messaging.intents.MessagingIntents;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaDialogParams;
import com.facebook.messaging.payment.value.input.OrionMessengerPayParams;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.share.model.ShareItem;

/* compiled from: org.torproject.android.intent.extra.HTTP_PROXY_HOST */
public class ComposerInitParamsFactory {
    public static ComposerInitParams m5015a(Intent intent) {
        if (intent == null || !intent.getBooleanExtra("show_composer", false)) {
            return null;
        }
        ComposerInitParamsBuilder composerInitParamsBuilder = new ComposerInitParamsBuilder();
        composerInitParamsBuilder.f5433a = intent.getStringExtra("composer_initial_text");
        composerInitParamsBuilder = composerInitParamsBuilder;
        composerInitParamsBuilder.f5434b = intent.getParcelableArrayListExtra("composer_photo_media_resource_list");
        ComposerInitParamsBuilder composerInitParamsBuilder2 = composerInitParamsBuilder;
        composerInitParamsBuilder2.f5435c = (PickMediaDialogParams) MessagingIntents.b(intent, "open_media_picker_params");
        composerInitParamsBuilder2 = composerInitParamsBuilder2;
        composerInitParamsBuilder2.f5436d = (OrionMessengerPayParams) MessagingIntents.b(intent, "orion_messenger_pay_params");
        composerInitParamsBuilder = composerInitParamsBuilder2;
        composerInitParamsBuilder.f5438f = intent.getBooleanExtra("composer_open_sticker_tray", false);
        composerInitParamsBuilder2 = composerInitParamsBuilder;
        composerInitParamsBuilder2.f5440h = (ComposerAppAttribution) intent.getParcelableExtra("app_attribution");
        composerInitParamsBuilder2 = composerInitParamsBuilder2;
        ShareItem shareItem = (ShareItem) intent.getParcelableExtra("extra_messenger_share_preview");
        if (shareItem != null) {
            composerInitParamsBuilder2.f5437e = shareItem;
        }
        return composerInitParamsBuilder2.m5014i();
    }
}
