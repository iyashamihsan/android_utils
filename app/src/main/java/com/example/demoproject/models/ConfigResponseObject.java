package com.example.demoproject.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ConfigResponseObject implements Serializable {

    @SerializedName("patch_available")
    @Expose
    private boolean isPatchAvailable;
    @SerializedName("patch_id")
    @Expose
    private String patchId;
    @SerializedName("patch_url")
    @Expose
    private String patchUrl;

    public boolean isPatchAvailable() {
        return isPatchAvailable;
    }

    public void setPatchAvailable(boolean patchAvailable) {
        isPatchAvailable = patchAvailable;
    }

    public String getPatchId() {
        return patchId;
    }

    public void setPatchId(String patchId) {
        this.patchId = patchId;
    }

    public String getPatchUrl() {
        return patchUrl;
    }

    public void setPatchUrl(String patchUrl) {
        this.patchUrl = patchUrl;
    }
}
