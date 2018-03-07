package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.attachments.angora.actionbutton.AngoraActionButtonController;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.linkshare.SidePhotoPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.ui.PortraitPhotoShareAttachmentView;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchZeroOptinContentRequestParams */
public class PortraitPhotoShareAttachmentPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, PortraitPhotoShareAttachmentView> {
    private static PortraitPhotoShareAttachmentPartDefinition f24215f;
    private static final Object f24216g = new Object();
    public final AngoraActionButtonController f24217a;
    private final FeedImageLoader f24218b;
    private final BaseShareAttachmentPartDefinition<E, PortraitPhotoShareAttachmentView> f24219c;
    private final SidePhotoPartDefinition<E, PortraitPhotoShareAttachmentView> f24220d;
    private final int f24221e;

    private static PortraitPhotoShareAttachmentPartDefinition m32565b(InjectorLike injectorLike) {
        return new PortraitPhotoShareAttachmentPartDefinition(ResourcesMethodAutoProvider.m6510a(injectorLike), AngoraActionButtonController.m32349a(injectorLike), FeedImageLoader.m28808a(injectorLike), BaseShareAttachmentPartDefinition.m32218a(injectorLike), SidePhotoPartDefinition.m32360a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        subParts.mo2756a(this.f24219c, feedProps);
        subParts.mo2756a(this.f24220d, new Props(graphQLStoryAttachment, this.f24221e));
        return null;
    }

    public final boolean m32568a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        Object obj2 = 1;
        GraphQLStory c = AttachmentProps.m28714c(feedProps);
        if (c != null) {
            if (c.mo2895u()) {
                obj2 = null;
            } else {
                GraphQLActor b = StoryActorHelper.m27492b(c);
                if (b != null) {
                    GraphQLObjectType b2 = b.m23790b();
                    if (b2 != null && b2.m22301g() == 2479791) {
                        obj2 = null;
                    }
                }
            }
        }
        if (obj2 != null) {
            int i = this.f24221e;
            if (this.f24217a.m32352b(feedProps)) {
                obj2 = null;
            } else {
                GraphQLMedia r = ((GraphQLStoryAttachment) feedProps.f13444a).m23979r();
                if (r == null) {
                    obj2 = null;
                } else {
                    GraphQLImage a = FeedImageLoader.m28809a(r, i);
                    obj2 = (a == null || GraphQLHelper.m22444a(a) >= 0.8f) ? null : 1;
                }
            }
            if (obj2 != null) {
                return true;
            }
        }
        return false;
    }

    @Inject
    public PortraitPhotoShareAttachmentPartDefinition(Resources resources, AngoraActionButtonController angoraActionButtonController, FeedImageLoader feedImageLoader, BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, SidePhotoPartDefinition sidePhotoPartDefinition) {
        this.f24217a = angoraActionButtonController;
        this.f24218b = feedImageLoader;
        this.f24219c = baseShareAttachmentPartDefinition;
        this.f24220d = sidePhotoPartDefinition;
        this.f24221e = SizeUtil.m19197b(resources, 2131427518);
    }

    public static PortraitPhotoShareAttachmentPartDefinition m32564a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PortraitPhotoShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24216g) {
                PortraitPhotoShareAttachmentPartDefinition portraitPhotoShareAttachmentPartDefinition;
                if (a2 != null) {
                    portraitPhotoShareAttachmentPartDefinition = (PortraitPhotoShareAttachmentPartDefinition) a2.mo818a(f24216g);
                } else {
                    portraitPhotoShareAttachmentPartDefinition = f24215f;
                }
                if (portraitPhotoShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32565b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24216g, b3);
                        } else {
                            f24215f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = portraitPhotoShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType mo2547a() {
        return PortraitPhotoShareAttachmentView.h;
    }
}
