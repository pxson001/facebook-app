package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
/* compiled from: hit_time_ms */
public class PhotoAttachmentSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static PhotoAttachmentSelector f20988f;
    private static final Object f20989g = new Object();
    private final PhotoAttachmentWithWarningsPartDefinition<FeedEnvironment> f20990a;
    private final ObjectionableContentPhotoAttachmentPartDefinition<FeedEnvironment> f20991b;
    private final SphericalPhotoAttachmentPartDefinition<FeedEnvironment> f20992c;
    private final PhotoAttachmentPartDefinition<FeedEnvironment> f20993d;
    private final LivePhotoAttachmentPartDefinition<FeedEnvironment> f20994e;

    private static PhotoAttachmentSelector m28720b(InjectorLike injectorLike) {
        return new PhotoAttachmentSelector(PhotoAttachmentPartDefinition.m28723a(injectorLike), PhotoAttachmentWithWarningsPartDefinition.m28778a(injectorLike), ObjectionableContentPhotoAttachmentPartDefinition.m28788a(injectorLike), SphericalPhotoAttachmentPartDefinition.m28798a(injectorLike), LivePhotoAttachmentPartDefinition.m28853a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        SubPartsSelector a = SubPartsSelector.m19114a(baseMultiRowSubParts, this.f20990a, obj);
        if (feedEnvironment.mo2446c().mo2419a() == FeedListName.FEED) {
            a.m19118a(this.f20991b, obj);
        }
        a.m19118a(this.f20994e, obj);
        a.m19118a(this.f20992c, obj);
        a.m19118a(this.f20993d, obj);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).f13444a;
        return (graphQLStoryAttachment.m23979r() == null || graphQLStoryAttachment.m23979r().m24440S() == null) ? false : true;
    }

    @Inject
    public PhotoAttachmentSelector(PhotoAttachmentPartDefinition photoAttachmentPartDefinition, PhotoAttachmentWithWarningsPartDefinition photoAttachmentWithWarningsPartDefinition, ObjectionableContentPhotoAttachmentPartDefinition objectionableContentPhotoAttachmentPartDefinition, SphericalPhotoAttachmentPartDefinition sphericalPhotoAttachmentPartDefinition, LivePhotoAttachmentPartDefinition livePhotoAttachmentPartDefinition) {
        this.f20990a = photoAttachmentWithWarningsPartDefinition;
        this.f20991b = objectionableContentPhotoAttachmentPartDefinition;
        this.f20993d = photoAttachmentPartDefinition;
        this.f20992c = sphericalPhotoAttachmentPartDefinition;
        this.f20994e = livePhotoAttachmentPartDefinition;
    }

    public static PhotoAttachmentSelector m28719a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotoAttachmentSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20989g) {
                PhotoAttachmentSelector photoAttachmentSelector;
                if (a2 != null) {
                    photoAttachmentSelector = (PhotoAttachmentSelector) a2.mo818a(f20989g);
                } else {
                    photoAttachmentSelector = f20988f;
                }
                if (photoAttachmentSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28720b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20989g, b3);
                        } else {
                            f20988f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = photoAttachmentSelector;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
