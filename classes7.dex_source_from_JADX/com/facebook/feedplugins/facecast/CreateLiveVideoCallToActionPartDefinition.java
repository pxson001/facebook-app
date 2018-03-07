package com.facebook.feedplugins.facecast;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.facecast.abtest.ExperimentsForFacecastAbtestModule;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.composer.launch.FeedComposerLauncher;
import com.facebook.feed.util.composer.launch.FeedComposerLauncherProvider;
import com.facebook.feed.util.composer.launch.NewsfeedLauncherContext;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionPartDefinition$Props;
import com.facebook.feedplugins.calltoaction.ActionLinkCallToActionView;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Optional;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Stuck on input/output streams */
public class CreateLiveVideoCallToActionPartDefinition<E extends FeedEnvironment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ActionLinkCallToActionView> {
    private static CreateLiveVideoCallToActionPartDefinition f23110g;
    private static final Object f23111h = new Object();
    public final Activity f23112a;
    private final Lazy<ActionLinkCallToActionPartDefinition> f23113b;
    public final QeAccessor f23114c;
    public final FeedComposerLauncher f23115d;
    private final FacecastUtil f23116e;
    public final GlyphColorizer f23117f;

    /* compiled from: Stuck on input/output streams */
    public class C19981 implements OnClickListener {
        final /* synthetic */ CreateLiveVideoCallToActionPartDefinition f23109a;

        public C19981(CreateLiveVideoCallToActionPartDefinition createLiveVideoCallToActionPartDefinition) {
            this.f23109a = createLiveVideoCallToActionPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1721681014);
            if (this.f23109a.f23114c.a(ExperimentsForFacecastAbtestModule.f2796q, false)) {
                this.f23109a.f23115d.m24962b(Optional.of(SafeUUIDGenerator.a().toString()), this.f23109a.f23112a);
            } else {
                this.f23109a.f23115d.m24953a(this.f23109a.f23112a);
            }
            LogUtils.a(821255821, a);
        }
    }

    private static CreateLiveVideoCallToActionPartDefinition m25543b(InjectorLike injectorLike) {
        return new CreateLiveVideoCallToActionPartDefinition(ActivityMethodAutoProvider.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (FeedComposerLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedComposerLauncherProvider.class), FacecastUtil.m3107b(injectorLike), IdBasedLazy.a(injectorLike, 1837), GlyphColorizer.a(injectorLike));
    }

    public final Object m25545a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        C19981 c19981 = new C19981(this);
        Drawable drawable = this.f23112a.getResources().getDrawable(2130841069);
        InsetDrawable insetDrawable = new InsetDrawable(this.f23117f.a(2130839967, -1), this.f23112a.getResources().getDimensionPixelOffset(2131432748));
        subParts.a((SinglePartDefinition) this.f23113b.get(), ActionLinkCallToActionPartDefinition$Props.m25512a(feedProps, null, c19981, null, new LayerDrawable(new Drawable[]{drawable, insetDrawable})));
        return null;
    }

    public final boolean m25546a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        if (!ActionLinkCallToActionPartDefinition.b(graphQLStory)) {
            return false;
        }
        GraphQLStoryActionLink a = ActionLinkHelper.a(StoryAttachmentHelper.o(graphQLStory));
        return a.a() != null && a.a().g() == 283228540 && this.f23116e.m3116l();
    }

    public static CreateLiveVideoCallToActionPartDefinition m25542a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CreateLiveVideoCallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23111h) {
                CreateLiveVideoCallToActionPartDefinition createLiveVideoCallToActionPartDefinition;
                if (a2 != null) {
                    createLiveVideoCallToActionPartDefinition = (CreateLiveVideoCallToActionPartDefinition) a2.a(f23111h);
                } else {
                    createLiveVideoCallToActionPartDefinition = f23110g;
                }
                if (createLiveVideoCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25543b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23111h, b3);
                        } else {
                            f23110g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = createLiveVideoCallToActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public CreateLiveVideoCallToActionPartDefinition(Activity activity, QeAccessor qeAccessor, FeedComposerLauncherProvider feedComposerLauncherProvider, FacecastUtil facecastUtil, Lazy<ActionLinkCallToActionPartDefinition> lazy, GlyphColorizer glyphColorizer) {
        this.f23112a = activity;
        this.f23113b = lazy;
        this.f23114c = qeAccessor;
        this.f23115d = feedComposerLauncherProvider.a(new NewsfeedLauncherContext("liveVideoCta"), FeedComposerLauncher.f22338a);
        this.f23116e = facecastUtil;
        this.f23117f = glyphColorizer;
    }

    public final ViewType<ActionLinkCallToActionView> m25544a() {
        return ActionLinkCallToActionView.f23054h;
    }
}
