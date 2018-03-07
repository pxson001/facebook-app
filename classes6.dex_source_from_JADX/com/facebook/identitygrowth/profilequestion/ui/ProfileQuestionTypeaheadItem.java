package com.facebook.identitygrowth.profilequestion.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.identitygrowth.profilequestion.data.ProfileQuestionOptionListData;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionFragmentModel;
import com.facebook.inject.FbInjector;

/* compiled from: mHugePictureUrl */
public class ProfileQuestionTypeaheadItem extends CheckedContentView {
    public Activity f11088h;
    public SecureContextHelper f11089i;
    public ProfileQuestionFragmentModel f11090j;

    public static void m17836a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ProfileQuestionTypeaheadItem profileQuestionTypeaheadItem = (ProfileQuestionTypeaheadItem) obj;
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        Activity b = ActivityMethodAutoProvider.b(fbInjector);
        profileQuestionTypeaheadItem.f11089i = secureContextHelper;
        profileQuestionTypeaheadItem.f11088h = b;
    }

    public ProfileQuestionTypeaheadItem(Context context) {
        this(context, null);
    }

    private ProfileQuestionTypeaheadItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772583);
    }

    private ProfileQuestionTypeaheadItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = ProfileQuestionTypeaheadItem.class;
        m17836a((Object) this, getContext());
        setShowThumbnail(false);
    }

    public final void m17837a(ProfileQuestionOptionListData profileQuestionOptionListData, ProfileQuestionFragmentModel profileQuestionFragmentModel) {
        this.f11090j = profileQuestionFragmentModel;
        CharSequence e = profileQuestionOptionListData.m17782e();
        if (profileQuestionOptionListData.m17781d() == null || e == null) {
            setTitleText(profileQuestionFragmentModel.m18041k());
            setTitleTextAppearance(2131624228);
            return;
        }
        setTitleText(e);
        setTitleTextAppearance(2131624227);
    }
}
