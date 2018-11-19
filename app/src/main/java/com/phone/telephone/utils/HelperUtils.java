package com.phone.telephone.utils;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.blankj.utilcode.util.LogUtils;
import com.phone.telephone.bean.PeopleEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 联系人的增删改查
 */
public class HelperUtils {
    public static List<PeopleEntity> lists = new ArrayList<PeopleEntity>();

    public static String getNumber(Context context) {
        Cursor cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null);
        String phoneNumber;
        String phoneName;
        while (cursor.moveToNext()) {
            phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));//电话号码
            phoneName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));//姓名
            PeopleEntity peopleEntity = new PeopleEntity();
            peopleEntity.setName(phoneName);
            peopleEntity.setPhone(phoneNumber);
            lists.add(peopleEntity);
            LogUtils.iTag("good", phoneName + phoneNumber);
        }
        return null;
    }
}
