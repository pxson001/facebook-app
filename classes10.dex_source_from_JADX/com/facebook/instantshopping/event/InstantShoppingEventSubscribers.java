package com.facebook.instantshopping.event;

import com.facebook.instantshopping.event.InstantShoppingEvents.CartClearedEvent;
import com.facebook.instantshopping.event.InstantShoppingEvents.ExecuteActionEvent;
import com.facebook.instantshopping.event.InstantShoppingEvents.InstantShoppingReloadDocumentEvent;
import com.facebook.instantshopping.event.InstantShoppingEvents.ItemAddedToCartEvent;
import com.facebook.instantshopping.event.InstantShoppingEvents.ItemRemovedFromCartEvent;
import com.facebook.instantshopping.event.InstantShoppingEvents.ProductSavedEvent;
import com.facebook.richdocument.event.RichDocumentEventSubscriber;

/* compiled from: Stops the manifest from refreshing without a dialog invocation (happens on cold start) */
public final class InstantShoppingEventSubscribers {

    /* compiled from: Stops the manifest from refreshing without a dialog invocation (happens on cold start) */
    public abstract class ItemAddedToCartEventSubscriber extends RichDocumentEventSubscriber<ItemAddedToCartEvent> {
        public final Class<ItemAddedToCartEvent> m24704a() {
            return ItemAddedToCartEvent.class;
        }
    }

    /* compiled from: Stops the manifest from refreshing without a dialog invocation (happens on cold start) */
    public abstract class InstantShoppingReloadDocumentEventSubscriber extends RichDocumentEventSubscriber<InstantShoppingReloadDocumentEvent> {
        public final Class<InstantShoppingReloadDocumentEvent> m24706a() {
            return InstantShoppingReloadDocumentEvent.class;
        }
    }

    /* compiled from: Stops the manifest from refreshing without a dialog invocation (happens on cold start) */
    public abstract class ProductSavedEventSubscriber extends RichDocumentEventSubscriber<ProductSavedEvent> {
        public final Class<ProductSavedEvent> m24709a() {
            return ProductSavedEvent.class;
        }
    }

    /* compiled from: Stops the manifest from refreshing without a dialog invocation (happens on cold start) */
    public abstract class ItemRemovedFromCartEventSubscriber extends RichDocumentEventSubscriber<ItemRemovedFromCartEvent> {
        public final Class<ItemRemovedFromCartEvent> m24711a() {
            return ItemRemovedFromCartEvent.class;
        }
    }

    /* compiled from: Stops the manifest from refreshing without a dialog invocation (happens on cold start) */
    public abstract class CartClearedEventSubscriber extends RichDocumentEventSubscriber<CartClearedEvent> {
        public final Class<CartClearedEvent> m24713a() {
            return CartClearedEvent.class;
        }
    }

    /* compiled from: Stops the manifest from refreshing without a dialog invocation (happens on cold start) */
    public abstract class ExecuteActionEventSubscriber extends RichDocumentEventSubscriber<ExecuteActionEvent> {
        public final Class<ExecuteActionEvent> m24715a() {
            return ExecuteActionEvent.class;
        }
    }
}
