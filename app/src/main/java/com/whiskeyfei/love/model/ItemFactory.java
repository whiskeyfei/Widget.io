package com.whiskeyfei.love.model;

import com.whiskeyfei.love.R;

import java.util.ArrayList;
import java.util.List;


public class ItemFactory {

    private static int mTabIconRes[][] = {
            {R.drawable.icon_chats_normal, R.drawable.icon_chats_selected},
            {R.drawable.icon_contacts_normal, R.drawable.icon_contacts_selected},
            {R.drawable.icon_discover_normal, R.drawable.icon_discover_selected},
            {R.drawable.icon_me_normal, R.drawable.icon_me_selected}
    };

    private static String mTabNames[] = {"Chats", "Contacts", "Discover", "Me"};
    private static int mTabType[] = {ItemInfo.Type.TYPE_CHATS, ItemInfo.Type.TYPE_CONTACTS, ItemInfo.Type.TYPE_DISCOVER, ItemInfo.Type.TYPE_ME};

    public static List<ItemInfo> getData() {
        List<ItemInfo> list = new ArrayList<>();
        for (int i = 0; i < mTabNames.length; i++) {
            list.add(new ItemInfo(mTabNames[i], mTabIconRes[i], mTabType[i]));
        }
        return list;
    }
}
