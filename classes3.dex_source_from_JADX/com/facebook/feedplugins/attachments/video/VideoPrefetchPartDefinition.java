package com.facebook.feedplugins.attachments.video;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.ui.feedprefetch.VideoPrefetchVisitorProvider;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.abtest.VideoPrefetchExperimentHelper;
import com.facebook.video.server.prefetcher.VideoPrefetchLocation;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: ufi/reactions/v2/84x84/love */
public class VideoPrefetchPartDefinition extends BaseSinglePartDefinition<Props, Void, HasFeedListType, View> {
    private static VideoPrefetchPartDefinition f103f;
    private static final Object f104g = new Object();
    private final VideoAutoPlaySettingsChecker f105a;
    private final Provider<TriState> f106b;
    private final AutoplayStateManagerProvider f107c;
    private final VideoPrefetchVisitorProvider f108d;
    private final VideoPrefetchExperimentHelper f109e;

    private static VideoPrefetchPartDefinition m102b(InjectorLike injectorLike) {
        return new VideoPrefetchPartDefinition(VideoPrefetchExperimentHelper.a(injectorLike), VideoAutoPlaySettingsChecker.a(injectorLike), IdBasedProvider.a(injectorLike, 669), (AutoplayStateManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class), (VideoPrefetchVisitorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoPrefetchVisitorProvider.class));
    }

    public final Object m103a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        Object obj2 = null;
        TracerDetour.a("VideoPrefetchPartDefinition.prepare", -42259750);
        try {
            VideoPrefetchLocation videoPrefetchLocation;
            FeedListName a = hasFeedListType.c().a();
            if (a.equals(FeedListName.PAGE_TIMELINE) || a.equals(FeedListName.MY_TIMELINE) || a.equals(FeedListName.OTHER_PERSON_TIMELINE)) {
                obj2 = 1;
            }
            if (a.equals(FeedListName.FEED)) {
                videoPrefetchLocation = VideoPrefetchLocation.NEWSFEED;
            } else if (obj2 != null) {
                videoPrefetchLocation = VideoPrefetchLocation.TIMELINE;
            } else if (a == FeedListName.VIDEO_CHANNEL) {
                videoPrefetchLocation = VideoPrefetchLocation.CHANNEL;
            } else if (this.f109e.e) {
                videoPrefetchLocation = VideoPrefetchLocation.MISC;
            } else {
                videoPrefetchLocation = null;
            }
            if (videoPrefetchLocation == null || !(this.f109e.d || this.f105a.a())) {
                TracerDetour.a(418258487);
            } else {
                if (props.c != -1) {
                    if (!((TriState) this.f106b.get()).asBoolean(false)) {
                        TracerDetour.a(1271326951);
                    } else if (props.c != 0) {
                        TracerDetour.a(-1536578145);
                    }
                }
                GraphQLStoryAttachment graphQLStoryAttachment = props.b;
                GraphQLMedia r = graphQLStoryAttachment.r();
                if (r == null) {
                    TracerDetour.a(930273930);
                } else {
                    GraphQLVideo b = GraphQLMediaConversionHelper.m236b(r);
                    if (b == null) {
                        TracerDetour.a(131239444);
                    } else {
                        this.f107c.a(AttachmentProps.e(props.a), b, Integer.valueOf(-1)).c();
                        this.f108d.a(videoPrefetchLocation, CallerContext.a(VideoPrefetchPartDefinition.class)).a(graphQLStoryAttachment);
                        TracerDetour.a(438415914);
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            TracerDetour.a(-1420751980);
        }
    }

    @Inject
    public VideoPrefetchPartDefinition(VideoPrefetchExperimentHelper videoPrefetchExperimentHelper, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, Provider<TriState> provider, AutoplayStateManagerProvider autoplayStateManagerProvider, VideoPrefetchVisitorProvider videoPrefetchVisitorProvider) {
        this.f109e = videoPrefetchExperimentHelper;
        this.f105a = videoAutoPlaySettingsChecker;
        this.f106b = provider;
        this.f107c = autoplayStateManagerProvider;
        this.f108d = videoPrefetchVisitorProvider;
    }

    public static VideoPrefetchPartDefinition m101a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoPrefetchPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f104g) {
                VideoPrefetchPartDefinition videoPrefetchPartDefinition;
                if (a2 != null) {
                    videoPrefetchPartDefinition = (VideoPrefetchPartDefinition) a2.a(f104g);
                } else {
                    videoPrefetchPartDefinition = f103f;
                }
                if (videoPrefetchPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m102b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f104g, b3);
                        } else {
                            f103f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoPrefetchPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
