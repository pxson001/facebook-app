package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionGroupMembersFields;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.CollectionGroupMembersFieldsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLInterfaces.TimelineMutualFriendFields;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.TimelineMutualFriendFieldsModel;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Preconditions;
import java.util.List;

/* compiled from: Ljava/util/Date; */
public class IconFacepileView extends CustomRelativeLayout {
    private static final CallerContext f13835a = CallerContext.a(IconFacepileView.class, "collections_collection");

    public IconFacepileView(Context context) {
        this(context, null);
    }

    public IconFacepileView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconFacepileView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m14990a(List<? extends TimelineMutualFriendFields> list) {
        int i = 0;
        while (i < 4) {
            Uri uri;
            int i2;
            if (list == null || i >= list.size()) {
                uri = null;
            } else {
                Uri parse;
                TimelineMutualFriendFieldsModel timelineMutualFriendFieldsModel = (TimelineMutualFriendFieldsModel) list.get(i);
                if (timelineMutualFriendFieldsModel.m14628a() != null) {
                    parse = Uri.parse(timelineMutualFriendFieldsModel.m14628a().b());
                } else {
                    parse = null;
                }
                uri = parse;
            }
            FbDraweeView fbDraweeView = (FbDraweeView) Preconditions.checkNotNull((FbDraweeView) getChildAt(i));
            fbDraweeView.a(uri, f13835a);
            if (uri != null) {
                i2 = 0;
            } else {
                i2 = 4;
            }
            fbDraweeView.setVisibility(i2);
            i++;
        }
    }

    public final void m14991b(List<CollectionGroupMembersFields> list) {
        int i = 0;
        while (i < 4) {
            Uri uri;
            int i2;
            if (list == null || i >= list.size()) {
                uri = null;
            } else {
                Uri parse;
                CollectionGroupMembersFieldsModel collectionGroupMembersFieldsModel = (CollectionGroupMembersFieldsModel) list.get(i);
                if (collectionGroupMembersFieldsModel.m14335a() != null) {
                    parse = Uri.parse(collectionGroupMembersFieldsModel.m14335a().b());
                } else {
                    parse = null;
                }
                uri = parse;
            }
            FbDraweeView fbDraweeView = (FbDraweeView) Preconditions.checkNotNull((FbDraweeView) getChildAt(i));
            fbDraweeView.a(uri, f13835a);
            if (uri != null) {
                i2 = 0;
            } else {
                i2 = 4;
            }
            fbDraweeView.setVisibility(i2);
            i++;
        }
    }
}
