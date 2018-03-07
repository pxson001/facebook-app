package com.facebook.messaging.business.commerceui.views;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModel;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModelType;
import com.facebook.messaging.business.commerce.model.retail.CommerceData;
import com.facebook.messaging.business.commerce.model.retail.Receipt;
import com.facebook.messaging.business.commerce.model.retail.ReceiptCancellation;
import com.facebook.messaging.business.commerce.model.retail.Shipment;
import com.facebook.messaging.business.commerce.model.retail.ShipmentTrackingEvent;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger;
import com.facebook.messaging.business.commerceui.views.retail.MultiItemReceiptView;
import com.facebook.messaging.business.commerceui.views.retail.ProductSubscriptionView;
import com.facebook.messaging.business.commerceui.views.retail.ReceiptDetailsFragment;
import com.facebook.messaging.business.commerceui.views.retail.RetailItemSuggestionView;
import com.facebook.messaging.business.commerceui.views.retail.ShippingDetailsFragment;
import com.facebook.messaging.business.commerceui.views.retail.ShippingNotificationView;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.ViewStubHolder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: num_audio_clips */
public class CommerceBubbleView extends CustomRelativeLayout {
    @Inject
    MessengerCommerceAnalyticsLogger f8419a;
    @Inject
    SecureContextHelper f8420b;
    @Nullable
    public CommerceData f8421c;
    private final ViewStubHolder<MultiItemReceiptView> f8422d;
    private final ViewStubHolder<ShippingNotificationView> f8423e;
    private final ViewStubHolder<RetailItemSuggestionView> f8424f;
    private final ViewStubHolder<ProductSubscriptionView> f8425g;

    /* compiled from: num_audio_clips */
    class C09531 implements OnClickListener {
        final /* synthetic */ CommerceBubbleView f8413a;

        C09531(CommerceBubbleView commerceBubbleView) {
            this.f8413a = commerceBubbleView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1131234691);
            CommerceView view2 = CommerceBubbleView.getView(this.f8413a);
            if (!(view2 == null || view2.mo231a())) {
                CommerceBubbleView.getView(this.f8413a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -395911145, a);
        }
    }

    private static <T extends View> void m8686a(Class<T> cls, T t) {
        m8687a((Object) t, t.getContext());
    }

    private static void m8687a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CommerceBubbleView) obj).m8684a(MessengerCommerceAnalyticsLogger.m8651b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    private void m8684a(MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger, SecureContextHelper secureContextHelper) {
        this.f8419a = messengerCommerceAnalyticsLogger;
        this.f8420b = secureContextHelper;
    }

    public CommerceBubbleView(Context context) {
        this(context, null);
    }

    public CommerceBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommerceBubbleView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8686a(CommerceBubbleView.class, (View) this);
        setContentView(2130905621);
        this.f8422d = ViewStubHolder.a((ViewStubCompat) a(2131564651));
        this.f8423e = ViewStubHolder.a((ViewStubCompat) a(2131564652));
        this.f8424f = ViewStubHolder.a((ViewStubCompat) a(2131564653));
        this.f8425g = ViewStubHolder.a((ViewStubCompat) a(2131564654));
        setOnClickListener(new C09531(this));
        final OnMenuItemClickListener c09542 = new OnMenuItemClickListener(this) {
            final /* synthetic */ CommerceBubbleView f8415b;

            public boolean onMenuItemClick(MenuItem menuItem) {
                if (this.f8415b.f8421c == null) {
                    return false;
                }
                CharSequence charSequence = "";
                if (menuItem.getItemId() == 2131568627) {
                    if (this.f8415b.f8421c.a instanceof Receipt) {
                        charSequence = ((Receipt) this.f8415b.f8421c.a).b;
                    } else if ((this.f8415b.f8421c.a instanceof ReceiptCancellation) && ((ReceiptCancellation) this.f8415b.f8421c.a).b != null) {
                        charSequence = ((ReceiptCancellation) this.f8415b.f8421c.a).b.b;
                    }
                } else if (menuItem.getItemId() != 2131568628) {
                    return false;
                } else {
                    if (this.f8415b.f8421c.a instanceof Shipment) {
                        charSequence = ((Shipment) this.f8415b.f8421c.a).c;
                    } else if (this.f8415b.f8421c.a instanceof ShipmentTrackingEvent) {
                        String str;
                        ShipmentTrackingEvent shipmentTrackingEvent = (ShipmentTrackingEvent) this.f8415b.f8421c.a;
                        if (shipmentTrackingEvent.f != null) {
                            str = shipmentTrackingEvent.f.c;
                        } else {
                            CharSequence charSequence2 = charSequence;
                        }
                        Object obj = str;
                    }
                }
                ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(this.f8415b.f8421c.a.a(), charSequence));
                return true;
            }
        };
        setOnCreateContextMenuListener(new OnCreateContextMenuListener(this) {
            final /* synthetic */ CommerceBubbleView f8418c;

            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (this.f8418c.f8421c != null) {
                    new MenuInflater(context).inflate(2131820557, contextMenu);
                    MenuItem findItem = contextMenu.findItem(2131568627);
                    MenuItem findItem2 = contextMenu.findItem(2131568628);
                    if ((this.f8418c.f8421c.a instanceof Receipt) || (this.f8418c.f8421c.a instanceof ReceiptCancellation)) {
                        findItem.setOnMenuItemClickListener(c09542);
                        findItem2.setVisible(false);
                    } else if ((this.f8418c.f8421c.a instanceof Shipment) || (this.f8418c.f8421c.a instanceof ShipmentTrackingEvent)) {
                        findItem2.setOnMenuItemClickListener(c09542);
                        findItem.setVisible(false);
                    }
                }
            }
        });
    }

    public void setModel(CommerceBubbleModel commerceBubbleModel) {
        CommerceBubbleModelType b;
        this.f8421c = new CommerceData(commerceBubbleModel);
        CommerceBubbleModelType commerceBubbleModelType = CommerceBubbleModelType.UNKNOWN;
        int i = 0;
        if (commerceBubbleModel != null) {
            b = commerceBubbleModel.b();
            i = commerceBubbleModel.c().size();
        } else {
            b = null;
        }
        this.f8422d.e();
        this.f8423e.e();
        this.f8424f.e();
        this.f8425g.e();
        if (i != 0) {
            CommerceView commerceView;
            if (b == CommerceBubbleModelType.RECEIPT) {
                this.f8422d.f();
                commerceView = (CommerceView) this.f8422d.a();
            } else if (b == CommerceBubbleModelType.CANCELLATION) {
                this.f8422d.f();
                commerceView = (CommerceView) this.f8422d.a();
            } else if (b == CommerceBubbleModelType.PRODUCT_SUBSCRIPTION) {
                this.f8425g.f();
                commerceView = (CommerceView) this.f8425g.a();
            } else if (CommerceBubbleModelType.isShippingBubble(b)) {
                this.f8423e.f();
                commerceView = (CommerceView) this.f8423e.a();
            } else if (b == CommerceBubbleModelType.AGENT_ITEM_SUGGESTION) {
                this.f8424f.f();
                commerceView = (CommerceView) this.f8424f.a();
            } else {
                commerceView = null;
            }
            if (commerceView != null) {
                commerceView.setModel(commerceBubbleModel);
            }
        }
    }

    @Nullable
    public static CommerceView getView(CommerceBubbleView commerceBubbleView) {
        if (commerceBubbleView.f8422d.d()) {
            return (CommerceView) commerceBubbleView.f8422d.a();
        }
        if (commerceBubbleView.f8423e.d()) {
            return (CommerceView) commerceBubbleView.f8423e.a();
        }
        if (commerceBubbleView.f8424f.d()) {
            return (CommerceView) commerceBubbleView.f8424f.a();
        }
        if (commerceBubbleView.f8425g.d()) {
            return (CommerceView) commerceBubbleView.f8425g.a();
        }
        return null;
    }

    public static void m8685a(CommerceBubbleView commerceBubbleView) {
        if (commerceBubbleView.f8421c != null && commerceBubbleView.f8421c.a != null) {
            commerceBubbleView.f8419a.m8654a(commerceBubbleView.f8421c.a.b(), commerceBubbleView.f8421c.a.a());
            Intent intent = null;
            if (CommerceBubbleModelType.isReceiptBubble(commerceBubbleView.f8421c.a.b())) {
                intent = ReceiptDetailsFragment.m8792c(commerceBubbleView.getContext(), commerceBubbleView.f8421c.a.a());
            } else if (CommerceBubbleModelType.isShippingBubble(commerceBubbleView.f8421c.a.b())) {
                intent = ShippingDetailsFragment.m8817a(commerceBubbleView.getContext(), commerceBubbleView.f8421c);
            }
            Preconditions.checkNotNull(intent);
            commerceBubbleView.f8420b.a(intent, commerceBubbleView.getContext());
        }
    }
}
