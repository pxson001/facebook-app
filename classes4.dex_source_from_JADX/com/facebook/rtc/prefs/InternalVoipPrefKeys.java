package com.facebook.rtc.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: from_notification */
public class InternalVoipPrefKeys {
    public static final PrefKey f11348A = ((PrefKey) f11368a.a("audio_exp_agc"));
    public static final PrefKey f11349B = ((PrefKey) f11368a.a("audio_ec_mode"));
    public static final PrefKey f11350C = ((PrefKey) f11368a.a("audio_agc_mode"));
    public static final PrefKey f11351D = ((PrefKey) f11368a.a("audio_ns_mode"));
    public static final PrefKey f11352E = ((PrefKey) f11368a.a("audio_lafns_mode"));
    public static final PrefKey f11353F = ((PrefKey) f11368a.a("starve_smoothing"));
    public static final PrefKey f11354G = ((PrefKey) f11368a.a("record_remote_video"));
    public static final PrefKey f11355H = ((PrefKey) f11368a.a("record_remote_raw_video"));
    public static final PrefKey f11356I = ((PrefKey) f11368a.a("record_self_video"));
    public static final PrefKey f11357J = ((PrefKey) f11368a.a("record_self_raw_video"));
    public static final PrefKey f11358K = ((PrefKey) f11368a.a("load_self_raw_video"));
    public static final PrefKey f11359L = ((PrefKey) f11368a.a("loop_video_playback"));
    public static final PrefKey f11360M = ((PrefKey) f11368a.a("preprocess_frames"));
    public static final PrefKey f11361N = ((PrefKey) f11368a.a("record_directory"));
    public static final PrefKey f11362O = ((PrefKey) f11368a.a("play_sample"));
    public static final PrefKey f11363P = ((PrefKey) f11368a.a("auto_answer"));
    public static final PrefKey f11364Q = ((PrefKey) f11368a.a("automated_test_support"));
    public static final PrefKey f11365R = ((PrefKey) f11368a.a("video_width"));
    public static final PrefKey f11366S = ((PrefKey) f11368a.a("video_height"));
    public static final PrefKey f11367T = ((PrefKey) f11368a.a("campon_campers"));
    public static final PrefKey f11368a;
    public static final PrefKey f11369b;
    public static final PrefKey f11370c = ((PrefKey) f11368a.a("saved_audio_mode"));
    public static final PrefKey f11371d = ((PrefKey) f11368a.a("audio_mode_test"));
    public static final PrefKey f11372e = ((PrefKey) f11368a.a("logging_level"));
    public static final PrefKey f11373f = ((PrefKey) f11368a.a("codec_mode_override2"));
    public static final PrefKey f11374g = ((PrefKey) f11368a.a("codec_rate_override2"));
    public static final PrefKey f11375h = ((PrefKey) f11368a.a("voip_bwe_logging"));
    public static final PrefKey f11376i = ((PrefKey) f11368a.a("audio_ec"));
    public static final PrefKey f11377j = ((PrefKey) f11368a.a("ispx_initial_sub_codec"));
    public static final PrefKey f11378k = ((PrefKey) f11368a.a("opispx_initial_sub_codec"));
    public static final PrefKey f11379l = ((PrefKey) f11368a.a("ispx_codec_switch_enabled"));
    public static final PrefKey f11380m = ((PrefKey) f11368a.a("ispx_fec_override_mode"));
    public static final PrefKey f11381n = ((PrefKey) f11368a.a("ispx_impl"));
    public static final PrefKey f11382o = ((PrefKey) f11368a.a("speex_per_packet_ispx"));
    public static final PrefKey f11383p = ((PrefKey) f11368a.a("isac_per_packet_ispx"));
    public static final PrefKey f11384q = ((PrefKey) f11368a.a("ispx_max_aggregation_bwe_offset_isac"));
    public static final PrefKey f11385r = ((PrefKey) f11368a.a("ispx_aggregation_stabilization_ms_isac"));
    public static final PrefKey f11386s = ((PrefKey) f11368a.a("isac_initial_bitrate"));
    public static final PrefKey f11387t = ((PrefKey) f11368a.a("speex_initial_bitrate"));
    public static final PrefKey f11388u = ((PrefKey) f11368a.a("ssl_private_key_0"));
    public static final PrefKey f11389v = ((PrefKey) f11368a.a("ssl_certificate_0"));
    public static final PrefKey f11390w = ((PrefKey) f11368a.a("audio_agc"));
    public static final PrefKey f11391x = ((PrefKey) f11368a.a("audio_ns"));
    public static final PrefKey f11392y = ((PrefKey) f11368a.a("audio_high_pass_filter"));
    public static final PrefKey f11393z = ((PrefKey) f11368a.a("audio_cng"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.c.a("voip/");
        f11368a = prefKey;
        f11369b = (PrefKey) prefKey.a("audio_mode");
    }
}
