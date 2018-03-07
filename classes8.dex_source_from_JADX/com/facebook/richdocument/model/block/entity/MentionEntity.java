package com.facebook.richdocument.model.block.entity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel;

/* compiled from: picker_creativecam_start_frames_download */
public class MentionEntity extends BaseEntity {
    public MentionEntity(EntityModel entityModel, Context context) {
        super(entityModel, context);
    }

    public void onClick(View view) {
        Uri uri = null;
        switch (this.f5658a.m6418z().g()) {
            case 2479791:
                uri = Uri.parse(StringFormatUtil.a(FBLinks.af, new Object[]{this.f5658a.mo315b()}));
                break;
            case 2645995:
                uri = Uri.parse(StringFormatUtil.a(FBLinks.aX, new Object[]{this.f5658a.mo315b()}));
                break;
        }
        if (uri != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            this.f5659b.a(intent, getContext());
        }
    }
}
