package tech.alvarez.note.listedit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tech.alvarez.note.R;
import tech.alvarez.note.data.db.entity.Note;
import tech.alvarez.note.utils.Util;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<Note> mValues;
    private ListContract.OnItemClickListener mOnItemClickListener;

    public NoteAdapter(ListContract.OnItemClickListener onItemClickListener) {
        mValues = new ArrayList<>();
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.nameTextView.setText(mValues.get(position).name);
        holder.tagTextView.setText(mValues.get(position).tag);

        holder.descriptionTextView.setText(holder.mItem.description);
        holder.tagTextView.setText(holder.mItem.tag);
        holder.dataAlertTextView.setText(Util.formatMin(holder.mItem.dateAlert));

        holder.mView.setBackgroundColor(Integer.parseInt(mValues.get(position).color));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.clickItem(holder.mItem);
            }
        });

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mOnItemClickListener.clickLongItem(holder.mItem);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setValues(List<Note> values) {
        mValues = values;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView nameTextView;
        public final TextView descriptionTextView;
        public final TextView dataAlertTextView;
        public final TextView tagTextView;
        public Note mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nameTextView = (TextView) view.findViewById(R.id.nameTextView);
            descriptionTextView = (TextView) view.findViewById(R.id.descriptionTextView);
            dataAlertTextView = (TextView) view.findViewById(R.id.dataAlertTextView);
            tagTextView = (TextView) view.findViewById(R.id.tagTextView);
        }
    }


}
