package com.example.demoproject.eventsmodel;

public class MessageEvent {

    private boolean isPatchInstalled = false;
    private boolean isNetworkAvailable = false;



    public boolean isNetworkAvailable() {
        return isNetworkAvailable;
    }

    public void setNetworkAvailable(boolean networkAvailable) {
        isNetworkAvailable = networkAvailable;
    }

    public MessageEvent(boolean isNetworkAvailable) {
        this.isNetworkAvailable = isNetworkAvailable;
    }

    public boolean isPatchInstalled() {
        return isPatchInstalled;
    }

    public void setPatchInstalled(boolean patchInstalled) {
        isPatchInstalled = patchInstalled;
    }

}