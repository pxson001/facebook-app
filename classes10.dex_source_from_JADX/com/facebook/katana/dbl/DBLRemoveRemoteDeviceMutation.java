package com.facebook.katana.dbl;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.katana.dbl.DBLRemoveRemoteDeviceMutationModels.DeviceBasedLoginRemoveRemoteDeviceMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: uploadPhoto */
public final class DBLRemoveRemoteDeviceMutation {

    /* compiled from: uploadPhoto */
    public class DeviceBasedLoginRemoveRemoteDeviceMutationString extends TypedGraphQLMutationString<DeviceBasedLoginRemoveRemoteDeviceMutationModel> {
        public DeviceBasedLoginRemoveRemoteDeviceMutationString() {
            super(DeviceBasedLoginRemoveRemoteDeviceMutationModel.class, false, "DeviceBasedLoginRemoveRemoteDeviceMutation", "d4171b7342b4e1605c3ac7175a32c3dc", "device_based_login_remove_remote_device", "0", "10154542966906729", RegularImmutableSet.a);
        }

        public final String m910a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
