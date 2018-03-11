package com.dash.a02_butter_knife;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dash on 2018/3/9.
 */
public class MyAdapter extends BaseAdapter {

    private Context context;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {

            view = View.inflate(context,R.layout.fragment_butter_kbife_layout,null);
            //holder
            holder = new ViewHolder(view);


            view.setTag(holder);

        }else {
            holder = (ViewHolder) view.getTag();
        }

        holder.button.setText("---------");


        return view;
    }

    class ViewHolder{

        @BindView(R.id.button_02)
        Button button;

        public ViewHolder(View view) {
            //在viewHolder的绑定butterKnife
            ButterKnife.bind(this,view);
        }
    }
}
