package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.ui.ImageShareAttachmentView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.StoryAttachmentUtil;
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
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ZZZZZZ */
public class ImageShareAttachmentPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, ImageShareAttachmentView> {
    public static final ViewType f20598a = new C17701();
    private static final PaddingStyle f20599b = PaddingStyle.a;
    private static ImageShareAttachmentPartDefinition f20600i;
    private static final Object f20601j = new Object();
    private final BackgroundPartDefinition f20602c;
    private final StoryAttachmentUtil f20603d;
    private final AttachmentLinkPartDefinition<E> f20604e;
    private final TextOrHiddenPartDefinition f20605f;
    private final StaticImagePartDefinition f20606g;
    private final AnimatedImagePartDefinition f20607h;

    /* compiled from: ZZZZZZ */
    final class C17701 extends ViewType {
        C17701() {
        }

        public final View m23637a(Context context) {
            return new ImageShareAttachmentView(context);
        }
    }

    private static ImageShareAttachmentPartDefinition m23640b(InjectorLike injectorLike) {
        return new ImageShareAttachmentPartDefinition(BackgroundPartDefinition.a(injectorLike), StoryAttachmentUtil.a(injectorLike), AttachmentLinkPartDefinition.a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike), StaticImagePartDefinition.m23772a(injectorLike), AnimatedImagePartDefinition.m23574a(injectorLike));
    }

    public final Object m23642a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(2131563058, this.f20605f, StoryAttachmentUtil.a(graphQLStoryAttachment));
        subParts.a(this.f20602c, new StylingData(AttachmentProps.e(feedProps), f20599b, 2130840170, -1));
        subParts.a(this.f20604e, new Props(feedProps));
        if (ImageShareUtil.m23647b(graphQLStoryAttachment) == null) {
            subParts.a(this.f20606g, graphQLStoryAttachment);
        } else {
            subParts.a(this.f20607h, feedProps);
        }
        return null;
    }

    public static ImageShareAttachmentPartDefinition m23638a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ImageShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20601j) {
                ImageShareAttachmentPartDefinition imageShareAttachmentPartDefinition;
                if (a2 != null) {
                    imageShareAttachmentPartDefinition = (ImageShareAttachmentPartDefinition) a2.a(f20601j);
                } else {
                    imageShareAttachmentPartDefinition = f20600i;
                }
                if (imageShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23640b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20601j, b3);
                        } else {
                            f20600i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = imageShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ImageShareAttachmentPartDefinition(BackgroundPartDefinition backgroundPartDefinition, StoryAttachmentUtil storyAttachmentUtil, AttachmentLinkPartDefinition attachmentLinkPartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition, StaticImagePartDefinition staticImagePartDefinition, AnimatedImagePartDefinition animatedImagePartDefinition) {
        this.f20602c = backgroundPartDefinition;
        this.f20603d = storyAttachmentUtil;
        this.f20604e = attachmentLinkPartDefinition;
        this.f20605f = textOrHiddenPartDefinition;
        this.f20606g = staticImagePartDefinition;
        this.f20607h = animatedImagePartDefinition;
    }

    public final ViewType m23641a() {
        return f20598a;
    }

    public static boolean m23639a(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        return (ImageShareUtil.m23646a(graphQLStoryAttachment) == null || ImageShareUtil.m23647b(graphQLStoryAttachment) == null) ? false : true;
    }
}
