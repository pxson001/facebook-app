package com.facebook.gametime.ui.components.partdefinition;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.environment.HasContext;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.feed.PermalinkStoryIdParams.Builder;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.reaction.feed.unitcomponents.util.ReactionSpannableStringUtil;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.GametimeDataFactFragment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TASK_CREATE_GROUP */
public class GametimeSportsPlayContentViewComponentPartDefinition extends BaseSinglePartDefinition<GametimeDataFactFragment, State, HasContext, ContentView> {
    private static final CallerContext f25120a = CallerContext.a(GametimeSportsPlayContentViewComponentPartDefinition.class);
    private static GametimeSportsPlayContentViewComponentPartDefinition f25121f;
    private static final Object f25122g = new Object();
    private final ClickListenerPartDefinition f25123b;
    private final FbDraweeControllerBuilder f25124c;
    public final SecureContextHelper f25125d;
    public final ViewPermalinkIntentFactory f25126e;

    /* compiled from: TASK_CREATE_GROUP */
    public class State {
        public final DraweeController f25118a;
        public final CharSequence f25119b;

        public State(DraweeController draweeController, CharSequence charSequence) {
            this.f25118a = draweeController;
            this.f25119b = charSequence;
        }
    }

    private static GametimeSportsPlayContentViewComponentPartDefinition m27104b(InjectorLike injectorLike) {
        return new GametimeSportsPlayContentViewComponentPartDefinition(ClickListenerPartDefinition.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ViewPermalinkIntentFactory.a(injectorLike));
    }

    public final Object m27105a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GametimeDataFactFragment gametimeDataFactFragment = (GametimeDataFactFragment) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(2131562500, this.f25123b, new OnClickListener(this) {
            final /* synthetic */ GametimeSportsPlayContentViewComponentPartDefinition f25117c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1599170569);
                Builder builder = new Builder();
                builder.a = gametimeDataFactFragment.m().c();
                builder = builder;
                builder.b = gametimeDataFactFragment.m().b();
                this.f25117c.f25125d.a(this.f25117c.f25126e.a(builder.a()), hasContext.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 273322043, a);
            }
        });
        FbPipelineDraweeController s = this.f25124c.a(gametimeDataFactFragment.b().d().a()).a(f25120a).s();
        CharSequence k = gametimeDataFactFragment.k();
        String eQ_ = gametimeDataFactFragment.eQ_();
        CharacterStyle styleSpan = new StyleSpan(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (k != null) {
            spannableStringBuilder.append(k);
            spannableStringBuilder.append(" ");
        }
        if (eQ_ != null) {
            ReactionSpannableStringUtil.a(spannableStringBuilder, eQ_, styleSpan);
        }
        return new State(s, spannableStringBuilder);
    }

    public final /* bridge */ /* synthetic */ void m27106a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -25259990);
        GametimeDataFactFragment gametimeDataFactFragment = (GametimeDataFactFragment) obj;
        State state = (State) obj2;
        ContentView contentView = (ContentView) view;
        contentView.setThumbnailController(state.f25118a);
        contentView.setTitleText(state.f25119b);
        contentView.setSubtitleText(gametimeDataFactFragment.eP_());
        Logger.a(8, EntryType.MARK_POP, 796087180, a);
    }

    public static GametimeSportsPlayContentViewComponentPartDefinition m27103a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeSportsPlayContentViewComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25122g) {
                GametimeSportsPlayContentViewComponentPartDefinition gametimeSportsPlayContentViewComponentPartDefinition;
                if (a2 != null) {
                    gametimeSportsPlayContentViewComponentPartDefinition = (GametimeSportsPlayContentViewComponentPartDefinition) a2.a(f25122g);
                } else {
                    gametimeSportsPlayContentViewComponentPartDefinition = f25121f;
                }
                if (gametimeSportsPlayContentViewComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27104b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25122g, b3);
                        } else {
                            f25121f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = gametimeSportsPlayContentViewComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GametimeSportsPlayContentViewComponentPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, FbDraweeControllerBuilder fbDraweeControllerBuilder, SecureContextHelper secureContextHelper, ViewPermalinkIntentFactory viewPermalinkIntentFactory) {
        this.f25123b = clickListenerPartDefinition;
        this.f25124c = fbDraweeControllerBuilder;
        this.f25125d = secureContextHelper;
        this.f25126e = viewPermalinkIntentFactory;
    }
}
