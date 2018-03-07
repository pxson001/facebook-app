package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.collage.PhotoGridProperties;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.LifeEventAttachmentHeaderTextPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.components.C1782xbb613794;
import com.facebook.feed.rows.sections.attachments.components.LifeEventAttachmentHeaderSubtitleTextComponentPartDefinition;
import com.facebook.feed.rows.sections.attachments.components.LifeEventAttachmentHeaderTitleTextComponentPartDefinition;
import com.facebook.feedplugins.attachments.collage.CollageAttachmentPartDefinition;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowSubParts;
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ZZ)Z */
public class LifeEventAttachmentGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static LifeEventAttachmentGroupPartDefinition f20627n;
    private static final Object f20628o = new Object();
    private final LifeEventAttachmentHeaderIconPartDefinition f20629a;
    private final LifeEventAttachmentHeaderTextPartDefinition f20630b;
    private final LifeEventAttachmentDescriptionPartDefinition f20631c;
    private final LifeEventAttachmentHeaderTitleTextComponentPartDefinition f20632d;
    private final LifeEventAttachmentHeaderSubtitleTextComponentPartDefinition f20633e;
    private final C1782xbb613794 f20634f;
    private final PhotoGridProperties f20635g;
    private final PhotoAttachmentPartDefinition<FeedEnvironment> f20636h;
    private final CollageAttachmentPartDefinition<FeedEnvironment> f20637i;
    private final int f20638j;
    private final int f20639k = -16777216;
    private final int f20640l;
    private final int f20641m;

    private static LifeEventAttachmentGroupPartDefinition m23664b(InjectorLike injectorLike) {
        return new LifeEventAttachmentGroupPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), LifeEventAttachmentHeaderIconPartDefinition.m23668a(injectorLike), LifeEventAttachmentHeaderTextPartDefinition.m23676a(injectorLike), LifeEventAttachmentDescriptionPartDefinition.m23656a(injectorLike), LifeEventAttachmentHeaderTitleTextComponentPartDefinition.m23838a(injectorLike), LifeEventAttachmentHeaderSubtitleTextComponentPartDefinition.m23823a(injectorLike), C1782xbb613794.m23846a(injectorLike), PhotoGridProperties.b(injectorLike), PhotoAttachmentPartDefinition.a(injectorLike), CollageAttachmentPartDefinition.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m23665a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        return m23663a(baseMultiRowSubParts, (FeedProps) obj);
    }

    public final boolean m23666a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (!GraphQLStoryAttachmentUtil.f(graphQLStoryAttachment)) {
            return false;
        }
        if (graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().S() == null) {
            return true;
        }
        if (this.f20635g.f(graphQLStoryAttachment)) {
            return this.f20637i.a(feedProps);
        }
        return PhotoAttachmentPartDefinition.a(feedProps);
    }

    public static LifeEventAttachmentGroupPartDefinition m23662a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LifeEventAttachmentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20628o) {
                LifeEventAttachmentGroupPartDefinition lifeEventAttachmentGroupPartDefinition;
                if (a2 != null) {
                    lifeEventAttachmentGroupPartDefinition = (LifeEventAttachmentGroupPartDefinition) a2.a(f20628o);
                } else {
                    lifeEventAttachmentGroupPartDefinition = f20627n;
                }
                if (lifeEventAttachmentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23664b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20628o, b3);
                        } else {
                            f20627n = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = lifeEventAttachmentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LifeEventAttachmentGroupPartDefinition(Resources resources, LifeEventAttachmentHeaderIconPartDefinition lifeEventAttachmentHeaderIconPartDefinition, LifeEventAttachmentHeaderTextPartDefinition lifeEventAttachmentHeaderTextPartDefinition, LifeEventAttachmentDescriptionPartDefinition lifeEventAttachmentDescriptionPartDefinition, LifeEventAttachmentHeaderTitleTextComponentPartDefinition lifeEventAttachmentHeaderTitleTextComponentPartDefinition, LifeEventAttachmentHeaderSubtitleTextComponentPartDefinition lifeEventAttachmentHeaderSubtitleTextComponentPartDefinition, C1782xbb613794 c1782xbb613794, PhotoGridProperties photoGridProperties, PhotoAttachmentPartDefinition photoAttachmentPartDefinition, CollageAttachmentPartDefinition collageAttachmentPartDefinition) {
        this.f20629a = lifeEventAttachmentHeaderIconPartDefinition;
        this.f20630b = lifeEventAttachmentHeaderTextPartDefinition;
        this.f20631c = lifeEventAttachmentDescriptionPartDefinition;
        this.f20632d = lifeEventAttachmentHeaderTitleTextComponentPartDefinition;
        this.f20633e = lifeEventAttachmentHeaderSubtitleTextComponentPartDefinition;
        this.f20634f = c1782xbb613794;
        this.f20635g = photoGridProperties;
        this.f20636h = photoAttachmentPartDefinition;
        this.f20637i = collageAttachmentPartDefinition;
        this.f20640l = SizeUtil.c(resources, 2131427400);
        this.f20641m = resources.getColor(2131362052);
        this.f20638j = SizeUtil.c(resources, 2131427404);
    }

    private Void m23663a(MultiRowSubParts<FeedEnvironment> multiRowSubParts, FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        multiRowSubParts.a(this.f20629a, feedProps);
        SubPartsSelector.a(multiRowSubParts, this.f20632d, feedProps).a(this.f20630b, new Props(feedProps, FlyoutClickSource.TITLE, "Title", 4.0f, 0.0f, this.f20638j, this.f20639k));
        SubPartsSelector.a(multiRowSubParts, this.f20633e, feedProps).a(this.f20630b, new Props(feedProps, FlyoutClickSource.SUBTITLE, "Subtitle", 4.0f, 8.0f, this.f20640l, this.f20641m));
        SubPartsSelector.a(multiRowSubParts, this.f20634f, feedProps).a(this.f20630b, new Props(feedProps, FlyoutClickSource.SUBTITLE, "Under Subtitle", 4.0f, 8.0f, this.f20640l, this.f20641m));
        multiRowSubParts.a(this.f20631c, feedProps);
        if (!(graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().S() == null)) {
            if (this.f20635g.f(graphQLStoryAttachment)) {
                multiRowSubParts.a(this.f20637i, feedProps);
            } else {
                multiRowSubParts.a(this.f20636h, feedProps);
            }
        }
        return null;
    }
}
