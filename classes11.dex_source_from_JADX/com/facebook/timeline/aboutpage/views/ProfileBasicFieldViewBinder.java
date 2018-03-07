package com.facebook.timeline.aboutpage.views;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView.BufferType;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.aboutpage.events.CollectionsClickEvents.RedirectToUriEvent;
import com.facebook.timeline.aboutpage.events.CollectionsEventBus;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldInfoModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldInfoModel.AssociatedPagesModel;
import com.facebook.timeline.aboutpage.util.ItemLinkMovementMethod;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: Ljava/lang/Void; */
public class ProfileBasicFieldViewBinder {
    public CollectionsEventBus f13896a;
    private final LinkifyUtil f13897b;
    private final ItemLinkMovementMethod f13898c;
    private final I18nJoiner f13899d;

    public static ProfileBasicFieldViewBinder m15030b(InjectorLike injectorLike) {
        return new ProfileBasicFieldViewBinder(CollectionsEventBus.m13930a(injectorLike), LinkifyUtil.a(injectorLike), ItemLinkMovementMethod.m14862a(injectorLike), I18nJoiner.b(injectorLike));
    }

    @Inject
    public ProfileBasicFieldViewBinder(CollectionsEventBus collectionsEventBus, LinkifyUtil linkifyUtil, ItemLinkMovementMethod itemLinkMovementMethod, I18nJoiner i18nJoiner) {
        this.f13896a = collectionsEventBus;
        this.f13897b = linkifyUtil;
        this.f13898c = itemLinkMovementMethod;
        this.f13899d = i18nJoiner;
    }

    public final void m15031a(FbTextView fbTextView, View view, ProfileFieldInfoModel profileFieldInfoModel) {
        if (profileFieldInfoModel.m14047m() && profileFieldInfoModel.m14056v() != null && !StringUtil.a(profileFieldInfoModel.m14056v().m14026a())) {
            fbTextView.setVisibility(0);
            fbTextView.setText(profileFieldInfoModel.m14056v().m14026a());
            fbTextView.setTextSize((float) SizeUtil.c(fbTextView.getResources(), 2131427402));
            fbTextView.setTextColor(fbTextView.getResources().getColor(2131361932));
            fbTextView.setTypeface(Typeface.DEFAULT);
            fbTextView.setOnClickListener(null);
            view.setOnClickListener(null);
            m15029a(fbTextView, 8388611);
        } else if (profileFieldInfoModel.m14039a() == null || profileFieldInfoModel.m14059y() == null) {
            fbTextView.setText("");
            fbTextView.setOnClickListener(null);
            view.setOnClickListener(null);
        } else {
            m15033b(fbTextView, view, profileFieldInfoModel);
        }
    }

    public final void m15033b(FbTextView fbTextView, View view, final ProfileFieldInfoModel profileFieldInfoModel) {
        if (profileFieldInfoModel.m14059y() == null) {
            fbTextView.setVisibility(8);
            return;
        }
        fbTextView.setVisibility(0);
        fbTextView.setTypeface(Typeface.DEFAULT);
        fbTextView.setText(profileFieldInfoModel.m14059y().m14036a().toUpperCase(Locale.getDefault()));
        fbTextView.setTextSize((float) SizeUtil.c(fbTextView.getResources(), 2131427398));
        fbTextView.setTextColor(fbTextView.getResources().getColor(2131361917));
        OnClickListener c16171 = new OnClickListener(this) {
            final /* synthetic */ ProfileBasicFieldViewBinder f13895b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1403939170);
                this.f13895b.f13896a.a(new RedirectToUriEvent(profileFieldInfoModel.m14039a()));
                Logger.a(2, EntryType.UI_INPUT_END, -1213309785, a);
            }
        };
        fbTextView.setOnClickListener(c16171);
        view.setOnClickListener(c16171);
        m15029a(fbTextView, 17);
    }

    public final void m15032a(FbTextView fbTextView, ImmutableList<AssociatedPagesModel> immutableList) {
        fbTextView.setText(m15028a(immutableList), BufferType.SPANNABLE);
        fbTextView.setTextSize((float) SizeUtil.c(fbTextView.getResources(), 2131427402));
        fbTextView.setMovementMethod(this.f13898c);
        m15029a(fbTextView, 8388611);
    }

    private Spannable m15028a(ImmutableList<AssociatedPagesModel> immutableList) {
        List arrayList = new ArrayList();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((AssociatedPagesModel) immutableList.get(i)).C_());
        }
        Spannable valueOf = SpannableString.valueOf(this.f13899d.a(arrayList));
        int size2 = immutableList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size2; i3++) {
            AssociatedPagesModel associatedPagesModel = (AssociatedPagesModel) immutableList.get(i3);
            Object D_ = associatedPagesModel.D_();
            Object C_ = associatedPagesModel.C_();
            if (!(StringUtil.a(D_) || StringUtil.a(C_))) {
                int length = C_.length();
                this.f13897b.a(D_, i2, i2 + length, valueOf, false, 2131363996, true, null, associatedPagesModel);
                i2 += this.f13899d.b().length() + length;
            }
        }
        return valueOf;
    }

    private static void m15029a(FbTextView fbTextView, int i) {
        LayoutParams layoutParams = fbTextView.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof FrameLayout.LayoutParams)) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
        }
        fbTextView.setLayoutParams(layoutParams);
    }
}
