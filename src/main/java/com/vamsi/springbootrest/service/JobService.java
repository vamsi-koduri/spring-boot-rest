package com.vamsi.springbootrest.service;

import com.vamsi.springbootrest.Repo.JobRepo;
import com.vamsi.springbootrest.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    @Autowired
    public JobRepo repo;

    public  void addJob(JobPost jobPost){
//        repo.addJob(jobPost);
        repo.save(jobPost);
    }
    public List<JobPost> getAllJobs() {
//        return repo.getAllJobs();
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
//        return repo.getJob( postId);
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
//        repo.updateJob(jobPost);
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
//        repo.deleteJob(postId);
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>();
        jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                            List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));

                    // Frontend Developer Job Post
                    jobs.add(
                            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                                    3, List.of("HTML", "CSS", "JavaScript", "React")));

                    // Data Scientist Job Post
                    jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                            List.of("Python", "Machine Learning", "Data Analysis")));

                    // Network Engineer Job Post
                    jobs.add(new JobPost(4, "Network Engineer",
                            "Design and implement computer networks for efficient data communication", 5,
                            List.of("Networking", "Cisco", "Routing", "Switching")));

                    // Mobile App Developer Job Post
                    jobs
                            .add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                                    3, List.of("iOS Development", "Android Development", "Mobile App")));

                    // DevOps Engineer Job Post
                    jobs.add(
                            new JobPost(6, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines",
                                    4, List.of("DevOps", "CI/CD", "Docker", "Kubernetes")));

                    // UI/UX Designer Job Post
                    jobs
                            .add(new JobPost(7, "UI/UX Designer", "Create engaging user experiences and intuitive user interfaces",
                                    2, List.of("User Experience", "User Interface Design", "Prototyping")));

                    // Cybersecurity Analyst Job Post
                    jobs
                            .add(new JobPost(8, "Cybersecurity Analyst", "Protect computer systems and networks from cyber threats",
                                    4, List.of("Cybersecurity", "Network Security", "Incident Response")));

                    // Full Stack Developer Job Post
                    jobs.add(new JobPost(9, "Full Stack Developer", "Experience in both front-end and back-end development",
                            5, List.of("JavaScript", "Node.js", "React", "Spring", "MongoDB")));

                    repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
          return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}
