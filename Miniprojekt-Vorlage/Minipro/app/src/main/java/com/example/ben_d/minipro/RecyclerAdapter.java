package com.example.ben_d.minipro;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> items;

    public RecyclerAdapter(List<String> itemList) {
        items = itemList;
    }

    public static class RecyclerItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public RecyclerItemViewHolder(final View parent, TextView itemTextView) {
            super(parent);
            textView = itemTextView;
        }

        public void setItemText(CharSequence text) {
            textView.setText(text);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        TextView itemTextView = (TextView) view.findViewById(R.id.itemTextView);
        return new RecyclerItemViewHolder(view, itemTextView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        RecyclerItemViewHolder holder = (RecyclerItemViewHolder) viewHolder;
        String itemText = items.get(position);
        holder.setItemText(itemText);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

}
