package com.ywq.ssm.utils;

public interface MessageType {
	public static final String TEXT = "text";//文本
	public static final String IMAGE = "image";//图片
	public static final String VOICE = "voice";//音频
	public static final String VIDEO = "video";//视频
	public static final String MUSIC = "music";//音乐
	public static final String NEWS = "news";//图文
	public static final String LINK = "link";//链接
	public static final String LOCATION = "location";//地理位置信息
	
	//事件类型
	public static final String EVENT = "event";
	public static final String SUBSCRIBE = "subscribe";//关注
	public static final String UNSUBSCRIBE = "unsubscribe";//取消关注
	public static final String CLICK = "click";//点击
	public static final String VIEW = "view";//查看
}
