package com.phone.telephone.adapter;

import android.content.Context;

import com.phone.telephone.R;
import com.phone.telephone.bean.PeopleEntity;

import java.util.List;


public class ContactsAdapter extends CommonAdapter<PeopleEntity> {
    private Context context;

    public ContactsAdapter(Context context, List<PeopleEntity> datas) {
        super(context, datas, R.layout.adapter_contacts);
        this.context = context;
    }

    @Override
    public void setValueForView(ViewHolder holder, PeopleEntity peopleEntity) {
        holder.setText(R.id.tv_constact_name, peopleEntity.getName());
    }
}
