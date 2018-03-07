package com.facebook.feedplugins.graphqlstory.seefirsttombstone;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.graphqlstory.tombstoneview.TombstoneView;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: initial_priority */
public class SeeFirstTombstonePartDefinition<E extends HasInvalidate & HasPersistentState> extends MultiRowSinglePartDefinition<Props, SpannableStringBuilder, E, TombstoneView> {
    public static final ViewType f20031a = new C08131();
    private static SeeFirstTombstonePartDefinition f20032d;
    private static final Object f20033e = new Object();
    private final Resources f20034b;
    public final Lazy<FriendingClient> f20035c;

    /* compiled from: initial_priority */
    final class C08131 extends ViewType {
        C08131() {
        }

        public final View mo1995a(Context context) {
            return new TombstoneView(context);
        }
    }

    /* compiled from: initial_priority */
    public class Props {
        public final GraphQLStory f20356a;
        public final HasPersistentState f20357b;

        public Props(GraphQLStory graphQLStory, HasPersistentState hasPersistentState) {
            this.f20356a = graphQLStory;
            this.f20357b = hasPersistentState;
        }
    }

    private static SeeFirstTombstonePartDefinition m27753b(InjectorLike injectorLike) {
        return new SeeFirstTombstonePartDefinition(ResourcesMethodAutoProvider.m6510a(injectorLike), IdBasedLazy.m1808a(injectorLike, 2073));
    }

    @Nullable
    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        CacheableEntity cacheableEntity = ((Props) obj).f20356a;
        SeeFirstTombstonePersistentState seeFirstTombstonePersistentState = (SeeFirstTombstonePersistentState) ((HasPersistentState) hasInvalidate).mo2425a(new SeeFirstTombstoneStoryKey(cacheableEntity), cacheableEntity);
        if (seeFirstTombstonePersistentState.f20361b == null) {
            return null;
        }
        int i;
        if (seeFirstTombstonePersistentState.f20362c) {
            i = 2131235597;
        } else {
            i = 2131235596;
        }
        CharSequence string = this.f20034b.getString(i, new Object[]{seeFirstTombstonePersistentState.f20360a});
        CharSequence spannableStringBuilder = new SpannableStringBuilder(this.f20034b.getText(2131230753));
        spannableStringBuilder.setSpan(new 2(this, cacheableEntity, seeFirstTombstonePersistentState, hasInvalidate), 0, spannableStringBuilder.length(), 18);
        return new SpannableStringBuilder(string).append(" ").append(spannableStringBuilder);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1398002109);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) obj2;
        TombstoneView tombstoneView = (TombstoneView) view;
        if (spannableStringBuilder != null) {
            tombstoneView.setTitle(spannableStringBuilder);
        }
        Logger.a(8, EntryType.MARK_POP, -431689685, a);
    }

    public final boolean m27757a(Object obj) {
        Props props = (Props) obj;
        CacheableEntity cacheableEntity = props.f20356a;
        return ((SeeFirstTombstonePersistentState) props.f20357b.mo2425a(new SeeFirstTombstoneStoryKey(cacheableEntity), cacheableEntity)).f20363d;
    }

    @Inject
    public SeeFirstTombstonePartDefinition(Resources resources, Lazy<FriendingClient> lazy) {
        this.f20034b = resources;
        this.f20035c = lazy;
    }

    public static SeeFirstTombstonePartDefinition m27752a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SeeFirstTombstonePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20033e) {
                SeeFirstTombstonePartDefinition seeFirstTombstonePartDefinition;
                if (a2 != null) {
                    seeFirstTombstonePartDefinition = (SeeFirstTombstonePartDefinition) a2.mo818a(f20033e);
                } else {
                    seeFirstTombstonePartDefinition = f20032d;
                }
                if (seeFirstTombstonePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27753b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20033e, b3);
                        } else {
                            f20032d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = seeFirstTombstonePartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType mo2547a() {
        return f20031a;
    }
}
