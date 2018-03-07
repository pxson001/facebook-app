package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.adinterfaces.CallToActionWrapper;
import com.facebook.adinterfaces.ui.EditableRadioGroup.OnCheckedChangeRadioGroupListener;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;

/* compiled from: VE */
public class AdInterfacesCallToActionView extends CustomLinearLayout {
    private int f22616a = 0;
    private EditableRadioGroup f22617b;

    public AdInterfacesCallToActionView(Context context) {
        super(context);
        m24542a();
    }

    public AdInterfacesCallToActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24542a();
    }

    protected AdInterfacesCallToActionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24542a();
    }

    private void m24542a() {
        setContentView(2130903109);
        this.f22617b = (EditableRadioGroup) a(2131559268);
    }

    public final void m24543a(GraphQLCallToActionType graphQLCallToActionType) {
        Preconditions.checkState(this.f22616a < 5);
        FbCustomRadioButton fbCustomRadioButton = (FbCustomRadioButton) this.f22617b.getChildAt(this.f22616a);
        fbCustomRadioButton.setVisibility(0);
        fbCustomRadioButton.setTextTextViewStart(CallToActionWrapper.fromGraphQLTypeCallToAction(graphQLCallToActionType).getText(getContext()));
        fbCustomRadioButton.setTag(graphQLCallToActionType);
        this.f22616a++;
    }

    public void setOnCheckedChangeListener(OnCheckedChangeRadioGroupListener onCheckedChangeRadioGroupListener) {
        this.f22617b.f23144d = onCheckedChangeRadioGroupListener;
    }

    public void setCallToActionType(GraphQLCallToActionType graphQLCallToActionType) {
        for (int i = 0; i < this.f22617b.getChildCount(); i++) {
            View childAt = this.f22617b.getChildAt(i);
            if (childAt.getTag() == graphQLCallToActionType) {
                this.f22617b.m25129a(childAt.getId());
                return;
            }
        }
    }
}
