package com.facebook.groupcommerce.widget.marketplace;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Checkable;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.ViewerGroupMarketplaceCrossPostNuxSeenInputData;
import com.facebook.graphql.calls.ViewerGroupMarketplaceCrossPostNuxSeenInputData.SeenMarketplaceCrossPostNux;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groupcommerce.protocol.FetchMarketplaceCrossPostShowSettingsGraphQL.FetchMarketplaceCrossPostShowSettingsString;
import com.facebook.groupcommerce.protocol.FetchMarketplaceCrossPostShowSettingsGraphQLModels.FetchMarketplaceCrossPostShowSettingsModel;
import com.facebook.groupcommerce.protocol.FetchMarketplaceCrossPostShowSettingsGraphQLModels.FetchMarketplaceCrossPostShowSettingsModel.GroupSellConfigModel;
import com.facebook.groupcommerce.protocol.FetchMarketplaceCrossPostShowSettingsGraphQLModels.FetchMarketplaceCrossPostShowSettingsModel.GroupSellConfigModel.EdgesModel;
import com.facebook.groupcommerce.protocol.GroupMarketplaceCrossPostNuxSeenMutation.GroupMarketplaceCrossPostNuxSeenMutationString;
import com.facebook.groupcommerce.ui.GroupsSalePostMarketplaceInfoDialogFragment;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.model.MarketplaceCrossPostSettingModel;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbCheckBox;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: admin_page_manage_ads */
public class CheckedPostToMarketplaceTextView extends CustomLinearLayout implements Checkable {
    @Inject
    public GraphQLQueryExecutor f10093a;
    @Inject
    @ForUiThread
    public ExecutorService f10094b;
    @Inject
    public AbstractFbErrorReporter f10095c;
    private FbCheckBox f10096d;
    private BetterTextView f10097e;
    public MarketplaceCrossPostSettingModel f10098f;

    private static <T extends View> void m10438a(Class<T> cls, T t) {
        m10439a((Object) t, t.getContext());
    }

    private static void m10439a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CheckedPostToMarketplaceTextView checkedPostToMarketplaceTextView = (CheckedPostToMarketplaceTextView) obj;
        GraphQLQueryExecutor a = GraphQLQueryExecutor.a(fbInjector);
        ExecutorService executorService = (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        checkedPostToMarketplaceTextView.f10093a = a;
        checkedPostToMarketplaceTextView.f10094b = executorService;
        checkedPostToMarketplaceTextView.f10095c = abstractFbErrorReporter;
    }

    public CheckedPostToMarketplaceTextView(Context context) {
        super(context);
        m10436a();
    }

    public CheckedPostToMarketplaceTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10436a();
    }

    protected CheckedPostToMarketplaceTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10436a();
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m10436a() {
        m10438a(CheckedPostToMarketplaceTextView.class, (View) this);
        setOrientation(0);
        setContentView(2130903563);
        this.f10097e = (BetterTextView) a(2131560311);
        this.f10096d = (FbCheckBox) a(2131558957);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CheckedPostToMarketplaceTextView f10090b;

            /* compiled from: admin_page_manage_ads */
            class C11721 implements OnClickListener {
                final /* synthetic */ C11741 f10087a;

                C11721(C11741 c11741) {
                    this.f10087a = c11741;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1780640689);
                    this.setChecked(true);
                    Logger.a(2, EntryType.UI_INPUT_END, 1065221363, a);
                }
            }

            /* compiled from: admin_page_manage_ads */
            class C11732 implements OnClickListener {
                final /* synthetic */ C11741 f10088a;

                C11732(C11741 c11741) {
                    this.f10088a = c11741;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1328274879);
                    this.setChecked(false);
                    Logger.a(2, EntryType.UI_INPUT_END, -222959924, a);
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 446854010);
                FragmentActivity fragmentActivity = (FragmentActivity) this.f10090b.getContext();
                GroupsSalePostMarketplaceInfoDialogFragment groupsSalePostMarketplaceInfoDialogFragment = new GroupsSalePostMarketplaceInfoDialogFragment();
                MarketplaceCrossPostSettingModel marketplaceCrossPostSettingModel = this.f10090b.f10098f;
                boolean isChecked = this.isChecked();
                groupsSalePostMarketplaceInfoDialogFragment.ao = marketplaceCrossPostSettingModel;
                if (!isChecked) {
                    groupsSalePostMarketplaceInfoDialogFragment.ap = groupsSalePostMarketplaceInfoDialogFragment.ao.upsellAcceptButtonLabel;
                }
                groupsSalePostMarketplaceInfoDialogFragment.aq = groupsSalePostMarketplaceInfoDialogFragment.ao.upsellDeclineButtonLabel;
                groupsSalePostMarketplaceInfoDialogFragment.as = false;
                groupsSalePostMarketplaceInfoDialogFragment.am = new C11721(this);
                groupsSalePostMarketplaceInfoDialogFragment.an = new C11732(this);
                groupsSalePostMarketplaceInfoDialogFragment.a(fragmentActivity.kO_(), "FOR_SALE_POST_TO_MARKETPLACE_INFO");
                Logger.a(2, EntryType.UI_INPUT_END, 686380836, a);
            }
        });
    }

    private final void m10440a(String str) {
        View a = a(2131560311);
        Tooltip tooltip = new Tooltip(getContext(), 2);
        tooltip.b(this.f10098f.nuxLabel);
        tooltip.a(Position.BELOW);
        tooltip.t = -1;
        tooltip.f(a);
        ViewerGroupMarketplaceCrossPostNuxSeenInputData viewerGroupMarketplaceCrossPostNuxSeenInputData = new ViewerGroupMarketplaceCrossPostNuxSeenInputData();
        viewerGroupMarketplaceCrossPostNuxSeenInputData.a("group_id", str);
        GraphQlCallInput graphQlCallInput = viewerGroupMarketplaceCrossPostNuxSeenInputData;
        graphQlCallInput.a("seen_marketplace_cross_post_nux", SeenMarketplaceCrossPostNux.TRUE);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString groupMarketplaceCrossPostNuxSeenMutationString = new GroupMarketplaceCrossPostNuxSeenMutationString();
        groupMarketplaceCrossPostNuxSeenMutationString.a("input", graphQlCallInput);
        this.f10093a.a(GraphQLRequest.a(groupMarketplaceCrossPostNuxSeenMutationString));
    }

    public final void m10441a(MarketplaceCrossPostSettingModel marketplaceCrossPostSettingModel, final String str) {
        int i = 8;
        this.f10098f = marketplaceCrossPostSettingModel;
        setVisibility(this.f10098f.a().booleanValue() ? 0 : 8);
        FbCheckBox fbCheckBox = this.f10096d;
        if (!this.f10098f.c().booleanValue()) {
            i = 0;
        }
        fbCheckBox.setVisibility(i);
        this.f10097e.setText(this.f10098f.checkBoxLabel);
        GraphQlQueryString fetchMarketplaceCrossPostShowSettingsString = new FetchMarketplaceCrossPostShowSettingsString();
        fetchMarketplaceCrossPostShowSettingsString.a("group_id", str);
        Futures.a(this.f10093a.a(GraphQLRequest.a(fetchMarketplaceCrossPostShowSettingsString).a(GraphQLCachePolicy.c)), new FutureCallback(this) {
            final /* synthetic */ CheckedPostToMarketplaceTextView f10092b;

            public void onSuccess(Object obj) {
                GroupSellConfigModel a = ((FetchMarketplaceCrossPostShowSettingsModel) ((GraphQLResult) obj).e).a();
                if (a != null) {
                    ImmutableList a2 = a.a();
                    int size = a2.size();
                    for (int i = 0; i < size; i++) {
                        EdgesModel edgesModel = (EdgesModel) a2.get(i);
                        if (edgesModel.a() != null && edgesModel.a().a().a()) {
                            this.f10092b.m10440a(str);
                        }
                    }
                }
            }

            public void onFailure(Throwable th) {
                this.f10092b.f10095c.a("CheckedPostToMarketplaceTextView", "Couldn't complete FetchMarketplaceCrossPostShowSettingsQuery", th);
            }
        }, this.f10094b);
    }

    public boolean isChecked() {
        return (this.f10096d != null && this.f10096d.isChecked()) || (this.f10098f != null && this.f10098f.c().booleanValue());
    }

    public void setChecked(boolean z) {
        if (this.f10096d != null) {
            this.f10096d.setChecked(z);
        }
    }

    public void toggle() {
        if (this.f10096d != null) {
            this.f10096d.toggle();
        }
    }

    public void setOnPostToMarketplaceCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        if (this.f10096d != null) {
            this.f10096d.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }
}
