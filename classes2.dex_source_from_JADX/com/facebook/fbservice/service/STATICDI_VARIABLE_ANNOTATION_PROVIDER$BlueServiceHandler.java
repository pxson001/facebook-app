package com.facebook.fbservice.service;

import com.facebook.inject.InjectorLike;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

/* compiled from: findfriends */
public class STATICDI_VARIABLE_ANNOTATION_PROVIDER$BlueServiceHandler implements Provider<BlueServiceHandler> {
    private final InjectorLike f23658a;
    private final Class<? extends Annotation> f23659b;

    private STATICDI_VARIABLE_ANNOTATION_PROVIDER$BlueServiceHandler(InjectorLike injectorLike, Class<? extends Annotation> cls) {
        this.f23658a = injectorLike;
        this.f23659b = cls;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object get() {
        /*
        r10 = this;
        r0 = r10.f23658a;
        r1 = r10.f23659b;
        r2 = r1.getName();
        r3 = r2.hashCode();
        switch(r3) {
            case -2126005293: goto L_0x0015;
            case -2117321519: goto L_0x003b;
            case -2073336660: goto L_0x004a;
            case -2067961994: goto L_0x0059;
            case -2026860165: goto L_0x0068;
            case -1931737038: goto L_0x0077;
            case -1900853943: goto L_0x008a;
            case -1900748615: goto L_0x009a;
            case -1890715581: goto L_0x00aa;
            case -1869290507: goto L_0x00ba;
            case -1860648388: goto L_0x00ca;
            case -1789749068: goto L_0x00da;
            case -1627854560: goto L_0x00ea;
            case -1564985283: goto L_0x010d;
            case -1505300081: goto L_0x011d;
            case -1489184968: goto L_0x012d;
            case -1401584399: goto L_0x0156;
            case -1385257768: goto L_0x0166;
            case -1355756259: goto L_0x0176;
            case -1332122278: goto L_0x0186;
            case -1330488832: goto L_0x0196;
            case -1261837881: goto L_0x01a6;
            case -1255218153: goto L_0x01b6;
            case -1224961729: goto L_0x01c6;
            case -1188549723: goto L_0x01d6;
            case -1178056958: goto L_0x01e6;
            case -1164903440: goto L_0x01f6;
            case -1122655631: goto L_0x021a;
            case -1049078358: goto L_0x022a;
            case -1002845722: goto L_0x023a;
            case -989343297: goto L_0x024a;
            case -978988459: goto L_0x025a;
            case -934853603: goto L_0x026a;
            case -913215988: goto L_0x027a;
            case -896536603: goto L_0x028a;
            case -852010683: goto L_0x029a;
            case -841975141: goto L_0x02aa;
            case -837530544: goto L_0x02d4;
            case -816327972: goto L_0x02f8;
            case -787981003: goto L_0x0308;
            case -779746026: goto L_0x0318;
            case -773164371: goto L_0x0344;
            case -772657272: goto L_0x0361;
            case -744478052: goto L_0x0371;
            case -696951776: goto L_0x0381;
            case -636370983: goto L_0x0391;
            case -591003923: goto L_0x03a1;
            case -588260433: goto L_0x03b1;
            case -487812484: goto L_0x03c5;
            case -463315916: goto L_0x03d5;
            case -361384923: goto L_0x03e5;
            case -294335145: goto L_0x03f5;
            case -204917617: goto L_0x0405;
            case -194524881: goto L_0x0415;
            case -186507513: goto L_0x0425;
            case -126427726: goto L_0x0435;
            case -111857656: goto L_0x0445;
            case -32458431: goto L_0x0455;
            case -20676426: goto L_0x0465;
            case -6392119: goto L_0x0475;
            case 15867670: goto L_0x049b;
            case 36014821: goto L_0x04ab;
            case 38252995: goto L_0x04bb;
            case 68787570: goto L_0x04cb;
            case 104929303: goto L_0x04db;
            case 114177453: goto L_0x04ff;
            case 123371988: goto L_0x050f;
            case 125559318: goto L_0x051f;
            case 129321600: goto L_0x0549;
            case 213401125: goto L_0x0559;
            case 238391018: goto L_0x0569;
            case 247852891: goto L_0x0579;
            case 270941338: goto L_0x0589;
            case 279568155: goto L_0x0599;
            case 336947448: goto L_0x05a9;
            case 399819439: goto L_0x05b9;
            case 414830821: goto L_0x05c9;
            case 418902241: goto L_0x05d9;
            case 464789455: goto L_0x05e9;
            case 487636853: goto L_0x05f9;
            case 570413104: goto L_0x0629;
            case 645622413: goto L_0x0639;
            case 670674684: goto L_0x0649;
            case 691725882: goto L_0x066a;
            case 691766488: goto L_0x067a;
            case 701429918: goto L_0x068a;
            case 729924452: goto L_0x069a;
            case 807836565: goto L_0x06aa;
            case 853502533: goto L_0x06ba;
            case 862416055: goto L_0x06ca;
            case 885156574: goto L_0x06da;
            case 900791765: goto L_0x06ea;
            case 964579969: goto L_0x06fa;
            case 1047401651: goto L_0x070a;
            case 1056977435: goto L_0x071a;
            case 1064828241: goto L_0x072a;
            case 1110033946: goto L_0x073a;
            case 1118074969: goto L_0x074a;
            case 1137820906: goto L_0x075a;
            case 1162244907: goto L_0x076a;
            case 1259911679: goto L_0x077a;
            case 1297212211: goto L_0x078a;
            case 1327869382: goto L_0x079a;
            case 1336963990: goto L_0x07aa;
            case 1387376720: goto L_0x07ba;
            case 1436837344: goto L_0x07ca;
            case 1543643414: goto L_0x07da;
            case 1560247599: goto L_0x07ea;
            case 1612854862: goto L_0x07fa;
            case 1620235209: goto L_0x080a;
            case 1638248007: goto L_0x081a;
            case 1656831736: goto L_0x082a;
            case 1666566454: goto L_0x083e;
            case 1702877722: goto L_0x084e;
            case 1723769058: goto L_0x085e;
            case 1784610938: goto L_0x0888;
            case 1830382594: goto L_0x0898;
            case 1921608147: goto L_0x08a8;
            case 1943490790: goto L_0x08c9;
            case 1978703352: goto L_0x08d9;
            case 1997142301: goto L_0x08e9;
            case 2021329191: goto L_0x08f9;
            default: goto L_0x000f;
        };
    L_0x000f:
        com.facebook.inject.FbInjector.m1082a(r2);
        r2 = 0;
    L_0x0013:
        r0 = r2;
        return r0;
    L_0x0015:
        r3 = "com.facebook.appirater.api.annotation.AppiraterQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x001d:
        r7 = new com.facebook.appirater.api.AppiraterServiceHandler;
        r4 = com.facebook.http.protocol.ApiMethodRunnerImpl.m15381a(r0);
        r4 = (com.facebook.http.protocol.ApiMethodRunnerImpl) r4;
        r5 = com.facebook.appirater.api.AppRaterShouldAskUserApiMethod.b(r0);
        r5 = (com.facebook.appirater.api.AppRaterShouldAskUserApiMethod) r5;
        r9 = new com.facebook.appirater.api.AppRaterCreateApiMethod;
        r9.<init>();
        r8 = r9;
        r6 = r8;
        r6 = (com.facebook.appirater.api.AppRaterCreateApiMethod) r6;
        r7.<init>(r4, r5, r6);
        r2 = r7;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x003b:
        r3 = "com.facebook.photos.upload.service.UploadServiceQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0043:
        r2 = com.facebook.photos.upload.module.BlueServiceHandler_UploadServiceQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x004a:
        r3 = "com.facebook.messaging.send.service.PendingSendQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0052:
        r2 = com.facebook.messaging.send.service.SendServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0059:
        r3 = "com.facebook.devicebasedlogin.protocol.DeviceBasedLoginQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0061:
        r2 = com.facebook.devicebasedlogin.protocol.DeviceBasedLoginServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0068:
        r3 = "com.facebook.orca.server.module.SmsCachingServiceChain";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0070:
        r2 = com.facebook.orca.server.module.BlueServiceHandler_SmsCachingServiceChainMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0077:
        r3 = "com.facebook.messaging.media.upload.udp.UDPServiceQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x007f:
        r4 = com.facebook.messaging.media.upload.udp.UDPConnectionServiceHandler.b(r0);
        r4 = (com.facebook.messaging.media.upload.udp.UDPConnectionServiceHandler) r4;
        r4 = r4;
        r2 = r4;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x008a:
        r3 = "com.facebook.feed.protocol.NewsFeedFetchQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0092:
        r2 = com.facebook.feed.module.BlueServiceHandler_NewsFeedFetchQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x009a:
        r3 = "com.facebook.privacy.service.PrivacyDataQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x00a2:
        r2 = com.facebook.privacy.BlueServiceHandler_PrivacyDataQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x00aa:
        r3 = "com.facebook.api.reportable_entity.ReportableEntityNegativeActionsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x00b2:
        r2 = com.facebook.api.reportable_entity.NegativeFeedbackActionOnReportableEntityHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x00ba:
        r3 = "com.facebook.search.service.GraphSearchDataQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x00c2:
        r2 = com.facebook.search.service.GraphSearchServiceHandler.b(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x00ca:
        r3 = "com.facebook.orca.server.module.FacebookCachingServiceChain";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x00d2:
        r2 = com.facebook.orca.server.module.BlueServiceHandler_FacebookCachingServiceChainMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x00da:
        r3 = "com.facebook.messaging.payment.protocol.PaymentQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x00e2:
        r2 = com.facebook.messaging.payment.protocol.BlueServiceHandler_PaymentQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x00ea:
        r3 = "com.facebook.fbservice.service.AuthQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x00f2:
        r4 = com.facebook.katana.login.Boolean_UseAuthLoginMethodAutoProvider.b(r0);
        r4 = (java.lang.Boolean) r4;
        r5 = com.facebook.katana.server.handler.Fb4aAuthHandler.b(r0);
        r5 = (com.facebook.katana.server.handler.Fb4aAuthHandler) r5;
        r6 = com.facebook.auth.login.AuthServiceHandler.a(r0);
        r6 = (com.facebook.auth.login.AuthServiceHandler) r6;
        r4 = com.facebook.katana.server.module.Fb4aServiceModule.a(r4, r5, r6);
        r2 = r4;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x010d:
        r3 = "com.facebook.stickers.service.StickersDownloadQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0115:
        r2 = com.facebook.stickers.service.BlueServiceHandler_StickersQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x011d:
        r3 = "com.facebook.messaging.send.service.SendQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0125:
        r2 = com.facebook.messaging.send.service.SendServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x012d:
        r3 = "com.facebook.timeline.service.TimelineSectionQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0135:
        r4 = com.facebook.privacy.service.PrivacyCacheServiceHandler.a(r0);
        r4 = (com.facebook.privacy.service.PrivacyCacheServiceHandler) r4;
        r5 = com.facebook.composer.publish.cache.db.ComposerPublishDbCacheServiceHandler.a(r0);
        r5 = (com.facebook.composer.publish.cache.db.ComposerPublishDbCacheServiceHandler) r5;
        r6 = com.facebook.composer.publish.ComposerPublishServiceHandler.b(r0);
        r6 = (com.facebook.composer.publish.ComposerPublishServiceHandler) r6;
        r7 = com.facebook.timeline.service.TimelineSectionServiceHandler.b(r0);
        r7 = (com.facebook.timeline.service.TimelineSectionServiceHandler) r7;
        r4 = com.facebook.timeline.TimelineModule.a(r4, r5, r6, r7);
        r2 = r4;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0156:
        r3 = "com.facebook.push.externalcloud.annotations.RegistrationQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x015e:
        r2 = com.facebook.push.registration.RegistrationHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0166:
        r3 = "com.facebook.katana.activity.codegenerator.CodeGeneratorServiceQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x016e:
        r2 = com.facebook.katana.activity.codegenerator.CodeGeneratorOperationHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0176:
        r3 = "com.facebook.sideloading.SideloadingServiceQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x017e:
        r2 = com.facebook.sideloading.SideloadingServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0186:
        r3 = "com.facebook.adspayments.protocol.PaymentsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x018e:
        r2 = com.facebook.adspayments.BlueServiceHandler_PaymentsQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0196:
        r3 = "com.facebook.messaging.media.upload.PhotoUploadHiResParallelQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x019e:
        r2 = com.facebook.messaging.media.upload.MediaUploadServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x01a6:
        r3 = "com.facebook.messaging.media.upload.PhotoUploadHiResQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x01ae:
        r2 = com.facebook.messaging.media.upload.MediaUploadServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x01b6:
        r3 = "com.facebook.orca.server.module.LowPriorityThreadsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x01be:
        r2 = com.facebook.orca.server.module.BlueServiceHandler_LowPriorityThreadsQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x01c6:
        r3 = "com.facebook.saved.common.protocol.SavedQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x01ce:
        r2 = com.facebook.saved.common.protocol.SavedServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x01d6:
        r3 = "com.facebook.interstitial.service.InterstitialQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x01de:
        r2 = com.facebook.interstitial.service.InterstitialServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x01e6:
        r3 = "com.facebook.backgroundlocation.settings.write.BackgroundLocationSettingsWriteQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x01ee:
        r2 = com.facebook.backgroundlocation.settings.write.BackgroundLocationSettingsWriteHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x01f6:
        r3 = "com.facebook.pages.common.friendinviter.service.FriendInviterMethodsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x01fe:
        r4 = new com.facebook.pages.common.friendinviter.service.FriendInviterServiceHandler;
        r5 = 2289; // 0x8f1 float:3.208E-42 double:1.131E-320;
        r5 = com.facebook.inject.IdBasedSingletonScopeProvider.m1809a(r0, r5);
        r6 = 8924; // 0x22dc float:1.2505E-41 double:4.409E-320;
        r6 = com.facebook.inject.IdBasedLazy.m1808a(r0, r6);
        r7 = 8923; // 0x22db float:1.2504E-41 double:4.4085E-320;
        r7 = com.facebook.inject.IdBasedLazy.m1808a(r0, r7);
        r4.<init>(r5, r6, r7);
        r2 = r4;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x021a:
        r3 = "com.facebook.nux.service.NuxQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0222:
        r2 = com.facebook.nux.service.NuxServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x022a:
        r3 = "com.facebook.messaging.media.upload.MediaUploadQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0232:
        r2 = com.facebook.messaging.media.upload.MediaUploadServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x023a:
        r3 = "com.facebook.friendsnearby.pingdialog.FriendsNearbyPingMethodsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0242:
        r2 = com.facebook.friendsnearby.pingdialog.FriendsNearbyPingServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x024a:
        r3 = "com.facebook.katana.login.protocol.LoginOperationQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0252:
        r2 = com.facebook.katana.login.protocol.LoginServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x025a:
        r3 = "com.facebook.contactlogs.service.ContactLogsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0262:
        r2 = com.facebook.contactlogs.service.ContactLogsServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x026a:
        r3 = "com.facebook.messaging.tincan.messenger.annotations.TincanCachingServiceChain";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0272:
        r2 = com.facebook.orca.server.module.BlueServiceHandler_TincanCachingServiceChainMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x027a:
        r3 = "com.facebook.location.foreground.ForegroundLocationQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0282:
        r2 = com.facebook.location.foreground.ForegroundLocationHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x028a:
        r3 = "com.facebook.stickers.service.StickersQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0292:
        r2 = com.facebook.stickers.service.BlueServiceHandler_StickersQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x029a:
        r3 = "com.facebook.growth.service.GrowthQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x02a2:
        r2 = com.facebook.growth.service.GrowthServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x02aa:
        r3 = "com.facebook.events.annotation.EventMethodQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x02b2:
        r6 = new com.facebook.events.service.EventServiceHandler;
        r4 = 2289; // 0x8f1 float:3.208E-42 double:1.131E-320;
        r7 = com.facebook.inject.IdBasedSingletonScopeProvider.m1809a(r0, r4);
        r9 = new com.facebook.events.protocol.CreateEventMethod;
        r9.<init>();
        r8 = r9;
        r4 = r8;
        r4 = (com.facebook.events.protocol.CreateEventMethod) r4;
        r9 = new com.facebook.events.protocol.EditEventMethod;
        r9.<init>();
        r8 = r9;
        r5 = r8;
        r5 = (com.facebook.events.protocol.EditEventMethod) r5;
        r6.<init>(r7, r4, r5);
        r2 = r6;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x02d4:
        r3 = "com.facebook.captcha.annotations.CaptchaQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x02dc:
        r4 = new com.facebook.captcha.service.CaptchaServiceHandler;
        r5 = 2289; // 0x8f1 float:3.208E-42 double:1.131E-320;
        r5 = com.facebook.inject.IdBasedSingletonScopeProvider.m1809a(r0, r5);
        r6 = 5031; // 0x13a7 float:7.05E-42 double:2.4856E-320;
        r6 = com.facebook.inject.IdBasedLazy.m1808a(r0, r6);
        r7 = 5032; // 0x13a8 float:7.051E-42 double:2.486E-320;
        r7 = com.facebook.inject.IdBasedLazy.m1808a(r0, r7);
        r4.<init>(r5, r6, r7);
        r2 = r4;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x02f8:
        r3 = "com.facebook.messaging.media.download.MediaDownloadQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0300:
        r2 = com.facebook.messaging.media.download.BlueServiceHandler_MediaDownloadQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0308:
        r3 = "com.facebook.zero.annotations.ZeroTokenQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0310:
        r2 = com.facebook.zero.protocol.ZeroTokenHandler.m32132a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0318:
        r3 = "com.facebook.backgroundlocation.reporting.BackgroundLocationReportingQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0320:
        r8 = new com.facebook.backgroundlocation.reporting.BackgroundLocationReportingHandler;
        r4 = android.content.Context.class;
        r4 = r0.getInstance(r4);
        r4 = (android.content.Context) r4;
        r5 = com.facebook.http.protocol.SingleMethodRunnerImpl.m11724a(r0);
        r5 = (com.facebook.http.protocol.AbstractSingleMethodRunner) r5;
        r6 = com.facebook.backgroundlocation.reporting.BackgroundLocationReportingUpdateMethod.a(r0);
        r6 = (com.facebook.backgroundlocation.reporting.BackgroundLocationReportingUpdateMethod) r6;
        r7 = com.facebook.content.FacebookOnlyIntentActionFactory.m4495a(r0);
        r7 = (com.facebook.content.FacebookOnlyIntentActionFactory) r7;
        r8.<init>(r4, r5, r6, r7);
        r2 = r8;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0344:
        r3 = "com.facebook.contacts.service.DynamicContactDataQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x034c:
        r4 = com.facebook.contacts.service.DynamicContactDataLocalServiceHandler.a(r0);
        r4 = (com.facebook.contacts.service.DynamicContactDataLocalServiceHandler) r4;
        r5 = com.facebook.contacts.service.DynamicContactDataServiceHandler.a(r0);
        r5 = (com.facebook.contacts.service.DynamicContactDataServiceHandler) r5;
        r4 = com.facebook.contacts.service.ContactsServiceModule.a(r4, r5);
        r2 = r4;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0361:
        r3 = "com.facebook.photos.data.service.PhotosServiceQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0369:
        r2 = com.facebook.photos.data.BlueServiceHandler_PhotosServiceQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0371:
        r3 = "com.facebook.messaging.media.upload.PhotoUploadQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0379:
        r2 = com.facebook.messaging.media.upload.MediaUploadServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0381:
        r3 = "com.facebook.nearby.protocol.NearbyMethodsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0389:
        r2 = com.facebook.nearby.server.NearbyServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0391:
        r3 = "com.facebook.payments.paymentmethods.picker.protocol.PickerProtocolQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0399:
        r2 = com.facebook.payments.paymentmethods.picker.protocol.BlueServiceHandler_PickerProtocolQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x03a1:
        r3 = "com.facebook.contacts.service.AddressBookQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x03a9:
        r2 = com.facebook.contacts.service.ContactsServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x03b1:
        r3 = "com.facebook.orca.server.module.PushTraceQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x03b9:
        r4 = com.facebook.orca.push.fbpushdata.PushTraceServiceHandler.a(r0);
        r4 = (com.facebook.orca.push.fbpushdata.PushTraceServiceHandler) r4;
        r4 = r4;
        r2 = r4;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x03c5:
        r3 = "com.facebook.adinterfaces.protocol.AdInterfacesMethodsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x03cd:
        r2 = com.facebook.adinterfaces.protocol.AdInterfacesServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x03d5:
        r3 = "com.facebook.feedplugins.storygallerysurvey.service.StoryGallerySurveyActionsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x03dd:
        r2 = com.facebook.feedplugins.storygallerysurvey.service.StoryGallerySurveyActionsServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x03e5:
        r3 = "com.facebook.platform.common.server.PlatformOperationQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x03ed:
        r2 = com.facebook.platform.common.server.PlatformOperationHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x03f5:
        r3 = "com.facebook.quickinvite.protocol.service.QuickInviteQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x03fd:
        r2 = com.facebook.quickinvite.protocol.service.QuickInviteServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0405:
        r3 = "com.facebook.payments.shipping.protocol.ShippingAddressProtocolQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x040d:
        r2 = com.facebook.payments.shipping.protocol.BlueServiceHandler_ShippingAddressProtocolQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0415:
        r3 = "com.facebook.vault.service.VaultQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x041d:
        r2 = com.facebook.vault.service.VaultServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0425:
        r3 = "com.facebook.analytics.service.AnalyticsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x042d:
        r2 = com.facebook.analytics.service.AnalyticsServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0435:
        r3 = "com.facebook.messaging.payment.pin.protocol.PaymentPinQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x043d:
        r2 = com.facebook.messaging.payment.pin.BlueServiceHandler_PaymentPinQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0445:
        r3 = "com.facebook.messaging.localfetch.LocalFetchQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x044d:
        r2 = com.facebook.messaging.localfetch.LocalFetchServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0455:
        r3 = "com.facebook.feed.protocol.NewsFeedPostingQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x045d:
        r2 = com.facebook.feed.module.BlueServiceHandler_NewsFeedPostingQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0465:
        r3 = "com.facebook.contacts.service.ContactsFetcherQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x046d:
        r2 = com.facebook.contacts.service.ContactsServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0475:
        r3 = "com.facebook.messaging.emoji.service.MessagingEmojiQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x047d:
        r5 = new com.facebook.messaging.emoji.service.MessagingEmojiLocalServiceHandler;
        r8 = new com.facebook.messaging.emoji.service.RecentEmojiHandler;
        r6 = com.facebook.messaging.emoji.storage.MessagingEmojiCache.a(r0);
        r6 = (com.facebook.messaging.emoji.storage.MessagingEmojiCache) r6;
        r7 = com.facebook.messaging.emoji.storage.MessagingEmojiDbStorageImpl.a(r0);
        r7 = (com.facebook.messaging.emoji.storage.MessagingEmojiDbStorageImpl) r7;
        r8.<init>(r6, r7);
        r4 = r8;
        r4 = (com.facebook.messaging.emoji.service.RecentEmojiHandler) r4;
        r5.<init>(r4);
        r2 = r5;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x049b:
        r3 = "com.facebook.megaphone.api.MegaphoneQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x04a3:
        r2 = com.facebook.megaphone.api.MegaphoneServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x04ab:
        r3 = "com.facebook.identitygrowth.profilequestion.service.SaveProfileQuestionQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x04b3:
        r2 = com.facebook.identitygrowth.profilequestion.service.ProfileQuestionServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x04bb:
        r3 = "com.facebook.messaging.sync.service.MessagesSyncQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x04c3:
        r2 = com.facebook.messaging.sync.service.MessagesSyncServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x04cb:
        r3 = "com.facebook.share.protocol.ShareMethodsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x04d3:
        r2 = com.facebook.share.server.ShareServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x04db:
        r3 = "com.facebook.si.annotations.LinkshimQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x04e3:
        r7 = new com.facebook.si.LinkshimServiceHandler;
        r4 = com.facebook.http.common.FbHttpRequestProcessor.m12260a(r0);
        r4 = (com.facebook.http.common.FbHttpRequestProcessor) r4;
        r5 = com.facebook.auth.datastore.impl.LoggedInUserSessionManager.m2511a(r0);
        r5 = (com.facebook.auth.datastore.impl.LoggedInUserSessionManager) r5;
        r6 = com.facebook.common.json.FbObjectMapperMethodAutoProvider.m6609a(r0);
        r6 = (com.fasterxml.jackson.databind.ObjectMapper) r6;
        r7.<init>(r4, r5, r6);
        r2 = r7;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x04ff:
        r3 = "com.facebook.payments.paymentmethods.cardform.protocol.CardFormProtocolQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0507:
        r2 = com.facebook.payments.paymentmethods.cardform.protocol.BlueServiceHandler_CardFormProtocolQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x050f:
        r3 = "com.facebook.orca.contacts.picker.service.ContactPickerNearbyQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0517:
        r2 = com.facebook.orca.contacts.picker.service.ContactPickerNearbyServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x051f:
        r3 = "com.facebook.account.recovery.annotations.AccountRecoveryQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0527:
        r4 = new com.facebook.account.recovery.service.AccountRecoveryServiceHandler;
        r5 = 2289; // 0x8f1 float:3.208E-42 double:1.131E-320;
        r5 = com.facebook.inject.IdBasedSingletonScopeProvider.m1809a(r0, r5);
        r6 = 4571; // 0x11db float:6.405E-42 double:2.2584E-320;
        r6 = com.facebook.inject.IdBasedLazy.m1808a(r0, r6);
        r7 = 4572; // 0x11dc float:6.407E-42 double:2.259E-320;
        r7 = com.facebook.inject.IdBasedLazy.m1808a(r0, r7);
        r8 = 4573; // 0x11dd float:6.408E-42 double:2.2594E-320;
        r8 = com.facebook.inject.IdBasedLazy.m1808a(r0, r8);
        r4.<init>(r5, r6, r7, r8);
        r2 = r4;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0549:
        r3 = "com.facebook.languages.switcher.service.LanguageSwitcherQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0551:
        r2 = com.facebook.languages.switcher.service.LanguageSwitcherServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0559:
        r3 = "com.facebook.aldrin.service.AldrinQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0561:
        r2 = com.facebook.aldrin.service.AldrinServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0569:
        r3 = "com.facebook.messaging.media.upload.MediaGetFbidQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0571:
        r2 = com.facebook.messaging.media.upload.MediaGetFbidServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0579:
        r3 = "com.facebook.payments.contactinfo.protocol.ContactInfoProtocolQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0581:
        r2 = com.facebook.payments.contactinfo.protocol.BlueServiceHandler_ContactInfoProtocolQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0589:
        r3 = "com.facebook.friends.service.FriendingQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0591:
        r2 = com.facebook.friends.service.FriendingServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0599:
        r3 = "com.facebook.structuredsurvey.api.PostSurveyQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x05a1:
        r2 = com.facebook.structuredsurvey.api.PostSurveyServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x05a9:
        r3 = "com.facebook.places.pagetopics.FetchPageTopicsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x05b1:
        r2 = com.facebook.places.pagetopics.FetchPageTopicsHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x05b9:
        r3 = "com.facebook.pages.adminedpages.service.AdminedPagesQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x05c1:
        r2 = com.facebook.pages.adminedpages.BlueServiceHandler_AdminedPagesQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x05c9:
        r3 = "com.facebook.groups.service.GroupsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x05d1:
        r2 = com.facebook.groups.service.GroupsServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x05d9:
        r3 = "com.facebook.common.pagesprotocol.PagesReviewMethodsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x05e1:
        r2 = com.facebook.common.pagesprotocol.PagesReviewServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x05e9:
        r3 = "com.facebook.zero.upsell.annotations.UpsellPromoQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x05f1:
        r2 = com.facebook.zero.upsell.service.UpsellPromoServiceHandler.b(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x05f9:
        r3 = "com.facebook.greetingcards.create.GreetingCardQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0601:
        r4 = new com.facebook.greetingcards.create.GreetingCardUploadHandler;
        r5 = 2289; // 0x8f1 float:3.208E-42 double:1.131E-320;
        r5 = com.facebook.inject.IdBasedSingletonScopeProvider.m1809a(r0, r5);
        r6 = com.facebook.composer.publish.protocol.PublishPostMethod.b(r0);
        r6 = (com.facebook.composer.publish.protocol.PublishPostMethod) r6;
        r7 = com.facebook.photos.upload.uploaders.DirectPhotoUploader.b(r0);
        r7 = (com.facebook.photos.upload.uploaders.DirectPhotoUploader) r7;
        r8 = com.facebook.photos.base.analytics.DefaultPhotoFlowLogger.b(r0);
        r8 = (com.facebook.photos.base.analytics.DefaultPhotoFlowLogger) r8;
        r9 = com.facebook.photos.upload.module.ImmediateRetryPolicyMethodAutoProvider.b(r0);
        r9 = (com.facebook.photos.upload.retry.ImmediateRetryPolicy) r9;
        r4.<init>(r5, r6, r7, r8, r9);
        r2 = r4;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0629:
        r3 = "com.facebook.messaging.media.service.LocalMediaQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0631:
        r2 = com.facebook.messaging.media.service.BlueServiceHandler_LocalMediaQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0639:
        r3 = "com.facebook.messaging.tincan.messenger.TincanQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0641:
        r2 = com.facebook.messaging.tincan.messenger.TincanServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0649:
        r3 = "com.facebook.api.negative_feedback.NegativeFeedbackActionsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0651:
        r5 = new com.facebook.api.negative_feedback.NegativeFeedbackActionHandler;
        r4 = 2289; // 0x8f1 float:3.208E-42 double:1.131E-320;
        r6 = com.facebook.inject.IdBasedSingletonScopeProvider.m1809a(r0, r4);
        r8 = new com.facebook.api.negative_feedback.NegativeFeedbackActionMethod;
        r8.<init>();
        r7 = r8;
        r4 = r7;
        r4 = (com.facebook.api.negative_feedback.NegativeFeedbackActionMethod) r4;
        r5.<init>(r6, r4);
        r2 = r5;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x066a:
        r3 = "com.facebook.bookmark.client.BookmarkSyncQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0672:
        r2 = com.facebook.bookmark.service.BlueServiceHandler_BookmarkSyncQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x067a:
        r3 = "com.facebook.katana.server.AuthenticateCredentialsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0682:
        r2 = com.facebook.katana.server.handler.AuthenticateCredentialsHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x068a:
        r3 = "com.facebook.notifications.protocol.NotificationsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0692:
        r2 = com.facebook.notifications.module.BlueServiceHandler_NotificationsQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x069a:
        r3 = "com.facebook.messaging.blocking.api.GetBlockedPeopleQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x06a2:
        r2 = com.facebook.messaging.blocking.api.GetBlockedPeopleServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x06aa:
        r3 = "com.facebook.pages.browser.data.service.PagesBrowserMethodsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x06b2:
        r2 = com.facebook.pages.browser.data.service.PagesBrowserServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x06ba:
        r3 = "com.facebook.contacts.service.ContactsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x06c2:
        r2 = com.facebook.contacts.service.ContactsServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x06ca:
        r3 = "com.facebook.facecast.protocol.FacecastServiceQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x06d2:
        r2 = com.facebook.facecast.protocol.FacecastServiceHandler.b(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x06da:
        r3 = "com.facebook.registration.service.AccountRegistrationQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x06e2:
        r2 = com.facebook.registration.service.AccountRegistrationServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x06ea:
        r3 = "com.facebook.messaging.media.upload.PhotoUploadParallelQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x06f2:
        r2 = com.facebook.messaging.media.upload.MediaUploadServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x06fa:
        r3 = "com.facebook.katana.server.SimpleDataFetchQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0702:
        r2 = com.facebook.katana.server.module.BlueServiceHandler_SimpleDataFetchQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x070a:
        r3 = "com.facebook.tagging.server.TaggingQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0712:
        r2 = com.facebook.tagging.server.TaggingServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x071a:
        r3 = "com.facebook.feed.annotations.ForNewsfeed";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0722:
        r2 = com.facebook.feed.module.BlueServiceHandler_ForNewsfeedMethodAutoProvider.b(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x072a:
        r3 = "com.facebook.uberbar.api.FetchUberbarResultQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0732:
        r2 = com.facebook.uberbar.api.UberbarServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x073a:
        r3 = "com.facebook.timeline.aboutpage.service.TimelineCollectionsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0742:
        r2 = com.facebook.timeline.aboutpage.BlueServiceHandler_TimelineCollectionsQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x074a:
        r3 = "com.facebook.auth.login.CheckApprovedMachineQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0752:
        r2 = com.facebook.auth.login.CheckApprovedMachineServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x075a:
        r3 = "com.facebook.messaging.payment.sync.service.PaymentsSyncQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0762:
        r2 = com.facebook.messaging.payment.sync.service.PaymentsSyncServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x076a:
        r3 = "com.facebook.katana.server.LoginApprovalResendCodeQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0772:
        r2 = com.facebook.katana.server.handler.LoginApprovalResendCodeServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x077a:
        r3 = "com.facebook.search.service.GraphSearchLogQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0782:
        r2 = com.facebook.search.service.GraphSearchServiceHandler.b(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x078a:
        r3 = "com.facebook.goodwill.publish.GoodwillPublishUploadQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0792:
        r2 = com.facebook.goodwill.publish.GoodwillPublishUploadHandler.b(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x079a:
        r3 = "com.facebook.feed.protocol.NewsFeedMainQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x07a2:
        r2 = com.facebook.feed.module.BlueServiceHandler_NewsFeedMainQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x07aa:
        r3 = "com.facebook.profile.inforequest.service.InfoRequestQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x07b2:
        r2 = com.facebook.profile.inforequest.service.InfoRequestServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x07ba:
        r3 = "com.facebook.contacts.upload.ContactsUploadQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x07c2:
        r2 = com.facebook.contacts.upload.ContactsUploadServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x07ca:
        r3 = "com.facebook.messaging.media.upload.VideoResizeQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x07d2:
        r2 = com.facebook.messaging.media.upload.MediaUploadVideoResizeHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x07da:
        r3 = "com.facebook.composer.savedsession.ComposerSavedSessionQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x07e2:
        r2 = com.facebook.composer.savedsession.ComposerSavedSessionServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x07ea:
        r3 = "com.facebook.pages.common.actionbar.blueservice.PagesCommonActionBarMethodsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x07f2:
        r2 = com.facebook.pages.common.actionbar.blueservice.PagesCommonActionBarServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x07fa:
        r3 = "com.facebook.orca.server.module.PushQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0802:
        r2 = com.facebook.orca.server.module.BlueServiceHandler_PushQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x080a:
        r3 = "com.facebook.messaging.media.upload.PhotoResizeQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0812:
        r2 = com.facebook.messaging.media.upload.MediaUploadPhotoResizeHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x081a:
        r3 = "com.facebook.commerce.storefront.api.StoreFrontQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0822:
        r2 = com.facebook.commerce.storefront.api.StoreFrontServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x082a:
        r3 = "com.facebook.timeline.service.TimelineHeaderQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0832:
        r4 = com.facebook.timeline.service.TimelineHeaderServiceHandler.b(r0);
        r4 = (com.facebook.timeline.service.TimelineHeaderServiceHandler) r4;
        r4 = r4;
        r2 = r4;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x083e:
        r3 = "com.facebook.abtest.qe.service.module.QuickExperimentQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0846:
        r2 = com.facebook.abtest.qe.service.QuickExperimentSyncServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x084e:
        r3 = "com.facebook.feed.protocol.UFIQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0856:
        r2 = com.facebook.feed.module.BlueServiceHandler_UFIQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x085e:
        r3 = "com.facebook.messaging.business.nativesignup.annotations.NativeSignUpQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0866:
        r7 = new com.facebook.messaging.business.nativesignup.protocol.NativeSignUpServiceHandler;
        r4 = com.facebook.http.protocol.ApiMethodRunnerImpl.m15381a(r0);
        r4 = (com.facebook.http.protocol.ApiMethodRunnerImpl) r4;
        r9 = new com.facebook.messaging.business.nativesignup.protocol.methods.ProxyLoginMethod;
        r9.<init>();
        r8 = r9;
        r5 = r8;
        r5 = (com.facebook.messaging.business.nativesignup.protocol.methods.ProxyLoginMethod) r5;
        r9 = new com.facebook.messaging.business.nativesignup.protocol.methods.ThirdPartyRegistrationMethod;
        r9.<init>();
        r8 = r9;
        r6 = r8;
        r6 = (com.facebook.messaging.business.nativesignup.protocol.methods.ThirdPartyRegistrationMethod) r6;
        r7.<init>(r4, r5, r6);
        r2 = r7;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0888:
        r3 = "com.facebook.orca.server.module.MultiCacheThreadsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0890:
        r2 = com.facebook.orca.server.module.BlueServiceHandler_MultiCacheThreadsQueueMethodAutoProvider.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x0898:
        r3 = "com.facebook.config.background.impl.ConfigBackgroundQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x08a0:
        r2 = com.facebook.config.background.impl.ConfigBackgroundServiceHandler.b(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x08a8:
        r3 = "com.facebook.api.negative_feedback.NegativeFeedbackMessageActionsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x08b0:
        r5 = new com.facebook.api.negative_feedback.NegativeFeedbackMessageActionHandler;
        r4 = 2289; // 0x8f1 float:3.208E-42 double:1.131E-320;
        r6 = com.facebook.inject.IdBasedSingletonScopeProvider.m1809a(r0, r4);
        r8 = new com.facebook.api.negative_feedback.NegativeFeedbackMessageActionMethod;
        r8.<init>();
        r7 = r8;
        r4 = r7;
        r4 = (com.facebook.api.negative_feedback.NegativeFeedbackMessageActionMethod) r4;
        r5.<init>(r6, r4);
        r2 = r5;
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x08c9:
        r3 = "com.facebook.confirmation.service.AccountConfirmationQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x08d1:
        r2 = com.facebook.confirmation.service.AccountConfirmationServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x08d9:
        r3 = "com.facebook.messaging.media.upload.VideoTranscodeUploadQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x08e1:
        r2 = com.facebook.messaging.media.upload.segmented.VideoSegmentTranscodeUploadHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x08e9:
        r3 = "com.facebook.friendsnearby.server.FriendsNearbyMethodsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x08f1:
        r2 = com.facebook.friendsnearby.server.FriendsNearbyServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
    L_0x08f9:
        r3 = "com.facebook.commerce.productdetails.api.ProductDetailsQueue";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x000f;
    L_0x0901:
        r2 = com.facebook.commerce.productdetails.api.ProductDetailsServiceHandler.a(r0);
        r2 = (com.facebook.fbservice.service.BlueServiceHandler) r2;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbservice.service.STATICDI_VARIABLE_ANNOTATION_PROVIDER$BlueServiceHandler.get():java.lang.Object");
    }

    public static Provider<BlueServiceHandler> m32076a(InjectorLike injectorLike, Class<? extends Annotation> cls) {
        return new STATICDI_VARIABLE_ANNOTATION_PROVIDER$BlueServiceHandler(injectorLike.getScopeUnawareInjector(), cls);
    }
}
