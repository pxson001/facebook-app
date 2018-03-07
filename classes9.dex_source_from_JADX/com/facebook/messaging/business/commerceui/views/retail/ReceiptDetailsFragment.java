package com.facebook.messaging.business.commerceui.views.retail;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.enums.GraphQLMessengerRetailItemStatus;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.commerce.converters.ModelConverters;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragments.CommerceOrderReceiptItemPaginatedQueryString;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragments.CommerceOrderReceiptQueryString;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsInterfaces.CommercePaginatedRetailItems;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceOrderReceiptModel;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommerceOrderReceiptModel.RetailAdjustmentsModel;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.CommercePaginatedRetailItemsModel;
import com.facebook.messaging.business.commerce.model.retail.Receipt;
import com.facebook.messaging.business.commerce.model.retail.ReceiptBuilder;
import com.facebook.messaging.business.commerce.model.retail.RetailAddress;
import com.facebook.messaging.business.commerce.model.retail.RetailAdjustment;
import com.facebook.messaging.business.commerce.model.retail.RetailAdjustmentBuilder;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger.CommerceNetworkRequestTypes;
import com.facebook.messaging.business.common.activity.BusinessActivity;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceRetailItem;
import com.facebook.resources.ui.FbButton;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: null ViewerContextUser found when canceling payment transaction id %s */
public class ReceiptDetailsFragment extends FbFragment implements BusinessActivityFragment {
    private static final CallerContext f8564f = CallerContext.a(ReceiptDetailsFragment.class);
    @Inject
    CommerceViewHelpers f8565a;
    private FbButton aA;
    private ProgressBar aB;
    private FrameLayout aC;
    private BetterTextView aD;
    public DefaultPageInfoFields aE;
    public int aF;
    private ImmutableList<? extends CommerceRetailItem> aG;
    public String aH;
    @Nullable
    private EventListener aI;
    @Nullable
    private Receipt aJ;
    private boolean aK;
    private FbDraweeView al;
    private RelativeLayout am;
    private BetterTextView an;
    private BetterTextView ao;
    private BetterTextView ap;
    private BetterTextView aq;
    private BetterTextView ar;
    private BetterTextView as;
    private BetterTextView at;
    private BetterTextView au;
    private BetterTextView av;
    private BetterTextView aw;
    private LinearLayout ax;
    public BetterTextView ay;
    private LinearLayout az;
    @Inject
    GraphQLQueryExecutor f8566b;
    @Inject
    public TasksManager f8567c;
    @Inject
    MessengerCommerceAnalyticsLogger f8568d;
    @Inject
    public MonotonicClock f8569e;
    private ReceiptViewModelHelper f8570g;
    private View f8571h;
    private View f8572i;

    /* compiled from: null ViewerContextUser found when canceling payment transaction id %s */
    class C09741 implements OnClickListener {
        final /* synthetic */ ReceiptDetailsFragment f8554a;

        C09741(ReceiptDetailsFragment receiptDetailsFragment) {
            this.f8554a = receiptDetailsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1123758071);
            if (!Strings.isNullOrEmpty(this.f8554a.aH)) {
                ReceiptDetailsFragment receiptDetailsFragment = this.f8554a;
                String str = this.f8554a.aH;
                if (!(Strings.isNullOrEmpty(str) || receiptDetailsFragment.aE == null)) {
                    long now = receiptDetailsFragment.f8569e.now();
                    ReceiptDetailsFragment.m8791b(receiptDetailsFragment, ViewState.SPINNER);
                    receiptDetailsFragment.f8567c.a(Tasks.ITEM_PAGINATION, new C09774(receiptDetailsFragment, str), AbstractDisposableFutureCallback.a(new C09785(receiptDetailsFragment, now)));
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 45785364, a);
        }
    }

    /* compiled from: null ViewerContextUser found when canceling payment transaction id %s */
    public class C09774 implements Callable<ListenableFuture<GraphQLResult<CommercePaginatedRetailItemsModel>>> {
        final /* synthetic */ String f8559a;
        final /* synthetic */ ReceiptDetailsFragment f8560b;

        public Object call() {
            GraphQlQueryString commerceOrderReceiptItemPaginatedQueryString = new CommerceOrderReceiptItemPaginatedQueryString();
            commerceOrderReceiptItemPaginatedQueryString.a("order_receipt_id", this.f8559a).a("item_after_cursor", this.f8560b.aE.a()).a("item_count", "10");
            return this.f8560b.f8566b.a(GraphQLRequest.a(commerceOrderReceiptItemPaginatedQueryString).a(GraphQLCachePolicy.a).a(600));
        }

        public C09774(ReceiptDetailsFragment receiptDetailsFragment, String str) {
            this.f8560b = receiptDetailsFragment;
            this.f8559a = str;
        }
    }

    /* compiled from: null ViewerContextUser found when canceling payment transaction id %s */
    public class C09785 implements FutureCallback<GraphQLResult<CommercePaginatedRetailItemsModel>> {
        final /* synthetic */ long f8561a;
        final /* synthetic */ ReceiptDetailsFragment f8562b;

        public C09785(ReceiptDetailsFragment receiptDetailsFragment, long j) {
            this.f8562b = receiptDetailsFragment;
            this.f8561a = j;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            ReceiptDetailsFragment.m8791b(this.f8562b, ViewState.CONTENT);
            ReceiptDetailsFragment.m8790b(this.f8562b, (CommercePaginatedRetailItems) graphQLResult.e);
            ReceiptDetailsFragment.aq(this.f8562b);
            ReceiptDetailsFragment.m8784a(this.f8562b, graphQLResult, this.f8561a, false);
        }

        public void onFailure(Throwable th) {
            ReceiptDetailsFragment.m8791b(this.f8562b, ViewState.CONTENT);
            ReceiptDetailsFragment.m8787a(this.f8562b, th, this.f8561a, false);
        }
    }

    /* compiled from: null ViewerContextUser found when canceling payment transaction id %s */
    public class Factory implements com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory {
        public final String mo307a() {
            return "ReceiptDetailsFragment";
        }

        public final BusinessActivityFragment mo308b() {
            return new ReceiptDetailsFragment();
        }
    }

    /* compiled from: null ViewerContextUser found when canceling payment transaction id %s */
    public enum Tasks {
        ORDER_DETAILS,
        ITEM_PAGINATION
    }

    /* compiled from: null ViewerContextUser found when canceling payment transaction id %s */
    public enum ViewState {
        CONTENT,
        SPINNER,
        ERROR_VIEW
    }

    public static void m8788a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ReceiptDetailsFragment) obj).m8783a(CommerceViewHelpers.m8755b(fbInjector), GraphQLQueryExecutor.a(fbInjector), TasksManager.b(fbInjector), MessengerCommerceAnalyticsLogger.m8651b(fbInjector), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector));
    }

    private void m8783a(CommerceViewHelpers commerceViewHelpers, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger, MonotonicClock monotonicClock) {
        this.f8565a = commerceViewHelpers;
        this.f8566b = graphQLQueryExecutor;
        this.f8567c = tasksManager;
        this.f8568d = messengerCommerceAnalyticsLogger;
        this.f8569e = monotonicClock;
    }

    public static Intent m8792c(Context context, String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
        Parcelable bundle = new Bundle();
        bundle.putString("receipt_id", str);
        return BusinessActivity.m8889a(context, "ReceiptDetailsFragment", bundle);
    }

    public final void mo310a(Parcelable parcelable) {
        this.aH = ((Bundle) parcelable).getString("receipt_id");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(this.aH));
    }

    public final void m8800c(Bundle bundle) {
        super.c(bundle);
        Class cls = ReceiptDetailsFragment.class;
        m8788a((Object) this, getContext());
    }

    public final void m8801e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("receipt_id", this.aH);
    }

    public final View m8794a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1784721990);
        if (bundle != null && Strings.isNullOrEmpty(this.aH)) {
            this.aH = bundle.getString("receipt_id");
        }
        View inflate = layoutInflater.inflate(2130905600, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2016051760, a);
        return inflate;
    }

    public final void m8797a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f8570g = new ReceiptViewModelHelper(getContext());
        this.f8571h = e(2131564542);
        this.f8572i = e(2131564543);
        this.al = (FbDraweeView) e(2131564544);
        this.az = (LinearLayout) e(2131564545);
        this.aA = (FbButton) e(2131564547);
        this.aB = (ProgressBar) e(2131564548);
        this.aC = (FrameLayout) e(2131564538);
        this.am = (RelativeLayout) e(2131564550);
        this.an = (BetterTextView) e(2131564551);
        this.ao = (BetterTextView) e(2131564552);
        this.ap = (BetterTextView) e(2131564553);
        this.aq = (BetterTextView) e(2131564554);
        this.ar = (BetterTextView) e(2131564555);
        this.as = (BetterTextView) e(2131564556);
        this.at = (BetterTextView) e(2131564557);
        this.au = (BetterTextView) e(2131564558);
        this.av = (BetterTextView) e(2131564559);
        this.aw = (BetterTextView) e(2131564560);
        this.ax = (LinearLayout) e(2131564561);
        this.ay = (BetterTextView) e(2131564563);
        this.aD = (BetterTextView) e(2131560093);
        this.aA.setOnClickListener(new C09741(this));
        this.ay.setOnCreateContextMenuListener(this);
        final String str = this.aH;
        if (!Strings.isNullOrEmpty(str)) {
            final long now = this.f8569e.now();
            m8786a(this, ViewState.SPINNER);
            this.f8567c.a(Tasks.ORDER_DETAILS, new Callable<ListenableFuture<GraphQLResult<CommerceOrderReceiptModel>>>(this) {
                final /* synthetic */ ReceiptDetailsFragment f8556b;

                public Object call() {
                    GraphQlQueryString commerceOrderReceiptQueryString = new CommerceOrderReceiptQueryString();
                    commerceOrderReceiptQueryString.a("order_receipt_id", str).a("item_count", "5");
                    return this.f8556b.f8566b.a(GraphQLRequest.a(commerceOrderReceiptQueryString).a(GraphQLCachePolicy.a).a(600));
                }
            }, AbstractDisposableFutureCallback.a(new FutureCallback<GraphQLResult<CommerceOrderReceiptModel>>(this) {
                final /* synthetic */ ReceiptDetailsFragment f8558b;

                public void onSuccess(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    ReceiptDetailsFragment.m8786a(this.f8558b, ViewState.CONTENT);
                    ReceiptDetailsFragment.m8785a(this.f8558b, (CommerceOrderReceiptModel) graphQLResult.e);
                    ReceiptDetailsFragment.m8784a(this.f8558b, graphQLResult, now, true);
                }

                public void onFailure(Throwable th) {
                    ReceiptDetailsFragment.m8786a(this.f8558b, ViewState.ERROR_VIEW);
                    ReceiptDetailsFragment.m8787a(this.f8558b, th, now, true);
                }
            }));
        }
    }

    @TargetApi(16)
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        o().getMenuInflater().inflate(2131820557, contextMenu);
        this.ay.setBackground(new ColorDrawable(jW_().getColor(2131363770)));
        contextMenu.findItem(2131568628).setVisible(false);
    }

    public static void m8785a(ReceiptDetailsFragment receiptDetailsFragment, CommerceOrderReceiptModel commerceOrderReceiptModel) {
        Receipt receipt;
        ReceiptBuilder a = ModelConverters.a(commerceOrderReceiptModel);
        if (a == null) {
            receipt = null;
        } else {
            Builder builder = new Builder();
            ImmutableList p = commerceOrderReceiptModel.p();
            int size = p.size();
            for (int i = 0; i < size; i++) {
                RetailAdjustmentsModel retailAdjustmentsModel = (RetailAdjustmentsModel) p.get(i);
                RetailAdjustmentBuilder retailAdjustmentBuilder = new RetailAdjustmentBuilder();
                retailAdjustmentBuilder.a = retailAdjustmentsModel.b();
                retailAdjustmentBuilder.b = retailAdjustmentsModel.a();
                builder.c(new RetailAdjustment(retailAdjustmentBuilder));
            }
            a.l = builder.b();
            a.f(commerceOrderReceiptModel.m());
            a.c = commerceOrderReceiptModel.r();
            a.d = commerceOrderReceiptModel.aC_();
            a.j = commerceOrderReceiptModel.t();
            a.m = commerceOrderReceiptModel.s();
            a.k = commerceOrderReceiptModel.q();
            a.r = commerceOrderReceiptModel.o();
            a.s = commerceOrderReceiptModel.l();
            a.n = commerceOrderReceiptModel.n();
            a.g = ModelConverters.a(commerceOrderReceiptModel.aE_());
            receipt = a.u();
        }
        receiptDetailsFragment.aJ = receipt;
        receiptDetailsFragment.f8570g.m8802a(receiptDetailsFragment.aJ);
        if (!(commerceOrderReceiptModel == null || commerceOrderReceiptModel.u() == null)) {
            receiptDetailsFragment.aF = commerceOrderReceiptModel.u().a();
        }
        m8790b(receiptDetailsFragment, (CommercePaginatedRetailItems) commerceOrderReceiptModel);
        receiptDetailsFragment.m8793e();
    }

    @TargetApi(16)
    public final boolean m8799b(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131568627) {
            return false;
        }
        String str;
        if (this.ay.getText() == null) {
            str = new String();
        } else {
            str = this.ay.getText().toString();
        }
        ((ClipboardManager) o().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(mo309a(getContext()), str));
        this.ay.setBackground(new ColorDrawable(jW_().getColor(2131361871)));
        return true;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1965783322);
        this.f8567c.c();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -363477788, a);
    }

    public static void m8790b(@Nullable ReceiptDetailsFragment receiptDetailsFragment, CommercePaginatedRetailItems commercePaginatedRetailItems) {
        if (commercePaginatedRetailItems != null && commercePaginatedRetailItems.u() != null) {
            receiptDetailsFragment.aE = commercePaginatedRetailItems.u().c();
            if (commercePaginatedRetailItems.u().b() != null && !commercePaginatedRetailItems.u().b().isEmpty()) {
                receiptDetailsFragment.aG = commercePaginatedRetailItems.u().b();
                receiptDetailsFragment.aF -= receiptDetailsFragment.aG.size();
            }
        }
    }

    public final void mo311a(EventListener eventListener) {
        this.aI = eventListener;
    }

    public final String mo309a(Context context) {
        return context.getString(2131240690);
    }

    private void m8793e() {
        if (this.aJ != null) {
            this.f8565a.m8756a(this.al, this.f8570g.m8803c(), f8564f);
            this.az.removeAllViews();
            aq(this);
            if (Strings.isNullOrEmpty(this.aJ.o)) {
                this.an.setVisibility(8);
                this.ao.setVisibility(8);
            } else {
                this.an.setVisibility(0);
                this.ao.setVisibility(0);
                this.ao.setText(this.aJ.o);
            }
            if (!this.aK) {
                if (this.aJ.p != null) {
                    m8782a(this.aJ.g, this.aJ.p);
                } else {
                    m8782a(this.aJ.g, null);
                }
                if (Strings.isNullOrEmpty(this.aJ.d)) {
                    this.au.setVisibility(8);
                    this.av.setVisibility(8);
                } else {
                    this.au.setVisibility(0);
                    this.av.setVisibility(0);
                    this.av.setText(this.aJ.d);
                }
            }
            this.ax.removeAllViews();
            m8789a(jW_().getString(2131240707), this.aJ.m, false);
            m8789a(jW_().getString(2131240708), this.aJ.l, false);
            ImmutableList immutableList = this.aJ.k;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                RetailAdjustment retailAdjustment = (RetailAdjustment) immutableList.get(i);
                m8789a(retailAdjustment.a, retailAdjustment.b, false);
            }
            m8789a(jW_().getString(2131240709), this.aJ.j, false);
            m8789a(jW_().getString(2131240710), this.aJ.i, true);
            if (Strings.isNullOrEmpty(this.aJ.m) && Strings.isNullOrEmpty(this.aJ.l) && Strings.isNullOrEmpty(this.aJ.j) && Strings.isNullOrEmpty(this.aJ.i)) {
                this.aw.setVisibility(8);
            } else {
                this.aw.setVisibility(0);
            }
            if (Strings.isNullOrEmpty(this.aJ.b)) {
                this.ay.setVisibility(8);
                return;
            }
            this.ay.setVisibility(0);
            this.ay.setText(StringLocaleUtil.a(jW_().getString(2131240711), new Object[]{this.aJ.b}));
        }
    }

    public static void aq(ReceiptDetailsFragment receiptDetailsFragment) {
        receiptDetailsFragment.aK = true;
        if (receiptDetailsFragment.aG != null) {
            int size = receiptDetailsFragment.aG.size();
            for (int i = 0; i < size; i++) {
                int i2;
                CommerceRetailItem commerceRetailItem = (CommerceRetailItem) receiptDetailsFragment.aG.get(i);
                ViewGroup viewGroup = (ViewGroup) LinearLayout.inflate(receiptDetailsFragment.getContext(), 2130905632, null);
                FbDraweeView fbDraweeView = (FbDraweeView) viewGroup.findViewById(2131564675);
                BetterTextView betterTextView = (BetterTextView) viewGroup.findViewById(2131564676);
                BetterTextView betterTextView2 = (BetterTextView) viewGroup.findViewById(2131564677);
                BetterTextView betterTextView3 = (BetterTextView) viewGroup.findViewById(2131564678);
                BetterTextView betterTextView4 = (BetterTextView) viewGroup.findViewById(2131564679);
                BetterTextView betterTextView5 = (BetterTextView) viewGroup.findViewById(2131564680);
                if (!Strings.isNullOrEmpty(commerceRetailItem.ax_())) {
                    fbDraweeView.a(Uri.parse(commerceRetailItem.ax_()), f8564f);
                }
                betterTextView.setVisibility(!Strings.isNullOrEmpty(commerceRetailItem.g()) ? 0 : 8);
                betterTextView.setText(commerceRetailItem.g());
                if (Strings.isNullOrEmpty(commerceRetailItem.d())) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                betterTextView2.setVisibility(i2);
                betterTextView2.setText(commerceRetailItem.d());
                if (Strings.isNullOrEmpty(commerceRetailItem.az_())) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                betterTextView3.setVisibility(i2);
                betterTextView3.setText(commerceRetailItem.az_());
                if (commerceRetailItem.k() == null || !commerceRetailItem.k().equals(GraphQLMessengerRetailItemStatus.CANCELED) || Strings.isNullOrEmpty(commerceRetailItem.aG_())) {
                    betterTextView5.setVisibility(!Strings.isNullOrEmpty(commerceRetailItem.aG_()) ? 0 : 8);
                    betterTextView4.setVisibility(8);
                    betterTextView5.setText(commerceRetailItem.aG_());
                    receiptDetailsFragment.aK = false;
                } else {
                    betterTextView4.setVisibility(0);
                    betterTextView4.setText(receiptDetailsFragment.jW_().getString(2131240713));
                    betterTextView5.setVisibility(0);
                    betterTextView5.setText(StringLocaleUtil.a(receiptDetailsFragment.jW_().getString(2131240712), new Object[]{commerceRetailItem.aG_()}));
                }
                receiptDetailsFragment.az.addView(viewGroup);
            }
            if (receiptDetailsFragment.aE == null || !receiptDetailsFragment.aE.b()) {
                receiptDetailsFragment.aA.setVisibility(8);
            } else {
                receiptDetailsFragment.aA.setText(receiptDetailsFragment.getContext().getString(2131240702, new Object[]{Integer.valueOf(receiptDetailsFragment.aF)}));
            }
        }
    }

    private void m8789a(@Nullable String str, @Nullable String str2, boolean z) {
        if (!Strings.isNullOrEmpty(str) && !Strings.isNullOrEmpty(str2)) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(2130905599, this.ax, false);
            BetterTextView betterTextView = (BetterTextView) linearLayout.findViewById(2131564540);
            BetterTextView betterTextView2 = (BetterTextView) linearLayout.findViewById(2131564541);
            betterTextView.setText(str);
            betterTextView2.setText(str2);
            if (z) {
                betterTextView.setTextAppearance(getContext(), 2131626380);
                betterTextView2.setTextAppearance(getContext(), 2131626380);
            }
            this.ax.addView(linearLayout);
        }
    }

    private void m8782a(RetailAddress retailAddress, String str) {
        if (str != null) {
            this.aq.setVisibility(0);
            this.aq.setText(str);
        } else {
            this.aq.setVisibility(8);
        }
        if (retailAddress != null) {
            if (Strings.isNullOrEmpty(retailAddress.a)) {
                this.ar.setVisibility(8);
            } else {
                this.ar.setVisibility(0);
                this.ar.setText(retailAddress.a);
            }
            if (Strings.isNullOrEmpty(retailAddress.b)) {
                this.as.setVisibility(8);
            } else {
                this.as.setVisibility(0);
                this.as.setText(retailAddress.b);
            }
            CharSequence a = CommerceViewHelpers.m8752a(getContext(), retailAddress);
            if (Strings.isNullOrEmpty(a)) {
                this.at.setVisibility(8);
            } else {
                this.at.setVisibility(0);
                this.at.setText(a);
            }
        } else {
            this.ar.setVisibility(8);
            this.as.setVisibility(8);
            this.at.setVisibility(8);
        }
        if (this.aq.getVisibility() == 0 || this.ar.getVisibility() == 0 || this.as.getVisibility() == 0 || this.at.getVisibility() == 0) {
            this.ap.setVisibility(0);
        } else {
            this.ap.setVisibility(8);
        }
    }

    public static void m8786a(ReceiptDetailsFragment receiptDetailsFragment, ViewState viewState) {
        switch (viewState) {
            case CONTENT:
                receiptDetailsFragment.aC.setVisibility(8);
                receiptDetailsFragment.aD.setVisibility(8);
                receiptDetailsFragment.f8571h.setVisibility(0);
                return;
            case SPINNER:
                receiptDetailsFragment.aC.setVisibility(0);
                receiptDetailsFragment.aD.setVisibility(4);
                receiptDetailsFragment.f8571h.setVisibility(4);
                return;
            case ERROR_VIEW:
                receiptDetailsFragment.aC.setVisibility(8);
                receiptDetailsFragment.aD.setVisibility(0);
                receiptDetailsFragment.f8571h.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public static void m8791b(ReceiptDetailsFragment receiptDetailsFragment, ViewState viewState) {
        switch (viewState) {
            case CONTENT:
                receiptDetailsFragment.aA.setVisibility(0);
                receiptDetailsFragment.aB.setVisibility(4);
                return;
            case SPINNER:
                receiptDetailsFragment.aA.setVisibility(4);
                receiptDetailsFragment.aB.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public static void m8784a(ReceiptDetailsFragment receiptDetailsFragment, GraphQLResult graphQLResult, long j, boolean z) {
        CommerceNetworkRequestTypes commerceNetworkRequestTypes;
        boolean z2;
        MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger = receiptDetailsFragment.f8568d;
        if (z) {
            commerceNetworkRequestTypes = CommerceNetworkRequestTypes.RECEIPT;
        } else {
            commerceNetworkRequestTypes = CommerceNetworkRequestTypes.RECEIPT_ITEM;
        }
        if (graphQLResult.e != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        messengerCommerceAnalyticsLogger.m8655a(commerceNetworkRequestTypes, z2, receiptDetailsFragment.f8569e.now() - j, null);
        if (receiptDetailsFragment.aI == null) {
            return;
        }
        if (graphQLResult.e != null) {
            receiptDetailsFragment.aI.mo313a();
        } else {
            receiptDetailsFragment.aI.mo314b();
        }
    }

    public static void m8787a(ReceiptDetailsFragment receiptDetailsFragment, Throwable th, long j, boolean z) {
        receiptDetailsFragment.f8568d.m8655a(z ? CommerceNetworkRequestTypes.RECEIPT : CommerceNetworkRequestTypes.RECEIPT_ITEM, false, receiptDetailsFragment.f8569e.now() - j, th != null ? th.getMessage() : null);
        if (receiptDetailsFragment.aI != null) {
            receiptDetailsFragment.aI.mo314b();
        }
    }
}
