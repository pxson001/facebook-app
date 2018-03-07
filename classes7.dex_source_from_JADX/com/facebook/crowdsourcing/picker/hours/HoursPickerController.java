package com.facebook.crowdsourcing.picker.hours;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListAdapter;
import android.widget.TimePicker;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.crowdsourcing.helper.HoursData;
import com.facebook.crowdsourcing.helper.HoursData.HoursForSingleDay;
import com.facebook.crowdsourcing.helper.HoursData.HoursInterval;
import com.facebook.crowdsourcing.helper.HoursDataHelper;
import com.facebook.crowdsourcing.picker.hours.HoursForSingleDayView.HoursOnClickListener;
import com.facebook.fbui.popover.PopoverSpinner;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.dialog.FbTimePickerDialog;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.facebook.livephotos.exoplayer.ext.flac.FlacExtractor */
public class HoursPickerController implements OnItemSelectedListener {
    private static volatile HoursPickerController f17498h;
    public HoursPickerFragment f17499a;
    public final HoursDataHelper f17500b;
    public final HoursDataMutator f17501c;
    private final Resources f17502d;
    private ViewGroup f17503e;
    public int f17504f;
    public HoursData f17505g;

    /* compiled from: com.facebook.livephotos.exoplayer.ext.flac.FlacExtractor */
    public class C14462 implements OnTimeSetListener {
        final /* synthetic */ int f17481a;
        final /* synthetic */ int f17482b;
        final /* synthetic */ HoursForSingleDayView f17483c;
        final /* synthetic */ HoursPickerController f17484d;

        public C14462(HoursPickerController hoursPickerController, int i, int i2, HoursForSingleDayView hoursForSingleDayView) {
            this.f17484d = hoursPickerController;
            this.f17481a = i;
            this.f17482b = i2;
            this.f17483c = hoursForSingleDayView;
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            HoursForSingleDay a = HoursDataMutator.m21363a(this.f17484d.f17505g.m21322a(this.f17481a), this.f17482b, this.f17484d.f17500b.m21328a(this.f17481a, i, i2), ((HoursInterval) this.f17484d.f17505g.m21322a(this.f17481a).f17418a.get(this.f17482b)).f17421b);
            this.f17484d.f17505g.m21323a(this.f17481a, a);
            HoursPickerController.m21390a(this.f17484d, this.f17483c, a, this.f17482b);
            HoursPickerFragment hoursPickerFragment = this.f17484d.f17499a;
            Intent intent = new Intent();
            intent.putExtra("extra_hours_selected_option", hoursPickerFragment.f17507a.f17504f);
            if (hoursPickerFragment.f17507a.f17504f == 0) {
                intent.putExtra("extra_hours_data", hoursPickerFragment.f17507a.f17505g);
            }
            hoursPickerFragment.ao().setResult(-1, intent);
        }
    }

    /* compiled from: com.facebook.livephotos.exoplayer.ext.flac.FlacExtractor */
    public class C14473 implements OnTimeSetListener {
        final /* synthetic */ int f17485a;
        final /* synthetic */ int f17486b;
        final /* synthetic */ HoursForSingleDayView f17487c;
        final /* synthetic */ HoursPickerController f17488d;

        public C14473(HoursPickerController hoursPickerController, int i, int i2, HoursForSingleDayView hoursForSingleDayView) {
            this.f17488d = hoursPickerController;
            this.f17485a = i;
            this.f17486b = i2;
            this.f17487c = hoursForSingleDayView;
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            HoursForSingleDay a = HoursDataMutator.m21363a(this.f17488d.f17505g.m21322a(this.f17485a), this.f17486b, ((HoursInterval) this.f17488d.f17505g.m21322a(this.f17485a).f17418a.get(this.f17486b)).f17420a, this.f17488d.f17500b.m21328a(this.f17485a, i, i2));
            this.f17488d.f17505g.m21323a(this.f17485a, a);
            HoursPickerController.m21390a(this.f17488d, this.f17487c, a, this.f17486b);
            HoursPickerFragment hoursPickerFragment = this.f17488d.f17499a;
            Intent intent = new Intent();
            intent.putExtra("extra_hours_selected_option", hoursPickerFragment.f17507a.f17504f);
            if (hoursPickerFragment.f17507a.f17504f == 0) {
                intent.putExtra("extra_hours_data", hoursPickerFragment.f17507a.f17505g);
            }
            hoursPickerFragment.ao().setResult(-1, intent);
        }
    }

    public static com.facebook.crowdsourcing.picker.hours.HoursPickerController m21385a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f17498h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.crowdsourcing.picker.hours.HoursPickerController.class;
        monitor-enter(r1);
        r0 = f17498h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m21395b(r0);	 Catch:{ all -> 0x0035 }
        f17498h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17498h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.crowdsourcing.picker.hours.HoursPickerController.a(com.facebook.inject.InjectorLike):com.facebook.crowdsourcing.picker.hours.HoursPickerController");
    }

    private static HoursPickerController m21395b(InjectorLike injectorLike) {
        return new HoursPickerController(HoursDataHelper.m21326b(injectorLike), new HoursDataMutator(HoursDataHelper.m21326b(injectorLike)), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public HoursPickerController(HoursDataHelper hoursDataHelper, HoursDataMutator hoursDataMutator, Resources resources) {
        this.f17500b = hoursDataHelper;
        this.f17501c = hoursDataMutator;
        this.f17502d = resources;
    }

    public final void m21401a(PopoverSpinner popoverSpinner, ViewGroup viewGroup, HoursForSingleDayView[] hoursForSingleDayViewArr, int i, Optional<HoursData> optional, OnHoursChangedListener onHoursChangedListener) {
        this.f17503e = viewGroup;
        this.f17499a = onHoursChangedListener;
        ListAdapter arrayAdapter = new ArrayAdapter(popoverSpinner.getContext(), 2130904801, this.f17502d.getStringArray(2131755083));
        this.f17504f = i;
        popoverSpinner.setAdapter(arrayAdapter);
        popoverSpinner.setSelection(i);
        popoverSpinner.setOnItemSelectedListener(this);
        m21386a(i);
        if (optional.isPresent()) {
            this.f17505g = (HoursData) optional.get();
            m21392a(hoursForSingleDayViewArr, (HoursData) optional.get());
        } else {
            this.f17505g = new HoursData();
        }
        m21391a(hoursForSingleDayViewArr);
        m21398b(hoursForSingleDayViewArr);
        m21400c(hoursForSingleDayViewArr);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = this.f17504f;
        this.f17504f = i;
        m21386a(i);
        if (this.f17504f != i2) {
            HoursPickerFragment hoursPickerFragment = this.f17499a;
            Intent intent = new Intent();
            intent.putExtra("extra_hours_selected_option", hoursPickerFragment.f17507a.f17504f);
            if (hoursPickerFragment.f17507a.f17504f == 0) {
                intent.putExtra("extra_hours_data", hoursPickerFragment.f17507a.f17505g);
            }
            hoursPickerFragment.ao().setResult(-1, intent);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    private void m21386a(int i) {
        this.f17503e.setVisibility(i == 0 ? 0 : 8);
    }

    private void m21392a(HoursForSingleDayView[] hoursForSingleDayViewArr, HoursData hoursData) {
        ImmutableList immutableList = HoursData.f17422a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            int intValue = ((Integer) immutableList.get(i)).intValue();
            HoursForSingleDay a = hoursData.m21322a(intValue);
            if (a.f17418a.isEmpty()) {
                hoursForSingleDayViewArr[intValue].m21374a();
            } else {
                hoursForSingleDayViewArr[intValue].m21376b();
                m21387a(hoursForSingleDayViewArr[intValue], (HoursInterval) a.f17418a.get(0));
                if (a.f17418a.size() > 1) {
                    m21397b(this, hoursForSingleDayViewArr[intValue], (HoursInterval) a.f17418a.get(1));
                }
            }
        }
    }

    private void m21391a(HoursForSingleDayView[] hoursForSingleDayViewArr) {
        ImmutableList immutableList = HoursData.f17422a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            final int intValue = ((Integer) immutableList.get(i)).intValue();
            final HoursForSingleDayView hoursForSingleDayView = hoursForSingleDayViewArr[intValue];
            hoursForSingleDayViewArr[intValue].setHoursOnClickListener(new HoursOnClickListener(this) {
                final /* synthetic */ HoursPickerController f17480c;

                public final void mo1365a(int i) {
                    if (HoursPickerController.m21393a(this.f17480c, intValue, i)) {
                        HoursPickerController.m21388a(this.f17480c, hoursForSingleDayView.getContext(), (OnTimeSetListener) new C14462(this.f17480c, intValue, i, hoursForSingleDayView), ((HoursInterval) this.f17480c.f17505g.m21322a(intValue).f17418a.get(i)).f17420a);
                    }
                }

                public final void mo1366b(int i) {
                    if (HoursPickerController.m21393a(this.f17480c, intValue, i)) {
                        HoursPickerController.m21388a(this.f17480c, hoursForSingleDayView.getContext(), (OnTimeSetListener) new C14473(this.f17480c, intValue, i, hoursForSingleDayView), ((HoursInterval) this.f17480c.f17505g.m21322a(intValue).f17418a.get(i)).f17421b);
                    }
                }
            });
        }
    }

    public static void m21388a(HoursPickerController hoursPickerController, Context context, OnTimeSetListener onTimeSetListener, long j) {
        new FbTimePickerDialog(context, onTimeSetListener, hoursPickerController.f17500b.m21330b(j), hoursPickerController.f17500b.m21331c(j), DateFormat.is24HourFormat(context)).show();
    }

    public static boolean m21393a(HoursPickerController hoursPickerController, int i, int i2) {
        return i2 >= 0 && i2 < hoursPickerController.f17505g.m21322a(i).f17418a.size();
    }

    private void m21398b(HoursForSingleDayView[] hoursForSingleDayViewArr) {
        ImmutableList immutableList = HoursData.f17422a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            final int intValue = ((Integer) immutableList.get(i)).intValue();
            final HoursForSingleDayView hoursForSingleDayView = hoursForSingleDayViewArr[intValue];
            hoursForSingleDayView.setCheckBoxOnCheckedChangeListener(new OnCheckedChangeListener(this) {
                final /* synthetic */ HoursPickerController f17491c;

                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    hoursForSingleDayView.setChildrenVisibility(z);
                    if (z) {
                        HoursPickerController.m21389a(this.f17491c, hoursForSingleDayView, intValue);
                    }
                    this.f17491c.f17505g.m21322a(intValue).f17419b = z;
                    HoursPickerFragment hoursPickerFragment = this.f17491c.f17499a;
                    Intent intent = new Intent();
                    intent.putExtra("extra_hours_selected_option", hoursPickerFragment.f17507a.f17504f);
                    if (hoursPickerFragment.f17507a.f17504f == 0) {
                        intent.putExtra("extra_hours_data", hoursPickerFragment.f17507a.f17505g);
                    }
                    hoursPickerFragment.ao().setResult(-1, intent);
                }
            });
        }
    }

    public static void m21389a(HoursPickerController hoursPickerController, HoursForSingleDayView hoursForSingleDayView, int i) {
        if (!hoursForSingleDayView.m21378e()) {
            int i2 = i == 1 ? 7 : i - 1;
            while (i2 >= 2) {
                if (hoursPickerController.f17505g.m21322a(i2).f17419b && !hoursPickerController.f17505g.m21322a(i2).f17418a.isEmpty()) {
                    break;
                }
                i2--;
            }
            i2 = -1;
            int i3 = i2;
            if (i3 == -1) {
                hoursPickerController.m21396b(hoursForSingleDayView, i);
            } else {
                hoursPickerController.m21399c(hoursForSingleDayView, i, i3);
            }
            HoursPickerFragment hoursPickerFragment = hoursPickerController.f17499a;
            Intent intent = new Intent();
            intent.putExtra("extra_hours_selected_option", hoursPickerFragment.f17507a.f17504f);
            if (hoursPickerFragment.f17507a.f17504f == 0) {
                intent.putExtra("extra_hours_data", hoursPickerFragment.f17507a.f17505g);
            }
            hoursPickerFragment.ao().setResult(-1, intent);
        }
    }

    private void m21396b(HoursForSingleDayView hoursForSingleDayView, int i) {
        this.f17501c.m21368a(this.f17505g, i);
        m21387a(hoursForSingleDayView, m21384a(this.f17505g.m21322a(i)));
    }

    private void m21399c(HoursForSingleDayView hoursForSingleDayView, int i, int i2) {
        HoursDataMutator hoursDataMutator = this.f17501c;
        HoursData hoursData = this.f17505g;
        HoursForSingleDay a = hoursData.m21322a(i2);
        for (int i3 = 0; i3 < a.f17418a.size(); i3++) {
            long j = ((HoursInterval) a.f17418a.get(i3)).f17420a;
            long j2 = ((HoursInterval) a.f17418a.get(i3)).f17421b;
            hoursData.m21323a(i, HoursDataMutator.m21364a(hoursData.m21322a(i), hoursDataMutator.f17460a.m21328a(i, hoursDataMutator.f17460a.m21330b(j), hoursDataMutator.f17460a.m21331c(j)), hoursDataMutator.f17460a.m21328a(i, hoursDataMutator.f17460a.m21330b(j2), hoursDataMutator.f17460a.m21331c(j2))));
        }
        m21387a(hoursForSingleDayView, m21384a(this.f17505g.m21322a(i)));
        if (this.f17505g.m21322a(i).f17418a.size() > 1) {
            m21397b(this, hoursForSingleDayView, m21394b(this.f17505g.m21322a(i)));
        }
    }

    private void m21400c(HoursForSingleDayView[] hoursForSingleDayViewArr) {
        ImmutableList immutableList = HoursData.f17422a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            final int intValue = ((Integer) immutableList.get(i)).intValue();
            final HoursForSingleDayView hoursForSingleDayView = hoursForSingleDayViewArr[intValue];
            hoursForSingleDayView.setAddIntervalButtonOnClickListener(new OnClickListener(this) {
                final /* synthetic */ HoursPickerController f17494c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1912620511);
                    this.f17494c.f17501c.m21368a(this.f17494c.f17505g, intValue);
                    HoursPickerController hoursPickerController = this.f17494c;
                    HoursForSingleDayView hoursForSingleDayView = hoursForSingleDayView;
                    HoursPickerController hoursPickerController2 = this.f17494c;
                    HoursPickerController.m21397b(hoursPickerController, hoursForSingleDayView, HoursPickerController.m21394b(this.f17494c.f17505g.m21322a(intValue)));
                    HoursPickerFragment hoursPickerFragment = this.f17494c.f17499a;
                    Intent intent = new Intent();
                    intent.putExtra("extra_hours_selected_option", hoursPickerFragment.f17507a.f17504f);
                    if (hoursPickerFragment.f17507a.f17504f == 0) {
                        intent.putExtra("extra_hours_data", hoursPickerFragment.f17507a.f17505g);
                    }
                    hoursPickerFragment.ao().setResult(-1, intent);
                    Logger.a(2, EntryType.UI_INPUT_END, 396677775, a);
                }
            });
            hoursForSingleDayView.setRemoveIntervalButtonOnClickListener(new OnClickListener(this) {
                final /* synthetic */ HoursPickerController f17497c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1137773741);
                    hoursForSingleDayView.m21377b(null, null);
                    HoursData hoursData = this.f17497c.f17505g;
                    int i = intValue;
                    if (1 < hoursData.m21322a(i).f17418a.size()) {
                        HoursForSingleDay a2 = hoursData.m21322a(i);
                        Builder builder = ImmutableList.builder();
                        for (int i2 = 0; i2 < a2.f17418a.size(); i2++) {
                            if (i2 != 1) {
                                builder.c(a2.f17418a.get(i2));
                            }
                        }
                        hoursData.m21323a(i, new HoursForSingleDay(builder.b()));
                    }
                    HoursPickerFragment hoursPickerFragment = this.f17497c.f17499a;
                    Intent intent = new Intent();
                    intent.putExtra("extra_hours_selected_option", hoursPickerFragment.f17507a.f17504f);
                    if (hoursPickerFragment.f17507a.f17504f == 0) {
                        intent.putExtra("extra_hours_data", hoursPickerFragment.f17507a.f17505g);
                    }
                    hoursPickerFragment.ao().setResult(-1, intent);
                    Logger.a(2, EntryType.UI_INPUT_END, -1410117268, a);
                }
            });
        }
    }

    public static void m21390a(HoursPickerController hoursPickerController, HoursForSingleDayView hoursForSingleDayView, HoursForSingleDay hoursForSingleDay, int i) {
        if (i == 0) {
            hoursPickerController.m21387a(hoursForSingleDayView, (HoursInterval) hoursForSingleDay.f17418a.get(i));
        } else {
            m21397b(hoursPickerController, hoursForSingleDayView, (HoursInterval) hoursForSingleDay.f17418a.get(i));
        }
    }

    private static HoursInterval m21384a(HoursForSingleDay hoursForSingleDay) {
        return (HoursInterval) hoursForSingleDay.f17418a.get(0);
    }

    public static HoursInterval m21394b(HoursForSingleDay hoursForSingleDay) {
        return (HoursInterval) hoursForSingleDay.f17418a.get(1);
    }

    private void m21387a(HoursForSingleDayView hoursForSingleDayView, HoursInterval hoursInterval) {
        hoursForSingleDayView.m21375a(this.f17500b.m21329a(hoursInterval.f17420a), this.f17500b.m21329a(hoursInterval.f17421b));
    }

    public static void m21397b(HoursPickerController hoursPickerController, HoursForSingleDayView hoursForSingleDayView, HoursInterval hoursInterval) {
        hoursForSingleDayView.m21377b(hoursPickerController.f17500b.m21329a(hoursInterval.f17420a), hoursPickerController.f17500b.m21329a(hoursInterval.f17421b));
    }
}
