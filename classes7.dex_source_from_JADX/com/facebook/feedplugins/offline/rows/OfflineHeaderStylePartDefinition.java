package com.facebook.feedplugins.offline.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.offline.rows.ui.HasOfflineHeaderView;
import com.facebook.graphql.model.GraphQLStory;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: STAR_RATING */
public class OfflineHeaderStylePartDefinition<E extends HasFeedListType & HasPositionInformation, V extends View & HasOfflineHeaderView> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, V> {
    private static final PaddingStyle f23622c = PaddingStyle.q;
    private static OfflineHeaderStylePartDefinition f23623d;
    private static final Object f23624e = new Object();
    private final BackgroundPartDefinition f23625a;
    private final Resources f23626b;

    private static OfflineHeaderStylePartDefinition m25841b(InjectorLike injectorLike) {
        return new OfflineHeaderStylePartDefinition(BackgroundPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m25842a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        if (!m25840a((HasFeedListType) anyEnvironment)) {
            subParts.a(this.f23625a, new StylingData(feedProps, f23622c));
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void m25843a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1138815124);
        m25839a((HasFeedListType) anyEnvironment, view);
        Logger.a(8, EntryType.MARK_POP, 375764704, a);
    }

    @Inject
    public OfflineHeaderStylePartDefinition(BackgroundPartDefinition backgroundPartDefinition, Resources resources) {
        this.f23625a = backgroundPartDefinition;
        this.f23626b = resources;
    }

    public static OfflineHeaderStylePartDefinition m25838a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineHeaderStylePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23624e) {
                OfflineHeaderStylePartDefinition offlineHeaderStylePartDefinition;
                if (a2 != null) {
                    offlineHeaderStylePartDefinition = (OfflineHeaderStylePartDefinition) a2.a(f23624e);
                } else {
                    offlineHeaderStylePartDefinition = f23623d;
                }
                if (offlineHeaderStylePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25841b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23624e, b3);
                        } else {
                            f23623d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineHeaderStylePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static boolean m25840a(HasFeedListType hasFeedListType) {
        return hasFeedListType.c() != null && hasFeedListType.c().a() == FeedListName.PERMALINK;
    }

    private void m25839a(E e, V v) {
        int i;
        int i2;
        View offlineHeaderView = ((HasOfflineHeaderView) v).getOfflineHeaderView();
        if (m25840a((HasFeedListType) e)) {
            i = 0;
            i2 = 2130843487;
        } else {
            i2 = 2130840287;
            i = this.f23626b.getDimensionPixelSize(2131430384);
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) offlineHeaderView.getLayoutParams();
        marginLayoutParams.setMargins(0, i, 0, 0);
        offlineHeaderView.setLayoutParams(marginLayoutParams);
        int paddingLeft = offlineHeaderView.getPaddingLeft();
        i = offlineHeaderView.getPaddingTop();
        int paddingRight = offlineHeaderView.getPaddingRight();
        int paddingBottom = offlineHeaderView.getPaddingBottom();
        offlineHeaderView.setBackgroundResource(i2);
        offlineHeaderView.setPadding(paddingLeft, i, paddingRight, paddingBottom);
    }
}
