package com.example.job;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {




    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static Context context;
    private static List<Job> jobList;
    public JobAdapter(Context context, List<Job> jobList) {
        this.context = context;
        this.jobList = jobList;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_job, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        Job job = jobList.get(position);
        holder.tvTime.setText(job.getCreateTime());
        holder.tvJobTitle.setText(job.getTitle());
        holder.tvCompany.setText(job.getWorkPlace());
        holder.tvCode.setText(job.getWorkField().getName());
        holder.tvCategory.setText(job.getEducationField().getName());
    //   holder.tvCategory.setText(job.getCountryOfGraduation().getName());
        holder.tvSalary.setText(job.getEmploymentType());
        holder.tvYears.setText(String.valueOf(job.getExperienceYear()));
        holder.tvDays.setText(String.valueOf(job.getCountryOfResidence()));
        holder.tvDescription.setText(job.getFileDescription());

//        if (job.getWork_experience() != null) {
//            holder.tvExpire.setText(job.getWork_experience().format(String.valueOf(dateFormatter)));
//        } else {
//            holder.tvExpire.setText("N/A");
//        }

         holder.tvViews.setText(String.valueOf(job.getWatchesCount()));
        holder.layoutSkills.removeAllViews();
//        for (String skill : job.getSkills()) {
//            TextView skillView = new TextView(context);
//            skillView.setText(skill);
//            skillView.setBackgroundResource(R.drawable.shape2);
//            skillView.setPadding(16, 8, 16, 8);
//            skillView.setTextColor(context.getResources().getColor(R.color.primary));
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params.setMargins(8, 0, 8, 0);
//            skillView.setLayoutParams(params);
//            holder.layoutSkills.addView(skillView);
//        }
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public static class JobViewHolder extends RecyclerView.ViewHolder {

        TextView tvTime, tvJobTitle, tvCompany, tvCode, tvCategory ,tvViews,
                tvSalary, tvYears, tvDays, tvDescription, tvExpire;
        LinearLayout layoutSkills;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Job selectedCrop = jobList.get(position);
                    Intent intent = new Intent(context, JobDetails.class);
                    intent.putExtra("COURSE_ID", selectedCrop.getId());

                    context.startActivity(intent);

                }

            });

            tvTime = itemView.findViewById(R.id.tvTime);
            tvJobTitle = itemView.findViewById(R.id.tvJobTitle);
            tvCompany = itemView.findViewById(R.id.tvCompany);
            tvCode = itemView.findViewById(R.id.pure);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvSalary = itemView.findViewById(R.id.tvSalary);
            tvYears = itemView.findViewById(R.id.Years);
            tvDays = itemView.findViewById(R.id.days);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvExpire = itemView.findViewById(R.id.tvExpire);
            layoutSkills = itemView.findViewById(R.id.layoutSkills);
            tvViews = itemView.findViewById(R.id.tvViews);

        }
    }
}
