package com.facebook.groups.composer.groupspollcomposer;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
@JsonDeserialize(using = GroupsPollDataModelDeserializer.class)
/* compiled from: view_group_events_tap */
public class GroupsPollDataModel {
    @JsonProperty("can_add_poll_option")
    private boolean canViewerAddPollOption = true;
    @JsonProperty("can_choose_multiple_options")
    private boolean canViewerChooseMultipleOptions = true;
    @JsonProperty("poll_optins")
    private List<String> pollOptions = new ArrayList();

    /* compiled from: view_group_events_tap */
    public enum GroupsPollOptionUpdateAction {
        ADD,
        REMOVE
    }

    public final boolean m462a(String str, GroupsPollOptionUpdateAction groupsPollOptionUpdateAction) {
        if (groupsPollOptionUpdateAction == GroupsPollOptionUpdateAction.ADD) {
            this.pollOptions.add(str);
            return true;
        } else if (groupsPollOptionUpdateAction != GroupsPollOptionUpdateAction.REMOVE || this.pollOptions.isEmpty() || !this.pollOptions.contains(str)) {
            return false;
        } else {
            this.pollOptions.remove(str);
            return true;
        }
    }

    public final int m459a() {
        return this.pollOptions.size();
    }

    public final String m460a(int i) {
        return (String) this.pollOptions.get(i);
    }

    public final ImmutableList<String> m463b() {
        return ImmutableList.copyOf(this.pollOptions);
    }

    public final void m461a(boolean z) {
        this.canViewerAddPollOption = z;
    }

    public final void m464b(boolean z) {
        this.canViewerChooseMultipleOptions = z;
    }

    public final boolean m465c() {
        return this.canViewerAddPollOption;
    }

    public final boolean m466d() {
        return this.canViewerChooseMultipleOptions;
    }
}
