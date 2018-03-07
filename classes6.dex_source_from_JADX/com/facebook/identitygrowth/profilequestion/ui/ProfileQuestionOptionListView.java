package com.facebook.identitygrowth.profilequestion.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.identitygrowth.profilequestion.data.ProfileQuestionOptionListData;
import com.facebook.identitygrowth.profilequestion.utils.ProfileQuestionHelper;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.InferenceWithExplanationFragmentModel;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionFragmentModel;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionFragmentModel.InferencesModel.EdgesModel;
import com.facebook.identitygrowth.typeahead.fragment.ProfileInfoTypeaheadActivity;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mIsMessageBlockedByViewer */
public class ProfileQuestionOptionListView extends CustomLinearLayout {
    private final ArrayList<ProfileQuestionOptionItem> f11054a = Lists.a();
    private final ContentView f11055b;
    public final ProfileQuestionTypeaheadItem f11056c;
    private ProfileQuestionFragmentModel f11057d;
    public ProfileQuestionHelper f11058e;
    public ProfileQuestionOptionListData f11059f;
    public OnSelectionChangedListener f11060g;
    private boolean f11061h;
    private boolean f11062i;

    /* compiled from: mIsMessageBlockedByViewer */
    class C06822 implements OnClickListener {
        final /* synthetic */ ProfileQuestionOptionListView f11053a;

        C06822(ProfileQuestionOptionListView profileQuestionOptionListView) {
            this.f11053a = profileQuestionOptionListView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1227800854);
            if (this.f11053a.f11059f.m17780c()) {
                this.f11053a.m17802a();
                ProfileQuestionOptionListView.m17800e(this.f11053a);
                this.f11053a.f11056c;
                Logger.a(2, EntryType.UI_INPUT_END, -426243078, a);
                return;
            }
            ProfileQuestionTypeaheadItem profileQuestionTypeaheadItem = this.f11053a.f11056c;
            profileQuestionTypeaheadItem.f11089i.a(ProfileInfoTypeaheadActivity.m18092a(profileQuestionTypeaheadItem.getContext(), profileQuestionTypeaheadItem.f11090j.m18041k(), profileQuestionTypeaheadItem.f11090j.m18042l(), null, false, "megaphone"), 1956, profileQuestionTypeaheadItem.f11088h);
            LogUtils.a(-1946205711, a);
        }
    }

    /* compiled from: mIsMessageBlockedByViewer */
    public interface OnSelectionChangedListener {
        void m17786a(String str);
    }

    private static <T extends View> void m17791a(Class<T> cls, T t) {
        m17792a((Object) t, t.getContext());
    }

    private static void m17792a(Object obj, Context context) {
        ((ProfileQuestionOptionListView) obj).f11058e = ProfileQuestionHelper.m17839a(FbInjector.get(context));
    }

    public ProfileQuestionOptionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17791a(ProfileQuestionOptionListView.class, (View) this);
        setOrientation(1);
        this.f11056c = new ProfileQuestionTypeaheadItem(context);
        this.f11055b = new ProfileQuestionShowMoreItem(context);
    }

    public final void m17803a(ProfileQuestionFragmentModel profileQuestionFragmentModel, ProfileQuestionOptionListData profileQuestionOptionListData, boolean z, boolean z2) {
        this.f11057d = profileQuestionFragmentModel;
        this.f11059f = profileQuestionOptionListData;
        this.f11061h = z;
        this.f11062i = z2;
        removeAllViews();
        if (this.f11059f.m17777a() || ProfileQuestionHelper.m17841b(this.f11057d)) {
            m17794b();
        } else {
            m17797c();
        }
    }

    @Inject
    private void m17790a(ProfileQuestionHelper profileQuestionHelper) {
        this.f11058e = profileQuestionHelper;
    }

    private void m17787a(@Nonnull final ProfileQuestionOptionItem profileQuestionOptionItem) {
        profileQuestionOptionItem.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProfileQuestionOptionListView f11052b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -66395495);
                if (profileQuestionOptionItem.isChecked()) {
                    this.f11052b.m17802a();
                } else {
                    this.f11052b.m17793a(profileQuestionOptionItem.f11050h, profileQuestionOptionItem.getOptionType(), false);
                }
                ProfileQuestionOptionListView.m17800e(this.f11052b);
                this.f11052b.f11056c;
                LogUtils.a(-1610308528, a);
            }
        });
        addView(profileQuestionOptionItem);
        this.f11054a.add(profileQuestionOptionItem);
    }

    private void m17794b() {
        if (this.f11061h) {
            View textView = new TextView(getContext());
            textView.setText(this.f11057d.dm_().a());
            int dimension = (int) getResources().getDimension(2131429818);
            int dimension2 = (int) getResources().getDimension(2131429819);
            textView.setPadding(dimension, dimension2, dimension, dimension2);
            textView.setTextColor(getResources().getColor(2131361936));
            textView.setTextSize(0, getResources().getDimension(2131427402));
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            addView(textView);
        }
        if (this.f11057d.dn_() != null) {
            this.f11054a.clear();
            ImmutableList a = this.f11057d.dn_().m18005a();
            dimension2 = a.size();
            for (int i = 0; i < dimension2; i++) {
                EdgesModel edgesModel = (EdgesModel) a.get(i);
                ProfileQuestionOptionItem profileQuestionInferenceOptionItem = new ProfileQuestionInferenceOptionItem(getContext());
                profileQuestionInferenceOptionItem.setInferenceData(edgesModel.m18000a());
                profileQuestionInferenceOptionItem.setShowThumbnail(this.f11062i);
                m17787a(profileQuestionInferenceOptionItem);
            }
        }
        this.f11056c.m17837a(this.f11059f, this.f11057d);
        this.f11056c.setOnClickListener(new C06822(this));
        addView(this.f11056c);
        m17800e(this);
    }

    private void m17797c() {
        InferenceWithExplanationFragmentModel a = ((EdgesModel) this.f11057d.dn_().m18005a().get(0)).m18000a();
        ProfileQuestionInferenceOptionItem profileQuestionSingleInferenceOptionItem = new ProfileQuestionSingleInferenceOptionItem(getContext());
        m17793a(a.m17981b().m17970b(), "page", false);
        profileQuestionSingleInferenceOptionItem.setInferenceData(a);
        addView(profileQuestionSingleInferenceOptionItem);
        addView(this.f11055b);
    }

    public void setOnSelectionChangedListener(OnSelectionChangedListener onSelectionChangedListener) {
        this.f11060g = onSelectionChangedListener;
    }

    public void setOnShowMoreClickListener(OnClickListener onClickListener) {
        this.f11055b.setOnClickListener(onClickListener);
    }

    public final void m17802a() {
        m17793a(null, null, false);
    }

    private void m17793a(@Nullable String str, @Nullable String str2, boolean z) {
        this.f11059f.m17775a(str, str2);
        this.f11059f.m17776a(z);
    }

    public static void m17799d(ProfileQuestionOptionListView profileQuestionOptionListView) {
        profileQuestionOptionListView.f11060g.m17786a(profileQuestionOptionListView.f11059f.m17778b());
    }

    public static void m17800e(ProfileQuestionOptionListView profileQuestionOptionListView) {
        int size = profileQuestionOptionListView.f11054a.size();
        for (int i = 0; i < size; i++) {
            ProfileQuestionOptionItem profileQuestionOptionItem = (ProfileQuestionOptionItem) profileQuestionOptionListView.f11054a.get(i);
            boolean z = (profileQuestionOptionListView.f11059f.m17780c() || profileQuestionOptionListView.f11059f.m17778b() == null || !profileQuestionOptionListView.f11059f.m17778b().equals(profileQuestionOptionItem.f11050h)) ? false : true;
            profileQuestionOptionItem.setChecked(z);
        }
        profileQuestionOptionListView.f11056c.setChecked(profileQuestionOptionListView.f11059f.m17780c());
        if (!profileQuestionOptionListView.f11059f.m17780c()) {
            profileQuestionOptionListView.m17801f();
        }
    }

    private void m17801f() {
        this.f11059f.m17774a(null);
        this.f11059f.m17779b(null);
        this.f11056c.m17837a(this.f11059f, this.f11057d);
    }
}
