package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Callbacks;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentKey;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentPersistentState;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: add_contactpoint */
public class ReactionPhotoFullWidthCounterUnitComponentPartDefinition<E extends HasContext & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, CustomFrameLayout> {
    public static final String f19925a = ReactionPhotoFullWidthCounterUnitComponentPartDefinition.class.getSimpleName();
    public static final ViewType<CustomFrameLayout> f19926b = ViewType.a(2130906700);
    private static ReactionPhotoFullWidthCounterUnitComponentPartDefinition f19927g;
    private static final Object f19928h = new Object();
    private final AbstractFbErrorReporter f19929c;
    private final PageStyleFactory f19930d;
    private final PersistentRecyclerPartDefinition<ReactionPhotoFullWidthPartDefinition$Props, E> f19931e;
    private final ReactionPhotoFullWidthPartDefinition f19932f;

    /* compiled from: add_contactpoint */
    public class CounterCallbacks<E2 extends AnyEnvironment> implements Callbacks<ReactionPhotoFullWidthPartDefinition$Props, E2> {
        private FbTextView f19917a;
        private final AbstractFbErrorReporter f19918b;
        private ReactionHScrollComponentPersistentState f19919c;
        private long[] f19920d = m23821a(this.f19921e, this.f19918b);
        private ImmutableList<? extends SizeAwareMedia> f19921e;
        private ReactionPhotoFullWidthPartDefinition f19922f;
        private ReactionUnitComponentNode f19923g;

        public CounterCallbacks(AbstractFbErrorReporter abstractFbErrorReporter, ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState, ReactionPhotoFullWidthPartDefinition reactionPhotoFullWidthPartDefinition, ReactionUnitComponentNode reactionUnitComponentNode) {
            this.f19918b = abstractFbErrorReporter;
            this.f19919c = reactionHScrollComponentPersistentState;
            this.f19921e = reactionUnitComponentNode.f18862b.bO();
            this.f19922f = reactionPhotoFullWidthPartDefinition;
            this.f19923g = reactionUnitComponentNode;
        }

        public final SinglePartDefinitionWithViewType m23823a(int i) {
            return this.f19922f;
        }

        public final Object m23825b(int i) {
            return new ReactionPhotoFullWidthPartDefinition$Props((SizeAwareMedia) this.f19921e.get(i), this.f19920d, this.f19923g.f18863c, this.f19923g.f18864d);
        }

        public final void m23826c(int i) {
            m23820a(i, this.f19921e.size());
            this.f19919c.f19176f = i;
        }

        public final int m23822a() {
            return this.f19921e.size();
        }

        public final void m23824a(FbTextView fbTextView) {
            this.f19917a = fbTextView;
            m23820a(this.f19919c.f19176f, this.f19921e.size());
        }

        private void m23820a(int i, int i2) {
            if (this.f19917a != null) {
                this.f19917a.setText(StringFormatUtil.formatStrLocaleSafe("%d/%d", Integer.valueOf(i + 1), Integer.valueOf(i2)));
            }
        }

        private static long[] m23821a(ImmutableList<? extends SizeAwareMedia> immutableList, FbErrorReporter fbErrorReporter) {
            long[] jArr = new long[immutableList.size()];
            for (int i = 0; i < immutableList.size(); i++) {
                try {
                    jArr[i] = Long.parseLong(((SizeAwareMedia) immutableList.get(i)).d());
                } catch (NumberFormatException e) {
                    fbErrorReporter.a(ReactionPhotoFullWidthCounterUnitComponentPartDefinition.f19925a, "Neighborhood feed query returned with empty results");
                }
            }
            return jArr;
        }
    }

    /* compiled from: add_contactpoint */
    public class State {
        public final CounterCallbacks f19924a;

        public State(CounterCallbacks counterCallbacks) {
            this.f19924a = counterCallbacks;
        }
    }

    private static ReactionPhotoFullWidthCounterUnitComponentPartDefinition m23828b(InjectorLike injectorLike) {
        return new ReactionPhotoFullWidthCounterUnitComponentPartDefinition((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), ReactionPhotoFullWidthPartDefinition.a(injectorLike));
    }

    public final Object m23830a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        ReactionHScrollComponentKey reactionHScrollComponentKey = new ReactionHScrollComponentKey(reactionUnitComponentNode.f18863c);
        CounterCallbacks counterCallbacks = new CounterCallbacks(this.f19929c, (ReactionHScrollComponentPersistentState) ((HasPersistentState) hasContext).a(reactionHScrollComponentKey, reactionUnitComponentNode), this.f19932f, reactionUnitComponentNode);
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f19931e;
        PageStyleFactory pageStyleFactory = this.f19930d;
        Builder c = Builder.c();
        c.d = -8.0f;
        subParts.a(2131562915, persistentRecyclerPartDefinition, new Props(pageStyleFactory.a(c.i()), ((ReactionHScrollComponentPersistentState) ((HasPersistentState) hasContext).a(reactionHScrollComponentKey, reactionUnitComponentNode)).f19176f, counterCallbacks, reactionUnitComponentNode.g(), reactionUnitComponentNode));
        return new State(counterCallbacks);
    }

    public final /* bridge */ /* synthetic */ void m23831a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1346470031);
        FbTextView fbTextView = (FbTextView) ((CustomFrameLayout) view).findViewById(2131566765);
        ((State) obj2).f19924a.m23824a(fbTextView);
        Logger.a(8, EntryType.MARK_POP, 455866852, a);
    }

    public final boolean m23832a(Object obj) {
        return !((ReactionUnitComponentNode) obj).f18862b.bO().isEmpty();
    }

    public static ReactionPhotoFullWidthCounterUnitComponentPartDefinition m23827a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPhotoFullWidthCounterUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19928h) {
                ReactionPhotoFullWidthCounterUnitComponentPartDefinition reactionPhotoFullWidthCounterUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionPhotoFullWidthCounterUnitComponentPartDefinition = (ReactionPhotoFullWidthCounterUnitComponentPartDefinition) a2.a(f19928h);
                } else {
                    reactionPhotoFullWidthCounterUnitComponentPartDefinition = f19927g;
                }
                if (reactionPhotoFullWidthCounterUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23828b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19928h, b3);
                        } else {
                            f19927g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPhotoFullWidthCounterUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionPhotoFullWidthCounterUnitComponentPartDefinition(AbstractFbErrorReporter abstractFbErrorReporter, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, ReactionPhotoFullWidthPartDefinition reactionPhotoFullWidthPartDefinition) {
        this.f19929c = abstractFbErrorReporter;
        this.f19930d = pageStyleFactory;
        this.f19931e = persistentRecyclerPartDefinition;
        this.f19932f = reactionPhotoFullWidthPartDefinition;
    }

    public final ViewType<CustomFrameLayout> m23829a() {
        return f19926b;
    }
}
