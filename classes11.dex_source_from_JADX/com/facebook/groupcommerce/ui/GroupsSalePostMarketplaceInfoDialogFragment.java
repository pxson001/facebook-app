package com.facebook.groupcommerce.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.ViewerGroupMarketplaceCrossPostInterceptSeenInputData;
import com.facebook.graphql.calls.ViewerGroupMarketplaceCrossPostInterceptSeenInputData.SeenMarketplaceCrossPostIntercept;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groupcommerce.protocol.GroupMarketplaceCrossPostInterceptSeenMutation.GroupMarketplaceCrossPostInterceptSeenMutationString;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.model.MarketplaceCrossPostSettingModel;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.widget.text.BetterTextView;

/* compiled from: ads_management */
public final class GroupsSalePostMarketplaceInfoDialogFragment extends FbDialogFragment {
    public OnClickListener am;
    public OnClickListener an;
    public MarketplaceCrossPostSettingModel ao;
    public String ap;
    public String aq;
    public GraphQLQueryExecutor ar;
    public boolean as;
    public String at;

    public static void m10429a(Object obj, Context context) {
        ((GroupsSalePostMarketplaceInfoDialogFragment) obj).ar = GraphQLQueryExecutor.a(FbInjector.get(context));
    }

    public final void m10430a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1403788180);
        super.a(bundle);
        Class cls = GroupsSalePostMarketplaceInfoDialogFragment.class;
        m10429a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2097601029, a);
    }

    public final Dialog m10431c(Bundle bundle) {
        final LinearLayout linearLayout = (LinearLayout) View.inflate(getContext(), 2130906584, null);
        FbButton fbButton = (FbButton) linearLayout.findViewById(2131566578);
        FbButton fbButton2 = (FbButton) linearLayout.findViewById(2131566577);
        if (this.as && this.at != null) {
            linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ GroupsSalePostMarketplaceInfoDialogFragment f10080b;

                public void onGlobalLayout() {
                    linearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ViewerGroupMarketplaceCrossPostInterceptSeenInputData viewerGroupMarketplaceCrossPostInterceptSeenInputData = new ViewerGroupMarketplaceCrossPostInterceptSeenInputData();
                    viewerGroupMarketplaceCrossPostInterceptSeenInputData.a("group_id", this.f10080b.at);
                    GraphQlCallInput graphQlCallInput = viewerGroupMarketplaceCrossPostInterceptSeenInputData;
                    graphQlCallInput.a("seen_marketplace_cross_post_intercept", SeenMarketplaceCrossPostIntercept.TRUE);
                    graphQlCallInput = graphQlCallInput;
                    GraphQlQueryString groupMarketplaceCrossPostInterceptSeenMutationString = new GroupMarketplaceCrossPostInterceptSeenMutationString();
                    groupMarketplaceCrossPostInterceptSeenMutationString.a("input", graphQlCallInput);
                    this.f10080b.ar.a(GraphQLRequest.a(groupMarketplaceCrossPostInterceptSeenMutationString));
                }
            });
        }
        if (this.ap != null) {
            fbButton.setText(this.ap);
        }
        fbButton2.setText(this.aq);
        if (this.ao.c().booleanValue()) {
            fbButton2.setVisibility(8);
        }
        BetterTextView betterTextView = (BetterTextView) linearLayout.findViewById(2131566574);
        BetterTextView betterTextView2 = (BetterTextView) linearLayout.findViewById(2131566575);
        BetterTextView betterTextView3 = (BetterTextView) linearLayout.findViewById(2131566576);
        ((BetterTextView) linearLayout.findViewById(2131566573)).setText(this.ao.upsellTitleLabel);
        betterTextView.setText(this.ao.upsellPeopleLabel);
        betterTextView2.setText(this.ao.upsellPinLabel);
        betterTextView3.setText(this.ao.upsellTimeLabel);
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(getContext());
        fbAlertDialogBuilder.a(linearLayout, 0, 0, 0, 0);
        final AlertDialog b = fbAlertDialogBuilder.b();
        fbButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GroupsSalePostMarketplaceInfoDialogFragment f10082b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1890029841);
                this.f10082b.am.onClick(view);
                b.cancel();
                Logger.a(2, EntryType.UI_INPUT_END, -835020087, a);
            }
        });
        fbButton2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GroupsSalePostMarketplaceInfoDialogFragment f10084b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 837923850);
                this.f10084b.an.onClick(view);
                b.cancel();
                Logger.a(2, EntryType.UI_INPUT_END, -1900784413, a);
            }
        });
        return b;
    }
}
