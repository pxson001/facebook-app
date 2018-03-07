package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.AdInterfacesCreativeHelper;
import com.facebook.adinterfaces.AdInterfacesCreativeHelper.C24751;
import com.facebook.adinterfaces.AdInterfacesCreativeHelper.Dimension;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CreativeChangedEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CreativeValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CreativeValidationEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent.IntentHandler;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ServerValidationRequestEvent;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataValidation;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.ui.UploadImageHelper.Tasks;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Value */
public class AdCreativeController extends BaseAdInterfacesViewController<AdInterfacesAdCreativeView, AdInterfacesBoostedComponentDataModel> {
    public static final Builder f22458a = new Builder(SimplePickerSource.PAGE).k().i().h().a(Action.LAUNCH_AD_IMAGE_CROPPER);
    public final QeAccessor f22459b;
    private final UploadImageHelper f22460c;
    private final OnClickListener f22461d;
    private final C25624 f22462e;
    public final TextWatcher f22463f;
    public final TextWatcher f22464g;
    public final AdInterfacesReactUtil f22465h;
    public String f22466i;
    public AdInterfacesBoostedComponentDataModel f22467j;
    public AdInterfacesAdCreativeView f22468k;
    public boolean f22469l = false;
    public CreativeAdModel f22470m;
    public List<AdInterfacesCreativeAttachmentView> f22471n;
    public String f22472o;
    public int f22473p;

    /* compiled from: Value */
    abstract class BaseTextWatcher implements TextWatcher {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: Value */
    class C25591 extends BaseTextWatcher {
        final /* synthetic */ AdCreativeController f22446a;

        C25591(AdCreativeController adCreativeController) {
            this.f22446a = adCreativeController;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!charSequence.equals(this.f22446a.f22470m.f21769b)) {
                AdCreativeController.m24322b(this.f22446a, charSequence);
                this.f22446a.f22440b.m22429a(new CreativeChangedEvent());
                this.f22446a.f22440b.m22429a(new ServerValidationRequestEvent());
            }
        }
    }

    /* compiled from: Value */
    class C25602 extends BaseTextWatcher {
        final /* synthetic */ AdCreativeController f22447a;

        C25602(AdCreativeController adCreativeController) {
            this.f22447a = adCreativeController;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!charSequence.equals(this.f22447a.f22470m.f21770c)) {
                AdCreativeController.m24324c(this.f22447a, charSequence);
                this.f22447a.f22440b.m22429a(new CreativeChangedEvent());
                this.f22447a.f22440b.m22429a(new ServerValidationRequestEvent());
            }
        }
    }

    /* compiled from: Value */
    class C25613 implements OnClickListener {
        final /* synthetic */ AdCreativeController f22448a;

        C25613(AdCreativeController adCreativeController) {
            this.f22448a = adCreativeController;
        }

        public void onClick(View view) {
            Intent a;
            int a2 = Logger.a(2, EntryType.UI_INPUT_START, 2000172431);
            if (this.f22448a.f22465h.m24852b()) {
                Dimension dimension;
                Context context = view.getContext();
                AdInterfacesReactUtil adInterfacesReactUtil = this.f22448a.f22465h;
                BaseAdInterfacesData baseAdInterfacesData = this.f22448a.f22467j;
                String str = baseAdInterfacesData.f21747c;
                switch (C24751.f21486a[baseAdInterfacesData.mo962b().ordinal()]) {
                    case 1:
                    case 2:
                        dimension = new Dimension(1200, 444);
                        break;
                    default:
                        dimension = new Dimension(1200, 628);
                        break;
                }
                a = adInterfacesReactUtil.m24850a(context, str, dimension, AdInterfacesCreativeHelper.m22434b(baseAdInterfacesData.mo962b()));
            } else {
                a = SimplePickerIntent.a(view.getContext(), AdCreativeController.f22458a);
            }
            this.f22448a.m24311l().m22429a(new IntentEvent(a, 20006));
            LogUtils.a(603578231, a2);
        }
    }

    /* compiled from: Value */
    public class C25624 {
        public final /* synthetic */ AdCreativeController f22449a;

        C25624(AdCreativeController adCreativeController) {
            this.f22449a = adCreativeController;
        }
    }

    /* compiled from: Value */
    class C25635 implements IntentHandler {
        final /* synthetic */ AdCreativeController f22450a;

        C25635(AdCreativeController adCreativeController) {
            this.f22450a = adCreativeController;
        }

        public final void mo980a(int i, Intent intent) {
            if (i == -1) {
                if (this.f22450a.f22465h.m24852b()) {
                    this.f22450a.m24331a(intent.getStringExtra("file_path"));
                    return;
                }
                this.f22450a.m24331a(((EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a)).b.getPath());
            }
        }
    }

    /* compiled from: Value */
    class C25657 implements OnClickListener {
        final /* synthetic */ AdCreativeController f22453a;

        C25657(AdCreativeController adCreativeController) {
            this.f22453a = adCreativeController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1456209483);
            this.f22453a.f22471n.add(AdCreativeController.m24319a(this.f22453a, false));
            Logger.a(2, EntryType.UI_INPUT_END, 868221820, a);
        }
    }

    public static AdCreativeController m24321b(InjectorLike injectorLike) {
        return new AdCreativeController(new UploadImageHelper(DefaultBlueServiceOperationFactory.b(injectorLike), TasksManager.b(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike)), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), AdInterfacesReactUtil.m24849b(injectorLike));
    }

    public final void mo982a(View view, @Nullable final AdInterfacesCardLayout adInterfacesCardLayout) {
        AdInterfacesAdCreativeView adInterfacesAdCreativeView = (AdInterfacesAdCreativeView) view;
        super.mo982a(adInterfacesAdCreativeView, adInterfacesCardLayout);
        this.f22468k = adInterfacesAdCreativeView;
        m24323c();
        this.f22440b.m22428a(20006, new C25635(this));
        this.f22440b.m22430a(new CreativeValidationEventSubscriber(this) {
            final /* synthetic */ AdCreativeController f22452b;

            public final void m24318b(FbEvent fbEvent) {
                adInterfacesCardLayout.m24584a(((CreativeValidationEvent) fbEvent).f21655a);
            }
        });
        boolean z = false;
        if (this.f22467j.mo962b() == ObjectiveType.PROMOTE_WEBSITE_EDIT_CREATIVE) {
            z = this.f22459b.a(ExperimentsForAdInterfacesModule.f21610g, false);
        }
        if (z) {
            this.f22469l = true;
            adInterfacesCardLayout.setCallToActionVisibility(8);
            this.f22468k.m24374a();
            this.f22468k.m24377b();
            this.f22468k.m24379c();
            this.f22472o = this.f22468k.getResources().getString(2131234042);
            this.f22471n = new ArrayList();
            this.f22471n.add(m24319a(this, true));
            this.f22468k.setAddAttachmentListener(new C25657(this));
        }
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22467j = (AdInterfacesBoostedComponentDataModel) baseAdInterfacesData;
        this.f22470m = this.f22467j.mo951C();
    }

    @Inject
    public AdCreativeController(UploadImageHelper uploadImageHelper, QeAccessor qeAccessor, AdInterfacesReactUtil adInterfacesReactUtil) {
        this.f22460c = uploadImageHelper;
        this.f22459b = qeAccessor;
        this.f22465h = adInterfacesReactUtil;
        this.f22463f = new C25591(this);
        this.f22464g = new C25602(this);
        this.f22461d = new C25613(this);
        this.f22462e = new C25624(this);
    }

    private void m24320a(CharSequence charSequence) {
        if (m24326f()) {
            this.f22440b.m22431a(AdInterfacesDataValidation.PAGE_LIKE_BODY_TEXT, !StringUtil.c(charSequence));
        }
    }

    public final void m24331a(String str) {
        this.f22470m.f21776i = str;
        this.f22467j.mo952a(this.f22470m);
        this.f22460c.m25159a(str, true, this.f22467j.m22853i(), this.f22468k.getContext(), this.f22462e);
    }

    private void m24323c() {
        String str = this.f22470m.f21770c;
        CharSequence charSequence = this.f22470m.f21769b;
        if (!(m24326f() || charSequence == null || charSequence.length() <= this.f22468k.f22503b)) {
            charSequence = charSequence.substring(0, this.f22468k.f22503b);
        }
        if (this.f22466i == null) {
            this.f22466i = this.f22470m.f21773f;
        }
        this.f22468k.setAdImageThumbnail(this.f22466i);
        m24325d();
        if (m24326f()) {
            this.f22468k.m24374a();
        } else {
            this.f22468k.setHeadlineText(charSequence);
            m24322b(this, charSequence);
        }
        this.f22468k.setDescriptionText(str);
        m24324c(this, str);
    }

    private void m24325d() {
        if (!m24326f()) {
            this.f22468k.m24375a(this.f22463f);
        }
        this.f22468k.m24378b(this.f22464g);
        this.f22468k.setOnImagePickerButtonClick(this.f22461d);
    }

    public static void m24322b(AdCreativeController adCreativeController, CharSequence charSequence) {
        adCreativeController.f22468k.setHeadlineRemainingCharacters(adCreativeController.f22468k.f22503b - charSequence.length());
        adCreativeController.f22470m.f21769b = charSequence.toString();
    }

    public static void m24324c(AdCreativeController adCreativeController, CharSequence charSequence) {
        adCreativeController.f22470m.f21770c = charSequence.toString();
        adCreativeController.m24320a(charSequence);
    }

    public final void mo981a() {
        super.mo981a();
        this.f22468k.m24380c(this.f22463f);
        this.f22468k.m24381d(this.f22464g);
        this.f22471n = null;
        this.f22468k = null;
        this.f22460c.f23189d.c(Tasks.UPLOAD_IMAGE_TASKS);
    }

    public final void mo984a(Bundle bundle) {
        bundle.putParcelable("current_creative_ad_model", this.f22470m);
        bundle.putString("current_photo_url", this.f22466i);
    }

    public final void mo985b(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.f22466i = bundle.getString("current_photo_url");
            this.f22470m = (CreativeAdModel) bundle.getParcelable("current_creative_ad_model");
            this.f22467j.mo952a(this.f22470m);
            m24323c();
        }
    }

    private boolean m24326f() {
        return this.f22467j.mo962b() == ObjectiveType.PAGE_LIKE_EDIT_CREATIVE || this.f22467j.mo962b() == ObjectiveType.PAGE_LIKE;
    }

    public static AdInterfacesCreativeAttachmentView m24319a(AdCreativeController adCreativeController, boolean z) {
        final AdInterfacesCreativeAttachmentView a = adCreativeController.f22468k.m24373a(adCreativeController.f22472o, adCreativeController.f22471n.size());
        if (z) {
            a.f22672d.setVisibility(8);
            a.f22677i.setVisibility(8);
        } else {
            a.f22671c.setOnClickListener(new OnClickListener(adCreativeController) {
                final /* synthetic */ AdCreativeController f22445b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 118867405);
                    this.f22445b.f22468k.m24376a(a);
                    this.f22445b.f22471n.remove(a.f22676h);
                    AdCreativeController adCreativeController = this.f22445b;
                    for (int i = 1; i < adCreativeController.f22471n.size(); i++) {
                        ((AdInterfacesCreativeAttachmentView) adCreativeController.f22471n.get(i)).m24596a(adCreativeController.f22472o, i);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, 1437899657, a);
                }
            });
        }
        a.f22674f.setOnClickListener(new OnClickListener(adCreativeController) {
            final /* synthetic */ AdCreativeController f22455b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 391796698);
                this.f22455b.f22440b.m22429a(new IntentEvent(SimplePickerIntent.a(view.getContext(), AdCreativeController.f22458a), 20006));
                this.f22455b.f22473p = a.f22676h;
                Logger.a(2, EntryType.UI_INPUT_END, -204274068, a);
            }
        });
        a.f22673e.addTextChangedListener(new BaseTextWatcher(adCreativeController) {
            final /* synthetic */ AdCreativeController f22457b;

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                a.f22670b.setBadgeText(String.valueOf(this.f22457b.f22468k.f22503b - charSequence.length()));
            }
        });
        a.f22673e.setText(adCreativeController.f22470m.f21769b);
        a.setAdImageThumbnail(adCreativeController.f22466i);
        return a;
    }
}
