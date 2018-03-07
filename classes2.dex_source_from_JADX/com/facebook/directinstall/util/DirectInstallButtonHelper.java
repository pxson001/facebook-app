package com.facebook.directinstall.util;

import android.content.Context;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLAppStoreApplication;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fetch_disk_and_network_in_parallel */
public class DirectInstallButtonHelper {
    Context f24127a;

    public static DirectInstallButtonHelper m32495b(InjectorLike injectorLike) {
        return new DirectInstallButtonHelper((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public DirectInstallButtonHelper(Context context) {
        this.f24127a = context;
    }

    public final String m32497a(@Nullable GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null) {
            return null;
        }
        GraphQLStoryActionLink a = ActionLinkHelper.m22936a(graphQLStoryAttachment, -508788748);
        GraphQLAppStoreApplication k = graphQLStoryAttachment.m23972k();
        if (a == null || k == null) {
            return null;
        }
        String aB = a.aB();
        switch (1.a[k.m23954q().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return m32494a(2131235971);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return m32494a(2131235972);
            case 3:
                return m32494a(2131235973);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return m32494a(2131235976);
            default:
                return aB;
        }
    }

    public static boolean m32496b(@Nullable GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null) {
            return false;
        }
        GraphQLAppStoreApplication k = graphQLStoryAttachment.m23972k();
        if (k == null) {
            return false;
        }
        switch (1.a[k.m23954q().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                return true;
            default:
                return false;
        }
    }

    private String m32494a(int i) {
        return this.f24127a.getResources().getText(i).toString();
    }
}
