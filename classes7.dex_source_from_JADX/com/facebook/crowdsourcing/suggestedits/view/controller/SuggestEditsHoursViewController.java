package com.facebook.crowdsourcing.suggestedits.view.controller;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.util.StringUtil;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.enums.SuggestEditsListViewType;
import com.facebook.crowdsourcing.helper.HoursData;
import com.facebook.crowdsourcing.helper.HoursData.HoursInterval;
import com.facebook.crowdsourcing.helper.HoursDataHelper;
import com.facebook.crowdsourcing.picker.SuggestEditsPickerLauncher;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.CrowdsourcedHours;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.CrowdsourcedFieldModel.UserValuesModel.EdgesModel.NodeModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsOptionModel;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.crowdsourcing.suggestedits.helper.ExtractValuesHelper;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import com.facebook.crowdsourcing.suggestedits.view.SuggestEditsHoursView;
import com.facebook.graphql.enums.GraphQLSuggestEditsFieldOptionType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.text.DateFormatSymbols;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ci_flow */
public class SuggestEditsHoursViewController implements SuggestEditsViewController<SuggestEditsHoursView, SuggestEditsField> {
    private static final String f17742a = SuggestEditsHoursViewController.class.getSimpleName();
    private static final ImmutableList<Integer> f17743b = ImmutableList.of(Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(1));
    private final AbstractFbErrorReporter f17744c;
    private final HoursDataHelper f17745d;
    private final Locale f17746e;
    public final SuggestEditsPickerLauncher f17747f;

    /* compiled from: ci_flow */
    /* synthetic */ class C14882 {
        static final /* synthetic */ int[] f17741a = new int[GraphQLSuggestEditsFieldOptionType.values().length];

        static {
            try {
                f17741a[GraphQLSuggestEditsFieldOptionType.HAS_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17741a[GraphQLSuggestEditsFieldOptionType.DOESNT_HAVE_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17741a[GraphQLSuggestEditsFieldOptionType.ALWAYS_OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17741a[GraphQLSuggestEditsFieldOptionType.PERMANENTLY_CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public final Object mo1372a(View view, Object obj, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener) {
        return (SuggestEditsField) obj;
    }

    public final /* bridge */ /* synthetic */ void mo1373a(View view, Object obj, @Nullable Object obj2, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsController suggestEditsController, @Nullable SuggestEditsInputType suggestEditsInputType, Fragment fragment, String str) {
        m21605a((SuggestEditsHoursView) view, (SuggestEditsField) obj, suggestEditsFieldChangedListener, suggestEditsInputType, fragment);
    }

    @Inject
    public SuggestEditsHoursViewController(AbstractFbErrorReporter abstractFbErrorReporter, HoursDataHelper hoursDataHelper, Locale locale, SuggestEditsPickerLauncher suggestEditsPickerLauncher) {
        this.f17744c = abstractFbErrorReporter;
        this.f17745d = hoursDataHelper;
        this.f17746e = locale;
        this.f17747f = suggestEditsPickerLauncher;
    }

    public final SuggestEditsListViewType mo1371a() {
        return SuggestEditsListViewType.HOURS_FIELD;
    }

    public final View mo1370a(ViewGroup viewGroup) {
        return (SuggestEditsHoursView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907302, viewGroup, false);
    }

    private void m21605a(SuggestEditsHoursView suggestEditsHoursView, SuggestEditsField suggestEditsField, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsInputType suggestEditsInputType, Fragment fragment) {
        suggestEditsHoursView.m21560a();
        switch (C14882.f17741a[suggestEditsField.ew_().ordinal()]) {
            case 1:
                CrowdsourcedHours f = ExtractValuesHelper.m21538f(suggestEditsField);
                if (f == null || m21607a(f)) {
                    m21610d(suggestEditsHoursView, suggestEditsField, suggestEditsFieldChangedListener, suggestEditsInputType, fragment);
                    return;
                } else {
                    m21608b(suggestEditsHoursView, suggestEditsField, suggestEditsFieldChangedListener, suggestEditsInputType, fragment);
                    return;
                }
            case 2:
            case 3:
            case 4:
                m21609c(suggestEditsHoursView, suggestEditsField, suggestEditsFieldChangedListener, suggestEditsInputType, fragment);
                return;
            default:
                this.f17744c.a(f17742a, "Trying to bind view with unsupported option selected: " + suggestEditsField.ew_());
                return;
        }
    }

    private static boolean m21607a(CrowdsourcedHours crowdsourcedHours) {
        ImmutableList immutableList = HoursData.f17422a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ImmutableList immutableList2 = HoursDataHelper.m21324a(((Integer) immutableList.get(i)).intValue(), crowdsourcedHours).f17418a;
            int size2 = immutableList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                HoursInterval hoursInterval = (HoursInterval) immutableList2.get(i2);
                if (hoursInterval.f17420a != 0 || hoursInterval.f17421b != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void m21608b(SuggestEditsHoursView suggestEditsHoursView, SuggestEditsField suggestEditsField, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsInputType suggestEditsInputType, Fragment fragment) {
        NodeModel f = ExtractValuesHelper.m21538f(suggestEditsField);
        if (f != null) {
            m21606a(suggestEditsHoursView, f);
        }
        suggestEditsHoursView.setFieldIcon(ExtractValuesHelper.m21530a(suggestEditsField));
        suggestEditsHoursView.setOnClickListener(m21603a(suggestEditsField, suggestEditsFieldChangedListener, suggestEditsInputType, fragment));
    }

    private void m21609c(SuggestEditsHoursView suggestEditsHoursView, SuggestEditsField suggestEditsField, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsInputType suggestEditsInputType, Fragment fragment) {
        SuggestEditsOptionModel i = ExtractValuesHelper.m21541i(suggestEditsField);
        suggestEditsHoursView.m21559a(i.m2837b(), ExtractValuesHelper.m21530a(suggestEditsField)).setFieldOnClickListener(m21603a(suggestEditsField, suggestEditsFieldChangedListener, suggestEditsInputType, fragment));
    }

    private void m21610d(SuggestEditsHoursView suggestEditsHoursView, SuggestEditsField suggestEditsField, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsInputType suggestEditsInputType, Fragment fragment) {
        suggestEditsHoursView.m21562b();
        suggestEditsHoursView.setOnClickListener(m21603a(suggestEditsField, suggestEditsFieldChangedListener, suggestEditsInputType, fragment));
    }

    private OnClickListener m21603a(SuggestEditsField suggestEditsField, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, @Nullable SuggestEditsInputType suggestEditsInputType, Fragment fragment) {
        if (suggestEditsInputType == null) {
            return null;
        }
        final SuggestEditsField suggestEditsField2 = suggestEditsField;
        final SuggestEditsInputType suggestEditsInputType2 = suggestEditsInputType;
        final SuggestEditsFieldChangedListener suggestEditsFieldChangedListener2 = suggestEditsFieldChangedListener;
        final Fragment fragment2 = fragment;
        return new OnClickListener(this) {
            final /* synthetic */ SuggestEditsHoursViewController f17740e;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1754505737);
                this.f17740e.f17747f.m21362a(suggestEditsField2, suggestEditsInputType2, suggestEditsFieldChangedListener2, fragment2);
                Logger.a(2, EntryType.UI_INPUT_END, -1351147038, a);
            }
        };
    }

    private void m21606a(SuggestEditsHoursView suggestEditsHoursView, NodeModel nodeModel) {
        Resources resources = suggestEditsHoursView.getResources();
        String[] weekdays = new DateFormatSymbols(this.f17746e).getWeekdays();
        int size = f17743b.size();
        for (int i = 0; i < size; i++) {
            int intValue = ((Integer) f17743b.get(i)).intValue();
            String a = m21604a(intValue, nodeModel, resources);
            if (Strings.isNullOrEmpty(a)) {
                suggestEditsHoursView.m21561a(StringUtil.c(weekdays[intValue]));
            } else {
                suggestEditsHoursView.m21563b(StringUtil.c(weekdays[intValue]), a);
            }
        }
    }

    private String m21604a(int i, NodeModel nodeModel, Resources resources) {
        StringBuilder stringBuilder = new StringBuilder();
        ImmutableList immutableList = HoursDataHelper.m21324a(i, nodeModel).f17418a;
        int size = immutableList.size();
        String str = "";
        for (int i2 = 0; i2 < size; i2++) {
            HoursInterval hoursInterval = (HoursInterval) immutableList.get(i2);
            stringBuilder.append(str);
            stringBuilder.append(resources.getString(2131239150, new Object[]{this.f17745d.m21329a(hoursInterval.f17420a), this.f17745d.m21329a(hoursInterval.f17421b)}));
            str = "\n";
        }
        return stringBuilder.toString();
    }
}
