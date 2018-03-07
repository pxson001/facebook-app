package com.facebook.groups.feed.rows.partdefinitions;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.groups.feed.menu.GroupsFeedStoryModerationHelper;
import com.facebook.groups.feed.rows.views.ApprovalBarView;
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
/* compiled from: faceweb/f?href=/%s/activity_feed/?type=all */
public class ApprovalBarPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, HasPositionInformation, ApprovalBarView> {
    public static final ViewType f14142a = new C15131();
    private static final PaddingStyle f14143b = Builder.g().b(3).i();
    private static ApprovalBarPartDefinition f14144e;
    private static final Object f14145f = new Object();
    private final BackgroundPartDefinition f14146c;
    public final GroupsFeedStoryModerationHelper f14147d;

    /* compiled from: faceweb/f?href=/%s/activity_feed/?type=all */
    final class C15131 extends ViewType {
        C15131() {
        }

        public final View m15693a(Context context) {
            return new ApprovalBarView(context);
        }
    }

    /* compiled from: faceweb/f?href=/%s/activity_feed/?type=all */
    public class State {
        public final OnClickListener f14140a;
        public final OnClickListener f14141b;

        public State(OnClickListener onClickListener, OnClickListener onClickListener2) {
            this.f14140a = onClickListener;
            this.f14141b = onClickListener2;
        }
    }

    private static ApprovalBarPartDefinition m15695b(InjectorLike injectorLike) {
        return new ApprovalBarPartDefinition(BackgroundPartDefinition.a(injectorLike), GroupsFeedStoryModerationHelper.m15664a(injectorLike));
    }

    public final Object m15697a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f14146c, new StylingData(feedProps, f14143b));
        return new State(new OnClickListener(this) {
            final /* synthetic */ ApprovalBarPartDefinition f14137b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 327132433);
                this.f14137b.f14147d.m15672b(feedProps);
                Logger.a(2, EntryType.UI_INPUT_END, 1486251238, a);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ ApprovalBarPartDefinition f14139b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -293919329);
                this.f14139b.f14147d.m15670a(feedProps, view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 1453652356, a);
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m15698a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 504731958);
        State state = (State) obj2;
        ApprovalBarView approvalBarView = (ApprovalBarView) view;
        approvalBarView.setPrimaryButtonListener(state.f14140a);
        approvalBarView.setNegativeButtonListener(state.f14141b);
        Logger.a(8, EntryType.MARK_POP, -695453206, a);
    }

    public final void m15700b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ApprovalBarView approvalBarView = (ApprovalBarView) view;
        approvalBarView.setPrimaryButtonListener(null);
        approvalBarView.setNegativeButtonListener(null);
    }

    public static ApprovalBarPartDefinition m15694a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ApprovalBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14145f) {
                ApprovalBarPartDefinition approvalBarPartDefinition;
                if (a2 != null) {
                    approvalBarPartDefinition = (ApprovalBarPartDefinition) a2.a(f14145f);
                } else {
                    approvalBarPartDefinition = f14144e;
                }
                if (approvalBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15695b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14145f, b3);
                        } else {
                            f14144e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = approvalBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ApprovalBarPartDefinition(BackgroundPartDefinition backgroundPartDefinition, GroupsFeedStoryModerationHelper groupsFeedStoryModerationHelper) {
        this.f14146c = backgroundPartDefinition;
        this.f14147d = groupsFeedStoryModerationHelper;
    }

    public final ViewType m15696a() {
        return f14142a;
    }

    public final boolean m15699a(Object obj) {
        return true;
    }
}
