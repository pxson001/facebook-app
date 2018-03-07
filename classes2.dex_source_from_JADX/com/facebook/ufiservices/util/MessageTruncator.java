package com.facebook.ufiservices.util;

import android.content.Context;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.framework.QuickExperimentControllerImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.friendsharing.text.abtest.FeedTextSizeExperimentHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.ufiservices.qe.PerAttachmentMessageTruncatorQuickExperiment;
import com.facebook.ufiservices.qe.PerAttachmentMessageTruncatorQuickExperiment.AttachmentType;
import com.facebook.ufiservices.qe.PerAttachmentMessageTruncatorQuickExperiment.Config;
import com.google.common.collect.ImmutableList;
import java.lang.Character.UnicodeBlock;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friending_possibilities?location=%s */
public class MessageTruncator {
    private static MessageTruncator f23100f;
    private static final Object f23101g = new Object();
    private final PerAttachmentMessageTruncatorQuickExperiment f23102a;
    public final Config f23103b = ((Config) this.f23105d.mo1436a(this.f23102a));
    private Context f23104c;
    private final QuickExperimentController f23105d;
    private final FeedTextSizeExperimentHelper f23106e;

    private static MessageTruncator m31229b(InjectorLike injectorLike) {
        return new MessageTruncator((Context) injectorLike.getInstance(Context.class), QuickExperimentControllerImpl.m10166a(injectorLike), new PerAttachmentMessageTruncatorQuickExperiment((Context) injectorLike.getInstance(Context.class)), FeedTextSizeExperimentHelper.m28684a(injectorLike));
    }

    public static MessageTruncator m31227a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MessageTruncator b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23101g) {
                MessageTruncator messageTruncator;
                if (a2 != null) {
                    messageTruncator = (MessageTruncator) a2.mo818a(f23101g);
                } else {
                    messageTruncator = f23100f;
                }
                if (messageTruncator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31229b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23101g, b3);
                        } else {
                            f23100f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = messageTruncator;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public MessageTruncator(Context context, QuickExperimentController quickExperimentController, PerAttachmentMessageTruncatorQuickExperiment perAttachmentMessageTruncatorQuickExperiment, FeedTextSizeExperimentHelper feedTextSizeExperimentHelper) {
        this.f23104c = context;
        this.f23105d = quickExperimentController;
        this.f23102a = perAttachmentMessageTruncatorQuickExperiment;
        this.f23106e = feedTextSizeExperimentHelper;
    }

    public final int m31230a(CharSequence charSequence, FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        this.f23105d.mo1437b(this.f23102a);
        if (this.f23106e.m28692a(graphQLStory) && this.f23106e.m28694c(graphQLStory) != -1) {
            return this.f23106e.m28694c(graphQLStory);
        }
        boolean z = StoryAttachmentHelper.m28029a(graphQLStory) || graphQLStory.m22326L() != null;
        if (!this.f23103b.f23108a) {
            return m31231a(charSequence, z);
        }
        int b = m31228b((FeedProps) feedProps);
        if (b != -1) {
            return b;
        }
        return m31231a(charSequence, z);
    }

    private int m31228b(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (StoryProps.m27456c(feedProps) != null) {
            AttachmentType attachmentType;
            Config config = this.f23103b;
            if (graphQLStory.mo2895u()) {
                attachmentType = AttachmentType.IS_SPONSORED_NESTED_STORY;
            } else {
                attachmentType = AttachmentType.IS_NESTED_STORY;
            }
            return config.m31234a(attachmentType);
        } else if (graphQLStory.m22326L() != null) {
            return this.f23103b.m31234a(graphQLStory.mo2895u() ? AttachmentType.SPONSORED_WITH_NESTED_STORY : AttachmentType.WITH_NESTED_STORY);
        } else if (!StoryAttachmentHelper.m28029a(graphQLStory)) {
            return -1;
        } else {
            int a;
            if (StoryAttachmentHelper.m28032c(graphQLStory)) {
                AttachmentType attachmentType2;
                Config config2 = this.f23103b;
                if (graphQLStory.mo2895u()) {
                    attachmentType2 = AttachmentType.SPONSORED_PHOTO;
                } else {
                    attachmentType2 = AttachmentType.PHOTO;
                }
                a = config2.m31234a(attachmentType2);
            } else if (StoryAttachmentHelper.m28030b(graphQLStory) && !StoryAttachmentHelper.m28032c(graphQLStory)) {
                a = this.f23103b.m31234a(graphQLStory.mo2895u() ? AttachmentType.SPONSORED_ALBUM : AttachmentType.ALBUM);
            } else if (StoryAttachmentHelper.m28037j(graphQLStory)) {
                a = this.f23103b.m31234a(graphQLStory.mo2895u() ? AttachmentType.SPONSORED_VIDEO : AttachmentType.VIDEO);
            } else if (StoryAttachmentHelper.m28034g(graphQLStory)) {
                a = this.f23103b.m31234a(graphQLStory.mo2895u() ? AttachmentType.SPONSORED_EXTERNAL_URL : AttachmentType.EXTERNAL_URL);
            } else {
                Object obj;
                ImmutableList M = graphQLStory.m22327M();
                if (!(M == null || M.isEmpty())) {
                    ImmutableList M2 = graphQLStory.m22327M();
                    int size = M2.size();
                    for (int i = 0; i < size; i++) {
                        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) M2.get(i);
                        if (graphQLStoryAttachment != null && GraphQLStoryAttachmentUtil.m28060k(graphQLStoryAttachment)) {
                            obj = 1;
                            break;
                        }
                    }
                }
                obj = null;
                if (obj != null) {
                    a = this.f23103b.m31234a(graphQLStory.mo2895u() ? AttachmentType.SPONSORED_PAGE : AttachmentType.PAGE);
                } else {
                    a = -1;
                }
            }
            return a;
        }
    }

    public final int m31231a(CharSequence charSequence, boolean z) {
        String charSequence2 = charSequence.toString();
        Object obj = null;
        int length = (int) (((double) charSequence2.length()) * 0.5d);
        int i = 0;
        for (int i2 = 0; i2 < charSequence2.length(); i2++) {
            Object obj2;
            UnicodeBlock of = UnicodeBlock.of(charSequence2.charAt(i2));
            if (of == UnicodeBlock.BASIC_LATIN || of == UnicodeBlock.LATIN_1_SUPPLEMENT || of == UnicodeBlock.LATIN_EXTENDED_A || of == UnicodeBlock.LATIN_EXTENDED_B) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                i++;
                if (i > length) {
                    obj = 1;
                    break;
                }
            }
        }
        if (obj == null) {
            return 150;
        }
        if (!z) {
            return 650;
        }
        switch (this.f23104c.getResources().getConfiguration().screenLayout & 15) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return 350;
            default:
                return 350;
        }
    }
}
