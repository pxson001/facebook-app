package com.facebook.growth.nux.preferences;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.growth.nux.GrowthNUXConstants.UserAccountNUXStep;
import com.facebook.growth.nux.UserAccountNUXActivity;
import com.facebook.inject.FbInjector;
import com.facebook.widget.prefs.OrcaListPreference;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: p2p_request_payment_button_clicked */
public class ShowNUXStepPreference extends OrcaListPreference {
    @Inject
    public SecureContextHelper f7505a;
    private ImmutableList<String> f7506b;

    public static void m7802a(Object obj, Context context) {
        ((ShowNUXStepPreference) obj).f7505a = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    public ShowNUXStepPreference(Context context) {
        super(context);
        Class cls = ShowNUXStepPreference.class;
        m7802a(this, getContext());
    }

    public final void m7804a() {
        ImmutableList b = m7803b(this);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(b.get(i));
            arrayList2.add(Integer.toString(i));
        }
        setTitle("Show NUX step");
        setSummary("Show a single NUX step");
        setKey(ShowNUXStepPreference.class.getName());
        setPersistent(false);
        if (size == 0) {
            setEntries(new CharSequence[]{"There are no nux steps to show."});
            setEntryValues(new CharSequence[]{Integer.toString(-1)});
            return;
        }
        setEntries((CharSequence[]) arrayList.toArray(new CharSequence[size]));
        setEntryValues((CharSequence[]) arrayList2.toArray(new CharSequence[size]));
        final Context context = getContext();
        setOnPreferenceChangeListener(new OnPreferenceChangeListener(this) {
            final /* synthetic */ ShowNUXStepPreference f7504b;

            public boolean onPreferenceChange(Preference preference, Object obj) {
                Intent intent = new Intent(context, UserAccountNUXActivity.class);
                intent.putExtra("show_single_step", (String) ShowNUXStepPreference.m7803b(this.f7504b).get(Integer.parseInt((String) obj)));
                this.f7504b.f7505a.a(intent, context);
                return true;
            }
        });
    }

    public static ImmutableList m7803b(ShowNUXStepPreference showNUXStepPreference) {
        if (showNUXStepPreference.f7506b == null) {
            Builder builder = ImmutableList.builder();
            Field[] fields = UserAccountNUXStep.class.getFields();
            String str = new String();
            for (Field field : fields) {
                try {
                    builder.c((String) field.get(str));
                } catch (Exception e) {
                }
            }
            showNUXStepPreference.f7506b = builder.b();
        }
        return showNUXStepPreference.f7506b;
    }
}
