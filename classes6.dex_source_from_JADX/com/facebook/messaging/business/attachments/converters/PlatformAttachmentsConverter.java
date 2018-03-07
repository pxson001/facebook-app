package com.facebook.messaging.business.attachments.converters;

import android.net.Uri;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItemBuilder;
import com.facebook.messaging.business.common.calltoaction.converters.CallToActionModelConverter;
import com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsModels.PlatformCallToActionModel;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.CommerceRetailItem;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: viewing_session_id */
public class PlatformAttachmentsConverter {
    @Nullable
    public static PlatformGenericAttachmentItem m388a(@Nullable CommerceRetailItem commerceRetailItem) {
        if (commerceRetailItem == null) {
            return null;
        }
        List arrayList = new ArrayList();
        ImmutableList aB_ = commerceRetailItem.aB_();
        if (aB_ != null) {
            int size = aB_.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(CallToActionModelConverter.m714a((PlatformCallToActionModel) aB_.get(i)));
            }
        }
        PlatformGenericAttachmentItemBuilder platformGenericAttachmentItemBuilder = new PlatformGenericAttachmentItemBuilder();
        platformGenericAttachmentItemBuilder.f460a = commerceRetailItem.mo96c();
        platformGenericAttachmentItemBuilder = platformGenericAttachmentItemBuilder;
        platformGenericAttachmentItemBuilder.f466g = commerceRetailItem.mo97d();
        platformGenericAttachmentItemBuilder = platformGenericAttachmentItemBuilder;
        platformGenericAttachmentItemBuilder.f467h = commerceRetailItem.az_();
        platformGenericAttachmentItemBuilder = platformGenericAttachmentItemBuilder;
        platformGenericAttachmentItemBuilder.f468i = commerceRetailItem.aG_();
        platformGenericAttachmentItemBuilder = platformGenericAttachmentItemBuilder;
        platformGenericAttachmentItemBuilder.f469j = commerceRetailItem.mo99j();
        platformGenericAttachmentItemBuilder = platformGenericAttachmentItemBuilder.m391d(commerceRetailItem.ax_());
        platformGenericAttachmentItemBuilder.f461b = commerceRetailItem.mo98g();
        platformGenericAttachmentItemBuilder = platformGenericAttachmentItemBuilder;
        platformGenericAttachmentItemBuilder.f470k = arrayList;
        platformGenericAttachmentItemBuilder = platformGenericAttachmentItemBuilder.m392j(commerceRetailItem.aF_());
        String ay_ = commerceRetailItem.ay_();
        platformGenericAttachmentItemBuilder.f472m = !Strings.isNullOrEmpty(ay_) ? Uri.parse(ay_) : null;
        return platformGenericAttachmentItemBuilder.m393n();
    }
}
