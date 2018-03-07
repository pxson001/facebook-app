package com.facebook.groups.protocol;

import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.dracula.runtime.base.DraculaRuntime;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.grouppurposes.protocol.GroupPurposesInformationGraphQLModels.GroupPurposesInformationModel.GroupPurposesModel;
import javax.annotation.Nullable;

/* compiled from: profile_publish_bar_click */
public class GroupInformationInterfaceFactory {

    /* compiled from: profile_publish_bar_click */
    public final class C05411 {
        public final /* synthetic */ FetchGroupInformationModel f5814a;

        C05411(FetchGroupInformationModel fetchGroupInformationModel) {
            this.f5814a = fetchGroupInformationModel;
        }

        @Nullable
        public final String m7212a() {
            return this.f5814a.gW_();
        }

        @Nullable
        public final String m7213b() {
            DraculaReturnValue b = this.f5814a.mo289b();
            MutableFlatBuffer mutableFlatBuffer = b.a;
            int i = b.b;
            int i2 = b.c;
            if (DraculaRuntime.a(mutableFlatBuffer, i, null, 0)) {
                return null;
            }
            DraculaReturnValue b2 = this.f5814a.mo289b();
            MutableFlatBuffer mutableFlatBuffer2 = b2.a;
            int i3 = b2.b;
            int i4 = b2.c;
            return mutableFlatBuffer2.k(i3, 13);
        }

        @Nullable
        public final GroupPurposesModel m7214c() {
            return this.f5814a.m6326t();
        }
    }

    public static C05411 m7215a(FetchGroupInformationModel fetchGroupInformationModel) {
        if (fetchGroupInformationModel == null) {
            return null;
        }
        return new C05411(fetchGroupInformationModel);
    }
}
