package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.search.results.environment.entity.CanApplyEntityInlineAction;
import com.facebook.search.results.environment.entity.CanLogEntityNavigation;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge.Node;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.rows.sections.binders.GraphQLNodeViewerGuestStateKey;
import com.facebook.search.results.rows.sections.binders.GraphQLNodeViewerJoinStateKey;
import com.facebook.search.results.rows.sections.binders.GraphQLNodeViewerLikeStateKey;
import com.facebook.search.results.rows.sections.collection.SearchResultsNodeClickListenerPartDefinition;
import com.facebook.search.results.rows.sections.entities.SearchResultsEntityActionButtonPartDefinition.ActionButtonData;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

@ContextScoped
/* compiled from: QuickPromotion_filter */
public class SearchResultsEntityBasePartDefinition<E extends HasContext & HasPersistentState & CanLogEntityNavigation & CanApplyEntityInlineAction> extends BaseSinglePartDefinition<SearchResultsProps<Node>, Void, E, ContentViewWithButton> {
    public static final ActionButtonData f24167a = new ActionButtonData(0, 0, null);
    private static final ImmutableMap<GraphQLFriendshipStatus, Integer> f24168b = ImmutableMap.of(GraphQLFriendshipStatus.CAN_REQUEST, Integer.valueOf(2130839877), GraphQLFriendshipStatus.OUTGOING_REQUEST, Integer.valueOf(2130839892), GraphQLFriendshipStatus.INCOMING_REQUEST, Integer.valueOf(2130839879), GraphQLFriendshipStatus.ARE_FRIENDS, Integer.valueOf(2130839685));
    private static final ImmutableMap<GraphQLFriendshipStatus, Integer> f24169c = ImmutableMap.of(GraphQLFriendshipStatus.CAN_REQUEST, Integer.valueOf(2131239005), GraphQLFriendshipStatus.OUTGOING_REQUEST, Integer.valueOf(2131239006), GraphQLFriendshipStatus.INCOMING_REQUEST, Integer.valueOf(2131239007), GraphQLFriendshipStatus.ARE_FRIENDS, Integer.valueOf(2131239008));
    private static final ImmutableMap<GraphQLGroupJoinState, Integer> f24170d = ImmutableMap.of(GraphQLGroupJoinState.CAN_REQUEST, Integer.valueOf(2130840035), GraphQLGroupJoinState.CAN_JOIN, Integer.valueOf(2130840035), GraphQLGroupJoinState.REQUESTED, Integer.valueOf(2130839777), GraphQLGroupJoinState.MEMBER, Integer.valueOf(2130839777));
    private static SearchResultsEntityBasePartDefinition f24171h;
    private static final Object f24172i = new Object();
    private final SearchResultsEntityTitlePartDefinition f24173e;
    private final SearchResultsEntityActionButtonPartDefinition f24174f;
    private final SearchResultsNodeClickListenerPartDefinition f24175g;

    /* compiled from: QuickPromotion_filter */
    final class C25742 implements CacheableEntity {
        final /* synthetic */ NodeModel f24166a;

        C25742(NodeModel nodeModel) {
            this.f24166a = nodeModel;
        }

        public final String m27705g() {
            return this.f24166a.mo572C();
        }
    }

    private static SearchResultsEntityBasePartDefinition m27715b(InjectorLike injectorLike) {
        return new SearchResultsEntityBasePartDefinition(SearchResultsEntityTitlePartDefinition.m27752a(injectorLike), SearchResultsEntityActionButtonPartDefinition.m27700a(injectorLike), SearchResultsNodeClickListenerPartDefinition.m27429a(injectorLike));
    }

    public static SearchResultsEntityBasePartDefinition m27713a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEntityBasePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24172i) {
                SearchResultsEntityBasePartDefinition searchResultsEntityBasePartDefinition;
                if (a2 != null) {
                    searchResultsEntityBasePartDefinition = (SearchResultsEntityBasePartDefinition) a2.a(f24172i);
                } else {
                    searchResultsEntityBasePartDefinition = f24171h;
                }
                if (searchResultsEntityBasePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27715b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24172i, b3);
                        } else {
                            f24171h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEntityBasePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m27719a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f24173e, searchResultsProps.f23388a);
        subParts.a(this.f24174f, m27710a(searchResultsProps, hasContext));
        subParts.a(this.f24175g, searchResultsProps);
        return null;
    }

    private ActionButtonData m27710a(SearchResultsProps<Node> searchResultsProps, E e) {
        switch (SearchResultsEntityUtils.m27756a((NodeModel) searchResultsProps.f23388a)) {
            case 2479791:
                return m27716c(searchResultsProps, e);
            case 2645995:
                return m27714b(searchResultsProps, e);
            case 67338874:
                return m27717d(searchResultsProps, e);
            case 69076575:
                return m27718e(searchResultsProps, e);
            default:
                return f24167a;
        }
    }

    private ActionButtonData m27714b(SearchResultsProps<Node> searchResultsProps, E e) {
        return m27708a(((NodeModel) searchResultsProps.f23388a).m9762w(), m27706a((SearchResultsProps) searchResultsProps, (CanApplyEntityInlineAction) e));
    }

    private ActionButtonData m27716c(SearchResultsProps<Node> searchResultsProps, E e) {
        NodeModel nodeModel = (NodeModel) searchResultsProps.f23388a;
        return m27712a(nodeModel.m9758s(), ((Boolean) ((HasPersistentState) e).a(new GraphQLNodeViewerLikeStateKey(nodeModel), m27707a(nodeModel))).booleanValue(), m27706a((SearchResultsProps) searchResultsProps, (CanApplyEntityInlineAction) e));
    }

    private ActionButtonData m27717d(SearchResultsProps<Node> searchResultsProps, E e) {
        NodeModel nodeModel = (NodeModel) searchResultsProps.f23388a;
        return m27711a(nodeModel.ji_(), (GraphQLEventGuestStatus) ((HasPersistentState) e).a(new GraphQLNodeViewerGuestStateKey(nodeModel), m27707a(nodeModel)), nodeModel.aw(), m27706a((SearchResultsProps) searchResultsProps, (CanApplyEntityInlineAction) e));
    }

    private ActionButtonData m27718e(SearchResultsProps<Node> searchResultsProps, E e) {
        NodeModel nodeModel = (NodeModel) searchResultsProps.f23388a;
        return m27709a(nodeModel.ax(), (GraphQLGroupJoinState) ((HasPersistentState) e).a(new GraphQLNodeViewerJoinStateKey(nodeModel), m27707a(nodeModel)), m27706a((SearchResultsProps) searchResultsProps, (CanApplyEntityInlineAction) e));
    }

    @Inject
    public SearchResultsEntityBasePartDefinition(SearchResultsEntityTitlePartDefinition searchResultsEntityTitlePartDefinition, SearchResultsEntityActionButtonPartDefinition searchResultsEntityActionButtonPartDefinition, SearchResultsNodeClickListenerPartDefinition searchResultsNodeClickListenerPartDefinition) {
        this.f24173e = searchResultsEntityTitlePartDefinition;
        this.f24174f = searchResultsEntityActionButtonPartDefinition;
        this.f24175g = searchResultsNodeClickListenerPartDefinition;
    }

    public static ActionButtonData m27708a(GraphQLFriendshipStatus graphQLFriendshipStatus, OnClickListener onClickListener) {
        Integer num = (Integer) f24168b.get(graphQLFriendshipStatus);
        Integer num2 = (Integer) f24169c.get(graphQLFriendshipStatus);
        return new ActionButtonData(num != null ? num.intValue() : 0, num2 != null ? num2.intValue() : 0, onClickListener);
    }

    private static ActionButtonData m27712a(boolean z, boolean z2, OnClickListener onClickListener) {
        int i = (z && z2) ? 0 : z ? 2130839774 : 2130839953;
        int i2 = z ? 2131239011 : 2131239010;
        if (z) {
            onClickListener = null;
        }
        return new ActionButtonData(i, i2, onClickListener);
    }

    public static ActionButtonData m27711a(boolean z, GraphQLEventGuestStatus graphQLEventGuestStatus, GraphQLEventGuestStatus graphQLEventGuestStatus2, OnClickListener onClickListener) {
        int i;
        int i2 = !z ? 0 : graphQLEventGuestStatus2 == graphQLEventGuestStatus ? 2130839846 : 2130839848;
        if (graphQLEventGuestStatus2 == graphQLEventGuestStatus) {
            i = 2131239014;
        } else {
            i = 2131239015;
        }
        if (graphQLEventGuestStatus2 != graphQLEventGuestStatus) {
            onClickListener = null;
        }
        return new ActionButtonData(i2, i, onClickListener);
    }

    public static ActionButtonData m27709a(GraphQLGroupJoinState graphQLGroupJoinState, GraphQLGroupJoinState graphQLGroupJoinState2, OnClickListener onClickListener) {
        Integer num;
        int i = 1;
        int i2 = 0;
        int i3 = (graphQLGroupJoinState == GraphQLGroupJoinState.MEMBER && graphQLGroupJoinState2 == GraphQLGroupJoinState.MEMBER) ? 1 : 0;
        if (!(graphQLGroupJoinState == GraphQLGroupJoinState.REQUESTED && graphQLGroupJoinState2 == GraphQLGroupJoinState.REQUESTED)) {
            i = 0;
        }
        if (i == 0 && i3 == 0) {
            num = (Integer) f24170d.get(graphQLGroupJoinState);
        } else {
            num = null;
        }
        if (num != null) {
            i2 = num.intValue();
        }
        if (graphQLGroupJoinState != GraphQLGroupJoinState.REQUESTED) {
            i3 = 2131239012;
        } else {
            i3 = 2131239013;
        }
        if (graphQLGroupJoinState == GraphQLGroupJoinState.REQUESTED) {
            onClickListener = null;
        }
        return new ActionButtonData(i2, i3, onClickListener);
    }

    private OnClickListener m27706a(final SearchResultsProps<Node> searchResultsProps, final CanApplyEntityInlineAction canApplyEntityInlineAction) {
        return new OnClickListener(this) {
            final /* synthetic */ SearchResultsEntityBasePartDefinition f24165c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 751560749);
                canApplyEntityInlineAction.mo1255b(searchResultsProps);
                Logger.a(2, EntryType.UI_INPUT_END, -1346825109, a);
            }
        };
    }

    private static CacheableEntity m27707a(NodeModel nodeModel) {
        return new C25742(nodeModel);
    }
}
