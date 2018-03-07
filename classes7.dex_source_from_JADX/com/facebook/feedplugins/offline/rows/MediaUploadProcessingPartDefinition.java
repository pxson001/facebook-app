package com.facebook.feedplugins.offline.rows;

import android.content.Context;
import android.view.View;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.upload.serverprocessing.util.VideoProcessingUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: STICKER_EDIT_FLOW */
public class MediaUploadProcessingPartDefinition<E extends HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<GraphQLStory, Void, E, View> {
    public static final ViewType f23559a = ViewType.a(2130907612);
    private static MediaUploadProcessingPartDefinition f23560d;
    private static final Object f23561e = new Object();
    private final OptimisticStoryStateCache f23562b;
    private final QeAccessor f23563c;

    private static MediaUploadProcessingPartDefinition m25802b(InjectorLike injectorLike) {
        return new MediaUploadProcessingPartDefinition(OptimisticStoryStateCache.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MediaUploadProcessingPartDefinition(OptimisticStoryStateCache optimisticStoryStateCache, QeAccessor qeAccessor) {
        this.f23562b = optimisticStoryStateCache;
        this.f23563c = qeAccessor;
    }

    public final ViewType m25803a() {
        return f23559a;
    }

    public final boolean m25804a(GraphQLStory graphQLStory) {
        if ((!StoryAttachmentHelper.k(graphQLStory) && !StoryAttachmentHelper.n(graphQLStory)) || !VideoProcessingUtil.a(this.f23563c)) {
            return false;
        }
        GraphQLFeedOptimisticPublishState a = this.f23562b.a(graphQLStory);
        if (a == GraphQLFeedOptimisticPublishState.DELETED || a == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || a != GraphQLFeedOptimisticPublishState.SUCCESS) {
            return false;
        }
        return true;
    }

    public static MediaUploadProcessingPartDefinition m25801a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaUploadProcessingPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23561e) {
                MediaUploadProcessingPartDefinition mediaUploadProcessingPartDefinition;
                if (a2 != null) {
                    mediaUploadProcessingPartDefinition = (MediaUploadProcessingPartDefinition) a2.a(f23561e);
                } else {
                    mediaUploadProcessingPartDefinition = f23560d;
                }
                if (mediaUploadProcessingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25802b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23561e, b3);
                        } else {
                            f23560d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaUploadProcessingPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
