package com.facebook.feed.rows.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.SubStoriesGroupPartDefinition;
import com.facebook.feed.rows.sections.SubStoriesGroupPartDefinition.Callbacks;
import com.facebook.feed.rows.sections.SubStoriesGroupPartDefinition.Props;
import com.facebook.feed.rows.sections.header.DefaultHeaderSelectorPartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BlingBarSelectorPartDefinition;
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
/* compiled from: activity_tag_picker */
public class PermalinkSubStoriesPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static PermalinkSubStoriesPartDefinition f19954g;
    private static final Object f19955h = new Object();
    private final SubStoriesGroupPartDefinition f19956a;
    public final DefaultHeaderSelectorPartDefinition f19957b;
    public final ContentTextPartDefinition f19958c;
    public final AttachmentsPartDefinition f19959d;
    public final PermalinkAttachedStoryPartDefinition f19960e;
    public final BlingBarSelectorPartDefinition f19961f;

    /* compiled from: activity_tag_picker */
    public class C17281 implements Callbacks {
        final /* synthetic */ PermalinkSubStoriesPartDefinition f19953a;

        public C17281(PermalinkSubStoriesPartDefinition permalinkSubStoriesPartDefinition) {
            this.f19953a = permalinkSubStoriesPartDefinition;
        }

        public final void mo1482a(MultiRowSubParts<FeedEnvironment> multiRowSubParts, FeedProps<GraphQLStory> feedProps) {
            multiRowSubParts.a(this.f19953a.f19957b, feedProps);
            multiRowSubParts.a(this.f19953a.f19958c, feedProps);
            multiRowSubParts.a(this.f19953a.f19959d, feedProps);
            multiRowSubParts.a(this.f19953a.f19960e, feedProps);
            multiRowSubParts.a(this.f19953a.f19961f, feedProps);
        }
    }

    private static PermalinkSubStoriesPartDefinition m23157b(InjectorLike injectorLike) {
        return new PermalinkSubStoriesPartDefinition(DefaultHeaderSelectorPartDefinition.a(injectorLike), ContentTextPartDefinition.a(injectorLike), AttachmentsPartDefinition.a(injectorLike), PermalinkAttachedStoryPartDefinition.m23106a(injectorLike), BlingBarSelectorPartDefinition.a(injectorLike), SubStoriesGroupPartDefinition.m23536a(injectorLike));
    }

    public final Object m23158a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f19956a, new Props((FeedProps) obj, new C17281(this)));
        return null;
    }

    public final boolean m23159a(Object obj) {
        return SubStoriesGroupPartDefinition.m23537a((GraphQLStory) ((FeedProps) obj).a);
    }

    @Inject
    public PermalinkSubStoriesPartDefinition(DefaultHeaderSelectorPartDefinition defaultHeaderSelectorPartDefinition, ContentTextPartDefinition contentTextPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, PermalinkAttachedStoryPartDefinition permalinkAttachedStoryPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, SubStoriesGroupPartDefinition subStoriesGroupPartDefinition) {
        this.f19957b = defaultHeaderSelectorPartDefinition;
        this.f19958c = contentTextPartDefinition;
        this.f19959d = attachmentsPartDefinition;
        this.f19960e = permalinkAttachedStoryPartDefinition;
        this.f19961f = blingBarSelectorPartDefinition;
        this.f19956a = subStoriesGroupPartDefinition;
    }

    public static PermalinkSubStoriesPartDefinition m23156a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkSubStoriesPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19955h) {
                PermalinkSubStoriesPartDefinition permalinkSubStoriesPartDefinition;
                if (a2 != null) {
                    permalinkSubStoriesPartDefinition = (PermalinkSubStoriesPartDefinition) a2.a(f19955h);
                } else {
                    permalinkSubStoriesPartDefinition = f19954g;
                }
                if (permalinkSubStoriesPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23157b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19955h, b3);
                        } else {
                            f19954g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkSubStoriesPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
