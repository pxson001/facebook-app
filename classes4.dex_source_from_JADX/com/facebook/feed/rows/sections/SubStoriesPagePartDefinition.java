package com.facebook.feed.rows.sections;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.ui.SubStoryItemViewWithCTA;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollUtil;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition.Props;
import com.facebook.feedplugins.base.footer.ui.BasicFooterPartDefinition;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: num_phone_contacts */
public class SubStoriesPagePartDefinition<E extends HasInvalidate> extends BaseSinglePartDefinitionWithViewType<FeedProps<GraphQLStory>, Integer, E, SubStoryItemViewWithCTA> {
    public static final ViewType<SubStoryItemViewWithCTA> f6553a = new C02961();
    private static SubStoriesPagePartDefinition f6554i;
    private static final Object f6555j = new Object();
    public final BasicFooterPartDefinition f6556b;
    public final FooterBackgroundPartDefinition<DefaultFooterView> f6557c;
    private final BlingBarPartDefinition f6558d;
    private final SubStoriesSponsoredPartDefinition<AnyEnvironment> f6559e = new SubStoriesSponsoredPartDefinition();
    private final SubStoriesFooterPartDefinition f6560f = new SubStoriesFooterPartDefinition(this);
    private final SubStoriesAttachmentPartDefinitionProvider f6561g;
    private final HScrollUtil f6562h;

    /* compiled from: num_phone_contacts */
    final class C02961 extends ViewType<SubStoryItemViewWithCTA> {
        C02961() {
        }

        public final View m6978a(Context context) {
            return new SubStoryItemViewWithCTA(context);
        }
    }

    private static SubStoriesPagePartDefinition m6974b(InjectorLike injectorLike) {
        return new SubStoriesPagePartDefinition(FooterBackgroundPartDefinition.a(injectorLike), BasicFooterPartDefinition.a(injectorLike), BlingBarPartDefinition.a(injectorLike), (SubStoriesAttachmentPartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SubStoriesAttachmentPartDefinitionProvider.class), HScrollUtil.a(injectorLike));
    }

    public final Object m6976a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f6559e, feedProps);
        subParts.a(2131562972, this.f6558d, new Props(feedProps, true));
        subParts.a(2131562973, this.f6560f, feedProps);
        subParts.a(2131567737, this.f6561g.a(Float.valueOf(1.9318181f)), feedProps.a(StoryAttachmentHelper.o(graphQLStory)));
        HScrollUtil hScrollUtil = this.f6562h;
        return Integer.valueOf(SizeUtil.a(hScrollUtil.a, hScrollUtil.b()));
    }

    public final /* bridge */ /* synthetic */ void m6977a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1779519256);
        ((SubStoryItemViewWithCTA) view).setWidth(((Integer) obj2).intValue());
        Logger.a(8, EntryType.MARK_POP, -556342969, a);
    }

    public static SubStoriesPagePartDefinition m6973a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SubStoriesPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6555j) {
                SubStoriesPagePartDefinition subStoriesPagePartDefinition;
                if (a2 != null) {
                    subStoriesPagePartDefinition = (SubStoriesPagePartDefinition) a2.a(f6555j);
                } else {
                    subStoriesPagePartDefinition = f6554i;
                }
                if (subStoriesPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6974b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6555j, b3);
                        } else {
                            f6554i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = subStoriesPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SubStoriesPagePartDefinition(FooterBackgroundPartDefinition footerBackgroundPartDefinition, BasicFooterPartDefinition basicFooterPartDefinition, BlingBarPartDefinition blingBarPartDefinition, SubStoriesAttachmentPartDefinitionProvider subStoriesAttachmentPartDefinitionProvider, HScrollUtil hScrollUtil) {
        this.f6558d = blingBarPartDefinition;
        this.f6556b = basicFooterPartDefinition;
        this.f6557c = footerBackgroundPartDefinition;
        this.f6561g = subStoriesAttachmentPartDefinitionProvider;
        this.f6562h = hScrollUtil;
    }

    public final ViewType<SubStoryItemViewWithCTA> m6975a() {
        return f6553a;
    }
}
