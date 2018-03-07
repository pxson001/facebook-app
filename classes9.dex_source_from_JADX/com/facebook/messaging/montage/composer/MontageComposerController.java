package com.facebook.messaging.montage.composer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.ui.util.ViewPositionUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.inject.Assisted;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.media.editing.MultimediaEditorController;
import com.facebook.messaging.media.editing.MultimediaEditorControllerProvider;
import com.facebook.messaging.media.editing.MultimediaEditorView;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.photos.editing.PhotoEditingConfig;
import com.facebook.messaging.photos.editing.PhotoEditingControllerProvider;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_refresher */
public class MontageComposerController {
    private final Executor f12466a;
    private final FragmentManager f12467b;
    private final MontageCanvasViewUtilProvider f12468c;
    public final MontageComposerFragmentFactory f12469d;
    public final MontageComposerNavigationControllerProvider f12470e;
    public final MontageMessageFactory f12471f;
    public final MontageSendUtilProvider f12472g;
    private final MultimediaEditorControllerProvider f12473h;
    private final Spring f12474i;
    public MontageCanvasViewUtil f12475j;
    public MontageComposerFragment f12476k;
    public MontageComposerNavigationController f12477l;
    public MontageSendUtil f12478m;
    public MultimediaEditorController f12479n;
    public ViewGroup f12480o;

    /* compiled from: is_refresher */
    public class C13801 {
        public final /* synthetic */ MontageComposerController f12459a;

        /* compiled from: is_refresher */
        public class C13791 implements Runnable {
            final /* synthetic */ C13801 f12458a;

            public C13791(C13801 c13801) {
                this.f12458a = c13801;
            }

            public void run() {
                this.f12458a.f12459a.f12477l.m12966a(CanvasType.CAMERA);
            }
        }

        C13801(MontageComposerController montageComposerController) {
            this.f12459a = montageComposerController;
        }
    }

    /* compiled from: is_refresher */
    public class C13812 {
        public final /* synthetic */ MontageComposerController f12460a;

        public C13812(MontageComposerController montageComposerController) {
            this.f12460a = montageComposerController;
        }
    }

    /* compiled from: is_refresher */
    public class ComposerEditorListener {
        public final /* synthetic */ MontageComposerController f12464a;

        public ComposerEditorListener(MontageComposerController montageComposerController) {
            this.f12464a = montageComposerController;
        }
    }

    /* compiled from: is_refresher */
    class HideShowEditorListener extends SimpleSpringListener {
        final /* synthetic */ MontageComposerController f12465a;

        public HideShowEditorListener(MontageComposerController montageComposerController) {
            this.f12465a = montageComposerController;
        }

        public final void m12931d(Spring spring) {
            MultimediaEditorView multimediaEditorView = this.f12465a.f12479n.f11566c;
            if (spring.i == 1.0d) {
                multimediaEditorView.setAlpha(0.0f);
                multimediaEditorView.setVisibility(0);
            } else if (spring.i == 0.0d) {
                this.f12465a.f12480o.setVisibility(0);
            }
        }

        public final void m12930b(Spring spring) {
            MultimediaEditorView multimediaEditorView = this.f12465a.f12479n.f11566c;
            if (spring.i == 0.0d) {
                multimediaEditorView.setVisibility(4);
            } else if (spring.i == 1.0d) {
                this.f12465a.f12480o.setVisibility(8);
            }
        }

        public final void m12929a(Spring spring) {
            this.f12465a.f12479n.f11566c.setAlpha((float) spring.d());
        }
    }

    @Inject
    public MontageComposerController(@Assisted FragmentManager fragmentManager, Executor executor, MontageCanvasViewUtilProvider montageCanvasViewUtilProvider, MontageComposerFragmentFactory montageComposerFragmentFactory, MontageComposerNavigationControllerProvider montageComposerNavigationControllerProvider, MontageMessageFactory montageMessageFactory, MontageSendUtilProvider montageSendUtilProvider, MultimediaEditorControllerProvider multimediaEditorControllerProvider, SpringSystem springSystem) {
        this.f12466a = executor;
        this.f12467b = fragmentManager;
        this.f12469d = montageComposerFragmentFactory;
        this.f12468c = montageCanvasViewUtilProvider;
        this.f12470e = montageComposerNavigationControllerProvider;
        this.f12471f = montageMessageFactory;
        this.f12472g = montageSendUtilProvider;
        this.f12473h = multimediaEditorControllerProvider;
        Spring a = springSystem.a().a(new SpringConfig(40.0d, 7.0d)).b(1.0d).a(0.0d);
        a.c = true;
        this.f12474i = a.l().a(new HideShowEditorListener(this));
    }

    public final void m12940a() {
        if (this.f12476k == null) {
            this.f12476k = new MontageComposerFragment();
            this.f12476k.an = new C13801(this);
        }
        this.f12476k.a(this.f12467b, "montage_composer");
    }

    public static void m12935h(MontageComposerController montageComposerController) {
        MultimediaEditorView multimediaEditorView = (MontageEditorView) montageComposerController.f12476k.e(2131563973);
        MultimediaEditorControllerProvider multimediaEditorControllerProvider = montageComposerController.f12473h;
        montageComposerController.f12479n = new MultimediaEditorController(multimediaEditorView, new PhotoEditingConfig(false, false, false, false), ImagePipelineMethodAutoProvider.a(multimediaEditorControllerProvider), (PhotoEditingControllerProvider) multimediaEditorControllerProvider.getOnDemandAssistedProviderForStaticDi(PhotoEditingControllerProvider.class), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(multimediaEditorControllerProvider));
        montageComposerController.f12479n.f11576m = false;
        montageComposerController.f12479n.f11566c.setVisibility(4);
        montageComposerController.f12479n.f11572i = new ComposerEditorListener(montageComposerController);
    }

    public static void m12936j(MontageComposerController montageComposerController) {
        montageComposerController.f12479n.m12222c(true);
        montageComposerController.f12474i.b(1.0d);
        montageComposerController.f12475j.m12928a((MontageComposerCanvas) montageComposerController.f12479n.f11566c);
    }

    public static void m12937k(MontageComposerController montageComposerController) {
        montageComposerController.f12479n.m12222c(false);
        montageComposerController.f12474i.b(0.0d);
    }

    public static boolean m12938l(MontageComposerController montageComposerController) {
        return montageComposerController.f12477l.m12970g();
    }

    private void m12934b(FbFragment fbFragment) {
        if (fbFragment instanceof MontageLocationCanvasFragment) {
            ((MontageLocationCanvasFragment) fbFragment).f12527a = this;
        } else if (fbFragment instanceof MontageCameraCanvasFragment) {
            ((MontageCameraCanvasFragment) fbFragment).f12440c = this;
        } else if (fbFragment instanceof MontageMediaPickerCanvasFragment) {
            ((MontageMediaPickerCanvasFragment) fbFragment).al = this;
        }
    }

    public static <T extends FbFragment & MontageComposerCanvas> FbFragment m12939n(MontageComposerController montageComposerController) {
        return (FbFragment) montageComposerController.f12476k.s().a(montageComposerController.f12480o.getId());
    }

    public static void m12933a(MontageComposerController montageComposerController, ListenableFuture listenableFuture, final boolean z) {
        Futures.a(listenableFuture, new FutureCallback<Message>(montageComposerController) {
            final /* synthetic */ MontageComposerController f12462b;

            public void onSuccess(@Nullable Object obj) {
                Message message = (Message) obj;
                Parcelable parcelable = null;
                if (z) {
                    this.f12462b.f12477l.m12968d();
                    this.f12462b.f12479n.m12220a(false);
                    parcelable = ViewPositionUtil.a(this.f12462b.f12479n.f11566c);
                }
                MontageComposerController montageComposerController = this.f12462b;
                if (montageComposerController.f12478m == null) {
                    montageComposerController.f12478m = new MontageSendUtil(montageComposerController.f12476k.getContext(), (SecureContextHelper) DefaultSecureContextHelper.a(montageComposerController.f12472g));
                }
                MontageSendUtil montageSendUtil = montageComposerController.f12478m;
                Intent putExtra = new Intent(MessagingIntentUris.a).setData(Uri.parse(MessengerLinks.o)).putExtra("ShareType", "ShareType.montage").putExtra("message", message).putExtra("source_view_info", parcelable);
                Activity activity = (Activity) ContextUtils.a(montageSendUtil.f12552a, Activity.class);
                if (activity == null) {
                    putExtra.addFlags(268435456);
                }
                montageSendUtil.f12553b.a(putExtra, montageSendUtil.f12552a);
                if (parcelable != null && activity != null) {
                    activity.overridePendingTransition(0, 0);
                }
            }

            public void onFailure(Throwable th) {
            }
        }, montageComposerController.f12466a);
    }
}
