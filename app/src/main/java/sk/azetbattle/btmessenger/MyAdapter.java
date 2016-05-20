package sk.azetbattle.btmessenger;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;

/**
 * Created by droma on 20.05.2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Message> mDataset;
    private String who = android.os.Build.MODEL;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mView;

        public TextView nameTw;
        public TextView textTw;
        public TextView timeTw;


        public ViewHolder(View v) {
            super(v);
            nameTw = (TextView) v.findViewById(R.id.name_tw);
            textTw = (TextView) v.findViewById(R.id.text_tw);
            timeTw = (TextView) v.findViewById(R.id.time_tw);
            mView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<Message> myDataset) {
        mDataset = myDataset;
    }

    public void setWho(String who) {
        this.who = who;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        int layout = 0;
        switch (viewType) {
            case 1:
                layout = R.layout.message;
                break;
            case 2:
                layout = R.layout.messega_receiver;
                break;
        }


        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Message msg = mDataset.get(position);
        DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm:ss MMMM, yyyy");
        holder.timeTw.setText(new DateTime(msg.getTime()).toString(fmt));
        holder.textTw.setText(msg.getText());
        holder.nameTw.setText(msg.getSender().getName());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public int getItemViewType(int position) {
        Message msg = mDataset.get(position);

        if (msg.getSender().getName().equals(who))
            return 1;
        else
            return 2;
    }
}

