package com.facebook.feedplugins.groupcommerce;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.enums.GraphQLGroupCommercePriceType;
import com.facebook.graphql.model.GraphQLCurrencyQuantity;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryCommerceHelper;
import com.facebook.groupcommerce.util.GroupCommercePartDefinitionHelper;
import com.facebook.groupcommerce.util.GroupCommercePriceFormatter;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: getKey() for invalid index */
public class GroupCommerceCompactItemPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, HasPositionInformation, GroupCommerceCompactItemView> {
    public static final ViewType f12684a = new C13221();
    private static GroupCommerceCompactItemPartDefinition f12685g;
    private static final Object f12686h = new Object();
    public final SecureContextHelper f12687b;
    public final IFeedIntentBuilder f12688c;
    private final BackgroundPartDefinition f12689d;
    public final Context f12690e;
    public final GroupCommercePriceFormatter f12691f;

    /* compiled from: getKey() for invalid index */
    final class C13221 extends ViewType {
        C13221() {
        }

        public final View m14495a(Context context) {
            return new GroupCommerceCompactItemView(context);
        }
    }

    /* compiled from: getKey() for invalid index */
    public class State {
        public final String f12679a;
        public final String f12680b;
        public final String f12681c;
        public final String f12682d;
        public final GraphQLTextWithEntities f12683e;

        public State(String str, String str2, String str3, String str4, GraphQLTextWithEntities graphQLTextWithEntities) {
            this.f12679a = str;
            this.f12680b = str2;
            this.f12681c = str3;
            this.f12682d = str4;
            this.f12683e = graphQLTextWithEntities;
        }
    }

    private static GroupCommerceCompactItemPartDefinition m14497b(InjectorLike injectorLike) {
        return new GroupCommerceCompactItemPartDefinition((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), (Context) injectorLike.getInstance(Context.class), BackgroundPartDefinition.a(injectorLike), GroupCommercePriceFormatter.a(injectorLike));
    }

    public final Object m14499a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z;
        String b;
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f12689d, new StylingData(feedProps, PaddingStyle.a));
        GraphQLStoryAttachment a = StoryCommerceHelper.a(graphQLStory);
        GraphQLNode z2 = a.z();
        String a2 = GroupCommercePartDefinitionHelper.a(this.f12690e, a);
        GroupCommercePriceFormatter groupCommercePriceFormatter = this.f12691f;
        GraphQLCurrencyQuantity ec = z2.ec();
        if (z2.fW() == GraphQLGroupCommercePriceType.NEGOTIABLE) {
            z = true;
        } else {
            z = false;
        }
        String a3 = groupCommercePriceFormatter.a(ec, z);
        GraphQLImage q = StoryAttachmentHelper.q(graphQLStory);
        if (q != null) {
            b = q.b();
        } else {
            b = null;
        }
        String str = b;
        GraphQLTextWithEntities db = z2.db();
        GraphQLTextWithEntities fs = z2.fs();
        if (fs == null || StringUtil.a(fs.a())) {
            b = null;
        } else {
            b = fs.a();
        }
        return new State(a2, a3, str, b, db);
    }

    public final /* bridge */ /* synthetic */ void m14500a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -884935278);
        State state = (State) obj2;
        GroupCommerceCompactItemView groupCommerceCompactItemView = (GroupCommerceCompactItemView) view;
        final GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        groupCommerceCompactItemView.f12693b.setText(state.f12679a);
        groupCommerceCompactItemView.f12694c.setText(state.f12680b);
        groupCommerceCompactItemView.f12695d.setThumbnailUri(state.f12681c);
        Object obj3 = state.f12682d;
        groupCommerceCompactItemView.f12692a.setText(obj3);
        if (Strings.isNullOrEmpty(obj3)) {
            groupCommerceCompactItemView.f12697f.setVisibility(8);
        } else {
            groupCommerceCompactItemView.f12697f.setVisibility(0);
        }
        GraphQLTextWithEntities graphQLTextWithEntities = state.f12683e;
        if (graphQLTextWithEntities != null) {
            groupCommerceCompactItemView.f12696e.a(graphQLTextWithEntities.a(), GraphQLHelper.a(graphQLTextWithEntities));
        } else {
            groupCommerceCompactItemView.f12696e.setText(null);
        }
        groupCommerceCompactItemView.setOnImageBlockClickListener(new OnClickListener(this) {
            final /* synthetic */ GroupCommerceCompactItemPartDefinition f12678b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 763546482);
                this.f12678b.f12687b.a(this.f12678b.f12688c.a(graphQLStory), this.f12678b.f12690e);
                Logger.a(2, EntryType.UI_INPUT_END, -1976380330, a);
            }
        });
        Logger.a(8, EntryType.MARK_POP, 558539945, a);
    }

    public final void m14502b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((GroupCommerceCompactItemView) view).setOnImageBlockClickListener(null);
    }

    public static GroupCommerceCompactItemPartDefinition m14496a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupCommerceCompactItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12686h) {
                GroupCommerceCompactItemPartDefinition groupCommerceCompactItemPartDefinition;
                if (a2 != null) {
                    groupCommerceCompactItemPartDefinition = (GroupCommerceCompactItemPartDefinition) a2.a(f12686h);
                } else {
                    groupCommerceCompactItemPartDefinition = f12685g;
                }
                if (groupCommerceCompactItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14497b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12686h, b3);
                        } else {
                            f12685g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupCommerceCompactItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GroupCommerceCompactItemPartDefinition(SecureContextHelper secureContextHelper, IFeedIntentBuilder iFeedIntentBuilder, Context context, BackgroundPartDefinition backgroundPartDefinition, GroupCommercePriceFormatter groupCommercePriceFormatter) {
        this.f12687b = secureContextHelper;
        this.f12688c = iFeedIntentBuilder;
        this.f12689d = backgroundPartDefinition;
        this.f12690e = context;
        this.f12691f = groupCommercePriceFormatter;
    }

    public final ViewType m14498a() {
        return f12684a;
    }

    public final boolean m14501a(Object obj) {
        return true;
    }
}
