package com.facebook.feedplugins.pysf.rows;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feedcache.mutator.FeedUnitCacheMutator;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.sections.header.FollowUserButtonPartDefinition;
import com.facebook.feed.rows.sections.header.FollowUserButtonPartDefinition$Props;
import com.facebook.feedplugins.pysf.rows.ui.PersonYouShouldFollowView;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.calls.ActorSubscribeInputData$SubscribeLocation;
import com.facebook.graphql.calls.ActorUnsubscribeInputData$SubscribeLocation;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnitItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FbDraweeImageUriPartDefinition;
import com.facebook.multirow.parts.FbDraweeImageUriPartDefinition.UriContextData;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notification_time */
public class PersonYouShouldFollowPagePartDefinition extends BaseSinglePartDefinitionWithViewType<Props, Void, AnyEnvironment, PersonYouShouldFollowView> {
    public static final ViewType<PersonYouShouldFollowView> f6765a = new C03161();
    private static final CallerContext f6766b = CallerContext.a(PersonYouShouldFollowPagePartDefinition.class, "native_newsfeed");
    private static PersonYouShouldFollowPagePartDefinition f6767m;
    private static final Object f6768n = new Object();
    public final Lazy<DefaultFeedUnitRenderer> f6769c;
    private final TextPartDefinition f6770d;
    private final FbDraweeImageUriPartDefinition f6771e;
    private final ClickListenerPartDefinition f6772f;
    private final FollowUserButtonPartDefinition f6773g;
    public final FeedUnitCacheMutator f6774h;
    public final Lazy<FeedbackGraphQLGenerator> f6775i;
    public final FriendingClient f6776j;
    public final NewsFeedAnalyticsEventBuilder f6777k;
    public final AnalyticsLogger f6778l;

    /* compiled from: notification_time */
    final class C03161 extends ViewType<PersonYouShouldFollowView> {
        C03161() {
        }

        public final View m7145a(Context context) {
            return new PersonYouShouldFollowView(context);
        }
    }

    private static PersonYouShouldFollowPagePartDefinition m7142b(InjectorLike injectorLike) {
        return new PersonYouShouldFollowPagePartDefinition(IdBasedLazy.a(injectorLike, 1473), TextPartDefinition.a(injectorLike), FbDraweeImageUriPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), FollowUserButtonPartDefinition.a(injectorLike), FeedUnitCacheMutator.a(injectorLike), IdBasedLazy.a(injectorLike, 995), FriendingClient.b(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public final Object m7144a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        GraphQLPeopleYouShouldFollowFeedUnitItem graphQLPeopleYouShouldFollowFeedUnitItem = props.b;
        subParts.a(2131565835, this.f6770d, m7140a(graphQLPeopleYouShouldFollowFeedUnitItem));
        subParts.a(2131565836, this.f6770d, graphQLPeopleYouShouldFollowFeedUnitItem.l().a());
        subParts.a(2131565832, this.f6771e, new UriContextData(graphQLPeopleYouShouldFollowFeedUnitItem.m().aI().b(), f6766b));
        2 2 = new 2(this, graphQLPeopleYouShouldFollowFeedUnitItem);
        subParts.a(2131565832, this.f6772f, 2);
        subParts.a(2131565834, this.f6772f, 2);
        subParts.a(2131565837, this.f6773g, new FollowUserButtonPartDefinition$Props(props.a, graphQLPeopleYouShouldFollowFeedUnitItem.m().aZ(), graphQLPeopleYouShouldFollowFeedUnitItem.m().P(), ActorSubscribeInputData$SubscribeLocation.PYSF_NETEGO, ActorUnsubscribeInputData$SubscribeLocation.PYSF_NETEGO, 2130840299, 2130840191));
        subParts.a(2131565838, this.f6772f, new 3(this, props));
        return null;
    }

    public static PersonYouShouldFollowPagePartDefinition m7141a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PersonYouShouldFollowPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6768n) {
                PersonYouShouldFollowPagePartDefinition personYouShouldFollowPagePartDefinition;
                if (a2 != null) {
                    personYouShouldFollowPagePartDefinition = (PersonYouShouldFollowPagePartDefinition) a2.a(f6768n);
                } else {
                    personYouShouldFollowPagePartDefinition = f6767m;
                }
                if (personYouShouldFollowPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7142b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6768n, b3);
                        } else {
                            f6767m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = personYouShouldFollowPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PersonYouShouldFollowPagePartDefinition(Lazy<DefaultFeedUnitRenderer> lazy, TextPartDefinition textPartDefinition, FbDraweeImageUriPartDefinition fbDraweeImageUriPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, FollowUserButtonPartDefinition followUserButtonPartDefinition, FeedUnitCacheMutator feedUnitCacheMutator, Lazy<FeedbackGraphQLGenerator> lazy2, FriendingClient friendingClient, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger) {
        this.f6769c = lazy;
        this.f6770d = textPartDefinition;
        this.f6771e = fbDraweeImageUriPartDefinition;
        this.f6772f = clickListenerPartDefinition;
        this.f6773g = followUserButtonPartDefinition;
        this.f6774h = feedUnitCacheMutator;
        this.f6775i = lazy2;
        this.f6776j = friendingClient;
        this.f6777k = newsFeedAnalyticsEventBuilder;
        this.f6778l = analyticsLogger;
    }

    public final ViewType<PersonYouShouldFollowView> m7143a() {
        return f6765a;
    }

    private static SpannableStringBuilder m7140a(GraphQLPeopleYouShouldFollowFeedUnitItem graphQLPeopleYouShouldFollowFeedUnitItem) {
        StyleSpan styleSpan = new StyleSpan(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(graphQLPeopleYouShouldFollowFeedUnitItem.m().ar());
        spannableStringBuilder.setSpan(styleSpan, 0, graphQLPeopleYouShouldFollowFeedUnitItem.m().ar().length(), 33);
        if (!(graphQLPeopleYouShouldFollowFeedUnitItem.j() == null || graphQLPeopleYouShouldFollowFeedUnitItem.j().a() == null)) {
            spannableStringBuilder.append("\n");
            spannableStringBuilder.append(graphQLPeopleYouShouldFollowFeedUnitItem.j().a());
        }
        return spannableStringBuilder;
    }
}
