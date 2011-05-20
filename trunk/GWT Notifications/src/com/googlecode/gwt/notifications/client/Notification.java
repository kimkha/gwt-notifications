package com.googlecode.gwt.notifications.client;


public class Notification {
	public static native boolean isDesktopNotificationSupported() /*-{
		return typeof $wnd.webkitNotifications != "undefined";
	}-*/;

	private String contentUrl;
	
	public Notification(String contentUrl) {
		this.contentUrl = contentUrl;
	}
}
