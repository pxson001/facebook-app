package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.richdocument.model.block.Annotation;
import com.facebook.richdocument.model.block.Annotation.AnnotationAlignment;
import com.facebook.richdocument.model.block.Annotation.AnnotationSlot;
import com.facebook.richdocument.model.block.Annotation.AnnotationStyle;
import com.facebook.richdocument.model.block.Annotation.AnnotationType;
import com.facebook.richdocument.model.block.AudioAnnotation;
import com.facebook.richdocument.model.block.FeedbackAnnotation;
import com.facebook.richdocument.model.block.LocationAnnotation;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentLocationAnnotationModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextAnnotationModel;
import com.facebook.richdocument.presenter.BlockPresenter;
import com.facebook.richdocument.view.autoplay.ViewLocationTracker;
import com.facebook.richdocument.view.autoplay.ViewLocationTracker.ViewLocationOffsetParams;
import com.facebook.richdocument.view.autoplay.ViewLocationTracker.ViewLocationOffsetParams.Unit;
import com.facebook.richdocument.view.block.AudioAnnotationAware;
import com.facebook.richdocument.view.block.AudioAnnotationAware.AudioAnnotationActionCondition;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.block.BlockViewUtil.C07482;
import com.facebook.richdocument.view.block.FeedbackAware;
import com.facebook.richdocument.view.block.LocationAnnotationAware;
import com.facebook.richdocument.view.block.TextAnnotationAware;
import com.facebook.richdocument.view.transition.AbstractTransitionStrategy;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.MediaTransitionStrategy;
import com.facebook.richdocument.view.transition.TransitionStrategyFactory;
import com.facebook.richdocument.view.transition.TransitionStrategyFactory.StrategyType;
import com.facebook.richdocument.view.util.RichDocumentLayoutDirection;
import com.facebook.richdocument.view.widget.AnnotationView;
import com.facebook.richdocument.view.widget.AudioAnnotationView;
import com.facebook.richdocument.view.widget.LocationAnnotationView;
import com.facebook.richdocument.view.widget.TextAnnotationView;
import com.facebook.richdocument.view.widget.UFIView;
import com.facebook.richdocument.view.widget.UFIView.ComposerLaunchParams;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.MediaFrameBody;
import com.facebook.richdocument.view.widget.media.MediaView;
import com.facebook.richdocument.view.widget.media.plugins.ExpandedOnlyMediaFramePlugin;
import com.facebook.richdocument.view.widget.media.plugins.MapUnderlayPlugin;
import com.facebook.richdocument.view.widget.media.plugins.MediaFramePlugin;
import com.facebook.richdocument.view.widget.media.plugins.MediaRotationPlugin;
import com.facebook.richdocument.view.widget.media.plugins.MediaTiltPlugin;
import com.facebook.richdocument.view.widget.media.plugins.MediaTiltPlugin.PluginState;
import com.facebook.richdocument.view.widget.media.plugins.SlideshowSyncPlugin;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import java.util.Collections;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: page_position */
public class MediaBlockView<T extends BlockPresenter, V extends MediaView> extends AbstractBlockView<T> implements AudioAnnotationAware, FeedbackAware, LocationAnnotationAware, TextAnnotationAware {
    public final MediaFrame<V> f6634a;
    @Inject
    public ViewLocationTracker f6635e;
    @Inject
    AbstractFbErrorReporter f6636f;
    @Inject
    TransitionStrategyFactory f6637g;
    @Inject
    public BlockViewUtil f6638h;
    @Inject
    public RichDocumentLayoutDirection f6639i;

    public static void m6972a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MediaBlockView) obj).m6971a(ViewLocationTracker.m6897a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), TransitionStrategyFactory.m7291a(injectorLike), BlockViewUtil.m6915a(injectorLike), RichDocumentLayoutDirection.m7366a(injectorLike));
    }

    public MediaBlockView(MediaFrame mediaFrame, View view) {
        super(view);
        Class cls = MediaBlockView.class;
        m6972a((Object) this, getContext());
        this.f6634a = mediaFrame;
        MediaFrameBody mediaFrameBody = (MediaFrameBody) mediaFrame.mo480b().findViewById(2131563003);
        mediaFrameBody.f7587d = (MediaView) mediaFrame.mo480b().findViewById(2131563004);
        mediaFrame.setBody(mediaFrameBody);
    }

    public void mo374a(Bundle bundle) {
        StrategyType strategyType;
        TracerDetour.a("MediaBlockView.reset", 965823332);
        super.mo374a(bundle);
        MediaFrame mediaFrame = this.f6634a;
        mediaFrame.mo437a();
        if (bundle == null || !bundle.containsKey("strategyType")) {
            strategyType = StrategyType.ASPECT_FIT;
        } else {
            strategyType = StrategyType.valueOf(bundle.getString("strategyType"));
        }
        StrategyType strategyType2 = strategyType;
        TracerDetour.a("MediaBlockView.reset#getTransitionStrategy", -884939959);
        boolean z = false;
        if (bundle != null && bundle.containsKey("isCoverMedia")) {
            z = Boolean.valueOf(bundle.getString("isCoverMedia", Boolean.toString(false))).booleanValue();
        }
        AbstractTransitionStrategy a = m6974a(mediaFrame, strategyType2, z);
        TracerDetour.a(-240453673);
        mediaFrame.setTransitionStrategy((MediaTransitionStrategy) a);
        if (strategyType2 != StrategyType.ASPECT_FIT_SLIDE && strategyType2 != StrategyType.FULLSCREEN_SLIDE) {
            m6987b(SlideshowSyncPlugin.class);
        } else if (!m6973c(SlideshowSyncPlugin.class)) {
            m6983a(new SlideshowSyncPlugin(mediaFrame));
        }
        if (strategyType2 != StrategyType.FULLSCREEN) {
            m6987b(ExpandedOnlyMediaFramePlugin.class);
        } else if (!m6973c(ExpandedOnlyMediaFramePlugin.class)) {
            m6983a(new ExpandedOnlyMediaFramePlugin(mediaFrame));
        }
        if (a instanceof MediaTransitionStrategy) {
            if (!((MediaTransitionStrategy) a).mo419j()) {
                m6987b(MediaRotationPlugin.class);
            } else if (!m6973c(MediaRotationPlugin.class)) {
                m6983a(new MediaRotationPlugin(mediaFrame));
            }
        }
        TracerDetour.a(-2111605657);
    }

    public void mo378b(Bundle bundle) {
        super.mo378b(bundle);
        this.f6634a.mo483d();
        ViewLocationTracker viewLocationTracker = this.f6635e;
        AbstractFbErrorReporter abstractFbErrorReporter = this.f6636f;
        if (this instanceof AudioAnnotationAware) {
            viewLocationTracker.m6902a(iY_(), new ViewLocationOffsetParams(Unit.PERCENTAGE, 0), new C07482(this));
            return;
        }
        SoftErrorBuilder a = SoftError.a(BlockViewUtil.f6595a, "set up audio annotation auto play failed");
        a.c = new IllegalArgumentException("The view is not audio annotation aware");
        abstractFbErrorReporter.a(a.g());
    }

    public void mo379c(Bundle bundle) {
        super.mo379c(bundle);
        this.f6634a.mo484e();
        ViewLocationTracker viewLocationTracker = this.f6635e;
        AbstractFbErrorReporter abstractFbErrorReporter = this.f6636f;
        if (this instanceof AudioAnnotationAware) {
            AudioAnnotationAware audioAnnotationAware = this;
            viewLocationTracker.m6901a(iY_());
            mo394b(AudioAnnotationActionCondition.ENFORCED);
            return;
        }
        SoftErrorBuilder a = SoftError.a(BlockViewUtil.f6595a, "cancel audio annotation auto play failed");
        a.c = new IllegalArgumentException("The view is not audio annotation aware");
        abstractFbErrorReporter.a(a.g());
    }

    public final void mo392a(RichDocumentTextAnnotationModel richDocumentTextAnnotationModel, RichDocumentTextAnnotationModel richDocumentTextAnnotationModel2, RichDocumentTextAnnotationModel richDocumentTextAnnotationModel3) {
        BlockViewUtil blockViewUtil = this.f6638h;
        getContext();
        blockViewUtil.m6925a(this.f6634a, richDocumentTextAnnotationModel, richDocumentTextAnnotationModel2, richDocumentTextAnnotationModel3);
    }

    public void mo391a(RichDocumentLocationAnnotationModel richDocumentLocationAnnotationModel) {
        BlockViewUtil blockViewUtil = this.f6638h;
        Context context = getContext();
        MediaFrame mediaFrame = this.f6634a;
        RichDocumentStyleModel richDocumentStyleModel = blockViewUtil.f6601e.f5119g;
        if (richDocumentLocationAnnotationModel != null) {
            ViewGroup viewGroup = (ViewGroup) mediaFrame;
            Locale locale = context.getResources().getConfiguration().locale;
            if (!StringUtil.c(richDocumentLocationAnnotationModel.m6032c())) {
                View a = LocationAnnotationView.m7491a(context, viewGroup, new LocationAnnotation(richDocumentLocationAnnotationModel.m6032c().toUpperCase(locale), AnnotationStyle.MINI_LABEL, blockViewUtil.f6600d.m7369a() ? AnnotationAlignment.RIGHT : AnnotationAlignment.LEFT, AnnotationSlot.TOP, richDocumentLocationAnnotationModel, richDocumentStyleModel));
                blockViewUtil.m6924a(a);
                mediaFrame.mo407a(a);
            }
            if (!StringUtil.c(richDocumentLocationAnnotationModel.m6031b())) {
                View view = (TextAnnotationView) blockViewUtil.f6598b.m7358a(2130906862);
                view.setAnnotation(new Annotation(AnnotationType.SUBTITLE, richDocumentLocationAnnotationModel.m6031b().toUpperCase(locale), AnnotationStyle.REGULAR, blockViewUtil.f6600d.m7369a() ? AnnotationAlignment.RIGHT : AnnotationAlignment.LEFT, AnnotationSlot.TOP, richDocumentStyleModel));
                blockViewUtil.m6924a(view);
                mediaFrame.mo407a(view);
            }
        }
        if (richDocumentLocationAnnotationModel != null && richDocumentLocationAnnotationModel.m6028a() != null) {
            ((MapUnderlayPlugin) m6975a(MapUnderlayPlugin.class)).m7939a(1, Collections.singletonList(richDocumentLocationAnnotationModel));
        }
    }

    public final void mo390a(AudioAnnotation audioAnnotation) {
        if (audioAnnotation != null && !StringUtil.a(audioAnnotation.f5615a)) {
            View a = AudioAnnotationView.m7406a(getContext(), this.f6634a.mo480b(), audioAnnotation);
            this.f6638h.m6924a(a);
            this.f6634a.mo407a(a);
        }
    }

    public final void mo389a(GraphQLDocumentFeedbackOptions graphQLDocumentFeedbackOptions, GraphQLFeedback graphQLFeedback) {
        FeedbackAnnotation a = FeedbackAnnotation.m5432a(graphQLDocumentFeedbackOptions, graphQLFeedback, this.f6639i);
        if (a != null) {
            UFIView uFIView = (UFIView) this.f6634a.getAnnotationViews().m7392a(AnnotationType.UFI);
            if (uFIView == null) {
                BlockViewUtil blockViewUtil = this.f6638h;
                View view = (UFIView) blockViewUtil.f6598b.m7358a(2130906884);
                if (view != null) {
                    blockViewUtil.m6924a(view);
                }
                uFIView = view;
                uFIView.setAnnotation(a);
                this.f6634a.mo407a(uFIView);
            } else {
                uFIView.setAnnotation(a);
            }
            if (uFIView != null) {
                uFIView.f7546q = mo397d();
            }
        }
    }

    private void m6971a(ViewLocationTracker viewLocationTracker, AbstractFbErrorReporter abstractFbErrorReporter, TransitionStrategyFactory transitionStrategyFactory, BlockViewUtil blockViewUtil, RichDocumentLayoutDirection richDocumentLayoutDirection) {
        this.f6635e = viewLocationTracker;
        this.f6636f = abstractFbErrorReporter;
        this.f6637g = transitionStrategyFactory;
        this.f6638h = blockViewUtil;
        this.f6639i = richDocumentLayoutDirection;
    }

    protected ComposerLaunchParams mo397d() {
        return null;
    }

    public boolean mo377a(int i, int i2) {
        MediaTiltPlugin mediaTiltPlugin = (MediaTiltPlugin) m6975a(MediaTiltPlugin.class);
        if (mediaTiltPlugin == null) {
            return false;
        }
        return mediaTiltPlugin.f7691j == PluginState.TOUCH;
    }

    private <T extends MediaFramePlugin> boolean m6973c(Class<T> cls) {
        if (!this.f6634a.mo494a((Class) cls)) {
            return false;
        }
        m6975a((Class) cls).mo508c();
        return true;
    }

    public final <T extends MediaFramePlugin> T m6975a(Class<T> cls) {
        return this.f6634a.mo495b(cls);
    }

    public final void mo393a(AudioAnnotationActionCondition audioAnnotationActionCondition) {
        AnnotationView a = this.f6634a.getBody().getAnnotationViews().m7392a(AnnotationType.AUDIO);
        if (a != null && (a instanceof AudioAnnotationView)) {
            ((AudioAnnotationView) a).m7416a(audioAnnotationActionCondition);
        }
    }

    public final void m6982a(MediaTransitionState mediaTransitionState) {
        this.f6634a.getTransitionStrategy().f6949d = mediaTransitionState;
    }

    public final void m6983a(MediaFramePlugin mediaFramePlugin) {
        this.f6634a.mo492a(mediaFramePlugin);
    }

    public final void mo394b(AudioAnnotationActionCondition audioAnnotationActionCondition) {
        AnnotationView a = this.f6634a.getBody().getAnnotationViews().m7392a(AnnotationType.AUDIO);
        if (a != null && (a instanceof AudioAnnotationView)) {
            ((AudioAnnotationView) a).m7417b(audioAnnotationActionCondition);
        }
    }

    protected final <T extends MediaFramePlugin> void m6987b(Class<T> cls) {
        this.f6634a.mo497c(cls);
    }

    protected final MediaFrame<V> m6990f() {
        return this.f6634a;
    }

    public final V m6992h() {
        return this.f6634a.getMediaView();
    }

    public View m6991g() {
        return iY_();
    }

    protected AbstractTransitionStrategy m6974a(MediaFrame mediaFrame, StrategyType strategyType, boolean z) {
        return this.f6637g.m7292a(strategyType, getContext(), mediaFrame, z);
    }
}
