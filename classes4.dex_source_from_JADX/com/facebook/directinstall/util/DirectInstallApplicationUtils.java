package com.facebook.directinstall.util;

import android.os.Bundle;
import com.facebook.common.uri.NativeAppDetails;
import com.facebook.common.uri.NativeAppDetails.Screenshot;
import com.facebook.common.util.StringUtil;
import com.facebook.directinstall.intent.DirectInstallAppData;
import com.facebook.directinstall.intent.DirectInstallAppData.DownloadConnectivityPolicy;
import com.facebook.directinstall.intent.DirectInstallAppDescriptor;
import com.facebook.directinstall.intent.DirectInstallAppDetails;
import com.facebook.directinstall.intent.DirectInstallAppDetails.TextWithEntities;
import com.facebook.directinstall.intent.DirectInstallAppDetails.TextWithEntities.Entity;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLInterfaces.GetNativeAppDetailsActorGraphQL;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLInterfaces.GetNativeAppDetailsFromActorGraphQL;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLInterfaces.GetNativeAppDetailsImageGraphQL;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels.GetNativeAppDetailsAppStoreApplicationGraphQLModel;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels.GetNativeAppDetailsAppStoreApplicationGraphQLModel.DescriptionModel;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels.GetNativeAppDetailsAppStoreApplicationGraphQLModel.PlatformApplicationModel;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels.GetNativeAppDetailsTextWithEntitiesGraphQLModel;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels.GetNativeAppDetailsTextWithEntitiesGraphQLModel.RangesModel;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels.GetNativeAppDetailsTextWithEntitiesGraphQLModel.RangesModel.EntityModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAppStoreApplicationInstallState;
import com.facebook.graphql.enums.GraphQLAppStoreDownloadConnectivityPolicy;
import com.facebook.graphql.enums.GraphQLDigitalGoodStoreType;
import com.facebook.graphql.model.GraphQLAppStoreApplication;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryActorHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.nio.ByteBuffer;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: desc */
public class DirectInstallApplicationUtils {
    @Nullable
    public static NativeAppDetails m14763a(@Nullable GetNativeAppDetailsFromActorGraphQL getNativeAppDetailsFromActorGraphQL, String str, String str2) {
        if (getNativeAppDetailsFromActorGraphQL == null) {
            return null;
        }
        return m14762a(getNativeAppDetailsFromActorGraphQL, getNativeAppDetailsFromActorGraphQL.m(), str, str2);
    }

    @Nullable
    public static NativeAppDetails m14764a(@Nullable GraphQLStoryAttachment graphQLStoryAttachment, @Nullable GraphQLStory graphQLStory, String str) {
        if (graphQLStoryAttachment == null || graphQLStory == null) {
            return null;
        }
        C0652x31e4f7ab a = DirectInstallConverter.m14772a(StoryActorHelper.b(graphQLStory));
        GraphQLAppStoreApplication k = graphQLStoryAttachment.k();
        ByteBuffer byteBuffer = null;
        if (k != null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a2 = DirectInstallConverter.m14768a(flatBufferBuilder, k);
            if (a2 != 0) {
                flatBufferBuilder.d(a2);
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                byteBuffer = new GetNativeAppDetailsAppStoreApplicationGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }
        return m14762a(a, byteBuffer, graphQLStory.g(), str);
    }

    private static NativeAppDetails m14762a(GetNativeAppDetailsActorGraphQL getNativeAppDetailsActorGraphQL, GetNativeAppDetailsAppStoreApplicationGraphQLModel getNativeAppDetailsAppStoreApplicationGraphQLModel, String str, String str2) {
        if (getNativeAppDetailsActorGraphQL == null || getNativeAppDetailsAppStoreApplicationGraphQLModel == null) {
            return null;
        }
        PlatformApplicationModel l = getNativeAppDetailsAppStoreApplicationGraphQLModel.l();
        if (l == null) {
            return null;
        }
        String str3;
        String a;
        String str4;
        DescriptionModel d = getNativeAppDetailsAppStoreApplicationGraphQLModel.d();
        if (StringUtil.a(new CharSequence[]{getNativeAppDetailsActorGraphQL.C_()})) {
            str3 = "";
        } else {
            str3 = getNativeAppDetailsActorGraphQL.C_();
        }
        if (d != null) {
            a = d.a();
        } else {
            a = null;
        }
        String g = getNativeAppDetailsAppStoreApplicationGraphQLModel.g();
        ImmutableList j = getNativeAppDetailsAppStoreApplicationGraphQLModel.j();
        ImmutableList n = getNativeAppDetailsAppStoreApplicationGraphQLModel.n();
        String a2 = getNativeAppDetailsAppStoreApplicationGraphQLModel.a();
        String m = getNativeAppDetailsAppStoreApplicationGraphQLModel.m();
        if (getNativeAppDetailsActorGraphQL.l() == null || getNativeAppDetailsActorGraphQL.l().b() == null) {
            str4 = "";
        } else {
            str4 = getNativeAppDetailsActorGraphQL.l().b();
        }
        NativeAppDetails nativeAppDetails = new NativeAppDetails(str3, a, g, j, n, a2, m, str4, str, getNativeAppDetailsAppStoreApplicationGraphQLModel.q(), getNativeAppDetailsAppStoreApplicationGraphQLModel.p(), l.b(), getNativeAppDetailsAppStoreApplicationGraphQLModel.b(), getNativeAppDetailsAppStoreApplicationGraphQLModel.cr_(), l.c(), l.d(), str2, getNativeAppDetailsAppStoreApplicationGraphQLModel.cq_());
        nativeAppDetails.w = m14765a(getNativeAppDetailsAppStoreApplicationGraphQLModel.o());
        nativeAppDetails.x = m14765a(getNativeAppDetailsAppStoreApplicationGraphQLModel.cs_());
        nativeAppDetails.u = m14767a(getNativeAppDetailsAppStoreApplicationGraphQLModel.c());
        nativeAppDetails.v = m14767a(getNativeAppDetailsAppStoreApplicationGraphQLModel.k());
        return nativeAppDetails;
    }

    @Nullable
    private static TextWithEntities m14765a(@Nullable GetNativeAppDetailsTextWithEntitiesGraphQLModel getNativeAppDetailsTextWithEntitiesGraphQLModel) {
        if (getNativeAppDetailsTextWithEntitiesGraphQLModel == null) {
            return null;
        }
        TextWithEntities textWithEntities = new TextWithEntities(getNativeAppDetailsTextWithEntitiesGraphQLModel.b());
        ImmutableList a = getNativeAppDetailsTextWithEntitiesGraphQLModel.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            RangesModel rangesModel = (RangesModel) a.get(i);
            if (!(rangesModel.a() == null || rangesModel.a().c() == null)) {
                String a2;
                EntityModel a3 = rangesModel.a();
                String b = a3.b();
                if (a3.c() != null) {
                    a2 = a3.c().a();
                } else {
                    a2 = null;
                }
                textWithEntities.b.add(new Entity(b, a2));
            }
        }
        return textWithEntities;
    }

    private static ImmutableList<Screenshot> m14767a(@Nullable ImmutableList<? extends GetNativeAppDetailsImageGraphQL> immutableList) {
        if (immutableList == null) {
            return null;
        }
        return ImmutableList.copyOf(Lists.a(immutableList, new 1()));
    }

    @Nullable
    public static NativeAppDetails m14761a(DirectInstallAppData directInstallAppData, Map<String, Object> map) {
        if (directInstallAppData == null) {
            return null;
        }
        DirectInstallAppDescriptor e = directInstallAppData.e();
        DirectInstallAppDetails d = directInstallAppData.d();
        String c = directInstallAppData.c();
        String a = directInstallAppData.a();
        Bundle b = directInstallAppData.b();
        DownloadConnectivityPolicy downloadConnectivityPolicy = directInstallAppData.a;
        if (e == null || d == null || c == null || a == null || downloadConnectivityPolicy == null) {
            return null;
        }
        NativeAppDetails nativeAppDetails = new NativeAppDetails(d.a(), d.b(), e.c(), e.d(), ImmutableList.of(GraphQLDigitalGoodStoreType.FB_ANDROID_STORE), e.a(), d.c(), d.d(), c, d.g(), e.b(), e.e(), d.h(), GraphQLAppStoreApplicationInstallState.NOT_INSTALLED, d.i(), d.j(), a, m14766a(downloadConnectivityPolicy));
        nativeAppDetails.r = b;
        nativeAppDetails.s = map;
        return nativeAppDetails;
    }

    private static GraphQLAppStoreDownloadConnectivityPolicy m14766a(DownloadConnectivityPolicy downloadConnectivityPolicy) {
        switch (2.a[downloadConnectivityPolicy.ordinal()]) {
            case 1:
                return GraphQLAppStoreDownloadConnectivityPolicy.WIFI_FORCE;
            case 2:
                return GraphQLAppStoreDownloadConnectivityPolicy.WIFI_ONLY;
            default:
                return GraphQLAppStoreDownloadConnectivityPolicy.ANY;
        }
    }
}
