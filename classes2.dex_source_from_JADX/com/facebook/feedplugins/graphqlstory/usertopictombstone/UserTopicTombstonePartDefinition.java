package com.facebook.feedplugins.graphqlstory.usertopictombstone;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedplugins.graphqlstory.tombstoneview.TombstoneView;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.topics.data.UserTopicHideMutator;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: inline_comments_for_aggregated_stories */
public class UserTopicTombstonePartDefinition<E extends HasInvalidate & HasPersistentState> extends MultiRowSinglePartDefinition<NegativeFeedbackActionsUnit, SpannableStringBuilder, E, TombstoneView> {
    public static final ViewType f19930a = new C08121();
    public static final String f19931b = UserTopicTombstonePartDefinition.class.getSimpleName();
    private static UserTopicTombstonePartDefinition f19932h;
    private static final Object f19933i = new Object();
    public final AbstractFbErrorReporter f19934c;
    public final FeedEventBus f19935d;
    private final Resources f19936e;
    public final UserTopicTombstoneStateManager f19937f;
    public final UserTopicHideMutator f19938g;

    /* compiled from: inline_comments_for_aggregated_stories */
    final class C08121 extends ViewType {
        C08121() {
        }

        public final View mo1995a(Context context) {
            return new TombstoneView(context);
        }
    }

    private static UserTopicTombstonePartDefinition m27718b(InjectorLike injectorLike) {
        return new UserTopicTombstonePartDefinition(FbErrorReporterImpl.m2317a(injectorLike), FeedEventBus.m4573a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike), UserTopicTombstoneStateManager.m18624a(injectorLike), UserTopicHideMutator.m18621b(injectorLike));
    }

    @Nullable
    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CacheableEntity cacheableEntity = (NegativeFeedbackActionsUnit) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        UserTopicTombstonePersistentState userTopicTombstonePersistentState = (UserTopicTombstonePersistentState) ((HasPersistentState) hasInvalidate).mo2425a(new UserTopicTombstoneStoryKey(cacheableEntity), cacheableEntity);
        if (userTopicTombstonePersistentState.a == null) {
            return null;
        }
        CharSequence string = this.f19936e.getString(2131235599, new Object[]{userTopicTombstonePersistentState.d, userTopicTombstonePersistentState.b});
        CharSequence spannableStringBuilder = new SpannableStringBuilder(this.f19936e.getString(2131230753));
        spannableStringBuilder.setSpan(new 2(this, cacheableEntity, userTopicTombstonePersistentState, hasInvalidate), 0, spannableStringBuilder.length(), 18);
        return new SpannableStringBuilder(string).append(" ").append(spannableStringBuilder);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 867610048);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) obj2;
        TombstoneView tombstoneView = (TombstoneView) view;
        if (spannableStringBuilder != null) {
            tombstoneView.setTitle(spannableStringBuilder);
        }
        Logger.a(8, EntryType.MARK_POP, 1273448326, a);
    }

    public final boolean m27722a(Object obj) {
        return this.f19937f.f12551a.contains(((NegativeFeedbackActionsUnit) obj).mo2507g());
    }

    @Inject
    public UserTopicTombstonePartDefinition(AbstractFbErrorReporter abstractFbErrorReporter, FeedEventBus feedEventBus, Resources resources, UserTopicTombstoneStateManager userTopicTombstoneStateManager, UserTopicHideMutator userTopicHideMutator) {
        this.f19934c = abstractFbErrorReporter;
        this.f19935d = feedEventBus;
        this.f19936e = resources;
        this.f19937f = userTopicTombstoneStateManager;
        this.f19938g = userTopicHideMutator;
    }

    public static UserTopicTombstonePartDefinition m27717a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            UserTopicTombstonePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f19933i) {
                UserTopicTombstonePartDefinition userTopicTombstonePartDefinition;
                if (a2 != null) {
                    userTopicTombstonePartDefinition = (UserTopicTombstonePartDefinition) a2.mo818a(f19933i);
                } else {
                    userTopicTombstonePartDefinition = f19932h;
                }
                if (userTopicTombstonePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27718b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f19933i, b3);
                        } else {
                            f19932h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = userTopicTombstonePartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType mo2547a() {
        return f19930a;
    }
}
