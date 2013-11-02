package org.gegorer.icecream;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class IcecreamListFragment extends Fragment implements AdapterView.OnItemClickListener {

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ListView view = (ListView)inflater.inflate(R.layout.listview, container);

        Cursor c = getActivity().getContentResolver().query(ProviderHelper.FAMI_URI, null, null, null, null);

        if(c != null)
        {
            view.setAdapter(new IcecreamCursorAdapter(getActivity(), c, 0));
            view.setOnItemClickListener(this);
        }

        return view;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv = (TextView) view.findViewById(R.id.addr);
        goToAddress(tv.getText());
    }

    void goToAddress(CharSequence address) {
        String mapLink = "https://maps.google.com.tw/maps?q=" + address;

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapLink));

        getActivity().startActivity(intent);
    }
};
