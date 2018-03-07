package com.facebook.messaging.business.commerceui.views.retail;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbMapViewDelegate;
import com.facebook.messaging.business.attachments.converters.PlatformAttachmentsConverter;
import com.facebook.messaging.business.attachments.model.LogoImage;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.facebook.messaging.business.commerce.converters.ModelConverters;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragments.CommerceShipmentQueryString;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceShipmentDetailsModel;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceShipmentDetailsModel.ReceiptModel;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModel;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModelType;
import com.facebook.messaging.business.commerce.model.retail.CommerceData;
import com.facebook.messaging.business.commerce.model.retail.Receipt;
import com.facebook.messaging.business.commerce.model.retail.ReceiptBuilder;
import com.facebook.messaging.business.commerce.model.retail.RetailAddress;
import com.facebook.messaging.business.commerce.model.retail.RetailCarrier;
import com.facebook.messaging.business.commerce.model.retail.Shipment;
import com.facebook.messaging.business.commerce.model.retail.ShipmentTrackingEvent;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger.CommerceNetworkRequestTypes;
import com.facebook.messaging.business.commerceui.views.retail.MapViewHelper.C09712;
import com.facebook.messaging.business.common.activity.BusinessActivity;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceRetailItem;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceLocationModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsModels.CommerceShipmentBubbleModel.RetailShipmentItemsModel;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: nub_y */
public final class ShippingDetailsFragment extends FbFragment implements BusinessActivityFragment {
    public static final CallerContext f8594i = CallerContext.a(ShippingDetailsFragment.class);
    @Inject
    public CommerceViewHelpers f8595a;
    public BetterTextView aA;
    public BetterTextView aB;
    public BetterTextView aC;
    public BetterTextView aD;
    public BetterTextView aE;
    public BetterTextView aF;
    public BetterTextView aG;
    private BetterTextView aH;
    public LinearLayout aI;
    private LinearLayout aJ;
    public BetterTextView aK;
    public BetterTextView aL;
    public BetterTextView aM;
    public FbDraweeView aN;
    @Nullable
    public EventListener aO;
    public CommerceBubbleModel al;
    public Receipt am;
    public Shipment an;
    private ImmutableList<ShipmentTrackingEvent> ao;
    public FbMapViewDelegate ap;
    public View aq;
    public ScrollView ar;
    private View as;
    public FrameLayout at;
    public LinearLayout au;
    public BetterTextView av;
    public View aw;
    public BetterTextView ax;
    public View ay;
    public BetterTextView az;
    @Inject
    GraphQLQueryExecutor f8596b;
    @Inject
    public TasksManager f8597c;
    @Inject
    SecureContextHelper f8598d;
    @Inject
    ModelConverters f8599e;
    @Inject
    public MessengerCommerceAnalyticsLogger f8600f;
    @Inject
    public MonotonicClock f8601g;
    @Inject
    public MapViewHelper f8602h;

    /* compiled from: nub_y */
    class C09811 implements OnClickListener {
        final /* synthetic */ ShippingDetailsFragment f8586a;

        C09811(ShippingDetailsFragment shippingDetailsFragment) {
            this.f8586a = shippingDetailsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -94620387);
            MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger;
            String str;
            if (view == this.f8586a.av && this.f8586a.an != null && this.f8586a.an.e != null) {
                messengerCommerceAnalyticsLogger = this.f8586a.f8600f;
                str = this.f8586a.an.a;
                Preconditions.checkNotNull(str);
                messengerCommerceAnalyticsLogger.f8365a.a(MessengerCommerceAnalyticsLogger.m8653f("did_tap_change_shipping_button").b("shipment_id", str));
                this.f8586a.f8598d.b(new Intent("android.intent.action.VIEW", this.f8586a.an.e), this.f8586a.getContext());
            } else if (view == this.f8586a.ax && this.f8586a.am != null) {
                messengerCommerceAnalyticsLogger = this.f8586a.f8600f;
                str = this.f8586a.am.b;
                Preconditions.checkNotNull(str);
                messengerCommerceAnalyticsLogger.f8365a.a(MessengerCommerceAnalyticsLogger.m8653f("did_tap_view_receipt_button").b("receipt_id", str));
                Intent c = ReceiptDetailsFragment.m8792c(this.f8586a.getContext(), this.f8586a.am.a);
                if (c != null) {
                    this.f8586a.f8598d.a(c, this.f8586a.getContext());
                }
            }
            LogUtils.a(1028074992, a);
        }
    }

    /* compiled from: nub_y */
    class C09822 implements OnTouchListener {
        final /* synthetic */ ShippingDetailsFragment f8587a;

        C09822(ShippingDetailsFragment shippingDetailsFragment) {
            this.f8587a = shippingDetailsFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f8587a.ar.requestDisallowInterceptTouchEvent(true);
                    break;
                case 1:
                case 3:
                    this.f8587a.ar.requestDisallowInterceptTouchEvent(false);
                    break;
            }
            return this.f8587a.ap.dispatchTouchEvent(motionEvent);
        }
    }

    /* compiled from: nub_y */
    class C09833 implements OnLayoutChangeListener {
        final /* synthetic */ ShippingDetailsFragment f8588a;

        C09833(ShippingDetailsFragment shippingDetailsFragment) {
            this.f8588a = shippingDetailsFragment;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            CommerceViewHelpers commerceViewHelpers = this.f8588a.f8595a;
            ViewGroup viewGroup = this.f8588a.at;
            int measuredHeight = this.f8588a.ap.getMeasuredHeight() + this.f8588a.aw.getMeasuredHeight();
            Preconditions.checkNotNull(view);
            Preconditions.checkNotNull(viewGroup);
            if (viewGroup.getVisibility() == 0) {
                LayoutParams layoutParams = viewGroup.getLayoutParams();
                layoutParams.width = view.getMeasuredWidth();
                layoutParams.height = view.getMeasuredHeight() - measuredHeight;
                viewGroup.setLayoutParams(layoutParams);
            }
            this.f8588a.ap.a(new C09712(this.f8588a.f8602h));
        }
    }

    /* compiled from: nub_y */
    public class Factory implements com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory {
        public final String mo307a() {
            return "ShippingDetailsFragment";
        }

        public final BusinessActivityFragment mo308b() {
            return new ShippingDetailsFragment();
        }
    }

    /* compiled from: nub_y */
    public enum Tasks {
        SHIPPING_DETAILS
    }

    public static void m8820a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ShippingDetailsFragment) obj).m8818a(CommerceViewHelpers.m8755b(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ModelConverters.a(injectorLike), MessengerCommerceAnalyticsLogger.m8651b(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), MapViewHelper.m8760b(injectorLike));
    }

    private void m8818a(CommerceViewHelpers commerceViewHelpers, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, SecureContextHelper secureContextHelper, ModelConverters modelConverters, MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger, MonotonicClock monotonicClock, MapViewHelper mapViewHelper) {
        this.f8595a = commerceViewHelpers;
        this.f8596b = graphQLQueryExecutor;
        this.f8597c = tasksManager;
        this.f8598d = secureContextHelper;
        this.f8599e = modelConverters;
        this.f8600f = messengerCommerceAnalyticsLogger;
        this.f8601g = monotonicClock;
        this.f8602h = mapViewHelper;
    }

    public static Intent m8817a(Context context, CommerceData commerceData) {
        boolean z;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(commerceData);
        if (commerceData.a != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkNotNull(Boolean.valueOf(z));
        return BusinessActivity.m8889a(context, "ShippingDetailsFragment", commerceData);
    }

    public final void mo310a(Parcelable parcelable) {
        Preconditions.checkState(parcelable instanceof CommerceData);
        CommerceBubbleModel commerceBubbleModel = ((CommerceData) parcelable).a;
        Preconditions.checkNotNull(commerceBubbleModel);
        Preconditions.checkState(CommerceBubbleModelType.isShippingBubble(commerceBubbleModel.b()));
        this.al = commerceBubbleModel;
    }

    public final void m8829c(Bundle bundle) {
        super.c(bundle);
        Class cls = ShippingDetailsFragment.class;
        m8820a((Object) this, getContext());
    }

    public final void m8830e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("fragment_state", this.al);
    }

    public final View m8823a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1096242040);
        if (bundle != null && this.al == null) {
            this.al = (CommerceBubbleModel) bundle.getParcelable("fragment_state");
        }
        View inflate = layoutInflater.inflate(2130905612, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2089542187, a);
        return inflate;
    }

    public final void m8826a(View view, Bundle bundle) {
        String str;
        super.a(view, bundle);
        Preconditions.checkNotNull(this.al);
        this.aq = e(2131564598);
        this.ar = (ScrollView) e(2131564600);
        this.ap = (FbMapViewDelegate) e(2131564599);
        this.ap.a(null);
        this.as = e(2131564601);
        this.at = (FrameLayout) e(2131564538);
        this.au = (LinearLayout) e(2131564602);
        this.av = (BetterTextView) e(2131564603);
        this.aw = e(2131564604);
        this.ax = (BetterTextView) e(2131564605);
        this.ay = e(2131564606);
        this.az = (BetterTextView) e(2131564607);
        this.aA = (BetterTextView) e(2131564608);
        this.aB = (BetterTextView) e(2131564609);
        this.aC = (BetterTextView) e(2131564610);
        this.aD = (BetterTextView) e(2131564611);
        this.aE = (BetterTextView) e(2131564612);
        this.aF = (BetterTextView) e(2131564613);
        this.aG = (BetterTextView) e(2131564615);
        this.aH = (BetterTextView) e(2131564616);
        this.aI = (LinearLayout) e(2131564617);
        this.aJ = (LinearLayout) e(2131564619);
        this.aK = (BetterTextView) e(2131564620);
        this.aL = (BetterTextView) e(2131564622);
        this.aM = (BetterTextView) e(2131564623);
        this.aN = (FbDraweeView) e(2131564621);
        OnClickListener c09811 = new C09811(this);
        this.av.setOnClickListener(c09811);
        this.ax.setOnClickListener(c09811);
        this.as.setOnTouchListener(new C09822(this));
        view.addOnLayoutChangeListener(new C09833(this));
        this.aL.setOnCreateContextMenuListener(this);
        if (this.al.b() == CommerceBubbleModelType.SHIPMENT || this.al.b() == CommerceBubbleModelType.SHIPMENT_FOR_UNSUPPORTED_CARRIER) {
            Preconditions.checkState(this.al instanceof Shipment);
            str = ((Shipment) this.al).a;
        } else {
            Preconditions.checkState(this.al instanceof ShipmentTrackingEvent);
            ShipmentTrackingEvent shipmentTrackingEvent = (ShipmentTrackingEvent) this.al;
            str = shipmentTrackingEvent.f != null ? shipmentTrackingEvent.f.a : null;
        }
        if (str != null) {
            Preconditions.checkNotNull(str);
            if (!(this.at == null || this.au == null)) {
                CommerceViewHelpers.m8754a(this.T, this.at, this.au, true);
            }
            final MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger = this.f8600f;
            final long now = this.f8601g.now();
            this.f8597c.a(Tasks.SHIPPING_DETAILS, new Callable<ListenableFuture<GraphQLResult<CommerceShipmentDetailsModel>>>(this) {
                final /* synthetic */ ShippingDetailsFragment f8590b;

                public Object call() {
                    GraphQlQueryString commerceShipmentQueryString = new CommerceShipmentQueryString();
                    commerceShipmentQueryString.a("shipment_id", str).a("item_count", "20").a("event_count", "20");
                    return this.f8590b.f8596b.a(GraphQLRequest.a(commerceShipmentQueryString).a(GraphQLCachePolicy.a).a(600));
                }
            }, AbstractDisposableFutureCallback.a(new FutureCallback<GraphQLResult<CommerceShipmentDetailsModel>>(this) {
                final /* synthetic */ ShippingDetailsFragment f8593c;

                public void onSuccess(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    boolean z = false;
                    ShippingDetailsFragment.m8819a(this.f8593c, (CommerceShipmentDetailsModel) graphQLResult.e);
                    ShippingDetailsFragment.m8822e(this.f8593c);
                    if (!(graphQLResult.e == null || this.f8593c.aq == null || this.f8593c.at == null || this.f8593c.au == null)) {
                        CommerceViewHelpers commerceViewHelpers = this.f8593c.f8595a;
                        CommerceViewHelpers.m8754a(this.f8593c.aq, this.f8593c.at, this.f8593c.au, false);
                    }
                    MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger = messengerCommerceAnalyticsLogger;
                    CommerceNetworkRequestTypes commerceNetworkRequestTypes = CommerceNetworkRequestTypes.SHIPMENT;
                    if (graphQLResult.e != null) {
                        z = true;
                    }
                    messengerCommerceAnalyticsLogger.m8655a(commerceNetworkRequestTypes, z, this.f8593c.f8601g.now() - now, null);
                    if (this.f8593c.aO == null) {
                        return;
                    }
                    if (graphQLResult.e != null) {
                        this.f8593c.aO.mo313a();
                    } else {
                        this.f8593c.aO.mo314b();
                    }
                }

                public void onFailure(Throwable th) {
                    messengerCommerceAnalyticsLogger.m8655a(CommerceNetworkRequestTypes.SHIPMENT, false, this.f8593c.f8601g.now() - now, th != null ? th.getMessage() : null);
                    if (this.f8593c.aO != null) {
                        this.f8593c.aO.mo314b();
                    }
                }
            }));
        }
    }

    @TargetApi(16)
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        o().getMenuInflater().inflate(2131820557, contextMenu);
        this.aL.setBackground(new ColorDrawable(jW_().getColor(2131363770)));
        contextMenu.findItem(2131568627).setVisible(false);
    }

    @TargetApi(16)
    public final boolean m8828b(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131568628) {
            return false;
        }
        String str;
        if (this.aL.getText() == null) {
            str = new String();
        } else {
            str = this.aL.getText().toString();
        }
        ((ClipboardManager) o().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(mo309a(getContext()), str));
        this.aL.setBackground(new ColorDrawable(jW_().getColor(2131361871)));
        return true;
    }

    public static void m8819a(ShippingDetailsFragment shippingDetailsFragment, CommerceShipmentDetailsModel commerceShipmentDetailsModel) {
        if (commerceShipmentDetailsModel != null) {
            shippingDetailsFragment.an = ModelConverters.a(commerceShipmentDetailsModel);
            Receipt receipt = null;
            if (commerceShipmentDetailsModel != null) {
                ReceiptModel d = commerceShipmentDetailsModel.d();
                if (!(d == null || Strings.isNullOrEmpty(d.b()))) {
                    ReceiptBuilder receiptBuilder = new ReceiptBuilder();
                    receiptBuilder.b = commerceShipmentDetailsModel.A();
                    CommerceLocationModel x = commerceShipmentDetailsModel.x();
                    if (x != null) {
                        receiptBuilder.g = ModelConverters.a(x);
                    }
                    List arrayList = new ArrayList();
                    RetailShipmentItemsModel C = commerceShipmentDetailsModel.C();
                    if (!(C == null || C.b() == null)) {
                        ImmutableList b = C.b();
                        int size = b.size();
                        for (int i = 0; i < size; i++) {
                            PlatformGenericAttachmentItem a = PlatformAttachmentsConverter.a((CommerceRetailItem) b.get(i));
                            if (a != null) {
                                arrayList.add(a);
                            }
                        }
                    }
                    receiptBuilder.a = d.b();
                    receiptBuilder.r = d.d();
                    receiptBuilder.p = ModelConverters.a(d.c());
                    receiptBuilder.q = arrayList;
                    receipt = receiptBuilder.u();
                }
            }
            shippingDetailsFragment.am = receipt;
            if (commerceShipmentDetailsModel.j() != null && commerceShipmentDetailsModel.j().a() != null && !commerceShipmentDetailsModel.j().a().isEmpty()) {
                shippingDetailsFragment.ao = shippingDetailsFragment.an.q;
            }
        }
    }

    public final void mo311a(EventListener eventListener) {
        this.aO = eventListener;
    }

    public final String mo309a(Context context) {
        return context.getString(2131240689);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1820963624);
        this.f8597c.c();
        CommerceViewHelpers.m8754a(this.aq, this.at, this.au, false);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -478759358, a);
    }

    public static void m8822e(ShippingDetailsFragment shippingDetailsFragment) {
        RetailCarrier retailCarrier;
        LogoImage logoImage;
        if (shippingDetailsFragment.an == null || shippingDetailsFragment.an.e == null) {
            shippingDetailsFragment.av.setVisibility(8);
            shippingDetailsFragment.aw.setVisibility(8);
        } else {
            shippingDetailsFragment.av.setVisibility(0);
            shippingDetailsFragment.aw.setVisibility(0);
        }
        if (shippingDetailsFragment.am != null) {
            shippingDetailsFragment.ax.setVisibility(0);
            shippingDetailsFragment.ay.setVisibility(0);
        } else {
            shippingDetailsFragment.ax.setVisibility(8);
            shippingDetailsFragment.ay.setVisibility(8);
        }
        shippingDetailsFragment.az.setVisibility(0);
        shippingDetailsFragment.aA.setVisibility(0);
        if (!Strings.isNullOrEmpty(shippingDetailsFragment.an.m)) {
            shippingDetailsFragment.aA.setText(shippingDetailsFragment.an.m);
        } else if (Strings.isNullOrEmpty(shippingDetailsFragment.an.k)) {
            shippingDetailsFragment.az.setVisibility(8);
            shippingDetailsFragment.aA.setVisibility(8);
        } else {
            shippingDetailsFragment.aA.setText(shippingDetailsFragment.an.k);
        }
        if (shippingDetailsFragment.am == null || Strings.isNullOrEmpty(shippingDetailsFragment.am.p)) {
            shippingDetailsFragment.aC.setVisibility(8);
        } else {
            shippingDetailsFragment.aC.setText(shippingDetailsFragment.am.p);
            shippingDetailsFragment.aC.setVisibility(0);
        }
        RetailAddress retailAddress = shippingDetailsFragment.an.i;
        if (retailAddress != null) {
            if (Strings.isNullOrEmpty(retailAddress.a) && Strings.isNullOrEmpty(retailAddress.b)) {
                shippingDetailsFragment.aD.setVisibility(8);
                shippingDetailsFragment.aE.setVisibility(8);
            } else {
                if (Strings.isNullOrEmpty(retailAddress.a)) {
                    shippingDetailsFragment.aD.setVisibility(8);
                } else {
                    shippingDetailsFragment.aD.setText(retailAddress.a);
                    shippingDetailsFragment.aD.setVisibility(0);
                }
                if (Strings.isNullOrEmpty(retailAddress.b)) {
                    shippingDetailsFragment.aE.setVisibility(8);
                } else {
                    shippingDetailsFragment.aE.setText(retailAddress.b);
                    shippingDetailsFragment.aE.setVisibility(0);
                }
            }
            String a = CommerceViewHelpers.m8752a(shippingDetailsFragment.getContext(), retailAddress);
            if (Strings.isNullOrEmpty(a)) {
                shippingDetailsFragment.aF.setVisibility(8);
            } else {
                shippingDetailsFragment.aF.setVisibility(0);
                shippingDetailsFragment.aF.setText(a);
            }
        } else {
            shippingDetailsFragment.aD.setVisibility(8);
            shippingDetailsFragment.aE.setVisibility(8);
            shippingDetailsFragment.aF.setVisibility(8);
        }
        if (shippingDetailsFragment.aC.getVisibility() == 0 || shippingDetailsFragment.aD.getVisibility() == 0 || shippingDetailsFragment.aE.getVisibility() == 0 || shippingDetailsFragment.aF.getVisibility() == 0) {
            shippingDetailsFragment.aB.setVisibility(0);
        } else {
            shippingDetailsFragment.aB.setVisibility(8);
        }
        CharSequence charSequence = null;
        shippingDetailsFragment.aG.setText(shippingDetailsFragment.an.n);
        if (Strings.isNullOrEmpty(shippingDetailsFragment.an.c)) {
            shippingDetailsFragment.aK.setVisibility(8);
            shippingDetailsFragment.aL.setVisibility(8);
        } else {
            shippingDetailsFragment.aK.setVisibility(0);
            shippingDetailsFragment.aL.setVisibility(0);
            shippingDetailsFragment.aL.setText(shippingDetailsFragment.an.c);
        }
        if (shippingDetailsFragment.an != null) {
            retailCarrier = shippingDetailsFragment.an.d;
        } else {
            retailCarrier = null;
        }
        CommerceViewHelpers commerceViewHelpers = shippingDetailsFragment.f8595a;
        FbDraweeView fbDraweeView = shippingDetailsFragment.aN;
        if (retailCarrier != null) {
            logoImage = retailCarrier.b;
        } else {
            logoImage = null;
        }
        boolean a2 = commerceViewHelpers.m8756a(fbDraweeView, logoImage, f8594i);
        BetterTextView betterTextView = shippingDetailsFragment.aM;
        if (retailCarrier != null) {
            charSequence = retailCarrier.d;
        }
        Preconditions.checkNotNull(betterTextView);
        if (!a2 || Strings.isNullOrEmpty(charSequence)) {
            betterTextView.setVisibility(8);
        } else {
            betterTextView.setText(charSequence);
            betterTextView.setVisibility(0);
        }
        shippingDetailsFragment.au();
        shippingDetailsFragment.av();
        shippingDetailsFragment.f8602h.m8761a(shippingDetailsFragment.al, shippingDetailsFragment.ap);
    }

    private void au() {
        this.aI.removeAllViews();
        if (this.an == null || this.an.p == null || this.an.p.isEmpty()) {
            this.aH.setVisibility(8);
            this.aI.setVisibility(8);
            return;
        }
        this.aH.setVisibility(0);
        this.aI.setVisibility(0);
        if (this.an.p.size() == 1) {
            this.aH.setText(jW_().getString(2131240669));
        } else {
            this.aH.setText(jW_().getString(2131240670));
        }
        ImmutableList immutableList = this.an.p;
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            int i4;
            PlatformGenericAttachmentItem platformGenericAttachmentItem = (PlatformGenericAttachmentItem) immutableList.get(i);
            if (Strings.isNullOrEmpty(platformGenericAttachmentItem.b)) {
                i3 = 0;
            } else {
                ViewGroup viewGroup = (ViewGroup) LinearLayout.inflate(getContext(), 2130905613, null);
                FbDraweeView fbDraweeView = (FbDraweeView) viewGroup.findViewById(2131564624);
                if (platformGenericAttachmentItem.d != null) {
                    fbDraweeView.a(platformGenericAttachmentItem.d, f8594i);
                }
                ((BetterTextView) viewGroup.findViewById(2131564625)).setText(platformGenericAttachmentItem.b);
                BetterTextView betterTextView = (BetterTextView) viewGroup.findViewById(2131564626);
                if (Strings.isNullOrEmpty(platformGenericAttachmentItem.g)) {
                    betterTextView.setVisibility(8);
                } else {
                    betterTextView.setText(platformGenericAttachmentItem.g);
                    betterTextView.setVisibility(0);
                }
                this.aI.addView(viewGroup);
                int dimension = (int) jW_().getDimension(2131433499);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.setMargins(dimension, (int) jW_().getDimension(2131433501), dimension, 0);
                viewGroup.setLayoutParams(layoutParams);
                i3 = 1;
            }
            if (i3 != 0) {
                i4 = i2 + 1;
            } else {
                i4 = i2;
            }
            if (i4 < 20) {
                i++;
                i2 = i4;
            } else {
                return;
            }
        }
    }

    private void av() {
        this.aJ.removeAllViews();
        if (this.ao == null || this.ao.isEmpty()) {
            m8821a(jW_().getString(2131240694), "");
            return;
        }
        int size = this.ao.size();
        for (int i = 0; i < size; i++) {
            ShipmentTrackingEvent shipmentTrackingEvent = (ShipmentTrackingEvent) this.ao.get(i);
            m8821a(shipmentTrackingEvent.b, shipmentTrackingEvent.d);
        }
    }

    private boolean m8821a(String str, String str2) {
        if (Strings.isNullOrEmpty(str)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) LinearLayout.inflate(getContext(), 2130905611, this.aJ);
        int childCount = this.aJ.getChildCount();
        ((BetterTextView) this.aJ.getChildAt(childCount - 2)).setText(str);
        BetterTextView betterTextView = (BetterTextView) this.aJ.getChildAt(childCount - 1);
        if (Strings.isNullOrEmpty(str2)) {
            betterTextView.setVisibility(8);
        } else {
            betterTextView.setText(str2);
            betterTextView.setVisibility(0);
        }
        childCount = (int) jW_().getDimension(2131433499);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams.setMargins(childCount, 0, childCount, 0);
        viewGroup.setLayoutParams(layoutParams);
        return true;
    }
}
