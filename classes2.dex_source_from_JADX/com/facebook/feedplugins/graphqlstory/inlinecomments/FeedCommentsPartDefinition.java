package com.facebook.feedplugins.graphqlstory.inlinecomments;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView.ScaleType;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.environment.HasScrollListenerSupport;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feedplugins.graphqlstory.inlinecomments.FeedCommentPartDefinition.Props;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ineligible_reason */
public class FeedCommentsPartDefinition<E extends HasPositionInformation & HasPersistentState & HasRowKey & HasPrefetcher & HasScrollListenerSupport> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, E> {
    private static FeedCommentsPartDefinition f20198g;
    private static final Object f20199h = new Object();
    public final Resources f20200a;
    private final FeedStoryUtil f20201b;
    private final GraphQLStoryUtil f20202c;
    public final FeedCommentPartDefinition<E> f20203d;
    private final AttachmentDisplayInfoHelper f20204e;
    public final QeAccessor f20205f;

    private static FeedCommentsPartDefinition m27857b(InjectorLike injectorLike) {
        return new FeedCommentsPartDefinition(ResourcesMethodAutoProvider.m6510a(injectorLike), FeedStoryUtil.m18578a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike), FeedCommentPartDefinition.m27861a(injectorLike), AttachmentDisplayInfoHelper.m27903a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        Flattenable flattenable = feedProps.f13444a;
        List e = this.f20202c.m9595e(feedProps);
        if (!(e == null || e.isEmpty())) {
            boolean a = this.f20205f.mo593a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMultipleRowsStoriesAbtestModule.f6718h, false);
            for (int i = 0; i < e.size(); i++) {
                AttachmentDisplayInfo attachmentDisplayInfo;
                if (a) {
                    AttachmentDisplayInfo attachmentDisplayInfo2;
                    GraphQLComment graphQLComment = (GraphQLComment) e.get(i);
                    Resources resources = this.f20200a;
                    if (graphQLComment == null) {
                        attachmentDisplayInfo2 = null;
                    } else {
                        AttachmentDisplayInfo attachmentDisplayInfo3;
                        AttachmentDisplayInfo$Builder attachmentDisplayInfo$Builder = new AttachmentDisplayInfo$Builder();
                        GraphQLStoryAttachment f = GraphQLCommentHelper.m29311f(graphQLComment);
                        if (f != null) {
                            attachmentDisplayInfo$Builder.f21606a = ImageUtil.m26990a(AttachmentDisplayInfoHelper.m27904a(resources, f));
                            AttachmentDisplayInfo$Builder attachmentDisplayInfo$Builder2 = attachmentDisplayInfo$Builder;
                            attachmentDisplayInfo$Builder2.f21609d = AttachmentDisplayInfoHelper.m27905a(graphQLComment, 2131235702, resources);
                            attachmentDisplayInfo$Builder2 = attachmentDisplayInfo$Builder2;
                            attachmentDisplayInfo$Builder2.f21607b = ScaleType.CENTER_CROP;
                            attachmentDisplayInfo$Builder2.f21608c = true;
                        }
                        f = GraphQLCommentHelper.m29310e(graphQLComment);
                        if (f != null) {
                            attachmentDisplayInfo$Builder.f21606a = ImageUtil.m26990a(AttachmentDisplayInfoHelper.m27904a(resources, f));
                            attachmentDisplayInfo$Builder.f21609d = AttachmentDisplayInfoHelper.m27905a(graphQLComment, 2131235703, resources);
                        }
                        if (attachmentDisplayInfo$Builder.f21606a == null) {
                            attachmentDisplayInfo3 = null;
                        } else {
                            attachmentDisplayInfo3 = new AttachmentDisplayInfo(attachmentDisplayInfo$Builder);
                        }
                        attachmentDisplayInfo2 = attachmentDisplayInfo3;
                    }
                    attachmentDisplayInfo = attachmentDisplayInfo2;
                } else {
                    attachmentDisplayInfo = null;
                }
                baseMultiRowSubParts.m19112a(this.f20203d, new Props(feedProps, new InlineCommentData(feedProps, (GraphQLComment) e.get(i), attachmentDisplayInfo)));
            }
        }
        return null;
    }

    @Inject
    public FeedCommentsPartDefinition(Resources resources, FeedStoryUtil feedStoryUtil, GraphQLStoryUtil graphQLStoryUtil, FeedCommentPartDefinition feedCommentPartDefinition, AttachmentDisplayInfoHelper attachmentDisplayInfoHelper, QeAccessor qeAccessor) {
        this.f20200a = resources;
        this.f20201b = feedStoryUtil;
        this.f20202c = graphQLStoryUtil;
        this.f20203d = feedCommentPartDefinition;
        this.f20204e = attachmentDisplayInfoHelper;
        this.f20205f = qeAccessor;
    }

    public static FeedCommentsPartDefinition m27856a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedCommentsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20199h) {
                FeedCommentsPartDefinition feedCommentsPartDefinition;
                if (a2 != null) {
                    feedCommentsPartDefinition = (FeedCommentsPartDefinition) a2.mo818a(f20199h);
                } else {
                    feedCommentsPartDefinition = f20198g;
                }
                if (feedCommentsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27857b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20199h, b3);
                        } else {
                            f20198g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedCommentsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final boolean m27859a(FeedProps<GraphQLStory> feedProps) {
        return this.f20201b.m18587a((FeedProps) feedProps);
    }
}
