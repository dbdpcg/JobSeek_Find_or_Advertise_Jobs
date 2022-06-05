package classes;

import java.util.Arrays;
import java.util.HashSet;

public class Tests {

    public Tests() {

    }

    public static HashSet<Job> createExampleJobs() {

        Recruiter recruiter1 = new Recruiter();
        recruiter1.setOrg("Google");

        Job job1 = new Job();
        job1.setJobTitle("Software Engineer");
        job1.setRecruiter(recruiter1);
        job1.setCat("compSie");
        job1.setDescription("This is a job. Please apply");
        job1.setState("QLD");
        job1.setSalary(125000);

        Job job2 = new Job();
        job2.setJobTitle("It Specialist");
        job2.setRecruiter(recruiter1);

        Job job3 = new Job();
        job3.setJobTitle("Data Analyst");
        job3.setRecruiter(recruiter1);

        Job job4 = new Job();
        job4.setJobTitle("DevOps");
        job4.setRecruiter(recruiter1);

        Job job5 = new Job();
        job5.setJobTitle("Web Dev");
        job5.setRecruiter(recruiter1);

        Job job6 = new Job();
        job6.setJobTitle("Backend");
        job6.setRecruiter(recruiter1);

        return new HashSet<Job>(Arrays.asList(job1, job2, job3, job4, job5, job6));
    }

    /**
     * tests whether the createJobSeeker method of the CreateAccount class is working successfully
     * success: if a valid email and password are written to the registeredUsers.csv file
     * can be used in conjunction with the testLogin method (which will test whether the newly created user can successfully log in)
     * @param testCreateAccount object of the CreateAccount class, from which the createJobSeeker method is invoked
     * @return true if the use case is expected to run, else false
     */
    public boolean testCreateAccount(CreateAccount testCreateAccount, Application testApplication) {
        //Test 1: expect true
        testCreateAccount.createJobSeeker("jack", "stoneman", "jack2@example.com", "abc123", "abc123");
        testApplication.userLogin("jack2@example.com", "abc123");
        return true;
        //Test 2: expect false - passwords don't match
        //testCreateAccount.createJobSeeker("jack", "stoneman", "jack2@example.com", "acb123", "abc124");
        //return false;
        //Test 3: expect false - email isn't unique
        //testCreateAccount.createJobSeeker("jack", "stoneman", "jack@example.com", "acb123", "abc124");
        //return false;
    }

    /**
     * tests whether the userLogin method of the Application class is working successfully
     * success: if a valid email and password are passed from the LoginPage to the userLogin method
     * then the currentUser will be printed
     * fail: the currentUser value will be "-1" and the user will be notifed that the email or password was incorrect
     * @param testLoginPage is an object of the LoginPage class
     * @param testApplication is an object of the Application class
     */
    public void testLogin(LoginPage testLoginPage, Application testApplication) {
        if (testApplication.userLogin(testLoginPage.getEmail(), testLoginPage.getPassword())) {
            System.out.println(String.format("User successfully logged in with email %s.", testApplication.getCurrentUser()));
        } else {
            System.out.println("Email or password incorrect.");
        }
    }

}