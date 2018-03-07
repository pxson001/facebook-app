package com.facebook.feedplugins.prompts;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.feedplugins.prompts.SocialPromptFeedActionHandler.C20511;
import com.facebook.feedplugins.prompts.graphql.ProductionPromptShareMutations.ProductionPromptShareMutationsString;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.ProductionPromptShareInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment.AnonymousClass16;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: SMS_READONLY_MODE */
public class PromptFriendSelectorFragment extends GenericFriendsSelectorFragment {
    private static final String aw = PromptFriendSelectorFragment.class.getSimpleName();
    @Inject
    public Lazy<SocialPromptFeedActionHandler> au;
    @Inject
    public AbstractFbErrorReporter av;
    private String ax;

    public static void m25915a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PromptFriendSelectorFragment promptFriendSelectorFragment = (PromptFriendSelectorFragment) obj;
        Lazy a = IdBasedLazy.a(fbInjector, 6434);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        promptFriendSelectorFragment.au = a;
        promptFriendSelectorFragment.av = abstractFbErrorReporter;
    }

    public final void mo321c(Bundle bundle) {
        Class cls = PromptFriendSelectorFragment.class;
        m25915a(this, getContext());
        super.mo321c(bundle);
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.ax = bundle2.getString(SocialPromptConstants.f23762a);
        }
        if (bundle2 == null || Strings.isNullOrEmpty(this.ax)) {
            this.av.a(aw, "FriendVote inviter launched without specifying Prompt ID");
        }
    }

    public final void mo322d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 356982382);
        super.mo322d(bundle);
        CharSequence string = jW_().getString(2131239240);
        if (this.aL != null) {
            View inflate = this.aL.inflate();
            ((ImageView) inflate.findViewById(2131562390)).setImageResource(2130840782);
            ((TextView) inflate.findViewById(2131562391)).setText(string);
            inflate.findViewById(2131562392).setOnClickListener(new AnonymousClass16(this, inflate));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1126574197, a);
    }

    protected final void aH() {
        SocialPromptFeedActionHandler socialPromptFeedActionHandler = (SocialPromptFeedActionHandler) this.au.get();
        ImmutableList ax = ax();
        String str = this.ax;
        GraphQlQueryString productionPromptShareMutationsString = new ProductionPromptShareMutationsString();
        ProductionPromptShareInputData productionPromptShareInputData = new ProductionPromptShareInputData();
        productionPromptShareInputData.a("actor_id", (String) socialPromptFeedActionHandler.f23771d.get());
        GraphQlCallInput graphQlCallInput = productionPromptShareInputData;
        graphQlCallInput.a("production_prompt_id", str);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("user_ids", ax);
        productionPromptShareMutationsString.a("input", graphQlCallInput);
        socialPromptFeedActionHandler.f23772e.a("key_send_social_prompt_invite", socialPromptFeedActionHandler.f23773f.a(GraphQLRequest.a(productionPromptShareMutationsString), OfflineQueryBehavior.b), new C20511(socialPromptFeedActionHandler, this));
    }
}
