package com.facebook.adinterfaces.ui;

import android.content.Intent;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CreativeChangedEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CreativeValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CreativeValidationEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.DataValidationEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ErrorDialogEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent.IntentHandler;
import com.facebook.adinterfaces.events.AdInterfacesEvents.InvalidatePreviewEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ServerValidationRequestEvent;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataValidation;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.HasWebsiteUrl;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.model.boostpost.HasAdCreative;
import com.facebook.adinterfaces.model.localawareness.AdInterfacesLocalAwarenessDataModel;
import com.facebook.adinterfaces.nativepreview.AdInterfacesNativePreviewRenderer;
import com.facebook.adinterfaces.objective.BoostedComponentEditCreativeObjective;
import com.facebook.adinterfaces.ui.UploadImageHelper.C27292;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: V2_CAMERA_ROLL_ITEM */
public class AdInterfacesNativePreviewViewController<D extends BaseAdInterfacesData & HasAdCreative> extends BaseAdInterfacesViewController<AdInterfacesNativePreviewView, D> {
    public static final ForegroundColorSpan f22817a = new ForegroundColorSpan(2131361918);
    public static final Class<AdInterfacesNativePreviewViewController> f22818b = AdInterfacesNativePreviewViewController.class;
    public static final ImmutableSet<AdInterfacesDataValidation> f22819c = ImmutableSet.of(AdInterfacesDataValidation.INVALID_URL, AdInterfacesDataValidation.PHONE_NUMBER, AdInterfacesDataValidation.PAGE_LIKE_BODY_TEXT, AdInterfacesDataValidation.ADDRESS, AdInterfacesDataValidation.PHOTO_NOT_UPLOADED, AdInterfacesDataValidation.SERVER_VALIDATION_ERROR, new AdInterfacesDataValidation[0]);
    public AdInterfacesContext f22820d;
    private String f22821e;
    public AdInterfacesNativePreviewView f22822f;
    public boolean f22823g;
    public final AdInterfacesNativePreviewRenderer f22824h;
    private final AdInterfacesErrorReporter f22825i;
    private final TasksManager f22826j;
    private final AdInterfacesDataHelper f22827k;
    private final AdInterfacesNativePreviewFetcher f22828l;
    public AdInterfacesCardLayout f22829m;
    public D f22830n;

    /* compiled from: V2_CAMERA_ROLL_ITEM */
    class C26431 implements OnClickListener {
        final /* synthetic */ AdInterfacesNativePreviewViewController f22810a;

        C26431(AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController) {
            this.f22810a = adInterfacesNativePreviewViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 941514508);
            this.f22810a.f22830n;
            Logger.a(2, EntryType.UI_INPUT_END, 2078112909, a);
        }
    }

    /* compiled from: V2_CAMERA_ROLL_ITEM */
    class C26442 extends CreativeChangedEventSubscriber {
        final /* synthetic */ AdInterfacesNativePreviewViewController f22811a;

        C26442(AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController) {
            this.f22811a = adInterfacesNativePreviewViewController;
        }

        public final void m24734b(FbEvent fbEvent) {
            AdInterfacesNativePreviewViewController.m24757g(this.f22811a);
        }
    }

    /* compiled from: V2_CAMERA_ROLL_ITEM */
    class C26453 implements IntentHandler {
        final /* synthetic */ AdInterfacesNativePreviewViewController f22812a;

        C26453(AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController) {
            this.f22812a = adInterfacesNativePreviewViewController;
        }

        public final void mo980a(int i, Intent intent) {
            if (i == -1) {
                AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel = (AdInterfacesBoostedComponentDataModel) intent.getParcelableExtra("CREATIVE_EDIT_DATA");
                if (adInterfacesBoostedComponentDataModel == null) {
                    this.f22812a.f22820d;
                    return;
                }
                ((HasAdCreative) this.f22812a.f22830n).mo952a(adInterfacesBoostedComponentDataModel.mo951C());
                this.f22812a.m24742a(adInterfacesBoostedComponentDataModel);
                AdInterfacesNativePreviewViewController.m24757g(this.f22812a);
                this.f22812a.f22440b.m22429a(new ServerValidationRequestEvent());
            }
        }
    }

    /* compiled from: V2_CAMERA_ROLL_ITEM */
    class C26464 extends DataValidationEventSubscriber {
        final /* synthetic */ AdInterfacesNativePreviewViewController f22813a;

        C26464(AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController) {
            this.f22813a = adInterfacesNativePreviewViewController;
        }

        public final void m24736b(FbEvent fbEvent) {
            if (!this.f22813a.f22829m) {
                if (this.f22813a.f22820d.m22433a(AdInterfacesNativePreviewViewController.f22819c)) {
                    this.f22813a.m24759h();
                } else if (this.f22813a.f22823g) {
                    AdInterfacesNativePreviewViewController.m24757g(this.f22813a);
                }
            }
        }
    }

    /* compiled from: V2_CAMERA_ROLL_ITEM */
    class C26475 extends InvalidatePreviewEventSubscriber {
        final /* synthetic */ AdInterfacesNativePreviewViewController f22814a;

        C26475(AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController) {
            this.f22814a = adInterfacesNativePreviewViewController;
        }

        public final void m24737b(FbEvent fbEvent) {
            AdInterfacesNativePreviewViewController.m24757g(this.f22814a);
        }
    }

    /* compiled from: V2_CAMERA_ROLL_ITEM */
    class C26486 extends CreativeValidationEventSubscriber {
        final /* synthetic */ AdInterfacesNativePreviewViewController f22815a;

        C26486(AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController) {
            this.f22815a = adInterfacesNativePreviewViewController;
        }

        public final void m24738b(FbEvent fbEvent) {
            this.f22815a.f22829m.m24584a(((CreativeValidationEvent) fbEvent).f21655a);
        }
    }

    /* compiled from: V2_CAMERA_ROLL_ITEM */
    class C26497 extends AbstractDisposableFutureCallback<FeedUnit> {
        final /* synthetic */ AdInterfacesNativePreviewViewController f22816a;

        C26497(AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController) {
            this.f22816a = adInterfacesNativePreviewViewController;
        }

        protected final void m24739a(Object obj) {
            FeedUnit feedUnit = (FeedUnit) obj;
            this.f22816a.f22829m.m24586a(false);
            this.f22816a.f22822f.setIsLoading(false);
            ViewGroup viewGroup = this.f22816a.f22822f.f22809b;
            if (feedUnit == null) {
                this.f22816a.m24746a(AdInterfacesNativePreviewViewController.m24749c(this.f22816a));
                viewGroup.removeAllViews();
                return;
            }
            viewGroup.removeAllViews();
            this.f22816a.f22824h.m22906a(viewGroup, feedUnit);
        }

        protected final void m24740a(Throwable th) {
            this.f22816a.f22829m.m24586a(false);
            this.f22816a.f22822f.setIsLoading(false);
            this.f22816a.f22829m;
        }
    }

    /* compiled from: V2_CAMERA_ROLL_ITEM */
    public interface AdInterfacesNativePreviewFetcher<T extends BaseAdInterfacesData> {
        ListenableFuture<FeedUnit> mo1037a(T t);
    }

    /* compiled from: V2_CAMERA_ROLL_ITEM */
    enum Tasks {
        FETCH_AD_PREVIEW
    }

    public final void mo982a(View view, AdInterfacesCardLayout adInterfacesCardLayout) {
        AdInterfacesNativePreviewView adInterfacesNativePreviewView = (AdInterfacesNativePreviewView) view;
        super.mo982a(adInterfacesNativePreviewView, adInterfacesCardLayout);
        this.f22829m = adInterfacesCardLayout;
        this.f22822f = adInterfacesNativePreviewView;
        this.f22820d = this.f22440b;
        if (this.f22830n.mo959v() != null) {
            this.f22822f.setIsLoading(false);
            this.f22822f.f22809b.removeAllViews();
            this.f22824h.m22906a(this.f22822f.f22809b, this.f22830n.mo959v());
            if (!AdInterfacesDataHelper.m22814j(this.f22830n)) {
                m24753e();
                return;
            }
            return;
        }
        if (m24764j()) {
            adInterfacesCardLayout.m24588b(true);
            adInterfacesCardLayout.setPencilOnClickListener(new C26431(this));
        }
        if (!AdInterfacesDataHelper.m22814j(this.f22830n)) {
            m24753e();
            m24757g(this);
        }
    }

    public final void mo983a(D d) {
        this.f22830n = (BaseAdInterfacesData) d;
    }

    @Inject
    public AdInterfacesNativePreviewViewController(AdInterfacesDataHelper adInterfacesDataHelper, AdInterfacesErrorReporter adInterfacesErrorReporter, TasksManager tasksManager, AdInterfacesNativePreviewRenderer adInterfacesNativePreviewRenderer, @Assisted AdInterfacesNativePreviewFetcher adInterfacesNativePreviewFetcher) {
        this.f22827k = adInterfacesDataHelper;
        this.f22825i = adInterfacesErrorReporter;
        this.f22826j = tasksManager;
        this.f22824h = adInterfacesNativePreviewRenderer;
        this.f22828l = adInterfacesNativePreviewFetcher;
    }

    public static String m24749c(AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController) {
        if (adInterfacesNativePreviewViewController.f22821e == null) {
            adInterfacesNativePreviewViewController.f22821e = adInterfacesNativePreviewViewController.f22829m.getContext().getString(2131234012);
        }
        return adInterfacesNativePreviewViewController.f22821e;
    }

    public static void m24752d(AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController) {
        Parcelable parcelable = adInterfacesNativePreviewViewController.f22830n;
        AdInterfacesContext adInterfacesContext = adInterfacesNativePreviewViewController.f22820d;
        Intent a = AdInterfacesIntentUtil.a(adInterfacesNativePreviewViewController.f22829m.getContext(), BoostedComponentEditCreativeObjective.m22951c(parcelable), Integer.valueOf(2131234040), parcelable.f21755k);
        a.putExtra("data", parcelable);
        adInterfacesContext.m22429a(new IntentEvent(a, 9, true));
    }

    public final void mo981a() {
        super.mo981a();
        this.f22826j.c(Tasks.FETCH_AD_PREVIEW);
        this.f22820d = null;
        this.f22822f = null;
        this.f22829m = null;
    }

    private void m24753e() {
        this.f22820d.m22430a(new C26442(this));
        this.f22820d.m22428a(9, new C26453(this));
        this.f22820d.m22430a(new C26464(this));
        this.f22820d.m22430a(new C26475(this));
        this.f22820d.m22430a(new C26486(this));
        AdInterfacesContext adInterfacesContext = this.f22820d;
        adInterfacesContext.m22430a(new C27292((HasAdCreative) this.f22830n, adInterfacesContext));
    }

    private void m24742a(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel) {
        if (this.f22830n instanceof HasWebsiteUrl) {
            ((HasWebsiteUrl) this.f22830n).c_(((HasWebsiteUrl) adInterfacesBoostedComponentDataModel).mI_());
        }
        if (this.f22830n instanceof AdInterfacesLocalAwarenessDataModel) {
            AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel = (AdInterfacesLocalAwarenessDataModel) this.f22830n;
            AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel2 = (AdInterfacesLocalAwarenessDataModel) adInterfacesBoostedComponentDataModel;
            adInterfacesLocalAwarenessDataModel.f21809c = adInterfacesLocalAwarenessDataModel2.f21809c;
            adInterfacesLocalAwarenessDataModel.f21803h = adInterfacesLocalAwarenessDataModel2.f21803h;
            adInterfacesLocalAwarenessDataModel.f21807a = adInterfacesLocalAwarenessDataModel2.f21807a;
        }
    }

    public static void m24756f(AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController) {
        String str = "\n";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Got null after returning from creative edit activity").append(str).append("Objective: ").append(adInterfacesNativePreviewViewController.f22830n.mo962b().name()).append(str).append("Page: ").append(adInterfacesNativePreviewViewController.f22830n.f21747c).append(str).append("Account Id: ").append(adInterfacesNativePreviewViewController.f22830n.m22853i());
        adInterfacesNativePreviewViewController.f22825i.m22726a(f22818b, stringBuilder.toString());
    }

    public static void m24757g(AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController) {
        if (!adInterfacesNativePreviewViewController.f22829m) {
            if (adInterfacesNativePreviewViewController.f22820d.m22433a(f22819c)) {
                adInterfacesNativePreviewViewController.m24759h();
                return;
            }
            adInterfacesNativePreviewViewController.f22823g = false;
            adInterfacesNativePreviewViewController.f22829m.m24586a(true);
            adInterfacesNativePreviewViewController.f22822f.setIsLoading(true);
            adInterfacesNativePreviewViewController.f22829m.setFooterSpannableText(null);
            adInterfacesNativePreviewViewController.f22826j.a(Tasks.FETCH_AD_PREVIEW, adInterfacesNativePreviewViewController.f22828l.mo1037a(adInterfacesNativePreviewViewController.f22830n), new C26497(adInterfacesNativePreviewViewController));
        }
    }

    private void m24759h() {
        this.f22826j.c(Tasks.FETCH_AD_PREVIEW);
        this.f22822f.setIsLoading(false);
        this.f22829m.m24586a(false);
        this.f22822f.f22809b.removeAllViews();
        m24746a(m24749c(this));
        this.f22823g = true;
    }

    public static void m24762i(AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController) {
        String c = m24749c(adInterfacesNativePreviewViewController);
        adInterfacesNativePreviewViewController.f22820d.m22429a(new ErrorDialogEvent(null, c));
        adInterfacesNativePreviewViewController.m24746a(c);
    }

    private void m24746a(String str) {
        Spanned spannableString = new SpannableString(str);
        spannableString.setSpan(f22817a, 0, str.length(), 33);
        this.f22829m.setFooterSpannableText(spannableString);
    }

    private boolean m24764j() {
        return (this.f22830n == null || this.f22830n.mo962b() == ObjectiveType.BOOST_EVENT || this.f22830n.mo962b() == ObjectiveType.BOOSTED_COMPONENT_BOOST_POST || this.f22830n.mo962b() == ObjectiveType.BOOST_POST) ? false : true;
    }

    public static boolean m24768m(AdInterfacesNativePreviewViewController adInterfacesNativePreviewViewController) {
        return adInterfacesNativePreviewViewController.f22830n.mo962b() == ObjectiveType.BOOSTED_COMPONENT_BOOST_POST || adInterfacesNativePreviewViewController.f22830n.mo962b() == ObjectiveType.BOOST_POST;
    }
}
