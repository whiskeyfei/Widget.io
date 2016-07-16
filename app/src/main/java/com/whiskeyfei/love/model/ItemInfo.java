package com.whiskeyfei.love.model;

public class ItemInfo {
	public String name;
	public int icon;
	public int type;
	public int icons[];
	
	public ItemInfo(String name,int icon,int type) {
		this.name = name;
		this.icon = icon;
		this.type = type;
	}

	public ItemInfo(String name,int icons[],int type) {
		this.name = name;
		this.icons = icons;
		this.type = type;
	}

	public static class Type{
		public static final int TYPE_CHATS = 0;
		public static final int TYPE_CONTACTS = 1;
		public static final int TYPE_DISCOVER = 2;
		public static final int TYPE_ME = 3;
	}
	
}
