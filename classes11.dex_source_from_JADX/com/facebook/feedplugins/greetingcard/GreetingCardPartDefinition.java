package com.facebook.feedplugins.greetingcard;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.facebook.base.activity.FbRootViewUtil;
import com.facebook.base.fragment.FragmentManagerHost.Util;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.model.GraphQLGreetingCard;
import com.facebook.graphql.model.GraphQLGreetingCardTemplateTheme;
import com.facebook.greetingcards.create.PreviewCardFragment.PreviewCardFragmentBuilder;
import com.facebook.greetingcards.model.GreetingCard;
import com.facebook.greetingcards.render.FoldingPopoverFragment;
import com.facebook.greetingcards.render.FoldingPopoverFragment.BackgroundAnimationHandler;
import com.facebook.greetingcards.render.GreetingCardPopoverFragment;
import com.facebook.greetingcards.render.RenderCardFragment;
import com.facebook.greetingcards.render.RenderCardFragment.RenderCardFragmentBuilder;
import com.facebook.greetingcards.render.StatusBarVisibilityController;
import com.facebook.greetingcards.render.templatefetch.FetchTemplateExecutor;
import com.facebook.greetingcards.render.templatefetch.TemplateResult;
import com.facebook.greetingcards.verve.VerveActionListener;
import com.facebook.greetingcards.verve.model.VMAction;
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
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: denied_scopes */
public class GreetingCardPartDefinition extends BaseSinglePartDefinition<Props, State, AnyEnvironment, GreetingCardView> {
    public static final Class<?> f7693a = GreetingCardPartDefinition.class;
    private static GreetingCardPartDefinition f7694f;
    private static final Object f7695g = new Object();
    public final GreetingCardModelUtils f7696b;
    public final AbstractFbErrorReporter f7697c;
    public final Executor f7698d;
    public final FetchTemplateExecutor f7699e;

    /* compiled from: denied_scopes */
    public class Props {
        public final GraphQLGreetingCard f7684a;
        public final Boolean f7685b;
        public final Boolean f7686c;

        public Props(GraphQLGreetingCard graphQLGreetingCard, Boolean bool, Boolean bool2) {
            this.f7684a = graphQLGreetingCard;
            this.f7685b = bool;
            this.f7686c = bool2;
        }
    }

    /* compiled from: denied_scopes */
    public class State {
        public TemplateResult f7687a;
        public final int f7688b;
        public OnClickListener f7689c;
        public GreetingCardPopoverFragment f7690d;
        public FoldingPopoverFragment f7691e;
        public StatusBarVisibilityController f7692f;

        public State(int i) {
            this.f7688b = i;
        }
    }

    private static GreetingCardPartDefinition m8884b(InjectorLike injectorLike) {
        return new GreetingCardPartDefinition(FetchTemplateExecutor.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), GreetingCardModelUtils.m8877a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public final Object m8885a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int parseColor;
        final Props props = (Props) obj;
        final GreetingCard a = this.f7696b.m8879a(props.f7684a);
        String n = props.f7684a.n();
        ImmutableList l = props.f7684a.j().l();
        int size = l.size();
        int i = 0;
        while (i < size) {
            GraphQLGreetingCardTemplateTheme graphQLGreetingCardTemplateTheme = (GraphQLGreetingCardTemplateTheme) l.get(i);
            if (Objects.equal(graphQLGreetingCardTemplateTheme.j(), n)) {
                try {
                    parseColor = Color.parseColor("#" + graphQLGreetingCardTemplateTheme.a());
                    break;
                } catch (Throwable e) {
                    this.f7697c.a("feedplugins.greetingcard.binder", "Failed to parse GreetingCard attachment style title text color", e);
                    parseColor = 0;
                }
            } else {
                i++;
            }
        }
        parseColor = 0;
        final State state = new State(parseColor);
        state.f7689c = new OnClickListener(this) {
            final /* synthetic */ GreetingCardPartDefinition f7678d;

            public void onClick(View view) {
                RenderCardFragment a;
                int a2 = Logger.a(2, EntryType.UI_INPUT_START, -563363437);
                final Context context = view.getContext();
                if (props.f7685b.booleanValue()) {
                    a = GreetingCardPartDefinition.m8882a(this.f7678d, context, a, "feed");
                } else {
                    a = GreetingCardPartDefinition.m8883a(this.f7678d, state, context, a, props.f7686c.booleanValue());
                }
                if (state.f7687a != null) {
                    a.a(state.f7687a);
                }
                final View a3 = FbRootViewUtil.a(context);
                final View findViewById = view.findViewById(2131562609);
                final Activity activity = (Activity) ContextUtils.a(view.getContext(), Activity.class);
                if (activity != null) {
                    state.f7692f = new StatusBarVisibilityController(activity.getWindow());
                }
                if (VERSION.SDK_INT >= 12 && findViewById != null) {
                    try {
                        if (state.f7691e == null) {
                            state.f7691e = new FoldingPopoverFragment();
                        }
                        state.f7691e.a(a);
                        if (state.f7691e.ap()) {
                            LogUtils.a(-145888692, a2);
                            return;
                        }
                        final View view2 = view;
                        view.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                            public final /* synthetic */ C09791 f7674g;

                            /* compiled from: denied_scopes */
                            public class C09771 {
                                public final /* synthetic */ C09781 f7667a;

                                C09771(C09781 c09781) {
                                    this.f7667a = c09781;
                                }
                            }

                            public void onGlobalLayout() {
                                if (activity != null && activity.findViewById(16908290).getY() == 0.0f) {
                                    Rect a = CustomViewUtils.a(findViewById);
                                    a.left += findViewById.getPaddingLeft();
                                    a.top += findViewById.getPaddingTop();
                                    a.right -= findViewById.getPaddingRight();
                                    a.bottom -= findViewById.getPaddingBottom();
                                    Bitmap createBitmap = Bitmap.createBitmap(a.width(), a.height(), Config.RGB_565);
                                    Canvas canvas = new Canvas(createBitmap);
                                    canvas.drawColor(-1);
                                    canvas.translate((float) (-findViewById.getPaddingLeft()), (float) (-findViewById.getPaddingTop()));
                                    canvas.clipRect(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getWidth(), findViewById.getHeight());
                                    findViewById.draw(canvas);
                                    if (state.f7687a == null) {
                                        a.ar = true;
                                        state.f7691e.ax = new C09771(this);
                                    } else {
                                        a.ar = false;
                                        state.f7691e.ax = null;
                                    }
                                    FoldingPopoverFragment foldingPopoverFragment = state.f7691e;
                                    foldingPopoverFragment.aq = a;
                                    FoldingPopoverFragment foldingPopoverFragment2 = foldingPopoverFragment;
                                    foldingPopoverFragment2.ar = createBitmap;
                                    foldingPopoverFragment2 = foldingPopoverFragment2;
                                    foldingPopoverFragment2.ao = a;
                                    foldingPopoverFragment2 = foldingPopoverFragment2;
                                    FragmentManager kO_ = Util.a(context).kO_();
                                    Window window = activity.getWindow();
                                    View view = a3;
                                    if (kO_.c()) {
                                        foldingPopoverFragment2.av = new BackgroundAnimationHandler(foldingPopoverFragment2, view, window);
                                        foldingPopoverFragment2.az = kO_;
                                        foldingPopoverFragment2.a(2, 2131625656);
                                        if (!foldingPopoverFragment2.mx_()) {
                                            foldingPopoverFragment2.a(kO_, "chromeless:content:fragment:tag");
                                            kO_.b();
                                        }
                                    } else {
                                        foldingPopoverFragment2.getClass();
                                        foldingPopoverFragment2.at.a(FoldingPopoverFragment.am, "Unsafe to commit stateful transactions.");
                                    }
                                    view2.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                                }
                            }
                        });
                        if (state.f7692f != null) {
                            state.f7692f.a();
                        }
                    } catch (Throwable e) {
                        this.f7678d.f7697c.a("feedplugins.greetingcard.binder", "OutOfMemory creating the bitmap for the cover", e);
                        if (state.f7692f != null) {
                            state.f7692f.b();
                        }
                        if (activity == null) {
                            BLog.b(GreetingCardPartDefinition.f7693a, "couldn't find activity");
                            LogUtils.a(-571102450, a2);
                            return;
                        }
                        state.f7690d = GreetingCardPopoverFragment.a(a, Util.a(context).kO_(), activity.getWindow(), a3);
                    }
                } else if (activity == null) {
                    BLog.b(GreetingCardPartDefinition.f7693a, "couldn't find activity");
                    LogUtils.a(-1297466903, a2);
                    return;
                } else {
                    state.f7690d = GreetingCardPopoverFragment.a(a, Util.a(context).kO_(), activity.getWindow(), a3);
                }
                LogUtils.a(-1684171643, a2);
            }
        };
        return state;
    }

    public final void m8887b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((GreetingCardView) view).setOnClickListener(null);
    }

    public static GreetingCardPartDefinition m8881a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GreetingCardPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7695g) {
                GreetingCardPartDefinition greetingCardPartDefinition;
                if (a2 != null) {
                    greetingCardPartDefinition = (GreetingCardPartDefinition) a2.a(f7695g);
                } else {
                    greetingCardPartDefinition = f7694f;
                }
                if (greetingCardPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8884b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7695g, b3);
                        } else {
                            f7694f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = greetingCardPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GreetingCardPartDefinition(FetchTemplateExecutor fetchTemplateExecutor, Executor executor, GreetingCardModelUtils greetingCardModelUtils, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f7696b = greetingCardModelUtils;
        this.f7697c = abstractFbErrorReporter;
        this.f7699e = fetchTemplateExecutor;
        this.f7698d = executor;
    }

    static /* synthetic */ RenderCardFragment m8882a(GreetingCardPartDefinition greetingCardPartDefinition, Context context, GreetingCard greetingCard, String str) {
        Resources resources = context.getResources();
        PreviewCardFragmentBuilder previewCardFragmentBuilder = new PreviewCardFragmentBuilder();
        previewCardFragmentBuilder.a(ImmutableList.of(resources.getString(2131241468), resources.getString(2131241469)));
        if (greetingCard != null) {
            previewCardFragmentBuilder.a(greetingCard);
        }
        previewCardFragmentBuilder.b.putString("args_source", str);
        return previewCardFragmentBuilder.b();
    }

    public static RenderCardFragment m8883a(GreetingCardPartDefinition greetingCardPartDefinition, final State state, @Nullable final Context context, GreetingCard greetingCard, boolean z) {
        Resources resources = context.getResources();
        RenderCardFragmentBuilder renderCardFragmentBuilder = new RenderCardFragmentBuilder(1);
        if (greetingCard != null) {
            renderCardFragmentBuilder.a(greetingCard);
        }
        if (z) {
            renderCardFragmentBuilder.a(ImmutableList.of(resources.getString(2131241472)));
        } else {
            renderCardFragmentBuilder.a(ImmutableList.of(resources.getString(2131241470)));
        }
        RenderCardFragment b = renderCardFragmentBuilder.b();
        b.ap = new VerveActionListener(greetingCardPartDefinition) {
            final /* synthetic */ GreetingCardPartDefinition f7683c;

            public final void m8880a(VMAction vMAction, View view) {
                if ("button1".equals(vMAction.type)) {
                    RenderCardFragment a = GreetingCardPartDefinition.m8882a(this.f7683c, context, null, "card");
                    if (state.f7690d != null) {
                        state.f7690d.a(a);
                    } else if (state.f7691e != null) {
                        state.f7691e.a(a);
                    }
                }
            }
        };
        return b;
    }
}
