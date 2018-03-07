package com.facebook.goodwill.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.collage.CollageAttachmentPartDefinition;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackAnniversaryCampaignStory;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchFriendsYouMayInviteParams */
public class ThrowbackAnniversaryCampaignGroupPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLGoodwillThrowbackAnniversaryCampaignStory, Void, FeedEnvironment> {
    private static ThrowbackAnniversaryCampaignGroupPartDefinition f13504d;
    private static final Object f13505e = new Object();
    private final ThrowbackAnniversaryCampaignHeaderPartDefinition f13506a;
    private final CollageAttachmentPartDefinition<FeedEnvironment> f13507b;
    private final ThrowbackAnniversaryCampaignSharePartDefinition f13508c;

    private static ThrowbackAnniversaryCampaignGroupPartDefinition m15283b(InjectorLike injectorLike) {
        return new ThrowbackAnniversaryCampaignGroupPartDefinition(ThrowbackAnniversaryCampaignHeaderPartDefinition.m15287a(injectorLike), CollageAttachmentPartDefinition.a(injectorLike), ThrowbackAnniversaryCampaignSharePartDefinition.m15293a(injectorLike));
    }

    public final Object m15284a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLGoodwillThrowbackAnniversaryCampaignStory graphQLGoodwillThrowbackAnniversaryCampaignStory = (GraphQLGoodwillThrowbackAnniversaryCampaignStory) obj;
        Builder builder = new Builder();
        builder.r = graphQLGoodwillThrowbackAnniversaryCampaignStory.k().r();
        builder = builder;
        builder.q = ImmutableList.of(GraphQLStoryAttachmentStyle.ALBUM);
        GraphQLStoryAttachment a = builder.a();
        GraphQLStory.Builder builder2 = new GraphQLStory.Builder();
        builder2.o = graphQLGoodwillThrowbackAnniversaryCampaignStory.g();
        builder2 = builder2;
        builder2.ay = null;
        builder2 = builder2;
        builder2.X = graphQLGoodwillThrowbackAnniversaryCampaignStory.m();
        builder2 = builder2;
        builder2.m = ImmutableList.of(a);
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(builder2.a());
        baseMultiRowSubParts.a(this.f13506a, FeedProps.c(graphQLGoodwillThrowbackAnniversaryCampaignStory));
        baseMultiRowSubParts.a(this.f13507b, FeedProps.a(o, ImmutableList.of(graphQLGoodwillThrowbackAnniversaryCampaignStory)));
        baseMultiRowSubParts.a(this.f13508c, graphQLGoodwillThrowbackAnniversaryCampaignStory);
        return null;
    }

    public final boolean m15285a(Object obj) {
        GraphQLGoodwillThrowbackAnniversaryCampaignStory graphQLGoodwillThrowbackAnniversaryCampaignStory = (GraphQLGoodwillThrowbackAnniversaryCampaignStory) obj;
        return (graphQLGoodwillThrowbackAnniversaryCampaignStory == null || graphQLGoodwillThrowbackAnniversaryCampaignStory.k() == null) ? false : true;
    }

    @Inject
    public ThrowbackAnniversaryCampaignGroupPartDefinition(ThrowbackAnniversaryCampaignHeaderPartDefinition throwbackAnniversaryCampaignHeaderPartDefinition, CollageAttachmentPartDefinition collageAttachmentPartDefinition, ThrowbackAnniversaryCampaignSharePartDefinition throwbackAnniversaryCampaignSharePartDefinition) {
        this.f13506a = throwbackAnniversaryCampaignHeaderPartDefinition;
        this.f13507b = collageAttachmentPartDefinition;
        this.f13508c = throwbackAnniversaryCampaignSharePartDefinition;
    }

    public static ThrowbackAnniversaryCampaignGroupPartDefinition m15282a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackAnniversaryCampaignGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13505e) {
                ThrowbackAnniversaryCampaignGroupPartDefinition throwbackAnniversaryCampaignGroupPartDefinition;
                if (a2 != null) {
                    throwbackAnniversaryCampaignGroupPartDefinition = (ThrowbackAnniversaryCampaignGroupPartDefinition) a2.a(f13505e);
                } else {
                    throwbackAnniversaryCampaignGroupPartDefinition = f13504d;
                }
                if (throwbackAnniversaryCampaignGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15283b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13505e, b3);
                        } else {
                            f13504d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackAnniversaryCampaignGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
