package com.facebook.gametime.ui.reaction;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQL;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQL.GametimePlaySubscriptionString;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimePlaySubscriptionModel;
import com.facebook.gametime.graphql.GametimeFragmentsGraphQLModels.GametimePlaySubscriptionModel.PlayModel;
import com.facebook.graphql.calls.GametimeMatchPlayCreateSubscribeInputData;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionConnectorException;
import com.facebook.graphql.mqtt.GraphQLSubscriptionConnector.GraphQLSubscriptionHandle;
import com.facebook.inject.Assisted;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.GametimeDataFactFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLModels.GametimeDataFactFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: {storyID} */
public class GametimePlaySubscriber {
    public final DefaultAndroidThreadUtil f14a;
    private final String f15b;
    public final ReactionCardContainer f16c;
    public final Set<ComponentIdentifier> f17d;
    public final GraphQLSubscriptionConnector f18e;
    public final GraphQLSubscriptionHolder f19f;
    private boolean f20g = false;
    public GraphQLSubscriptionHandle f21h;

    /* compiled from: {storyID} */
    class C00011 extends AbstractDisposableFutureCallback<GametimePlaySubscriptionModel> {
        final /* synthetic */ GametimePlaySubscriber f11a;

        C00011(GametimePlaySubscriber gametimePlaySubscriber) {
            this.f11a = gametimePlaySubscriber;
        }

        protected final void m11a(Object obj) {
            GametimePlaySubscriptionModel gametimePlaySubscriptionModel = (GametimePlaySubscriptionModel) obj;
            if (gametimePlaySubscriptionModel != null && gametimePlaySubscriptionModel.a() != null) {
                final PlayModel a = gametimePlaySubscriptionModel.a();
                this.f11a.f14a.a(new Runnable(this) {
                    final /* synthetic */ C00011 f10b;

                    public void run() {
                        GametimePlaySubscriber gametimePlaySubscriber = this.f10b.f11a;
                        PlayModel playModel = a;
                        for (ComponentIdentifier componentIdentifier : gametimePlaySubscriber.f17d) {
                            ReactionUnitFragment a = gametimePlaySubscriber.f16c.a(componentIdentifier.f12a);
                            if (a != null) {
                                ReactionUnitComponentModel a2 = ReactionUnitComponentUtil.a(a, componentIdentifier.f13b);
                                if (!(a2 == null || a2.bW() == null)) {
                                    int i;
                                    if (a2.bW().isEmpty()) {
                                        i = -1;
                                    } else {
                                        i = ((GametimeDataFactFragment) a2.bW().get(0)).l();
                                    }
                                    if (i < playModel.l()) {
                                        Builder builder = ImmutableList.builder();
                                        builder.c(GametimeDataFactFragmentModel.a(playModel));
                                        ImmutableList bW = a2.bW();
                                        int size = bW.size();
                                        for (int i2 = 0; i2 < size; i2++) {
                                            builder.c(GametimeDataFactFragmentModel.a((GametimeDataFactFragment) bW.get(i2)));
                                        }
                                        ReactionUnitComponentModel.Builder a3 = ReactionUnitComponentModel.Builder.a(ReactionUnitComponentModel.a(a2));
                                        a3.bK = builder.b();
                                        gametimePlaySubscriber.f16c.a(ReactionUnitComponentUtil.a(a, a3.a(), componentIdentifier.f13b), componentIdentifier.f12a, CardSearchType.UNIT_ID);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }

        protected final void m12a(Throwable th) {
        }
    }

    /* compiled from: {storyID} */
    public class ComponentIdentifier {
        public String f12a;
        public String f13b;

        ComponentIdentifier(String str, String str2) {
            this.f12a = str;
            this.f13b = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ComponentIdentifier componentIdentifier = (ComponentIdentifier) obj;
            if (componentIdentifier.f12a.equals(this.f12a) && componentIdentifier.f13b.equals(this.f13b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.f12a, this.f13b});
        }
    }

    @Inject
    public GametimePlaySubscriber(@Assisted String str, @Assisted ReactionCardContainer reactionCardContainer, DefaultAndroidThreadUtil defaultAndroidThreadUtil, GraphQLSubscriptionConnector graphQLSubscriptionConnector, GraphQLSubscriptionHolder graphQLSubscriptionHolder) {
        this.f15b = str;
        this.f16c = reactionCardContainer;
        this.f14a = defaultAndroidThreadUtil;
        this.f18e = graphQLSubscriptionConnector;
        this.f19f = graphQLSubscriptionHolder;
        this.f17d = new HashSet();
    }

    public final void m14a(String str, String str2) {
        this.f17d.add(new ComponentIdentifier(str, str2));
        if (!this.f20g) {
            m13e();
        }
    }

    private void m13e() {
        this.f20g = true;
        GametimePlaySubscriptionString g = GametimeFragmentsGraphQL.g();
        g.a("input", new GametimeMatchPlayCreateSubscribeInputData().a(this.f15b));
        try {
            this.f21h = this.f18e.a(g, new C00011(this));
        } catch (GraphQLSubscriptionConnectorException e) {
        }
    }
}
