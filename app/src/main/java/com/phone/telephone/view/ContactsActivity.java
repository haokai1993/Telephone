package com.phone.telephone.view;

import android.os.Bundle;
import android.widget.ListView;

import com.phone.telephone.R;
import com.phone.telephone.adapter.ContactsAdapter;
import com.phone.telephone.utils.HelperUtils;

public class ContactsActivity extends BaseActivity {
    private ListView list_constacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        initview();
    }

    private void initview() {
        HelperUtils.getNumber(ContactsActivity.this);
        list_constacts = findViewById(R.id.listview_constacts);
        list_constacts.setAdapter(new ContactsAdapter(this, HelperUtils.lists));
    }
}
