package com.facebook.feedplugins.video;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.video.components.RichVideoRowComponentPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ufi/reactions/v2/24x24/haha */
public class VideoAttachmentsSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static VideoAttachmentsSelectorPartDefinition f145j;
    private static final Object f146k = new Object();
    public final AbstractFbErrorReporter f147a;
    private final InlineVideoDirectResponseAttachmentPartDefinition<FeedEnvironment> f148b;
    private final FullscreenVideoAttachmentPartDefinition<FeedEnvironment> f149c;
    private final Inline360VideoAttachmentPartDefinition<FeedEnvironment> f150d;
    private final InlineVideoAttachmentPartDefinition<FeedEnvironment> f151e;
    private final RichVideoRowPartDefinition<FeedEnvironment> f152f;
    private final RichVideoDirectResponseAttachmentPartDefinition<FeedEnvironment> f153g;
    private final VideoPartDefinition f154h;
    private final RichVideoRowComponentPartDefinition f155i;

    private static VideoAttachmentsSelectorPartDefinition m141b(InjectorLike injectorLike) {
        return new VideoAttachmentsSelectorPartDefinition(VideoPartDefinition.m145a(injectorLike), InlineVideoAttachmentPartDefinition.m153a(injectorLike), RichVideoRowPartDefinition.m176a(injectorLike), Inline360VideoAttachmentPartDefinition.m183a(injectorLike), FullscreenVideoAttachmentPartDefinition.m200a(injectorLike), InlineVideoDirectResponseAttachmentPartDefinition.m212a(injectorLike), RichVideoDirectResponseAttachmentPartDefinition.m218a(injectorLike), RichVideoRowComponentPartDefinition.m229a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public final Object m142a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f154h, GraphQLMediaConversionHelper.m236b(((GraphQLStoryAttachment) feedProps.a).r())).a(this.f153g, feedProps).a(this.f148b, feedProps).a(this.f155i, feedProps).a(this.f152f, feedProps).a(this.f150d, feedProps).a(this.f151e, feedProps).a(this.f149c, feedProps);
        return null;
    }

    @Inject
    public VideoAttachmentsSelectorPartDefinition(VideoPartDefinition videoPartDefinition, InlineVideoAttachmentPartDefinition inlineVideoAttachmentPartDefinition, RichVideoRowPartDefinition richVideoRowPartDefinition, Inline360VideoAttachmentPartDefinition inline360VideoAttachmentPartDefinition, FullscreenVideoAttachmentPartDefinition fullscreenVideoAttachmentPartDefinition, InlineVideoDirectResponseAttachmentPartDefinition inlineVideoDirectResponseAttachmentPartDefinition, RichVideoDirectResponseAttachmentPartDefinition richVideoDirectResponseAttachmentPartDefinition, RichVideoRowComponentPartDefinition richVideoRowComponentPartDefinition, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f147a = abstractFbErrorReporter;
        this.f148b = inlineVideoDirectResponseAttachmentPartDefinition;
        this.f152f = richVideoRowPartDefinition;
        this.f153g = richVideoDirectResponseAttachmentPartDefinition;
        this.f149c = fullscreenVideoAttachmentPartDefinition;
        this.f150d = inline360VideoAttachmentPartDefinition;
        this.f151e = inlineVideoAttachmentPartDefinition;
        this.f154h = videoPartDefinition;
        this.f155i = richVideoRowComponentPartDefinition;
    }

    public static VideoAttachmentsSelectorPartDefinition m140a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoAttachmentsSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f146k) {
                VideoAttachmentsSelectorPartDefinition videoAttachmentsSelectorPartDefinition;
                if (a2 != null) {
                    videoAttachmentsSelectorPartDefinition = (VideoAttachmentsSelectorPartDefinition) a2.a(f146k);
                } else {
                    videoAttachmentsSelectorPartDefinition = f145j;
                }
                if (videoAttachmentsSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m141b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f146k, b3);
                        } else {
                            f145j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoAttachmentsSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m143a(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (graphQLStoryAttachment.r() != null && graphQLStoryAttachment.r().j() != null && graphQLStoryAttachment.r().j().g() == 82650203 && !Strings.isNullOrEmpty(graphQLStoryAttachment.r().aO())) {
            return true;
        }
        GraphQLStory c = AttachmentProps.c(feedProps);
        AbstractFbErrorReporter abstractFbErrorReporter = this.f147a;
        String str = "FullscreenVideoAttachmentPartDefinition";
        String str2 = "Unexpected null video with zombie: %s";
        Object[] objArr = new Object[1];
        objArr[0] = c != null ? c.S_() : null;
        abstractFbErrorReporter.a(SoftError.a(str, StringLocaleUtil.a(str2, objArr)).g());
        return false;
    }
}
