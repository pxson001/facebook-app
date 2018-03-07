package com.facebook.socialgood.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.socialgood.protocol.FundraiserPageModels.FundraiserPageHeaderQueryModel;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: Null story edge in long click */
public class FundraiserPageHeaderView extends ReactionHeaderViewWithTouchDelegate {
    public FundraiserCoverHeaderView f12854b;

    public FundraiserPageHeaderView(Context context) {
        super(context);
        m13519e();
    }

    public FundraiserPageHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m13519e();
    }

    public FundraiserPageHeaderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13519e();
    }

    private void m13519e() {
        setContentView(2130904565);
        this.f12854b = (FundraiserCoverHeaderView) c(2131562467);
    }

    public final void m13520a(FundraiserPageHeaderQueryModel fundraiserPageHeaderQueryModel, String str) {
        String k;
        boolean z;
        Preconditions.checkNotNull(fundraiserPageHeaderQueryModel);
        FundraiserPageActionBar fundraiserPageActionBar = (FundraiserPageActionBar) c(2131562469);
        String r = fundraiserPageHeaderQueryModel.m13414r();
        String d = SocialGoodDataModelHelper.m13525d(fundraiserPageHeaderQueryModel);
        SocialGoodDataModelHelper.m13529n(fundraiserPageHeaderQueryModel);
        if (SocialGoodDataModelHelper.m13523b(fundraiserPageHeaderQueryModel)) {
            Preconditions.checkNotNull(fundraiserPageHeaderQueryModel.m13411o());
            Preconditions.checkArgument(!TextUtils.isEmpty(fundraiserPageHeaderQueryModel.m13411o().m13351k()));
            k = fundraiserPageHeaderQueryModel.m13411o().m13351k();
        } else if (SocialGoodDataModelHelper.m13524c(fundraiserPageHeaderQueryModel)) {
            k = fundraiserPageHeaderQueryModel.m13414r();
        } else {
            k = null;
        }
        String str2 = k;
        boolean l = fundraiserPageHeaderQueryModel.m13408l();
        String k2 = fundraiserPageHeaderQueryModel.m13407k();
        SocialGoodDataModelHelper.m13529n(fundraiserPageHeaderQueryModel);
        if (SocialGoodDataModelHelper.m13523b(fundraiserPageHeaderQueryModel)) {
            Preconditions.checkNotNull(fundraiserPageHeaderQueryModel.m13411o());
            k = fundraiserPageHeaderQueryModel.m13411o().m13352l();
        } else if (SocialGoodDataModelHelper.m13524c(fundraiserPageHeaderQueryModel)) {
            k = fundraiserPageHeaderQueryModel.m13418v();
        } else {
            k = null;
        }
        String str3 = k;
        int a = SocialGoodDataModelHelper.m13522a(fundraiserPageHeaderQueryModel);
        boolean isEmpty = TextUtils.isEmpty(fundraiserPageHeaderQueryModel.m13416t());
        SocialGoodDataModelHelper.m13529n(fundraiserPageHeaderQueryModel);
        if (SocialGoodDataModelHelper.m13524c(fundraiserPageHeaderQueryModel) && fundraiserPageHeaderQueryModel.m13409m()) {
            z = true;
        } else {
            z = false;
        }
        fundraiserPageActionBar.m13497a(r, d, str2, l, str, k2, str3, a, isEmpty, z);
        this.f12854b.m13464a(fundraiserPageHeaderQueryModel);
    }

    public View getDonateCallToActionButton() {
        return c(2131562468);
    }

    public final void m13521b() {
        View c = c(2131562466);
        c.setBackgroundResource(17170445);
        LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = -1;
        c.setLayoutParams(layoutParams);
        c(2131562469).setVisibility(8);
        this.f12854b.setVisibility(8);
        c(2131562468).setVisibility(8);
        c(2131562470).setVisibility(0);
    }

    public FundraiserCoverHeaderView getCoverHeaderView() {
        return this.f12854b;
    }
}
