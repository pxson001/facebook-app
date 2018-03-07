package com.facebook.feedplugins.groupcommerce;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.event.ProductItemEvents.ToggleAvailabilitySurface;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryCommerceHelper;
import com.facebook.groupcommerce.protocol.ProductItemUpdateAvailabilityHelper;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: full_width */
public class GroupCommerceItemMarkAsSoldAttachmentPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, String, HasPositionInformation, GroupCommerceMarkAsSoldView> {
    public static final ViewType f12747a = new C13271();
    private static GroupCommerceItemMarkAsSoldAttachmentPartDefinition f12748e;
    private static final Object f12749f = new Object();
    public final ProductItemUpdateAvailabilityHelper f12750b;
    private final BackgroundPartDefinition f12751c;
    private final Context f12752d;

    /* compiled from: full_width */
    final class C13271 extends ViewType {
        C13271() {
        }

        public final View m14544a(Context context) {
            return new GroupCommerceMarkAsSoldView(context);
        }
    }

    private static GroupCommerceItemMarkAsSoldAttachmentPartDefinition m14547b(InjectorLike injectorLike) {
        return new GroupCommerceItemMarkAsSoldAttachmentPartDefinition((Context) injectorLike.getInstance(Context.class), BackgroundPartDefinition.a(injectorLike), ProductItemUpdateAvailabilityHelper.b(injectorLike));
    }

    public final Object m14549a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        FeedProps e = AttachmentProps.e(feedProps);
        GraphQLStory graphQLStory = (GraphQLStory) e.a;
        if (m14546a(feedProps)) {
            subParts.a(this.f12751c, new StylingData(e, PaddingStyle.a));
        }
        int i = (graphQLStory == null || !StoryCommerceHelper.d(graphQLStory)) ? 2131237863 : 2131237862;
        return this.f12752d.getResources().getString(i);
    }

    public final /* bridge */ /* synthetic */ void m14550a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 454591945);
        FeedProps feedProps = (FeedProps) obj;
        String str = (String) obj2;
        GroupCommerceMarkAsSoldView groupCommerceMarkAsSoldView = (GroupCommerceMarkAsSoldView) view;
        final FeedProps e = AttachmentProps.e(feedProps);
        if (m14546a(feedProps)) {
            groupCommerceMarkAsSoldView.setButtonContainerVisibility(0);
            GroupCommerceViewHelper.m14582a(StoryCommerceHelper.d((GraphQLStory) e.a), groupCommerceMarkAsSoldView.f12753a, groupCommerceMarkAsSoldView.getContext());
            groupCommerceMarkAsSoldView.f12753a.setText(str);
            groupCommerceMarkAsSoldView.setOnChangeAvailabilityClickListener(new OnClickListener(this) {
                final /* synthetic */ GroupCommerceItemMarkAsSoldAttachmentPartDefinition f12746b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1356382431);
                    this.f12746b.f12750b.a(e, ToggleAvailabilitySurface.FEED_STORY);
                    Logger.a(2, EntryType.UI_INPUT_END, 1419410772, a);
                }
            });
        } else {
            groupCommerceMarkAsSoldView.setButtonContainerVisibility(8);
        }
        Logger.a(8, EntryType.MARK_POP, -1075206291, a);
    }

    public final void m14552b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        GroupCommerceMarkAsSoldView groupCommerceMarkAsSoldView = (GroupCommerceMarkAsSoldView) view;
        GraphQLStory c = AttachmentProps.c((FeedProps) obj);
        if (c != null && StoryCommerceHelper.c(c)) {
            groupCommerceMarkAsSoldView.setOnChangeAvailabilityClickListener(null);
        }
    }

    @Inject
    public GroupCommerceItemMarkAsSoldAttachmentPartDefinition(Context context, BackgroundPartDefinition backgroundPartDefinition, ProductItemUpdateAvailabilityHelper productItemUpdateAvailabilityHelper) {
        this.f12750b = productItemUpdateAvailabilityHelper;
        this.f12751c = backgroundPartDefinition;
        this.f12752d = context;
    }

    public static GroupCommerceItemMarkAsSoldAttachmentPartDefinition m14545a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupCommerceItemMarkAsSoldAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12749f) {
                GroupCommerceItemMarkAsSoldAttachmentPartDefinition groupCommerceItemMarkAsSoldAttachmentPartDefinition;
                if (a2 != null) {
                    groupCommerceItemMarkAsSoldAttachmentPartDefinition = (GroupCommerceItemMarkAsSoldAttachmentPartDefinition) a2.a(f12749f);
                } else {
                    groupCommerceItemMarkAsSoldAttachmentPartDefinition = f12748e;
                }
                if (groupCommerceItemMarkAsSoldAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14547b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12749f, b3);
                        } else {
                            f12748e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupCommerceItemMarkAsSoldAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m14548a() {
        return f12747a;
    }

    public final boolean m14551a(Object obj) {
        return true;
    }

    public static boolean m14546a(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStory c = AttachmentProps.c(feedProps);
        return ((GraphQLStoryAttachment) feedProps.a).z().hq() && c != null && StoryCommerceHelper.c(c);
    }
}
