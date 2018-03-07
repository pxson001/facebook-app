package com.facebook.goodwill.dailydialogue.data;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
/* compiled from: fetch_call_to_action_types */
public class DailyDialogueViewedMutationProtocol$Tracking {
    @JsonProperty("daily_dialogue_lightweight_extra")
    public String extra;
    @JsonProperty("daily_dialogue_lightweight_unit_id")
    public String id;
    @JsonProperty("daily_dialogue_lightweight_unit_type")
    public String type;

    protected DailyDialogueViewedMutationProtocol$Tracking() {
    }
}
