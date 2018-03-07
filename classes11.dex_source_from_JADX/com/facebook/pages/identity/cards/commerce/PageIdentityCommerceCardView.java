package com.facebook.pages.identity.cards.commerce;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceProductSectionType;
import com.facebook.commerce.core.analytics.CommerceAnalytics.CommerceSubEvent;
import com.facebook.commerce.core.ui.ProductItemAtGlanceView;
import com.facebook.commerce.core.ui.ProductItemAtGlanceViewModel;
import com.facebook.commerce.core.util.CommerceCurrencyUtil;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.commerce.storefront.gating.StorefrontGatekeepers;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLModels.PageIdentityCommerceCardQueryModel;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLModels.PageIdentityCommerceCardQueryModel.CommerceStoreModel.OrderedCollectionsModel;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLModels.PageIdentityCommerceCardQueryModel.CommerceStoreModel.OrderedCollectionsModel.NodesModel.CollectionProductItemsModel.CollectionProductItemsNodesModel;
import com.facebook.pages.data.graphql.cards.PageIdentityCommerceCardGraphQLModels.PageIdentityCommerceCardQueryModel.CommerceStoreModel.OrderedCollectionsModel.NodesModel.CollectionProductItemsModel.CollectionProductItemsNodesModel.OrderedImagesModel;
import com.facebook.pages.identity.cards.commerce.PageIdentityCommerceCardViewHelper.ClickedItemId;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.LazyView;
import com.facebook.widget.text.BetterButton;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: privacy_checkup_mobile_write_retry_fail */
public class PageIdentityCommerceCardView extends CustomLinearLayout implements PageSecondaryCardView {
    private static final CallerContext f3371f = CallerContext.a(PageIdentityCommerceCardView.class, "timeline");
    @Inject
    SecureContextHelper f3372a;
    @Inject
    AnalyticsLogger f3373b;
    @Inject
    Clock f3374c;
    @Inject
    CommerceNavigationUtil f3375d;
    @Inject
    StorefrontGatekeepers f3376e;
    private HoneyClientEvent f3377g;
    public TextView f3378h = ((TextView) a(2131565438));
    public BetterButton f3379i = ((BetterButton) a(2131565439));
    public LinearLayout f3380j = ((LinearLayout) a(2131565435));
    public LazyView f3381k = new LazyView((ViewStub) a(2131565440));
    public int f3382l = getResources().getDimensionPixelSize(2131427419);

    public static void m4480a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityCommerceCardView) obj).m4477a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector), CommerceNavigationUtil.a(fbInjector), StorefrontGatekeepers.b(fbInjector));
    }

    public PageIdentityCommerceCardView(Context context) {
        super(context);
        Class cls = PageIdentityCommerceCardView.class;
        m4480a((Object) this, getContext());
        setContentView(2130906008);
        setOrientation(1);
        this.f3380j.setPadding(this.f3380j.getPaddingLeft(), this.f3380j.getPaddingTop(), this.f3380j.getPaddingRight(), getResources().getDimensionPixelSize(2131427418));
    }

    public final void m4481a(final long j, PageIdentityCommerceCardQueryModel pageIdentityCommerceCardQueryModel) {
        Object obj = !PageIdentityCommerceCardViewHelper.m4486c(pageIdentityCommerceCardQueryModel.a().b()) ? 1 : null;
        boolean c = PageIdentityCommerceCardViewHelper.m4487c(pageIdentityCommerceCardQueryModel);
        this.f3378h.setText(getResources().getString(2131235510));
        OnClickListener c04531 = new OnClickListener(this) {
            final /* synthetic */ PageIdentityCommerceCardView f3360b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -263336839);
                this.f3360b.f3375d.a(j);
                Logger.a(2, EntryType.UI_INPUT_END, -616311465, a);
            }
        };
        this.f3379i.setVisibility(c ? 0 : 8);
        this.f3379i.setOnClickListener(c04531);
        if (obj == null) {
            Preconditions.checkState(c);
            this.f3381k.a().setVisibility(0);
            this.f3381k.a().setOnClickListener(c04531);
            this.f3381k.a().findViewById(2131565434).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ PageIdentityCommerceCardView f3362b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1735098991);
                    CommerceNavigationUtil commerceNavigationUtil = this.f3362b.f3375d;
                    Intent b = commerceNavigationUtil.b(j);
                    if (b != null) {
                        b.putExtra("extra_wait_for_mutation_finish", true);
                        commerceNavigationUtil.b.a(b, commerceNavigationUtil.a);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, 292458094, a);
                }
            });
            this.f3378h.setOnClickListener(c04531);
            this.f3380j.setVisibility(8);
            return;
        }
        this.f3381k.c();
        this.f3380j.setVisibility(0);
        OrderedCollectionsModel b = pageIdentityCommerceCardQueryModel.a().b();
        if (b != null) {
            final String b2 = PageIdentityCommerceCardViewHelper.m4484b(b);
            if (b2 != null) {
                ImmutableList a = PageIdentityCommerceCardViewHelper.m4482a(b);
                int size = a.size();
                if (size != 0) {
                    final PageIdentityCommerceCardQueryModel pageIdentityCommerceCardQueryModel2 = pageIdentityCommerceCardQueryModel;
                    final long j2 = j;
                    this.f3378h.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ PageIdentityCommerceCardView f3366d;

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, -268109240);
                            this.f3366d.m4478a(pageIdentityCommerceCardQueryModel2, j2, b2, new ClickedItemId(-1, null));
                            Logger.a(2, EntryType.UI_INPUT_END, 962384924, a);
                        }
                    });
                    boolean z = size == 1 || size == 2 || size == 5;
                    Preconditions.checkState(z);
                    LinearLayout linearLayout = (LinearLayout) this.f3380j.findViewById(2131565436);
                    LinearLayout linearLayout2 = (LinearLayout) this.f3380j.findViewById(2131565437);
                    linearLayout.removeAllViews();
                    linearLayout2.removeAllViews();
                    if (a.size() < 5) {
                        linearLayout2.setVisibility(8);
                    } else {
                        linearLayout2.setVisibility(0);
                    }
                    for (int i = 0; i < a.size(); i++) {
                        ProductItemAtGlanceView a2 = m4476a((CollectionProductItemsNodesModel) a.get(i));
                        a2.setTag(new ClickedItemId(i, ((CollectionProductItemsNodesModel) a.get(i)).b()));
                        pageIdentityCommerceCardQueryModel2 = pageIdentityCommerceCardQueryModel;
                        j2 = j;
                        a2.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ PageIdentityCommerceCardView f3370d;

                            public void onClick(View view) {
                                ClickedItemId clickedItemId;
                                int a = Logger.a(2, EntryType.UI_INPUT_START, -1321247181);
                                PageIdentityCommerceCardView pageIdentityCommerceCardView = this.f3370d;
                                PageIdentityCommerceCardQueryModel pageIdentityCommerceCardQueryModel = pageIdentityCommerceCardQueryModel2;
                                long j = j2;
                                String str = b2;
                                if (view.getTag() == null || !(view.getTag() instanceof ClickedItemId)) {
                                    clickedItemId = new ClickedItemId(-1, null);
                                } else {
                                    clickedItemId = (ClickedItemId) view.getTag();
                                }
                                pageIdentityCommerceCardView.m4478a(pageIdentityCommerceCardQueryModel, j, str, clickedItemId);
                                Logger.a(2, EntryType.UI_INPUT_END, 154636868, a);
                            }
                        });
                        if (i < 2) {
                            linearLayout.addView(a2);
                        } else {
                            linearLayout2.addView(a2);
                        }
                    }
                    long a3 = this.f3374c.a() / 1000;
                    this.f3377g = new HoneyClientEvent("commerce_view_page_store_entry_point");
                    this.f3377g.b("collection_id", b2);
                    this.f3377g.a("logger_creation_time", a3);
                    this.f3377g.a("logging_start_time", a3);
                    this.f3377g.b("page_id", String.valueOf(j));
                    this.f3377g.b("ref_id", String.valueOf(j));
                    this.f3377g.a("ref_type", 6);
                }
            }
        }
    }

    private void m4477a(SecureContextHelper secureContextHelper, AnalyticsLogger analyticsLogger, Clock clock, CommerceNavigationUtil commerceNavigationUtil, StorefrontGatekeepers storefrontGatekeepers) {
        this.f3372a = secureContextHelper;
        this.f3373b = analyticsLogger;
        this.f3374c = clock;
        this.f3375d = commerceNavigationUtil;
        this.f3376e = storefrontGatekeepers;
    }

    private ProductItemAtGlanceView m4476a(CollectionProductItemsNodesModel collectionProductItemsNodesModel) {
        LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        ProductItemAtGlanceView productItemAtGlanceView = new ProductItemAtGlanceView(this.f3380j.getContext());
        productItemAtGlanceView.setLayoutParams(layoutParams);
        productItemAtGlanceView.setPadding(this.f3382l, this.f3382l, this.f3382l, this.f3382l);
        boolean z = true;
        Preconditions.checkState(!collectionProductItemsNodesModel.d().isEmpty());
        if (((OrderedImagesModel) collectionProductItemsNodesModel.d().get(0)).a() == null) {
            z = false;
        }
        Preconditions.checkState(z);
        productItemAtGlanceView.a(new ProductItemAtGlanceViewModel(Uri.parse(((OrderedImagesModel) collectionProductItemsNodesModel.d().get(0)).a().a()), collectionProductItemsNodesModel.c(), CommerceCurrencyUtil.a(collectionProductItemsNodesModel.kx_())));
        return productItemAtGlanceView;
    }

    private void m4478a(PageIdentityCommerceCardQueryModel pageIdentityCommerceCardQueryModel, long j, String str, ClickedItemId clickedItemId) {
        HoneyClientEvent b = new HoneyClientEvent(CommerceSubEvent.DID_OPEN_STOREFRONT_FROM_PAGE_HEADER.value).b("page_id", Long.toString(j)).b("container", CommerceProductSectionType.PAGE_STOREFRONT_ENTRY_GRID.value);
        b.c = "collection_grid";
        this.f3373b.a(b);
        if (pageIdentityCommerceCardQueryModel.a() == null || pageIdentityCommerceCardQueryModel.a().b() == null) {
            BLog.b(getClass(), "Shop card click: NULL commerceStore OR orderedCollections");
        } else if (!this.f3376e.a()) {
            String c = pageIdentityCommerceCardQueryModel.a().c();
            if (c != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                Builder appendQueryParameter = Uri.parse(c).buildUpon().appendQueryParameter("rid", String.valueOf(j)).appendQueryParameter("rt", "6");
                if (clickedItemId.f3383a >= 0) {
                    appendQueryParameter.appendQueryParameter("hsi", String.valueOf(clickedItemId.f3383a));
                }
                intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(appendQueryParameter.build().toString()))));
                this.f3372a.a(intent, getContext());
            }
        } else if (PageIdentityCommerceCardViewHelper.m4485b(pageIdentityCommerceCardQueryModel)) {
            this.f3375d.a(str, Long.toString(j), clickedItemId.f3384b);
        } else {
            this.f3375d.a(Long.toString(j), clickedItemId.f3384b);
        }
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1854381161);
        if (this.f3377g != null) {
            this.f3377g.a("logging_stop_time", this.f3374c.a() / 1000);
            this.f3373b.a(this.f3377g);
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1351428255, a);
    }
}
