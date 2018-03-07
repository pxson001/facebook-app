package com.facebook.composer.minutiae.music;

import com.facebook.content.ActionReceiver;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;

/* compiled from: obj_id */
public class MusicBroadcastReceiver extends DynamicSecureBroadcastReceiver {
    private static final String[] f11659a = new String[]{"com.android.music.metachanged", "com.android.music.playstatechanged", "com.android.music.playbackcomplete", "com.android.music.queuechanged", "com.jrtstudio.music.playstatechanged", "com.jrtstudio.music.playbackcomplete", "com.jrtstudio.music.metachanged", "com.htc.music.playstatechanged", "com.htc.music.playbackcomplete", "com.htc.music.metachanged", "fm.last.android.metachanged", "fm.last.android.playbackpaused", "fm.last.android.playbackcomplete", "com.lge.music.metachanged", "com.lge.music.playstatechanged", "com.lge.music.endofplayback", "com.miui.player.playbackcomplete", "com.miui.player.metachanged", "com.real.IMP.playstatechanged", "com.real.IMP.playbackcomplete", "com.real.IMP.metachanged", "com.sonyericsson.music.metachanged", "com.sonyericsson.music.playbackcontrol.ACTION_PLAYBACK_PAUSE", "com.sonyericsson.music.playbackcontrol.ACTION_PAUSED", "com.samsung.sec.android.MusicPlayer.playstatechanged", "com.samsung.sec.android.MusicPlayer.playbackcomplete", "com.samsung.sec.android.MusicPlayer.metachanged", "com.nullsoft.winamp.metachanged", "com.nullsoft.winamp.playstatechanged", "com.nullsoft.winamp.playbackcomplete", "com.amazon.mp3.metachanged", "com.amazon.mp3.playstatechanged", "com.amazon.mp3.playbackcomplete", "com.rdio.android.metachanged", "com.rdio.android.playbackcomplete", "com.rdio.android.playstatechanged", "com.spotify.music.metadatachanged", "com.spotify.music.playbackstatechanged", "com.spotify.music.queuechanged", "com.doubleTwist.androidPlayer.metachanged", "com.doubleTwist.androidPlayer.playstatechanged", "com.doubleTwist.androidPlayer.playbackcomplete", "org.iii.romulus.meridian.playbackcomplete", "org.iii.romulus.meridian.playstatechanged", "org.iii.romulus.meridian.metachanged", "com.tbig.playerpro.playstatechanged", "com.tbig.playerpro.metachanged", "com.tbig.playerpro.queuechanged", "com.tbig.playerpro.playbackcomplete"};

    private static Map<String, ActionReceiver> m16943c() {
        MusicBroadcastActionReceiver musicBroadcastActionReceiver = new MusicBroadcastActionReceiver();
        Builder builder = ImmutableMap.builder();
        for (Object b : f11659a) {
            builder.m609b(b, musicBroadcastActionReceiver);
        }
        return builder.m610b();
    }

    public MusicBroadcastReceiver() {
        super(m16943c());
    }
}
