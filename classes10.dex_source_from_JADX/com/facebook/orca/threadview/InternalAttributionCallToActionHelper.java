package com.facebook.orca.threadview;

import com.facebook.messaging.attribution.AttributionActionType;
import com.facebook.messaging.forward.MessageForwardHandler;
import com.facebook.orca.compose.ComposeFragment;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Inject;

/* compiled from: migration_flow */
public class InternalAttributionCallToActionHelper {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MessageForwardHandler> f6979a = UltralightRuntime.b;
    public ComposeFragment f6980b;

    /* compiled from: migration_flow */
    public /* synthetic */ class C10501 {
        public static final /* synthetic */ int[] f6977a = new int[Source.values().length];
        public static final /* synthetic */ int[] f6978b = new int[AttributionActionType.values().length];

        static {
            try {
                f6978b[AttributionActionType.INTERNAL_FEATURE_REPLY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6978b[AttributionActionType.MONTAGE_ADD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6977a[Source.MEDIA_PICKER.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6977a[Source.VOICE_CLIP.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
        }
    }
}
