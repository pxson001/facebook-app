package com.facebook.photos.creativeediting.stickers.events;

import com.facebook.stickers.model.Sticker;

/* compiled from: mQueryProvider= */
public class StickerEvents {

    /* compiled from: mQueryProvider= */
    public class ShowStickerPickerEvent extends StickerEvent {
    }

    /* compiled from: mQueryProvider= */
    public abstract class ShowStickerPickerEventSubscriber extends StickerEventSubscriber<ShowStickerPickerEvent> {
        public final Class<ShowStickerPickerEvent> m11542a() {
            return ShowStickerPickerEvent.class;
        }
    }

    /* compiled from: mQueryProvider= */
    public class StickerSelectedEvent extends StickerEvent {
        public final Sticker f9609a;
        public final int f9610b;
        public final int f9611c;

        public StickerSelectedEvent(Sticker sticker, int i, int i2) {
            this.f9609a = sticker;
            this.f9610b = i;
            this.f9611c = i2;
        }
    }

    /* compiled from: mQueryProvider= */
    public abstract class StickerSelectedEventSubscriber extends StickerEventSubscriber<StickerSelectedEvent> {
        public final Class<StickerSelectedEvent> m11543a() {
            return StickerSelectedEvent.class;
        }
    }
}
