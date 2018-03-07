package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: at_work_app/ */
public class VideoSetsTextExtractor {
    private static VideoSetsTextExtractor f9817b;
    private static final Object f9818c = new Object();
    public final LegacyAngoraAttachmentUtil f9819a;

    /* compiled from: at_work_app/ */
    public class GenericLabel {
        public CharSequence f9814a;
        public CharSequence f9815b;
        public CharSequence f9816c;

        public GenericLabel() {
            this("", "");
        }

        private GenericLabel(CharSequence charSequence, CharSequence charSequence2) {
            this.f9814a = charSequence;
            this.f9815b = charSequence2;
        }
    }

    private static VideoSetsTextExtractor m10232b(InjectorLike injectorLike) {
        return new VideoSetsTextExtractor(LegacyAngoraAttachmentUtil.a(injectorLike));
    }

    @Inject
    public VideoSetsTextExtractor(LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil) {
        this.f9819a = legacyAngoraAttachmentUtil;
    }

    public static VideoSetsTextExtractor m10231a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoSetsTextExtractor b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9818c) {
                VideoSetsTextExtractor videoSetsTextExtractor;
                if (a2 != null) {
                    videoSetsTextExtractor = (VideoSetsTextExtractor) a2.a(f9818c);
                } else {
                    videoSetsTextExtractor = f9817b;
                }
                if (videoSetsTextExtractor == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10232b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9818c, b3);
                        } else {
                            f9817b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoSetsTextExtractor;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final GenericLabel m10233a(FeedProps<GraphQLStoryAttachment> feedProps) {
        if (feedProps.a == null) {
            return new GenericLabel();
        }
        CharSequence charSequence;
        String str;
        GenericLabel genericLabel = new GenericLabel();
        if (feedProps.a == null) {
            charSequence = null;
        } else {
            charSequence = this.f9819a.a((GraphQLStoryAttachment) feedProps.a);
            if (TextUtils.isEmpty(charSequence)) {
                if (AttachmentProps.c(feedProps) == null) {
                    charSequence = null;
                } else {
                    GraphQLTextWithEntities b = StoryHierarchyHelper.b(AttachmentProps.c(feedProps));
                    if (!(b == null || b.a() == null)) {
                        charSequence = b.a();
                    }
                }
            }
        }
        CharSequence charSequence2 = charSequence;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (graphQLStoryAttachment == null || graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().F() == null || graphQLStoryAttachment.r().F().b().isEmpty() || ((GraphQLActor) graphQLStoryAttachment.r().F().b().get(0)).aa() == null) {
            str = "";
        } else {
            str = ((GraphQLActor) graphQLStoryAttachment.r().F().b().get(0)).aa();
        }
        String str2 = str;
        if (TextUtils.isEmpty(charSequence2)) {
            genericLabel.f9814a = str2;
            return genericLabel;
        }
        genericLabel.f9814a = charSequence2;
        genericLabel.f9815b = str2;
        return genericLabel;
    }
}
