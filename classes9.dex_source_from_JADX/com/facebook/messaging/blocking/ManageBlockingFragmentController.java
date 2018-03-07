package com.facebook.messaging.blocking;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.internal.widget.ViewStubCompat;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.MessengerContentPageUnsubscribeInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.blocking.BlockingUtils.C09301;
import com.facebook.messaging.blocking.BlockingUtils.C09312;
import com.facebook.messaging.business.common.analytics.BusinessAnalyticsLogger;
import com.facebook.messaging.business.common.helper.BusinessMessageDialogHelper;
import com.facebook.messaging.business.promotion.gating.BusinessPromotionGatekeepers;
import com.facebook.messaging.business.subscription.common.graphql.BusinessSubscriptionMutations.ContentPageUnsubscribeMutationString;
import com.facebook.messaging.business.subscription.common.utils.BusinessSubscriptionMutationHelper;
import com.facebook.messaging.business.subscription.common.utils.BusinessSubscriptionMutationHelper.2;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import com.facebook.qe.api.QeAccessor;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.user.model.User;
import com.facebook.user.model.User.CommercePageType;
import com.facebook.widget.BetterSwitch;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.CustomUrlLikeSpan;
import com.facebook.widget.text.CustomUrlLikeSpan.OnUrlClickHandler;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: onResultPhotoObjectParam */
public class ManageBlockingFragmentController {
    public static final Uri f8286a = Uri.parse("https://m.facebook.com/privacy/touch/block/");
    public User f8287b;
    public ErrorDialogs f8288c;
    private FragmentManager f8289d;
    private ViewStubHolder<LinearLayout> f8290e;
    private ViewStubHolder<LinearLayout> f8291f;
    public SecureContextHelper f8292g;
    private BlockingUtils f8293h;
    public BlockingAnalyticsLogger f8294i;
    private BusinessAnalyticsLogger f8295j;
    public BusinessMessageDialogHelper f8296k;
    public Provider<TriState> f8297l;
    private final QeAccessor f8298m;
    public Lazy<LinkHandlingHelper> f8299n;
    private BusinessPromotionGatekeepers f8300o;
    private final GatekeeperStoreImpl f8301p;

    /* compiled from: onResultPhotoObjectParam */
    public class C09386 implements OnClickListener {
        final /* synthetic */ ManageBlockingFragmentController f8282a;

        public C09386(ManageBlockingFragmentController manageBlockingFragmentController) {
            this.f8282a = manageBlockingFragmentController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 93179634);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(StringFormatUtil.formatStrLocaleSafe("https://m.facebook.com/privacy/touch/block/confirm?bid=%s", this.f8282a.f8287b.a)));
            this.f8282a.f8292g.b(intent, view.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 2022045588, a);
        }
    }

    /* compiled from: onResultPhotoObjectParam */
    enum BlockRowType {
        MESSAGES,
        PROMOTION_MESSAGES,
        SUBSCRIPTION_MESSAGES
    }

    @Inject
    public ManageBlockingFragmentController(ErrorDialogs errorDialogs, SecureContextHelper secureContextHelper, BlockingUtils blockingUtils, BlockingAnalyticsLogger blockingAnalyticsLogger, Provider<TriState> provider, BusinessAnalyticsLogger businessAnalyticsLogger, BusinessMessageDialogHelper businessMessageDialogHelper, QeAccessor qeAccessor, Lazy<LinkHandlingHelper> lazy, BusinessPromotionGatekeepers businessPromotionGatekeepers, GatekeeperStore gatekeeperStore) {
        this.f8288c = errorDialogs;
        this.f8292g = secureContextHelper;
        this.f8293h = blockingUtils;
        this.f8294i = blockingAnalyticsLogger;
        this.f8297l = provider;
        this.f8295j = businessAnalyticsLogger;
        this.f8296k = businessMessageDialogHelper;
        this.f8298m = qeAccessor;
        this.f8299n = lazy;
        this.f8300o = businessPromotionGatekeepers;
        this.f8301p = gatekeeperStore;
    }

    public final void m8553a(User user, @Nullable ManageBlockingParam manageBlockingParam, View view, FragmentManager fragmentManager) {
        this.f8287b = user;
        this.f8289d = fragmentManager;
        m8536a(view, manageBlockingParam);
        View view2 = (LinearLayout) view.findViewById(2131559919);
        BetterSwitch a = m8534a(view2, BlockRowType.MESSAGES);
        this.f8290e = ViewStubHolder.a((ViewStubCompat) view.findViewById(2131563662));
        this.f8291f = ViewStubHolder.a((ViewStubCompat) view.findViewById(2131563663));
        m8537a(view2, a, BlockRowType.MESSAGES);
        m8540a(this.f8290e, BlockRowType.PROMOTION_MESSAGES);
        m8540a(this.f8291f, BlockRowType.SUBSCRIPTION_MESSAGES);
        m8538a(this, a);
        m8539a(user, view);
    }

    private void m8536a(View view, ManageBlockingParam manageBlockingParam) {
        int i = 0;
        int i2 = (!(manageBlockingParam instanceof AdManageBlockingParam) || Strings.isNullOrEmpty(((AdManageBlockingParam) manageBlockingParam).f8244a)) ? 0 : 1;
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(2131563660);
        if (i2 == 0) {
            linearLayout.setVisibility(8);
            return;
        }
        final AdManageBlockingParam adManageBlockingParam = (AdManageBlockingParam) manageBlockingParam;
        linearLayout.setVisibility(0);
        linearLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ManageBlockingFragmentController f8267c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -601995569);
                ((LinkHandlingHelper) this.f8267c.f8299n.get()).a(linearLayout.getContext(), Uri.parse(adManageBlockingParam.f8244a));
                Logger.a(2, EntryType.UI_INPUT_END, 790731012, a);
            }
        });
        View findViewById = view.findViewById(2131563661);
        if (!adManageBlockingParam.f8245b) {
            i = 4;
        }
        findViewById.setVisibility(i);
    }

    private void m8540a(ViewStubHolder viewStubHolder, BlockRowType blockRowType) {
        Preconditions.checkNotNull(viewStubHolder);
        if (m8541a(blockRowType)) {
            viewStubHolder.f();
            m8537a(viewStubHolder.a(), m8534a(viewStubHolder.a(), blockRowType), blockRowType);
            return;
        }
        viewStubHolder.e();
    }

    private void m8537a(View view, BetterSwitch betterSwitch, BlockRowType blockRowType) {
        Preconditions.checkNotNull(view);
        if (m8541a(blockRowType)) {
            boolean z;
            view.setVisibility(0);
            BetterTextView betterTextView = (BetterTextView) view.findViewById(2131559940);
            BetterTextView betterTextView2 = (BetterTextView) view.findViewById(2131559941);
            ProgressBar progressBar = (ProgressBar) view.findViewById(2131559939);
            Preconditions.checkNotNull(betterTextView);
            Preconditions.checkNotNull(betterTextView2);
            betterTextView.setText(m8535a(view.getContext(), blockRowType));
            betterTextView2.setText(m8542b(view.getContext(), blockRowType));
            betterTextView2.setMovementMethod(LinkMovementMethod.getInstance());
            betterTextView2.setLinkTextColor(view.getResources().getColor(2131362241));
            switch (blockRowType) {
                case MESSAGES:
                    z = this.f8287b.I;
                    break;
                case PROMOTION_MESSAGES:
                    z = this.f8287b.J;
                    break;
                case SUBSCRIPTION_MESSAGES:
                    z = this.f8287b.R;
                    break;
                default:
                    z = false;
                    break;
            }
            betterSwitch.setChecked(z);
            betterSwitch.setOnCheckedChangeListener(m8533a(blockRowType, betterSwitch, progressBar));
            return;
        }
        view.setVisibility(8);
    }

    private boolean m8541a(BlockRowType blockRowType) {
        switch (blockRowType) {
            case MESSAGES:
                if (this.f8287b.H) {
                    return false;
                }
                return true;
            case PROMOTION_MESSAGES:
                return m8544b(this.f8287b);
            case SUBSCRIPTION_MESSAGES:
                return m8547c(this.f8287b);
            default:
                return false;
        }
    }

    private static BetterSwitch m8534a(View view, BlockRowType blockRowType) {
        switch (blockRowType) {
            case MESSAGES:
                return (BetterSwitch) view.findViewById(2131559920);
            case PROMOTION_MESSAGES:
                return (BetterSwitch) view.findViewById(2131559938);
            case SUBSCRIPTION_MESSAGES:
                return (BetterSwitch) view.findViewById(2131559943);
            default:
                throw new IllegalArgumentException("Block row type not supported");
        }
    }

    private static String m8535a(Context context, BlockRowType blockRowType) {
        switch (blockRowType) {
            case MESSAGES:
                return context.getResources().getString(2131240222);
            case PROMOTION_MESSAGES:
                return context.getResources().getString(2131240219);
            case SUBSCRIPTION_MESSAGES:
                return context.getResources().getString(2131240220);
            default:
                throw new IllegalArgumentException("Block row type not supported");
        }
    }

    private SpannableString m8542b(final Context context, BlockRowType blockRowType) {
        switch (blockRowType) {
            case MESSAGES:
                User user = this.f8287b;
                Resources resources = context.getResources();
                StyledStringBuilder styledStringBuilder = new StyledStringBuilder(resources);
                styledStringBuilder.a(resources.getString(2131240224, new Object[]{BlockingUtils.m8508a(user)}));
                String string = resources.getString(2131240226);
                CustomUrlLikeSpan customUrlLikeSpan = new CustomUrlLikeSpan();
                customUrlLikeSpan.a = new OnUrlClickHandler(this) {
                    final /* synthetic */ ManageBlockingFragmentController f8269b;

                    public final void m8528a() {
                        ManageBlockingFragmentController manageBlockingFragmentController = this.f8269b;
                        Context context = context;
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(BlockingUtils.f8256a);
                        manageBlockingFragmentController.f8292g.b(intent, context);
                    }
                };
                styledStringBuilder.a("[[link_learn_more]]", string, customUrlLikeSpan, 33);
                return styledStringBuilder.b();
            case PROMOTION_MESSAGES:
                return SpannableString.valueOf(context.getResources().getString(2131240223, new Object[]{BlockingUtils.m8508a(this.f8287b)}));
            case SUBSCRIPTION_MESSAGES:
                return SpannableString.valueOf(context.getResources().getString(2131240225, new Object[]{BlockingUtils.m8508a(this.f8287b)}));
            default:
                throw new IllegalArgumentException("Block row type not supported");
        }
    }

    private void m8539a(User user, View view) {
        boolean z;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131559921);
        Preconditions.checkNotNull(linearLayout);
        if (user.E || user.T() || ((TriState) this.f8297l.get()).asBoolean(true)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            linearLayout.setVisibility(8);
        } else if (user.H) {
            ((BetterTextView) view.findViewById(2131559922)).setText(view.getResources().getString(2131240229, new Object[]{BlockingUtils.m8508a(user)}));
            ((BetterTextView) view.findViewById(2131559923)).setText(view.getResources().getString(2131240230, new Object[]{BlockingUtils.m8508a(user)}));
            final Context context = view.getContext();
            linearLayout.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ManageBlockingFragmentController f8284b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1400723599);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(ManageBlockingFragmentController.f8286a);
                    this.f8284b.f8292g.b(intent, context);
                    this.f8284b.f8294i.m8500b(this.f8284b.f8287b.a);
                    Logger.a(2, EntryType.UI_INPUT_END, -1793800852, a);
                }
            });
        } else {
            m8546c(user, view);
            linearLayout.setOnClickListener(new C09386(this));
        }
    }

    private boolean m8544b(User user) {
        return this.f8300o.m9359a() && user.T() && user.v != CommercePageType.COMMERCE_PAGE_TYPE_AGENT;
    }

    private boolean m8547c(User user) {
        if (this.f8301p.a(329, false) && user.T() && user.v != CommercePageType.COMMERCE_PAGE_TYPE_AGENT && user.R) {
            return true;
        }
        return false;
    }

    private static void m8546c(User user, View view) {
        ((BetterTextView) view.findViewById(2131559922)).setText(view.getResources().getString(2131240227, new Object[]{BlockingUtils.m8508a(user)}));
        ((BetterTextView) view.findViewById(2131559923)).setText(view.getResources().getString(2131240228, new Object[]{BlockingUtils.m8508a(user)}));
    }

    private OnCheckedChangeListener m8533a(final BlockRowType blockRowType, final BetterSwitch betterSwitch, final ProgressBar progressBar) {
        return new OnCheckedChangeListener(this) {
            final /* synthetic */ ManageBlockingFragmentController f8273d;

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    ManageBlockingFragmentController.m8543b(this.f8273d, blockRowType, betterSwitch, progressBar);
                } else {
                    ManageBlockingFragmentController.m8545c(this.f8273d, blockRowType, betterSwitch, progressBar);
                }
            }
        };
    }

    public static void m8543b(ManageBlockingFragmentController manageBlockingFragmentController, BlockRowType blockRowType, BetterSwitch betterSwitch, ProgressBar progressBar) {
        if (blockRowType == BlockRowType.MESSAGES) {
            manageBlockingFragmentController.f8293h.m8516a(manageBlockingFragmentController.f8287b.a, manageBlockingFragmentController.m8549e(blockRowType, betterSwitch, progressBar));
            manageBlockingFragmentController.f8294i.m8501c(manageBlockingFragmentController.f8287b.a);
            m8538a(manageBlockingFragmentController, betterSwitch);
        } else if (blockRowType == BlockRowType.PROMOTION_MESSAGES) {
            manageBlockingFragmentController.f8293h.m8517a(manageBlockingFragmentController.f8287b.a, manageBlockingFragmentController.m8548d(blockRowType, betterSwitch, progressBar));
            manageBlockingFragmentController.f8295j.f8693a.a(BusinessAnalyticsLogger.m8899c("promotion_message_block_on").b("page_id", manageBlockingFragmentController.f8287b.a));
        } else if (blockRowType == BlockRowType.SUBSCRIPTION_MESSAGES) {
            BlockingUtils blockingUtils = manageBlockingFragmentController.f8293h;
            blockingUtils.f8264i.a("messenger_user_control", manageBlockingFragmentController.f8287b.a, new C09301(blockingUtils, manageBlockingFragmentController.m8548d(blockRowType, betterSwitch, progressBar)));
        }
        manageBlockingFragmentController.m8551g(blockRowType, betterSwitch, progressBar);
    }

    public static void m8545c(ManageBlockingFragmentController manageBlockingFragmentController, BlockRowType blockRowType, BetterSwitch betterSwitch, ProgressBar progressBar) {
        if (blockRowType == BlockRowType.MESSAGES) {
            manageBlockingFragmentController.f8293h.m8519b(manageBlockingFragmentController.f8287b.a, manageBlockingFragmentController.m8549e(blockRowType, betterSwitch, progressBar));
            manageBlockingFragmentController.f8294i.m8502d(manageBlockingFragmentController.f8287b.a);
            m8538a(manageBlockingFragmentController, betterSwitch);
        } else if (blockRowType == BlockRowType.PROMOTION_MESSAGES) {
            manageBlockingFragmentController.f8293h.m8520b(manageBlockingFragmentController.f8287b.a, manageBlockingFragmentController.m8548d(blockRowType, betterSwitch, progressBar));
            manageBlockingFragmentController.f8295j.f8693a.a(BusinessAnalyticsLogger.m8899c("promotion_message_block_off").b("page_id", manageBlockingFragmentController.f8287b.a));
        } else if (blockRowType == BlockRowType.SUBSCRIPTION_MESSAGES) {
            BlockingUtils blockingUtils = manageBlockingFragmentController.f8293h;
            String str = manageBlockingFragmentController.f8287b.a;
            C09364 d = manageBlockingFragmentController.m8548d(blockRowType, betterSwitch, progressBar);
            BusinessSubscriptionMutationHelper businessSubscriptionMutationHelper = blockingUtils.f8264i;
            C09312 c09312 = new C09312(blockingUtils, d);
            if (Strings.isNullOrEmpty(str)) {
                businessSubscriptionMutationHelper.a.a("BusinessSubscriptionMutationHelper", "Unsubscribe page id is null");
                if (c09312 != null) {
                    c09312.m8505b();
                }
            }
            MessengerContentPageUnsubscribeInputData messengerContentPageUnsubscribeInputData = new MessengerContentPageUnsubscribeInputData();
            messengerContentPageUnsubscribeInputData.a("page_id", str);
            GraphQlQueryString contentPageUnsubscribeMutationString = new ContentPageUnsubscribeMutationString();
            contentPageUnsubscribeMutationString.a("input", messengerContentPageUnsubscribeInputData);
            businessSubscriptionMutationHelper.f = businessSubscriptionMutationHelper.b.a(GraphQLRequest.a(contentPageUnsubscribeMutationString));
            Futures.a(businessSubscriptionMutationHelper.f, new 2(businessSubscriptionMutationHelper, c09312), businessSubscriptionMutationHelper.c);
        }
        manageBlockingFragmentController.m8551g(blockRowType, betterSwitch, progressBar);
    }

    private C09364 m8548d(final BlockRowType blockRowType, final BetterSwitch betterSwitch, final ProgressBar progressBar) {
        return new Object(this) {
            final /* synthetic */ ManageBlockingFragmentController f8277d;

            public final void m8529a() {
                ManageBlockingFragmentController.m8552h(this.f8277d, blockRowType, betterSwitch, progressBar);
            }

            public final void m8530b() {
                this.f8277d.f8296k.m9019a();
                ManageBlockingFragmentController.m8550f(this.f8277d, blockRowType, betterSwitch, progressBar);
            }
        };
    }

    private OperationResultFutureCallback m8549e(final BlockRowType blockRowType, final BetterSwitch betterSwitch, final ProgressBar progressBar) {
        return new OperationResultFutureCallback(this) {
            final /* synthetic */ ManageBlockingFragmentController f8281d;

            protected final void m8531a(ServiceException serviceException) {
                this.f8281d.f8288c.a(this.f8281d.f8288c.a(serviceException));
                ManageBlockingFragmentController.m8550f(this.f8281d, blockRowType, betterSwitch, progressBar);
                if (blockRowType == BlockRowType.MESSAGES) {
                    ManageBlockingFragmentController.m8538a(this.f8281d, betterSwitch);
                }
            }

            protected final void m8532a(Object obj) {
                ManageBlockingFragmentController.m8552h(this.f8281d, blockRowType, betterSwitch, progressBar);
            }
        };
    }

    public static void m8550f(ManageBlockingFragmentController manageBlockingFragmentController, BlockRowType blockRowType, BetterSwitch betterSwitch, ProgressBar progressBar) {
        betterSwitch.setOnCheckedChangeListener(null);
        betterSwitch.toggle();
        betterSwitch.setOnCheckedChangeListener(manageBlockingFragmentController.m8533a(blockRowType, betterSwitch, progressBar));
        m8552h(manageBlockingFragmentController, blockRowType, betterSwitch, progressBar);
    }

    public static void m8538a(ManageBlockingFragmentController manageBlockingFragmentController, BetterSwitch betterSwitch) {
        if (betterSwitch.isChecked() || !manageBlockingFragmentController.m8544b(manageBlockingFragmentController.f8287b)) {
            manageBlockingFragmentController.f8290e.e();
        } else {
            manageBlockingFragmentController.f8290e.f();
        }
        if (betterSwitch.isChecked() || !manageBlockingFragmentController.m8547c(manageBlockingFragmentController.f8287b)) {
            manageBlockingFragmentController.f8291f.e();
        } else {
            manageBlockingFragmentController.f8291f.f();
        }
    }

    private void m8551g(BlockRowType blockRowType, BetterSwitch betterSwitch, ProgressBar progressBar) {
        if (m8541a(blockRowType) && betterSwitch != null && progressBar != null) {
            betterSwitch.setVisibility(4);
            progressBar.setVisibility(0);
        }
    }

    public static void m8552h(ManageBlockingFragmentController manageBlockingFragmentController, BlockRowType blockRowType, BetterSwitch betterSwitch, ProgressBar progressBar) {
        if (manageBlockingFragmentController.m8541a(blockRowType) && betterSwitch != null && progressBar != null) {
            betterSwitch.setVisibility(0);
            progressBar.setVisibility(4);
        }
    }
}
