package com.facebook.feedplugins.groupcommerce;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.WriteOnceInt;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.EdgeToEdgePaddingStyleConfig;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feed.rows.styling.PaddingStyleConfigMethodAutoProvider;
import com.facebook.feedplugins.groupcommerce.GroupCommerceItemAttachmentPartDefinition.ItemStatus;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.groupcommerce.util.GroupCommercePartDefinitionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fundraiser_campaign_id */
public class GroupCommerceItemAttachmentTitlePartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Integer, HasPositionInformation, BetterTextView> {
    public static final ViewType f12736a = new C13261();
    private static GroupCommerceItemAttachmentTitlePartDefinition f12737h;
    private static final Object f12738i = new Object();
    public final Context f12739b;
    private final BackgroundPartDefinition f12740c;
    private final TextPartDefinition f12741d;
    private final EdgeToEdgePaddingStyleConfig f12742e;
    public final WriteOnceInt f12743f = new WriteOnceInt();
    public final WriteOnceInt f12744g = new WriteOnceInt();

    /* compiled from: fundraiser_campaign_id */
    final class C13261 extends ViewType {
        C13261() {
        }

        public final View m14537a(Context context) {
            BetterTextView betterTextView = new BetterTextView(context);
            betterTextView.setTypeface(null, 1);
            return betterTextView;
        }
    }

    private static GroupCommerceItemAttachmentTitlePartDefinition m14539b(InjectorLike injectorLike) {
        return new GroupCommerceItemAttachmentTitlePartDefinition(BackgroundPartDefinition.a(injectorLike), (Context) injectorLike.getInstance(Context.class), TextPartDefinition.a(injectorLike), PaddingStyleConfigMethodAutoProvider.b(injectorLike));
    }

    public final Object m14541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int b;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        ItemStatus a = GroupCommerceItemAttachmentPartDefinition.m14520a(graphQLStoryAttachment.z());
        String a2 = GroupCommercePartDefinitionHelper.a(this.f12739b, graphQLStoryAttachment);
        if (a == ItemStatus.AVAILABLE) {
            if (!this.f12744g.a) {
                this.f12744g.a(this.f12739b.getResources().getColor(2131362048));
            }
            b = this.f12744g.b();
        } else {
            if (!this.f12743f.a) {
                this.f12743f.a(this.f12739b.getResources().getColor(2131361974));
            }
            b = this.f12743f.b();
        }
        int i = b;
        subParts.a(this.f12741d, a2);
        BackgroundPartDefinition backgroundPartDefinition = this.f12740c;
        FeedProps e = AttachmentProps.e(feedProps);
        Builder g = Builder.g();
        EdgeToEdgePaddingStyleConfig edgeToEdgePaddingStyleConfig = this.f12742e;
        g.b = 6.0f;
        subParts.a(backgroundPartDefinition, new StylingData(e, g.i()));
        return Integer.valueOf(i);
    }

    public final /* bridge */ /* synthetic */ void m14542a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1902556236);
        ((BetterTextView) view).setTextColor(((Integer) obj2).intValue());
        Logger.a(8, EntryType.MARK_POP, -1466983150, a);
    }

    @Inject
    public GroupCommerceItemAttachmentTitlePartDefinition(BackgroundPartDefinition backgroundPartDefinition, Context context, TextPartDefinition textPartDefinition, EdgeToEdgePaddingStyleConfig edgeToEdgePaddingStyleConfig) {
        this.f12740c = backgroundPartDefinition;
        this.f12739b = context;
        this.f12741d = textPartDefinition;
        this.f12742e = edgeToEdgePaddingStyleConfig;
    }

    public static GroupCommerceItemAttachmentTitlePartDefinition m14538a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupCommerceItemAttachmentTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12738i) {
                GroupCommerceItemAttachmentTitlePartDefinition groupCommerceItemAttachmentTitlePartDefinition;
                if (a2 != null) {
                    groupCommerceItemAttachmentTitlePartDefinition = (GroupCommerceItemAttachmentTitlePartDefinition) a2.a(f12738i);
                } else {
                    groupCommerceItemAttachmentTitlePartDefinition = f12737h;
                }
                if (groupCommerceItemAttachmentTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14539b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12738i, b3);
                        } else {
                            f12737h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupCommerceItemAttachmentTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m14540a() {
        return f12736a;
    }

    public final boolean m14543a(Object obj) {
        return true;
    }
}
