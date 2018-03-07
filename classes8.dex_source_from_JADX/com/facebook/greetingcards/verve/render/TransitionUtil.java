package com.facebook.greetingcards.verve.render;

import android.text.TextUtils;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.draggable.Direction;
import com.facebook.greetingcards.verve.model.VMAction;
import com.facebook.greetingcards.verve.model.VMDeck;
import com.facebook.greetingcards.verve.model.VMSlide;
import java.util.Iterator;

/* compiled from: view_story_insights_tap */
public class TransitionUtil {
    private static final Class<?> f394a = TransitionUtil.class;

    /* compiled from: view_story_insights_tap */
    /* synthetic */ class C00431 {
        static final /* synthetic */ int[] f393a = new int[Direction.values().length];

        static {
            try {
                f393a[Direction.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f393a[Direction.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f393a[Direction.UP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f393a[Direction.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static int m361a(VMDeck vMDeck, int i) {
        VMSlide vMSlide = (VMSlide) vMDeck.slides.get(i);
        if (vMSlide.actionsMap == null) {
            return 0;
        }
        Iterator it = vMSlide.actionsMap.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            for (Direction direction : Direction.values()) {
                if (TextUtils.equals(m364a(direction), str)) {
                    try {
                        m362a(vMDeck, i, direction);
                        i2 |= direction.flag();
                    } catch (Throwable e) {
                        BLog.a(f394a, "Unable to get new slide for swipe", e);
                    }
                }
            }
        }
        return i2;
    }

    public static int m362a(VMDeck vMDeck, int i, Direction direction) {
        VMAction vMAction = (VMAction) ((VMSlide) vMDeck.slides.get(i)).actionsMap.get(m364a(direction));
        if ("select-slide".equals(vMAction.type)) {
            return m363a(vMDeck, vMAction.arg);
        }
        if ("previous-slide".equals(vMAction.type)) {
            return i - 1;
        }
        if ("next-slide".equals(vMAction.type)) {
            return i + 1;
        }
        throw new IllegalArgumentException("Unrecognized action type " + vMAction.type);
    }

    public static int m363a(VMDeck vMDeck, String str) {
        for (int i = 0; i < vMDeck.slides.size(); i++) {
            if (TextUtils.equals(((VMSlide) vMDeck.slides.get(i)).name, str)) {
                return i;
            }
        }
        throw new RuntimeException("No such slideName: " + str);
    }

    private static String m364a(Direction direction) {
        switch (C00431.f393a[direction.ordinal()]) {
            case 1:
                return "swipe-left";
            case 2:
                return "swipe-right";
            case 3:
                return "swipe-up";
            case 4:
                return "swipe-down";
            default:
                throw new IllegalArgumentException("Invalid direction " + direction);
        }
    }
}
