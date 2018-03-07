package com.facebook.events.create.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.CollectionUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tagging.conversion.FriendSuggestionsAndSelectorActivity;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: connState */
public class CohostsSelector extends CustomFrameLayout implements OnClickListener {
    private EventCohostsModel f16283a;
    private FbTextView f16284b;
    private boolean f16285c;
    private SecureContextHelper f16286d;
    private Activity f16287e;
    private int f16288f;
    private boolean f16289g;

    private static <T extends View> void m16763a(Class<T> cls, T t) {
        m16764a((Object) t, t.getContext());
    }

    private static void m16764a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CohostsSelector) obj).m16762a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), ActivityMethodAutoProvider.b(fbInjector));
    }

    public CohostsSelector(Context context) {
        this(context, null);
    }

    public CohostsSelector(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CohostsSelector(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16765b();
    }

    @Inject
    private void m16762a(SecureContextHelper secureContextHelper, Activity activity) {
        this.f16286d = secureContextHelper;
        this.f16287e = activity;
    }

    private void m16765b() {
        m16763a(CohostsSelector.class, (View) this);
        setContentView(2130904116);
        setFocusable(false);
        this.f16284b = (FbTextView) c(2131561490);
        setOnClickListener(this);
    }

    public final void m16769a(EventCohostsModel eventCohostsModel, int i, boolean z, boolean z2) {
        this.f16283a = eventCohostsModel;
        this.f16288f = i;
        this.f16285c = z2;
        m16767f();
        if (z) {
            setVisibility(0);
        }
    }

    public final void m16768a(Intent intent) {
        EventCohostsModel eventCohostsModel = this.f16283a;
        if (intent.hasExtra("profiles")) {
            eventCohostsModel.f16324a = RegularImmutableList.a;
            eventCohostsModel.f16325b = null;
            eventCohostsModel.f16326c = 0;
            long[] longArrayExtra = intent.getLongArrayExtra("profiles");
            if (longArrayExtra != null) {
                Builder builder = new Builder();
                for (long l : longArrayExtra) {
                    builder.c(Long.toString(l));
                }
                eventCohostsModel.f16324a = builder.b();
            }
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("full_profiles");
            if (CollectionUtil.b(parcelableArrayListExtra)) {
                eventCohostsModel.f16325b = ((FacebookProfile) parcelableArrayListExtra.get(0)).mDisplayName;
                eventCohostsModel.f16326c = parcelableArrayListExtra.size();
            }
        }
        m16767f();
    }

    private void m16766e() {
        List list = this.f16283a.f16324a;
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            jArr[i] = Long.parseLong((String) list.get(i));
        }
        Intent a = FriendSuggestionsAndSelectorActivity.a(this.f16287e, jArr);
        a.putExtra("custom_title_res_id", 2131236910);
        if (this.f16285c) {
            a.putExtra("extra_include_viewer", true);
        }
        this.f16286d.a(a, this.f16288f, this.f16287e);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Parcelable bundle = new Bundle();
        bundle.putParcelable("cohostsSlectorSuperState", onSaveInstanceState);
        bundle.putBoolean("hasClickedOnCohostSelector", this.f16289g);
        bundle.putBoolean("includeViewerAsCohostChoice", this.f16285c);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("cohostsSlectorSuperState"));
        this.f16289g = bundle.getBoolean("hasClickedOnCohostSelector");
        this.f16285c = bundle.getBoolean("includeViewerAsCohostChoice");
        m16767f();
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 250434141);
        this.f16289g = true;
        m16766e();
        Logger.a(2, EntryType.UI_INPUT_END, 452270003, a);
    }

    public final boolean m16770a() {
        return this.f16289g;
    }

    private void m16767f() {
        int i = this.f16283a.f16326c;
        String str = this.f16283a.f16325b;
        if (i <= 0 || Strings.isNullOrEmpty(str)) {
            this.f16284b.setText("");
            return;
        }
        if (i > 1) {
            i--;
            str = getResources().getQuantityString(2131689659, i, new Object[]{str, Integer.valueOf(i)});
        }
        String string = getResources().getString(2131236909);
        this.f16284b.setText(StringFormatUtil.a(string, new Object[]{str}));
    }
}
