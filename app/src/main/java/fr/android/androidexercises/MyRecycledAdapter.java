package fr.android.androidexercises;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Joris on 22/01/2016.
 */
public class MyRecycledAdapter extends RecyclerView.Adapter<MyRecycledAdapter.ViewHolder> {

    private List<Book> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name;
        public TextView price;
        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.nameTextView);
            price = (TextView) v.findViewById(R.id.priceTextView);
        }
    }

    public MyRecycledAdapter(List<Book> myBooks) {
        mDataset = myBooks;
    }

    @Override
    public MyRecycledAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_view_item_book, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyRecycledAdapter.ViewHolder holder, int position) {

        holder.name.setText(this.mDataset.get(position).name);
        holder.price.setText(this.mDataset.get(position).price + "€");
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
