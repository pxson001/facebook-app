package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.os.Bundle;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CreativeChangedEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ErrorDialogEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedAdAccountChangeEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedAdAccountChangeEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ServerValidationRequestEvent;
import com.facebook.adinterfaces.model.AdInterfacesDataValidation;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.model.boostpost.HasAdCreative;
import com.facebook.adinterfaces.protocol.UploadAdImageMethod.Params;
import com.facebook.adinterfaces.protocol.UploadAdImageMethod.Result;
import com.facebook.adinterfaces.ui.AdCreativeController.C25624;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.content.event.FbEvent;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import java.io.File;
import javax.inject.Inject;

/* compiled from: Unknown mutation type  */
public class UploadImageHelper {
    private static final CallerContext f23186a = CallerContext.a(AdCreativeController.class);
    public DialogBasedProgressIndicator f23187b;
    private final DefaultBlueServiceOperationFactory f23188c;
    public final TasksManager f23189d;
    public AdInterfacesErrorReporter f23190e;

    /* compiled from: Unknown mutation type  */
    public final class C27292 extends SelectedAdAccountChangeEventSubscriber {
        final /* synthetic */ HasAdCreative f23184a;
        final /* synthetic */ AdInterfacesContext f23185b;

        public C27292(HasAdCreative hasAdCreative, AdInterfacesContext adInterfacesContext) {
            this.f23184a = hasAdCreative;
            this.f23185b = adInterfacesContext;
        }

        public final void m25157b(FbEvent fbEvent) {
            SelectedAdAccountChangeEvent selectedAdAccountChangeEvent = (SelectedAdAccountChangeEvent) fbEvent;
            if (!selectedAdAccountChangeEvent.f21675b.equals(selectedAdAccountChangeEvent.f21674a)) {
                CreativeAdModel C = this.f23184a.mo951C();
                if (C != null) {
                    C.f21772e = null;
                    C.f21773f = C.f21777j;
                    this.f23185b.m22429a(new CreativeChangedEvent());
                }
            }
        }
    }

    /* compiled from: Unknown mutation type  */
    public enum Tasks {
        UPLOAD_IMAGE_TASKS
    }

    @Inject
    public UploadImageHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, TasksManager tasksManager, AdInterfacesErrorReporter adInterfacesErrorReporter) {
        this.f23188c = defaultBlueServiceOperationFactory;
        this.f23189d = tasksManager;
        this.f23190e = adInterfacesErrorReporter;
    }

    protected final void m25159a(String str, final boolean z, String str2, Context context, final C25624 c25624) {
        if (z) {
            if (this.f23187b == null) {
                this.f23187b = new DialogBasedProgressIndicator(context, 2131234053);
            }
            this.f23187b.a();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("adInterfacesUploadAdImageParams", new Params(str2, str));
        this.f23189d.a(Tasks.UPLOAD_IMAGE_TASKS, BlueServiceOperationFactoryDetour.a(this.f23188c, "ad_interfaces_upload_ad_image", bundle, ErrorPropagation.BY_EXCEPTION, f23186a, -610691601).a(), new AbstractDisposableFutureCallback<OperationResult>(this) {
            final /* synthetic */ UploadImageHelper f23183c;

            protected final void m25155a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                if (z) {
                    this.f23183c.m25158a();
                }
                C25624 c25624 = c25624;
                Result result = (Result) operationResult.h();
                if (result != null && result.f22418a != null) {
                    new File(c25624.f22449a.f22470m.f21776i).delete();
                    c25624.f22449a.f22440b.m22431a(AdInterfacesDataValidation.PHOTO_NOT_UPLOADED, true);
                    AdCreativeController adCreativeController;
                    if (c25624.f22449a.f22469l) {
                        adCreativeController = c25624.f22449a;
                        ((AdInterfacesCreativeAttachmentView) adCreativeController.f22471n.get(adCreativeController.f22473p)).setAdImageThumbnail(result.f22419b);
                    } else {
                        adCreativeController = c25624.f22449a;
                        adCreativeController.f22470m.f21772e = result.f22418a;
                        adCreativeController.f22466i = result.f22419b;
                        adCreativeController.f22470m.f21773f = adCreativeController.f22466i;
                        adCreativeController.f22468k.setAdImageThumbnail(adCreativeController.f22466i);
                    }
                    c25624.f22449a.f22440b.m22429a(new ServerValidationRequestEvent());
                }
            }

            protected final void m25156a(Throwable th) {
                this.f23183c.m25158a();
                this.f23183c.f23190e.m22727a(UploadImageHelper.class, "upload ad image failed", th);
                C25624 c25624 = c25624;
                new File(c25624.f22449a.f22470m.f21776i).delete();
                c25624.f22449a.f22440b.m22429a(new ErrorDialogEvent());
            }
        });
    }

    protected final void m25158a() {
        if (this.f23187b != null) {
            this.f23187b.b();
        }
    }
}
