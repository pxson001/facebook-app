package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props;
import com.facebook.feedplugins.storyset.rows.ui.StoryPageWithPhotoView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: key DESC */
public class StorySetPhotoPageRootPartDefinition<E extends CanLikePage & HasContext & HasFeedListType & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey & HasIsAsync> extends BaseSinglePartDefinitionWithViewType<StorySetPageProps, Void, E, StoryPageWithPhotoView> {
    public static final StoryPageWithPhotoViewType f18514a = new StoryPageWithPhotoViewType();
    private static StorySetPhotoPageRootPartDefinition f18515e;
    private static final Object f18516f = new Object();
    private final StorySetAttachmentImagePartDefinition f18517b;
    private final StorySetBasicPagePartDefinition<E> f18518c;
    private final AttachmentLinkPartDefinition f18519d;

    /* compiled from: key DESC */
    class StoryPageWithPhotoViewType extends StorySetEmbededHeaderViewType<StoryPageWithPhotoView> {
        public final View mo1995a(Context context) {
            return (StoryPageWithPhotoView) m26000a(new StoryPageWithPhotoView(context));
        }
    }

    private static StorySetPhotoPageRootPartDefinition m25992b(InjectorLike injectorLike) {
        return new StorySetPhotoPageRootPartDefinition(StorySetBasicPagePartDefinition.a(injectorLike), AttachmentLinkPartDefinition.m32226a(injectorLike), StorySetAttachmentImagePartDefinition.a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        StorySetPageProps storySetPageProps = (StorySetPageProps) obj;
        FeedProps i = StoryProps.m27461i(storySetPageProps.b);
        subParts.mo2756a(this.f18518c, new StorySetPageProps(storySetPageProps.a, storySetPageProps.c, storySetPageProps.d, true));
        subParts.mo2755a(2131567724, this.f18517b, i.f13444a);
        subParts.mo2755a(2131567724, this.f18519d, new Props(i));
        return null;
    }

    public static StorySetPhotoPageRootPartDefinition m25991a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetPhotoPageRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18516f) {
                StorySetPhotoPageRootPartDefinition storySetPhotoPageRootPartDefinition;
                if (a2 != null) {
                    storySetPhotoPageRootPartDefinition = (StorySetPhotoPageRootPartDefinition) a2.mo818a(f18516f);
                } else {
                    storySetPhotoPageRootPartDefinition = f18515e;
                }
                if (storySetPhotoPageRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25992b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18516f, b3);
                        } else {
                            f18515e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetPhotoPageRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public StorySetPhotoPageRootPartDefinition(StorySetBasicPagePartDefinition storySetBasicPagePartDefinition, AttachmentLinkPartDefinition attachmentLinkPartDefinition, StorySetAttachmentImagePartDefinition storySetAttachmentImagePartDefinition) {
        this.f18518c = storySetBasicPagePartDefinition;
        this.f18517b = storySetAttachmentImagePartDefinition;
        this.f18519d = attachmentLinkPartDefinition;
    }

    public final ViewType<StoryPageWithPhotoView> mo2547a() {
        f18514a.f18520a = this.f18518c.a();
        return f18514a;
    }
}
