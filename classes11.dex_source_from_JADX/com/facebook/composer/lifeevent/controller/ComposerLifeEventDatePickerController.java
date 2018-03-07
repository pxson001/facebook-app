package com.facebook.composer.lifeevent.controller;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.lifeevent.view.ComposerLifeEventWithDatePickerView;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.model.ComposerDateInfo.ProvidesDateInfo;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.uicontrib.datepicker.Date;
import com.facebook.uicontrib.datepicker.Date.Builder;
import java.util.Calendar;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fundraiser_campaign_fragment_invalid_payment_method */
public class ComposerLifeEventDatePickerController<DataProvider extends ProvidesDateInfo> implements ComposerEventHandler {
    private static final Date f6660a = new Builder().a();
    public final Context f6661b;
    public final DataProvider f6662c;
    public final ComposerLifeEventWithDatePickerView f6663d;
    public final TimeFormatUtil f6664e;
    public Date f6665f = f6660a;

    /* compiled from: fundraiser_campaign_fragment_invalid_payment_method */
    /* synthetic */ class C08442 {
        static final /* synthetic */ int[] f6659a = new int[ComposerEvent.values().length];

        static {
            try {
                f6659a[ComposerEvent.ON_FIRST_DRAW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6659a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Inject
    public ComposerLifeEventDatePickerController(@Assisted DataProvider dataProvider, @Assisted final DatePickerListener datePickerListener, @Assisted ComposerLifeEventWithDatePickerView composerLifeEventWithDatePickerView, Context context, TimeFormatUtil timeFormatUtil) {
        this.f6661b = context;
        this.f6664e = timeFormatUtil;
        this.f6663d = composerLifeEventWithDatePickerView;
        this.f6662c = dataProvider;
        this.f6663d.setDatePickerClickListener(new OnClickListener(this) {
            final /* synthetic */ ComposerLifeEventDatePickerController f6658b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1740940160);
                datePickerListener.f13963a.E().c.f6099a.dp.m7453a();
                Logger.a(2, EntryType.UI_INPUT_END, -2040571036, a);
            }
        });
    }

    public final void m8098a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        switch (C08442.f6659a[composerEvent.ordinal()]) {
            case 1:
            case 2:
                if (this.f6665f != this.f6662c.m7428d().a()) {
                    String num;
                    this.f6665f = this.f6662c.m7428d().a();
                    if (this.f6665f == null) {
                        this.f6665f = Date.a;
                    }
                    if (this.f6665f.b() == null) {
                        num = Integer.toString(this.f6665f.a());
                    } else if (this.f6665f.c() == null) {
                        r2 = this.f6665f;
                        r4 = Calendar.getInstance();
                        r4.set(r2.a(), r2.b().intValue() - 1, 1);
                        num = DateUtils.formatDateTime(this.f6661b, r4.getTimeInMillis(), 32);
                    } else {
                        r2 = this.f6665f;
                        r4 = Calendar.getInstance();
                        r4.set(r2.a(), r2.b().intValue() - 1, r2.c().intValue());
                        num = this.f6664e.a(TimeFormatStyle.EVENTS_RELATIVE_DATE_STYLE, r4.getTimeInMillis());
                    }
                    this.f6663d.setDateLabel(num);
                }
                return;
            default:
                return;
        }
    }
}
