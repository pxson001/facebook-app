package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.facebook.ui.emoji.EmojiUtil;
import javax.inject.Inject;

@ContextScoped
/* compiled from: accessToken */
public class PhotosFeedAttachmentTextBuilder {
    private static PhotosFeedAttachmentTextBuilder f20133c;
    private static final Object f20134d = new Object();
    private final EmojiUtil f20135a;
    public final LinkifyUtil f20136b;

    private static PhotosFeedAttachmentTextBuilder m23290b(InjectorLike injectorLike) {
        return new PhotosFeedAttachmentTextBuilder(LinkifyUtil.a(injectorLike), EmojiUtil.a(injectorLike));
    }

    @Inject
    public PhotosFeedAttachmentTextBuilder(LinkifyUtil linkifyUtil, EmojiUtil emojiUtil) {
        this.f20136b = linkifyUtil;
        this.f20135a = emojiUtil;
    }

    public final Spannable m23291a(GraphQLTextWithEntities graphQLTextWithEntities, int i) {
        CharSequence charSequence;
        if (graphQLTextWithEntities.b() != null) {
            String str;
            if (graphQLTextWithEntities == null) {
                str = "";
            } else {
                str = this.f20136b.a(LinkifyUtilConverter.b(graphQLTextWithEntities), null, null, null);
            }
            charSequence = str;
        } else {
            charSequence = graphQLTextWithEntities.a();
        }
        Spannable spannableStringBuilder = new SpannableStringBuilder(charSequence);
        this.f20135a.a(spannableStringBuilder, i);
        return spannableStringBuilder;
    }

    public static PhotosFeedAttachmentTextBuilder m23289a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedAttachmentTextBuilder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20134d) {
                PhotosFeedAttachmentTextBuilder photosFeedAttachmentTextBuilder;
                if (a2 != null) {
                    photosFeedAttachmentTextBuilder = (PhotosFeedAttachmentTextBuilder) a2.a(f20134d);
                } else {
                    photosFeedAttachmentTextBuilder = f20133c;
                }
                if (photosFeedAttachmentTextBuilder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23290b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20134d, b3);
                        } else {
                            f20133c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedAttachmentTextBuilder;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
