package user;

import entity.Account;
import javax.ejb.EJB;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import session.AccountFacade;

public class Coach_ {
    @EJB 
    AccountFacade account;
    
    public Coach_() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void should_write_training_documents() {
        //Coach juan = account.find("Juan");
        //Coach juan = new Coach("Juan");
        //TrainingDocument trainingDocument = coach.writeTrainingDocument();
        //assertThat(trainingDocument.getWriter(), is(juan));
        //assertThat(trainingDocument.getAthletes(), null);
    }
}
