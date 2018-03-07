package com.facebook.messaging.xma.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import com.facebook.common.util.StringUtil;
import com.facebook.messaging.graphql.threads.ThreadQueriesInterfaces.XMAAttachmentStoryFields.ActionLinks;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel.ActionLinksModel;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: throwback_units */
public class ActionLinkBar extends CustomLinearLayout {
    public ActionLinkBar(Context context) {
        super(context);
        m1786a();
    }

    public ActionLinkBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m1786a();
    }

    public ActionLinkBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1786a();
    }

    private void m1786a() {
        setOrientation(0);
        setBackgroundDrawable(new ColorDrawable(-1));
        setGravity(5);
    }

    public void setActionLinks(ImmutableList<? extends ActionLinks> immutableList) {
        int i;
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            ActionLinksModel actionLinksModel = (ActionLinksModel) immutableList.get(i);
            if (!(actionLinksModel == null || StringUtil.a(actionLinksModel.b()) || StringUtil.a(actionLinksModel.c()))) {
                builder.c(actionLinksModel);
            }
        }
        ImmutableList b = builder.b();
        if (b.isEmpty()) {
            removeAllViews();
            return;
        }
        while (getChildCount() > b.size()) {
            removeViewAt(0);
        }
        for (i = 0; i < getChildCount(); i++) {
            ((ActionLinkButton) getChildAt(i)).setActionLink((ActionLinksModel) b.get(i));
        }
        while (getChildCount() != b.size()) {
            ActionLinkButton actionLinkButton = new ActionLinkButton(getContext());
            actionLinkButton.setActionLink((ActionLinksModel) b.get(getChildCount()));
            addView(actionLinkButton);
        }
    }
}
