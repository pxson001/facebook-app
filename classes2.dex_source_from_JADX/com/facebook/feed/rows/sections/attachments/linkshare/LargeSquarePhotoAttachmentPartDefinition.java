package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.content.res.Resources;
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
import com.facebook.feed.rows.sections.attachments.linkshare.SidePhotoShareAttachmentPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.ui.LargeSquarePhotoShareAttachmentView;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
/* compiled from: fetch_aldrin_logged_out_status */
public class LargeSquarePhotoAttachmentPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, LargeSquarePhotoShareAttachmentView> {
    private static LargeSquarePhotoAttachmentPartDefinition f24197f;
    private static final Object f24198g = new Object();
    private final BaseShareAttachmentPartDefinition<E, LargeSquarePhotoShareAttachmentView> f24199a;
    private final int f24200b;
    private final int f24201c;
    private final SidePhotoShareAttachmentPartDefinition<E, LargeSquarePhotoShareAttachmentView> f24202d;
    private final FeedImageLoader f24203e;

    private static LargeSquarePhotoAttachmentPartDefinition m32547b(InjectorLike injectorLike) {
        return new LargeSquarePhotoAttachmentPartDefinition(BaseShareAttachmentPartDefinition.m32218a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike), SidePhotoShareAttachmentPartDefinition.m32363a(injectorLike), FeedImageLoader.m28808a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a(this.f24199a, feedProps);
        subParts.mo2756a(this.f24202d, new Props((GraphQLStoryAttachment) feedProps.f13444a, m32546b(feedProps)));
        return null;
    }

    public final boolean m32550a(Object obj) {
        boolean z;
        FeedProps feedProps = (FeedProps) obj;
        Flattenable flattenable = feedProps.f13444a;
        int b = m32546b(feedProps);
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        if (graphQLStoryAttachment.m23979r() == null) {
            z = false;
        } else {
            GraphQLImage a = FeedImageLoader.m28809a(graphQLStoryAttachment.m23979r(), b);
            z = a != null && a.mo2925c() >= b && a.mo2923a() >= b;
        }
        return z;
    }

    @Inject
    public LargeSquarePhotoAttachmentPartDefinition(BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, Resources resources, SidePhotoShareAttachmentPartDefinition sidePhotoShareAttachmentPartDefinition, FeedImageLoader feedImageLoader) {
        this.f24199a = baseShareAttachmentPartDefinition;
        this.f24202d = sidePhotoShareAttachmentPartDefinition;
        this.f24203e = feedImageLoader;
        this.f24200b = SizeUtil.m19197b(resources, 2131427518);
        this.f24201c = SizeUtil.m19197b(resources, 2131427520);
    }

    public static LargeSquarePhotoAttachmentPartDefinition m32545a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LargeSquarePhotoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24198g) {
                LargeSquarePhotoAttachmentPartDefinition largeSquarePhotoAttachmentPartDefinition;
                if (a2 != null) {
                    largeSquarePhotoAttachmentPartDefinition = (LargeSquarePhotoAttachmentPartDefinition) a2.mo818a(f24198g);
                } else {
                    largeSquarePhotoAttachmentPartDefinition = f24197f;
                }
                if (largeSquarePhotoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32547b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24198g, b3);
                        } else {
                            f24197f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = largeSquarePhotoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType<LargeSquarePhotoShareAttachmentView> mo2547a() {
        return LargeSquarePhotoShareAttachmentView.h;
    }

    private int m32546b(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStory c = AttachmentProps.m28714c(feedProps);
        return (c == null || !c.mo2895u()) ? this.f24200b : this.f24201c;
    }
}
