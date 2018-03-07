package com.facebook.messaging.sounds;

import android.content.Context;

/* compiled from: com.facebook.messaging.sms.HEADLESS_SEND */
public enum NotificationSoundFiles {
    BABYGIGGLE(2131231412, 2131165186),
    BIRDIE(2131231413, 2131165187),
    BLING(2131231414, 2131165188),
    BLIPBEEP(2131231415, 2131165189),
    CHIME(2131231416, 2131165195),
    CRICKETS(2131231417, 2131165201),
    DOGBARK(2131231418, 2131165205),
    DOUBLEKNOCK(2131231419, 2131165208),
    DOUBLEPOP(2131231420, 2131165209),
    DREAMY(2131231421, 2131165210),
    FANFARE(2131231422, 2131165219),
    HELLO(2131231423, 2131165223),
    MESSAGEKID(2131231424, 2131165246),
    OPENUP(2131231425, 2131165258),
    ORCHESTRAHIT(2131231426, 2131165262),
    PING(2131231427, 2131165268),
    PULSE(2131231428, 2131165287),
    RESONATE(2131231429, 2131165300),
    RIMSHOT(2131231430, 2131165301),
    RINGRING(2131231431, 2131165302),
    RIPPLE(2131231432, 2131165303),
    SINGLEPOP(2131231433, 2131165313),
    SIZZLE(2131231434, 2131165314),
    TAP(2131231435, 2131165331),
    TRIPLEPOP(2131231436, 2131165332),
    VIBRATION(2131231437, 2131165333),
    WHISTLE(2131231438, 2131165347),
    ZIPZAP(2131231439, 2131165349);
    
    public int nameResId;
    public int rawResId;

    private NotificationSoundFiles(int i, int i2) {
        this.nameResId = i;
        this.rawResId = i2;
    }

    public final String getUri(Context context) {
        return "android.resource://" + context.getResources().getResourcePackageName(this.rawResId) + '/' + context.getResources().getResourceTypeName(this.rawResId) + '/' + context.getResources().getResourceEntryName(this.rawResId);
    }
}
