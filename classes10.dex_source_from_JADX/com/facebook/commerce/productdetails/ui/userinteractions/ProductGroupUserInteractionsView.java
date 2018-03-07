package com.facebook.commerce.productdetails.ui.userinteractions;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.facebook.api.graphql.likes.LikeMutations;
import com.facebook.commerce.core.ui.NoticeView;
import com.facebook.commerce.core.ui.NoticeView.NoticeLevel;
import com.facebook.commerce.productdetails.api.ProductDetailsFetcher;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.FetchProductGroupQueryModel;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.ProductGroupFeedbackModel;
import com.facebook.commerce.productdetails.ui.productandpurchasedetails.ProductGroupProductAndPurchaseDetailsView;
import com.facebook.commerce.productdetails.ui.userinteractions.ProductGroupUserInteractionsViewControllerImpl.C21312;
import com.facebook.commerce.productdetails.ui.userinteractions.ProductGroupUserInteractionsViewModel.CheckoutType;
import com.facebook.commerce.productdetails.ui.userinteractions.ProductVariantViewModel.VariantValueState;
import com.facebook.commerce.productdetails.util.ProductDetailsFeedbackUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.feed.widget.FeedbackCustomPressStateButton;
import com.facebook.graphql.calls.FeedbackLikeInputData;
import com.facebook.graphql.calls.FeedbackUnlikeInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.staticadapter.StaticAdapter.Bindable;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ListViewFriendlyViewPager;
import com.facebook.widget.springbutton.TouchSpring;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: dbl_settings_account_remove */
public class ProductGroupUserInteractionsView extends CustomFrameLayout implements Bindable<FetchProductGroupQueryModel> {
    public static int f15344a = 80;
    private static final String f15345h = ProductGroupUserInteractionsView.class.getSimpleName();
    private GlyphWithTextView f15346A;
    private LinearLayout f15347B;
    private ProductGroupProductAndPurchaseDetailsView f15348C;
    @Inject
    ProductGroupUserInteractionsImagesAdapterProvider f15349b;
    @Inject
    public ScreenUtil f15350c;
    @Inject
    public Provider<TouchSpring> f15351d;
    @Inject
    public GlyphColorizer f15352e;
    @Inject
    public ProductGroupUserInteractionsViewControllerImpl f15353f;
    @Inject
    ProductDetailsFeedbackUtil f15354g;
    private ProductGroupUserInteractionsImagesAdapter f15355i;
    public ViewGroup f15356j;
    public FeedbackCustomPressStateButton f15357k;
    public FeedbackCustomPressStateButton f15358l;
    public FeedbackCustomPressStateButton f15359m;
    public BetterTextView f15360n;
    public NoticeView f15361o;
    private TextView f15362p;
    public ListViewFriendlyViewPager f15363q;
    private LinearLayout[] f15364r;
    public TextView[] f15365s;
    public Spinner[] f15366t;
    public TextView f15367u;
    public TextView f15368v;
    public TextView f15369w;
    public LinearLayout f15370x;
    public Spinner f15371y;
    private GlyphWithTextView f15372z;

    /* compiled from: dbl_settings_account_remove */
    public class C21266 implements Callable {
        final /* synthetic */ ProductGroupFeedbackViewModel f15332a;
        final /* synthetic */ ProductGroupUserInteractionsView f15333b;

        public C21266(ProductGroupUserInteractionsView productGroupUserInteractionsView, ProductGroupFeedbackViewModel productGroupFeedbackViewModel) {
            this.f15333b = productGroupUserInteractionsView;
            this.f15332a = productGroupFeedbackViewModel;
        }

        public Object call() {
            this.f15333b.m15945a(Optional.of(this.f15332a));
            return null;
        }
    }

    /* compiled from: dbl_settings_account_remove */
    public class VariantOnItemSelectedListener implements OnTouchListener, OnItemSelectedListener {
        final /* synthetic */ ProductGroupUserInteractionsView f15340a;
        private final int f15341b;
        private boolean f15342c;
        private final ProductGroupUserInteractionsViewModel f15343d;

        public VariantOnItemSelectedListener(ProductGroupUserInteractionsView productGroupUserInteractionsView, int i, ProductGroupUserInteractionsViewModel productGroupUserInteractionsViewModel) {
            this.f15340a = productGroupUserInteractionsView;
            this.f15341b = i;
            this.f15343d = productGroupUserInteractionsViewModel;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f15342c) {
                ProductGroupUserInteractionsView.m15942b(this.f15340a, this.f15340a.f15353f.m15966a(this.f15343d, this.f15341b, i - 1));
                this.f15342c = false;
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f15342c = true;
            return false;
        }
    }

    public static void m15940a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ProductGroupUserInteractionsView) obj).m15938a((ProductGroupUserInteractionsImagesAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ProductGroupUserInteractionsImagesAdapterProvider.class), ScreenUtil.a(fbInjector), IdBasedProvider.a(fbInjector, 3736), GlyphColorizer.a(fbInjector), ProductGroupUserInteractionsViewControllerImpl.m15961b(fbInjector), ProductDetailsFeedbackUtil.m15972a(fbInjector));
    }

    public final void mo758a(Object obj) {
        m15939a(this.f15353f.m15965a((FetchProductGroupQueryModel) obj));
    }

    private void m15939a(final ProductGroupUserInteractionsViewModel productGroupUserInteractionsViewModel) {
        if (productGroupUserInteractionsViewModel.f15414a.isPresent()) {
            this.f15361o.setVisibility(0);
            this.f15361o.setLevel((NoticeLevel) productGroupUserInteractionsViewModel.f15414a.get());
            this.f15361o.setTitle(productGroupUserInteractionsViewModel.f15415b);
            this.f15361o.setMessage(productGroupUserInteractionsViewModel.f15416c);
            this.f15361o.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ProductGroupUserInteractionsView f15335b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 266185278);
                    ProductGroupUserInteractionsViewControllerImpl productGroupUserInteractionsViewControllerImpl = this.f15335b.f15353f;
                    Context context = this.f15335b.getContext();
                    Intent a2 = ((UriIntentMapper) productGroupUserInteractionsViewControllerImpl.f15386j.get()).a(context, "https://m.facebook.com/business/help/223106797811279");
                    if (a2 != null) {
                        ((SecureContextHelper) productGroupUserInteractionsViewControllerImpl.f15380d.get()).a(a2, context);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -973989799, a);
                }
            });
        } else {
            this.f15361o.setVisibility(8);
        }
        this.f15362p.setText(productGroupUserInteractionsViewModel.f15417d);
        this.f15355i.f15320b = productGroupUserInteractionsViewModel.f15419f;
        if (productGroupUserInteractionsViewModel.f15418e) {
            this.f15355i.f15321c = new OnClickListener(this) {
                final /* synthetic */ ProductGroupUserInteractionsView f15323b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1679427386);
                    this.f15323b.f15353f.m15969a(productGroupUserInteractionsViewModel, this.f15323b.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, 653579258, a);
                }
            };
            this.f15359m.setVisibility(0);
            this.f15359m.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ProductGroupUserInteractionsView f15325b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 121379847);
                    this.f15325b.f15353f.m15969a(productGroupUserInteractionsViewModel, this.f15325b.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, 1675239327, a);
                }
            });
        } else {
            this.f15355i.f15321c = null;
            this.f15359m.setVisibility(8);
        }
        m15941b();
        this.f15355i.kR_();
        m15942b(this, productGroupUserInteractionsViewModel);
        m15945a(productGroupUserInteractionsViewModel.f15432s);
        this.f15348C.m15924a(productGroupUserInteractionsViewModel.f15433t);
        if (productGroupUserInteractionsViewModel.f15424k) {
            int min = (getResources().getDisplayMetrics().widthPixels - ((Math.min(this.f15350c.c(), this.f15350c.d()) * f15344a) / 100)) / 2;
            this.f15363q.setPadding(min, this.f15363q.getPaddingTop(), min, this.f15363q.getPaddingBottom());
        }
    }

    public ProductGroupUserInteractionsView(Context context) {
        super(context);
        m15937a(context);
    }

    private void m15937a(Context context) {
        Class cls = ProductGroupUserInteractionsView.class;
        m15940a((Object) this, getContext());
        setContentView(2130906414);
        this.f15361o = (NoticeView) c(2131566297);
        this.f15362p = (TextView) c(2131566298);
        this.f15355i = new ProductGroupUserInteractionsImagesAdapter(context);
        this.f15363q = (ListViewFriendlyViewPager) c(2131566299);
        this.f15363q.setAdapter(this.f15355i);
        this.f15364r = new LinearLayout[3];
        this.f15365s = new TextView[3];
        this.f15366t = new Spinner[3];
        this.f15364r[0] = (LinearLayout) c(2131566304);
        this.f15365s[0] = (TextView) c(2131566305);
        this.f15366t[0] = (Spinner) c(2131566306);
        this.f15364r[1] = (LinearLayout) c(2131566307);
        this.f15365s[1] = (TextView) c(2131566308);
        this.f15366t[1] = (Spinner) c(2131566309);
        this.f15364r[2] = (LinearLayout) c(2131566310);
        this.f15365s[2] = (TextView) c(2131566311);
        this.f15366t[2] = (Spinner) c(2131566312);
        this.f15367u = (TextView) c(2131566300);
        this.f15368v = (TextView) c(2131566301);
        this.f15369w = (TextView) c(2131566302);
        this.f15370x = (LinearLayout) c(2131566313);
        this.f15371y = (Spinner) c(2131566315);
        this.f15372z = (GlyphWithTextView) c(2131566316);
        this.f15346A = (GlyphWithTextView) c(2131566317);
        m15941b();
        this.f15363q.setCurrentItem(0);
        this.f15363q.scrollTo(0, 0);
        this.f15368v.setPaintFlags(this.f15368v.getPaintFlags() | 16);
        this.f15347B = (LinearLayout) c(2131566303);
        this.f15348C = new ProductGroupProductAndPurchaseDetailsView(context, null, 0);
        this.f15347B.addView(this.f15348C);
        this.f15356j = (ViewGroup) c(2131566318);
        this.f15357k = (FeedbackCustomPressStateButton) c(2131566319);
        this.f15357k.setSpring((TouchSpring) this.f15351d.get());
        this.f15358l = (FeedbackCustomPressStateButton) c(2131566320);
        this.f15358l.setSpring((TouchSpring) this.f15351d.get());
        this.f15358l.setImageDrawable(this.f15352e.a(2130839805, -7235677));
        this.f15359m = (FeedbackCustomPressStateButton) c(2131566321);
        this.f15359m.setSpring((TouchSpring) this.f15351d.get());
        this.f15359m.setImageDrawable(this.f15352e.a(2130840097, -7235677));
        this.f15360n = (BetterTextView) c(2131566322);
    }

    private void m15941b() {
        int i = getResources().getDisplayMetrics().widthPixels;
        int min = (Math.min(this.f15350c.c(), this.f15350c.d()) * f15344a) / 100;
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131434190);
        this.f15363q.setPadding(this.f15363q.getPaddingLeft() - (dimensionPixelSize / 2), this.f15363q.getPaddingTop(), ((((i - min) - this.f15363q.getPaddingLeft()) - dimensionPixelSize) + dimensionPixelSize) + (dimensionPixelSize / 2), this.f15363q.getPaddingBottom());
        this.f15363q.setPageMargin(dimensionPixelSize);
        this.f15363q.setOffscreenPageLimit((i / min) + 2);
    }

    public static void m15942b(ProductGroupUserInteractionsView productGroupUserInteractionsView, ProductGroupUserInteractionsViewModel productGroupUserInteractionsViewModel) {
        productGroupUserInteractionsView.m15944e(productGroupUserInteractionsViewModel);
        if (!productGroupUserInteractionsViewModel.f15426m.isPresent() || ((Integer) productGroupUserInteractionsViewModel.f15426m.get()).intValue() <= 0) {
            productGroupUserInteractionsView.f15370x.setVisibility(8);
        } else {
            productGroupUserInteractionsView.f15370x.setVisibility(0);
            Spinner spinner = productGroupUserInteractionsView.f15371y;
            int intValue = ((Integer) productGroupUserInteractionsViewModel.f15426m.get()).intValue();
            String[] strArr = new String[intValue];
            for (int i = 1; i <= intValue; i++) {
                strArr[i - 1] = Integer.toString(i);
            }
            spinner.setAdapter(new ArrayAdapter(productGroupUserInteractionsView.getContext(), 17367049, strArr));
        }
        productGroupUserInteractionsView.f15371y.setEnabled(productGroupUserInteractionsViewModel.f15427n);
        productGroupUserInteractionsView.f15367u.setText(productGroupUserInteractionsViewModel.f15420g);
        if (productGroupUserInteractionsViewModel.f15421h.isPresent()) {
            productGroupUserInteractionsView.f15368v.setText(productGroupUserInteractionsView.getResources().getString(2131241862, new Object[]{productGroupUserInteractionsViewModel.f15421h.get()}));
        } else {
            productGroupUserInteractionsView.f15368v.setText("");
        }
        if (productGroupUserInteractionsViewModel.f15423j) {
            productGroupUserInteractionsView.f15369w.setText(productGroupUserInteractionsView.getResources().getString(2131241872));
        } else if (productGroupUserInteractionsViewModel.f15422i.isPresent()) {
            productGroupUserInteractionsView.f15369w.setText(productGroupUserInteractionsView.getResources().getString(2131241863, new Object[]{productGroupUserInteractionsViewModel.f15422i.get()}));
        } else {
            productGroupUserInteractionsView.f15369w.setText("");
        }
        productGroupUserInteractionsView.m15943d(productGroupUserInteractionsViewModel);
    }

    public final void m15945a(Optional<ProductGroupFeedbackViewModel> optional) {
        if (optional.isPresent()) {
            final ProductGroupFeedbackViewModel productGroupFeedbackViewModel = (ProductGroupFeedbackViewModel) optional.get();
            if (productGroupFeedbackViewModel.f15309a) {
                int i;
                CharSequence string;
                this.f15357k.setVisibility(0);
                this.f15357k.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ ProductGroupUserInteractionsView f15327b;

                    public void onClick(View view) {
                        Absent absent;
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -59683798);
                        ProductGroupUserInteractionsView productGroupUserInteractionsView = this.f15327b;
                        ProductGroupFeedbackViewModel productGroupFeedbackViewModel = productGroupFeedbackViewModel;
                        ProductGroupUserInteractionsViewControllerImpl productGroupUserInteractionsViewControllerImpl = productGroupUserInteractionsView.f15353f;
                        Callable c21266 = new C21266(productGroupUserInteractionsView, productGroupFeedbackViewModel);
                        ProductGroupFeedbackModel productGroupFeedbackModel = productGroupFeedbackViewModel.f15314f;
                        if (productGroupFeedbackModel == null) {
                            absent = Absent.INSTANCE;
                        } else {
                            GraphQlQueryString a2;
                            GraphQlCallInput a3;
                            String nl_ = productGroupFeedbackModel.nl_();
                            boolean z = !productGroupFeedbackModel.nk_();
                            Optional a4 = ProductGroupUserInteractionsViewControllerImpl.m15949a(ProductDetailsFeedbackUtil.m15971a(productGroupFeedbackModel, z));
                            ProductDetailsFetcher productDetailsFetcher = productGroupUserInteractionsViewControllerImpl.f15378b;
                            Preconditions.checkState(!StringUtil.a(nl_));
                            String str = productDetailsFetcher.f15135b.b() != null ? productDetailsFetcher.f15135b.b().mUserId : productDetailsFetcher.f15135b.a().mUserId;
                            if (z) {
                                a2 = LikeMutations.a();
                                a3 = new FeedbackLikeInputData().b(nl_).a(str);
                            } else {
                                a2 = LikeMutations.b();
                                a3 = new FeedbackUnlikeInputData().b(nl_).a(str);
                            }
                            a2.a("input", a3);
                            Futures.a(productDetailsFetcher.f15136c.b(new MutationRequest(a2)), new C21312(productGroupUserInteractionsViewControllerImpl, c21266), productGroupUserInteractionsViewControllerImpl.f15379c);
                            absent = a4;
                        }
                        productGroupUserInteractionsView.m15945a((Optional) absent);
                        Logger.a(2, EntryType.UI_INPUT_END, 818657686, a);
                    }
                });
                FeedbackCustomPressStateButton feedbackCustomPressStateButton = this.f15357k;
                GlyphColorizer glyphColorizer = this.f15352e;
                if (productGroupFeedbackViewModel.f15311c) {
                    i = -10972929;
                } else {
                    i = -7235677;
                }
                feedbackCustomPressStateButton.setImageDrawable(glyphColorizer.a(2130839953, i));
                feedbackCustomPressStateButton = this.f15357k;
                if (productGroupFeedbackViewModel.f15311c) {
                    i = getResources().getColor(2131361917);
                } else {
                    i = getResources().getColor(2131361920);
                }
                feedbackCustomPressStateButton.setTextColor(i);
                feedbackCustomPressStateButton = this.f15357k;
                if (productGroupFeedbackViewModel.f15311c) {
                    string = getResources().getString(2131241880);
                } else {
                    string = getResources().getString(2131241879);
                }
                feedbackCustomPressStateButton.setContentDescription(string);
            } else {
                this.f15357k.setVisibility(8);
            }
            if (productGroupFeedbackViewModel.f15310b) {
                this.f15358l.setVisibility(0);
                this.f15358l.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ ProductGroupUserInteractionsView f15329b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1214248869);
                        this.f15329b.f15353f.m15967a(productGroupFeedbackViewModel, this.f15329b.getContext());
                        Logger.a(2, EntryType.UI_INPUT_END, 1676288581, a);
                    }
                });
            } else {
                this.f15358l.setVisibility(8);
            }
            CharSequence a = this.f15354g.m15974a(productGroupFeedbackViewModel.f15312d, productGroupFeedbackViewModel.f15313e);
            if (StringUtil.a(a)) {
                this.f15360n.setVisibility(8);
                return;
            }
            this.f15360n.setVisibility(0);
            this.f15360n.setText(a);
            this.f15360n.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ProductGroupUserInteractionsView f15331b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 210489196);
                    this.f15331b.f15353f.m15967a(productGroupFeedbackViewModel, this.f15331b.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, 1408914031, a);
                }
            });
            return;
        }
        this.f15356j.setVisibility(8);
    }

    private void m15943d(final ProductGroupUserInteractionsViewModel productGroupUserInteractionsViewModel) {
        CheckoutType checkoutType = productGroupUserInteractionsViewModel.f15429p;
        if (checkoutType == null) {
            this.f15372z.setVisibility(8);
            this.f15346A.setVisibility(8);
            return;
        }
        this.f15372z.setVisibility(0);
        this.f15372z.setEnabled(productGroupUserInteractionsViewModel.f15431r);
        this.f15372z.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProductGroupUserInteractionsView f15337b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -443819871);
                this.f15337b.f15353f.m15968a(productGroupUserInteractionsViewModel, this.f15337b.f15371y.getSelectedItemPosition() + 1, this.f15337b.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 1615265815, a);
            }
        });
        switch (checkoutType) {
            case OFFSITE:
                this.f15372z.setImageDrawable(this.f15352e.a(2130839952, -1));
                this.f15372z.setOrientation(2);
                this.f15372z.setText(2131241866);
                this.f15372z.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131427421));
                if (StringUtil.a(productGroupUserInteractionsViewModel.f15430q)) {
                    this.f15346A.setVisibility(8);
                    return;
                }
                this.f15346A.setVisibility(0);
                this.f15346A.setImageResource(0);
                this.f15346A.setText(getResources().getString(2131241870, new Object[]{productGroupUserInteractionsViewModel.f15430q}));
                return;
            case CONTACT_MERCHANT:
                this.f15372z.setImageDrawable(this.f15352e.a(2130839685, -1));
                this.f15372z.setOrientation(0);
                this.f15372z.setImageScale(0.75f);
                this.f15372z.setText(2131241865);
                this.f15346A.setVisibility(0);
                this.f15346A.setText(2131241871);
                this.f15346A.setImageResource(0);
                this.f15372z.setCompoundDrawablePadding(0);
                return;
            case ONSITE:
                this.f15372z.setImageResource(0);
                this.f15372z.setText(2131241864);
                this.f15346A.setVisibility(0);
                this.f15346A.setText(2131241869);
                this.f15346A.setImageDrawable(this.f15352e.a(2130839971, -7235677));
                return;
            default:
                return;
        }
    }

    private void m15944e(ProductGroupUserInteractionsViewModel productGroupUserInteractionsViewModel) {
        int size = productGroupUserInteractionsViewModel.f15425l.size();
        for (int i = 0; i < size; i++) {
            if (i < size) {
                this.f15364r[i].setVisibility(0);
                this.f15365s[i].setText(((ProductVariantViewModel) productGroupUserInteractionsViewModel.f15425l.get(i)).f15434a);
                Object variantOnItemSelectedListener = new VariantOnItemSelectedListener(this, i, productGroupUserInteractionsViewModel);
                this.f15366t[i].setOnItemSelectedListener(variantOnItemSelectedListener);
                this.f15366t[i].setOnTouchListener(variantOnItemSelectedListener);
                m15936a(i, (ProductVariantViewModel) productGroupUserInteractionsViewModel.f15425l.get(i));
            } else {
                this.f15364r[i].setVisibility(8);
            }
        }
    }

    private void m15936a(int i, ProductVariantViewModel productVariantViewModel) {
        String[] strArr = new String[(productVariantViewModel.f15435b.size() + 1)];
        strArr[0] = getResources().getString(2131241858, new Object[]{productVariantViewModel.f15434a});
        for (int i2 = 0; i2 < productVariantViewModel.f15435b.size(); i2++) {
            String str = (String) productVariantViewModel.f15435b.get(i2);
            switch ((VariantValueState) productVariantViewModel.f15436c.get(i2)) {
                case SOLD_OUT:
                    str = getResources().getString(2131241859, new Object[]{str});
                    break;
                case NOT_AVAILABLE:
                    str = getResources().getString(2131241860, new Object[]{str});
                    break;
                default:
                    break;
            }
            strArr[i2 + 1] = str;
        }
        this.f15366t[i].setAdapter(new ArrayAdapter(getContext(), 17367049, strArr));
        if (productVariantViewModel.f15437d.isPresent()) {
            this.f15366t[i].setSelection(((Integer) productVariantViewModel.f15437d.get()).intValue() + 1);
        }
    }

    private void m15938a(ProductGroupUserInteractionsImagesAdapterProvider productGroupUserInteractionsImagesAdapterProvider, ScreenUtil screenUtil, Provider<TouchSpring> provider, GlyphColorizer glyphColorizer, ProductGroupUserInteractionsViewController productGroupUserInteractionsViewController, ProductDetailsFeedbackUtil productDetailsFeedbackUtil) {
        this.f15349b = productGroupUserInteractionsImagesAdapterProvider;
        this.f15350c = screenUtil;
        this.f15351d = provider;
        this.f15352e = glyphColorizer;
        this.f15353f = productGroupUserInteractionsViewController;
        this.f15354g = productDetailsFeedbackUtil;
    }
}
