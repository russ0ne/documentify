package steps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbehave.core.annotations.*;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;

import documentify.action.RequestFormActionBean;
import documentify.model.Request;
import net.sourceforge.stripes.controller.DispatcherServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.mock.MockHttpSession;
import net.sourceforge.stripes.mock.MockRoundtrip;
import net.sourceforge.stripes.mock.MockServletContext;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateRequestTest extends JUnitStories {

    private MockServletContext mockContext;
    private MockHttpSession mockSession;
    private RequestFormActionBean bean;
    private MockRoundtrip trip;

    @Given("a task of creating a new request")
    public void givenATaskOfCreatingANewRequest() throws Exception {
        setup();
        trip = new MockRoundtrip(mockContext, RequestFormActionBean.class, mockSession);
        trip.setParameter("request.id", "100");
        trip.setParameter("request.dateOfRequest", "01-01-2014");
        trip.setParameter("request.pointsWorth", "99");
        trip.setParameter("request.comments", "New Request");
        trip.setParameter("request.assignedPriority", "LOW");
        trip.setParameter("request.reviewDate", "01-01-2017");
        trip.setParameter("request.requestTitle", "New Request Title");
        trip.setParameter("request.requestDesc", "No more info");
        trip.execute("save");
        bean = trip.getActionBean(RequestFormActionBean.class);
    }

    @Then("no validation errors will exist")
    public void thenNoValidationErrorsExist() {
        assertEquals("Validations should be 0", 0, bean.getContext().getValidationErrors().size());
    }

    @Then("the user will be redirected to the correct URL")
    public void thenTheUserIsRedirectedToTheCorrectUrl() {
        assertTrue("The Resolution went to the wrong URL", trip.getDestination().startsWith("/RequestList.action"));
    }

    @Then("the correct values will be saved in the database")
    public void thenTheCorrectValuesWillBeSavedInTheDatabase() {
        Request requestUnderTest = bean.getRequest();
        assertEquals("The Id should have been 100", "100", requestUnderTest.getId().toString());
        assertEquals("The date of request should have been 01/01/2014", "Wed Jan 01 00:00:00 GMT 2014", requestUnderTest.getDateOfRequest().toString());
        assertEquals("The number of points should have been 99", "99", String.valueOf(requestUnderTest.getPointsWorth()));
        assertEquals("The comments should have been \"New Request\"", "New Request", requestUnderTest.getComments());
        assertEquals("The review date should have been 15/01/2017", "Sun Jan 01 00:00:00 GMT 2017", requestUnderTest.getReviewDate().toString());
        assertEquals("The title should have been \"New Request Title\"", "New Request Title", requestUnderTest.getRequestTitle());
        assertEquals("The description should have been \"No more info\"", "No more info", requestUnderTest.getRequestDesc());
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
