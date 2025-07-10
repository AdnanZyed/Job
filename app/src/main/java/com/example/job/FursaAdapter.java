package com.example.job;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FursaAdapter extends RecyclerView.Adapter<FursaAdapter.FursaViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(FursaItem item);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    private List<FursaItem> itemList;

    public FursaAdapter(List<FursaItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public FursaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fursa, parent, false);
        return new FursaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FursaViewHolder holder, int position) {
        FursaItem item = itemList.get(position);
        holder.titleTextView.setText(item.getTitle());
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class FursaViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;

        public FursaViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
        }
    }
}
