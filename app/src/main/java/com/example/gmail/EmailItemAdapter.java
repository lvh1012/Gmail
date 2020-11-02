package com.example.gmail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class EmailItemAdapter extends BaseAdapter {

    Context context;
    List<EmailItem> items;

    public EmailItemAdapter(Context context, List<EmailItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.email_card, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.mAvatar = view.findViewById(R.id.avatar);
            viewHolder.mSender= view.findViewById(R.id.sender);
            viewHolder.mbrief = view.findViewById(R.id.brief);
            viewHolder.mDate = view.findViewById(R.id.date);
            view.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder)view.getTag();

        EmailItem item = items.get(i);
        viewHolder.mAvatar.setImageResource(item.getAvatar());
        viewHolder.mSender.setText(item.getSender());
        viewHolder.mbrief.setText(item.getBrief());
        viewHolder.mDate.setText(item.getDate().toString());

        return view;
    }

    private class ViewHolder {
        public ImageView mAvatar;
        public TextView mSender;
        public TextView mSubject;
        public TextView mbrief;
        public TextView mDate;
    }
}