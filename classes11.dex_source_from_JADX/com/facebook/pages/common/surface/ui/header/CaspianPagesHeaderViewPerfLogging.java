package com.facebook.pages.common.surface.ui.header;

import android.os.ParcelUuid;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderViewModel.BindModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;

/* compiled from: related_pages_fetch_task */
public interface CaspianPagesHeaderViewPerfLogging {
    BaseControllerListener mo66a();

    void mo67a(ParcelUuid parcelUuid);

    void mo68a(PageHeaderData pageHeaderData, BindModel bindModel);

    void mo69a(boolean z);

    BaseControllerListener mo70b();

    void mo71c();
}
