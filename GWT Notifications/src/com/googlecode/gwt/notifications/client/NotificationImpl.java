package com.googlecode.gwt.notifications.client;

public class NotificationImpl {
	public static final int PERMISSION_ALLOWED = 0;
	public static final int PERMISSION_NOT_ALLOWED = 1;
	public static final int PERMISSION_DENIED = 2;

	protected NotificationImpl() {
		
	}
	
	public native int checkPermission() /*-{
		return $wnd.webkitNotifications.checkPermission();
	}-*/;
	
	public native void requestPermission() /*-{
		$wnd.webkitNotifications.requestPermission();
	}-*/;
}
