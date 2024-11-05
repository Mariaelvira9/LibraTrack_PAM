package mep.mobile.libratrack_pam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Integer> bookCovers;
    private Context context;
    private OnItemClickListener listener;

    public BookAdapter(List<Integer> bookCovers, Context context) {
        this.bookCovers = bookCovers;
        this.context = context;
    }

        @NonNull
        @Override
        public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
            return new BookViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
            int imageResId = bookCovers.get(position);
            Glide.with(context).load(imageResId).into(holder.bookCover);
        }

        @Override
        public int getItemCount() {
            return bookCovers.size();
        }

        public class BookViewHolder extends RecyclerView.ViewHolder {
            ImageView bookCover;

            public BookViewHolder(@NonNull View itemView) {
                super(itemView);
                bookCover = itemView.findViewById(R.id.bookCover);

                itemView.setOnClickListener(v -> {
                    if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getAdapterPosition());
                    }
                });
            }
        }

        public interface OnItemClickListener {
            void onItemClick(int position);
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }
}