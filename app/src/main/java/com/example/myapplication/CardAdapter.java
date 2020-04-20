package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardHolder>{
    private ArrayList<CardItem> cardList;
    private OnItemClickListener clickListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        clickListener = listener;
    }

    public static class CardHolder extends RecyclerView.ViewHolder{
        //public ImageView mImageView;
        public TextView mTextView;

        public CardHolder(View cardView, final OnItemClickListener listener){
            super(cardView);
            //mImageView = cardView.findViewById(R.id.imageView);
            mTextView = cardView.findViewById(R.id.textView);

            cardView.setOnClickListener(new  View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public CardAdapter(ArrayList<CardItem> cardList){
        this.cardList=cardList;
    }

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        CardHolder ch = new CardHolder(v,clickListener );
        return ch;
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        CardItem currentItem = cardList.get(position);
        //holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView.setText(currentItem.getText());
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

}
