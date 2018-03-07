package com.facebook.crowdsourcing.picker.hours;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.crowdsourcing.helper.HoursData;
import com.facebook.fbui.popover.PopoverSpinner;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.text.DateFormatSymbols;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: com.facebook.livephotos.exoplayer.MediaCodecTrackRenderer_ */
public class HoursPickerFragment extends FbFragment {
    @Inject
    public HoursPickerController f17507a;
    @Inject
    public Locale f17508b;
    private PopoverSpinner f17509c;
    private LinearLayout f17510d;
    private HoursForSingleDayView[] f17511e;

    /* compiled from: com.facebook.livephotos.exoplayer.MediaCodecTrackRenderer_ */
    class C14511 extends OnToolbarButtonListener {
        final /* synthetic */ HoursPickerFragment f17506a;

        C14511(HoursPickerFragment hoursPickerFragment) {
            this.f17506a = hoursPickerFragment;
        }

        public final void m21402a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f17506a.ao().onBackPressed();
        }
    }

    public static void m21403a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        HoursPickerFragment hoursPickerFragment = (HoursPickerFragment) obj;
        HoursPickerController a = HoursPickerController.m21385a(injectorLike);
        Locale b = LocaleMethodAutoProvider.b(injectorLike);
        hoursPickerFragment.f17507a = a;
        hoursPickerFragment.f17508b = b;
    }

    public final void m21407c(Bundle bundle) {
        super.c(bundle);
        Class cls = HoursPickerFragment.class;
        m21403a(this, getContext());
    }

    public final void m21405G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 97486171);
        super.G();
        HasTitleBar hasTitleBar = (HasTitleBar) Preconditions.checkNotNull(a(HasTitleBar.class));
        hasTitleBar.setCustomTitle(null);
        hasTitleBar.y_(2131239149);
        hasTitleBar.c(true);
        Builder a2 = TitleBarButtonSpec.a();
        a2.g = b(2131239153);
        a2 = a2;
        a2.d = true;
        hasTitleBar.a(a2.a());
        hasTitleBar.a(new C14511(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2119318083, a);
    }

    public final View m21406a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1170552361);
        View inflate = layoutInflater.inflate(2130904799, viewGroup, false);
        this.f17509c = (PopoverSpinner) FindViewUtil.b(inflate, 2131562927);
        this.f17510d = (LinearLayout) FindViewUtil.b(inflate, 2131562928);
        this.f17511e = new HoursForSingleDayView[]{new HoursForSingleDayView(getContext()), (HoursForSingleDayView) FindViewUtil.b(inflate, 2131562935), (HoursForSingleDayView) FindViewUtil.b(inflate, 2131562929), (HoursForSingleDayView) FindViewUtil.b(inflate, 2131562930), (HoursForSingleDayView) FindViewUtil.b(inflate, 2131562931), (HoursForSingleDayView) FindViewUtil.b(inflate, 2131562932), (HoursForSingleDayView) FindViewUtil.b(inflate, 2131562933), (HoursForSingleDayView) FindViewUtil.b(inflate, 2131562934)};
        m21404e();
        this.f17507a.m21401a(this.f17509c, this.f17510d, this.f17511e, this.s.getInt("extra_hours_selected_option"), Optional.fromNullable((HoursData) this.s.getParcelable("extra_hours_data")), this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 758583430, a);
        return inflate;
    }

    private void m21404e() {
        String[] weekdays = new DateFormatSymbols(this.f17508b).getWeekdays();
        ImmutableList immutableList = HoursData.f17422a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            int intValue = ((Integer) immutableList.get(i)).intValue();
            this.f17511e[intValue].setDayNameLabel(StringUtil.c(weekdays[intValue]));
        }
    }
}
