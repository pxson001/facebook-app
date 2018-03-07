package com.facebook.stickers.perf;

import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.google.common.collect.ImmutableSet;

/* compiled from: edit_photo_caption */
public final class StickerSequences {
    public static final StickerKeyboardSequence f16770a = new StickerKeyboardSequence();
    public static final StickerPostSequence f16771b = new StickerPostSequence();
    public static final StickerStoreSequence f16772c = new StickerStoreSequence();
    public static final StickerStoreWithPackSequence f16773d = new StickerStoreWithPackSequence();

    /* compiled from: edit_photo_caption */
    public final class StickerKeyboardSequence extends AbstractSequenceDefinition {
        public StickerKeyboardSequence() {
            super(1638401, "StickerKeyboardSequence", false, ImmutableSet.of("com.facebook.feedback.ui.BaseFeedbackFragment", "com.facebook.feed.permalink.NewPermalinkFragment", "com.facebook.stickers.popup.StickerKeyboard"));
        }
    }

    /* compiled from: edit_photo_caption */
    public final class StickerPostSequence extends AbstractSequenceDefinition {
        public StickerPostSequence() {
            super(1638402, "StickerPostSequence", false, ImmutableSet.of("com.facebook.feedback.ui.BaseFeedbackFragment", "com.facebook.feed.permalink.NewPermalinkFragment", "com.facebook.stickers.popup.StickerKeyboard"));
        }
    }

    /* compiled from: edit_photo_caption */
    public final class StickerStoreSequence extends AbstractSequenceDefinition {
        public StickerStoreSequence() {
            super(1638403, "StickerStoreSequence", false, ImmutableSet.of("com.facebook.feedback.ui.BaseFeedbackFragment", "com.facebook.feed.permalink.NewPermalinkFragment", "com.facebook.stickers.popup.StickerKeyboard", "com.facebook.stickers.store.StickerStoreActivity", "com.facebook.stickers.store.StickerStoreFragment"));
        }
    }

    /* compiled from: edit_photo_caption */
    public final class StickerStoreWithPackSequence extends AbstractSequenceDefinition {
        public StickerStoreWithPackSequence() {
            super(1638404, "StickerStoreWithPackSequence", false, ImmutableSet.of("com.facebook.feedback.ui.BaseFeedbackFragment", "com.facebook.feed.permalink.NewPermalinkFragment", "com.facebook.stickers.popup.StickerKeyboard", "com.facebook.stickers.store.StickerStoreActivity", "com.facebook.stickers.store.StickerStoreFragment"));
        }
    }
}
