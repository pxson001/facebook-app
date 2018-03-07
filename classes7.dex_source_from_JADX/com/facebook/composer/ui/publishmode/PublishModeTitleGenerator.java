package com.facebook.composer.ui.publishmode;

import android.content.Context;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.PublishMode;
import javax.inject.Inject;

/* compiled from: composer_creative_editing_tools */
public class PublishModeTitleGenerator {
    private final Context f17081a;
    private final DefaultTimeFormatUtil f17082b;

    /* compiled from: composer_creative_editing_tools */
    /* synthetic */ class C13831 {
        static final /* synthetic */ int[] f17080a = new int[PublishMode.values().length];

        static {
            try {
                f17080a[PublishMode.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17080a[PublishMode.SCHEDULE_POST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17080a[PublishMode.SAVE_DRAFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static PublishModeTitleGenerator m21032b(InjectorLike injectorLike) {
        return new PublishModeTitleGenerator((Context) injectorLike.getInstance(Context.class), DefaultTimeFormatUtil.a(injectorLike));
    }

    @Inject
    public PublishModeTitleGenerator(Context context, DefaultTimeFormatUtil defaultTimeFormatUtil) {
        this.f17081a = context;
        this.f17082b = defaultTimeFormatUtil;
    }

    public final String m21034a(PublishMode publishMode) {
        switch (C13831.f17080a[publishMode.ordinal()]) {
            case 1:
                return this.f17081a.getString(2131234634);
            case 2:
                return this.f17081a.getString(2131234635);
            case 3:
                return this.f17081a.getString(2131234636);
            default:
                throw new IllegalArgumentException("Unknown publish mode: " + publishMode);
        }
    }

    public final String m21033a(long j) {
        long a = this.f17082b.a(j * 1000);
        int i = (a == 0 || a == 1) ? 2131234623 : 2131234624;
        return this.f17081a.getString(i, new Object[]{m21035b(r2), m21036c(r2)});
    }

    public final String m21035b(long j) {
        return this.f17082b.a(TimeFormatStyle.EVENTS_RELATIVE_DATE_STYLE, j);
    }

    public final String m21036c(long j) {
        return this.f17082b.a(TimeFormatStyle.HOUR_MINUTE_STYLE, j);
    }
}
