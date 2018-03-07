package com.facebook.stickers.data;

import com.facebook.graphql.calls.InterfaceInputInterface;
import com.facebook.stickers.model.StickerInterface;
import com.google.common.base.Preconditions;

/* compiled from: employerHubId */
public class StickerInterfaceTranslator {
    public static InterfaceInputInterface m23958a(StickerInterface stickerInterface) {
        Preconditions.checkNotNull(stickerInterface);
        switch (stickerInterface) {
            case MESSENGER:
                return InterfaceInputInterface.MESSAGES;
            case COMMENTS:
                return InterfaceInputInterface.COMMENTS;
            case COMPOSER:
                return InterfaceInputInterface.COMPOSER;
            case POSTS:
                return InterfaceInputInterface.POSTS;
            case SMS:
                return InterfaceInputInterface.SMS;
            default:
                return InterfaceInputInterface.values()[0];
        }
    }
}
