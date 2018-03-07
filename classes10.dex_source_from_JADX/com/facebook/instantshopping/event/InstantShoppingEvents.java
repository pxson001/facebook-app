package com.facebook.instantshopping.event;

import android.content.Intent;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingOptionsActionFragmentModel;
import com.facebook.richdocument.event.RichDocumentEvent;

/* compiled from: Simulate a stalled main thread */
public class InstantShoppingEvents {

    /* compiled from: Simulate a stalled main thread */
    public class CartClearedEvent implements RichDocumentEvent {
    }

    /* compiled from: Simulate a stalled main thread */
    public class ExecuteActionEvent implements RichDocumentEvent {
        public final InstantShoppingActionFragmentModel f23515a = null;
        public final InstantShoppingOptionsActionFragmentModel f23516b;

        public ExecuteActionEvent(InstantShoppingOptionsActionFragmentModel instantShoppingOptionsActionFragmentModel) {
            this.f23516b = instantShoppingOptionsActionFragmentModel;
        }
    }

    /* compiled from: Simulate a stalled main thread */
    public class InstantShoppingReloadDocumentEvent implements RichDocumentEvent {
        public Intent f23517a;

        public InstantShoppingReloadDocumentEvent(Intent intent) {
            this.f23517a = intent;
        }
    }

    /* compiled from: Simulate a stalled main thread */
    public class ItemAddedToCartEvent implements RichDocumentEvent {
        private final long f23518a;

        public ItemAddedToCartEvent(long j) {
            this.f23518a = j;
        }
    }

    /* compiled from: Simulate a stalled main thread */
    public class ItemRemovedFromCartEvent implements RichDocumentEvent {
    }

    /* compiled from: Simulate a stalled main thread */
    public class ProductSavedEvent implements RichDocumentEvent {
        public final boolean f23519a;

        public ProductSavedEvent(boolean z) {
            this.f23519a = z;
        }
    }
}
