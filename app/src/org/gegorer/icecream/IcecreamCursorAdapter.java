package org.gegorer.icecream;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class IcecreamCursorAdapter extends CursorAdapter {

    public IcecreamCursorAdapter(Context context, Cursor c, int flags ) {
        super(context, c, flags);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameTv = (TextView) view.findViewById(R.id.name);
        TextView addrTv = (TextView) view.findViewById(R.id.addr);

        if(nameTv != null) {
            nameTv.setText(cursor.getString(ProviderHelper.DISPLAY_NAME_IDX));
        }
        if(addrTv != null) {
            addrTv.setText(cursor.getString(ProviderHelper.ADDRESS_IDX));
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return View.inflate(context, R.layout.list_item, null);
    }
};

