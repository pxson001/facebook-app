package com.facebook.messaging.payment.prefs.receipts.manual.model;

/* compiled from: getAccessToken */
public class ModelToItemsConverter {

    /* compiled from: getAccessToken */
    public enum Item {
        PRODUCT_ITEM(1),
        PRICE_BREAKDOWN(2),
        SHIPPING_ADDRESS(3),
        SHIPPING_METHOD(4),
        PAYMENT_STATUS(6),
        SHIPPING_FULFILLMENT(8),
        QUANTITY(9),
        PAYMENT_STATUS_WITH_ATTACHMENT(10);
        
        private int mViewType;

        private Item(int i) {
            this.mViewType = i;
        }

        public static Item getItemFromViewType(int i) {
            for (Item item : values()) {
                if (item.getItemViewType() == i) {
                    return item;
                }
            }
            throw new IllegalArgumentException("No Item found for view type: " + i);
        }

        public final int getItemViewType() {
            return this.mViewType;
        }
    }
}
