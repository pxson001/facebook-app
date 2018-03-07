package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.SubStoriesGroupPartDefinition.Callbacks;
import com.facebook.feed.rows.sections.SubStoriesGroupPartDefinition.Props;
import com.facebook.feed.rows.sections.header.DefaultHeaderSelectorPartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BlingBarSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.stickers.StickerRootPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ^bytes (\d+)-(\d+)/(\d+)$ */
public class FeedSubStoriesPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static FeedSubStoriesPartDefinition f20370h;
    private static final Object f20371i = new Object();
    private final SubStoriesGroupPartDefinition f20372a;
    public final DefaultHeaderSelectorPartDefinition f20373b;
    public final StickerRootPartDefinition<FeedEnvironment> f20374c;
    public final ContentTextPartDefinition f20375d;
    public final AttachmentsPartDefinition f20376e;
    public final LimitedAttachedStoryPartDefinition f20377f;
    public final BlingBarSelectorPartDefinition f20378g;

    /* compiled from: ^bytes (\d+)-(\d+)/(\d+)$ */
    public class C17571 implements Callbacks {
        final /* synthetic */ FeedSubStoriesPartDefinition f20369a;

        public C17571(FeedSubStoriesPartDefinition feedSubStoriesPartDefinition) {
            this.f20369a = feedSubStoriesPartDefinition;
        }

        public final void mo1482a(MultiRowSubParts<FeedEnvironment> multiRowSubParts, FeedProps<GraphQLStory> feedProps) {
            multiRowSubParts.a(this.f20369a.f20373b, feedProps);
            multiRowSubParts.a(this.f20369a.f20374c, feedProps);
            multiRowSubParts.a(this.f20369a.f20375d, feedProps);
            multiRowSubParts.a(this.f20369a.f20376e, feedProps);
            multiRowSubParts.a(this.f20369a.f20377f, feedProps);
            multiRowSubParts.a(this.f20369a.f20378g, feedProps);
        }
    }

    private static FeedSubStoriesPartDefinition m23496b(InjectorLike injectorLike) {
        return new FeedSubStoriesPartDefinition(DefaultHeaderSelectorPartDefinition.a(injectorLike), StickerRootPartDefinition.a(injectorLike), ContentTextPartDefinition.a(injectorLike), AttachmentsPartDefinition.a(injectorLike), LimitedAttachedStoryPartDefinition.a(injectorLike), BlingBarSelectorPartDefinition.a(injectorLike), SubStoriesGroupPartDefinition.m23536a(injectorLike));
    }

    public final Object m23497a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f20372a, new Props((FeedProps) obj, new C17571(this)));
        return null;
    }

    public final boolean m23498a(Object obj) {
        return SubStoriesGroupPartDefinition.m23537a((GraphQLStory) ((FeedProps) obj).a);
    }

    @Inject
    public FeedSubStoriesPartDefinition(DefaultHeaderSelectorPartDefinition defaultHeaderSelectorPartDefinition, StickerRootPartDefinition stickerRootPartDefinition, ContentTextPartDefinition contentTextPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, LimitedAttachedStoryPartDefinition limitedAttachedStoryPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, SubStoriesGroupPartDefinition subStoriesGroupPartDefinition) {
        this.f20373b = defaultHeaderSelectorPartDefinition;
        this.f20374c = stickerRootPartDefinition;
        this.f20375d = contentTextPartDefinition;
        this.f20376e = attachmentsPartDefinition;
        this.f20377f = limitedAttachedStoryPartDefinition;
        this.f20378g = blingBarSelectorPartDefinition;
        this.f20372a = subStoriesGroupPartDefinition;
    }

    public static FeedSubStoriesPartDefinition m23495a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedSubStoriesPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20371i) {
                FeedSubStoriesPartDefinition feedSubStoriesPartDefinition;
                if (a2 != null) {
                    feedSubStoriesPartDefinition = (FeedSubStoriesPartDefinition) a2.a(f20371i);
                } else {
                    feedSubStoriesPartDefinition = f20370h;
                }
                if (feedSubStoriesPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23496b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20371i, b3);
                        } else {
                            f20370h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = feedSubStoriesPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
