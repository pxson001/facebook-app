package com.facebook.timeline.protiles.rows;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.protiles.events.ProtilesActionEvent;
import com.facebook.timeline.protiles.events.ProtilesActionEvent.Type;
import com.facebook.timeline.protiles.model.ProtileModel;
import com.facebook.timeline.protiles.util.TimelineCollapsedProtilesExperimentHelper;
import com.facebook.timeline.protiles.views.ProtilesHeaderView;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fc_friends_scroll_perf */
public class ProtilesHeaderPartDefinition extends MultiRowSinglePartDefinition<ProtileModel, State, AnyEnvironment, ProtilesHeaderView> {
    public static final ViewType f12251a = new C17391();
    private static ProtilesHeaderPartDefinition f12252h;
    private static final Object f12253i = new Object();
    public final EventsStream f12254b;
    private final TimelinePerformanceLogger f12255c;
    private final ClickListenerPartDefinition f12256d;
    private final TimelineCollapsedProtilesExperimentHelper f12257e;
    private final Resources f12258f;
    private final QeAccessor f12259g;

    /* compiled from: fc_friends_scroll_perf */
    final class C17391 extends ViewType {
        C17391() {
        }

        public final View m12318a(Context context) {
            return new ProtilesHeaderView(context);
        }
    }

    /* compiled from: fc_friends_scroll_perf */
    public class State {
        @Nullable
        public final Drawable f12249a;
        public final boolean f12250b;

        public State(@Nullable Drawable drawable, boolean z) {
            this.f12249a = drawable;
            this.f12250b = z;
        }
    }

    private static ProtilesHeaderPartDefinition m12323b(InjectorLike injectorLike) {
        return new ProtilesHeaderPartDefinition(EventsStream.a(injectorLike), TimelinePerformanceLogger.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), TimelineCollapsedProtilesExperimentHelper.m12438a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m12325a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ProtileModel protileModel = (ProtileModel) obj;
        subParts.a(this.f12256d, new OnClickListener(this) {
            final /* synthetic */ ProtilesHeaderPartDefinition f12248b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -835935204);
                this.f12248b.f12254b.a(new ProtilesActionEvent(Type.CLICK_HEADER, protileModel));
                Logger.a(2, EntryType.UI_INPUT_END, 1208592933, a);
            }
        });
        Drawable b = m12322b(protileModel);
        boolean z = this.f12257e.m12445c(protileModel) && !protileModel.f12108d;
        return new State(b, z);
    }

    public final /* bridge */ /* synthetic */ void m12326a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 81702286);
        m12321a((ProtileModel) obj, (State) obj2, (ProtilesHeaderView) view);
        Logger.a(8, EntryType.MARK_POP, 758542614, a);
    }

    public final boolean m12327a(Object obj) {
        return ((ProtileModel) obj).m12111d() != null;
    }

    public static ProtilesHeaderPartDefinition m12320a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12253i) {
                ProtilesHeaderPartDefinition protilesHeaderPartDefinition;
                if (a2 != null) {
                    protilesHeaderPartDefinition = (ProtilesHeaderPartDefinition) a2.a(f12253i);
                } else {
                    protilesHeaderPartDefinition = f12252h;
                }
                if (protilesHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12323b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12253i, b3);
                        } else {
                            f12252h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ProtilesHeaderPartDefinition(EventsStream eventsStream, TimelinePerformanceLogger timelinePerformanceLogger, ClickListenerPartDefinition clickListenerPartDefinition, TimelineCollapsedProtilesExperimentHelper timelineCollapsedProtilesExperimentHelper, Resources resources, QeAccessor qeAccessor) {
        this.f12254b = eventsStream;
        this.f12255c = timelinePerformanceLogger;
        this.f12256d = clickListenerPartDefinition;
        this.f12257e = timelineCollapsedProtilesExperimentHelper;
        this.f12258f = resources;
        this.f12259g = qeAccessor;
    }

    public final ViewType m12324a() {
        return f12251a;
    }

    private void m12321a(ProtileModel protileModel, State state, ProtilesHeaderView protilesHeaderView) {
        if (state.f12249a != null) {
            protilesHeaderView.setDrawable(state.f12249a);
        } else {
            Uri uri;
            if (protileModel.f12106b.m12217j() == null || protileModel.f12106b.m12217j().m12202a() == null) {
                uri = null;
            } else {
                uri = Uri.parse(protileModel.f12106b.m12217j().m12202a());
            }
            protilesHeaderView.f12412j.a(uri, ProtilesHeaderView.f12410h);
        }
        CharSequence d = protileModel.m12111d();
        CharSequence e = protileModel.m12112e();
        Spannable spannableString = new SpannableString(d);
        ProtilesHeaderView.m12448a(-16777216, spannableString);
        protilesHeaderView.f12413k.setText(spannableString);
        if (!Strings.isNullOrEmpty(e)) {
            spannableString = new SpannableStringBuilder().append(" · ").append(e);
            ProtilesHeaderView.m12448a(protilesHeaderView.getResources().getColor(2131361937), spannableString);
            spannableString.setSpan(new AbsoluteSizeSpan(protilesHeaderView.getResources().getDimensionPixelSize(2131427400)), 0, spannableString.length(), 33);
            protilesHeaderView.f12413k.append(spannableString);
        }
        if (!state.f12250b) {
            protilesHeaderView.f12413k.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        } else if (protilesHeaderView.f12411i.a()) {
            protilesHeaderView.f12413k.setCompoundDrawablesWithIntrinsicBounds(protilesHeaderView.f12414l, null, null, null);
        } else {
            protilesHeaderView.f12413k.setCompoundDrawablesWithIntrinsicBounds(null, null, protilesHeaderView.f12414l, null);
        }
        this.f12255c.w = true;
    }

    public final void m12328b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        this.f12255c.w = false;
    }

    @Nullable
    private Drawable m12322b(ProtileModel protileModel) {
        if (!this.f12259g.a(ExperimentsForTimelineAbTestModule.aT, false)) {
            return null;
        }
        if (protileModel.m12109b() == GraphQLProfileTileSectionType.PHOTOS) {
            return m12319a(2130842634);
        }
        if (protileModel.m12109b() == GraphQLProfileTileSectionType.FRIENDS) {
            return m12319a(2130840492);
        }
        return null;
    }

    private LayerDrawable m12319a(@DrawableRes int i) {
        LayerDrawable layerDrawable = (LayerDrawable) this.f12258f.getDrawable(i);
        layerDrawable.findDrawableByLayerId(2131568583).setColorFilter(this.f12258f.getColor(2131361920), Mode.SRC_IN);
        return layerDrawable;
    }
}
