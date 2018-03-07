package com.facebook.feedplugins.pillsblingbar.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feedback.reactions.ui.PillsBlingBarView;
import com.facebook.graphql.model.GraphQLStory;
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
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SPEEDTEST */
public class PillsBlingBarSeenByBinderPartDefinition<E extends HasFeedListType & HasPersistentState & HasPositionInformation> extends BaseSinglePartDefinition<GraphQLStory, SeenByBinderStateHolder, E, PillsBlingBarView> {
    private static PillsBlingBarSeenByBinderPartDefinition f23731c;
    private static final Object f23732d = new Object();
    public IFeedIntentBuilder f23733a;
    public SecureContextHelper f23734b;

    /* compiled from: SPEEDTEST */
    public class SeenByBinderStateHolder {
        public final OnClickListener f23730a;

        public SeenByBinderStateHolder(OnClickListener onClickListener) {
            this.f23730a = onClickListener;
        }
    }

    private static PillsBlingBarSeenByBinderPartDefinition m25904b(InjectorLike injectorLike) {
        return new PillsBlingBarSeenByBinderPartDefinition((IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public final Object m25905a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLStory graphQLStory = (GraphQLStory) obj;
        final HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        return new SeenByBinderStateHolder(new OnClickListener(this) {
            final /* synthetic */ PillsBlingBarSeenByBinderPartDefinition f23729c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2142696586);
                Context context = view.getContext();
                Intent a2 = this.f23729c.f23733a.a(graphQLStory, hasFeedListType.c().a());
                a2.putExtra("fragment_title", context.getString(2131233565));
                this.f23729c.f23734b.a(a2, context);
                Logger.a(2, EntryType.UI_INPUT_END, 285799469, a);
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m25906a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 871144948);
        SeenByBinderStateHolder seenByBinderStateHolder = (SeenByBinderStateHolder) obj2;
        PillsBlingBarView pillsBlingBarView = (PillsBlingBarView) view;
        pillsBlingBarView.setSeenByCount(((GraphQLStory) obj).D());
        pillsBlingBarView.setSeenByClickListener(seenByBinderStateHolder.f23730a);
        pillsBlingBarView.setId(2131558554);
        Logger.a(8, EntryType.MARK_POP, 1331445491, a);
    }

    public final void m25907b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        PillsBlingBarView pillsBlingBarView = (PillsBlingBarView) view;
        pillsBlingBarView.setSeenByCount(0);
        pillsBlingBarView.setSeenByClickListener(null);
    }

    @Inject
    public PillsBlingBarSeenByBinderPartDefinition(IFeedIntentBuilder iFeedIntentBuilder, SecureContextHelper secureContextHelper) {
        this.f23733a = iFeedIntentBuilder;
        this.f23734b = secureContextHelper;
    }

    public static PillsBlingBarSeenByBinderPartDefinition m25903a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PillsBlingBarSeenByBinderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23732d) {
                PillsBlingBarSeenByBinderPartDefinition pillsBlingBarSeenByBinderPartDefinition;
                if (a2 != null) {
                    pillsBlingBarSeenByBinderPartDefinition = (PillsBlingBarSeenByBinderPartDefinition) a2.a(f23732d);
                } else {
                    pillsBlingBarSeenByBinderPartDefinition = f23731c;
                }
                if (pillsBlingBarSeenByBinderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25904b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23732d, b3);
                        } else {
                            f23731c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pillsBlingBarSeenByBinderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
