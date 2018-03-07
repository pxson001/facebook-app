package com.facebook.goodwill.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.PhotoAttachmentPartDefinition;
import com.facebook.feedplugins.goodwill.ThrowbackSimplePhotoAttachmentPartDefinition;
import com.facebook.feedplugins.goodwill.throwback.ThrowbackFeedFooterPartDefinition;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.goodwill.feed.rows.ThrowbackPromotionFeedUnitEdge.ThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: fb.com */
public class ThrowbackPromotionPhotoStoryGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<ThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static ThrowbackPromotionPhotoStoryGroupPartDefinition f13789g;
    private static final Object f13790h = new Object();
    private final ThrowbackFeedFooterPartDefinition f13791a;
    private final PhotoAttachmentPartDefinition<FeedEnvironment> f13792b;
    private final ThrowbackSimplePhotoAttachmentPartDefinition<FeedEnvironment> f13793c;
    private final ThrowbackFeedPromotionHeaderPartDefinition f13794d;
    private final ThrowbackPromotionMoreFooterPartDefinition f13795e;
    private final GatekeeperStoreImpl f13796f;

    private static ThrowbackPromotionPhotoStoryGroupPartDefinition m15447b(InjectorLike injectorLike) {
        return new ThrowbackPromotionPhotoStoryGroupPartDefinition(PhotoAttachmentPartDefinition.a(injectorLike), ThrowbackSimplePhotoAttachmentPartDefinition.m14411a(injectorLike), ThrowbackFeedFooterPartDefinition.a(injectorLike), ThrowbackFeedPromotionHeaderPartDefinition.m15308a(injectorLike), ThrowbackPromotionMoreFooterPartDefinition.m15442a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m15448a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) ((ThrowbackPromotionFeedUnit) feedProps.a).f13777c;
        FeedProps a = feedProps.a(graphQLStory);
        baseMultiRowSubParts.a(this.f13794d, feedProps);
        if (this.f13796f.a(858, false)) {
            baseMultiRowSubParts.a(this.f13793c, a.a(StoryAttachmentHelper.o(graphQLStory)));
        } else {
            baseMultiRowSubParts.a(this.f13792b, a.a(StoryAttachmentHelper.o(graphQLStory)));
        }
        baseMultiRowSubParts.a(this.f13791a, a);
        baseMultiRowSubParts.a(this.f13795e, feedProps);
        return null;
    }

    public final boolean m15449a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (!(((ThrowbackPromotionFeedUnit) feedProps.a).f13777c instanceof GraphQLStory)) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) ((ThrowbackPromotionFeedUnit) feedProps.a).f13777c;
        return (graphQLStory == null || StoryAttachmentHelper.o(graphQLStory) == null) ? false : true;
    }

    @Inject
    public ThrowbackPromotionPhotoStoryGroupPartDefinition(PhotoAttachmentPartDefinition photoAttachmentPartDefinition, ThrowbackSimplePhotoAttachmentPartDefinition throwbackSimplePhotoAttachmentPartDefinition, ThrowbackFeedFooterPartDefinition throwbackFeedFooterPartDefinition, ThrowbackFeedPromotionHeaderPartDefinition throwbackFeedPromotionHeaderPartDefinition, ThrowbackPromotionMoreFooterPartDefinition throwbackPromotionMoreFooterPartDefinition, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f13791a = throwbackFeedFooterPartDefinition;
        this.f13792b = photoAttachmentPartDefinition;
        this.f13793c = throwbackSimplePhotoAttachmentPartDefinition;
        this.f13794d = throwbackFeedPromotionHeaderPartDefinition;
        this.f13795e = throwbackPromotionMoreFooterPartDefinition;
        this.f13796f = gatekeeperStoreImpl;
    }

    public static ThrowbackPromotionPhotoStoryGroupPartDefinition m15446a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPromotionPhotoStoryGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13790h) {
                ThrowbackPromotionPhotoStoryGroupPartDefinition throwbackPromotionPhotoStoryGroupPartDefinition;
                if (a2 != null) {
                    throwbackPromotionPhotoStoryGroupPartDefinition = (ThrowbackPromotionPhotoStoryGroupPartDefinition) a2.a(f13790h);
                } else {
                    throwbackPromotionPhotoStoryGroupPartDefinition = f13789g;
                }
                if (throwbackPromotionPhotoStoryGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15447b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13790h, b3);
                        } else {
                            f13789g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPromotionPhotoStoryGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
