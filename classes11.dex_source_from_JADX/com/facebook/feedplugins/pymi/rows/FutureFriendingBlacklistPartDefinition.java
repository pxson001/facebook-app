package com.facebook.feedplugins.pymi.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.feedcache.mutator.FeedUnitCacheMutator;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.feedplugins.pymi.fetcher.PeopleYouMayInviteFeedUnitFetcher;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsEdge;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.multirow.parts.VisibilityPartDefinition;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: code_expired */
public class FutureFriendingBlacklistPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, View> {
    private static FutureFriendingBlacklistPartDefinition f8699i;
    private static final Object f8700j = new Object();
    public final AllCapsTransformationMethod f8701a;
    private final ClickListenerPartDefinition f8702b;
    public final FeedUnitCacheMutator f8703c;
    public final PeopleYouMayInviteFeedUnitFetcher f8704d;
    public final FriendingClient f8705e;
    public final Resources f8706f;
    private final TextPartDefinition f8707g;
    private final VisibilityPartDefinition<AnyEnvironment> f8708h;

    /* compiled from: code_expired */
    public class Props {
        public final GraphQLPeopleYouMayInviteFeedUnit f8695a;
        public final GraphQLPeopleYouMayInviteFeedUnitContactsEdge f8696b;
        @Nullable
        public final String f8697c;
        public final boolean f8698d;

        public Props(GraphQLPeopleYouMayInviteFeedUnit graphQLPeopleYouMayInviteFeedUnit, GraphQLPeopleYouMayInviteFeedUnitContactsEdge graphQLPeopleYouMayInviteFeedUnitContactsEdge, String str, boolean z) {
            this.f8695a = graphQLPeopleYouMayInviteFeedUnit;
            this.f8696b = graphQLPeopleYouMayInviteFeedUnitContactsEdge;
            this.f8697c = str;
            this.f8698d = z;
        }
    }

    private static FutureFriendingBlacklistPartDefinition m9518b(InjectorLike injectorLike) {
        return new FutureFriendingBlacklistPartDefinition(AllCapsTransformationMethod.b(injectorLike), ClickListenerPartDefinition.a(injectorLike), FeedUnitCacheMutator.a(injectorLike), PeopleYouMayInviteFeedUnitFetcher.m9507a(injectorLike), FriendingClient.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), TextPartDefinition.a(injectorLike), VisibilityPartDefinition.a(injectorLike));
    }

    public final Object m9519a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        subParts.a(this.f8702b, new OnClickListener(this) {
            final /* synthetic */ FutureFriendingBlacklistPartDefinition f8694b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2079953373);
                this.f8694b.f8705e.a(props.f8697c);
                GraphQLPeopleYouMayInviteFeedUnit a2 = this.f8694b.f8703c.a(props.f8695a, props.f8696b.k());
                if (a2 != null) {
                    this.f8694b.f8704d.m9511a(a2);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 2118659551, a);
            }
        });
        subParts.a(this.f8707g, this.f8701a.getTransformation(this.f8706f.getString(2131239087), null));
        subParts.a(this.f8708h, Integer.valueOf(props.f8698d ? 8 : 0));
        return null;
    }

    public static FutureFriendingBlacklistPartDefinition m9517a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FutureFriendingBlacklistPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8700j) {
                FutureFriendingBlacklistPartDefinition futureFriendingBlacklistPartDefinition;
                if (a2 != null) {
                    futureFriendingBlacklistPartDefinition = (FutureFriendingBlacklistPartDefinition) a2.a(f8700j);
                } else {
                    futureFriendingBlacklistPartDefinition = f8699i;
                }
                if (futureFriendingBlacklistPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9518b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8700j, b3);
                        } else {
                            f8699i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = futureFriendingBlacklistPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public FutureFriendingBlacklistPartDefinition(AllCapsTransformationMethod allCapsTransformationMethod, ClickListenerPartDefinition clickListenerPartDefinition, FeedUnitCacheMutator feedUnitCacheMutator, PeopleYouMayInviteFeedUnitFetcher peopleYouMayInviteFeedUnitFetcher, FriendingClient friendingClient, Resources resources, TextPartDefinition textPartDefinition, VisibilityPartDefinition visibilityPartDefinition) {
        this.f8701a = allCapsTransformationMethod;
        this.f8702b = clickListenerPartDefinition;
        this.f8703c = feedUnitCacheMutator;
        this.f8704d = peopleYouMayInviteFeedUnitFetcher;
        this.f8705e = friendingClient;
        this.f8706f = resources;
        this.f8707g = textPartDefinition;
        this.f8708h = visibilityPartDefinition;
    }
}
