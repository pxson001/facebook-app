package com.facebook.rtc.voicemail;

/* compiled from: app_discovery_lite_load_failed */
class VoicemailHandler$1 implements Runnable {
    final /* synthetic */ VoicemailHandler f20365a;

    VoicemailHandler$1(VoicemailHandler voicemailHandler) {
        this.f20365a = voicemailHandler;
    }

    public void run() {
        Object obj;
        VoicemailHandler voicemailHandler = this.f20365a;
        voicemailHandler.j.b();
        VoicemailAssetUrlFetcher voicemailAssetUrlFetcher = voicemailHandler.i;
        if (voicemailAssetUrlFetcher.b.a() - voicemailAssetUrlFetcher.a.a(VoicemailAssetUrlFetcher.g(), -1) > 2592000000L) {
            obj = 1;
        } else {
            obj = null;
        }
        Object obj2 = obj;
        if (obj2 != null) {
            voicemailHandler.i.a.edit().a(VoicemailAssetUrlFetcher.f()).commit();
        }
        voicemailHandler.o = voicemailHandler.i.b();
        if (voicemailHandler.o == null) {
            voicemailHandler.o = voicemailHandler.i.a();
            VoicemailAssetUrlFetcher voicemailAssetUrlFetcher2 = voicemailHandler.i;
            voicemailAssetUrlFetcher2.a.edit().a(VoicemailAssetUrlFetcher.g(), voicemailAssetUrlFetcher2.b.a()).commit();
        }
        if (voicemailHandler.o != null) {
            voicemailAssetUrlFetcher2 = voicemailHandler.i;
            voicemailAssetUrlFetcher2.a.edit().a(VoicemailAssetUrlFetcher.f(), voicemailHandler.o).commit();
        }
        if (obj2 != null) {
            voicemailHandler.f.b(voicemailHandler.o);
        }
        voicemailHandler.f.a(voicemailHandler.o, voicemailHandler, VoicemailHandler.b);
    }
}
