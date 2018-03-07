package com.facebook.feedplugins.video;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import com.facebook.attachments.videos.ui.Inline360VideoAttachmentView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.Inline360VideoPartDefinition;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.video.abtest.Video360PlayerConfig;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: ufi/reactions/v2/16x16/haha */
public class Inline360VideoAttachmentPartDefinition<E extends HasPositionInformation & HasFeedListType & HasPersistentState & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, Inline360VideoAttachmentView> {
    public static final ViewType f200a = new C00041();
    private static Inline360VideoAttachmentPartDefinition f201e;
    private static final Object f202f = new Object();
    private final Video360PlayerConfig f203b;
    private final VideoAttachmentBackgroundPartDefinition<E> f204c;
    private final Inline360VideoPartDefinition<E> f205d;

    /* compiled from: ufi/reactions/v2/16x16/haha */
    final class C00041 extends ViewType {
        C00041() {
        }

        public final View m190a(Context context) {
            return new Inline360VideoAttachmentView(context);
        }
    }

    private static Inline360VideoAttachmentPartDefinition m184b(InjectorLike injectorLike) {
        return new Inline360VideoAttachmentPartDefinition(IdBasedProvider.a(injectorLike, 3634), VideoAttachmentBackgroundPartDefinition.m162a(injectorLike), Inline360VideoPartDefinition.m192a(injectorLike));
    }

    public final Object m187a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        Flattenable flattenable = feedProps.a;
        subParts.a(this.f204c, feedProps);
        subParts.a(this.f205d, feedProps);
        return null;
    }

    @Inject
    public Inline360VideoAttachmentPartDefinition(Provider<Video360PlayerConfig> provider, VideoAttachmentBackgroundPartDefinition videoAttachmentBackgroundPartDefinition, Inline360VideoPartDefinition inline360VideoPartDefinition) {
        this.f203b = (Video360PlayerConfig) provider.get();
        this.f204c = videoAttachmentBackgroundPartDefinition;
        this.f205d = inline360VideoPartDefinition;
    }

    public final ViewType m186a() {
        return f200a;
    }

    public static Inline360VideoAttachmentPartDefinition m183a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            Inline360VideoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f202f) {
                Inline360VideoAttachmentPartDefinition inline360VideoAttachmentPartDefinition;
                if (a2 != null) {
                    inline360VideoAttachmentPartDefinition = (Inline360VideoAttachmentPartDefinition) a2.a(f202f);
                } else {
                    inline360VideoAttachmentPartDefinition = f201e;
                }
                if (inline360VideoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m184b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f202f, b3);
                        } else {
                            f201e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = inline360VideoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static boolean m185b(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        return graphQLStoryAttachment.r() != null && graphQLStoryAttachment.r().ap();
    }

    public final boolean m188a(FeedProps<GraphQLStoryAttachment> feedProps) {
        return VERSION.SDK_INT >= 18 && !((GraphQLStoryAttachment) feedProps.a).q() && m185b((FeedProps) feedProps) && this.f203b.e;
    }
}
