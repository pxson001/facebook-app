package com.facebook.vault.protocol;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.vault.model.FacebookVaultDevice;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

@AutoGenJsonDeserializer
@JsonDeserialize(using = VaultDeviceGetResultDeserializer.class)
/* compiled from: fetchImageAndDecodeFromCache */
public class VaultDeviceGetResult {
    @JsonProperty("data")
    public List<FacebookVaultDevice> data = null;
}
