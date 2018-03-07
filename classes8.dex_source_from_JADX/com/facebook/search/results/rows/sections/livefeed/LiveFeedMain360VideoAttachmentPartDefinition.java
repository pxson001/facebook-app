package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import com.facebook.attachments.videos.ui.Inline360VideoAttachmentView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ViewPaddingPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition.PaddingData;
import com.facebook.video.abtest.Video360PlayerConfig;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PmaColdStartFirstRunSequence */
public class LiveFeedMain360VideoAttachmentPartDefinition<E extends HasPositionInformation & HasFeedListType & HasPersistentState & HasInvalidate & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, Inline360VideoAttachmentView> {
    public static final ViewType<Inline360VideoAttachmentView> f24476a = new C25861();
    private static LiveFeedMain360VideoAttachmentPartDefinition f24477f;
    private static final Object f24478g = new Object();
    private final Video360PlayerConfig f24479b;
    private final Resources f24480c;
    private final ViewPaddingPartDefinition f24481d;
    private final LiveFeed360VideoAttachmentPartDefinition<E> f24482e;

    /* compiled from: PmaColdStartFirstRunSequence */
    final class C25861 extends ViewType {
        C25861() {
        }

        public final View m27938a(Context context) {
            return new Inline360VideoAttachmentView(context);
        }
    }

    private static LiveFeedMain360VideoAttachmentPartDefinition m27940b(InjectorLike injectorLike) {
        return new LiveFeedMain360VideoAttachmentPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), ViewPaddingPartDefinition.a(injectorLike), LiveFeed360VideoAttachmentPartDefinition.m27905a(injectorLike), Video360PlayerConfig.b(injectorLike));
    }

    public final Object m27942a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24482e, (FeedProps) obj);
        int dimensionPixelSize = this.f24480c.getDimensionPixelSize(2131432592);
        subParts.a(this.f24481d, new PaddingData(this.f24480c.getDimensionPixelSize(2131432588), dimensionPixelSize, this.f24480c.getDimensionPixelSize(2131432589), dimensionPixelSize));
        return null;
    }

    public final boolean m27943a(Object obj) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) ((FeedProps) obj).a);
        return VERSION.SDK_INT >= 18 && o != null && !o.q() && o.r() != null && o.r().ap() && this.f24479b.e;
    }

    @Inject
    public LiveFeedMain360VideoAttachmentPartDefinition(Resources resources, ViewPaddingPartDefinition viewPaddingPartDefinition, LiveFeed360VideoAttachmentPartDefinition liveFeed360VideoAttachmentPartDefinition, Video360PlayerConfig video360PlayerConfig) {
        this.f24480c = resources;
        this.f24481d = viewPaddingPartDefinition;
        this.f24482e = liveFeed360VideoAttachmentPartDefinition;
        this.f24479b = video360PlayerConfig;
    }

    public static LiveFeedMain360VideoAttachmentPartDefinition m27939a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiveFeedMain360VideoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24478g) {
                LiveFeedMain360VideoAttachmentPartDefinition liveFeedMain360VideoAttachmentPartDefinition;
                if (a2 != null) {
                    liveFeedMain360VideoAttachmentPartDefinition = (LiveFeedMain360VideoAttachmentPartDefinition) a2.a(f24478g);
                } else {
                    liveFeedMain360VideoAttachmentPartDefinition = f24477f;
                }
                if (liveFeedMain360VideoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27940b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24478g, b3);
                        } else {
                            f24477f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liveFeedMain360VideoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<Inline360VideoAttachmentView> m27941a() {
        return f24476a;
    }
}
