/*package com.example.aiproject;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<FriendlyMessage> listItem;
    private Context context;

    private static final int VIEW_HOLDER_ME = 0;
    private static final int VIEW_HOLDER_YOU = 1;

    private String mfromUserId;

    public CustomAdapter(ArrayList<FriendlyMessage> list, String fromUserId)
    {
        this.listItem = list;
        this.mfromUserId = fromUserId;
    }

    @Override
    public int getItemViewType(int position)
    {
        if(listItem.get(position).getFromUserId().equalsIgnoreCase(mfromUserId))
        {
            return VIEW_HOLDER_ME;

        } else {
            return VIEW_HOLDER_YOU;
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType){
            case VIEW_HOLDER_ME:
               // return new ViewHolderMe(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_message,parent));
            case VIEW_HOLDER_YOU:
               // return new ViewHolderYou(LayoutInflater.from(parent.getContext()).inflate(R.layout.their_message,parent));
            default:
                return null;

        }


        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderMe){
            ViewHolderMe viewHolderImage = (ViewHolderMe) holder;
            viewHolderImage.messageBody.setText(String.format("%s",listItem.get(position).getText().trim()));
            viewHolderImage.itemView.setTag(viewHolderImage);


        } else if (holder instanceof ViewHolderYou) {
            ViewHolderYou viewHolderYou = (ViewHolderYou) holder;
            viewHolderYou.name.setText(String.format("%s",listItem.get(position).getName()));
            viewHolderYou.messageBody.setText(String.format("%s",listItem.get(position).getText()));

            GradientDrawable drawable = (GradientDrawable) viewHolderYou.avatar.getBackground();
            drawable.setColor(Color.GRAY);
            viewHolderYou.itemView.setTag(viewHolderYou);
        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class ViewHolderMe extends RecyclerView.ViewHolder {
        public TextView messageBody;
        public ViewHolderMe(View inflate) {
            super(inflate);
           // messageBody = (TextView) inflate.findViewById(R.id.message_body);
        }
    }

    private class ViewHolderYou extends RecyclerView.ViewHolder {

        public View avatar;
        public TextView name, messageBody;
        public ViewHolderYou(View inflate) {
            super(inflate);
            //avatar = (View) inflate.findViewById(R.id.avatar);
           // name = (TextView) inflate.findViewById(R.id.name);
            //messageBody = (TextView) inflate.findViewById(R.id.message_body);
        }
    }
} */
