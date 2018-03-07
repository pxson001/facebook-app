package com.facebook.richdocument.view.block;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLEntity.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.model.block.Annotation;
import com.facebook.richdocument.model.block.Annotation.AnnotationAlignment;
import com.facebook.richdocument.model.block.Annotation.AnnotationSlot;
import com.facebook.richdocument.model.block.Annotation.AnnotationStyle;
import com.facebook.richdocument.model.block.Annotation.AnnotationType;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextAnnotationModel;
import com.facebook.richdocument.view.autoplay.ViewLocationTracker.ViewLocationListener;
import com.facebook.richdocument.view.block.AudioAnnotationAware.AudioAnnotationActionCondition;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.util.CompositeRecyclableViewFactory;
import com.facebook.richdocument.view.util.RichDocumentLayoutDirection;
import com.facebook.richdocument.view.widget.AnnotatableView;
import com.facebook.richdocument.view.widget.PressStateButton;
import com.facebook.richdocument.view.widget.TextAnnotationView;
import com.facebook.richdocument.view.widget.UFIView.ComposerLaunchParams;
import javax.inject.Inject;

@ContextScoped
/* compiled from: pandoraType */
public final class BlockViewUtil {
    public static final String f6595a = BlockViewUtil.class.getSimpleName();
    private static BlockViewUtil f6596f;
    private static final Object f6597g = new Object();
    public final CompositeRecyclableViewFactory f6598b;
    private final HamDimensions f6599c;
    public final RichDocumentLayoutDirection f6600d;
    public final RichDocumentInfo f6601e;

    /* compiled from: pandoraType */
    public final class C07471 implements Runnable {
        final /* synthetic */ RecyclerView f6592a;

        public C07471(RecyclerView recyclerView) {
            this.f6592a = recyclerView;
        }

        public final void run() {
            this.f6592a.h();
        }
    }

    /* compiled from: pandoraType */
    public final class C07482 implements ViewLocationListener {
        final /* synthetic */ AudioAnnotationAware f6593a;

        public C07482(AudioAnnotationAware audioAnnotationAware) {
            this.f6593a = audioAnnotationAware;
        }

        public final void mo372a() {
            this.f6593a.mo393a(AudioAnnotationActionCondition.SCROLL_TRIGGERED);
        }

        public final void mo373b() {
            this.f6593a.mo394b(AudioAnnotationActionCondition.SCROLL_TRIGGERED);
        }
    }

    /* compiled from: pandoraType */
    /* synthetic */ class C07493 {
        static final /* synthetic */ int[] f6594a = new int[GraphQLDocumentMediaPresentationStyle.values().length];

        static {
            try {
                f6594a[GraphQLDocumentMediaPresentationStyle.ASPECT_FIT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6594a[GraphQLDocumentMediaPresentationStyle.FULL_SCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static BlockViewUtil m6922b(InjectorLike injectorLike) {
        return new BlockViewUtil(CompositeRecyclableViewFactory.m7356a(injectorLike), HamDimensions.m5268a(injectorLike), RichDocumentLayoutDirection.m7366a(injectorLike), RichDocumentInfo.m5102a(injectorLike));
    }

    public static BlockViewUtil m6915a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BlockViewUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6597g) {
                BlockViewUtil blockViewUtil;
                if (a2 != null) {
                    blockViewUtil = (BlockViewUtil) a2.a(f6597g);
                } else {
                    blockViewUtil = f6596f;
                }
                if (blockViewUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6922b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6597g, b3);
                        } else {
                            f6596f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = blockViewUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public BlockViewUtil(CompositeRecyclableViewFactory compositeRecyclableViewFactory, HamDimensions hamDimensions, RichDocumentLayoutDirection richDocumentLayoutDirection, RichDocumentInfo richDocumentInfo) {
        this.f6598b = compositeRecyclableViewFactory;
        this.f6599c = hamDimensions;
        this.f6600d = richDocumentLayoutDirection;
        this.f6601e = richDocumentInfo;
    }

    public final void m6924a(View view) {
        if (view.getLayoutParams() instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
            int b = this.f6599c.m5276b(2131558653);
            int b2 = this.f6599c.m5276b(2131558654);
            marginLayoutParams.leftMargin = b;
            marginLayoutParams.rightMargin = b2;
            if (VERSION.SDK_INT >= 17) {
                marginLayoutParams.setMarginStart(b);
                marginLayoutParams.setMarginEnd(b2);
            }
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public final void m6925a(AnnotatableView annotatableView, RichDocumentTextAnnotationModel richDocumentTextAnnotationModel, RichDocumentTextAnnotationModel richDocumentTextAnnotationModel2, RichDocumentTextAnnotationModel richDocumentTextAnnotationModel3) {
        RichDocumentStyleModel richDocumentStyleModel = this.f6601e.f5119g;
        if (richDocumentTextAnnotationModel != null) {
            Annotation a = Annotation.m5431a(AnnotationType.TITLE, richDocumentTextAnnotationModel, richDocumentStyleModel);
            View view = (TextAnnotationView) this.f6598b.m7358a(2130906862);
            m6924a(view);
            view.setAnnotation(a);
            annotatableView.mo407a(view);
        }
        if (richDocumentTextAnnotationModel2 != null) {
            a = Annotation.m5431a(AnnotationType.SUBTITLE, richDocumentTextAnnotationModel2, richDocumentStyleModel);
            view = (TextAnnotationView) this.f6598b.m7358a(2130906862);
            m6924a(view);
            view.setAnnotation(a);
            annotatableView.mo407a(view);
        }
        if (richDocumentTextAnnotationModel3 != null) {
            Annotation annotation = new Annotation(AnnotationType.COPYRIGHT, richDocumentTextAnnotationModel3.m6376b(), richDocumentTextAnnotationModel3.m6375a(), AnnotationStyle.MINI_LABEL, AnnotationAlignment.from(richDocumentTextAnnotationModel3.m6377c()), AnnotationSlot.from(richDocumentTextAnnotationModel3.iu_()), richDocumentStyleModel);
            View view2 = (TextAnnotationView) this.f6598b.m7358a(2130906862);
            m6924a(view2);
            view2.setAnnotation(annotation);
            annotatableView.mo407a(view2);
        }
    }

    public static ComposerLaunchParams m6917a(String str, int i) {
        Builder builder = new Builder();
        builder.m = str;
        builder = builder;
        builder.S = new GraphQLObjectType(i);
        return new ComposerLaunchParams.Builder(ComposerConfigurationFactory.a(ComposerSourceType.INSTANT_ARTICLE, null, ComposerShareParams.Builder.a(builder.a()).b()).setIsFireAndForget(true).a()).m7719a();
    }

    public static void m6919a(Drawable drawable, int i) {
        if (drawable != null) {
            drawable.mutate().setColorFilter(i, Mode.SRC_IN);
        }
    }

    public static MediaTransitionState m6916a(GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle) {
        switch (C07493.f6594a[graphQLDocumentMediaPresentationStyle.ordinal()]) {
            case 1:
                return MediaTransitionState.f6977a;
            case 2:
                return MediaTransitionState.f6978b;
            default:
                return MediaTransitionState.f6977a;
        }
    }

    public static void m6921a(PressStateButton pressStateButton, int i, int i2, int i3, int i4) {
        pressStateButton.setText(i);
        pressStateButton.setImageResource(i2);
        m6920a(pressStateButton, i3, i4);
    }

    public static void m6920a(PressStateButton pressStateButton, int i, int i2) {
        m6919a(pressStateButton.getDrawable(), i);
        pressStateButton.setTextColor(i2);
    }

    public final void m6923a(Context context, ComposerLauncher composerLauncher, String str, String str2, String str3, int i) {
        ComposerSourceType composerSourceType = ComposerSourceType.WEB_VIEW;
        ComposerShareParams.Builder a = ComposerShareParams.Builder.a(str2);
        a.e = str3;
        m6918a(i, composerLauncher, str, ComposerConfigurationFactory.a(composerSourceType, a.b()).setIsFireAndForget(true).setInitialTargetData(ComposerTargetData.a).a(), context);
    }

    public final void m6926b(Context context, ComposerLauncher composerLauncher, String str, String str2) {
        ComposerSourceType composerSourceType = ComposerSourceType.WEB_VIEW;
        ComposerShareParams.Builder a = ComposerShareParams.Builder.a(str2);
        a.f = str;
        m6918a(1001, composerLauncher, null, ComposerConfigurationFactory.b(composerSourceType, a.b()).setInitialTargetData(ComposerTargetData.a).setIsFireAndForget(true).a(), context);
    }

    private void m6918a(int i, ComposerLauncher composerLauncher, String str, ComposerConfiguration composerConfiguration, Context context) {
        FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.a(context, FragmentManagerHost.class);
        if (fragmentManagerHost == null || fragmentManagerHost.kO_().a(this.f6601e.f5118f) == null) {
            composerLauncher.a(str, composerConfiguration, context);
        } else {
            composerLauncher.a(str, composerConfiguration, i, fragmentManagerHost.kO_().a(this.f6601e.f5118f));
        }
    }
}
