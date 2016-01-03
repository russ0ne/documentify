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
import java.util.Locale;
import net.sourceforge.stripes.controller.DispatcherServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.mock.MockHttpSession;
import net.sourceforge.stripes.mock.MockRoundtrip;
import net.sourceforge.stripes.mock.MockServletContext;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateRequestSteps extends JUnitStories {

    private MockServletContext mockContext;
    private MockHttpSession mockSession;
    private RequestFormActionBean bean;
    private MockRoundtrip trip;

    @Given("a task of creating a new request")
    public void givenATaskOfCreatingANewRequest() throws Exception {
        setup();
        trip = new MockRoundtrip(mockContext, RequestFormActionBean.class, mockSession);
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
        bean = trip.getActionBean(RequestFormActionBean.class);
    }

    @Then("a simple confirmation message is returned")
    public void thenASimpleConfirmationMessageIsReturned() {
        assertEquals("Save message is incorrect", "Request 100 has been saved.", bean.getContext().getMessages().get(0).getMessage(Locale.getDefault()));
    }

    @Then("no validation errors will exist")
    public void thenNoValidationErrorsExist() {
        assertEquals("Validations should be 0", 0, bean.getContext().getValidationErrors().size());
    }

    @Then("the user will be redirected to the correct URL")
    public void thenTheUserIsRedirectedToTheCorrectUrl() {
        assertTrue("The Resolution went to the wrong URL", trip.getDestination().startsWith("/RequestList.ction"));
    }

    @Then("the correct values will be saved in the database")
    public void thenTheCorrectValuesWillBeSavedInTheDatabase() {
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
        assertEquals("The status of the request should be OPEN", "OPEN", status.getStatus());
        User requester = requestUnderTest.getRequester();
        assertEquals("The Requester\'s name should have been Russ", "Russ", requester.getUserName());
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
