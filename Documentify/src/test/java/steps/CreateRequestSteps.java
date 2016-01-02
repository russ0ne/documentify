package steps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbehave.core.annotations.*;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;

import documentify.action.RequestFormActionBean;
import documentify.model.Project;
import documentify.model.Request;
import documentify.model.Status;
import documentify.model.User;
import net.sourceforge.stripes.controller.DispatcherServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.mock.MockHttpSession;
import net.sourceforge.stripes.mock.MockRoundtrip;
import net.sourceforge.stripes.mock.MockServletContext;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateRequestSteps extends JUnitStories {

    private static MockServletContext mockContext;
    private static MockHttpSession mockSession;

    Request request;

    //@When("a Title is Test_Request1, Description is 'Test_Desc', Request Date is '01/01/2014', Due Date is '01/01/2017', Points Avilable is '28', Priority is 'Low', Status is 'Open', Requested By 'Russ', Comments is 'Test_Comment'")
    //public void whenATitleIsTest_Request1DescriptionIsTest_DescRequestDateIs01012014DueDateIs01012017PointsAvilableIs28PriorityIsLowStatusIsOpenRequestedByRussCommentsIsTest_Comment() {
    //    System.out.println("Parsing request values");
    //}

    @Then("a simple confirmation message is returned")
    public void thenASimpleConfirmationMessageIsReturned() {
        System.out.println("Then!!");
    }

    @Given("a task of creating a new request")
    public void givenATaskOfCreatingANewRequest() throws Exception {
        setup();
        MockRoundtrip trip = new MockRoundtrip(mockContext, RequestFormActionBean.class, mockSession);
        trip.setParameter("request.id", "100");
        trip.setParameter("request.dateOfRequest", "01/01/2014");
        trip.setParameter("request.project", "Part-Time Hero's Project");
        trip.setParameter("request.pointsWorth", "99");
        trip.setParameter("request.comments", "New Request");
        trip.setParameter("request.assignedPriority", "Low");
        trip.setParameter("request.requester", "Russ");
        trip.setParameter("request.reviewDate", "15/01/2017");
        trip.setParameter("request.status", "OPEN");
        trip.setParameter("request.requestTitle", "New Request Title");
        trip.setParameter("request.requestDesc", "No more info");
        trip.execute();
        
        RequestFormActionBean bean = trip.getActionBean(RequestFormActionBean.class);
        
        //check there were no validation errors
        assertEquals("Validations should be 0", 0, bean.getContext().getValidationErrors().size());
        
        //check that the Request's variables are set correctly
        Request requestUnderTest = bean.getRequest();
        assertEquals("The Id should have been 100", "100", requestUnderTest.getId());
        assertEquals("The date of request should have been 01/01/2014", "01/01/2014", requestUnderTest.getDateOfRequest());
        assertEquals("The number of points should have been 99", "99", requestUnderTest.getPointsWorth());
        assertEquals("The comments should have been \"New Request\"", "New Request", requestUnderTest.getComments());
        assertEquals("The review date should have been 15/01/2017", "15/01/2017", requestUnderTest.getReviewDate());
        assertEquals("The title should hvae been \"New Request Title\"", "New Request Title", requestUnderTest.getRequestTitle());
        assertEquals("The description should have been \"No more info\"", "No more info", requestUnderTest.getRequestDesc());
        Project proj = requestUnderTest.getProject();
        assertEquals("The project name should have been \"Part-Time Hero\'s Project", "Part-Time Hero's Project", proj.getProjectName());
        Status status = requestUnderTest.getStatus();
        assertEquals("The status of the request should be OPEN", "OPEN", requestUnderTest.getStatus());
        User requester = requestUnderTest.getRequester();
        assertEquals("The Requester\'s name should have been Russ", "Russ", requester.getUserName());
        
        assertTrue("The Resolution went to the wrong URL", trip.getDestination().startsWith("/RequestList.ction"));
    }

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("steps/CreateRequest.story");
    }

    @SuppressWarnings("deprecation")
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(getClass().getClassLoader())).useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.CONSOLE));
    }

    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
    }

    @Override
    @Test
    public void run() throws Throwable {
        super.run();
    }

    private void setup() throws Exception {
        // Context and Session Setup
        mockContext = new MockServletContext("Test-Context");
        Map<String, String> params = new HashMap<>();
        params.put("ActionResolver.Packages", "documentify.action");
        params.put("Extension.Packages", "documentify.ext, org.stripesstuff.stripersist");
        mockContext.addFilter(StripesFilter.class, "StripesFilter", params);
        mockContext.setServlet(DispatcherServlet.class, "DispatcherServlet", null);
        mockSession = new MockHttpSession(mockContext);
    }
}
