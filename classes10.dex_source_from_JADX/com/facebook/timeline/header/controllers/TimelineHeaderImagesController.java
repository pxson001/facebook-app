package com.facebook.timeline.header.controllers;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.view.DraweeView;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: fisLIALINLIPLIZjibyzpIRAIRD198197593pfdpfwpfxTY1TYAScrULIbratnoembempEMBEMPjrfjrcGABRANRAMRAVRAYjpzombArcArmfwfhfyhfxhfqhfjGENGELzhzOSICITSCHrobgpiie_ie.xprHHHIELNOKqpfexaextexusepDEVz2zEXIGenhpbLSEyptGARLeoLet090_paoxyUBArusbxtecrsysFERfhcfhxis_ishisbxjybroer2zuhjhcjhnjhxISOISCNev011ko_petpersidoggbubDebDecbufennentgolAFFAFAris424GOOjuajunjuvNP0ljykbcczyoRDqkfAsshei876NETNESNE1SilTrirnjcarCAMuvuhjyhjghjlhjnwinIFFRVEKosorp3r4SWoeyeAYEUniwdwwdyng_kylnlypoopolTREallalkalcalpoyoTINtgutgbtgfedded_ALKALIALDALEALTED1EDSEDWEDULOCjkxoveagoaggodzUELUNIUNNBILBIRSavAGIAGAUNGdskhbxck_EONzazLDEn66PluRCH.safrj9.1pyrAle060ty-tyrulzEddHAMfqnfqlfqgNDINDSHunShaKITmw3SAISABrairavBilFylGlo1.1NIOPLELVERip1BiAZEAZZAZ2scuFradf1xcqwebKKKPACSou515ambtfitfubz2bz14qweetAMAAM1fjkEENIgo147ON1kjnkjxMetkmyna1RUMSnopknDkfhydCURubs0zxjwb3wwrosSHK.rocxvBEE050SosStrve_LDOdfzzmozmxNG1imk1HoDfkepsCumdxbCOCCOLCOOuxeHUGHUMPusne.mcgopyopcHAIHAP4kaik1ikkJENnyannajdkRev525andteryvoANCFFFHugEFFYANMPEMPIPUTPNPkjvPECpbzpbbaaacrycracrfcrecroSojUPItritrotraszkgbgCRACREvsqGBOksoREIka.katcyp3QWAng040DWAbczdruFffuntundunnHOLHOPhbwhbvKilldcldwmikmilshlSOUfnmcluqyjqyfCraYfniamia.URNURSAntf20987NKYeaga.ma.sbcjmdmatmATEATCATAATMDICFLAddhittjcvITO8.1facnicniqplutdjWizstestafdkIamukkzygzydzyjzykLLSLLALLEyguwqe4.0arwwns6.1abbabyjqxjqvLAW963tqvjxbbirFlamihABEABIABRudlfybfytfyyjyfdkjyjvRDOcfd99499303.038030xvjHEVYbrzozMaGNA2NA1394OTOOTSOLLOLOSLImpuQUAERRLYAGUAGUYIBE888NJAPIOPIDPIRThungsng1TIOaurSSAAUTiuybxbgibSynSysRIOSluDUC@sselcx4mgiotkftkttkzehfAHAsuzvxbdfkdfjfgtixiixozxzLCOlpmfz1DLEaccacqWooSmiURPECOACHuebFUNfxtfxrzeb6.0jajRGIKnimptpuppusSpivfcvfyvfpxuxww1Luk130cjdessickics_inhugWATICOICTowdrliywjDudAVADOMDOWdjpiverjpkrykrukraBranke55wRfhailaidDbrAINaquiyPbullwaPRERMAosecquUSEUSIBLOBLEtwoDomOWBsydlviGATwynIvazdjLGAurzSevptocdtNCI010bduffmCDEvalxtyxtxxtk_aletsDAWozoCK1xymhtmhtwhtvustILDILOEAK8.0@20TOPTOMCdt222dimORPq5qzqaMonnjq!QAnjypizpirTTTpioTARpidoctUISUITtiotiggkzgkjgkfAJAssivzvizaizdVENLAKLASNTSNTOybryboIZI11.RLObjbugsvoztsuzgf1BoDddsocflopsoBro992cesbgfdcfCESdjlxseWHIx2zFABukuyBoZzzidea77RRRTANFisSKYrgyrgiBoxHILdcxz1qim_imbimmhsqIMBspiMusMufLUMjlzMozrphdvdAPIsmosmiffeLKETifIPEIPSKENOMIphpakuSecBURBUSBUCthebplbpvAKOghgvulJUAjpkXxxDMAluxROMOOBRusoobx3xhommojGGYzfkoutnumSEABubBudcbrcbx**k_gaRUNSHErfvWoRciodbzHeafqhCIOEVYGggdhfINKINEINAKOTUDDUDEftbkz1OGITMA4mepnbEAMGrarf1jgtjnzaddto_el_ell852gieADYADEADAORKdsoELIPowPolmykoki101494BARBASBADttyblax2xEagviklegGDAlaclawTAI.19TEVccbmyhmygQqqdtqCCECCCutcutkutsHIPwkwDRIIDOrixSNAPORzak_deRTI.lvBaBz3zioplizEWAqx490-RIA_saODOnbyKen5.0RacRaiRavRapRaywriarrartardyloAKArriARIARMCcc */
public class TimelineHeaderImagesController {
    private static TimelineHeaderImagesController f11635e;
    private static final Object f11636f = new Object();
    private final Context f11637a;
    private final Provider<MediaGalleryLauncher> f11638b;
    private final Provider<MediaGalleryLauncherParamsFactory> f11639c;
    private final QeAccessor f11640d;

    private static TimelineHeaderImagesController m11681b(InjectorLike injectorLike) {
        return new TimelineHeaderImagesController((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 9351), IdBasedSingletonScopeProvider.a(injectorLike, 9346), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TimelineHeaderImagesController(Context context, Provider<MediaGalleryLauncher> provider, Provider<MediaGalleryLauncherParamsFactory> provider2, QeAccessor qeAccessor) {
        this.f11637a = context;
        this.f11638b = provider;
        this.f11639c = provider2;
        this.f11640d = qeAccessor;
    }

    public final void m11682a(DraweeView draweeView, String str, @Nullable String str2, @Nullable ImageRequest imageRequest, @Nullable DefaultImageFields defaultImageFields, FullscreenGallerySource fullscreenGallerySource) {
        m11680a(draweeView, this.f11640d.a(ExperimentsForTimelineAbTestModule.aE, false), str, str2, imageRequest, defaultImageFields, fullscreenGallerySource);
    }

    public static TimelineHeaderImagesController m11679a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineHeaderImagesController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11636f) {
                TimelineHeaderImagesController timelineHeaderImagesController;
                if (a2 != null) {
                    timelineHeaderImagesController = (TimelineHeaderImagesController) a2.a(f11636f);
                } else {
                    timelineHeaderImagesController = f11635e;
                }
                if (timelineHeaderImagesController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11681b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11636f, b3);
                        } else {
                            f11635e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineHeaderImagesController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m11683a(String str, @Nullable String str2, @Nullable ImageRequest imageRequest, @Nullable DefaultImageFields defaultImageFields, FullscreenGallerySource fullscreenGallerySource) {
        m11680a(null, false, str, str2, imageRequest, defaultImageFields, fullscreenGallerySource);
    }

    private void m11680a(@Nullable DraweeView draweeView, boolean z, String str, @Nullable String str2, @Nullable ImageRequest imageRequest, @Nullable DefaultImageFields defaultImageFields, FullscreenGallerySource fullscreenGallerySource) {
        Builder a;
        AnimationParamProvider a2;
        if (str2 != null) {
            this.f11639c.get();
            a = MediaGalleryLauncherParamsFactory.a(str2);
        } else {
            this.f11639c.get();
            a = MediaGalleryLauncherParamsFactory.f(ImmutableList.of(str));
        }
        if (defaultImageFields != null && z) {
            a.a(ImmutableList.of(MediaGalleryLauncherHelper.m11670a(str, defaultImageFields)));
        }
        MediaGalleryLauncherParams b = a.a(fullscreenGallerySource).a(str).a(imageRequest).b();
        MediaGalleryLauncher mediaGalleryLauncher = (MediaGalleryLauncher) this.f11638b.get();
        Context context = this.f11637a;
        if (z) {
            a2 = MediaGalleryLauncherHelper.m11671a(str, draweeView, imageRequest);
        } else {
            a2 = null;
        }
        mediaGalleryLauncher.a(context, b, a2);
    }
}
